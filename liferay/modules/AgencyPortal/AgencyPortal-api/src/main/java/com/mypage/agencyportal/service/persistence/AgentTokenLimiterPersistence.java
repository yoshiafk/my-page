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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.agencyportal.exception.NoSuchAgentTokenLimiterException;
import com.mypage.agencyportal.model.AgentTokenLimiter;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the agent token limiter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentTokenLimiterUtil
 * @generated
 */
@ProviderType
public interface AgentTokenLimiterPersistence
	extends BasePersistence<AgentTokenLimiter> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AgentTokenLimiterUtil} to access the agent token limiter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the agent token limiter where token = &#63; or throws a <code>NoSuchAgentTokenLimiterException</code> if it could not be found.
	 *
	 * @param token the token
	 * @return the matching agent token limiter
	 * @throws NoSuchAgentTokenLimiterException if a matching agent token limiter could not be found
	 */
	public AgentTokenLimiter findBytoken(String token)
		throws NoSuchAgentTokenLimiterException;

	/**
	 * Returns the agent token limiter where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param token the token
	 * @return the matching agent token limiter, or <code>null</code> if a matching agent token limiter could not be found
	 */
	public AgentTokenLimiter fetchBytoken(String token);

	/**
	 * Returns the agent token limiter where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param token the token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching agent token limiter, or <code>null</code> if a matching agent token limiter could not be found
	 */
	public AgentTokenLimiter fetchBytoken(String token, boolean useFinderCache);

	/**
	 * Removes the agent token limiter where token = &#63; from the database.
	 *
	 * @param token the token
	 * @return the agent token limiter that was removed
	 */
	public AgentTokenLimiter removeBytoken(String token)
		throws NoSuchAgentTokenLimiterException;

	/**
	 * Returns the number of agent token limiters where token = &#63;.
	 *
	 * @param token the token
	 * @return the number of matching agent token limiters
	 */
	public int countBytoken(String token);

	/**
	 * Returns the agent token limiter where deptCode = &#63; and tokenType = &#63; or throws a <code>NoSuchAgentTokenLimiterException</code> if it could not be found.
	 *
	 * @param deptCode the dept code
	 * @param tokenType the token type
	 * @return the matching agent token limiter
	 * @throws NoSuchAgentTokenLimiterException if a matching agent token limiter could not be found
	 */
	public AgentTokenLimiter findBydeptCodeAndTokenType(
			String deptCode, String tokenType)
		throws NoSuchAgentTokenLimiterException;

	/**
	 * Returns the agent token limiter where deptCode = &#63; and tokenType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param deptCode the dept code
	 * @param tokenType the token type
	 * @return the matching agent token limiter, or <code>null</code> if a matching agent token limiter could not be found
	 */
	public AgentTokenLimiter fetchBydeptCodeAndTokenType(
		String deptCode, String tokenType);

	/**
	 * Returns the agent token limiter where deptCode = &#63; and tokenType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param deptCode the dept code
	 * @param tokenType the token type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching agent token limiter, or <code>null</code> if a matching agent token limiter could not be found
	 */
	public AgentTokenLimiter fetchBydeptCodeAndTokenType(
		String deptCode, String tokenType, boolean useFinderCache);

	/**
	 * Removes the agent token limiter where deptCode = &#63; and tokenType = &#63; from the database.
	 *
	 * @param deptCode the dept code
	 * @param tokenType the token type
	 * @return the agent token limiter that was removed
	 */
	public AgentTokenLimiter removeBydeptCodeAndTokenType(
			String deptCode, String tokenType)
		throws NoSuchAgentTokenLimiterException;

	/**
	 * Returns the number of agent token limiters where deptCode = &#63; and tokenType = &#63;.
	 *
	 * @param deptCode the dept code
	 * @param tokenType the token type
	 * @return the number of matching agent token limiters
	 */
	public int countBydeptCodeAndTokenType(String deptCode, String tokenType);

	/**
	 * Caches the agent token limiter in the entity cache if it is enabled.
	 *
	 * @param agentTokenLimiter the agent token limiter
	 */
	public void cacheResult(AgentTokenLimiter agentTokenLimiter);

	/**
	 * Caches the agent token limiters in the entity cache if it is enabled.
	 *
	 * @param agentTokenLimiters the agent token limiters
	 */
	public void cacheResult(
		java.util.List<AgentTokenLimiter> agentTokenLimiters);

	/**
	 * Creates a new agent token limiter with the primary key. Does not add the agent token limiter to the database.
	 *
	 * @param agentTokenLimiterId the primary key for the new agent token limiter
	 * @return the new agent token limiter
	 */
	public AgentTokenLimiter create(long agentTokenLimiterId);

	/**
	 * Removes the agent token limiter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentTokenLimiterId the primary key of the agent token limiter
	 * @return the agent token limiter that was removed
	 * @throws NoSuchAgentTokenLimiterException if a agent token limiter with the primary key could not be found
	 */
	public AgentTokenLimiter remove(long agentTokenLimiterId)
		throws NoSuchAgentTokenLimiterException;

	public AgentTokenLimiter updateImpl(AgentTokenLimiter agentTokenLimiter);

	/**
	 * Returns the agent token limiter with the primary key or throws a <code>NoSuchAgentTokenLimiterException</code> if it could not be found.
	 *
	 * @param agentTokenLimiterId the primary key of the agent token limiter
	 * @return the agent token limiter
	 * @throws NoSuchAgentTokenLimiterException if a agent token limiter with the primary key could not be found
	 */
	public AgentTokenLimiter findByPrimaryKey(long agentTokenLimiterId)
		throws NoSuchAgentTokenLimiterException;

	/**
	 * Returns the agent token limiter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentTokenLimiterId the primary key of the agent token limiter
	 * @return the agent token limiter, or <code>null</code> if a agent token limiter with the primary key could not be found
	 */
	public AgentTokenLimiter fetchByPrimaryKey(long agentTokenLimiterId);

	/**
	 * Returns all the agent token limiters.
	 *
	 * @return the agent token limiters
	 */
	public java.util.List<AgentTokenLimiter> findAll();

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
	public java.util.List<AgentTokenLimiter> findAll(int start, int end);

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
	public java.util.List<AgentTokenLimiter> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentTokenLimiter>
			orderByComparator);

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
	public java.util.List<AgentTokenLimiter> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentTokenLimiter>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the agent token limiters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of agent token limiters.
	 *
	 * @return the number of agent token limiters
	 */
	public int countAll();

}