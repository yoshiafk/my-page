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
 * Provides a wrapper for {@link AgentCalendarLocalService}.
 *
 * @author Gositus Team
 * @see AgentCalendarLocalService
 * @generated
 */
public class AgentCalendarLocalServiceWrapper
	implements AgentCalendarLocalService,
			   ServiceWrapper<AgentCalendarLocalService> {

	public AgentCalendarLocalServiceWrapper(
		AgentCalendarLocalService agentCalendarLocalService) {

		_agentCalendarLocalService = agentCalendarLocalService;
	}

	/**
	 * Adds the agent calendar to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentCalendarLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentCalendar the agent calendar
	 * @return the agent calendar that was added
	 */
	@Override
	public com.mypage.agencyportal.model.AgentCalendar addAgentCalendar(
		com.mypage.agencyportal.model.AgentCalendar agentCalendar) {

		return _agentCalendarLocalService.addAgentCalendar(agentCalendar);
	}

	@Override
	public com.mypage.agencyportal.model.AgentCalendar addCalendar(
			String title, String location, String address, String description,
			String link, String category, long roleId, long groupId,
			String startDate, String startTime, String endDate, String endTime,
			String fileURL, long fileEntryId, int isAllDay, int active,
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.text.ParseException {

		return _agentCalendarLocalService.addCalendar(
			title, location, address, description, link, category, roleId,
			groupId, startDate, startTime, endDate, endTime, fileURL,
			fileEntryId, isAllDay, active, userId);
	}

	/**
	 * Creates a new agent calendar with the primary key. Does not add the agent calendar to the database.
	 *
	 * @param agentCalendarId the primary key for the new agent calendar
	 * @return the new agent calendar
	 */
	@Override
	public com.mypage.agencyportal.model.AgentCalendar createAgentCalendar(
		long agentCalendarId) {

		return _agentCalendarLocalService.createAgentCalendar(agentCalendarId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentCalendarLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the agent calendar from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentCalendarLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentCalendar the agent calendar
	 * @return the agent calendar that was removed
	 */
	@Override
	public com.mypage.agencyportal.model.AgentCalendar deleteAgentCalendar(
		com.mypage.agencyportal.model.AgentCalendar agentCalendar) {

		return _agentCalendarLocalService.deleteAgentCalendar(agentCalendar);
	}

	/**
	 * Deletes the agent calendar with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentCalendarLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentCalendarId the primary key of the agent calendar
	 * @return the agent calendar that was removed
	 * @throws PortalException if a agent calendar with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.AgentCalendar deleteAgentCalendar(
			long agentCalendarId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentCalendarLocalService.deleteAgentCalendar(agentCalendarId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentCalendarLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _agentCalendarLocalService.dynamicQuery();
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

		return _agentCalendarLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentCalendarModelImpl</code>.
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

		return _agentCalendarLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentCalendarModelImpl</code>.
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

		return _agentCalendarLocalService.dynamicQuery(
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

		return _agentCalendarLocalService.dynamicQueryCount(dynamicQuery);
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

		return _agentCalendarLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.agencyportal.model.AgentCalendar fetchAgentCalendar(
		long agentCalendarId) {

		return _agentCalendarLocalService.fetchAgentCalendar(agentCalendarId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _agentCalendarLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentCalendar>
		getActiveCalendarByRole(
			long userId, long roleId, java.util.List<Long> groupId) {

		return _agentCalendarLocalService.getActiveCalendarByRole(
			userId, roleId, groupId);
	}

	/**
	 * Returns the agent calendar with the primary key.
	 *
	 * @param agentCalendarId the primary key of the agent calendar
	 * @return the agent calendar
	 * @throws PortalException if a agent calendar with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.AgentCalendar getAgentCalendar(
			long agentCalendarId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentCalendarLocalService.getAgentCalendar(agentCalendarId);
	}

	/**
	 * Returns a range of all the agent calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent calendars
	 * @param end the upper bound of the range of agent calendars (not inclusive)
	 * @return the range of agent calendars
	 */
	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentCalendar>
		getAgentCalendars(int start, int end) {

		return _agentCalendarLocalService.getAgentCalendars(start, end);
	}

	/**
	 * Returns the number of agent calendars.
	 *
	 * @return the number of agent calendars
	 */
	@Override
	public int getAgentCalendarsCount() {
		return _agentCalendarLocalService.getAgentCalendarsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _agentCalendarLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _agentCalendarLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentCalendarLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.agencyportal.model.AgentCalendar setActive(
			long agentCalendarId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentCalendarLocalService.setActive(
			agentCalendarId, active, serviceContext);
	}

	/**
	 * Updates the agent calendar in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentCalendarLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentCalendar the agent calendar
	 * @return the agent calendar that was updated
	 */
	@Override
	public com.mypage.agencyportal.model.AgentCalendar updateAgentCalendar(
		com.mypage.agencyportal.model.AgentCalendar agentCalendar) {

		return _agentCalendarLocalService.updateAgentCalendar(agentCalendar);
	}

	@Override
	public com.mypage.agencyportal.model.AgentCalendar updateCalendar(
			long agentCalendarId, String title, String location, String address,
			String description, String link, String category, long roleId,
			long groupId, String startDate, String startTime, String endDate,
			String endTime, String fileURL, long fileEntryId, int isAllDay,
			int active)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.text.ParseException {

		return _agentCalendarLocalService.updateCalendar(
			agentCalendarId, title, location, address, description, link,
			category, roleId, groupId, startDate, startTime, endDate, endTime,
			fileURL, fileEntryId, isAllDay, active);
	}

	@Override
	public AgentCalendarLocalService getWrappedService() {
		return _agentCalendarLocalService;
	}

	@Override
	public void setWrappedService(
		AgentCalendarLocalService agentCalendarLocalService) {

		_agentCalendarLocalService = agentCalendarLocalService;
	}

	private AgentCalendarLocalService _agentCalendarLocalService;

}