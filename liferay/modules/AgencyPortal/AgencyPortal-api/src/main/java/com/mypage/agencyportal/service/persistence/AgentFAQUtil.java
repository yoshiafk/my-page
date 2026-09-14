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

import com.mypage.agencyportal.model.AgentFAQ;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the agent faq service. This utility wraps <code>com.mypage.agencyportal.service.persistence.impl.AgentFAQPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentFAQPersistence
 * @generated
 */
public class AgentFAQUtil {

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
	public static void clearCache(AgentFAQ agentFAQ) {
		getPersistence().clearCache(agentFAQ);
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
	public static Map<Serializable, AgentFAQ> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AgentFAQ> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AgentFAQ> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AgentFAQ> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AgentFAQ> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AgentFAQ update(AgentFAQ agentFAQ) {
		return getPersistence().update(agentFAQ);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AgentFAQ update(
		AgentFAQ agentFAQ, ServiceContext serviceContext) {

		return getPersistence().update(agentFAQ, serviceContext);
	}

	/**
	 * Returns all the agent faqs where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching agent faqs
	 */
	public static List<AgentFAQ> findBycategory(String category) {
		return getPersistence().findBycategory(category);
	}

	/**
	 * Returns a range of all the agent faqs where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentFAQModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of agent faqs
	 * @param end the upper bound of the range of agent faqs (not inclusive)
	 * @return the range of matching agent faqs
	 */
	public static List<AgentFAQ> findBycategory(
		String category, int start, int end) {

		return getPersistence().findBycategory(category, start, end);
	}

	/**
	 * Returns an ordered range of all the agent faqs where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentFAQModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of agent faqs
	 * @param end the upper bound of the range of agent faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent faqs
	 */
	public static List<AgentFAQ> findBycategory(
		String category, int start, int end,
		OrderByComparator<AgentFAQ> orderByComparator) {

		return getPersistence().findBycategory(
			category, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the agent faqs where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentFAQModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of agent faqs
	 * @param end the upper bound of the range of agent faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent faqs
	 */
	public static List<AgentFAQ> findBycategory(
		String category, int start, int end,
		OrderByComparator<AgentFAQ> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBycategory(
			category, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agent faq in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent faq
	 * @throws NoSuchAgentFAQException if a matching agent faq could not be found
	 */
	public static AgentFAQ findBycategory_First(
			String category, OrderByComparator<AgentFAQ> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentFAQException {

		return getPersistence().findBycategory_First(
			category, orderByComparator);
	}

	/**
	 * Returns the first agent faq in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent faq, or <code>null</code> if a matching agent faq could not be found
	 */
	public static AgentFAQ fetchBycategory_First(
		String category, OrderByComparator<AgentFAQ> orderByComparator) {

		return getPersistence().fetchBycategory_First(
			category, orderByComparator);
	}

	/**
	 * Returns the last agent faq in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent faq
	 * @throws NoSuchAgentFAQException if a matching agent faq could not be found
	 */
	public static AgentFAQ findBycategory_Last(
			String category, OrderByComparator<AgentFAQ> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentFAQException {

		return getPersistence().findBycategory_Last(
			category, orderByComparator);
	}

	/**
	 * Returns the last agent faq in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent faq, or <code>null</code> if a matching agent faq could not be found
	 */
	public static AgentFAQ fetchBycategory_Last(
		String category, OrderByComparator<AgentFAQ> orderByComparator) {

		return getPersistence().fetchBycategory_Last(
			category, orderByComparator);
	}

	/**
	 * Returns the agent faqs before and after the current agent faq in the ordered set where category = &#63;.
	 *
	 * @param agentFaqId the primary key of the current agent faq
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent faq
	 * @throws NoSuchAgentFAQException if a agent faq with the primary key could not be found
	 */
	public static AgentFAQ[] findBycategory_PrevAndNext(
			long agentFaqId, String category,
			OrderByComparator<AgentFAQ> orderByComparator)
		throws com.mypage.agencyportal.exception.NoSuchAgentFAQException {

		return getPersistence().findBycategory_PrevAndNext(
			agentFaqId, category, orderByComparator);
	}

	/**
	 * Removes all the agent faqs where category = &#63; from the database.
	 *
	 * @param category the category
	 */
	public static void removeBycategory(String category) {
		getPersistence().removeBycategory(category);
	}

	/**
	 * Returns the number of agent faqs where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching agent faqs
	 */
	public static int countBycategory(String category) {
		return getPersistence().countBycategory(category);
	}

	/**
	 * Caches the agent faq in the entity cache if it is enabled.
	 *
	 * @param agentFAQ the agent faq
	 */
	public static void cacheResult(AgentFAQ agentFAQ) {
		getPersistence().cacheResult(agentFAQ);
	}

	/**
	 * Caches the agent faqs in the entity cache if it is enabled.
	 *
	 * @param agentFAQs the agent faqs
	 */
	public static void cacheResult(List<AgentFAQ> agentFAQs) {
		getPersistence().cacheResult(agentFAQs);
	}

	/**
	 * Creates a new agent faq with the primary key. Does not add the agent faq to the database.
	 *
	 * @param agentFaqId the primary key for the new agent faq
	 * @return the new agent faq
	 */
	public static AgentFAQ create(long agentFaqId) {
		return getPersistence().create(agentFaqId);
	}

	/**
	 * Removes the agent faq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentFaqId the primary key of the agent faq
	 * @return the agent faq that was removed
	 * @throws NoSuchAgentFAQException if a agent faq with the primary key could not be found
	 */
	public static AgentFAQ remove(long agentFaqId)
		throws com.mypage.agencyportal.exception.NoSuchAgentFAQException {

		return getPersistence().remove(agentFaqId);
	}

	public static AgentFAQ updateImpl(AgentFAQ agentFAQ) {
		return getPersistence().updateImpl(agentFAQ);
	}

	/**
	 * Returns the agent faq with the primary key or throws a <code>NoSuchAgentFAQException</code> if it could not be found.
	 *
	 * @param agentFaqId the primary key of the agent faq
	 * @return the agent faq
	 * @throws NoSuchAgentFAQException if a agent faq with the primary key could not be found
	 */
	public static AgentFAQ findByPrimaryKey(long agentFaqId)
		throws com.mypage.agencyportal.exception.NoSuchAgentFAQException {

		return getPersistence().findByPrimaryKey(agentFaqId);
	}

	/**
	 * Returns the agent faq with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentFaqId the primary key of the agent faq
	 * @return the agent faq, or <code>null</code> if a agent faq with the primary key could not be found
	 */
	public static AgentFAQ fetchByPrimaryKey(long agentFaqId) {
		return getPersistence().fetchByPrimaryKey(agentFaqId);
	}

	/**
	 * Returns all the agent faqs.
	 *
	 * @return the agent faqs
	 */
	public static List<AgentFAQ> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the agent faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentFAQModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent faqs
	 * @param end the upper bound of the range of agent faqs (not inclusive)
	 * @return the range of agent faqs
	 */
	public static List<AgentFAQ> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the agent faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentFAQModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent faqs
	 * @param end the upper bound of the range of agent faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agent faqs
	 */
	public static List<AgentFAQ> findAll(
		int start, int end, OrderByComparator<AgentFAQ> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the agent faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentFAQModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent faqs
	 * @param end the upper bound of the range of agent faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agent faqs
	 */
	public static List<AgentFAQ> findAll(
		int start, int end, OrderByComparator<AgentFAQ> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the agent faqs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of agent faqs.
	 *
	 * @return the number of agent faqs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AgentFAQPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AgentFAQPersistence _persistence;

}