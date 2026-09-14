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

import com.mypage.user.exception.NoSuchUserOneTimeCodeException;
import com.mypage.user.model.UserOneTimeCode;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user one time code service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserOneTimeCodeUtil
 * @generated
 */
@ProviderType
public interface UserOneTimeCodePersistence
	extends BasePersistence<UserOneTimeCode> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserOneTimeCodeUtil} to access the user one time code persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the user one time code where userId = &#63; or throws a <code>NoSuchUserOneTimeCodeException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching user one time code
	 * @throws NoSuchUserOneTimeCodeException if a matching user one time code could not be found
	 */
	public UserOneTimeCode findByUserId(long userId)
		throws NoSuchUserOneTimeCodeException;

	/**
	 * Returns the user one time code where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching user one time code, or <code>null</code> if a matching user one time code could not be found
	 */
	public UserOneTimeCode fetchByUserId(long userId);

	/**
	 * Returns the user one time code where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user one time code, or <code>null</code> if a matching user one time code could not be found
	 */
	public UserOneTimeCode fetchByUserId(long userId, boolean useFinderCache);

	/**
	 * Removes the user one time code where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the user one time code that was removed
	 */
	public UserOneTimeCode removeByUserId(long userId)
		throws NoSuchUserOneTimeCodeException;

	/**
	 * Returns the number of user one time codes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user one time codes
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the user one time codes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user one time codes
	 */
	public java.util.List<UserOneTimeCode> findByUserIdCollection(long userId);

	/**
	 * Returns a range of all the user one time codes where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserOneTimeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user one time codes
	 * @param end the upper bound of the range of user one time codes (not inclusive)
	 * @return the range of matching user one time codes
	 */
	public java.util.List<UserOneTimeCode> findByUserIdCollection(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the user one time codes where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserOneTimeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user one time codes
	 * @param end the upper bound of the range of user one time codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user one time codes
	 */
	public java.util.List<UserOneTimeCode> findByUserIdCollection(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserOneTimeCode>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user one time codes where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserOneTimeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user one time codes
	 * @param end the upper bound of the range of user one time codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user one time codes
	 */
	public java.util.List<UserOneTimeCode> findByUserIdCollection(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserOneTimeCode>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user one time code in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user one time code
	 * @throws NoSuchUserOneTimeCodeException if a matching user one time code could not be found
	 */
	public UserOneTimeCode findByUserIdCollection_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserOneTimeCode>
				orderByComparator)
		throws NoSuchUserOneTimeCodeException;

	/**
	 * Returns the first user one time code in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user one time code, or <code>null</code> if a matching user one time code could not be found
	 */
	public UserOneTimeCode fetchByUserIdCollection_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserOneTimeCode>
			orderByComparator);

	/**
	 * Returns the last user one time code in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user one time code
	 * @throws NoSuchUserOneTimeCodeException if a matching user one time code could not be found
	 */
	public UserOneTimeCode findByUserIdCollection_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserOneTimeCode>
				orderByComparator)
		throws NoSuchUserOneTimeCodeException;

	/**
	 * Returns the last user one time code in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user one time code, or <code>null</code> if a matching user one time code could not be found
	 */
	public UserOneTimeCode fetchByUserIdCollection_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserOneTimeCode>
			orderByComparator);

	/**
	 * Returns the user one time codes before and after the current user one time code in the ordered set where userId = &#63;.
	 *
	 * @param userOneTimeCodeId the primary key of the current user one time code
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user one time code
	 * @throws NoSuchUserOneTimeCodeException if a user one time code with the primary key could not be found
	 */
	public UserOneTimeCode[] findByUserIdCollection_PrevAndNext(
			long userOneTimeCodeId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserOneTimeCode>
				orderByComparator)
		throws NoSuchUserOneTimeCodeException;

	/**
	 * Removes all the user one time codes where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserIdCollection(long userId);

	/**
	 * Returns the number of user one time codes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user one time codes
	 */
	public int countByUserIdCollection(long userId);

	/**
	 * Returns the user one time code where userId = &#63; and sharedSecret = &#63; or throws a <code>NoSuchUserOneTimeCodeException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param sharedSecret the shared secret
	 * @return the matching user one time code
	 * @throws NoSuchUserOneTimeCodeException if a matching user one time code could not be found
	 */
	public UserOneTimeCode findByUserIdSecret(long userId, String sharedSecret)
		throws NoSuchUserOneTimeCodeException;

	/**
	 * Returns the user one time code where userId = &#63; and sharedSecret = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param sharedSecret the shared secret
	 * @return the matching user one time code, or <code>null</code> if a matching user one time code could not be found
	 */
	public UserOneTimeCode fetchByUserIdSecret(
		long userId, String sharedSecret);

	/**
	 * Returns the user one time code where userId = &#63; and sharedSecret = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param sharedSecret the shared secret
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user one time code, or <code>null</code> if a matching user one time code could not be found
	 */
	public UserOneTimeCode fetchByUserIdSecret(
		long userId, String sharedSecret, boolean useFinderCache);

	/**
	 * Removes the user one time code where userId = &#63; and sharedSecret = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param sharedSecret the shared secret
	 * @return the user one time code that was removed
	 */
	public UserOneTimeCode removeByUserIdSecret(
			long userId, String sharedSecret)
		throws NoSuchUserOneTimeCodeException;

	/**
	 * Returns the number of user one time codes where userId = &#63; and sharedSecret = &#63;.
	 *
	 * @param userId the user ID
	 * @param sharedSecret the shared secret
	 * @return the number of matching user one time codes
	 */
	public int countByUserIdSecret(long userId, String sharedSecret);

	/**
	 * Caches the user one time code in the entity cache if it is enabled.
	 *
	 * @param userOneTimeCode the user one time code
	 */
	public void cacheResult(UserOneTimeCode userOneTimeCode);

	/**
	 * Caches the user one time codes in the entity cache if it is enabled.
	 *
	 * @param userOneTimeCodes the user one time codes
	 */
	public void cacheResult(java.util.List<UserOneTimeCode> userOneTimeCodes);

	/**
	 * Creates a new user one time code with the primary key. Does not add the user one time code to the database.
	 *
	 * @param userOneTimeCodeId the primary key for the new user one time code
	 * @return the new user one time code
	 */
	public UserOneTimeCode create(long userOneTimeCodeId);

	/**
	 * Removes the user one time code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userOneTimeCodeId the primary key of the user one time code
	 * @return the user one time code that was removed
	 * @throws NoSuchUserOneTimeCodeException if a user one time code with the primary key could not be found
	 */
	public UserOneTimeCode remove(long userOneTimeCodeId)
		throws NoSuchUserOneTimeCodeException;

	public UserOneTimeCode updateImpl(UserOneTimeCode userOneTimeCode);

	/**
	 * Returns the user one time code with the primary key or throws a <code>NoSuchUserOneTimeCodeException</code> if it could not be found.
	 *
	 * @param userOneTimeCodeId the primary key of the user one time code
	 * @return the user one time code
	 * @throws NoSuchUserOneTimeCodeException if a user one time code with the primary key could not be found
	 */
	public UserOneTimeCode findByPrimaryKey(long userOneTimeCodeId)
		throws NoSuchUserOneTimeCodeException;

	/**
	 * Returns the user one time code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userOneTimeCodeId the primary key of the user one time code
	 * @return the user one time code, or <code>null</code> if a user one time code with the primary key could not be found
	 */
	public UserOneTimeCode fetchByPrimaryKey(long userOneTimeCodeId);

	/**
	 * Returns all the user one time codes.
	 *
	 * @return the user one time codes
	 */
	public java.util.List<UserOneTimeCode> findAll();

	/**
	 * Returns a range of all the user one time codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserOneTimeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user one time codes
	 * @param end the upper bound of the range of user one time codes (not inclusive)
	 * @return the range of user one time codes
	 */
	public java.util.List<UserOneTimeCode> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user one time codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserOneTimeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user one time codes
	 * @param end the upper bound of the range of user one time codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user one time codes
	 */
	public java.util.List<UserOneTimeCode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserOneTimeCode>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user one time codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserOneTimeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user one time codes
	 * @param end the upper bound of the range of user one time codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user one time codes
	 */
	public java.util.List<UserOneTimeCode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserOneTimeCode>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user one time codes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user one time codes.
	 *
	 * @return the number of user one time codes
	 */
	public int countAll();

}