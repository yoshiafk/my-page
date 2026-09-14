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

import com.mypage.agencyportal.model.AgentMarkCalendar;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the agent mark calendar service. This utility wraps <code>com.mypage.agencyportal.service.persistence.impl.AgentMarkCalendarPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentMarkCalendarPersistence
 * @generated
 */
public class AgentMarkCalendarUtil {

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
	public static void clearCache(AgentMarkCalendar agentMarkCalendar) {
		getPersistence().clearCache(agentMarkCalendar);
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
	public static Map<Serializable, AgentMarkCalendar> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AgentMarkCalendar> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AgentMarkCalendar> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AgentMarkCalendar> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AgentMarkCalendar> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AgentMarkCalendar update(
		AgentMarkCalendar agentMarkCalendar) {

		return getPersistence().update(agentMarkCalendar);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AgentMarkCalendar update(
		AgentMarkCalendar agentMarkCalendar, ServiceContext serviceContext) {

		return getPersistence().update(agentMarkCalendar, serviceContext);
	}

	/**
	 * Returns all the agent mark calendars where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching agent mark calendars
	 */
	public static List<AgentMarkCalendar> findBymypageUserId(
		long mypageUserId) {

		return getPersistence().findBymypageUserId(mypageUserId);
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
	public static List<AgentMarkCalendar> findBymypageUserId(
		long mypageUserId, int start, int end) {

		return getPersistence().findBymypageUserId(mypageUserId, start, end);
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
	public static List<AgentMarkCalendar> findBymypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<AgentMarkCalendar> orderByComparator) {

		return getPersistence().findBymypageUserId(
			mypageUserId, start, end, orderByComparator);
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
	public static List<AgentMarkCalendar> findBymypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<AgentMarkCalendar> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBymypageUserId(
			mypageUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agent mark calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent mark calendar
	 * @throws NoSuchAgentMarkCalendarException if a matching agent mark calendar could not be found
	 */
	public static AgentMarkCalendar findBymypageUserId_First(
			long mypageUserId,
			OrderByComparator<AgentMarkCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentMarkCalendarException {

		return getPersistence().findBymypageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the first agent mark calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent mark calendar, or <code>null</code> if a matching agent mark calendar could not be found
	 */
	public static AgentMarkCalendar fetchBymypageUserId_First(
		long mypageUserId,
		OrderByComparator<AgentMarkCalendar> orderByComparator) {

		return getPersistence().fetchBymypageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last agent mark calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent mark calendar
	 * @throws NoSuchAgentMarkCalendarException if a matching agent mark calendar could not be found
	 */
	public static AgentMarkCalendar findBymypageUserId_Last(
			long mypageUserId,
			OrderByComparator<AgentMarkCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentMarkCalendarException {

		return getPersistence().findBymypageUserId_Last(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last agent mark calendar in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent mark calendar, or <code>null</code> if a matching agent mark calendar could not be found
	 */
	public static AgentMarkCalendar fetchBymypageUserId_Last(
		long mypageUserId,
		OrderByComparator<AgentMarkCalendar> orderByComparator) {

		return getPersistence().fetchBymypageUserId_Last(
			mypageUserId, orderByComparator);
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
	public static AgentMarkCalendar[] findBymypageUserId_PrevAndNext(
			long agentMarkCalendarId, long mypageUserId,
			OrderByComparator<AgentMarkCalendar> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentMarkCalendarException {

		return getPersistence().findBymypageUserId_PrevAndNext(
			agentMarkCalendarId, mypageUserId, orderByComparator);
	}

	/**
	 * Removes all the agent mark calendars where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	public static void removeBymypageUserId(long mypageUserId) {
		getPersistence().removeBymypageUserId(mypageUserId);
	}

	/**
	 * Returns the number of agent mark calendars where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching agent mark calendars
	 */
	public static int countBymypageUserId(long mypageUserId) {
		return getPersistence().countBymypageUserId(mypageUserId);
	}

	/**
	 * Caches the agent mark calendar in the entity cache if it is enabled.
	 *
	 * @param agentMarkCalendar the agent mark calendar
	 */
	public static void cacheResult(AgentMarkCalendar agentMarkCalendar) {
		getPersistence().cacheResult(agentMarkCalendar);
	}

	/**
	 * Caches the agent mark calendars in the entity cache if it is enabled.
	 *
	 * @param agentMarkCalendars the agent mark calendars
	 */
	public static void cacheResult(List<AgentMarkCalendar> agentMarkCalendars) {
		getPersistence().cacheResult(agentMarkCalendars);
	}

	/**
	 * Creates a new agent mark calendar with the primary key. Does not add the agent mark calendar to the database.
	 *
	 * @param agentMarkCalendarId the primary key for the new agent mark calendar
	 * @return the new agent mark calendar
	 */
	public static AgentMarkCalendar create(long agentMarkCalendarId) {
		return getPersistence().create(agentMarkCalendarId);
	}

	/**
	 * Removes the agent mark calendar with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentMarkCalendarId the primary key of the agent mark calendar
	 * @return the agent mark calendar that was removed
	 * @throws NoSuchAgentMarkCalendarException if a agent mark calendar with the primary key could not be found
	 */
	public static AgentMarkCalendar remove(long agentMarkCalendarId)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentMarkCalendarException {

		return getPersistence().remove(agentMarkCalendarId);
	}

	public static AgentMarkCalendar updateImpl(
		AgentMarkCalendar agentMarkCalendar) {

		return getPersistence().updateImpl(agentMarkCalendar);
	}

	/**
	 * Returns the agent mark calendar with the primary key or throws a <code>NoSuchAgentMarkCalendarException</code> if it could not be found.
	 *
	 * @param agentMarkCalendarId the primary key of the agent mark calendar
	 * @return the agent mark calendar
	 * @throws NoSuchAgentMarkCalendarException if a agent mark calendar with the primary key could not be found
	 */
	public static AgentMarkCalendar findByPrimaryKey(long agentMarkCalendarId)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentMarkCalendarException {

		return getPersistence().findByPrimaryKey(agentMarkCalendarId);
	}

	/**
	 * Returns the agent mark calendar with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentMarkCalendarId the primary key of the agent mark calendar
	 * @return the agent mark calendar, or <code>null</code> if a agent mark calendar with the primary key could not be found
	 */
	public static AgentMarkCalendar fetchByPrimaryKey(
		long agentMarkCalendarId) {

		return getPersistence().fetchByPrimaryKey(agentMarkCalendarId);
	}

	/**
	 * Returns all the agent mark calendars.
	 *
	 * @return the agent mark calendars
	 */
	public static List<AgentMarkCalendar> findAll() {
		return getPersistence().findAll();
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
	public static List<AgentMarkCalendar> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<AgentMarkCalendar> findAll(
		int start, int end,
		OrderByComparator<AgentMarkCalendar> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<AgentMarkCalendar> findAll(
		int start, int end,
		OrderByComparator<AgentMarkCalendar> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the agent mark calendars from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of agent mark calendars.
	 *
	 * @return the number of agent mark calendars
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AgentMarkCalendarPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AgentMarkCalendarPersistence _persistence;

}