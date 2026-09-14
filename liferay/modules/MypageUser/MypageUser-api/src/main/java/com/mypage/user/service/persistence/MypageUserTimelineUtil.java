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

package com.mypage.user.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.user.model.MypageUserTimeline;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the mypage user timeline service. This utility wraps <code>com.mypage.user.service.persistence.impl.MypageUserTimelinePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserTimelinePersistence
 * @generated
 */
public class MypageUserTimelineUtil {

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
	public static void clearCache(MypageUserTimeline mypageUserTimeline) {
		getPersistence().clearCache(mypageUserTimeline);
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
	public static Map<Serializable, MypageUserTimeline> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MypageUserTimeline> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MypageUserTimeline> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MypageUserTimeline> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MypageUserTimeline> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MypageUserTimeline update(
		MypageUserTimeline mypageUserTimeline) {

		return getPersistence().update(mypageUserTimeline);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MypageUserTimeline update(
		MypageUserTimeline mypageUserTimeline, ServiceContext serviceContext) {

		return getPersistence().update(mypageUserTimeline, serviceContext);
	}

	/**
	 * Returns all the mypage user timelines where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching mypage user timelines
	 */
	public static List<MypageUserTimeline> findBygetByMypageUserId(
		long mypageUserId) {

		return getPersistence().findBygetByMypageUserId(mypageUserId);
	}

	/**
	 * Returns a range of all the mypage user timelines where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user timelines
	 * @param end the upper bound of the range of mypage user timelines (not inclusive)
	 * @return the range of matching mypage user timelines
	 */
	public static List<MypageUserTimeline> findBygetByMypageUserId(
		long mypageUserId, int start, int end) {

		return getPersistence().findBygetByMypageUserId(
			mypageUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the mypage user timelines where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user timelines
	 * @param end the upper bound of the range of mypage user timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching mypage user timelines
	 */
	public static List<MypageUserTimeline> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MypageUserTimeline> orderByComparator) {

		return getPersistence().findBygetByMypageUserId(
			mypageUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the mypage user timelines where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user timelines
	 * @param end the upper bound of the range of mypage user timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching mypage user timelines
	 */
	public static List<MypageUserTimeline> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MypageUserTimeline> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBygetByMypageUserId(
			mypageUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first mypage user timeline in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user timeline
	 * @throws NoSuchMypageUserTimelineException if a matching mypage user timeline could not be found
	 */
	public static MypageUserTimeline findBygetByMypageUserId_First(
			long mypageUserId,
			OrderByComparator<MypageUserTimeline> orderByComparator)
		throws com.mypage.user.exception.NoSuchMypageUserTimelineException {

		return getPersistence().findBygetByMypageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the first mypage user timeline in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user timeline, or <code>null</code> if a matching mypage user timeline could not be found
	 */
	public static MypageUserTimeline fetchBygetByMypageUserId_First(
		long mypageUserId,
		OrderByComparator<MypageUserTimeline> orderByComparator) {

		return getPersistence().fetchBygetByMypageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last mypage user timeline in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user timeline
	 * @throws NoSuchMypageUserTimelineException if a matching mypage user timeline could not be found
	 */
	public static MypageUserTimeline findBygetByMypageUserId_Last(
			long mypageUserId,
			OrderByComparator<MypageUserTimeline> orderByComparator)
		throws com.mypage.user.exception.NoSuchMypageUserTimelineException {

		return getPersistence().findBygetByMypageUserId_Last(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last mypage user timeline in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user timeline, or <code>null</code> if a matching mypage user timeline could not be found
	 */
	public static MypageUserTimeline fetchBygetByMypageUserId_Last(
		long mypageUserId,
		OrderByComparator<MypageUserTimeline> orderByComparator) {

		return getPersistence().fetchBygetByMypageUserId_Last(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the mypage user timelines before and after the current mypage user timeline in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserTimelineId the primary key of the current mypage user timeline
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next mypage user timeline
	 * @throws NoSuchMypageUserTimelineException if a mypage user timeline with the primary key could not be found
	 */
	public static MypageUserTimeline[] findBygetByMypageUserId_PrevAndNext(
			long mypageUserTimelineId, long mypageUserId,
			OrderByComparator<MypageUserTimeline> orderByComparator)
		throws com.mypage.user.exception.NoSuchMypageUserTimelineException {

		return getPersistence().findBygetByMypageUserId_PrevAndNext(
			mypageUserTimelineId, mypageUserId, orderByComparator);
	}

	/**
	 * Removes all the mypage user timelines where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	public static void removeBygetByMypageUserId(long mypageUserId) {
		getPersistence().removeBygetByMypageUserId(mypageUserId);
	}

	/**
	 * Returns the number of mypage user timelines where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching mypage user timelines
	 */
	public static int countBygetByMypageUserId(long mypageUserId) {
		return getPersistence().countBygetByMypageUserId(mypageUserId);
	}

	/**
	 * Caches the mypage user timeline in the entity cache if it is enabled.
	 *
	 * @param mypageUserTimeline the mypage user timeline
	 */
	public static void cacheResult(MypageUserTimeline mypageUserTimeline) {
		getPersistence().cacheResult(mypageUserTimeline);
	}

	/**
	 * Caches the mypage user timelines in the entity cache if it is enabled.
	 *
	 * @param mypageUserTimelines the mypage user timelines
	 */
	public static void cacheResult(
		List<MypageUserTimeline> mypageUserTimelines) {

		getPersistence().cacheResult(mypageUserTimelines);
	}

	/**
	 * Creates a new mypage user timeline with the primary key. Does not add the mypage user timeline to the database.
	 *
	 * @param mypageUserTimelineId the primary key for the new mypage user timeline
	 * @return the new mypage user timeline
	 */
	public static MypageUserTimeline create(long mypageUserTimelineId) {
		return getPersistence().create(mypageUserTimelineId);
	}

	/**
	 * Removes the mypage user timeline with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserTimelineId the primary key of the mypage user timeline
	 * @return the mypage user timeline that was removed
	 * @throws NoSuchMypageUserTimelineException if a mypage user timeline with the primary key could not be found
	 */
	public static MypageUserTimeline remove(long mypageUserTimelineId)
		throws com.mypage.user.exception.NoSuchMypageUserTimelineException {

		return getPersistence().remove(mypageUserTimelineId);
	}

	public static MypageUserTimeline updateImpl(
		MypageUserTimeline mypageUserTimeline) {

		return getPersistence().updateImpl(mypageUserTimeline);
	}

	/**
	 * Returns the mypage user timeline with the primary key or throws a <code>NoSuchMypageUserTimelineException</code> if it could not be found.
	 *
	 * @param mypageUserTimelineId the primary key of the mypage user timeline
	 * @return the mypage user timeline
	 * @throws NoSuchMypageUserTimelineException if a mypage user timeline with the primary key could not be found
	 */
	public static MypageUserTimeline findByPrimaryKey(long mypageUserTimelineId)
		throws com.mypage.user.exception.NoSuchMypageUserTimelineException {

		return getPersistence().findByPrimaryKey(mypageUserTimelineId);
	}

	/**
	 * Returns the mypage user timeline with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserTimelineId the primary key of the mypage user timeline
	 * @return the mypage user timeline, or <code>null</code> if a mypage user timeline with the primary key could not be found
	 */
	public static MypageUserTimeline fetchByPrimaryKey(
		long mypageUserTimelineId) {

		return getPersistence().fetchByPrimaryKey(mypageUserTimelineId);
	}

	/**
	 * Returns all the mypage user timelines.
	 *
	 * @return the mypage user timelines
	 */
	public static List<MypageUserTimeline> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the mypage user timelines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user timelines
	 * @param end the upper bound of the range of mypage user timelines (not inclusive)
	 * @return the range of mypage user timelines
	 */
	public static List<MypageUserTimeline> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the mypage user timelines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user timelines
	 * @param end the upper bound of the range of mypage user timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage user timelines
	 */
	public static List<MypageUserTimeline> findAll(
		int start, int end,
		OrderByComparator<MypageUserTimeline> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the mypage user timelines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user timelines
	 * @param end the upper bound of the range of mypage user timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage user timelines
	 */
	public static List<MypageUserTimeline> findAll(
		int start, int end,
		OrderByComparator<MypageUserTimeline> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the mypage user timelines from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of mypage user timelines.
	 *
	 * @return the number of mypage user timelines
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MypageUserTimelinePersistence getPersistence() {
		return _persistence;
	}

	private static volatile MypageUserTimelinePersistence _persistence;

}