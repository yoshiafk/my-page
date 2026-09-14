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
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringUtil;

import com.mypage.user.exception.NoSuchCreditTypeException;
import com.mypage.user.model.CreditType;
import com.mypage.user.model.impl.CreditTypeImpl;
import com.mypage.user.model.impl.CreditTypeModelImpl;
import com.mypage.user.service.persistence.CreditTypePersistence;
import com.mypage.user.service.persistence.CreditTypeUtil;
import com.mypage.user.service.persistence.impl.constants.MPUPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the credit type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CreditTypePersistence.class)
public class CreditTypePersistenceImpl
	extends BasePersistenceImpl<CreditType> implements CreditTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CreditTypeUtil</code> to access the credit type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CreditTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBygetByMypageUserId;
	private FinderPath _finderPathCountBygetByMypageUserId;

	/**
	 * Returns the credit type where mypageUserId = &#63; or throws a <code>NoSuchCreditTypeException</code> if it could not be found.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching credit type
	 * @throws NoSuchCreditTypeException if a matching credit type could not be found
	 */
	@Override
	public CreditType findBygetByMypageUserId(long mypageUserId)
		throws NoSuchCreditTypeException {

		CreditType creditType = fetchBygetByMypageUserId(mypageUserId);

		if (creditType == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("mypageUserId=");
			sb.append(mypageUserId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCreditTypeException(sb.toString());
		}

		return creditType;
	}

	/**
	 * Returns the credit type where mypageUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching credit type, or <code>null</code> if a matching credit type could not be found
	 */
	@Override
	public CreditType fetchBygetByMypageUserId(long mypageUserId) {
		return fetchBygetByMypageUserId(mypageUserId, true);
	}

	/**
	 * Returns the credit type where mypageUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching credit type, or <code>null</code> if a matching credit type could not be found
	 */
	@Override
	public CreditType fetchBygetByMypageUserId(
		long mypageUserId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {mypageUserId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBygetByMypageUserId, finderArgs, this);
		}

		if (result instanceof CreditType) {
			CreditType creditType = (CreditType)result;

			if (mypageUserId != creditType.getMypageUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CREDITTYPE_WHERE);

			sb.append(_FINDER_COLUMN_GETBYMYPAGEUSERID_MYPAGEUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserId);

				List<CreditType> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBygetByMypageUserId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {mypageUserId};
							}

							_log.warn(
								"CreditTypePersistenceImpl.fetchBygetByMypageUserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CreditType creditType = list.get(0);

					result = creditType;

					cacheResult(creditType);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CreditType)result;
		}
	}

	/**
	 * Removes the credit type where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the credit type that was removed
	 */
	@Override
	public CreditType removeBygetByMypageUserId(long mypageUserId)
		throws NoSuchCreditTypeException {

		CreditType creditType = findBygetByMypageUserId(mypageUserId);

		return remove(creditType);
	}

	/**
	 * Returns the number of credit types where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching credit types
	 */
	@Override
	public int countBygetByMypageUserId(long mypageUserId) {
		FinderPath finderPath = _finderPathCountBygetByMypageUserId;

		Object[] finderArgs = new Object[] {mypageUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CREDITTYPE_WHERE);

			sb.append(_FINDER_COLUMN_GETBYMYPAGEUSERID_MYPAGEUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String
		_FINDER_COLUMN_GETBYMYPAGEUSERID_MYPAGEUSERID_2 =
			"creditType.mypageUserId = ?";

	public CreditTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("limit", "limit_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CreditType.class);

		setModelImplClass(CreditTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the credit type in the entity cache if it is enabled.
	 *
	 * @param creditType the credit type
	 */
	@Override
	public void cacheResult(CreditType creditType) {
		entityCache.putResult(
			CreditTypeImpl.class, creditType.getPrimaryKey(), creditType);

		finderCache.putResult(
			_finderPathFetchBygetByMypageUserId,
			new Object[] {creditType.getMypageUserId()}, creditType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the credit types in the entity cache if it is enabled.
	 *
	 * @param creditTypes the credit types
	 */
	@Override
	public void cacheResult(List<CreditType> creditTypes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (creditTypes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CreditType creditType : creditTypes) {
			if (entityCache.getResult(
					CreditTypeImpl.class, creditType.getPrimaryKey()) == null) {

				cacheResult(creditType);
			}
		}
	}

	/**
	 * Clears the cache for all credit types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CreditTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the credit type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CreditType creditType) {
		entityCache.removeResult(CreditTypeImpl.class, creditType);
	}

	@Override
	public void clearCache(List<CreditType> creditTypes) {
		for (CreditType creditType : creditTypes) {
			entityCache.removeResult(CreditTypeImpl.class, creditType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CreditTypeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CreditTypeModelImpl creditTypeModelImpl) {

		Object[] args = new Object[] {creditTypeModelImpl.getMypageUserId()};

		finderCache.putResult(
			_finderPathCountBygetByMypageUserId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBygetByMypageUserId, args, creditTypeModelImpl,
			false);
	}

	/**
	 * Creates a new credit type with the primary key. Does not add the credit type to the database.
	 *
	 * @param creditTypeId the primary key for the new credit type
	 * @return the new credit type
	 */
	@Override
	public CreditType create(long creditTypeId) {
		CreditType creditType = new CreditTypeImpl();

		creditType.setNew(true);
		creditType.setPrimaryKey(creditTypeId);

		creditType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return creditType;
	}

	/**
	 * Removes the credit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creditTypeId the primary key of the credit type
	 * @return the credit type that was removed
	 * @throws NoSuchCreditTypeException if a credit type with the primary key could not be found
	 */
	@Override
	public CreditType remove(long creditTypeId)
		throws NoSuchCreditTypeException {

		return remove((Serializable)creditTypeId);
	}

	/**
	 * Removes the credit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the credit type
	 * @return the credit type that was removed
	 * @throws NoSuchCreditTypeException if a credit type with the primary key could not be found
	 */
	@Override
	public CreditType remove(Serializable primaryKey)
		throws NoSuchCreditTypeException {

		Session session = null;

		try {
			session = openSession();

			CreditType creditType = (CreditType)session.get(
				CreditTypeImpl.class, primaryKey);

			if (creditType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCreditTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(creditType);
		}
		catch (NoSuchCreditTypeException noSuchEntityException) {
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
	protected CreditType removeImpl(CreditType creditType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(creditType)) {
				creditType = (CreditType)session.get(
					CreditTypeImpl.class, creditType.getPrimaryKeyObj());
			}

			if (creditType != null) {
				session.delete(creditType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (creditType != null) {
			clearCache(creditType);
		}

		return creditType;
	}

	@Override
	public CreditType updateImpl(CreditType creditType) {
		boolean isNew = creditType.isNew();

		if (!(creditType instanceof CreditTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(creditType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(creditType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in creditType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CreditType implementation " +
					creditType.getClass());
		}

		CreditTypeModelImpl creditTypeModelImpl =
			(CreditTypeModelImpl)creditType;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (creditType.getCreateDate() == null)) {
			if (serviceContext == null) {
				creditType.setCreateDate(date);
			}
			else {
				creditType.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!creditTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				creditType.setModifiedDate(date);
			}
			else {
				creditType.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(creditType);
			}
			else {
				creditType = (CreditType)session.merge(creditType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CreditTypeImpl.class, creditTypeModelImpl, false, true);

		cacheUniqueFindersCache(creditTypeModelImpl);

		if (isNew) {
			creditType.setNew(false);
		}

		creditType.resetOriginalValues();

		return creditType;
	}

	/**
	 * Returns the credit type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the credit type
	 * @return the credit type
	 * @throws NoSuchCreditTypeException if a credit type with the primary key could not be found
	 */
	@Override
	public CreditType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCreditTypeException {

		CreditType creditType = fetchByPrimaryKey(primaryKey);

		if (creditType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCreditTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return creditType;
	}

	/**
	 * Returns the credit type with the primary key or throws a <code>NoSuchCreditTypeException</code> if it could not be found.
	 *
	 * @param creditTypeId the primary key of the credit type
	 * @return the credit type
	 * @throws NoSuchCreditTypeException if a credit type with the primary key could not be found
	 */
	@Override
	public CreditType findByPrimaryKey(long creditTypeId)
		throws NoSuchCreditTypeException {

		return findByPrimaryKey((Serializable)creditTypeId);
	}

	/**
	 * Returns the credit type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param creditTypeId the primary key of the credit type
	 * @return the credit type, or <code>null</code> if a credit type with the primary key could not be found
	 */
	@Override
	public CreditType fetchByPrimaryKey(long creditTypeId) {
		return fetchByPrimaryKey((Serializable)creditTypeId);
	}

	/**
	 * Returns all the credit types.
	 *
	 * @return the credit types
	 */
	@Override
	public List<CreditType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit types
	 * @param end the upper bound of the range of credit types (not inclusive)
	 * @return the range of credit types
	 */
	@Override
	public List<CreditType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit types
	 * @param end the upper bound of the range of credit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of credit types
	 */
	@Override
	public List<CreditType> findAll(
		int start, int end, OrderByComparator<CreditType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the credit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit types
	 * @param end the upper bound of the range of credit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of credit types
	 */
	@Override
	public List<CreditType> findAll(
		int start, int end, OrderByComparator<CreditType> orderByComparator,
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

		List<CreditType> list = null;

		if (useFinderCache) {
			list = (List<CreditType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CREDITTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CREDITTYPE;

				sql = sql.concat(CreditTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CreditType>)QueryUtil.list(
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
	 * Removes all the credit types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CreditType creditType : findAll()) {
			remove(creditType);
		}
	}

	/**
	 * Returns the number of credit types.
	 *
	 * @return the number of credit types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CREDITTYPE);

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
		return "creditTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CREDITTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CreditTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the credit type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CreditTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CreditType.class.getName()));

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

		_finderPathFetchBygetByMypageUserId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBygetByMypageUserId",
			new String[] {Long.class.getName()}, new String[] {"mypageUserId"},
			true);

		_finderPathCountBygetByMypageUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBygetByMypageUserId", new String[] {Long.class.getName()},
			new String[] {"mypageUserId"}, false);

		_setCreditTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCreditTypeUtilPersistence(null);

		entityCache.removeCache(CreditTypeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setCreditTypeUtilPersistence(
		CreditTypePersistence creditTypePersistence) {

		try {
			Field field = CreditTypeUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, creditTypePersistence);
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

	private static final String _SQL_SELECT_CREDITTYPE =
		"SELECT creditType FROM CreditType creditType";

	private static final String _SQL_SELECT_CREDITTYPE_WHERE =
		"SELECT creditType FROM CreditType creditType WHERE ";

	private static final String _SQL_COUNT_CREDITTYPE =
		"SELECT COUNT(creditType) FROM CreditType creditType";

	private static final String _SQL_COUNT_CREDITTYPE_WHERE =
		"SELECT COUNT(creditType) FROM CreditType creditType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "creditType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CreditType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CreditType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CreditTypePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"limit", "active"});

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

	private static class CreditTypeModelArgumentsResolver
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

			CreditTypeModelImpl creditTypeModelImpl =
				(CreditTypeModelImpl)baseModel;

			long columnBitmask = creditTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(creditTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						creditTypeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(creditTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			CreditTypeModelImpl creditTypeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = creditTypeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = creditTypeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}