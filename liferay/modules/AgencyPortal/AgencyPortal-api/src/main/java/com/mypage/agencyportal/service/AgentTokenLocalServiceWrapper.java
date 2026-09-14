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
 * Provides a wrapper for {@link AgentTokenLocalService}.
 *
 * @author Gositus Team
 * @see AgentTokenLocalService
 * @generated
 */
public class AgentTokenLocalServiceWrapper
	implements AgentTokenLocalService, ServiceWrapper<AgentTokenLocalService> {

	public AgentTokenLocalServiceWrapper(
		AgentTokenLocalService agentTokenLocalService) {

		_agentTokenLocalService = agentTokenLocalService;
	}

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
	@Override
	public com.mypage.agencyportal.model.AgentToken addAgentToken(
		com.mypage.agencyportal.model.AgentToken agentToken) {

		return _agentTokenLocalService.addAgentToken(agentToken);
	}

	@Override
	public com.mypage.agencyportal.model.AgentToken addAgentToken(
		String deptCode, String token, int isValid) {

		return _agentTokenLocalService.addAgentToken(deptCode, token, isValid);
	}

	/**
	 * Creates a new agent token with the primary key. Does not add the agent token to the database.
	 *
	 * @param agentTokenId the primary key for the new agent token
	 * @return the new agent token
	 */
	@Override
	public com.mypage.agencyportal.model.AgentToken createAgentToken(
		long agentTokenId) {

		return _agentTokenLocalService.createAgentToken(agentTokenId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentTokenLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.mypage.agencyportal.model.AgentToken deleteAgentToken(
		com.mypage.agencyportal.model.AgentToken agentToken) {

		return _agentTokenLocalService.deleteAgentToken(agentToken);
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
	@Override
	public com.mypage.agencyportal.model.AgentToken deleteAgentToken(
			long agentTokenId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentTokenLocalService.deleteAgentToken(agentTokenId);
	}

	@Override
	public boolean deleteAgentTokenByDeptCode(String deptCode) {
		return _agentTokenLocalService.deleteAgentTokenByDeptCode(deptCode);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentTokenLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _agentTokenLocalService.dynamicQuery();
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

		return _agentTokenLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _agentTokenLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _agentTokenLocalService.dynamicQuery(
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

		return _agentTokenLocalService.dynamicQueryCount(dynamicQuery);
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

		return _agentTokenLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.agencyportal.model.AgentToken editAgentToken(
		long agentTokenId, String apiRequestToken,
		java.util.Date apiRequestTokenExpired) {

		return _agentTokenLocalService.editAgentToken(
			agentTokenId, apiRequestToken, apiRequestTokenExpired);
	}

	@Override
	public com.mypage.agencyportal.model.AgentToken editAgentToken(
		long agentTokenId, String deptCode, String token, int isValid) {

		return _agentTokenLocalService.editAgentToken(
			agentTokenId, deptCode, token, isValid);
	}

	@Override
	public com.mypage.agencyportal.model.AgentToken fetchAgentToken(
		long agentTokenId) {

		return _agentTokenLocalService.fetchAgentToken(agentTokenId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _agentTokenLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the agent token with the primary key.
	 *
	 * @param agentTokenId the primary key of the agent token
	 * @return the agent token
	 * @throws PortalException if a agent token with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.AgentToken getAgentToken(
			long agentTokenId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentTokenLocalService.getAgentToken(agentTokenId);
	}

	/**
	 * Get Agent Token by Request Token
	 */
	@Override
	public com.mypage.agencyportal.model.AgentToken
		getAgentTokenByApiRequestToken(String apiRequestToken) {

		return _agentTokenLocalService.getAgentTokenByApiRequestToken(
			apiRequestToken);
	}

	/**
	 * Get Agent Token
	 */
	@Override
	public com.mypage.agencyportal.model.AgentToken getAgentTokenByDeptCode(
		String deptCode) {

		return _agentTokenLocalService.getAgentTokenByDeptCode(deptCode);
	}

	/**
	 * Get Agent Token by Token
	 */
	@Override
	public com.mypage.agencyportal.model.AgentToken getAgentTokenByToken(
		String token) {

		return _agentTokenLocalService.getAgentTokenByToken(token);
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
	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentToken>
		getAgentTokens(int start, int end) {

		return _agentTokenLocalService.getAgentTokens(start, end);
	}

	/**
	 * Returns the number of agent tokens.
	 *
	 * @return the number of agent tokens
	 */
	@Override
	public int getAgentTokensCount() {
		return _agentTokenLocalService.getAgentTokensCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _agentTokenLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _agentTokenLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentTokenLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.agencyportal.model.AgentToken renewAgentToken(
		long agentTokenId) {

		return _agentTokenLocalService.renewAgentToken(agentTokenId);
	}

	@Override
	public boolean setAgentTokenToInvalid(long agentTokenId) {
		return _agentTokenLocalService.setAgentTokenToInvalid(agentTokenId);
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
	@Override
	public com.mypage.agencyportal.model.AgentToken updateAgentToken(
		com.mypage.agencyportal.model.AgentToken agentToken) {

		return _agentTokenLocalService.updateAgentToken(agentToken);
	}

	/**
	 * Verify render token and api request token
	 */
	@Override
	public com.mypage.agencyportal.model.AgentToken verifyToken(
		String renderToken, String apiRequestToken) {

		return _agentTokenLocalService.verifyToken(
			renderToken, apiRequestToken);
	}

	@Override
	public AgentTokenLocalService getWrappedService() {
		return _agentTokenLocalService;
	}

	@Override
	public void setWrappedService(
		AgentTokenLocalService agentTokenLocalService) {

		_agentTokenLocalService = agentTokenLocalService;
	}

	private AgentTokenLocalService _agentTokenLocalService;

}