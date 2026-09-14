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

import com.mypage.agencyportal.exception.NoSuchAgentSalesToolsException;
import com.mypage.agencyportal.model.AgentSalesTools;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the agent sales tools service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentSalesToolsUtil
 * @generated
 */
@ProviderType
public interface AgentSalesToolsPersistence
	extends BasePersistence<AgentSalesTools> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AgentSalesToolsUtil} to access the agent sales tools persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the agent sales toolses where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching agent sales toolses
	 */
	public java.util.List<AgentSalesTools> findBycategory(String category);

	/**
	 * Returns a range of all the agent sales toolses where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @return the range of matching agent sales toolses
	 */
	public java.util.List<AgentSalesTools> findBycategory(
		String category, int start, int end);

	/**
	 * Returns an ordered range of all the agent sales toolses where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent sales toolses
	 */
	public java.util.List<AgentSalesTools> findBycategory(
		String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentSalesTools>
			orderByComparator);

	/**
	 * Returns an ordered range of all the agent sales toolses where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent sales toolses
	 */
	public java.util.List<AgentSalesTools> findBycategory(
		String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentSalesTools>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first agent sales tools in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a matching agent sales tools could not be found
	 */
	public AgentSalesTools findBycategory_First(
			String category,
			com.liferay.portal.kernel.util.OrderByComparator<AgentSalesTools>
				orderByComparator)
		throws NoSuchAgentSalesToolsException;

	/**
	 * Returns the first agent sales tools in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent sales tools, or <code>null</code> if a matching agent sales tools could not be found
	 */
	public AgentSalesTools fetchBycategory_First(
		String category,
		com.liferay.portal.kernel.util.OrderByComparator<AgentSalesTools>
			orderByComparator);

	/**
	 * Returns the last agent sales tools in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a matching agent sales tools could not be found
	 */
	public AgentSalesTools findBycategory_Last(
			String category,
			com.liferay.portal.kernel.util.OrderByComparator<AgentSalesTools>
				orderByComparator)
		throws NoSuchAgentSalesToolsException;

	/**
	 * Returns the last agent sales tools in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent sales tools, or <code>null</code> if a matching agent sales tools could not be found
	 */
	public AgentSalesTools fetchBycategory_Last(
		String category,
		com.liferay.portal.kernel.util.OrderByComparator<AgentSalesTools>
			orderByComparator);

	/**
	 * Returns the agent sales toolses before and after the current agent sales tools in the ordered set where category = &#63;.
	 *
	 * @param agentSalesToolsId the primary key of the current agent sales tools
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a agent sales tools with the primary key could not be found
	 */
	public AgentSalesTools[] findBycategory_PrevAndNext(
			long agentSalesToolsId, String category,
			com.liferay.portal.kernel.util.OrderByComparator<AgentSalesTools>
				orderByComparator)
		throws NoSuchAgentSalesToolsException;

	/**
	 * Removes all the agent sales toolses where category = &#63; from the database.
	 *
	 * @param category the category
	 */
	public void removeBycategory(String category);

	/**
	 * Returns the number of agent sales toolses where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching agent sales toolses
	 */
	public int countBycategory(String category);

	/**
	 * Returns all the agent sales toolses where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the matching agent sales toolses
	 */
	public java.util.List<AgentSalesTools> findBymypageUserRoleId(
		long mypageUserRoleId);

	/**
	 * Returns a range of all the agent sales toolses where mypageUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @return the range of matching agent sales toolses
	 */
	public java.util.List<AgentSalesTools> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end);

	/**
	 * Returns an ordered range of all the agent sales toolses where mypageUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent sales toolses
	 */
	public java.util.List<AgentSalesTools> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentSalesTools>
			orderByComparator);

	/**
	 * Returns an ordered range of all the agent sales toolses where mypageUserRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent sales toolses
	 */
	public java.util.List<AgentSalesTools> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentSalesTools>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first agent sales tools in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a matching agent sales tools could not be found
	 */
	public AgentSalesTools findBymypageUserRoleId_First(
			long mypageUserRoleId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentSalesTools>
				orderByComparator)
		throws NoSuchAgentSalesToolsException;

	/**
	 * Returns the first agent sales tools in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent sales tools, or <code>null</code> if a matching agent sales tools could not be found
	 */
	public AgentSalesTools fetchBymypageUserRoleId_First(
		long mypageUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentSalesTools>
			orderByComparator);

	/**
	 * Returns the last agent sales tools in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a matching agent sales tools could not be found
	 */
	public AgentSalesTools findBymypageUserRoleId_Last(
			long mypageUserRoleId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentSalesTools>
				orderByComparator)
		throws NoSuchAgentSalesToolsException;

	/**
	 * Returns the last agent sales tools in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent sales tools, or <code>null</code> if a matching agent sales tools could not be found
	 */
	public AgentSalesTools fetchBymypageUserRoleId_Last(
		long mypageUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator<AgentSalesTools>
			orderByComparator);

	/**
	 * Returns the agent sales toolses before and after the current agent sales tools in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param agentSalesToolsId the primary key of the current agent sales tools
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a agent sales tools with the primary key could not be found
	 */
	public AgentSalesTools[] findBymypageUserRoleId_PrevAndNext(
			long agentSalesToolsId, long mypageUserRoleId,
			com.liferay.portal.kernel.util.OrderByComparator<AgentSalesTools>
				orderByComparator)
		throws NoSuchAgentSalesToolsException;

	/**
	 * Removes all the agent sales toolses where mypageUserRoleId = &#63; from the database.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 */
	public void removeBymypageUserRoleId(long mypageUserRoleId);

	/**
	 * Returns the number of agent sales toolses where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the number of matching agent sales toolses
	 */
	public int countBymypageUserRoleId(long mypageUserRoleId);

	/**
	 * Caches the agent sales tools in the entity cache if it is enabled.
	 *
	 * @param agentSalesTools the agent sales tools
	 */
	public void cacheResult(AgentSalesTools agentSalesTools);

	/**
	 * Caches the agent sales toolses in the entity cache if it is enabled.
	 *
	 * @param agentSalesToolses the agent sales toolses
	 */
	public void cacheResult(java.util.List<AgentSalesTools> agentSalesToolses);

	/**
	 * Creates a new agent sales tools with the primary key. Does not add the agent sales tools to the database.
	 *
	 * @param agentSalesToolsId the primary key for the new agent sales tools
	 * @return the new agent sales tools
	 */
	public AgentSalesTools create(long agentSalesToolsId);

	/**
	 * Removes the agent sales tools with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentSalesToolsId the primary key of the agent sales tools
	 * @return the agent sales tools that was removed
	 * @throws NoSuchAgentSalesToolsException if a agent sales tools with the primary key could not be found
	 */
	public AgentSalesTools remove(long agentSalesToolsId)
		throws NoSuchAgentSalesToolsException;

	public AgentSalesTools updateImpl(AgentSalesTools agentSalesTools);

	/**
	 * Returns the agent sales tools with the primary key or throws a <code>NoSuchAgentSalesToolsException</code> if it could not be found.
	 *
	 * @param agentSalesToolsId the primary key of the agent sales tools
	 * @return the agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a agent sales tools with the primary key could not be found
	 */
	public AgentSalesTools findByPrimaryKey(long agentSalesToolsId)
		throws NoSuchAgentSalesToolsException;

	/**
	 * Returns the agent sales tools with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentSalesToolsId the primary key of the agent sales tools
	 * @return the agent sales tools, or <code>null</code> if a agent sales tools with the primary key could not be found
	 */
	public AgentSalesTools fetchByPrimaryKey(long agentSalesToolsId);

	/**
	 * Returns all the agent sales toolses.
	 *
	 * @return the agent sales toolses
	 */
	public java.util.List<AgentSalesTools> findAll();

	/**
	 * Returns a range of all the agent sales toolses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @return the range of agent sales toolses
	 */
	public java.util.List<AgentSalesTools> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the agent sales toolses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agent sales toolses
	 */
	public java.util.List<AgentSalesTools> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentSalesTools>
			orderByComparator);

	/**
	 * Returns an ordered range of all the agent sales toolses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentSalesToolsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent sales toolses
	 * @param end the upper bound of the range of agent sales toolses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agent sales toolses
	 */
	public java.util.List<AgentSalesTools> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentSalesTools>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the agent sales toolses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of agent sales toolses.
	 *
	 * @return the number of agent sales toolses
	 */
	public int countAll();

}