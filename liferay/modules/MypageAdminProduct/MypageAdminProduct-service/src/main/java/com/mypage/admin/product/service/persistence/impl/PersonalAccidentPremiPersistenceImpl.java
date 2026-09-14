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

import com.mypage.admin.product.exception.NoSuchPersonalAccidentPremiException;
import com.mypage.admin.product.model.PersonalAccidentPremi;
import com.mypage.admin.product.model.impl.PersonalAccidentPremiImpl;
import com.mypage.admin.product.model.impl.PersonalAccidentPremiModelImpl;
import com.mypage.admin.product.service.persistence.PersonalAccidentPremiPersistence;
import com.mypage.admin.product.service.persistence.PersonalAccidentPremiUtil;
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
 * The persistence implementation for the personal accident premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = PersonalAccidentPremiPersistence.class)
public class PersonalAccidentPremiPersistenceImpl
	extends BasePersistenceImpl<PersonalAccidentPremi>
	implements PersonalAccidentPremiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PersonalAccidentPremiUtil</code> to access the personal accident premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PersonalAccidentPremiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PersonalAccidentPremiPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PersonalAccidentPremi.class);

		setModelImplClass(PersonalAccidentPremiImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the personal accident premi in the entity cache if it is enabled.
	 *
	 * @param personalAccidentPremi the personal accident premi
	 */
	@Override
	public void cacheResult(PersonalAccidentPremi personalAccidentPremi) {
		entityCache.putResult(
			PersonalAccidentPremiImpl.class,
			personalAccidentPremi.getPrimaryKey(), personalAccidentPremi);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the personal accident premis in the entity cache if it is enabled.
	 *
	 * @param personalAccidentPremis the personal accident premis
	 */
	@Override
	public void cacheResult(
		List<PersonalAccidentPremi> personalAccidentPremis) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (personalAccidentPremis.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PersonalAccidentPremi personalAccidentPremi :
				personalAccidentPremis) {

			if (entityCache.getResult(
					PersonalAccidentPremiImpl.class,
					personalAccidentPremi.getPrimaryKey()) == null) {

				cacheResult(personalAccidentPremi);
			}
		}
	}

	/**
	 * Clears the cache for all personal accident premis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PersonalAccidentPremiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the personal accident premi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PersonalAccidentPremi personalAccidentPremi) {
		entityCache.removeResult(
			PersonalAccidentPremiImpl.class, personalAccidentPremi);
	}

	@Override
	public void clearCache(List<PersonalAccidentPremi> personalAccidentPremis) {
		for (PersonalAccidentPremi personalAccidentPremi :
				personalAccidentPremis) {

			entityCache.removeResult(
				PersonalAccidentPremiImpl.class, personalAccidentPremi);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				PersonalAccidentPremiImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new personal accident premi with the primary key. Does not add the personal accident premi to the database.
	 *
	 * @param personalAccidentPremiId the primary key for the new personal accident premi
	 * @return the new personal accident premi
	 */
	@Override
	public PersonalAccidentPremi create(long personalAccidentPremiId) {
		PersonalAccidentPremi personalAccidentPremi =
			new PersonalAccidentPremiImpl();

		personalAccidentPremi.setNew(true);
		personalAccidentPremi.setPrimaryKey(personalAccidentPremiId);

		personalAccidentPremi.setCompanyId(CompanyThreadLocal.getCompanyId());

		return personalAccidentPremi;
	}

	/**
	 * Removes the personal accident premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personalAccidentPremiId the primary key of the personal accident premi
	 * @return the personal accident premi that was removed
	 * @throws NoSuchPersonalAccidentPremiException if a personal accident premi with the primary key could not be found
	 */
	@Override
	public PersonalAccidentPremi remove(long personalAccidentPremiId)
		throws NoSuchPersonalAccidentPremiException {

		return remove((Serializable)personalAccidentPremiId);
	}

	/**
	 * Removes the personal accident premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the personal accident premi
	 * @return the personal accident premi that was removed
	 * @throws NoSuchPersonalAccidentPremiException if a personal accident premi with the primary key could not be found
	 */
	@Override
	public PersonalAccidentPremi remove(Serializable primaryKey)
		throws NoSuchPersonalAccidentPremiException {

		Session session = null;

		try {
			session = openSession();

			PersonalAccidentPremi personalAccidentPremi =
				(PersonalAccidentPremi)session.get(
					PersonalAccidentPremiImpl.class, primaryKey);

			if (personalAccidentPremi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersonalAccidentPremiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(personalAccidentPremi);
		}
		catch (NoSuchPersonalAccidentPremiException noSuchEntityException) {
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
	protected PersonalAccidentPremi removeImpl(
		PersonalAccidentPremi personalAccidentPremi) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(personalAccidentPremi)) {
				personalAccidentPremi = (PersonalAccidentPremi)session.get(
					PersonalAccidentPremiImpl.class,
					personalAccidentPremi.getPrimaryKeyObj());
			}

			if (personalAccidentPremi != null) {
				session.delete(personalAccidentPremi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (personalAccidentPremi != null) {
			clearCache(personalAccidentPremi);
		}

		return personalAccidentPremi;
	}

	@Override
	public PersonalAccidentPremi updateImpl(
		PersonalAccidentPremi personalAccidentPremi) {

		boolean isNew = personalAccidentPremi.isNew();

		if (!(personalAccidentPremi instanceof
				PersonalAccidentPremiModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(personalAccidentPremi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					personalAccidentPremi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in personalAccidentPremi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PersonalAccidentPremi implementation " +
					personalAccidentPremi.getClass());
		}

		PersonalAccidentPremiModelImpl personalAccidentPremiModelImpl =
			(PersonalAccidentPremiModelImpl)personalAccidentPremi;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (personalAccidentPremi.getCreateDate() == null)) {
			if (serviceContext == null) {
				personalAccidentPremi.setCreateDate(date);
			}
			else {
				personalAccidentPremi.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!personalAccidentPremiModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				personalAccidentPremi.setModifiedDate(date);
			}
			else {
				personalAccidentPremi.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(personalAccidentPremi);
			}
			else {
				personalAccidentPremi = (PersonalAccidentPremi)session.merge(
					personalAccidentPremi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PersonalAccidentPremiImpl.class, personalAccidentPremi, false,
			true);

		if (isNew) {
			personalAccidentPremi.setNew(false);
		}

		personalAccidentPremi.resetOriginalValues();

		return personalAccidentPremi;
	}

	/**
	 * Returns the personal accident premi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the personal accident premi
	 * @return the personal accident premi
	 * @throws NoSuchPersonalAccidentPremiException if a personal accident premi with the primary key could not be found
	 */
	@Override
	public PersonalAccidentPremi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPersonalAccidentPremiException {

		PersonalAccidentPremi personalAccidentPremi = fetchByPrimaryKey(
			primaryKey);

		if (personalAccidentPremi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPersonalAccidentPremiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return personalAccidentPremi;
	}

	/**
	 * Returns the personal accident premi with the primary key or throws a <code>NoSuchPersonalAccidentPremiException</code> if it could not be found.
	 *
	 * @param personalAccidentPremiId the primary key of the personal accident premi
	 * @return the personal accident premi
	 * @throws NoSuchPersonalAccidentPremiException if a personal accident premi with the primary key could not be found
	 */
	@Override
	public PersonalAccidentPremi findByPrimaryKey(long personalAccidentPremiId)
		throws NoSuchPersonalAccidentPremiException {

		return findByPrimaryKey((Serializable)personalAccidentPremiId);
	}

	/**
	 * Returns the personal accident premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personalAccidentPremiId the primary key of the personal accident premi
	 * @return the personal accident premi, or <code>null</code> if a personal accident premi with the primary key could not be found
	 */
	@Override
	public PersonalAccidentPremi fetchByPrimaryKey(
		long personalAccidentPremiId) {

		return fetchByPrimaryKey((Serializable)personalAccidentPremiId);
	}

	/**
	 * Returns all the personal accident premis.
	 *
	 * @return the personal accident premis
	 */
	@Override
	public List<PersonalAccidentPremi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the personal accident premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalAccidentPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal accident premis
	 * @param end the upper bound of the range of personal accident premis (not inclusive)
	 * @return the range of personal accident premis
	 */
	@Override
	public List<PersonalAccidentPremi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the personal accident premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalAccidentPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal accident premis
	 * @param end the upper bound of the range of personal accident premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of personal accident premis
	 */
	@Override
	public List<PersonalAccidentPremi> findAll(
		int start, int end,
		OrderByComparator<PersonalAccidentPremi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the personal accident premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalAccidentPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal accident premis
	 * @param end the upper bound of the range of personal accident premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of personal accident premis
	 */
	@Override
	public List<PersonalAccidentPremi> findAll(
		int start, int end,
		OrderByComparator<PersonalAccidentPremi> orderByComparator,
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

		List<PersonalAccidentPremi> list = null;

		if (useFinderCache) {
			list = (List<PersonalAccidentPremi>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PERSONALACCIDENTPREMI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PERSONALACCIDENTPREMI;

				sql = sql.concat(PersonalAccidentPremiModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PersonalAccidentPremi>)QueryUtil.list(
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
	 * Removes all the personal accident premis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PersonalAccidentPremi personalAccidentPremi : findAll()) {
			remove(personalAccidentPremi);
		}
	}

	/**
	 * Returns the number of personal accident premis.
	 *
	 * @return the number of personal accident premis
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
					_SQL_COUNT_PERSONALACCIDENTPREMI);

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
		return "personalAccidentPremiId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PERSONALACCIDENTPREMI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PersonalAccidentPremiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the personal accident premi persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new PersonalAccidentPremiModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PersonalAccidentPremi.class.getName()));

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

		_setPersonalAccidentPremiUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPersonalAccidentPremiUtilPersistence(null);

		entityCache.removeCache(PersonalAccidentPremiImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPersonalAccidentPremiUtilPersistence(
		PersonalAccidentPremiPersistence personalAccidentPremiPersistence) {

		try {
			Field field = PersonalAccidentPremiUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, personalAccidentPremiPersistence);
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

	private static final String _SQL_SELECT_PERSONALACCIDENTPREMI =
		"SELECT personalAccidentPremi FROM PersonalAccidentPremi personalAccidentPremi";

	private static final String _SQL_COUNT_PERSONALACCIDENTPREMI =
		"SELECT COUNT(personalAccidentPremi) FROM PersonalAccidentPremi personalAccidentPremi";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"personalAccidentPremi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PersonalAccidentPremi exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PersonalAccidentPremiPersistenceImpl.class);

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

	private static class PersonalAccidentPremiModelArgumentsResolver
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

			PersonalAccidentPremiModelImpl personalAccidentPremiModelImpl =
				(PersonalAccidentPremiModelImpl)baseModel;

			long columnBitmask =
				personalAccidentPremiModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					personalAccidentPremiModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						personalAccidentPremiModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					personalAccidentPremiModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PersonalAccidentPremiModelImpl personalAccidentPremiModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						personalAccidentPremiModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						personalAccidentPremiModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}