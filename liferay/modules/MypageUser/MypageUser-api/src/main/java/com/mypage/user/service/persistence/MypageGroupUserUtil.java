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

import com.mypage.user.model.MypageGroupUser;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the mypage group user service. This utility wraps <code>com.mypage.user.service.persistence.impl.MypageGroupUserPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageGroupUserPersistence
 * @generated
 */
public class MypageGroupUserUtil {

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
	public static void clearCache(MypageGroupUser mypageGroupUser) {
		getPersistence().clearCache(mypageGroupUser);
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
	public static Map<Serializable, MypageGroupUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MypageGroupUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MypageGroupUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MypageGroupUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MypageGroupUser> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MypageGroupUser update(MypageGroupUser mypageGroupUser) {
		return getPersistence().update(mypageGroupUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MypageGroupUser update(
		MypageGroupUser mypageGroupUser, ServiceContext serviceContext) {

		return getPersistence().update(mypageGroupUser, serviceContext);
	}

	/**
	 * Returns all the mypage group users where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @return the matching mypage group users
	 */
	public static List<MypageGroupUser> findBymypageGroupId(
		long mypageGroupId) {

		return getPersistence().findBymypageGroupId(mypageGroupId);
	}

	/**
	 * Returns a range of all the mypage group users where mypageGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageGroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param start the lower bound of the range of mypage group users
	 * @param end the upper bound of the range of mypage group users (not inclusive)
	 * @return the range of matching mypage group users
	 */
	public static List<MypageGroupUser> findBymypageGroupId(
		long mypageGroupId, int start, int end) {

		return getPersistence().findBymypageGroupId(mypageGroupId, start, end);
	}

	/**
	 * Returns an ordered range of all the mypage group users where mypageGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageGroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param start the lower bound of the range of mypage group users
	 * @param end the upper bound of the range of mypage group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching mypage group users
	 */
	public static List<MypageGroupUser> findBymypageGroupId(
		long mypageGroupId, int start, int end,
		OrderByComparator<MypageGroupUser> orderByComparator) {

		return getPersistence().findBymypageGroupId(
			mypageGroupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the mypage group users where mypageGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageGroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param start the lower bound of the range of mypage group users
	 * @param end the upper bound of the range of mypage group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching mypage group users
	 */
	public static List<MypageGroupUser> findBymypageGroupId(
		long mypageGroupId, int start, int end,
		OrderByComparator<MypageGroupUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBymypageGroupId(
			mypageGroupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first mypage group user in the ordered set where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage group user
	 * @throws NoSuchMypageGroupUserException if a matching mypage group user could not be found
	 */
	public static MypageGroupUser findBymypageGroupId_First(
			long mypageGroupId,
			OrderByComparator<MypageGroupUser> orderByComparator)
		throws com.mypage.user.exception.NoSuchMypageGroupUserException {

		return getPersistence().findBymypageGroupId_First(
			mypageGroupId, orderByComparator);
	}

	/**
	 * Returns the first mypage group user in the ordered set where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage group user, or <code>null</code> if a matching mypage group user could not be found
	 */
	public static MypageGroupUser fetchBymypageGroupId_First(
		long mypageGroupId,
		OrderByComparator<MypageGroupUser> orderByComparator) {

		return getPersistence().fetchBymypageGroupId_First(
			mypageGroupId, orderByComparator);
	}

	/**
	 * Returns the last mypage group user in the ordered set where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage group user
	 * @throws NoSuchMypageGroupUserException if a matching mypage group user could not be found
	 */
	public static MypageGroupUser findBymypageGroupId_Last(
			long mypageGroupId,
			OrderByComparator<MypageGroupUser> orderByComparator)
		throws com.mypage.user.exception.NoSuchMypageGroupUserException {

		return getPersistence().findBymypageGroupId_Last(
			mypageGroupId, orderByComparator);
	}

	/**
	 * Returns the last mypage group user in the ordered set where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage group user, or <code>null</code> if a matching mypage group user could not be found
	 */
	public static MypageGroupUser fetchBymypageGroupId_Last(
		long mypageGroupId,
		OrderByComparator<MypageGroupUser> orderByComparator) {

		return getPersistence().fetchBymypageGroupId_Last(
			mypageGroupId, orderByComparator);
	}

	/**
	 * Returns the mypage group users before and after the current mypage group user in the ordered set where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupUserId the primary key of the current mypage group user
	 * @param mypageGroupId the mypage group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next mypage group user
	 * @throws NoSuchMypageGroupUserException if a mypage group user with the primary key could not be found
	 */
	public static MypageGroupUser[] findBymypageGroupId_PrevAndNext(
			long mypageGroupUserId, long mypageGroupId,
			OrderByComparator<MypageGroupUser> orderByComparator)
		throws com.mypage.user.exception.NoSuchMypageGroupUserException {

		return getPersistence().findBymypageGroupId_PrevAndNext(
			mypageGroupUserId, mypageGroupId, orderByComparator);
	}

	/**
	 * Removes all the mypage group users where mypageGroupId = &#63; from the database.
	 *
	 * @param mypageGroupId the mypage group ID
	 */
	public static void removeBymypageGroupId(long mypageGroupId) {
		getPersistence().removeBymypageGroupId(mypageGroupId);
	}

	/**
	 * Returns the number of mypage group users where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @return the number of matching mypage group users
	 */
	public static int countBymypageGroupId(long mypageGroupId) {
		return getPersistence().countBymypageGroupId(mypageGroupId);
	}

	/**
	 * Returns the mypage group user where mypageUserId = &#63; or throws a <code>NoSuchMypageGroupUserException</code> if it could not be found.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching mypage group user
	 * @throws NoSuchMypageGroupUserException if a matching mypage group user could not be found
	 */
	public static MypageGroupUser findBymypageUserId(long mypageUserId)
		throws com.mypage.user.exception.NoSuchMypageGroupUserException {

		return getPersistence().findBymypageUserId(mypageUserId);
	}

	/**
	 * Returns the mypage group user where mypageUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching mypage group user, or <code>null</code> if a matching mypage group user could not be found
	 */
	public static MypageGroupUser fetchBymypageUserId(long mypageUserId) {
		return getPersistence().fetchBymypageUserId(mypageUserId);
	}

	/**
	 * Returns the mypage group user where mypageUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage group user, or <code>null</code> if a matching mypage group user could not be found
	 */
	public static MypageGroupUser fetchBymypageUserId(
		long mypageUserId, boolean useFinderCache) {

		return getPersistence().fetchBymypageUserId(
			mypageUserId, useFinderCache);
	}

	/**
	 * Removes the mypage group user where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the mypage group user that was removed
	 */
	public static MypageGroupUser removeBymypageUserId(long mypageUserId)
		throws com.mypage.user.exception.NoSuchMypageGroupUserException {

		return getPersistence().removeBymypageUserId(mypageUserId);
	}

	/**
	 * Returns the number of mypage group users where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching mypage group users
	 */
	public static int countBymypageUserId(long mypageUserId) {
		return getPersistence().countBymypageUserId(mypageUserId);
	}

	/**
	 * Caches the mypage group user in the entity cache if it is enabled.
	 *
	 * @param mypageGroupUser the mypage group user
	 */
	public static void cacheResult(MypageGroupUser mypageGroupUser) {
		getPersistence().cacheResult(mypageGroupUser);
	}

	/**
	 * Caches the mypage group users in the entity cache if it is enabled.
	 *
	 * @param mypageGroupUsers the mypage group users
	 */
	public static void cacheResult(List<MypageGroupUser> mypageGroupUsers) {
		getPersistence().cacheResult(mypageGroupUsers);
	}

	/**
	 * Creates a new mypage group user with the primary key. Does not add the mypage group user to the database.
	 *
	 * @param mypageGroupUserId the primary key for the new mypage group user
	 * @return the new mypage group user
	 */
	public static MypageGroupUser create(long mypageGroupUserId) {
		return getPersistence().create(mypageGroupUserId);
	}

	/**
	 * Removes the mypage group user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageGroupUserId the primary key of the mypage group user
	 * @return the mypage group user that was removed
	 * @throws NoSuchMypageGroupUserException if a mypage group user with the primary key could not be found
	 */
	public static MypageGroupUser remove(long mypageGroupUserId)
		throws com.mypage.user.exception.NoSuchMypageGroupUserException {

		return getPersistence().remove(mypageGroupUserId);
	}

	public static MypageGroupUser updateImpl(MypageGroupUser mypageGroupUser) {
		return getPersistence().updateImpl(mypageGroupUser);
	}

	/**
	 * Returns the mypage group user with the primary key or throws a <code>NoSuchMypageGroupUserException</code> if it could not be found.
	 *
	 * @param mypageGroupUserId the primary key of the mypage group user
	 * @return the mypage group user
	 * @throws NoSuchMypageGroupUserException if a mypage group user with the primary key could not be found
	 */
	public static MypageGroupUser findByPrimaryKey(long mypageGroupUserId)
		throws com.mypage.user.exception.NoSuchMypageGroupUserException {

		return getPersistence().findByPrimaryKey(mypageGroupUserId);
	}

	/**
	 * Returns the mypage group user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageGroupUserId the primary key of the mypage group user
	 * @return the mypage group user, or <code>null</code> if a mypage group user with the primary key could not be found
	 */
	public static MypageGroupUser fetchByPrimaryKey(long mypageGroupUserId) {
		return getPersistence().fetchByPrimaryKey(mypageGroupUserId);
	}

	/**
	 * Returns all the mypage group users.
	 *
	 * @return the mypage group users
	 */
	public static List<MypageGroupUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the mypage group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageGroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage group users
	 * @param end the upper bound of the range of mypage group users (not inclusive)
	 * @return the range of mypage group users
	 */
	public static List<MypageGroupUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the mypage group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageGroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage group users
	 * @param end the upper bound of the range of mypage group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage group users
	 */
	public static List<MypageGroupUser> findAll(
		int start, int end,
		OrderByComparator<MypageGroupUser> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the mypage group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageGroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage group users
	 * @param end the upper bound of the range of mypage group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage group users
	 */
	public static List<MypageGroupUser> findAll(
		int start, int end,
		OrderByComparator<MypageGroupUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the mypage group users from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of mypage group users.
	 *
	 * @return the number of mypage group users
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MypageGroupUserPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MypageGroupUserPersistence _persistence;

}