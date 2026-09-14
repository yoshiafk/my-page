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

import com.mypage.admin.product.exception.NoSuchHealthIndividuPlanException;
import com.mypage.admin.product.model.HealthIndividuPlan;
import com.mypage.admin.product.model.impl.HealthIndividuPlanImpl;
import com.mypage.admin.product.model.impl.HealthIndividuPlanModelImpl;
import com.mypage.admin.product.service.persistence.HealthIndividuPlanPersistence;
import com.mypage.admin.product.service.persistence.HealthIndividuPlanUtil;
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
 * The persistence implementation for the health individu plan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = HealthIndividuPlanPersistence.class)
public class HealthIndividuPlanPersistenceImpl
	extends BasePersistenceImpl<HealthIndividuPlan>
	implements HealthIndividuPlanPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HealthIndividuPlanUtil</code> to access the health individu plan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HealthIndividuPlanImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public HealthIndividuPlanPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(HealthIndividuPlan.class);

		setModelImplClass(HealthIndividuPlanImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the health individu plan in the entity cache if it is enabled.
	 *
	 * @param healthIndividuPlan the health individu plan
	 */
	@Override
	public void cacheResult(HealthIndividuPlan healthIndividuPlan) {
		entityCache.putResult(
			HealthIndividuPlanImpl.class, healthIndividuPlan.getPrimaryKey(),
			healthIndividuPlan);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the health individu plans in the entity cache if it is enabled.
	 *
	 * @param healthIndividuPlans the health individu plans
	 */
	@Override
	public void cacheResult(List<HealthIndividuPlan> healthIndividuPlans) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (healthIndividuPlans.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (HealthIndividuPlan healthIndividuPlan : healthIndividuPlans) {
			if (entityCache.getResult(
					HealthIndividuPlanImpl.class,
					healthIndividuPlan.getPrimaryKey()) == null) {

				cacheResult(healthIndividuPlan);
			}
		}
	}

	/**
	 * Clears the cache for all health individu plans.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HealthIndividuPlanImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the health individu plan.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HealthIndividuPlan healthIndividuPlan) {
		entityCache.removeResult(
			HealthIndividuPlanImpl.class, healthIndividuPlan);
	}

	@Override
	public void clearCache(List<HealthIndividuPlan> healthIndividuPlans) {
		for (HealthIndividuPlan healthIndividuPlan : healthIndividuPlans) {
			entityCache.removeResult(
				HealthIndividuPlanImpl.class, healthIndividuPlan);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(HealthIndividuPlanImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new health individu plan with the primary key. Does not add the health individu plan to the database.
	 *
	 * @param healthIndividuPlanId the primary key for the new health individu plan
	 * @return the new health individu plan
	 */
	@Override
	public HealthIndividuPlan create(long healthIndividuPlanId) {
		HealthIndividuPlan healthIndividuPlan = new HealthIndividuPlanImpl();

		healthIndividuPlan.setNew(true);
		healthIndividuPlan.setPrimaryKey(healthIndividuPlanId);

		healthIndividuPlan.setCompanyId(CompanyThreadLocal.getCompanyId());

		return healthIndividuPlan;
	}

	/**
	 * Removes the health individu plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param healthIndividuPlanId the primary key of the health individu plan
	 * @return the health individu plan that was removed
	 * @throws NoSuchHealthIndividuPlanException if a health individu plan with the primary key could not be found
	 */
	@Override
	public HealthIndividuPlan remove(long healthIndividuPlanId)
		throws NoSuchHealthIndividuPlanException {

		return remove((Serializable)healthIndividuPlanId);
	}

	/**
	 * Removes the health individu plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the health individu plan
	 * @return the health individu plan that was removed
	 * @throws NoSuchHealthIndividuPlanException if a health individu plan with the primary key could not be found
	 */
	@Override
	public HealthIndividuPlan remove(Serializable primaryKey)
		throws NoSuchHealthIndividuPlanException {

		Session session = null;

		try {
			session = openSession();

			HealthIndividuPlan healthIndividuPlan =
				(HealthIndividuPlan)session.get(
					HealthIndividuPlanImpl.class, primaryKey);

			if (healthIndividuPlan == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHealthIndividuPlanException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(healthIndividuPlan);
		}
		catch (NoSuchHealthIndividuPlanException noSuchEntityException) {
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
	protected HealthIndividuPlan removeImpl(
		HealthIndividuPlan healthIndividuPlan) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(healthIndividuPlan)) {
				healthIndividuPlan = (HealthIndividuPlan)session.get(
					HealthIndividuPlanImpl.class,
					healthIndividuPlan.getPrimaryKeyObj());
			}

			if (healthIndividuPlan != null) {
				session.delete(healthIndividuPlan);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (healthIndividuPlan != null) {
			clearCache(healthIndividuPlan);
		}

		return healthIndividuPlan;
	}

	@Override
	public HealthIndividuPlan updateImpl(
		HealthIndividuPlan healthIndividuPlan) {

		boolean isNew = healthIndividuPlan.isNew();

		if (!(healthIndividuPlan instanceof HealthIndividuPlanModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(healthIndividuPlan.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					healthIndividuPlan);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in healthIndividuPlan proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom HealthIndividuPlan implementation " +
					healthIndividuPlan.getClass());
		}

		HealthIndividuPlanModelImpl healthIndividuPlanModelImpl =
			(HealthIndividuPlanModelImpl)healthIndividuPlan;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (healthIndividuPlan.getCreateDate() == null)) {
			if (serviceContext == null) {
				healthIndividuPlan.setCreateDate(date);
			}
			else {
				healthIndividuPlan.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!healthIndividuPlanModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				healthIndividuPlan.setModifiedDate(date);
			}
			else {
				healthIndividuPlan.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(healthIndividuPlan);
			}
			else {
				healthIndividuPlan = (HealthIndividuPlan)session.merge(
					healthIndividuPlan);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			HealthIndividuPlanImpl.class, healthIndividuPlan, false, true);

		if (isNew) {
			healthIndividuPlan.setNew(false);
		}

		healthIndividuPlan.resetOriginalValues();

		return healthIndividuPlan;
	}

	/**
	 * Returns the health individu plan with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the health individu plan
	 * @return the health individu plan
	 * @throws NoSuchHealthIndividuPlanException if a health individu plan with the primary key could not be found
	 */
	@Override
	public HealthIndividuPlan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHealthIndividuPlanException {

		HealthIndividuPlan healthIndividuPlan = fetchByPrimaryKey(primaryKey);

		if (healthIndividuPlan == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHealthIndividuPlanException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return healthIndividuPlan;
	}

	/**
	 * Returns the health individu plan with the primary key or throws a <code>NoSuchHealthIndividuPlanException</code> if it could not be found.
	 *
	 * @param healthIndividuPlanId the primary key of the health individu plan
	 * @return the health individu plan
	 * @throws NoSuchHealthIndividuPlanException if a health individu plan with the primary key could not be found
	 */
	@Override
	public HealthIndividuPlan findByPrimaryKey(long healthIndividuPlanId)
		throws NoSuchHealthIndividuPlanException {

		return findByPrimaryKey((Serializable)healthIndividuPlanId);
	}

	/**
	 * Returns the health individu plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param healthIndividuPlanId the primary key of the health individu plan
	 * @return the health individu plan, or <code>null</code> if a health individu plan with the primary key could not be found
	 */
	@Override
	public HealthIndividuPlan fetchByPrimaryKey(long healthIndividuPlanId) {
		return fetchByPrimaryKey((Serializable)healthIndividuPlanId);
	}

	/**
	 * Returns all the health individu plans.
	 *
	 * @return the health individu plans
	 */
	@Override
	public List<HealthIndividuPlan> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the health individu plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu plans
	 * @param end the upper bound of the range of health individu plans (not inclusive)
	 * @return the range of health individu plans
	 */
	@Override
	public List<HealthIndividuPlan> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the health individu plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu plans
	 * @param end the upper bound of the range of health individu plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of health individu plans
	 */
	@Override
	public List<HealthIndividuPlan> findAll(
		int start, int end,
		OrderByComparator<HealthIndividuPlan> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the health individu plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu plans
	 * @param end the upper bound of the range of health individu plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of health individu plans
	 */
	@Override
	public List<HealthIndividuPlan> findAll(
		int start, int end,
		OrderByComparator<HealthIndividuPlan> orderByComparator,
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

		List<HealthIndividuPlan> list = null;

		if (useFinderCache) {
			list = (List<HealthIndividuPlan>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HEALTHINDIVIDUPLAN);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HEALTHINDIVIDUPLAN;

				sql = sql.concat(HealthIndividuPlanModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<HealthIndividuPlan>)QueryUtil.list(
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
	 * Removes all the health individu plans from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (HealthIndividuPlan healthIndividuPlan : findAll()) {
			remove(healthIndividuPlan);
		}
	}

	/**
	 * Returns the number of health individu plans.
	 *
	 * @return the number of health individu plans
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
					_SQL_COUNT_HEALTHINDIVIDUPLAN);

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
		return "healthIndividuPlanId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_HEALTHINDIVIDUPLAN;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HealthIndividuPlanModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the health individu plan persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new HealthIndividuPlanModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", HealthIndividuPlan.class.getName()));

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

		_setHealthIndividuPlanUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setHealthIndividuPlanUtilPersistence(null);

		entityCache.removeCache(HealthIndividuPlanImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setHealthIndividuPlanUtilPersistence(
		HealthIndividuPlanPersistence healthIndividuPlanPersistence) {

		try {
			Field field = HealthIndividuPlanUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, healthIndividuPlanPersistence);
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

	private static final String _SQL_SELECT_HEALTHINDIVIDUPLAN =
		"SELECT healthIndividuPlan FROM HealthIndividuPlan healthIndividuPlan";

	private static final String _SQL_COUNT_HEALTHINDIVIDUPLAN =
		"SELECT COUNT(healthIndividuPlan) FROM HealthIndividuPlan healthIndividuPlan";

	private static final String _ORDER_BY_ENTITY_ALIAS = "healthIndividuPlan.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No HealthIndividuPlan exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		HealthIndividuPlanPersistenceImpl.class);

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

	private static class HealthIndividuPlanModelArgumentsResolver
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

			HealthIndividuPlanModelImpl healthIndividuPlanModelImpl =
				(HealthIndividuPlanModelImpl)baseModel;

			long columnBitmask = healthIndividuPlanModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					healthIndividuPlanModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						healthIndividuPlanModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					healthIndividuPlanModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			HealthIndividuPlanModelImpl healthIndividuPlanModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						healthIndividuPlanModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = healthIndividuPlanModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}