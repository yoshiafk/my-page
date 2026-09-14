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

package com.mypage.user.service.persistence.impl;

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

import com.mypage.user.exception.NoSuchCreditWalletException;
import com.mypage.user.model.CreditWallet;
import com.mypage.user.model.impl.CreditWalletImpl;
import com.mypage.user.model.impl.CreditWalletModelImpl;
import com.mypage.user.service.persistence.CreditWalletPersistence;
import com.mypage.user.service.persistence.CreditWalletUtil;
import com.mypage.user.service.persistence.impl.constants.MPUPersistenceConstants;

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
 * The persistence implementation for the credit wallet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CreditWalletPersistence.class)
public class CreditWalletPersistenceImpl
	extends BasePersistenceImpl<CreditWallet>
	implements CreditWalletPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CreditWalletUtil</code> to access the credit wallet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CreditWalletImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CreditWalletPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CreditWallet.class);

		setModelImplClass(CreditWalletImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the credit wallet in the entity cache if it is enabled.
	 *
	 * @param creditWallet the credit wallet
	 */
	@Override
	public void cacheResult(CreditWallet creditWallet) {
		entityCache.putResult(
			CreditWalletImpl.class, creditWallet.getPrimaryKey(), creditWallet);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the credit wallets in the entity cache if it is enabled.
	 *
	 * @param creditWallets the credit wallets
	 */
	@Override
	public void cacheResult(List<CreditWallet> creditWallets) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (creditWallets.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CreditWallet creditWallet : creditWallets) {
			if (entityCache.getResult(
					CreditWalletImpl.class, creditWallet.getPrimaryKey()) ==
						null) {

				cacheResult(creditWallet);
			}
		}
	}

	/**
	 * Clears the cache for all credit wallets.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CreditWalletImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the credit wallet.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CreditWallet creditWallet) {
		entityCache.removeResult(CreditWalletImpl.class, creditWallet);
	}

	@Override
	public void clearCache(List<CreditWallet> creditWallets) {
		for (CreditWallet creditWallet : creditWallets) {
			entityCache.removeResult(CreditWalletImpl.class, creditWallet);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CreditWalletImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new credit wallet with the primary key. Does not add the credit wallet to the database.
	 *
	 * @param creditWalletId the primary key for the new credit wallet
	 * @return the new credit wallet
	 */
	@Override
	public CreditWallet create(long creditWalletId) {
		CreditWallet creditWallet = new CreditWalletImpl();

		creditWallet.setNew(true);
		creditWallet.setPrimaryKey(creditWalletId);

		creditWallet.setCompanyId(CompanyThreadLocal.getCompanyId());

		return creditWallet;
	}

	/**
	 * Removes the credit wallet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creditWalletId the primary key of the credit wallet
	 * @return the credit wallet that was removed
	 * @throws NoSuchCreditWalletException if a credit wallet with the primary key could not be found
	 */
	@Override
	public CreditWallet remove(long creditWalletId)
		throws NoSuchCreditWalletException {

		return remove((Serializable)creditWalletId);
	}

	/**
	 * Removes the credit wallet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the credit wallet
	 * @return the credit wallet that was removed
	 * @throws NoSuchCreditWalletException if a credit wallet with the primary key could not be found
	 */
	@Override
	public CreditWallet remove(Serializable primaryKey)
		throws NoSuchCreditWalletException {

		Session session = null;

		try {
			session = openSession();

			CreditWallet creditWallet = (CreditWallet)session.get(
				CreditWalletImpl.class, primaryKey);

			if (creditWallet == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCreditWalletException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(creditWallet);
		}
		catch (NoSuchCreditWalletException noSuchEntityException) {
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
	protected CreditWallet removeImpl(CreditWallet creditWallet) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(creditWallet)) {
				creditWallet = (CreditWallet)session.get(
					CreditWalletImpl.class, creditWallet.getPrimaryKeyObj());
			}

			if (creditWallet != null) {
				session.delete(creditWallet);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (creditWallet != null) {
			clearCache(creditWallet);
		}

		return creditWallet;
	}

	@Override
	public CreditWallet updateImpl(CreditWallet creditWallet) {
		boolean isNew = creditWallet.isNew();

		if (!(creditWallet instanceof CreditWalletModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(creditWallet.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					creditWallet);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in creditWallet proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CreditWallet implementation " +
					creditWallet.getClass());
		}

		CreditWalletModelImpl creditWalletModelImpl =
			(CreditWalletModelImpl)creditWallet;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (creditWallet.getCreateDate() == null)) {
			if (serviceContext == null) {
				creditWallet.setCreateDate(date);
			}
			else {
				creditWallet.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!creditWalletModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				creditWallet.setModifiedDate(date);
			}
			else {
				creditWallet.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(creditWallet);
			}
			else {
				creditWallet = (CreditWallet)session.merge(creditWallet);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CreditWalletImpl.class, creditWallet, false, true);

		if (isNew) {
			creditWallet.setNew(false);
		}

		creditWallet.resetOriginalValues();

		return creditWallet;
	}

	/**
	 * Returns the credit wallet with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the credit wallet
	 * @return the credit wallet
	 * @throws NoSuchCreditWalletException if a credit wallet with the primary key could not be found
	 */
	@Override
	public CreditWallet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCreditWalletException {

		CreditWallet creditWallet = fetchByPrimaryKey(primaryKey);

		if (creditWallet == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCreditWalletException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return creditWallet;
	}

	/**
	 * Returns the credit wallet with the primary key or throws a <code>NoSuchCreditWalletException</code> if it could not be found.
	 *
	 * @param creditWalletId the primary key of the credit wallet
	 * @return the credit wallet
	 * @throws NoSuchCreditWalletException if a credit wallet with the primary key could not be found
	 */
	@Override
	public CreditWallet findByPrimaryKey(long creditWalletId)
		throws NoSuchCreditWalletException {

		return findByPrimaryKey((Serializable)creditWalletId);
	}

	/**
	 * Returns the credit wallet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param creditWalletId the primary key of the credit wallet
	 * @return the credit wallet, or <code>null</code> if a credit wallet with the primary key could not be found
	 */
	@Override
	public CreditWallet fetchByPrimaryKey(long creditWalletId) {
		return fetchByPrimaryKey((Serializable)creditWalletId);
	}

	/**
	 * Returns all the credit wallets.
	 *
	 * @return the credit wallets
	 */
	@Override
	public List<CreditWallet> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit wallets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallets
	 * @param end the upper bound of the range of credit wallets (not inclusive)
	 * @return the range of credit wallets
	 */
	@Override
	public List<CreditWallet> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit wallets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallets
	 * @param end the upper bound of the range of credit wallets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of credit wallets
	 */
	@Override
	public List<CreditWallet> findAll(
		int start, int end, OrderByComparator<CreditWallet> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the credit wallets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallets
	 * @param end the upper bound of the range of credit wallets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of credit wallets
	 */
	@Override
	public List<CreditWallet> findAll(
		int start, int end, OrderByComparator<CreditWallet> orderByComparator,
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

		List<CreditWallet> list = null;

		if (useFinderCache) {
			list = (List<CreditWallet>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CREDITWALLET);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CREDITWALLET;

				sql = sql.concat(CreditWalletModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CreditWallet>)QueryUtil.list(
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
	 * Removes all the credit wallets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CreditWallet creditWallet : findAll()) {
			remove(creditWallet);
		}
	}

	/**
	 * Returns the number of credit wallets.
	 *
	 * @return the number of credit wallets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CREDITWALLET);

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
		return "creditWalletId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CREDITWALLET;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CreditWalletModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the credit wallet persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CreditWalletModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CreditWallet.class.getName()));

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

		_setCreditWalletUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCreditWalletUtilPersistence(null);

		entityCache.removeCache(CreditWalletImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setCreditWalletUtilPersistence(
		CreditWalletPersistence creditWalletPersistence) {

		try {
			Field field = CreditWalletUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, creditWalletPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MPUPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MPUPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MPUPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_CREDITWALLET =
		"SELECT creditWallet FROM CreditWallet creditWallet";

	private static final String _SQL_COUNT_CREDITWALLET =
		"SELECT COUNT(creditWallet) FROM CreditWallet creditWallet";

	private static final String _ORDER_BY_ENTITY_ALIAS = "creditWallet.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CreditWallet exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CreditWalletPersistenceImpl.class);

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

	private static class CreditWalletModelArgumentsResolver
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

			CreditWalletModelImpl creditWalletModelImpl =
				(CreditWalletModelImpl)baseModel;

			long columnBitmask = creditWalletModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(creditWalletModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						creditWalletModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(creditWalletModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			CreditWalletModelImpl creditWalletModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = creditWalletModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = creditWalletModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}