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

import com.mypage.agencyportal.exception.NoSuchAgentCategorySalesToolsException;
import com.mypage.agencyportal.model.AgentCategorySalesTools;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the agent category sales tools service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentCategorySalesToolsUtil
 * @generated
 */
@ProviderType
public interface AgentCategorySalesToolsPersistence
	extends BasePersistence<AgentCategorySalesTools> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AgentCategorySalesToolsUtil} to access the agent category sales tools persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the agent category sales tools in the entity cache if it is enabled.
	 *
	 * @param agentCategorySalesTools the agent category sales tools
	 */
	public void cacheResult(AgentCategorySalesTools agentCategorySalesTools);

	/**
	 * Caches the agent category sales toolses in the entity cache if it is enabled.
	 *
	 * @param agentCategorySalesToolses the agent category sales toolses
	 */
	public void cacheResult(
		java.util.List<AgentCategorySalesTools> agentCategorySalesToolses);

	/**
	 * Creates a new agent category sales tools with the primary key. Does not add the agent category sales tools to the database.
	 *
	 * @param agentCategorySalesToolsId the primary key for the new agent category sales tools
	 * @return the new agent category sales tools
	 */
	public AgentCategorySalesTools create(long agentCategorySalesToolsId);

	/**
	 * Removes the agent category sales tools with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentCategorySalesToolsId the primary key of the agent category sales tools
	 * @return the agent category sales tools that was removed
	 * @throws NoSuchAgentCategorySalesToolsException if a agent category sales tools with the primary key could not be found
	 */
	public AgentCategorySalesTools remove(long agentCategorySalesToolsId)
		throws NoSuchAgentCategorySalesToolsException;

	public AgentCategorySalesTools updateImpl(
		AgentCategorySalesTools agentCategorySalesTools);

	/**
	 * Returns the agent category sales tools with the primary key or throws a <code>NoSuchAgentCategorySalesToolsException</code> if it could not be found.
	 *
	 * @param agentCategorySalesToolsId the primary key of the agent category sales tools
	 * @return the agent category sales tools
	 * @throws NoSuchAgentCategorySalesToolsException if a agent category sales tools with the primary key could not be found
	 */
	public AgentCategorySalesTools findByPrimaryKey(
			long agentCategorySalesToolsId)
		throws NoSuchAgentCategorySalesToolsException;

	/**
	 * Returns the agent category sales tools with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentCategorySalesToolsId the primary key of the agent category sales tools
	 * @return the agent category sales tools, or <code>null</code> if a agent category sales tools with the primary key could not be found
	 */
	public AgentCategorySalesTools fetchByPrimaryKey(
		long agentCategorySalesToolsId);

	/**
	 * Returns all the agent category sales toolses.
	 *
	 * @return the agent category sales toolses
	 */
	public java.util.List<AgentCategorySalesTools> findAll();

	/**
	 * Returns a range of all the agent category sales toolses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCategorySalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent category sales toolses
	 * @param end the upper bound of the range of agent category sales toolses (not inclusive)
	 * @return the range of agent category sales toolses
	 */
	public java.util.List<AgentCategorySalesTools> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the agent category sales toolses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCategorySalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent category sales toolses
	 * @param end the upper bound of the range of agent category sales toolses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agent category sales toolses
	 */
	public java.util.List<AgentCategorySalesTools> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AgentCategorySalesTools> orderByComparator);

	/**
	 * Returns an ordered range of all the agent category sales toolses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentCategorySalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent category sales toolses
	 * @param end the upper bound of the range of agent category sales toolses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agent category sales toolses
	 */
	public java.util.List<AgentCategorySalesTools> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AgentCategorySalesTools> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the agent category sales toolses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of agent category sales toolses.
	 *
	 * @return the number of agent category sales toolses
	 */
	public int countAll();

}