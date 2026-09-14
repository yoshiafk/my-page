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

import com.mypage.user.exception.NoSuchUserRegistrationException;
import com.mypage.user.model.UserRegistration;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationUtil
 * @generated
 */
@ProviderType
public interface UserRegistrationPersistence
	extends BasePersistence<UserRegistration> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserRegistrationUtil} to access the user registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the user registration in the entity cache if it is enabled.
	 *
	 * @param userRegistration the user registration
	 */
	public void cacheResult(UserRegistration userRegistration);

	/**
	 * Caches the user registrations in the entity cache if it is enabled.
	 *
	 * @param userRegistrations the user registrations
	 */
	public void cacheResult(java.util.List<UserRegistration> userRegistrations);

	/**
	 * Creates a new user registration with the primary key. Does not add the user registration to the database.
	 *
	 * @param userRegistrationId the primary key for the new user registration
	 * @return the new user registration
	 */
	public UserRegistration create(long userRegistrationId);

	/**
	 * Removes the user registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRegistrationId the primary key of the user registration
	 * @return the user registration that was removed
	 * @throws NoSuchUserRegistrationException if a user registration with the primary key could not be found
	 */
	public UserRegistration remove(long userRegistrationId)
		throws NoSuchUserRegistrationException;

	public UserRegistration updateImpl(UserRegistration userRegistration);

	/**
	 * Returns the user registration with the primary key or throws a <code>NoSuchUserRegistrationException</code> if it could not be found.
	 *
	 * @param userRegistrationId the primary key of the user registration
	 * @return the user registration
	 * @throws NoSuchUserRegistrationException if a user registration with the primary key could not be found
	 */
	public UserRegistration findByPrimaryKey(long userRegistrationId)
		throws NoSuchUserRegistrationException;

	/**
	 * Returns the user registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRegistrationId the primary key of the user registration
	 * @return the user registration, or <code>null</code> if a user registration with the primary key could not be found
	 */
	public UserRegistration fetchByPrimaryKey(long userRegistrationId);

	/**
	 * Returns all the user registrations.
	 *
	 * @return the user registrations
	 */
	public java.util.List<UserRegistration> findAll();

	/**
	 * Returns a range of all the user registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registrations
	 * @param end the upper bound of the range of user registrations (not inclusive)
	 * @return the range of user registrations
	 */
	public java.util.List<UserRegistration> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registrations
	 * @param end the upper bound of the range of user registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user registrations
	 */
	public java.util.List<UserRegistration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserRegistration>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registrations
	 * @param end the upper bound of the range of user registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user registrations
	 */
	public java.util.List<UserRegistration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserRegistration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user registrations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user registrations.
	 *
	 * @return the number of user registrations
	 */
	public int countAll();

}