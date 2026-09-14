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

import com.mypage.agencyportal.exception.NoSuchAgentFAQException;
import com.mypage.agencyportal.model.AgentFAQ;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the agent faq service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentFAQUtil
 * @generated
 */
@ProviderType
public interface AgentFAQPersistence extends BasePersistence<AgentFAQ> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AgentFAQUtil} to access the agent faq persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the agent faqs where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching agent faqs
	 */
	public java.util.List<AgentFAQ> findBycategory(String category);

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
	public java.util.List<AgentFAQ> findBycategory(
		String category, int start, int end);

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
	public java.util.List<AgentFAQ> findBycategory(
		String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentFAQ>
			orderByComparator);

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
	public java.util.List<AgentFAQ> findBycategory(
		String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentFAQ>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first agent faq in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent faq
	 * @throws NoSuchAgentFAQException if a matching agent faq could not be found
	 */
	public AgentFAQ findBycategory_First(
			String category,
			com.liferay.portal.kernel.util.OrderByComparator<AgentFAQ>
				orderByComparator)
		throws NoSuchAgentFAQException;

	/**
	 * Returns the first agent faq in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent faq, or <code>null</code> if a matching agent faq could not be found
	 */
	public AgentFAQ fetchBycategory_First(
		String category,
		com.liferay.portal.kernel.util.OrderByComparator<AgentFAQ>
			orderByComparator);

	/**
	 * Returns the last agent faq in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent faq
	 * @throws NoSuchAgentFAQException if a matching agent faq could not be found
	 */
	public AgentFAQ findBycategory_Last(
			String category,
			com.liferay.portal.kernel.util.OrderByComparator<AgentFAQ>
				orderByComparator)
		throws NoSuchAgentFAQException;

	/**
	 * Returns the last agent faq in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent faq, or <code>null</code> if a matching agent faq could not be found
	 */
	public AgentFAQ fetchBycategory_Last(
		String category,
		com.liferay.portal.kernel.util.OrderByComparator<AgentFAQ>
			orderByComparator);

	/**
	 * Returns the agent faqs before and after the current agent faq in the ordered set where category = &#63;.
	 *
	 * @param agentFaqId the primary key of the current agent faq
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent faq
	 * @throws NoSuchAgentFAQException if a agent faq with the primary key could not be found
	 */
	public AgentFAQ[] findBycategory_PrevAndNext(
			long agentFaqId, String category,
			com.liferay.portal.kernel.util.OrderByComparator<AgentFAQ>
				orderByComparator)
		throws NoSuchAgentFAQException;

	/**
	 * Removes all the agent faqs where category = &#63; from the database.
	 *
	 * @param category the category
	 */
	public void removeBycategory(String category);

	/**
	 * Returns the number of agent faqs where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching agent faqs
	 */
	public int countBycategory(String category);

	/**
	 * Caches the agent faq in the entity cache if it is enabled.
	 *
	 * @param agentFAQ the agent faq
	 */
	public void cacheResult(AgentFAQ agentFAQ);

	/**
	 * Caches the agent faqs in the entity cache if it is enabled.
	 *
	 * @param agentFAQs the agent faqs
	 */
	public void cacheResult(java.util.List<AgentFAQ> agentFAQs);

	/**
	 * Creates a new agent faq with the primary key. Does not add the agent faq to the database.
	 *
	 * @param agentFaqId the primary key for the new agent faq
	 * @return the new agent faq
	 */
	public AgentFAQ create(long agentFaqId);

	/**
	 * Removes the agent faq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentFaqId the primary key of the agent faq
	 * @return the agent faq that was removed
	 * @throws NoSuchAgentFAQException if a agent faq with the primary key could not be found
	 */
	public AgentFAQ remove(long agentFaqId) throws NoSuchAgentFAQException;

	public AgentFAQ updateImpl(AgentFAQ agentFAQ);

	/**
	 * Returns the agent faq with the primary key or throws a <code>NoSuchAgentFAQException</code> if it could not be found.
	 *
	 * @param agentFaqId the primary key of the agent faq
	 * @return the agent faq
	 * @throws NoSuchAgentFAQException if a agent faq with the primary key could not be found
	 */
	public AgentFAQ findByPrimaryKey(long agentFaqId)
		throws NoSuchAgentFAQException;

	/**
	 * Returns the agent faq with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentFaqId the primary key of the agent faq
	 * @return the agent faq, or <code>null</code> if a agent faq with the primary key could not be found
	 */
	public AgentFAQ fetchByPrimaryKey(long agentFaqId);

	/**
	 * Returns all the agent faqs.
	 *
	 * @return the agent faqs
	 */
	public java.util.List<AgentFAQ> findAll();

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
	public java.util.List<AgentFAQ> findAll(int start, int end);

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
	public java.util.List<AgentFAQ> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentFAQ>
			orderByComparator);

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
	public java.util.List<AgentFAQ> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentFAQ>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the agent faqs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of agent faqs.
	 *
	 * @return the number of agent faqs
	 */
	public int countAll();

}