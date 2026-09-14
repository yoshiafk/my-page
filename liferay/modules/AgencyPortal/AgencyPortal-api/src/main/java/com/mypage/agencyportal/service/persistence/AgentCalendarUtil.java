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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.agencyportal.model.AgentCalendar;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the agent calendar service. This utility wraps <code>com.mypage.agencyportal.service.persistence.impl.AgentCalendarPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentCalendarPersistence
 * @generated
 */
public class AgentCalendarUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AgentCalendar agentCalendar) {
		getPersistence().clearCache(agentCalendar);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, AgentCalendar> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AgentCalendar> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AgentCalendar> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AgentCalendar> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AgentCalendar update(AgentCalendar agentCalendar) {
		return getPersistence().update(agentCalendar);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AgentCalendar update(
		AgentCalendar agentCalendar, ServiceContext serviceContext) {

		return getPersistence().update(agentCalendar, serviceContext);
	}

	/**
	 * Returns all the agent calendars where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching agent calendars
	 */
	public static List<AgentCalendar> findBytitle(String title) {
		return getPersistence().findBytitle(title);
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
	public static List<AgentCalendar> findBytitle(
		String title, int start, int end) {

		return getPersistence().findBytitle(title, start, end);
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
	public static List<AgentCalendar> findBytitle(
		String title, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator) {

		return getPersistence().findBytitle(
			title, start, end, orderByComparator);
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
	public static List<AgentCalendar> findBytitle(
		String title, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBytitle(
			title, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agent calendar in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public static AgentCalendar findBytitle_First(
			String title, OrderByComparator<AgentCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentCalendarException {

		return getPersistence().findBytitle_First(title, orderByComparator);
	}

	/**
	 * Returns the first agent calendar in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public static AgentCalendar fetchBytitle_First(
		String title, OrderByComparator<AgentCalendar> orderByComparator) {

		return getPersistence().fetchBytitle_First(title, orderByComparator);
	}

	/**
	 * Returns the last agent calendar in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public static AgentCalendar findBytitle_Last(
			String title, OrderByComparator<AgentCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentCalendarException {

		return getPersistence().findBytitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the last agent calendar in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public static AgentCalendar fetchBytitle_Last(
		String title, OrderByComparator<AgentCalendar> orderByComparator) {

		return getPersistence().fetchBytitle_Last(title, orderByComparator);
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
	public static AgentCalendar[] findBytitle_PrevAndNext(
			long agentCalendarId, String title,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentCalendarException {

		return getPersistence().findBytitle_PrevAndNext(
			agentCalendarId, title, orderByComparator);
	}

	/**
	 * Removes all the agent calendars where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public static void removeBytitle(String title) {
		getPersistence().removeBytitle(title);
	}

	/**
	 * Returns the number of agent calendars where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching agent calendars
	 */
	public static int countBytitle(String title) {
		return getPersistence().countBytitle(title);
	}

	/**
	 * Returns all the agent calendars where location = &#63;.
	 *
	 * @param location the location
	 * @return the matching agent calendars
	 */
	public static List<AgentCalendar> findBylocation(String location) {
		return getPersistence().findBylocation(location);
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
	public static List<AgentCalendar> findBylocation(
		String location, int start, int end) {

		return getPersistence().findBylocation(location, start, end);
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
	public static List<AgentCalendar> findBylocation(
		String location, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator) {

		return getPersistence().findBylocation(
			location, start, end, orderByComparator);
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
	public static List<AgentCalendar> findBylocation(
		String location, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBylocation(
			location, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agent calendar in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public static AgentCalendar findBylocation_First(
			String location, OrderByComparator<AgentCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentCalendarException {

		return getPersistence().findBylocation_First(
			location, orderByComparator);
	}

	/**
	 * Returns the first agent calendar in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public static AgentCalendar fetchBylocation_First(
		String location, OrderByComparator<AgentCalendar> orderByComparator) {

		return getPersistence().fetchBylocation_First(
			location, orderByComparator);
	}

	/**
	 * Returns the last agent calendar in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public static AgentCalendar findBylocation_Last(
			String location, OrderByComparator<AgentCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentCalendarException {

		return getPersistence().findBylocation_Last(
			location, orderByComparator);
	}

	/**
	 * Returns the last agent calendar in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public static AgentCalendar fetchBylocation_Last(
		String location, OrderByComparator<AgentCalendar> orderByComparator) {

		return getPersistence().fetchBylocation_Last(
			location, orderByComparator);
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
	public static AgentCalendar[] findBylocation_PrevAndNext(
			long agentCalendarId, String location,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentCalendarException {

		return getPersistence().findBylocation_PrevAndNext(
			agentCalendarId, location, orderByComparator);
	}

	/**
	 * Removes all the agent calendars where location = &#63; from the database.
	 *
	 * @param location the location
	 */
	public static void removeBylocation(String location) {
		getPersistence().removeBylocation(location);
	}

	/**
	 * Returns the number of agent calendars where location = &#63;.
	 *
	 * @param location the location
	 * @return the number of matching agent calendars
	 */
	public static int countBylocation(String location) {
		return getPersistence().countBylocation(location);
	}

	/**
	 * Returns all the agent calendars where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching agent calendars
	 */
	public static List<AgentCalendar> findBymypageUserId(long mypageUserId) {
		return getPersistence().findBymypageUserId(mypageUserId);
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
	public static List<AgentCalendar> findBymypageUserId(
		long mypageUserId, int start, int end) {

		return getPersistence().findBymypageUserId(mypageUserId, start, end);
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
	public static List<AgentCalendar> findBymypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator) {

		return getPersistence().findBymypageUserId(
			mypageUserId, start, end, orderByComparator);
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
	public static List<AgentCalendar> findBymypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBymypageUserId(
			mypageUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agent calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public static AgentCalendar findBymypageUserId_First(
			long mypageUserId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentCalendarException {

		return getPersistence().findBymypageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the first agent calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public static AgentCalendar fetchBymypageUserId_First(
		long mypageUserId, OrderByComparator<AgentCalendar> orderByComparator) {

		return getPersistence().fetchBymypageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public static AgentCalendar findBymypageUserId_Last(
			long mypageUserId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentCalendarException {

		return getPersistence().findBymypageUserId_Last(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public static AgentCalendar fetchBymypageUserId_Last(
		long mypageUserId, OrderByComparator<AgentCalendar> orderByComparator) {

		return getPersistence().fetchBymypageUserId_Last(
			mypageUserId, orderByComparator);
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
	public static AgentCalendar[] findBymypageUserId_PrevAndNext(
			long agentCalendarId, long mypageUserId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentCalendarException {

		return getPersistence().findBymypageUserId_PrevAndNext(
			agentCalendarId, mypageUserId, orderByComparator);
	}

	/**
	 * Removes all the agent calendars where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	public static void removeBymypageUserId(long mypageUserId) {
		getPersistence().removeBymypageUserId(mypageUserId);
	}

	/**
	 * Returns the number of agent calendars where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching agent calendars
	 */
	public static int countBymypageUserId(long mypageUserId) {
		return getPersistence().countBymypageUserId(mypageUserId);
	}

	/**
	 * Returns all the agent calendars where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the matching agent calendars
	 */
	public static List<AgentCalendar> findBymypageUserRoleId(
		long mypageUserRoleId) {

		return getPersistence().findBymypageUserRoleId(mypageUserRoleId);
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
	public static List<AgentCalendar> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end) {

		return getPersistence().findBymypageUserRoleId(
			mypageUserRoleId, start, end);
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
	public static List<AgentCalendar> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator) {

		return getPersistence().findBymypageUserRoleId(
			mypageUserRoleId, start, end, orderByComparator);
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
	public static List<AgentCalendar> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBymypageUserRoleId(
			mypageUserRoleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agent calendar in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public static AgentCalendar findBymypageUserRoleId_First(
			long mypageUserRoleId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentCalendarException {

		return getPersistence().findBymypageUserRoleId_First(
			mypageUserRoleId, orderByComparator);
	}

	/**
	 * Returns the first agent calendar in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public static AgentCalendar fetchBymypageUserRoleId_First(
		long mypageUserRoleId,
		OrderByComparator<AgentCalendar> orderByComparator) {

		return getPersistence().fetchBymypageUserRoleId_First(
			mypageUserRoleId, orderByComparator);
	}

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public static AgentCalendar findBymypageUserRoleId_Last(
			long mypageUserRoleId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentCalendarException {

		return getPersistence().findBymypageUserRoleId_Last(
			mypageUserRoleId, orderByComparator);
	}

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public static AgentCalendar fetchBymypageUserRoleId_Last(
		long mypageUserRoleId,
		OrderByComparator<AgentCalendar> orderByComparator) {

		return getPersistence().fetchBymypageUserRoleId_Last(
			mypageUserRoleId, orderByComparator);
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
	public static AgentCalendar[] findBymypageUserRoleId_PrevAndNext(
			long agentCalendarId, long mypageUserRoleId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentCalendarException {

		return getPersistence().findBymypageUserRoleId_PrevAndNext(
			agentCalendarId, mypageUserRoleId, orderByComparator);
	}

	/**
	 * Removes all the agent calendars where mypageUserRoleId = &#63; from the database.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 */
	public static void removeBymypageUserRoleId(long mypageUserRoleId) {
		getPersistence().removeBymypageUserRoleId(mypageUserRoleId);
	}

	/**
	 * Returns the number of agent calendars where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the number of matching agent calendars
	 */
	public static int countBymypageUserRoleId(long mypageUserRoleId) {
		return getPersistence().countBymypageUserRoleId(mypageUserRoleId);
	}

	/**
	 * Returns all the agent calendars where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @return the matching agent calendars
	 */
	public static List<AgentCalendar> findBymypageUserGroupId(
		long mypageUserGroupId) {

		return getPersistence().findBymypageUserGroupId(mypageUserGroupId);
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
	public static List<AgentCalendar> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end) {

		return getPersistence().findBymypageUserGroupId(
			mypageUserGroupId, start, end);
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
	public static List<AgentCalendar> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator) {

		return getPersistence().findBymypageUserGroupId(
			mypageUserGroupId, start, end, orderByComparator);
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
	public static List<AgentCalendar> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBymypageUserGroupId(
			mypageUserGroupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agent calendar in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public static AgentCalendar findBymypageUserGroupId_First(
			long mypageUserGroupId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentCalendarException {

		return getPersistence().findBymypageUserGroupId_First(
			mypageUserGroupId, orderByComparator);
	}

	/**
	 * Returns the first agent calendar in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public static AgentCalendar fetchBymypageUserGroupId_First(
		long mypageUserGroupId,
		OrderByComparator<AgentCalendar> orderByComparator) {

		return getPersistence().fetchBymypageUserGroupId_First(
			mypageUserGroupId, orderByComparator);
	}

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar
	 * @throws NoSuchAgentCalendarException if a matching agent calendar could not be found
	 */
	public static AgentCalendar findBymypageUserGroupId_Last(
			long mypageUserGroupId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentCalendarException {

		return getPersistence().findBymypageUserGroupId_Last(
			mypageUserGroupId, orderByComparator);
	}

	/**
	 * Returns the last agent calendar in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent calendar, or <code>null</code> if a matching agent calendar could not be found
	 */
	public static AgentCalendar fetchBymypageUserGroupId_Last(
		long mypageUserGroupId,
		OrderByComparator<AgentCalendar> orderByComparator) {

		return getPersistence().fetchBymypageUserGroupId_Last(
			mypageUserGroupId, orderByComparator);
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
	public static AgentCalendar[] findBymypageUserGroupId_PrevAndNext(
			long agentCalendarId, long mypageUserGroupId,
			OrderByComparator<AgentCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentCalendarException {

		return getPersistence().findBymypageUserGroupId_PrevAndNext(
			agentCalendarId, mypageUserGroupId, orderByComparator);
	}

	/**
	 * Removes all the agent calendars where mypageUserGroupId = &#63; from the database.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 */
	public static void removeBymypageUserGroupId(long mypageUserGroupId) {
		getPersistence().removeBymypageUserGroupId(mypageUserGroupId);
	}

	/**
	 * Returns the number of agent calendars where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @return the number of matching agent calendars
	 */
	public static int countBymypageUserGroupId(long mypageUserGroupId) {
		return getPersistence().countBymypageUserGroupId(mypageUserGroupId);
	}

	/**
	 * Caches the agent calendar in the entity cache if it is enabled.
	 *
	 * @param agentCalendar the agent calendar
	 */
	public static void cacheResult(AgentCalendar agentCalendar) {
		getPersistence().cacheResult(agentCalendar);
	}

	/**
	 * Caches the agent calendars in the entity cache if it is enabled.
	 *
	 * @param agentCalendars the agent calendars
	 */
	public static void cacheResult(List<AgentCalendar> agentCalendars) {
		getPersistence().cacheResult(agentCalendars);
	}

	/**
	 * Creates a new agent calendar with the primary key. Does not add the agent calendar to the database.
	 *
	 * @param agentCalendarId the primary key for the new agent calendar
	 * @return the new agent calendar
	 */
	public static AgentCalendar create(long agentCalendarId) {
		return getPersistence().create(agentCalendarId);
	}

	/**
	 * Removes the agent calendar with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentCalendarId the primary key of the agent calendar
	 * @return the agent calendar that was removed
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	public static AgentCalendar remove(long agentCalendarId)
		throws com.mypage.agencyportal.exception.NoSuchAgentCalendarException {

		return getPersistence().remove(agentCalendarId);
	}

	public static AgentCalendar updateImpl(AgentCalendar agentCalendar) {
		return getPersistence().updateImpl(agentCalendar);
	}

	/**
	 * Returns the agent calendar with the primary key or throws a <code>NoSuchAgentCalendarException</code> if it could not be found.
	 *
	 * @param agentCalendarId the primary key of the agent calendar
	 * @return the agent calendar
	 * @throws NoSuchAgentCalendarException if a agent calendar with the primary key could not be found
	 */
	public static AgentCalendar findByPrimaryKey(long agentCalendarId)
		throws com.mypage.agencyportal.exception.NoSuchAgentCalendarException {

		return getPersistence().findByPrimaryKey(agentCalendarId);
	}

	/**
	 * Returns the agent calendar with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentCalendarId the primary key of the agent calendar
	 * @return the agent calendar, or <code>null</code> if a agent calendar with the primary key could not be found
	 */
	public static AgentCalendar fetchByPrimaryKey(long agentCalendarId) {
		return getPersistence().fetchByPrimaryKey(agentCalendarId);
	}

	/**
	 * Returns all the agent calendars.
	 *
	 * @return the agent calendars
	 */
	public static List<AgentCalendar> findAll() {
		return getPersistence().findAll();
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
	public static List<AgentCalendar> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<AgentCalendar> findAll(
		int start, int end,
		OrderByComparator<AgentCalendar> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<AgentCalendar> findAll(
		int start, int end, OrderByComparator<AgentCalendar> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the agent calendars from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of agent calendars.
	 *
	 * @return the number of agent calendars
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AgentCalendarPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AgentCalendarPersistence _persistence;

}