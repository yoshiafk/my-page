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

import com.mypage.agencyportal.model.AgentEmailBucket;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the agent email bucket service. This utility wraps <code>com.mypage.agencyportal.service.persistence.impl.AgentEmailBucketPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see AgentEmailBucketPersistence
 * @generated
 */
public class AgentEmailBucketUtil {

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
	public static void clearCache(AgentEmailBucket agentEmailBucket) {
		getPersistence().clearCache(agentEmailBucket);
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
	public static Map<Serializable, AgentEmailBucket> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AgentEmailBucket> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AgentEmailBucket> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AgentEmailBucket> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AgentEmailBucket> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AgentEmailBucket update(AgentEmailBucket agentEmailBucket) {
		return getPersistence().update(agentEmailBucket);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AgentEmailBucket update(
		AgentEmailBucket agentEmailBucket, ServiceContext serviceContext) {

		return getPersistence().update(agentEmailBucket, serviceContext);
	}

	/**
	 * Returns all the agent email buckets where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @return the matching agent email buckets
	 */
	public static List<AgentEmailBucket> findBystatus(String status_) {
		return getPersistence().findBystatus(status_);
	}

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
	public static List<AgentEmailBucket> findBystatus(
		String status_, int start, int end) {

		return getPersistence().findBystatus(status_, start, end);
	}

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
	public static List<AgentEmailBucket> findBystatus(
		String status_, int start, int end,
		OrderByComparator<AgentEmailBucket> orderByComparator) {

		return getPersistence().findBystatus(
			status_, start, end, orderByComparator);
	}

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
	public static List<AgentEmailBucket> findBystatus(
		String status_, int start, int end,
		OrderByComparator<AgentEmailBucket> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBystatus(
			status_, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agent email bucket in the ordered set where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent email bucket
	 * @throws NoSuchAgentEmailBucketException if a matching agent email bucket could not be found
	 */
	public static AgentEmailBucket findBystatus_First(
			String status_,
			OrderByComparator<AgentEmailBucket> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentEmailBucketException {

		return getPersistence().findBystatus_First(status_, orderByComparator);
	}

	/**
	 * Returns the first agent email bucket in the ordered set where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent email bucket, or <code>null</code> if a matching agent email bucket could not be found
	 */
	public static AgentEmailBucket fetchBystatus_First(
		String status_, OrderByComparator<AgentEmailBucket> orderByComparator) {

		return getPersistence().fetchBystatus_First(status_, orderByComparator);
	}

	/**
	 * Returns the last agent email bucket in the ordered set where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent email bucket
	 * @throws NoSuchAgentEmailBucketException if a matching agent email bucket could not be found
	 */
	public static AgentEmailBucket findBystatus_Last(
			String status_,
			OrderByComparator<AgentEmailBucket> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentEmailBucketException {

		return getPersistence().findBystatus_Last(status_, orderByComparator);
	}

	/**
	 * Returns the last agent email bucket in the ordered set where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent email bucket, or <code>null</code> if a matching agent email bucket could not be found
	 */
	public static AgentEmailBucket fetchBystatus_Last(
		String status_, OrderByComparator<AgentEmailBucket> orderByComparator) {

		return getPersistence().fetchBystatus_Last(status_, orderByComparator);
	}

	/**
	 * Returns the agent email buckets before and after the current agent email bucket in the ordered set where status_ = &#63;.
	 *
	 * @param agentEmailBucketId the primary key of the current agent email bucket
	 * @param status_ the status_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent email bucket
	 * @throws NoSuchAgentEmailBucketException if a agent email bucket with the primary key could not be found
	 */
	public static AgentEmailBucket[] findBystatus_PrevAndNext(
			long agentEmailBucketId, String status_,
			OrderByComparator<AgentEmailBucket> orderByComparator)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentEmailBucketException {

		return getPersistence().findBystatus_PrevAndNext(
			agentEmailBucketId, status_, orderByComparator);
	}

	/**
	 * Removes all the agent email buckets where status_ = &#63; from the database.
	 *
	 * @param status_ the status_
	 */
	public static void removeBystatus(String status_) {
		getPersistence().removeBystatus(status_);
	}

	/**
	 * Returns the number of agent email buckets where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @return the number of matching agent email buckets
	 */
	public static int countBystatus(String status_) {
		return getPersistence().countBystatus(status_);
	}

	/**
	 * Caches the agent email bucket in the entity cache if it is enabled.
	 *
	 * @param agentEmailBucket the agent email bucket
	 */
	public static void cacheResult(AgentEmailBucket agentEmailBucket) {
		getPersistence().cacheResult(agentEmailBucket);
	}

	/**
	 * Caches the agent email buckets in the entity cache if it is enabled.
	 *
	 * @param agentEmailBuckets the agent email buckets
	 */
	public static void cacheResult(List<AgentEmailBucket> agentEmailBuckets) {
		getPersistence().cacheResult(agentEmailBuckets);
	}

	/**
	 * Creates a new agent email bucket with the primary key. Does not add the agent email bucket to the database.
	 *
	 * @param agentEmailBucketId the primary key for the new agent email bucket
	 * @return the new agent email bucket
	 */
	public static AgentEmailBucket create(long agentEmailBucketId) {
		return getPersistence().create(agentEmailBucketId);
	}

	/**
	 * Removes the agent email bucket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentEmailBucketId the primary key of the agent email bucket
	 * @return the agent email bucket that was removed
	 * @throws NoSuchAgentEmailBucketException if a agent email bucket with the primary key could not be found
	 */
	public static AgentEmailBucket remove(long agentEmailBucketId)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentEmailBucketException {

		return getPersistence().remove(agentEmailBucketId);
	}

	public static AgentEmailBucket updateImpl(
		AgentEmailBucket agentEmailBucket) {

		return getPersistence().updateImpl(agentEmailBucket);
	}

	/**
	 * Returns the agent email bucket with the primary key or throws a <code>NoSuchAgentEmailBucketException</code> if it could not be found.
	 *
	 * @param agentEmailBucketId the primary key of the agent email bucket
	 * @return the agent email bucket
	 * @throws NoSuchAgentEmailBucketException if a agent email bucket with the primary key could not be found
	 */
	public static AgentEmailBucket findByPrimaryKey(long agentEmailBucketId)
		throws com.mypage.agencyportal.exception.
			NoSuchAgentEmailBucketException {

		return getPersistence().findByPrimaryKey(agentEmailBucketId);
	}

	/**
	 * Returns the agent email bucket with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentEmailBucketId the primary key of the agent email bucket
	 * @return the agent email bucket, or <code>null</code> if a agent email bucket with the primary key could not be found
	 */
	public static AgentEmailBucket fetchByPrimaryKey(long agentEmailBucketId) {
		return getPersistence().fetchByPrimaryKey(agentEmailBucketId);
	}

	/**
	 * Returns all the agent email buckets.
	 *
	 * @return the agent email buckets
	 */
	public static List<AgentEmailBucket> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<AgentEmailBucket> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<AgentEmailBucket> findAll(
		int start, int end,
		OrderByComparator<AgentEmailBucket> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<AgentEmailBucket> findAll(
		int start, int end,
		OrderByComparator<AgentEmailBucket> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the agent email buckets from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of agent email buckets.
	 *
	 * @return the number of agent email buckets
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AgentEmailBucketPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AgentEmailBucketPersistence _persistence;

}