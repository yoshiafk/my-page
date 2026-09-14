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

import com.mypage.agencyportal.exception.NoSuchAgentTokenException;
import com.mypage.agencyportal.model.AgentToken;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the agent token service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentTokenUtil
 * @generated
 */
@ProviderType
public interface AgentTokenPersistence extends BasePersistence<AgentToken> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AgentTokenUtil} to access the agent token persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the agent token where deptCode = &#63; or throws a <code>NoSuchAgentTokenException</code> if it could not be found.
	 *
	 * @param deptCode the dept code
	 * @return the matching agent token
	 * @throws NoSuchAgentTokenException if a matching agent token could not be found
	 */
	public AgentToken findBydeptCode(String deptCode)
		throws NoSuchAgentTokenException;

	/**
	 * Returns the agent token where deptCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param deptCode the dept code
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	public AgentToken fetchBydeptCode(String deptCode);

	/**
	 * Returns the agent token where deptCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param deptCode the dept code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	public AgentToken fetchBydeptCode(String deptCode, boolean useFinderCache);

	/**
	 * Removes the agent token where deptCode = &#63; from the database.
	 *
	 * @param deptCode the dept code
	 * @return the agent token that was removed
	 */
	public AgentToken removeBydeptCode(String deptCode)
		throws NoSuchAgentTokenException;

	/**
	 * Returns the number of agent tokens where deptCode = &#63;.
	 *
	 * @param deptCode the dept code
	 * @return the number of matching agent tokens
	 */
	public int countBydeptCode(String deptCode);

	/**
	 * Returns the agent token where token = &#63; or throws a <code>NoSuchAgentTokenException</code> if it could not be found.
	 *
	 * @param token the token
	 * @return the matching agent token
	 * @throws NoSuchAgentTokenException if a matching agent token could not be found
	 */
	public AgentToken findBytoken(String token)
		throws NoSuchAgentTokenException;

	/**
	 * Returns the agent token where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param token the token
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	public AgentToken fetchBytoken(String token);

	/**
	 * Returns the agent token where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param token the token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	public AgentToken fetchBytoken(String token, boolean useFinderCache);

	/**
	 * Removes the agent token where token = &#63; from the database.
	 *
	 * @param token the token
	 * @return the agent token that was removed
	 */
	public AgentToken removeBytoken(String token)
		throws NoSuchAgentTokenException;

	/**
	 * Returns the number of agent tokens where token = &#63;.
	 *
	 * @param token the token
	 * @return the number of matching agent tokens
	 */
	public int countBytoken(String token);

	/**
	 * Returns the agent token where apiRequestToken = &#63; or throws a <code>NoSuchAgentTokenException</code> if it could not be found.
	 *
	 * @param apiRequestToken the api request token
	 * @return the matching agent token
	 * @throws NoSuchAgentTokenException if a matching agent token could not be found
	 */
	public AgentToken findByapiRequestToken(String apiRequestToken)
		throws NoSuchAgentTokenException;

	/**
	 * Returns the agent token where apiRequestToken = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param apiRequestToken the api request token
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	public AgentToken fetchByapiRequestToken(String apiRequestToken);

	/**
	 * Returns the agent token where apiRequestToken = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param apiRequestToken the api request token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	public AgentToken fetchByapiRequestToken(
		String apiRequestToken, boolean useFinderCache);

	/**
	 * Removes the agent token where apiRequestToken = &#63; from the database.
	 *
	 * @param apiRequestToken the api request token
	 * @return the agent token that was removed
	 */
	public AgentToken removeByapiRequestToken(String apiRequestToken)
		throws NoSuchAgentTokenException;

	/**
	 * Returns the number of agent tokens where apiRequestToken = &#63;.
	 *
	 * @param apiRequestToken the api request token
	 * @return the number of matching agent tokens
	 */
	public int countByapiRequestToken(String apiRequestToken);

	/**
	 * Caches the agent token in the entity cache if it is enabled.
	 *
	 * @param agentToken the agent token
	 */
	public void cacheResult(AgentToken agentToken);

	/**
	 * Caches the agent tokens in the entity cache if it is enabled.
	 *
	 * @param agentTokens the agent tokens
	 */
	public void cacheResult(java.util.List<AgentToken> agentTokens);

	/**
	 * Creates a new agent token with the primary key. Does not add the agent token to the database.
	 *
	 * @param agentTokenId the primary key for the new agent token
	 * @return the new agent token
	 */
	public AgentToken create(long agentTokenId);

	/**
	 * Removes the agent token with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentTokenId the primary key of the agent token
	 * @return the agent token that was removed
	 * @throws NoSuchAgentTokenException if a agent token with the primary key could not be found
	 */
	public AgentToken remove(long agentTokenId)
		throws NoSuchAgentTokenException;

	public AgentToken updateImpl(AgentToken agentToken);

	/**
	 * Returns the agent token with the primary key or throws a <code>NoSuchAgentTokenException</code> if it could not be found.
	 *
	 * @param agentTokenId the primary key of the agent token
	 * @return the agent token
	 * @throws NoSuchAgentTokenException if a agent token with the primary key could not be found
	 */
	public AgentToken findByPrimaryKey(long agentTokenId)
		throws NoSuchAgentTokenException;

	/**
	 * Returns the agent token with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentTokenId the primary key of the agent token
	 * @return the agent token, or <code>null</code> if a agent token with the primary key could not be found
	 */
	public AgentToken fetchByPrimaryKey(long agentTokenId);

	/**
	 * Returns all the agent tokens.
	 *
	 * @return the agent tokens
	 */
	public java.util.List<AgentToken> findAll();

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
	public java.util.List<AgentToken> findAll(int start, int end);

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
	public java.util.List<AgentToken> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentToken>
			orderByComparator);

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
	public java.util.List<AgentToken> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentToken>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the agent tokens from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of agent tokens.
	 *
	 * @return the number of agent tokens
	 */
	public int countAll();

}