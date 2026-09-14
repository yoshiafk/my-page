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

import com.mypage.agencyportal.exception.NoSuchAgentFAQCategoryException;
import com.mypage.agencyportal.model.AgentFAQCategory;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the agent faq category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentFAQCategoryUtil
 * @generated
 */
@ProviderType
public interface AgentFAQCategoryPersistence
	extends BasePersistence<AgentFAQCategory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AgentFAQCategoryUtil} to access the agent faq category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the agent faq category in the entity cache if it is enabled.
	 *
	 * @param agentFAQCategory the agent faq category
	 */
	public void cacheResult(AgentFAQCategory agentFAQCategory);

	/**
	 * Caches the agent faq categories in the entity cache if it is enabled.
	 *
	 * @param agentFAQCategories the agent faq categories
	 */
	public void cacheResult(
		java.util.List<AgentFAQCategory> agentFAQCategories);

	/**
	 * Creates a new agent faq category with the primary key. Does not add the agent faq category to the database.
	 *
	 * @param agentFaqCategoryId the primary key for the new agent faq category
	 * @return the new agent faq category
	 */
	public AgentFAQCategory create(long agentFaqCategoryId);

	/**
	 * Removes the agent faq category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentFaqCategoryId the primary key of the agent faq category
	 * @return the agent faq category that was removed
	 * @throws NoSuchAgentFAQCategoryException if a agent faq category with the primary key could not be found
	 */
	public AgentFAQCategory remove(long agentFaqCategoryId)
		throws NoSuchAgentFAQCategoryException;

	public AgentFAQCategory updateImpl(AgentFAQCategory agentFAQCategory);

	/**
	 * Returns the agent faq category with the primary key or throws a <code>NoSuchAgentFAQCategoryException</code> if it could not be found.
	 *
	 * @param agentFaqCategoryId the primary key of the agent faq category
	 * @return the agent faq category
	 * @throws NoSuchAgentFAQCategoryException if a agent faq category with the primary key could not be found
	 */
	public AgentFAQCategory findByPrimaryKey(long agentFaqCategoryId)
		throws NoSuchAgentFAQCategoryException;

	/**
	 * Returns the agent faq category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentFaqCategoryId the primary key of the agent faq category
	 * @return the agent faq category, or <code>null</code> if a agent faq category with the primary key could not be found
	 */
	public AgentFAQCategory fetchByPrimaryKey(long agentFaqCategoryId);

	/**
	 * Returns all the agent faq categories.
	 *
	 * @return the agent faq categories
	 */
	public java.util.List<AgentFAQCategory> findAll();

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
	public java.util.List<AgentFAQCategory> findAll(int start, int end);

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
	public java.util.List<AgentFAQCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentFAQCategory>
			orderByComparator);

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
	public java.util.List<AgentFAQCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentFAQCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the agent faq categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of agent faq categories.
	 *
	 * @return the number of agent faq categories
	 */
	public int countAll();

}