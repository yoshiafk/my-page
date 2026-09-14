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

package com.mypage.admin.product.service.persistence.impl;

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

import com.mypage.admin.product.exception.NoSuchHealthSmeTemplateException;
import com.mypage.admin.product.model.HealthSmeTemplate;
import com.mypage.admin.product.model.impl.HealthSmeTemplateImpl;
import com.mypage.admin.product.model.impl.HealthSmeTemplateModelImpl;
import com.mypage.admin.product.service.persistence.HealthSmeTemplatePersistence;
import com.mypage.admin.product.service.persistence.HealthSmeTemplateUtil;
import com.mypage.admin.product.service.persistence.impl.constants.MPPersistenceConstants;

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
 * The persistence implementation for the health sme template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = HealthSmeTemplatePersistence.class)
public class HealthSmeTemplatePersistenceImpl
	extends BasePersistenceImpl<HealthSmeTemplate>
	implements HealthSmeTemplatePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HealthSmeTemplateUtil</code> to access the health sme template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HealthSmeTemplateImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public HealthSmeTemplatePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(HealthSmeTemplate.class);

		setModelImplClass(HealthSmeTemplateImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the health sme template in the entity cache if it is enabled.
	 *
	 * @param healthSmeTemplate the health sme template
	 */
	@Override
	public void cacheResult(HealthSmeTemplate healthSmeTemplate) {
		entityCache.putResult(
			HealthSmeTemplateImpl.class, healthSmeTemplate.getPrimaryKey(),
			healthSmeTemplate);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the health sme templates in the entity cache if it is enabled.
	 *
	 * @param healthSmeTemplates the health sme templates
	 */
	@Override
	public void cacheResult(List<HealthSmeTemplate> healthSmeTemplates) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (healthSmeTemplates.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (HealthSmeTemplate healthSmeTemplate : healthSmeTemplates) {
			if (entityCache.getResult(
					HealthSmeTemplateImpl.class,
					healthSmeTemplate.getPrimaryKey()) == null) {

				cacheResult(healthSmeTemplate);
			}
		}
	}

	/**
	 * Clears the cache for all health sme templates.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HealthSmeTemplateImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the health sme template.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HealthSmeTemplate healthSmeTemplate) {
		entityCache.removeResult(
			HealthSmeTemplateImpl.class, healthSmeTemplate);
	}

	@Override
	public void clearCache(List<HealthSmeTemplate> healthSmeTemplates) {
		for (HealthSmeTemplate healthSmeTemplate : healthSmeTemplates) {
			entityCache.removeResult(
				HealthSmeTemplateImpl.class, healthSmeTemplate);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(HealthSmeTemplateImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new health sme template with the primary key. Does not add the health sme template to the database.
	 *
	 * @param healthSmeTemplateId the primary key for the new health sme template
	 * @return the new health sme template
	 */
	@Override
	public HealthSmeTemplate create(long healthSmeTemplateId) {
		HealthSmeTemplate healthSmeTemplate = new HealthSmeTemplateImpl();

		healthSmeTemplate.setNew(true);
		healthSmeTemplate.setPrimaryKey(healthSmeTemplateId);

		healthSmeTemplate.setCompanyId(CompanyThreadLocal.getCompanyId());

		return healthSmeTemplate;
	}

	/**
	 * Removes the health sme template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param healthSmeTemplateId the primary key of the health sme template
	 * @return the health sme template that was removed
	 * @throws NoSuchHealthSmeTemplateException if a health sme template with the primary key could not be found
	 */
	@Override
	public HealthSmeTemplate remove(long healthSmeTemplateId)
		throws NoSuchHealthSmeTemplateException {

		return remove((Serializable)healthSmeTemplateId);
	}

	/**
	 * Removes the health sme template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the health sme template
	 * @return the health sme template that was removed
	 * @throws NoSuchHealthSmeTemplateException if a health sme template with the primary key could not be found
	 */
	@Override
	public HealthSmeTemplate remove(Serializable primaryKey)
		throws NoSuchHealthSmeTemplateException {

		Session session = null;

		try {
			session = openSession();

			HealthSmeTemplate healthSmeTemplate =
				(HealthSmeTemplate)session.get(
					HealthSmeTemplateImpl.class, primaryKey);

			if (healthSmeTemplate == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHealthSmeTemplateException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(healthSmeTemplate);
		}
		catch (NoSuchHealthSmeTemplateException noSuchEntityException) {
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
	protected HealthSmeTemplate removeImpl(
		HealthSmeTemplate healthSmeTemplate) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(healthSmeTemplate)) {
				healthSmeTemplate = (HealthSmeTemplate)session.get(
					HealthSmeTemplateImpl.class,
					healthSmeTemplate.getPrimaryKeyObj());
			}

			if (healthSmeTemplate != null) {
				session.delete(healthSmeTemplate);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (healthSmeTemplate != null) {
			clearCache(healthSmeTemplate);
		}

		return healthSmeTemplate;
	}

	@Override
	public HealthSmeTemplate updateImpl(HealthSmeTemplate healthSmeTemplate) {
		boolean isNew = healthSmeTemplate.isNew();

		if (!(healthSmeTemplate instanceof HealthSmeTemplateModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(healthSmeTemplate.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					healthSmeTemplate);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in healthSmeTemplate proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom HealthSmeTemplate implementation " +
					healthSmeTemplate.getClass());
		}

		HealthSmeTemplateModelImpl healthSmeTemplateModelImpl =
			(HealthSmeTemplateModelImpl)healthSmeTemplate;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (healthSmeTemplate.getCreateDate() == null)) {
			if (serviceContext == null) {
				healthSmeTemplate.setCreateDate(date);
			}
			else {
				healthSmeTemplate.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!healthSmeTemplateModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				healthSmeTemplate.setModifiedDate(date);
			}
			else {
				healthSmeTemplate.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(healthSmeTemplate);
			}
			else {
				healthSmeTemplate = (HealthSmeTemplate)session.merge(
					healthSmeTemplate);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			HealthSmeTemplateImpl.class, healthSmeTemplate, false, true);

		if (isNew) {
			healthSmeTemplate.setNew(false);
		}

		healthSmeTemplate.resetOriginalValues();

		return healthSmeTemplate;
	}

	/**
	 * Returns the health sme template with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the health sme template
	 * @return the health sme template
	 * @throws NoSuchHealthSmeTemplateException if a health sme template with the primary key could not be found
	 */
	@Override
	public HealthSmeTemplate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHealthSmeTemplateException {

		HealthSmeTemplate healthSmeTemplate = fetchByPrimaryKey(primaryKey);

		if (healthSmeTemplate == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHealthSmeTemplateException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return healthSmeTemplate;
	}

	/**
	 * Returns the health sme template with the primary key or throws a <code>NoSuchHealthSmeTemplateException</code> if it could not be found.
	 *
	 * @param healthSmeTemplateId the primary key of the health sme template
	 * @return the health sme template
	 * @throws NoSuchHealthSmeTemplateException if a health sme template with the primary key could not be found
	 */
	@Override
	public HealthSmeTemplate findByPrimaryKey(long healthSmeTemplateId)
		throws NoSuchHealthSmeTemplateException {

		return findByPrimaryKey((Serializable)healthSmeTemplateId);
	}

	/**
	 * Returns the health sme template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param healthSmeTemplateId the primary key of the health sme template
	 * @return the health sme template, or <code>null</code> if a health sme template with the primary key could not be found
	 */
	@Override
	public HealthSmeTemplate fetchByPrimaryKey(long healthSmeTemplateId) {
		return fetchByPrimaryKey((Serializable)healthSmeTemplateId);
	}

	/**
	 * Returns all the health sme templates.
	 *
	 * @return the health sme templates
	 */
	@Override
	public List<HealthSmeTemplate> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the health sme templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme templates
	 * @param end the upper bound of the range of health sme templates (not inclusive)
	 * @return the range of health sme templates
	 */
	@Override
	public List<HealthSmeTemplate> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the health sme templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme templates
	 * @param end the upper bound of the range of health sme templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of health sme templates
	 */
	@Override
	public List<HealthSmeTemplate> findAll(
		int start, int end,
		OrderByComparator<HealthSmeTemplate> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the health sme templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme templates
	 * @param end the upper bound of the range of health sme templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of health sme templates
	 */
	@Override
	public List<HealthSmeTemplate> findAll(
		int start, int end,
		OrderByComparator<HealthSmeTemplate> orderByComparator,
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

		List<HealthSmeTemplate> list = null;

		if (useFinderCache) {
			list = (List<HealthSmeTemplate>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HEALTHSMETEMPLATE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HEALTHSMETEMPLATE;

				sql = sql.concat(HealthSmeTemplateModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<HealthSmeTemplate>)QueryUtil.list(
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
	 * Removes all the health sme templates from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (HealthSmeTemplate healthSmeTemplate : findAll()) {
			remove(healthSmeTemplate);
		}
	}

	/**
	 * Returns the number of health sme templates.
	 *
	 * @return the number of health sme templates
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_HEALTHSMETEMPLATE);

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
		return "healthSmeTemplateId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_HEALTHSMETEMPLATE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HealthSmeTemplateModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the health sme template persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new HealthSmeTemplateModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", HealthSmeTemplate.class.getName()));

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

		_setHealthSmeTemplateUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setHealthSmeTemplateUtilPersistence(null);

		entityCache.removeCache(HealthSmeTemplateImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setHealthSmeTemplateUtilPersistence(
		HealthSmeTemplatePersistence healthSmeTemplatePersistence) {

		try {
			Field field = HealthSmeTemplateUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, healthSmeTemplatePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MPPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_HEALTHSMETEMPLATE =
		"SELECT healthSmeTemplate FROM HealthSmeTemplate healthSmeTemplate";

	private static final String _SQL_COUNT_HEALTHSMETEMPLATE =
		"SELECT COUNT(healthSmeTemplate) FROM HealthSmeTemplate healthSmeTemplate";

	private static final String _ORDER_BY_ENTITY_ALIAS = "healthSmeTemplate.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No HealthSmeTemplate exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		HealthSmeTemplatePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"code", "active"});

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

	private static class HealthSmeTemplateModelArgumentsResolver
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

			HealthSmeTemplateModelImpl healthSmeTemplateModelImpl =
				(HealthSmeTemplateModelImpl)baseModel;

			long columnBitmask = healthSmeTemplateModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					healthSmeTemplateModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						healthSmeTemplateModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					healthSmeTemplateModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			HealthSmeTemplateModelImpl healthSmeTemplateModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						healthSmeTemplateModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = healthSmeTemplateModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}