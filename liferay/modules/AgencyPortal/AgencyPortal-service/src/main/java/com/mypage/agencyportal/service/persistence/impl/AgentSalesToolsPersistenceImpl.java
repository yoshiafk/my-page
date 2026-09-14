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

package com.mypage.agencyportal.service.persistence.impl;

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

import com.mypage.agencyportal.exception.NoSuchAgentSalesToolsException;
import com.mypage.agencyportal.model.AgentSalesTools;
import com.mypage.agencyportal.model.impl.AgentSalesToolsImpl;
import com.mypage.agencyportal.model.impl.AgentSalesToolsModelImpl;
import com.mypage.agencyportal.service.persistence.AgentSalesToolsPersistence;
import com.mypage.agencyportal.service.persistence.AgentSalesToolsUtil;
import com.mypage.agencyportal.service.persistence.impl.constants.APPersistenceConstants;

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
 * The persistence implementation for the agent sales tools service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = AgentSalesToolsPersistence.class)
public class AgentSalesToolsPersistenceImpl
	extends BasePersistenceImpl<AgentSalesTools>
	implements AgentSalesToolsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AgentSalesToolsUtil</code> to access the agent sales tools persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AgentSalesToolsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBycategory;
	private FinderPath _finderPathWithoutPaginationFindBycategory;
	private FinderPath _finderPathCountBycategory;

	/**
	 * Returns all the agent sales toolses where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching agent sales toolses
	 */
	@Override
	public List<AgentSalesTools> findBycategory(String category) {
		return findBycategory(
			category, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent sales toolses where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @return the range of matching agent sales toolses
	 */
	@Override
	public List<AgentSalesTools> findBycategory(
		String category, int start, int end) {

		return findBycategory(category, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent sales toolses where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent sales toolses
	 */
	@Override
	public List<AgentSalesTools> findBycategory(
		String category, int start, int end,
		OrderByComparator<AgentSalesTools> orderByComparator) {

		return findBycategory(category, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent sales toolses where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent sales toolses
	 */
	@Override
	public List<AgentSalesTools> findBycategory(
		String category, int start, int end,
		OrderByComparator<AgentSalesTools> orderByComparator,
		boolean useFinderCache) {

		category = Objects.toString(category, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBycategory;
				finderArgs = new Object[] {category};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycategory;
			finderArgs = new Object[] {category, start, end, orderByComparator};
		}

		List<AgentSalesTools> list = null;

		if (useFinderCache) {
			list = (List<AgentSalesTools>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgentSalesTools agentSalesTools : list) {
					if (!category.equals(agentSalesTools.getCategory())) {
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

			sb.append(_SQL_SELECT_AGENTSALESTOOLS_WHERE);

			boolean bindCategory = false;

			if (category.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgentSalesToolsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCategory) {
					queryPos.add(category);
				}

				list = (List<AgentSalesTools>)QueryUtil.list(
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
	 * Returns the first agent sales tools in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a matching agent sales tools could not be found
	 */
	@Override
	public AgentSalesTools findBycategory_First(
			String category,
			OrderByComparator<AgentSalesTools> orderByComparator)
		throws NoSuchAgentSalesToolsException {

		AgentSalesTools agentSalesTools = fetchBycategory_First(
			category, orderByComparator);

		if (agentSalesTools != null) {
			return agentSalesTools;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("category=");
		sb.append(category);

		sb.append("}");

		throw new NoSuchAgentSalesToolsException(sb.toString());
	}

	/**
	 * Returns the first agent sales tools in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent sales tools, or <code>null</code> if a matching agent sales tools could not be found
	 */
	@Override
	public AgentSalesTools fetchBycategory_First(
		String category, OrderByComparator<AgentSalesTools> orderByComparator) {

		List<AgentSalesTools> list = findBycategory(
			category, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agent sales tools in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a matching agent sales tools could not be found
	 */
	@Override
	public AgentSalesTools findBycategory_Last(
			String category,
			OrderByComparator<AgentSalesTools> orderByComparator)
		throws NoSuchAgentSalesToolsException {

		AgentSalesTools agentSalesTools = fetchBycategory_Last(
			category, orderByComparator);

		if (agentSalesTools != null) {
			return agentSalesTools;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("category=");
		sb.append(category);

		sb.append("}");

		throw new NoSuchAgentSalesToolsException(sb.toString());
	}

	/**
	 * Returns the last agent sales tools in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent sales tools, or <code>null</code> if a matching agent sales tools could not be found
	 */
	@Override
	public AgentSalesTools fetchBycategory_Last(
		String category, OrderByComparator<AgentSalesTools> orderByComparator) {

		int count = countBycategory(category);

		if (count == 0) {
			return null;
		}

		List<AgentSalesTools> list = findBycategory(
			category, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agent sales toolses before and after the current agent sales tools in the ordered set where category = &#63;.
	 *
	 * @param agentSalesToolsId the primary key of the current agent sales tools
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a agent sales tools with the primary key could not be found
	 */
	@Override
	public AgentSalesTools[] findBycategory_PrevAndNext(
			long agentSalesToolsId, String category,
			OrderByComparator<AgentSalesTools> orderByComparator)
		throws NoSuchAgentSalesToolsException {

		category = Objects.toString(category, "");

		AgentSalesTools agentSalesTools = findByPrimaryKey(agentSalesToolsId);

		Session session = null;

		try {
			session = openSession();

			AgentSalesTools[] array = new AgentSalesToolsImpl[3];

			array[0] = getBycategory_PrevAndNext(
				session, agentSalesTools, category, orderByComparator, true);

			array[1] = agentSalesTools;

			array[2] = getBycategory_PrevAndNext(
				session, agentSalesTools, category, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AgentSalesTools getBycategory_PrevAndNext(
		Session session, AgentSalesTools agentSalesTools, String category,
		OrderByComparator<AgentSalesTools> orderByComparator,
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

		sb.append(_SQL_SELECT_AGENTSALESTOOLS_WHERE);

		boolean bindCategory = false;

		if (category.isEmpty()) {
			sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
		}
		else {
			bindCategory = true;

			sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
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
			sb.append(AgentSalesToolsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCategory) {
			queryPos.add(category);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						agentSalesTools)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgentSalesTools> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agent sales toolses where category = &#63; from the database.
	 *
	 * @param category the category
	 */
	@Override
	public void removeBycategory(String category) {
		for (AgentSalesTools agentSalesTools :
				findBycategory(
					category, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(agentSalesTools);
		}
	}

	/**
	 * Returns the number of agent sales toolses where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching agent sales toolses
	 */
	@Override
	public int countBycategory(String category) {
		category = Objects.toString(category, "");

		FinderPath finderPath = _finderPathCountBycategory;

		Object[] finderArgs = new Object[] {category};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTSALESTOOLS_WHERE);

			boolean bindCategory = false;

			if (category.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCategory) {
					queryPos.add(category);
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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_2 =
		"agentSalesTools.category = ?";

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_3 =
		"(agentSalesTools.category IS NULL OR agentSalesTools.category = '')";

	private FinderPath _finderPathWithPaginationFindBymypageUserRoleId;
	private FinderPath _finderPathWithoutPaginationFindBymypageUserRoleId;
	private FinderPath _finderPathCountBymypageUserRoleId;

	/**
	 * Returns all the agent sales toolses where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the matching agent sales toolses
	 */
	@Override
	public List<AgentSalesTools> findBymypageUserRoleId(long mypageUserRoleId) {
		return findBymypageUserRoleId(
			mypageUserRoleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent sales toolses where mypageUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @return the range of matching agent sales toolses
	 */
	@Override
	public List<AgentSalesTools> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end) {

		return findBymypageUserRoleId(mypageUserRoleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent sales toolses where mypageUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent sales toolses
	 */
	@Override
	public List<AgentSalesTools> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		OrderByComparator<AgentSalesTools> orderByComparator) {

		return findBymypageUserRoleId(
			mypageUserRoleId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent sales toolses where mypageUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent sales toolses
	 */
	@Override
	public List<AgentSalesTools> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		OrderByComparator<AgentSalesTools> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBymypageUserRoleId;
				finderArgs = new Object[] {mypageUserRoleId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBymypageUserRoleId;
			finderArgs = new Object[] {
				mypageUserRoleId, start, end, orderByComparator
			};
		}

		List<AgentSalesTools> list = null;

		if (useFinderCache) {
			list = (List<AgentSalesTools>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgentSalesTools agentSalesTools : list) {
					if (mypageUserRoleId !=
							agentSalesTools.getMypageUserRoleId()) {

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

			sb.append(_SQL_SELECT_AGENTSALESTOOLS_WHERE);

			sb.append(_FINDER_COLUMN_MYPAGEUSERROLEID_MYPAGEUSERROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgentSalesToolsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserRoleId);

				list = (List<AgentSalesTools>)QueryUtil.list(
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
	 * Returns the first agent sales tools in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a matching agent sales tools could not be found
	 */
	@Override
	public AgentSalesTools findBymypageUserRoleId_First(
			long mypageUserRoleId,
			OrderByComparator<AgentSalesTools> orderByComparator)
		throws NoSuchAgentSalesToolsException {

		AgentSalesTools agentSalesTools = fetchBymypageUserRoleId_First(
			mypageUserRoleId, orderByComparator);

		if (agentSalesTools != null) {
			return agentSalesTools;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserRoleId=");
		sb.append(mypageUserRoleId);

		sb.append("}");

		throw new NoSuchAgentSalesToolsException(sb.toString());
	}

	/**
	 * Returns the first agent sales tools in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent sales tools, or <code>null</code> if a matching agent sales tools could not be found
	 */
	@Override
	public AgentSalesTools fetchBymypageUserRoleId_First(
		long mypageUserRoleId,
		OrderByComparator<AgentSalesTools> orderByComparator) {

		List<AgentSalesTools> list = findBymypageUserRoleId(
			mypageUserRoleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agent sales tools in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a matching agent sales tools could not be found
	 */
	@Override
	public AgentSalesTools findBymypageUserRoleId_Last(
			long mypageUserRoleId,
			OrderByComparator<AgentSalesTools> orderByComparator)
		throws NoSuchAgentSalesToolsException {

		AgentSalesTools agentSalesTools = fetchBymypageUserRoleId_Last(
			mypageUserRoleId, orderByComparator);

		if (agentSalesTools != null) {
			return agentSalesTools;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserRoleId=");
		sb.append(mypageUserRoleId);

		sb.append("}");

		throw new NoSuchAgentSalesToolsException(sb.toString());
	}

	/**
	 * Returns the last agent sales tools in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent sales tools, or <code>null</code> if a matching agent sales tools could not be found
	 */
	@Override
	public AgentSalesTools fetchBymypageUserRoleId_Last(
		long mypageUserRoleId,
		OrderByComparator<AgentSalesTools> orderByComparator) {

		int count = countBymypageUserRoleId(mypageUserRoleId);

		if (count == 0) {
			return null;
		}

		List<AgentSalesTools> list = findBymypageUserRoleId(
			mypageUserRoleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agent sales toolses before and after the current agent sales tools in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param agentSalesToolsId the primary key of the current agent sales tools
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a agent sales tools with the primary key could not be found
	 */
	@Override
	public AgentSalesTools[] findBymypageUserRoleId_PrevAndNext(
			long agentSalesToolsId, long mypageUserRoleId,
			OrderByComparator<AgentSalesTools> orderByComparator)
		throws NoSuchAgentSalesToolsException {

		AgentSalesTools agentSalesTools = findByPrimaryKey(agentSalesToolsId);

		Session session = null;

		try {
			session = openSession();

			AgentSalesTools[] array = new AgentSalesToolsImpl[3];

			array[0] = getBymypageUserRoleId_PrevAndNext(
				session, agentSalesTools, mypageUserRoleId, orderByComparator,
				true);

			array[1] = agentSalesTools;

			array[2] = getBymypageUserRoleId_PrevAndNext(
				session, agentSalesTools, mypageUserRoleId, orderByComparator,
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

	protected AgentSalesTools getBymypageUserRoleId_PrevAndNext(
		Session session, AgentSalesTools agentSalesTools, long mypageUserRoleId,
		OrderByComparator<AgentSalesTools> orderByComparator,
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

		sb.append(_SQL_SELECT_AGENTSALESTOOLS_WHERE);

		sb.append(_FINDER_COLUMN_MYPAGEUSERROLEID_MYPAGEUSERROLEID_2);

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
			sb.append(AgentSalesToolsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(mypageUserRoleId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						agentSalesTools)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgentSalesTools> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agent sales toolses where mypageUserRoleId = &#63; from the database.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 */
	@Override
	public void removeBymypageUserRoleId(long mypageUserRoleId) {
		for (AgentSalesTools agentSalesTools :
				findBymypageUserRoleId(
					mypageUserRoleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(agentSalesTools);
		}
	}

	/**
	 * Returns the number of agent sales toolses where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the number of matching agent sales toolses
	 */
	@Override
	public int countBymypageUserRoleId(long mypageUserRoleId) {
		FinderPath finderPath = _finderPathCountBymypageUserRoleId;

		Object[] finderArgs = new Object[] {mypageUserRoleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTSALESTOOLS_WHERE);

			sb.append(_FINDER_COLUMN_MYPAGEUSERROLEID_MYPAGEUSERROLEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserRoleId);

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
		_FINDER_COLUMN_MYPAGEUSERROLEID_MYPAGEUSERROLEID_2 =
			"agentSalesTools.mypageUserRoleId = ?";

	public AgentSalesToolsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("role", "role_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AgentSalesTools.class);

		setModelImplClass(AgentSalesToolsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the agent sales tools in the entity cache if it is enabled.
	 *
	 * @param agentSalesTools the agent sales tools
	 */
	@Override
	public void cacheResult(AgentSalesTools agentSalesTools) {
		entityCache.putResult(
			AgentSalesToolsImpl.class, agentSalesTools.getPrimaryKey(),
			agentSalesTools);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the agent sales toolses in the entity cache if it is enabled.
	 *
	 * @param agentSalesToolses the agent sales toolses
	 */
	@Override
	public void cacheResult(List<AgentSalesTools> agentSalesToolses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (agentSalesToolses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AgentSalesTools agentSalesTools : agentSalesToolses) {
			if (entityCache.getResult(
					AgentSalesToolsImpl.class,
					agentSalesTools.getPrimaryKey()) == null) {

				cacheResult(agentSalesTools);
			}
		}
	}

	/**
	 * Clears the cache for all agent sales toolses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AgentSalesToolsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the agent sales tools.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AgentSalesTools agentSalesTools) {
		entityCache.removeResult(AgentSalesToolsImpl.class, agentSalesTools);
	}

	@Override
	public void clearCache(List<AgentSalesTools> agentSalesToolses) {
		for (AgentSalesTools agentSalesTools : agentSalesToolses) {
			entityCache.removeResult(
				AgentSalesToolsImpl.class, agentSalesTools);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AgentSalesToolsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new agent sales tools with the primary key. Does not add the agent sales tools to the database.
	 *
	 * @param agentSalesToolsId the primary key for the new agent sales tools
	 * @return the new agent sales tools
	 */
	@Override
	public AgentSalesTools create(long agentSalesToolsId) {
		AgentSalesTools agentSalesTools = new AgentSalesToolsImpl();

		agentSalesTools.setNew(true);
		agentSalesTools.setPrimaryKey(agentSalesToolsId);

		agentSalesTools.setCompanyId(CompanyThreadLocal.getCompanyId());

		return agentSalesTools;
	}

	/**
	 * Removes the agent sales tools with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentSalesToolsId the primary key of the agent sales tools
	 * @return the agent sales tools that was removed
	 * @throws NoSuchAgentSalesToolsException if a agent sales tools with the primary key could not be found
	 */
	@Override
	public AgentSalesTools remove(long agentSalesToolsId)
		throws NoSuchAgentSalesToolsException {

		return remove((Serializable)agentSalesToolsId);
	}

	/**
	 * Removes the agent sales tools with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the agent sales tools
	 * @return the agent sales tools that was removed
	 * @throws NoSuchAgentSalesToolsException if a agent sales tools with the primary key could not be found
	 */
	@Override
	public AgentSalesTools remove(Serializable primaryKey)
		throws NoSuchAgentSalesToolsException {

		Session session = null;

		try {
			session = openSession();

			AgentSalesTools agentSalesTools = (AgentSalesTools)session.get(
				AgentSalesToolsImpl.class, primaryKey);

			if (agentSalesTools == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAgentSalesToolsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(agentSalesTools);
		}
		catch (NoSuchAgentSalesToolsException noSuchEntityException) {
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
	protected AgentSalesTools removeImpl(AgentSalesTools agentSalesTools) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(agentSalesTools)) {
				agentSalesTools = (AgentSalesTools)session.get(
					AgentSalesToolsImpl.class,
					agentSalesTools.getPrimaryKeyObj());
			}

			if (agentSalesTools != null) {
				session.delete(agentSalesTools);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (agentSalesTools != null) {
			clearCache(agentSalesTools);
		}

		return agentSalesTools;
	}

	@Override
	public AgentSalesTools updateImpl(AgentSalesTools agentSalesTools) {
		boolean isNew = agentSalesTools.isNew();

		if (!(agentSalesTools instanceof AgentSalesToolsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(agentSalesTools.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					agentSalesTools);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in agentSalesTools proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AgentSalesTools implementation " +
					agentSalesTools.getClass());
		}

		AgentSalesToolsModelImpl agentSalesToolsModelImpl =
			(AgentSalesToolsModelImpl)agentSalesTools;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (agentSalesTools.getCreateDate() == null)) {
			if (serviceContext == null) {
				agentSalesTools.setCreateDate(date);
			}
			else {
				agentSalesTools.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!agentSalesToolsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				agentSalesTools.setModifiedDate(date);
			}
			else {
				agentSalesTools.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(agentSalesTools);
			}
			else {
				agentSalesTools = (AgentSalesTools)session.merge(
					agentSalesTools);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AgentSalesToolsImpl.class, agentSalesToolsModelImpl, false, true);

		if (isNew) {
			agentSalesTools.setNew(false);
		}

		agentSalesTools.resetOriginalValues();

		return agentSalesTools;
	}

	/**
	 * Returns the agent sales tools with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the agent sales tools
	 * @return the agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a agent sales tools with the primary key could not be found
	 */
	@Override
	public AgentSalesTools findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAgentSalesToolsException {

		AgentSalesTools agentSalesTools = fetchByPrimaryKey(primaryKey);

		if (agentSalesTools == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAgentSalesToolsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return agentSalesTools;
	}

	/**
	 * Returns the agent sales tools with the primary key or throws a <code>NoSuchAgentSalesToolsException</code> if it could not be found.
	 *
	 * @param agentSalesToolsId the primary key of the agent sales tools
	 * @return the agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a agent sales tools with the primary key could not be found
	 */
	@Override
	public AgentSalesTools findByPrimaryKey(long agentSalesToolsId)
		throws NoSuchAgentSalesToolsException {

		return findByPrimaryKey((Serializable)agentSalesToolsId);
	}

	/**
	 * Returns the agent sales tools with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentSalesToolsId the primary key of the agent sales tools
	 * @return the agent sales tools, or <code>null</code> if a agent sales tools with the primary key could not be found
	 */
	@Override
	public AgentSalesTools fetchByPrimaryKey(long agentSalesToolsId) {
		return fetchByPrimaryKey((Serializable)agentSalesToolsId);
	}

	/**
	 * Returns all the agent sales toolses.
	 *
	 * @return the agent sales toolses
	 */
	@Override
	public List<AgentSalesTools> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent sales toolses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @return the range of agent sales toolses
	 */
	@Override
	public List<AgentSalesTools> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent sales toolses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agent sales toolses
	 */
	@Override
	public List<AgentSalesTools> findAll(
		int start, int end,
		OrderByComparator<AgentSalesTools> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent sales toolses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agent sales toolses
	 */
	@Override
	public List<AgentSalesTools> findAll(
		int start, int end,
		OrderByComparator<AgentSalesTools> orderByComparator,
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

		List<AgentSalesTools> list = null;

		if (useFinderCache) {
			list = (List<AgentSalesTools>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AGENTSALESTOOLS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AGENTSALESTOOLS;

				sql = sql.concat(AgentSalesToolsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AgentSalesTools>)QueryUtil.list(
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
	 * Removes all the agent sales toolses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AgentSalesTools agentSalesTools : findAll()) {
			remove(agentSalesTools);
		}
	}

	/**
	 * Returns the number of agent sales toolses.
	 *
	 * @return the number of agent sales toolses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AGENTSALESTOOLS);

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
		return "agentSalesToolsId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AGENTSALESTOOLS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AgentSalesToolsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the agent sales tools persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new AgentSalesToolsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", AgentSalesTools.class.getName()));

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

		_finderPathWithPaginationFindBycategory = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycategory",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"category"}, true);

		_finderPathWithoutPaginationFindBycategory = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycategory",
			new String[] {String.class.getName()}, new String[] {"category"},
			true);

		_finderPathCountBycategory = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycategory",
			new String[] {String.class.getName()}, new String[] {"category"},
			false);

		_finderPathWithPaginationFindBymypageUserRoleId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymypageUserRoleId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"mypageUserRoleId"}, true);

		_finderPathWithoutPaginationFindBymypageUserRoleId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymypageUserRoleId",
			new String[] {Long.class.getName()},
			new String[] {"mypageUserRoleId"}, true);

		_finderPathCountBymypageUserRoleId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBymypageUserRoleId", new String[] {Long.class.getName()},
			new String[] {"mypageUserRoleId"}, false);

		_setAgentSalesToolsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAgentSalesToolsUtilPersistence(null);

		entityCache.removeCache(AgentSalesToolsImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setAgentSalesToolsUtilPersistence(
		AgentSalesToolsPersistence agentSalesToolsPersistence) {

		try {
			Field field = AgentSalesToolsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, agentSalesToolsPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = APPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = APPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = APPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_AGENTSALESTOOLS =
		"SELECT agentSalesTools FROM AgentSalesTools agentSalesTools";

	private static final String _SQL_SELECT_AGENTSALESTOOLS_WHERE =
		"SELECT agentSalesTools FROM AgentSalesTools agentSalesTools WHERE ";

	private static final String _SQL_COUNT_AGENTSALESTOOLS =
		"SELECT COUNT(agentSalesTools) FROM AgentSalesTools agentSalesTools";

	private static final String _SQL_COUNT_AGENTSALESTOOLS_WHERE =
		"SELECT COUNT(agentSalesTools) FROM AgentSalesTools agentSalesTools WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "agentSalesTools.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AgentSalesTools exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AgentSalesTools exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AgentSalesToolsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"role", "active"});

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

	private static class AgentSalesToolsModelArgumentsResolver
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

			AgentSalesToolsModelImpl agentSalesToolsModelImpl =
				(AgentSalesToolsModelImpl)baseModel;

			long columnBitmask = agentSalesToolsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					agentSalesToolsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						agentSalesToolsModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					agentSalesToolsModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			AgentSalesToolsModelImpl agentSalesToolsModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						agentSalesToolsModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = agentSalesToolsModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}