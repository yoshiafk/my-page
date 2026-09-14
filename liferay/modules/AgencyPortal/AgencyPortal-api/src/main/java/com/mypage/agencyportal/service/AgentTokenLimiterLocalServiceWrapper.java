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
 * Provides a wrapper for {@link AgentTokenLimiterLocalService}.
 *
 * @author Gositus Team
 * @see AgentTokenLimiterLocalService
 * @generated
 */
public class AgentTokenLimiterLocalServiceWrapper
	implements AgentTokenLimiterLocalService,
			   ServiceWrapper<AgentTokenLimiterLocalService> {

	public AgentTokenLimiterLocalServiceWrapper(
		AgentTokenLimiterLocalService agentTokenLimiterLocalService) {

		_agentTokenLimiterLocalService = agentTokenLimiterLocalService;
	}

	/**
	 * Adds the agent token limiter to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentTokenLimiterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentTokenLimiter the agent token limiter
	 * @return the agent token limiter that was added
	 */
	@Override
	public com.mypage.agencyportal.model.AgentTokenLimiter addAgentTokenLimiter(
		com.mypage.agencyportal.model.AgentTokenLimiter agentTokenLimiter) {

		return _agentTokenLimiterLocalService.addAgentTokenLimiter(
			agentTokenLimiter);
	}

	@Override
	public com.mypage.agencyportal.model.AgentTokenLimiter addAgentTokenLimiter(
		String deptCode, String token, String tokenType, int isValid) {

		return _agentTokenLimiterLocalService.addAgentTokenLimiter(
			deptCode, token, tokenType, isValid);
	}

	/**
	 * Creates a new agent token limiter with the primary key. Does not add the agent token limiter to the database.
	 *
	 * @param agentTokenLimiterId the primary key for the new agent token limiter
	 * @return the new agent token limiter
	 */
	@Override
	public com.mypage.agencyportal.model.AgentTokenLimiter
		createAgentTokenLimiter(long agentTokenLimiterId) {

		return _agentTokenLimiterLocalService.createAgentTokenLimiter(
			agentTokenLimiterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentTokenLimiterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the agent token limiter from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentTokenLimiterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentTokenLimiter the agent token limiter
	 * @return the agent token limiter that was removed
	 */
	@Override
	public com.mypage.agencyportal.model.AgentTokenLimiter
		deleteAgentTokenLimiter(
			com.mypage.agencyportal.model.AgentTokenLimiter agentTokenLimiter) {

		return _agentTokenLimiterLocalService.deleteAgentTokenLimiter(
			agentTokenLimiter);
	}

	/**
	 * Deletes the agent token limiter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentTokenLimiterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentTokenLimiterId the primary key of the agent token limiter
	 * @return the agent token limiter that was removed
	 * @throws PortalException if a agent token limiter with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.AgentTokenLimiter
			deleteAgentTokenLimiter(long agentTokenLimiterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentTokenLimiterLocalService.deleteAgentTokenLimiter(
			agentTokenLimiterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentTokenLimiterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _agentTokenLimiterLocalService.dynamicQuery();
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

		return _agentTokenLimiterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentTokenLimiterModelImpl</code>.
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

		return _agentTokenLimiterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentTokenLimiterModelImpl</code>.
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

		return _agentTokenLimiterLocalService.dynamicQuery(
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

		return _agentTokenLimiterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _agentTokenLimiterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.agencyportal.model.AgentTokenLimiter
		editAgentTokenLimiter(
			long agentTokenLimiterId, String deptCode, String token,
			String tokenType, int isValid) {

		return _agentTokenLimiterLocalService.editAgentTokenLimiter(
			agentTokenLimiterId, deptCode, token, tokenType, isValid);
	}

	@Override
	public com.mypage.agencyportal.model.AgentTokenLimiter
		fetchAgentTokenLimiter(long agentTokenLimiterId) {

		return _agentTokenLimiterLocalService.fetchAgentTokenLimiter(
			agentTokenLimiterId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _agentTokenLimiterLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the agent token limiter with the primary key.
	 *
	 * @param agentTokenLimiterId the primary key of the agent token limiter
	 * @return the agent token limiter
	 * @throws PortalException if a agent token limiter with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.AgentTokenLimiter getAgentTokenLimiter(
			long agentTokenLimiterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentTokenLimiterLocalService.getAgentTokenLimiter(
			agentTokenLimiterId);
	}

	@Override
	public com.mypage.agencyportal.model.AgentTokenLimiter
		getAgentTokenLimiterByDeptCodeAndTokenType(
			String deptCode, String tokenType) {

		return _agentTokenLimiterLocalService.
			getAgentTokenLimiterByDeptCodeAndTokenType(deptCode, tokenType);
	}

	@Override
	public com.mypage.agencyportal.model.AgentTokenLimiter
		getAgentTokenLimiterByToken(String token) {

		return _agentTokenLimiterLocalService.getAgentTokenLimiterByToken(
			token);
	}

	/**
	 * Returns a range of all the agent token limiters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.AgentTokenLimiterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent token limiters
	 * @param end the upper bound of the range of agent token limiters (not inclusive)
	 * @return the range of agent token limiters
	 */
	@Override
	public java.util.List<com.mypage.agencyportal.model.AgentTokenLimiter>
		getAgentTokenLimiters(int start, int end) {

		return _agentTokenLimiterLocalService.getAgentTokenLimiters(start, end);
	}

	/**
	 * Returns the number of agent token limiters.
	 *
	 * @return the number of agent token limiters
	 */
	@Override
	public int getAgentTokenLimitersCount() {
		return _agentTokenLimiterLocalService.getAgentTokenLimitersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _agentTokenLimiterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _agentTokenLimiterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agentTokenLimiterLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean setToInvalid(long agentTokenLimiterId) {
		return _agentTokenLimiterLocalService.setToInvalid(agentTokenLimiterId);
	}

	/**
	 * Updates the agent token limiter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgentTokenLimiterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agentTokenLimiter the agent token limiter
	 * @return the agent token limiter that was updated
	 */
	@Override
	public com.mypage.agencyportal.model.AgentTokenLimiter
		updateAgentTokenLimiter(
			com.mypage.agencyportal.model.AgentTokenLimiter agentTokenLimiter) {

		return _agentTokenLimiterLocalService.updateAgentTokenLimiter(
			agentTokenLimiter);
	}

	@Override
	public AgentTokenLimiterLocalService getWrappedService() {
		return _agentTokenLimiterLocalService;
	}

	@Override
	public void setWrappedService(
		AgentTokenLimiterLocalService agentTokenLimiterLocalService) {

		_agentTokenLimiterLocalService = agentTokenLimiterLocalService;
	}

	private AgentTokenLimiterLocalService _agentTokenLimiterLocalService;

}