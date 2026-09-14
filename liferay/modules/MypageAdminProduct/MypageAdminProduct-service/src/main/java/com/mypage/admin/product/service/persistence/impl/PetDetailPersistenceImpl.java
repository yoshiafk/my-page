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

import com.mypage.admin.product.exception.NoSuchPetDetailException;
import com.mypage.admin.product.model.PetDetail;
import com.mypage.admin.product.model.impl.PetDetailImpl;
import com.mypage.admin.product.model.impl.PetDetailModelImpl;
import com.mypage.admin.product.service.persistence.PetDetailPersistence;
import com.mypage.admin.product.service.persistence.PetDetailUtil;
import com.mypage.admin.product.service.persistence.impl.constants.MPPersistenceConstants;

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
 * The persistence implementation for the pet detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = PetDetailPersistence.class)
public class PetDetailPersistenceImpl
	extends BasePersistenceImpl<PetDetail> implements PetDetailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PetDetailUtil</code> to access the pet detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PetDetailImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PetDetailPersistenceImpl() {
		setModelClass(PetDetail.class);

		setModelImplClass(PetDetailImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the pet detail in the entity cache if it is enabled.
	 *
	 * @param petDetail the pet detail
	 */
	@Override
	public void cacheResult(PetDetail petDetail) {
		entityCache.putResult(
			PetDetailImpl.class, petDetail.getPrimaryKey(), petDetail);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the pet details in the entity cache if it is enabled.
	 *
	 * @param petDetails the pet details
	 */
	@Override
	public void cacheResult(List<PetDetail> petDetails) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (petDetails.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PetDetail petDetail : petDetails) {
			if (entityCache.getResult(
					PetDetailImpl.class, petDetail.getPrimaryKey()) == null) {

				cacheResult(petDetail);
			}
		}
	}

	/**
	 * Clears the cache for all pet details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PetDetailImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pet detail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PetDetail petDetail) {
		entityCache.removeResult(PetDetailImpl.class, petDetail);
	}

	@Override
	public void clearCache(List<PetDetail> petDetails) {
		for (PetDetail petDetail : petDetails) {
			entityCache.removeResult(PetDetailImpl.class, petDetail);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PetDetailImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new pet detail with the primary key. Does not add the pet detail to the database.
	 *
	 * @param petDetailId the primary key for the new pet detail
	 * @return the new pet detail
	 */
	@Override
	public PetDetail create(long petDetailId) {
		PetDetail petDetail = new PetDetailImpl();

		petDetail.setNew(true);
		petDetail.setPrimaryKey(petDetailId);

		petDetail.setCompanyId(CompanyThreadLocal.getCompanyId());

		return petDetail;
	}

	/**
	 * Removes the pet detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petDetailId the primary key of the pet detail
	 * @return the pet detail that was removed
	 * @throws NoSuchPetDetailException if a pet detail with the primary key could not be found
	 */
	@Override
	public PetDetail remove(long petDetailId) throws NoSuchPetDetailException {
		return remove((Serializable)petDetailId);
	}

	/**
	 * Removes the pet detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pet detail
	 * @return the pet detail that was removed
	 * @throws NoSuchPetDetailException if a pet detail with the primary key could not be found
	 */
	@Override
	public PetDetail remove(Serializable primaryKey)
		throws NoSuchPetDetailException {

		Session session = null;

		try {
			session = openSession();

			PetDetail petDetail = (PetDetail)session.get(
				PetDetailImpl.class, primaryKey);

			if (petDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPetDetailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(petDetail);
		}
		catch (NoSuchPetDetailException noSuchEntityException) {
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
	protected PetDetail removeImpl(PetDetail petDetail) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(petDetail)) {
				petDetail = (PetDetail)session.get(
					PetDetailImpl.class, petDetail.getPrimaryKeyObj());
			}

			if (petDetail != null) {
				session.delete(petDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (petDetail != null) {
			clearCache(petDetail);
		}

		return petDetail;
	}

	@Override
	public PetDetail updateImpl(PetDetail petDetail) {
		boolean isNew = petDetail.isNew();

		if (!(petDetail instanceof PetDetailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(petDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(petDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in petDetail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PetDetail implementation " +
					petDetail.getClass());
		}

		PetDetailModelImpl petDetailModelImpl = (PetDetailModelImpl)petDetail;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (petDetail.getCreateDate() == null)) {
			if (serviceContext == null) {
				petDetail.setCreateDate(date);
			}
			else {
				petDetail.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!petDetailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				petDetail.setModifiedDate(date);
			}
			else {
				petDetail.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(petDetail);
			}
			else {
				petDetail = (PetDetail)session.merge(petDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PetDetailImpl.class, petDetail, false, true);

		if (isNew) {
			petDetail.setNew(false);
		}

		petDetail.resetOriginalValues();

		return petDetail;
	}

	/**
	 * Returns the pet detail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pet detail
	 * @return the pet detail
	 * @throws NoSuchPetDetailException if a pet detail with the primary key could not be found
	 */
	@Override
	public PetDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPetDetailException {

		PetDetail petDetail = fetchByPrimaryKey(primaryKey);

		if (petDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPetDetailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return petDetail;
	}

	/**
	 * Returns the pet detail with the primary key or throws a <code>NoSuchPetDetailException</code> if it could not be found.
	 *
	 * @param petDetailId the primary key of the pet detail
	 * @return the pet detail
	 * @throws NoSuchPetDetailException if a pet detail with the primary key could not be found
	 */
	@Override
	public PetDetail findByPrimaryKey(long petDetailId)
		throws NoSuchPetDetailException {

		return findByPrimaryKey((Serializable)petDetailId);
	}

	/**
	 * Returns the pet detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petDetailId the primary key of the pet detail
	 * @return the pet detail, or <code>null</code> if a pet detail with the primary key could not be found
	 */
	@Override
	public PetDetail fetchByPrimaryKey(long petDetailId) {
		return fetchByPrimaryKey((Serializable)petDetailId);
	}

	/**
	 * Returns all the pet details.
	 *
	 * @return the pet details
	 */
	@Override
	public List<PetDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pet details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet details
	 * @param end the upper bound of the range of pet details (not inclusive)
	 * @return the range of pet details
	 */
	@Override
	public List<PetDetail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pet details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet details
	 * @param end the upper bound of the range of pet details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pet details
	 */
	@Override
	public List<PetDetail> findAll(
		int start, int end, OrderByComparator<PetDetail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pet details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet details
	 * @param end the upper bound of the range of pet details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pet details
	 */
	@Override
	public List<PetDetail> findAll(
		int start, int end, OrderByComparator<PetDetail> orderByComparator,
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

		List<PetDetail> list = null;

		if (useFinderCache) {
			list = (List<PetDetail>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PETDETAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PETDETAIL;

				sql = sql.concat(PetDetailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PetDetail>)QueryUtil.list(
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
	 * Removes all the pet details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PetDetail petDetail : findAll()) {
			remove(petDetail);
		}
	}

	/**
	 * Returns the number of pet details.
	 *
	 * @return the number of pet details
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PETDETAIL);

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
		return "petDetailId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PETDETAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PetDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pet detail persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PetDetailModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PetDetail.class.getName()));

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

		_setPetDetailUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPetDetailUtilPersistence(null);

		entityCache.removeCache(PetDetailImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPetDetailUtilPersistence(
		PetDetailPersistence petDetailPersistence) {

		try {
			Field field = PetDetailUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, petDetailPersistence);
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

	private static final String _SQL_SELECT_PETDETAIL =
		"SELECT petDetail FROM PetDetail petDetail";

	private static final String _SQL_COUNT_PETDETAIL =
		"SELECT COUNT(petDetail) FROM PetDetail petDetail";

	private static final String _ORDER_BY_ENTITY_ALIAS = "petDetail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PetDetail exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PetDetailPersistenceImpl.class);

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

	private static class PetDetailModelArgumentsResolver
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

			PetDetailModelImpl petDetailModelImpl =
				(PetDetailModelImpl)baseModel;

			long columnBitmask = petDetailModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(petDetailModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						petDetailModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(PetDetailPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(petDetailModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PetDetailModelImpl petDetailModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = petDetailModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = petDetailModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |= PetDetailModelImpl.getColumnBitmask(
				"petName");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}