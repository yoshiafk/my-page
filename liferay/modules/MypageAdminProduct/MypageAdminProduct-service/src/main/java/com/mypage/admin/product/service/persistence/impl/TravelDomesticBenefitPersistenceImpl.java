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

import com.mypage.admin.product.exception.NoSuchTravelDomesticBenefitException;
import com.mypage.admin.product.model.TravelDomesticBenefit;
import com.mypage.admin.product.model.impl.TravelDomesticBenefitImpl;
import com.mypage.admin.product.model.impl.TravelDomesticBenefitModelImpl;
import com.mypage.admin.product.service.persistence.TravelDomesticBenefitPersistence;
import com.mypage.admin.product.service.persistence.TravelDomesticBenefitUtil;
import com.mypage.admin.product.service.persistence.impl.constants.MPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the travel domestic benefit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = TravelDomesticBenefitPersistence.class)
public class TravelDomesticBenefitPersistenceImpl
	extends BasePersistenceImpl<TravelDomesticBenefit>
	implements TravelDomesticBenefitPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TravelDomesticBenefitUtil</code> to access the travel domestic benefit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TravelDomesticBenefitImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath
		_finderPathWithPaginationFindBysearchTravelDomesticBenefitId;
	private FinderPath
		_finderPathWithoutPaginationFindBysearchTravelDomesticBenefitId;
	private FinderPath _finderPathCountBysearchTravelDomesticBenefitId;

	/**
	 * Returns all the travel domestic benefits where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @return the matching travel domestic benefits
	 */
	@Override
	public List<TravelDomesticBenefit> findBysearchTravelDomesticBenefitId(
		long travelDomesticBenefitId) {

		return findBysearchTravelDomesticBenefitId(
			travelDomesticBenefitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the travel domestic benefits where travelDomesticBenefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @return the range of matching travel domestic benefits
	 */
	@Override
	public List<TravelDomesticBenefit> findBysearchTravelDomesticBenefitId(
		long travelDomesticBenefitId, int start, int end) {

		return findBysearchTravelDomesticBenefitId(
			travelDomesticBenefitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefits where travelDomesticBenefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic benefits
	 */
	@Override
	public List<TravelDomesticBenefit> findBysearchTravelDomesticBenefitId(
		long travelDomesticBenefitId, int start, int end,
		OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		return findBysearchTravelDomesticBenefitId(
			travelDomesticBenefitId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefits where travelDomesticBenefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic benefits
	 */
	@Override
	public List<TravelDomesticBenefit> findBysearchTravelDomesticBenefitId(
		long travelDomesticBenefitId, int start, int end,
		OrderByComparator<TravelDomesticBenefit> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBysearchTravelDomesticBenefitId;
				finderArgs = new Object[] {travelDomesticBenefitId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBysearchTravelDomesticBenefitId;
			finderArgs = new Object[] {
				travelDomesticBenefitId, start, end, orderByComparator
			};
		}

		List<TravelDomesticBenefit> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticBenefit>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelDomesticBenefit travelDomesticBenefit : list) {
					if (travelDomesticBenefitId !=
							travelDomesticBenefit.
								getTravelDomesticBenefitId()) {

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

			sb.append(_SQL_SELECT_TRAVELDOMESTICBENEFIT_WHERE);

			sb.append(
				_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITID_TRAVELDOMESTICBENEFITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelDomesticBenefitModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(travelDomesticBenefitId);

				list = (List<TravelDomesticBenefit>)QueryUtil.list(
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
	 * Returns the first travel domestic benefit in the ordered set where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	@Override
	public TravelDomesticBenefit findBysearchTravelDomesticBenefitId_First(
			long travelDomesticBenefitId,
			OrderByComparator<TravelDomesticBenefit> orderByComparator)
		throws NoSuchTravelDomesticBenefitException {

		TravelDomesticBenefit travelDomesticBenefit =
			fetchBysearchTravelDomesticBenefitId_First(
				travelDomesticBenefitId, orderByComparator);

		if (travelDomesticBenefit != null) {
			return travelDomesticBenefit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelDomesticBenefitId=");
		sb.append(travelDomesticBenefitId);

		sb.append("}");

		throw new NoSuchTravelDomesticBenefitException(sb.toString());
	}

	/**
	 * Returns the first travel domestic benefit in the ordered set where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	@Override
	public TravelDomesticBenefit fetchBysearchTravelDomesticBenefitId_First(
		long travelDomesticBenefitId,
		OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		List<TravelDomesticBenefit> list = findBysearchTravelDomesticBenefitId(
			travelDomesticBenefitId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel domestic benefit in the ordered set where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	@Override
	public TravelDomesticBenefit findBysearchTravelDomesticBenefitId_Last(
			long travelDomesticBenefitId,
			OrderByComparator<TravelDomesticBenefit> orderByComparator)
		throws NoSuchTravelDomesticBenefitException {

		TravelDomesticBenefit travelDomesticBenefit =
			fetchBysearchTravelDomesticBenefitId_Last(
				travelDomesticBenefitId, orderByComparator);

		if (travelDomesticBenefit != null) {
			return travelDomesticBenefit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelDomesticBenefitId=");
		sb.append(travelDomesticBenefitId);

		sb.append("}");

		throw new NoSuchTravelDomesticBenefitException(sb.toString());
	}

	/**
	 * Returns the last travel domestic benefit in the ordered set where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	@Override
	public TravelDomesticBenefit fetchBysearchTravelDomesticBenefitId_Last(
		long travelDomesticBenefitId,
		OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		int count = countBysearchTravelDomesticBenefitId(
			travelDomesticBenefitId);

		if (count == 0) {
			return null;
		}

		List<TravelDomesticBenefit> list = findBysearchTravelDomesticBenefitId(
			travelDomesticBenefitId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the travel domestic benefits where travelDomesticBenefitId = &#63; from the database.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 */
	@Override
	public void removeBysearchTravelDomesticBenefitId(
		long travelDomesticBenefitId) {

		for (TravelDomesticBenefit travelDomesticBenefit :
				findBysearchTravelDomesticBenefitId(
					travelDomesticBenefitId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(travelDomesticBenefit);
		}
	}

	/**
	 * Returns the number of travel domestic benefits where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @return the number of matching travel domestic benefits
	 */
	@Override
	public int countBysearchTravelDomesticBenefitId(
		long travelDomesticBenefitId) {

		FinderPath finderPath = _finderPathCountBysearchTravelDomesticBenefitId;

		Object[] finderArgs = new Object[] {travelDomesticBenefitId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAVELDOMESTICBENEFIT_WHERE);

			sb.append(
				_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITID_TRAVELDOMESTICBENEFITID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(travelDomesticBenefitId);

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
		_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITID_TRAVELDOMESTICBENEFITID_2 =
			"travelDomesticBenefit.travelDomesticBenefitId = ?";

	private FinderPath
		_finderPathWithPaginationFindBysearchTravelDomesticBenefitPlan;
	private FinderPath
		_finderPathWithoutPaginationFindBysearchTravelDomesticBenefitPlan;
	private FinderPath _finderPathCountBysearchTravelDomesticBenefitPlan;

	/**
	 * Returns all the travel domestic benefits where plan = &#63;.
	 *
	 * @param plan the plan
	 * @return the matching travel domestic benefits
	 */
	@Override
	public List<TravelDomesticBenefit> findBysearchTravelDomesticBenefitPlan(
		String plan) {

		return findBysearchTravelDomesticBenefitPlan(
			plan, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel domestic benefits where plan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param plan the plan
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @return the range of matching travel domestic benefits
	 */
	@Override
	public List<TravelDomesticBenefit> findBysearchTravelDomesticBenefitPlan(
		String plan, int start, int end) {

		return findBysearchTravelDomesticBenefitPlan(plan, start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefits where plan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param plan the plan
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic benefits
	 */
	@Override
	public List<TravelDomesticBenefit> findBysearchTravelDomesticBenefitPlan(
		String plan, int start, int end,
		OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		return findBysearchTravelDomesticBenefitPlan(
			plan, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefits where plan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param plan the plan
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic benefits
	 */
	@Override
	public List<TravelDomesticBenefit> findBysearchTravelDomesticBenefitPlan(
		String plan, int start, int end,
		OrderByComparator<TravelDomesticBenefit> orderByComparator,
		boolean useFinderCache) {

		plan = Objects.toString(plan, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBysearchTravelDomesticBenefitPlan;
				finderArgs = new Object[] {plan};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBysearchTravelDomesticBenefitPlan;
			finderArgs = new Object[] {plan, start, end, orderByComparator};
		}

		List<TravelDomesticBenefit> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticBenefit>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelDomesticBenefit travelDomesticBenefit : list) {
					if (!plan.equals(travelDomesticBenefit.getPlan())) {
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

			sb.append(_SQL_SELECT_TRAVELDOMESTICBENEFIT_WHERE);

			boolean bindPlan = false;

			if (plan.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITPLAN_PLAN_3);
			}
			else {
				bindPlan = true;

				sb.append(
					_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITPLAN_PLAN_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelDomesticBenefitModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPlan) {
					queryPos.add(plan);
				}

				list = (List<TravelDomesticBenefit>)QueryUtil.list(
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
	 * Returns the first travel domestic benefit in the ordered set where plan = &#63;.
	 *
	 * @param plan the plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	@Override
	public TravelDomesticBenefit findBysearchTravelDomesticBenefitPlan_First(
			String plan,
			OrderByComparator<TravelDomesticBenefit> orderByComparator)
		throws NoSuchTravelDomesticBenefitException {

		TravelDomesticBenefit travelDomesticBenefit =
			fetchBysearchTravelDomesticBenefitPlan_First(
				plan, orderByComparator);

		if (travelDomesticBenefit != null) {
			return travelDomesticBenefit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("plan=");
		sb.append(plan);

		sb.append("}");

		throw new NoSuchTravelDomesticBenefitException(sb.toString());
	}

	/**
	 * Returns the first travel domestic benefit in the ordered set where plan = &#63;.
	 *
	 * @param plan the plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	@Override
	public TravelDomesticBenefit fetchBysearchTravelDomesticBenefitPlan_First(
		String plan,
		OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		List<TravelDomesticBenefit> list =
			findBysearchTravelDomesticBenefitPlan(
				plan, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel domestic benefit in the ordered set where plan = &#63;.
	 *
	 * @param plan the plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	@Override
	public TravelDomesticBenefit findBysearchTravelDomesticBenefitPlan_Last(
			String plan,
			OrderByComparator<TravelDomesticBenefit> orderByComparator)
		throws NoSuchTravelDomesticBenefitException {

		TravelDomesticBenefit travelDomesticBenefit =
			fetchBysearchTravelDomesticBenefitPlan_Last(
				plan, orderByComparator);

		if (travelDomesticBenefit != null) {
			return travelDomesticBenefit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("plan=");
		sb.append(plan);

		sb.append("}");

		throw new NoSuchTravelDomesticBenefitException(sb.toString());
	}

	/**
	 * Returns the last travel domestic benefit in the ordered set where plan = &#63;.
	 *
	 * @param plan the plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	@Override
	public TravelDomesticBenefit fetchBysearchTravelDomesticBenefitPlan_Last(
		String plan,
		OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		int count = countBysearchTravelDomesticBenefitPlan(plan);

		if (count == 0) {
			return null;
		}

		List<TravelDomesticBenefit> list =
			findBysearchTravelDomesticBenefitPlan(
				plan, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the travel domestic benefits before and after the current travel domestic benefit in the ordered set where plan = &#63;.
	 *
	 * @param travelDomesticBenefitId the primary key of the current travel domestic benefit
	 * @param plan the plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a travel domestic benefit with the primary key could not be found
	 */
	@Override
	public TravelDomesticBenefit[]
			findBysearchTravelDomesticBenefitPlan_PrevAndNext(
				long travelDomesticBenefitId, String plan,
				OrderByComparator<TravelDomesticBenefit> orderByComparator)
		throws NoSuchTravelDomesticBenefitException {

		plan = Objects.toString(plan, "");

		TravelDomesticBenefit travelDomesticBenefit = findByPrimaryKey(
			travelDomesticBenefitId);

		Session session = null;

		try {
			session = openSession();

			TravelDomesticBenefit[] array = new TravelDomesticBenefitImpl[3];

			array[0] = getBysearchTravelDomesticBenefitPlan_PrevAndNext(
				session, travelDomesticBenefit, plan, orderByComparator, true);

			array[1] = travelDomesticBenefit;

			array[2] = getBysearchTravelDomesticBenefitPlan_PrevAndNext(
				session, travelDomesticBenefit, plan, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TravelDomesticBenefit
		getBysearchTravelDomesticBenefitPlan_PrevAndNext(
			Session session, TravelDomesticBenefit travelDomesticBenefit,
			String plan,
			OrderByComparator<TravelDomesticBenefit> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRAVELDOMESTICBENEFIT_WHERE);

		boolean bindPlan = false;

		if (plan.isEmpty()) {
			sb.append(_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITPLAN_PLAN_3);
		}
		else {
			bindPlan = true;

			sb.append(_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITPLAN_PLAN_2);
		}

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
			sb.append(TravelDomesticBenefitModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPlan) {
			queryPos.add(plan);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						travelDomesticBenefit)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TravelDomesticBenefit> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the travel domestic benefits where plan = &#63; from the database.
	 *
	 * @param plan the plan
	 */
	@Override
	public void removeBysearchTravelDomesticBenefitPlan(String plan) {
		for (TravelDomesticBenefit travelDomesticBenefit :
				findBysearchTravelDomesticBenefitPlan(
					plan, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(travelDomesticBenefit);
		}
	}

	/**
	 * Returns the number of travel domestic benefits where plan = &#63;.
	 *
	 * @param plan the plan
	 * @return the number of matching travel domestic benefits
	 */
	@Override
	public int countBysearchTravelDomesticBenefitPlan(String plan) {
		plan = Objects.toString(plan, "");

		FinderPath finderPath =
			_finderPathCountBysearchTravelDomesticBenefitPlan;

		Object[] finderArgs = new Object[] {plan};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAVELDOMESTICBENEFIT_WHERE);

			boolean bindPlan = false;

			if (plan.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITPLAN_PLAN_3);
			}
			else {
				bindPlan = true;

				sb.append(
					_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITPLAN_PLAN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPlan) {
					queryPos.add(plan);
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

	private static final String
		_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITPLAN_PLAN_2 =
			"travelDomesticBenefit.plan = ?";

	private static final String
		_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITPLAN_PLAN_3 =
			"(travelDomesticBenefit.plan IS NULL OR travelDomesticBenefit.plan = '')";

	private FinderPath _finderPathWithPaginationFindBysearchGroup;
	private FinderPath _finderPathWithoutPaginationFindBysearchGroup;
	private FinderPath _finderPathCountBysearchGroup;

	/**
	 * Returns all the travel domestic benefits where group = &#63;.
	 *
	 * @param group the group
	 * @return the matching travel domestic benefits
	 */
	@Override
	public List<TravelDomesticBenefit> findBysearchGroup(String group) {
		return findBysearchGroup(
			group, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel domestic benefits where group = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param group the group
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @return the range of matching travel domestic benefits
	 */
	@Override
	public List<TravelDomesticBenefit> findBysearchGroup(
		String group, int start, int end) {

		return findBysearchGroup(group, start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefits where group = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param group the group
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic benefits
	 */
	@Override
	public List<TravelDomesticBenefit> findBysearchGroup(
		String group, int start, int end,
		OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		return findBysearchGroup(group, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefits where group = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param group the group
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic benefits
	 */
	@Override
	public List<TravelDomesticBenefit> findBysearchGroup(
		String group, int start, int end,
		OrderByComparator<TravelDomesticBenefit> orderByComparator,
		boolean useFinderCache) {

		group = Objects.toString(group, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBysearchGroup;
				finderArgs = new Object[] {group};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchGroup;
			finderArgs = new Object[] {group, start, end, orderByComparator};
		}

		List<TravelDomesticBenefit> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticBenefit>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelDomesticBenefit travelDomesticBenefit : list) {
					if (!group.equals(travelDomesticBenefit.getGroup())) {
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

			sb.append(_SQL_SELECT_TRAVELDOMESTICBENEFIT_WHERE);

			boolean bindGroup = false;

			if (group.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHGROUP_GROUP_3);
			}
			else {
				bindGroup = true;

				sb.append(_FINDER_COLUMN_SEARCHGROUP_GROUP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelDomesticBenefitModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGroup) {
					queryPos.add(group);
				}

				list = (List<TravelDomesticBenefit>)QueryUtil.list(
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
	 * Returns the first travel domestic benefit in the ordered set where group = &#63;.
	 *
	 * @param group the group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	@Override
	public TravelDomesticBenefit findBysearchGroup_First(
			String group,
			OrderByComparator<TravelDomesticBenefit> orderByComparator)
		throws NoSuchTravelDomesticBenefitException {

		TravelDomesticBenefit travelDomesticBenefit = fetchBysearchGroup_First(
			group, orderByComparator);

		if (travelDomesticBenefit != null) {
			return travelDomesticBenefit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("group=");
		sb.append(group);

		sb.append("}");

		throw new NoSuchTravelDomesticBenefitException(sb.toString());
	}

	/**
	 * Returns the first travel domestic benefit in the ordered set where group = &#63;.
	 *
	 * @param group the group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	@Override
	public TravelDomesticBenefit fetchBysearchGroup_First(
		String group,
		OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		List<TravelDomesticBenefit> list = findBysearchGroup(
			group, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel domestic benefit in the ordered set where group = &#63;.
	 *
	 * @param group the group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	@Override
	public TravelDomesticBenefit findBysearchGroup_Last(
			String group,
			OrderByComparator<TravelDomesticBenefit> orderByComparator)
		throws NoSuchTravelDomesticBenefitException {

		TravelDomesticBenefit travelDomesticBenefit = fetchBysearchGroup_Last(
			group, orderByComparator);

		if (travelDomesticBenefit != null) {
			return travelDomesticBenefit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("group=");
		sb.append(group);

		sb.append("}");

		throw new NoSuchTravelDomesticBenefitException(sb.toString());
	}

	/**
	 * Returns the last travel domestic benefit in the ordered set where group = &#63;.
	 *
	 * @param group the group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	@Override
	public TravelDomesticBenefit fetchBysearchGroup_Last(
		String group,
		OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		int count = countBysearchGroup(group);

		if (count == 0) {
			return null;
		}

		List<TravelDomesticBenefit> list = findBysearchGroup(
			group, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the travel domestic benefits before and after the current travel domestic benefit in the ordered set where group = &#63;.
	 *
	 * @param travelDomesticBenefitId the primary key of the current travel domestic benefit
	 * @param group the group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a travel domestic benefit with the primary key could not be found
	 */
	@Override
	public TravelDomesticBenefit[] findBysearchGroup_PrevAndNext(
			long travelDomesticBenefitId, String group,
			OrderByComparator<TravelDomesticBenefit> orderByComparator)
		throws NoSuchTravelDomesticBenefitException {

		group = Objects.toString(group, "");

		TravelDomesticBenefit travelDomesticBenefit = findByPrimaryKey(
			travelDomesticBenefitId);

		Session session = null;

		try {
			session = openSession();

			TravelDomesticBenefit[] array = new TravelDomesticBenefitImpl[3];

			array[0] = getBysearchGroup_PrevAndNext(
				session, travelDomesticBenefit, group, orderByComparator, true);

			array[1] = travelDomesticBenefit;

			array[2] = getBysearchGroup_PrevAndNext(
				session, travelDomesticBenefit, group, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TravelDomesticBenefit getBysearchGroup_PrevAndNext(
		Session session, TravelDomesticBenefit travelDomesticBenefit,
		String group,
		OrderByComparator<TravelDomesticBenefit> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRAVELDOMESTICBENEFIT_WHERE);

		boolean bindGroup = false;

		if (group.isEmpty()) {
			sb.append(_FINDER_COLUMN_SEARCHGROUP_GROUP_3);
		}
		else {
			bindGroup = true;

			sb.append(_FINDER_COLUMN_SEARCHGROUP_GROUP_2);
		}

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
			sb.append(TravelDomesticBenefitModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindGroup) {
			queryPos.add(group);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						travelDomesticBenefit)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TravelDomesticBenefit> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the travel domestic benefits where group = &#63; from the database.
	 *
	 * @param group the group
	 */
	@Override
	public void removeBysearchGroup(String group) {
		for (TravelDomesticBenefit travelDomesticBenefit :
				findBysearchGroup(
					group, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(travelDomesticBenefit);
		}
	}

	/**
	 * Returns the number of travel domestic benefits where group = &#63;.
	 *
	 * @param group the group
	 * @return the number of matching travel domestic benefits
	 */
	@Override
	public int countBysearchGroup(String group) {
		group = Objects.toString(group, "");

		FinderPath finderPath = _finderPathCountBysearchGroup;

		Object[] finderArgs = new Object[] {group};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAVELDOMESTICBENEFIT_WHERE);

			boolean bindGroup = false;

			if (group.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHGROUP_GROUP_3);
			}
			else {
				bindGroup = true;

				sb.append(_FINDER_COLUMN_SEARCHGROUP_GROUP_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGroup) {
					queryPos.add(group);
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

	private static final String _FINDER_COLUMN_SEARCHGROUP_GROUP_2 =
		"travelDomesticBenefit.group = ?";

	private static final String _FINDER_COLUMN_SEARCHGROUP_GROUP_3 =
		"(travelDomesticBenefit.group IS NULL OR travelDomesticBenefit.group = '')";

	public TravelDomesticBenefitPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("group", "group_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TravelDomesticBenefit.class);

		setModelImplClass(TravelDomesticBenefitImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the travel domestic benefit in the entity cache if it is enabled.
	 *
	 * @param travelDomesticBenefit the travel domestic benefit
	 */
	@Override
	public void cacheResult(TravelDomesticBenefit travelDomesticBenefit) {
		entityCache.putResult(
			TravelDomesticBenefitImpl.class,
			travelDomesticBenefit.getPrimaryKey(), travelDomesticBenefit);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the travel domestic benefits in the entity cache if it is enabled.
	 *
	 * @param travelDomesticBenefits the travel domestic benefits
	 */
	@Override
	public void cacheResult(
		List<TravelDomesticBenefit> travelDomesticBenefits) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (travelDomesticBenefits.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TravelDomesticBenefit travelDomesticBenefit :
				travelDomesticBenefits) {

			if (entityCache.getResult(
					TravelDomesticBenefitImpl.class,
					travelDomesticBenefit.getPrimaryKey()) == null) {

				cacheResult(travelDomesticBenefit);
			}
		}
	}

	/**
	 * Clears the cache for all travel domestic benefits.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TravelDomesticBenefitImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the travel domestic benefit.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TravelDomesticBenefit travelDomesticBenefit) {
		entityCache.removeResult(
			TravelDomesticBenefitImpl.class, travelDomesticBenefit);
	}

	@Override
	public void clearCache(List<TravelDomesticBenefit> travelDomesticBenefits) {
		for (TravelDomesticBenefit travelDomesticBenefit :
				travelDomesticBenefits) {

			entityCache.removeResult(
				TravelDomesticBenefitImpl.class, travelDomesticBenefit);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				TravelDomesticBenefitImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new travel domestic benefit with the primary key. Does not add the travel domestic benefit to the database.
	 *
	 * @param travelDomesticBenefitId the primary key for the new travel domestic benefit
	 * @return the new travel domestic benefit
	 */
	@Override
	public TravelDomesticBenefit create(long travelDomesticBenefitId) {
		TravelDomesticBenefit travelDomesticBenefit =
			new TravelDomesticBenefitImpl();

		travelDomesticBenefit.setNew(true);
		travelDomesticBenefit.setPrimaryKey(travelDomesticBenefitId);

		travelDomesticBenefit.setCompanyId(CompanyThreadLocal.getCompanyId());

		return travelDomesticBenefit;
	}

	/**
	 * Removes the travel domestic benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticBenefitId the primary key of the travel domestic benefit
	 * @return the travel domestic benefit that was removed
	 * @throws NoSuchTravelDomesticBenefitException if a travel domestic benefit with the primary key could not be found
	 */
	@Override
	public TravelDomesticBenefit remove(long travelDomesticBenefitId)
		throws NoSuchTravelDomesticBenefitException {

		return remove((Serializable)travelDomesticBenefitId);
	}

	/**
	 * Removes the travel domestic benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the travel domestic benefit
	 * @return the travel domestic benefit that was removed
	 * @throws NoSuchTravelDomesticBenefitException if a travel domestic benefit with the primary key could not be found
	 */
	@Override
	public TravelDomesticBenefit remove(Serializable primaryKey)
		throws NoSuchTravelDomesticBenefitException {

		Session session = null;

		try {
			session = openSession();

			TravelDomesticBenefit travelDomesticBenefit =
				(TravelDomesticBenefit)session.get(
					TravelDomesticBenefitImpl.class, primaryKey);

			if (travelDomesticBenefit == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTravelDomesticBenefitException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(travelDomesticBenefit);
		}
		catch (NoSuchTravelDomesticBenefitException noSuchEntityException) {
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
	protected TravelDomesticBenefit removeImpl(
		TravelDomesticBenefit travelDomesticBenefit) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(travelDomesticBenefit)) {
				travelDomesticBenefit = (TravelDomesticBenefit)session.get(
					TravelDomesticBenefitImpl.class,
					travelDomesticBenefit.getPrimaryKeyObj());
			}

			if (travelDomesticBenefit != null) {
				session.delete(travelDomesticBenefit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (travelDomesticBenefit != null) {
			clearCache(travelDomesticBenefit);
		}

		return travelDomesticBenefit;
	}

	@Override
	public TravelDomesticBenefit updateImpl(
		TravelDomesticBenefit travelDomesticBenefit) {

		boolean isNew = travelDomesticBenefit.isNew();

		if (!(travelDomesticBenefit instanceof
				TravelDomesticBenefitModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(travelDomesticBenefit.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					travelDomesticBenefit);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in travelDomesticBenefit proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TravelDomesticBenefit implementation " +
					travelDomesticBenefit.getClass());
		}

		TravelDomesticBenefitModelImpl travelDomesticBenefitModelImpl =
			(TravelDomesticBenefitModelImpl)travelDomesticBenefit;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (travelDomesticBenefit.getCreateDate() == null)) {
			if (serviceContext == null) {
				travelDomesticBenefit.setCreateDate(date);
			}
			else {
				travelDomesticBenefit.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!travelDomesticBenefitModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				travelDomesticBenefit.setModifiedDate(date);
			}
			else {
				travelDomesticBenefit.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(travelDomesticBenefit);
			}
			else {
				travelDomesticBenefit = (TravelDomesticBenefit)session.merge(
					travelDomesticBenefit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TravelDomesticBenefitImpl.class, travelDomesticBenefitModelImpl,
			false, true);

		if (isNew) {
			travelDomesticBenefit.setNew(false);
		}

		travelDomesticBenefit.resetOriginalValues();

		return travelDomesticBenefit;
	}

	/**
	 * Returns the travel domestic benefit with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the travel domestic benefit
	 * @return the travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a travel domestic benefit with the primary key could not be found
	 */
	@Override
	public TravelDomesticBenefit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTravelDomesticBenefitException {

		TravelDomesticBenefit travelDomesticBenefit = fetchByPrimaryKey(
			primaryKey);

		if (travelDomesticBenefit == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTravelDomesticBenefitException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return travelDomesticBenefit;
	}

	/**
	 * Returns the travel domestic benefit with the primary key or throws a <code>NoSuchTravelDomesticBenefitException</code> if it could not be found.
	 *
	 * @param travelDomesticBenefitId the primary key of the travel domestic benefit
	 * @return the travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a travel domestic benefit with the primary key could not be found
	 */
	@Override
	public TravelDomesticBenefit findByPrimaryKey(long travelDomesticBenefitId)
		throws NoSuchTravelDomesticBenefitException {

		return findByPrimaryKey((Serializable)travelDomesticBenefitId);
	}

	/**
	 * Returns the travel domestic benefit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticBenefitId the primary key of the travel domestic benefit
	 * @return the travel domestic benefit, or <code>null</code> if a travel domestic benefit with the primary key could not be found
	 */
	@Override
	public TravelDomesticBenefit fetchByPrimaryKey(
		long travelDomesticBenefitId) {

		return fetchByPrimaryKey((Serializable)travelDomesticBenefitId);
	}

	/**
	 * Returns all the travel domestic benefits.
	 *
	 * @return the travel domestic benefits
	 */
	@Override
	public List<TravelDomesticBenefit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel domestic benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @return the range of travel domestic benefits
	 */
	@Override
	public List<TravelDomesticBenefit> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic benefits
	 */
	@Override
	public List<TravelDomesticBenefit> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic benefits
	 */
	@Override
	public List<TravelDomesticBenefit> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticBenefit> orderByComparator,
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

		List<TravelDomesticBenefit> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticBenefit>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAVELDOMESTICBENEFIT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAVELDOMESTICBENEFIT;

				sql = sql.concat(TravelDomesticBenefitModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TravelDomesticBenefit>)QueryUtil.list(
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
	 * Removes all the travel domestic benefits from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TravelDomesticBenefit travelDomesticBenefit : findAll()) {
			remove(travelDomesticBenefit);
		}
	}

	/**
	 * Returns the number of travel domestic benefits.
	 *
	 * @return the number of travel domestic benefits
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
					_SQL_COUNT_TRAVELDOMESTICBENEFIT);

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
		return "travelDomesticBenefitId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAVELDOMESTICBENEFIT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TravelDomesticBenefitModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the travel domestic benefit persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new TravelDomesticBenefitModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", TravelDomesticBenefit.class.getName()));

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

		_finderPathWithPaginationFindBysearchTravelDomesticBenefitId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBysearchTravelDomesticBenefitId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"travelDomesticBenefitId"}, true);

		_finderPathWithoutPaginationFindBysearchTravelDomesticBenefitId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBysearchTravelDomesticBenefitId",
				new String[] {Long.class.getName()},
				new String[] {"travelDomesticBenefitId"}, true);

		_finderPathCountBysearchTravelDomesticBenefitId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysearchTravelDomesticBenefitId",
			new String[] {Long.class.getName()},
			new String[] {"travelDomesticBenefitId"}, false);

		_finderPathWithPaginationFindBysearchTravelDomesticBenefitPlan =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBysearchTravelDomesticBenefitPlan",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"plan"}, true);

		_finderPathWithoutPaginationFindBysearchTravelDomesticBenefitPlan =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBysearchTravelDomesticBenefitPlan",
				new String[] {String.class.getName()}, new String[] {"plan"},
				true);

		_finderPathCountBysearchTravelDomesticBenefitPlan = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysearchTravelDomesticBenefitPlan",
			new String[] {String.class.getName()}, new String[] {"plan"},
			false);

		_finderPathWithPaginationFindBysearchGroup = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchGroup",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"group_"}, true);

		_finderPathWithoutPaginationFindBysearchGroup = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysearchGroup",
			new String[] {String.class.getName()}, new String[] {"group_"},
			true);

		_finderPathCountBysearchGroup = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchGroup",
			new String[] {String.class.getName()}, new String[] {"group_"},
			false);

		_setTravelDomesticBenefitUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTravelDomesticBenefitUtilPersistence(null);

		entityCache.removeCache(TravelDomesticBenefitImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setTravelDomesticBenefitUtilPersistence(
		TravelDomesticBenefitPersistence travelDomesticBenefitPersistence) {

		try {
			Field field = TravelDomesticBenefitUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, travelDomesticBenefitPersistence);
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

	private static final String _SQL_SELECT_TRAVELDOMESTICBENEFIT =
		"SELECT travelDomesticBenefit FROM TravelDomesticBenefit travelDomesticBenefit";

	private static final String _SQL_SELECT_TRAVELDOMESTICBENEFIT_WHERE =
		"SELECT travelDomesticBenefit FROM TravelDomesticBenefit travelDomesticBenefit WHERE ";

	private static final String _SQL_COUNT_TRAVELDOMESTICBENEFIT =
		"SELECT COUNT(travelDomesticBenefit) FROM TravelDomesticBenefit travelDomesticBenefit";

	private static final String _SQL_COUNT_TRAVELDOMESTICBENEFIT_WHERE =
		"SELECT COUNT(travelDomesticBenefit) FROM TravelDomesticBenefit travelDomesticBenefit WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"travelDomesticBenefit.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TravelDomesticBenefit exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TravelDomesticBenefit exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TravelDomesticBenefitPersistenceImpl.class);

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

	private static class TravelDomesticBenefitModelArgumentsResolver
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

			TravelDomesticBenefitModelImpl travelDomesticBenefitModelImpl =
				(TravelDomesticBenefitModelImpl)baseModel;

			long columnBitmask =
				travelDomesticBenefitModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					travelDomesticBenefitModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						travelDomesticBenefitModelImpl.getColumnBitmask(
							columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(TravelDomesticBenefitPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					travelDomesticBenefitModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			TravelDomesticBenefitModelImpl travelDomesticBenefitModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						travelDomesticBenefitModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						travelDomesticBenefitModelImpl.getColumnValue(
							columnName);
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