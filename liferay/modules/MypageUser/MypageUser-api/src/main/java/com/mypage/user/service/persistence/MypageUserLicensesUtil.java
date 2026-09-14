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

import com.mypage.user.model.MypageUserLicenses;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the mypage user licenses service. This utility wraps <code>com.mypage.user.service.persistence.impl.MypageUserLicensesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserLicensesPersistence
 * @generated
 */
public class MypageUserLicensesUtil {

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
	public static void clearCache(MypageUserLicenses mypageUserLicenses) {
		getPersistence().clearCache(mypageUserLicenses);
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
	public static Map<Serializable, MypageUserLicenses> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MypageUserLicenses> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MypageUserLicenses> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MypageUserLicenses> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MypageUserLicenses> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MypageUserLicenses update(
		MypageUserLicenses mypageUserLicenses) {

		return getPersistence().update(mypageUserLicenses);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MypageUserLicenses update(
		MypageUserLicenses mypageUserLicenses, ServiceContext serviceContext) {

		return getPersistence().update(mypageUserLicenses, serviceContext);
	}

	/**
	 * Returns all the mypage user licenseses where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching mypage user licenseses
	 */
	public static List<MypageUserLicenses> findBygetByMypageUserId(
		long mypageUserId) {

		return getPersistence().findBygetByMypageUserId(mypageUserId);
	}

	/**
	 * Returns a range of all the mypage user licenseses where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @return the range of matching mypage user licenseses
	 */
	public static List<MypageUserLicenses> findBygetByMypageUserId(
		long mypageUserId, int start, int end) {

		return getPersistence().findBygetByMypageUserId(
			mypageUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the mypage user licenseses where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching mypage user licenseses
	 */
	public static List<MypageUserLicenses> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MypageUserLicenses> orderByComparator) {

		return getPersistence().findBygetByMypageUserId(
			mypageUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the mypage user licenseses where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching mypage user licenseses
	 */
	public static List<MypageUserLicenses> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MypageUserLicenses> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBygetByMypageUserId(
			mypageUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first mypage user licenses in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user licenses
	 * @throws NoSuchMypageUserLicensesException if a matching mypage user licenses could not be found
	 */
	public static MypageUserLicenses findBygetByMypageUserId_First(
			long mypageUserId,
			OrderByComparator<MypageUserLicenses> orderByComparator)
		throws com.mypage.user.exception.NoSuchMypageUserLicensesException {

		return getPersistence().findBygetByMypageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the first mypage user licenses in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user licenses, or <code>null</code> if a matching mypage user licenses could not be found
	 */
	public static MypageUserLicenses fetchBygetByMypageUserId_First(
		long mypageUserId,
		OrderByComparator<MypageUserLicenses> orderByComparator) {

		return getPersistence().fetchBygetByMypageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last mypage user licenses in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user licenses
	 * @throws NoSuchMypageUserLicensesException if a matching mypage user licenses could not be found
	 */
	public static MypageUserLicenses findBygetByMypageUserId_Last(
			long mypageUserId,
			OrderByComparator<MypageUserLicenses> orderByComparator)
		throws com.mypage.user.exception.NoSuchMypageUserLicensesException {

		return getPersistence().findBygetByMypageUserId_Last(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last mypage user licenses in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user licenses, or <code>null</code> if a matching mypage user licenses could not be found
	 */
	public static MypageUserLicenses fetchBygetByMypageUserId_Last(
		long mypageUserId,
		OrderByComparator<MypageUserLicenses> orderByComparator) {

		return getPersistence().fetchBygetByMypageUserId_Last(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the mypage user licenseses before and after the current mypage user licenses in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserLicensesId the primary key of the current mypage user licenses
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next mypage user licenses
	 * @throws NoSuchMypageUserLicensesException if a mypage user licenses with the primary key could not be found
	 */
	public static MypageUserLicenses[] findBygetByMypageUserId_PrevAndNext(
			long mypageUserLicensesId, long mypageUserId,
			OrderByComparator<MypageUserLicenses> orderByComparator)
		throws com.mypage.user.exception.NoSuchMypageUserLicensesException {

		return getPersistence().findBygetByMypageUserId_PrevAndNext(
			mypageUserLicensesId, mypageUserId, orderByComparator);
	}

	/**
	 * Removes all the mypage user licenseses where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	public static void removeBygetByMypageUserId(long mypageUserId) {
		getPersistence().removeBygetByMypageUserId(mypageUserId);
	}

	/**
	 * Returns the number of mypage user licenseses where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching mypage user licenseses
	 */
	public static int countBygetByMypageUserId(long mypageUserId) {
		return getPersistence().countBygetByMypageUserId(mypageUserId);
	}

	/**
	 * Caches the mypage user licenses in the entity cache if it is enabled.
	 *
	 * @param mypageUserLicenses the mypage user licenses
	 */
	public static void cacheResult(MypageUserLicenses mypageUserLicenses) {
		getPersistence().cacheResult(mypageUserLicenses);
	}

	/**
	 * Caches the mypage user licenseses in the entity cache if it is enabled.
	 *
	 * @param mypageUserLicenseses the mypage user licenseses
	 */
	public static void cacheResult(
		List<MypageUserLicenses> mypageUserLicenseses) {

		getPersistence().cacheResult(mypageUserLicenseses);
	}

	/**
	 * Creates a new mypage user licenses with the primary key. Does not add the mypage user licenses to the database.
	 *
	 * @param mypageUserLicensesId the primary key for the new mypage user licenses
	 * @return the new mypage user licenses
	 */
	public static MypageUserLicenses create(long mypageUserLicensesId) {
		return getPersistence().create(mypageUserLicensesId);
	}

	/**
	 * Removes the mypage user licenses with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserLicensesId the primary key of the mypage user licenses
	 * @return the mypage user licenses that was removed
	 * @throws NoSuchMypageUserLicensesException if a mypage user licenses with the primary key could not be found
	 */
	public static MypageUserLicenses remove(long mypageUserLicensesId)
		throws com.mypage.user.exception.NoSuchMypageUserLicensesException {

		return getPersistence().remove(mypageUserLicensesId);
	}

	public static MypageUserLicenses updateImpl(
		MypageUserLicenses mypageUserLicenses) {

		return getPersistence().updateImpl(mypageUserLicenses);
	}

	/**
	 * Returns the mypage user licenses with the primary key or throws a <code>NoSuchMypageUserLicensesException</code> if it could not be found.
	 *
	 * @param mypageUserLicensesId the primary key of the mypage user licenses
	 * @return the mypage user licenses
	 * @throws NoSuchMypageUserLicensesException if a mypage user licenses with the primary key could not be found
	 */
	public static MypageUserLicenses findByPrimaryKey(long mypageUserLicensesId)
		throws com.mypage.user.exception.NoSuchMypageUserLicensesException {

		return getPersistence().findByPrimaryKey(mypageUserLicensesId);
	}

	/**
	 * Returns the mypage user licenses with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserLicensesId the primary key of the mypage user licenses
	 * @return the mypage user licenses, or <code>null</code> if a mypage user licenses with the primary key could not be found
	 */
	public static MypageUserLicenses fetchByPrimaryKey(
		long mypageUserLicensesId) {

		return getPersistence().fetchByPrimaryKey(mypageUserLicensesId);
	}

	/**
	 * Returns all the mypage user licenseses.
	 *
	 * @return the mypage user licenseses
	 */
	public static List<MypageUserLicenses> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the mypage user licenseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @return the range of mypage user licenseses
	 */
	public static List<MypageUserLicenses> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the mypage user licenseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage user licenseses
	 */
	public static List<MypageUserLicenses> findAll(
		int start, int end,
		OrderByComparator<MypageUserLicenses> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the mypage user licenseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage user licenseses
	 */
	public static List<MypageUserLicenses> findAll(
		int start, int end,
		OrderByComparator<MypageUserLicenses> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the mypage user licenseses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of mypage user licenseses.
	 *
	 * @return the number of mypage user licenseses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MypageUserLicensesPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MypageUserLicensesPersistence _persistence;

}