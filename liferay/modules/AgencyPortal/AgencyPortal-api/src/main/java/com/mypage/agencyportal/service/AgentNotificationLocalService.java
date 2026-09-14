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

import com.mypage.agencyportal.model.AgentNotification;

import java.io.Serializable;

import java.text.ParseException;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for AgentNotification. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Gositus Team
 * @see AgentNotificationLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AgentNotificationLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.mypage.agencyportal.service.impl.AgentNotificationLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the agent notification local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AgentNotificationLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public AgentNotification addAgentNotification(
		AgentNotification agentNotification);

	public AgentNotification addNotification(
			String title, String location, String address, String description,
			String link, String category, long roleId, long groupId,
			long referenceId, String startDate, String startTime,
			String endDate, String endTime, String fileURL, long fileEntryId,
			int isAllDay, int active, long userId)
		throws ParseException, PortalException;

	/**
	 * Creates a new agent notification with the primary key. Does not add the agent notification to the database.
	 *
	 * @param agentNotificationId the primary key for the new agent notification
	 * @return the new agent notification
	 */
	@Transactional(enabled = false)
	public AgentNotification createAgentNotification(long agentNotificationId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public AgentNotification deleteAgentNotification(
		AgentNotification agentNotification);

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
	@Indexable(type = IndexableType.DELETE)
	public AgentNotification deleteAgentNotification(long agentNotificationId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentNotificationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentNotificationModelImpl</code>.
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
	public AgentNotification fetchAgentNotification(long agentNotificationId);

	public List<AgentNotification> findByFilter(
		int start, int end, long userId, long roleId, List<Long> groupId,
		List<String> category);

	public long findEndLicenseByYear(long userId, String category, int year);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AgentNotification> getActiveNotificationByRole(
		long userId, long roleId, List<Long> groupId, List<String> category);

	/**
	 * Returns the agent notification with the primary key.
	 *
	 * @param agentNotificationId the primary key of the agent notification
	 * @return the agent notification
	 * @throws PortalException if a agent notification with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AgentNotification getAgentNotification(long agentNotificationId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AgentNotification> getAgentNotifications(int start, int end);

	/**
	 * Returns the number of agent notifications.
	 *
	 * @return the number of agent notifications
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAgentNotificationsCount();

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AgentNotification> getUnreadNotificationByRole(
		long userId, long roleId, List<Long> groupId);

	public AgentNotification setActive(
			long agentNotificationId, long referenceId, int active,
			ServiceContext serviceContext)
		throws PortalException;

	public AgentNotification setIsRead(
			long notificationId, int isRead, ServiceContext serviceContext)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public AgentNotification updateAgentNotification(
		AgentNotification agentNotification);

	public AgentNotification updateNotification(
			String title, String location, String address, String description,
			String link, String category, long roleId, long groupId,
			long referenceId, String startDate, String startTime,
			String endDate, String endTime, String fileURL, long fileEntryId,
			int isAllDay, int active)
		throws ParseException, PortalException;

	public AgentNotification updateNotificationAdmin(
			long agentNotificationId, String title, String location,
			String address, String description, String link, String category,
			long roleId, long groupId, long referenceId, String startDate,
			String startTime, String endDate, String endTime, int isAllDay,
			int active)
		throws ParseException, PortalException;

}