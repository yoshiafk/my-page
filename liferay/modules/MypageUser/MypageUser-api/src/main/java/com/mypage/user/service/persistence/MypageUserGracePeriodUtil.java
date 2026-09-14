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

import com.mypage.user.model.MypageUserGracePeriod;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the mypage user grace period service. This utility wraps <code>com.mypage.user.service.persistence.impl.MypageUserGracePeriodPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserGracePeriodPersistence
 * @generated
 */
public class MypageUserGracePeriodUtil {

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
	public static void clearCache(MypageUserGracePeriod mypageUserGracePeriod) {
		getPersistence().clearCache(mypageUserGracePeriod);
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
	public static Map<Serializable, MypageUserGracePeriod> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MypageUserGracePeriod> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MypageUserGracePeriod> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MypageUserGracePeriod> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MypageUserGracePeriod> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MypageUserGracePeriod update(
		MypageUserGracePeriod mypageUserGracePeriod) {

		return getPersistence().update(mypageUserGracePeriod);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MypageUserGracePeriod update(
		MypageUserGracePeriod mypageUserGracePeriod,
		ServiceContext serviceContext) {

		return getPersistence().update(mypageUserGracePeriod, serviceContext);
	}

	/**
	 * Returns all the mypage user grace periods where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching mypage user grace periods
	 */
	public static List<MypageUserGracePeriod> findBygetByMypageUserId(
		long mypageUserId) {

		return getPersistence().findBygetByMypageUserId(mypageUserId);
	}

	/**
	 * Returns a range of all the mypage user grace periods where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @return the range of matching mypage user grace periods
	 */
	public static List<MypageUserGracePeriod> findBygetByMypageUserId(
		long mypageUserId, int start, int end) {

		return getPersistence().findBygetByMypageUserId(
			mypageUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the mypage user grace periods where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching mypage user grace periods
	 */
	public static List<MypageUserGracePeriod> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MypageUserGracePeriod> orderByComparator) {

		return getPersistence().findBygetByMypageUserId(
			mypageUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the mypage user grace periods where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching mypage user grace periods
	 */
	public static List<MypageUserGracePeriod> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MypageUserGracePeriod> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBygetByMypageUserId(
			mypageUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first mypage user grace period in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user grace period
	 * @throws NoSuchMypageUserGracePeriodException if a matching mypage user grace period could not be found
	 */
	public static MypageUserGracePeriod findBygetByMypageUserId_First(
			long mypageUserId,
			OrderByComparator<MypageUserGracePeriod> orderByComparator)
		throws com.mypage.user.exception.NoSuchMypageUserGracePeriodException {

		return getPersistence().findBygetByMypageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the first mypage user grace period in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user grace period, or <code>null</code> if a matching mypage user grace period could not be found
	 */
	public static MypageUserGracePeriod fetchBygetByMypageUserId_First(
		long mypageUserId,
		OrderByComparator<MypageUserGracePeriod> orderByComparator) {

		return getPersistence().fetchBygetByMypageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last mypage user grace period in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user grace period
	 * @throws NoSuchMypageUserGracePeriodException if a matching mypage user grace period could not be found
	 */
	public static MypageUserGracePeriod findBygetByMypageUserId_Last(
			long mypageUserId,
			OrderByComparator<MypageUserGracePeriod> orderByComparator)
		throws com.mypage.user.exception.NoSuchMypageUserGracePeriodException {

		return getPersistence().findBygetByMypageUserId_Last(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last mypage user grace period in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user grace period, or <code>null</code> if a matching mypage user grace period could not be found
	 */
	public static MypageUserGracePeriod fetchBygetByMypageUserId_Last(
		long mypageUserId,
		OrderByComparator<MypageUserGracePeriod> orderByComparator) {

		return getPersistence().fetchBygetByMypageUserId_Last(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the mypage user grace periods before and after the current mypage user grace period in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserGracePeriodId the primary key of the current mypage user grace period
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next mypage user grace period
	 * @throws NoSuchMypageUserGracePeriodException if a mypage user grace period with the primary key could not be found
	 */
	public static MypageUserGracePeriod[] findBygetByMypageUserId_PrevAndNext(
			long mypageUserGracePeriodId, long mypageUserId,
			OrderByComparator<MypageUserGracePeriod> orderByComparator)
		throws com.mypage.user.exception.NoSuchMypageUserGracePeriodException {

		return getPersistence().findBygetByMypageUserId_PrevAndNext(
			mypageUserGracePeriodId, mypageUserId, orderByComparator);
	}

	/**
	 * Removes all the mypage user grace periods where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	public static void removeBygetByMypageUserId(long mypageUserId) {
		getPersistence().removeBygetByMypageUserId(mypageUserId);
	}

	/**
	 * Returns the number of mypage user grace periods where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching mypage user grace periods
	 */
	public static int countBygetByMypageUserId(long mypageUserId) {
		return getPersistence().countBygetByMypageUserId(mypageUserId);
	}

	/**
	 * Caches the mypage user grace period in the entity cache if it is enabled.
	 *
	 * @param mypageUserGracePeriod the mypage user grace period
	 */
	public static void cacheResult(
		MypageUserGracePeriod mypageUserGracePeriod) {

		getPersistence().cacheResult(mypageUserGracePeriod);
	}

	/**
	 * Caches the mypage user grace periods in the entity cache if it is enabled.
	 *
	 * @param mypageUserGracePeriods the mypage user grace periods
	 */
	public static void cacheResult(
		List<MypageUserGracePeriod> mypageUserGracePeriods) {

		getPersistence().cacheResult(mypageUserGracePeriods);
	}

	/**
	 * Creates a new mypage user grace period with the primary key. Does not add the mypage user grace period to the database.
	 *
	 * @param mypageUserGracePeriodId the primary key for the new mypage user grace period
	 * @return the new mypage user grace period
	 */
	public static MypageUserGracePeriod create(long mypageUserGracePeriodId) {
		return getPersistence().create(mypageUserGracePeriodId);
	}

	/**
	 * Removes the mypage user grace period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserGracePeriodId the primary key of the mypage user grace period
	 * @return the mypage user grace period that was removed
	 * @throws NoSuchMypageUserGracePeriodException if a mypage user grace period with the primary key could not be found
	 */
	public static MypageUserGracePeriod remove(long mypageUserGracePeriodId)
		throws com.mypage.user.exception.NoSuchMypageUserGracePeriodException {

		return getPersistence().remove(mypageUserGracePeriodId);
	}

	public static MypageUserGracePeriod updateImpl(
		MypageUserGracePeriod mypageUserGracePeriod) {

		return getPersistence().updateImpl(mypageUserGracePeriod);
	}

	/**
	 * Returns the mypage user grace period with the primary key or throws a <code>NoSuchMypageUserGracePeriodException</code> if it could not be found.
	 *
	 * @param mypageUserGracePeriodId the primary key of the mypage user grace period
	 * @return the mypage user grace period
	 * @throws NoSuchMypageUserGracePeriodException if a mypage user grace period with the primary key could not be found
	 */
	public static MypageUserGracePeriod findByPrimaryKey(
			long mypageUserGracePeriodId)
		throws com.mypage.user.exception.NoSuchMypageUserGracePeriodException {

		return getPersistence().findByPrimaryKey(mypageUserGracePeriodId);
	}

	/**
	 * Returns the mypage user grace period with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserGracePeriodId the primary key of the mypage user grace period
	 * @return the mypage user grace period, or <code>null</code> if a mypage user grace period with the primary key could not be found
	 */
	public static MypageUserGracePeriod fetchByPrimaryKey(
		long mypageUserGracePeriodId) {

		return getPersistence().fetchByPrimaryKey(mypageUserGracePeriodId);
	}

	/**
	 * Returns all the mypage user grace periods.
	 *
	 * @return the mypage user grace periods
	 */
	public static List<MypageUserGracePeriod> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the mypage user grace periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @return the range of mypage user grace periods
	 */
	public static List<MypageUserGracePeriod> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the mypage user grace periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage user grace periods
	 */
	public static List<MypageUserGracePeriod> findAll(
		int start, int end,
		OrderByComparator<MypageUserGracePeriod> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the mypage user grace periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage user grace periods
	 */
	public static List<MypageUserGracePeriod> findAll(
		int start, int end,
		OrderByComparator<MypageUserGracePeriod> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the mypage user grace periods from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of mypage user grace periods.
	 *
	 * @return the number of mypage user grace periods
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MypageUserGracePeriodPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MypageUserGracePeriodPersistence _persistence;

}