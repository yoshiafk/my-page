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

package com.aii.esppk.admin.service.persistence;

import com.aii.esppk.admin.exception.NoSuchSppkUserException;
import com.aii.esppk.admin.model.SppkUser;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sppk user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see SppkUserUtil
 * @generated
 */
@ProviderType
public interface SppkUserPersistence extends BasePersistence<SppkUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SppkUserUtil} to access the sppk user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; or throws a <code>NoSuchSppkUserException</code> if it could not be found.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @return the matching sppk user
	 * @throws NoSuchSppkUserException if a matching sppk user could not be found
	 */
	public SppkUser findBysppkLoginCode(String sppkLoginCode)
		throws NoSuchSppkUserException;

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	public SppkUser fetchBysppkLoginCode(String sppkLoginCode);

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	public SppkUser fetchBysppkLoginCode(
		String sppkLoginCode, boolean useFinderCache);

	/**
	 * Removes the sppk user where sppkLoginCode = &#63; from the database.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @return the sppk user that was removed
	 */
	public SppkUser removeBysppkLoginCode(String sppkLoginCode)
		throws NoSuchSppkUserException;

	/**
	 * Returns the number of sppk users where sppkLoginCode = &#63;.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @return the number of matching sppk users
	 */
	public int countBysppkLoginCode(String sppkLoginCode);

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; and password = &#63; or throws a <code>NoSuchSppkUserException</code> if it could not be found.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param password the password
	 * @return the matching sppk user
	 * @throws NoSuchSppkUserException if a matching sppk user could not be found
	 */
	public SppkUser findBysppkLoginCodeAndPassword(
			String sppkLoginCode, String password)
		throws NoSuchSppkUserException;

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; and password = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param password the password
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	public SppkUser fetchBysppkLoginCodeAndPassword(
		String sppkLoginCode, String password);

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; and password = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param password the password
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	public SppkUser fetchBysppkLoginCodeAndPassword(
		String sppkLoginCode, String password, boolean useFinderCache);

	/**
	 * Removes the sppk user where sppkLoginCode = &#63; and password = &#63; from the database.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param password the password
	 * @return the sppk user that was removed
	 */
	public SppkUser removeBysppkLoginCodeAndPassword(
			String sppkLoginCode, String password)
		throws NoSuchSppkUserException;

	/**
	 * Returns the number of sppk users where sppkLoginCode = &#63; and password = &#63;.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param password the password
	 * @return the number of matching sppk users
	 */
	public int countBysppkLoginCodeAndPassword(
		String sppkLoginCode, String password);

	/**
	 * Returns all the sppk users where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @return the matching sppk users
	 */
	public java.util.List<SppkUser> findByfullName(String fullName);

	/**
	 * Returns a range of all the sppk users where fullName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkUserModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of sppk users
	 * @param end the upper bound of the range of sppk users (not inclusive)
	 * @return the range of matching sppk users
	 */
	public java.util.List<SppkUser> findByfullName(
		String fullName, int start, int end);

	/**
	 * Returns an ordered range of all the sppk users where fullName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkUserModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of sppk users
	 * @param end the upper bound of the range of sppk users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sppk users
	 */
	public java.util.List<SppkUser> findByfullName(
		String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SppkUser>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sppk users where fullName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkUserModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of sppk users
	 * @param end the upper bound of the range of sppk users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sppk users
	 */
	public java.util.List<SppkUser> findByfullName(
		String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SppkUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sppk user in the ordered set where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sppk user
	 * @throws NoSuchSppkUserException if a matching sppk user could not be found
	 */
	public SppkUser findByfullName_First(
			String fullName,
			com.liferay.portal.kernel.util.OrderByComparator<SppkUser>
				orderByComparator)
		throws NoSuchSppkUserException;

	/**
	 * Returns the first sppk user in the ordered set where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	public SppkUser fetchByfullName_First(
		String fullName,
		com.liferay.portal.kernel.util.OrderByComparator<SppkUser>
			orderByComparator);

	/**
	 * Returns the last sppk user in the ordered set where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sppk user
	 * @throws NoSuchSppkUserException if a matching sppk user could not be found
	 */
	public SppkUser findByfullName_Last(
			String fullName,
			com.liferay.portal.kernel.util.OrderByComparator<SppkUser>
				orderByComparator)
		throws NoSuchSppkUserException;

	/**
	 * Returns the last sppk user in the ordered set where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	public SppkUser fetchByfullName_Last(
		String fullName,
		com.liferay.portal.kernel.util.OrderByComparator<SppkUser>
			orderByComparator);

	/**
	 * Returns the sppk users before and after the current sppk user in the ordered set where fullName LIKE &#63;.
	 *
	 * @param sppkUserId the primary key of the current sppk user
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sppk user
	 * @throws NoSuchSppkUserException if a sppk user with the primary key could not be found
	 */
	public SppkUser[] findByfullName_PrevAndNext(
			long sppkUserId, String fullName,
			com.liferay.portal.kernel.util.OrderByComparator<SppkUser>
				orderByComparator)
		throws NoSuchSppkUserException;

	/**
	 * Removes all the sppk users where fullName LIKE &#63; from the database.
	 *
	 * @param fullName the full name
	 */
	public void removeByfullName(String fullName);

	/**
	 * Returns the number of sppk users where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @return the number of matching sppk users
	 */
	public int countByfullName(String fullName);

	/**
	 * Returns the sppk user where email = &#63; and otpCode = &#63; or throws a <code>NoSuchSppkUserException</code> if it could not be found.
	 *
	 * @param email the email
	 * @param otpCode the otp code
	 * @return the matching sppk user
	 * @throws NoSuchSppkUserException if a matching sppk user could not be found
	 */
	public SppkUser findByemailAndOtpCode(String email, String otpCode)
		throws NoSuchSppkUserException;

	/**
	 * Returns the sppk user where email = &#63; and otpCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @param otpCode the otp code
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	public SppkUser fetchByemailAndOtpCode(String email, String otpCode);

	/**
	 * Returns the sppk user where email = &#63; and otpCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param otpCode the otp code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	public SppkUser fetchByemailAndOtpCode(
		String email, String otpCode, boolean useFinderCache);

	/**
	 * Removes the sppk user where email = &#63; and otpCode = &#63; from the database.
	 *
	 * @param email the email
	 * @param otpCode the otp code
	 * @return the sppk user that was removed
	 */
	public SppkUser removeByemailAndOtpCode(String email, String otpCode)
		throws NoSuchSppkUserException;

	/**
	 * Returns the number of sppk users where email = &#63; and otpCode = &#63;.
	 *
	 * @param email the email
	 * @param otpCode the otp code
	 * @return the number of matching sppk users
	 */
	public int countByemailAndOtpCode(String email, String otpCode);

	/**
	 * Caches the sppk user in the entity cache if it is enabled.
	 *
	 * @param sppkUser the sppk user
	 */
	public void cacheResult(SppkUser sppkUser);

	/**
	 * Caches the sppk users in the entity cache if it is enabled.
	 *
	 * @param sppkUsers the sppk users
	 */
	public void cacheResult(java.util.List<SppkUser> sppkUsers);

	/**
	 * Creates a new sppk user with the primary key. Does not add the sppk user to the database.
	 *
	 * @param sppkUserId the primary key for the new sppk user
	 * @return the new sppk user
	 */
	public SppkUser create(long sppkUserId);

	/**
	 * Removes the sppk user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sppkUserId the primary key of the sppk user
	 * @return the sppk user that was removed
	 * @throws NoSuchSppkUserException if a sppk user with the primary key could not be found
	 */
	public SppkUser remove(long sppkUserId) throws NoSuchSppkUserException;

	public SppkUser updateImpl(SppkUser sppkUser);

	/**
	 * Returns the sppk user with the primary key or throws a <code>NoSuchSppkUserException</code> if it could not be found.
	 *
	 * @param sppkUserId the primary key of the sppk user
	 * @return the sppk user
	 * @throws NoSuchSppkUserException if a sppk user with the primary key could not be found
	 */
	public SppkUser findByPrimaryKey(long sppkUserId)
		throws NoSuchSppkUserException;

	/**
	 * Returns the sppk user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sppkUserId the primary key of the sppk user
	 * @return the sppk user, or <code>null</code> if a sppk user with the primary key could not be found
	 */
	public SppkUser fetchByPrimaryKey(long sppkUserId);

	/**
	 * Returns all the sppk users.
	 *
	 * @return the sppk users
	 */
	public java.util.List<SppkUser> findAll();

	/**
	 * Returns a range of all the sppk users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sppk users
	 * @param end the upper bound of the range of sppk users (not inclusive)
	 * @return the range of sppk users
	 */
	public java.util.List<SppkUser> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the sppk users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sppk users
	 * @param end the upper bound of the range of sppk users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sppk users
	 */
	public java.util.List<SppkUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SppkUser>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sppk users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sppk users
	 * @param end the upper bound of the range of sppk users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sppk users
	 */
	public java.util.List<SppkUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SppkUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sppk users from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sppk users.
	 *
	 * @return the number of sppk users
	 */
	public int countAll();

}