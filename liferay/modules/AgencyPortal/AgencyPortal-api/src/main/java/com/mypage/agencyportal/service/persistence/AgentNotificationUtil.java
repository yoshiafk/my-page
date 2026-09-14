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

import com.mypage.agencyportal.model.AgentNotification;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the agent notification service. This utility wraps <code>com.mypage.agencyportal.service.persistence.impl.AgentNotificationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentNotificationPersistence
 * @generated
 */
public class AgentNotificationUtil {

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
	public static void clearCache(AgentNotification agentNotification) {
		getPersistence().clearCache(agentNotification);
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
	public static Map<Serializable, AgentNotification> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AgentNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AgentNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AgentNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AgentNotification update(
		AgentNotification agentNotification) {

		return getPersistence().update(agentNotification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AgentNotification update(
		AgentNotification agentNotification, ServiceContext serviceContext) {

		return getPersistence().update(agentNotification, serviceContext);
	}

	/**
	 * Returns all the agent notifications where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching agent notifications
	 */
	public static List<AgentNotification> findBytitle(String title) {
		return getPersistence().findBytitle(title);
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
	public static List<AgentNotification> findBytitle(
		String title, int start, int end) {

		return getPersistence().findBytitle(title, start, end);
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
	public static List<AgentNotification> findBytitle(
		String title, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().findBytitle(
			title, start, end, orderByComparator);
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
	public static List<AgentNotification> findBytitle(
		String title, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBytitle(
			title, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agent notification in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public static AgentNotification findBytitle_First(
			String title,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findBytitle_First(title, orderByComparator);
	}

	/**
	 * Returns the first agent notification in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public static AgentNotification fetchBytitle_First(
		String title, OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().fetchBytitle_First(title, orderByComparator);
	}

	/**
	 * Returns the last agent notification in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public static AgentNotification findBytitle_Last(
			String title,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findBytitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the last agent notification in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public static AgentNotification fetchBytitle_Last(
		String title, OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().fetchBytitle_Last(title, orderByComparator);
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
	public static AgentNotification[] findBytitle_PrevAndNext(
			long agentNotificationId, String title,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findBytitle_PrevAndNext(
			agentNotificationId, title, orderByComparator);
	}

	/**
	 * Removes all the agent notifications where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public static void removeBytitle(String title) {
		getPersistence().removeBytitle(title);
	}

	/**
	 * Returns the number of agent notifications where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching agent notifications
	 */
	public static int countBytitle(String title) {
		return getPersistence().countBytitle(title);
	}

	/**
	 * Returns all the agent notifications where location = &#63;.
	 *
	 * @param location the location
	 * @return the matching agent notifications
	 */
	public static List<AgentNotification> findBylocation(String location) {
		return getPersistence().findBylocation(location);
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
	public static List<AgentNotification> findBylocation(
		String location, int start, int end) {

		return getPersistence().findBylocation(location, start, end);
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
	public static List<AgentNotification> findBylocation(
		String location, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().findBylocation(
			location, start, end, orderByComparator);
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
	public static List<AgentNotification> findBylocation(
		String location, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBylocation(
			location, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agent notification in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public static AgentNotification findBylocation_First(
			String location,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findBylocation_First(
			location, orderByComparator);
	}

	/**
	 * Returns the first agent notification in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public static AgentNotification fetchBylocation_First(
		String location,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().fetchBylocation_First(
			location, orderByComparator);
	}

	/**
	 * Returns the last agent notification in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public static AgentNotification findBylocation_Last(
			String location,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findBylocation_Last(
			location, orderByComparator);
	}

	/**
	 * Returns the last agent notification in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public static AgentNotification fetchBylocation_Last(
		String location,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().fetchBylocation_Last(
			location, orderByComparator);
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
	public static AgentNotification[] findBylocation_PrevAndNext(
			long agentNotificationId, String location,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findBylocation_PrevAndNext(
			agentNotificationId, location, orderByComparator);
	}

	/**
	 * Removes all the agent notifications where location = &#63; from the database.
	 *
	 * @param location the location
	 */
	public static void removeBylocation(String location) {
		getPersistence().removeBylocation(location);
	}

	/**
	 * Returns the number of agent notifications where location = &#63;.
	 *
	 * @param location the location
	 * @return the number of matching agent notifications
	 */
	public static int countBylocation(String location) {
		return getPersistence().countBylocation(location);
	}

	/**
	 * Returns all the agent notifications where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching agent notifications
	 */
	public static List<AgentNotification> findBymypageUserId(
		long mypageUserId) {

		return getPersistence().findBymypageUserId(mypageUserId);
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
	public static List<AgentNotification> findBymypageUserId(
		long mypageUserId, int start, int end) {

		return getPersistence().findBymypageUserId(mypageUserId, start, end);
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
	public static List<AgentNotification> findBymypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().findBymypageUserId(
			mypageUserId, start, end, orderByComparator);
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
	public static List<AgentNotification> findBymypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBymypageUserId(
			mypageUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agent notification in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public static AgentNotification findBymypageUserId_First(
			long mypageUserId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findBymypageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the first agent notification in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public static AgentNotification fetchBymypageUserId_First(
		long mypageUserId,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().fetchBymypageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last agent notification in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public static AgentNotification findBymypageUserId_Last(
			long mypageUserId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findBymypageUserId_Last(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last agent notification in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public static AgentNotification fetchBymypageUserId_Last(
		long mypageUserId,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().fetchBymypageUserId_Last(
			mypageUserId, orderByComparator);
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
	public static AgentNotification[] findBymypageUserId_PrevAndNext(
			long agentNotificationId, long mypageUserId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findBymypageUserId_PrevAndNext(
			agentNotificationId, mypageUserId, orderByComparator);
	}

	/**
	 * Removes all the agent notifications where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	public static void removeBymypageUserId(long mypageUserId) {
		getPersistence().removeBymypageUserId(mypageUserId);
	}

	/**
	 * Returns the number of agent notifications where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching agent notifications
	 */
	public static int countBymypageUserId(long mypageUserId) {
		return getPersistence().countBymypageUserId(mypageUserId);
	}

	/**
	 * Returns all the agent notifications where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the matching agent notifications
	 */
	public static List<AgentNotification> findBymypageUserRoleId(
		long mypageUserRoleId) {

		return getPersistence().findBymypageUserRoleId(mypageUserRoleId);
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
	public static List<AgentNotification> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end) {

		return getPersistence().findBymypageUserRoleId(
			mypageUserRoleId, start, end);
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
	public static List<AgentNotification> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().findBymypageUserRoleId(
			mypageUserRoleId, start, end, orderByComparator);
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
	public static List<AgentNotification> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBymypageUserRoleId(
			mypageUserRoleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agent notification in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public static AgentNotification findBymypageUserRoleId_First(
			long mypageUserRoleId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findBymypageUserRoleId_First(
			mypageUserRoleId, orderByComparator);
	}

	/**
	 * Returns the first agent notification in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public static AgentNotification fetchBymypageUserRoleId_First(
		long mypageUserRoleId,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().fetchBymypageUserRoleId_First(
			mypageUserRoleId, orderByComparator);
	}

	/**
	 * Returns the last agent notification in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public static AgentNotification findBymypageUserRoleId_Last(
			long mypageUserRoleId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findBymypageUserRoleId_Last(
			mypageUserRoleId, orderByComparator);
	}

	/**
	 * Returns the last agent notification in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public static AgentNotification fetchBymypageUserRoleId_Last(
		long mypageUserRoleId,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().fetchBymypageUserRoleId_Last(
			mypageUserRoleId, orderByComparator);
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
	public static AgentNotification[] findBymypageUserRoleId_PrevAndNext(
			long agentNotificationId, long mypageUserRoleId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findBymypageUserRoleId_PrevAndNext(
			agentNotificationId, mypageUserRoleId, orderByComparator);
	}

	/**
	 * Removes all the agent notifications where mypageUserRoleId = &#63; from the database.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 */
	public static void removeBymypageUserRoleId(long mypageUserRoleId) {
		getPersistence().removeBymypageUserRoleId(mypageUserRoleId);
	}

	/**
	 * Returns the number of agent notifications where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the number of matching agent notifications
	 */
	public static int countBymypageUserRoleId(long mypageUserRoleId) {
		return getPersistence().countBymypageUserRoleId(mypageUserRoleId);
	}

	/**
	 * Returns all the agent notifications where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @return the matching agent notifications
	 */
	public static List<AgentNotification> findBymypageUserGroupId(
		long mypageUserGroupId) {

		return getPersistence().findBymypageUserGroupId(mypageUserGroupId);
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
	public static List<AgentNotification> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end) {

		return getPersistence().findBymypageUserGroupId(
			mypageUserGroupId, start, end);
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
	public static List<AgentNotification> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().findBymypageUserGroupId(
			mypageUserGroupId, start, end, orderByComparator);
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
	public static List<AgentNotification> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBymypageUserGroupId(
			mypageUserGroupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agent notification in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public static AgentNotification findBymypageUserGroupId_First(
			long mypageUserGroupId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findBymypageUserGroupId_First(
			mypageUserGroupId, orderByComparator);
	}

	/**
	 * Returns the first agent notification in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public static AgentNotification fetchBymypageUserGroupId_First(
		long mypageUserGroupId,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().fetchBymypageUserGroupId_First(
			mypageUserGroupId, orderByComparator);
	}

	/**
	 * Returns the last agent notification in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public static AgentNotification findBymypageUserGroupId_Last(
			long mypageUserGroupId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findBymypageUserGroupId_Last(
			mypageUserGroupId, orderByComparator);
	}

	/**
	 * Returns the last agent notification in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public static AgentNotification fetchBymypageUserGroupId_Last(
		long mypageUserGroupId,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().fetchBymypageUserGroupId_Last(
			mypageUserGroupId, orderByComparator);
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
	public static AgentNotification[] findBymypageUserGroupId_PrevAndNext(
			long agentNotificationId, long mypageUserGroupId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findBymypageUserGroupId_PrevAndNext(
			agentNotificationId, mypageUserGroupId, orderByComparator);
	}

	/**
	 * Removes all the agent notifications where mypageUserGroupId = &#63; from the database.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 */
	public static void removeBymypageUserGroupId(long mypageUserGroupId) {
		getPersistence().removeBymypageUserGroupId(mypageUserGroupId);
	}

	/**
	 * Returns the number of agent notifications where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @return the number of matching agent notifications
	 */
	public static int countBymypageUserGroupId(long mypageUserGroupId) {
		return getPersistence().countBymypageUserGroupId(mypageUserGroupId);
	}

	/**
	 * Returns all the agent notifications where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @return the matching agent notifications
	 */
	public static List<AgentNotification> findByreferenceId(long referenceId) {
		return getPersistence().findByreferenceId(referenceId);
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
	public static List<AgentNotification> findByreferenceId(
		long referenceId, int start, int end) {

		return getPersistence().findByreferenceId(referenceId, start, end);
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
	public static List<AgentNotification> findByreferenceId(
		long referenceId, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().findByreferenceId(
			referenceId, start, end, orderByComparator);
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
	public static List<AgentNotification> findByreferenceId(
		long referenceId, int start, int end,
		OrderByComparator<AgentNotification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByreferenceId(
			referenceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agent notification in the ordered set where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public static AgentNotification findByreferenceId_First(
			long referenceId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findByreferenceId_First(
			referenceId, orderByComparator);
	}

	/**
	 * Returns the first agent notification in the ordered set where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public static AgentNotification fetchByreferenceId_First(
		long referenceId,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().fetchByreferenceId_First(
			referenceId, orderByComparator);
	}

	/**
	 * Returns the last agent notification in the ordered set where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public static AgentNotification findByreferenceId_Last(
			long referenceId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findByreferenceId_Last(
			referenceId, orderByComparator);
	}

	/**
	 * Returns the last agent notification in the ordered set where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public static AgentNotification fetchByreferenceId_Last(
		long referenceId,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().fetchByreferenceId_Last(
			referenceId, orderByComparator);
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
	public static AgentNotification[] findByreferenceId_PrevAndNext(
			long agentNotificationId, long referenceId,
			OrderByComparator<AgentNotification> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findByreferenceId_PrevAndNext(
			agentNotificationId, referenceId, orderByComparator);
	}

	/**
	 * Removes all the agent notifications where referenceId = &#63; from the database.
	 *
	 * @param referenceId the reference ID
	 */
	public static void removeByreferenceId(long referenceId) {
		getPersistence().removeByreferenceId(referenceId);
	}

	/**
	 * Returns the number of agent notifications where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @return the number of matching agent notifications
	 */
	public static int countByreferenceId(long referenceId) {
		return getPersistence().countByreferenceId(referenceId);
	}

	/**
	 * Caches the agent notification in the entity cache if it is enabled.
	 *
	 * @param agentNotification the agent notification
	 */
	public static void cacheResult(AgentNotification agentNotification) {
		getPersistence().cacheResult(agentNotification);
	}

	/**
	 * Caches the agent notifications in the entity cache if it is enabled.
	 *
	 * @param agentNotifications the agent notifications
	 */
	public static void cacheResult(List<AgentNotification> agentNotifications) {
		getPersistence().cacheResult(agentNotifications);
	}

	/**
	 * Creates a new agent notification with the primary key. Does not add the agent notification to the database.
	 *
	 * @param agentNotificationId the primary key for the new agent notification
	 * @return the new agent notification
	 */
	public static AgentNotification create(long agentNotificationId) {
		return getPersistence().create(agentNotificationId);
	}

	/**
	 * Removes the agent notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentNotificationId the primary key of the agent notification
	 * @return the agent notification that was removed
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	public static AgentNotification remove(long agentNotificationId)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().remove(agentNotificationId);
	}

	public static AgentNotification updateImpl(
		AgentNotification agentNotification) {

		return getPersistence().updateImpl(agentNotification);
	}

	/**
	 * Returns the agent notification with the primary key or throws a <code>NoSuchAgentNotificationException</code> if it could not be found.
	 *
	 * @param agentNotificationId the primary key of the agent notification
	 * @return the agent notification
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	public static AgentNotification findByPrimaryKey(long agentNotificationId)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentNotificationException {

		return getPersistence().findByPrimaryKey(agentNotificationId);
	}

	/**
	 * Returns the agent notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentNotificationId the primary key of the agent notification
	 * @return the agent notification, or <code>null</code> if a agent notification with the primary key could not be found
	 */
	public static AgentNotification fetchByPrimaryKey(
		long agentNotificationId) {

		return getPersistence().fetchByPrimaryKey(agentNotificationId);
	}

	/**
	 * Returns all the agent notifications.
	 *
	 * @return the agent notifications
	 */
	public static List<AgentNotification> findAll() {
		return getPersistence().findAll();
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
	public static List<AgentNotification> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<AgentNotification> findAll(
		int start, int end,
		OrderByComparator<AgentNotification> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<AgentNotification> findAll(
		int start, int end,
		OrderByComparator<AgentNotification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the agent notifications from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of agent notifications.
	 *
	 * @return the number of agent notifications
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AgentNotificationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AgentNotificationPersistence _persistence;

}