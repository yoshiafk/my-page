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
 * Provides a wrapper for {@link AgentMarkCalendarLocalService}.
 *
 * @author Gositus Team
 * @see AgentMarkCalendarLocalService
 * @generated
 */
public class AgentMarkCalendarLocalServiceWrapper
	implements AgentMarkCalendarLocalService,
			   ServiceWrapper<AgentMarkCalendarLocalService> {

	public AgentMarkCalendarLocalServiceWrapper(
		AgentMarkCalendarLocalService agentMarkCalendarLocalService) {

		_agentMarkCalendarLocalService = agentMarkCalendarLocalService;
	}

	/**
	 * Adds the agent mark calendar to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentMarkCalendarLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentMarkCalendar the agent mark calendar
	 * @return the agent mark calendar that was added
	 */
	@Override
	public com.mypage.agencyportal.model.AgentMarkCalendar addAgentMarkCalendar(
		com.mypage.agencyportal.model.AgentMarkCalendar agentMarkCalendar) {

		return _agentMarkCalendarLocalService.addAgentMarkCalendar(
			agentMarkCalendar);
	}

	@Override
	public com.mypage.agencyportal.model.AgentMarkCalendar addAgentMarkCalendar(
			long agentCalendarId, long mypageUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentMarkCalendarLocalService.addAgentMarkCalendar(
			agentCalendarId, mypageUserId);
	}

	/**
	 * Creates a new agent mark calendar with the primary key. Does not add the agent mark calendar to the database.
	 *
	 * @param agentMarkCalendarId the primary key for the new agent mark calendar
	 * @return the new agent mark calendar
	 */
	@Override
	public com.mypage.agencyportal.model.AgentMarkCalendar
		createAgentMarkCalendar(long agentMarkCalendarId) {

		return _agentMarkCalendarLocalService.createAgentMarkCalendar(
			agentMarkCalendarId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentMarkCalendarLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the agent mark calendar from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentMarkCalendarLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentMarkCalendar the agent mark calendar
	 * @return the agent mark calendar that was removed
	 */
	@Override
	public com.mypage.agencyportal.model.AgentMarkCalendar
		deleteAgentMarkCalendar(
			com.mypage.agencyportal.model.AgentMarkCalendar agentMarkCalendar) {

		return _agentMarkCalendarLocalService.deleteAgentMarkCalendar(
			agentMarkCalendar);
	}

	/**
	 * Deletes the agent mark calendar with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentMarkCalendarLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentMarkCalendarId the primary key of the agent mark calendar
	 * @return the agent mark calendar that was removed
	 * @throws PortalException if a agent mark calendar with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.AgentMarkCalendar
			deleteAgentMarkCalendar(long agentMarkCalendarId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentMarkCalendarLocalService.deleteAgentMarkCalendar(
			agentMarkCalendarId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentMarkCalendarLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _agentMarkCalendarLocalService.dynamicQuery();
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

		return _agentMarkCalendarLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentMarkCalendarModelImpl</code>.
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

		return _agentMarkCalendarLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentMarkCalendarModelImpl</code>.
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

		return _agentMarkCalendarLocalService.dynamicQuery(
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

		return _agentMarkCalendarLocalService.dynamicQueryCount(dynamicQuery);
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

		return _agentMarkCalendarLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.agencyportal.model.AgentMarkCalendar
		fetchAgentMarkCalendar(long agentMarkCalendarId) {

		return _agentMarkCalendarLocalService.fetchAgentMarkCalendar(
			agentMarkCalendarId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _agentMarkCalendarLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the agent mark calendar with the primary key.
	 *
	 * @param agentMarkCalendarId the primary key of the agent mark calendar
	 * @return the agent mark calendar
	 * @throws PortalException if a agent mark calendar with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.AgentMarkCalendar getAgentMarkCalendar(
			long agentMarkCalendarId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentMarkCalendarLocalService.getAgentMarkCalendar(
			agentMarkCalendarId);
	}

	/**
	 * Returns a range of all the agent mark calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentMarkCalendarModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent mark calendars
	 * @param end the upper bound of the range of agent mark calendars (not inclusive)
	 * @return the range of agent mark calendars
	 */
	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentMarkCalendar>
		getAgentMarkCalendars(int start, int end) {

		return _agentMarkCalendarLocalService.getAgentMarkCalendars(start, end);
	}

	/**
	 * Returns the number of agent mark calendars.
	 *
	 * @return the number of agent mark calendars
	 */
	@Override
	public int getAgentMarkCalendarsCount() {
		return _agentMarkCalendarLocalService.getAgentMarkCalendarsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _agentMarkCalendarLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _agentMarkCalendarLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentMarkCalendarLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the agent mark calendar in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentMarkCalendarLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentMarkCalendar the agent mark calendar
	 * @return the agent mark calendar that was updated
	 */
	@Override
	public com.mypage.agencyportal.model.AgentMarkCalendar
		updateAgentMarkCalendar(
			com.mypage.agencyportal.model.AgentMarkCalendar agentMarkCalendar) {

		return _agentMarkCalendarLocalService.updateAgentMarkCalendar(
			agentMarkCalendar);
	}

	@Override
	public AgentMarkCalendarLocalService getWrappedService() {
		return _agentMarkCalendarLocalService;
	}

	@Override
	public void setWrappedService(
		AgentMarkCalendarLocalService agentMarkCalendarLocalService) {

		_agentMarkCalendarLocalService = agentMarkCalendarLocalService;
	}

	private AgentMarkCalendarLocalService _agentMarkCalendarLocalService;

}