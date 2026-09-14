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

import com.mypage.user.model.UserRegistrationLiability;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the user registration liability service. This utility wraps <code>com.mypage.user.service.persistence.impl.UserRegistrationLiabilityPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationLiabilityPersistence
 * @generated
 */
public class UserRegistrationLiabilityUtil {

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
		UserRegistrationLiability userRegistrationLiability) {

		getPersistence().clearCache(userRegistrationLiability);
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
	public static Map<Serializable, UserRegistrationLiability>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserRegistrationLiability> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserRegistrationLiability> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserRegistrationLiability> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserRegistrationLiability> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserRegistrationLiability update(
		UserRegistrationLiability userRegistrationLiability) {

		return getPersistence().update(userRegistrationLiability);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserRegistrationLiability update(
		UserRegistrationLiability userRegistrationLiability,
		ServiceContext serviceContext) {

		return getPersistence().update(
			userRegistrationLiability, serviceContext);
	}

	/**
	 * Returns all the user registration liabilities where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the matching user registration liabilities
	 */
	public static List<UserRegistrationLiability> findByUserRegistrationId(
		long userRegistrationId) {

		return getPersistence().findByUserRegistrationId(userRegistrationId);
	}

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
	public static List<UserRegistrationLiability> findByUserRegistrationId(
		long userRegistrationId, int start, int end) {

		return getPersistence().findByUserRegistrationId(
			userRegistrationId, start, end);
	}

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
	public static List<UserRegistrationLiability> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		OrderByComparator<UserRegistrationLiability> orderByComparator) {

		return getPersistence().findByUserRegistrationId(
			userRegistrationId, start, end, orderByComparator);
	}

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
	public static List<UserRegistrationLiability> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		OrderByComparator<UserRegistrationLiability> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserRegistrationId(
			userRegistrationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user registration liability in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration liability
	 * @throws NoSuchUserRegistrationLiabilityException if a matching user registration liability could not be found
	 */
	public static UserRegistrationLiability findByUserRegistrationId_First(
			long userRegistrationId,
			OrderByComparator<UserRegistrationLiability> orderByComparator)
		throws com.mypage.user.exception.
			NoSuchUserRegistrationLiabilityException {

		return getPersistence().findByUserRegistrationId_First(
			userRegistrationId, orderByComparator);
	}

	/**
	 * Returns the first user registration liability in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration liability, or <code>null</code> if a matching user registration liability could not be found
	 */
	public static UserRegistrationLiability fetchByUserRegistrationId_First(
		long userRegistrationId,
		OrderByComparator<UserRegistrationLiability> orderByComparator) {

		return getPersistence().fetchByUserRegistrationId_First(
			userRegistrationId, orderByComparator);
	}

	/**
	 * Returns the last user registration liability in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration liability
	 * @throws NoSuchUserRegistrationLiabilityException if a matching user registration liability could not be found
	 */
	public static UserRegistrationLiability findByUserRegistrationId_Last(
			long userRegistrationId,
			OrderByComparator<UserRegistrationLiability> orderByComparator)
		throws com.mypage.user.exception.
			NoSuchUserRegistrationLiabilityException {

		return getPersistence().findByUserRegistrationId_Last(
			userRegistrationId, orderByComparator);
	}

	/**
	 * Returns the last user registration liability in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration liability, or <code>null</code> if a matching user registration liability could not be found
	 */
	public static UserRegistrationLiability fetchByUserRegistrationId_Last(
		long userRegistrationId,
		OrderByComparator<UserRegistrationLiability> orderByComparator) {

		return getPersistence().fetchByUserRegistrationId_Last(
			userRegistrationId, orderByComparator);
	}

	/**
	 * Returns the user registration liabilities before and after the current user registration liability in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationLiabilityId the primary key of the current user registration liability
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user registration liability
	 * @throws NoSuchUserRegistrationLiabilityException if a user registration liability with the primary key could not be found
	 */
	public static UserRegistrationLiability[]
			findByUserRegistrationId_PrevAndNext(
				long userRegistrationLiabilityId, long userRegistrationId,
				OrderByComparator<UserRegistrationLiability> orderByComparator)
		throws com.mypage.user.exception.
			NoSuchUserRegistrationLiabilityException {

		return getPersistence().findByUserRegistrationId_PrevAndNext(
			userRegistrationLiabilityId, userRegistrationId, orderByComparator);
	}

	/**
	 * Removes all the user registration liabilities where userRegistrationId = &#63; from the database.
	 *
	 * @param userRegistrationId the user registration ID
	 */
	public static void removeByUserRegistrationId(long userRegistrationId) {
		getPersistence().removeByUserRegistrationId(userRegistrationId);
	}

	/**
	 * Returns the number of user registration liabilities where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the number of matching user registration liabilities
	 */
	public static int countByUserRegistrationId(long userRegistrationId) {
		return getPersistence().countByUserRegistrationId(userRegistrationId);
	}

	/**
	 * Caches the user registration liability in the entity cache if it is enabled.
	 *
	 * @param userRegistrationLiability the user registration liability
	 */
	public static void cacheResult(
		UserRegistrationLiability userRegistrationLiability) {

		getPersistence().cacheResult(userRegistrationLiability);
	}

	/**
	 * Caches the user registration liabilities in the entity cache if it is enabled.
	 *
	 * @param userRegistrationLiabilities the user registration liabilities
	 */
	public static void cacheResult(
		List<UserRegistrationLiability> userRegistrationLiabilities) {

		getPersistence().cacheResult(userRegistrationLiabilities);
	}

	/**
	 * Creates a new user registration liability with the primary key. Does not add the user registration liability to the database.
	 *
	 * @param userRegistrationLiabilityId the primary key for the new user registration liability
	 * @return the new user registration liability
	 */
	public static UserRegistrationLiability create(
		long userRegistrationLiabilityId) {

		return getPersistence().create(userRegistrationLiabilityId);
	}

	/**
	 * Removes the user registration liability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRegistrationLiabilityId the primary key of the user registration liability
	 * @return the user registration liability that was removed
	 * @throws NoSuchUserRegistrationLiabilityException if a user registration liability with the primary key could not be found
	 */
	public static UserRegistrationLiability remove(
			long userRegistrationLiabilityId)
		throws com.mypage.user.exception.
			NoSuchUserRegistrationLiabilityException {

		return getPersistence().remove(userRegistrationLiabilityId);
	}

	public static UserRegistrationLiability updateImpl(
		UserRegistrationLiability userRegistrationLiability) {

		return getPersistence().updateImpl(userRegistrationLiability);
	}

	/**
	 * Returns the user registration liability with the primary key or throws a <code>NoSuchUserRegistrationLiabilityException</code> if it could not be found.
	 *
	 * @param userRegistrationLiabilityId the primary key of the user registration liability
	 * @return the user registration liability
	 * @throws NoSuchUserRegistrationLiabilityException if a user registration liability with the primary key could not be found
	 */
	public static UserRegistrationLiability findByPrimaryKey(
			long userRegistrationLiabilityId)
		throws com.mypage.user.exception.
			NoSuchUserRegistrationLiabilityException {

		return getPersistence().findByPrimaryKey(userRegistrationLiabilityId);
	}

	/**
	 * Returns the user registration liability with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRegistrationLiabilityId the primary key of the user registration liability
	 * @return the user registration liability, or <code>null</code> if a user registration liability with the primary key could not be found
	 */
	public static UserRegistrationLiability fetchByPrimaryKey(
		long userRegistrationLiabilityId) {

		return getPersistence().fetchByPrimaryKey(userRegistrationLiabilityId);
	}

	/**
	 * Returns all the user registration liabilities.
	 *
	 * @return the user registration liabilities
	 */
	public static List<UserRegistrationLiability> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<UserRegistrationLiability> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<UserRegistrationLiability> findAll(
		int start, int end,
		OrderByComparator<UserRegistrationLiability> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<UserRegistrationLiability> findAll(
		int start, int end,
		OrderByComparator<UserRegistrationLiability> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user registration liabilities from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user registration liabilities.
	 *
	 * @return the number of user registration liabilities
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserRegistrationLiabilityPersistence getPersistence() {
		return _persistence;
	}

	private static volatile UserRegistrationLiabilityPersistence _persistence;

}