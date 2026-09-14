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

import com.mypage.agencyportal.model.AgentFAQCategory;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the agent faq category service. This utility wraps <code>com.mypage.agencyportal.service.persistence.impl.AgentFAQCategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentFAQCategoryPersistence
 * @generated
 */
public class AgentFAQCategoryUtil {

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
	public static void clearCache(AgentFAQCategory agentFAQCategory) {
		getPersistence().clearCache(agentFAQCategory);
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
	public static Map<Serializable, AgentFAQCategory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AgentFAQCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AgentFAQCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AgentFAQCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AgentFAQCategory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AgentFAQCategory update(AgentFAQCategory agentFAQCategory) {
		return getPersistence().update(agentFAQCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AgentFAQCategory update(
		AgentFAQCategory agentFAQCategory, ServiceContext serviceContext) {

		return getPersistence().update(agentFAQCategory, serviceContext);
	}

	/**
	 * Caches the agent faq category in the entity cache if it is enabled.
	 *
	 * @param agentFAQCategory the agent faq category
	 */
	public static void cacheResult(AgentFAQCategory agentFAQCategory) {
		getPersistence().cacheResult(agentFAQCategory);
	}

	/**
	 * Caches the agent faq categories in the entity cache if it is enabled.
	 *
	 * @param agentFAQCategories the agent faq categories
	 */
	public static void cacheResult(List<AgentFAQCategory> agentFAQCategories) {
		getPersistence().cacheResult(agentFAQCategories);
	}

	/**
	 * Creates a new agent faq category with the primary key. Does not add the agent faq category to the database.
	 *
	 * @param agentFaqCategoryId the primary key for the new agent faq category
	 * @return the new agent faq category
	 */
	public static AgentFAQCategory create(long agentFaqCategoryId) {
		return getPersistence().create(agentFaqCategoryId);
	}

	/**
	 * Removes the agent faq category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentFaqCategoryId the primary key of the agent faq category
	 * @return the agent faq category that was removed
	 * @throws NoSuchAgentFAQCategoryException if a agent faq category with the primary key could not be found
	 */
	public static AgentFAQCategory remove(long agentFaqCategoryId)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentFAQCategoryException {

		return getPersistence().remove(agentFaqCategoryId);
	}

	public static AgentFAQCategory updateImpl(
		AgentFAQCategory agentFAQCategory) {

		return getPersistence().updateImpl(agentFAQCategory);
	}

	/**
	 * Returns the agent faq category with the primary key or throws a <code>NoSuchAgentFAQCategoryException</code> if it could not be found.
	 *
	 * @param agentFaqCategoryId the primary key of the agent faq category
	 * @return the agent faq category
	 * @throws NoSuchAgentFAQCategoryException if a agent faq category with the primary key could not be found
	 */
	public static AgentFAQCategory findByPrimaryKey(long agentFaqCategoryId)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentFAQCategoryException {

		return getPersistence().findByPrimaryKey(agentFaqCategoryId);
	}

	/**
	 * Returns the agent faq category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentFaqCategoryId the primary key of the agent faq category
	 * @return the agent faq category, or <code>null</code> if a agent faq category with the primary key could not be found
	 */
	public static AgentFAQCategory fetchByPrimaryKey(long agentFaqCategoryId) {
		return getPersistence().fetchByPrimaryKey(agentFaqCategoryId);
	}

	/**
	 * Returns all the agent faq categories.
	 *
	 * @return the agent faq categories
	 */
	public static List<AgentFAQCategory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the agent faq categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentFAQCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent faq categories
	 * @param end the upper bound of the range of agent faq categories (not inclusive)
	 * @return the range of agent faq categories
	 */
	public static List<AgentFAQCategory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the agent faq categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentFAQCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent faq categories
	 * @param end the upper bound of the range of agent faq categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agent faq categories
	 */
	public static List<AgentFAQCategory> findAll(
		int start, int end,
		OrderByComparator<AgentFAQCategory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the agent faq categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentFAQCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent faq categories
	 * @param end the upper bound of the range of agent faq categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agent faq categories
	 */
	public static List<AgentFAQCategory> findAll(
		int start, int end,
		OrderByComparator<AgentFAQCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the agent faq categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of agent faq categories.
	 *
	 * @return the number of agent faq categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AgentFAQCategoryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AgentFAQCategoryPersistence _persistence;

}