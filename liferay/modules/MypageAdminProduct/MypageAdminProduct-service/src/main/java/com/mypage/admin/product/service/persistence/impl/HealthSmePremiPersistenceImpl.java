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

import com.mypage.admin.product.exception.NoSuchHealthSmePremiException;
import com.mypage.admin.product.model.HealthSmePremi;
import com.mypage.admin.product.model.impl.HealthSmePremiImpl;
import com.mypage.admin.product.model.impl.HealthSmePremiModelImpl;
import com.mypage.admin.product.service.persistence.HealthSmePremiPersistence;
import com.mypage.admin.product.service.persistence.HealthSmePremiUtil;
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
 * The persistence implementation for the health sme premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = HealthSmePremiPersistence.class)
public class HealthSmePremiPersistenceImpl
	extends BasePersistenceImpl<HealthSmePremi>
	implements HealthSmePremiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HealthSmePremiUtil</code> to access the health sme premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HealthSmePremiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public HealthSmePremiPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(HealthSmePremi.class);

		setModelImplClass(HealthSmePremiImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the health sme premi in the entity cache if it is enabled.
	 *
	 * @param healthSmePremi the health sme premi
	 */
	@Override
	public void cacheResult(HealthSmePremi healthSmePremi) {
		entityCache.putResult(
			HealthSmePremiImpl.class, healthSmePremi.getPrimaryKey(),
			healthSmePremi);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the health sme premis in the entity cache if it is enabled.
	 *
	 * @param healthSmePremis the health sme premis
	 */
	@Override
	public void cacheResult(List<HealthSmePremi> healthSmePremis) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (healthSmePremis.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (HealthSmePremi healthSmePremi : healthSmePremis) {
			if (entityCache.getResult(
					HealthSmePremiImpl.class, healthSmePremi.getPrimaryKey()) ==
						null) {

				cacheResult(healthSmePremi);
			}
		}
	}

	/**
	 * Clears the cache for all health sme premis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HealthSmePremiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the health sme premi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HealthSmePremi healthSmePremi) {
		entityCache.removeResult(HealthSmePremiImpl.class, healthSmePremi);
	}

	@Override
	public void clearCache(List<HealthSmePremi> healthSmePremis) {
		for (HealthSmePremi healthSmePremi : healthSmePremis) {
			entityCache.removeResult(HealthSmePremiImpl.class, healthSmePremi);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(HealthSmePremiImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new health sme premi with the primary key. Does not add the health sme premi to the database.
	 *
	 * @param healthSmePremiId the primary key for the new health sme premi
	 * @return the new health sme premi
	 */
	@Override
	public HealthSmePremi create(long healthSmePremiId) {
		HealthSmePremi healthSmePremi = new HealthSmePremiImpl();

		healthSmePremi.setNew(true);
		healthSmePremi.setPrimaryKey(healthSmePremiId);

		healthSmePremi.setCompanyId(CompanyThreadLocal.getCompanyId());

		return healthSmePremi;
	}

	/**
	 * Removes the health sme premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param healthSmePremiId the primary key of the health sme premi
	 * @return the health sme premi that was removed
	 * @throws NoSuchHealthSmePremiException if a health sme premi with the primary key could not be found
	 */
	@Override
	public HealthSmePremi remove(long healthSmePremiId)
		throws NoSuchHealthSmePremiException {

		return remove((Serializable)healthSmePremiId);
	}

	/**
	 * Removes the health sme premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the health sme premi
	 * @return the health sme premi that was removed
	 * @throws NoSuchHealthSmePremiException if a health sme premi with the primary key could not be found
	 */
	@Override
	public HealthSmePremi remove(Serializable primaryKey)
		throws NoSuchHealthSmePremiException {

		Session session = null;

		try {
			session = openSession();

			HealthSmePremi healthSmePremi = (HealthSmePremi)session.get(
				HealthSmePremiImpl.class, primaryKey);

			if (healthSmePremi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHealthSmePremiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(healthSmePremi);
		}
		catch (NoSuchHealthSmePremiException noSuchEntityException) {
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
	protected HealthSmePremi removeImpl(HealthSmePremi healthSmePremi) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(healthSmePremi)) {
				healthSmePremi = (HealthSmePremi)session.get(
					HealthSmePremiImpl.class,
					healthSmePremi.getPrimaryKeyObj());
			}

			if (healthSmePremi != null) {
				session.delete(healthSmePremi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (healthSmePremi != null) {
			clearCache(healthSmePremi);
		}

		return healthSmePremi;
	}

	@Override
	public HealthSmePremi updateImpl(HealthSmePremi healthSmePremi) {
		boolean isNew = healthSmePremi.isNew();

		if (!(healthSmePremi instanceof HealthSmePremiModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(healthSmePremi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					healthSmePremi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in healthSmePremi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom HealthSmePremi implementation " +
					healthSmePremi.getClass());
		}

		HealthSmePremiModelImpl healthSmePremiModelImpl =
			(HealthSmePremiModelImpl)healthSmePremi;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (healthSmePremi.getCreateDate() == null)) {
			if (serviceContext == null) {
				healthSmePremi.setCreateDate(date);
			}
			else {
				healthSmePremi.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!healthSmePremiModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				healthSmePremi.setModifiedDate(date);
			}
			else {
				healthSmePremi.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(healthSmePremi);
			}
			else {
				healthSmePremi = (HealthSmePremi)session.merge(healthSmePremi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			HealthSmePremiImpl.class, healthSmePremi, false, true);

		if (isNew) {
			healthSmePremi.setNew(false);
		}

		healthSmePremi.resetOriginalValues();

		return healthSmePremi;
	}

	/**
	 * Returns the health sme premi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the health sme premi
	 * @return the health sme premi
	 * @throws NoSuchHealthSmePremiException if a health sme premi with the primary key could not be found
	 */
	@Override
	public HealthSmePremi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHealthSmePremiException {

		HealthSmePremi healthSmePremi = fetchByPrimaryKey(primaryKey);

		if (healthSmePremi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHealthSmePremiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return healthSmePremi;
	}

	/**
	 * Returns the health sme premi with the primary key or throws a <code>NoSuchHealthSmePremiException</code> if it could not be found.
	 *
	 * @param healthSmePremiId the primary key of the health sme premi
	 * @return the health sme premi
	 * @throws NoSuchHealthSmePremiException if a health sme premi with the primary key could not be found
	 */
	@Override
	public HealthSmePremi findByPrimaryKey(long healthSmePremiId)
		throws NoSuchHealthSmePremiException {

		return findByPrimaryKey((Serializable)healthSmePremiId);
	}

	/**
	 * Returns the health sme premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param healthSmePremiId the primary key of the health sme premi
	 * @return the health sme premi, or <code>null</code> if a health sme premi with the primary key could not be found
	 */
	@Override
	public HealthSmePremi fetchByPrimaryKey(long healthSmePremiId) {
		return fetchByPrimaryKey((Serializable)healthSmePremiId);
	}

	/**
	 * Returns all the health sme premis.
	 *
	 * @return the health sme premis
	 */
	@Override
	public List<HealthSmePremi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the health sme premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme premis
	 * @param end the upper bound of the range of health sme premis (not inclusive)
	 * @return the range of health sme premis
	 */
	@Override
	public List<HealthSmePremi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the health sme premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme premis
	 * @param end the upper bound of the range of health sme premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of health sme premis
	 */
	@Override
	public List<HealthSmePremi> findAll(
		int start, int end,
		OrderByComparator<HealthSmePremi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the health sme premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme premis
	 * @param end the upper bound of the range of health sme premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of health sme premis
	 */
	@Override
	public List<HealthSmePremi> findAll(
		int start, int end, OrderByComparator<HealthSmePremi> orderByComparator,
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

		List<HealthSmePremi> list = null;

		if (useFinderCache) {
			list = (List<HealthSmePremi>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HEALTHSMEPREMI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HEALTHSMEPREMI;

				sql = sql.concat(HealthSmePremiModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<HealthSmePremi>)QueryUtil.list(
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
	 * Removes all the health sme premis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (HealthSmePremi healthSmePremi : findAll()) {
			remove(healthSmePremi);
		}
	}

	/**
	 * Returns the number of health sme premis.
	 *
	 * @return the number of health sme premis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_HEALTHSMEPREMI);

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
		return "healthSmePremiId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_HEALTHSMEPREMI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HealthSmePremiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the health sme premi persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new HealthSmePremiModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", HealthSmePremi.class.getName()));

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

		_setHealthSmePremiUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setHealthSmePremiUtilPersistence(null);

		entityCache.removeCache(HealthSmePremiImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setHealthSmePremiUtilPersistence(
		HealthSmePremiPersistence healthSmePremiPersistence) {

		try {
			Field field = HealthSmePremiUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, healthSmePremiPersistence);
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

	private static final String _SQL_SELECT_HEALTHSMEPREMI =
		"SELECT healthSmePremi FROM HealthSmePremi healthSmePremi";

	private static final String _SQL_COUNT_HEALTHSMEPREMI =
		"SELECT COUNT(healthSmePremi) FROM HealthSmePremi healthSmePremi";

	private static final String _ORDER_BY_ENTITY_ALIAS = "healthSmePremi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No HealthSmePremi exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		HealthSmePremiPersistenceImpl.class);

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

	private static class HealthSmePremiModelArgumentsResolver
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

			HealthSmePremiModelImpl healthSmePremiModelImpl =
				(HealthSmePremiModelImpl)baseModel;

			long columnBitmask = healthSmePremiModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					healthSmePremiModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						healthSmePremiModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					healthSmePremiModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			HealthSmePremiModelImpl healthSmePremiModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						healthSmePremiModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = healthSmePremiModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}