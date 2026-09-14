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

package com.mypage.agencyportal.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.agencyportal.model.AgentToken;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the agent token service. This utility wraps <code>com.mypage.agencyportal.service.persistence.impl.AgentTokenPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentTokenPersistence
 * @generated
 */
public class AgentTokenUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AgentToken agentToken) {
		getPersistence().clearCache(agentToken);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, AgentToken> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AgentToken> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AgentToken> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AgentToken> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AgentToken> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AgentToken update(AgentToken agentToken) {
		return getPersistence().update(agentToken);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AgentToken update(
		AgentToken agentToken, ServiceContext serviceContext) {

		return getPersistence().update(agentToken, serviceContext);
	}

	/**
	 * Returns the agent token where deptCode = &#63; or throws a <code>NoSuchAgentTokenException</code> if it could not be found.
	 *
	 * @param deptCode the dept code
	 * @return the matching agent token
	 * @throws NoSuchAgentTokenException if a matching agent token could not be found
	 */
	public static AgentToken findBydeptCode(String deptCode)
		throws com.mypage.agencyportal.exception.NoSuchAgentTokenException {

		return getPersistence().findBydeptCode(deptCode);
	}

	/**
	 * Returns the agent token where deptCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param deptCode the dept code
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	public static AgentToken fetchBydeptCode(String deptCode) {
		return getPersistence().fetchBydeptCode(deptCode);
	}

	/**
	 * Returns the agent token where deptCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param deptCode the dept code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	public static AgentToken fetchBydeptCode(
		String deptCode, boolean useFinderCache) {

		return getPersistence().fetchBydeptCode(deptCode, useFinderCache);
	}

	/**
	 * Removes the agent token where deptCode = &#63; from the database.
	 *
	 * @param deptCode the dept code
	 * @return the agent token that was removed
	 */
	public static AgentToken removeBydeptCode(String deptCode)
		throws com.mypage.agencyportal.exception.NoSuchAgentTokenException {

		return getPersistence().removeBydeptCode(deptCode);
	}

	/**
	 * Returns the number of agent tokens where deptCode = &#63;.
	 *
	 * @param deptCode the dept code
	 * @return the number of matching agent tokens
	 */
	public static int countBydeptCode(String deptCode) {
		return getPersistence().countBydeptCode(deptCode);
	}

	/**
	 * Returns the agent token where token = &#63; or throws a <code>NoSuchAgentTokenException</code> if it could not be found.
	 *
	 * @param token the token
	 * @return the matching agent token
	 * @throws NoSuchAgentTokenException if a matching agent token could not be found
	 */
	public static AgentToken findBytoken(String token)
		throws com.mypage.agencyportal.exception.NoSuchAgentTokenException {

		return getPersistence().findBytoken(token);
	}

	/**
	 * Returns the agent token where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param token the token
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	public static AgentToken fetchBytoken(String token) {
		return getPersistence().fetchBytoken(token);
	}

	/**
	 * Returns the agent token where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param token the token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	public static AgentToken fetchBytoken(
		String token, boolean useFinderCache) {

		return getPersistence().fetchBytoken(token, useFinderCache);
	}

	/**
	 * Removes the agent token where token = &#63; from the database.
	 *
	 * @param token the token
	 * @return the agent token that was removed
	 */
	public static AgentToken removeBytoken(String token)
		throws com.mypage.agencyportal.exception.NoSuchAgentTokenException {

		return getPersistence().removeBytoken(token);
	}

	/**
	 * Returns the number of agent tokens where token = &#63;.
	 *
	 * @param token the token
	 * @return the number of matching agent tokens
	 */
	public static int countBytoken(String token) {
		return getPersistence().countBytoken(token);
	}

	/**
	 * Returns the agent token where apiRequestToken = &#63; or throws a <code>NoSuchAgentTokenException</code> if it could not be found.
	 *
	 * @param apiRequestToken the api request token
	 * @return the matching agent token
	 * @throws NoSuchAgentTokenException if a matching agent token could not be found
	 */
	public static AgentToken findByapiRequestToken(String apiRequestToken)
		throws com.mypage.agencyportal.exception.NoSuchAgentTokenException {

		return getPersistence().findByapiRequestToken(apiRequestToken);
	}

	/**
	 * Returns the agent token where apiRequestToken = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param apiRequestToken the api request token
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	public static AgentToken fetchByapiRequestToken(String apiRequestToken) {
		return getPersistence().fetchByapiRequestToken(apiRequestToken);
	}

	/**
	 * Returns the agent token where apiRequestToken = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param apiRequestToken the api request token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	public static AgentToken fetchByapiRequestToken(
		String apiRequestToken, boolean useFinderCache) {

		return getPersistence().fetchByapiRequestToken(
			apiRequestToken, useFinderCache);
	}

	/**
	 * Removes the agent token where apiRequestToken = &#63; from the database.
	 *
	 * @param apiRequestToken the api request token
	 * @return the agent token that was removed
	 */
	public static AgentToken removeByapiRequestToken(String apiRequestToken)
		throws com.mypage.agencyportal.exception.NoSuchAgentTokenException {

		return getPersistence().removeByapiRequestToken(apiRequestToken);
	}

	/**
	 * Returns the number of agent tokens where apiRequestToken = &#63;.
	 *
	 * @param apiRequestToken the api request token
	 * @return the number of matching agent tokens
	 */
	public static int countByapiRequestToken(String apiRequestToken) {
		return getPersistence().countByapiRequestToken(apiRequestToken);
	}

	/**
	 * Caches the agent token in the entity cache if it is enabled.
	 *
	 * @param agentToken the agent token
	 */
	public static void cacheResult(AgentToken agentToken) {
		getPersistence().cacheResult(agentToken);
	}

	/**
	 * Caches the agent tokens in the entity cache if it is enabled.
	 *
	 * @param agentTokens the agent tokens
	 */
	public static void cacheResult(List<AgentToken> agentTokens) {
		getPersistence().cacheResult(agentTokens);
	}

	/**
	 * Creates a new agent token with the primary key. Does not add the agent token to the database.
	 *
	 * @param agentTokenId the primary key for the new agent token
	 * @return the new agent token
	 */
	public static AgentToken create(long agentTokenId) {
		return getPersistence().create(agentTokenId);
	}

	/**
	 * Removes the agent token with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentTokenId the primary key of the agent token
	 * @return the agent token that was removed
	 * @throws NoSuchAgentTokenException if a agent token with the primary key could not be found
	 */
	public static AgentToken remove(long agentTokenId)
		throws com.mypage.agencyportal.exception.NoSuchAgentTokenException {

		return getPersistence().remove(agentTokenId);
	}

	public static AgentToken updateImpl(AgentToken agentToken) {
		return getPersistence().updateImpl(agentToken);
	}

	/**
	 * Returns the agent token with the primary key or throws a <code>NoSuchAgentTokenException</code> if it could not be found.
	 *
	 * @param agentTokenId the primary key of the agent token
	 * @return the agent token
	 * @throws NoSuchAgentTokenException if a agent token with the primary key could not be found
	 */
	public static AgentToken findByPrimaryKey(long agentTokenId)
		throws com.mypage.agencyportal.exception.NoSuchAgentTokenException {

		return getPersistence().findByPrimaryKey(agentTokenId);
	}

	/**
	 * Returns the agent token with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentTokenId the primary key of the agent token
	 * @return the agent token, or <code>null</code> if a agent token with the primary key could not be found
	 */
	public static AgentToken fetchByPrimaryKey(long agentTokenId) {
		return getPersistence().fetchByPrimaryKey(agentTokenId);
	}

	/**
	 * Returns all the agent tokens.
	 *
	 * @return the agent tokens
	 */
	public static List<AgentToken> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the agent tokens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentTokenModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent tokens
	 * @param end the upper bound of the range of agent tokens (not inclusive)
	 * @return the range of agent tokens
	 */
	public static List<AgentToken> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the agent tokens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentTokenModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent tokens
	 * @param end the upper bound of the range of agent tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agent tokens
	 */
	public static List<AgentToken> findAll(
		int start, int end, OrderByComparator<AgentToken> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the agent tokens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentTokenModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent tokens
	 * @param end the upper bound of the range of agent tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agent tokens
	 */
	public static List<AgentToken> findAll(
		int start, int end, OrderByComparator<AgentToken> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the agent tokens from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of agent tokens.
	 *
	 * @return the number of agent tokens
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AgentTokenPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AgentTokenPersistence _persistence;

}