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

import com.mypage.admin.product.exception.NoSuchSmartActiveOccupationException;
import com.mypage.admin.product.model.SmartActiveOccupation;
import com.mypage.admin.product.model.impl.SmartActiveOccupationImpl;
import com.mypage.admin.product.model.impl.SmartActiveOccupationModelImpl;
import com.mypage.admin.product.service.persistence.SmartActiveOccupationPersistence;
import com.mypage.admin.product.service.persistence.SmartActiveOccupationUtil;
import com.mypage.admin.product.service.persistence.impl.constants.MPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
 * The persistence implementation for the smart active occupation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = SmartActiveOccupationPersistence.class)
public class SmartActiveOccupationPersistenceImpl
	extends BasePersistenceImpl<SmartActiveOccupation>
	implements SmartActiveOccupationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SmartActiveOccupationUtil</code> to access the smart active occupation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SmartActiveOccupationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBycode;
	private FinderPath _finderPathCountBycode;

	/**
	 * Returns the smart active occupation where code = &#63; or throws a <code>NoSuchSmartActiveOccupationException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching smart active occupation
	 * @throws NoSuchSmartActiveOccupationException if a matching smart active occupation could not be found
	 */
	@Override
	public SmartActiveOccupation findBycode(String code)
		throws NoSuchSmartActiveOccupationException {

		SmartActiveOccupation smartActiveOccupation = fetchBycode(code);

		if (smartActiveOccupation == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("code=");
			sb.append(code);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSmartActiveOccupationException(sb.toString());
		}

		return smartActiveOccupation;
	}

	/**
	 * Returns the smart active occupation where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching smart active occupation, or <code>null</code> if a matching smart active occupation could not be found
	 */
	@Override
	public SmartActiveOccupation fetchBycode(String code) {
		return fetchBycode(code, true);
	}

	/**
	 * Returns the smart active occupation where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active occupation, or <code>null</code> if a matching smart active occupation could not be found
	 */
	@Override
	public SmartActiveOccupation fetchBycode(
		String code, boolean useFinderCache) {

		code = Objects.toString(code, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {code};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBycode, finderArgs, this);
		}

		if (result instanceof SmartActiveOccupation) {
			SmartActiveOccupation smartActiveOccupation =
				(SmartActiveOccupation)result;

			if (!Objects.equals(code, smartActiveOccupation.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SMARTACTIVEOCCUPATION_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
				}

				List<SmartActiveOccupation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBycode, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {code};
							}

							_log.warn(
								"SmartActiveOccupationPersistenceImpl.fetchBycode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SmartActiveOccupation smartActiveOccupation = list.get(0);

					result = smartActiveOccupation;

					cacheResult(smartActiveOccupation);
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
			return (SmartActiveOccupation)result;
		}
	}

	/**
	 * Removes the smart active occupation where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the smart active occupation that was removed
	 */
	@Override
	public SmartActiveOccupation removeBycode(String code)
		throws NoSuchSmartActiveOccupationException {

		SmartActiveOccupation smartActiveOccupation = findBycode(code);

		return remove(smartActiveOccupation);
	}

	/**
	 * Returns the number of smart active occupations where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching smart active occupations
	 */
	@Override
	public int countBycode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountBycode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SMARTACTIVEOCCUPATION_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
				}

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

	private static final String _FINDER_COLUMN_CODE_CODE_2 =
		"smartActiveOccupation.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(smartActiveOccupation.code IS NULL OR smartActiveOccupation.code = '')";

	public SmartActiveOccupationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SmartActiveOccupation.class);

		setModelImplClass(SmartActiveOccupationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the smart active occupation in the entity cache if it is enabled.
	 *
	 * @param smartActiveOccupation the smart active occupation
	 */
	@Override
	public void cacheResult(SmartActiveOccupation smartActiveOccupation) {
		entityCache.putResult(
			SmartActiveOccupationImpl.class,
			smartActiveOccupation.getPrimaryKey(), smartActiveOccupation);

		finderCache.putResult(
			_finderPathFetchBycode,
			new Object[] {smartActiveOccupation.getCode()},
			smartActiveOccupation);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the smart active occupations in the entity cache if it is enabled.
	 *
	 * @param smartActiveOccupations the smart active occupations
	 */
	@Override
	public void cacheResult(
		List<SmartActiveOccupation> smartActiveOccupations) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (smartActiveOccupations.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SmartActiveOccupation smartActiveOccupation :
				smartActiveOccupations) {

			if (entityCache.getResult(
					SmartActiveOccupationImpl.class,
					smartActiveOccupation.getPrimaryKey()) == null) {

				cacheResult(smartActiveOccupation);
			}
		}
	}

	/**
	 * Clears the cache for all smart active occupations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SmartActiveOccupationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the smart active occupation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SmartActiveOccupation smartActiveOccupation) {
		entityCache.removeResult(
			SmartActiveOccupationImpl.class, smartActiveOccupation);
	}

	@Override
	public void clearCache(List<SmartActiveOccupation> smartActiveOccupations) {
		for (SmartActiveOccupation smartActiveOccupation :
				smartActiveOccupations) {

			entityCache.removeResult(
				SmartActiveOccupationImpl.class, smartActiveOccupation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				SmartActiveOccupationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SmartActiveOccupationModelImpl smartActiveOccupationModelImpl) {

		Object[] args = new Object[] {smartActiveOccupationModelImpl.getCode()};

		finderCache.putResult(
			_finderPathCountBycode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBycode, args, smartActiveOccupationModelImpl,
			false);
	}

	/**
	 * Creates a new smart active occupation with the primary key. Does not add the smart active occupation to the database.
	 *
	 * @param smartActiveOccupationId the primary key for the new smart active occupation
	 * @return the new smart active occupation
	 */
	@Override
	public SmartActiveOccupation create(long smartActiveOccupationId) {
		SmartActiveOccupation smartActiveOccupation =
			new SmartActiveOccupationImpl();

		smartActiveOccupation.setNew(true);
		smartActiveOccupation.setPrimaryKey(smartActiveOccupationId);

		smartActiveOccupation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return smartActiveOccupation;
	}

	/**
	 * Removes the smart active occupation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveOccupationId the primary key of the smart active occupation
	 * @return the smart active occupation that was removed
	 * @throws NoSuchSmartActiveOccupationException if a smart active occupation with the primary key could not be found
	 */
	@Override
	public SmartActiveOccupation remove(long smartActiveOccupationId)
		throws NoSuchSmartActiveOccupationException {

		return remove((Serializable)smartActiveOccupationId);
	}

	/**
	 * Removes the smart active occupation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the smart active occupation
	 * @return the smart active occupation that was removed
	 * @throws NoSuchSmartActiveOccupationException if a smart active occupation with the primary key could not be found
	 */
	@Override
	public SmartActiveOccupation remove(Serializable primaryKey)
		throws NoSuchSmartActiveOccupationException {

		Session session = null;

		try {
			session = openSession();

			SmartActiveOccupation smartActiveOccupation =
				(SmartActiveOccupation)session.get(
					SmartActiveOccupationImpl.class, primaryKey);

			if (smartActiveOccupation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSmartActiveOccupationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(smartActiveOccupation);
		}
		catch (NoSuchSmartActiveOccupationException noSuchEntityException) {
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
	protected SmartActiveOccupation removeImpl(
		SmartActiveOccupation smartActiveOccupation) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(smartActiveOccupation)) {
				smartActiveOccupation = (SmartActiveOccupation)session.get(
					SmartActiveOccupationImpl.class,
					smartActiveOccupation.getPrimaryKeyObj());
			}

			if (smartActiveOccupation != null) {
				session.delete(smartActiveOccupation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (smartActiveOccupation != null) {
			clearCache(smartActiveOccupation);
		}

		return smartActiveOccupation;
	}

	@Override
	public SmartActiveOccupation updateImpl(
		SmartActiveOccupation smartActiveOccupation) {

		boolean isNew = smartActiveOccupation.isNew();

		if (!(smartActiveOccupation instanceof
				SmartActiveOccupationModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(smartActiveOccupation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					smartActiveOccupation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in smartActiveOccupation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SmartActiveOccupation implementation " +
					smartActiveOccupation.getClass());
		}

		SmartActiveOccupationModelImpl smartActiveOccupationModelImpl =
			(SmartActiveOccupationModelImpl)smartActiveOccupation;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (smartActiveOccupation.getCreateDate() == null)) {
			if (serviceContext == null) {
				smartActiveOccupation.setCreateDate(date);
			}
			else {
				smartActiveOccupation.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!smartActiveOccupationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				smartActiveOccupation.setModifiedDate(date);
			}
			else {
				smartActiveOccupation.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(smartActiveOccupation);
			}
			else {
				smartActiveOccupation = (SmartActiveOccupation)session.merge(
					smartActiveOccupation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SmartActiveOccupationImpl.class, smartActiveOccupationModelImpl,
			false, true);

		cacheUniqueFindersCache(smartActiveOccupationModelImpl);

		if (isNew) {
			smartActiveOccupation.setNew(false);
		}

		smartActiveOccupation.resetOriginalValues();

		return smartActiveOccupation;
	}

	/**
	 * Returns the smart active occupation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the smart active occupation
	 * @return the smart active occupation
	 * @throws NoSuchSmartActiveOccupationException if a smart active occupation with the primary key could not be found
	 */
	@Override
	public SmartActiveOccupation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSmartActiveOccupationException {

		SmartActiveOccupation smartActiveOccupation = fetchByPrimaryKey(
			primaryKey);

		if (smartActiveOccupation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSmartActiveOccupationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return smartActiveOccupation;
	}

	/**
	 * Returns the smart active occupation with the primary key or throws a <code>NoSuchSmartActiveOccupationException</code> if it could not be found.
	 *
	 * @param smartActiveOccupationId the primary key of the smart active occupation
	 * @return the smart active occupation
	 * @throws NoSuchSmartActiveOccupationException if a smart active occupation with the primary key could not be found
	 */
	@Override
	public SmartActiveOccupation findByPrimaryKey(long smartActiveOccupationId)
		throws NoSuchSmartActiveOccupationException {

		return findByPrimaryKey((Serializable)smartActiveOccupationId);
	}

	/**
	 * Returns the smart active occupation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveOccupationId the primary key of the smart active occupation
	 * @return the smart active occupation, or <code>null</code> if a smart active occupation with the primary key could not be found
	 */
	@Override
	public SmartActiveOccupation fetchByPrimaryKey(
		long smartActiveOccupationId) {

		return fetchByPrimaryKey((Serializable)smartActiveOccupationId);
	}

	/**
	 * Returns all the smart active occupations.
	 *
	 * @return the smart active occupations
	 */
	@Override
	public List<SmartActiveOccupation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smart active occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active occupations
	 * @param end the upper bound of the range of smart active occupations (not inclusive)
	 * @return the range of smart active occupations
	 */
	@Override
	public List<SmartActiveOccupation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart active occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active occupations
	 * @param end the upper bound of the range of smart active occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active occupations
	 */
	@Override
	public List<SmartActiveOccupation> findAll(
		int start, int end,
		OrderByComparator<SmartActiveOccupation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart active occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active occupations
	 * @param end the upper bound of the range of smart active occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active occupations
	 */
	@Override
	public List<SmartActiveOccupation> findAll(
		int start, int end,
		OrderByComparator<SmartActiveOccupation> orderByComparator,
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

		List<SmartActiveOccupation> list = null;

		if (useFinderCache) {
			list = (List<SmartActiveOccupation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SMARTACTIVEOCCUPATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SMARTACTIVEOCCUPATION;

				sql = sql.concat(SmartActiveOccupationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SmartActiveOccupation>)QueryUtil.list(
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
	 * Removes all the smart active occupations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SmartActiveOccupation smartActiveOccupation : findAll()) {
			remove(smartActiveOccupation);
		}
	}

	/**
	 * Returns the number of smart active occupations.
	 *
	 * @return the number of smart active occupations
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
					_SQL_COUNT_SMARTACTIVEOCCUPATION);

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
		return "smartActiveOccupationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SMARTACTIVEOCCUPATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SmartActiveOccupationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the smart active occupation persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SmartActiveOccupationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SmartActiveOccupation.class.getName()));

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

		_finderPathFetchBycode = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBycode",
			new String[] {String.class.getName()}, new String[] {"code_"},
			true);

		_finderPathCountBycode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycode",
			new String[] {String.class.getName()}, new String[] {"code_"},
			false);

		_setSmartActiveOccupationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSmartActiveOccupationUtilPersistence(null);

		entityCache.removeCache(SmartActiveOccupationImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setSmartActiveOccupationUtilPersistence(
		SmartActiveOccupationPersistence smartActiveOccupationPersistence) {

		try {
			Field field = SmartActiveOccupationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, smartActiveOccupationPersistence);
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

	private static final String _SQL_SELECT_SMARTACTIVEOCCUPATION =
		"SELECT smartActiveOccupation FROM SmartActiveOccupation smartActiveOccupation";

	private static final String _SQL_SELECT_SMARTACTIVEOCCUPATION_WHERE =
		"SELECT smartActiveOccupation FROM SmartActiveOccupation smartActiveOccupation WHERE ";

	private static final String _SQL_COUNT_SMARTACTIVEOCCUPATION =
		"SELECT COUNT(smartActiveOccupation) FROM SmartActiveOccupation smartActiveOccupation";

	private static final String _SQL_COUNT_SMARTACTIVEOCCUPATION_WHERE =
		"SELECT COUNT(smartActiveOccupation) FROM SmartActiveOccupation smartActiveOccupation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"smartActiveOccupation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SmartActiveOccupation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SmartActiveOccupation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SmartActiveOccupationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"code", "active"});

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

	private static class SmartActiveOccupationModelArgumentsResolver
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

			SmartActiveOccupationModelImpl smartActiveOccupationModelImpl =
				(SmartActiveOccupationModelImpl)baseModel;

			long columnBitmask =
				smartActiveOccupationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					smartActiveOccupationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						smartActiveOccupationModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					smartActiveOccupationModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SmartActiveOccupationModelImpl smartActiveOccupationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						smartActiveOccupationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						smartActiveOccupationModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}