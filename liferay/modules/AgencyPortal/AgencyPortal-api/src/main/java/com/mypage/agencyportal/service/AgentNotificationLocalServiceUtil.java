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

package com.mypage.agencyportal.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.agencyportal.model.AgentNotification;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AgentNotification. This utility wraps
 * <code>com.mypage.agencyportal.service.impl.AgentNotificationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see AgentNotificationLocalService
 * @generated
 */
public class AgentNotificationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.agencyportal.service.impl.AgentNotificationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the agent notification to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentNotificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentNotification the agent notification
	 * @return the agent notification that was added
	 */
	public static AgentNotification addAgentNotification(
		AgentNotification agentNotification) {

		return getService().addAgentNotification(agentNotification);
	}

	public static AgentNotification addNotification(
			String title, String location, String address, String description,
			String link, String category, long roleId, long groupId,
			long referenceId, String startDate, String startTime,
			String endDate, String endTime, String fileURL, long fileEntryId,
			int isAllDay, int active, long userId)
		throws java.text.ParseException, PortalException {

		return getService().addNotification(
			title, location, address, description, link, category, roleId,
			groupId, referenceId, startDate, startTime, endDate, endTime,
			fileURL, fileEntryId, isAllDay, active, userId);
	}

	/**
	 * Creates a new agent notification with the primary key. Does not add the agent notification to the database.
	 *
	 * @param agentNotificationId the primary key for the new agent notification
	 * @return the new agent notification
	 */
	public static AgentNotification createAgentNotification(
		long agentNotificationId) {

		return getService().createAgentNotification(agentNotificationId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the agent notification from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentNotificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentNotification the agent notification
	 * @return the agent notification that was removed
	 */
	public static AgentNotification deleteAgentNotification(
		AgentNotification agentNotification) {

		return getService().deleteAgentNotification(agentNotification);
	}

	/**
	 * Deletes the agent notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentNotificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentNotificationId the primary key of the agent notification
	 * @return the agent notification that was removed
	 * @throws PortalException if a agent notification with the primary key could not be found
	 */
	public static AgentNotification deleteAgentNotification(
			long agentNotificationId)
		throws PortalException {

		return getService().deleteAgentNotification(agentNotificationId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static AgentNotification fetchAgentNotification(
		long agentNotificationId) {

		return getService().fetchAgentNotification(agentNotificationId);
	}

	public static List<AgentNotification> findByFilter(
		int start, int end, long userId, long roleId, List<Long> groupId,
		List<String> category) {

		return getService().findByFilter(
			start, end, userId, roleId, groupId, category);
	}

	public static long findEndLicenseByYear(
		long userId, String category, int year) {

		return getService().findEndLicenseByYear(userId, category, year);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<AgentNotification> getActiveNotificationByRole(
		long userId, long roleId, List<Long> groupId, List<String> category) {

		return getService().getActiveNotificationByRole(
			userId, roleId, groupId, category);
	}

	/**
	 * Returns the agent notification with the primary key.
	 *
	 * @param agentNotificationId the primary key of the agent notification
	 * @return the agent notification
	 * @throws PortalException if a agent notification with the primary key could not be found
	 */
	public static AgentNotification getAgentNotification(
			long agentNotificationId)
		throws PortalException {

		return getService().getAgentNotification(agentNotificationId);
	}

	/**
	 * Returns a range of all the agent notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent notifications
	 * @param end the upper bound of the range of agent notifications (not inclusive)
	 * @return the range of agent notifications
	 */
	public static List<AgentNotification> getAgentNotifications(
		int start, int end) {

		return getService().getAgentNotifications(start, end);
	}

	/**
	 * Returns the number of agent notifications.
	 *
	 * @return the number of agent notifications
	 */
	public static int getAgentNotificationsCount() {
		return getService().getAgentNotificationsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static List<AgentNotification> getUnreadNotificationByRole(
		long userId, long roleId, List<Long> groupId) {

		return getService().getUnreadNotificationByRole(
			userId, roleId, groupId);
	}

	public static AgentNotification setActive(
			long agentNotificationId, long referenceId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			agentNotificationId, referenceId, active, serviceContext);
	}

	public static AgentNotification setIsRead(
			long notificationId, int isRead,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setIsRead(notificationId, isRead, serviceContext);
	}

	/**
	 * Updates the agent notification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentNotificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentNotification the agent notification
	 * @return the agent notification that was updated
	 */
	public static AgentNotification updateAgentNotification(
		AgentNotification agentNotification) {

		return getService().updateAgentNotification(agentNotification);
	}

	public static AgentNotification updateNotification(
			String title, String location, String address, String description,
			String link, String category, long roleId, long groupId,
			long referenceId, String startDate, String startTime,
			String endDate, String endTime, String fileURL, long fileEntryId,
			int isAllDay, int active)
		throws java.text.ParseException, PortalException {

		return getService().updateNotification(
			title, location, address, description, link, category, roleId,
			groupId, referenceId, startDate, startTime, endDate, endTime,
			fileURL, fileEntryId, isAllDay, active);
	}

	public static AgentNotification updateNotificationAdmin(
			long agentNotificationId, String title, String location,
			String address, String description, String link, String category,
			long roleId, long groupId, long referenceId, String startDate,
			String startTime, String endDate, String endTime, int isAllDay,
			int active)
		throws java.text.ParseException, PortalException {

		return getService().updateNotificationAdmin(
			agentNotificationId, title, location, address, description, link,
			category, roleId, groupId, referenceId, startDate, startTime,
			endDate, endTime, isAllDay, active);
	}

	public static AgentNotificationLocalService getService() {
		return _service;
	}

	private static volatile AgentNotificationLocalService _service;

}