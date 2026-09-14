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

import com.mypage.admin.product.exception.NoSuchTravelDomesticPremiException;
import com.mypage.admin.product.model.TravelDomesticPremi;
import com.mypage.admin.product.model.impl.TravelDomesticPremiImpl;
import com.mypage.admin.product.model.impl.TravelDomesticPremiModelImpl;
import com.mypage.admin.product.service.persistence.TravelDomesticPremiPersistence;
import com.mypage.admin.product.service.persistence.TravelDomesticPremiUtil;
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
 * The persistence implementation for the travel domestic premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = TravelDomesticPremiPersistence.class)
public class TravelDomesticPremiPersistenceImpl
	extends BasePersistenceImpl<TravelDomesticPremi>
	implements TravelDomesticPremiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TravelDomesticPremiUtil</code> to access the travel domestic premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TravelDomesticPremiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBysearchPremi;
	private FinderPath _finderPathWithoutPaginationFindBysearchPremi;
	private FinderPath _finderPathCountBysearchPremi;

	/**
	 * Returns all the travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @return the matching travel domestic premis
	 */
	@Override
	public List<TravelDomesticPremi> findBysearchPremi(
		int duration, String plan, String insuredType) {

		return findBysearchPremi(
			duration, plan, insuredType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @return the range of matching travel domestic premis
	 */
	@Override
	public List<TravelDomesticPremi> findBysearchPremi(
		int duration, String plan, String insuredType, int start, int end) {

		return findBysearchPremi(duration, plan, insuredType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic premis
	 */
	@Override
	public List<TravelDomesticPremi> findBysearchPremi(
		int duration, String plan, String insuredType, int start, int end,
		OrderByComparator<TravelDomesticPremi> orderByComparator) {

		return findBysearchPremi(
			duration, plan, insuredType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic premis
	 */
	@Override
	public List<TravelDomesticPremi> findBysearchPremi(
		int duration, String plan, String insuredType, int start, int end,
		OrderByComparator<TravelDomesticPremi> orderByComparator,
		boolean useFinderCache) {

		plan = Objects.toString(plan, "");
		insuredType = Objects.toString(insuredType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBysearchPremi;
				finderArgs = new Object[] {duration, plan, insuredType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchPremi;
			finderArgs = new Object[] {
				duration, plan, insuredType, start, end, orderByComparator
			};
		}

		List<TravelDomesticPremi> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticPremi>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelDomesticPremi travelDomesticPremi : list) {
					if ((duration != travelDomesticPremi.getDuration()) ||
						!plan.equals(travelDomesticPremi.getPlan()) ||
						!insuredType.equals(
							travelDomesticPremi.getInsuredType())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_TRAVELDOMESTICPREMI_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHPREMI_DURATION_2);

			boolean bindPlan = false;

			if (plan.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHPREMI_PLAN_3);
			}
			else {
				bindPlan = true;

				sb.append(_FINDER_COLUMN_SEARCHPREMI_PLAN_2);
			}

			boolean bindInsuredType = false;

			if (insuredType.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHPREMI_INSUREDTYPE_3);
			}
			else {
				bindInsuredType = true;

				sb.append(_FINDER_COLUMN_SEARCHPREMI_INSUREDTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelDomesticPremiModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(duration);

				if (bindPlan) {
					queryPos.add(plan);
				}

				if (bindInsuredType) {
					queryPos.add(insuredType);
				}

				list = (List<TravelDomesticPremi>)QueryUtil.list(
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
	 * Returns the first travel domestic premi in the ordered set where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic premi
	 * @throws NoSuchTravelDomesticPremiException if a matching travel domestic premi could not be found
	 */
	@Override
	public TravelDomesticPremi findBysearchPremi_First(
			int duration, String plan, String insuredType,
			OrderByComparator<TravelDomesticPremi> orderByComparator)
		throws NoSuchTravelDomesticPremiException {

		TravelDomesticPremi travelDomesticPremi = fetchBysearchPremi_First(
			duration, plan, insuredType, orderByComparator);

		if (travelDomesticPremi != null) {
			return travelDomesticPremi;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("duration=");
		sb.append(duration);

		sb.append(", plan=");
		sb.append(plan);

		sb.append(", insuredType=");
		sb.append(insuredType);

		sb.append("}");

		throw new NoSuchTravelDomesticPremiException(sb.toString());
	}

	/**
	 * Returns the first travel domestic premi in the ordered set where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic premi, or <code>null</code> if a matching travel domestic premi could not be found
	 */
	@Override
	public TravelDomesticPremi fetchBysearchPremi_First(
		int duration, String plan, String insuredType,
		OrderByComparator<TravelDomesticPremi> orderByComparator) {

		List<TravelDomesticPremi> list = findBysearchPremi(
			duration, plan, insuredType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel domestic premi in the ordered set where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic premi
	 * @throws NoSuchTravelDomesticPremiException if a matching travel domestic premi could not be found
	 */
	@Override
	public TravelDomesticPremi findBysearchPremi_Last(
			int duration, String plan, String insuredType,
			OrderByComparator<TravelDomesticPremi> orderByComparator)
		throws NoSuchTravelDomesticPremiException {

		TravelDomesticPremi travelDomesticPremi = fetchBysearchPremi_Last(
			duration, plan, insuredType, orderByComparator);

		if (travelDomesticPremi != null) {
			return travelDomesticPremi;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("duration=");
		sb.append(duration);

		sb.append(", plan=");
		sb.append(plan);

		sb.append(", insuredType=");
		sb.append(insuredType);

		sb.append("}");

		throw new NoSuchTravelDomesticPremiException(sb.toString());
	}

	/**
	 * Returns the last travel domestic premi in the ordered set where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic premi, or <code>null</code> if a matching travel domestic premi could not be found
	 */
	@Override
	public TravelDomesticPremi fetchBysearchPremi_Last(
		int duration, String plan, String insuredType,
		OrderByComparator<TravelDomesticPremi> orderByComparator) {

		int count = countBysearchPremi(duration, plan, insuredType);

		if (count == 0) {
			return null;
		}

		List<TravelDomesticPremi> list = findBysearchPremi(
			duration, plan, insuredType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the travel domestic premis before and after the current travel domestic premi in the ordered set where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param travelDomesticPremiId the primary key of the current travel domestic premi
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel domestic premi
	 * @throws NoSuchTravelDomesticPremiException if a travel domestic premi with the primary key could not be found
	 */
	@Override
	public TravelDomesticPremi[] findBysearchPremi_PrevAndNext(
			long travelDomesticPremiId, int duration, String plan,
			String insuredType,
			OrderByComparator<TravelDomesticPremi> orderByComparator)
		throws NoSuchTravelDomesticPremiException {

		plan = Objects.toString(plan, "");
		insuredType = Objects.toString(insuredType, "");

		TravelDomesticPremi travelDomesticPremi = findByPrimaryKey(
			travelDomesticPremiId);

		Session session = null;

		try {
			session = openSession();

			TravelDomesticPremi[] array = new TravelDomesticPremiImpl[3];

			array[0] = getBysearchPremi_PrevAndNext(
				session, travelDomesticPremi, duration, plan, insuredType,
				orderByComparator, true);

			array[1] = travelDomesticPremi;

			array[2] = getBysearchPremi_PrevAndNext(
				session, travelDomesticPremi, duration, plan, insuredType,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TravelDomesticPremi getBysearchPremi_PrevAndNext(
		Session session, TravelDomesticPremi travelDomesticPremi, int duration,
		String plan, String insuredType,
		OrderByComparator<TravelDomesticPremi> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_TRAVELDOMESTICPREMI_WHERE);

		sb.append(_FINDER_COLUMN_SEARCHPREMI_DURATION_2);

		boolean bindPlan = false;

		if (plan.isEmpty()) {
			sb.append(_FINDER_COLUMN_SEARCHPREMI_PLAN_3);
		}
		else {
			bindPlan = true;

			sb.append(_FINDER_COLUMN_SEARCHPREMI_PLAN_2);
		}

		boolean bindInsuredType = false;

		if (insuredType.isEmpty()) {
			sb.append(_FINDER_COLUMN_SEARCHPREMI_INSUREDTYPE_3);
		}
		else {
			bindInsuredType = true;

			sb.append(_FINDER_COLUMN_SEARCHPREMI_INSUREDTYPE_2);
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
			sb.append(TravelDomesticPremiModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(duration);

		if (bindPlan) {
			queryPos.add(plan);
		}

		if (bindInsuredType) {
			queryPos.add(insuredType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						travelDomesticPremi)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TravelDomesticPremi> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63; from the database.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 */
	@Override
	public void removeBysearchPremi(
		int duration, String plan, String insuredType) {

		for (TravelDomesticPremi travelDomesticPremi :
				findBysearchPremi(
					duration, plan, insuredType, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(travelDomesticPremi);
		}
	}

	/**
	 * Returns the number of travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @return the number of matching travel domestic premis
	 */
	@Override
	public int countBysearchPremi(
		int duration, String plan, String insuredType) {

		plan = Objects.toString(plan, "");
		insuredType = Objects.toString(insuredType, "");

		FinderPath finderPath = _finderPathCountBysearchPremi;

		Object[] finderArgs = new Object[] {duration, plan, insuredType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_TRAVELDOMESTICPREMI_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHPREMI_DURATION_2);

			boolean bindPlan = false;

			if (plan.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHPREMI_PLAN_3);
			}
			else {
				bindPlan = true;

				sb.append(_FINDER_COLUMN_SEARCHPREMI_PLAN_2);
			}

			boolean bindInsuredType = false;

			if (insuredType.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHPREMI_INSUREDTYPE_3);
			}
			else {
				bindInsuredType = true;

				sb.append(_FINDER_COLUMN_SEARCHPREMI_INSUREDTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(duration);

				if (bindPlan) {
					queryPos.add(plan);
				}

				if (bindInsuredType) {
					queryPos.add(insuredType);
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

	private static final String _FINDER_COLUMN_SEARCHPREMI_DURATION_2 =
		"travelDomesticPremi.duration = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHPREMI_PLAN_2 =
		"travelDomesticPremi.plan = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHPREMI_PLAN_3 =
		"(travelDomesticPremi.plan IS NULL OR travelDomesticPremi.plan = '') AND ";

	private static final String _FINDER_COLUMN_SEARCHPREMI_INSUREDTYPE_2 =
		"travelDomesticPremi.insuredType = ?";

	private static final String _FINDER_COLUMN_SEARCHPREMI_INSUREDTYPE_3 =
		"(travelDomesticPremi.insuredType IS NULL OR travelDomesticPremi.insuredType = '')";

	public TravelDomesticPremiPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("currency", "currency_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TravelDomesticPremi.class);

		setModelImplClass(TravelDomesticPremiImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the travel domestic premi in the entity cache if it is enabled.
	 *
	 * @param travelDomesticPremi the travel domestic premi
	 */
	@Override
	public void cacheResult(TravelDomesticPremi travelDomesticPremi) {
		entityCache.putResult(
			TravelDomesticPremiImpl.class, travelDomesticPremi.getPrimaryKey(),
			travelDomesticPremi);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the travel domestic premis in the entity cache if it is enabled.
	 *
	 * @param travelDomesticPremis the travel domestic premis
	 */
	@Override
	public void cacheResult(List<TravelDomesticPremi> travelDomesticPremis) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (travelDomesticPremis.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TravelDomesticPremi travelDomesticPremi : travelDomesticPremis) {
			if (entityCache.getResult(
					TravelDomesticPremiImpl.class,
					travelDomesticPremi.getPrimaryKey()) == null) {

				cacheResult(travelDomesticPremi);
			}
		}
	}

	/**
	 * Clears the cache for all travel domestic premis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TravelDomesticPremiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the travel domestic premi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TravelDomesticPremi travelDomesticPremi) {
		entityCache.removeResult(
			TravelDomesticPremiImpl.class, travelDomesticPremi);
	}

	@Override
	public void clearCache(List<TravelDomesticPremi> travelDomesticPremis) {
		for (TravelDomesticPremi travelDomesticPremi : travelDomesticPremis) {
			entityCache.removeResult(
				TravelDomesticPremiImpl.class, travelDomesticPremi);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TravelDomesticPremiImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new travel domestic premi with the primary key. Does not add the travel domestic premi to the database.
	 *
	 * @param travelDomesticPremiId the primary key for the new travel domestic premi
	 * @return the new travel domestic premi
	 */
	@Override
	public TravelDomesticPremi create(long travelDomesticPremiId) {
		TravelDomesticPremi travelDomesticPremi = new TravelDomesticPremiImpl();

		travelDomesticPremi.setNew(true);
		travelDomesticPremi.setPrimaryKey(travelDomesticPremiId);

		travelDomesticPremi.setCompanyId(CompanyThreadLocal.getCompanyId());

		return travelDomesticPremi;
	}

	/**
	 * Removes the travel domestic premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticPremiId the primary key of the travel domestic premi
	 * @return the travel domestic premi that was removed
	 * @throws NoSuchTravelDomesticPremiException if a travel domestic premi with the primary key could not be found
	 */
	@Override
	public TravelDomesticPremi remove(long travelDomesticPremiId)
		throws NoSuchTravelDomesticPremiException {

		return remove((Serializable)travelDomesticPremiId);
	}

	/**
	 * Removes the travel domestic premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the travel domestic premi
	 * @return the travel domestic premi that was removed
	 * @throws NoSuchTravelDomesticPremiException if a travel domestic premi with the primary key could not be found
	 */
	@Override
	public TravelDomesticPremi remove(Serializable primaryKey)
		throws NoSuchTravelDomesticPremiException {

		Session session = null;

		try {
			session = openSession();

			TravelDomesticPremi travelDomesticPremi =
				(TravelDomesticPremi)session.get(
					TravelDomesticPremiImpl.class, primaryKey);

			if (travelDomesticPremi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTravelDomesticPremiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(travelDomesticPremi);
		}
		catch (NoSuchTravelDomesticPremiException noSuchEntityException) {
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
	protected TravelDomesticPremi removeImpl(
		TravelDomesticPremi travelDomesticPremi) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(travelDomesticPremi)) {
				travelDomesticPremi = (TravelDomesticPremi)session.get(
					TravelDomesticPremiImpl.class,
					travelDomesticPremi.getPrimaryKeyObj());
			}

			if (travelDomesticPremi != null) {
				session.delete(travelDomesticPremi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (travelDomesticPremi != null) {
			clearCache(travelDomesticPremi);
		}

		return travelDomesticPremi;
	}

	@Override
	public TravelDomesticPremi updateImpl(
		TravelDomesticPremi travelDomesticPremi) {

		boolean isNew = travelDomesticPremi.isNew();

		if (!(travelDomesticPremi instanceof TravelDomesticPremiModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(travelDomesticPremi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					travelDomesticPremi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in travelDomesticPremi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TravelDomesticPremi implementation " +
					travelDomesticPremi.getClass());
		}

		TravelDomesticPremiModelImpl travelDomesticPremiModelImpl =
			(TravelDomesticPremiModelImpl)travelDomesticPremi;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (travelDomesticPremi.getCreateDate() == null)) {
			if (serviceContext == null) {
				travelDomesticPremi.setCreateDate(date);
			}
			else {
				travelDomesticPremi.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!travelDomesticPremiModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				travelDomesticPremi.setModifiedDate(date);
			}
			else {
				travelDomesticPremi.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(travelDomesticPremi);
			}
			else {
				travelDomesticPremi = (TravelDomesticPremi)session.merge(
					travelDomesticPremi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TravelDomesticPremiImpl.class, travelDomesticPremiModelImpl, false,
			true);

		if (isNew) {
			travelDomesticPremi.setNew(false);
		}

		travelDomesticPremi.resetOriginalValues();

		return travelDomesticPremi;
	}

	/**
	 * Returns the travel domestic premi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the travel domestic premi
	 * @return the travel domestic premi
	 * @throws NoSuchTravelDomesticPremiException if a travel domestic premi with the primary key could not be found
	 */
	@Override
	public TravelDomesticPremi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTravelDomesticPremiException {

		TravelDomesticPremi travelDomesticPremi = fetchByPrimaryKey(primaryKey);

		if (travelDomesticPremi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTravelDomesticPremiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return travelDomesticPremi;
	}

	/**
	 * Returns the travel domestic premi with the primary key or throws a <code>NoSuchTravelDomesticPremiException</code> if it could not be found.
	 *
	 * @param travelDomesticPremiId the primary key of the travel domestic premi
	 * @return the travel domestic premi
	 * @throws NoSuchTravelDomesticPremiException if a travel domestic premi with the primary key could not be found
	 */
	@Override
	public TravelDomesticPremi findByPrimaryKey(long travelDomesticPremiId)
		throws NoSuchTravelDomesticPremiException {

		return findByPrimaryKey((Serializable)travelDomesticPremiId);
	}

	/**
	 * Returns the travel domestic premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticPremiId the primary key of the travel domestic premi
	 * @return the travel domestic premi, or <code>null</code> if a travel domestic premi with the primary key could not be found
	 */
	@Override
	public TravelDomesticPremi fetchByPrimaryKey(long travelDomesticPremiId) {
		return fetchByPrimaryKey((Serializable)travelDomesticPremiId);
	}

	/**
	 * Returns all the travel domestic premis.
	 *
	 * @return the travel domestic premis
	 */
	@Override
	public List<TravelDomesticPremi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel domestic premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @return the range of travel domestic premis
	 */
	@Override
	public List<TravelDomesticPremi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel domestic premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic premis
	 */
	@Override
	public List<TravelDomesticPremi> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticPremi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic premis
	 */
	@Override
	public List<TravelDomesticPremi> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticPremi> orderByComparator,
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

		List<TravelDomesticPremi> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticPremi>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAVELDOMESTICPREMI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAVELDOMESTICPREMI;

				sql = sql.concat(TravelDomesticPremiModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TravelDomesticPremi>)QueryUtil.list(
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
	 * Removes all the travel domestic premis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TravelDomesticPremi travelDomesticPremi : findAll()) {
			remove(travelDomesticPremi);
		}
	}

	/**
	 * Returns the number of travel domestic premis.
	 *
	 * @return the number of travel domestic premis
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
					_SQL_COUNT_TRAVELDOMESTICPREMI);

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
		return "travelDomesticPremiId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAVELDOMESTICPREMI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TravelDomesticPremiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the travel domestic premi persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new TravelDomesticPremiModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", TravelDomesticPremi.class.getName()));

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

		_finderPathWithPaginationFindBysearchPremi = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchPremi",
			new String[] {
				Integer.class.getName(), String.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"duration", "plan", "insuredType"}, true);

		_finderPathWithoutPaginationFindBysearchPremi = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysearchPremi",
			new String[] {
				Integer.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"duration", "plan", "insuredType"}, true);

		_finderPathCountBysearchPremi = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchPremi",
			new String[] {
				Integer.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"duration", "plan", "insuredType"}, false);

		_setTravelDomesticPremiUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTravelDomesticPremiUtilPersistence(null);

		entityCache.removeCache(TravelDomesticPremiImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setTravelDomesticPremiUtilPersistence(
		TravelDomesticPremiPersistence travelDomesticPremiPersistence) {

		try {
			Field field = TravelDomesticPremiUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, travelDomesticPremiPersistence);
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

	private static final String _SQL_SELECT_TRAVELDOMESTICPREMI =
		"SELECT travelDomesticPremi FROM TravelDomesticPremi travelDomesticPremi";

	private static final String _SQL_SELECT_TRAVELDOMESTICPREMI_WHERE =
		"SELECT travelDomesticPremi FROM TravelDomesticPremi travelDomesticPremi WHERE ";

	private static final String _SQL_COUNT_TRAVELDOMESTICPREMI =
		"SELECT COUNT(travelDomesticPremi) FROM TravelDomesticPremi travelDomesticPremi";

	private static final String _SQL_COUNT_TRAVELDOMESTICPREMI_WHERE =
		"SELECT COUNT(travelDomesticPremi) FROM TravelDomesticPremi travelDomesticPremi WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "travelDomesticPremi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TravelDomesticPremi exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TravelDomesticPremi exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TravelDomesticPremiPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"currency", "active"});

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

	private static class TravelDomesticPremiModelArgumentsResolver
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

			TravelDomesticPremiModelImpl travelDomesticPremiModelImpl =
				(TravelDomesticPremiModelImpl)baseModel;

			long columnBitmask =
				travelDomesticPremiModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					travelDomesticPremiModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						travelDomesticPremiModelImpl.getColumnBitmask(
							columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(TravelDomesticPremiPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					travelDomesticPremiModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			TravelDomesticPremiModelImpl travelDomesticPremiModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						travelDomesticPremiModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = travelDomesticPremiModelImpl.getColumnValue(
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