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

import com.mypage.agencyportal.exception.NoSuchAgentNotificationException;
import com.mypage.agencyportal.model.AgentNotification;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the agent notification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentNotificationUtil
 * @generated
 */
@ProviderType
public interface AgentNotificationPersistence
	extends BasePersistence<AgentNotification> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AgentNotificationUtil} to access the agent notification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the agent notifications where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching agent notifications
	 */
	public java.util.List<AgentNotification> findBytitle(String title);

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
	public java.util.List<AgentNotification> findBytitle(
		String title, int start, int end);

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
	public java.util.List<AgentNotification> findBytitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

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
	public java.util.List<AgentNotification> findBytitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first agent notification in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public AgentNotification findBytitle_First(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Returns the first agent notification in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public AgentNotification fetchBytitle_First(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

	/**
	 * Returns the last agent notification in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public AgentNotification findBytitle_Last(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Returns the last agent notification in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public AgentNotification fetchBytitle_Last(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

	/**
	 * Returns the agent notifications before and after the current agent notification in the ordered set where title = &#63;.
	 *
	 * @param agentNotificationId the primary key of the current agent notification
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent notification
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	public AgentNotification[] findBytitle_PrevAndNext(
			long agentNotificationId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Removes all the agent notifications where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public void removeBytitle(String title);

	/**
	 * Returns the number of agent notifications where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching agent notifications
	 */
	public int countBytitle(String title);

	/**
	 * Returns all the agent notifications where location = &#63;.
	 *
	 * @param location the location
	 * @return the matching agent notifications
	 */
	public java.util.List<AgentNotification> findBylocation(String location);

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
	public java.util.List<AgentNotification> findBylocation(
		String location, int start, int end);

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
	public java.util.List<AgentNotification> findBylocation(
		String location, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

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
	public java.util.List<AgentNotification> findBylocation(
		String location, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first agent notification in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public AgentNotification findBylocation_First(
			String location,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Returns the first agent notification in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public AgentNotification fetchBylocation_First(
		String location,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

	/**
	 * Returns the last agent notification in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public AgentNotification findBylocation_Last(
			String location,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Returns the last agent notification in the ordered set where location = &#63;.
	 *
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public AgentNotification fetchBylocation_Last(
		String location,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

	/**
	 * Returns the agent notifications before and after the current agent notification in the ordered set where location = &#63;.
	 *
	 * @param agentNotificationId the primary key of the current agent notification
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent notification
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	public AgentNotification[] findBylocation_PrevAndNext(
			long agentNotificationId, String location,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Removes all the agent notifications where location = &#63; from the database.
	 *
	 * @param location the location
	 */
	public void removeBylocation(String location);

	/**
	 * Returns the number of agent notifications where location = &#63;.
	 *
	 * @param location the location
	 * @return the number of matching agent notifications
	 */
	public int countBylocation(String location);

	/**
	 * Returns all the agent notifications where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching agent notifications
	 */
	public java.util.List<AgentNotification> findBymypageUserId(
		long mypageUserId);

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
	public java.util.List<AgentNotification> findBymypageUserId(
		long mypageUserId, int start, int end);

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
	public java.util.List<AgentNotification> findBymypageUserId(
		long mypageUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

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
	public java.util.List<AgentNotification> findBymypageUserId(
		long mypageUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first agent notification in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public AgentNotification findBymypageUserId_First(
			long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Returns the first agent notification in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public AgentNotification fetchBymypageUserId_First(
		long mypageUserId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

	/**
	 * Returns the last agent notification in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public AgentNotification findBymypageUserId_Last(
			long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Returns the last agent notification in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public AgentNotification fetchBymypageUserId_Last(
		long mypageUserId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

	/**
	 * Returns the agent notifications before and after the current agent notification in the ordered set where mypageUserId = &#63;.
	 *
	 * @param agentNotificationId the primary key of the current agent notification
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent notification
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	public AgentNotification[] findBymypageUserId_PrevAndNext(
			long agentNotificationId, long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Removes all the agent notifications where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	public void removeBymypageUserId(long mypageUserId);

	/**
	 * Returns the number of agent notifications where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching agent notifications
	 */
	public int countBymypageUserId(long mypageUserId);

	/**
	 * Returns all the agent notifications where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the matching agent notifications
	 */
	public java.util.List<AgentNotification> findBymypageUserRoleId(
		long mypageUserRoleId);

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
	public java.util.List<AgentNotification> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end);

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
	public java.util.List<AgentNotification> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

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
	public java.util.List<AgentNotification> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first agent notification in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public AgentNotification findBymypageUserRoleId_First(
			long mypageUserRoleId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Returns the first agent notification in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public AgentNotification fetchBymypageUserRoleId_First(
		long mypageUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

	/**
	 * Returns the last agent notification in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public AgentNotification findBymypageUserRoleId_Last(
			long mypageUserRoleId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Returns the last agent notification in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public AgentNotification fetchBymypageUserRoleId_Last(
		long mypageUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

	/**
	 * Returns the agent notifications before and after the current agent notification in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param agentNotificationId the primary key of the current agent notification
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent notification
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	public AgentNotification[] findBymypageUserRoleId_PrevAndNext(
			long agentNotificationId, long mypageUserRoleId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Removes all the agent notifications where mypageUserRoleId = &#63; from the database.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 */
	public void removeBymypageUserRoleId(long mypageUserRoleId);

	/**
	 * Returns the number of agent notifications where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the number of matching agent notifications
	 */
	public int countBymypageUserRoleId(long mypageUserRoleId);

	/**
	 * Returns all the agent notifications where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @return the matching agent notifications
	 */
	public java.util.List<AgentNotification> findBymypageUserGroupId(
		long mypageUserGroupId);

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
	public java.util.List<AgentNotification> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end);

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
	public java.util.List<AgentNotification> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

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
	public java.util.List<AgentNotification> findBymypageUserGroupId(
		long mypageUserGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first agent notification in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public AgentNotification findBymypageUserGroupId_First(
			long mypageUserGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Returns the first agent notification in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public AgentNotification fetchBymypageUserGroupId_First(
		long mypageUserGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

	/**
	 * Returns the last agent notification in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public AgentNotification findBymypageUserGroupId_Last(
			long mypageUserGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Returns the last agent notification in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public AgentNotification fetchBymypageUserGroupId_Last(
		long mypageUserGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

	/**
	 * Returns the agent notifications before and after the current agent notification in the ordered set where mypageUserGroupId = &#63;.
	 *
	 * @param agentNotificationId the primary key of the current agent notification
	 * @param mypageUserGroupId the mypage user group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent notification
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	public AgentNotification[] findBymypageUserGroupId_PrevAndNext(
			long agentNotificationId, long mypageUserGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Removes all the agent notifications where mypageUserGroupId = &#63; from the database.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 */
	public void removeBymypageUserGroupId(long mypageUserGroupId);

	/**
	 * Returns the number of agent notifications where mypageUserGroupId = &#63;.
	 *
	 * @param mypageUserGroupId the mypage user group ID
	 * @return the number of matching agent notifications
	 */
	public int countBymypageUserGroupId(long mypageUserGroupId);

	/**
	 * Returns all the agent notifications where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @return the matching agent notifications
	 */
	public java.util.List<AgentNotification> findByreferenceId(
		long referenceId);

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
	public java.util.List<AgentNotification> findByreferenceId(
		long referenceId, int start, int end);

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
	public java.util.List<AgentNotification> findByreferenceId(
		long referenceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

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
	public java.util.List<AgentNotification> findByreferenceId(
		long referenceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first agent notification in the ordered set where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public AgentNotification findByreferenceId_First(
			long referenceId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Returns the first agent notification in the ordered set where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public AgentNotification fetchByreferenceId_First(
		long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

	/**
	 * Returns the last agent notification in the ordered set where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification
	 * @throws NoSuchAgentNotificationException if a matching agent notification could not be found
	 */
	public AgentNotification findByreferenceId_Last(
			long referenceId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Returns the last agent notification in the ordered set where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent notification, or <code>null</code> if a matching agent notification could not be found
	 */
	public AgentNotification fetchByreferenceId_Last(
		long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

	/**
	 * Returns the agent notifications before and after the current agent notification in the ordered set where referenceId = &#63;.
	 *
	 * @param agentNotificationId the primary key of the current agent notification
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent notification
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	public AgentNotification[] findByreferenceId_PrevAndNext(
			long agentNotificationId, long referenceId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
				orderByComparator)
		throws NoSuchAgentNotificationException;

	/**
	 * Removes all the agent notifications where referenceId = &#63; from the database.
	 *
	 * @param referenceId the reference ID
	 */
	public void removeByreferenceId(long referenceId);

	/**
	 * Returns the number of agent notifications where referenceId = &#63;.
	 *
	 * @param referenceId the reference ID
	 * @return the number of matching agent notifications
	 */
	public int countByreferenceId(long referenceId);

	/**
	 * Caches the agent notification in the entity cache if it is enabled.
	 *
	 * @param agentNotification the agent notification
	 */
	public void cacheResult(AgentNotification agentNotification);

	/**
	 * Caches the agent notifications in the entity cache if it is enabled.
	 *
	 * @param agentNotifications the agent notifications
	 */
	public void cacheResult(
		java.util.List<AgentNotification> agentNotifications);

	/**
	 * Creates a new agent notification with the primary key. Does not add the agent notification to the database.
	 *
	 * @param agentNotificationId the primary key for the new agent notification
	 * @return the new agent notification
	 */
	public AgentNotification create(long agentNotificationId);

	/**
	 * Removes the agent notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentNotificationId the primary key of the agent notification
	 * @return the agent notification that was removed
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	public AgentNotification remove(long agentNotificationId)
		throws NoSuchAgentNotificationException;

	public AgentNotification updateImpl(AgentNotification agentNotification);

	/**
	 * Returns the agent notification with the primary key or throws a <code>NoSuchAgentNotificationException</code> if it could not be found.
	 *
	 * @param agentNotificationId the primary key of the agent notification
	 * @return the agent notification
	 * @throws NoSuchAgentNotificationException if a agent notification with the primary key could not be found
	 */
	public AgentNotification findByPrimaryKey(long agentNotificationId)
		throws NoSuchAgentNotificationException;

	/**
	 * Returns the agent notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentNotificationId the primary key of the agent notification
	 * @return the agent notification, or <code>null</code> if a agent notification with the primary key could not be found
	 */
	public AgentNotification fetchByPrimaryKey(long agentNotificationId);

	/**
	 * Returns all the agent notifications.
	 *
	 * @return the agent notifications
	 */
	public java.util.List<AgentNotification> findAll();

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
	public java.util.List<AgentNotification> findAll(int start, int end);

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
	public java.util.List<AgentNotification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator);

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
	public java.util.List<AgentNotification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentNotification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the agent notifications from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of agent notifications.
	 *
	 * @return the number of agent notifications
	 */
	public int countAll();

}