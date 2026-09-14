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

import com.mypage.leads.exception.NoSuchDetailHealthIndividuException;
import com.mypage.leads.model.DetailHealthIndividu;
import com.mypage.leads.model.impl.DetailHealthIndividuImpl;
import com.mypage.leads.model.impl.DetailHealthIndividuModelImpl;
import com.mypage.leads.service.persistence.DetailHealthIndividuPersistence;
import com.mypage.leads.service.persistence.DetailHealthIndividuUtil;
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
 * The persistence implementation for the detail health individu service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @generated
 */
@Component(service = DetailHealthIndividuPersistence.class)
public class DetailHealthIndividuPersistenceImpl
	extends BasePersistenceImpl<DetailHealthIndividu>
	implements DetailHealthIndividuPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DetailHealthIndividuUtil</code> to access the detail health individu persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DetailHealthIndividuImpl.class.getName();

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
	 * Returns the detail health individu where LeadsId = &#63; or throws a <code>NoSuchDetailHealthIndividuException</code> if it could not be found.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail health individu
	 * @throws NoSuchDetailHealthIndividuException if a matching detail health individu could not be found
	 */
	@Override
	public DetailHealthIndividu findBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailHealthIndividuException {

		DetailHealthIndividu detailHealthIndividu = fetchBysearchByLeadsId(
			LeadsId);

		if (detailHealthIndividu == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("LeadsId=");
			sb.append(LeadsId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDetailHealthIndividuException(sb.toString());
		}

		return detailHealthIndividu;
	}

	/**
	 * Returns the detail health individu where LeadsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail health individu, or <code>null</code> if a matching detail health individu could not be found
	 */
	@Override
	public DetailHealthIndividu fetchBysearchByLeadsId(long LeadsId) {
		return fetchBysearchByLeadsId(LeadsId, true);
	}

	/**
	 * Returns the detail health individu where LeadsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching detail health individu, or <code>null</code> if a matching detail health individu could not be found
	 */
	@Override
	public DetailHealthIndividu fetchBysearchByLeadsId(
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

		if (result instanceof DetailHealthIndividu) {
			DetailHealthIndividu detailHealthIndividu =
				(DetailHealthIndividu)result;

			if (LeadsId != detailHealthIndividu.getLeadsId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DETAILHEALTHINDIVIDU_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYLEADSID_LEADSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(LeadsId);

				List<DetailHealthIndividu> list = query.list();

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
								"DetailHealthIndividuPersistenceImpl.fetchBysearchByLeadsId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DetailHealthIndividu detailHealthIndividu = list.get(0);

					result = detailHealthIndividu;

					cacheResult(detailHealthIndividu);
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
			return (DetailHealthIndividu)result;
		}
	}

	/**
	 * Removes the detail health individu where LeadsId = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 * @return the detail health individu that was removed
	 */
	@Override
	public DetailHealthIndividu removeBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailHealthIndividuException {

		DetailHealthIndividu detailHealthIndividu = findBysearchByLeadsId(
			LeadsId);

		return remove(detailHealthIndividu);
	}

	/**
	 * Returns the number of detail health individus where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the number of matching detail health individus
	 */
	@Override
	public int countBysearchByLeadsId(long LeadsId) {
		FinderPath finderPath = _finderPathCountBysearchByLeadsId;

		Object[] finderArgs = new Object[] {LeadsId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DETAILHEALTHINDIVIDU_WHERE);

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
		"detailHealthIndividu.LeadsId = ?";

	public DetailHealthIndividuPersistenceImpl() {
		setModelClass(DetailHealthIndividu.class);

		setModelImplClass(DetailHealthIndividuImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the detail health individu in the entity cache if it is enabled.
	 *
	 * @param detailHealthIndividu the detail health individu
	 */
	@Override
	public void cacheResult(DetailHealthIndividu detailHealthIndividu) {
		entityCache.putResult(
			DetailHealthIndividuImpl.class,
			detailHealthIndividu.getPrimaryKey(), detailHealthIndividu);

		finderCache.putResult(
			_finderPathFetchBysearchByLeadsId,
			new Object[] {detailHealthIndividu.getLeadsId()},
			detailHealthIndividu);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the detail health individus in the entity cache if it is enabled.
	 *
	 * @param detailHealthIndividus the detail health individus
	 */
	@Override
	public void cacheResult(List<DetailHealthIndividu> detailHealthIndividus) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (detailHealthIndividus.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DetailHealthIndividu detailHealthIndividu :
				detailHealthIndividus) {

			if (entityCache.getResult(
					DetailHealthIndividuImpl.class,
					detailHealthIndividu.getPrimaryKey()) == null) {

				cacheResult(detailHealthIndividu);
			}
		}
	}

	/**
	 * Clears the cache for all detail health individus.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DetailHealthIndividuImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the detail health individu.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DetailHealthIndividu detailHealthIndividu) {
		entityCache.removeResult(
			DetailHealthIndividuImpl.class, detailHealthIndividu);
	}

	@Override
	public void clearCache(List<DetailHealthIndividu> detailHealthIndividus) {
		for (DetailHealthIndividu detailHealthIndividu :
				detailHealthIndividus) {

			entityCache.removeResult(
				DetailHealthIndividuImpl.class, detailHealthIndividu);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				DetailHealthIndividuImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DetailHealthIndividuModelImpl detailHealthIndividuModelImpl) {

		Object[] args = new Object[] {
			detailHealthIndividuModelImpl.getLeadsId()
		};

		finderCache.putResult(
			_finderPathCountBysearchByLeadsId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBysearchByLeadsId, args,
			detailHealthIndividuModelImpl, false);
	}

	/**
	 * Creates a new detail health individu with the primary key. Does not add the detail health individu to the database.
	 *
	 * @param detailHealthIndividuId the primary key for the new detail health individu
	 * @return the new detail health individu
	 */
	@Override
	public DetailHealthIndividu create(long detailHealthIndividuId) {
		DetailHealthIndividu detailHealthIndividu =
			new DetailHealthIndividuImpl();

		detailHealthIndividu.setNew(true);
		detailHealthIndividu.setPrimaryKey(detailHealthIndividuId);

		detailHealthIndividu.setCompanyId(CompanyThreadLocal.getCompanyId());

		return detailHealthIndividu;
	}

	/**
	 * Removes the detail health individu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param detailHealthIndividuId the primary key of the detail health individu
	 * @return the detail health individu that was removed
	 * @throws NoSuchDetailHealthIndividuException if a detail health individu with the primary key could not be found
	 */
	@Override
	public DetailHealthIndividu remove(long detailHealthIndividuId)
		throws NoSuchDetailHealthIndividuException {

		return remove((Serializable)detailHealthIndividuId);
	}

	/**
	 * Removes the detail health individu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the detail health individu
	 * @return the detail health individu that was removed
	 * @throws NoSuchDetailHealthIndividuException if a detail health individu with the primary key could not be found
	 */
	@Override
	public DetailHealthIndividu remove(Serializable primaryKey)
		throws NoSuchDetailHealthIndividuException {

		Session session = null;

		try {
			session = openSession();

			DetailHealthIndividu detailHealthIndividu =
				(DetailHealthIndividu)session.get(
					DetailHealthIndividuImpl.class, primaryKey);

			if (detailHealthIndividu == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDetailHealthIndividuException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(detailHealthIndividu);
		}
		catch (NoSuchDetailHealthIndividuException noSuchEntityException) {
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
	protected DetailHealthIndividu removeImpl(
		DetailHealthIndividu detailHealthIndividu) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(detailHealthIndividu)) {
				detailHealthIndividu = (DetailHealthIndividu)session.get(
					DetailHealthIndividuImpl.class,
					detailHealthIndividu.getPrimaryKeyObj());
			}

			if (detailHealthIndividu != null) {
				session.delete(detailHealthIndividu);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (detailHealthIndividu != null) {
			clearCache(detailHealthIndividu);
		}

		return detailHealthIndividu;
	}

	@Override
	public DetailHealthIndividu updateImpl(
		DetailHealthIndividu detailHealthIndividu) {

		boolean isNew = detailHealthIndividu.isNew();

		if (!(detailHealthIndividu instanceof DetailHealthIndividuModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(detailHealthIndividu.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					detailHealthIndividu);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in detailHealthIndividu proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DetailHealthIndividu implementation " +
					detailHealthIndividu.getClass());
		}

		DetailHealthIndividuModelImpl detailHealthIndividuModelImpl =
			(DetailHealthIndividuModelImpl)detailHealthIndividu;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (detailHealthIndividu.getCreateDate() == null)) {
			if (serviceContext == null) {
				detailHealthIndividu.setCreateDate(date);
			}
			else {
				detailHealthIndividu.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!detailHealthIndividuModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				detailHealthIndividu.setModifiedDate(date);
			}
			else {
				detailHealthIndividu.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(detailHealthIndividu);
			}
			else {
				detailHealthIndividu = (DetailHealthIndividu)session.merge(
					detailHealthIndividu);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DetailHealthIndividuImpl.class, detailHealthIndividuModelImpl,
			false, true);

		cacheUniqueFindersCache(detailHealthIndividuModelImpl);

		if (isNew) {
			detailHealthIndividu.setNew(false);
		}

		detailHealthIndividu.resetOriginalValues();

		return detailHealthIndividu;
	}

	/**
	 * Returns the detail health individu with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the detail health individu
	 * @return the detail health individu
	 * @throws NoSuchDetailHealthIndividuException if a detail health individu with the primary key could not be found
	 */
	@Override
	public DetailHealthIndividu findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDetailHealthIndividuException {

		DetailHealthIndividu detailHealthIndividu = fetchByPrimaryKey(
			primaryKey);

		if (detailHealthIndividu == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDetailHealthIndividuException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return detailHealthIndividu;
	}

	/**
	 * Returns the detail health individu with the primary key or throws a <code>NoSuchDetailHealthIndividuException</code> if it could not be found.
	 *
	 * @param detailHealthIndividuId the primary key of the detail health individu
	 * @return the detail health individu
	 * @throws NoSuchDetailHealthIndividuException if a detail health individu with the primary key could not be found
	 */
	@Override
	public DetailHealthIndividu findByPrimaryKey(long detailHealthIndividuId)
		throws NoSuchDetailHealthIndividuException {

		return findByPrimaryKey((Serializable)detailHealthIndividuId);
	}

	/**
	 * Returns the detail health individu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param detailHealthIndividuId the primary key of the detail health individu
	 * @return the detail health individu, or <code>null</code> if a detail health individu with the primary key could not be found
	 */
	@Override
	public DetailHealthIndividu fetchByPrimaryKey(long detailHealthIndividuId) {
		return fetchByPrimaryKey((Serializable)detailHealthIndividuId);
	}

	/**
	 * Returns all the detail health individus.
	 *
	 * @return the detail health individus
	 */
	@Override
	public List<DetailHealthIndividu> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the detail health individus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailHealthIndividuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail health individus
	 * @param end the upper bound of the range of detail health individus (not inclusive)
	 * @return the range of detail health individus
	 */
	@Override
	public List<DetailHealthIndividu> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the detail health individus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailHealthIndividuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail health individus
	 * @param end the upper bound of the range of detail health individus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail health individus
	 */
	@Override
	public List<DetailHealthIndividu> findAll(
		int start, int end,
		OrderByComparator<DetailHealthIndividu> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the detail health individus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailHealthIndividuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail health individus
	 * @param end the upper bound of the range of detail health individus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail health individus
	 */
	@Override
	public List<DetailHealthIndividu> findAll(
		int start, int end,
		OrderByComparator<DetailHealthIndividu> orderByComparator,
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

		List<DetailHealthIndividu> list = null;

		if (useFinderCache) {
			list = (List<DetailHealthIndividu>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DETAILHEALTHINDIVIDU);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DETAILHEALTHINDIVIDU;

				sql = sql.concat(DetailHealthIndividuModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DetailHealthIndividu>)QueryUtil.list(
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
	 * Removes all the detail health individus from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DetailHealthIndividu detailHealthIndividu : findAll()) {
			remove(detailHealthIndividu);
		}
	}

	/**
	 * Returns the number of detail health individus.
	 *
	 * @return the number of detail health individus
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
					_SQL_COUNT_DETAILHEALTHINDIVIDU);

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
		return "detailHealthIndividuId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DETAILHEALTHINDIVIDU;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DetailHealthIndividuModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the detail health individu persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new DetailHealthIndividuModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DetailHealthIndividu.class.getName()));

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

		_setDetailHealthIndividuUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDetailHealthIndividuUtilPersistence(null);

		entityCache.removeCache(DetailHealthIndividuImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setDetailHealthIndividuUtilPersistence(
		DetailHealthIndividuPersistence detailHealthIndividuPersistence) {

		try {
			Field field = DetailHealthIndividuUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, detailHealthIndividuPersistence);
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

	private static final String _SQL_SELECT_DETAILHEALTHINDIVIDU =
		"SELECT detailHealthIndividu FROM DetailHealthIndividu detailHealthIndividu";

	private static final String _SQL_SELECT_DETAILHEALTHINDIVIDU_WHERE =
		"SELECT detailHealthIndividu FROM DetailHealthIndividu detailHealthIndividu WHERE ";

	private static final String _SQL_COUNT_DETAILHEALTHINDIVIDU =
		"SELECT COUNT(detailHealthIndividu) FROM DetailHealthIndividu detailHealthIndividu";

	private static final String _SQL_COUNT_DETAILHEALTHINDIVIDU_WHERE =
		"SELECT COUNT(detailHealthIndividu) FROM DetailHealthIndividu detailHealthIndividu WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"detailHealthIndividu.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DetailHealthIndividu exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DetailHealthIndividu exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DetailHealthIndividuPersistenceImpl.class);

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

	private static class DetailHealthIndividuModelArgumentsResolver
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

			DetailHealthIndividuModelImpl detailHealthIndividuModelImpl =
				(DetailHealthIndividuModelImpl)baseModel;

			long columnBitmask =
				detailHealthIndividuModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					detailHealthIndividuModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						detailHealthIndividuModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					detailHealthIndividuModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			DetailHealthIndividuModelImpl detailHealthIndividuModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						detailHealthIndividuModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = detailHealthIndividuModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}