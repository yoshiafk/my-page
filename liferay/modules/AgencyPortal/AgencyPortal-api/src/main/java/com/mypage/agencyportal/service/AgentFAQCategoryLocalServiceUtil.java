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

import com.mypage.agencyportal.model.AgentFAQCategory;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AgentFAQCategory. This utility wraps
 * <code>com.mypage.agencyportal.service.impl.AgentFAQCategoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see AgentFAQCategoryLocalService
 * @generated
 */
public class AgentFAQCategoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.agencyportal.service.impl.AgentFAQCategoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static AgentFAQCategory addAgentFAQCategory(
		AgentFAQCategory agentFAQCategory) {

		return getService().addAgentFAQCategory(agentFAQCategory);
	}

	public static AgentFAQCategory addFaqCategory(String category, int active)
		throws PortalException {

		return getService().addFaqCategory(category, active);
	}

	/**
	 * Creates a new agent faq category with the primary key. Does not add the agent faq category to the database.
	 *
	 * @param agentFaqCategoryId the primary key for the new agent faq category
	 * @return the new agent faq category
	 */
	public static AgentFAQCategory createAgentFAQCategory(
		long agentFaqCategoryId) {

		return getService().createAgentFAQCategory(agentFaqCategoryId);
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
	 * Deletes the agent faq category from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentFAQCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentFAQCategory the agent faq category
	 * @return the agent faq category that was removed
	 */
	public static AgentFAQCategory deleteAgentFAQCategory(
		AgentFAQCategory agentFAQCategory) {

		return getService().deleteAgentFAQCategory(agentFAQCategory);
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
	public static AgentFAQCategory deleteAgentFAQCategory(
			long agentFaqCategoryId)
		throws PortalException {

		return getService().deleteAgentFAQCategory(agentFaqCategoryId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentFAQCategoryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentFAQCategoryModelImpl</code>.
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

	public static AgentFAQCategory fetchAgentFAQCategory(
		long agentFaqCategoryId) {

		return getService().fetchAgentFAQCategory(agentFaqCategoryId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<AgentFAQCategory> getActiveCategory() {
		return getService().getActiveCategory();
	}

	public static List<AgentFAQCategory> getActiveCategoryInUse() {
		return getService().getActiveCategoryInUse();
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
	public static List<AgentFAQCategory> getAgentFAQCategories(
		int start, int end) {

		return getService().getAgentFAQCategories(start, end);
	}

	/**
	 * Returns the number of agent faq categories.
	 *
	 * @return the number of agent faq categories
	 */
	public static int getAgentFAQCategoriesCount() {
		return getService().getAgentFAQCategoriesCount();
	}

	/**
	 * Returns the agent faq category with the primary key.
	 *
	 * @param agentFaqCategoryId the primary key of the agent faq category
	 * @return the agent faq category
	 * @throws PortalException if a agent faq category with the primary key could not be found
	 */
	public static AgentFAQCategory getAgentFAQCategory(long agentFaqCategoryId)
		throws PortalException {

		return getService().getAgentFAQCategory(agentFaqCategoryId);
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

	public static AgentFAQCategory setActive(
			long agentFaqCategoryId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
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
	public static AgentFAQCategory updateAgentFAQCategory(
		AgentFAQCategory agentFAQCategory) {

		return getService().updateAgentFAQCategory(agentFAQCategory);
	}

	public static AgentFAQCategory updateFaqCategory(
			long agentFaqCategoryId, String category, int active)
		throws PortalException {

		return getService().updateFaqCategory(
			agentFaqCategoryId, category, active);
	}

	public static AgentFAQCategoryLocalService getService() {
		return _service;
	}

	private static volatile AgentFAQCategoryLocalService _service;

}