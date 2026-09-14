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

import com.mypage.user.model.UserRegistrationReference;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the user registration reference service. This utility wraps <code>com.mypage.user.service.persistence.impl.UserRegistrationReferencePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationReferencePersistence
 * @generated
 */
public class UserRegistrationReferenceUtil {

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
	public static void clearCache(
		UserRegistrationReference userRegistrationReference) {

		getPersistence().clearCache(userRegistrationReference);
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
	public static Map<Serializable, UserRegistrationReference>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserRegistrationReference> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserRegistrationReference> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserRegistrationReference> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserRegistrationReference> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserRegistrationReference update(
		UserRegistrationReference userRegistrationReference) {

		return getPersistence().update(userRegistrationReference);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserRegistrationReference update(
		UserRegistrationReference userRegistrationReference,
		ServiceContext serviceContext) {

		return getPersistence().update(
			userRegistrationReference, serviceContext);
	}

	/**
	 * Returns all the user registration references where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the matching user registration references
	 */
	public static List<UserRegistrationReference> findByUserRegistrationId(
		long userRegistrationId) {

		return getPersistence().findByUserRegistrationId(userRegistrationId);
	}

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
	public static List<UserRegistrationReference> findByUserRegistrationId(
		long userRegistrationId, int start, int end) {

		return getPersistence().findByUserRegistrationId(
			userRegistrationId, start, end);
	}

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
	public static List<UserRegistrationReference> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		OrderByComparator<UserRegistrationReference> orderByComparator) {

		return getPersistence().findByUserRegistrationId(
			userRegistrationId, start, end, orderByComparator);
	}

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
	public static List<UserRegistrationReference> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		OrderByComparator<UserRegistrationReference> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserRegistrationId(
			userRegistrationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user registration reference in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration reference
	 * @throws NoSuchUserRegistrationReferenceException if a matching user registration reference could not be found
	 */
	public static UserRegistrationReference findByUserRegistrationId_First(
			long userRegistrationId,
			OrderByComparator<UserRegistrationReference> orderByComparator)
		throws com.mypage.user.exception.
			NoSuchUserRegistrationReferenceException {

		return getPersistence().findByUserRegistrationId_First(
			userRegistrationId, orderByComparator);
	}

	/**
	 * Returns the first user registration reference in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration reference, or <code>null</code> if a matching user registration reference could not be found
	 */
	public static UserRegistrationReference fetchByUserRegistrationId_First(
		long userRegistrationId,
		OrderByComparator<UserRegistrationReference> orderByComparator) {

		return getPersistence().fetchByUserRegistrationId_First(
			userRegistrationId, orderByComparator);
	}

	/**
	 * Returns the last user registration reference in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration reference
	 * @throws NoSuchUserRegistrationReferenceException if a matching user registration reference could not be found
	 */
	public static UserRegistrationReference findByUserRegistrationId_Last(
			long userRegistrationId,
			OrderByComparator<UserRegistrationReference> orderByComparator)
		throws com.mypage.user.exception.
			NoSuchUserRegistrationReferenceException {

		return getPersistence().findByUserRegistrationId_Last(
			userRegistrationId, orderByComparator);
	}

	/**
	 * Returns the last user registration reference in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration reference, or <code>null</code> if a matching user registration reference could not be found
	 */
	public static UserRegistrationReference fetchByUserRegistrationId_Last(
		long userRegistrationId,
		OrderByComparator<UserRegistrationReference> orderByComparator) {

		return getPersistence().fetchByUserRegistrationId_Last(
			userRegistrationId, orderByComparator);
	}

	/**
	 * Returns the user registration references before and after the current user registration reference in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationReferenceId the primary key of the current user registration reference
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user registration reference
	 * @throws NoSuchUserRegistrationReferenceException if a user registration reference with the primary key could not be found
	 */
	public static UserRegistrationReference[]
			findByUserRegistrationId_PrevAndNext(
				long userRegistrationReferenceId, long userRegistrationId,
				OrderByComparator<UserRegistrationReference> orderByComparator)
		throws com.mypage.user.exception.
			NoSuchUserRegistrationReferenceException {

		return getPersistence().findByUserRegistrationId_PrevAndNext(
			userRegistrationReferenceId, userRegistrationId, orderByComparator);
	}

	/**
	 * Removes all the user registration references where userRegistrationId = &#63; from the database.
	 *
	 * @param userRegistrationId the user registration ID
	 */
	public static void removeByUserRegistrationId(long userRegistrationId) {
		getPersistence().removeByUserRegistrationId(userRegistrationId);
	}

	/**
	 * Returns the number of user registration references where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the number of matching user registration references
	 */
	public static int countByUserRegistrationId(long userRegistrationId) {
		return getPersistence().countByUserRegistrationId(userRegistrationId);
	}

	/**
	 * Caches the user registration reference in the entity cache if it is enabled.
	 *
	 * @param userRegistrationReference the user registration reference
	 */
	public static void cacheResult(
		UserRegistrationReference userRegistrationReference) {

		getPersistence().cacheResult(userRegistrationReference);
	}

	/**
	 * Caches the user registration references in the entity cache if it is enabled.
	 *
	 * @param userRegistrationReferences the user registration references
	 */
	public static void cacheResult(
		List<UserRegistrationReference> userRegistrationReferences) {

		getPersistence().cacheResult(userRegistrationReferences);
	}

	/**
	 * Creates a new user registration reference with the primary key. Does not add the user registration reference to the database.
	 *
	 * @param userRegistrationReferenceId the primary key for the new user registration reference
	 * @return the new user registration reference
	 */
	public static UserRegistrationReference create(
		long userRegistrationReferenceId) {

		return getPersistence().create(userRegistrationReferenceId);
	}

	/**
	 * Removes the user registration reference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRegistrationReferenceId the primary key of the user registration reference
	 * @return the user registration reference that was removed
	 * @throws NoSuchUserRegistrationReferenceException if a user registration reference with the primary key could not be found
	 */
	public static UserRegistrationReference remove(
			long userRegistrationReferenceId)
		throws com.mypage.user.exception.
			NoSuchUserRegistrationReferenceException {

		return getPersistence().remove(userRegistrationReferenceId);
	}

	public static UserRegistrationReference updateImpl(
		UserRegistrationReference userRegistrationReference) {

		return getPersistence().updateImpl(userRegistrationReference);
	}

	/**
	 * Returns the user registration reference with the primary key or throws a <code>NoSuchUserRegistrationReferenceException</code> if it could not be found.
	 *
	 * @param userRegistrationReferenceId the primary key of the user registration reference
	 * @return the user registration reference
	 * @throws NoSuchUserRegistrationReferenceException if a user registration reference with the primary key could not be found
	 */
	public static UserRegistrationReference findByPrimaryKey(
			long userRegistrationReferenceId)
		throws com.mypage.user.exception.
			NoSuchUserRegistrationReferenceException {

		return getPersistence().findByPrimaryKey(userRegistrationReferenceId);
	}

	/**
	 * Returns the user registration reference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRegistrationReferenceId the primary key of the user registration reference
	 * @return the user registration reference, or <code>null</code> if a user registration reference with the primary key could not be found
	 */
	public static UserRegistrationReference fetchByPrimaryKey(
		long userRegistrationReferenceId) {

		return getPersistence().fetchByPrimaryKey(userRegistrationReferenceId);
	}

	/**
	 * Returns all the user registration references.
	 *
	 * @return the user registration references
	 */
	public static List<UserRegistrationReference> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<UserRegistrationReference> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<UserRegistrationReference> findAll(
		int start, int end,
		OrderByComparator<UserRegistrationReference> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<UserRegistrationReference> findAll(
		int start, int end,
		OrderByComparator<UserRegistrationReference> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user registration references from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user registration references.
	 *
	 * @return the number of user registration references
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserRegistrationReferencePersistence getPersistence() {
		return _persistence;
	}

	private static volatile UserRegistrationReferencePersistence _persistence;

}