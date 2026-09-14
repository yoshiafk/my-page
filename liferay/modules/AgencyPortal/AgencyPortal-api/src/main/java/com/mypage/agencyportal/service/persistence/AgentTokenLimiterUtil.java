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

import com.mypage.agencyportal.model.AgentTokenLimiter;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the agent token limiter service. This utility wraps <code>com.mypage.agencyportal.service.persistence.impl.AgentTokenLimiterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentTokenLimiterPersistence
 * @generated
 */
public class AgentTokenLimiterUtil {

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
	public static void clearCache(AgentTokenLimiter agentTokenLimiter) {
		getPersistence().clearCache(agentTokenLimiter);
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
	public static Map<Serializable, AgentTokenLimiter> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AgentTokenLimiter> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AgentTokenLimiter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AgentTokenLimiter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AgentTokenLimiter> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AgentTokenLimiter update(
		AgentTokenLimiter agentTokenLimiter) {

		return getPersistence().update(agentTokenLimiter);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AgentTokenLimiter update(
		AgentTokenLimiter agentTokenLimiter, ServiceContext serviceContext) {

		return getPersistence().update(agentTokenLimiter, serviceContext);
	}

	/**
	 * Returns the agent token limiter where token = &#63; or throws a <code>NoSuchAgentTokenLimiterException</code> if it could not be found.
	 *
	 * @param token the token
	 * @return the matching agent token limiter
	 * @throws NoSuchAgentTokenLimiterException if a matching agent token limiter could not be found
	 */
	public static AgentTokenLimiter findBytoken(String token)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentTokenLimiterException {

		return getPersistence().findBytoken(token);
	}

	/**
	 * Returns the agent token limiter where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param token the token
	 * @return the matching agent token limiter, or <code>null</code> if a matching agent token limiter could not be found
	 */
	public static AgentTokenLimiter fetchBytoken(String token) {
		return getPersistence().fetchBytoken(token);
	}

	/**
	 * Returns the agent token limiter where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param token the token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching agent token limiter, or <code>null</code> if a matching agent token limiter could not be found
	 */
	public static AgentTokenLimiter fetchBytoken(
		String token, boolean useFinderCache) {

		return getPersistence().fetchBytoken(token, useFinderCache);
	}

	/**
	 * Removes the agent token limiter where token = &#63; from the database.
	 *
	 * @param token the token
	 * @return the agent token limiter that was removed
	 */
	public static AgentTokenLimiter removeBytoken(String token)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentTokenLimiterException {

		return getPersistence().removeBytoken(token);
	}

	/**
	 * Returns the number of agent token limiters where token = &#63;.
	 *
	 * @param token the token
	 * @return the number of matching agent token limiters
	 */
	public static int countBytoken(String token) {
		return getPersistence().countBytoken(token);
	}

	/**
	 * Returns the agent token limiter where deptCode = &#63; and tokenType = &#63; or throws a <code>NoSuchAgentTokenLimiterException</code> if it could not be found.
	 *
	 * @param deptCode the dept code
	 * @param tokenType the token type
	 * @return the matching agent token limiter
	 * @throws NoSuchAgentTokenLimiterException if a matching agent token limiter could not be found
	 */
	public static AgentTokenLimiter findBydeptCodeAndTokenType(
			String deptCode, String tokenType)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentTokenLimiterException {

		return getPersistence().findBydeptCodeAndTokenType(deptCode, tokenType);
	}

	/**
	 * Returns the agent token limiter where deptCode = &#63; and tokenType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param deptCode the dept code
	 * @param tokenType the token type
	 * @return the matching agent token limiter, or <code>null</code> if a matching agent token limiter could not be found
	 */
	public static AgentTokenLimiter fetchBydeptCodeAndTokenType(
		String deptCode, String tokenType) {

		return getPersistence().fetchBydeptCodeAndTokenType(
			deptCode, tokenType);
	}

	/**
	 * Returns the agent token limiter where deptCode = &#63; and tokenType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param deptCode the dept code
	 * @param tokenType the token type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching agent token limiter, or <code>null</code> if a matching agent token limiter could not be found
	 */
	public static AgentTokenLimiter fetchBydeptCodeAndTokenType(
		String deptCode, String tokenType, boolean useFinderCache) {

		return getPersistence().fetchBydeptCodeAndTokenType(
			deptCode, tokenType, useFinderCache);
	}

	/**
	 * Removes the agent token limiter where deptCode = &#63; and tokenType = &#63; from the database.
	 *
	 * @param deptCode the dept code
	 * @param tokenType the token type
	 * @return the agent token limiter that was removed
	 */
	public static AgentTokenLimiter removeBydeptCodeAndTokenType(
			String deptCode, String tokenType)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentTokenLimiterException {

		return getPersistence().removeBydeptCodeAndTokenType(
			deptCode, tokenType);
	}

	/**
	 * Returns the number of agent token limiters where deptCode = &#63; and tokenType = &#63;.
	 *
	 * @param deptCode the dept code
	 * @param tokenType the token type
	 * @return the number of matching agent token limiters
	 */
	public static int countBydeptCodeAndTokenType(
		String deptCode, String tokenType) {

		return getPersistence().countBydeptCodeAndTokenType(
			deptCode, tokenType);
	}

	/**
	 * Caches the agent token limiter in the entity cache if it is enabled.
	 *
	 * @param agentTokenLimiter the agent token limiter
	 */
	public static void cacheResult(AgentTokenLimiter agentTokenLimiter) {
		getPersistence().cacheResult(agentTokenLimiter);
	}

	/**
	 * Caches the agent token limiters in the entity cache if it is enabled.
	 *
	 * @param agentTokenLimiters the agent token limiters
	 */
	public static void cacheResult(List<AgentTokenLimiter> agentTokenLimiters) {
		getPersistence().cacheResult(agentTokenLimiters);
	}

	/**
	 * Creates a new agent token limiter with the primary key. Does not add the agent token limiter to the database.
	 *
	 * @param agentTokenLimiterId the primary key for the new agent token limiter
	 * @return the new agent token limiter
	 */
	public static AgentTokenLimiter create(long agentTokenLimiterId) {
		return getPersistence().create(agentTokenLimiterId);
	}

	/**
	 * Removes the agent token limiter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentTokenLimiterId the primary key of the agent token limiter
	 * @return the agent token limiter that was removed
	 * @throws NoSuchAgentTokenLimiterException if a agent token limiter with the primary key could not be found
	 */
	public static AgentTokenLimiter remove(long agentTokenLimiterId)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentTokenLimiterException {

		return getPersistence().remove(agentTokenLimiterId);
	}

	public static AgentTokenLimiter updateImpl(
		AgentTokenLimiter agentTokenLimiter) {

		return getPersistence().updateImpl(agentTokenLimiter);
	}

	/**
	 * Returns the agent token limiter with the primary key or throws a <code>NoSuchAgentTokenLimiterException</code> if it could not be found.
	 *
	 * @param agentTokenLimiterId the primary key of the agent token limiter
	 * @return the agent token limiter
	 * @throws NoSuchAgentTokenLimiterException if a agent token limiter with the primary key could not be found
	 */
	public static AgentTokenLimiter findByPrimaryKey(long agentTokenLimiterId)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentTokenLimiterException {

		return getPersistence().findByPrimaryKey(agentTokenLimiterId);
	}

	/**
	 * Returns the agent token limiter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentTokenLimiterId the primary key of the agent token limiter
	 * @return the agent token limiter, or <code>null</code> if a agent token limiter with the primary key could not be found
	 */
	public static AgentTokenLimiter fetchByPrimaryKey(
		long agentTokenLimiterId) {

		return getPersistence().fetchByPrimaryKey(agentTokenLimiterId);
	}

	/**
	 * Returns all the agent token limiters.
	 *
	 * @return the agent token limiters
	 */
	public static List<AgentTokenLimiter> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the agent token limiters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentTokenLimiterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent token limiters
	 * @param end the upper bound of the range of agent token limiters (not inclusive)
	 * @return the range of agent token limiters
	 */
	public static List<AgentTokenLimiter> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the agent token limiters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentTokenLimiterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent token limiters
	 * @param end the upper bound of the range of agent token limiters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agent token limiters
	 */
	public static List<AgentTokenLimiter> findAll(
		int start, int end,
		OrderByComparator<AgentTokenLimiter> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the agent token limiters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentTokenLimiterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent token limiters
	 * @param end the upper bound of the range of agent token limiters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agent token limiters
	 */
	public static List<AgentTokenLimiter> findAll(
		int start, int end,
		OrderByComparator<AgentTokenLimiter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the agent token limiters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of agent token limiters.
	 *
	 * @return the number of agent token limiters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AgentTokenLimiterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AgentTokenLimiterPersistence _persistence;

}