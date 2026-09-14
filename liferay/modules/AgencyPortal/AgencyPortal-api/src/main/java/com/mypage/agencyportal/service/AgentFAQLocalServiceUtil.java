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

import com.mypage.agencyportal.model.AgentFAQ;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AgentFAQ. This utility wraps
 * <code>com.mypage.agencyportal.service.impl.AgentFAQLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see AgentFAQLocalService
 * @generated
 */
public class AgentFAQLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.agencyportal.service.impl.AgentFAQLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static AgentFAQ addAgentFAQ(AgentFAQ agentFAQ) {
		return getService().addAgentFAQ(agentFAQ);
	}

	public static AgentFAQ addFaq(
			String title, String description, int categoryId, int active)
		throws PortalException {

		return getService().addFaq(title, description, categoryId, active);
	}

	/**
	 * Creates a new agent faq with the primary key. Does not add the agent faq to the database.
	 *
	 * @param agentFaqId the primary key for the new agent faq
	 * @return the new agent faq
	 */
	public static AgentFAQ createAgentFAQ(long agentFaqId) {
		return getService().createAgentFAQ(agentFaqId);
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
	 * Deletes the agent faq from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentFAQLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentFAQ the agent faq
	 * @return the agent faq that was removed
	 */
	public static AgentFAQ deleteAgentFAQ(AgentFAQ agentFAQ) {
		return getService().deleteAgentFAQ(agentFAQ);
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
	public static AgentFAQ deleteAgentFAQ(long agentFaqId)
		throws PortalException {

		return getService().deleteAgentFAQ(agentFaqId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentFAQModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentFAQModelImpl</code>.
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

	public static AgentFAQ fetchAgentFAQ(long agentFaqId) {
		return getService().fetchAgentFAQ(agentFaqId);
	}

	public static List<AgentFAQ> findByCategory(String category) {
		return getService().findByCategory(category);
	}

	public static List<AgentFAQ> findByFilter(
		int start, int end, String title, String category) {

		return getService().findByFilter(start, end, title, category);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the agent faq with the primary key.
	 *
	 * @param agentFaqId the primary key of the agent faq
	 * @return the agent faq
	 * @throws PortalException if a agent faq with the primary key could not be found
	 */
	public static AgentFAQ getAgentFAQ(long agentFaqId) throws PortalException {
		return getService().getAgentFAQ(agentFaqId);
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
	public static List<AgentFAQ> getAgentFAQs(int start, int end) {
		return getService().getAgentFAQs(start, end);
	}

	/**
	 * Returns the number of agent faqs.
	 *
	 * @return the number of agent faqs
	 */
	public static int getAgentFAQsCount() {
		return getService().getAgentFAQsCount();
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

	public static AgentFAQ setActive(
			long agentFaqId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(agentFaqId, active, serviceContext);
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
	public static AgentFAQ updateAgentFAQ(AgentFAQ agentFAQ) {
		return getService().updateAgentFAQ(agentFAQ);
	}

	public static AgentFAQ updateFaq(
			long agentFaqId, String title, String description, int categoryId,
			int active)
		throws PortalException {

		return getService().updateFaq(
			agentFaqId, title, description, categoryId, active);
	}

	public static AgentFAQLocalService getService() {
		return _service;
	}

	private static volatile AgentFAQLocalService _service;

}