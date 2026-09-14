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

import com.mypage.admin.product.exception.NoSuchMasterGlobalVariableException;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.model.impl.MasterGlobalVariableImpl;
import com.mypage.admin.product.model.impl.MasterGlobalVariableModelImpl;
import com.mypage.admin.product.service.persistence.MasterGlobalVariablePersistence;
import com.mypage.admin.product.service.persistence.MasterGlobalVariableUtil;
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
 * The persistence implementation for the master global variable service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = MasterGlobalVariablePersistence.class)
public class MasterGlobalVariablePersistenceImpl
	extends BasePersistenceImpl<MasterGlobalVariable>
	implements MasterGlobalVariablePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MasterGlobalVariableUtil</code> to access the master global variable persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MasterGlobalVariableImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public MasterGlobalVariablePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("group", "group_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MasterGlobalVariable.class);

		setModelImplClass(MasterGlobalVariableImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the master global variable in the entity cache if it is enabled.
	 *
	 * @param masterGlobalVariable the master global variable
	 */
	@Override
	public void cacheResult(MasterGlobalVariable masterGlobalVariable) {
		entityCache.putResult(
			MasterGlobalVariableImpl.class,
			masterGlobalVariable.getPrimaryKey(), masterGlobalVariable);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the master global variables in the entity cache if it is enabled.
	 *
	 * @param masterGlobalVariables the master global variables
	 */
	@Override
	public void cacheResult(List<MasterGlobalVariable> masterGlobalVariables) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (masterGlobalVariables.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MasterGlobalVariable masterGlobalVariable :
				masterGlobalVariables) {

			if (entityCache.getResult(
					MasterGlobalVariableImpl.class,
					masterGlobalVariable.getPrimaryKey()) == null) {

				cacheResult(masterGlobalVariable);
			}
		}
	}

	/**
	 * Clears the cache for all master global variables.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MasterGlobalVariableImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the master global variable.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MasterGlobalVariable masterGlobalVariable) {
		entityCache.removeResult(
			MasterGlobalVariableImpl.class, masterGlobalVariable);
	}

	@Override
	public void clearCache(List<MasterGlobalVariable> masterGlobalVariables) {
		for (MasterGlobalVariable masterGlobalVariable :
				masterGlobalVariables) {

			entityCache.removeResult(
				MasterGlobalVariableImpl.class, masterGlobalVariable);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				MasterGlobalVariableImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new master global variable with the primary key. Does not add the master global variable to the database.
	 *
	 * @param masterGlobalVariableId the primary key for the new master global variable
	 * @return the new master global variable
	 */
	@Override
	public MasterGlobalVariable create(long masterGlobalVariableId) {
		MasterGlobalVariable masterGlobalVariable =
			new MasterGlobalVariableImpl();

		masterGlobalVariable.setNew(true);
		masterGlobalVariable.setPrimaryKey(masterGlobalVariableId);

		masterGlobalVariable.setCompanyId(CompanyThreadLocal.getCompanyId());

		return masterGlobalVariable;
	}

	/**
	 * Removes the master global variable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterGlobalVariableId the primary key of the master global variable
	 * @return the master global variable that was removed
	 * @throws NoSuchMasterGlobalVariableException if a master global variable with the primary key could not be found
	 */
	@Override
	public MasterGlobalVariable remove(long masterGlobalVariableId)
		throws NoSuchMasterGlobalVariableException {

		return remove((Serializable)masterGlobalVariableId);
	}

	/**
	 * Removes the master global variable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the master global variable
	 * @return the master global variable that was removed
	 * @throws NoSuchMasterGlobalVariableException if a master global variable with the primary key could not be found
	 */
	@Override
	public MasterGlobalVariable remove(Serializable primaryKey)
		throws NoSuchMasterGlobalVariableException {

		Session session = null;

		try {
			session = openSession();

			MasterGlobalVariable masterGlobalVariable =
				(MasterGlobalVariable)session.get(
					MasterGlobalVariableImpl.class, primaryKey);

			if (masterGlobalVariable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasterGlobalVariableException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(masterGlobalVariable);
		}
		catch (NoSuchMasterGlobalVariableException noSuchEntityException) {
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
	protected MasterGlobalVariable removeImpl(
		MasterGlobalVariable masterGlobalVariable) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(masterGlobalVariable)) {
				masterGlobalVariable = (MasterGlobalVariable)session.get(
					MasterGlobalVariableImpl.class,
					masterGlobalVariable.getPrimaryKeyObj());
			}

			if (masterGlobalVariable != null) {
				session.delete(masterGlobalVariable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (masterGlobalVariable != null) {
			clearCache(masterGlobalVariable);
		}

		return masterGlobalVariable;
	}

	@Override
	public MasterGlobalVariable updateImpl(
		MasterGlobalVariable masterGlobalVariable) {

		boolean isNew = masterGlobalVariable.isNew();

		if (!(masterGlobalVariable instanceof MasterGlobalVariableModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(masterGlobalVariable.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					masterGlobalVariable);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in masterGlobalVariable proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MasterGlobalVariable implementation " +
					masterGlobalVariable.getClass());
		}

		MasterGlobalVariableModelImpl masterGlobalVariableModelImpl =
			(MasterGlobalVariableModelImpl)masterGlobalVariable;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (masterGlobalVariable.getCreateDate() == null)) {
			if (serviceContext == null) {
				masterGlobalVariable.setCreateDate(date);
			}
			else {
				masterGlobalVariable.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!masterGlobalVariableModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				masterGlobalVariable.setModifiedDate(date);
			}
			else {
				masterGlobalVariable.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(masterGlobalVariable);
			}
			else {
				masterGlobalVariable = (MasterGlobalVariable)session.merge(
					masterGlobalVariable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MasterGlobalVariableImpl.class, masterGlobalVariable, false, true);

		if (isNew) {
			masterGlobalVariable.setNew(false);
		}

		masterGlobalVariable.resetOriginalValues();

		return masterGlobalVariable;
	}

	/**
	 * Returns the master global variable with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the master global variable
	 * @return the master global variable
	 * @throws NoSuchMasterGlobalVariableException if a master global variable with the primary key could not be found
	 */
	@Override
	public MasterGlobalVariable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMasterGlobalVariableException {

		MasterGlobalVariable masterGlobalVariable = fetchByPrimaryKey(
			primaryKey);

		if (masterGlobalVariable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasterGlobalVariableException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return masterGlobalVariable;
	}

	/**
	 * Returns the master global variable with the primary key or throws a <code>NoSuchMasterGlobalVariableException</code> if it could not be found.
	 *
	 * @param masterGlobalVariableId the primary key of the master global variable
	 * @return the master global variable
	 * @throws NoSuchMasterGlobalVariableException if a master global variable with the primary key could not be found
	 */
	@Override
	public MasterGlobalVariable findByPrimaryKey(long masterGlobalVariableId)
		throws NoSuchMasterGlobalVariableException {

		return findByPrimaryKey((Serializable)masterGlobalVariableId);
	}

	/**
	 * Returns the master global variable with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterGlobalVariableId the primary key of the master global variable
	 * @return the master global variable, or <code>null</code> if a master global variable with the primary key could not be found
	 */
	@Override
	public MasterGlobalVariable fetchByPrimaryKey(long masterGlobalVariableId) {
		return fetchByPrimaryKey((Serializable)masterGlobalVariableId);
	}

	/**
	 * Returns all the master global variables.
	 *
	 * @return the master global variables
	 */
	@Override
	public List<MasterGlobalVariable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master global variables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterGlobalVariableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master global variables
	 * @param end the upper bound of the range of master global variables (not inclusive)
	 * @return the range of master global variables
	 */
	@Override
	public List<MasterGlobalVariable> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the master global variables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterGlobalVariableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master global variables
	 * @param end the upper bound of the range of master global variables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master global variables
	 */
	@Override
	public List<MasterGlobalVariable> findAll(
		int start, int end,
		OrderByComparator<MasterGlobalVariable> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master global variables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterGlobalVariableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master global variables
	 * @param end the upper bound of the range of master global variables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master global variables
	 */
	@Override
	public List<MasterGlobalVariable> findAll(
		int start, int end,
		OrderByComparator<MasterGlobalVariable> orderByComparator,
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

		List<MasterGlobalVariable> list = null;

		if (useFinderCache) {
			list = (List<MasterGlobalVariable>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MASTERGLOBALVARIABLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MASTERGLOBALVARIABLE;

				sql = sql.concat(MasterGlobalVariableModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MasterGlobalVariable>)QueryUtil.list(
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
	 * Removes all the master global variables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MasterGlobalVariable masterGlobalVariable : findAll()) {
			remove(masterGlobalVariable);
		}
	}

	/**
	 * Returns the number of master global variables.
	 *
	 * @return the number of master global variables
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
					_SQL_COUNT_MASTERGLOBALVARIABLE);

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
		return "masterGlobalVariableId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MASTERGLOBALVARIABLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MasterGlobalVariableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the master global variable persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new MasterGlobalVariableModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MasterGlobalVariable.class.getName()));

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

		_setMasterGlobalVariableUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMasterGlobalVariableUtilPersistence(null);

		entityCache.removeCache(MasterGlobalVariableImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setMasterGlobalVariableUtilPersistence(
		MasterGlobalVariablePersistence masterGlobalVariablePersistence) {

		try {
			Field field = MasterGlobalVariableUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, masterGlobalVariablePersistence);
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

	private static final String _SQL_SELECT_MASTERGLOBALVARIABLE =
		"SELECT masterGlobalVariable FROM MasterGlobalVariable masterGlobalVariable";

	private static final String _SQL_COUNT_MASTERGLOBALVARIABLE =
		"SELECT COUNT(masterGlobalVariable) FROM MasterGlobalVariable masterGlobalVariable";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"masterGlobalVariable.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MasterGlobalVariable exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		MasterGlobalVariablePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"group", "active"});

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

	private static class MasterGlobalVariableModelArgumentsResolver
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

			MasterGlobalVariableModelImpl masterGlobalVariableModelImpl =
				(MasterGlobalVariableModelImpl)baseModel;

			long columnBitmask =
				masterGlobalVariableModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					masterGlobalVariableModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						masterGlobalVariableModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					masterGlobalVariableModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			MasterGlobalVariableModelImpl masterGlobalVariableModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						masterGlobalVariableModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = masterGlobalVariableModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}