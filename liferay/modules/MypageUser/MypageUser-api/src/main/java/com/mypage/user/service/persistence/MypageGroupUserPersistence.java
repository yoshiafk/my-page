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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.user.exception.NoSuchMypageGroupUserException;
import com.mypage.user.model.MypageGroupUser;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the mypage group user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageGroupUserUtil
 * @generated
 */
@ProviderType
public interface MypageGroupUserPersistence
	extends BasePersistence<MypageGroupUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MypageGroupUserUtil} to access the mypage group user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the mypage group users where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @return the matching mypage group users
	 */
	public java.util.List<MypageGroupUser> findBymypageGroupId(
		long mypageGroupId);

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
	public java.util.List<MypageGroupUser> findBymypageGroupId(
		long mypageGroupId, int start, int end);

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
	public java.util.List<MypageGroupUser> findBymypageGroupId(
		long mypageGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageGroupUser>
			orderByComparator);

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
	public java.util.List<MypageGroupUser> findBymypageGroupId(
		long mypageGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageGroupUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first mypage group user in the ordered set where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage group user
	 * @throws NoSuchMypageGroupUserException if a matching mypage group user could not be found
	 */
	public MypageGroupUser findBymypageGroupId_First(
			long mypageGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<MypageGroupUser>
				orderByComparator)
		throws NoSuchMypageGroupUserException;

	/**
	 * Returns the first mypage group user in the ordered set where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage group user, or <code>null</code> if a matching mypage group user could not be found
	 */
	public MypageGroupUser fetchBymypageGroupId_First(
		long mypageGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<MypageGroupUser>
			orderByComparator);

	/**
	 * Returns the last mypage group user in the ordered set where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage group user
	 * @throws NoSuchMypageGroupUserException if a matching mypage group user could not be found
	 */
	public MypageGroupUser findBymypageGroupId_Last(
			long mypageGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<MypageGroupUser>
				orderByComparator)
		throws NoSuchMypageGroupUserException;

	/**
	 * Returns the last mypage group user in the ordered set where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage group user, or <code>null</code> if a matching mypage group user could not be found
	 */
	public MypageGroupUser fetchBymypageGroupId_Last(
		long mypageGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<MypageGroupUser>
			orderByComparator);

	/**
	 * Returns the mypage group users before and after the current mypage group user in the ordered set where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupUserId the primary key of the current mypage group user
	 * @param mypageGroupId the mypage group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next mypage group user
	 * @throws NoSuchMypageGroupUserException if a mypage group user with the primary key could not be found
	 */
	public MypageGroupUser[] findBymypageGroupId_PrevAndNext(
			long mypageGroupUserId, long mypageGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<MypageGroupUser>
				orderByComparator)
		throws NoSuchMypageGroupUserException;

	/**
	 * Removes all the mypage group users where mypageGroupId = &#63; from the database.
	 *
	 * @param mypageGroupId the mypage group ID
	 */
	public void removeBymypageGroupId(long mypageGroupId);

	/**
	 * Returns the number of mypage group users where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @return the number of matching mypage group users
	 */
	public int countBymypageGroupId(long mypageGroupId);

	/**
	 * Returns the mypage group user where mypageUserId = &#63; or throws a <code>NoSuchMypageGroupUserException</code> if it could not be found.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching mypage group user
	 * @throws NoSuchMypageGroupUserException if a matching mypage group user could not be found
	 */
	public MypageGroupUser findBymypageUserId(long mypageUserId)
		throws NoSuchMypageGroupUserException;

	/**
	 * Returns the mypage group user where mypageUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching mypage group user, or <code>null</code> if a matching mypage group user could not be found
	 */
	public MypageGroupUser fetchBymypageUserId(long mypageUserId);

	/**
	 * Returns the mypage group user where mypageUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage group user, or <code>null</code> if a matching mypage group user could not be found
	 */
	public MypageGroupUser fetchBymypageUserId(
		long mypageUserId, boolean useFinderCache);

	/**
	 * Removes the mypage group user where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the mypage group user that was removed
	 */
	public MypageGroupUser removeBymypageUserId(long mypageUserId)
		throws NoSuchMypageGroupUserException;

	/**
	 * Returns the number of mypage group users where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching mypage group users
	 */
	public int countBymypageUserId(long mypageUserId);

	/**
	 * Caches the mypage group user in the entity cache if it is enabled.
	 *
	 * @param mypageGroupUser the mypage group user
	 */
	public void cacheResult(MypageGroupUser mypageGroupUser);

	/**
	 * Caches the mypage group users in the entity cache if it is enabled.
	 *
	 * @param mypageGroupUsers the mypage group users
	 */
	public void cacheResult(java.util.List<MypageGroupUser> mypageGroupUsers);

	/**
	 * Creates a new mypage group user with the primary key. Does not add the mypage group user to the database.
	 *
	 * @param mypageGroupUserId the primary key for the new mypage group user
	 * @return the new mypage group user
	 */
	public MypageGroupUser create(long mypageGroupUserId);

	/**
	 * Removes the mypage group user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageGroupUserId the primary key of the mypage group user
	 * @return the mypage group user that was removed
	 * @throws NoSuchMypageGroupUserException if a mypage group user with the primary key could not be found
	 */
	public MypageGroupUser remove(long mypageGroupUserId)
		throws NoSuchMypageGroupUserException;

	public MypageGroupUser updateImpl(MypageGroupUser mypageGroupUser);

	/**
	 * Returns the mypage group user with the primary key or throws a <code>NoSuchMypageGroupUserException</code> if it could not be found.
	 *
	 * @param mypageGroupUserId the primary key of the mypage group user
	 * @return the mypage group user
	 * @throws NoSuchMypageGroupUserException if a mypage group user with the primary key could not be found
	 */
	public MypageGroupUser findByPrimaryKey(long mypageGroupUserId)
		throws NoSuchMypageGroupUserException;

	/**
	 * Returns the mypage group user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageGroupUserId the primary key of the mypage group user
	 * @return the mypage group user, or <code>null</code> if a mypage group user with the primary key could not be found
	 */
	public MypageGroupUser fetchByPrimaryKey(long mypageGroupUserId);

	/**
	 * Returns all the mypage group users.
	 *
	 * @return the mypage group users
	 */
	public java.util.List<MypageGroupUser> findAll();

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
	public java.util.List<MypageGroupUser> findAll(int start, int end);

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
	public java.util.List<MypageGroupUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageGroupUser>
			orderByComparator);

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
	public java.util.List<MypageGroupUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageGroupUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the mypage group users from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of mypage group users.
	 *
	 * @return the number of mypage group users
	 */
	public int countAll();

}