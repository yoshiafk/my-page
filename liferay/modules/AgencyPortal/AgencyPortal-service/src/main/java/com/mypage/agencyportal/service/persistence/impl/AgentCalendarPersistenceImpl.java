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

import com.mypage.agencyportal.exception.NoSuchAgentCalendarException;
import com.mypage.agencyportal.model.AgentCalendar;
import com.mypage.agencyportal.model.impl.AgentCalendarImpl;
import com.mypage.agencyportal.model.impl.AgentCalendarModelImpl;
import com.mypage.agencyportal.service.persistence.AgentCalendarPersistence;
import com.mypage.agencyportal.service.persistence.AgentCalendarUtil;
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
 * The persistence implementation for the agent calendar service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = AgentCalendarPersistence.class)
public class AgentCalendarPersistenceImpl
	extends BasePersistenceImpl<AgentCalendar>
	implements AgentCalendarPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AgentCalendarUtil</code> to access the agent calendar persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AgentCalendarImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBytitle;
	private FinderPath _finderPathWithoutPaginationFindBytitle;
	private FinderPath _finderPathCountBytitle;

	/**
	 * Returns all the agent calendars where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBytitle(String title) {
		return findBytitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent calendars where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @return the range of matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBytitle(String title, int start, int end) {
		return findBytitle(title, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent calendars where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBytitle(
		String title, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator) {

		return findBytitle(title, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent calendars where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBytitle(
		String title, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator,
		boolean useFinderCache) {

		title = Objects.toString(title, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBytitle;
				finderArgs = new Object[] {title};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBytitle;
			finderArgs = new Object[] {title, start, end, orderByComparator};
		}

		List<AgentCalendar> list = null;

		if (useFinderCache) {
			list = (List<AgentCalendar>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgentCalendar agentCalendar : list) {
					if (!title.equals(agentCalendar.getTitle())) {
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

			sb.append(_SQL_SELECT_AGENTCALENDAR_WHERE);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				sb.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				sb.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgentCalendarModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTitle) {
					queryPos.add(title);
				}

				list = (List<AgentCalendar>)QueryUtil.list(
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
	 * Returns the first agent calendar in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar findBytitle_First(
			String title, OrderByComparator<AgentCalendar> orderByComparator)
		throws NoSuchAgentCalendarException {

		AgentCalendar agentCalendar = fetchBytitle_First(
			title, orderByComparator);

		if (agentCalendar != null) {
			return agentCalendar;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("title=");
		sb.append(title);

		sb.append("}");

		throw new NoSuchAgentCalendarException(sb.toString());
	}

	/**
	 * Returns the first agent calendar in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar fetchBytitle_First(
		String title, OrderByComparator<AgentCalendar> orderByComparator) {

		List<AgentCalendar> list = findBytitle(title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agent calendar in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar findBytitle_Last(
			String title, OrderByComparator<AgentCalendar> orderByComparator)
		throws NoSuchAgentCalendarException {

		AgentCalendar agentCalendar = fetchBytitle_Last(
			title, orderByComparator);

		if (agentCalendar != null) {
			return agentCalendar;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("title=");
		sb.append(title);

		sb.append("}");

		throw new NoSuchAgentCalendarException(sb.toString());
	}

	/**
	 * Returns the last agent calendar in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar fetchBytitle_Last(
		String title, OrderByComparator<AgentCalendar> orderByComparator) {

		int count = countBytitle(title);

		if (count == 0) {
			return null;
		}

		List<AgentCalendar> list = findBytitle(
			title, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agent calendars before and after the current agent calendar in the ordered set where title = &#63;.
	 *
	 * @param agentCalendarId the primary key of the current agent calendar
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent calendar
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	@Override
	public AgentCalendar[] findBytitle_PrevAndNext(
			long agentCalendarId, String title,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws NoSuchAgentCalendarException {

		title = Objects.toString(title, "");

		AgentCalendar agentCalendar = findByPrimaryKey(agentCalendarId);

		Session session = null;

		try {
			session = openSession();

			AgentCalendar[] array = new AgentCalendarImpl[3];

			array[0] = getBytitle_PrevAndNext(
				session, agentCalendar, title, orderByComparator, true);

			array[1] = agentCalendar;

			array[2] = getBytitle_PrevAndNext(
				session, agentCalendar, title, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AgentCalendar getBytitle_PrevAndNext(
		Session session, AgentCalendar agentCalendar, String title,
		OrderByComparator<AgentCalendar> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AGENTCALENDAR_WHERE);

		boolean bindTitle = false;

		if (title.isEmpty()) {
			sb.append(_FINDER_COLUMN_TITLE_TITLE_3);
		}
		else {
			bindTitle = true;

			sb.append(_FINDER_COLUMN_TITLE_TITLE_2);
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
			sb.append(AgentCalendarModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTitle) {
			queryPos.add(title);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						agentCalendar)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgentCalendar> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agent calendars where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	@Override
	public void removeBytitle(String title) {
		for (AgentCalendar agentCalendar :
				findBytitle(
					title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(agentCalendar);
		}
	}

	/**
	 * Returns the number of agent calendars where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching agent calendars
	 */
	@Override
	public int countBytitle(String title) {
		title = Objects.toString(title, "");

		FinderPath finderPath = _finderPathCountBytitle;

		Object[] finderArgs = new Object[] {title};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTCALENDAR_WHERE);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				sb.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				sb.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTitle) {
					queryPos.add(title);
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

	private static final String _FINDER_COLUMN_TITLE_TITLE_2 =
		"agentCalendar.title = ?";

	private static final String _FINDER_COLUMN_TITLE_TITLE_3 =
		"(agentCalendar.title IS NULL OR agentCalendar.title = '')";

	private FinderPath _finderPathWithPaginationFindBylocation;
	private FinderPath _finderPathWithoutPaginationFindBylocation;
	private FinderPath _finderPathCountBylocation;

	/**
	 * Returns all the agent calendars where location = &#63;.
	 *
	 * @param location the location
	 * @return the matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBylocation(String location) {
		return findBylocation(
			location, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent calendars where location = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param location the location
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @return the range of matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBylocation(
		String location, int start, int end) {

		return findBylocation(location, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent calendars where location = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param location the location
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBylocation(
		String location, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator) {

		return findBylocation(location, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent calendars where location = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param location the location
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBylocation(
		String location, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator,
		boolean useFinderCache) {

		location = Objects.toString(location, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBylocation;
				finderArgs = new Object[] {location};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBylocation;
			finderArgs = new Object[] {location, start, end, orderByComparator};
		}

		List<AgentCalendar> list = null;

		if (useFinderCache) {
			list = (List<AgentCalendar>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgentCalendar agentCalendar : list) {
					if (!location.equals(agentCalendar.getLocation())) {
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

			sb.append(_SQL_SELECT_AGENTCALENDAR_WHERE);

			boolean bindLocation = false;

			if (location.isEmpty()) {
				sb.append(_FINDER_COLUMN_LOCATION_LOCATION_3);
			}
			else {
				bindLocation = true;

				sb.append(_FINDER_COLUMN_LOCATION_LOCATION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgentCalendarModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLocation) {
					queryPos.add(location);
				}

				list = (List<AgentCalendar>)QueryUtil.list(
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
	 * Returns the first agent calendar in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar findBylocation_First(
			String location, OrderByComparator<AgentCalendar> orderByComparator)
		throws NoSuchAgentCalendarException {

		AgentCalendar agentCalendar = fetchBylocation_First(
			location, orderByComparator);

		if (agentCalendar != null) {
			return agentCalendar;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("location=");
		sb.append(location);

		sb.append("}");

		throw new NoSuchAgentCalendarException(sb.toString());
	}

	/**
	 * Returns the first agent calendar in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar fetchBylocation_First(
		String location, OrderByComparator<AgentCalendar> orderByComparator) {

		List<AgentCalendar> list = findBylocation(
			location, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agent calendar in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar findBylocation_Last(
			String location, OrderByComparator<AgentCalendar> orderByComparator)
		throws NoSuchAgentCalendarException {

		AgentCalendar agentCalendar = fetchBylocation_Last(
			location, orderByComparator);

		if (agentCalendar != null) {
			return agentCalendar;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("location=");
		sb.append(location);

		sb.append("}");

		throw new NoSuchAgentCalendarException(sb.toString());
	}

	/**
	 * Returns the last agent calendar in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar fetchBylocation_Last(
		String location, OrderByComparator<AgentCalendar> orderByComparator) {

		int count = countBylocation(location);

		if (count == 0) {
			return null;
		}

		List<AgentCalendar> list = findBylocation(
			location, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agent calendars before and after the current agent calendar in the ordered set where location = &#63;.
	 *
	 * @param agentCalendarId the primary key of the current agent calendar
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent calendar
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	@Override
	public AgentCalendar[] findBylocation_PrevAndNext(
			long agentCalendarId, String location,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws NoSuchAgentCalendarException {

		location = Objects.toString(location, "");

		AgentCalendar agentCalendar = findByPrimaryKey(agentCalendarId);

		Session session = null;

		try {
			session = openSession();

			AgentCalendar[] array = new AgentCalendarImpl[3];

			array[0] = getBylocation_PrevAndNext(
				session, agentCalendar, location, orderByComparator, true);

			array[1] = agentCalendar;

			array[2] = getBylocation_PrevAndNext(
				session, agentCalendar, location, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AgentCalendar getBylocation_PrevAndNext(
		Session session, AgentCalendar agentCalendar, String location,
		OrderByComparator<AgentCalendar> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AGENTCALENDAR_WHERE);

		boolean bindLocation = false;

		if (location.isEmpty()) {
			sb.append(_FINDER_COLUMN_LOCATION_LOCATION_3);
		}
		else {
			bindLocation = true;

			sb.append(_FINDER_COLUMN_LOCATION_LOCATION_2);
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
			sb.append(AgentCalendarModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindLocation) {
			queryPos.add(location);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						agentCalendar)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgentCalendar> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agent calendars where location = &#63; from the database.
	 *
	 * @param location the location
	 */
	@Override
	public void removeBylocation(String location) {
		for (AgentCalendar agentCalendar :
				findBylocation(
					location, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(agentCalendar);
		}
	}

	/**
	 * Returns the number of agent calendars where location = &#63;.
	 *
	 * @param location the location
	 * @return the number of matching agent calendars
	 */
	@Override
	public int countBylocation(String location) {
		location = Objects.toString(location, "");

		FinderPath finderPath = _finderPathCountBylocation;

		Object[] finderArgs = new Object[] {location};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTCALENDAR_WHERE);

			boolean bindLocation = false;

			if (location.isEmpty()) {
				sb.append(_FINDER_COLUMN_LOCATION_LOCATION_3);
			}
			else {
				bindLocation = true;

				sb.append(_FINDER_COLUMN_LOCATION_LOCATION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLocation) {
					queryPos.add(location);
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

	private static final String _FINDER_COLUMN_LOCATION_LOCATION_2 =
		"agentCalendar.location = ?";

	private static final String _FINDER_COLUMN_LOCATION_LOCATION_3 =
		"(agentCalendar.location IS NULL OR agentCalendar.location = '')";

	private FinderPath _finderPathWithPaginationFindBymypageUserId;
	private FinderPath _finderPathWithoutPaginationFindBymypageUserId;
	private FinderPath _finderPathCountBymypageUserId;

	/**
	 * Returns all the agent calendars where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBymypageUserId(long mypageUserId) {
		return findBymypageUserId(
			mypageUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent calendars where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @return the range of matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBymypageUserId(
		long mypageUserId, int start, int end) {

		return findBymypageUserId(mypageUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent calendars where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBymypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator) {

		return findBymypageUserId(
			mypageUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent calendars where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBymypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBymypageUserId;
				finderArgs = new Object[] {mypageUserId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBymypageUserId;
			finderArgs = new Object[] {
				mypageUserId, start, end, orderByComparator
			};
		}

		List<AgentCalendar> list = null;

		if (useFinderCache) {
			list = (List<AgentCalendar>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgentCalendar agentCalendar : list) {
					if (mypageUserId != agentCalendar.getMypageUserId()) {
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

			sb.append(_SQL_SELECT_AGENTCALENDAR_WHERE);

			sb.append(_FINDER_COLUMN_MYPAGEUSERID_MYPAGEUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgentCalendarModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserId);

				list = (List<AgentCalendar>)QueryUtil.list(
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
	 * Returns the first agent calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar findBymypageUserId_First(
			long mypageUserId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws NoSuchAgentCalendarException {

		AgentCalendar agentCalendar = fetchBymypageUserId_First(
			mypageUserId, orderByComparator);

		if (agentCalendar != null) {
			return agentCalendar;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserId=");
		sb.append(mypageUserId);

		sb.append("}");

		throw new NoSuchAgentCalendarException(sb.toString());
	}

	/**
	 * Returns the first agent calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar fetchBymypageUserId_First(
		long mypageUserId, OrderByComparator<AgentCalendar> orderByComparator) {

		List<AgentCalendar> list = findBymypageUserId(
			mypageUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar findBymypageUserId_Last(
			long mypageUserId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws NoSuchAgentCalendarException {

		AgentCalendar agentCalendar = fetchBymypageUserId_Last(
			mypageUserId, orderByComparator);

		if (agentCalendar != null) {
			return agentCalendar;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserId=");
		sb.append(mypageUserId);

		sb.append("}");

		throw new NoSuchAgentCalendarException(sb.toString());
	}

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar fetchBymypageUserId_Last(
		long mypageUserId, OrderByComparator<AgentCalendar> orderByComparator) {

		int count = countBymypageUserId(mypageUserId);

		if (count == 0) {
			return null;
		}

		List<AgentCalendar> list = findBymypageUserId(
			mypageUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agent calendars before and after the current agent calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param agentCalendarId the primary key of the current agent calendar
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent calendar
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	@Override
	public AgentCalendar[] findBymypageUserId_PrevAndNext(
			long agentCalendarId, long mypageUserId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws NoSuchAgentCalendarException {

		AgentCalendar agentCalendar = findByPrimaryKey(agentCalendarId);

		Session session = null;

		try {
			session = openSession();

			AgentCalendar[] array = new AgentCalendarImpl[3];

			array[0] = getBymypageUserId_PrevAndNext(
				session, agentCalendar, mypageUserId, orderByComparator, true);

			array[1] = agentCalendar;

			array[2] = getBymypageUserId_PrevAndNext(
				session, agentCalendar, mypageUserId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AgentCalendar getBymypageUserId_PrevAndNext(
		Session session, AgentCalendar agentCalendar, long mypageUserId,
		OrderByComparator<AgentCalendar> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AGENTCALENDAR_WHERE);

		sb.append(_FINDER_COLUMN_MYPAGEUSERID_MYPAGEUSERID_2);

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
			sb.append(AgentCalendarModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(mypageUserId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						agentCalendar)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgentCalendar> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agent calendars where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	@Override
	public void removeBymypageUserId(long mypageUserId) {
		for (AgentCalendar agentCalendar :
				findBymypageUserId(
					mypageUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(agentCalendar);
		}
	}

	/**
	 * Returns the number of agent calendars where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching agent calendars
	 */
	@Override
	public int countBymypageUserId(long mypageUserId) {
		FinderPath finderPath = _finderPathCountBymypageUserId;

		Object[] finderArgs = new Object[] {mypageUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTCALENDAR_WHERE);

			sb.append(_FINDER_COLUMN_MYPAGEUSERID_MYPAGEUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserId);

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

	private static final String _FINDER_COLUMN_MYPAGEUSERID_MYPAGEUSERID_2 =
		"agentCalendar.mypageUserId = ?";

	private FinderPath _finderPathWithPaginationFindBymypageUserRoleId;
	private FinderPath _finderPathWithoutPaginationFindBymypageUserRoleId;
	private FinderPath _finderPathCountBymypageUserRoleId;

	/**
	 * Returns all the agent calendars where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBymypageUserRoleId(long mypageUserRoleId) {
		return findBymypageUserRoleId(
			mypageUserRoleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent calendars where mypageUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @return the range of matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end) {

		return findBymypageUserRoleId(mypageUserRoleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent calendars where mypageUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator) {

		return findBymypageUserRoleId(
			mypageUserRoleId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent calendars where mypageUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator,
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

		List<AgentCalendar> list = null;

		if (useFinderCache) {
			list = (List<AgentCalendar>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgentCalendar agentCalendar : list) {
					if (mypageUserRoleId !=
							agentCalendar.getMypageUserRoleId()) {

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

			sb.append(_SQL_SELECT_AGENTCALENDAR_WHERE);

			sb.append(_FINDER_COLUMN_MYPAGEUSERROLEID_MYPAGEUSERROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgentCalendarModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserRoleId);

				list = (List<AgentCalendar>)QueryUtil.list(
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
	 * Returns the first agent calendar in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar findBymypageUserRoleId_First(
			long mypageUserRoleId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws NoSuchAgentCalendarException {

		AgentCalendar agentCalendar = fetchBymypageUserRoleId_First(
			mypageUserRoleId, orderByComparator);

		if (agentCalendar != null) {
			return agentCalendar;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserRoleId=");
		sb.append(mypageUserRoleId);

		sb.append("}");

		throw new NoSuchAgentCalendarException(sb.toString());
	}

	/**
	 * Returns the first agent calendar in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar fetchBymypageUserRoleId_First(
		long mypageUserRoleId,
		OrderByComparator<AgentCalendar> orderByComparator) {

		List<AgentCalendar> list = findBymypageUserRoleId(
			mypageUserRoleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar findBymypageUserRoleId_Last(
			long mypageUserRoleId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws NoSuchAgentCalendarException {

		AgentCalendar agentCalendar = fetchBymypageUserRoleId_Last(
			mypageUserRoleId, orderByComparator);

		if (agentCalendar != null) {
			return agentCalendar;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserRoleId=");
		sb.append(mypageUserRoleId);

		sb.append("}");

		throw new NoSuchAgentCalendarException(sb.toString());
	}

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar fetchBymypageUserRoleId_Last(
		long mypageUserRoleId,
		OrderByComparator<AgentCalendar> orderByComparator) {

		int count = countBymypageUserRoleId(mypageUserRoleId);

		if (count == 0) {
			return null;
		}

		List<AgentCalendar> list = findBymypageUserRoleId(
			mypageUserRoleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agent calendars before and after the current agent calendar in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param agentCalendarId the primary key of the current agent calendar
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent calendar
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	@Override
	public AgentCalendar[] findBymypageUserRoleId_PrevAndNext(
			long agentCalendarId, long mypageUserRoleId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws NoSuchAgentCalendarException {

		AgentCalendar agentCalendar = findByPrimaryKey(agentCalendarId);

		Session session = null;

		try {
			session = openSession();

			AgentCalendar[] array = new AgentCalendarImpl[3];

			array[0] = getBymypageUserRoleId_PrevAndNext(
				session, agentCalendar, mypageUserRoleId, orderByComparator,
				true);

			array[1] = agentCalendar;

			array[2] = getBymypageUserRoleId_PrevAndNext(
				session, agentCalendar, mypageUserRoleId, orderByComparator,
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

	protected AgentCalendar getBymypageUserRoleId_PrevAndNext(
		Session session, AgentCalendar agentCalendar, long mypageUserRoleId,
		OrderByComparator<AgentCalendar> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AGENTCALENDAR_WHERE);

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
			sb.append(AgentCalendarModelImpl.ORDER_BY_JPQL);
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
						agentCalendar)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgentCalendar> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agent calendars where mypageUserRoleId = &#63; from the database.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 */
	@Override
	public void removeBymypageUserRoleId(long mypageUserRoleId) {
		for (AgentCalendar agentCalendar :
				findBymypageUserRoleId(
					mypageUserRoleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(agentCalendar);
		}
	}

	/**
	 * Returns the number of agent calendars where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the number of matching agent calendars
	 */
	@Override
	public int countBymypageUserRoleId(long mypageUserRoleId) {
		FinderPath finderPath = _finderPathCountBymypageUserRoleId;

		Object[] finderArgs = new Object[] {mypageUserRoleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTCALENDAR_WHERE);

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
			"agentCalendar.mypageUserRoleId = ?";

	private FinderPath _finderPathWithPaginationFindBymypageUserGroupId;
	private FinderPath _finderPathWithoutPaginationFindBymypageUserGroupId;
	private FinderPath _finderPathCountBymypageUserGroupId;

	/**
	 * Returns all the agent calendars where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @return the matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBymypageUserGroupId(long mypageUserGroupId) {
		return findBymypageUserGroupId(
			mypageUserGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent calendars where mypageUserGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @return the range of matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end) {

		return findBymypageUserGroupId(mypageUserGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent calendars where mypageUserGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator) {

		return findBymypageUserGroupId(
			mypageUserGroupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent calendars where mypageUserGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent calendars
	 */
	@Override
	public List<AgentCalendar> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBymypageUserGroupId;
				finderArgs = new Object[] {mypageUserGroupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBymypageUserGroupId;
			finderArgs = new Object[] {
				mypageUserGroupId, start, end, orderByComparator
			};
		}

		List<AgentCalendar> list = null;

		if (useFinderCache) {
			list = (List<AgentCalendar>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgentCalendar agentCalendar : list) {
					if (mypageUserGroupId !=
							agentCalendar.getMypageUserGroupId()) {

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

			sb.append(_SQL_SELECT_AGENTCALENDAR_WHERE);

			sb.append(_FINDER_COLUMN_MYPAGEUSERGROUPID_MYPAGEUSERGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgentCalendarModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserGroupId);

				list = (List<AgentCalendar>)QueryUtil.list(
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
	 * Returns the first agent calendar in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar findBymypageUserGroupId_First(
			long mypageUserGroupId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws NoSuchAgentCalendarException {

		AgentCalendar agentCalendar = fetchBymypageUserGroupId_First(
			mypageUserGroupId, orderByComparator);

		if (agentCalendar != null) {
			return agentCalendar;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserGroupId=");
		sb.append(mypageUserGroupId);

		sb.append("}");

		throw new NoSuchAgentCalendarException(sb.toString());
	}

	/**
	 * Returns the first agent calendar in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar fetchBymypageUserGroupId_First(
		long mypageUserGroupId,
		OrderByComparator<AgentCalendar> orderByComparator) {

		List<AgentCalendar> list = findBymypageUserGroupId(
			mypageUserGroupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar findBymypageUserGroupId_Last(
			long mypageUserGroupId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws NoSuchAgentCalendarException {

		AgentCalendar agentCalendar = fetchBymypageUserGroupId_Last(
			mypageUserGroupId, orderByComparator);

		if (agentCalendar != null) {
			return agentCalendar;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserGroupId=");
		sb.append(mypageUserGroupId);

		sb.append("}");

		throw new NoSuchAgentCalendarException(sb.toString());
	}

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	@Override
	public AgentCalendar fetchBymypageUserGroupId_Last(
		long mypageUserGroupId,
		OrderByComparator<AgentCalendar> orderByComparator) {

		int count = countBymypageUserGroupId(mypageUserGroupId);

		if (count == 0) {
			return null;
		}

		List<AgentCalendar> list = findBymypageUserGroupId(
			mypageUserGroupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agent calendars before and after the current agent calendar in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param agentCalendarId the primary key of the current agent calendar
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent calendar
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	@Override
	public AgentCalendar[] findBymypageUserGroupId_PrevAndNext(
			long agentCalendarId, long mypageUserGroupId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws NoSuchAgentCalendarException {

		AgentCalendar agentCalendar = findByPrimaryKey(agentCalendarId);

		Session session = null;

		try {
			session = openSession();

			AgentCalendar[] array = new AgentCalendarImpl[3];

			array[0] = getBymypageUserGroupId_PrevAndNext(
				session, agentCalendar, mypageUserGroupId, orderByComparator,
				true);

			array[1] = agentCalendar;

			array[2] = getBymypageUserGroupId_PrevAndNext(
				session, agentCalendar, mypageUserGroupId, orderByComparator,
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

	protected AgentCalendar getBymypageUserGroupId_PrevAndNext(
		Session session, AgentCalendar agentCalendar, long mypageUserGroupId,
		OrderByComparator<AgentCalendar> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AGENTCALENDAR_WHERE);

		sb.append(_FINDER_COLUMN_MYPAGEUSERGROUPID_MYPAGEUSERGROUPID_2);

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
			sb.append(AgentCalendarModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(mypageUserGroupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						agentCalendar)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgentCalendar> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agent calendars where mypageUserGroupId = &#63; from the database.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 */
	@Override
	public void removeBymypageUserGroupId(long mypageUserGroupId) {
		for (AgentCalendar agentCalendar :
				findBymypageUserGroupId(
					mypageUserGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(agentCalendar);
		}
	}

	/**
	 * Returns the number of agent calendars where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @return the number of matching agent calendars
	 */
	@Override
	public int countBymypageUserGroupId(long mypageUserGroupId) {
		FinderPath finderPath = _finderPathCountBymypageUserGroupId;

		Object[] finderArgs = new Object[] {mypageUserGroupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTCALENDAR_WHERE);

			sb.append(_FINDER_COLUMN_MYPAGEUSERGROUPID_MYPAGEUSERGROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserGroupId);

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
		_FINDER_COLUMN_MYPAGEUSERGROUPID_MYPAGEUSERGROUPID_2 =
			"agentCalendar.mypageUserGroupId = ?";

	public AgentCalendarPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("role", "role_");
		dbColumnNames.put("group", "group_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AgentCalendar.class);

		setModelImplClass(AgentCalendarImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the agent calendar in the entity cache if it is enabled.
	 *
	 * @param agentCalendar the agent calendar
	 */
	@Override
	public void cacheResult(AgentCalendar agentCalendar) {
		entityCache.putResult(
			AgentCalendarImpl.class, agentCalendar.getPrimaryKey(),
			agentCalendar);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the agent calendars in the entity cache if it is enabled.
	 *
	 * @param agentCalendars the agent calendars
	 */
	@Override
	public void cacheResult(List<AgentCalendar> agentCalendars) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (agentCalendars.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AgentCalendar agentCalendar : agentCalendars) {
			if (entityCache.getResult(
					AgentCalendarImpl.class, agentCalendar.getPrimaryKey()) ==
						null) {

				cacheResult(agentCalendar);
			}
		}
	}

	/**
	 * Clears the cache for all agent calendars.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AgentCalendarImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the agent calendar.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AgentCalendar agentCalendar) {
		entityCache.removeResult(AgentCalendarImpl.class, agentCalendar);
	}

	@Override
	public void clearCache(List<AgentCalendar> agentCalendars) {
		for (AgentCalendar agentCalendar : agentCalendars) {
			entityCache.removeResult(AgentCalendarImpl.class, agentCalendar);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AgentCalendarImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new agent calendar with the primary key. Does not add the agent calendar to the database.
	 *
	 * @param agentCalendarId the primary key for the new agent calendar
	 * @return the new agent calendar
	 */
	@Override
	public AgentCalendar create(long agentCalendarId) {
		AgentCalendar agentCalendar = new AgentCalendarImpl();

		agentCalendar.setNew(true);
		agentCalendar.setPrimaryKey(agentCalendarId);

		agentCalendar.setCompanyId(CompanyThreadLocal.getCompanyId());

		return agentCalendar;
	}

	/**
	 * Removes the agent calendar with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentCalendarId the primary key of the agent calendar
	 * @return the agent calendar that was removed
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	@Override
	public AgentCalendar remove(long agentCalendarId)
		throws NoSuchAgentCalendarException {

		return remove((Serializable)agentCalendarId);
	}

	/**
	 * Removes the agent calendar with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the agent calendar
	 * @return the agent calendar that was removed
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	@Override
	public AgentCalendar remove(Serializable primaryKey)
		throws NoSuchAgentCalendarException {

		Session session = null;

		try {
			session = openSession();

			AgentCalendar agentCalendar = (AgentCalendar)session.get(
				AgentCalendarImpl.class, primaryKey);

			if (agentCalendar == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAgentCalendarException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(agentCalendar);
		}
		catch (NoSuchAgentCalendarException noSuchEntityException) {
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
	protected AgentCalendar removeImpl(AgentCalendar agentCalendar) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(agentCalendar)) {
				agentCalendar = (AgentCalendar)session.get(
					AgentCalendarImpl.class, agentCalendar.getPrimaryKeyObj());
			}

			if (agentCalendar != null) {
				session.delete(agentCalendar);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (agentCalendar != null) {
			clearCache(agentCalendar);
		}

		return agentCalendar;
	}

	@Override
	public AgentCalendar updateImpl(AgentCalendar agentCalendar) {
		boolean isNew = agentCalendar.isNew();

		if (!(agentCalendar instanceof AgentCalendarModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(agentCalendar.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					agentCalendar);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in agentCalendar proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AgentCalendar implementation " +
					agentCalendar.getClass());
		}

		AgentCalendarModelImpl agentCalendarModelImpl =
			(AgentCalendarModelImpl)agentCalendar;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (agentCalendar.getCreateDate() == null)) {
			if (serviceContext == null) {
				agentCalendar.setCreateDate(date);
			}
			else {
				agentCalendar.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!agentCalendarModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				agentCalendar.setModifiedDate(date);
			}
			else {
				agentCalendar.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(agentCalendar);
			}
			else {
				agentCalendar = (AgentCalendar)session.merge(agentCalendar);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AgentCalendarImpl.class, agentCalendarModelImpl, false, true);

		if (isNew) {
			agentCalendar.setNew(false);
		}

		agentCalendar.resetOriginalValues();

		return agentCalendar;
	}

	/**
	 * Returns the agent calendar with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the agent calendar
	 * @return the agent calendar
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	@Override
	public AgentCalendar findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAgentCalendarException {

		AgentCalendar agentCalendar = fetchByPrimaryKey(primaryKey);

		if (agentCalendar == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAgentCalendarException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return agentCalendar;
	}

	/**
	 * Returns the agent calendar with the primary key or throws a <code>NoSuchAgentCalendarException</code> if it could not be found.
	 *
	 * @param agentCalendarId the primary key of the agent calendar
	 * @return the agent calendar
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	@Override
	public AgentCalendar findByPrimaryKey(long agentCalendarId)
		throws NoSuchAgentCalendarException {

		return findByPrimaryKey((Serializable)agentCalendarId);
	}

	/**
	 * Returns the agent calendar with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentCalendarId the primary key of the agent calendar
	 * @return the agent calendar, or <code>null</code> if a agent calendar with the primary key could not be found
	 */
	@Override
	public AgentCalendar fetchByPrimaryKey(long agentCalendarId) {
		return fetchByPrimaryKey((Serializable)agentCalendarId);
	}

	/**
	 * Returns all the agent calendars.
	 *
	 * @return the agent calendars
	 */
	@Override
	public List<AgentCalendar> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @return the range of agent calendars
	 */
	@Override
	public List<AgentCalendar> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agent calendars
	 */
	@Override
	public List<AgentCalendar> findAll(
		int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agent calendars
	 */
	@Override
	public List<AgentCalendar> findAll(
		int start, int end, OrderByComparator<AgentCalendar> orderByComparator,
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

		List<AgentCalendar> list = null;

		if (useFinderCache) {
			list = (List<AgentCalendar>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AGENTCALENDAR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AGENTCALENDAR;

				sql = sql.concat(AgentCalendarModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AgentCalendar>)QueryUtil.list(
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
	 * Removes all the agent calendars from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AgentCalendar agentCalendar : findAll()) {
			remove(agentCalendar);
		}
	}

	/**
	 * Returns the number of agent calendars.
	 *
	 * @return the number of agent calendars
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AGENTCALENDAR);

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
		return "agentCalendarId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AGENTCALENDAR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AgentCalendarModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the agent calendar persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new AgentCalendarModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", AgentCalendar.class.getName()));

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

		_finderPathWithPaginationFindBytitle = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytitle",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"title"}, true);

		_finderPathWithoutPaginationFindBytitle = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytitle",
			new String[] {String.class.getName()}, new String[] {"title"},
			true);

		_finderPathCountBytitle = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytitle",
			new String[] {String.class.getName()}, new String[] {"title"},
			false);

		_finderPathWithPaginationFindBylocation = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylocation",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"location"}, true);

		_finderPathWithoutPaginationFindBylocation = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylocation",
			new String[] {String.class.getName()}, new String[] {"location"},
			true);

		_finderPathCountBylocation = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylocation",
			new String[] {String.class.getName()}, new String[] {"location"},
			false);

		_finderPathWithPaginationFindBymypageUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymypageUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"mypageUserId"}, true);

		_finderPathWithoutPaginationFindBymypageUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymypageUserId",
			new String[] {Long.class.getName()}, new String[] {"mypageUserId"},
			true);

		_finderPathCountBymypageUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymypageUserId",
			new String[] {Long.class.getName()}, new String[] {"mypageUserId"},
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

		_finderPathWithPaginationFindBymypageUserGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymypageUserGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"mypageUserGroupId"}, true);

		_finderPathWithoutPaginationFindBymypageUserGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBymypageUserGroupId", new String[] {Long.class.getName()},
			new String[] {"mypageUserGroupId"}, true);

		_finderPathCountBymypageUserGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBymypageUserGroupId", new String[] {Long.class.getName()},
			new String[] {"mypageUserGroupId"}, false);

		_setAgentCalendarUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAgentCalendarUtilPersistence(null);

		entityCache.removeCache(AgentCalendarImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setAgentCalendarUtilPersistence(
		AgentCalendarPersistence agentCalendarPersistence) {

		try {
			Field field = AgentCalendarUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, agentCalendarPersistence);
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

	private static final String _SQL_SELECT_AGENTCALENDAR =
		"SELECT agentCalendar FROM AgentCalendar agentCalendar";

	private static final String _SQL_SELECT_AGENTCALENDAR_WHERE =
		"SELECT agentCalendar FROM AgentCalendar agentCalendar WHERE ";

	private static final String _SQL_COUNT_AGENTCALENDAR =
		"SELECT COUNT(agentCalendar) FROM AgentCalendar agentCalendar";

	private static final String _SQL_COUNT_AGENTCALENDAR_WHERE =
		"SELECT COUNT(agentCalendar) FROM AgentCalendar agentCalendar WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "agentCalendar.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AgentCalendar exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AgentCalendar exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AgentCalendarPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"role", "group", "active"});

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

	private static class AgentCalendarModelArgumentsResolver
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

			AgentCalendarModelImpl agentCalendarModelImpl =
				(AgentCalendarModelImpl)baseModel;

			long columnBitmask = agentCalendarModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(agentCalendarModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						agentCalendarModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(agentCalendarModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			AgentCalendarModelImpl agentCalendarModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						agentCalendarModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = agentCalendarModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}