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

import com.mypage.agencyportal.exception.NoSuchAgentMarkCalendarException;
import com.mypage.agencyportal.model.AgentMarkCalendar;
import com.mypage.agencyportal.model.impl.AgentMarkCalendarImpl;
import com.mypage.agencyportal.model.impl.AgentMarkCalendarModelImpl;
import com.mypage.agencyportal.service.persistence.AgentMarkCalendarPersistence;
import com.mypage.agencyportal.service.persistence.AgentMarkCalendarUtil;
import com.mypage.agencyportal.service.persistence.impl.constants.APPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the agent mark calendar service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = AgentMarkCalendarPersistence.class)
public class AgentMarkCalendarPersistenceImpl
	extends BasePersistenceImpl<AgentMarkCalendar>
	implements AgentMarkCalendarPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AgentMarkCalendarUtil</code> to access the agent mark calendar persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AgentMarkCalendarImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBymypageUserId;
	private FinderPath _finderPathWithoutPaginationFindBymypageUserId;
	private FinderPath _finderPathCountBymypageUserId;

	/**
	 * Returns all the agent mark calendars where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching agent mark calendars
	 */
	@Override
	public List<AgentMarkCalendar> findBymypageUserId(long mypageUserId) {
		return findBymypageUserId(
			mypageUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent mark calendars where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentMarkCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of agent mark calendars
	 * @param end the upper bound of the range of agent mark calendars (not inclusive)
	 * @return the range of matching agent mark calendars
	 */
	@Override
	public List<AgentMarkCalendar> findBymypageUserId(
		long mypageUserId, int start, int end) {

		return findBymypageUserId(mypageUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent mark calendars where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentMarkCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of agent mark calendars
	 * @param end the upper bound of the range of agent mark calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent mark calendars
	 */
	@Override
	public List<AgentMarkCalendar> findBymypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<AgentMarkCalendar> orderByComparator) {

		return findBymypageUserId(
			mypageUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent mark calendars where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentMarkCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of agent mark calendars
	 * @param end the upper bound of the range of agent mark calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent mark calendars
	 */
	@Override
	public List<AgentMarkCalendar> findBymypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<AgentMarkCalendar> orderByComparator,
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

		List<AgentMarkCalendar> list = null;

		if (useFinderCache) {
			list = (List<AgentMarkCalendar>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgentMarkCalendar agentMarkCalendar : list) {
					if (mypageUserId != agentMarkCalendar.getMypageUserId()) {
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

			sb.append(_SQL_SELECT_AGENTMARKCALENDAR_WHERE);

			sb.append(_FINDER_COLUMN_MYPAGEUSERID_MYPAGEUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgentMarkCalendarModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserId);

				list = (List<AgentMarkCalendar>)QueryUtil.list(
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
	 * Returns the first agent mark calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent mark calendar
	 * @throws NoSuchAgentMarkCalendarException if a matching agent mark calendar could not be found
	 */
	@Override
	public AgentMarkCalendar findBymypageUserId_First(
			long mypageUserId,
			OrderByComparator<AgentMarkCalendar> orderByComparator)
		throws NoSuchAgentMarkCalendarException {

		AgentMarkCalendar agentMarkCalendar = fetchBymypageUserId_First(
			mypageUserId, orderByComparator);

		if (agentMarkCalendar != null) {
			return agentMarkCalendar;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserId=");
		sb.append(mypageUserId);

		sb.append("}");

		throw new NoSuchAgentMarkCalendarException(sb.toString());
	}

	/**
	 * Returns the first agent mark calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent mark calendar, or <code>null</code> if a matching agent mark calendar could not be found
	 */
	@Override
	public AgentMarkCalendar fetchBymypageUserId_First(
		long mypageUserId,
		OrderByComparator<AgentMarkCalendar> orderByComparator) {

		List<AgentMarkCalendar> list = findBymypageUserId(
			mypageUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agent mark calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent mark calendar
	 * @throws NoSuchAgentMarkCalendarException if a matching agent mark calendar could not be found
	 */
	@Override
	public AgentMarkCalendar findBymypageUserId_Last(
			long mypageUserId,
			OrderByComparator<AgentMarkCalendar> orderByComparator)
		throws NoSuchAgentMarkCalendarException {

		AgentMarkCalendar agentMarkCalendar = fetchBymypageUserId_Last(
			mypageUserId, orderByComparator);

		if (agentMarkCalendar != null) {
			return agentMarkCalendar;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserId=");
		sb.append(mypageUserId);

		sb.append("}");

		throw new NoSuchAgentMarkCalendarException(sb.toString());
	}

	/**
	 * Returns the last agent mark calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent mark calendar, or <code>null</code> if a matching agent mark calendar could not be found
	 */
	@Override
	public AgentMarkCalendar fetchBymypageUserId_Last(
		long mypageUserId,
		OrderByComparator<AgentMarkCalendar> orderByComparator) {

		int count = countBymypageUserId(mypageUserId);

		if (count == 0) {
			return null;
		}

		List<AgentMarkCalendar> list = findBymypageUserId(
			mypageUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agent mark calendars before and after the current agent mark calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param agentMarkCalendarId the primary key of the current agent mark calendar
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent mark calendar
	 * @throws NoSuchAgentMarkCalendarException if a agent mark calendar with the primary key could not be found
	 */
	@Override
	public AgentMarkCalendar[] findBymypageUserId_PrevAndNext(
			long agentMarkCalendarId, long mypageUserId,
			OrderByComparator<AgentMarkCalendar> orderByComparator)
		throws NoSuchAgentMarkCalendarException {

		AgentMarkCalendar agentMarkCalendar = findByPrimaryKey(
			agentMarkCalendarId);

		Session session = null;

		try {
			session = openSession();

			AgentMarkCalendar[] array = new AgentMarkCalendarImpl[3];

			array[0] = getBymypageUserId_PrevAndNext(
				session, agentMarkCalendar, mypageUserId, orderByComparator,
				true);

			array[1] = agentMarkCalendar;

			array[2] = getBymypageUserId_PrevAndNext(
				session, agentMarkCalendar, mypageUserId, orderByComparator,
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

	protected AgentMarkCalendar getBymypageUserId_PrevAndNext(
		Session session, AgentMarkCalendar agentMarkCalendar, long mypageUserId,
		OrderByComparator<AgentMarkCalendar> orderByComparator,
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

		sb.append(_SQL_SELECT_AGENTMARKCALENDAR_WHERE);

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
			sb.append(AgentMarkCalendarModelImpl.ORDER_BY_JPQL);
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
						agentMarkCalendar)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgentMarkCalendar> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agent mark calendars where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	@Override
	public void removeBymypageUserId(long mypageUserId) {
		for (AgentMarkCalendar agentMarkCalendar :
				findBymypageUserId(
					mypageUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(agentMarkCalendar);
		}
	}

	/**
	 * Returns the number of agent mark calendars where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching agent mark calendars
	 */
	@Override
	public int countBymypageUserId(long mypageUserId) {
		FinderPath finderPath = _finderPathCountBymypageUserId;

		Object[] finderArgs = new Object[] {mypageUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTMARKCALENDAR_WHERE);

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
		"agentMarkCalendar.mypageUserId = ?";

	public AgentMarkCalendarPersistenceImpl() {
		setModelClass(AgentMarkCalendar.class);

		setModelImplClass(AgentMarkCalendarImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the agent mark calendar in the entity cache if it is enabled.
	 *
	 * @param agentMarkCalendar the agent mark calendar
	 */
	@Override
	public void cacheResult(AgentMarkCalendar agentMarkCalendar) {
		entityCache.putResult(
			AgentMarkCalendarImpl.class, agentMarkCalendar.getPrimaryKey(),
			agentMarkCalendar);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the agent mark calendars in the entity cache if it is enabled.
	 *
	 * @param agentMarkCalendars the agent mark calendars
	 */
	@Override
	public void cacheResult(List<AgentMarkCalendar> agentMarkCalendars) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (agentMarkCalendars.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AgentMarkCalendar agentMarkCalendar : agentMarkCalendars) {
			if (entityCache.getResult(
					AgentMarkCalendarImpl.class,
					agentMarkCalendar.getPrimaryKey()) == null) {

				cacheResult(agentMarkCalendar);
			}
		}
	}

	/**
	 * Clears the cache for all agent mark calendars.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AgentMarkCalendarImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the agent mark calendar.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AgentMarkCalendar agentMarkCalendar) {
		entityCache.removeResult(
			AgentMarkCalendarImpl.class, agentMarkCalendar);
	}

	@Override
	public void clearCache(List<AgentMarkCalendar> agentMarkCalendars) {
		for (AgentMarkCalendar agentMarkCalendar : agentMarkCalendars) {
			entityCache.removeResult(
				AgentMarkCalendarImpl.class, agentMarkCalendar);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AgentMarkCalendarImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new agent mark calendar with the primary key. Does not add the agent mark calendar to the database.
	 *
	 * @param agentMarkCalendarId the primary key for the new agent mark calendar
	 * @return the new agent mark calendar
	 */
	@Override
	public AgentMarkCalendar create(long agentMarkCalendarId) {
		AgentMarkCalendar agentMarkCalendar = new AgentMarkCalendarImpl();

		agentMarkCalendar.setNew(true);
		agentMarkCalendar.setPrimaryKey(agentMarkCalendarId);

		agentMarkCalendar.setCompanyId(CompanyThreadLocal.getCompanyId());

		return agentMarkCalendar;
	}

	/**
	 * Removes the agent mark calendar with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentMarkCalendarId the primary key of the agent mark calendar
	 * @return the agent mark calendar that was removed
	 * @throws NoSuchAgentMarkCalendarException if a agent mark calendar with the primary key could not be found
	 */
	@Override
	public AgentMarkCalendar remove(long agentMarkCalendarId)
		throws NoSuchAgentMarkCalendarException {

		return remove((Serializable)agentMarkCalendarId);
	}

	/**
	 * Removes the agent mark calendar with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the agent mark calendar
	 * @return the agent mark calendar that was removed
	 * @throws NoSuchAgentMarkCalendarException if a agent mark calendar with the primary key could not be found
	 */
	@Override
	public AgentMarkCalendar remove(Serializable primaryKey)
		throws NoSuchAgentMarkCalendarException {

		Session session = null;

		try {
			session = openSession();

			AgentMarkCalendar agentMarkCalendar =
				(AgentMarkCalendar)session.get(
					AgentMarkCalendarImpl.class, primaryKey);

			if (agentMarkCalendar == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAgentMarkCalendarException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(agentMarkCalendar);
		}
		catch (NoSuchAgentMarkCalendarException noSuchEntityException) {
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
	protected AgentMarkCalendar removeImpl(
		AgentMarkCalendar agentMarkCalendar) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(agentMarkCalendar)) {
				agentMarkCalendar = (AgentMarkCalendar)session.get(
					AgentMarkCalendarImpl.class,
					agentMarkCalendar.getPrimaryKeyObj());
			}

			if (agentMarkCalendar != null) {
				session.delete(agentMarkCalendar);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (agentMarkCalendar != null) {
			clearCache(agentMarkCalendar);
		}

		return agentMarkCalendar;
	}

	@Override
	public AgentMarkCalendar updateImpl(AgentMarkCalendar agentMarkCalendar) {
		boolean isNew = agentMarkCalendar.isNew();

		if (!(agentMarkCalendar instanceof AgentMarkCalendarModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(agentMarkCalendar.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					agentMarkCalendar);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in agentMarkCalendar proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AgentMarkCalendar implementation " +
					agentMarkCalendar.getClass());
		}

		AgentMarkCalendarModelImpl agentMarkCalendarModelImpl =
			(AgentMarkCalendarModelImpl)agentMarkCalendar;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (agentMarkCalendar.getCreateDate() == null)) {
			if (serviceContext == null) {
				agentMarkCalendar.setCreateDate(date);
			}
			else {
				agentMarkCalendar.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!agentMarkCalendarModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				agentMarkCalendar.setModifiedDate(date);
			}
			else {
				agentMarkCalendar.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(agentMarkCalendar);
			}
			else {
				agentMarkCalendar = (AgentMarkCalendar)session.merge(
					agentMarkCalendar);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AgentMarkCalendarImpl.class, agentMarkCalendarModelImpl, false,
			true);

		if (isNew) {
			agentMarkCalendar.setNew(false);
		}

		agentMarkCalendar.resetOriginalValues();

		return agentMarkCalendar;
	}

	/**
	 * Returns the agent mark calendar with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the agent mark calendar
	 * @return the agent mark calendar
	 * @throws NoSuchAgentMarkCalendarException if a agent mark calendar with the primary key could not be found
	 */
	@Override
	public AgentMarkCalendar findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAgentMarkCalendarException {

		AgentMarkCalendar agentMarkCalendar = fetchByPrimaryKey(primaryKey);

		if (agentMarkCalendar == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAgentMarkCalendarException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return agentMarkCalendar;
	}

	/**
	 * Returns the agent mark calendar with the primary key or throws a <code>NoSuchAgentMarkCalendarException</code> if it could not be found.
	 *
	 * @param agentMarkCalendarId the primary key of the agent mark calendar
	 * @return the agent mark calendar
	 * @throws NoSuchAgentMarkCalendarException if a agent mark calendar with the primary key could not be found
	 */
	@Override
	public AgentMarkCalendar findByPrimaryKey(long agentMarkCalendarId)
		throws NoSuchAgentMarkCalendarException {

		return findByPrimaryKey((Serializable)agentMarkCalendarId);
	}

	/**
	 * Returns the agent mark calendar with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentMarkCalendarId the primary key of the agent mark calendar
	 * @return the agent mark calendar, or <code>null</code> if a agent mark calendar with the primary key could not be found
	 */
	@Override
	public AgentMarkCalendar fetchByPrimaryKey(long agentMarkCalendarId) {
		return fetchByPrimaryKey((Serializable)agentMarkCalendarId);
	}

	/**
	 * Returns all the agent mark calendars.
	 *
	 * @return the agent mark calendars
	 */
	@Override
	public List<AgentMarkCalendar> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent mark calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentMarkCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent mark calendars
	 * @param end the upper bound of the range of agent mark calendars (not inclusive)
	 * @return the range of agent mark calendars
	 */
	@Override
	public List<AgentMarkCalendar> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent mark calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentMarkCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent mark calendars
	 * @param end the upper bound of the range of agent mark calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agent mark calendars
	 */
	@Override
	public List<AgentMarkCalendar> findAll(
		int start, int end,
		OrderByComparator<AgentMarkCalendar> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent mark calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentMarkCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent mark calendars
	 * @param end the upper bound of the range of agent mark calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agent mark calendars
	 */
	@Override
	public List<AgentMarkCalendar> findAll(
		int start, int end,
		OrderByComparator<AgentMarkCalendar> orderByComparator,
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

		List<AgentMarkCalendar> list = null;

		if (useFinderCache) {
			list = (List<AgentMarkCalendar>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AGENTMARKCALENDAR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AGENTMARKCALENDAR;

				sql = sql.concat(AgentMarkCalendarModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AgentMarkCalendar>)QueryUtil.list(
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
	 * Removes all the agent mark calendars from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AgentMarkCalendar agentMarkCalendar : findAll()) {
			remove(agentMarkCalendar);
		}
	}

	/**
	 * Returns the number of agent mark calendars.
	 *
	 * @return the number of agent mark calendars
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AGENTMARKCALENDAR);

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
		return "agentMarkCalendarId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AGENTMARKCALENDAR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AgentMarkCalendarModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the agent mark calendar persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new AgentMarkCalendarModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", AgentMarkCalendar.class.getName()));

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

		_setAgentMarkCalendarUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAgentMarkCalendarUtilPersistence(null);

		entityCache.removeCache(AgentMarkCalendarImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setAgentMarkCalendarUtilPersistence(
		AgentMarkCalendarPersistence agentMarkCalendarPersistence) {

		try {
			Field field = AgentMarkCalendarUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, agentMarkCalendarPersistence);
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

	private static final String _SQL_SELECT_AGENTMARKCALENDAR =
		"SELECT agentMarkCalendar FROM AgentMarkCalendar agentMarkCalendar";

	private static final String _SQL_SELECT_AGENTMARKCALENDAR_WHERE =
		"SELECT agentMarkCalendar FROM AgentMarkCalendar agentMarkCalendar WHERE ";

	private static final String _SQL_COUNT_AGENTMARKCALENDAR =
		"SELECT COUNT(agentMarkCalendar) FROM AgentMarkCalendar agentMarkCalendar";

	private static final String _SQL_COUNT_AGENTMARKCALENDAR_WHERE =
		"SELECT COUNT(agentMarkCalendar) FROM AgentMarkCalendar agentMarkCalendar WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "agentMarkCalendar.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AgentMarkCalendar exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AgentMarkCalendar exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AgentMarkCalendarPersistenceImpl.class);

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

	private static class AgentMarkCalendarModelArgumentsResolver
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

			AgentMarkCalendarModelImpl agentMarkCalendarModelImpl =
				(AgentMarkCalendarModelImpl)baseModel;

			long columnBitmask = agentMarkCalendarModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					agentMarkCalendarModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						agentMarkCalendarModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					agentMarkCalendarModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			AgentMarkCalendarModelImpl agentMarkCalendarModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						agentMarkCalendarModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = agentMarkCalendarModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}