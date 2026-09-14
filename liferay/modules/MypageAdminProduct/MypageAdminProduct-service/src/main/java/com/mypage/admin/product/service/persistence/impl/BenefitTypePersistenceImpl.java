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

import com.mypage.admin.product.exception.NoSuchBenefitTypeException;
import com.mypage.admin.product.model.BenefitType;
import com.mypage.admin.product.model.impl.BenefitTypeImpl;
import com.mypage.admin.product.model.impl.BenefitTypeModelImpl;
import com.mypage.admin.product.service.persistence.BenefitTypePersistence;
import com.mypage.admin.product.service.persistence.BenefitTypeUtil;
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
 * The persistence implementation for the benefit type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = BenefitTypePersistence.class)
public class BenefitTypePersistenceImpl
	extends BasePersistenceImpl<BenefitType> implements BenefitTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BenefitTypeUtil</code> to access the benefit type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BenefitTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public BenefitTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(BenefitType.class);

		setModelImplClass(BenefitTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the benefit type in the entity cache if it is enabled.
	 *
	 * @param benefitType the benefit type
	 */
	@Override
	public void cacheResult(BenefitType benefitType) {
		entityCache.putResult(
			BenefitTypeImpl.class, benefitType.getPrimaryKey(), benefitType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the benefit types in the entity cache if it is enabled.
	 *
	 * @param benefitTypes the benefit types
	 */
	@Override
	public void cacheResult(List<BenefitType> benefitTypes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (benefitTypes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BenefitType benefitType : benefitTypes) {
			if (entityCache.getResult(
					BenefitTypeImpl.class, benefitType.getPrimaryKey()) ==
						null) {

				cacheResult(benefitType);
			}
		}
	}

	/**
	 * Clears the cache for all benefit types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BenefitTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the benefit type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BenefitType benefitType) {
		entityCache.removeResult(BenefitTypeImpl.class, benefitType);
	}

	@Override
	public void clearCache(List<BenefitType> benefitTypes) {
		for (BenefitType benefitType : benefitTypes) {
			entityCache.removeResult(BenefitTypeImpl.class, benefitType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BenefitTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new benefit type with the primary key. Does not add the benefit type to the database.
	 *
	 * @param benefitTypeId the primary key for the new benefit type
	 * @return the new benefit type
	 */
	@Override
	public BenefitType create(long benefitTypeId) {
		BenefitType benefitType = new BenefitTypeImpl();

		benefitType.setNew(true);
		benefitType.setPrimaryKey(benefitTypeId);

		benefitType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return benefitType;
	}

	/**
	 * Removes the benefit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param benefitTypeId the primary key of the benefit type
	 * @return the benefit type that was removed
	 * @throws NoSuchBenefitTypeException if a benefit type with the primary key could not be found
	 */
	@Override
	public BenefitType remove(long benefitTypeId)
		throws NoSuchBenefitTypeException {

		return remove((Serializable)benefitTypeId);
	}

	/**
	 * Removes the benefit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the benefit type
	 * @return the benefit type that was removed
	 * @throws NoSuchBenefitTypeException if a benefit type with the primary key could not be found
	 */
	@Override
	public BenefitType remove(Serializable primaryKey)
		throws NoSuchBenefitTypeException {

		Session session = null;

		try {
			session = openSession();

			BenefitType benefitType = (BenefitType)session.get(
				BenefitTypeImpl.class, primaryKey);

			if (benefitType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBenefitTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(benefitType);
		}
		catch (NoSuchBenefitTypeException noSuchEntityException) {
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
	protected BenefitType removeImpl(BenefitType benefitType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(benefitType)) {
				benefitType = (BenefitType)session.get(
					BenefitTypeImpl.class, benefitType.getPrimaryKeyObj());
			}

			if (benefitType != null) {
				session.delete(benefitType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (benefitType != null) {
			clearCache(benefitType);
		}

		return benefitType;
	}

	@Override
	public BenefitType updateImpl(BenefitType benefitType) {
		boolean isNew = benefitType.isNew();

		if (!(benefitType instanceof BenefitTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(benefitType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(benefitType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in benefitType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BenefitType implementation " +
					benefitType.getClass());
		}

		BenefitTypeModelImpl benefitTypeModelImpl =
			(BenefitTypeModelImpl)benefitType;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (benefitType.getCreateDate() == null)) {
			if (serviceContext == null) {
				benefitType.setCreateDate(date);
			}
			else {
				benefitType.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!benefitTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				benefitType.setModifiedDate(date);
			}
			else {
				benefitType.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(benefitType);
			}
			else {
				benefitType = (BenefitType)session.merge(benefitType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(BenefitTypeImpl.class, benefitType, false, true);

		if (isNew) {
			benefitType.setNew(false);
		}

		benefitType.resetOriginalValues();

		return benefitType;
	}

	/**
	 * Returns the benefit type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the benefit type
	 * @return the benefit type
	 * @throws NoSuchBenefitTypeException if a benefit type with the primary key could not be found
	 */
	@Override
	public BenefitType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBenefitTypeException {

		BenefitType benefitType = fetchByPrimaryKey(primaryKey);

		if (benefitType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBenefitTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return benefitType;
	}

	/**
	 * Returns the benefit type with the primary key or throws a <code>NoSuchBenefitTypeException</code> if it could not be found.
	 *
	 * @param benefitTypeId the primary key of the benefit type
	 * @return the benefit type
	 * @throws NoSuchBenefitTypeException if a benefit type with the primary key could not be found
	 */
	@Override
	public BenefitType findByPrimaryKey(long benefitTypeId)
		throws NoSuchBenefitTypeException {

		return findByPrimaryKey((Serializable)benefitTypeId);
	}

	/**
	 * Returns the benefit type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param benefitTypeId the primary key of the benefit type
	 * @return the benefit type, or <code>null</code> if a benefit type with the primary key could not be found
	 */
	@Override
	public BenefitType fetchByPrimaryKey(long benefitTypeId) {
		return fetchByPrimaryKey((Serializable)benefitTypeId);
	}

	/**
	 * Returns all the benefit types.
	 *
	 * @return the benefit types
	 */
	@Override
	public List<BenefitType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the benefit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit types
	 * @param end the upper bound of the range of benefit types (not inclusive)
	 * @return the range of benefit types
	 */
	@Override
	public List<BenefitType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the benefit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit types
	 * @param end the upper bound of the range of benefit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of benefit types
	 */
	@Override
	public List<BenefitType> findAll(
		int start, int end, OrderByComparator<BenefitType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the benefit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit types
	 * @param end the upper bound of the range of benefit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of benefit types
	 */
	@Override
	public List<BenefitType> findAll(
		int start, int end, OrderByComparator<BenefitType> orderByComparator,
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

		List<BenefitType> list = null;

		if (useFinderCache) {
			list = (List<BenefitType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BENEFITTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BENEFITTYPE;

				sql = sql.concat(BenefitTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BenefitType>)QueryUtil.list(
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
	 * Removes all the benefit types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BenefitType benefitType : findAll()) {
			remove(benefitType);
		}
	}

	/**
	 * Returns the number of benefit types.
	 *
	 * @return the number of benefit types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BENEFITTYPE);

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
		return "benefitTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BENEFITTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BenefitTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the benefit type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new BenefitTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", BenefitType.class.getName()));

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

		_setBenefitTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBenefitTypeUtilPersistence(null);

		entityCache.removeCache(BenefitTypeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setBenefitTypeUtilPersistence(
		BenefitTypePersistence benefitTypePersistence) {

		try {
			Field field = BenefitTypeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, benefitTypePersistence);
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

	private static final String _SQL_SELECT_BENEFITTYPE =
		"SELECT benefitType FROM BenefitType benefitType";

	private static final String _SQL_COUNT_BENEFITTYPE =
		"SELECT COUNT(benefitType) FROM BenefitType benefitType";

	private static final String _ORDER_BY_ENTITY_ALIAS = "benefitType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BenefitType exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		BenefitTypePersistenceImpl.class);

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

	private static class BenefitTypeModelArgumentsResolver
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

			BenefitTypeModelImpl benefitTypeModelImpl =
				(BenefitTypeModelImpl)baseModel;

			long columnBitmask = benefitTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(benefitTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						benefitTypeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(benefitTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			BenefitTypeModelImpl benefitTypeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = benefitTypeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = benefitTypeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}