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

import com.mypage.admin.product.exception.NoSuchIndustryException;
import com.mypage.admin.product.model.Industry;
import com.mypage.admin.product.model.impl.IndustryImpl;
import com.mypage.admin.product.model.impl.IndustryModelImpl;
import com.mypage.admin.product.service.persistence.IndustryPersistence;
import com.mypage.admin.product.service.persistence.IndustryUtil;
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
 * The persistence implementation for the industry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = IndustryPersistence.class)
public class IndustryPersistenceImpl
	extends BasePersistenceImpl<Industry> implements IndustryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>IndustryUtil</code> to access the industry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		IndustryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public IndustryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Industry.class);

		setModelImplClass(IndustryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the industry in the entity cache if it is enabled.
	 *
	 * @param industry the industry
	 */
	@Override
	public void cacheResult(Industry industry) {
		entityCache.putResult(
			IndustryImpl.class, industry.getPrimaryKey(), industry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the industries in the entity cache if it is enabled.
	 *
	 * @param industries the industries
	 */
	@Override
	public void cacheResult(List<Industry> industries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (industries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Industry industry : industries) {
			if (entityCache.getResult(
					IndustryImpl.class, industry.getPrimaryKey()) == null) {

				cacheResult(industry);
			}
		}
	}

	/**
	 * Clears the cache for all industries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IndustryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the industry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Industry industry) {
		entityCache.removeResult(IndustryImpl.class, industry);
	}

	@Override
	public void clearCache(List<Industry> industries) {
		for (Industry industry : industries) {
			entityCache.removeResult(IndustryImpl.class, industry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(IndustryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new industry with the primary key. Does not add the industry to the database.
	 *
	 * @param industryId the primary key for the new industry
	 * @return the new industry
	 */
	@Override
	public Industry create(long industryId) {
		Industry industry = new IndustryImpl();

		industry.setNew(true);
		industry.setPrimaryKey(industryId);

		industry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return industry;
	}

	/**
	 * Removes the industry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param industryId the primary key of the industry
	 * @return the industry that was removed
	 * @throws NoSuchIndustryException if a industry with the primary key could not be found
	 */
	@Override
	public Industry remove(long industryId) throws NoSuchIndustryException {
		return remove((Serializable)industryId);
	}

	/**
	 * Removes the industry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the industry
	 * @return the industry that was removed
	 * @throws NoSuchIndustryException if a industry with the primary key could not be found
	 */
	@Override
	public Industry remove(Serializable primaryKey)
		throws NoSuchIndustryException {

		Session session = null;

		try {
			session = openSession();

			Industry industry = (Industry)session.get(
				IndustryImpl.class, primaryKey);

			if (industry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIndustryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(industry);
		}
		catch (NoSuchIndustryException noSuchEntityException) {
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
	protected Industry removeImpl(Industry industry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(industry)) {
				industry = (Industry)session.get(
					IndustryImpl.class, industry.getPrimaryKeyObj());
			}

			if (industry != null) {
				session.delete(industry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (industry != null) {
			clearCache(industry);
		}

		return industry;
	}

	@Override
	public Industry updateImpl(Industry industry) {
		boolean isNew = industry.isNew();

		if (!(industry instanceof IndustryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(industry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(industry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in industry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Industry implementation " +
					industry.getClass());
		}

		IndustryModelImpl industryModelImpl = (IndustryModelImpl)industry;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (industry.getCreateDate() == null)) {
			if (serviceContext == null) {
				industry.setCreateDate(date);
			}
			else {
				industry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!industryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				industry.setModifiedDate(date);
			}
			else {
				industry.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(industry);
			}
			else {
				industry = (Industry)session.merge(industry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(IndustryImpl.class, industry, false, true);

		if (isNew) {
			industry.setNew(false);
		}

		industry.resetOriginalValues();

		return industry;
	}

	/**
	 * Returns the industry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the industry
	 * @return the industry
	 * @throws NoSuchIndustryException if a industry with the primary key could not be found
	 */
	@Override
	public Industry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIndustryException {

		Industry industry = fetchByPrimaryKey(primaryKey);

		if (industry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIndustryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return industry;
	}

	/**
	 * Returns the industry with the primary key or throws a <code>NoSuchIndustryException</code> if it could not be found.
	 *
	 * @param industryId the primary key of the industry
	 * @return the industry
	 * @throws NoSuchIndustryException if a industry with the primary key could not be found
	 */
	@Override
	public Industry findByPrimaryKey(long industryId)
		throws NoSuchIndustryException {

		return findByPrimaryKey((Serializable)industryId);
	}

	/**
	 * Returns the industry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param industryId the primary key of the industry
	 * @return the industry, or <code>null</code> if a industry with the primary key could not be found
	 */
	@Override
	public Industry fetchByPrimaryKey(long industryId) {
		return fetchByPrimaryKey((Serializable)industryId);
	}

	/**
	 * Returns all the industries.
	 *
	 * @return the industries
	 */
	@Override
	public List<Industry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the industries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @return the range of industries
	 */
	@Override
	public List<Industry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the industries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of industries
	 */
	@Override
	public List<Industry> findAll(
		int start, int end, OrderByComparator<Industry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the industries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of industries
	 */
	@Override
	public List<Industry> findAll(
		int start, int end, OrderByComparator<Industry> orderByComparator,
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

		List<Industry> list = null;

		if (useFinderCache) {
			list = (List<Industry>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_INDUSTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_INDUSTRY;

				sql = sql.concat(IndustryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Industry>)QueryUtil.list(
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
	 * Removes all the industries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Industry industry : findAll()) {
			remove(industry);
		}
	}

	/**
	 * Returns the number of industries.
	 *
	 * @return the number of industries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_INDUSTRY);

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
		return "industryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_INDUSTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return IndustryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the industry persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new IndustryModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Industry.class.getName()));

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

		_setIndustryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setIndustryUtilPersistence(null);

		entityCache.removeCache(IndustryImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setIndustryUtilPersistence(
		IndustryPersistence industryPersistence) {

		try {
			Field field = IndustryUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, industryPersistence);
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

	private static final String _SQL_SELECT_INDUSTRY =
		"SELECT industry FROM Industry industry";

	private static final String _SQL_COUNT_INDUSTRY =
		"SELECT COUNT(industry) FROM Industry industry";

	private static final String _ORDER_BY_ENTITY_ALIAS = "industry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Industry exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		IndustryPersistenceImpl.class);

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

	private static class IndustryModelArgumentsResolver
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

			IndustryModelImpl industryModelImpl = (IndustryModelImpl)baseModel;

			long columnBitmask = industryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(industryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						industryModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(industryModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			IndustryModelImpl industryModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = industryModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = industryModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}