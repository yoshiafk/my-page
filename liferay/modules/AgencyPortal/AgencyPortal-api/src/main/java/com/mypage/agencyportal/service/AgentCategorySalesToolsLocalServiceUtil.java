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

import com.mypage.agencyportal.model.AgentCategorySalesTools;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AgentCategorySalesTools. This utility wraps
 * <code>com.mypage.agencyportal.service.impl.AgentCategorySalesToolsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see AgentCategorySalesToolsLocalService
 * @generated
 */
public class AgentCategorySalesToolsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.agencyportal.service.impl.AgentCategorySalesToolsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the agent category sales tools to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentCategorySalesToolsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentCategorySalesTools the agent category sales tools
	 * @return the agent category sales tools that was added
	 */
	public static AgentCategorySalesTools addAgentCategorySalesTools(
		AgentCategorySalesTools agentCategorySalesTools) {

		return getService().addAgentCategorySalesTools(agentCategorySalesTools);
	}

	public static AgentCategorySalesTools addCategorySalesTools(
			String category, int active)
		throws PortalException {

		return getService().addCategorySalesTools(category, active);
	}

	/**
	 * Creates a new agent category sales tools with the primary key. Does not add the agent category sales tools to the database.
	 *
	 * @param agentCategorySalesToolsId the primary key for the new agent category sales tools
	 * @return the new agent category sales tools
	 */
	public static AgentCategorySalesTools createAgentCategorySalesTools(
		long agentCategorySalesToolsId) {

		return getService().createAgentCategorySalesTools(
			agentCategorySalesToolsId);
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
	 * Deletes the agent category sales tools from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentCategorySalesToolsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentCategorySalesTools the agent category sales tools
	 * @return the agent category sales tools that was removed
	 */
	public static AgentCategorySalesTools deleteAgentCategorySalesTools(
		AgentCategorySalesTools agentCategorySalesTools) {

		return getService().deleteAgentCategorySalesTools(
			agentCategorySalesTools);
	}

	/**
	 * Deletes the agent category sales tools with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentCategorySalesToolsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentCategorySalesToolsId the primary key of the agent category sales tools
	 * @return the agent category sales tools that was removed
	 * @throws PortalException if a agent category sales tools with the primary key could not be found
	 */
	public static AgentCategorySalesTools deleteAgentCategorySalesTools(
			long agentCategorySalesToolsId)
		throws PortalException {

		return getService().deleteAgentCategorySalesTools(
			agentCategorySalesToolsId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentCategorySalesToolsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentCategorySalesToolsModelImpl</code>.
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

	public static AgentCategorySalesTools fetchAgentCategorySalesTools(
		long agentCategorySalesToolsId) {

		return getService().fetchAgentCategorySalesTools(
			agentCategorySalesToolsId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<AgentCategorySalesTools> getActiveCategory() {
		return getService().getActiveCategory();
	}

	/**
	 * Returns the agent category sales tools with the primary key.
	 *
	 * @param agentCategorySalesToolsId the primary key of the agent category sales tools
	 * @return the agent category sales tools
	 * @throws PortalException if a agent category sales tools with the primary key could not be found
	 */
	public static AgentCategorySalesTools getAgentCategorySalesTools(
			long agentCategorySalesToolsId)
		throws PortalException {

		return getService().getAgentCategorySalesTools(
			agentCategorySalesToolsId);
	}

	/**
	 * Returns a range of all the agent category sales toolses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentCategorySalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent category sales toolses
	 * @param end the upper bound of the range of agent category sales toolses (not inclusive)
	 * @return the range of agent category sales toolses
	 */
	public static List<AgentCategorySalesTools> getAgentCategorySalesToolses(
		int start, int end) {

		return getService().getAgentCategorySalesToolses(start, end);
	}

	/**
	 * Returns the number of agent category sales toolses.
	 *
	 * @return the number of agent category sales toolses
	 */
	public static int getAgentCategorySalesToolsesCount() {
		return getService().getAgentCategorySalesToolsesCount();
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

	public static AgentCategorySalesTools setActive(
			long agentCategorySalesToolsId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			agentCategorySalesToolsId, active, serviceContext);
	}

	/**
	 * Updates the agent category sales tools in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentCategorySalesToolsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentCategorySalesTools the agent category sales tools
	 * @return the agent category sales tools that was updated
	 */
	public static AgentCategorySalesTools updateAgentCategorySalesTools(
		AgentCategorySalesTools agentCategorySalesTools) {

		return getService().updateAgentCategorySalesTools(
			agentCategorySalesTools);
	}

	public static AgentCategorySalesTools updateCategorySalesTools(
			long agentCategorySalesToolsId, String category, int active)
		throws PortalException {

		return getService().updateCategorySalesTools(
			agentCategorySalesToolsId, category, active);
	}

	public static AgentCategorySalesToolsLocalService getService() {
		return _service;
	}

	private static volatile AgentCategorySalesToolsLocalService _service;

}