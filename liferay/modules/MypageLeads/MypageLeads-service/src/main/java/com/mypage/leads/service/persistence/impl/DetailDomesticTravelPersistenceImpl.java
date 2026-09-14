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

package com.mypage.leads.service.persistence.impl;

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
import com.liferay.portal.kernel.util.StringUtil;

import com.mypage.leads.exception.NoSuchDetailDomesticTravelException;
import com.mypage.leads.model.DetailDomesticTravel;
import com.mypage.leads.model.impl.DetailDomesticTravelImpl;
import com.mypage.leads.model.impl.DetailDomesticTravelModelImpl;
import com.mypage.leads.service.persistence.DetailDomesticTravelPersistence;
import com.mypage.leads.service.persistence.DetailDomesticTravelUtil;
import com.mypage.leads.service.persistence.impl.constants.MPLPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the detail domestic travel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @generated
 */
@Component(service = DetailDomesticTravelPersistence.class)
public class DetailDomesticTravelPersistenceImpl
	extends BasePersistenceImpl<DetailDomesticTravel>
	implements DetailDomesticTravelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DetailDomesticTravelUtil</code> to access the detail domestic travel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DetailDomesticTravelImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBysearchByLeadsId;
	private FinderPath _finderPathCountBysearchByLeadsId;

	/**
	 * Returns the detail domestic travel where LeadsId = &#63; or throws a <code>NoSuchDetailDomesticTravelException</code> if it could not be found.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail domestic travel
	 * @throws NoSuchDetailDomesticTravelException if a matching detail domestic travel could not be found
	 */
	@Override
	public DetailDomesticTravel findBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailDomesticTravelException {

		DetailDomesticTravel detailDomesticTravel = fetchBysearchByLeadsId(
			LeadsId);

		if (detailDomesticTravel == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("LeadsId=");
			sb.append(LeadsId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDetailDomesticTravelException(sb.toString());
		}

		return detailDomesticTravel;
	}

	/**
	 * Returns the detail domestic travel where LeadsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail domestic travel, or <code>null</code> if a matching detail domestic travel could not be found
	 */
	@Override
	public DetailDomesticTravel fetchBysearchByLeadsId(long LeadsId) {
		return fetchBysearchByLeadsId(LeadsId, true);
	}

	/**
	 * Returns the detail domestic travel where LeadsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching detail domestic travel, or <code>null</code> if a matching detail domestic travel could not be found
	 */
	@Override
	public DetailDomesticTravel fetchBysearchByLeadsId(
		long LeadsId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {LeadsId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBysearchByLeadsId, finderArgs, this);
		}

		if (result instanceof DetailDomesticTravel) {
			DetailDomesticTravel detailDomesticTravel =
				(DetailDomesticTravel)result;

			if (LeadsId != detailDomesticTravel.getLeadsId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DETAILDOMESTICTRAVEL_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYLEADSID_LEADSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(LeadsId);

				List<DetailDomesticTravel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBysearchByLeadsId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {LeadsId};
							}

							_log.warn(
								"DetailDomesticTravelPersistenceImpl.fetchBysearchByLeadsId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DetailDomesticTravel detailDomesticTravel = list.get(0);

					result = detailDomesticTravel;

					cacheResult(detailDomesticTravel);
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
			return (DetailDomesticTravel)result;
		}
	}

	/**
	 * Removes the detail domestic travel where LeadsId = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 * @return the detail domestic travel that was removed
	 */
	@Override
	public DetailDomesticTravel removeBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailDomesticTravelException {

		DetailDomesticTravel detailDomesticTravel = findBysearchByLeadsId(
			LeadsId);

		return remove(detailDomesticTravel);
	}

	/**
	 * Returns the number of detail domestic travels where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the number of matching detail domestic travels
	 */
	@Override
	public int countBysearchByLeadsId(long LeadsId) {
		FinderPath finderPath = _finderPathCountBysearchByLeadsId;

		Object[] finderArgs = new Object[] {LeadsId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DETAILDOMESTICTRAVEL_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYLEADSID_LEADSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(LeadsId);

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

	private static final String _FINDER_COLUMN_SEARCHBYLEADSID_LEADSID_2 =
		"detailDomesticTravel.LeadsId = ?";

	public DetailDomesticTravelPersistenceImpl() {
		setModelClass(DetailDomesticTravel.class);

		setModelImplClass(DetailDomesticTravelImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the detail domestic travel in the entity cache if it is enabled.
	 *
	 * @param detailDomesticTravel the detail domestic travel
	 */
	@Override
	public void cacheResult(DetailDomesticTravel detailDomesticTravel) {
		entityCache.putResult(
			DetailDomesticTravelImpl.class,
			detailDomesticTravel.getPrimaryKey(), detailDomesticTravel);

		finderCache.putResult(
			_finderPathFetchBysearchByLeadsId,
			new Object[] {detailDomesticTravel.getLeadsId()},
			detailDomesticTravel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the detail domestic travels in the entity cache if it is enabled.
	 *
	 * @param detailDomesticTravels the detail domestic travels
	 */
	@Override
	public void cacheResult(List<DetailDomesticTravel> detailDomesticTravels) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (detailDomesticTravels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DetailDomesticTravel detailDomesticTravel :
				detailDomesticTravels) {

			if (entityCache.getResult(
					DetailDomesticTravelImpl.class,
					detailDomesticTravel.getPrimaryKey()) == null) {

				cacheResult(detailDomesticTravel);
			}
		}
	}

	/**
	 * Clears the cache for all detail domestic travels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DetailDomesticTravelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the detail domestic travel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DetailDomesticTravel detailDomesticTravel) {
		entityCache.removeResult(
			DetailDomesticTravelImpl.class, detailDomesticTravel);
	}

	@Override
	public void clearCache(List<DetailDomesticTravel> detailDomesticTravels) {
		for (DetailDomesticTravel detailDomesticTravel :
				detailDomesticTravels) {

			entityCache.removeResult(
				DetailDomesticTravelImpl.class, detailDomesticTravel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				DetailDomesticTravelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DetailDomesticTravelModelImpl detailDomesticTravelModelImpl) {

		Object[] args = new Object[] {
			detailDomesticTravelModelImpl.getLeadsId()
		};

		finderCache.putResult(
			_finderPathCountBysearchByLeadsId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBysearchByLeadsId, args,
			detailDomesticTravelModelImpl, false);
	}

	/**
	 * Creates a new detail domestic travel with the primary key. Does not add the detail domestic travel to the database.
	 *
	 * @param detailDomesticTravelId the primary key for the new detail domestic travel
	 * @return the new detail domestic travel
	 */
	@Override
	public DetailDomesticTravel create(long detailDomesticTravelId) {
		DetailDomesticTravel detailDomesticTravel =
			new DetailDomesticTravelImpl();

		detailDomesticTravel.setNew(true);
		detailDomesticTravel.setPrimaryKey(detailDomesticTravelId);

		detailDomesticTravel.setCompanyId(CompanyThreadLocal.getCompanyId());

		return detailDomesticTravel;
	}

	/**
	 * Removes the detail domestic travel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param detailDomesticTravelId the primary key of the detail domestic travel
	 * @return the detail domestic travel that was removed
	 * @throws NoSuchDetailDomesticTravelException if a detail domestic travel with the primary key could not be found
	 */
	@Override
	public DetailDomesticTravel remove(long detailDomesticTravelId)
		throws NoSuchDetailDomesticTravelException {

		return remove((Serializable)detailDomesticTravelId);
	}

	/**
	 * Removes the detail domestic travel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the detail domestic travel
	 * @return the detail domestic travel that was removed
	 * @throws NoSuchDetailDomesticTravelException if a detail domestic travel with the primary key could not be found
	 */
	@Override
	public DetailDomesticTravel remove(Serializable primaryKey)
		throws NoSuchDetailDomesticTravelException {

		Session session = null;

		try {
			session = openSession();

			DetailDomesticTravel detailDomesticTravel =
				(DetailDomesticTravel)session.get(
					DetailDomesticTravelImpl.class, primaryKey);

			if (detailDomesticTravel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDetailDomesticTravelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(detailDomesticTravel);
		}
		catch (NoSuchDetailDomesticTravelException noSuchEntityException) {
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
	protected DetailDomesticTravel removeImpl(
		DetailDomesticTravel detailDomesticTravel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(detailDomesticTravel)) {
				detailDomesticTravel = (DetailDomesticTravel)session.get(
					DetailDomesticTravelImpl.class,
					detailDomesticTravel.getPrimaryKeyObj());
			}

			if (detailDomesticTravel != null) {
				session.delete(detailDomesticTravel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (detailDomesticTravel != null) {
			clearCache(detailDomesticTravel);
		}

		return detailDomesticTravel;
	}

	@Override
	public DetailDomesticTravel updateImpl(
		DetailDomesticTravel detailDomesticTravel) {

		boolean isNew = detailDomesticTravel.isNew();

		if (!(detailDomesticTravel instanceof DetailDomesticTravelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(detailDomesticTravel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					detailDomesticTravel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in detailDomesticTravel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DetailDomesticTravel implementation " +
					detailDomesticTravel.getClass());
		}

		DetailDomesticTravelModelImpl detailDomesticTravelModelImpl =
			(DetailDomesticTravelModelImpl)detailDomesticTravel;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (detailDomesticTravel.getCreateDate() == null)) {
			if (serviceContext == null) {
				detailDomesticTravel.setCreateDate(date);
			}
			else {
				detailDomesticTravel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!detailDomesticTravelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				detailDomesticTravel.setModifiedDate(date);
			}
			else {
				detailDomesticTravel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(detailDomesticTravel);
			}
			else {
				detailDomesticTravel = (DetailDomesticTravel)session.merge(
					detailDomesticTravel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DetailDomesticTravelImpl.class, detailDomesticTravelModelImpl,
			false, true);

		cacheUniqueFindersCache(detailDomesticTravelModelImpl);

		if (isNew) {
			detailDomesticTravel.setNew(false);
		}

		detailDomesticTravel.resetOriginalValues();

		return detailDomesticTravel;
	}

	/**
	 * Returns the detail domestic travel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the detail domestic travel
	 * @return the detail domestic travel
	 * @throws NoSuchDetailDomesticTravelException if a detail domestic travel with the primary key could not be found
	 */
	@Override
	public DetailDomesticTravel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDetailDomesticTravelException {

		DetailDomesticTravel detailDomesticTravel = fetchByPrimaryKey(
			primaryKey);

		if (detailDomesticTravel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDetailDomesticTravelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return detailDomesticTravel;
	}

	/**
	 * Returns the detail domestic travel with the primary key or throws a <code>NoSuchDetailDomesticTravelException</code> if it could not be found.
	 *
	 * @param detailDomesticTravelId the primary key of the detail domestic travel
	 * @return the detail domestic travel
	 * @throws NoSuchDetailDomesticTravelException if a detail domestic travel with the primary key could not be found
	 */
	@Override
	public DetailDomesticTravel findByPrimaryKey(long detailDomesticTravelId)
		throws NoSuchDetailDomesticTravelException {

		return findByPrimaryKey((Serializable)detailDomesticTravelId);
	}

	/**
	 * Returns the detail domestic travel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param detailDomesticTravelId the primary key of the detail domestic travel
	 * @return the detail domestic travel, or <code>null</code> if a detail domestic travel with the primary key could not be found
	 */
	@Override
	public DetailDomesticTravel fetchByPrimaryKey(long detailDomesticTravelId) {
		return fetchByPrimaryKey((Serializable)detailDomesticTravelId);
	}

	/**
	 * Returns all the detail domestic travels.
	 *
	 * @return the detail domestic travels
	 */
	@Override
	public List<DetailDomesticTravel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the detail domestic travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDomesticTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail domestic travels
	 * @param end the upper bound of the range of detail domestic travels (not inclusive)
	 * @return the range of detail domestic travels
	 */
	@Override
	public List<DetailDomesticTravel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the detail domestic travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDomesticTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail domestic travels
	 * @param end the upper bound of the range of detail domestic travels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail domestic travels
	 */
	@Override
	public List<DetailDomesticTravel> findAll(
		int start, int end,
		OrderByComparator<DetailDomesticTravel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the detail domestic travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDomesticTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail domestic travels
	 * @param end the upper bound of the range of detail domestic travels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail domestic travels
	 */
	@Override
	public List<DetailDomesticTravel> findAll(
		int start, int end,
		OrderByComparator<DetailDomesticTravel> orderByComparator,
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

		List<DetailDomesticTravel> list = null;

		if (useFinderCache) {
			list = (List<DetailDomesticTravel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DETAILDOMESTICTRAVEL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DETAILDOMESTICTRAVEL;

				sql = sql.concat(DetailDomesticTravelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DetailDomesticTravel>)QueryUtil.list(
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
	 * Removes all the detail domestic travels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DetailDomesticTravel detailDomesticTravel : findAll()) {
			remove(detailDomesticTravel);
		}
	}

	/**
	 * Returns the number of detail domestic travels.
	 *
	 * @return the number of detail domestic travels
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
					_SQL_COUNT_DETAILDOMESTICTRAVEL);

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
		return "detailDomesticTravelId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DETAILDOMESTICTRAVEL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DetailDomesticTravelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the detail domestic travel persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new DetailDomesticTravelModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DetailDomesticTravel.class.getName()));

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

		_finderPathFetchBysearchByLeadsId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBysearchByLeadsId",
			new String[] {Long.class.getName()}, new String[] {"LeadsId"},
			true);

		_finderPathCountBysearchByLeadsId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchByLeadsId",
			new String[] {Long.class.getName()}, new String[] {"LeadsId"},
			false);

		_setDetailDomesticTravelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDetailDomesticTravelUtilPersistence(null);

		entityCache.removeCache(DetailDomesticTravelImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setDetailDomesticTravelUtilPersistence(
		DetailDomesticTravelPersistence detailDomesticTravelPersistence) {

		try {
			Field field = DetailDomesticTravelUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, detailDomesticTravelPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MPLPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MPLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MPLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_DETAILDOMESTICTRAVEL =
		"SELECT detailDomesticTravel FROM DetailDomesticTravel detailDomesticTravel";

	private static final String _SQL_SELECT_DETAILDOMESTICTRAVEL_WHERE =
		"SELECT detailDomesticTravel FROM DetailDomesticTravel detailDomesticTravel WHERE ";

	private static final String _SQL_COUNT_DETAILDOMESTICTRAVEL =
		"SELECT COUNT(detailDomesticTravel) FROM DetailDomesticTravel detailDomesticTravel";

	private static final String _SQL_COUNT_DETAILDOMESTICTRAVEL_WHERE =
		"SELECT COUNT(detailDomesticTravel) FROM DetailDomesticTravel detailDomesticTravel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"detailDomesticTravel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DetailDomesticTravel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DetailDomesticTravel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DetailDomesticTravelPersistenceImpl.class);

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

	private static class DetailDomesticTravelModelArgumentsResolver
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

			DetailDomesticTravelModelImpl detailDomesticTravelModelImpl =
				(DetailDomesticTravelModelImpl)baseModel;

			long columnBitmask =
				detailDomesticTravelModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					detailDomesticTravelModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						detailDomesticTravelModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					detailDomesticTravelModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			DetailDomesticTravelModelImpl detailDomesticTravelModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						detailDomesticTravelModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = detailDomesticTravelModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}