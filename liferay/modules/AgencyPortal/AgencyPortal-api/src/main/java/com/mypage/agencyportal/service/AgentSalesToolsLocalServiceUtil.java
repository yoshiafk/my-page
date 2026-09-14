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

import com.mypage.agencyportal.model.AgentSalesTools;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AgentSalesTools. This utility wraps
 * <code>com.mypage.agencyportal.service.impl.AgentSalesToolsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see AgentSalesToolsLocalService
 * @generated
 */
public class AgentSalesToolsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.agencyportal.service.impl.AgentSalesToolsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the agent sales tools to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentSalesToolsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentSalesTools the agent sales tools
	 * @return the agent sales tools that was added
	 */
	public static AgentSalesTools addAgentSalesTools(
		AgentSalesTools agentSalesTools) {

		return getService().addAgentSalesTools(agentSalesTools);
	}

	public static AgentSalesTools addSalesTools(
			String title, String description, int categoryId, String fileURL,
			long fileEntryId, int roleId, int active)
		throws PortalException {

		return getService().addSalesTools(
			title, description, categoryId, fileURL, fileEntryId, roleId,
			active);
	}

	/**
	 * Creates a new agent sales tools with the primary key. Does not add the agent sales tools to the database.
	 *
	 * @param agentSalesToolsId the primary key for the new agent sales tools
	 * @return the new agent sales tools
	 */
	public static AgentSalesTools createAgentSalesTools(
		long agentSalesToolsId) {

		return getService().createAgentSalesTools(agentSalesToolsId);
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
	 * Deletes the agent sales tools from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentSalesToolsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentSalesTools the agent sales tools
	 * @return the agent sales tools that was removed
	 */
	public static AgentSalesTools deleteAgentSalesTools(
		AgentSalesTools agentSalesTools) {

		return getService().deleteAgentSalesTools(agentSalesTools);
	}

	/**
	 * Deletes the agent sales tools with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentSalesToolsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentSalesToolsId the primary key of the agent sales tools
	 * @return the agent sales tools that was removed
	 * @throws PortalException if a agent sales tools with the primary key could not be found
	 */
	public static AgentSalesTools deleteAgentSalesTools(long agentSalesToolsId)
		throws PortalException {

		return getService().deleteAgentSalesTools(agentSalesToolsId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentSalesToolsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentSalesToolsModelImpl</code>.
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

	public static AgentSalesTools fetchAgentSalesTools(long agentSalesToolsId) {
		return getService().fetchAgentSalesTools(agentSalesToolsId);
	}

	public static List<AgentSalesTools> findByFilter(
		int start, int end, String title, String category, long roleId) {

		return getService().findByFilter(start, end, title, category, roleId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the agent sales tools with the primary key.
	 *
	 * @param agentSalesToolsId the primary key of the agent sales tools
	 * @return the agent sales tools
	 * @throws PortalException if a agent sales tools with the primary key could not be found
	 */
	public static AgentSalesTools getAgentSalesTools(long agentSalesToolsId)
		throws PortalException {

		return getService().getAgentSalesTools(agentSalesToolsId);
	}

	/**
	 * Returns a range of all the agent sales toolses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @return the range of agent sales toolses
	 */
	public static List<AgentSalesTools> getAgentSalesToolses(
		int start, int end) {

		return getService().getAgentSalesToolses(start, end);
	}

	/**
	 * Returns the number of agent sales toolses.
	 *
	 * @return the number of agent sales toolses
	 */
	public static int getAgentSalesToolsesCount() {
		return getService().getAgentSalesToolsesCount();
	}

	public static int getCountByFilter(
		String title, String category, long roleId) {

		return getService().getCountByFilter(title, category, roleId);
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

	public static AgentSalesTools setActive(
			long agentSalesToolsId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			agentSalesToolsId, active, serviceContext);
	}

	/**
	 * Updates the agent sales tools in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentSalesToolsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentSalesTools the agent sales tools
	 * @return the agent sales tools that was updated
	 */
	public static AgentSalesTools updateAgentSalesTools(
		AgentSalesTools agentSalesTools) {

		return getService().updateAgentSalesTools(agentSalesTools);
	}

	public static AgentSalesTools updateSalesTools(
			long agentSalesToolsId, String title, String description,
			int categoryId, String fileURL, long fileEntryId, int roleId,
			int active)
		throws PortalException {

		return getService().updateSalesTools(
			agentSalesToolsId, title, description, categoryId, fileURL,
			fileEntryId, roleId, active);
	}

	public static AgentSalesToolsLocalService getService() {
		return _service;
	}

	private static volatile AgentSalesToolsLocalService _service;

}