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

import com.mypage.admin.product.exception.NoSuchTravelIntBenefitException;
import com.mypage.admin.product.model.TravelIntBenefit;
import com.mypage.admin.product.model.impl.TravelIntBenefitImpl;
import com.mypage.admin.product.model.impl.TravelIntBenefitModelImpl;
import com.mypage.admin.product.service.persistence.TravelIntBenefitPersistence;
import com.mypage.admin.product.service.persistence.TravelIntBenefitUtil;
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
 * The persistence implementation for the travel int benefit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = TravelIntBenefitPersistence.class)
public class TravelIntBenefitPersistenceImpl
	extends BasePersistenceImpl<TravelIntBenefit>
	implements TravelIntBenefitPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TravelIntBenefitUtil</code> to access the travel int benefit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TravelIntBenefitImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public TravelIntBenefitPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TravelIntBenefit.class);

		setModelImplClass(TravelIntBenefitImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the travel int benefit in the entity cache if it is enabled.
	 *
	 * @param travelIntBenefit the travel int benefit
	 */
	@Override
	public void cacheResult(TravelIntBenefit travelIntBenefit) {
		entityCache.putResult(
			TravelIntBenefitImpl.class, travelIntBenefit.getPrimaryKey(),
			travelIntBenefit);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the travel int benefits in the entity cache if it is enabled.
	 *
	 * @param travelIntBenefits the travel int benefits
	 */
	@Override
	public void cacheResult(List<TravelIntBenefit> travelIntBenefits) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (travelIntBenefits.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TravelIntBenefit travelIntBenefit : travelIntBenefits) {
			if (entityCache.getResult(
					TravelIntBenefitImpl.class,
					travelIntBenefit.getPrimaryKey()) == null) {

				cacheResult(travelIntBenefit);
			}
		}
	}

	/**
	 * Clears the cache for all travel int benefits.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TravelIntBenefitImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the travel int benefit.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TravelIntBenefit travelIntBenefit) {
		entityCache.removeResult(TravelIntBenefitImpl.class, travelIntBenefit);
	}

	@Override
	public void clearCache(List<TravelIntBenefit> travelIntBenefits) {
		for (TravelIntBenefit travelIntBenefit : travelIntBenefits) {
			entityCache.removeResult(
				TravelIntBenefitImpl.class, travelIntBenefit);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TravelIntBenefitImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new travel int benefit with the primary key. Does not add the travel int benefit to the database.
	 *
	 * @param travelIntBenefitId the primary key for the new travel int benefit
	 * @return the new travel int benefit
	 */
	@Override
	public TravelIntBenefit create(long travelIntBenefitId) {
		TravelIntBenefit travelIntBenefit = new TravelIntBenefitImpl();

		travelIntBenefit.setNew(true);
		travelIntBenefit.setPrimaryKey(travelIntBenefitId);

		travelIntBenefit.setCompanyId(CompanyThreadLocal.getCompanyId());

		return travelIntBenefit;
	}

	/**
	 * Removes the travel int benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelIntBenefitId the primary key of the travel int benefit
	 * @return the travel int benefit that was removed
	 * @throws NoSuchTravelIntBenefitException if a travel int benefit with the primary key could not be found
	 */
	@Override
	public TravelIntBenefit remove(long travelIntBenefitId)
		throws NoSuchTravelIntBenefitException {

		return remove((Serializable)travelIntBenefitId);
	}

	/**
	 * Removes the travel int benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the travel int benefit
	 * @return the travel int benefit that was removed
	 * @throws NoSuchTravelIntBenefitException if a travel int benefit with the primary key could not be found
	 */
	@Override
	public TravelIntBenefit remove(Serializable primaryKey)
		throws NoSuchTravelIntBenefitException {

		Session session = null;

		try {
			session = openSession();

			TravelIntBenefit travelIntBenefit = (TravelIntBenefit)session.get(
				TravelIntBenefitImpl.class, primaryKey);

			if (travelIntBenefit == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTravelIntBenefitException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(travelIntBenefit);
		}
		catch (NoSuchTravelIntBenefitException noSuchEntityException) {
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
	protected TravelIntBenefit removeImpl(TravelIntBenefit travelIntBenefit) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(travelIntBenefit)) {
				travelIntBenefit = (TravelIntBenefit)session.get(
					TravelIntBenefitImpl.class,
					travelIntBenefit.getPrimaryKeyObj());
			}

			if (travelIntBenefit != null) {
				session.delete(travelIntBenefit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (travelIntBenefit != null) {
			clearCache(travelIntBenefit);
		}

		return travelIntBenefit;
	}

	@Override
	public TravelIntBenefit updateImpl(TravelIntBenefit travelIntBenefit) {
		boolean isNew = travelIntBenefit.isNew();

		if (!(travelIntBenefit instanceof TravelIntBenefitModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(travelIntBenefit.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					travelIntBenefit);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in travelIntBenefit proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TravelIntBenefit implementation " +
					travelIntBenefit.getClass());
		}

		TravelIntBenefitModelImpl travelIntBenefitModelImpl =
			(TravelIntBenefitModelImpl)travelIntBenefit;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (travelIntBenefit.getCreateDate() == null)) {
			if (serviceContext == null) {
				travelIntBenefit.setCreateDate(date);
			}
			else {
				travelIntBenefit.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!travelIntBenefitModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				travelIntBenefit.setModifiedDate(date);
			}
			else {
				travelIntBenefit.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(travelIntBenefit);
			}
			else {
				travelIntBenefit = (TravelIntBenefit)session.merge(
					travelIntBenefit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TravelIntBenefitImpl.class, travelIntBenefit, false, true);

		if (isNew) {
			travelIntBenefit.setNew(false);
		}

		travelIntBenefit.resetOriginalValues();

		return travelIntBenefit;
	}

	/**
	 * Returns the travel int benefit with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the travel int benefit
	 * @return the travel int benefit
	 * @throws NoSuchTravelIntBenefitException if a travel int benefit with the primary key could not be found
	 */
	@Override
	public TravelIntBenefit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTravelIntBenefitException {

		TravelIntBenefit travelIntBenefit = fetchByPrimaryKey(primaryKey);

		if (travelIntBenefit == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTravelIntBenefitException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return travelIntBenefit;
	}

	/**
	 * Returns the travel int benefit with the primary key or throws a <code>NoSuchTravelIntBenefitException</code> if it could not be found.
	 *
	 * @param travelIntBenefitId the primary key of the travel int benefit
	 * @return the travel int benefit
	 * @throws NoSuchTravelIntBenefitException if a travel int benefit with the primary key could not be found
	 */
	@Override
	public TravelIntBenefit findByPrimaryKey(long travelIntBenefitId)
		throws NoSuchTravelIntBenefitException {

		return findByPrimaryKey((Serializable)travelIntBenefitId);
	}

	/**
	 * Returns the travel int benefit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelIntBenefitId the primary key of the travel int benefit
	 * @return the travel int benefit, or <code>null</code> if a travel int benefit with the primary key could not be found
	 */
	@Override
	public TravelIntBenefit fetchByPrimaryKey(long travelIntBenefitId) {
		return fetchByPrimaryKey((Serializable)travelIntBenefitId);
	}

	/**
	 * Returns all the travel int benefits.
	 *
	 * @return the travel int benefits
	 */
	@Override
	public List<TravelIntBenefit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel int benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefits
	 * @param end the upper bound of the range of travel int benefits (not inclusive)
	 * @return the range of travel int benefits
	 */
	@Override
	public List<TravelIntBenefit> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel int benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefits
	 * @param end the upper bound of the range of travel int benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel int benefits
	 */
	@Override
	public List<TravelIntBenefit> findAll(
		int start, int end,
		OrderByComparator<TravelIntBenefit> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel int benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefits
	 * @param end the upper bound of the range of travel int benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel int benefits
	 */
	@Override
	public List<TravelIntBenefit> findAll(
		int start, int end,
		OrderByComparator<TravelIntBenefit> orderByComparator,
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

		List<TravelIntBenefit> list = null;

		if (useFinderCache) {
			list = (List<TravelIntBenefit>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAVELINTBENEFIT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAVELINTBENEFIT;

				sql = sql.concat(TravelIntBenefitModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TravelIntBenefit>)QueryUtil.list(
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
	 * Removes all the travel int benefits from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TravelIntBenefit travelIntBenefit : findAll()) {
			remove(travelIntBenefit);
		}
	}

	/**
	 * Returns the number of travel int benefits.
	 *
	 * @return the number of travel int benefits
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TRAVELINTBENEFIT);

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
		return "travelIntBenefitId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAVELINTBENEFIT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TravelIntBenefitModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the travel int benefit persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new TravelIntBenefitModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", TravelIntBenefit.class.getName()));

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

		_setTravelIntBenefitUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTravelIntBenefitUtilPersistence(null);

		entityCache.removeCache(TravelIntBenefitImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setTravelIntBenefitUtilPersistence(
		TravelIntBenefitPersistence travelIntBenefitPersistence) {

		try {
			Field field = TravelIntBenefitUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, travelIntBenefitPersistence);
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

	private static final String _SQL_SELECT_TRAVELINTBENEFIT =
		"SELECT travelIntBenefit FROM TravelIntBenefit travelIntBenefit";

	private static final String _SQL_COUNT_TRAVELINTBENEFIT =
		"SELECT COUNT(travelIntBenefit) FROM TravelIntBenefit travelIntBenefit";

	private static final String _ORDER_BY_ENTITY_ALIAS = "travelIntBenefit.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TravelIntBenefit exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		TravelIntBenefitPersistenceImpl.class);

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

	private static class TravelIntBenefitModelArgumentsResolver
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

			TravelIntBenefitModelImpl travelIntBenefitModelImpl =
				(TravelIntBenefitModelImpl)baseModel;

			long columnBitmask = travelIntBenefitModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					travelIntBenefitModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						travelIntBenefitModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					travelIntBenefitModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			TravelIntBenefitModelImpl travelIntBenefitModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						travelIntBenefitModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = travelIntBenefitModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}