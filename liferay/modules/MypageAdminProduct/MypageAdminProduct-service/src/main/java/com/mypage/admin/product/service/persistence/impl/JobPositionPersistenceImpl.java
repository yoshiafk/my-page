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

import com.mypage.admin.product.exception.NoSuchJobPositionException;
import com.mypage.admin.product.model.JobPosition;
import com.mypage.admin.product.model.impl.JobPositionImpl;
import com.mypage.admin.product.model.impl.JobPositionModelImpl;
import com.mypage.admin.product.service.persistence.JobPositionPersistence;
import com.mypage.admin.product.service.persistence.JobPositionUtil;
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
 * The persistence implementation for the job position service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = JobPositionPersistence.class)
public class JobPositionPersistenceImpl
	extends BasePersistenceImpl<JobPosition> implements JobPositionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>JobPositionUtil</code> to access the job position persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		JobPositionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public JobPositionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(JobPosition.class);

		setModelImplClass(JobPositionImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the job position in the entity cache if it is enabled.
	 *
	 * @param jobPosition the job position
	 */
	@Override
	public void cacheResult(JobPosition jobPosition) {
		entityCache.putResult(
			JobPositionImpl.class, jobPosition.getPrimaryKey(), jobPosition);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the job positions in the entity cache if it is enabled.
	 *
	 * @param jobPositions the job positions
	 */
	@Override
	public void cacheResult(List<JobPosition> jobPositions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (jobPositions.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (JobPosition jobPosition : jobPositions) {
			if (entityCache.getResult(
					JobPositionImpl.class, jobPosition.getPrimaryKey()) ==
						null) {

				cacheResult(jobPosition);
			}
		}
	}

	/**
	 * Clears the cache for all job positions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(JobPositionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the job position.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JobPosition jobPosition) {
		entityCache.removeResult(JobPositionImpl.class, jobPosition);
	}

	@Override
	public void clearCache(List<JobPosition> jobPositions) {
		for (JobPosition jobPosition : jobPositions) {
			entityCache.removeResult(JobPositionImpl.class, jobPosition);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(JobPositionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new job position with the primary key. Does not add the job position to the database.
	 *
	 * @param jobPositionId the primary key for the new job position
	 * @return the new job position
	 */
	@Override
	public JobPosition create(long jobPositionId) {
		JobPosition jobPosition = new JobPositionImpl();

		jobPosition.setNew(true);
		jobPosition.setPrimaryKey(jobPositionId);

		jobPosition.setCompanyId(CompanyThreadLocal.getCompanyId());

		return jobPosition;
	}

	/**
	 * Removes the job position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobPositionId the primary key of the job position
	 * @return the job position that was removed
	 * @throws NoSuchJobPositionException if a job position with the primary key could not be found
	 */
	@Override
	public JobPosition remove(long jobPositionId)
		throws NoSuchJobPositionException {

		return remove((Serializable)jobPositionId);
	}

	/**
	 * Removes the job position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job position
	 * @return the job position that was removed
	 * @throws NoSuchJobPositionException if a job position with the primary key could not be found
	 */
	@Override
	public JobPosition remove(Serializable primaryKey)
		throws NoSuchJobPositionException {

		Session session = null;

		try {
			session = openSession();

			JobPosition jobPosition = (JobPosition)session.get(
				JobPositionImpl.class, primaryKey);

			if (jobPosition == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobPositionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(jobPosition);
		}
		catch (NoSuchJobPositionException noSuchEntityException) {
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
	protected JobPosition removeImpl(JobPosition jobPosition) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jobPosition)) {
				jobPosition = (JobPosition)session.get(
					JobPositionImpl.class, jobPosition.getPrimaryKeyObj());
			}

			if (jobPosition != null) {
				session.delete(jobPosition);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (jobPosition != null) {
			clearCache(jobPosition);
		}

		return jobPosition;
	}

	@Override
	public JobPosition updateImpl(JobPosition jobPosition) {
		boolean isNew = jobPosition.isNew();

		if (!(jobPosition instanceof JobPositionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(jobPosition.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(jobPosition);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in jobPosition proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom JobPosition implementation " +
					jobPosition.getClass());
		}

		JobPositionModelImpl jobPositionModelImpl =
			(JobPositionModelImpl)jobPosition;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (jobPosition.getCreateDate() == null)) {
			if (serviceContext == null) {
				jobPosition.setCreateDate(date);
			}
			else {
				jobPosition.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!jobPositionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				jobPosition.setModifiedDate(date);
			}
			else {
				jobPosition.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(jobPosition);
			}
			else {
				jobPosition = (JobPosition)session.merge(jobPosition);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(JobPositionImpl.class, jobPosition, false, true);

		if (isNew) {
			jobPosition.setNew(false);
		}

		jobPosition.resetOriginalValues();

		return jobPosition;
	}

	/**
	 * Returns the job position with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job position
	 * @return the job position
	 * @throws NoSuchJobPositionException if a job position with the primary key could not be found
	 */
	@Override
	public JobPosition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJobPositionException {

		JobPosition jobPosition = fetchByPrimaryKey(primaryKey);

		if (jobPosition == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJobPositionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return jobPosition;
	}

	/**
	 * Returns the job position with the primary key or throws a <code>NoSuchJobPositionException</code> if it could not be found.
	 *
	 * @param jobPositionId the primary key of the job position
	 * @return the job position
	 * @throws NoSuchJobPositionException if a job position with the primary key could not be found
	 */
	@Override
	public JobPosition findByPrimaryKey(long jobPositionId)
		throws NoSuchJobPositionException {

		return findByPrimaryKey((Serializable)jobPositionId);
	}

	/**
	 * Returns the job position with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobPositionId the primary key of the job position
	 * @return the job position, or <code>null</code> if a job position with the primary key could not be found
	 */
	@Override
	public JobPosition fetchByPrimaryKey(long jobPositionId) {
		return fetchByPrimaryKey((Serializable)jobPositionId);
	}

	/**
	 * Returns all the job positions.
	 *
	 * @return the job positions
	 */
	@Override
	public List<JobPosition> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPositionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job positions
	 * @param end the upper bound of the range of job positions (not inclusive)
	 * @return the range of job positions
	 */
	@Override
	public List<JobPosition> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the job positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPositionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job positions
	 * @param end the upper bound of the range of job positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job positions
	 */
	@Override
	public List<JobPosition> findAll(
		int start, int end, OrderByComparator<JobPosition> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the job positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPositionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job positions
	 * @param end the upper bound of the range of job positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of job positions
	 */
	@Override
	public List<JobPosition> findAll(
		int start, int end, OrderByComparator<JobPosition> orderByComparator,
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

		List<JobPosition> list = null;

		if (useFinderCache) {
			list = (List<JobPosition>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_JOBPOSITION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_JOBPOSITION;

				sql = sql.concat(JobPositionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<JobPosition>)QueryUtil.list(
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
	 * Removes all the job positions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (JobPosition jobPosition : findAll()) {
			remove(jobPosition);
		}
	}

	/**
	 * Returns the number of job positions.
	 *
	 * @return the number of job positions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_JOBPOSITION);

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
		return "jobPositionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_JOBPOSITION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return JobPositionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the job position persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new JobPositionModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", JobPosition.class.getName()));

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

		_setJobPositionUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setJobPositionUtilPersistence(null);

		entityCache.removeCache(JobPositionImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setJobPositionUtilPersistence(
		JobPositionPersistence jobPositionPersistence) {

		try {
			Field field = JobPositionUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, jobPositionPersistence);
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

	private static final String _SQL_SELECT_JOBPOSITION =
		"SELECT jobPosition FROM JobPosition jobPosition";

	private static final String _SQL_COUNT_JOBPOSITION =
		"SELECT COUNT(jobPosition) FROM JobPosition jobPosition";

	private static final String _ORDER_BY_ENTITY_ALIAS = "jobPosition.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No JobPosition exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		JobPositionPersistenceImpl.class);

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

	private static class JobPositionModelArgumentsResolver
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

			JobPositionModelImpl jobPositionModelImpl =
				(JobPositionModelImpl)baseModel;

			long columnBitmask = jobPositionModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(jobPositionModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						jobPositionModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(jobPositionModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			JobPositionModelImpl jobPositionModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = jobPositionModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = jobPositionModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}