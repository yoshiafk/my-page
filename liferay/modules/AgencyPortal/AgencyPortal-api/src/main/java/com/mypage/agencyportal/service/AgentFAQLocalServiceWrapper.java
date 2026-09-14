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
 * Provides a wrapper for {@link AgentFAQLocalService}.
 *
 * @author Gositus Team
 * @see AgentFAQLocalService
 * @generated
 */
public class AgentFAQLocalServiceWrapper
	implements AgentFAQLocalService, ServiceWrapper<AgentFAQLocalService> {

	public AgentFAQLocalServiceWrapper(
		AgentFAQLocalService agentFAQLocalService) {

		_agentFAQLocalService = agentFAQLocalService;
	}

	/**
	 * Adds the agent faq to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentFAQLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentFAQ the agent faq
	 * @return the agent faq that was added
	 */
	@Override
	public com.mypage.agencyportal.model.AgentFAQ addAgentFAQ(
		com.mypage.agencyportal.model.AgentFAQ agentFAQ) {

		return _agentFAQLocalService.addAgentFAQ(agentFAQ);
	}

	@Override
	public com.mypage.agencyportal.model.AgentFAQ addFaq(
			String title, String description, int categoryId, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentFAQLocalService.addFaq(
			title, description, categoryId, active);
	}

	/**
	 * Creates a new agent faq with the primary key. Does not add the agent faq to the database.
	 *
	 * @param agentFaqId the primary key for the new agent faq
	 * @return the new agent faq
	 */
	@Override
	public com.mypage.agencyportal.model.AgentFAQ createAgentFAQ(
		long agentFaqId) {

		return _agentFAQLocalService.createAgentFAQ(agentFaqId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentFAQLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the agent faq from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentFAQLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentFAQ the agent faq
	 * @return the agent faq that was removed
	 */
	@Override
	public com.mypage.agencyportal.model.AgentFAQ deleteAgentFAQ(
		com.mypage.agencyportal.model.AgentFAQ agentFAQ) {

		return _agentFAQLocalService.deleteAgentFAQ(agentFAQ);
	}

	/**
	 * Deletes the agent faq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentFAQLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentFaqId the primary key of the agent faq
	 * @return the agent faq that was removed
	 * @throws PortalException if a agent faq with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.AgentFAQ deleteAgentFAQ(
			long agentFaqId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentFAQLocalService.deleteAgentFAQ(agentFaqId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentFAQLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _agentFAQLocalService.dynamicQuery();
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

		return _agentFAQLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentFAQModelImpl</code>.
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

		return _agentFAQLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentFAQModelImpl</code>.
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

		return _agentFAQLocalService.dynamicQuery(
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

		return _agentFAQLocalService.dynamicQueryCount(dynamicQuery);
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

		return _agentFAQLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.agencyportal.model.AgentFAQ fetchAgentFAQ(
		long agentFaqId) {

		return _agentFAQLocalService.fetchAgentFAQ(agentFaqId);
	}

	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentFAQ>
		findByCategory(String category) {

		return _agentFAQLocalService.findByCategory(category);
	}

	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentFAQ> findByFilter(
		int start, int end, String title, String category) {

		return _agentFAQLocalService.findByFilter(start, end, title, category);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _agentFAQLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the agent faq with the primary key.
	 *
	 * @param agentFaqId the primary key of the agent faq
	 * @return the agent faq
	 * @throws PortalException if a agent faq with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.AgentFAQ getAgentFAQ(long agentFaqId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentFAQLocalService.getAgentFAQ(agentFaqId);
	}

	/**
	 * Returns a range of all the agent faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentFAQModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent faqs
	 * @param end the upper bound of the range of agent faqs (not inclusive)
	 * @return the range of agent faqs
	 */
	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentFAQ> getAgentFAQs(
		int start, int end) {

		return _agentFAQLocalService.getAgentFAQs(start, end);
	}

	/**
	 * Returns the number of agent faqs.
	 *
	 * @return the number of agent faqs
	 */
	@Override
	public int getAgentFAQsCount() {
		return _agentFAQLocalService.getAgentFAQsCount();
	}

	@Override
	public int getCountByFilter(String title, String category, long roleId) {
		return _agentFAQLocalService.getCountByFilter(title, category, roleId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _agentFAQLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _agentFAQLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentFAQLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.agencyportal.model.AgentFAQ setActive(
			long agentFaqId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentFAQLocalService.setActive(
			agentFaqId, active, serviceContext);
	}

	/**
	 * Updates the agent faq in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentFAQLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentFAQ the agent faq
	 * @return the agent faq that was updated
	 */
	@Override
	public com.mypage.agencyportal.model.AgentFAQ updateAgentFAQ(
		com.mypage.agencyportal.model.AgentFAQ agentFAQ) {

		return _agentFAQLocalService.updateAgentFAQ(agentFAQ);
	}

	@Override
	public com.mypage.agencyportal.model.AgentFAQ updateFaq(
			long agentFaqId, String title, String description, int categoryId,
			int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentFAQLocalService.updateFaq(
			agentFaqId, title, description, categoryId, active);
	}

	@Override
	public AgentFAQLocalService getWrappedService() {
		return _agentFAQLocalService;
	}

	@Override
	public void setWrappedService(AgentFAQLocalService agentFAQLocalService) {
		_agentFAQLocalService = agentFAQLocalService;
	}

	private AgentFAQLocalService _agentFAQLocalService;

}