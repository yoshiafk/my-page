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

import com.mypage.user.exception.NoSuchUserRegistrationLiabilityException;
import com.mypage.user.model.UserRegistrationLiability;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user registration liability service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationLiabilityUtil
 * @generated
 */
@ProviderType
public interface UserRegistrationLiabilityPersistence
	extends BasePersistence<UserRegistrationLiability> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserRegistrationLiabilityUtil} to access the user registration liability persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user registration liabilities where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the matching user registration liabilities
	 */
	public java.util.List<UserRegistrationLiability> findByUserRegistrationId(
		long userRegistrationId);

	/**
	 * Returns a range of all the user registration liabilities where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationLiabilityModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration liabilities
	 * @param end the upper bound of the range of user registration liabilities (not inclusive)
	 * @return the range of matching user registration liabilities
	 */
	public java.util.List<UserRegistrationLiability> findByUserRegistrationId(
		long userRegistrationId, int start, int end);

	/**
	 * Returns an ordered range of all the user registration liabilities where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationLiabilityModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration liabilities
	 * @param end the upper bound of the range of user registration liabilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user registration liabilities
	 */
	public java.util.List<UserRegistrationLiability> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationLiability> orderByComparator);

	/**
	 * Returns an ordered range of all the user registration liabilities where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationLiabilityModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration liabilities
	 * @param end the upper bound of the range of user registration liabilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user registration liabilities
	 */
	public java.util.List<UserRegistrationLiability> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationLiability> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user registration liability in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration liability
	 * @throws NoSuchUserRegistrationLiabilityException if a matching user registration liability could not be found
	 */
	public UserRegistrationLiability findByUserRegistrationId_First(
			long userRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserRegistrationLiability> orderByComparator)
		throws NoSuchUserRegistrationLiabilityException;

	/**
	 * Returns the first user registration liability in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration liability, or <code>null</code> if a matching user registration liability could not be found
	 */
	public UserRegistrationLiability fetchByUserRegistrationId_First(
		long userRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationLiability> orderByComparator);

	/**
	 * Returns the last user registration liability in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration liability
	 * @throws NoSuchUserRegistrationLiabilityException if a matching user registration liability could not be found
	 */
	public UserRegistrationLiability findByUserRegistrationId_Last(
			long userRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserRegistrationLiability> orderByComparator)
		throws NoSuchUserRegistrationLiabilityException;

	/**
	 * Returns the last user registration liability in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration liability, or <code>null</code> if a matching user registration liability could not be found
	 */
	public UserRegistrationLiability fetchByUserRegistrationId_Last(
		long userRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationLiability> orderByComparator);

	/**
	 * Returns the user registration liabilities before and after the current user registration liability in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationLiabilityId the primary key of the current user registration liability
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user registration liability
	 * @throws NoSuchUserRegistrationLiabilityException if a user registration liability with the primary key could not be found
	 */
	public UserRegistrationLiability[] findByUserRegistrationId_PrevAndNext(
			long userRegistrationLiabilityId, long userRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserRegistrationLiability> orderByComparator)
		throws NoSuchUserRegistrationLiabilityException;

	/**
	 * Removes all the user registration liabilities where userRegistrationId = &#63; from the database.
	 *
	 * @param userRegistrationId the user registration ID
	 */
	public void removeByUserRegistrationId(long userRegistrationId);

	/**
	 * Returns the number of user registration liabilities where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the number of matching user registration liabilities
	 */
	public int countByUserRegistrationId(long userRegistrationId);

	/**
	 * Caches the user registration liability in the entity cache if it is enabled.
	 *
	 * @param userRegistrationLiability the user registration liability
	 */
	public void cacheResult(
		UserRegistrationLiability userRegistrationLiability);

	/**
	 * Caches the user registration liabilities in the entity cache if it is enabled.
	 *
	 * @param userRegistrationLiabilities the user registration liabilities
	 */
	public void cacheResult(
		java.util.List<UserRegistrationLiability> userRegistrationLiabilities);

	/**
	 * Creates a new user registration liability with the primary key. Does not add the user registration liability to the database.
	 *
	 * @param userRegistrationLiabilityId the primary key for the new user registration liability
	 * @return the new user registration liability
	 */
	public UserRegistrationLiability create(long userRegistrationLiabilityId);

	/**
	 * Removes the user registration liability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRegistrationLiabilityId the primary key of the user registration liability
	 * @return the user registration liability that was removed
	 * @throws NoSuchUserRegistrationLiabilityException if a user registration liability with the primary key could not be found
	 */
	public UserRegistrationLiability remove(long userRegistrationLiabilityId)
		throws NoSuchUserRegistrationLiabilityException;

	public UserRegistrationLiability updateImpl(
		UserRegistrationLiability userRegistrationLiability);

	/**
	 * Returns the user registration liability with the primary key or throws a <code>NoSuchUserRegistrationLiabilityException</code> if it could not be found.
	 *
	 * @param userRegistrationLiabilityId the primary key of the user registration liability
	 * @return the user registration liability
	 * @throws NoSuchUserRegistrationLiabilityException if a user registration liability with the primary key could not be found
	 */
	public UserRegistrationLiability findByPrimaryKey(
			long userRegistrationLiabilityId)
		throws NoSuchUserRegistrationLiabilityException;

	/**
	 * Returns the user registration liability with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRegistrationLiabilityId the primary key of the user registration liability
	 * @return the user registration liability, or <code>null</code> if a user registration liability with the primary key could not be found
	 */
	public UserRegistrationLiability fetchByPrimaryKey(
		long userRegistrationLiabilityId);

	/**
	 * Returns all the user registration liabilities.
	 *
	 * @return the user registration liabilities
	 */
	public java.util.List<UserRegistrationLiability> findAll();

	/**
	 * Returns a range of all the user registration liabilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationLiabilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration liabilities
	 * @param end the upper bound of the range of user registration liabilities (not inclusive)
	 * @return the range of user registration liabilities
	 */
	public java.util.List<UserRegistrationLiability> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the user registration liabilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationLiabilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration liabilities
	 * @param end the upper bound of the range of user registration liabilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user registration liabilities
	 */
	public java.util.List<UserRegistrationLiability> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationLiability> orderByComparator);

	/**
	 * Returns an ordered range of all the user registration liabilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationLiabilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration liabilities
	 * @param end the upper bound of the range of user registration liabilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user registration liabilities
	 */
	public java.util.List<UserRegistrationLiability> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationLiability> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user registration liabilities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user registration liabilities.
	 *
	 * @return the number of user registration liabilities
	 */
	public int countAll();

}