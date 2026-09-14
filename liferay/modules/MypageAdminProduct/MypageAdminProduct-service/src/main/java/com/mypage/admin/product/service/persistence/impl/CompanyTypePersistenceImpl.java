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

import com.mypage.admin.product.exception.NoSuchCompanyTypeException;
import com.mypage.admin.product.model.CompanyType;
import com.mypage.admin.product.model.impl.CompanyTypeImpl;
import com.mypage.admin.product.model.impl.CompanyTypeModelImpl;
import com.mypage.admin.product.service.persistence.CompanyTypePersistence;
import com.mypage.admin.product.service.persistence.CompanyTypeUtil;
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
 * The persistence implementation for the company type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = CompanyTypePersistence.class)
public class CompanyTypePersistenceImpl
	extends BasePersistenceImpl<CompanyType> implements CompanyTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CompanyTypeUtil</code> to access the company type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CompanyTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CompanyTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CompanyType.class);

		setModelImplClass(CompanyTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the company type in the entity cache if it is enabled.
	 *
	 * @param companyType the company type
	 */
	@Override
	public void cacheResult(CompanyType companyType) {
		entityCache.putResult(
			CompanyTypeImpl.class, companyType.getPrimaryKey(), companyType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the company types in the entity cache if it is enabled.
	 *
	 * @param companyTypes the company types
	 */
	@Override
	public void cacheResult(List<CompanyType> companyTypes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (companyTypes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CompanyType companyType : companyTypes) {
			if (entityCache.getResult(
					CompanyTypeImpl.class, companyType.getPrimaryKey()) ==
						null) {

				cacheResult(companyType);
			}
		}
	}

	/**
	 * Clears the cache for all company types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CompanyTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the company type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CompanyType companyType) {
		entityCache.removeResult(CompanyTypeImpl.class, companyType);
	}

	@Override
	public void clearCache(List<CompanyType> companyTypes) {
		for (CompanyType companyType : companyTypes) {
			entityCache.removeResult(CompanyTypeImpl.class, companyType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CompanyTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new company type with the primary key. Does not add the company type to the database.
	 *
	 * @param companyTypeId the primary key for the new company type
	 * @return the new company type
	 */
	@Override
	public CompanyType create(long companyTypeId) {
		CompanyType companyType = new CompanyTypeImpl();

		companyType.setNew(true);
		companyType.setPrimaryKey(companyTypeId);

		companyType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return companyType;
	}

	/**
	 * Removes the company type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param companyTypeId the primary key of the company type
	 * @return the company type that was removed
	 * @throws NoSuchCompanyTypeException if a company type with the primary key could not be found
	 */
	@Override
	public CompanyType remove(long companyTypeId)
		throws NoSuchCompanyTypeException {

		return remove((Serializable)companyTypeId);
	}

	/**
	 * Removes the company type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the company type
	 * @return the company type that was removed
	 * @throws NoSuchCompanyTypeException if a company type with the primary key could not be found
	 */
	@Override
	public CompanyType remove(Serializable primaryKey)
		throws NoSuchCompanyTypeException {

		Session session = null;

		try {
			session = openSession();

			CompanyType companyType = (CompanyType)session.get(
				CompanyTypeImpl.class, primaryKey);

			if (companyType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCompanyTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(companyType);
		}
		catch (NoSuchCompanyTypeException noSuchEntityException) {
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
	protected CompanyType removeImpl(CompanyType companyType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(companyType)) {
				companyType = (CompanyType)session.get(
					CompanyTypeImpl.class, companyType.getPrimaryKeyObj());
			}

			if (companyType != null) {
				session.delete(companyType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (companyType != null) {
			clearCache(companyType);
		}

		return companyType;
	}

	@Override
	public CompanyType updateImpl(CompanyType companyType) {
		boolean isNew = companyType.isNew();

		if (!(companyType instanceof CompanyTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(companyType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(companyType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in companyType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CompanyType implementation " +
					companyType.getClass());
		}

		CompanyTypeModelImpl companyTypeModelImpl =
			(CompanyTypeModelImpl)companyType;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (companyType.getCreateDate() == null)) {
			if (serviceContext == null) {
				companyType.setCreateDate(date);
			}
			else {
				companyType.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!companyTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				companyType.setModifiedDate(date);
			}
			else {
				companyType.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(companyType);
			}
			else {
				companyType = (CompanyType)session.merge(companyType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(CompanyTypeImpl.class, companyType, false, true);

		if (isNew) {
			companyType.setNew(false);
		}

		companyType.resetOriginalValues();

		return companyType;
	}

	/**
	 * Returns the company type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the company type
	 * @return the company type
	 * @throws NoSuchCompanyTypeException if a company type with the primary key could not be found
	 */
	@Override
	public CompanyType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCompanyTypeException {

		CompanyType companyType = fetchByPrimaryKey(primaryKey);

		if (companyType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCompanyTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return companyType;
	}

	/**
	 * Returns the company type with the primary key or throws a <code>NoSuchCompanyTypeException</code> if it could not be found.
	 *
	 * @param companyTypeId the primary key of the company type
	 * @return the company type
	 * @throws NoSuchCompanyTypeException if a company type with the primary key could not be found
	 */
	@Override
	public CompanyType findByPrimaryKey(long companyTypeId)
		throws NoSuchCompanyTypeException {

		return findByPrimaryKey((Serializable)companyTypeId);
	}

	/**
	 * Returns the company type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param companyTypeId the primary key of the company type
	 * @return the company type, or <code>null</code> if a company type with the primary key could not be found
	 */
	@Override
	public CompanyType fetchByPrimaryKey(long companyTypeId) {
		return fetchByPrimaryKey((Serializable)companyTypeId);
	}

	/**
	 * Returns all the company types.
	 *
	 * @return the company types
	 */
	@Override
	public List<CompanyType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the company types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of company types
	 * @param end the upper bound of the range of company types (not inclusive)
	 * @return the range of company types
	 */
	@Override
	public List<CompanyType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the company types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of company types
	 * @param end the upper bound of the range of company types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of company types
	 */
	@Override
	public List<CompanyType> findAll(
		int start, int end, OrderByComparator<CompanyType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the company types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of company types
	 * @param end the upper bound of the range of company types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of company types
	 */
	@Override
	public List<CompanyType> findAll(
		int start, int end, OrderByComparator<CompanyType> orderByComparator,
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

		List<CompanyType> list = null;

		if (useFinderCache) {
			list = (List<CompanyType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COMPANYTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COMPANYTYPE;

				sql = sql.concat(CompanyTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CompanyType>)QueryUtil.list(
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
	 * Removes all the company types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CompanyType companyType : findAll()) {
			remove(companyType);
		}
	}

	/**
	 * Returns the number of company types.
	 *
	 * @return the number of company types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COMPANYTYPE);

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
		return "companyTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COMPANYTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CompanyTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the company type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CompanyTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CompanyType.class.getName()));

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

		_setCompanyTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCompanyTypeUtilPersistence(null);

		entityCache.removeCache(CompanyTypeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setCompanyTypeUtilPersistence(
		CompanyTypePersistence companyTypePersistence) {

		try {
			Field field = CompanyTypeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, companyTypePersistence);
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

	private static final String _SQL_SELECT_COMPANYTYPE =
		"SELECT companyType FROM CompanyType companyType";

	private static final String _SQL_COUNT_COMPANYTYPE =
		"SELECT COUNT(companyType) FROM CompanyType companyType";

	private static final String _ORDER_BY_ENTITY_ALIAS = "companyType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CompanyType exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CompanyTypePersistenceImpl.class);

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

	private static class CompanyTypeModelArgumentsResolver
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

			CompanyTypeModelImpl companyTypeModelImpl =
				(CompanyTypeModelImpl)baseModel;

			long columnBitmask = companyTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(companyTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						companyTypeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(companyTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			CompanyTypeModelImpl companyTypeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = companyTypeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = companyTypeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}