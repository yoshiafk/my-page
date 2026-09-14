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

import com.mypage.admin.product.exception.NoSuchSmartActiveClassException;
import com.mypage.admin.product.model.SmartActiveClass;
import com.mypage.admin.product.model.impl.SmartActiveClassImpl;
import com.mypage.admin.product.model.impl.SmartActiveClassModelImpl;
import com.mypage.admin.product.service.persistence.SmartActiveClassPersistence;
import com.mypage.admin.product.service.persistence.SmartActiveClassUtil;
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
 * The persistence implementation for the smart active class service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = SmartActiveClassPersistence.class)
public class SmartActiveClassPersistenceImpl
	extends BasePersistenceImpl<SmartActiveClass>
	implements SmartActiveClassPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SmartActiveClassUtil</code> to access the smart active class persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SmartActiveClassImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SmartActiveClassPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SmartActiveClass.class);

		setModelImplClass(SmartActiveClassImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the smart active class in the entity cache if it is enabled.
	 *
	 * @param smartActiveClass the smart active class
	 */
	@Override
	public void cacheResult(SmartActiveClass smartActiveClass) {
		entityCache.putResult(
			SmartActiveClassImpl.class, smartActiveClass.getPrimaryKey(),
			smartActiveClass);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the smart active classes in the entity cache if it is enabled.
	 *
	 * @param smartActiveClasses the smart active classes
	 */
	@Override
	public void cacheResult(List<SmartActiveClass> smartActiveClasses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (smartActiveClasses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SmartActiveClass smartActiveClass : smartActiveClasses) {
			if (entityCache.getResult(
					SmartActiveClassImpl.class,
					smartActiveClass.getPrimaryKey()) == null) {

				cacheResult(smartActiveClass);
			}
		}
	}

	/**
	 * Clears the cache for all smart active classes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SmartActiveClassImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the smart active class.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SmartActiveClass smartActiveClass) {
		entityCache.removeResult(SmartActiveClassImpl.class, smartActiveClass);
	}

	@Override
	public void clearCache(List<SmartActiveClass> smartActiveClasses) {
		for (SmartActiveClass smartActiveClass : smartActiveClasses) {
			entityCache.removeResult(
				SmartActiveClassImpl.class, smartActiveClass);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SmartActiveClassImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new smart active class with the primary key. Does not add the smart active class to the database.
	 *
	 * @param smartActiveClassId the primary key for the new smart active class
	 * @return the new smart active class
	 */
	@Override
	public SmartActiveClass create(long smartActiveClassId) {
		SmartActiveClass smartActiveClass = new SmartActiveClassImpl();

		smartActiveClass.setNew(true);
		smartActiveClass.setPrimaryKey(smartActiveClassId);

		smartActiveClass.setCompanyId(CompanyThreadLocal.getCompanyId());

		return smartActiveClass;
	}

	/**
	 * Removes the smart active class with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveClassId the primary key of the smart active class
	 * @return the smart active class that was removed
	 * @throws NoSuchSmartActiveClassException if a smart active class with the primary key could not be found
	 */
	@Override
	public SmartActiveClass remove(long smartActiveClassId)
		throws NoSuchSmartActiveClassException {

		return remove((Serializable)smartActiveClassId);
	}

	/**
	 * Removes the smart active class with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the smart active class
	 * @return the smart active class that was removed
	 * @throws NoSuchSmartActiveClassException if a smart active class with the primary key could not be found
	 */
	@Override
	public SmartActiveClass remove(Serializable primaryKey)
		throws NoSuchSmartActiveClassException {

		Session session = null;

		try {
			session = openSession();

			SmartActiveClass smartActiveClass = (SmartActiveClass)session.get(
				SmartActiveClassImpl.class, primaryKey);

			if (smartActiveClass == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSmartActiveClassException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(smartActiveClass);
		}
		catch (NoSuchSmartActiveClassException noSuchEntityException) {
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
	protected SmartActiveClass removeImpl(SmartActiveClass smartActiveClass) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(smartActiveClass)) {
				smartActiveClass = (SmartActiveClass)session.get(
					SmartActiveClassImpl.class,
					smartActiveClass.getPrimaryKeyObj());
			}

			if (smartActiveClass != null) {
				session.delete(smartActiveClass);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (smartActiveClass != null) {
			clearCache(smartActiveClass);
		}

		return smartActiveClass;
	}

	@Override
	public SmartActiveClass updateImpl(SmartActiveClass smartActiveClass) {
		boolean isNew = smartActiveClass.isNew();

		if (!(smartActiveClass instanceof SmartActiveClassModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(smartActiveClass.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					smartActiveClass);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in smartActiveClass proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SmartActiveClass implementation " +
					smartActiveClass.getClass());
		}

		SmartActiveClassModelImpl smartActiveClassModelImpl =
			(SmartActiveClassModelImpl)smartActiveClass;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (smartActiveClass.getCreateDate() == null)) {
			if (serviceContext == null) {
				smartActiveClass.setCreateDate(date);
			}
			else {
				smartActiveClass.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!smartActiveClassModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				smartActiveClass.setModifiedDate(date);
			}
			else {
				smartActiveClass.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(smartActiveClass);
			}
			else {
				smartActiveClass = (SmartActiveClass)session.merge(
					smartActiveClass);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SmartActiveClassImpl.class, smartActiveClass, false, true);

		if (isNew) {
			smartActiveClass.setNew(false);
		}

		smartActiveClass.resetOriginalValues();

		return smartActiveClass;
	}

	/**
	 * Returns the smart active class with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the smart active class
	 * @return the smart active class
	 * @throws NoSuchSmartActiveClassException if a smart active class with the primary key could not be found
	 */
	@Override
	public SmartActiveClass findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSmartActiveClassException {

		SmartActiveClass smartActiveClass = fetchByPrimaryKey(primaryKey);

		if (smartActiveClass == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSmartActiveClassException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return smartActiveClass;
	}

	/**
	 * Returns the smart active class with the primary key or throws a <code>NoSuchSmartActiveClassException</code> if it could not be found.
	 *
	 * @param smartActiveClassId the primary key of the smart active class
	 * @return the smart active class
	 * @throws NoSuchSmartActiveClassException if a smart active class with the primary key could not be found
	 */
	@Override
	public SmartActiveClass findByPrimaryKey(long smartActiveClassId)
		throws NoSuchSmartActiveClassException {

		return findByPrimaryKey((Serializable)smartActiveClassId);
	}

	/**
	 * Returns the smart active class with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveClassId the primary key of the smart active class
	 * @return the smart active class, or <code>null</code> if a smart active class with the primary key could not be found
	 */
	@Override
	public SmartActiveClass fetchByPrimaryKey(long smartActiveClassId) {
		return fetchByPrimaryKey((Serializable)smartActiveClassId);
	}

	/**
	 * Returns all the smart active classes.
	 *
	 * @return the smart active classes
	 */
	@Override
	public List<SmartActiveClass> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smart active classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active classes
	 * @param end the upper bound of the range of smart active classes (not inclusive)
	 * @return the range of smart active classes
	 */
	@Override
	public List<SmartActiveClass> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart active classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active classes
	 * @param end the upper bound of the range of smart active classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active classes
	 */
	@Override
	public List<SmartActiveClass> findAll(
		int start, int end,
		OrderByComparator<SmartActiveClass> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart active classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active classes
	 * @param end the upper bound of the range of smart active classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active classes
	 */
	@Override
	public List<SmartActiveClass> findAll(
		int start, int end,
		OrderByComparator<SmartActiveClass> orderByComparator,
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

		List<SmartActiveClass> list = null;

		if (useFinderCache) {
			list = (List<SmartActiveClass>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SMARTACTIVECLASS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SMARTACTIVECLASS;

				sql = sql.concat(SmartActiveClassModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SmartActiveClass>)QueryUtil.list(
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
	 * Removes all the smart active classes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SmartActiveClass smartActiveClass : findAll()) {
			remove(smartActiveClass);
		}
	}

	/**
	 * Returns the number of smart active classes.
	 *
	 * @return the number of smart active classes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SMARTACTIVECLASS);

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
		return "smartActiveClassId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SMARTACTIVECLASS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SmartActiveClassModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the smart active class persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SmartActiveClassModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SmartActiveClass.class.getName()));

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

		_setSmartActiveClassUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSmartActiveClassUtilPersistence(null);

		entityCache.removeCache(SmartActiveClassImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setSmartActiveClassUtilPersistence(
		SmartActiveClassPersistence smartActiveClassPersistence) {

		try {
			Field field = SmartActiveClassUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, smartActiveClassPersistence);
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

	private static final String _SQL_SELECT_SMARTACTIVECLASS =
		"SELECT smartActiveClass FROM SmartActiveClass smartActiveClass";

	private static final String _SQL_COUNT_SMARTACTIVECLASS =
		"SELECT COUNT(smartActiveClass) FROM SmartActiveClass smartActiveClass";

	private static final String _ORDER_BY_ENTITY_ALIAS = "smartActiveClass.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SmartActiveClass exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SmartActiveClassPersistenceImpl.class);

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

	private static class SmartActiveClassModelArgumentsResolver
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

			SmartActiveClassModelImpl smartActiveClassModelImpl =
				(SmartActiveClassModelImpl)baseModel;

			long columnBitmask = smartActiveClassModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					smartActiveClassModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						smartActiveClassModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					smartActiveClassModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SmartActiveClassModelImpl smartActiveClassModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						smartActiveClassModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = smartActiveClassModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}