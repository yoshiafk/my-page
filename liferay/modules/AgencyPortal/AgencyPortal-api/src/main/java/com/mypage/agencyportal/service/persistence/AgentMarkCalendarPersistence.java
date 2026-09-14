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

package com.mypage.agencyportal.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.agencyportal.exception.NoSuchAgentMarkCalendarException;
import com.mypage.agencyportal.model.AgentMarkCalendar;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the agent mark calendar service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentMarkCalendarUtil
 * @generated
 */
@ProviderType
public interface AgentMarkCalendarPersistence
	extends BasePersistence<AgentMarkCalendar> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AgentMarkCalendarUtil} to access the agent mark calendar persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the agent mark calendars where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching agent mark calendars
	 */
	public java.util.List<AgentMarkCalendar> findBymypageUserId(
		long mypageUserId);

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
	public java.util.List<AgentMarkCalendar> findBymypageUserId(
		long mypageUserId, int start, int end);

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
	public java.util.List<AgentMarkCalendar> findBymypageUserId(
		long mypageUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentMarkCalendar>
			orderByComparator);

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
	public java.util.List<AgentMarkCalendar> findBymypageUserId(
		long mypageUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentMarkCalendar>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first agent mark calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent mark calendar
	 * @throws NoSuchAgentMarkCalendarException if a matching agent mark calendar could not be found
	 */
	public AgentMarkCalendar findBymypageUserId_First(
			long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentMarkCalendar>
				orderByComparator)
		throws NoSuchAgentMarkCalendarException;

	/**
	 * Returns the first agent mark calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent mark calendar, or <code>null</code> if a matching agent mark calendar could not be found
	 */
	public AgentMarkCalendar fetchBymypageUserId_First(
		long mypageUserId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentMarkCalendar>
			orderByComparator);

	/**
	 * Returns the last agent mark calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent mark calendar
	 * @throws NoSuchAgentMarkCalendarException if a matching agent mark calendar could not be found
	 */
	public AgentMarkCalendar findBymypageUserId_Last(
			long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentMarkCalendar>
				orderByComparator)
		throws NoSuchAgentMarkCalendarException;

	/**
	 * Returns the last agent mark calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent mark calendar, or <code>null</code> if a matching agent mark calendar could not be found
	 */
	public AgentMarkCalendar fetchBymypageUserId_Last(
		long mypageUserId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentMarkCalendar>
			orderByComparator);

	/**
	 * Returns the agent mark calendars before and after the current agent mark calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param agentMarkCalendarId the primary key of the current agent mark calendar
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent mark calendar
	 * @throws NoSuchAgentMarkCalendarException if a agent mark calendar with the primary key could not be found
	 */
	public AgentMarkCalendar[] findBymypageUserId_PrevAndNext(
			long agentMarkCalendarId, long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentMarkCalendar>
				orderByComparator)
		throws NoSuchAgentMarkCalendarException;

	/**
	 * Removes all the agent mark calendars where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	public void removeBymypageUserId(long mypageUserId);

	/**
	 * Returns the number of agent mark calendars where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching agent mark calendars
	 */
	public int countBymypageUserId(long mypageUserId);

	/**
	 * Caches the agent mark calendar in the entity cache if it is enabled.
	 *
	 * @param agentMarkCalendar the agent mark calendar
	 */
	public void cacheResult(AgentMarkCalendar agentMarkCalendar);

	/**
	 * Caches the agent mark calendars in the entity cache if it is enabled.
	 *
	 * @param agentMarkCalendars the agent mark calendars
	 */
	public void cacheResult(
		java.util.List<AgentMarkCalendar> agentMarkCalendars);

	/**
	 * Creates a new agent mark calendar with the primary key. Does not add the agent mark calendar to the database.
	 *
	 * @param agentMarkCalendarId the primary key for the new agent mark calendar
	 * @return the new agent mark calendar
	 */
	public AgentMarkCalendar create(long agentMarkCalendarId);

	/**
	 * Removes the agent mark calendar with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentMarkCalendarId the primary key of the agent mark calendar
	 * @return the agent mark calendar that was removed
	 * @throws NoSuchAgentMarkCalendarException if a agent mark calendar with the primary key could not be found
	 */
	public AgentMarkCalendar remove(long agentMarkCalendarId)
		throws NoSuchAgentMarkCalendarException;

	public AgentMarkCalendar updateImpl(AgentMarkCalendar agentMarkCalendar);

	/**
	 * Returns the agent mark calendar with the primary key or throws a <code>NoSuchAgentMarkCalendarException</code> if it could not be found.
	 *
	 * @param agentMarkCalendarId the primary key of the agent mark calendar
	 * @return the agent mark calendar
	 * @throws NoSuchAgentMarkCalendarException if a agent mark calendar with the primary key could not be found
	 */
	public AgentMarkCalendar findByPrimaryKey(long agentMarkCalendarId)
		throws NoSuchAgentMarkCalendarException;

	/**
	 * Returns the agent mark calendar with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentMarkCalendarId the primary key of the agent mark calendar
	 * @return the agent mark calendar, or <code>null</code> if a agent mark calendar with the primary key could not be found
	 */
	public AgentMarkCalendar fetchByPrimaryKey(long agentMarkCalendarId);

	/**
	 * Returns all the agent mark calendars.
	 *
	 * @return the agent mark calendars
	 */
	public java.util.List<AgentMarkCalendar> findAll();

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
	public java.util.List<AgentMarkCalendar> findAll(int start, int end);

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
	public java.util.List<AgentMarkCalendar> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentMarkCalendar>
			orderByComparator);

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
	public java.util.List<AgentMarkCalendar> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentMarkCalendar>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the agent mark calendars from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of agent mark calendars.
	 *
	 * @return the number of agent mark calendars
	 */
	public int countAll();

}