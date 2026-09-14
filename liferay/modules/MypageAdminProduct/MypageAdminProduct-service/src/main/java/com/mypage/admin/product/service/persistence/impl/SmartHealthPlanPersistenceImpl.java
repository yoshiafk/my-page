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

import com.mypage.admin.product.exception.NoSuchSmartHealthPlanException;
import com.mypage.admin.product.model.SmartHealthPlan;
import com.mypage.admin.product.model.impl.SmartHealthPlanImpl;
import com.mypage.admin.product.model.impl.SmartHealthPlanModelImpl;
import com.mypage.admin.product.service.persistence.SmartHealthPlanPersistence;
import com.mypage.admin.product.service.persistence.SmartHealthPlanUtil;
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
 * The persistence implementation for the smart health plan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = SmartHealthPlanPersistence.class)
public class SmartHealthPlanPersistenceImpl
	extends BasePersistenceImpl<SmartHealthPlan>
	implements SmartHealthPlanPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SmartHealthPlanUtil</code> to access the smart health plan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SmartHealthPlanImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByplanName;
	private FinderPath _finderPathCountByplanName;

	/**
	 * Returns the smart health plan where planName = &#63; or throws a <code>NoSuchSmartHealthPlanException</code> if it could not be found.
	 *
	 * @param planName the plan name
	 * @return the matching smart health plan
	 * @throws NoSuchSmartHealthPlanException if a matching smart health plan could not be found
	 */
	@Override
	public SmartHealthPlan findByplanName(String planName)
		throws NoSuchSmartHealthPlanException {

		SmartHealthPlan smartHealthPlan = fetchByplanName(planName);

		if (smartHealthPlan == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("planName=");
			sb.append(planName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSmartHealthPlanException(sb.toString());
		}

		return smartHealthPlan;
	}

	/**
	 * Returns the smart health plan where planName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param planName the plan name
	 * @return the matching smart health plan, or <code>null</code> if a matching smart health plan could not be found
	 */
	@Override
	public SmartHealthPlan fetchByplanName(String planName) {
		return fetchByplanName(planName, true);
	}

	/**
	 * Returns the smart health plan where planName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param planName the plan name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart health plan, or <code>null</code> if a matching smart health plan could not be found
	 */
	@Override
	public SmartHealthPlan fetchByplanName(
		String planName, boolean useFinderCache) {

		planName = Objects.toString(planName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {planName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByplanName, finderArgs, this);
		}

		if (result instanceof SmartHealthPlan) {
			SmartHealthPlan smartHealthPlan = (SmartHealthPlan)result;

			if (!Objects.equals(planName, smartHealthPlan.getPlanName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SMARTHEALTHPLAN_WHERE);

			boolean bindPlanName = false;

			if (planName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PLANNAME_PLANNAME_3);
			}
			else {
				bindPlanName = true;

				sb.append(_FINDER_COLUMN_PLANNAME_PLANNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPlanName) {
					queryPos.add(planName);
				}

				List<SmartHealthPlan> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByplanName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {planName};
							}

							_log.warn(
								"SmartHealthPlanPersistenceImpl.fetchByplanName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SmartHealthPlan smartHealthPlan = list.get(0);

					result = smartHealthPlan;

					cacheResult(smartHealthPlan);
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
			return (SmartHealthPlan)result;
		}
	}

	/**
	 * Removes the smart health plan where planName = &#63; from the database.
	 *
	 * @param planName the plan name
	 * @return the smart health plan that was removed
	 */
	@Override
	public SmartHealthPlan removeByplanName(String planName)
		throws NoSuchSmartHealthPlanException {

		SmartHealthPlan smartHealthPlan = findByplanName(planName);

		return remove(smartHealthPlan);
	}

	/**
	 * Returns the number of smart health plans where planName = &#63;.
	 *
	 * @param planName the plan name
	 * @return the number of matching smart health plans
	 */
	@Override
	public int countByplanName(String planName) {
		planName = Objects.toString(planName, "");

		FinderPath finderPath = _finderPathCountByplanName;

		Object[] finderArgs = new Object[] {planName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SMARTHEALTHPLAN_WHERE);

			boolean bindPlanName = false;

			if (planName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PLANNAME_PLANNAME_3);
			}
			else {
				bindPlanName = true;

				sb.append(_FINDER_COLUMN_PLANNAME_PLANNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPlanName) {
					queryPos.add(planName);
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

	private static final String _FINDER_COLUMN_PLANNAME_PLANNAME_2 =
		"smartHealthPlan.planName = ?";

	private static final String _FINDER_COLUMN_PLANNAME_PLANNAME_3 =
		"(smartHealthPlan.planName IS NULL OR smartHealthPlan.planName = '')";

	private FinderPath _finderPathWithPaginationFindByplanGroup;
	private FinderPath _finderPathWithoutPaginationFindByplanGroup;
	private FinderPath _finderPathCountByplanGroup;

	/**
	 * Returns all the smart health plans where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @return the matching smart health plans
	 */
	@Override
	public List<SmartHealthPlan> findByplanGroup(String planGroup) {
		return findByplanGroup(
			planGroup, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smart health plans where planGroup = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param planGroup the plan group
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @return the range of matching smart health plans
	 */
	@Override
	public List<SmartHealthPlan> findByplanGroup(
		String planGroup, int start, int end) {

		return findByplanGroup(planGroup, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart health plans where planGroup = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param planGroup the plan group
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smart health plans
	 */
	@Override
	public List<SmartHealthPlan> findByplanGroup(
		String planGroup, int start, int end,
		OrderByComparator<SmartHealthPlan> orderByComparator) {

		return findByplanGroup(planGroup, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart health plans where planGroup = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param planGroup the plan group
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smart health plans
	 */
	@Override
	public List<SmartHealthPlan> findByplanGroup(
		String planGroup, int start, int end,
		OrderByComparator<SmartHealthPlan> orderByComparator,
		boolean useFinderCache) {

		planGroup = Objects.toString(planGroup, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByplanGroup;
				finderArgs = new Object[] {planGroup};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByplanGroup;
			finderArgs = new Object[] {
				planGroup, start, end, orderByComparator
			};
		}

		List<SmartHealthPlan> list = null;

		if (useFinderCache) {
			list = (List<SmartHealthPlan>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SmartHealthPlan smartHealthPlan : list) {
					if (!planGroup.equals(smartHealthPlan.getPlanGroup())) {
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

			sb.append(_SQL_SELECT_SMARTHEALTHPLAN_WHERE);

			boolean bindPlanGroup = false;

			if (planGroup.isEmpty()) {
				sb.append(_FINDER_COLUMN_PLANGROUP_PLANGROUP_3);
			}
			else {
				bindPlanGroup = true;

				sb.append(_FINDER_COLUMN_PLANGROUP_PLANGROUP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SmartHealthPlanModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPlanGroup) {
					queryPos.add(planGroup);
				}

				list = (List<SmartHealthPlan>)QueryUtil.list(
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
	 * Returns the first smart health plan in the ordered set where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart health plan
	 * @throws NoSuchSmartHealthPlanException if a matching smart health plan could not be found
	 */
	@Override
	public SmartHealthPlan findByplanGroup_First(
			String planGroup,
			OrderByComparator<SmartHealthPlan> orderByComparator)
		throws NoSuchSmartHealthPlanException {

		SmartHealthPlan smartHealthPlan = fetchByplanGroup_First(
			planGroup, orderByComparator);

		if (smartHealthPlan != null) {
			return smartHealthPlan;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("planGroup=");
		sb.append(planGroup);

		sb.append("}");

		throw new NoSuchSmartHealthPlanException(sb.toString());
	}

	/**
	 * Returns the first smart health plan in the ordered set where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart health plan, or <code>null</code> if a matching smart health plan could not be found
	 */
	@Override
	public SmartHealthPlan fetchByplanGroup_First(
		String planGroup,
		OrderByComparator<SmartHealthPlan> orderByComparator) {

		List<SmartHealthPlan> list = findByplanGroup(
			planGroup, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last smart health plan in the ordered set where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart health plan
	 * @throws NoSuchSmartHealthPlanException if a matching smart health plan could not be found
	 */
	@Override
	public SmartHealthPlan findByplanGroup_Last(
			String planGroup,
			OrderByComparator<SmartHealthPlan> orderByComparator)
		throws NoSuchSmartHealthPlanException {

		SmartHealthPlan smartHealthPlan = fetchByplanGroup_Last(
			planGroup, orderByComparator);

		if (smartHealthPlan != null) {
			return smartHealthPlan;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("planGroup=");
		sb.append(planGroup);

		sb.append("}");

		throw new NoSuchSmartHealthPlanException(sb.toString());
	}

	/**
	 * Returns the last smart health plan in the ordered set where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart health plan, or <code>null</code> if a matching smart health plan could not be found
	 */
	@Override
	public SmartHealthPlan fetchByplanGroup_Last(
		String planGroup,
		OrderByComparator<SmartHealthPlan> orderByComparator) {

		int count = countByplanGroup(planGroup);

		if (count == 0) {
			return null;
		}

		List<SmartHealthPlan> list = findByplanGroup(
			planGroup, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smart health plans before and after the current smart health plan in the ordered set where planGroup = &#63;.
	 *
	 * @param smartHealthPlanId the primary key of the current smart health plan
	 * @param planGroup the plan group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next smart health plan
	 * @throws NoSuchSmartHealthPlanException if a smart health plan with the primary key could not be found
	 */
	@Override
	public SmartHealthPlan[] findByplanGroup_PrevAndNext(
			long smartHealthPlanId, String planGroup,
			OrderByComparator<SmartHealthPlan> orderByComparator)
		throws NoSuchSmartHealthPlanException {

		planGroup = Objects.toString(planGroup, "");

		SmartHealthPlan smartHealthPlan = findByPrimaryKey(smartHealthPlanId);

		Session session = null;

		try {
			session = openSession();

			SmartHealthPlan[] array = new SmartHealthPlanImpl[3];

			array[0] = getByplanGroup_PrevAndNext(
				session, smartHealthPlan, planGroup, orderByComparator, true);

			array[1] = smartHealthPlan;

			array[2] = getByplanGroup_PrevAndNext(
				session, smartHealthPlan, planGroup, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SmartHealthPlan getByplanGroup_PrevAndNext(
		Session session, SmartHealthPlan smartHealthPlan, String planGroup,
		OrderByComparator<SmartHealthPlan> orderByComparator,
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

		sb.append(_SQL_SELECT_SMARTHEALTHPLAN_WHERE);

		boolean bindPlanGroup = false;

		if (planGroup.isEmpty()) {
			sb.append(_FINDER_COLUMN_PLANGROUP_PLANGROUP_3);
		}
		else {
			bindPlanGroup = true;

			sb.append(_FINDER_COLUMN_PLANGROUP_PLANGROUP_2);
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
			sb.append(SmartHealthPlanModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPlanGroup) {
			queryPos.add(planGroup);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						smartHealthPlan)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SmartHealthPlan> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smart health plans where planGroup = &#63; from the database.
	 *
	 * @param planGroup the plan group
	 */
	@Override
	public void removeByplanGroup(String planGroup) {
		for (SmartHealthPlan smartHealthPlan :
				findByplanGroup(
					planGroup, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(smartHealthPlan);
		}
	}

	/**
	 * Returns the number of smart health plans where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @return the number of matching smart health plans
	 */
	@Override
	public int countByplanGroup(String planGroup) {
		planGroup = Objects.toString(planGroup, "");

		FinderPath finderPath = _finderPathCountByplanGroup;

		Object[] finderArgs = new Object[] {planGroup};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SMARTHEALTHPLAN_WHERE);

			boolean bindPlanGroup = false;

			if (planGroup.isEmpty()) {
				sb.append(_FINDER_COLUMN_PLANGROUP_PLANGROUP_3);
			}
			else {
				bindPlanGroup = true;

				sb.append(_FINDER_COLUMN_PLANGROUP_PLANGROUP_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPlanGroup) {
					queryPos.add(planGroup);
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

	private static final String _FINDER_COLUMN_PLANGROUP_PLANGROUP_2 =
		"smartHealthPlan.planGroup = ?";

	private static final String _FINDER_COLUMN_PLANGROUP_PLANGROUP_3 =
		"(smartHealthPlan.planGroup IS NULL OR smartHealthPlan.planGroup = '')";

	public SmartHealthPlanPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SmartHealthPlan.class);

		setModelImplClass(SmartHealthPlanImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the smart health plan in the entity cache if it is enabled.
	 *
	 * @param smartHealthPlan the smart health plan
	 */
	@Override
	public void cacheResult(SmartHealthPlan smartHealthPlan) {
		entityCache.putResult(
			SmartHealthPlanImpl.class, smartHealthPlan.getPrimaryKey(),
			smartHealthPlan);

		finderCache.putResult(
			_finderPathFetchByplanName,
			new Object[] {smartHealthPlan.getPlanName()}, smartHealthPlan);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the smart health plans in the entity cache if it is enabled.
	 *
	 * @param smartHealthPlans the smart health plans
	 */
	@Override
	public void cacheResult(List<SmartHealthPlan> smartHealthPlans) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (smartHealthPlans.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SmartHealthPlan smartHealthPlan : smartHealthPlans) {
			if (entityCache.getResult(
					SmartHealthPlanImpl.class,
					smartHealthPlan.getPrimaryKey()) == null) {

				cacheResult(smartHealthPlan);
			}
		}
	}

	/**
	 * Clears the cache for all smart health plans.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SmartHealthPlanImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the smart health plan.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SmartHealthPlan smartHealthPlan) {
		entityCache.removeResult(SmartHealthPlanImpl.class, smartHealthPlan);
	}

	@Override
	public void clearCache(List<SmartHealthPlan> smartHealthPlans) {
		for (SmartHealthPlan smartHealthPlan : smartHealthPlans) {
			entityCache.removeResult(
				SmartHealthPlanImpl.class, smartHealthPlan);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SmartHealthPlanImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SmartHealthPlanModelImpl smartHealthPlanModelImpl) {

		Object[] args = new Object[] {smartHealthPlanModelImpl.getPlanName()};

		finderCache.putResult(
			_finderPathCountByplanName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByplanName, args, smartHealthPlanModelImpl, false);
	}

	/**
	 * Creates a new smart health plan with the primary key. Does not add the smart health plan to the database.
	 *
	 * @param smartHealthPlanId the primary key for the new smart health plan
	 * @return the new smart health plan
	 */
	@Override
	public SmartHealthPlan create(long smartHealthPlanId) {
		SmartHealthPlan smartHealthPlan = new SmartHealthPlanImpl();

		smartHealthPlan.setNew(true);
		smartHealthPlan.setPrimaryKey(smartHealthPlanId);

		smartHealthPlan.setCompanyId(CompanyThreadLocal.getCompanyId());

		return smartHealthPlan;
	}

	/**
	 * Removes the smart health plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartHealthPlanId the primary key of the smart health plan
	 * @return the smart health plan that was removed
	 * @throws NoSuchSmartHealthPlanException if a smart health plan with the primary key could not be found
	 */
	@Override
	public SmartHealthPlan remove(long smartHealthPlanId)
		throws NoSuchSmartHealthPlanException {

		return remove((Serializable)smartHealthPlanId);
	}

	/**
	 * Removes the smart health plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the smart health plan
	 * @return the smart health plan that was removed
	 * @throws NoSuchSmartHealthPlanException if a smart health plan with the primary key could not be found
	 */
	@Override
	public SmartHealthPlan remove(Serializable primaryKey)
		throws NoSuchSmartHealthPlanException {

		Session session = null;

		try {
			session = openSession();

			SmartHealthPlan smartHealthPlan = (SmartHealthPlan)session.get(
				SmartHealthPlanImpl.class, primaryKey);

			if (smartHealthPlan == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSmartHealthPlanException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(smartHealthPlan);
		}
		catch (NoSuchSmartHealthPlanException noSuchEntityException) {
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
	protected SmartHealthPlan removeImpl(SmartHealthPlan smartHealthPlan) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(smartHealthPlan)) {
				smartHealthPlan = (SmartHealthPlan)session.get(
					SmartHealthPlanImpl.class,
					smartHealthPlan.getPrimaryKeyObj());
			}

			if (smartHealthPlan != null) {
				session.delete(smartHealthPlan);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (smartHealthPlan != null) {
			clearCache(smartHealthPlan);
		}

		return smartHealthPlan;
	}

	@Override
	public SmartHealthPlan updateImpl(SmartHealthPlan smartHealthPlan) {
		boolean isNew = smartHealthPlan.isNew();

		if (!(smartHealthPlan instanceof SmartHealthPlanModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(smartHealthPlan.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					smartHealthPlan);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in smartHealthPlan proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SmartHealthPlan implementation " +
					smartHealthPlan.getClass());
		}

		SmartHealthPlanModelImpl smartHealthPlanModelImpl =
			(SmartHealthPlanModelImpl)smartHealthPlan;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (smartHealthPlan.getCreateDate() == null)) {
			if (serviceContext == null) {
				smartHealthPlan.setCreateDate(date);
			}
			else {
				smartHealthPlan.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!smartHealthPlanModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				smartHealthPlan.setModifiedDate(date);
			}
			else {
				smartHealthPlan.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(smartHealthPlan);
			}
			else {
				smartHealthPlan = (SmartHealthPlan)session.merge(
					smartHealthPlan);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SmartHealthPlanImpl.class, smartHealthPlanModelImpl, false, true);

		cacheUniqueFindersCache(smartHealthPlanModelImpl);

		if (isNew) {
			smartHealthPlan.setNew(false);
		}

		smartHealthPlan.resetOriginalValues();

		return smartHealthPlan;
	}

	/**
	 * Returns the smart health plan with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the smart health plan
	 * @return the smart health plan
	 * @throws NoSuchSmartHealthPlanException if a smart health plan with the primary key could not be found
	 */
	@Override
	public SmartHealthPlan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSmartHealthPlanException {

		SmartHealthPlan smartHealthPlan = fetchByPrimaryKey(primaryKey);

		if (smartHealthPlan == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSmartHealthPlanException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return smartHealthPlan;
	}

	/**
	 * Returns the smart health plan with the primary key or throws a <code>NoSuchSmartHealthPlanException</code> if it could not be found.
	 *
	 * @param smartHealthPlanId the primary key of the smart health plan
	 * @return the smart health plan
	 * @throws NoSuchSmartHealthPlanException if a smart health plan with the primary key could not be found
	 */
	@Override
	public SmartHealthPlan findByPrimaryKey(long smartHealthPlanId)
		throws NoSuchSmartHealthPlanException {

		return findByPrimaryKey((Serializable)smartHealthPlanId);
	}

	/**
	 * Returns the smart health plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartHealthPlanId the primary key of the smart health plan
	 * @return the smart health plan, or <code>null</code> if a smart health plan with the primary key could not be found
	 */
	@Override
	public SmartHealthPlan fetchByPrimaryKey(long smartHealthPlanId) {
		return fetchByPrimaryKey((Serializable)smartHealthPlanId);
	}

	/**
	 * Returns all the smart health plans.
	 *
	 * @return the smart health plans
	 */
	@Override
	public List<SmartHealthPlan> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smart health plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @return the range of smart health plans
	 */
	@Override
	public List<SmartHealthPlan> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart health plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart health plans
	 */
	@Override
	public List<SmartHealthPlan> findAll(
		int start, int end,
		OrderByComparator<SmartHealthPlan> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart health plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart health plans
	 */
	@Override
	public List<SmartHealthPlan> findAll(
		int start, int end,
		OrderByComparator<SmartHealthPlan> orderByComparator,
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

		List<SmartHealthPlan> list = null;

		if (useFinderCache) {
			list = (List<SmartHealthPlan>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SMARTHEALTHPLAN);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SMARTHEALTHPLAN;

				sql = sql.concat(SmartHealthPlanModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SmartHealthPlan>)QueryUtil.list(
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
	 * Removes all the smart health plans from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SmartHealthPlan smartHealthPlan : findAll()) {
			remove(smartHealthPlan);
		}
	}

	/**
	 * Returns the number of smart health plans.
	 *
	 * @return the number of smart health plans
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SMARTHEALTHPLAN);

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
		return "smartHealthPlanId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SMARTHEALTHPLAN;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SmartHealthPlanModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the smart health plan persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SmartHealthPlanModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SmartHealthPlan.class.getName()));

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

		_finderPathFetchByplanName = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByplanName",
			new String[] {String.class.getName()}, new String[] {"planName"},
			true);

		_finderPathCountByplanName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByplanName",
			new String[] {String.class.getName()}, new String[] {"planName"},
			false);

		_finderPathWithPaginationFindByplanGroup = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByplanGroup",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"planGroup"}, true);

		_finderPathWithoutPaginationFindByplanGroup = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByplanGroup",
			new String[] {String.class.getName()}, new String[] {"planGroup"},
			true);

		_finderPathCountByplanGroup = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByplanGroup",
			new String[] {String.class.getName()}, new String[] {"planGroup"},
			false);

		_setSmartHealthPlanUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSmartHealthPlanUtilPersistence(null);

		entityCache.removeCache(SmartHealthPlanImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setSmartHealthPlanUtilPersistence(
		SmartHealthPlanPersistence smartHealthPlanPersistence) {

		try {
			Field field = SmartHealthPlanUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, smartHealthPlanPersistence);
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

	private static final String _SQL_SELECT_SMARTHEALTHPLAN =
		"SELECT smartHealthPlan FROM SmartHealthPlan smartHealthPlan";

	private static final String _SQL_SELECT_SMARTHEALTHPLAN_WHERE =
		"SELECT smartHealthPlan FROM SmartHealthPlan smartHealthPlan WHERE ";

	private static final String _SQL_COUNT_SMARTHEALTHPLAN =
		"SELECT COUNT(smartHealthPlan) FROM SmartHealthPlan smartHealthPlan";

	private static final String _SQL_COUNT_SMARTHEALTHPLAN_WHERE =
		"SELECT COUNT(smartHealthPlan) FROM SmartHealthPlan smartHealthPlan WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "smartHealthPlan.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SmartHealthPlan exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SmartHealthPlan exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SmartHealthPlanPersistenceImpl.class);

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

	private static class SmartHealthPlanModelArgumentsResolver
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

			SmartHealthPlanModelImpl smartHealthPlanModelImpl =
				(SmartHealthPlanModelImpl)baseModel;

			long columnBitmask = smartHealthPlanModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					smartHealthPlanModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						smartHealthPlanModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					smartHealthPlanModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SmartHealthPlanModelImpl smartHealthPlanModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						smartHealthPlanModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = smartHealthPlanModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}