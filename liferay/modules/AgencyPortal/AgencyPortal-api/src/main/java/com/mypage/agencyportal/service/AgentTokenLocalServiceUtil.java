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

import com.mypage.agencyportal.model.AgentToken;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AgentToken. This utility wraps
 * <code>com.mypage.agencyportal.service.impl.AgentTokenLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see AgentTokenLocalService
 * @generated
 */
public class AgentTokenLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.agencyportal.service.impl.AgentTokenLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the agent token to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentTokenLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentToken the agent token
	 * @return the agent token that was added
	 */
	public static AgentToken addAgentToken(AgentToken agentToken) {
		return getService().addAgentToken(agentToken);
	}

	public static AgentToken addAgentToken(
		String deptCode, String token, int isValid) {

		return getService().addAgentToken(deptCode, token, isValid);
	}

	/**
	 * Creates a new agent token with the primary key. Does not add the agent token to the database.
	 *
	 * @param agentTokenId the primary key for the new agent token
	 * @return the new agent token
	 */
	public static AgentToken createAgentToken(long agentTokenId) {
		return getService().createAgentToken(agentTokenId);
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
	 * Deletes the agent token from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentTokenLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentToken the agent token
	 * @return the agent token that was removed
	 */
	public static AgentToken deleteAgentToken(AgentToken agentToken) {
		return getService().deleteAgentToken(agentToken);
	}

	/**
	 * Deletes the agent token with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentTokenLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentTokenId the primary key of the agent token
	 * @return the agent token that was removed
	 * @throws PortalException if a agent token with the primary key could not be found
	 */
	public static AgentToken deleteAgentToken(long agentTokenId)
		throws PortalException {

		return getService().deleteAgentToken(agentTokenId);
	}

	public static boolean deleteAgentTokenByDeptCode(String deptCode) {
		return getService().deleteAgentTokenByDeptCode(deptCode);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentTokenModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentTokenModelImpl</code>.
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

	public static AgentToken editAgentToken(
		long agentTokenId, String apiRequestToken,
		java.util.Date apiRequestTokenExpired) {

		return getService().editAgentToken(
			agentTokenId, apiRequestToken, apiRequestTokenExpired);
	}

	public static AgentToken editAgentToken(
		long agentTokenId, String deptCode, String token, int isValid) {

		return getService().editAgentToken(
			agentTokenId, deptCode, token, isValid);
	}

	public static AgentToken fetchAgentToken(long agentTokenId) {
		return getService().fetchAgentToken(agentTokenId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the agent token with the primary key.
	 *
	 * @param agentTokenId the primary key of the agent token
	 * @return the agent token
	 * @throws PortalException if a agent token with the primary key could not be found
	 */
	public static AgentToken getAgentToken(long agentTokenId)
		throws PortalException {

		return getService().getAgentToken(agentTokenId);
	}

	/**
	 * Get Agent Token by Request Token
	 */
	public static AgentToken getAgentTokenByApiRequestToken(
		String apiRequestToken) {

		return getService().getAgentTokenByApiRequestToken(apiRequestToken);
	}

	/**
	 * Get Agent Token
	 */
	public static AgentToken getAgentTokenByDeptCode(String deptCode) {
		return getService().getAgentTokenByDeptCode(deptCode);
	}

	/**
	 * Get Agent Token by Token
	 */
	public static AgentToken getAgentTokenByToken(String token) {
		return getService().getAgentTokenByToken(token);
	}

	/**
	 * Returns a range of all the agent tokens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentTokenModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent tokens
	 * @param end the upper bound of the range of agent tokens (not inclusive)
	 * @return the range of agent tokens
	 */
	public static List<AgentToken> getAgentTokens(int start, int end) {
		return getService().getAgentTokens(start, end);
	}

	/**
	 * Returns the number of agent tokens.
	 *
	 * @return the number of agent tokens
	 */
	public static int getAgentTokensCount() {
		return getService().getAgentTokensCount();
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

	public static AgentToken renewAgentToken(long agentTokenId) {
		return getService().renewAgentToken(agentTokenId);
	}

	public static boolean setAgentTokenToInvalid(long agentTokenId) {
		return getService().setAgentTokenToInvalid(agentTokenId);
	}

	/**
	 * Updates the agent token in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentTokenLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentToken the agent token
	 * @return the agent token that was updated
	 */
	public static AgentToken updateAgentToken(AgentToken agentToken) {
		return getService().updateAgentToken(agentToken);
	}

	/**
	 * Verify render token and api request token
	 */
	public static AgentToken verifyToken(
		String renderToken, String apiRequestToken) {

		return getService().verifyToken(renderToken, apiRequestToken);
	}

	public static AgentTokenLocalService getService() {
		return _service;
	}

	private static volatile AgentTokenLocalService _service;

}