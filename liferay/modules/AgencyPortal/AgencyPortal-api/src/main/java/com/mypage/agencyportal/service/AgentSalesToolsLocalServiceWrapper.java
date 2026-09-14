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
 * Provides a wrapper for {@link AgentSalesToolsLocalService}.
 *
 * @author Gositus Team
 * @see AgentSalesToolsLocalService
 * @generated
 */
public class AgentSalesToolsLocalServiceWrapper
	implements AgentSalesToolsLocalService,
			   ServiceWrapper<AgentSalesToolsLocalService> {

	public AgentSalesToolsLocalServiceWrapper(
		AgentSalesToolsLocalService agentSalesToolsLocalService) {

		_agentSalesToolsLocalService = agentSalesToolsLocalService;
	}

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
	@Override
	public com.mypage.agencyportal.model.AgentSalesTools addAgentSalesTools(
		com.mypage.agencyportal.model.AgentSalesTools agentSalesTools) {

		return _agentSalesToolsLocalService.addAgentSalesTools(agentSalesTools);
	}

	@Override
	public com.mypage.agencyportal.model.AgentSalesTools addSalesTools(
			String title, String description, int categoryId, String fileURL,
			long fileEntryId, int roleId, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentSalesToolsLocalService.addSalesTools(
			title, description, categoryId, fileURL, fileEntryId, roleId,
			active);
	}

	/**
	 * Creates a new agent sales tools with the primary key. Does not add the agent sales tools to the database.
	 *
	 * @param agentSalesToolsId the primary key for the new agent sales tools
	 * @return the new agent sales tools
	 */
	@Override
	public com.mypage.agencyportal.model.AgentSalesTools createAgentSalesTools(
		long agentSalesToolsId) {

		return _agentSalesToolsLocalService.createAgentSalesTools(
			agentSalesToolsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentSalesToolsLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.mypage.agencyportal.model.AgentSalesTools deleteAgentSalesTools(
		com.mypage.agencyportal.model.AgentSalesTools agentSalesTools) {

		return _agentSalesToolsLocalService.deleteAgentSalesTools(
			agentSalesTools);
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
	@Override
	public com.mypage.agencyportal.model.AgentSalesTools deleteAgentSalesTools(
			long agentSalesToolsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentSalesToolsLocalService.deleteAgentSalesTools(
			agentSalesToolsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentSalesToolsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _agentSalesToolsLocalService.dynamicQuery();
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

		return _agentSalesToolsLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _agentSalesToolsLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _agentSalesToolsLocalService.dynamicQuery(
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

		return _agentSalesToolsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _agentSalesToolsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.agencyportal.model.AgentSalesTools fetchAgentSalesTools(
		long agentSalesToolsId) {

		return _agentSalesToolsLocalService.fetchAgentSalesTools(
			agentSalesToolsId);
	}

	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentSalesTools>
		findByFilter(
			int start, int end, String title, String category, long roleId) {

		return _agentSalesToolsLocalService.findByFilter(
			start, end, title, category, roleId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _agentSalesToolsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the agent sales tools with the primary key.
	 *
	 * @param agentSalesToolsId the primary key of the agent sales tools
	 * @return the agent sales tools
	 * @throws PortalException if a agent sales tools with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.AgentSalesTools getAgentSalesTools(
			long agentSalesToolsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentSalesToolsLocalService.getAgentSalesTools(
			agentSalesToolsId);
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
	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentSalesTools>
		getAgentSalesToolses(int start, int end) {

		return _agentSalesToolsLocalService.getAgentSalesToolses(start, end);
	}

	/**
	 * Returns the number of agent sales toolses.
	 *
	 * @return the number of agent sales toolses
	 */
	@Override
	public int getAgentSalesToolsesCount() {
		return _agentSalesToolsLocalService.getAgentSalesToolsesCount();
	}

	@Override
	public int getCountByFilter(String title, String category, long roleId) {
		return _agentSalesToolsLocalService.getCountByFilter(
			title, category, roleId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _agentSalesToolsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _agentSalesToolsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentSalesToolsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.agencyportal.model.AgentSalesTools setActive(
			long agentSalesToolsId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentSalesToolsLocalService.setActive(
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
	@Override
	public com.mypage.agencyportal.model.AgentSalesTools updateAgentSalesTools(
		com.mypage.agencyportal.model.AgentSalesTools agentSalesTools) {

		return _agentSalesToolsLocalService.updateAgentSalesTools(
			agentSalesTools);
	}

	@Override
	public com.mypage.agencyportal.model.AgentSalesTools updateSalesTools(
			long agentSalesToolsId, String title, String description,
			int categoryId, String fileURL, long fileEntryId, int roleId,
			int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentSalesToolsLocalService.updateSalesTools(
			agentSalesToolsId, title, description, categoryId, fileURL,
			fileEntryId, roleId, active);
	}

	@Override
	public AgentSalesToolsLocalService getWrappedService() {
		return _agentSalesToolsLocalService;
	}

	@Override
	public void setWrappedService(
		AgentSalesToolsLocalService agentSalesToolsLocalService) {

		_agentSalesToolsLocalService = agentSalesToolsLocalService;
	}

	private AgentSalesToolsLocalService _agentSalesToolsLocalService;

}