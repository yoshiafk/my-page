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

import com.mypage.agencyportal.model.AgentCalendar;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AgentCalendar. This utility wraps
 * <code>com.mypage.agencyportal.service.impl.AgentCalendarLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see AgentCalendarLocalService
 * @generated
 */
public class AgentCalendarLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.agencyportal.service.impl.AgentCalendarLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static AgentCalendar addAgentCalendar(AgentCalendar agentCalendar) {
		return getService().addAgentCalendar(agentCalendar);
	}

	public static AgentCalendar addCalendar(
			String title, String location, String address, String description,
			String link, String category, long roleId, long groupId,
			String startDate, String startTime, String endDate, String endTime,
			String fileURL, long fileEntryId, int isAllDay, int active,
			long userId)
		throws java.text.ParseException, PortalException {

		return getService().addCalendar(
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
	public static AgentCalendar createAgentCalendar(long agentCalendarId) {
		return getService().createAgentCalendar(agentCalendarId);
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
	 * Deletes the agent calendar from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentCalendarLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentCalendar the agent calendar
	 * @return the agent calendar that was removed
	 */
	public static AgentCalendar deleteAgentCalendar(
		AgentCalendar agentCalendar) {

		return getService().deleteAgentCalendar(agentCalendar);
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
	public static AgentCalendar deleteAgentCalendar(long agentCalendarId)
		throws PortalException {

		return getService().deleteAgentCalendar(agentCalendarId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentCalendarModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentCalendarModelImpl</code>.
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

	public static AgentCalendar fetchAgentCalendar(long agentCalendarId) {
		return getService().fetchAgentCalendar(agentCalendarId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<AgentCalendar> getActiveCalendarByRole(
		long userId, long roleId, List<Long> groupId) {

		return getService().getActiveCalendarByRole(userId, roleId, groupId);
	}

	/**
	 * Returns the agent calendar with the primary key.
	 *
	 * @param agentCalendarId the primary key of the agent calendar
	 * @return the agent calendar
	 * @throws PortalException if a agent calendar with the primary key could not be found
	 */
	public static AgentCalendar getAgentCalendar(long agentCalendarId)
		throws PortalException {

		return getService().getAgentCalendar(agentCalendarId);
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
	public static List<AgentCalendar> getAgentCalendars(int start, int end) {
		return getService().getAgentCalendars(start, end);
	}

	/**
	 * Returns the number of agent calendars.
	 *
	 * @return the number of agent calendars
	 */
	public static int getAgentCalendarsCount() {
		return getService().getAgentCalendarsCount();
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

	public static AgentCalendar setActive(
			long agentCalendarId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(agentCalendarId, active, serviceContext);
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
	public static AgentCalendar updateAgentCalendar(
		AgentCalendar agentCalendar) {

		return getService().updateAgentCalendar(agentCalendar);
	}

	public static AgentCalendar updateCalendar(
			long agentCalendarId, String title, String location, String address,
			String description, String link, String category, long roleId,
			long groupId, String startDate, String startTime, String endDate,
			String endTime, String fileURL, long fileEntryId, int isAllDay,
			int active)
		throws java.text.ParseException, PortalException {

		return getService().updateCalendar(
			agentCalendarId, title, location, address, description, link,
			category, roleId, groupId, startDate, startTime, endDate, endTime,
			fileURL, fileEntryId, isAllDay, active);
	}

	public static AgentCalendarLocalService getService() {
		return _service;
	}

	private static volatile AgentCalendarLocalService _service;

}