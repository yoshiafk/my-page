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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AgentNotificationLocalService}.
 *
 * @author Gositus Team
 * @see AgentNotificationLocalService
 * @generated
 */
public class AgentNotificationLocalServiceWrapper
	implements AgentNotificationLocalService,
			   ServiceWrapper<AgentNotificationLocalService> {

	public AgentNotificationLocalServiceWrapper(
		AgentNotificationLocalService agentNotificationLocalService) {

		_agentNotificationLocalService = agentNotificationLocalService;
	}

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
	@Override
	public com.mypage.agencyportal.model.AgentNotification addAgentNotification(
		com.mypage.agencyportal.model.AgentNotification agentNotification) {

		return _agentNotificationLocalService.addAgentNotification(
			agentNotification);
	}

	@Override
	public com.mypage.agencyportal.model.AgentNotification addNotification(
			String title, String location, String address, String description,
			String link, String category, long roleId, long groupId,
			long referenceId, String startDate, String startTime,
			String endDate, String endTime, String fileURL, long fileEntryId,
			int isAllDay, int active, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.text.ParseException {

		return _agentNotificationLocalService.addNotification(
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
	@Override
	public com.mypage.agencyportal.model.AgentNotification
		createAgentNotification(long agentNotificationId) {

		return _agentNotificationLocalService.createAgentNotification(
			agentNotificationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentNotificationLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.mypage.agencyportal.model.AgentNotification
		deleteAgentNotification(
			com.mypage.agencyportal.model.AgentNotification agentNotification) {

		return _agentNotificationLocalService.deleteAgentNotification(
			agentNotification);
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
	@Override
	public com.mypage.agencyportal.model.AgentNotification
			deleteAgentNotification(long agentNotificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentNotificationLocalService.deleteAgentNotification(
			agentNotificationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentNotificationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _agentNotificationLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _agentNotificationLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _agentNotificationLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _agentNotificationLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _agentNotificationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _agentNotificationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.agencyportal.model.AgentNotification
		fetchAgentNotification(long agentNotificationId) {

		return _agentNotificationLocalService.fetchAgentNotification(
			agentNotificationId);
	}

	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentNotification>
		findByFilter(
			int start, int end, long userId, long roleId,
			java.util.List<Long> groupId, java.util.List<String> category) {

		return _agentNotificationLocalService.findByFilter(
			start, end, userId, roleId, groupId, category);
	}

	@Override
	public long findEndLicenseByYear(long userId, String category, int year) {
		return _agentNotificationLocalService.findEndLicenseByYear(
			userId, category, year);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _agentNotificationLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentNotification>
		getActiveNotificationByRole(
			long userId, long roleId, java.util.List<Long> groupId,
			java.util.List<String> category) {

		return _agentNotificationLocalService.getActiveNotificationByRole(
			userId, roleId, groupId, category);
	}

	/**
	 * Returns the agent notification with the primary key.
	 *
	 * @param agentNotificationId the primary key of the agent notification
	 * @return the agent notification
	 * @throws PortalException if a agent notification with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.AgentNotification getAgentNotification(
			long agentNotificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentNotificationLocalService.getAgentNotification(
			agentNotificationId);
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
	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentNotification>
		getAgentNotifications(int start, int end) {

		return _agentNotificationLocalService.getAgentNotifications(start, end);
	}

	/**
	 * Returns the number of agent notifications.
	 *
	 * @return the number of agent notifications
	 */
	@Override
	public int getAgentNotificationsCount() {
		return _agentNotificationLocalService.getAgentNotificationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _agentNotificationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _agentNotificationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentNotificationLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentNotification>
		getUnreadNotificationByRole(
			long userId, long roleId, java.util.List<Long> groupId) {

		return _agentNotificationLocalService.getUnreadNotificationByRole(
			userId, roleId, groupId);
	}

	@Override
	public com.mypage.agencyportal.model.AgentNotification setActive(
			long agentNotificationId, long referenceId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentNotificationLocalService.setActive(
			agentNotificationId, referenceId, active, serviceContext);
	}

	@Override
	public com.mypage.agencyportal.model.AgentNotification setIsRead(
			long notificationId, int isRead,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentNotificationLocalService.setIsRead(
			notificationId, isRead, serviceContext);
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
	@Override
	public com.mypage.agencyportal.model.AgentNotification
		updateAgentNotification(
			com.mypage.agencyportal.model.AgentNotification agentNotification) {

		return _agentNotificationLocalService.updateAgentNotification(
			agentNotification);
	}

	@Override
	public com.mypage.agencyportal.model.AgentNotification updateNotification(
			String title, String location, String address, String description,
			String link, String category, long roleId, long groupId,
			long referenceId, String startDate, String startTime,
			String endDate, String endTime, String fileURL, long fileEntryId,
			int isAllDay, int active)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.text.ParseException {

		return _agentNotificationLocalService.updateNotification(
			title, location, address, description, link, category, roleId,
			groupId, referenceId, startDate, startTime, endDate, endTime,
			fileURL, fileEntryId, isAllDay, active);
	}

	@Override
	public com.mypage.agencyportal.model.AgentNotification
			updateNotificationAdmin(
				long agentNotificationId, String title, String location,
				String address, String description, String link,
				String category, long roleId, long groupId, long referenceId,
				String startDate, String startTime, String endDate,
				String endTime, int isAllDay, int active)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.text.ParseException {

		return _agentNotificationLocalService.updateNotificationAdmin(
			agentNotificationId, title, location, address, description, link,
			category, roleId, groupId, referenceId, startDate, startTime,
			endDate, endTime, isAllDay, active);
	}

	@Override
	public AgentNotificationLocalService getWrappedService() {
		return _agentNotificationLocalService;
	}

	@Override
	public void setWrappedService(
		AgentNotificationLocalService agentNotificationLocalService) {

		_agentNotificationLocalService = agentNotificationLocalService;
	}

	private AgentNotificationLocalService _agentNotificationLocalService;

}