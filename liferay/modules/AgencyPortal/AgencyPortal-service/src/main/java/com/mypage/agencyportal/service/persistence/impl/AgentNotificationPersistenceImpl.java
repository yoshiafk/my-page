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

import com.mypage.agencyportal.exception.NoSuchAgentNotificationException;
import com.mypage.agencyportal.model.AgentNotification;
import com.mypage.agencyportal.model.impl.AgentNotificationImpl;
import com.mypage.agencyportal.model.impl.AgentNotificationModelImpl;
import com.mypage.agencyportal.service.persistence.AgentNotificationPersistence;
import com.mypage.agencyportal.service.persistence.AgentNotificationUtil;
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
 * The persistence implementation for the agent notification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = AgentNotificationPersistence.class)
public class AgentNotificationPersistenceImpl
	extends BasePersistenceImpl<AgentNotification>
	implements AgentNotificationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AgentNotificationUtil</code> to access the agent notification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AgentNotificationImpl.class.getName();

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
	 * Returns all the agent notifications where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBytitle(String title) {
		return findBytitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent notifications where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @return the range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBytitle(
		String title, int start, int end) {

		return findBytitle(title, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent notifications where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBytitle(
		String title, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator) {

		return findBytitle(title, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent notifications where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBytitle(
		String title, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator,
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

		List<AgentNotification> list = null;

		if (useFinderCache) {
			list = (List<AgentNotification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgentNotification agentNotification : list) {
					if (!title.equals(agentNotification.getTitle())) {
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

			sb.append(_SQL_SELECT_AGENTNOTIFICATION_WHERE);

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
				sb.append(AgentNotificationModelImpl.ORDER_BY_JPQL);
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

				list = (List<AgentNotification>)QueryUtil.list(
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
	 * Returns the first agent notification in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification findBytitle_First(
			String title,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		AgentNotification agentNotification = fetchBytitle_First(
			title, orderByComparator);

		if (agentNotification != null) {
			return agentNotification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("title=");
		sb.append(title);

		sb.append("}");

		throw new NoSuchAgentNotificationException(sb.toString());
	}

	/**
	 * Returns the first agent notification in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification fetchBytitle_First(
		String title, OrderByComparator<AgentNotification> orderByComparator) {

		List<AgentNotification> list = findBytitle(
			title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agent notification in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification findBytitle_Last(
			String title,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		AgentNotification agentNotification = fetchBytitle_Last(
			title, orderByComparator);

		if (agentNotification != null) {
			return agentNotification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("title=");
		sb.append(title);

		sb.append("}");

		throw new NoSuchAgentNotificationException(sb.toString());
	}

	/**
	 * Returns the last agent notification in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification fetchBytitle_Last(
		String title, OrderByComparator<AgentNotification> orderByComparator) {

		int count = countBytitle(title);

		if (count == 0) {
			return null;
		}

		List<AgentNotification> list = findBytitle(
			title, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agent notifications before and after the current agent notification in the ordered set where title = &#63;.
	 *
	 * @param agentNotificationId the primary key of the current agent notification
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent notification
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	@Override
	public AgentNotification[] findBytitle_PrevAndNext(
			long agentNotificationId, String title,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		title = Objects.toString(title, "");

		AgentNotification agentNotification = findByPrimaryKey(
			agentNotificationId);

		Session session = null;

		try {
			session = openSession();

			AgentNotification[] array = new AgentNotificationImpl[3];

			array[0] = getBytitle_PrevAndNext(
				session, agentNotification, title, orderByComparator, true);

			array[1] = agentNotification;

			array[2] = getBytitle_PrevAndNext(
				session, agentNotification, title, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AgentNotification getBytitle_PrevAndNext(
		Session session, AgentNotification agentNotification, String title,
		OrderByComparator<AgentNotification> orderByComparator,
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

		sb.append(_SQL_SELECT_AGENTNOTIFICATION_WHERE);

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
			sb.append(AgentNotificationModelImpl.ORDER_BY_JPQL);
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
						agentNotification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgentNotification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agent notifications where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	@Override
	public void removeBytitle(String title) {
		for (AgentNotification agentNotification :
				findBytitle(
					title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(agentNotification);
		}
	}

	/**
	 * Returns the number of agent notifications where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching agent notifications
	 */
	@Override
	public int countBytitle(String title) {
		title = Objects.toString(title, "");

		FinderPath finderPath = _finderPathCountBytitle;

		Object[] finderArgs = new Object[] {title};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTNOTIFICATION_WHERE);

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
		"agentNotification.title = ?";

	private static final String _FINDER_COLUMN_TITLE_TITLE_3 =
		"(agentNotification.title IS NULL OR agentNotification.title = '')";

	private FinderPath _finderPathWithPaginationFindBylocation;
	private FinderPath _finderPathWithoutPaginationFindBylocation;
	private FinderPath _finderPathCountBylocation;

	/**
	 * Returns all the agent notifications where location = &#63;.
	 *
	 * @param location the location
	 * @return the matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBylocation(String location) {
		return findBylocation(
			location, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent notifications where location = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param location the location
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @return the range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBylocation(
		String location, int start, int end) {

		return findBylocation(location, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent notifications where location = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param location the location
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBylocation(
		String location, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator) {

		return findBylocation(location, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent notifications where location = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param location the location
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBylocation(
		String location, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator,
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

		List<AgentNotification> list = null;

		if (useFinderCache) {
			list = (List<AgentNotification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgentNotification agentNotification : list) {
					if (!location.equals(agentNotification.getLocation())) {
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

			sb.append(_SQL_SELECT_AGENTNOTIFICATION_WHERE);

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
				sb.append(AgentNotificationModelImpl.ORDER_BY_JPQL);
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

				list = (List<AgentNotification>)QueryUtil.list(
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
	 * Returns the first agent notification in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification findBylocation_First(
			String location,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		AgentNotification agentNotification = fetchBylocation_First(
			location, orderByComparator);

		if (agentNotification != null) {
			return agentNotification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("location=");
		sb.append(location);

		sb.append("}");

		throw new NoSuchAgentNotificationException(sb.toString());
	}

	/**
	 * Returns the first agent notification in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification fetchBylocation_First(
		String location,
		OrderByComparator<AgentNotification> orderByComparator) {

		List<AgentNotification> list = findBylocation(
			location, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agent notification in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification findBylocation_Last(
			String location,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		AgentNotification agentNotification = fetchBylocation_Last(
			location, orderByComparator);

		if (agentNotification != null) {
			return agentNotification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("location=");
		sb.append(location);

		sb.append("}");

		throw new NoSuchAgentNotificationException(sb.toString());
	}

	/**
	 * Returns the last agent notification in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification fetchBylocation_Last(
		String location,
		OrderByComparator<AgentNotification> orderByComparator) {

		int count = countBylocation(location);

		if (count == 0) {
			return null;
		}

		List<AgentNotification> list = findBylocation(
			location, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agent notifications before and after the current agent notification in the ordered set where location = &#63;.
	 *
	 * @param agentNotificationId the primary key of the current agent notification
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent notification
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	@Override
	public AgentNotification[] findBylocation_PrevAndNext(
			long agentNotificationId, String location,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		location = Objects.toString(location, "");

		AgentNotification agentNotification = findByPrimaryKey(
			agentNotificationId);

		Session session = null;

		try {
			session = openSession();

			AgentNotification[] array = new AgentNotificationImpl[3];

			array[0] = getBylocation_PrevAndNext(
				session, agentNotification, location, orderByComparator, true);

			array[1] = agentNotification;

			array[2] = getBylocation_PrevAndNext(
				session, agentNotification, location, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AgentNotification getBylocation_PrevAndNext(
		Session session, AgentNotification agentNotification, String location,
		OrderByComparator<AgentNotification> orderByComparator,
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

		sb.append(_SQL_SELECT_AGENTNOTIFICATION_WHERE);

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
			sb.append(AgentNotificationModelImpl.ORDER_BY_JPQL);
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
						agentNotification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgentNotification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agent notifications where location = &#63; from the database.
	 *
	 * @param location the location
	 */
	@Override
	public void removeBylocation(String location) {
		for (AgentNotification agentNotification :
				findBylocation(
					location, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(agentNotification);
		}
	}

	/**
	 * Returns the number of agent notifications where location = &#63;.
	 *
	 * @param location the location
	 * @return the number of matching agent notifications
	 */
	@Override
	public int countBylocation(String location) {
		location = Objects.toString(location, "");

		FinderPath finderPath = _finderPathCountBylocation;

		Object[] finderArgs = new Object[] {location};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTNOTIFICATION_WHERE);

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
		"agentNotification.location = ?";

	private static final String _FINDER_COLUMN_LOCATION_LOCATION_3 =
		"(agentNotification.location IS NULL OR agentNotification.location = '')";

	private FinderPath _finderPathWithPaginationFindBymypageUserId;
	private FinderPath _finderPathWithoutPaginationFindBymypageUserId;
	private FinderPath _finderPathCountBymypageUserId;

	/**
	 * Returns all the agent notifications where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBymypageUserId(long mypageUserId) {
		return findBymypageUserId(
			mypageUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent notifications where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @return the range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBymypageUserId(
		long mypageUserId, int start, int end) {

		return findBymypageUserId(mypageUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent notifications where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBymypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator) {

		return findBymypageUserId(
			mypageUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent notifications where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBymypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator,
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

		List<AgentNotification> list = null;

		if (useFinderCache) {
			list = (List<AgentNotification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgentNotification agentNotification : list) {
					if (mypageUserId != agentNotification.getMypageUserId()) {
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

			sb.append(_SQL_SELECT_AGENTNOTIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_MYPAGEUSERID_MYPAGEUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgentNotificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserId);

				list = (List<AgentNotification>)QueryUtil.list(
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
	 * Returns the first agent notification in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification findBymypageUserId_First(
			long mypageUserId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		AgentNotification agentNotification = fetchBymypageUserId_First(
			mypageUserId, orderByComparator);

		if (agentNotification != null) {
			return agentNotification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserId=");
		sb.append(mypageUserId);

		sb.append("}");

		throw new NoSuchAgentNotificationException(sb.toString());
	}

	/**
	 * Returns the first agent notification in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification fetchBymypageUserId_First(
		long mypageUserId,
		OrderByComparator<AgentNotification> orderByComparator) {

		List<AgentNotification> list = findBymypageUserId(
			mypageUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agent notification in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification findBymypageUserId_Last(
			long mypageUserId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		AgentNotification agentNotification = fetchBymypageUserId_Last(
			mypageUserId, orderByComparator);

		if (agentNotification != null) {
			return agentNotification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserId=");
		sb.append(mypageUserId);

		sb.append("}");

		throw new NoSuchAgentNotificationException(sb.toString());
	}

	/**
	 * Returns the last agent notification in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification fetchBymypageUserId_Last(
		long mypageUserId,
		OrderByComparator<AgentNotification> orderByComparator) {

		int count = countBymypageUserId(mypageUserId);

		if (count == 0) {
			return null;
		}

		List<AgentNotification> list = findBymypageUserId(
			mypageUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agent notifications before and after the current agent notification in the ordered set where mypageUserId = &#63;.
	 *
	 * @param agentNotificationId the primary key of the current agent notification
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent notification
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	@Override
	public AgentNotification[] findBymypageUserId_PrevAndNext(
			long agentNotificationId, long mypageUserId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		AgentNotification agentNotification = findByPrimaryKey(
			agentNotificationId);

		Session session = null;

		try {
			session = openSession();

			AgentNotification[] array = new AgentNotificationImpl[3];

			array[0] = getBymypageUserId_PrevAndNext(
				session, agentNotification, mypageUserId, orderByComparator,
				true);

			array[1] = agentNotification;

			array[2] = getBymypageUserId_PrevAndNext(
				session, agentNotification, mypageUserId, orderByComparator,
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

	protected AgentNotification getBymypageUserId_PrevAndNext(
		Session session, AgentNotification agentNotification, long mypageUserId,
		OrderByComparator<AgentNotification> orderByComparator,
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

		sb.append(_SQL_SELECT_AGENTNOTIFICATION_WHERE);

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
			sb.append(AgentNotificationModelImpl.ORDER_BY_JPQL);
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
						agentNotification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgentNotification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agent notifications where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	@Override
	public void removeBymypageUserId(long mypageUserId) {
		for (AgentNotification agentNotification :
				findBymypageUserId(
					mypageUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(agentNotification);
		}
	}

	/**
	 * Returns the number of agent notifications where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching agent notifications
	 */
	@Override
	public int countBymypageUserId(long mypageUserId) {
		FinderPath finderPath = _finderPathCountBymypageUserId;

		Object[] finderArgs = new Object[] {mypageUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTNOTIFICATION_WHERE);

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
		"agentNotification.mypageUserId = ?";

	private FinderPath _finderPathWithPaginationFindBymypageUserRoleId;
	private FinderPath _finderPathWithoutPaginationFindBymypageUserRoleId;
	private FinderPath _finderPathCountBymypageUserRoleId;

	/**
	 * Returns all the agent notifications where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBymypageUserRoleId(
		long mypageUserRoleId) {

		return findBymypageUserRoleId(
			mypageUserRoleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent notifications where mypageUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @return the range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end) {

		return findBymypageUserRoleId(mypageUserRoleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent notifications where mypageUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator) {

		return findBymypageUserRoleId(
			mypageUserRoleId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent notifications where mypageUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator,
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

		List<AgentNotification> list = null;

		if (useFinderCache) {
			list = (List<AgentNotification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgentNotification agentNotification : list) {
					if (mypageUserRoleId !=
							agentNotification.getMypageUserRoleId()) {

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

			sb.append(_SQL_SELECT_AGENTNOTIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_MYPAGEUSERROLEID_MYPAGEUSERROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgentNotificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserRoleId);

				list = (List<AgentNotification>)QueryUtil.list(
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
	 * Returns the first agent notification in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification findBymypageUserRoleId_First(
			long mypageUserRoleId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		AgentNotification agentNotification = fetchBymypageUserRoleId_First(
			mypageUserRoleId, orderByComparator);

		if (agentNotification != null) {
			return agentNotification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserRoleId=");
		sb.append(mypageUserRoleId);

		sb.append("}");

		throw new NoSuchAgentNotificationException(sb.toString());
	}

	/**
	 * Returns the first agent notification in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification fetchBymypageUserRoleId_First(
		long mypageUserRoleId,
		OrderByComparator<AgentNotification> orderByComparator) {

		List<AgentNotification> list = findBymypageUserRoleId(
			mypageUserRoleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agent notification in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification findBymypageUserRoleId_Last(
			long mypageUserRoleId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		AgentNotification agentNotification = fetchBymypageUserRoleId_Last(
			mypageUserRoleId, orderByComparator);

		if (agentNotification != null) {
			return agentNotification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserRoleId=");
		sb.append(mypageUserRoleId);

		sb.append("}");

		throw new NoSuchAgentNotificationException(sb.toString());
	}

	/**
	 * Returns the last agent notification in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification fetchBymypageUserRoleId_Last(
		long mypageUserRoleId,
		OrderByComparator<AgentNotification> orderByComparator) {

		int count = countBymypageUserRoleId(mypageUserRoleId);

		if (count == 0) {
			return null;
		}

		List<AgentNotification> list = findBymypageUserRoleId(
			mypageUserRoleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agent notifications before and after the current agent notification in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param agentNotificationId the primary key of the current agent notification
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent notification
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	@Override
	public AgentNotification[] findBymypageUserRoleId_PrevAndNext(
			long agentNotificationId, long mypageUserRoleId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		AgentNotification agentNotification = findByPrimaryKey(
			agentNotificationId);

		Session session = null;

		try {
			session = openSession();

			AgentNotification[] array = new AgentNotificationImpl[3];

			array[0] = getBymypageUserRoleId_PrevAndNext(
				session, agentNotification, mypageUserRoleId, orderByComparator,
				true);

			array[1] = agentNotification;

			array[2] = getBymypageUserRoleId_PrevAndNext(
				session, agentNotification, mypageUserRoleId, orderByComparator,
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

	protected AgentNotification getBymypageUserRoleId_PrevAndNext(
		Session session, AgentNotification agentNotification,
		long mypageUserRoleId,
		OrderByComparator<AgentNotification> orderByComparator,
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

		sb.append(_SQL_SELECT_AGENTNOTIFICATION_WHERE);

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
			sb.append(AgentNotificationModelImpl.ORDER_BY_JPQL);
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
						agentNotification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgentNotification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agent notifications where mypageUserRoleId = &#63; from the database.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 */
	@Override
	public void removeBymypageUserRoleId(long mypageUserRoleId) {
		for (AgentNotification agentNotification :
				findBymypageUserRoleId(
					mypageUserRoleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(agentNotification);
		}
	}

	/**
	 * Returns the number of agent notifications where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the number of matching agent notifications
	 */
	@Override
	public int countBymypageUserRoleId(long mypageUserRoleId) {
		FinderPath finderPath = _finderPathCountBymypageUserRoleId;

		Object[] finderArgs = new Object[] {mypageUserRoleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTNOTIFICATION_WHERE);

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
			"agentNotification.mypageUserRoleId = ?";

	private FinderPath _finderPathWithPaginationFindBymypageUserGroupId;
	private FinderPath _finderPathWithoutPaginationFindBymypageUserGroupId;
	private FinderPath _finderPathCountBymypageUserGroupId;

	/**
	 * Returns all the agent notifications where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @return the matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBymypageUserGroupId(
		long mypageUserGroupId) {

		return findBymypageUserGroupId(
			mypageUserGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent notifications where mypageUserGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @return the range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end) {

		return findBymypageUserGroupId(mypageUserGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent notifications where mypageUserGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator) {

		return findBymypageUserGroupId(
			mypageUserGroupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent notifications where mypageUserGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator,
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

		List<AgentNotification> list = null;

		if (useFinderCache) {
			list = (List<AgentNotification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgentNotification agentNotification : list) {
					if (mypageUserGroupId !=
							agentNotification.getMypageUserGroupId()) {

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

			sb.append(_SQL_SELECT_AGENTNOTIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_MYPAGEUSERGROUPID_MYPAGEUSERGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgentNotificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserGroupId);

				list = (List<AgentNotification>)QueryUtil.list(
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
	 * Returns the first agent notification in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification findBymypageUserGroupId_First(
			long mypageUserGroupId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		AgentNotification agentNotification = fetchBymypageUserGroupId_First(
			mypageUserGroupId, orderByComparator);

		if (agentNotification != null) {
			return agentNotification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserGroupId=");
		sb.append(mypageUserGroupId);

		sb.append("}");

		throw new NoSuchAgentNotificationException(sb.toString());
	}

	/**
	 * Returns the first agent notification in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification fetchBymypageUserGroupId_First(
		long mypageUserGroupId,
		OrderByComparator<AgentNotification> orderByComparator) {

		List<AgentNotification> list = findBymypageUserGroupId(
			mypageUserGroupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agent notification in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification findBymypageUserGroupId_Last(
			long mypageUserGroupId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		AgentNotification agentNotification = fetchBymypageUserGroupId_Last(
			mypageUserGroupId, orderByComparator);

		if (agentNotification != null) {
			return agentNotification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserGroupId=");
		sb.append(mypageUserGroupId);

		sb.append("}");

		throw new NoSuchAgentNotificationException(sb.toString());
	}

	/**
	 * Returns the last agent notification in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification fetchBymypageUserGroupId_Last(
		long mypageUserGroupId,
		OrderByComparator<AgentNotification> orderByComparator) {

		int count = countBymypageUserGroupId(mypageUserGroupId);

		if (count == 0) {
			return null;
		}

		List<AgentNotification> list = findBymypageUserGroupId(
			mypageUserGroupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agent notifications before and after the current agent notification in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param agentNotificationId the primary key of the current agent notification
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent notification
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	@Override
	public AgentNotification[] findBymypageUserGroupId_PrevAndNext(
			long agentNotificationId, long mypageUserGroupId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		AgentNotification agentNotification = findByPrimaryKey(
			agentNotificationId);

		Session session = null;

		try {
			session = openSession();

			AgentNotification[] array = new AgentNotificationImpl[3];

			array[0] = getBymypageUserGroupId_PrevAndNext(
				session, agentNotification, mypageUserGroupId,
				orderByComparator, true);

			array[1] = agentNotification;

			array[2] = getBymypageUserGroupId_PrevAndNext(
				session, agentNotification, mypageUserGroupId,
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

	protected AgentNotification getBymypageUserGroupId_PrevAndNext(
		Session session, AgentNotification agentNotification,
		long mypageUserGroupId,
		OrderByComparator<AgentNotification> orderByComparator,
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

		sb.append(_SQL_SELECT_AGENTNOTIFICATION_WHERE);

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
			sb.append(AgentNotificationModelImpl.ORDER_BY_JPQL);
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
						agentNotification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgentNotification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agent notifications where mypageUserGroupId = &#63; from the database.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 */
	@Override
	public void removeBymypageUserGroupId(long mypageUserGroupId) {
		for (AgentNotification agentNotification :
				findBymypageUserGroupId(
					mypageUserGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(agentNotification);
		}
	}

	/**
	 * Returns the number of agent notifications where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @return the number of matching agent notifications
	 */
	@Override
	public int countBymypageUserGroupId(long mypageUserGroupId) {
		FinderPath finderPath = _finderPathCountBymypageUserGroupId;

		Object[] finderArgs = new Object[] {mypageUserGroupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTNOTIFICATION_WHERE);

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
			"agentNotification.mypageUserGroupId = ?";

	private FinderPath _finderPathWithPaginationFindByreferenceId;
	private FinderPath _finderPathWithoutPaginationFindByreferenceId;
	private FinderPath _finderPathCountByreferenceId;

	/**
	 * Returns all the agent notifications where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @return the matching agent notifications
	 */
	@Override
	public List<AgentNotification> findByreferenceId(long referenceId) {
		return findByreferenceId(
			referenceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent notifications where referenceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param referenceId the reference ID
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @return the range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findByreferenceId(
		long referenceId, int start, int end) {

		return findByreferenceId(referenceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent notifications where referenceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param referenceId the reference ID
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findByreferenceId(
		long referenceId, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator) {

		return findByreferenceId(
			referenceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent notifications where referenceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param referenceId the reference ID
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent notifications
	 */
	@Override
	public List<AgentNotification> findByreferenceId(
		long referenceId, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByreferenceId;
				finderArgs = new Object[] {referenceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByreferenceId;
			finderArgs = new Object[] {
				referenceId, start, end, orderByComparator
			};
		}

		List<AgentNotification> list = null;

		if (useFinderCache) {
			list = (List<AgentNotification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgentNotification agentNotification : list) {
					if (referenceId != agentNotification.getReferenceId()) {
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

			sb.append(_SQL_SELECT_AGENTNOTIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_REFERENCEID_REFERENCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgentNotificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(referenceId);

				list = (List<AgentNotification>)QueryUtil.list(
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
	 * Returns the first agent notification in the ordered set where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification findByreferenceId_First(
			long referenceId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		AgentNotification agentNotification = fetchByreferenceId_First(
			referenceId, orderByComparator);

		if (agentNotification != null) {
			return agentNotification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("referenceId=");
		sb.append(referenceId);

		sb.append("}");

		throw new NoSuchAgentNotificationException(sb.toString());
	}

	/**
	 * Returns the first agent notification in the ordered set where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification fetchByreferenceId_First(
		long referenceId,
		OrderByComparator<AgentNotification> orderByComparator) {

		List<AgentNotification> list = findByreferenceId(
			referenceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agent notification in the ordered set where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification findByreferenceId_Last(
			long referenceId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		AgentNotification agentNotification = fetchByreferenceId_Last(
			referenceId, orderByComparator);

		if (agentNotification != null) {
			return agentNotification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("referenceId=");
		sb.append(referenceId);

		sb.append("}");

		throw new NoSuchAgentNotificationException(sb.toString());
	}

	/**
	 * Returns the last agent notification in the ordered set where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	@Override
	public AgentNotification fetchByreferenceId_Last(
		long referenceId,
		OrderByComparator<AgentNotification> orderByComparator) {

		int count = countByreferenceId(referenceId);

		if (count == 0) {
			return null;
		}

		List<AgentNotification> list = findByreferenceId(
			referenceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agent notifications before and after the current agent notification in the ordered set where referenceId = &#63;.
	 *
	 * @param agentNotificationId the primary key of the current agent notification
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent notification
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	@Override
	public AgentNotification[] findByreferenceId_PrevAndNext(
			long agentNotificationId, long referenceId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws NoSuchAgentNotificationException {

		AgentNotification agentNotification = findByPrimaryKey(
			agentNotificationId);

		Session session = null;

		try {
			session = openSession();

			AgentNotification[] array = new AgentNotificationImpl[3];

			array[0] = getByreferenceId_PrevAndNext(
				session, agentNotification, referenceId, orderByComparator,
				true);

			array[1] = agentNotification;

			array[2] = getByreferenceId_PrevAndNext(
				session, agentNotification, referenceId, orderByComparator,
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

	protected AgentNotification getByreferenceId_PrevAndNext(
		Session session, AgentNotification agentNotification, long referenceId,
		OrderByComparator<AgentNotification> orderByComparator,
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

		sb.append(_SQL_SELECT_AGENTNOTIFICATION_WHERE);

		sb.append(_FINDER_COLUMN_REFERENCEID_REFERENCEID_2);

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
			sb.append(AgentNotificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(referenceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						agentNotification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgentNotification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agent notifications where referenceId = &#63; from the database.
	 *
	 * @param referenceId the reference ID
	 */
	@Override
	public void removeByreferenceId(long referenceId) {
		for (AgentNotification agentNotification :
				findByreferenceId(
					referenceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(agentNotification);
		}
	}

	/**
	 * Returns the number of agent notifications where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @return the number of matching agent notifications
	 */
	@Override
	public int countByreferenceId(long referenceId) {
		FinderPath finderPath = _finderPathCountByreferenceId;

		Object[] finderArgs = new Object[] {referenceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTNOTIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_REFERENCEID_REFERENCEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(referenceId);

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

	private static final String _FINDER_COLUMN_REFERENCEID_REFERENCEID_2 =
		"agentNotification.referenceId = ?";

	public AgentNotificationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("role", "role_");
		dbColumnNames.put("group", "group_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AgentNotification.class);

		setModelImplClass(AgentNotificationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the agent notification in the entity cache if it is enabled.
	 *
	 * @param agentNotification the agent notification
	 */
	@Override
	public void cacheResult(AgentNotification agentNotification) {
		entityCache.putResult(
			AgentNotificationImpl.class, agentNotification.getPrimaryKey(),
			agentNotification);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the agent notifications in the entity cache if it is enabled.
	 *
	 * @param agentNotifications the agent notifications
	 */
	@Override
	public void cacheResult(List<AgentNotification> agentNotifications) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (agentNotifications.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AgentNotification agentNotification : agentNotifications) {
			if (entityCache.getResult(
					AgentNotificationImpl.class,
					agentNotification.getPrimaryKey()) == null) {

				cacheResult(agentNotification);
			}
		}
	}

	/**
	 * Clears the cache for all agent notifications.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AgentNotificationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the agent notification.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AgentNotification agentNotification) {
		entityCache.removeResult(
			AgentNotificationImpl.class, agentNotification);
	}

	@Override
	public void clearCache(List<AgentNotification> agentNotifications) {
		for (AgentNotification agentNotification : agentNotifications) {
			entityCache.removeResult(
				AgentNotificationImpl.class, agentNotification);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AgentNotificationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new agent notification with the primary key. Does not add the agent notification to the database.
	 *
	 * @param agentNotificationId the primary key for the new agent notification
	 * @return the new agent notification
	 */
	@Override
	public AgentNotification create(long agentNotificationId) {
		AgentNotification agentNotification = new AgentNotificationImpl();

		agentNotification.setNew(true);
		agentNotification.setPrimaryKey(agentNotificationId);

		agentNotification.setCompanyId(CompanyThreadLocal.getCompanyId());

		return agentNotification;
	}

	/**
	 * Removes the agent notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentNotificationId the primary key of the agent notification
	 * @return the agent notification that was removed
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	@Override
	public AgentNotification remove(long agentNotificationId)
		throws NoSuchAgentNotificationException {

		return remove((Serializable)agentNotificationId);
	}

	/**
	 * Removes the agent notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the agent notification
	 * @return the agent notification that was removed
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	@Override
	public AgentNotification remove(Serializable primaryKey)
		throws NoSuchAgentNotificationException {

		Session session = null;

		try {
			session = openSession();

			AgentNotification agentNotification =
				(AgentNotification)session.get(
					AgentNotificationImpl.class, primaryKey);

			if (agentNotification == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAgentNotificationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(agentNotification);
		}
		catch (NoSuchAgentNotificationException noSuchEntityException) {
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
	protected AgentNotification removeImpl(
		AgentNotification agentNotification) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(agentNotification)) {
				agentNotification = (AgentNotification)session.get(
					AgentNotificationImpl.class,
					agentNotification.getPrimaryKeyObj());
			}

			if (agentNotification != null) {
				session.delete(agentNotification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (agentNotification != null) {
			clearCache(agentNotification);
		}

		return agentNotification;
	}

	@Override
	public AgentNotification updateImpl(AgentNotification agentNotification) {
		boolean isNew = agentNotification.isNew();

		if (!(agentNotification instanceof AgentNotificationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(agentNotification.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					agentNotification);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in agentNotification proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AgentNotification implementation " +
					agentNotification.getClass());
		}

		AgentNotificationModelImpl agentNotificationModelImpl =
			(AgentNotificationModelImpl)agentNotification;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (agentNotification.getCreateDate() == null)) {
			if (serviceContext == null) {
				agentNotification.setCreateDate(date);
			}
			else {
				agentNotification.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!agentNotificationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				agentNotification.setModifiedDate(date);
			}
			else {
				agentNotification.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(agentNotification);
			}
			else {
				agentNotification = (AgentNotification)session.merge(
					agentNotification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AgentNotificationImpl.class, agentNotificationModelImpl, false,
			true);

		if (isNew) {
			agentNotification.setNew(false);
		}

		agentNotification.resetOriginalValues();

		return agentNotification;
	}

	/**
	 * Returns the agent notification with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the agent notification
	 * @return the agent notification
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	@Override
	public AgentNotification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAgentNotificationException {

		AgentNotification agentNotification = fetchByPrimaryKey(primaryKey);

		if (agentNotification == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAgentNotificationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return agentNotification;
	}

	/**
	 * Returns the agent notification with the primary key or throws a <code>NoSuchAgentNotificationException</code> if it could not be found.
	 *
	 * @param agentNotificationId the primary key of the agent notification
	 * @return the agent notification
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	@Override
	public AgentNotification findByPrimaryKey(long agentNotificationId)
		throws NoSuchAgentNotificationException {

		return findByPrimaryKey((Serializable)agentNotificationId);
	}

	/**
	 * Returns the agent notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentNotificationId the primary key of the agent notification
	 * @return the agent notification, or <code>null</code> if a agent notification with the primary key could not be found
	 */
	@Override
	public AgentNotification fetchByPrimaryKey(long agentNotificationId) {
		return fetchByPrimaryKey((Serializable)agentNotificationId);
	}

	/**
	 * Returns all the agent notifications.
	 *
	 * @return the agent notifications
	 */
	@Override
	public List<AgentNotification> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @return the range of agent notifications
	 */
	@Override
	public List<AgentNotification> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agent notifications
	 */
	@Override
	public List<AgentNotification> findAll(
		int start, int end,
		OrderByComparator<AgentNotification> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agent notifications
	 */
	@Override
	public List<AgentNotification> findAll(
		int start, int end,
		OrderByComparator<AgentNotification> orderByComparator,
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

		List<AgentNotification> list = null;

		if (useFinderCache) {
			list = (List<AgentNotification>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AGENTNOTIFICATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AGENTNOTIFICATION;

				sql = sql.concat(AgentNotificationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AgentNotification>)QueryUtil.list(
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
	 * Removes all the agent notifications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AgentNotification agentNotification : findAll()) {
			remove(agentNotification);
		}
	}

	/**
	 * Returns the number of agent notifications.
	 *
	 * @return the number of agent notifications
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AGENTNOTIFICATION);

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
		return "agentNotificationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AGENTNOTIFICATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AgentNotificationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the agent notification persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new AgentNotificationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", AgentNotification.class.getName()));

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

		_finderPathWithPaginationFindByreferenceId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByreferenceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"referenceId"}, true);

		_finderPathWithoutPaginationFindByreferenceId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByreferenceId",
			new String[] {Long.class.getName()}, new String[] {"referenceId"},
			true);

		_finderPathCountByreferenceId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByreferenceId",
			new String[] {Long.class.getName()}, new String[] {"referenceId"},
			false);

		_setAgentNotificationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAgentNotificationUtilPersistence(null);

		entityCache.removeCache(AgentNotificationImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setAgentNotificationUtilPersistence(
		AgentNotificationPersistence agentNotificationPersistence) {

		try {
			Field field = AgentNotificationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, agentNotificationPersistence);
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

	private static final String _SQL_SELECT_AGENTNOTIFICATION =
		"SELECT agentNotification FROM AgentNotification agentNotification";

	private static final String _SQL_SELECT_AGENTNOTIFICATION_WHERE =
		"SELECT agentNotification FROM AgentNotification agentNotification WHERE ";

	private static final String _SQL_COUNT_AGENTNOTIFICATION =
		"SELECT COUNT(agentNotification) FROM AgentNotification agentNotification";

	private static final String _SQL_COUNT_AGENTNOTIFICATION_WHERE =
		"SELECT COUNT(agentNotification) FROM AgentNotification agentNotification WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "agentNotification.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AgentNotification exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AgentNotification exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AgentNotificationPersistenceImpl.class);

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

	private static class AgentNotificationModelArgumentsResolver
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

			AgentNotificationModelImpl agentNotificationModelImpl =
				(AgentNotificationModelImpl)baseModel;

			long columnBitmask = agentNotificationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					agentNotificationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						agentNotificationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					agentNotificationModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			AgentNotificationModelImpl agentNotificationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						agentNotificationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = agentNotificationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}