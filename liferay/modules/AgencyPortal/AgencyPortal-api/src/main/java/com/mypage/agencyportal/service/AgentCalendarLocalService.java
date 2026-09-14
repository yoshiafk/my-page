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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.agencyportal.model.AgentCalendar;

import java.io.Serializable;

import java.text.ParseException;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for AgentCalendar. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Gositus Team
 * @see AgentCalendarLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AgentCalendarLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.mypage.agencyportal.service.impl.AgentCalendarLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the agent calendar local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AgentCalendarLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public AgentCalendar addAgentCalendar(AgentCalendar agentCalendar);

	public AgentCalendar addCalendar(
			String title, String location, String address, String description,
			String link, String category, long roleId, long groupId,
			String startDate, String startTime, String endDate, String endTime,
			String fileURL, long fileEntryId, int isAllDay, int active,
			long userId)
		throws ParseException, PortalException;

	/**
	 * Creates a new agent calendar with the primary key. Does not add the agent calendar to the database.
	 *
	 * @param agentCalendarId the primary key for the new agent calendar
	 * @return the new agent calendar
	 */
	@Transactional(enabled = false)
	public AgentCalendar createAgentCalendar(long agentCalendarId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public AgentCalendar deleteAgentCalendar(AgentCalendar agentCalendar);

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
	@Indexable(type = IndexableType.DELETE)
	public AgentCalendar deleteAgentCalendar(long agentCalendarId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AgentCalendar fetchAgentCalendar(long agentCalendarId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AgentCalendar> getActiveCalendarByRole(
		long userId, long roleId, List<Long> groupId);

	/**
	 * Returns the agent calendar with the primary key.
	 *
	 * @param agentCalendarId the primary key of the agent calendar
	 * @return the agent calendar
	 * @throws PortalException if a agent calendar with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AgentCalendar getAgentCalendar(long agentCalendarId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AgentCalendar> getAgentCalendars(int start, int end);

	/**
	 * Returns the number of agent calendars.
	 *
	 * @return the number of agent calendars
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAgentCalendarsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public AgentCalendar setActive(
			long agentCalendarId, int active, ServiceContext serviceContext)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public AgentCalendar updateAgentCalendar(AgentCalendar agentCalendar);

	public AgentCalendar updateCalendar(
			long agentCalendarId, String title, String location, String address,
			String description, String link, String category, long roleId,
			long groupId, String startDate, String startTime, String endDate,
			String endTime, String fileURL, long fileEntryId, int isAllDay,
			int active)
		throws ParseException, PortalException;

}