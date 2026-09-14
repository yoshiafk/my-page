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

import com.mypage.user.exception.NoSuchMypageUserException;
import com.mypage.user.model.MypageUser;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the mypage user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserUtil
 * @generated
 */
@ProviderType
public interface MypageUserPersistence extends BasePersistence<MypageUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MypageUserUtil} to access the mypage user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the mypage user where liferayUserId = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	public MypageUser findBygetByLiferayUserId(long liferayUserId)
		throws NoSuchMypageUserException;

	/**
	 * Returns the mypage user where liferayUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public MypageUser fetchBygetByLiferayUserId(long liferayUserId);

	/**
	 * Returns the mypage user where liferayUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param liferayUserId the liferay user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public MypageUser fetchBygetByLiferayUserId(
		long liferayUserId, boolean useFinderCache);

	/**
	 * Removes the mypage user where liferayUserId = &#63; from the database.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the mypage user that was removed
	 */
	public MypageUser removeBygetByLiferayUserId(long liferayUserId)
		throws NoSuchMypageUserException;

	/**
	 * Returns the number of mypage users where liferayUserId = &#63;.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the number of matching mypage users
	 */
	public int countBygetByLiferayUserId(long liferayUserId);

	/**
	 * Returns the mypage user where creditWalletId = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	public MypageUser findBycreditWalletId(long creditWalletId)
		throws NoSuchMypageUserException;

	/**
	 * Returns the mypage user where creditWalletId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public MypageUser fetchBycreditWalletId(long creditWalletId);

	/**
	 * Returns the mypage user where creditWalletId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public MypageUser fetchBycreditWalletId(
		long creditWalletId, boolean useFinderCache);

	/**
	 * Removes the mypage user where creditWalletId = &#63; from the database.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the mypage user that was removed
	 */
	public MypageUser removeBycreditWalletId(long creditWalletId)
		throws NoSuchMypageUserException;

	/**
	 * Returns the number of mypage users where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the number of matching mypage users
	 */
	public int countBycreditWalletId(long creditWalletId);

	/**
	 * Returns the mypage user where prettyUrl = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param prettyUrl the pretty url
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	public MypageUser findByPrettyUrl(String prettyUrl)
		throws NoSuchMypageUserException;

	/**
	 * Returns the mypage user where prettyUrl = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param prettyUrl the pretty url
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public MypageUser fetchByPrettyUrl(String prettyUrl);

	/**
	 * Returns the mypage user where prettyUrl = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param prettyUrl the pretty url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public MypageUser fetchByPrettyUrl(
		String prettyUrl, boolean useFinderCache);

	/**
	 * Removes the mypage user where prettyUrl = &#63; from the database.
	 *
	 * @param prettyUrl the pretty url
	 * @return the mypage user that was removed
	 */
	public MypageUser removeByPrettyUrl(String prettyUrl)
		throws NoSuchMypageUserException;

	/**
	 * Returns the number of mypage users where prettyUrl = &#63;.
	 *
	 * @param prettyUrl the pretty url
	 * @return the number of matching mypage users
	 */
	public int countByPrettyUrl(String prettyUrl);

	/**
	 * Returns the mypage user where code = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	public MypageUser findByAgentCode(String code)
		throws NoSuchMypageUserException;

	/**
	 * Returns the mypage user where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public MypageUser fetchByAgentCode(String code);

	/**
	 * Returns the mypage user where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public MypageUser fetchByAgentCode(String code, boolean useFinderCache);

	/**
	 * Removes the mypage user where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the mypage user that was removed
	 */
	public MypageUser removeByAgentCode(String code)
		throws NoSuchMypageUserException;

	/**
	 * Returns the number of mypage users where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching mypage users
	 */
	public int countByAgentCode(String code);

	/**
	 * Returns the mypage user where email = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	public MypageUser findByEmailAddress(String email)
		throws NoSuchMypageUserException;

	/**
	 * Returns the mypage user where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public MypageUser fetchByEmailAddress(String email);

	/**
	 * Returns the mypage user where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public MypageUser fetchByEmailAddress(String email, boolean useFinderCache);

	/**
	 * Removes the mypage user where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the mypage user that was removed
	 */
	public MypageUser removeByEmailAddress(String email)
		throws NoSuchMypageUserException;

	/**
	 * Returns the number of mypage users where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching mypage users
	 */
	public int countByEmailAddress(String email);

	/**
	 * Returns the mypage user where deptoreCode = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param deptoreCode the deptore code
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	public MypageUser findByDeptoreCode(String deptoreCode)
		throws NoSuchMypageUserException;

	/**
	 * Returns the mypage user where deptoreCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param deptoreCode the deptore code
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public MypageUser fetchByDeptoreCode(String deptoreCode);

	/**
	 * Returns the mypage user where deptoreCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param deptoreCode the deptore code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public MypageUser fetchByDeptoreCode(
		String deptoreCode, boolean useFinderCache);

	/**
	 * Removes the mypage user where deptoreCode = &#63; from the database.
	 *
	 * @param deptoreCode the deptore code
	 * @return the mypage user that was removed
	 */
	public MypageUser removeByDeptoreCode(String deptoreCode)
		throws NoSuchMypageUserException;

	/**
	 * Returns the number of mypage users where deptoreCode = &#63;.
	 *
	 * @param deptoreCode the deptore code
	 * @return the number of matching mypage users
	 */
	public int countByDeptoreCode(String deptoreCode);

	/**
	 * Returns the mypage user where mypageUserRoleId = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	public MypageUser findByRoleId(long mypageUserRoleId)
		throws NoSuchMypageUserException;

	/**
	 * Returns the mypage user where mypageUserRoleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public MypageUser fetchByRoleId(long mypageUserRoleId);

	/**
	 * Returns the mypage user where mypageUserRoleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public MypageUser fetchByRoleId(
		long mypageUserRoleId, boolean useFinderCache);

	/**
	 * Removes the mypage user where mypageUserRoleId = &#63; from the database.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the mypage user that was removed
	 */
	public MypageUser removeByRoleId(long mypageUserRoleId)
		throws NoSuchMypageUserException;

	/**
	 * Returns the number of mypage users where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the number of matching mypage users
	 */
	public int countByRoleId(long mypageUserRoleId);

	/**
	 * Caches the mypage user in the entity cache if it is enabled.
	 *
	 * @param mypageUser the mypage user
	 */
	public void cacheResult(MypageUser mypageUser);

	/**
	 * Caches the mypage users in the entity cache if it is enabled.
	 *
	 * @param mypageUsers the mypage users
	 */
	public void cacheResult(java.util.List<MypageUser> mypageUsers);

	/**
	 * Creates a new mypage user with the primary key. Does not add the mypage user to the database.
	 *
	 * @param mypageUserId the primary key for the new mypage user
	 * @return the new mypage user
	 */
	public MypageUser create(long mypageUserId);

	/**
	 * Removes the mypage user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserId the primary key of the mypage user
	 * @return the mypage user that was removed
	 * @throws NoSuchMypageUserException if a mypage user with the primary key could not be found
	 */
	public MypageUser remove(long mypageUserId)
		throws NoSuchMypageUserException;

	public MypageUser updateImpl(MypageUser mypageUser);

	/**
	 * Returns the mypage user with the primary key or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param mypageUserId the primary key of the mypage user
	 * @return the mypage user
	 * @throws NoSuchMypageUserException if a mypage user with the primary key could not be found
	 */
	public MypageUser findByPrimaryKey(long mypageUserId)
		throws NoSuchMypageUserException;

	/**
	 * Returns the mypage user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserId the primary key of the mypage user
	 * @return the mypage user, or <code>null</code> if a mypage user with the primary key could not be found
	 */
	public MypageUser fetchByPrimaryKey(long mypageUserId);

	/**
	 * Returns all the mypage users.
	 *
	 * @return the mypage users
	 */
	public java.util.List<MypageUser> findAll();

	/**
	 * Returns a range of all the mypage users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage users
	 * @param end the upper bound of the range of mypage users (not inclusive)
	 * @return the range of mypage users
	 */
	public java.util.List<MypageUser> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the mypage users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage users
	 * @param end the upper bound of the range of mypage users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage users
	 */
	public java.util.List<MypageUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUser>
			orderByComparator);

	/**
	 * Returns an ordered range of all the mypage users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage users
	 * @param end the upper bound of the range of mypage users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage users
	 */
	public java.util.List<MypageUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the mypage users from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of mypage users.
	 *
	 * @return the number of mypage users
	 */
	public int countAll();

}