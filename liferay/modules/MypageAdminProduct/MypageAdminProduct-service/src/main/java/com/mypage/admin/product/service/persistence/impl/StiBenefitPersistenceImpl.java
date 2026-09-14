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

import com.mypage.admin.product.exception.NoSuchStiBenefitException;
import com.mypage.admin.product.model.StiBenefit;
import com.mypage.admin.product.model.impl.StiBenefitImpl;
import com.mypage.admin.product.model.impl.StiBenefitModelImpl;
import com.mypage.admin.product.service.persistence.StiBenefitPersistence;
import com.mypage.admin.product.service.persistence.StiBenefitUtil;
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
 * The persistence implementation for the sti benefit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = StiBenefitPersistence.class)
public class StiBenefitPersistenceImpl
	extends BasePersistenceImpl<StiBenefit> implements StiBenefitPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StiBenefitUtil</code> to access the sti benefit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StiBenefitImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public StiBenefitPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(StiBenefit.class);

		setModelImplClass(StiBenefitImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the sti benefit in the entity cache if it is enabled.
	 *
	 * @param stiBenefit the sti benefit
	 */
	@Override
	public void cacheResult(StiBenefit stiBenefit) {
		entityCache.putResult(
			StiBenefitImpl.class, stiBenefit.getPrimaryKey(), stiBenefit);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sti benefits in the entity cache if it is enabled.
	 *
	 * @param stiBenefits the sti benefits
	 */
	@Override
	public void cacheResult(List<StiBenefit> stiBenefits) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (stiBenefits.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (StiBenefit stiBenefit : stiBenefits) {
			if (entityCache.getResult(
					StiBenefitImpl.class, stiBenefit.getPrimaryKey()) == null) {

				cacheResult(stiBenefit);
			}
		}
	}

	/**
	 * Clears the cache for all sti benefits.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StiBenefitImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sti benefit.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StiBenefit stiBenefit) {
		entityCache.removeResult(StiBenefitImpl.class, stiBenefit);
	}

	@Override
	public void clearCache(List<StiBenefit> stiBenefits) {
		for (StiBenefit stiBenefit : stiBenefits) {
			entityCache.removeResult(StiBenefitImpl.class, stiBenefit);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(StiBenefitImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new sti benefit with the primary key. Does not add the sti benefit to the database.
	 *
	 * @param benefitId the primary key for the new sti benefit
	 * @return the new sti benefit
	 */
	@Override
	public StiBenefit create(long benefitId) {
		StiBenefit stiBenefit = new StiBenefitImpl();

		stiBenefit.setNew(true);
		stiBenefit.setPrimaryKey(benefitId);

		stiBenefit.setCompanyId(CompanyThreadLocal.getCompanyId());

		return stiBenefit;
	}

	/**
	 * Removes the sti benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param benefitId the primary key of the sti benefit
	 * @return the sti benefit that was removed
	 * @throws NoSuchStiBenefitException if a sti benefit with the primary key could not be found
	 */
	@Override
	public StiBenefit remove(long benefitId) throws NoSuchStiBenefitException {
		return remove((Serializable)benefitId);
	}

	/**
	 * Removes the sti benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sti benefit
	 * @return the sti benefit that was removed
	 * @throws NoSuchStiBenefitException if a sti benefit with the primary key could not be found
	 */
	@Override
	public StiBenefit remove(Serializable primaryKey)
		throws NoSuchStiBenefitException {

		Session session = null;

		try {
			session = openSession();

			StiBenefit stiBenefit = (StiBenefit)session.get(
				StiBenefitImpl.class, primaryKey);

			if (stiBenefit == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStiBenefitException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stiBenefit);
		}
		catch (NoSuchStiBenefitException noSuchEntityException) {
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
	protected StiBenefit removeImpl(StiBenefit stiBenefit) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stiBenefit)) {
				stiBenefit = (StiBenefit)session.get(
					StiBenefitImpl.class, stiBenefit.getPrimaryKeyObj());
			}

			if (stiBenefit != null) {
				session.delete(stiBenefit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stiBenefit != null) {
			clearCache(stiBenefit);
		}

		return stiBenefit;
	}

	@Override
	public StiBenefit updateImpl(StiBenefit stiBenefit) {
		boolean isNew = stiBenefit.isNew();

		if (!(stiBenefit instanceof StiBenefitModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stiBenefit.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(stiBenefit);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stiBenefit proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StiBenefit implementation " +
					stiBenefit.getClass());
		}

		StiBenefitModelImpl stiBenefitModelImpl =
			(StiBenefitModelImpl)stiBenefit;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (stiBenefit.getCreateDate() == null)) {
			if (serviceContext == null) {
				stiBenefit.setCreateDate(date);
			}
			else {
				stiBenefit.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!stiBenefitModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				stiBenefit.setModifiedDate(date);
			}
			else {
				stiBenefit.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(stiBenefit);
			}
			else {
				stiBenefit = (StiBenefit)session.merge(stiBenefit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(StiBenefitImpl.class, stiBenefit, false, true);

		if (isNew) {
			stiBenefit.setNew(false);
		}

		stiBenefit.resetOriginalValues();

		return stiBenefit;
	}

	/**
	 * Returns the sti benefit with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sti benefit
	 * @return the sti benefit
	 * @throws NoSuchStiBenefitException if a sti benefit with the primary key could not be found
	 */
	@Override
	public StiBenefit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStiBenefitException {

		StiBenefit stiBenefit = fetchByPrimaryKey(primaryKey);

		if (stiBenefit == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStiBenefitException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stiBenefit;
	}

	/**
	 * Returns the sti benefit with the primary key or throws a <code>NoSuchStiBenefitException</code> if it could not be found.
	 *
	 * @param benefitId the primary key of the sti benefit
	 * @return the sti benefit
	 * @throws NoSuchStiBenefitException if a sti benefit with the primary key could not be found
	 */
	@Override
	public StiBenefit findByPrimaryKey(long benefitId)
		throws NoSuchStiBenefitException {

		return findByPrimaryKey((Serializable)benefitId);
	}

	/**
	 * Returns the sti benefit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param benefitId the primary key of the sti benefit
	 * @return the sti benefit, or <code>null</code> if a sti benefit with the primary key could not be found
	 */
	@Override
	public StiBenefit fetchByPrimaryKey(long benefitId) {
		return fetchByPrimaryKey((Serializable)benefitId);
	}

	/**
	 * Returns all the sti benefits.
	 *
	 * @return the sti benefits
	 */
	@Override
	public List<StiBenefit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sti benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti benefits
	 * @param end the upper bound of the range of sti benefits (not inclusive)
	 * @return the range of sti benefits
	 */
	@Override
	public List<StiBenefit> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sti benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti benefits
	 * @param end the upper bound of the range of sti benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sti benefits
	 */
	@Override
	public List<StiBenefit> findAll(
		int start, int end, OrderByComparator<StiBenefit> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sti benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti benefits
	 * @param end the upper bound of the range of sti benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sti benefits
	 */
	@Override
	public List<StiBenefit> findAll(
		int start, int end, OrderByComparator<StiBenefit> orderByComparator,
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

		List<StiBenefit> list = null;

		if (useFinderCache) {
			list = (List<StiBenefit>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STIBENEFIT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STIBENEFIT;

				sql = sql.concat(StiBenefitModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StiBenefit>)QueryUtil.list(
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
	 * Removes all the sti benefits from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StiBenefit stiBenefit : findAll()) {
			remove(stiBenefit);
		}
	}

	/**
	 * Returns the number of sti benefits.
	 *
	 * @return the number of sti benefits
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STIBENEFIT);

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
		return "benefitId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STIBENEFIT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StiBenefitModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sti benefit persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new StiBenefitModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", StiBenefit.class.getName()));

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

		_setStiBenefitUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setStiBenefitUtilPersistence(null);

		entityCache.removeCache(StiBenefitImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setStiBenefitUtilPersistence(
		StiBenefitPersistence stiBenefitPersistence) {

		try {
			Field field = StiBenefitUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, stiBenefitPersistence);
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

	private static final String _SQL_SELECT_STIBENEFIT =
		"SELECT stiBenefit FROM StiBenefit stiBenefit";

	private static final String _SQL_COUNT_STIBENEFIT =
		"SELECT COUNT(stiBenefit) FROM StiBenefit stiBenefit";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stiBenefit.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StiBenefit exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		StiBenefitPersistenceImpl.class);

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

	private static class StiBenefitModelArgumentsResolver
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

			StiBenefitModelImpl stiBenefitModelImpl =
				(StiBenefitModelImpl)baseModel;

			long columnBitmask = stiBenefitModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(stiBenefitModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						stiBenefitModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(stiBenefitModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			StiBenefitModelImpl stiBenefitModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = stiBenefitModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = stiBenefitModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}