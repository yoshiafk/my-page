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

import com.mypage.admin.product.exception.NoSuchSmartActiveClassRateException;
import com.mypage.admin.product.model.SmartActiveClassRate;
import com.mypage.admin.product.model.impl.SmartActiveClassRateImpl;
import com.mypage.admin.product.model.impl.SmartActiveClassRateModelImpl;
import com.mypage.admin.product.service.persistence.SmartActiveClassRatePersistence;
import com.mypage.admin.product.service.persistence.SmartActiveClassRateUtil;
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
 * The persistence implementation for the smart active class rate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = SmartActiveClassRatePersistence.class)
public class SmartActiveClassRatePersistenceImpl
	extends BasePersistenceImpl<SmartActiveClassRate>
	implements SmartActiveClassRatePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SmartActiveClassRateUtil</code> to access the smart active class rate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SmartActiveClassRateImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SmartActiveClassRatePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SmartActiveClassRate.class);

		setModelImplClass(SmartActiveClassRateImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the smart active class rate in the entity cache if it is enabled.
	 *
	 * @param smartActiveClassRate the smart active class rate
	 */
	@Override
	public void cacheResult(SmartActiveClassRate smartActiveClassRate) {
		entityCache.putResult(
			SmartActiveClassRateImpl.class,
			smartActiveClassRate.getPrimaryKey(), smartActiveClassRate);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the smart active class rates in the entity cache if it is enabled.
	 *
	 * @param smartActiveClassRates the smart active class rates
	 */
	@Override
	public void cacheResult(List<SmartActiveClassRate> smartActiveClassRates) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (smartActiveClassRates.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SmartActiveClassRate smartActiveClassRate :
				smartActiveClassRates) {

			if (entityCache.getResult(
					SmartActiveClassRateImpl.class,
					smartActiveClassRate.getPrimaryKey()) == null) {

				cacheResult(smartActiveClassRate);
			}
		}
	}

	/**
	 * Clears the cache for all smart active class rates.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SmartActiveClassRateImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the smart active class rate.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SmartActiveClassRate smartActiveClassRate) {
		entityCache.removeResult(
			SmartActiveClassRateImpl.class, smartActiveClassRate);
	}

	@Override
	public void clearCache(List<SmartActiveClassRate> smartActiveClassRates) {
		for (SmartActiveClassRate smartActiveClassRate :
				smartActiveClassRates) {

			entityCache.removeResult(
				SmartActiveClassRateImpl.class, smartActiveClassRate);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				SmartActiveClassRateImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new smart active class rate with the primary key. Does not add the smart active class rate to the database.
	 *
	 * @param smartActiveClassRateId the primary key for the new smart active class rate
	 * @return the new smart active class rate
	 */
	@Override
	public SmartActiveClassRate create(long smartActiveClassRateId) {
		SmartActiveClassRate smartActiveClassRate =
			new SmartActiveClassRateImpl();

		smartActiveClassRate.setNew(true);
		smartActiveClassRate.setPrimaryKey(smartActiveClassRateId);

		smartActiveClassRate.setCompanyId(CompanyThreadLocal.getCompanyId());

		return smartActiveClassRate;
	}

	/**
	 * Removes the smart active class rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveClassRateId the primary key of the smart active class rate
	 * @return the smart active class rate that was removed
	 * @throws NoSuchSmartActiveClassRateException if a smart active class rate with the primary key could not be found
	 */
	@Override
	public SmartActiveClassRate remove(long smartActiveClassRateId)
		throws NoSuchSmartActiveClassRateException {

		return remove((Serializable)smartActiveClassRateId);
	}

	/**
	 * Removes the smart active class rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the smart active class rate
	 * @return the smart active class rate that was removed
	 * @throws NoSuchSmartActiveClassRateException if a smart active class rate with the primary key could not be found
	 */
	@Override
	public SmartActiveClassRate remove(Serializable primaryKey)
		throws NoSuchSmartActiveClassRateException {

		Session session = null;

		try {
			session = openSession();

			SmartActiveClassRate smartActiveClassRate =
				(SmartActiveClassRate)session.get(
					SmartActiveClassRateImpl.class, primaryKey);

			if (smartActiveClassRate == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSmartActiveClassRateException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(smartActiveClassRate);
		}
		catch (NoSuchSmartActiveClassRateException noSuchEntityException) {
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
	protected SmartActiveClassRate removeImpl(
		SmartActiveClassRate smartActiveClassRate) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(smartActiveClassRate)) {
				smartActiveClassRate = (SmartActiveClassRate)session.get(
					SmartActiveClassRateImpl.class,
					smartActiveClassRate.getPrimaryKeyObj());
			}

			if (smartActiveClassRate != null) {
				session.delete(smartActiveClassRate);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (smartActiveClassRate != null) {
			clearCache(smartActiveClassRate);
		}

		return smartActiveClassRate;
	}

	@Override
	public SmartActiveClassRate updateImpl(
		SmartActiveClassRate smartActiveClassRate) {

		boolean isNew = smartActiveClassRate.isNew();

		if (!(smartActiveClassRate instanceof SmartActiveClassRateModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(smartActiveClassRate.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					smartActiveClassRate);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in smartActiveClassRate proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SmartActiveClassRate implementation " +
					smartActiveClassRate.getClass());
		}

		SmartActiveClassRateModelImpl smartActiveClassRateModelImpl =
			(SmartActiveClassRateModelImpl)smartActiveClassRate;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (smartActiveClassRate.getCreateDate() == null)) {
			if (serviceContext == null) {
				smartActiveClassRate.setCreateDate(date);
			}
			else {
				smartActiveClassRate.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!smartActiveClassRateModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				smartActiveClassRate.setModifiedDate(date);
			}
			else {
				smartActiveClassRate.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(smartActiveClassRate);
			}
			else {
				smartActiveClassRate = (SmartActiveClassRate)session.merge(
					smartActiveClassRate);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SmartActiveClassRateImpl.class, smartActiveClassRate, false, true);

		if (isNew) {
			smartActiveClassRate.setNew(false);
		}

		smartActiveClassRate.resetOriginalValues();

		return smartActiveClassRate;
	}

	/**
	 * Returns the smart active class rate with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the smart active class rate
	 * @return the smart active class rate
	 * @throws NoSuchSmartActiveClassRateException if a smart active class rate with the primary key could not be found
	 */
	@Override
	public SmartActiveClassRate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSmartActiveClassRateException {

		SmartActiveClassRate smartActiveClassRate = fetchByPrimaryKey(
			primaryKey);

		if (smartActiveClassRate == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSmartActiveClassRateException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return smartActiveClassRate;
	}

	/**
	 * Returns the smart active class rate with the primary key or throws a <code>NoSuchSmartActiveClassRateException</code> if it could not be found.
	 *
	 * @param smartActiveClassRateId the primary key of the smart active class rate
	 * @return the smart active class rate
	 * @throws NoSuchSmartActiveClassRateException if a smart active class rate with the primary key could not be found
	 */
	@Override
	public SmartActiveClassRate findByPrimaryKey(long smartActiveClassRateId)
		throws NoSuchSmartActiveClassRateException {

		return findByPrimaryKey((Serializable)smartActiveClassRateId);
	}

	/**
	 * Returns the smart active class rate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveClassRateId the primary key of the smart active class rate
	 * @return the smart active class rate, or <code>null</code> if a smart active class rate with the primary key could not be found
	 */
	@Override
	public SmartActiveClassRate fetchByPrimaryKey(long smartActiveClassRateId) {
		return fetchByPrimaryKey((Serializable)smartActiveClassRateId);
	}

	/**
	 * Returns all the smart active class rates.
	 *
	 * @return the smart active class rates
	 */
	@Override
	public List<SmartActiveClassRate> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smart active class rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active class rates
	 * @param end the upper bound of the range of smart active class rates (not inclusive)
	 * @return the range of smart active class rates
	 */
	@Override
	public List<SmartActiveClassRate> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart active class rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active class rates
	 * @param end the upper bound of the range of smart active class rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active class rates
	 */
	@Override
	public List<SmartActiveClassRate> findAll(
		int start, int end,
		OrderByComparator<SmartActiveClassRate> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart active class rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active class rates
	 * @param end the upper bound of the range of smart active class rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active class rates
	 */
	@Override
	public List<SmartActiveClassRate> findAll(
		int start, int end,
		OrderByComparator<SmartActiveClassRate> orderByComparator,
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

		List<SmartActiveClassRate> list = null;

		if (useFinderCache) {
			list = (List<SmartActiveClassRate>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SMARTACTIVECLASSRATE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SMARTACTIVECLASSRATE;

				sql = sql.concat(SmartActiveClassRateModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SmartActiveClassRate>)QueryUtil.list(
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
	 * Removes all the smart active class rates from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SmartActiveClassRate smartActiveClassRate : findAll()) {
			remove(smartActiveClassRate);
		}
	}

	/**
	 * Returns the number of smart active class rates.
	 *
	 * @return the number of smart active class rates
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_SMARTACTIVECLASSRATE);

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
		return "smartActiveClassRateId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SMARTACTIVECLASSRATE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SmartActiveClassRateModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the smart active class rate persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SmartActiveClassRateModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SmartActiveClassRate.class.getName()));

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

		_setSmartActiveClassRateUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSmartActiveClassRateUtilPersistence(null);

		entityCache.removeCache(SmartActiveClassRateImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setSmartActiveClassRateUtilPersistence(
		SmartActiveClassRatePersistence smartActiveClassRatePersistence) {

		try {
			Field field = SmartActiveClassRateUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, smartActiveClassRatePersistence);
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

	private static final String _SQL_SELECT_SMARTACTIVECLASSRATE =
		"SELECT smartActiveClassRate FROM SmartActiveClassRate smartActiveClassRate";

	private static final String _SQL_COUNT_SMARTACTIVECLASSRATE =
		"SELECT COUNT(smartActiveClassRate) FROM SmartActiveClassRate smartActiveClassRate";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"smartActiveClassRate.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SmartActiveClassRate exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SmartActiveClassRatePersistenceImpl.class);

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

	private static class SmartActiveClassRateModelArgumentsResolver
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

			SmartActiveClassRateModelImpl smartActiveClassRateModelImpl =
				(SmartActiveClassRateModelImpl)baseModel;

			long columnBitmask =
				smartActiveClassRateModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					smartActiveClassRateModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						smartActiveClassRateModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					smartActiveClassRateModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SmartActiveClassRateModelImpl smartActiveClassRateModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						smartActiveClassRateModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = smartActiveClassRateModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}