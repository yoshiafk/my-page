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
 * Provides a wrapper for {@link AgentCategorySalesToolsLocalService}.
 *
 * @author Gositus Team
 * @see AgentCategorySalesToolsLocalService
 * @generated
 */
public class AgentCategorySalesToolsLocalServiceWrapper
	implements AgentCategorySalesToolsLocalService,
			   ServiceWrapper<AgentCategorySalesToolsLocalService> {

	public AgentCategorySalesToolsLocalServiceWrapper(
		AgentCategorySalesToolsLocalService
			agentCategorySalesToolsLocalService) {

		_agentCategorySalesToolsLocalService =
			agentCategorySalesToolsLocalService;
	}

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
	@Override
	public com.mypage.agencyportal.model.AgentCategorySalesTools
		addAgentCategorySalesTools(
			com.mypage.agencyportal.model.AgentCategorySalesTools
				agentCategorySalesTools) {

		return _agentCategorySalesToolsLocalService.addAgentCategorySalesTools(
			agentCategorySalesTools);
	}

	@Override
	public com.mypage.agencyportal.model.AgentCategorySalesTools
			addCategorySalesTools(String category, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentCategorySalesToolsLocalService.addCategorySalesTools(
			category, active);
	}

	/**
	 * Creates a new agent category sales tools with the primary key. Does not add the agent category sales tools to the database.
	 *
	 * @param agentCategorySalesToolsId the primary key for the new agent category sales tools
	 * @return the new agent category sales tools
	 */
	@Override
	public com.mypage.agencyportal.model.AgentCategorySalesTools
		createAgentCategorySalesTools(long agentCategorySalesToolsId) {

		return _agentCategorySalesToolsLocalService.
			createAgentCategorySalesTools(agentCategorySalesToolsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentCategorySalesToolsLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.mypage.agencyportal.model.AgentCategorySalesTools
		deleteAgentCategorySalesTools(
			com.mypage.agencyportal.model.AgentCategorySalesTools
				agentCategorySalesTools) {

		return _agentCategorySalesToolsLocalService.
			deleteAgentCategorySalesTools(agentCategorySalesTools);
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
	@Override
	public com.mypage.agencyportal.model.AgentCategorySalesTools
			deleteAgentCategorySalesTools(long agentCategorySalesToolsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentCategorySalesToolsLocalService.
			deleteAgentCategorySalesTools(agentCategorySalesToolsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentCategorySalesToolsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _agentCategorySalesToolsLocalService.dynamicQuery();
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

		return _agentCategorySalesToolsLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _agentCategorySalesToolsLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _agentCategorySalesToolsLocalService.dynamicQuery(
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

		return _agentCategorySalesToolsLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _agentCategorySalesToolsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.agencyportal.model.AgentCategorySalesTools
		fetchAgentCategorySalesTools(long agentCategorySalesToolsId) {

		return _agentCategorySalesToolsLocalService.
			fetchAgentCategorySalesTools(agentCategorySalesToolsId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _agentCategorySalesToolsLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentCategorySalesTools>
		getActiveCategory() {

		return _agentCategorySalesToolsLocalService.getActiveCategory();
	}

	/**
	 * Returns the agent category sales tools with the primary key.
	 *
	 * @param agentCategorySalesToolsId the primary key of the agent category sales tools
	 * @return the agent category sales tools
	 * @throws PortalException if a agent category sales tools with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.AgentCategorySalesTools
			getAgentCategorySalesTools(long agentCategorySalesToolsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentCategorySalesToolsLocalService.getAgentCategorySalesTools(
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
	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentCategorySalesTools>
		getAgentCategorySalesToolses(int start, int end) {

		return _agentCategorySalesToolsLocalService.
			getAgentCategorySalesToolses(start, end);
	}

	/**
	 * Returns the number of agent category sales toolses.
	 *
	 * @return the number of agent category sales toolses
	 */
	@Override
	public int getAgentCategorySalesToolsesCount() {
		return _agentCategorySalesToolsLocalService.
			getAgentCategorySalesToolsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _agentCategorySalesToolsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _agentCategorySalesToolsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentCategorySalesToolsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public com.mypage.agencyportal.model.AgentCategorySalesTools setActive(
			long agentCategorySalesToolsId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentCategorySalesToolsLocalService.setActive(
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
	@Override
	public com.mypage.agencyportal.model.AgentCategorySalesTools
		updateAgentCategorySalesTools(
			com.mypage.agencyportal.model.AgentCategorySalesTools
				agentCategorySalesTools) {

		return _agentCategorySalesToolsLocalService.
			updateAgentCategorySalesTools(agentCategorySalesTools);
	}

	@Override
	public com.mypage.agencyportal.model.AgentCategorySalesTools
			updateCategorySalesTools(
				long agentCategorySalesToolsId, String category, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentCategorySalesToolsLocalService.updateCategorySalesTools(
			agentCategorySalesToolsId, category, active);
	}

	@Override
	public AgentCategorySalesToolsLocalService getWrappedService() {
		return _agentCategorySalesToolsLocalService;
	}

	@Override
	public void setWrappedService(
		AgentCategorySalesToolsLocalService
			agentCategorySalesToolsLocalService) {

		_agentCategorySalesToolsLocalService =
			agentCategorySalesToolsLocalService;
	}

	private AgentCategorySalesToolsLocalService
		_agentCategorySalesToolsLocalService;

}