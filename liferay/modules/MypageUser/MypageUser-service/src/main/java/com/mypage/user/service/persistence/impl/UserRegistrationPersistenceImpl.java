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

package com.mypage.user.service.persistence.impl;

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

import com.mypage.user.exception.NoSuchUserRegistrationException;
import com.mypage.user.model.UserRegistration;
import com.mypage.user.model.impl.UserRegistrationImpl;
import com.mypage.user.model.impl.UserRegistrationModelImpl;
import com.mypage.user.service.persistence.UserRegistrationPersistence;
import com.mypage.user.service.persistence.UserRegistrationUtil;
import com.mypage.user.service.persistence.impl.constants.MPUPersistenceConstants;

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
 * The persistence implementation for the user registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UserRegistrationPersistence.class)
public class UserRegistrationPersistenceImpl
	extends BasePersistenceImpl<UserRegistration>
	implements UserRegistrationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserRegistrationUtil</code> to access the user registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserRegistrationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public UserRegistrationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(UserRegistration.class);

		setModelImplClass(UserRegistrationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the user registration in the entity cache if it is enabled.
	 *
	 * @param userRegistration the user registration
	 */
	@Override
	public void cacheResult(UserRegistration userRegistration) {
		entityCache.putResult(
			UserRegistrationImpl.class, userRegistration.getPrimaryKey(),
			userRegistration);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the user registrations in the entity cache if it is enabled.
	 *
	 * @param userRegistrations the user registrations
	 */
	@Override
	public void cacheResult(List<UserRegistration> userRegistrations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (userRegistrations.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UserRegistration userRegistration : userRegistrations) {
			if (entityCache.getResult(
					UserRegistrationImpl.class,
					userRegistration.getPrimaryKey()) == null) {

				cacheResult(userRegistration);
			}
		}
	}

	/**
	 * Clears the cache for all user registrations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user registration.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserRegistration userRegistration) {
		entityCache.removeResult(UserRegistrationImpl.class, userRegistration);
	}

	@Override
	public void clearCache(List<UserRegistration> userRegistrations) {
		for (UserRegistration userRegistration : userRegistrations) {
			entityCache.removeResult(
				UserRegistrationImpl.class, userRegistration);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(UserRegistrationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new user registration with the primary key. Does not add the user registration to the database.
	 *
	 * @param userRegistrationId the primary key for the new user registration
	 * @return the new user registration
	 */
	@Override
	public UserRegistration create(long userRegistrationId) {
		UserRegistration userRegistration = new UserRegistrationImpl();

		userRegistration.setNew(true);
		userRegistration.setPrimaryKey(userRegistrationId);

		userRegistration.setCompanyId(CompanyThreadLocal.getCompanyId());

		return userRegistration;
	}

	/**
	 * Removes the user registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRegistrationId the primary key of the user registration
	 * @return the user registration that was removed
	 * @throws NoSuchUserRegistrationException if a user registration with the primary key could not be found
	 */
	@Override
	public UserRegistration remove(long userRegistrationId)
		throws NoSuchUserRegistrationException {

		return remove((Serializable)userRegistrationId);
	}

	/**
	 * Removes the user registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user registration
	 * @return the user registration that was removed
	 * @throws NoSuchUserRegistrationException if a user registration with the primary key could not be found
	 */
	@Override
	public UserRegistration remove(Serializable primaryKey)
		throws NoSuchUserRegistrationException {

		Session session = null;

		try {
			session = openSession();

			UserRegistration userRegistration = (UserRegistration)session.get(
				UserRegistrationImpl.class, primaryKey);

			if (userRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserRegistrationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userRegistration);
		}
		catch (NoSuchUserRegistrationException noSuchEntityException) {
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
	protected UserRegistration removeImpl(UserRegistration userRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userRegistration)) {
				userRegistration = (UserRegistration)session.get(
					UserRegistrationImpl.class,
					userRegistration.getPrimaryKeyObj());
			}

			if (userRegistration != null) {
				session.delete(userRegistration);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userRegistration != null) {
			clearCache(userRegistration);
		}

		return userRegistration;
	}

	@Override
	public UserRegistration updateImpl(UserRegistration userRegistration) {
		boolean isNew = userRegistration.isNew();

		if (!(userRegistration instanceof UserRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					userRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userRegistration proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserRegistration implementation " +
					userRegistration.getClass());
		}

		UserRegistrationModelImpl userRegistrationModelImpl =
			(UserRegistrationModelImpl)userRegistration;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (userRegistration.getCreateDate() == null)) {
			if (serviceContext == null) {
				userRegistration.setCreateDate(date);
			}
			else {
				userRegistration.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!userRegistrationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userRegistration.setModifiedDate(date);
			}
			else {
				userRegistration.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userRegistration);
			}
			else {
				userRegistration = (UserRegistration)session.merge(
					userRegistration);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UserRegistrationImpl.class, userRegistration, false, true);

		if (isNew) {
			userRegistration.setNew(false);
		}

		userRegistration.resetOriginalValues();

		return userRegistration;
	}

	/**
	 * Returns the user registration with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user registration
	 * @return the user registration
	 * @throws NoSuchUserRegistrationException if a user registration with the primary key could not be found
	 */
	@Override
	public UserRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserRegistrationException {

		UserRegistration userRegistration = fetchByPrimaryKey(primaryKey);

		if (userRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserRegistrationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userRegistration;
	}

	/**
	 * Returns the user registration with the primary key or throws a <code>NoSuchUserRegistrationException</code> if it could not be found.
	 *
	 * @param userRegistrationId the primary key of the user registration
	 * @return the user registration
	 * @throws NoSuchUserRegistrationException if a user registration with the primary key could not be found
	 */
	@Override
	public UserRegistration findByPrimaryKey(long userRegistrationId)
		throws NoSuchUserRegistrationException {

		return findByPrimaryKey((Serializable)userRegistrationId);
	}

	/**
	 * Returns the user registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRegistrationId the primary key of the user registration
	 * @return the user registration, or <code>null</code> if a user registration with the primary key could not be found
	 */
	@Override
	public UserRegistration fetchByPrimaryKey(long userRegistrationId) {
		return fetchByPrimaryKey((Serializable)userRegistrationId);
	}

	/**
	 * Returns all the user registrations.
	 *
	 * @return the user registrations
	 */
	@Override
	public List<UserRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registrations
	 * @param end the upper bound of the range of user registrations (not inclusive)
	 * @return the range of user registrations
	 */
	@Override
	public List<UserRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registrations
	 * @param end the upper bound of the range of user registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user registrations
	 */
	@Override
	public List<UserRegistration> findAll(
		int start, int end,
		OrderByComparator<UserRegistration> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registrations
	 * @param end the upper bound of the range of user registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user registrations
	 */
	@Override
	public List<UserRegistration> findAll(
		int start, int end,
		OrderByComparator<UserRegistration> orderByComparator,
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

		List<UserRegistration> list = null;

		if (useFinderCache) {
			list = (List<UserRegistration>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERREGISTRATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERREGISTRATION;

				sql = sql.concat(UserRegistrationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserRegistration>)QueryUtil.list(
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
	 * Removes all the user registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserRegistration userRegistration : findAll()) {
			remove(userRegistration);
		}
	}

	/**
	 * Returns the number of user registrations.
	 *
	 * @return the number of user registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_USERREGISTRATION);

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
		return "userRegistrationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERREGISTRATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user registration persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new UserRegistrationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", UserRegistration.class.getName()));

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

		_setUserRegistrationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setUserRegistrationUtilPersistence(null);

		entityCache.removeCache(UserRegistrationImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setUserRegistrationUtilPersistence(
		UserRegistrationPersistence userRegistrationPersistence) {

		try {
			Field field = UserRegistrationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, userRegistrationPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MPUPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MPUPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MPUPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_USERREGISTRATION =
		"SELECT userRegistration FROM UserRegistration userRegistration";

	private static final String _SQL_COUNT_USERREGISTRATION =
		"SELECT COUNT(userRegistration) FROM UserRegistration userRegistration";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userRegistration.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserRegistration exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		UserRegistrationPersistenceImpl.class);

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

	private static class UserRegistrationModelArgumentsResolver
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

			UserRegistrationModelImpl userRegistrationModelImpl =
				(UserRegistrationModelImpl)baseModel;

			long columnBitmask = userRegistrationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					userRegistrationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						userRegistrationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					userRegistrationModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			UserRegistrationModelImpl userRegistrationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						userRegistrationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = userRegistrationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}