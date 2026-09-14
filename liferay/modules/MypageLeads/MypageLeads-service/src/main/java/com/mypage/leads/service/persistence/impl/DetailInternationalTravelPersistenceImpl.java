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

import com.mypage.leads.exception.NoSuchDetailInternationalTravelException;
import com.mypage.leads.model.DetailInternationalTravel;
import com.mypage.leads.model.impl.DetailInternationalTravelImpl;
import com.mypage.leads.model.impl.DetailInternationalTravelModelImpl;
import com.mypage.leads.service.persistence.DetailInternationalTravelPersistence;
import com.mypage.leads.service.persistence.DetailInternationalTravelUtil;
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
 * The persistence implementation for the detail international travel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @generated
 */
@Component(service = DetailInternationalTravelPersistence.class)
public class DetailInternationalTravelPersistenceImpl
	extends BasePersistenceImpl<DetailInternationalTravel>
	implements DetailInternationalTravelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DetailInternationalTravelUtil</code> to access the detail international travel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DetailInternationalTravelImpl.class.getName();

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
	 * Returns the detail international travel where LeadsId = &#63; or throws a <code>NoSuchDetailInternationalTravelException</code> if it could not be found.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail international travel
	 * @throws NoSuchDetailInternationalTravelException if a matching detail international travel could not be found
	 */
	@Override
	public DetailInternationalTravel findBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailInternationalTravelException {

		DetailInternationalTravel detailInternationalTravel =
			fetchBysearchByLeadsId(LeadsId);

		if (detailInternationalTravel == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("LeadsId=");
			sb.append(LeadsId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDetailInternationalTravelException(sb.toString());
		}

		return detailInternationalTravel;
	}

	/**
	 * Returns the detail international travel where LeadsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail international travel, or <code>null</code> if a matching detail international travel could not be found
	 */
	@Override
	public DetailInternationalTravel fetchBysearchByLeadsId(long LeadsId) {
		return fetchBysearchByLeadsId(LeadsId, true);
	}

	/**
	 * Returns the detail international travel where LeadsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching detail international travel, or <code>null</code> if a matching detail international travel could not be found
	 */
	@Override
	public DetailInternationalTravel fetchBysearchByLeadsId(
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

		if (result instanceof DetailInternationalTravel) {
			DetailInternationalTravel detailInternationalTravel =
				(DetailInternationalTravel)result;

			if (LeadsId != detailInternationalTravel.getLeadsId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DETAILINTERNATIONALTRAVEL_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYLEADSID_LEADSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(LeadsId);

				List<DetailInternationalTravel> list = query.list();

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
								"DetailInternationalTravelPersistenceImpl.fetchBysearchByLeadsId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DetailInternationalTravel detailInternationalTravel =
						list.get(0);

					result = detailInternationalTravel;

					cacheResult(detailInternationalTravel);
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
			return (DetailInternationalTravel)result;
		}
	}

	/**
	 * Removes the detail international travel where LeadsId = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 * @return the detail international travel that was removed
	 */
	@Override
	public DetailInternationalTravel removeBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailInternationalTravelException {

		DetailInternationalTravel detailInternationalTravel =
			findBysearchByLeadsId(LeadsId);

		return remove(detailInternationalTravel);
	}

	/**
	 * Returns the number of detail international travels where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the number of matching detail international travels
	 */
	@Override
	public int countBysearchByLeadsId(long LeadsId) {
		FinderPath finderPath = _finderPathCountBysearchByLeadsId;

		Object[] finderArgs = new Object[] {LeadsId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DETAILINTERNATIONALTRAVEL_WHERE);

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
		"detailInternationalTravel.LeadsId = ?";

	public DetailInternationalTravelPersistenceImpl() {
		setModelClass(DetailInternationalTravel.class);

		setModelImplClass(DetailInternationalTravelImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the detail international travel in the entity cache if it is enabled.
	 *
	 * @param detailInternationalTravel the detail international travel
	 */
	@Override
	public void cacheResult(
		DetailInternationalTravel detailInternationalTravel) {

		entityCache.putResult(
			DetailInternationalTravelImpl.class,
			detailInternationalTravel.getPrimaryKey(),
			detailInternationalTravel);

		finderCache.putResult(
			_finderPathFetchBysearchByLeadsId,
			new Object[] {detailInternationalTravel.getLeadsId()},
			detailInternationalTravel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the detail international travels in the entity cache if it is enabled.
	 *
	 * @param detailInternationalTravels the detail international travels
	 */
	@Override
	public void cacheResult(
		List<DetailInternationalTravel> detailInternationalTravels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (detailInternationalTravels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DetailInternationalTravel detailInternationalTravel :
				detailInternationalTravels) {

			if (entityCache.getResult(
					DetailInternationalTravelImpl.class,
					detailInternationalTravel.getPrimaryKey()) == null) {

				cacheResult(detailInternationalTravel);
			}
		}
	}

	/**
	 * Clears the cache for all detail international travels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DetailInternationalTravelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the detail international travel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		DetailInternationalTravel detailInternationalTravel) {

		entityCache.removeResult(
			DetailInternationalTravelImpl.class, detailInternationalTravel);
	}

	@Override
	public void clearCache(
		List<DetailInternationalTravel> detailInternationalTravels) {

		for (DetailInternationalTravel detailInternationalTravel :
				detailInternationalTravels) {

			entityCache.removeResult(
				DetailInternationalTravelImpl.class, detailInternationalTravel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				DetailInternationalTravelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DetailInternationalTravelModelImpl detailInternationalTravelModelImpl) {

		Object[] args = new Object[] {
			detailInternationalTravelModelImpl.getLeadsId()
		};

		finderCache.putResult(
			_finderPathCountBysearchByLeadsId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBysearchByLeadsId, args,
			detailInternationalTravelModelImpl, false);
	}

	/**
	 * Creates a new detail international travel with the primary key. Does not add the detail international travel to the database.
	 *
	 * @param DetailId the primary key for the new detail international travel
	 * @return the new detail international travel
	 */
	@Override
	public DetailInternationalTravel create(long DetailId) {
		DetailInternationalTravel detailInternationalTravel =
			new DetailInternationalTravelImpl();

		detailInternationalTravel.setNew(true);
		detailInternationalTravel.setPrimaryKey(DetailId);

		detailInternationalTravel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return detailInternationalTravel;
	}

	/**
	 * Removes the detail international travel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param DetailId the primary key of the detail international travel
	 * @return the detail international travel that was removed
	 * @throws NoSuchDetailInternationalTravelException if a detail international travel with the primary key could not be found
	 */
	@Override
	public DetailInternationalTravel remove(long DetailId)
		throws NoSuchDetailInternationalTravelException {

		return remove((Serializable)DetailId);
	}

	/**
	 * Removes the detail international travel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the detail international travel
	 * @return the detail international travel that was removed
	 * @throws NoSuchDetailInternationalTravelException if a detail international travel with the primary key could not be found
	 */
	@Override
	public DetailInternationalTravel remove(Serializable primaryKey)
		throws NoSuchDetailInternationalTravelException {

		Session session = null;

		try {
			session = openSession();

			DetailInternationalTravel detailInternationalTravel =
				(DetailInternationalTravel)session.get(
					DetailInternationalTravelImpl.class, primaryKey);

			if (detailInternationalTravel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDetailInternationalTravelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(detailInternationalTravel);
		}
		catch (NoSuchDetailInternationalTravelException noSuchEntityException) {
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
	protected DetailInternationalTravel removeImpl(
		DetailInternationalTravel detailInternationalTravel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(detailInternationalTravel)) {
				detailInternationalTravel =
					(DetailInternationalTravel)session.get(
						DetailInternationalTravelImpl.class,
						detailInternationalTravel.getPrimaryKeyObj());
			}

			if (detailInternationalTravel != null) {
				session.delete(detailInternationalTravel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (detailInternationalTravel != null) {
			clearCache(detailInternationalTravel);
		}

		return detailInternationalTravel;
	}

	@Override
	public DetailInternationalTravel updateImpl(
		DetailInternationalTravel detailInternationalTravel) {

		boolean isNew = detailInternationalTravel.isNew();

		if (!(detailInternationalTravel instanceof
				DetailInternationalTravelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(detailInternationalTravel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					detailInternationalTravel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in detailInternationalTravel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DetailInternationalTravel implementation " +
					detailInternationalTravel.getClass());
		}

		DetailInternationalTravelModelImpl detailInternationalTravelModelImpl =
			(DetailInternationalTravelModelImpl)detailInternationalTravel;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (detailInternationalTravel.getCreateDate() == null)) {
			if (serviceContext == null) {
				detailInternationalTravel.setCreateDate(date);
			}
			else {
				detailInternationalTravel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!detailInternationalTravelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				detailInternationalTravel.setModifiedDate(date);
			}
			else {
				detailInternationalTravel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(detailInternationalTravel);
			}
			else {
				detailInternationalTravel =
					(DetailInternationalTravel)session.merge(
						detailInternationalTravel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DetailInternationalTravelImpl.class,
			detailInternationalTravelModelImpl, false, true);

		cacheUniqueFindersCache(detailInternationalTravelModelImpl);

		if (isNew) {
			detailInternationalTravel.setNew(false);
		}

		detailInternationalTravel.resetOriginalValues();

		return detailInternationalTravel;
	}

	/**
	 * Returns the detail international travel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the detail international travel
	 * @return the detail international travel
	 * @throws NoSuchDetailInternationalTravelException if a detail international travel with the primary key could not be found
	 */
	@Override
	public DetailInternationalTravel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDetailInternationalTravelException {

		DetailInternationalTravel detailInternationalTravel = fetchByPrimaryKey(
			primaryKey);

		if (detailInternationalTravel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDetailInternationalTravelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return detailInternationalTravel;
	}

	/**
	 * Returns the detail international travel with the primary key or throws a <code>NoSuchDetailInternationalTravelException</code> if it could not be found.
	 *
	 * @param DetailId the primary key of the detail international travel
	 * @return the detail international travel
	 * @throws NoSuchDetailInternationalTravelException if a detail international travel with the primary key could not be found
	 */
	@Override
	public DetailInternationalTravel findByPrimaryKey(long DetailId)
		throws NoSuchDetailInternationalTravelException {

		return findByPrimaryKey((Serializable)DetailId);
	}

	/**
	 * Returns the detail international travel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param DetailId the primary key of the detail international travel
	 * @return the detail international travel, or <code>null</code> if a detail international travel with the primary key could not be found
	 */
	@Override
	public DetailInternationalTravel fetchByPrimaryKey(long DetailId) {
		return fetchByPrimaryKey((Serializable)DetailId);
	}

	/**
	 * Returns all the detail international travels.
	 *
	 * @return the detail international travels
	 */
	@Override
	public List<DetailInternationalTravel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the detail international travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailInternationalTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail international travels
	 * @param end the upper bound of the range of detail international travels (not inclusive)
	 * @return the range of detail international travels
	 */
	@Override
	public List<DetailInternationalTravel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the detail international travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailInternationalTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail international travels
	 * @param end the upper bound of the range of detail international travels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail international travels
	 */
	@Override
	public List<DetailInternationalTravel> findAll(
		int start, int end,
		OrderByComparator<DetailInternationalTravel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the detail international travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailInternationalTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail international travels
	 * @param end the upper bound of the range of detail international travels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail international travels
	 */
	@Override
	public List<DetailInternationalTravel> findAll(
		int start, int end,
		OrderByComparator<DetailInternationalTravel> orderByComparator,
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

		List<DetailInternationalTravel> list = null;

		if (useFinderCache) {
			list = (List<DetailInternationalTravel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DETAILINTERNATIONALTRAVEL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DETAILINTERNATIONALTRAVEL;

				sql = sql.concat(
					DetailInternationalTravelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DetailInternationalTravel>)QueryUtil.list(
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
	 * Removes all the detail international travels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DetailInternationalTravel detailInternationalTravel : findAll()) {
			remove(detailInternationalTravel);
		}
	}

	/**
	 * Returns the number of detail international travels.
	 *
	 * @return the number of detail international travels
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
					_SQL_COUNT_DETAILINTERNATIONALTRAVEL);

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
		return "DetailId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DETAILINTERNATIONALTRAVEL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DetailInternationalTravelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the detail international travel persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new DetailInternationalTravelModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DetailInternationalTravel.class.getName()));

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

		_setDetailInternationalTravelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDetailInternationalTravelUtilPersistence(null);

		entityCache.removeCache(DetailInternationalTravelImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setDetailInternationalTravelUtilPersistence(
		DetailInternationalTravelPersistence
			detailInternationalTravelPersistence) {

		try {
			Field field = DetailInternationalTravelUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, detailInternationalTravelPersistence);
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

	private static final String _SQL_SELECT_DETAILINTERNATIONALTRAVEL =
		"SELECT detailInternationalTravel FROM DetailInternationalTravel detailInternationalTravel";

	private static final String _SQL_SELECT_DETAILINTERNATIONALTRAVEL_WHERE =
		"SELECT detailInternationalTravel FROM DetailInternationalTravel detailInternationalTravel WHERE ";

	private static final String _SQL_COUNT_DETAILINTERNATIONALTRAVEL =
		"SELECT COUNT(detailInternationalTravel) FROM DetailInternationalTravel detailInternationalTravel";

	private static final String _SQL_COUNT_DETAILINTERNATIONALTRAVEL_WHERE =
		"SELECT COUNT(detailInternationalTravel) FROM DetailInternationalTravel detailInternationalTravel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"detailInternationalTravel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DetailInternationalTravel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DetailInternationalTravel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DetailInternationalTravelPersistenceImpl.class);

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

	private static class DetailInternationalTravelModelArgumentsResolver
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

			DetailInternationalTravelModelImpl
				detailInternationalTravelModelImpl =
					(DetailInternationalTravelModelImpl)baseModel;

			long columnBitmask =
				detailInternationalTravelModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					detailInternationalTravelModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						detailInternationalTravelModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					detailInternationalTravelModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			DetailInternationalTravelModelImpl
				detailInternationalTravelModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						detailInternationalTravelModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						detailInternationalTravelModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}