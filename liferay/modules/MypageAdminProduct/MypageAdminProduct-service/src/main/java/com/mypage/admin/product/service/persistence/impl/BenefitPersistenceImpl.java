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

import com.mypage.admin.product.exception.NoSuchBenefitException;
import com.mypage.admin.product.model.Benefit;
import com.mypage.admin.product.model.impl.BenefitImpl;
import com.mypage.admin.product.model.impl.BenefitModelImpl;
import com.mypage.admin.product.service.persistence.BenefitPersistence;
import com.mypage.admin.product.service.persistence.BenefitUtil;
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
 * The persistence implementation for the benefit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = BenefitPersistence.class)
public class BenefitPersistenceImpl
	extends BasePersistenceImpl<Benefit> implements BenefitPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BenefitUtil</code> to access the benefit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BenefitImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public BenefitPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Benefit.class);

		setModelImplClass(BenefitImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the benefit in the entity cache if it is enabled.
	 *
	 * @param benefit the benefit
	 */
	@Override
	public void cacheResult(Benefit benefit) {
		entityCache.putResult(
			BenefitImpl.class, benefit.getPrimaryKey(), benefit);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the benefits in the entity cache if it is enabled.
	 *
	 * @param benefits the benefits
	 */
	@Override
	public void cacheResult(List<Benefit> benefits) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (benefits.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Benefit benefit : benefits) {
			if (entityCache.getResult(
					BenefitImpl.class, benefit.getPrimaryKey()) == null) {

				cacheResult(benefit);
			}
		}
	}

	/**
	 * Clears the cache for all benefits.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BenefitImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the benefit.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Benefit benefit) {
		entityCache.removeResult(BenefitImpl.class, benefit);
	}

	@Override
	public void clearCache(List<Benefit> benefits) {
		for (Benefit benefit : benefits) {
			entityCache.removeResult(BenefitImpl.class, benefit);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BenefitImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new benefit with the primary key. Does not add the benefit to the database.
	 *
	 * @param benefitId the primary key for the new benefit
	 * @return the new benefit
	 */
	@Override
	public Benefit create(long benefitId) {
		Benefit benefit = new BenefitImpl();

		benefit.setNew(true);
		benefit.setPrimaryKey(benefitId);

		benefit.setCompanyId(CompanyThreadLocal.getCompanyId());

		return benefit;
	}

	/**
	 * Removes the benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param benefitId the primary key of the benefit
	 * @return the benefit that was removed
	 * @throws NoSuchBenefitException if a benefit with the primary key could not be found
	 */
	@Override
	public Benefit remove(long benefitId) throws NoSuchBenefitException {
		return remove((Serializable)benefitId);
	}

	/**
	 * Removes the benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the benefit
	 * @return the benefit that was removed
	 * @throws NoSuchBenefitException if a benefit with the primary key could not be found
	 */
	@Override
	public Benefit remove(Serializable primaryKey)
		throws NoSuchBenefitException {

		Session session = null;

		try {
			session = openSession();

			Benefit benefit = (Benefit)session.get(
				BenefitImpl.class, primaryKey);

			if (benefit == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBenefitException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(benefit);
		}
		catch (NoSuchBenefitException noSuchEntityException) {
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
	protected Benefit removeImpl(Benefit benefit) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(benefit)) {
				benefit = (Benefit)session.get(
					BenefitImpl.class, benefit.getPrimaryKeyObj());
			}

			if (benefit != null) {
				session.delete(benefit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (benefit != null) {
			clearCache(benefit);
		}

		return benefit;
	}

	@Override
	public Benefit updateImpl(Benefit benefit) {
		boolean isNew = benefit.isNew();

		if (!(benefit instanceof BenefitModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(benefit.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(benefit);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in benefit proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Benefit implementation " +
					benefit.getClass());
		}

		BenefitModelImpl benefitModelImpl = (BenefitModelImpl)benefit;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (benefit.getCreateDate() == null)) {
			if (serviceContext == null) {
				benefit.setCreateDate(date);
			}
			else {
				benefit.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!benefitModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				benefit.setModifiedDate(date);
			}
			else {
				benefit.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(benefit);
			}
			else {
				benefit = (Benefit)session.merge(benefit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(BenefitImpl.class, benefit, false, true);

		if (isNew) {
			benefit.setNew(false);
		}

		benefit.resetOriginalValues();

		return benefit;
	}

	/**
	 * Returns the benefit with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the benefit
	 * @return the benefit
	 * @throws NoSuchBenefitException if a benefit with the primary key could not be found
	 */
	@Override
	public Benefit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBenefitException {

		Benefit benefit = fetchByPrimaryKey(primaryKey);

		if (benefit == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBenefitException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return benefit;
	}

	/**
	 * Returns the benefit with the primary key or throws a <code>NoSuchBenefitException</code> if it could not be found.
	 *
	 * @param benefitId the primary key of the benefit
	 * @return the benefit
	 * @throws NoSuchBenefitException if a benefit with the primary key could not be found
	 */
	@Override
	public Benefit findByPrimaryKey(long benefitId)
		throws NoSuchBenefitException {

		return findByPrimaryKey((Serializable)benefitId);
	}

	/**
	 * Returns the benefit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param benefitId the primary key of the benefit
	 * @return the benefit, or <code>null</code> if a benefit with the primary key could not be found
	 */
	@Override
	public Benefit fetchByPrimaryKey(long benefitId) {
		return fetchByPrimaryKey((Serializable)benefitId);
	}

	/**
	 * Returns all the benefits.
	 *
	 * @return the benefits
	 */
	@Override
	public List<Benefit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefits
	 * @param end the upper bound of the range of benefits (not inclusive)
	 * @return the range of benefits
	 */
	@Override
	public List<Benefit> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefits
	 * @param end the upper bound of the range of benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of benefits
	 */
	@Override
	public List<Benefit> findAll(
		int start, int end, OrderByComparator<Benefit> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefits
	 * @param end the upper bound of the range of benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of benefits
	 */
	@Override
	public List<Benefit> findAll(
		int start, int end, OrderByComparator<Benefit> orderByComparator,
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

		List<Benefit> list = null;

		if (useFinderCache) {
			list = (List<Benefit>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BENEFIT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BENEFIT;

				sql = sql.concat(BenefitModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Benefit>)QueryUtil.list(
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
	 * Removes all the benefits from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Benefit benefit : findAll()) {
			remove(benefit);
		}
	}

	/**
	 * Returns the number of benefits.
	 *
	 * @return the number of benefits
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BENEFIT);

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
		return _SQL_SELECT_BENEFIT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BenefitModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the benefit persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new BenefitModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Benefit.class.getName()));

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

		_setBenefitUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBenefitUtilPersistence(null);

		entityCache.removeCache(BenefitImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setBenefitUtilPersistence(
		BenefitPersistence benefitPersistence) {

		try {
			Field field = BenefitUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, benefitPersistence);
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

	private static final String _SQL_SELECT_BENEFIT =
		"SELECT benefit FROM Benefit benefit";

	private static final String _SQL_COUNT_BENEFIT =
		"SELECT COUNT(benefit) FROM Benefit benefit";

	private static final String _ORDER_BY_ENTITY_ALIAS = "benefit.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Benefit exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		BenefitPersistenceImpl.class);

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

	private static class BenefitModelArgumentsResolver
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

			BenefitModelImpl benefitModelImpl = (BenefitModelImpl)baseModel;

			long columnBitmask = benefitModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(benefitModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						benefitModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(benefitModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			BenefitModelImpl benefitModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = benefitModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = benefitModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}