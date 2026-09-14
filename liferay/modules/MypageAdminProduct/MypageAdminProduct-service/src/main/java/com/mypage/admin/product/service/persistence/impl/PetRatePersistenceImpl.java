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

import com.mypage.admin.product.exception.NoSuchPetRateException;
import com.mypage.admin.product.model.PetRate;
import com.mypage.admin.product.model.impl.PetRateImpl;
import com.mypage.admin.product.model.impl.PetRateModelImpl;
import com.mypage.admin.product.service.persistence.PetRatePersistence;
import com.mypage.admin.product.service.persistence.PetRateUtil;
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
 * The persistence implementation for the pet rate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = PetRatePersistence.class)
public class PetRatePersistenceImpl
	extends BasePersistenceImpl<PetRate> implements PetRatePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PetRateUtil</code> to access the pet rate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PetRateImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByPlan;
	private FinderPath _finderPathWithoutPaginationFindByPlan;
	private FinderPath _finderPathCountByPlan;

	/**
	 * Returns all the pet rates where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @return the matching pet rates
	 */
	@Override
	public List<PetRate> findByPlan(long petPlan) {
		return findByPlan(petPlan, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pet rates where petPlan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param petPlan the pet plan
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @return the range of matching pet rates
	 */
	@Override
	public List<PetRate> findByPlan(long petPlan, int start, int end) {
		return findByPlan(petPlan, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pet rates where petPlan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param petPlan the pet plan
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet rates
	 */
	@Override
	public List<PetRate> findByPlan(
		long petPlan, int start, int end,
		OrderByComparator<PetRate> orderByComparator) {

		return findByPlan(petPlan, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pet rates where petPlan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param petPlan the pet plan
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet rates
	 */
	@Override
	public List<PetRate> findByPlan(
		long petPlan, int start, int end,
		OrderByComparator<PetRate> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPlan;
				finderArgs = new Object[] {petPlan};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPlan;
			finderArgs = new Object[] {petPlan, start, end, orderByComparator};
		}

		List<PetRate> list = null;

		if (useFinderCache) {
			list = (List<PetRate>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PetRate petRate : list) {
					if (petPlan != petRate.getPetPlan()) {
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

			sb.append(_SQL_SELECT_PETRATE_WHERE);

			sb.append(_FINDER_COLUMN_PLAN_PETPLAN_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PetRateModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(petPlan);

				list = (List<PetRate>)QueryUtil.list(
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
	 * Returns the first pet rate in the ordered set where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet rate
	 * @throws NoSuchPetRateException if a matching pet rate could not be found
	 */
	@Override
	public PetRate findByPlan_First(
			long petPlan, OrderByComparator<PetRate> orderByComparator)
		throws NoSuchPetRateException {

		PetRate petRate = fetchByPlan_First(petPlan, orderByComparator);

		if (petRate != null) {
			return petRate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("petPlan=");
		sb.append(petPlan);

		sb.append("}");

		throw new NoSuchPetRateException(sb.toString());
	}

	/**
	 * Returns the first pet rate in the ordered set where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet rate, or <code>null</code> if a matching pet rate could not be found
	 */
	@Override
	public PetRate fetchByPlan_First(
		long petPlan, OrderByComparator<PetRate> orderByComparator) {

		List<PetRate> list = findByPlan(petPlan, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pet rate in the ordered set where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet rate
	 * @throws NoSuchPetRateException if a matching pet rate could not be found
	 */
	@Override
	public PetRate findByPlan_Last(
			long petPlan, OrderByComparator<PetRate> orderByComparator)
		throws NoSuchPetRateException {

		PetRate petRate = fetchByPlan_Last(petPlan, orderByComparator);

		if (petRate != null) {
			return petRate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("petPlan=");
		sb.append(petPlan);

		sb.append("}");

		throw new NoSuchPetRateException(sb.toString());
	}

	/**
	 * Returns the last pet rate in the ordered set where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet rate, or <code>null</code> if a matching pet rate could not be found
	 */
	@Override
	public PetRate fetchByPlan_Last(
		long petPlan, OrderByComparator<PetRate> orderByComparator) {

		int count = countByPlan(petPlan);

		if (count == 0) {
			return null;
		}

		List<PetRate> list = findByPlan(
			petPlan, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pet rates before and after the current pet rate in the ordered set where petPlan = &#63;.
	 *
	 * @param petRateId the primary key of the current pet rate
	 * @param petPlan the pet plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet rate
	 * @throws NoSuchPetRateException if a pet rate with the primary key could not be found
	 */
	@Override
	public PetRate[] findByPlan_PrevAndNext(
			long petRateId, long petPlan,
			OrderByComparator<PetRate> orderByComparator)
		throws NoSuchPetRateException {

		PetRate petRate = findByPrimaryKey(petRateId);

		Session session = null;

		try {
			session = openSession();

			PetRate[] array = new PetRateImpl[3];

			array[0] = getByPlan_PrevAndNext(
				session, petRate, petPlan, orderByComparator, true);

			array[1] = petRate;

			array[2] = getByPlan_PrevAndNext(
				session, petRate, petPlan, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PetRate getByPlan_PrevAndNext(
		Session session, PetRate petRate, long petPlan,
		OrderByComparator<PetRate> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PETRATE_WHERE);

		sb.append(_FINDER_COLUMN_PLAN_PETPLAN_2);

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
			sb.append(PetRateModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(petPlan);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(petRate)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PetRate> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pet rates where petPlan = &#63; from the database.
	 *
	 * @param petPlan the pet plan
	 */
	@Override
	public void removeByPlan(long petPlan) {
		for (PetRate petRate :
				findByPlan(
					petPlan, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(petRate);
		}
	}

	/**
	 * Returns the number of pet rates where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @return the number of matching pet rates
	 */
	@Override
	public int countByPlan(long petPlan) {
		FinderPath finderPath = _finderPathCountByPlan;

		Object[] finderArgs = new Object[] {petPlan};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PETRATE_WHERE);

			sb.append(_FINDER_COLUMN_PLAN_PETPLAN_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(petPlan);

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

	private static final String _FINDER_COLUMN_PLAN_PETPLAN_2 =
		"petRate.petPlan = ?";

	private FinderPath _finderPathFetchBysearchByPetPlanAndPetRemarks;
	private FinderPath _finderPathCountBysearchByPetPlanAndPetRemarks;

	/**
	 * Returns the pet rate where petPlan = &#63; and petRemarks = &#63; or throws a <code>NoSuchPetRateException</code> if it could not be found.
	 *
	 * @param petPlan the pet plan
	 * @param petRemarks the pet remarks
	 * @return the matching pet rate
	 * @throws NoSuchPetRateException if a matching pet rate could not be found
	 */
	@Override
	public PetRate findBysearchByPetPlanAndPetRemarks(
			long petPlan, long petRemarks)
		throws NoSuchPetRateException {

		PetRate petRate = fetchBysearchByPetPlanAndPetRemarks(
			petPlan, petRemarks);

		if (petRate == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("petPlan=");
			sb.append(petPlan);

			sb.append(", petRemarks=");
			sb.append(petRemarks);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPetRateException(sb.toString());
		}

		return petRate;
	}

	/**
	 * Returns the pet rate where petPlan = &#63; and petRemarks = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param petPlan the pet plan
	 * @param petRemarks the pet remarks
	 * @return the matching pet rate, or <code>null</code> if a matching pet rate could not be found
	 */
	@Override
	public PetRate fetchBysearchByPetPlanAndPetRemarks(
		long petPlan, long petRemarks) {

		return fetchBysearchByPetPlanAndPetRemarks(petPlan, petRemarks, true);
	}

	/**
	 * Returns the pet rate where petPlan = &#63; and petRemarks = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param petPlan the pet plan
	 * @param petRemarks the pet remarks
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet rate, or <code>null</code> if a matching pet rate could not be found
	 */
	@Override
	public PetRate fetchBysearchByPetPlanAndPetRemarks(
		long petPlan, long petRemarks, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {petPlan, petRemarks};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBysearchByPetPlanAndPetRemarks, finderArgs,
				this);
		}

		if (result instanceof PetRate) {
			PetRate petRate = (PetRate)result;

			if ((petPlan != petRate.getPetPlan()) ||
				(petRemarks != petRate.getPetRemarks())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PETRATE_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYPETPLANANDPETREMARKS_PETPLAN_2);

			sb.append(_FINDER_COLUMN_SEARCHBYPETPLANANDPETREMARKS_PETREMARKS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(petPlan);

				queryPos.add(petRemarks);

				List<PetRate> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBysearchByPetPlanAndPetRemarks,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {petPlan, petRemarks};
							}

							_log.warn(
								"PetRatePersistenceImpl.fetchBysearchByPetPlanAndPetRemarks(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PetRate petRate = list.get(0);

					result = petRate;

					cacheResult(petRate);
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
			return (PetRate)result;
		}
	}

	/**
	 * Removes the pet rate where petPlan = &#63; and petRemarks = &#63; from the database.
	 *
	 * @param petPlan the pet plan
	 * @param petRemarks the pet remarks
	 * @return the pet rate that was removed
	 */
	@Override
	public PetRate removeBysearchByPetPlanAndPetRemarks(
			long petPlan, long petRemarks)
		throws NoSuchPetRateException {

		PetRate petRate = findBysearchByPetPlanAndPetRemarks(
			petPlan, petRemarks);

		return remove(petRate);
	}

	/**
	 * Returns the number of pet rates where petPlan = &#63; and petRemarks = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @param petRemarks the pet remarks
	 * @return the number of matching pet rates
	 */
	@Override
	public int countBysearchByPetPlanAndPetRemarks(
		long petPlan, long petRemarks) {

		FinderPath finderPath = _finderPathCountBysearchByPetPlanAndPetRemarks;

		Object[] finderArgs = new Object[] {petPlan, petRemarks};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PETRATE_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYPETPLANANDPETREMARKS_PETPLAN_2);

			sb.append(_FINDER_COLUMN_SEARCHBYPETPLANANDPETREMARKS_PETREMARKS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(petPlan);

				queryPos.add(petRemarks);

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
		_FINDER_COLUMN_SEARCHBYPETPLANANDPETREMARKS_PETPLAN_2 =
			"petRate.petPlan = ? AND ";

	private static final String
		_FINDER_COLUMN_SEARCHBYPETPLANANDPETREMARKS_PETREMARKS_2 =
			"petRate.petRemarks = ?";

	public PetRatePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PetRate.class);

		setModelImplClass(PetRateImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the pet rate in the entity cache if it is enabled.
	 *
	 * @param petRate the pet rate
	 */
	@Override
	public void cacheResult(PetRate petRate) {
		entityCache.putResult(
			PetRateImpl.class, petRate.getPrimaryKey(), petRate);

		finderCache.putResult(
			_finderPathFetchBysearchByPetPlanAndPetRemarks,
			new Object[] {petRate.getPetPlan(), petRate.getPetRemarks()},
			petRate);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the pet rates in the entity cache if it is enabled.
	 *
	 * @param petRates the pet rates
	 */
	@Override
	public void cacheResult(List<PetRate> petRates) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (petRates.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PetRate petRate : petRates) {
			if (entityCache.getResult(
					PetRateImpl.class, petRate.getPrimaryKey()) == null) {

				cacheResult(petRate);
			}
		}
	}

	/**
	 * Clears the cache for all pet rates.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PetRateImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pet rate.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PetRate petRate) {
		entityCache.removeResult(PetRateImpl.class, petRate);
	}

	@Override
	public void clearCache(List<PetRate> petRates) {
		for (PetRate petRate : petRates) {
			entityCache.removeResult(PetRateImpl.class, petRate);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PetRateImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(PetRateModelImpl petRateModelImpl) {
		Object[] args = new Object[] {
			petRateModelImpl.getPetPlan(), petRateModelImpl.getPetRemarks()
		};

		finderCache.putResult(
			_finderPathCountBysearchByPetPlanAndPetRemarks, args,
			Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBysearchByPetPlanAndPetRemarks, args,
			petRateModelImpl, false);
	}

	/**
	 * Creates a new pet rate with the primary key. Does not add the pet rate to the database.
	 *
	 * @param petRateId the primary key for the new pet rate
	 * @return the new pet rate
	 */
	@Override
	public PetRate create(long petRateId) {
		PetRate petRate = new PetRateImpl();

		petRate.setNew(true);
		petRate.setPrimaryKey(petRateId);

		petRate.setCompanyId(CompanyThreadLocal.getCompanyId());

		return petRate;
	}

	/**
	 * Removes the pet rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petRateId the primary key of the pet rate
	 * @return the pet rate that was removed
	 * @throws NoSuchPetRateException if a pet rate with the primary key could not be found
	 */
	@Override
	public PetRate remove(long petRateId) throws NoSuchPetRateException {
		return remove((Serializable)petRateId);
	}

	/**
	 * Removes the pet rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pet rate
	 * @return the pet rate that was removed
	 * @throws NoSuchPetRateException if a pet rate with the primary key could not be found
	 */
	@Override
	public PetRate remove(Serializable primaryKey)
		throws NoSuchPetRateException {

		Session session = null;

		try {
			session = openSession();

			PetRate petRate = (PetRate)session.get(
				PetRateImpl.class, primaryKey);

			if (petRate == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPetRateException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(petRate);
		}
		catch (NoSuchPetRateException noSuchEntityException) {
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
	protected PetRate removeImpl(PetRate petRate) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(petRate)) {
				petRate = (PetRate)session.get(
					PetRateImpl.class, petRate.getPrimaryKeyObj());
			}

			if (petRate != null) {
				session.delete(petRate);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (petRate != null) {
			clearCache(petRate);
		}

		return petRate;
	}

	@Override
	public PetRate updateImpl(PetRate petRate) {
		boolean isNew = petRate.isNew();

		if (!(petRate instanceof PetRateModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(petRate.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(petRate);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in petRate proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PetRate implementation " +
					petRate.getClass());
		}

		PetRateModelImpl petRateModelImpl = (PetRateModelImpl)petRate;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (petRate.getCreateDate() == null)) {
			if (serviceContext == null) {
				petRate.setCreateDate(date);
			}
			else {
				petRate.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!petRateModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				petRate.setModifiedDate(date);
			}
			else {
				petRate.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(petRate);
			}
			else {
				petRate = (PetRate)session.merge(petRate);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PetRateImpl.class, petRateModelImpl, false, true);

		cacheUniqueFindersCache(petRateModelImpl);

		if (isNew) {
			petRate.setNew(false);
		}

		petRate.resetOriginalValues();

		return petRate;
	}

	/**
	 * Returns the pet rate with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pet rate
	 * @return the pet rate
	 * @throws NoSuchPetRateException if a pet rate with the primary key could not be found
	 */
	@Override
	public PetRate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPetRateException {

		PetRate petRate = fetchByPrimaryKey(primaryKey);

		if (petRate == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPetRateException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return petRate;
	}

	/**
	 * Returns the pet rate with the primary key or throws a <code>NoSuchPetRateException</code> if it could not be found.
	 *
	 * @param petRateId the primary key of the pet rate
	 * @return the pet rate
	 * @throws NoSuchPetRateException if a pet rate with the primary key could not be found
	 */
	@Override
	public PetRate findByPrimaryKey(long petRateId)
		throws NoSuchPetRateException {

		return findByPrimaryKey((Serializable)petRateId);
	}

	/**
	 * Returns the pet rate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petRateId the primary key of the pet rate
	 * @return the pet rate, or <code>null</code> if a pet rate with the primary key could not be found
	 */
	@Override
	public PetRate fetchByPrimaryKey(long petRateId) {
		return fetchByPrimaryKey((Serializable)petRateId);
	}

	/**
	 * Returns all the pet rates.
	 *
	 * @return the pet rates
	 */
	@Override
	public List<PetRate> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pet rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @return the range of pet rates
	 */
	@Override
	public List<PetRate> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pet rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pet rates
	 */
	@Override
	public List<PetRate> findAll(
		int start, int end, OrderByComparator<PetRate> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pet rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pet rates
	 */
	@Override
	public List<PetRate> findAll(
		int start, int end, OrderByComparator<PetRate> orderByComparator,
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

		List<PetRate> list = null;

		if (useFinderCache) {
			list = (List<PetRate>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PETRATE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PETRATE;

				sql = sql.concat(PetRateModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PetRate>)QueryUtil.list(
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
	 * Removes all the pet rates from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PetRate petRate : findAll()) {
			remove(petRate);
		}
	}

	/**
	 * Returns the number of pet rates.
	 *
	 * @return the number of pet rates
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PETRATE);

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
		return "petRateId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PETRATE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PetRateModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pet rate persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PetRateModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PetRate.class.getName()));

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

		_finderPathWithPaginationFindByPlan = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPlan",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"petPlan"}, true);

		_finderPathWithoutPaginationFindByPlan = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPlan",
			new String[] {Long.class.getName()}, new String[] {"petPlan"},
			true);

		_finderPathCountByPlan = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPlan",
			new String[] {Long.class.getName()}, new String[] {"petPlan"},
			false);

		_finderPathFetchBysearchByPetPlanAndPetRemarks = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBysearchByPetPlanAndPetRemarks",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"petPlan", "petRemarks"}, true);

		_finderPathCountBysearchByPetPlanAndPetRemarks = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysearchByPetPlanAndPetRemarks",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"petPlan", "petRemarks"}, false);

		_setPetRateUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPetRateUtilPersistence(null);

		entityCache.removeCache(PetRateImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPetRateUtilPersistence(
		PetRatePersistence petRatePersistence) {

		try {
			Field field = PetRateUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, petRatePersistence);
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

	private static final String _SQL_SELECT_PETRATE =
		"SELECT petRate FROM PetRate petRate";

	private static final String _SQL_SELECT_PETRATE_WHERE =
		"SELECT petRate FROM PetRate petRate WHERE ";

	private static final String _SQL_COUNT_PETRATE =
		"SELECT COUNT(petRate) FROM PetRate petRate";

	private static final String _SQL_COUNT_PETRATE_WHERE =
		"SELECT COUNT(petRate) FROM PetRate petRate WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "petRate.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PetRate exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PetRate exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PetRatePersistenceImpl.class);

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

	private static class PetRateModelArgumentsResolver
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

			PetRateModelImpl petRateModelImpl = (PetRateModelImpl)baseModel;

			long columnBitmask = petRateModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(petRateModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						petRateModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(PetRatePersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(petRateModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PetRateModelImpl petRateModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = petRateModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = petRateModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}