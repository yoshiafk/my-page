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

import com.mypage.user.exception.NoSuchUserRegistrationEducationException;
import com.mypage.user.model.UserRegistrationEducation;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user registration education service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationEducationUtil
 * @generated
 */
@ProviderType
public interface UserRegistrationEducationPersistence
	extends BasePersistence<UserRegistrationEducation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserRegistrationEducationUtil} to access the user registration education persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user registration educations where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the matching user registration educations
	 */
	public java.util.List<UserRegistrationEducation> findByUserRegistrationId(
		long userRegistrationId);

	/**
	 * Returns a range of all the user registration educations where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationEducationModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration educations
	 * @param end the upper bound of the range of user registration educations (not inclusive)
	 * @return the range of matching user registration educations
	 */
	public java.util.List<UserRegistrationEducation> findByUserRegistrationId(
		long userRegistrationId, int start, int end);

	/**
	 * Returns an ordered range of all the user registration educations where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationEducationModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration educations
	 * @param end the upper bound of the range of user registration educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user registration educations
	 */
	public java.util.List<UserRegistrationEducation> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationEducation> orderByComparator);

	/**
	 * Returns an ordered range of all the user registration educations where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationEducationModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration educations
	 * @param end the upper bound of the range of user registration educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user registration educations
	 */
	public java.util.List<UserRegistrationEducation> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationEducation> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user registration education in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration education
	 * @throws NoSuchUserRegistrationEducationException if a matching user registration education could not be found
	 */
	public UserRegistrationEducation findByUserRegistrationId_First(
			long userRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserRegistrationEducation> orderByComparator)
		throws NoSuchUserRegistrationEducationException;

	/**
	 * Returns the first user registration education in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration education, or <code>null</code> if a matching user registration education could not be found
	 */
	public UserRegistrationEducation fetchByUserRegistrationId_First(
		long userRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationEducation> orderByComparator);

	/**
	 * Returns the last user registration education in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration education
	 * @throws NoSuchUserRegistrationEducationException if a matching user registration education could not be found
	 */
	public UserRegistrationEducation findByUserRegistrationId_Last(
			long userRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserRegistrationEducation> orderByComparator)
		throws NoSuchUserRegistrationEducationException;

	/**
	 * Returns the last user registration education in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration education, or <code>null</code> if a matching user registration education could not be found
	 */
	public UserRegistrationEducation fetchByUserRegistrationId_Last(
		long userRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationEducation> orderByComparator);

	/**
	 * Returns the user registration educations before and after the current user registration education in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationEducationId the primary key of the current user registration education
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user registration education
	 * @throws NoSuchUserRegistrationEducationException if a user registration education with the primary key could not be found
	 */
	public UserRegistrationEducation[] findByUserRegistrationId_PrevAndNext(
			long userRegistrationEducationId, long userRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserRegistrationEducation> orderByComparator)
		throws NoSuchUserRegistrationEducationException;

	/**
	 * Removes all the user registration educations where userRegistrationId = &#63; from the database.
	 *
	 * @param userRegistrationId the user registration ID
	 */
	public void removeByUserRegistrationId(long userRegistrationId);

	/**
	 * Returns the number of user registration educations where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the number of matching user registration educations
	 */
	public int countByUserRegistrationId(long userRegistrationId);

	/**
	 * Caches the user registration education in the entity cache if it is enabled.
	 *
	 * @param userRegistrationEducation the user registration education
	 */
	public void cacheResult(
		UserRegistrationEducation userRegistrationEducation);

	/**
	 * Caches the user registration educations in the entity cache if it is enabled.
	 *
	 * @param userRegistrationEducations the user registration educations
	 */
	public void cacheResult(
		java.util.List<UserRegistrationEducation> userRegistrationEducations);

	/**
	 * Creates a new user registration education with the primary key. Does not add the user registration education to the database.
	 *
	 * @param userRegistrationEducationId the primary key for the new user registration education
	 * @return the new user registration education
	 */
	public UserRegistrationEducation create(long userRegistrationEducationId);

	/**
	 * Removes the user registration education with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRegistrationEducationId the primary key of the user registration education
	 * @return the user registration education that was removed
	 * @throws NoSuchUserRegistrationEducationException if a user registration education with the primary key could not be found
	 */
	public UserRegistrationEducation remove(long userRegistrationEducationId)
		throws NoSuchUserRegistrationEducationException;

	public UserRegistrationEducation updateImpl(
		UserRegistrationEducation userRegistrationEducation);

	/**
	 * Returns the user registration education with the primary key or throws a <code>NoSuchUserRegistrationEducationException</code> if it could not be found.
	 *
	 * @param userRegistrationEducationId the primary key of the user registration education
	 * @return the user registration education
	 * @throws NoSuchUserRegistrationEducationException if a user registration education with the primary key could not be found
	 */
	public UserRegistrationEducation findByPrimaryKey(
			long userRegistrationEducationId)
		throws NoSuchUserRegistrationEducationException;

	/**
	 * Returns the user registration education with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRegistrationEducationId the primary key of the user registration education
	 * @return the user registration education, or <code>null</code> if a user registration education with the primary key could not be found
	 */
	public UserRegistrationEducation fetchByPrimaryKey(
		long userRegistrationEducationId);

	/**
	 * Returns all the user registration educations.
	 *
	 * @return the user registration educations
	 */
	public java.util.List<UserRegistrationEducation> findAll();

	/**
	 * Returns a range of all the user registration educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationEducationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration educations
	 * @param end the upper bound of the range of user registration educations (not inclusive)
	 * @return the range of user registration educations
	 */
	public java.util.List<UserRegistrationEducation> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the user registration educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationEducationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration educations
	 * @param end the upper bound of the range of user registration educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user registration educations
	 */
	public java.util.List<UserRegistrationEducation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationEducation> orderByComparator);

	/**
	 * Returns an ordered range of all the user registration educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationEducationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration educations
	 * @param end the upper bound of the range of user registration educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user registration educations
	 */
	public java.util.List<UserRegistrationEducation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserRegistrationEducation> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user registration educations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user registration educations.
	 *
	 * @return the number of user registration educations
	 */
	public int countAll();

}