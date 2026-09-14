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

import com.mypage.agencyportal.exception.NoSuchAgentEmailBucketException;
import com.mypage.agencyportal.model.AgentEmailBucket;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the agent email bucket service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentEmailBucketUtil
 * @generated
 */
@ProviderType
public interface AgentEmailBucketPersistence
	extends BasePersistence<AgentEmailBucket> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AgentEmailBucketUtil} to access the agent email bucket persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the agent email buckets where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @return the matching agent email buckets
	 */
	public java.util.List<AgentEmailBucket> findBystatus(String status_);

	/**
	 * Returns a range of all the agent email buckets where status_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentEmailBucketModelImpl</code>.
	 * </p>
	 *
	 * @param status_ the status_
	 * @param start the lower bound of the range of agent email buckets
	 * @param end the upper bound of the range of agent email buckets (not inclusive)
	 * @return the range of matching agent email buckets
	 */
	public java.util.List<AgentEmailBucket> findBystatus(
		String status_, int start, int end);

	/**
	 * Returns an ordered range of all the agent email buckets where status_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentEmailBucketModelImpl</code>.
	 * </p>
	 *
	 * @param status_ the status_
	 * @param start the lower bound of the range of agent email buckets
	 * @param end the upper bound of the range of agent email buckets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent email buckets
	 */
	public java.util.List<AgentEmailBucket> findBystatus(
		String status_, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentEmailBucket>
			orderByComparator);

	/**
	 * Returns an ordered range of all the agent email buckets where status_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentEmailBucketModelImpl</code>.
	 * </p>
	 *
	 * @param status_ the status_
	 * @param start the lower bound of the range of agent email buckets
	 * @param end the upper bound of the range of agent email buckets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent email buckets
	 */
	public java.util.List<AgentEmailBucket> findBystatus(
		String status_, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentEmailBucket>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first agent email bucket in the ordered set where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent email bucket
	 * @throws NoSuchAgentEmailBucketException if a matching agent email bucket could not be found
	 */
	public AgentEmailBucket findBystatus_First(
			String status_,
			com.liferay.portal.kernel.util.OrderByComparator<AgentEmailBucket>
				orderByComparator)
		throws NoSuchAgentEmailBucketException;

	/**
	 * Returns the first agent email bucket in the ordered set where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent email bucket, or <code>null</code> if a matching agent email bucket could not be found
	 */
	public AgentEmailBucket fetchBystatus_First(
		String status_,
		com.liferay.portal.kernel.util.OrderByComparator<AgentEmailBucket>
			orderByComparator);

	/**
	 * Returns the last agent email bucket in the ordered set where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent email bucket
	 * @throws NoSuchAgentEmailBucketException if a matching agent email bucket could not be found
	 */
	public AgentEmailBucket findBystatus_Last(
			String status_,
			com.liferay.portal.kernel.util.OrderByComparator<AgentEmailBucket>
				orderByComparator)
		throws NoSuchAgentEmailBucketException;

	/**
	 * Returns the last agent email bucket in the ordered set where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent email bucket, or <code>null</code> if a matching agent email bucket could not be found
	 */
	public AgentEmailBucket fetchBystatus_Last(
		String status_,
		com.liferay.portal.kernel.util.OrderByComparator<AgentEmailBucket>
			orderByComparator);

	/**
	 * Returns the agent email buckets before and after the current agent email bucket in the ordered set where status_ = &#63;.
	 *
	 * @param agentEmailBucketId the primary key of the current agent email bucket
	 * @param status_ the status_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent email bucket
	 * @throws NoSuchAgentEmailBucketException if a agent email bucket with the primary key could not be found
	 */
	public AgentEmailBucket[] findBystatus_PrevAndNext(
			long agentEmailBucketId, String status_,
			com.liferay.portal.kernel.util.OrderByComparator<AgentEmailBucket>
				orderByComparator)
		throws NoSuchAgentEmailBucketException;

	/**
	 * Removes all the agent email buckets where status_ = &#63; from the database.
	 *
	 * @param status_ the status_
	 */
	public void removeBystatus(String status_);

	/**
	 * Returns the number of agent email buckets where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @return the number of matching agent email buckets
	 */
	public int countBystatus(String status_);

	/**
	 * Caches the agent email bucket in the entity cache if it is enabled.
	 *
	 * @param agentEmailBucket the agent email bucket
	 */
	public void cacheResult(AgentEmailBucket agentEmailBucket);

	/**
	 * Caches the agent email buckets in the entity cache if it is enabled.
	 *
	 * @param agentEmailBuckets the agent email buckets
	 */
	public void cacheResult(java.util.List<AgentEmailBucket> agentEmailBuckets);

	/**
	 * Creates a new agent email bucket with the primary key. Does not add the agent email bucket to the database.
	 *
	 * @param agentEmailBucketId the primary key for the new agent email bucket
	 * @return the new agent email bucket
	 */
	public AgentEmailBucket create(long agentEmailBucketId);

	/**
	 * Removes the agent email bucket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentEmailBucketId the primary key of the agent email bucket
	 * @return the agent email bucket that was removed
	 * @throws NoSuchAgentEmailBucketException if a agent email bucket with the primary key could not be found
	 */
	public AgentEmailBucket remove(long agentEmailBucketId)
		throws NoSuchAgentEmailBucketException;

	public AgentEmailBucket updateImpl(AgentEmailBucket agentEmailBucket);

	/**
	 * Returns the agent email bucket with the primary key or throws a <code>NoSuchAgentEmailBucketException</code> if it could not be found.
	 *
	 * @param agentEmailBucketId the primary key of the agent email bucket
	 * @return the agent email bucket
	 * @throws NoSuchAgentEmailBucketException if a agent email bucket with the primary key could not be found
	 */
	public AgentEmailBucket findByPrimaryKey(long agentEmailBucketId)
		throws NoSuchAgentEmailBucketException;

	/**
	 * Returns the agent email bucket with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentEmailBucketId the primary key of the agent email bucket
	 * @return the agent email bucket, or <code>null</code> if a agent email bucket with the primary key could not be found
	 */
	public AgentEmailBucket fetchByPrimaryKey(long agentEmailBucketId);

	/**
	 * Returns all the agent email buckets.
	 *
	 * @return the agent email buckets
	 */
	public java.util.List<AgentEmailBucket> findAll();

	/**
	 * Returns a range of all the agent email buckets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentEmailBucketModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent email buckets
	 * @param end the upper bound of the range of agent email buckets (not inclusive)
	 * @return the range of agent email buckets
	 */
	public java.util.List<AgentEmailBucket> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the agent email buckets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentEmailBucketModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent email buckets
	 * @param end the upper bound of the range of agent email buckets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agent email buckets
	 */
	public java.util.List<AgentEmailBucket> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentEmailBucket>
			orderByComparator);

	/**
	 * Returns an ordered range of all the agent email buckets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentEmailBucketModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent email buckets
	 * @param end the upper bound of the range of agent email buckets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agent email buckets
	 */
	public java.util.List<AgentEmailBucket> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AgentEmailBucket>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the agent email buckets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of agent email buckets.
	 *
	 * @return the number of agent email buckets
	 */
	public int countAll();

}