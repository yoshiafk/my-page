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

import com.mypage.leads.exception.NoSuchDetailTlpException;
import com.mypage.leads.model.DetailTlp;
import com.mypage.leads.model.impl.DetailTlpImpl;
import com.mypage.leads.model.impl.DetailTlpModelImpl;
import com.mypage.leads.service.persistence.DetailTlpPersistence;
import com.mypage.leads.service.persistence.DetailTlpUtil;
import com.mypage.leads.service.persistence.impl.constants.MPLPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the detail tlp service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @generated
 */
@Component(service = DetailTlpPersistence.class)
public class DetailTlpPersistenceImpl
	extends BasePersistenceImpl<DetailTlp> implements DetailTlpPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DetailTlpUtil</code> to access the detail tlp persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DetailTlpImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByleadsId;
	private FinderPath _finderPathWithoutPaginationFindByleadsId;
	private FinderPath _finderPathCountByleadsId;

	/**
	 * Returns all the detail tlps where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @return the matching detail tlps
	 */
	@Override
	public List<DetailTlp> findByleadsId(long leadsId) {
		return findByleadsId(
			leadsId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the detail tlps where leadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param leadsId the leads ID
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @return the range of matching detail tlps
	 */
	@Override
	public List<DetailTlp> findByleadsId(long leadsId, int start, int end) {
		return findByleadsId(leadsId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the detail tlps where leadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param leadsId the leads ID
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching detail tlps
	 */
	@Override
	public List<DetailTlp> findByleadsId(
		long leadsId, int start, int end,
		OrderByComparator<DetailTlp> orderByComparator) {

		return findByleadsId(leadsId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the detail tlps where leadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param leadsId the leads ID
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching detail tlps
	 */
	@Override
	public List<DetailTlp> findByleadsId(
		long leadsId, int start, int end,
		OrderByComparator<DetailTlp> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByleadsId;
				finderArgs = new Object[] {leadsId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByleadsId;
			finderArgs = new Object[] {leadsId, start, end, orderByComparator};
		}

		List<DetailTlp> list = null;

		if (useFinderCache) {
			list = (List<DetailTlp>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DetailTlp detailTlp : list) {
					if (leadsId != detailTlp.getLeadsId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DETAILTLP_WHERE);

			sb.append(_FINDER_COLUMN_LEADSID_LEADSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DetailTlpModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leadsId);

				list = (List<DetailTlp>)QueryUtil.list(
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
	 * Returns the first detail tlp in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching detail tlp
	 * @throws NoSuchDetailTlpException if a matching detail tlp could not be found
	 */
	@Override
	public DetailTlp findByleadsId_First(
			long leadsId, OrderByComparator<DetailTlp> orderByComparator)
		throws NoSuchDetailTlpException {

		DetailTlp detailTlp = fetchByleadsId_First(leadsId, orderByComparator);

		if (detailTlp != null) {
			return detailTlp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("leadsId=");
		sb.append(leadsId);

		sb.append("}");

		throw new NoSuchDetailTlpException(sb.toString());
	}

	/**
	 * Returns the first detail tlp in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching detail tlp, or <code>null</code> if a matching detail tlp could not be found
	 */
	@Override
	public DetailTlp fetchByleadsId_First(
		long leadsId, OrderByComparator<DetailTlp> orderByComparator) {

		List<DetailTlp> list = findByleadsId(leadsId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last detail tlp in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching detail tlp
	 * @throws NoSuchDetailTlpException if a matching detail tlp could not be found
	 */
	@Override
	public DetailTlp findByleadsId_Last(
			long leadsId, OrderByComparator<DetailTlp> orderByComparator)
		throws NoSuchDetailTlpException {

		DetailTlp detailTlp = fetchByleadsId_Last(leadsId, orderByComparator);

		if (detailTlp != null) {
			return detailTlp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("leadsId=");
		sb.append(leadsId);

		sb.append("}");

		throw new NoSuchDetailTlpException(sb.toString());
	}

	/**
	 * Returns the last detail tlp in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching detail tlp, or <code>null</code> if a matching detail tlp could not be found
	 */
	@Override
	public DetailTlp fetchByleadsId_Last(
		long leadsId, OrderByComparator<DetailTlp> orderByComparator) {

		int count = countByleadsId(leadsId);

		if (count == 0) {
			return null;
		}

		List<DetailTlp> list = findByleadsId(
			leadsId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the detail tlps before and after the current detail tlp in the ordered set where leadsId = &#63;.
	 *
	 * @param detailTlpId the primary key of the current detail tlp
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next detail tlp
	 * @throws NoSuchDetailTlpException if a detail tlp with the primary key could not be found
	 */
	@Override
	public DetailTlp[] findByleadsId_PrevAndNext(
			long detailTlpId, long leadsId,
			OrderByComparator<DetailTlp> orderByComparator)
		throws NoSuchDetailTlpException {

		DetailTlp detailTlp = findByPrimaryKey(detailTlpId);

		Session session = null;

		try {
			session = openSession();

			DetailTlp[] array = new DetailTlpImpl[3];

			array[0] = getByleadsId_PrevAndNext(
				session, detailTlp, leadsId, orderByComparator, true);

			array[1] = detailTlp;

			array[2] = getByleadsId_PrevAndNext(
				session, detailTlp, leadsId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DetailTlp getByleadsId_PrevAndNext(
		Session session, DetailTlp detailTlp, long leadsId,
		OrderByComparator<DetailTlp> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DETAILTLP_WHERE);

		sb.append(_FINDER_COLUMN_LEADSID_LEADSID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DetailTlpModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(leadsId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(detailTlp)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DetailTlp> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the detail tlps where leadsId = &#63; from the database.
	 *
	 * @param leadsId the leads ID
	 */
	@Override
	public void removeByleadsId(long leadsId) {
		for (DetailTlp detailTlp :
				findByleadsId(
					leadsId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(detailTlp);
		}
	}

	/**
	 * Returns the number of detail tlps where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @return the number of matching detail tlps
	 */
	@Override
	public int countByleadsId(long leadsId) {
		FinderPath finderPath = _finderPathCountByleadsId;

		Object[] finderArgs = new Object[] {leadsId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DETAILTLP_WHERE);

			sb.append(_FINDER_COLUMN_LEADSID_LEADSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leadsId);

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

	private static final String _FINDER_COLUMN_LEADSID_LEADSID_2 =
		"detailTlp.leadsId = ?";

	public DetailTlpPersistenceImpl() {
		setModelClass(DetailTlp.class);

		setModelImplClass(DetailTlpImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the detail tlp in the entity cache if it is enabled.
	 *
	 * @param detailTlp the detail tlp
	 */
	@Override
	public void cacheResult(DetailTlp detailTlp) {
		entityCache.putResult(
			DetailTlpImpl.class, detailTlp.getPrimaryKey(), detailTlp);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the detail tlps in the entity cache if it is enabled.
	 *
	 * @param detailTlps the detail tlps
	 */
	@Override
	public void cacheResult(List<DetailTlp> detailTlps) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (detailTlps.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DetailTlp detailTlp : detailTlps) {
			if (entityCache.getResult(
					DetailTlpImpl.class, detailTlp.getPrimaryKey()) == null) {

				cacheResult(detailTlp);
			}
		}
	}

	/**
	 * Clears the cache for all detail tlps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DetailTlpImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the detail tlp.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DetailTlp detailTlp) {
		entityCache.removeResult(DetailTlpImpl.class, detailTlp);
	}

	@Override
	public void clearCache(List<DetailTlp> detailTlps) {
		for (DetailTlp detailTlp : detailTlps) {
			entityCache.removeResult(DetailTlpImpl.class, detailTlp);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DetailTlpImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new detail tlp with the primary key. Does not add the detail tlp to the database.
	 *
	 * @param detailTlpId the primary key for the new detail tlp
	 * @return the new detail tlp
	 */
	@Override
	public DetailTlp create(long detailTlpId) {
		DetailTlp detailTlp = new DetailTlpImpl();

		detailTlp.setNew(true);
		detailTlp.setPrimaryKey(detailTlpId);

		detailTlp.setCompanyId(CompanyThreadLocal.getCompanyId());

		return detailTlp;
	}

	/**
	 * Removes the detail tlp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param detailTlpId the primary key of the detail tlp
	 * @return the detail tlp that was removed
	 * @throws NoSuchDetailTlpException if a detail tlp with the primary key could not be found
	 */
	@Override
	public DetailTlp remove(long detailTlpId) throws NoSuchDetailTlpException {
		return remove((Serializable)detailTlpId);
	}

	/**
	 * Removes the detail tlp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the detail tlp
	 * @return the detail tlp that was removed
	 * @throws NoSuchDetailTlpException if a detail tlp with the primary key could not be found
	 */
	@Override
	public DetailTlp remove(Serializable primaryKey)
		throws NoSuchDetailTlpException {

		Session session = null;

		try {
			session = openSession();

			DetailTlp detailTlp = (DetailTlp)session.get(
				DetailTlpImpl.class, primaryKey);

			if (detailTlp == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDetailTlpException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(detailTlp);
		}
		catch (NoSuchDetailTlpException noSuchEntityException) {
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
	protected DetailTlp removeImpl(DetailTlp detailTlp) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(detailTlp)) {
				detailTlp = (DetailTlp)session.get(
					DetailTlpImpl.class, detailTlp.getPrimaryKeyObj());
			}

			if (detailTlp != null) {
				session.delete(detailTlp);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (detailTlp != null) {
			clearCache(detailTlp);
		}

		return detailTlp;
	}

	@Override
	public DetailTlp updateImpl(DetailTlp detailTlp) {
		boolean isNew = detailTlp.isNew();

		if (!(detailTlp instanceof DetailTlpModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(detailTlp.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(detailTlp);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in detailTlp proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DetailTlp implementation " +
					detailTlp.getClass());
		}

		DetailTlpModelImpl detailTlpModelImpl = (DetailTlpModelImpl)detailTlp;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (detailTlp.getCreateDate() == null)) {
			if (serviceContext == null) {
				detailTlp.setCreateDate(date);
			}
			else {
				detailTlp.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!detailTlpModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				detailTlp.setModifiedDate(date);
			}
			else {
				detailTlp.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(detailTlp);
			}
			else {
				detailTlp = (DetailTlp)session.merge(detailTlp);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DetailTlpImpl.class, detailTlpModelImpl, false, true);

		if (isNew) {
			detailTlp.setNew(false);
		}

		detailTlp.resetOriginalValues();

		return detailTlp;
	}

	/**
	 * Returns the detail tlp with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the detail tlp
	 * @return the detail tlp
	 * @throws NoSuchDetailTlpException if a detail tlp with the primary key could not be found
	 */
	@Override
	public DetailTlp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDetailTlpException {

		DetailTlp detailTlp = fetchByPrimaryKey(primaryKey);

		if (detailTlp == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDetailTlpException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return detailTlp;
	}

	/**
	 * Returns the detail tlp with the primary key or throws a <code>NoSuchDetailTlpException</code> if it could not be found.
	 *
	 * @param detailTlpId the primary key of the detail tlp
	 * @return the detail tlp
	 * @throws NoSuchDetailTlpException if a detail tlp with the primary key could not be found
	 */
	@Override
	public DetailTlp findByPrimaryKey(long detailTlpId)
		throws NoSuchDetailTlpException {

		return findByPrimaryKey((Serializable)detailTlpId);
	}

	/**
	 * Returns the detail tlp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param detailTlpId the primary key of the detail tlp
	 * @return the detail tlp, or <code>null</code> if a detail tlp with the primary key could not be found
	 */
	@Override
	public DetailTlp fetchByPrimaryKey(long detailTlpId) {
		return fetchByPrimaryKey((Serializable)detailTlpId);
	}

	/**
	 * Returns all the detail tlps.
	 *
	 * @return the detail tlps
	 */
	@Override
	public List<DetailTlp> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the detail tlps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @return the range of detail tlps
	 */
	@Override
	public List<DetailTlp> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the detail tlps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail tlps
	 */
	@Override
	public List<DetailTlp> findAll(
		int start, int end, OrderByComparator<DetailTlp> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the detail tlps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail tlps
	 */
	@Override
	public List<DetailTlp> findAll(
		int start, int end, OrderByComparator<DetailTlp> orderByComparator,
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

		List<DetailTlp> list = null;

		if (useFinderCache) {
			list = (List<DetailTlp>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DETAILTLP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DETAILTLP;

				sql = sql.concat(DetailTlpModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DetailTlp>)QueryUtil.list(
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
	 * Removes all the detail tlps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DetailTlp detailTlp : findAll()) {
			remove(detailTlp);
		}
	}

	/**
	 * Returns the number of detail tlps.
	 *
	 * @return the number of detail tlps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DETAILTLP);

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
		return "detailTlpId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DETAILTLP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DetailTlpModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the detail tlp persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new DetailTlpModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DetailTlp.class.getName()));

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

		_finderPathWithPaginationFindByleadsId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByleadsId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"leadsId"}, true);

		_finderPathWithoutPaginationFindByleadsId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByleadsId",
			new String[] {Long.class.getName()}, new String[] {"leadsId"},
			true);

		_finderPathCountByleadsId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByleadsId",
			new String[] {Long.class.getName()}, new String[] {"leadsId"},
			false);

		_setDetailTlpUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDetailTlpUtilPersistence(null);

		entityCache.removeCache(DetailTlpImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setDetailTlpUtilPersistence(
		DetailTlpPersistence detailTlpPersistence) {

		try {
			Field field = DetailTlpUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, detailTlpPersistence);
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

	private static final String _SQL_SELECT_DETAILTLP =
		"SELECT detailTlp FROM DetailTlp detailTlp";

	private static final String _SQL_SELECT_DETAILTLP_WHERE =
		"SELECT detailTlp FROM DetailTlp detailTlp WHERE ";

	private static final String _SQL_COUNT_DETAILTLP =
		"SELECT COUNT(detailTlp) FROM DetailTlp detailTlp";

	private static final String _SQL_COUNT_DETAILTLP_WHERE =
		"SELECT COUNT(detailTlp) FROM DetailTlp detailTlp WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "detailTlp.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DetailTlp exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DetailTlp exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DetailTlpPersistenceImpl.class);

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

	private static class DetailTlpModelArgumentsResolver
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

			DetailTlpModelImpl detailTlpModelImpl =
				(DetailTlpModelImpl)baseModel;

			if (!checkColumn ||
				_hasModifiedColumns(detailTlpModelImpl, columnNames)) {

				return _getValue(detailTlpModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			DetailTlpModelImpl detailTlpModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = detailTlpModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = detailTlpModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static boolean _hasModifiedColumns(
			DetailTlpModelImpl detailTlpModelImpl, String[] columnNames) {

			if (columnNames.length == 0) {
				return false;
			}

			for (String columnName : columnNames) {
				if (!Objects.equals(
						detailTlpModelImpl.getColumnOriginalValue(columnName),
						detailTlpModelImpl.getColumnValue(columnName))) {

					return true;
				}
			}

			return false;
		}

	}

}