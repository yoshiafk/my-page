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

import com.mypage.user.model.MypageUserWorkingHour;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the mypage user working hour service. This utility wraps <code>com.mypage.user.service.persistence.impl.MypageUserWorkingHourPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserWorkingHourPersistence
 * @generated
 */
public class MypageUserWorkingHourUtil {

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
	public static void clearCache(MypageUserWorkingHour mypageUserWorkingHour) {
		getPersistence().clearCache(mypageUserWorkingHour);
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
	public static Map<Serializable, MypageUserWorkingHour> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MypageUserWorkingHour> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MypageUserWorkingHour> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MypageUserWorkingHour> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MypageUserWorkingHour> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MypageUserWorkingHour update(
		MypageUserWorkingHour mypageUserWorkingHour) {

		return getPersistence().update(mypageUserWorkingHour);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MypageUserWorkingHour update(
		MypageUserWorkingHour mypageUserWorkingHour,
		ServiceContext serviceContext) {

		return getPersistence().update(mypageUserWorkingHour, serviceContext);
	}

	/**
	 * Returns all the mypage user working hours where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching mypage user working hours
	 */
	public static List<MypageUserWorkingHour> findBygetByMypageUserId(
		long mypageUserId) {

		return getPersistence().findBygetByMypageUserId(mypageUserId);
	}

	/**
	 * Returns a range of all the mypage user working hours where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @return the range of matching mypage user working hours
	 */
	public static List<MypageUserWorkingHour> findBygetByMypageUserId(
		long mypageUserId, int start, int end) {

		return getPersistence().findBygetByMypageUserId(
			mypageUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the mypage user working hours where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching mypage user working hours
	 */
	public static List<MypageUserWorkingHour> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MypageUserWorkingHour> orderByComparator) {

		return getPersistence().findBygetByMypageUserId(
			mypageUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the mypage user working hours where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching mypage user working hours
	 */
	public static List<MypageUserWorkingHour> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MypageUserWorkingHour> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBygetByMypageUserId(
			mypageUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first mypage user working hour in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user working hour
	 * @throws NoSuchMypageUserWorkingHourException if a matching mypage user working hour could not be found
	 */
	public static MypageUserWorkingHour findBygetByMypageUserId_First(
			long mypageUserId,
			OrderByComparator<MypageUserWorkingHour> orderByComparator)
		throws com.mypage.user.exception.NoSuchMypageUserWorkingHourException {

		return getPersistence().findBygetByMypageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the first mypage user working hour in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user working hour, or <code>null</code> if a matching mypage user working hour could not be found
	 */
	public static MypageUserWorkingHour fetchBygetByMypageUserId_First(
		long mypageUserId,
		OrderByComparator<MypageUserWorkingHour> orderByComparator) {

		return getPersistence().fetchBygetByMypageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last mypage user working hour in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user working hour
	 * @throws NoSuchMypageUserWorkingHourException if a matching mypage user working hour could not be found
	 */
	public static MypageUserWorkingHour findBygetByMypageUserId_Last(
			long mypageUserId,
			OrderByComparator<MypageUserWorkingHour> orderByComparator)
		throws com.mypage.user.exception.NoSuchMypageUserWorkingHourException {

		return getPersistence().findBygetByMypageUserId_Last(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last mypage user working hour in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user working hour, or <code>null</code> if a matching mypage user working hour could not be found
	 */
	public static MypageUserWorkingHour fetchBygetByMypageUserId_Last(
		long mypageUserId,
		OrderByComparator<MypageUserWorkingHour> orderByComparator) {

		return getPersistence().fetchBygetByMypageUserId_Last(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the mypage user working hours before and after the current mypage user working hour in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserWorkingHourId the primary key of the current mypage user working hour
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next mypage user working hour
	 * @throws NoSuchMypageUserWorkingHourException if a mypage user working hour with the primary key could not be found
	 */
	public static MypageUserWorkingHour[] findBygetByMypageUserId_PrevAndNext(
			long mypageUserWorkingHourId, long mypageUserId,
			OrderByComparator<MypageUserWorkingHour> orderByComparator)
		throws com.mypage.user.exception.NoSuchMypageUserWorkingHourException {

		return getPersistence().findBygetByMypageUserId_PrevAndNext(
			mypageUserWorkingHourId, mypageUserId, orderByComparator);
	}

	/**
	 * Removes all the mypage user working hours where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	public static void removeBygetByMypageUserId(long mypageUserId) {
		getPersistence().removeBygetByMypageUserId(mypageUserId);
	}

	/**
	 * Returns the number of mypage user working hours where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching mypage user working hours
	 */
	public static int countBygetByMypageUserId(long mypageUserId) {
		return getPersistence().countBygetByMypageUserId(mypageUserId);
	}

	/**
	 * Caches the mypage user working hour in the entity cache if it is enabled.
	 *
	 * @param mypageUserWorkingHour the mypage user working hour
	 */
	public static void cacheResult(
		MypageUserWorkingHour mypageUserWorkingHour) {

		getPersistence().cacheResult(mypageUserWorkingHour);
	}

	/**
	 * Caches the mypage user working hours in the entity cache if it is enabled.
	 *
	 * @param mypageUserWorkingHours the mypage user working hours
	 */
	public static void cacheResult(
		List<MypageUserWorkingHour> mypageUserWorkingHours) {

		getPersistence().cacheResult(mypageUserWorkingHours);
	}

	/**
	 * Creates a new mypage user working hour with the primary key. Does not add the mypage user working hour to the database.
	 *
	 * @param mypageUserWorkingHourId the primary key for the new mypage user working hour
	 * @return the new mypage user working hour
	 */
	public static MypageUserWorkingHour create(long mypageUserWorkingHourId) {
		return getPersistence().create(mypageUserWorkingHourId);
	}

	/**
	 * Removes the mypage user working hour with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserWorkingHourId the primary key of the mypage user working hour
	 * @return the mypage user working hour that was removed
	 * @throws NoSuchMypageUserWorkingHourException if a mypage user working hour with the primary key could not be found
	 */
	public static MypageUserWorkingHour remove(long mypageUserWorkingHourId)
		throws com.mypage.user.exception.NoSuchMypageUserWorkingHourException {

		return getPersistence().remove(mypageUserWorkingHourId);
	}

	public static MypageUserWorkingHour updateImpl(
		MypageUserWorkingHour mypageUserWorkingHour) {

		return getPersistence().updateImpl(mypageUserWorkingHour);
	}

	/**
	 * Returns the mypage user working hour with the primary key or throws a <code>NoSuchMypageUserWorkingHourException</code> if it could not be found.
	 *
	 * @param mypageUserWorkingHourId the primary key of the mypage user working hour
	 * @return the mypage user working hour
	 * @throws NoSuchMypageUserWorkingHourException if a mypage user working hour with the primary key could not be found
	 */
	public static MypageUserWorkingHour findByPrimaryKey(
			long mypageUserWorkingHourId)
		throws com.mypage.user.exception.NoSuchMypageUserWorkingHourException {

		return getPersistence().findByPrimaryKey(mypageUserWorkingHourId);
	}

	/**
	 * Returns the mypage user working hour with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserWorkingHourId the primary key of the mypage user working hour
	 * @return the mypage user working hour, or <code>null</code> if a mypage user working hour with the primary key could not be found
	 */
	public static MypageUserWorkingHour fetchByPrimaryKey(
		long mypageUserWorkingHourId) {

		return getPersistence().fetchByPrimaryKey(mypageUserWorkingHourId);
	}

	/**
	 * Returns all the mypage user working hours.
	 *
	 * @return the mypage user working hours
	 */
	public static List<MypageUserWorkingHour> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the mypage user working hours.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @return the range of mypage user working hours
	 */
	public static List<MypageUserWorkingHour> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the mypage user working hours.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage user working hours
	 */
	public static List<MypageUserWorkingHour> findAll(
		int start, int end,
		OrderByComparator<MypageUserWorkingHour> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the mypage user working hours.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage user working hours
	 */
	public static List<MypageUserWorkingHour> findAll(
		int start, int end,
		OrderByComparator<MypageUserWorkingHour> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the mypage user working hours from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of mypage user working hours.
	 *
	 * @return the number of mypage user working hours
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MypageUserWorkingHourPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MypageUserWorkingHourPersistence _persistence;

}