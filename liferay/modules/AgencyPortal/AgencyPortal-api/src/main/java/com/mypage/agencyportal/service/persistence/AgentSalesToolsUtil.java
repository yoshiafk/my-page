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

import com.mypage.agencyportal.model.AgentSalesTools;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the agent sales tools service. This utility wraps <code>com.mypage.agencyportal.service.persistence.impl.AgentSalesToolsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentSalesToolsPersistence
 * @generated
 */
public class AgentSalesToolsUtil {

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
	public static void clearCache(AgentSalesTools agentSalesTools) {
		getPersistence().clearCache(agentSalesTools);
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
	public static Map<Serializable, AgentSalesTools> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AgentSalesTools> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AgentSalesTools> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AgentSalesTools> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AgentSalesTools> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AgentSalesTools update(AgentSalesTools agentSalesTools) {
		return getPersistence().update(agentSalesTools);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AgentSalesTools update(
		AgentSalesTools agentSalesTools, ServiceContext serviceContext) {

		return getPersistence().update(agentSalesTools, serviceContext);
	}

	/**
	 * Returns all the agent sales toolses where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching agent sales toolses
	 */
	public static List<AgentSalesTools> findBycategory(String category) {
		return getPersistence().findBycategory(category);
	}

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
	public static List<AgentSalesTools> findBycategory(
		String category, int start, int end) {

		return getPersistence().findBycategory(category, start, end);
	}

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
	public static List<AgentSalesTools> findBycategory(
		String category, int start, int end,
		OrderByComparator<AgentSalesTools> orderByComparator) {

		return getPersistence().findBycategory(
			category, start, end, orderByComparator);
	}

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
	public static List<AgentSalesTools> findBycategory(
		String category, int start, int end,
		OrderByComparator<AgentSalesTools> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBycategory(
			category, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agent sales tools in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a matching agent sales tools could not be found
	 */
	public static AgentSalesTools findBycategory_First(
			String category,
			OrderByComparator<AgentSalesTools> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentSalesToolsException {

		return getPersistence().findBycategory_First(
			category, orderByComparator);
	}

	/**
	 * Returns the first agent sales tools in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent sales tools, or <code>null</code> if a matching agent sales tools could not be found
	 */
	public static AgentSalesTools fetchBycategory_First(
		String category, OrderByComparator<AgentSalesTools> orderByComparator) {

		return getPersistence().fetchBycategory_First(
			category, orderByComparator);
	}

	/**
	 * Returns the last agent sales tools in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a matching agent sales tools could not be found
	 */
	public static AgentSalesTools findBycategory_Last(
			String category,
			OrderByComparator<AgentSalesTools> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentSalesToolsException {

		return getPersistence().findBycategory_Last(
			category, orderByComparator);
	}

	/**
	 * Returns the last agent sales tools in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent sales tools, or <code>null</code> if a matching agent sales tools could not be found
	 */
	public static AgentSalesTools fetchBycategory_Last(
		String category, OrderByComparator<AgentSalesTools> orderByComparator) {

		return getPersistence().fetchBycategory_Last(
			category, orderByComparator);
	}

	/**
	 * Returns the agent sales toolses before and after the current agent sales tools in the ordered set where category = &#63;.
	 *
	 * @param agentSalesToolsId the primary key of the current agent sales tools
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a agent sales tools with the primary key could not be found
	 */
	public static AgentSalesTools[] findBycategory_PrevAndNext(
			long agentSalesToolsId, String category,
			OrderByComparator<AgentSalesTools> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentSalesToolsException {

		return getPersistence().findBycategory_PrevAndNext(
			agentSalesToolsId, category, orderByComparator);
	}

	/**
	 * Removes all the agent sales toolses where category = &#63; from the database.
	 *
	 * @param category the category
	 */
	public static void removeBycategory(String category) {
		getPersistence().removeBycategory(category);
	}

	/**
	 * Returns the number of agent sales toolses where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching agent sales toolses
	 */
	public static int countBycategory(String category) {
		return getPersistence().countBycategory(category);
	}

	/**
	 * Returns all the agent sales toolses where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the matching agent sales toolses
	 */
	public static List<AgentSalesTools> findBymypageUserRoleId(
		long mypageUserRoleId) {

		return getPersistence().findBymypageUserRoleId(mypageUserRoleId);
	}

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
	public static List<AgentSalesTools> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end) {

		return getPersistence().findBymypageUserRoleId(
			mypageUserRoleId, start, end);
	}

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
	public static List<AgentSalesTools> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		OrderByComparator<AgentSalesTools> orderByComparator) {

		return getPersistence().findBymypageUserRoleId(
			mypageUserRoleId, start, end, orderByComparator);
	}

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
	public static List<AgentSalesTools> findBymypageUserRoleId(
		long mypageUserRoleId, int start, int end,
		OrderByComparator<AgentSalesTools> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBymypageUserRoleId(
			mypageUserRoleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agent sales tools in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a matching agent sales tools could not be found
	 */
	public static AgentSalesTools findBymypageUserRoleId_First(
			long mypageUserRoleId,
			OrderByComparator<AgentSalesTools> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentSalesToolsException {

		return getPersistence().findBymypageUserRoleId_First(
			mypageUserRoleId, orderByComparator);
	}

	/**
	 * Returns the first agent sales tools in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent sales tools, or <code>null</code> if a matching agent sales tools could not be found
	 */
	public static AgentSalesTools fetchBymypageUserRoleId_First(
		long mypageUserRoleId,
		OrderByComparator<AgentSalesTools> orderByComparator) {

		return getPersistence().fetchBymypageUserRoleId_First(
			mypageUserRoleId, orderByComparator);
	}

	/**
	 * Returns the last agent sales tools in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a matching agent sales tools could not be found
	 */
	public static AgentSalesTools findBymypageUserRoleId_Last(
			long mypageUserRoleId,
			OrderByComparator<AgentSalesTools> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentSalesToolsException {

		return getPersistence().findBymypageUserRoleId_Last(
			mypageUserRoleId, orderByComparator);
	}

	/**
	 * Returns the last agent sales tools in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent sales tools, or <code>null</code> if a matching agent sales tools could not be found
	 */
	public static AgentSalesTools fetchBymypageUserRoleId_Last(
		long mypageUserRoleId,
		OrderByComparator<AgentSalesTools> orderByComparator) {

		return getPersistence().fetchBymypageUserRoleId_Last(
			mypageUserRoleId, orderByComparator);
	}

	/**
	 * Returns the agent sales toolses before and after the current agent sales tools in the ordered set where mypageUserRoleId = &#63;.
	 *
	 * @param agentSalesToolsId the primary key of the current agent sales tools
	 * @param mypageUserRoleId the mypage user role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a agent sales tools with the primary key could not be found
	 */
	public static AgentSalesTools[] findBymypageUserRoleId_PrevAndNext(
			long agentSalesToolsId, long mypageUserRoleId,
			OrderByComparator<AgentSalesTools> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentSalesToolsException {

		return getPersistence().findBymypageUserRoleId_PrevAndNext(
			agentSalesToolsId, mypageUserRoleId, orderByComparator);
	}

	/**
	 * Removes all the agent sales toolses where mypageUserRoleId = &#63; from the database.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 */
	public static void removeBymypageUserRoleId(long mypageUserRoleId) {
		getPersistence().removeBymypageUserRoleId(mypageUserRoleId);
	}

	/**
	 * Returns the number of agent sales toolses where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the number of matching agent sales toolses
	 */
	public static int countBymypageUserRoleId(long mypageUserRoleId) {
		return getPersistence().countBymypageUserRoleId(mypageUserRoleId);
	}

	/**
	 * Caches the agent sales tools in the entity cache if it is enabled.
	 *
	 * @param agentSalesTools the agent sales tools
	 */
	public static void cacheResult(AgentSalesTools agentSalesTools) {
		getPersistence().cacheResult(agentSalesTools);
	}

	/**
	 * Caches the agent sales toolses in the entity cache if it is enabled.
	 *
	 * @param agentSalesToolses the agent sales toolses
	 */
	public static void cacheResult(List<AgentSalesTools> agentSalesToolses) {
		getPersistence().cacheResult(agentSalesToolses);
	}

	/**
	 * Creates a new agent sales tools with the primary key. Does not add the agent sales tools to the database.
	 *
	 * @param agentSalesToolsId the primary key for the new agent sales tools
	 * @return the new agent sales tools
	 */
	public static AgentSalesTools create(long agentSalesToolsId) {
		return getPersistence().create(agentSalesToolsId);
	}

	/**
	 * Removes the agent sales tools with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentSalesToolsId the primary key of the agent sales tools
	 * @return the agent sales tools that was removed
	 * @throws NoSuchAgentSalesToolsException if a agent sales tools with the primary key could not be found
	 */
	public static AgentSalesTools remove(long agentSalesToolsId)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentSalesToolsException {

		return getPersistence().remove(agentSalesToolsId);
	}

	public static AgentSalesTools updateImpl(AgentSalesTools agentSalesTools) {
		return getPersistence().updateImpl(agentSalesTools);
	}

	/**
	 * Returns the agent sales tools with the primary key or throws a <code>NoSuchAgentSalesToolsException</code> if it could not be found.
	 *
	 * @param agentSalesToolsId the primary key of the agent sales tools
	 * @return the agent sales tools
	 * @throws NoSuchAgentSalesToolsException if a agent sales tools with the primary key could not be found
	 */
	public static AgentSalesTools findByPrimaryKey(long agentSalesToolsId)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentSalesToolsException {

		return getPersistence().findByPrimaryKey(agentSalesToolsId);
	}

	/**
	 * Returns the agent sales tools with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentSalesToolsId the primary key of the agent sales tools
	 * @return the agent sales tools, or <code>null</code> if a agent sales tools with the primary key could not be found
	 */
	public static AgentSalesTools fetchByPrimaryKey(long agentSalesToolsId) {
		return getPersistence().fetchByPrimaryKey(agentSalesToolsId);
	}

	/**
	 * Returns all the agent sales toolses.
	 *
	 * @return the agent sales toolses
	 */
	public static List<AgentSalesTools> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<AgentSalesTools> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<AgentSalesTools> findAll(
		int start, int end,
		OrderByComparator<AgentSalesTools> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<AgentSalesTools> findAll(
		int start, int end,
		OrderByComparator<AgentSalesTools> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the agent sales toolses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of agent sales toolses.
	 *
	 * @return the number of agent sales toolses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AgentSalesToolsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AgentSalesToolsPersistence _persistence;

}