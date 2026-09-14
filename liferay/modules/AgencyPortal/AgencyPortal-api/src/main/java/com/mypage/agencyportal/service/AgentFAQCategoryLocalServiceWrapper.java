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
 * Provides a wrapper for {@link AgentFAQCategoryLocalService}.
 *
 * @author Gositus Team
 * @see AgentFAQCategoryLocalService
 * @generated
 */
public class AgentFAQCategoryLocalServiceWrapper
	implements AgentFAQCategoryLocalService,
			   ServiceWrapper<AgentFAQCategoryLocalService> {

	public AgentFAQCategoryLocalServiceWrapper(
		AgentFAQCategoryLocalService agentFAQCategoryLocalService) {

		_agentFAQCategoryLocalService = agentFAQCategoryLocalService;
	}

	/**
	 * Adds the agent faq category to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentFAQCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentFAQCategory the agent faq category
	 * @return the agent faq category that was added
	 */
	@Override
	public com.mypage.agencyportal.model.AgentFAQCategory addAgentFAQCategory(
		com.mypage.agencyportal.model.AgentFAQCategory agentFAQCategory) {

		return _agentFAQCategoryLocalService.addAgentFAQCategory(
			agentFAQCategory);
	}

	@Override
	public com.mypage.agencyportal.model.AgentFAQCategory addFaqCategory(
			String category, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentFAQCategoryLocalService.addFaqCategory(category, active);
	}

	/**
	 * Creates a new agent faq category with the primary key. Does not add the agent faq category to the database.
	 *
	 * @param agentFaqCategoryId the primary key for the new agent faq category
	 * @return the new agent faq category
	 */
	@Override
	public com.mypage.agencyportal.model.AgentFAQCategory
		createAgentFAQCategory(long agentFaqCategoryId) {

		return _agentFAQCategoryLocalService.createAgentFAQCategory(
			agentFaqCategoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentFAQCategoryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the agent faq category from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentFAQCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentFAQCategory the agent faq category
	 * @return the agent faq category that was removed
	 */
	@Override
	public com.mypage.agencyportal.model.AgentFAQCategory
		deleteAgentFAQCategory(
			com.mypage.agencyportal.model.AgentFAQCategory agentFAQCategory) {

		return _agentFAQCategoryLocalService.deleteAgentFAQCategory(
			agentFAQCategory);
	}

	/**
	 * Deletes the agent faq category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentFAQCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentFaqCategoryId the primary key of the agent faq category
	 * @return the agent faq category that was removed
	 * @throws PortalException if a agent faq category with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.AgentFAQCategory
			deleteAgentFAQCategory(long agentFaqCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentFAQCategoryLocalService.deleteAgentFAQCategory(
			agentFaqCategoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentFAQCategoryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _agentFAQCategoryLocalService.dynamicQuery();
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

		return _agentFAQCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentFAQCategoryModelImpl</code>.
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

		return _agentFAQCategoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentFAQCategoryModelImpl</code>.
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

		return _agentFAQCategoryLocalService.dynamicQuery(
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

		return _agentFAQCategoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _agentFAQCategoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.agencyportal.model.AgentFAQCategory fetchAgentFAQCategory(
		long agentFaqCategoryId) {

		return _agentFAQCategoryLocalService.fetchAgentFAQCategory(
			agentFaqCategoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _agentFAQCategoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentFAQCategory>
		getActiveCategory() {

		return _agentFAQCategoryLocalService.getActiveCategory();
	}

	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentFAQCategory>
		getActiveCategoryInUse() {

		return _agentFAQCategoryLocalService.getActiveCategoryInUse();
	}

	/**
	 * Returns a range of all the agent faq categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentFAQCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent faq categories
	 * @param end the upper bound of the range of agent faq categories (not inclusive)
	 * @return the range of agent faq categories
	 */
	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentFAQCategory>
		getAgentFAQCategories(int start, int end) {

		return _agentFAQCategoryLocalService.getAgentFAQCategories(start, end);
	}

	/**
	 * Returns the number of agent faq categories.
	 *
	 * @return the number of agent faq categories
	 */
	@Override
	public int getAgentFAQCategoriesCount() {
		return _agentFAQCategoryLocalService.getAgentFAQCategoriesCount();
	}

	/**
	 * Returns the agent faq category with the primary key.
	 *
	 * @param agentFaqCategoryId the primary key of the agent faq category
	 * @return the agent faq category
	 * @throws PortalException if a agent faq category with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.AgentFAQCategory getAgentFAQCategory(
			long agentFaqCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentFAQCategoryLocalService.getAgentFAQCategory(
			agentFaqCategoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _agentFAQCategoryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _agentFAQCategoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentFAQCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.agencyportal.model.AgentFAQCategory setActive(
			long agentFaqCategoryId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentFAQCategoryLocalService.setActive(
			agentFaqCategoryId, active, serviceContext);
	}

	/**
	 * Updates the agent faq category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentFAQCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentFAQCategory the agent faq category
	 * @return the agent faq category that was updated
	 */
	@Override
	public com.mypage.agencyportal.model.AgentFAQCategory
		updateAgentFAQCategory(
			com.mypage.agencyportal.model.AgentFAQCategory agentFAQCategory) {

		return _agentFAQCategoryLocalService.updateAgentFAQCategory(
			agentFAQCategory);
	}

	@Override
	public com.mypage.agencyportal.model.AgentFAQCategory updateFaqCategory(
			long agentFaqCategoryId, String category, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentFAQCategoryLocalService.updateFaqCategory(
			agentFaqCategoryId, category, active);
	}

	@Override
	public AgentFAQCategoryLocalService getWrappedService() {
		return _agentFAQCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		AgentFAQCategoryLocalService agentFAQCategoryLocalService) {

		_agentFAQCategoryLocalService = agentFAQCategoryLocalService;
	}

	private AgentFAQCategoryLocalService _agentFAQCategoryLocalService;

}