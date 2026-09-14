/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.mypage.agencyportal.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import com.mypage.agencyportal.exception.NoSuchAgentFAQCategoryException;
import com.mypage.agencyportal.model.AgentFAQCategory;
import com.mypage.agencyportal.model.impl.AgentFAQCategoryImpl;
import com.mypage.agencyportal.model.impl.AgentFAQCategoryModelImpl;
import com.mypage.agencyportal.service.persistence.AgentFAQCategoryPersistence;
import com.mypage.agencyportal.service.persistence.AgentFAQCategoryUtil;
import com.mypage.agencyportal.service.persistence.impl.constants.APPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the agent faq category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = AgentFAQCategoryPersistence.class)
public class AgentFAQCategoryPersistenceImpl
	extends BasePersistenceImpl<AgentFAQCategory>
	implements AgentFAQCategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AgentFAQCategoryUtil</code> to access the agent faq category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AgentFAQCategoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AgentFAQCategoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AgentFAQCategory.class);

		setModelImplClass(AgentFAQCategoryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the agent faq category in the entity cache if it is enabled.
	 *
	 * @param agentFAQCategory the agent faq category
	 */
	@Override
	public void cacheResult(AgentFAQCategory agentFAQCategory) {
		entityCache.putResult(
			AgentFAQCategoryImpl.class, agentFAQCategory.getPrimaryKey(),
			agentFAQCategory);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the agent faq categories in the entity cache if it is enabled.
	 *
	 * @param agentFAQCategories the agent faq categories
	 */
	@Override
	public void cacheResult(List<AgentFAQCategory> agentFAQCategories) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (agentFAQCategories.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AgentFAQCategory agentFAQCategory : agentFAQCategories) {
			if (entityCache.getResult(
					AgentFAQCategoryImpl.class,
					agentFAQCategory.getPrimaryKey()) == null) {

				cacheResult(agentFAQCategory);
			}
		}
	}

	/**
	 * Clears the cache for all agent faq categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AgentFAQCategoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the agent faq category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AgentFAQCategory agentFAQCategory) {
		entityCache.removeResult(AgentFAQCategoryImpl.class, agentFAQCategory);
	}

	@Override
	public void clearCache(List<AgentFAQCategory> agentFAQCategories) {
		for (AgentFAQCategory agentFAQCategory : agentFAQCategories) {
			entityCache.removeResult(
				AgentFAQCategoryImpl.class, agentFAQCategory);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AgentFAQCategoryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new agent faq category with the primary key. Does not add the agent faq category to the database.
	 *
	 * @param agentFaqCategoryId the primary key for the new agent faq category
	 * @return the new agent faq category
	 */
	@Override
	public AgentFAQCategory create(long agentFaqCategoryId) {
		AgentFAQCategory agentFAQCategory = new AgentFAQCategoryImpl();

		agentFAQCategory.setNew(true);
		agentFAQCategory.setPrimaryKey(agentFaqCategoryId);

		agentFAQCategory.setCompanyId(CompanyThreadLocal.getCompanyId());

		return agentFAQCategory;
	}

	/**
	 * Removes the agent faq category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentFaqCategoryId the primary key of the agent faq category
	 * @return the agent faq category that was removed
	 * @throws NoSuchAgentFAQCategoryException if a agent faq category with the primary key could not be found
	 */
	@Override
	public AgentFAQCategory remove(long agentFaqCategoryId)
		throws NoSuchAgentFAQCategoryException {

		return remove((Serializable)agentFaqCategoryId);
	}

	/**
	 * Removes the agent faq category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the agent faq category
	 * @return the agent faq category that was removed
	 * @throws NoSuchAgentFAQCategoryException if a agent faq category with the primary key could not be found
	 */
	@Override
	public AgentFAQCategory remove(Serializable primaryKey)
		throws NoSuchAgentFAQCategoryException {

		Session session = null;

		try {
			session = openSession();

			AgentFAQCategory agentFAQCategory = (AgentFAQCategory)session.get(
				AgentFAQCategoryImpl.class, primaryKey);

			if (agentFAQCategory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAgentFAQCategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(agentFAQCategory);
		}
		catch (NoSuchAgentFAQCategoryException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AgentFAQCategory removeImpl(AgentFAQCategory agentFAQCategory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(agentFAQCategory)) {
				agentFAQCategory = (AgentFAQCategory)session.get(
					AgentFAQCategoryImpl.class,
					agentFAQCategory.getPrimaryKeyObj());
			}

			if (agentFAQCategory != null) {
				session.delete(agentFAQCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (agentFAQCategory != null) {
			clearCache(agentFAQCategory);
		}

		return agentFAQCategory;
	}

	@Override
	public AgentFAQCategory updateImpl(AgentFAQCategory agentFAQCategory) {
		boolean isNew = agentFAQCategory.isNew();

		if (!(agentFAQCategory instanceof AgentFAQCategoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(agentFAQCategory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					agentFAQCategory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in agentFAQCategory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AgentFAQCategory implementation " +
					agentFAQCategory.getClass());
		}

		AgentFAQCategoryModelImpl agentFAQCategoryModelImpl =
			(AgentFAQCategoryModelImpl)agentFAQCategory;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (agentFAQCategory.getCreateDate() == null)) {
			if (serviceContext == null) {
				agentFAQCategory.setCreateDate(date);
			}
			else {
				agentFAQCategory.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!agentFAQCategoryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				agentFAQCategory.setModifiedDate(date);
			}
			else {
				agentFAQCategory.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(agentFAQCategory);
			}
			else {
				agentFAQCategory = (AgentFAQCategory)session.merge(
					agentFAQCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AgentFAQCategoryImpl.class, agentFAQCategory, false, true);

		if (isNew) {
			agentFAQCategory.setNew(false);
		}

		agentFAQCategory.resetOriginalValues();

		return agentFAQCategory;
	}

	/**
	 * Returns the agent faq category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the agent faq category
	 * @return the agent faq category
	 * @throws NoSuchAgentFAQCategoryException if a agent faq category with the primary key could not be found
	 */
	@Override
	public AgentFAQCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAgentFAQCategoryException {

		AgentFAQCategory agentFAQCategory = fetchByPrimaryKey(primaryKey);

		if (agentFAQCategory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAgentFAQCategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return agentFAQCategory;
	}

	/**
	 * Returns the agent faq category with the primary key or throws a <code>NoSuchAgentFAQCategoryException</code> if it could not be found.
	 *
	 * @param agentFaqCategoryId the primary key of the agent faq category
	 * @return the agent faq category
	 * @throws NoSuchAgentFAQCategoryException if a agent faq category with the primary key could not be found
	 */
	@Override
	public AgentFAQCategory findByPrimaryKey(long agentFaqCategoryId)
		throws NoSuchAgentFAQCategoryException {

		return findByPrimaryKey((Serializable)agentFaqCategoryId);
	}

	/**
	 * Returns the agent faq category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentFaqCategoryId the primary key of the agent faq category
	 * @return the agent faq category, or <code>null</code> if a agent faq category with the primary key could not be found
	 */
	@Override
	public AgentFAQCategory fetchByPrimaryKey(long agentFaqCategoryId) {
		return fetchByPrimaryKey((Serializable)agentFaqCategoryId);
	}

	/**
	 * Returns all the agent faq categories.
	 *
	 * @return the agent faq categories
	 */
	@Override
	public List<AgentFAQCategory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent faq categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentFAQCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent faq categories
	 * @param end the upper bound of the range of agent faq categories (not inclusive)
	 * @return the range of agent faq categories
	 */
	@Override
	public List<AgentFAQCategory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent faq categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentFAQCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent faq categories
	 * @param end the upper bound of the range of agent faq categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agent faq categories
	 */
	@Override
	public List<AgentFAQCategory> findAll(
		int start, int end,
		OrderByComparator<AgentFAQCategory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent faq categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentFAQCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent faq categories
	 * @param end the upper bound of the range of agent faq categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agent faq categories
	 */
	@Override
	public List<AgentFAQCategory> findAll(
		int start, int end,
		OrderByComparator<AgentFAQCategory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<AgentFAQCategory> list = null;

		if (useFinderCache) {
			list = (List<AgentFAQCategory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AGENTFAQCATEGORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AGENTFAQCATEGORY;

				sql = sql.concat(AgentFAQCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AgentFAQCategory>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the agent faq categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AgentFAQCategory agentFAQCategory : findAll()) {
			remove(agentFAQCategory);
		}
	}

	/**
	 * Returns the number of agent faq categories.
	 *
	 * @return the number of agent faq categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AGENTFAQCATEGORY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "agentFaqCategoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AGENTFAQCATEGORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AgentFAQCategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the agent faq category persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new AgentFAQCategoryModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", AgentFAQCategory.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setAgentFAQCategoryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAgentFAQCategoryUtilPersistence(null);

		entityCache.removeCache(AgentFAQCategoryImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setAgentFAQCategoryUtilPersistence(
		AgentFAQCategoryPersistence agentFAQCategoryPersistence) {

		try {
			Field field = AgentFAQCategoryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, agentFAQCategoryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = APPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = APPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = APPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AGENTFAQCATEGORY =
		"SELECT agentFAQCategory FROM AgentFAQCategory agentFAQCategory";

	private static final String _SQL_COUNT_AGENTFAQCATEGORY =
		"SELECT COUNT(agentFAQCategory) FROM AgentFAQCategory agentFAQCategory";

	private static final String _ORDER_BY_ENTITY_ALIAS = "agentFAQCategory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AgentFAQCategory exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AgentFAQCategoryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"active"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class AgentFAQCategoryModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			AgentFAQCategoryModelImpl agentFAQCategoryModelImpl =
				(AgentFAQCategoryModelImpl)baseModel;

			long columnBitmask = agentFAQCategoryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					agentFAQCategoryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						agentFAQCategoryModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					agentFAQCategoryModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			AgentFAQCategoryModelImpl agentFAQCategoryModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						agentFAQCategoryModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = agentFAQCategoryModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}