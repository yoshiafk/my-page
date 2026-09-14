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

import com.mypage.user.exception.NoSuchUserRegistrationJobExpException;
import com.mypage.user.model.UserRegistrationJobExp;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user registration job exp service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationJobExpUtil
 * @generated
 */
@ProviderType
public interface UserRegistrationJobExpPersistence
	extends BasePersistence<UserRegistrationJobExp> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserRegistrationJobExpUtil} to access the user registration job exp persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user registration job exps where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the matching user registration job exps
	 */
	public java.util.List<UserRegistrationJobExp> findByUserRegistrationId(
		long userRegistrationId);

	/**
	 * Returns a range of all the user registration job exps where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationJobExpModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration job exps
	 * @param end the upper bound of the range of user registration job exps (not inclusive)
	 * @return the range of matching user registration job exps
	 */
	public java.util.List<UserRegistrationJobExp> findByUserRegistrationId(
		long userRegistrationId, int start, int end);

	/**
	 * Returns an ordered range of all the user registration job exps where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationJobExpModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration job exps
	 * @param end the upper bound of the range of user registration job exps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user registration job exps
	 */
	public java.util.List<UserRegistrationJobExp> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserRegistrationJobExp>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user registration job exps where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationJobExpModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration job exps
	 * @param end the upper bound of the range of user registration job exps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user registration job exps
	 */
	public java.util.List<UserRegistrationJobExp> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserRegistrationJobExp>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user registration job exp in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration job exp
	 * @throws NoSuchUserRegistrationJobExpException if a matching user registration job exp could not be found
	 */
	public UserRegistrationJobExp findByUserRegistrationId_First(
			long userRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserRegistrationJobExp> orderByComparator)
		throws NoSuchUserRegistrationJobExpException;

	/**
	 * Returns the first user registration job exp in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration job exp, or <code>null</code> if a matching user registration job exp could not be found
	 */
	public UserRegistrationJobExp fetchByUserRegistrationId_First(
		long userRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator<UserRegistrationJobExp>
			orderByComparator);

	/**
	 * Returns the last user registration job exp in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration job exp
	 * @throws NoSuchUserRegistrationJobExpException if a matching user registration job exp could not be found
	 */
	public UserRegistrationJobExp findByUserRegistrationId_Last(
			long userRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserRegistrationJobExp> orderByComparator)
		throws NoSuchUserRegistrationJobExpException;

	/**
	 * Returns the last user registration job exp in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration job exp, or <code>null</code> if a matching user registration job exp could not be found
	 */
	public UserRegistrationJobExp fetchByUserRegistrationId_Last(
		long userRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator<UserRegistrationJobExp>
			orderByComparator);

	/**
	 * Returns the user registration job exps before and after the current user registration job exp in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationJobExpId the primary key of the current user registration job exp
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user registration job exp
	 * @throws NoSuchUserRegistrationJobExpException if a user registration job exp with the primary key could not be found
	 */
	public UserRegistrationJobExp[] findByUserRegistrationId_PrevAndNext(
			long userRegistrationJobExpId, long userRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserRegistrationJobExp> orderByComparator)
		throws NoSuchUserRegistrationJobExpException;

	/**
	 * Removes all the user registration job exps where userRegistrationId = &#63; from the database.
	 *
	 * @param userRegistrationId the user registration ID
	 */
	public void removeByUserRegistrationId(long userRegistrationId);

	/**
	 * Returns the number of user registration job exps where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the number of matching user registration job exps
	 */
	public int countByUserRegistrationId(long userRegistrationId);

	/**
	 * Caches the user registration job exp in the entity cache if it is enabled.
	 *
	 * @param userRegistrationJobExp the user registration job exp
	 */
	public void cacheResult(UserRegistrationJobExp userRegistrationJobExp);

	/**
	 * Caches the user registration job exps in the entity cache if it is enabled.
	 *
	 * @param userRegistrationJobExps the user registration job exps
	 */
	public void cacheResult(
		java.util.List<UserRegistrationJobExp> userRegistrationJobExps);

	/**
	 * Creates a new user registration job exp with the primary key. Does not add the user registration job exp to the database.
	 *
	 * @param userRegistrationJobExpId the primary key for the new user registration job exp
	 * @return the new user registration job exp
	 */
	public UserRegistrationJobExp create(long userRegistrationJobExpId);

	/**
	 * Removes the user registration job exp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRegistrationJobExpId the primary key of the user registration job exp
	 * @return the user registration job exp that was removed
	 * @throws NoSuchUserRegistrationJobExpException if a user registration job exp with the primary key could not be found
	 */
	public UserRegistrationJobExp remove(long userRegistrationJobExpId)
		throws NoSuchUserRegistrationJobExpException;

	public UserRegistrationJobExp updateImpl(
		UserRegistrationJobExp userRegistrationJobExp);

	/**
	 * Returns the user registration job exp with the primary key or throws a <code>NoSuchUserRegistrationJobExpException</code> if it could not be found.
	 *
	 * @param userRegistrationJobExpId the primary key of the user registration job exp
	 * @return the user registration job exp
	 * @throws NoSuchUserRegistrationJobExpException if a user registration job exp with the primary key could not be found
	 */
	public UserRegistrationJobExp findByPrimaryKey(
			long userRegistrationJobExpId)
		throws NoSuchUserRegistrationJobExpException;

	/**
	 * Returns the user registration job exp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRegistrationJobExpId the primary key of the user registration job exp
	 * @return the user registration job exp, or <code>null</code> if a user registration job exp with the primary key could not be found
	 */
	public UserRegistrationJobExp fetchByPrimaryKey(
		long userRegistrationJobExpId);

	/**
	 * Returns all the user registration job exps.
	 *
	 * @return the user registration job exps
	 */
	public java.util.List<UserRegistrationJobExp> findAll();

	/**
	 * Returns a range of all the user registration job exps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationJobExpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration job exps
	 * @param end the upper bound of the range of user registration job exps (not inclusive)
	 * @return the range of user registration job exps
	 */
	public java.util.List<UserRegistrationJobExp> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user registration job exps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationJobExpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration job exps
	 * @param end the upper bound of the range of user registration job exps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user registration job exps
	 */
	public java.util.List<UserRegistrationJobExp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserRegistrationJobExp>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user registration job exps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationJobExpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration job exps
	 * @param end the upper bound of the range of user registration job exps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user registration job exps
	 */
	public java.util.List<UserRegistrationJobExp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserRegistrationJobExp>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user registration job exps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user registration job exps.
	 *
	 * @return the number of user registration job exps
	 */
	public int countAll();

}