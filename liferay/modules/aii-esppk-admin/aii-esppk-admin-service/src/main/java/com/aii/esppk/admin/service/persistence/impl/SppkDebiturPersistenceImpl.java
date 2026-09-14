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

package com.aii.esppk.admin.service.persistence.impl;

import com.aii.esppk.admin.exception.NoSuchSppkDebiturException;
import com.aii.esppk.admin.model.SppkDebitur;
import com.aii.esppk.admin.model.impl.SppkDebiturImpl;
import com.aii.esppk.admin.model.impl.SppkDebiturModelImpl;
import com.aii.esppk.admin.service.persistence.SppkDebiturPersistence;
import com.aii.esppk.admin.service.persistence.SppkDebiturUtil;
import com.aii.esppk.admin.service.persistence.impl.constants.MSPPKPersistenceConstants;

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

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
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
 * The persistence implementation for the sppk debitur service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @generated
 */
@Component(service = SppkDebiturPersistence.class)
public class SppkDebiturPersistenceImpl
	extends BasePersistenceImpl<SppkDebitur> implements SppkDebiturPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SppkDebiturUtil</code> to access the sppk debitur persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SppkDebiturImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SppkDebiturPersistenceImpl() {
		setModelClass(SppkDebitur.class);

		setModelImplClass(SppkDebiturImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the sppk debitur in the entity cache if it is enabled.
	 *
	 * @param sppkDebitur the sppk debitur
	 */
	@Override
	public void cacheResult(SppkDebitur sppkDebitur) {
		entityCache.putResult(
			SppkDebiturImpl.class, sppkDebitur.getPrimaryKey(), sppkDebitur);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sppk debiturs in the entity cache if it is enabled.
	 *
	 * @param sppkDebiturs the sppk debiturs
	 */
	@Override
	public void cacheResult(List<SppkDebitur> sppkDebiturs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (sppkDebiturs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SppkDebitur sppkDebitur : sppkDebiturs) {
			if (entityCache.getResult(
					SppkDebiturImpl.class, sppkDebitur.getPrimaryKey()) ==
						null) {

				cacheResult(sppkDebitur);
			}
		}
	}

	/**
	 * Clears the cache for all sppk debiturs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SppkDebiturImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sppk debitur.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SppkDebitur sppkDebitur) {
		entityCache.removeResult(SppkDebiturImpl.class, sppkDebitur);
	}

	@Override
	public void clearCache(List<SppkDebitur> sppkDebiturs) {
		for (SppkDebitur sppkDebitur : sppkDebiturs) {
			entityCache.removeResult(SppkDebiturImpl.class, sppkDebitur);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SppkDebiturImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new sppk debitur with the primary key. Does not add the sppk debitur to the database.
	 *
	 * @param sppkDebiturId the primary key for the new sppk debitur
	 * @return the new sppk debitur
	 */
	@Override
	public SppkDebitur create(long sppkDebiturId) {
		SppkDebitur sppkDebitur = new SppkDebiturImpl();

		sppkDebitur.setNew(true);
		sppkDebitur.setPrimaryKey(sppkDebiturId);

		sppkDebitur.setCompanyId(CompanyThreadLocal.getCompanyId());

		return sppkDebitur;
	}

	/**
	 * Removes the sppk debitur with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sppkDebiturId the primary key of the sppk debitur
	 * @return the sppk debitur that was removed
	 * @throws NoSuchSppkDebiturException if a sppk debitur with the primary key could not be found
	 */
	@Override
	public SppkDebitur remove(long sppkDebiturId)
		throws NoSuchSppkDebiturException {

		return remove((Serializable)sppkDebiturId);
	}

	/**
	 * Removes the sppk debitur with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sppk debitur
	 * @return the sppk debitur that was removed
	 * @throws NoSuchSppkDebiturException if a sppk debitur with the primary key could not be found
	 */
	@Override
	public SppkDebitur remove(Serializable primaryKey)
		throws NoSuchSppkDebiturException {

		Session session = null;

		try {
			session = openSession();

			SppkDebitur sppkDebitur = (SppkDebitur)session.get(
				SppkDebiturImpl.class, primaryKey);

			if (sppkDebitur == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSppkDebiturException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(sppkDebitur);
		}
		catch (NoSuchSppkDebiturException noSuchEntityException) {
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
	protected SppkDebitur removeImpl(SppkDebitur sppkDebitur) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sppkDebitur)) {
				sppkDebitur = (SppkDebitur)session.get(
					SppkDebiturImpl.class, sppkDebitur.getPrimaryKeyObj());
			}

			if (sppkDebitur != null) {
				session.delete(sppkDebitur);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (sppkDebitur != null) {
			clearCache(sppkDebitur);
		}

		return sppkDebitur;
	}

	@Override
	public SppkDebitur updateImpl(SppkDebitur sppkDebitur) {
		boolean isNew = sppkDebitur.isNew();

		if (!(sppkDebitur instanceof SppkDebiturModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(sppkDebitur.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(sppkDebitur);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in sppkDebitur proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SppkDebitur implementation " +
					sppkDebitur.getClass());
		}

		SppkDebiturModelImpl sppkDebiturModelImpl =
			(SppkDebiturModelImpl)sppkDebitur;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (sppkDebitur.getCreateDate() == null)) {
			if (serviceContext == null) {
				sppkDebitur.setCreateDate(date);
			}
			else {
				sppkDebitur.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!sppkDebiturModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				sppkDebitur.setModifiedDate(date);
			}
			else {
				sppkDebitur.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(sppkDebitur);
			}
			else {
				sppkDebitur = (SppkDebitur)session.merge(sppkDebitur);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(SppkDebiturImpl.class, sppkDebitur, false, true);

		if (isNew) {
			sppkDebitur.setNew(false);
		}

		sppkDebitur.resetOriginalValues();

		return sppkDebitur;
	}

	/**
	 * Returns the sppk debitur with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sppk debitur
	 * @return the sppk debitur
	 * @throws NoSuchSppkDebiturException if a sppk debitur with the primary key could not be found
	 */
	@Override
	public SppkDebitur findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSppkDebiturException {

		SppkDebitur sppkDebitur = fetchByPrimaryKey(primaryKey);

		if (sppkDebitur == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSppkDebiturException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return sppkDebitur;
	}

	/**
	 * Returns the sppk debitur with the primary key or throws a <code>NoSuchSppkDebiturException</code> if it could not be found.
	 *
	 * @param sppkDebiturId the primary key of the sppk debitur
	 * @return the sppk debitur
	 * @throws NoSuchSppkDebiturException if a sppk debitur with the primary key could not be found
	 */
	@Override
	public SppkDebitur findByPrimaryKey(long sppkDebiturId)
		throws NoSuchSppkDebiturException {

		return findByPrimaryKey((Serializable)sppkDebiturId);
	}

	/**
	 * Returns the sppk debitur with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sppkDebiturId the primary key of the sppk debitur
	 * @return the sppk debitur, or <code>null</code> if a sppk debitur with the primary key could not be found
	 */
	@Override
	public SppkDebitur fetchByPrimaryKey(long sppkDebiturId) {
		return fetchByPrimaryKey((Serializable)sppkDebiturId);
	}

	/**
	 * Returns all the sppk debiturs.
	 *
	 * @return the sppk debiturs
	 */
	@Override
	public List<SppkDebitur> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sppk debiturs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkDebiturModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sppk debiturs
	 * @param end the upper bound of the range of sppk debiturs (not inclusive)
	 * @return the range of sppk debiturs
	 */
	@Override
	public List<SppkDebitur> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sppk debiturs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkDebiturModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sppk debiturs
	 * @param end the upper bound of the range of sppk debiturs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sppk debiturs
	 */
	@Override
	public List<SppkDebitur> findAll(
		int start, int end, OrderByComparator<SppkDebitur> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sppk debiturs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkDebiturModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sppk debiturs
	 * @param end the upper bound of the range of sppk debiturs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sppk debiturs
	 */
	@Override
	public List<SppkDebitur> findAll(
		int start, int end, OrderByComparator<SppkDebitur> orderByComparator,
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

		List<SppkDebitur> list = null;

		if (useFinderCache) {
			list = (List<SppkDebitur>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SPPKDEBITUR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SPPKDEBITUR;

				sql = sql.concat(SppkDebiturModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SppkDebitur>)QueryUtil.list(
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
	 * Removes all the sppk debiturs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SppkDebitur sppkDebitur : findAll()) {
			remove(sppkDebitur);
		}
	}

	/**
	 * Returns the number of sppk debiturs.
	 *
	 * @return the number of sppk debiturs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SPPKDEBITUR);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "sppkDebiturId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SPPKDEBITUR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SppkDebiturModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sppk debitur persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new SppkDebiturModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SppkDebitur.class.getName()));

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

		_setSppkDebiturUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSppkDebiturUtilPersistence(null);

		entityCache.removeCache(SppkDebiturImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setSppkDebiturUtilPersistence(
		SppkDebiturPersistence sppkDebiturPersistence) {

		try {
			Field field = SppkDebiturUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, sppkDebiturPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MSPPKPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MSPPKPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MSPPKPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_SPPKDEBITUR =
		"SELECT sppkDebitur FROM SppkDebitur sppkDebitur";

	private static final String _SQL_COUNT_SPPKDEBITUR =
		"SELECT COUNT(sppkDebitur) FROM SppkDebitur sppkDebitur";

	private static final String _ORDER_BY_ENTITY_ALIAS = "sppkDebitur.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SppkDebitur exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SppkDebiturPersistenceImpl.class);

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

	private static class SppkDebiturModelArgumentsResolver
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

			SppkDebiturModelImpl sppkDebiturModelImpl =
				(SppkDebiturModelImpl)baseModel;

			long columnBitmask = sppkDebiturModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(sppkDebiturModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						sppkDebiturModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(sppkDebiturModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SppkDebiturModelImpl sppkDebiturModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = sppkDebiturModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = sppkDebiturModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}