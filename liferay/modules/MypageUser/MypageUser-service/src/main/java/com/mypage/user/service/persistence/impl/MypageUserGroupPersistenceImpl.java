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

import com.mypage.user.exception.NoSuchMypageUserGroupException;
import com.mypage.user.model.MypageUserGroup;
import com.mypage.user.model.impl.MypageUserGroupImpl;
import com.mypage.user.model.impl.MypageUserGroupModelImpl;
import com.mypage.user.service.persistence.MypageUserGroupPersistence;
import com.mypage.user.service.persistence.MypageUserGroupUtil;
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
 * The persistence implementation for the mypage user group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MypageUserGroupPersistence.class)
public class MypageUserGroupPersistenceImpl
	extends BasePersistenceImpl<MypageUserGroup>
	implements MypageUserGroupPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MypageUserGroupUtil</code> to access the mypage user group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MypageUserGroupImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public MypageUserGroupPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MypageUserGroup.class);

		setModelImplClass(MypageUserGroupImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the mypage user group in the entity cache if it is enabled.
	 *
	 * @param mypageUserGroup the mypage user group
	 */
	@Override
	public void cacheResult(MypageUserGroup mypageUserGroup) {
		entityCache.putResult(
			MypageUserGroupImpl.class, mypageUserGroup.getPrimaryKey(),
			mypageUserGroup);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the mypage user groups in the entity cache if it is enabled.
	 *
	 * @param mypageUserGroups the mypage user groups
	 */
	@Override
	public void cacheResult(List<MypageUserGroup> mypageUserGroups) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (mypageUserGroups.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MypageUserGroup mypageUserGroup : mypageUserGroups) {
			if (entityCache.getResult(
					MypageUserGroupImpl.class,
					mypageUserGroup.getPrimaryKey()) == null) {

				cacheResult(mypageUserGroup);
			}
		}
	}

	/**
	 * Clears the cache for all mypage user groups.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MypageUserGroupImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the mypage user group.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MypageUserGroup mypageUserGroup) {
		entityCache.removeResult(MypageUserGroupImpl.class, mypageUserGroup);
	}

	@Override
	public void clearCache(List<MypageUserGroup> mypageUserGroups) {
		for (MypageUserGroup mypageUserGroup : mypageUserGroups) {
			entityCache.removeResult(
				MypageUserGroupImpl.class, mypageUserGroup);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MypageUserGroupImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new mypage user group with the primary key. Does not add the mypage user group to the database.
	 *
	 * @param mypageUserGroupId the primary key for the new mypage user group
	 * @return the new mypage user group
	 */
	@Override
	public MypageUserGroup create(long mypageUserGroupId) {
		MypageUserGroup mypageUserGroup = new MypageUserGroupImpl();

		mypageUserGroup.setNew(true);
		mypageUserGroup.setPrimaryKey(mypageUserGroupId);

		mypageUserGroup.setCompanyId(CompanyThreadLocal.getCompanyId());

		return mypageUserGroup;
	}

	/**
	 * Removes the mypage user group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserGroupId the primary key of the mypage user group
	 * @return the mypage user group that was removed
	 * @throws NoSuchMypageUserGroupException if a mypage user group with the primary key could not be found
	 */
	@Override
	public MypageUserGroup remove(long mypageUserGroupId)
		throws NoSuchMypageUserGroupException {

		return remove((Serializable)mypageUserGroupId);
	}

	/**
	 * Removes the mypage user group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mypage user group
	 * @return the mypage user group that was removed
	 * @throws NoSuchMypageUserGroupException if a mypage user group with the primary key could not be found
	 */
	@Override
	public MypageUserGroup remove(Serializable primaryKey)
		throws NoSuchMypageUserGroupException {

		Session session = null;

		try {
			session = openSession();

			MypageUserGroup mypageUserGroup = (MypageUserGroup)session.get(
				MypageUserGroupImpl.class, primaryKey);

			if (mypageUserGroup == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMypageUserGroupException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(mypageUserGroup);
		}
		catch (NoSuchMypageUserGroupException noSuchEntityException) {
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
	protected MypageUserGroup removeImpl(MypageUserGroup mypageUserGroup) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mypageUserGroup)) {
				mypageUserGroup = (MypageUserGroup)session.get(
					MypageUserGroupImpl.class,
					mypageUserGroup.getPrimaryKeyObj());
			}

			if (mypageUserGroup != null) {
				session.delete(mypageUserGroup);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (mypageUserGroup != null) {
			clearCache(mypageUserGroup);
		}

		return mypageUserGroup;
	}

	@Override
	public MypageUserGroup updateImpl(MypageUserGroup mypageUserGroup) {
		boolean isNew = mypageUserGroup.isNew();

		if (!(mypageUserGroup instanceof MypageUserGroupModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(mypageUserGroup.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					mypageUserGroup);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in mypageUserGroup proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MypageUserGroup implementation " +
					mypageUserGroup.getClass());
		}

		MypageUserGroupModelImpl mypageUserGroupModelImpl =
			(MypageUserGroupModelImpl)mypageUserGroup;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (mypageUserGroup.getCreateDate() == null)) {
			if (serviceContext == null) {
				mypageUserGroup.setCreateDate(date);
			}
			else {
				mypageUserGroup.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!mypageUserGroupModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				mypageUserGroup.setModifiedDate(date);
			}
			else {
				mypageUserGroup.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(mypageUserGroup);
			}
			else {
				mypageUserGroup = (MypageUserGroup)session.merge(
					mypageUserGroup);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MypageUserGroupImpl.class, mypageUserGroup, false, true);

		if (isNew) {
			mypageUserGroup.setNew(false);
		}

		mypageUserGroup.resetOriginalValues();

		return mypageUserGroup;
	}

	/**
	 * Returns the mypage user group with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mypage user group
	 * @return the mypage user group
	 * @throws NoSuchMypageUserGroupException if a mypage user group with the primary key could not be found
	 */
	@Override
	public MypageUserGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMypageUserGroupException {

		MypageUserGroup mypageUserGroup = fetchByPrimaryKey(primaryKey);

		if (mypageUserGroup == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMypageUserGroupException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return mypageUserGroup;
	}

	/**
	 * Returns the mypage user group with the primary key or throws a <code>NoSuchMypageUserGroupException</code> if it could not be found.
	 *
	 * @param mypageUserGroupId the primary key of the mypage user group
	 * @return the mypage user group
	 * @throws NoSuchMypageUserGroupException if a mypage user group with the primary key could not be found
	 */
	@Override
	public MypageUserGroup findByPrimaryKey(long mypageUserGroupId)
		throws NoSuchMypageUserGroupException {

		return findByPrimaryKey((Serializable)mypageUserGroupId);
	}

	/**
	 * Returns the mypage user group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserGroupId the primary key of the mypage user group
	 * @return the mypage user group, or <code>null</code> if a mypage user group with the primary key could not be found
	 */
	@Override
	public MypageUserGroup fetchByPrimaryKey(long mypageUserGroupId) {
		return fetchByPrimaryKey((Serializable)mypageUserGroupId);
	}

	/**
	 * Returns all the mypage user groups.
	 *
	 * @return the mypage user groups
	 */
	@Override
	public List<MypageUserGroup> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mypage user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user groups
	 * @param end the upper bound of the range of mypage user groups (not inclusive)
	 * @return the range of mypage user groups
	 */
	@Override
	public List<MypageUserGroup> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the mypage user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user groups
	 * @param end the upper bound of the range of mypage user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage user groups
	 */
	@Override
	public List<MypageUserGroup> findAll(
		int start, int end,
		OrderByComparator<MypageUserGroup> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mypage user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user groups
	 * @param end the upper bound of the range of mypage user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage user groups
	 */
	@Override
	public List<MypageUserGroup> findAll(
		int start, int end,
		OrderByComparator<MypageUserGroup> orderByComparator,
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

		List<MypageUserGroup> list = null;

		if (useFinderCache) {
			list = (List<MypageUserGroup>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MYPAGEUSERGROUP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MYPAGEUSERGROUP;

				sql = sql.concat(MypageUserGroupModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MypageUserGroup>)QueryUtil.list(
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
	 * Removes all the mypage user groups from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MypageUserGroup mypageUserGroup : findAll()) {
			remove(mypageUserGroup);
		}
	}

	/**
	 * Returns the number of mypage user groups.
	 *
	 * @return the number of mypage user groups
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MYPAGEUSERGROUP);

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
		return "mypageUserGroupId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MYPAGEUSERGROUP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MypageUserGroupModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the mypage user group persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new MypageUserGroupModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MypageUserGroup.class.getName()));

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

		_setMypageUserGroupUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMypageUserGroupUtilPersistence(null);

		entityCache.removeCache(MypageUserGroupImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setMypageUserGroupUtilPersistence(
		MypageUserGroupPersistence mypageUserGroupPersistence) {

		try {
			Field field = MypageUserGroupUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, mypageUserGroupPersistence);
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

	private static final String _SQL_SELECT_MYPAGEUSERGROUP =
		"SELECT mypageUserGroup FROM MypageUserGroup mypageUserGroup";

	private static final String _SQL_COUNT_MYPAGEUSERGROUP =
		"SELECT COUNT(mypageUserGroup) FROM MypageUserGroup mypageUserGroup";

	private static final String _ORDER_BY_ENTITY_ALIAS = "mypageUserGroup.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MypageUserGroup exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		MypageUserGroupPersistenceImpl.class);

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

	private static class MypageUserGroupModelArgumentsResolver
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

			MypageUserGroupModelImpl mypageUserGroupModelImpl =
				(MypageUserGroupModelImpl)baseModel;

			long columnBitmask = mypageUserGroupModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					mypageUserGroupModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						mypageUserGroupModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					mypageUserGroupModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			MypageUserGroupModelImpl mypageUserGroupModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						mypageUserGroupModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = mypageUserGroupModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}