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

import com.mypage.admin.product.exception.NoSuchSmartActiveFeatureException;
import com.mypage.admin.product.model.SmartActiveFeature;
import com.mypage.admin.product.model.impl.SmartActiveFeatureImpl;
import com.mypage.admin.product.model.impl.SmartActiveFeatureModelImpl;
import com.mypage.admin.product.service.persistence.SmartActiveFeaturePersistence;
import com.mypage.admin.product.service.persistence.SmartActiveFeatureUtil;
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
 * The persistence implementation for the smart active feature service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = SmartActiveFeaturePersistence.class)
public class SmartActiveFeaturePersistenceImpl
	extends BasePersistenceImpl<SmartActiveFeature>
	implements SmartActiveFeaturePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SmartActiveFeatureUtil</code> to access the smart active feature persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SmartActiveFeatureImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SmartActiveFeaturePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SmartActiveFeature.class);

		setModelImplClass(SmartActiveFeatureImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the smart active feature in the entity cache if it is enabled.
	 *
	 * @param smartActiveFeature the smart active feature
	 */
	@Override
	public void cacheResult(SmartActiveFeature smartActiveFeature) {
		entityCache.putResult(
			SmartActiveFeatureImpl.class, smartActiveFeature.getPrimaryKey(),
			smartActiveFeature);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the smart active features in the entity cache if it is enabled.
	 *
	 * @param smartActiveFeatures the smart active features
	 */
	@Override
	public void cacheResult(List<SmartActiveFeature> smartActiveFeatures) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (smartActiveFeatures.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SmartActiveFeature smartActiveFeature : smartActiveFeatures) {
			if (entityCache.getResult(
					SmartActiveFeatureImpl.class,
					smartActiveFeature.getPrimaryKey()) == null) {

				cacheResult(smartActiveFeature);
			}
		}
	}

	/**
	 * Clears the cache for all smart active features.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SmartActiveFeatureImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the smart active feature.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SmartActiveFeature smartActiveFeature) {
		entityCache.removeResult(
			SmartActiveFeatureImpl.class, smartActiveFeature);
	}

	@Override
	public void clearCache(List<SmartActiveFeature> smartActiveFeatures) {
		for (SmartActiveFeature smartActiveFeature : smartActiveFeatures) {
			entityCache.removeResult(
				SmartActiveFeatureImpl.class, smartActiveFeature);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SmartActiveFeatureImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new smart active feature with the primary key. Does not add the smart active feature to the database.
	 *
	 * @param smartActiveFeatureId the primary key for the new smart active feature
	 * @return the new smart active feature
	 */
	@Override
	public SmartActiveFeature create(long smartActiveFeatureId) {
		SmartActiveFeature smartActiveFeature = new SmartActiveFeatureImpl();

		smartActiveFeature.setNew(true);
		smartActiveFeature.setPrimaryKey(smartActiveFeatureId);

		smartActiveFeature.setCompanyId(CompanyThreadLocal.getCompanyId());

		return smartActiveFeature;
	}

	/**
	 * Removes the smart active feature with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveFeatureId the primary key of the smart active feature
	 * @return the smart active feature that was removed
	 * @throws NoSuchSmartActiveFeatureException if a smart active feature with the primary key could not be found
	 */
	@Override
	public SmartActiveFeature remove(long smartActiveFeatureId)
		throws NoSuchSmartActiveFeatureException {

		return remove((Serializable)smartActiveFeatureId);
	}

	/**
	 * Removes the smart active feature with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the smart active feature
	 * @return the smart active feature that was removed
	 * @throws NoSuchSmartActiveFeatureException if a smart active feature with the primary key could not be found
	 */
	@Override
	public SmartActiveFeature remove(Serializable primaryKey)
		throws NoSuchSmartActiveFeatureException {

		Session session = null;

		try {
			session = openSession();

			SmartActiveFeature smartActiveFeature =
				(SmartActiveFeature)session.get(
					SmartActiveFeatureImpl.class, primaryKey);

			if (smartActiveFeature == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSmartActiveFeatureException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(smartActiveFeature);
		}
		catch (NoSuchSmartActiveFeatureException noSuchEntityException) {
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
	protected SmartActiveFeature removeImpl(
		SmartActiveFeature smartActiveFeature) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(smartActiveFeature)) {
				smartActiveFeature = (SmartActiveFeature)session.get(
					SmartActiveFeatureImpl.class,
					smartActiveFeature.getPrimaryKeyObj());
			}

			if (smartActiveFeature != null) {
				session.delete(smartActiveFeature);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (smartActiveFeature != null) {
			clearCache(smartActiveFeature);
		}

		return smartActiveFeature;
	}

	@Override
	public SmartActiveFeature updateImpl(
		SmartActiveFeature smartActiveFeature) {

		boolean isNew = smartActiveFeature.isNew();

		if (!(smartActiveFeature instanceof SmartActiveFeatureModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(smartActiveFeature.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					smartActiveFeature);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in smartActiveFeature proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SmartActiveFeature implementation " +
					smartActiveFeature.getClass());
		}

		SmartActiveFeatureModelImpl smartActiveFeatureModelImpl =
			(SmartActiveFeatureModelImpl)smartActiveFeature;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (smartActiveFeature.getCreateDate() == null)) {
			if (serviceContext == null) {
				smartActiveFeature.setCreateDate(date);
			}
			else {
				smartActiveFeature.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!smartActiveFeatureModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				smartActiveFeature.setModifiedDate(date);
			}
			else {
				smartActiveFeature.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(smartActiveFeature);
			}
			else {
				smartActiveFeature = (SmartActiveFeature)session.merge(
					smartActiveFeature);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SmartActiveFeatureImpl.class, smartActiveFeature, false, true);

		if (isNew) {
			smartActiveFeature.setNew(false);
		}

		smartActiveFeature.resetOriginalValues();

		return smartActiveFeature;
	}

	/**
	 * Returns the smart active feature with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the smart active feature
	 * @return the smart active feature
	 * @throws NoSuchSmartActiveFeatureException if a smart active feature with the primary key could not be found
	 */
	@Override
	public SmartActiveFeature findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSmartActiveFeatureException {

		SmartActiveFeature smartActiveFeature = fetchByPrimaryKey(primaryKey);

		if (smartActiveFeature == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSmartActiveFeatureException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return smartActiveFeature;
	}

	/**
	 * Returns the smart active feature with the primary key or throws a <code>NoSuchSmartActiveFeatureException</code> if it could not be found.
	 *
	 * @param smartActiveFeatureId the primary key of the smart active feature
	 * @return the smart active feature
	 * @throws NoSuchSmartActiveFeatureException if a smart active feature with the primary key could not be found
	 */
	@Override
	public SmartActiveFeature findByPrimaryKey(long smartActiveFeatureId)
		throws NoSuchSmartActiveFeatureException {

		return findByPrimaryKey((Serializable)smartActiveFeatureId);
	}

	/**
	 * Returns the smart active feature with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveFeatureId the primary key of the smart active feature
	 * @return the smart active feature, or <code>null</code> if a smart active feature with the primary key could not be found
	 */
	@Override
	public SmartActiveFeature fetchByPrimaryKey(long smartActiveFeatureId) {
		return fetchByPrimaryKey((Serializable)smartActiveFeatureId);
	}

	/**
	 * Returns all the smart active features.
	 *
	 * @return the smart active features
	 */
	@Override
	public List<SmartActiveFeature> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smart active features.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveFeatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active features
	 * @param end the upper bound of the range of smart active features (not inclusive)
	 * @return the range of smart active features
	 */
	@Override
	public List<SmartActiveFeature> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart active features.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveFeatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active features
	 * @param end the upper bound of the range of smart active features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active features
	 */
	@Override
	public List<SmartActiveFeature> findAll(
		int start, int end,
		OrderByComparator<SmartActiveFeature> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart active features.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveFeatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active features
	 * @param end the upper bound of the range of smart active features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active features
	 */
	@Override
	public List<SmartActiveFeature> findAll(
		int start, int end,
		OrderByComparator<SmartActiveFeature> orderByComparator,
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

		List<SmartActiveFeature> list = null;

		if (useFinderCache) {
			list = (List<SmartActiveFeature>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SMARTACTIVEFEATURE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SMARTACTIVEFEATURE;

				sql = sql.concat(SmartActiveFeatureModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SmartActiveFeature>)QueryUtil.list(
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
	 * Removes all the smart active features from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SmartActiveFeature smartActiveFeature : findAll()) {
			remove(smartActiveFeature);
		}
	}

	/**
	 * Returns the number of smart active features.
	 *
	 * @return the number of smart active features
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
					_SQL_COUNT_SMARTACTIVEFEATURE);

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
		return "smartActiveFeatureId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SMARTACTIVEFEATURE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SmartActiveFeatureModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the smart active feature persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SmartActiveFeatureModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SmartActiveFeature.class.getName()));

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

		_setSmartActiveFeatureUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSmartActiveFeatureUtilPersistence(null);

		entityCache.removeCache(SmartActiveFeatureImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setSmartActiveFeatureUtilPersistence(
		SmartActiveFeaturePersistence smartActiveFeaturePersistence) {

		try {
			Field field = SmartActiveFeatureUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, smartActiveFeaturePersistence);
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

	private static final String _SQL_SELECT_SMARTACTIVEFEATURE =
		"SELECT smartActiveFeature FROM SmartActiveFeature smartActiveFeature";

	private static final String _SQL_COUNT_SMARTACTIVEFEATURE =
		"SELECT COUNT(smartActiveFeature) FROM SmartActiveFeature smartActiveFeature";

	private static final String _ORDER_BY_ENTITY_ALIAS = "smartActiveFeature.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SmartActiveFeature exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SmartActiveFeaturePersistenceImpl.class);

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

	private static class SmartActiveFeatureModelArgumentsResolver
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

			SmartActiveFeatureModelImpl smartActiveFeatureModelImpl =
				(SmartActiveFeatureModelImpl)baseModel;

			long columnBitmask = smartActiveFeatureModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					smartActiveFeatureModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						smartActiveFeatureModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					smartActiveFeatureModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SmartActiveFeatureModelImpl smartActiveFeatureModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						smartActiveFeatureModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = smartActiveFeatureModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}