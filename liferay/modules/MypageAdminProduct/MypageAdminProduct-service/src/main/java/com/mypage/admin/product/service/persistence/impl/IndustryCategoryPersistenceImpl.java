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

import com.mypage.admin.product.exception.NoSuchIndustryCategoryException;
import com.mypage.admin.product.model.IndustryCategory;
import com.mypage.admin.product.model.impl.IndustryCategoryImpl;
import com.mypage.admin.product.model.impl.IndustryCategoryModelImpl;
import com.mypage.admin.product.service.persistence.IndustryCategoryPersistence;
import com.mypage.admin.product.service.persistence.IndustryCategoryUtil;
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
 * The persistence implementation for the industry category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = IndustryCategoryPersistence.class)
public class IndustryCategoryPersistenceImpl
	extends BasePersistenceImpl<IndustryCategory>
	implements IndustryCategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>IndustryCategoryUtil</code> to access the industry category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		IndustryCategoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public IndustryCategoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(IndustryCategory.class);

		setModelImplClass(IndustryCategoryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the industry category in the entity cache if it is enabled.
	 *
	 * @param industryCategory the industry category
	 */
	@Override
	public void cacheResult(IndustryCategory industryCategory) {
		entityCache.putResult(
			IndustryCategoryImpl.class, industryCategory.getPrimaryKey(),
			industryCategory);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the industry categories in the entity cache if it is enabled.
	 *
	 * @param industryCategories the industry categories
	 */
	@Override
	public void cacheResult(List<IndustryCategory> industryCategories) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (industryCategories.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (IndustryCategory industryCategory : industryCategories) {
			if (entityCache.getResult(
					IndustryCategoryImpl.class,
					industryCategory.getPrimaryKey()) == null) {

				cacheResult(industryCategory);
			}
		}
	}

	/**
	 * Clears the cache for all industry categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IndustryCategoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the industry category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(IndustryCategory industryCategory) {
		entityCache.removeResult(IndustryCategoryImpl.class, industryCategory);
	}

	@Override
	public void clearCache(List<IndustryCategory> industryCategories) {
		for (IndustryCategory industryCategory : industryCategories) {
			entityCache.removeResult(
				IndustryCategoryImpl.class, industryCategory);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(IndustryCategoryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new industry category with the primary key. Does not add the industry category to the database.
	 *
	 * @param industryCategoryId the primary key for the new industry category
	 * @return the new industry category
	 */
	@Override
	public IndustryCategory create(long industryCategoryId) {
		IndustryCategory industryCategory = new IndustryCategoryImpl();

		industryCategory.setNew(true);
		industryCategory.setPrimaryKey(industryCategoryId);

		industryCategory.setCompanyId(CompanyThreadLocal.getCompanyId());

		return industryCategory;
	}

	/**
	 * Removes the industry category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param industryCategoryId the primary key of the industry category
	 * @return the industry category that was removed
	 * @throws NoSuchIndustryCategoryException if a industry category with the primary key could not be found
	 */
	@Override
	public IndustryCategory remove(long industryCategoryId)
		throws NoSuchIndustryCategoryException {

		return remove((Serializable)industryCategoryId);
	}

	/**
	 * Removes the industry category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the industry category
	 * @return the industry category that was removed
	 * @throws NoSuchIndustryCategoryException if a industry category with the primary key could not be found
	 */
	@Override
	public IndustryCategory remove(Serializable primaryKey)
		throws NoSuchIndustryCategoryException {

		Session session = null;

		try {
			session = openSession();

			IndustryCategory industryCategory = (IndustryCategory)session.get(
				IndustryCategoryImpl.class, primaryKey);

			if (industryCategory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIndustryCategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(industryCategory);
		}
		catch (NoSuchIndustryCategoryException noSuchEntityException) {
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
	protected IndustryCategory removeImpl(IndustryCategory industryCategory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(industryCategory)) {
				industryCategory = (IndustryCategory)session.get(
					IndustryCategoryImpl.class,
					industryCategory.getPrimaryKeyObj());
			}

			if (industryCategory != null) {
				session.delete(industryCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (industryCategory != null) {
			clearCache(industryCategory);
		}

		return industryCategory;
	}

	@Override
	public IndustryCategory updateImpl(IndustryCategory industryCategory) {
		boolean isNew = industryCategory.isNew();

		if (!(industryCategory instanceof IndustryCategoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(industryCategory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					industryCategory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in industryCategory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom IndustryCategory implementation " +
					industryCategory.getClass());
		}

		IndustryCategoryModelImpl industryCategoryModelImpl =
			(IndustryCategoryModelImpl)industryCategory;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (industryCategory.getCreateDate() == null)) {
			if (serviceContext == null) {
				industryCategory.setCreateDate(date);
			}
			else {
				industryCategory.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!industryCategoryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				industryCategory.setModifiedDate(date);
			}
			else {
				industryCategory.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(industryCategory);
			}
			else {
				industryCategory = (IndustryCategory)session.merge(
					industryCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			IndustryCategoryImpl.class, industryCategory, false, true);

		if (isNew) {
			industryCategory.setNew(false);
		}

		industryCategory.resetOriginalValues();

		return industryCategory;
	}

	/**
	 * Returns the industry category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the industry category
	 * @return the industry category
	 * @throws NoSuchIndustryCategoryException if a industry category with the primary key could not be found
	 */
	@Override
	public IndustryCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIndustryCategoryException {

		IndustryCategory industryCategory = fetchByPrimaryKey(primaryKey);

		if (industryCategory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIndustryCategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return industryCategory;
	}

	/**
	 * Returns the industry category with the primary key or throws a <code>NoSuchIndustryCategoryException</code> if it could not be found.
	 *
	 * @param industryCategoryId the primary key of the industry category
	 * @return the industry category
	 * @throws NoSuchIndustryCategoryException if a industry category with the primary key could not be found
	 */
	@Override
	public IndustryCategory findByPrimaryKey(long industryCategoryId)
		throws NoSuchIndustryCategoryException {

		return findByPrimaryKey((Serializable)industryCategoryId);
	}

	/**
	 * Returns the industry category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param industryCategoryId the primary key of the industry category
	 * @return the industry category, or <code>null</code> if a industry category with the primary key could not be found
	 */
	@Override
	public IndustryCategory fetchByPrimaryKey(long industryCategoryId) {
		return fetchByPrimaryKey((Serializable)industryCategoryId);
	}

	/**
	 * Returns all the industry categories.
	 *
	 * @return the industry categories
	 */
	@Override
	public List<IndustryCategory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the industry categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of industry categories
	 * @param end the upper bound of the range of industry categories (not inclusive)
	 * @return the range of industry categories
	 */
	@Override
	public List<IndustryCategory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the industry categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of industry categories
	 * @param end the upper bound of the range of industry categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of industry categories
	 */
	@Override
	public List<IndustryCategory> findAll(
		int start, int end,
		OrderByComparator<IndustryCategory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the industry categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of industry categories
	 * @param end the upper bound of the range of industry categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of industry categories
	 */
	@Override
	public List<IndustryCategory> findAll(
		int start, int end,
		OrderByComparator<IndustryCategory> orderByComparator,
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

		List<IndustryCategory> list = null;

		if (useFinderCache) {
			list = (List<IndustryCategory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_INDUSTRYCATEGORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_INDUSTRYCATEGORY;

				sql = sql.concat(IndustryCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<IndustryCategory>)QueryUtil.list(
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
	 * Removes all the industry categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (IndustryCategory industryCategory : findAll()) {
			remove(industryCategory);
		}
	}

	/**
	 * Returns the number of industry categories.
	 *
	 * @return the number of industry categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_INDUSTRYCATEGORY);

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
		return "industryCategoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_INDUSTRYCATEGORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return IndustryCategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the industry category persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new IndustryCategoryModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", IndustryCategory.class.getName()));

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

		_setIndustryCategoryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setIndustryCategoryUtilPersistence(null);

		entityCache.removeCache(IndustryCategoryImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setIndustryCategoryUtilPersistence(
		IndustryCategoryPersistence industryCategoryPersistence) {

		try {
			Field field = IndustryCategoryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, industryCategoryPersistence);
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

	private static final String _SQL_SELECT_INDUSTRYCATEGORY =
		"SELECT industryCategory FROM IndustryCategory industryCategory";

	private static final String _SQL_COUNT_INDUSTRYCATEGORY =
		"SELECT COUNT(industryCategory) FROM IndustryCategory industryCategory";

	private static final String _ORDER_BY_ENTITY_ALIAS = "industryCategory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No IndustryCategory exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		IndustryCategoryPersistenceImpl.class);

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

	private static class IndustryCategoryModelArgumentsResolver
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

			IndustryCategoryModelImpl industryCategoryModelImpl =
				(IndustryCategoryModelImpl)baseModel;

			long columnBitmask = industryCategoryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					industryCategoryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						industryCategoryModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					industryCategoryModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			IndustryCategoryModelImpl industryCategoryModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						industryCategoryModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = industryCategoryModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}