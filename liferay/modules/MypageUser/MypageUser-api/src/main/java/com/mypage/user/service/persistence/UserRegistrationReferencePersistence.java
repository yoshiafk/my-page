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

import com.mypage.user.exception.NoSuchUserRegistrationReferenceException;
import com.mypage.user.model.UserRegistrationReference;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user registration reference service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationReferenceUtil
 * @generated
 */
@ProviderType
public interface UserRegistrationReferencePersistence
	extends BasePersistence<UserRegistrationReference> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserRegistrationReferenceUtil} to access the user registration reference persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user registration references where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the matching user registration references
	 */
	public java.util.List<UserRegistrationReference> findByUserRegistrationId(
		long userRegistrationId);

	/**
	 * Returns a range of all the user registration references where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationReferenceModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration references
	 * @param end the upper bound of the range of user registration references (not inclusive)
	 * @return the range of matching user registration references
	 */
	public java.util.List<UserRegistrationReference> findByUserRegistrationId(
		long userRegistrationId, int start, int end);

	/**
	 * Returns an ordered range of all the user registration references where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationReferenceModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration references
	 * @param end the upper bound of the range of user registration references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user registration references
	 */
	public java.util.List<UserRegistrationReference> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationReference> orderByComparator);

	/**
	 * Returns an ordered range of all the user registration references where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationReferenceModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration references
	 * @param end the upper bound of the range of user registration references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user registration references
	 */
	public java.util.List<UserRegistrationReference> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationReference> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user registration reference in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration reference
	 * @throws NoSuchUserRegistrationReferenceException if a matching user registration reference could not be found
	 */
	public UserRegistrationReference findByUserRegistrationId_First(
			long userRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserRegistrationReference> orderByComparator)
		throws NoSuchUserRegistrationReferenceException;

	/**
	 * Returns the first user registration reference in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration reference, or <code>null</code> if a matching user registration reference could not be found
	 */
	public UserRegistrationReference fetchByUserRegistrationId_First(
		long userRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationReference> orderByComparator);

	/**
	 * Returns the last user registration reference in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration reference
	 * @throws NoSuchUserRegistrationReferenceException if a matching user registration reference could not be found
	 */
	public UserRegistrationReference findByUserRegistrationId_Last(
			long userRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserRegistrationReference> orderByComparator)
		throws NoSuchUserRegistrationReferenceException;

	/**
	 * Returns the last user registration reference in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration reference, or <code>null</code> if a matching user registration reference could not be found
	 */
	public UserRegistrationReference fetchByUserRegistrationId_Last(
		long userRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationReference> orderByComparator);

	/**
	 * Returns the user registration references before and after the current user registration reference in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationReferenceId the primary key of the current user registration reference
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user registration reference
	 * @throws NoSuchUserRegistrationReferenceException if a user registration reference with the primary key could not be found
	 */
	public UserRegistrationReference[] findByUserRegistrationId_PrevAndNext(
			long userRegistrationReferenceId, long userRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserRegistrationReference> orderByComparator)
		throws NoSuchUserRegistrationReferenceException;

	/**
	 * Removes all the user registration references where userRegistrationId = &#63; from the database.
	 *
	 * @param userRegistrationId the user registration ID
	 */
	public void removeByUserRegistrationId(long userRegistrationId);

	/**
	 * Returns the number of user registration references where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the number of matching user registration references
	 */
	public int countByUserRegistrationId(long userRegistrationId);

	/**
	 * Caches the user registration reference in the entity cache if it is enabled.
	 *
	 * @param userRegistrationReference the user registration reference
	 */
	public void cacheResult(
		UserRegistrationReference userRegistrationReference);

	/**
	 * Caches the user registration references in the entity cache if it is enabled.
	 *
	 * @param userRegistrationReferences the user registration references
	 */
	public void cacheResult(
		java.util.List<UserRegistrationReference> userRegistrationReferences);

	/**
	 * Creates a new user registration reference with the primary key. Does not add the user registration reference to the database.
	 *
	 * @param userRegistrationReferenceId the primary key for the new user registration reference
	 * @return the new user registration reference
	 */
	public UserRegistrationReference create(long userRegistrationReferenceId);

	/**
	 * Removes the user registration reference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRegistrationReferenceId the primary key of the user registration reference
	 * @return the user registration reference that was removed
	 * @throws NoSuchUserRegistrationReferenceException if a user registration reference with the primary key could not be found
	 */
	public UserRegistrationReference remove(long userRegistrationReferenceId)
		throws NoSuchUserRegistrationReferenceException;

	public UserRegistrationReference updateImpl(
		UserRegistrationReference userRegistrationReference);

	/**
	 * Returns the user registration reference with the primary key or throws a <code>NoSuchUserRegistrationReferenceException</code> if it could not be found.
	 *
	 * @param userRegistrationReferenceId the primary key of the user registration reference
	 * @return the user registration reference
	 * @throws NoSuchUserRegistrationReferenceException if a user registration reference with the primary key could not be found
	 */
	public UserRegistrationReference findByPrimaryKey(
			long userRegistrationReferenceId)
		throws NoSuchUserRegistrationReferenceException;

	/**
	 * Returns the user registration reference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRegistrationReferenceId the primary key of the user registration reference
	 * @return the user registration reference, or <code>null</code> if a user registration reference with the primary key could not be found
	 */
	public UserRegistrationReference fetchByPrimaryKey(
		long userRegistrationReferenceId);

	/**
	 * Returns all the user registration references.
	 *
	 * @return the user registration references
	 */
	public java.util.List<UserRegistrationReference> findAll();

	/**
	 * Returns a range of all the user registration references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationReferenceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration references
	 * @param end the upper bound of the range of user registration references (not inclusive)
	 * @return the range of user registration references
	 */
	public java.util.List<UserRegistrationReference> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the user registration references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationReferenceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration references
	 * @param end the upper bound of the range of user registration references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user registration references
	 */
	public java.util.List<UserRegistrationReference> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationReference> orderByComparator);

	/**
	 * Returns an ordered range of all the user registration references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationReferenceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration references
	 * @param end the upper bound of the range of user registration references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user registration references
	 */
	public java.util.List<UserRegistrationReference> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationReference> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user registration references from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user registration references.
	 *
	 * @return the number of user registration references
	 */
	public int countAll();

}