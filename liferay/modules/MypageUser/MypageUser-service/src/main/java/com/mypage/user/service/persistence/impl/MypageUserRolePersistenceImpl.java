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

import com.mypage.user.exception.NoSuchMypageUserRoleException;
import com.mypage.user.model.MypageUserRole;
import com.mypage.user.model.impl.MypageUserRoleImpl;
import com.mypage.user.model.impl.MypageUserRoleModelImpl;
import com.mypage.user.service.persistence.MypageUserRolePersistence;
import com.mypage.user.service.persistence.MypageUserRoleUtil;
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
 * The persistence implementation for the mypage user role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MypageUserRolePersistence.class)
public class MypageUserRolePersistenceImpl
	extends BasePersistenceImpl<MypageUserRole>
	implements MypageUserRolePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MypageUserRoleUtil</code> to access the mypage user role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MypageUserRoleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public MypageUserRolePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MypageUserRole.class);

		setModelImplClass(MypageUserRoleImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the mypage user role in the entity cache if it is enabled.
	 *
	 * @param mypageUserRole the mypage user role
	 */
	@Override
	public void cacheResult(MypageUserRole mypageUserRole) {
		entityCache.putResult(
			MypageUserRoleImpl.class, mypageUserRole.getPrimaryKey(),
			mypageUserRole);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the mypage user roles in the entity cache if it is enabled.
	 *
	 * @param mypageUserRoles the mypage user roles
	 */
	@Override
	public void cacheResult(List<MypageUserRole> mypageUserRoles) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (mypageUserRoles.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MypageUserRole mypageUserRole : mypageUserRoles) {
			if (entityCache.getResult(
					MypageUserRoleImpl.class, mypageUserRole.getPrimaryKey()) ==
						null) {

				cacheResult(mypageUserRole);
			}
		}
	}

	/**
	 * Clears the cache for all mypage user roles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MypageUserRoleImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the mypage user role.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MypageUserRole mypageUserRole) {
		entityCache.removeResult(MypageUserRoleImpl.class, mypageUserRole);
	}

	@Override
	public void clearCache(List<MypageUserRole> mypageUserRoles) {
		for (MypageUserRole mypageUserRole : mypageUserRoles) {
			entityCache.removeResult(MypageUserRoleImpl.class, mypageUserRole);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MypageUserRoleImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new mypage user role with the primary key. Does not add the mypage user role to the database.
	 *
	 * @param mypageUserRoleId the primary key for the new mypage user role
	 * @return the new mypage user role
	 */
	@Override
	public MypageUserRole create(long mypageUserRoleId) {
		MypageUserRole mypageUserRole = new MypageUserRoleImpl();

		mypageUserRole.setNew(true);
		mypageUserRole.setPrimaryKey(mypageUserRoleId);

		mypageUserRole.setCompanyId(CompanyThreadLocal.getCompanyId());

		return mypageUserRole;
	}

	/**
	 * Removes the mypage user role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserRoleId the primary key of the mypage user role
	 * @return the mypage user role that was removed
	 * @throws NoSuchMypageUserRoleException if a mypage user role with the primary key could not be found
	 */
	@Override
	public MypageUserRole remove(long mypageUserRoleId)
		throws NoSuchMypageUserRoleException {

		return remove((Serializable)mypageUserRoleId);
	}

	/**
	 * Removes the mypage user role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mypage user role
	 * @return the mypage user role that was removed
	 * @throws NoSuchMypageUserRoleException if a mypage user role with the primary key could not be found
	 */
	@Override
	public MypageUserRole remove(Serializable primaryKey)
		throws NoSuchMypageUserRoleException {

		Session session = null;

		try {
			session = openSession();

			MypageUserRole mypageUserRole = (MypageUserRole)session.get(
				MypageUserRoleImpl.class, primaryKey);

			if (mypageUserRole == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMypageUserRoleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(mypageUserRole);
		}
		catch (NoSuchMypageUserRoleException noSuchEntityException) {
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
	protected MypageUserRole removeImpl(MypageUserRole mypageUserRole) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mypageUserRole)) {
				mypageUserRole = (MypageUserRole)session.get(
					MypageUserRoleImpl.class,
					mypageUserRole.getPrimaryKeyObj());
			}

			if (mypageUserRole != null) {
				session.delete(mypageUserRole);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (mypageUserRole != null) {
			clearCache(mypageUserRole);
		}

		return mypageUserRole;
	}

	@Override
	public MypageUserRole updateImpl(MypageUserRole mypageUserRole) {
		boolean isNew = mypageUserRole.isNew();

		if (!(mypageUserRole instanceof MypageUserRoleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(mypageUserRole.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					mypageUserRole);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in mypageUserRole proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MypageUserRole implementation " +
					mypageUserRole.getClass());
		}

		MypageUserRoleModelImpl mypageUserRoleModelImpl =
			(MypageUserRoleModelImpl)mypageUserRole;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (mypageUserRole.getCreateDate() == null)) {
			if (serviceContext == null) {
				mypageUserRole.setCreateDate(date);
			}
			else {
				mypageUserRole.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!mypageUserRoleModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				mypageUserRole.setModifiedDate(date);
			}
			else {
				mypageUserRole.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(mypageUserRole);
			}
			else {
				mypageUserRole = (MypageUserRole)session.merge(mypageUserRole);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MypageUserRoleImpl.class, mypageUserRole, false, true);

		if (isNew) {
			mypageUserRole.setNew(false);
		}

		mypageUserRole.resetOriginalValues();

		return mypageUserRole;
	}

	/**
	 * Returns the mypage user role with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mypage user role
	 * @return the mypage user role
	 * @throws NoSuchMypageUserRoleException if a mypage user role with the primary key could not be found
	 */
	@Override
	public MypageUserRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMypageUserRoleException {

		MypageUserRole mypageUserRole = fetchByPrimaryKey(primaryKey);

		if (mypageUserRole == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMypageUserRoleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return mypageUserRole;
	}

	/**
	 * Returns the mypage user role with the primary key or throws a <code>NoSuchMypageUserRoleException</code> if it could not be found.
	 *
	 * @param mypageUserRoleId the primary key of the mypage user role
	 * @return the mypage user role
	 * @throws NoSuchMypageUserRoleException if a mypage user role with the primary key could not be found
	 */
	@Override
	public MypageUserRole findByPrimaryKey(long mypageUserRoleId)
		throws NoSuchMypageUserRoleException {

		return findByPrimaryKey((Serializable)mypageUserRoleId);
	}

	/**
	 * Returns the mypage user role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserRoleId the primary key of the mypage user role
	 * @return the mypage user role, or <code>null</code> if a mypage user role with the primary key could not be found
	 */
	@Override
	public MypageUserRole fetchByPrimaryKey(long mypageUserRoleId) {
		return fetchByPrimaryKey((Serializable)mypageUserRoleId);
	}

	/**
	 * Returns all the mypage user roles.
	 *
	 * @return the mypage user roles
	 */
	@Override
	public List<MypageUserRole> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mypage user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user roles
	 * @param end the upper bound of the range of mypage user roles (not inclusive)
	 * @return the range of mypage user roles
	 */
	@Override
	public List<MypageUserRole> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the mypage user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user roles
	 * @param end the upper bound of the range of mypage user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage user roles
	 */
	@Override
	public List<MypageUserRole> findAll(
		int start, int end,
		OrderByComparator<MypageUserRole> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mypage user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user roles
	 * @param end the upper bound of the range of mypage user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage user roles
	 */
	@Override
	public List<MypageUserRole> findAll(
		int start, int end, OrderByComparator<MypageUserRole> orderByComparator,
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

		List<MypageUserRole> list = null;

		if (useFinderCache) {
			list = (List<MypageUserRole>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MYPAGEUSERROLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MYPAGEUSERROLE;

				sql = sql.concat(MypageUserRoleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MypageUserRole>)QueryUtil.list(
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
	 * Removes all the mypage user roles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MypageUserRole mypageUserRole : findAll()) {
			remove(mypageUserRole);
		}
	}

	/**
	 * Returns the number of mypage user roles.
	 *
	 * @return the number of mypage user roles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MYPAGEUSERROLE);

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
		return "mypageUserRoleId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MYPAGEUSERROLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MypageUserRoleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the mypage user role persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new MypageUserRoleModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MypageUserRole.class.getName()));

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

		_setMypageUserRoleUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMypageUserRoleUtilPersistence(null);

		entityCache.removeCache(MypageUserRoleImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setMypageUserRoleUtilPersistence(
		MypageUserRolePersistence mypageUserRolePersistence) {

		try {
			Field field = MypageUserRoleUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, mypageUserRolePersistence);
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

	private static final String _SQL_SELECT_MYPAGEUSERROLE =
		"SELECT mypageUserRole FROM MypageUserRole mypageUserRole";

	private static final String _SQL_COUNT_MYPAGEUSERROLE =
		"SELECT COUNT(mypageUserRole) FROM MypageUserRole mypageUserRole";

	private static final String _ORDER_BY_ENTITY_ALIAS = "mypageUserRole.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MypageUserRole exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		MypageUserRolePersistenceImpl.class);

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

	private static class MypageUserRoleModelArgumentsResolver
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

			MypageUserRoleModelImpl mypageUserRoleModelImpl =
				(MypageUserRoleModelImpl)baseModel;

			long columnBitmask = mypageUserRoleModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					mypageUserRoleModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						mypageUserRoleModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					mypageUserRoleModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			MypageUserRoleModelImpl mypageUserRoleModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						mypageUserRoleModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = mypageUserRoleModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}