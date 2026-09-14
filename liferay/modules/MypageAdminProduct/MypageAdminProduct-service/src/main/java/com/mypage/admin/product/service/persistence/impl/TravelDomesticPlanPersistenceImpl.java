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

import com.mypage.admin.product.exception.NoSuchTravelDomesticPlanException;
import com.mypage.admin.product.model.TravelDomesticPlan;
import com.mypage.admin.product.model.impl.TravelDomesticPlanImpl;
import com.mypage.admin.product.model.impl.TravelDomesticPlanModelImpl;
import com.mypage.admin.product.service.persistence.TravelDomesticPlanPersistence;
import com.mypage.admin.product.service.persistence.TravelDomesticPlanUtil;
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
 * The persistence implementation for the travel domestic plan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = TravelDomesticPlanPersistence.class)
public class TravelDomesticPlanPersistenceImpl
	extends BasePersistenceImpl<TravelDomesticPlan>
	implements TravelDomesticPlanPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TravelDomesticPlanUtil</code> to access the travel domestic plan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TravelDomesticPlanImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBysearchPlan;
	private FinderPath _finderPathWithoutPaginationFindBysearchPlan;
	private FinderPath _finderPathCountBysearchPlan;

	/**
	 * Returns all the travel domestic plans where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @return the matching travel domestic plans
	 */
	@Override
	public List<TravelDomesticPlan> findBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi) {

		return findBysearchPlan(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel domestic plans where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @return the range of matching travel domestic plans
	 */
	@Override
	public List<TravelDomesticPlan> findBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi, int start, int end) {

		return findBysearchPlan(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the travel domestic plans where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic plans
	 */
	@Override
	public List<TravelDomesticPlan> findBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi, int start, int end,
		OrderByComparator<TravelDomesticPlan> orderByComparator) {

		return findBysearchPlan(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic plans where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic plans
	 */
	@Override
	public List<TravelDomesticPlan> findBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi, int start, int end,
		OrderByComparator<TravelDomesticPlan> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");
		code = Objects.toString(code, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBysearchPlan;
				finderArgs = new Object[] {
					travelDomesticPlanId, name, code, toproTsi, toproAtsi
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchPlan;
			finderArgs = new Object[] {
				travelDomesticPlanId, name, code, toproTsi, toproAtsi, start,
				end, orderByComparator
			};
		}

		List<TravelDomesticPlan> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticPlan>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelDomesticPlan travelDomesticPlan : list) {
					if ((travelDomesticPlanId !=
							travelDomesticPlan.getTravelDomesticPlanId()) ||
						!name.equals(travelDomesticPlan.getName()) ||
						!code.equals(travelDomesticPlan.getCode()) ||
						(toproTsi != travelDomesticPlan.getToproTsi()) ||
						(toproAtsi != travelDomesticPlan.getToproAtsi())) {

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
					7 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(7);
			}

			sb.append(_SQL_SELECT_TRAVELDOMESTICPLAN_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHPLAN_TRAVELDOMESTICPLANID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHPLAN_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_SEARCHPLAN_NAME_2);
			}

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHPLAN_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_SEARCHPLAN_CODE_2);
			}

			sb.append(_FINDER_COLUMN_SEARCHPLAN_TOPROTSI_2);

			sb.append(_FINDER_COLUMN_SEARCHPLAN_TOPROATSI_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelDomesticPlanModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(travelDomesticPlanId);

				if (bindName) {
					queryPos.add(name);
				}

				if (bindCode) {
					queryPos.add(code);
				}

				queryPos.add(toproTsi);

				queryPos.add(toproAtsi);

				list = (List<TravelDomesticPlan>)QueryUtil.list(
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
	 * Returns the first travel domestic plan in the ordered set where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a matching travel domestic plan could not be found
	 */
	@Override
	public TravelDomesticPlan findBysearchPlan_First(
			long travelDomesticPlanId, String name, String code, int toproTsi,
			int toproAtsi,
			OrderByComparator<TravelDomesticPlan> orderByComparator)
		throws NoSuchTravelDomesticPlanException {

		TravelDomesticPlan travelDomesticPlan = fetchBysearchPlan_First(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi,
			orderByComparator);

		if (travelDomesticPlan != null) {
			return travelDomesticPlan;
		}

		StringBundler sb = new StringBundler(12);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelDomesticPlanId=");
		sb.append(travelDomesticPlanId);

		sb.append(", name=");
		sb.append(name);

		sb.append(", code=");
		sb.append(code);

		sb.append(", toproTsi=");
		sb.append(toproTsi);

		sb.append(", toproAtsi=");
		sb.append(toproAtsi);

		sb.append("}");

		throw new NoSuchTravelDomesticPlanException(sb.toString());
	}

	/**
	 * Returns the first travel domestic plan in the ordered set where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic plan, or <code>null</code> if a matching travel domestic plan could not be found
	 */
	@Override
	public TravelDomesticPlan fetchBysearchPlan_First(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi,
		OrderByComparator<TravelDomesticPlan> orderByComparator) {

		List<TravelDomesticPlan> list = findBysearchPlan(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel domestic plan in the ordered set where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a matching travel domestic plan could not be found
	 */
	@Override
	public TravelDomesticPlan findBysearchPlan_Last(
			long travelDomesticPlanId, String name, String code, int toproTsi,
			int toproAtsi,
			OrderByComparator<TravelDomesticPlan> orderByComparator)
		throws NoSuchTravelDomesticPlanException {

		TravelDomesticPlan travelDomesticPlan = fetchBysearchPlan_Last(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi,
			orderByComparator);

		if (travelDomesticPlan != null) {
			return travelDomesticPlan;
		}

		StringBundler sb = new StringBundler(12);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelDomesticPlanId=");
		sb.append(travelDomesticPlanId);

		sb.append(", name=");
		sb.append(name);

		sb.append(", code=");
		sb.append(code);

		sb.append(", toproTsi=");
		sb.append(toproTsi);

		sb.append(", toproAtsi=");
		sb.append(toproAtsi);

		sb.append("}");

		throw new NoSuchTravelDomesticPlanException(sb.toString());
	}

	/**
	 * Returns the last travel domestic plan in the ordered set where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic plan, or <code>null</code> if a matching travel domestic plan could not be found
	 */
	@Override
	public TravelDomesticPlan fetchBysearchPlan_Last(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi,
		OrderByComparator<TravelDomesticPlan> orderByComparator) {

		int count = countBysearchPlan(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi);

		if (count == 0) {
			return null;
		}

		List<TravelDomesticPlan> list = findBysearchPlan(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi, count - 1,
			count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the travel domestic plans where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63; from the database.
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 */
	@Override
	public void removeBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi) {

		for (TravelDomesticPlan travelDomesticPlan :
				findBysearchPlan(
					travelDomesticPlanId, name, code, toproTsi, toproAtsi,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(travelDomesticPlan);
		}
	}

	/**
	 * Returns the number of travel domestic plans where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @return the number of matching travel domestic plans
	 */
	@Override
	public int countBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi) {

		name = Objects.toString(name, "");
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountBysearchPlan;

		Object[] finderArgs = new Object[] {
			travelDomesticPlanId, name, code, toproTsi, toproAtsi
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_COUNT_TRAVELDOMESTICPLAN_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHPLAN_TRAVELDOMESTICPLANID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHPLAN_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_SEARCHPLAN_NAME_2);
			}

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHPLAN_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_SEARCHPLAN_CODE_2);
			}

			sb.append(_FINDER_COLUMN_SEARCHPLAN_TOPROTSI_2);

			sb.append(_FINDER_COLUMN_SEARCHPLAN_TOPROATSI_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(travelDomesticPlanId);

				if (bindName) {
					queryPos.add(name);
				}

				if (bindCode) {
					queryPos.add(code);
				}

				queryPos.add(toproTsi);

				queryPos.add(toproAtsi);

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
		_FINDER_COLUMN_SEARCHPLAN_TRAVELDOMESTICPLANID_2 =
			"travelDomesticPlan.travelDomesticPlanId = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHPLAN_NAME_2 =
		"travelDomesticPlan.name = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHPLAN_NAME_3 =
		"(travelDomesticPlan.name IS NULL OR travelDomesticPlan.name = '') AND ";

	private static final String _FINDER_COLUMN_SEARCHPLAN_CODE_2 =
		"travelDomesticPlan.code = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHPLAN_CODE_3 =
		"(travelDomesticPlan.code IS NULL OR travelDomesticPlan.code = '') AND ";

	private static final String _FINDER_COLUMN_SEARCHPLAN_TOPROTSI_2 =
		"travelDomesticPlan.toproTsi = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHPLAN_TOPROATSI_2 =
		"travelDomesticPlan.toproAtsi = ?";

	private FinderPath _finderPathWithPaginationFindBysearchByCode;
	private FinderPath _finderPathWithoutPaginationFindBysearchByCode;
	private FinderPath _finderPathCountBysearchByCode;

	/**
	 * Returns all the travel domestic plans where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching travel domestic plans
	 */
	@Override
	public List<TravelDomesticPlan> findBysearchByCode(String code) {
		return findBysearchByCode(
			code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel domestic plans where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @return the range of matching travel domestic plans
	 */
	@Override
	public List<TravelDomesticPlan> findBysearchByCode(
		String code, int start, int end) {

		return findBysearchByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel domestic plans where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic plans
	 */
	@Override
	public List<TravelDomesticPlan> findBysearchByCode(
		String code, int start, int end,
		OrderByComparator<TravelDomesticPlan> orderByComparator) {

		return findBysearchByCode(code, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic plans where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic plans
	 */
	@Override
	public List<TravelDomesticPlan> findBysearchByCode(
		String code, int start, int end,
		OrderByComparator<TravelDomesticPlan> orderByComparator,
		boolean useFinderCache) {

		code = Objects.toString(code, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBysearchByCode;
				finderArgs = new Object[] {code};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchByCode;
			finderArgs = new Object[] {code, start, end, orderByComparator};
		}

		List<TravelDomesticPlan> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticPlan>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelDomesticPlan travelDomesticPlan : list) {
					if (!code.equals(travelDomesticPlan.getCode())) {
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

			sb.append(_SQL_SELECT_TRAVELDOMESTICPLAN_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHBYCODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_SEARCHBYCODE_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelDomesticPlanModelImpl.ORDER_BY_JPQL);
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

				list = (List<TravelDomesticPlan>)QueryUtil.list(
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
	 * Returns the first travel domestic plan in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a matching travel domestic plan could not be found
	 */
	@Override
	public TravelDomesticPlan findBysearchByCode_First(
			String code,
			OrderByComparator<TravelDomesticPlan> orderByComparator)
		throws NoSuchTravelDomesticPlanException {

		TravelDomesticPlan travelDomesticPlan = fetchBysearchByCode_First(
			code, orderByComparator);

		if (travelDomesticPlan != null) {
			return travelDomesticPlan;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchTravelDomesticPlanException(sb.toString());
	}

	/**
	 * Returns the first travel domestic plan in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic plan, or <code>null</code> if a matching travel domestic plan could not be found
	 */
	@Override
	public TravelDomesticPlan fetchBysearchByCode_First(
		String code, OrderByComparator<TravelDomesticPlan> orderByComparator) {

		List<TravelDomesticPlan> list = findBysearchByCode(
			code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel domestic plan in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a matching travel domestic plan could not be found
	 */
	@Override
	public TravelDomesticPlan findBysearchByCode_Last(
			String code,
			OrderByComparator<TravelDomesticPlan> orderByComparator)
		throws NoSuchTravelDomesticPlanException {

		TravelDomesticPlan travelDomesticPlan = fetchBysearchByCode_Last(
			code, orderByComparator);

		if (travelDomesticPlan != null) {
			return travelDomesticPlan;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchTravelDomesticPlanException(sb.toString());
	}

	/**
	 * Returns the last travel domestic plan in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic plan, or <code>null</code> if a matching travel domestic plan could not be found
	 */
	@Override
	public TravelDomesticPlan fetchBysearchByCode_Last(
		String code, OrderByComparator<TravelDomesticPlan> orderByComparator) {

		int count = countBysearchByCode(code);

		if (count == 0) {
			return null;
		}

		List<TravelDomesticPlan> list = findBysearchByCode(
			code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the travel domestic plans before and after the current travel domestic plan in the ordered set where code = &#63;.
	 *
	 * @param travelDomesticPlanId the primary key of the current travel domestic plan
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a travel domestic plan with the primary key could not be found
	 */
	@Override
	public TravelDomesticPlan[] findBysearchByCode_PrevAndNext(
			long travelDomesticPlanId, String code,
			OrderByComparator<TravelDomesticPlan> orderByComparator)
		throws NoSuchTravelDomesticPlanException {

		code = Objects.toString(code, "");

		TravelDomesticPlan travelDomesticPlan = findByPrimaryKey(
			travelDomesticPlanId);

		Session session = null;

		try {
			session = openSession();

			TravelDomesticPlan[] array = new TravelDomesticPlanImpl[3];

			array[0] = getBysearchByCode_PrevAndNext(
				session, travelDomesticPlan, code, orderByComparator, true);

			array[1] = travelDomesticPlan;

			array[2] = getBysearchByCode_PrevAndNext(
				session, travelDomesticPlan, code, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TravelDomesticPlan getBysearchByCode_PrevAndNext(
		Session session, TravelDomesticPlan travelDomesticPlan, String code,
		OrderByComparator<TravelDomesticPlan> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAVELDOMESTICPLAN_WHERE);

		boolean bindCode = false;

		if (code.isEmpty()) {
			sb.append(_FINDER_COLUMN_SEARCHBYCODE_CODE_3);
		}
		else {
			bindCode = true;

			sb.append(_FINDER_COLUMN_SEARCHBYCODE_CODE_2);
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
			sb.append(TravelDomesticPlanModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCode) {
			queryPos.add(code);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						travelDomesticPlan)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TravelDomesticPlan> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the travel domestic plans where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	@Override
	public void removeBysearchByCode(String code) {
		for (TravelDomesticPlan travelDomesticPlan :
				findBysearchByCode(
					code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(travelDomesticPlan);
		}
	}

	/**
	 * Returns the number of travel domestic plans where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching travel domestic plans
	 */
	@Override
	public int countBysearchByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountBysearchByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAVELDOMESTICPLAN_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHBYCODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_SEARCHBYCODE_CODE_2);
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

	private static final String _FINDER_COLUMN_SEARCHBYCODE_CODE_2 =
		"travelDomesticPlan.code = ?";

	private static final String _FINDER_COLUMN_SEARCHBYCODE_CODE_3 =
		"(travelDomesticPlan.code IS NULL OR travelDomesticPlan.code = '')";

	private FinderPath _finderPathFetchByCode;
	private FinderPath _finderPathCountByCode;

	/**
	 * Returns the travel domestic plan where code = &#63; or throws a <code>NoSuchTravelDomesticPlanException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a matching travel domestic plan could not be found
	 */
	@Override
	public TravelDomesticPlan findByCode(String code)
		throws NoSuchTravelDomesticPlanException {

		TravelDomesticPlan travelDomesticPlan = fetchByCode(code);

		if (travelDomesticPlan == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("code=");
			sb.append(code);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTravelDomesticPlanException(sb.toString());
		}

		return travelDomesticPlan;
	}

	/**
	 * Returns the travel domestic plan where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching travel domestic plan, or <code>null</code> if a matching travel domestic plan could not be found
	 */
	@Override
	public TravelDomesticPlan fetchByCode(String code) {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the travel domestic plan where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching travel domestic plan, or <code>null</code> if a matching travel domestic plan could not be found
	 */
	@Override
	public TravelDomesticPlan fetchByCode(String code, boolean useFinderCache) {
		code = Objects.toString(code, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {code};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCode, finderArgs, this);
		}

		if (result instanceof TravelDomesticPlan) {
			TravelDomesticPlan travelDomesticPlan = (TravelDomesticPlan)result;

			if (!Objects.equals(code, travelDomesticPlan.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_TRAVELDOMESTICPLAN_WHERE);

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

				List<TravelDomesticPlan> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCode, finderArgs, list);
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
								"TravelDomesticPlanPersistenceImpl.fetchByCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TravelDomesticPlan travelDomesticPlan = list.get(0);

					result = travelDomesticPlan;

					cacheResult(travelDomesticPlan);
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
			return (TravelDomesticPlan)result;
		}
	}

	/**
	 * Removes the travel domestic plan where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the travel domestic plan that was removed
	 */
	@Override
	public TravelDomesticPlan removeByCode(String code)
		throws NoSuchTravelDomesticPlanException {

		TravelDomesticPlan travelDomesticPlan = findByCode(code);

		return remove(travelDomesticPlan);
	}

	/**
	 * Returns the number of travel domestic plans where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching travel domestic plans
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAVELDOMESTICPLAN_WHERE);

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
		"travelDomesticPlan.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(travelDomesticPlan.code IS NULL OR travelDomesticPlan.code = '')";

	public TravelDomesticPlanPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TravelDomesticPlan.class);

		setModelImplClass(TravelDomesticPlanImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the travel domestic plan in the entity cache if it is enabled.
	 *
	 * @param travelDomesticPlan the travel domestic plan
	 */
	@Override
	public void cacheResult(TravelDomesticPlan travelDomesticPlan) {
		entityCache.putResult(
			TravelDomesticPlanImpl.class, travelDomesticPlan.getPrimaryKey(),
			travelDomesticPlan);

		finderCache.putResult(
			_finderPathFetchByCode, new Object[] {travelDomesticPlan.getCode()},
			travelDomesticPlan);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the travel domestic plans in the entity cache if it is enabled.
	 *
	 * @param travelDomesticPlans the travel domestic plans
	 */
	@Override
	public void cacheResult(List<TravelDomesticPlan> travelDomesticPlans) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (travelDomesticPlans.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TravelDomesticPlan travelDomesticPlan : travelDomesticPlans) {
			if (entityCache.getResult(
					TravelDomesticPlanImpl.class,
					travelDomesticPlan.getPrimaryKey()) == null) {

				cacheResult(travelDomesticPlan);
			}
		}
	}

	/**
	 * Clears the cache for all travel domestic plans.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TravelDomesticPlanImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the travel domestic plan.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TravelDomesticPlan travelDomesticPlan) {
		entityCache.removeResult(
			TravelDomesticPlanImpl.class, travelDomesticPlan);
	}

	@Override
	public void clearCache(List<TravelDomesticPlan> travelDomesticPlans) {
		for (TravelDomesticPlan travelDomesticPlan : travelDomesticPlans) {
			entityCache.removeResult(
				TravelDomesticPlanImpl.class, travelDomesticPlan);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TravelDomesticPlanImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TravelDomesticPlanModelImpl travelDomesticPlanModelImpl) {

		Object[] args = new Object[] {travelDomesticPlanModelImpl.getCode()};

		finderCache.putResult(
			_finderPathCountByCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCode, args, travelDomesticPlanModelImpl, false);
	}

	/**
	 * Creates a new travel domestic plan with the primary key. Does not add the travel domestic plan to the database.
	 *
	 * @param travelDomesticPlanId the primary key for the new travel domestic plan
	 * @return the new travel domestic plan
	 */
	@Override
	public TravelDomesticPlan create(long travelDomesticPlanId) {
		TravelDomesticPlan travelDomesticPlan = new TravelDomesticPlanImpl();

		travelDomesticPlan.setNew(true);
		travelDomesticPlan.setPrimaryKey(travelDomesticPlanId);

		travelDomesticPlan.setCompanyId(CompanyThreadLocal.getCompanyId());

		return travelDomesticPlan;
	}

	/**
	 * Removes the travel domestic plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticPlanId the primary key of the travel domestic plan
	 * @return the travel domestic plan that was removed
	 * @throws NoSuchTravelDomesticPlanException if a travel domestic plan with the primary key could not be found
	 */
	@Override
	public TravelDomesticPlan remove(long travelDomesticPlanId)
		throws NoSuchTravelDomesticPlanException {

		return remove((Serializable)travelDomesticPlanId);
	}

	/**
	 * Removes the travel domestic plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the travel domestic plan
	 * @return the travel domestic plan that was removed
	 * @throws NoSuchTravelDomesticPlanException if a travel domestic plan with the primary key could not be found
	 */
	@Override
	public TravelDomesticPlan remove(Serializable primaryKey)
		throws NoSuchTravelDomesticPlanException {

		Session session = null;

		try {
			session = openSession();

			TravelDomesticPlan travelDomesticPlan =
				(TravelDomesticPlan)session.get(
					TravelDomesticPlanImpl.class, primaryKey);

			if (travelDomesticPlan == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTravelDomesticPlanException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(travelDomesticPlan);
		}
		catch (NoSuchTravelDomesticPlanException noSuchEntityException) {
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
	protected TravelDomesticPlan removeImpl(
		TravelDomesticPlan travelDomesticPlan) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(travelDomesticPlan)) {
				travelDomesticPlan = (TravelDomesticPlan)session.get(
					TravelDomesticPlanImpl.class,
					travelDomesticPlan.getPrimaryKeyObj());
			}

			if (travelDomesticPlan != null) {
				session.delete(travelDomesticPlan);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (travelDomesticPlan != null) {
			clearCache(travelDomesticPlan);
		}

		return travelDomesticPlan;
	}

	@Override
	public TravelDomesticPlan updateImpl(
		TravelDomesticPlan travelDomesticPlan) {

		boolean isNew = travelDomesticPlan.isNew();

		if (!(travelDomesticPlan instanceof TravelDomesticPlanModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(travelDomesticPlan.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					travelDomesticPlan);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in travelDomesticPlan proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TravelDomesticPlan implementation " +
					travelDomesticPlan.getClass());
		}

		TravelDomesticPlanModelImpl travelDomesticPlanModelImpl =
			(TravelDomesticPlanModelImpl)travelDomesticPlan;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (travelDomesticPlan.getCreateDate() == null)) {
			if (serviceContext == null) {
				travelDomesticPlan.setCreateDate(date);
			}
			else {
				travelDomesticPlan.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!travelDomesticPlanModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				travelDomesticPlan.setModifiedDate(date);
			}
			else {
				travelDomesticPlan.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(travelDomesticPlan);
			}
			else {
				travelDomesticPlan = (TravelDomesticPlan)session.merge(
					travelDomesticPlan);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TravelDomesticPlanImpl.class, travelDomesticPlanModelImpl, false,
			true);

		cacheUniqueFindersCache(travelDomesticPlanModelImpl);

		if (isNew) {
			travelDomesticPlan.setNew(false);
		}

		travelDomesticPlan.resetOriginalValues();

		return travelDomesticPlan;
	}

	/**
	 * Returns the travel domestic plan with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the travel domestic plan
	 * @return the travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a travel domestic plan with the primary key could not be found
	 */
	@Override
	public TravelDomesticPlan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTravelDomesticPlanException {

		TravelDomesticPlan travelDomesticPlan = fetchByPrimaryKey(primaryKey);

		if (travelDomesticPlan == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTravelDomesticPlanException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return travelDomesticPlan;
	}

	/**
	 * Returns the travel domestic plan with the primary key or throws a <code>NoSuchTravelDomesticPlanException</code> if it could not be found.
	 *
	 * @param travelDomesticPlanId the primary key of the travel domestic plan
	 * @return the travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a travel domestic plan with the primary key could not be found
	 */
	@Override
	public TravelDomesticPlan findByPrimaryKey(long travelDomesticPlanId)
		throws NoSuchTravelDomesticPlanException {

		return findByPrimaryKey((Serializable)travelDomesticPlanId);
	}

	/**
	 * Returns the travel domestic plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticPlanId the primary key of the travel domestic plan
	 * @return the travel domestic plan, or <code>null</code> if a travel domestic plan with the primary key could not be found
	 */
	@Override
	public TravelDomesticPlan fetchByPrimaryKey(long travelDomesticPlanId) {
		return fetchByPrimaryKey((Serializable)travelDomesticPlanId);
	}

	/**
	 * Returns all the travel domestic plans.
	 *
	 * @return the travel domestic plans
	 */
	@Override
	public List<TravelDomesticPlan> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel domestic plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @return the range of travel domestic plans
	 */
	@Override
	public List<TravelDomesticPlan> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel domestic plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic plans
	 */
	@Override
	public List<TravelDomesticPlan> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticPlan> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic plans
	 */
	@Override
	public List<TravelDomesticPlan> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticPlan> orderByComparator,
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

		List<TravelDomesticPlan> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticPlan>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAVELDOMESTICPLAN);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAVELDOMESTICPLAN;

				sql = sql.concat(TravelDomesticPlanModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TravelDomesticPlan>)QueryUtil.list(
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
	 * Removes all the travel domestic plans from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TravelDomesticPlan travelDomesticPlan : findAll()) {
			remove(travelDomesticPlan);
		}
	}

	/**
	 * Returns the number of travel domestic plans.
	 *
	 * @return the number of travel domestic plans
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
					_SQL_COUNT_TRAVELDOMESTICPLAN);

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
		return "travelDomesticPlanId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAVELDOMESTICPLAN;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TravelDomesticPlanModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the travel domestic plan persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new TravelDomesticPlanModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", TravelDomesticPlan.class.getName()));

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

		_finderPathWithPaginationFindBysearchPlan = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchPlan",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {
				"travelDomesticPlanId", "name", "code_", "toproTsi", "toproAtsi"
			},
			true);

		_finderPathWithoutPaginationFindBysearchPlan = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysearchPlan",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			new String[] {
				"travelDomesticPlanId", "name", "code_", "toproTsi", "toproAtsi"
			},
			true);

		_finderPathCountBysearchPlan = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchPlan",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			new String[] {
				"travelDomesticPlanId", "name", "code_", "toproTsi", "toproAtsi"
			},
			false);

		_finderPathWithPaginationFindBysearchByCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchByCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"code_"}, true);

		_finderPathWithoutPaginationFindBysearchByCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysearchByCode",
			new String[] {String.class.getName()}, new String[] {"code_"},
			true);

		_finderPathCountBysearchByCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchByCode",
			new String[] {String.class.getName()}, new String[] {"code_"},
			false);

		_finderPathFetchByCode = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] {String.class.getName()}, new String[] {"code_"},
			true);

		_finderPathCountByCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] {String.class.getName()}, new String[] {"code_"},
			false);

		_setTravelDomesticPlanUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTravelDomesticPlanUtilPersistence(null);

		entityCache.removeCache(TravelDomesticPlanImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setTravelDomesticPlanUtilPersistence(
		TravelDomesticPlanPersistence travelDomesticPlanPersistence) {

		try {
			Field field = TravelDomesticPlanUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, travelDomesticPlanPersistence);
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

	private static final String _SQL_SELECT_TRAVELDOMESTICPLAN =
		"SELECT travelDomesticPlan FROM TravelDomesticPlan travelDomesticPlan";

	private static final String _SQL_SELECT_TRAVELDOMESTICPLAN_WHERE =
		"SELECT travelDomesticPlan FROM TravelDomesticPlan travelDomesticPlan WHERE ";

	private static final String _SQL_COUNT_TRAVELDOMESTICPLAN =
		"SELECT COUNT(travelDomesticPlan) FROM TravelDomesticPlan travelDomesticPlan";

	private static final String _SQL_COUNT_TRAVELDOMESTICPLAN_WHERE =
		"SELECT COUNT(travelDomesticPlan) FROM TravelDomesticPlan travelDomesticPlan WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "travelDomesticPlan.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TravelDomesticPlan exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TravelDomesticPlan exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TravelDomesticPlanPersistenceImpl.class);

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

	private static class TravelDomesticPlanModelArgumentsResolver
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

			TravelDomesticPlanModelImpl travelDomesticPlanModelImpl =
				(TravelDomesticPlanModelImpl)baseModel;

			long columnBitmask = travelDomesticPlanModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					travelDomesticPlanModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						travelDomesticPlanModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					travelDomesticPlanModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			TravelDomesticPlanModelImpl travelDomesticPlanModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						travelDomesticPlanModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = travelDomesticPlanModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}