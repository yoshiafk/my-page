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

import com.mypage.agencyportal.exception.NoSuchAgentCalendarException;
import com.mypage.agencyportal.model.AgentCalendar;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the agent calendar service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentCalendarUtil
 * @generated
 */
@ProviderType
public interface AgentCalendarPersistence
	extends BasePersistence<AgentCalendar> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AgentCalendarUtil} to access the agent calendar persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the agent calendars where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching agent calendars
	 */
	public java.util.List<AgentCalendar> findBytitle(String title);

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
	public java.util.List<AgentCalendar> findBytitle(
		String title, int start, int end);

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
	public java.util.List<AgentCalendar> findBytitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator);

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
	public java.util.List<AgentCalendar> findBytitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first agent calendar in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public AgentCalendar findBytitle_First(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
				orderByComparator)
		throws NoSuchAgentCalendarException;

	/**
	 * Returns the first agent calendar in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public AgentCalendar fetchBytitle_First(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator);

	/**
	 * Returns the last agent calendar in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public AgentCalendar findBytitle_Last(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
				orderByComparator)
		throws NoSuchAgentCalendarException;

	/**
	 * Returns the last agent calendar in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public AgentCalendar fetchBytitle_Last(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator);

	/**
	 * Returns the agent calendars before and after the current agent calendar in the ordered set where title = &#63;.
	 *
	 * @param agentCalendarId the primary key of the current agent calendar
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent calendar
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	public AgentCalendar[] findBytitle_PrevAndNext(
			long agentCalendarId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
				orderByComparator)
		throws NoSuchAgentCalendarException;

	/**
	 * Removes all the agent calendars where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public void removeBytitle(String title);

	/**
	 * Returns the number of agent calendars where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching agent calendars
	 */
	public int countBytitle(String title);

	/**
	 * Returns all the agent calendars where location = &#63;.
	 *
	 * @param location the location
	 * @return the matching agent calendars
	 */
	public java.util.List<AgentCalendar> findBylocation(String location);

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
	public java.util.List<AgentCalendar> findBylocation(
		String location, int start, int end);

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
	public java.util.List<AgentCalendar> findBylocation(
		String location, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator);

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
	public java.util.List<AgentCalendar> findBylocation(
		String location, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first agent calendar in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public AgentCalendar findBylocation_First(
			String location,
			com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
				orderByComparator)
		throws NoSuchAgentCalendarException;

	/**
	 * Returns the first agent calendar in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public AgentCalendar fetchBylocation_First(
		String location,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator);

	/**
	 * Returns the last agent calendar in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public AgentCalendar findBylocation_Last(
			String location,
			com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
				orderByComparator)
		throws NoSuchAgentCalendarException;

	/**
	 * Returns the last agent calendar in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public AgentCalendar fetchBylocation_Last(
		String location,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator);

	/**
	 * Returns the agent calendars before and after the current agent calendar in the ordered set where location = &#63;.
	 *
	 * @param agentCalendarId the primary key of the current agent calendar
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent calendar
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	public AgentCalendar[] findBylocation_PrevAndNext(
			long agentCalendarId, String location,
			com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
				orderByComparator)
		throws NoSuchAgentCalendarException;

	/**
	 * Removes all the agent calendars where location = &#63; from the database.
	 *
	 * @param location the location
	 */
	public void removeBylocation(String location);

	/**
	 * Returns the number of agent calendars where location = &#63;.
	 *
	 * @param location the location
	 * @return the number of matching agent calendars
	 */
	public int countBylocation(String location);

	/**
	 * Returns all the agent calendars where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching agent calendars
	 */
	public java.util.List<AgentCalendar> findBymypageUserId(long mypageUserId);

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
	public java.util.List<AgentCalendar> findBymypageUserId(
		long mypageUserId, int start, int end);

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
	public java.util.List<AgentCalendar> findBymypageUserId(
		long mypageUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator);

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
	public java.util.List<AgentCalendar> findBymypageUserId(
		long mypageUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first agent calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public AgentCalendar findBymypageUserId_First(
			long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
				orderByComparator)
		throws NoSuchAgentCalendarException;

	/**
	 * Returns the first agent calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public AgentCalendar fetchBymypageUserId_First(
		long mypageUserId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator);

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public AgentCalendar findBymypageUserId_Last(
			long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
				orderByComparator)
		throws NoSuchAgentCalendarException;

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public AgentCalendar fetchBymypageUserId_Last(
		long mypageUserId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator);

	/**
	 * Returns the agent calendars before and after the current agent calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param agentCalendarId the primary key of the current agent calendar
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent calendar
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	public AgentCalendar[] findBymypageUserId_PrevAndNext(
			long agentCalendarId, long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
				orderByComparator)
		throws NoSuchAgentCalendarException;

	/**
	 * Removes all the agent calendars where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	public void removeBymypageUserId(long mypageUserId);

	/**
	 * Returns the number of agent calendars where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching agent calendars
	 */
	public int countBymypageUserId(long mypageUserId);

	/**
	 * Returns all the agent calendars where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the matching agent calendars
	 */
	public java.util.List<AgentCalendar> findBymypageUserRoleId(
		long mypageUserRoleId);

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
	public java.util.List<AgentCalendar> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end);

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
	public java.util.List<AgentCalendar> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator);

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
	public java.util.List<AgentCalendar> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first agent calendar in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public AgentCalendar findBymypageUserRoleId_First(
			long mypageUserRoleId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
				orderByComparator)
		throws NoSuchAgentCalendarException;

	/**
	 * Returns the first agent calendar in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public AgentCalendar fetchBymypageUserRoleId_First(
		long mypageUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator);

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public AgentCalendar findBymypageUserRoleId_Last(
			long mypageUserRoleId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
				orderByComparator)
		throws NoSuchAgentCalendarException;

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public AgentCalendar fetchBymypageUserRoleId_Last(
		long mypageUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator);

	/**
	 * Returns the agent calendars before and after the current agent calendar in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param agentCalendarId the primary key of the current agent calendar
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent calendar
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	public AgentCalendar[] findBymypageUserRoleId_PrevAndNext(
			long agentCalendarId, long mypageUserRoleId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
				orderByComparator)
		throws NoSuchAgentCalendarException;

	/**
	 * Removes all the agent calendars where mypageUserRoleId = &#63; from the database.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 */
	public void removeBymypageUserRoleId(long mypageUserRoleId);

	/**
	 * Returns the number of agent calendars where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the number of matching agent calendars
	 */
	public int countBymypageUserRoleId(long mypageUserRoleId);

	/**
	 * Returns all the agent calendars where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @return the matching agent calendars
	 */
	public java.util.List<AgentCalendar> findBymypageUserGroupId(
		long mypageUserGroupId);

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
	public java.util.List<AgentCalendar> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end);

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
	public java.util.List<AgentCalendar> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator);

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
	public java.util.List<AgentCalendar> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first agent calendar in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public AgentCalendar findBymypageUserGroupId_First(
			long mypageUserGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
				orderByComparator)
		throws NoSuchAgentCalendarException;

	/**
	 * Returns the first agent calendar in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public AgentCalendar fetchBymypageUserGroupId_First(
		long mypageUserGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator);

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public AgentCalendar findBymypageUserGroupId_Last(
			long mypageUserGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
				orderByComparator)
		throws NoSuchAgentCalendarException;

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public AgentCalendar fetchBymypageUserGroupId_Last(
		long mypageUserGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator);

	/**
	 * Returns the agent calendars before and after the current agent calendar in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param agentCalendarId the primary key of the current agent calendar
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent calendar
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	public AgentCalendar[] findBymypageUserGroupId_PrevAndNext(
			long agentCalendarId, long mypageUserGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
				orderByComparator)
		throws NoSuchAgentCalendarException;

	/**
	 * Removes all the agent calendars where mypageUserGroupId = &#63; from the database.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 */
	public void removeBymypageUserGroupId(long mypageUserGroupId);

	/**
	 * Returns the number of agent calendars where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @return the number of matching agent calendars
	 */
	public int countBymypageUserGroupId(long mypageUserGroupId);

	/**
	 * Caches the agent calendar in the entity cache if it is enabled.
	 *
	 * @param agentCalendar the agent calendar
	 */
	public void cacheResult(AgentCalendar agentCalendar);

	/**
	 * Caches the agent calendars in the entity cache if it is enabled.
	 *
	 * @param agentCalendars the agent calendars
	 */
	public void cacheResult(java.util.List<AgentCalendar> agentCalendars);

	/**
	 * Creates a new agent calendar with the primary key. Does not add the agent calendar to the database.
	 *
	 * @param agentCalendarId the primary key for the new agent calendar
	 * @return the new agent calendar
	 */
	public AgentCalendar create(long agentCalendarId);

	/**
	 * Removes the agent calendar with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentCalendarId the primary key of the agent calendar
	 * @return the agent calendar that was removed
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	public AgentCalendar remove(long agentCalendarId)
		throws NoSuchAgentCalendarException;

	public AgentCalendar updateImpl(AgentCalendar agentCalendar);

	/**
	 * Returns the agent calendar with the primary key or throws a <code>NoSuchAgentCalendarException</code> if it could not be found.
	 *
	 * @param agentCalendarId the primary key of the agent calendar
	 * @return the agent calendar
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	public AgentCalendar findByPrimaryKey(long agentCalendarId)
		throws NoSuchAgentCalendarException;

	/**
	 * Returns the agent calendar with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentCalendarId the primary key of the agent calendar
	 * @return the agent calendar, or <code>null</code> if a agent calendar with the primary key could not be found
	 */
	public AgentCalendar fetchByPrimaryKey(long agentCalendarId);

	/**
	 * Returns all the agent calendars.
	 *
	 * @return the agent calendars
	 */
	public java.util.List<AgentCalendar> findAll();

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
	public java.util.List<AgentCalendar> findAll(int start, int end);

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
	public java.util.List<AgentCalendar> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator);

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
	public java.util.List<AgentCalendar> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentCalendar>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the agent calendars from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of agent calendars.
	 *
	 * @return the number of agent calendars
	 */
	public int countAll();

}