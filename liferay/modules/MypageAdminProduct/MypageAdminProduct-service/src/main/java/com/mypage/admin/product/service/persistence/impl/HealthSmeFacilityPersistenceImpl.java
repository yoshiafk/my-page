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

import com.mypage.admin.product.exception.NoSuchHealthSmeFacilityException;
import com.mypage.admin.product.model.HealthSmeFacility;
import com.mypage.admin.product.model.impl.HealthSmeFacilityImpl;
import com.mypage.admin.product.model.impl.HealthSmeFacilityModelImpl;
import com.mypage.admin.product.service.persistence.HealthSmeFacilityPersistence;
import com.mypage.admin.product.service.persistence.HealthSmeFacilityUtil;
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
 * The persistence implementation for the health sme facility service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = HealthSmeFacilityPersistence.class)
public class HealthSmeFacilityPersistenceImpl
	extends BasePersistenceImpl<HealthSmeFacility>
	implements HealthSmeFacilityPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HealthSmeFacilityUtil</code> to access the health sme facility persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HealthSmeFacilityImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public HealthSmeFacilityPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(HealthSmeFacility.class);

		setModelImplClass(HealthSmeFacilityImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the health sme facility in the entity cache if it is enabled.
	 *
	 * @param healthSmeFacility the health sme facility
	 */
	@Override
	public void cacheResult(HealthSmeFacility healthSmeFacility) {
		entityCache.putResult(
			HealthSmeFacilityImpl.class, healthSmeFacility.getPrimaryKey(),
			healthSmeFacility);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the health sme facilities in the entity cache if it is enabled.
	 *
	 * @param healthSmeFacilities the health sme facilities
	 */
	@Override
	public void cacheResult(List<HealthSmeFacility> healthSmeFacilities) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (healthSmeFacilities.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (HealthSmeFacility healthSmeFacility : healthSmeFacilities) {
			if (entityCache.getResult(
					HealthSmeFacilityImpl.class,
					healthSmeFacility.getPrimaryKey()) == null) {

				cacheResult(healthSmeFacility);
			}
		}
	}

	/**
	 * Clears the cache for all health sme facilities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HealthSmeFacilityImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the health sme facility.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HealthSmeFacility healthSmeFacility) {
		entityCache.removeResult(
			HealthSmeFacilityImpl.class, healthSmeFacility);
	}

	@Override
	public void clearCache(List<HealthSmeFacility> healthSmeFacilities) {
		for (HealthSmeFacility healthSmeFacility : healthSmeFacilities) {
			entityCache.removeResult(
				HealthSmeFacilityImpl.class, healthSmeFacility);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(HealthSmeFacilityImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new health sme facility with the primary key. Does not add the health sme facility to the database.
	 *
	 * @param healthSmeFacilityId the primary key for the new health sme facility
	 * @return the new health sme facility
	 */
	@Override
	public HealthSmeFacility create(long healthSmeFacilityId) {
		HealthSmeFacility healthSmeFacility = new HealthSmeFacilityImpl();

		healthSmeFacility.setNew(true);
		healthSmeFacility.setPrimaryKey(healthSmeFacilityId);

		healthSmeFacility.setCompanyId(CompanyThreadLocal.getCompanyId());

		return healthSmeFacility;
	}

	/**
	 * Removes the health sme facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param healthSmeFacilityId the primary key of the health sme facility
	 * @return the health sme facility that was removed
	 * @throws NoSuchHealthSmeFacilityException if a health sme facility with the primary key could not be found
	 */
	@Override
	public HealthSmeFacility remove(long healthSmeFacilityId)
		throws NoSuchHealthSmeFacilityException {

		return remove((Serializable)healthSmeFacilityId);
	}

	/**
	 * Removes the health sme facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the health sme facility
	 * @return the health sme facility that was removed
	 * @throws NoSuchHealthSmeFacilityException if a health sme facility with the primary key could not be found
	 */
	@Override
	public HealthSmeFacility remove(Serializable primaryKey)
		throws NoSuchHealthSmeFacilityException {

		Session session = null;

		try {
			session = openSession();

			HealthSmeFacility healthSmeFacility =
				(HealthSmeFacility)session.get(
					HealthSmeFacilityImpl.class, primaryKey);

			if (healthSmeFacility == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHealthSmeFacilityException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(healthSmeFacility);
		}
		catch (NoSuchHealthSmeFacilityException noSuchEntityException) {
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
	protected HealthSmeFacility removeImpl(
		HealthSmeFacility healthSmeFacility) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(healthSmeFacility)) {
				healthSmeFacility = (HealthSmeFacility)session.get(
					HealthSmeFacilityImpl.class,
					healthSmeFacility.getPrimaryKeyObj());
			}

			if (healthSmeFacility != null) {
				session.delete(healthSmeFacility);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (healthSmeFacility != null) {
			clearCache(healthSmeFacility);
		}

		return healthSmeFacility;
	}

	@Override
	public HealthSmeFacility updateImpl(HealthSmeFacility healthSmeFacility) {
		boolean isNew = healthSmeFacility.isNew();

		if (!(healthSmeFacility instanceof HealthSmeFacilityModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(healthSmeFacility.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					healthSmeFacility);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in healthSmeFacility proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom HealthSmeFacility implementation " +
					healthSmeFacility.getClass());
		}

		HealthSmeFacilityModelImpl healthSmeFacilityModelImpl =
			(HealthSmeFacilityModelImpl)healthSmeFacility;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (healthSmeFacility.getCreateDate() == null)) {
			if (serviceContext == null) {
				healthSmeFacility.setCreateDate(date);
			}
			else {
				healthSmeFacility.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!healthSmeFacilityModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				healthSmeFacility.setModifiedDate(date);
			}
			else {
				healthSmeFacility.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(healthSmeFacility);
			}
			else {
				healthSmeFacility = (HealthSmeFacility)session.merge(
					healthSmeFacility);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			HealthSmeFacilityImpl.class, healthSmeFacility, false, true);

		if (isNew) {
			healthSmeFacility.setNew(false);
		}

		healthSmeFacility.resetOriginalValues();

		return healthSmeFacility;
	}

	/**
	 * Returns the health sme facility with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the health sme facility
	 * @return the health sme facility
	 * @throws NoSuchHealthSmeFacilityException if a health sme facility with the primary key could not be found
	 */
	@Override
	public HealthSmeFacility findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHealthSmeFacilityException {

		HealthSmeFacility healthSmeFacility = fetchByPrimaryKey(primaryKey);

		if (healthSmeFacility == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHealthSmeFacilityException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return healthSmeFacility;
	}

	/**
	 * Returns the health sme facility with the primary key or throws a <code>NoSuchHealthSmeFacilityException</code> if it could not be found.
	 *
	 * @param healthSmeFacilityId the primary key of the health sme facility
	 * @return the health sme facility
	 * @throws NoSuchHealthSmeFacilityException if a health sme facility with the primary key could not be found
	 */
	@Override
	public HealthSmeFacility findByPrimaryKey(long healthSmeFacilityId)
		throws NoSuchHealthSmeFacilityException {

		return findByPrimaryKey((Serializable)healthSmeFacilityId);
	}

	/**
	 * Returns the health sme facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param healthSmeFacilityId the primary key of the health sme facility
	 * @return the health sme facility, or <code>null</code> if a health sme facility with the primary key could not be found
	 */
	@Override
	public HealthSmeFacility fetchByPrimaryKey(long healthSmeFacilityId) {
		return fetchByPrimaryKey((Serializable)healthSmeFacilityId);
	}

	/**
	 * Returns all the health sme facilities.
	 *
	 * @return the health sme facilities
	 */
	@Override
	public List<HealthSmeFacility> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the health sme facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeFacilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme facilities
	 * @param end the upper bound of the range of health sme facilities (not inclusive)
	 * @return the range of health sme facilities
	 */
	@Override
	public List<HealthSmeFacility> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the health sme facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeFacilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme facilities
	 * @param end the upper bound of the range of health sme facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of health sme facilities
	 */
	@Override
	public List<HealthSmeFacility> findAll(
		int start, int end,
		OrderByComparator<HealthSmeFacility> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the health sme facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeFacilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme facilities
	 * @param end the upper bound of the range of health sme facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of health sme facilities
	 */
	@Override
	public List<HealthSmeFacility> findAll(
		int start, int end,
		OrderByComparator<HealthSmeFacility> orderByComparator,
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

		List<HealthSmeFacility> list = null;

		if (useFinderCache) {
			list = (List<HealthSmeFacility>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HEALTHSMEFACILITY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HEALTHSMEFACILITY;

				sql = sql.concat(HealthSmeFacilityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<HealthSmeFacility>)QueryUtil.list(
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
	 * Removes all the health sme facilities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (HealthSmeFacility healthSmeFacility : findAll()) {
			remove(healthSmeFacility);
		}
	}

	/**
	 * Returns the number of health sme facilities.
	 *
	 * @return the number of health sme facilities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_HEALTHSMEFACILITY);

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
		return "healthSmeFacilityId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_HEALTHSMEFACILITY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HealthSmeFacilityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the health sme facility persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new HealthSmeFacilityModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", HealthSmeFacility.class.getName()));

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

		_setHealthSmeFacilityUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setHealthSmeFacilityUtilPersistence(null);

		entityCache.removeCache(HealthSmeFacilityImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setHealthSmeFacilityUtilPersistence(
		HealthSmeFacilityPersistence healthSmeFacilityPersistence) {

		try {
			Field field = HealthSmeFacilityUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, healthSmeFacilityPersistence);
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

	private static final String _SQL_SELECT_HEALTHSMEFACILITY =
		"SELECT healthSmeFacility FROM HealthSmeFacility healthSmeFacility";

	private static final String _SQL_COUNT_HEALTHSMEFACILITY =
		"SELECT COUNT(healthSmeFacility) FROM HealthSmeFacility healthSmeFacility";

	private static final String _ORDER_BY_ENTITY_ALIAS = "healthSmeFacility.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No HealthSmeFacility exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		HealthSmeFacilityPersistenceImpl.class);

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

	private static class HealthSmeFacilityModelArgumentsResolver
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

			HealthSmeFacilityModelImpl healthSmeFacilityModelImpl =
				(HealthSmeFacilityModelImpl)baseModel;

			long columnBitmask = healthSmeFacilityModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					healthSmeFacilityModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						healthSmeFacilityModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					healthSmeFacilityModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			HealthSmeFacilityModelImpl healthSmeFacilityModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						healthSmeFacilityModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = healthSmeFacilityModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}