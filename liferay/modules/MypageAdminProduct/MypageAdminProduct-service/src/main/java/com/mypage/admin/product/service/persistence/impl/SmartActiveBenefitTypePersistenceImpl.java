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

import com.mypage.admin.product.exception.NoSuchSmartActiveBenefitTypeException;
import com.mypage.admin.product.model.SmartActiveBenefitType;
import com.mypage.admin.product.model.impl.SmartActiveBenefitTypeImpl;
import com.mypage.admin.product.model.impl.SmartActiveBenefitTypeModelImpl;
import com.mypage.admin.product.service.persistence.SmartActiveBenefitTypePersistence;
import com.mypage.admin.product.service.persistence.SmartActiveBenefitTypeUtil;
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
 * The persistence implementation for the smart active benefit type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = SmartActiveBenefitTypePersistence.class)
public class SmartActiveBenefitTypePersistenceImpl
	extends BasePersistenceImpl<SmartActiveBenefitType>
	implements SmartActiveBenefitTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SmartActiveBenefitTypeUtil</code> to access the smart active benefit type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SmartActiveBenefitTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SmartActiveBenefitTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SmartActiveBenefitType.class);

		setModelImplClass(SmartActiveBenefitTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the smart active benefit type in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefitType the smart active benefit type
	 */
	@Override
	public void cacheResult(SmartActiveBenefitType smartActiveBenefitType) {
		entityCache.putResult(
			SmartActiveBenefitTypeImpl.class,
			smartActiveBenefitType.getPrimaryKey(), smartActiveBenefitType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the smart active benefit types in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefitTypes the smart active benefit types
	 */
	@Override
	public void cacheResult(
		List<SmartActiveBenefitType> smartActiveBenefitTypes) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (smartActiveBenefitTypes.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SmartActiveBenefitType smartActiveBenefitType :
				smartActiveBenefitTypes) {

			if (entityCache.getResult(
					SmartActiveBenefitTypeImpl.class,
					smartActiveBenefitType.getPrimaryKey()) == null) {

				cacheResult(smartActiveBenefitType);
			}
		}
	}

	/**
	 * Clears the cache for all smart active benefit types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SmartActiveBenefitTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the smart active benefit type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SmartActiveBenefitType smartActiveBenefitType) {
		entityCache.removeResult(
			SmartActiveBenefitTypeImpl.class, smartActiveBenefitType);
	}

	@Override
	public void clearCache(
		List<SmartActiveBenefitType> smartActiveBenefitTypes) {

		for (SmartActiveBenefitType smartActiveBenefitType :
				smartActiveBenefitTypes) {

			entityCache.removeResult(
				SmartActiveBenefitTypeImpl.class, smartActiveBenefitType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				SmartActiveBenefitTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new smart active benefit type with the primary key. Does not add the smart active benefit type to the database.
	 *
	 * @param smartActiveBenefitTypeId the primary key for the new smart active benefit type
	 * @return the new smart active benefit type
	 */
	@Override
	public SmartActiveBenefitType create(long smartActiveBenefitTypeId) {
		SmartActiveBenefitType smartActiveBenefitType =
			new SmartActiveBenefitTypeImpl();

		smartActiveBenefitType.setNew(true);
		smartActiveBenefitType.setPrimaryKey(smartActiveBenefitTypeId);

		smartActiveBenefitType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return smartActiveBenefitType;
	}

	/**
	 * Removes the smart active benefit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveBenefitTypeId the primary key of the smart active benefit type
	 * @return the smart active benefit type that was removed
	 * @throws NoSuchSmartActiveBenefitTypeException if a smart active benefit type with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefitType remove(long smartActiveBenefitTypeId)
		throws NoSuchSmartActiveBenefitTypeException {

		return remove((Serializable)smartActiveBenefitTypeId);
	}

	/**
	 * Removes the smart active benefit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the smart active benefit type
	 * @return the smart active benefit type that was removed
	 * @throws NoSuchSmartActiveBenefitTypeException if a smart active benefit type with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefitType remove(Serializable primaryKey)
		throws NoSuchSmartActiveBenefitTypeException {

		Session session = null;

		try {
			session = openSession();

			SmartActiveBenefitType smartActiveBenefitType =
				(SmartActiveBenefitType)session.get(
					SmartActiveBenefitTypeImpl.class, primaryKey);

			if (smartActiveBenefitType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSmartActiveBenefitTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(smartActiveBenefitType);
		}
		catch (NoSuchSmartActiveBenefitTypeException noSuchEntityException) {
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
	protected SmartActiveBenefitType removeImpl(
		SmartActiveBenefitType smartActiveBenefitType) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(smartActiveBenefitType)) {
				smartActiveBenefitType = (SmartActiveBenefitType)session.get(
					SmartActiveBenefitTypeImpl.class,
					smartActiveBenefitType.getPrimaryKeyObj());
			}

			if (smartActiveBenefitType != null) {
				session.delete(smartActiveBenefitType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (smartActiveBenefitType != null) {
			clearCache(smartActiveBenefitType);
		}

		return smartActiveBenefitType;
	}

	@Override
	public SmartActiveBenefitType updateImpl(
		SmartActiveBenefitType smartActiveBenefitType) {

		boolean isNew = smartActiveBenefitType.isNew();

		if (!(smartActiveBenefitType instanceof
				SmartActiveBenefitTypeModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(smartActiveBenefitType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					smartActiveBenefitType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in smartActiveBenefitType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SmartActiveBenefitType implementation " +
					smartActiveBenefitType.getClass());
		}

		SmartActiveBenefitTypeModelImpl smartActiveBenefitTypeModelImpl =
			(SmartActiveBenefitTypeModelImpl)smartActiveBenefitType;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (smartActiveBenefitType.getCreateDate() == null)) {
			if (serviceContext == null) {
				smartActiveBenefitType.setCreateDate(date);
			}
			else {
				smartActiveBenefitType.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!smartActiveBenefitTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				smartActiveBenefitType.setModifiedDate(date);
			}
			else {
				smartActiveBenefitType.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(smartActiveBenefitType);
			}
			else {
				smartActiveBenefitType = (SmartActiveBenefitType)session.merge(
					smartActiveBenefitType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SmartActiveBenefitTypeImpl.class, smartActiveBenefitType, false,
			true);

		if (isNew) {
			smartActiveBenefitType.setNew(false);
		}

		smartActiveBenefitType.resetOriginalValues();

		return smartActiveBenefitType;
	}

	/**
	 * Returns the smart active benefit type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the smart active benefit type
	 * @return the smart active benefit type
	 * @throws NoSuchSmartActiveBenefitTypeException if a smart active benefit type with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefitType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSmartActiveBenefitTypeException {

		SmartActiveBenefitType smartActiveBenefitType = fetchByPrimaryKey(
			primaryKey);

		if (smartActiveBenefitType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSmartActiveBenefitTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return smartActiveBenefitType;
	}

	/**
	 * Returns the smart active benefit type with the primary key or throws a <code>NoSuchSmartActiveBenefitTypeException</code> if it could not be found.
	 *
	 * @param smartActiveBenefitTypeId the primary key of the smart active benefit type
	 * @return the smart active benefit type
	 * @throws NoSuchSmartActiveBenefitTypeException if a smart active benefit type with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefitType findByPrimaryKey(
			long smartActiveBenefitTypeId)
		throws NoSuchSmartActiveBenefitTypeException {

		return findByPrimaryKey((Serializable)smartActiveBenefitTypeId);
	}

	/**
	 * Returns the smart active benefit type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveBenefitTypeId the primary key of the smart active benefit type
	 * @return the smart active benefit type, or <code>null</code> if a smart active benefit type with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefitType fetchByPrimaryKey(
		long smartActiveBenefitTypeId) {

		return fetchByPrimaryKey((Serializable)smartActiveBenefitTypeId);
	}

	/**
	 * Returns all the smart active benefit types.
	 *
	 * @return the smart active benefit types
	 */
	@Override
	public List<SmartActiveBenefitType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smart active benefit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit types
	 * @param end the upper bound of the range of smart active benefit types (not inclusive)
	 * @return the range of smart active benefit types
	 */
	@Override
	public List<SmartActiveBenefitType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart active benefit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit types
	 * @param end the upper bound of the range of smart active benefit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active benefit types
	 */
	@Override
	public List<SmartActiveBenefitType> findAll(
		int start, int end,
		OrderByComparator<SmartActiveBenefitType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart active benefit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit types
	 * @param end the upper bound of the range of smart active benefit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active benefit types
	 */
	@Override
	public List<SmartActiveBenefitType> findAll(
		int start, int end,
		OrderByComparator<SmartActiveBenefitType> orderByComparator,
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

		List<SmartActiveBenefitType> list = null;

		if (useFinderCache) {
			list = (List<SmartActiveBenefitType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SMARTACTIVEBENEFITTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SMARTACTIVEBENEFITTYPE;

				sql = sql.concat(SmartActiveBenefitTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SmartActiveBenefitType>)QueryUtil.list(
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
	 * Removes all the smart active benefit types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SmartActiveBenefitType smartActiveBenefitType : findAll()) {
			remove(smartActiveBenefitType);
		}
	}

	/**
	 * Returns the number of smart active benefit types.
	 *
	 * @return the number of smart active benefit types
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
					_SQL_COUNT_SMARTACTIVEBENEFITTYPE);

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
		return "smartActiveBenefitTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SMARTACTIVEBENEFITTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SmartActiveBenefitTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the smart active benefit type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SmartActiveBenefitTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SmartActiveBenefitType.class.getName()));

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

		_setSmartActiveBenefitTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSmartActiveBenefitTypeUtilPersistence(null);

		entityCache.removeCache(SmartActiveBenefitTypeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setSmartActiveBenefitTypeUtilPersistence(
		SmartActiveBenefitTypePersistence smartActiveBenefitTypePersistence) {

		try {
			Field field = SmartActiveBenefitTypeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, smartActiveBenefitTypePersistence);
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

	private static final String _SQL_SELECT_SMARTACTIVEBENEFITTYPE =
		"SELECT smartActiveBenefitType FROM SmartActiveBenefitType smartActiveBenefitType";

	private static final String _SQL_COUNT_SMARTACTIVEBENEFITTYPE =
		"SELECT COUNT(smartActiveBenefitType) FROM SmartActiveBenefitType smartActiveBenefitType";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"smartActiveBenefitType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SmartActiveBenefitType exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SmartActiveBenefitTypePersistenceImpl.class);

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

	private static class SmartActiveBenefitTypeModelArgumentsResolver
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

			SmartActiveBenefitTypeModelImpl smartActiveBenefitTypeModelImpl =
				(SmartActiveBenefitTypeModelImpl)baseModel;

			long columnBitmask =
				smartActiveBenefitTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					smartActiveBenefitTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						smartActiveBenefitTypeModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					smartActiveBenefitTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SmartActiveBenefitTypeModelImpl smartActiveBenefitTypeModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						smartActiveBenefitTypeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						smartActiveBenefitTypeModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}