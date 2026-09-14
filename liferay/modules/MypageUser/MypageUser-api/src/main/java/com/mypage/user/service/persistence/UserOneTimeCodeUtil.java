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

import com.mypage.user.model.UserOneTimeCode;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the user one time code service. This utility wraps <code>com.mypage.user.service.persistence.impl.UserOneTimeCodePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserOneTimeCodePersistence
 * @generated
 */
public class UserOneTimeCodeUtil {

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
	public static void clearCache(UserOneTimeCode userOneTimeCode) {
		getPersistence().clearCache(userOneTimeCode);
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
	public static Map<Serializable, UserOneTimeCode> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserOneTimeCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserOneTimeCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserOneTimeCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserOneTimeCode> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserOneTimeCode update(UserOneTimeCode userOneTimeCode) {
		return getPersistence().update(userOneTimeCode);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserOneTimeCode update(
		UserOneTimeCode userOneTimeCode, ServiceContext serviceContext) {

		return getPersistence().update(userOneTimeCode, serviceContext);
	}

	/**
	 * Returns the user one time code where userId = &#63; or throws a <code>NoSuchUserOneTimeCodeException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching user one time code
	 * @throws NoSuchUserOneTimeCodeException if a matching user one time code could not be found
	 */
	public static UserOneTimeCode findByUserId(long userId)
		throws com.mypage.user.exception.NoSuchUserOneTimeCodeException {

		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns the user one time code where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching user one time code, or <code>null</code> if a matching user one time code could not be found
	 */
	public static UserOneTimeCode fetchByUserId(long userId) {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	 * Returns the user one time code where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user one time code, or <code>null</code> if a matching user one time code could not be found
	 */
	public static UserOneTimeCode fetchByUserId(
		long userId, boolean useFinderCache) {

		return getPersistence().fetchByUserId(userId, useFinderCache);
	}

	/**
	 * Removes the user one time code where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the user one time code that was removed
	 */
	public static UserOneTimeCode removeByUserId(long userId)
		throws com.mypage.user.exception.NoSuchUserOneTimeCodeException {

		return getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of user one time codes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user one time codes
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the user one time codes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user one time codes
	 */
	public static List<UserOneTimeCode> findByUserIdCollection(long userId) {
		return getPersistence().findByUserIdCollection(userId);
	}

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
	public static List<UserOneTimeCode> findByUserIdCollection(
		long userId, int start, int end) {

		return getPersistence().findByUserIdCollection(userId, start, end);
	}

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
	public static List<UserOneTimeCode> findByUserIdCollection(
		long userId, int start, int end,
		OrderByComparator<UserOneTimeCode> orderByComparator) {

		return getPersistence().findByUserIdCollection(
			userId, start, end, orderByComparator);
	}

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
	public static List<UserOneTimeCode> findByUserIdCollection(
		long userId, int start, int end,
		OrderByComparator<UserOneTimeCode> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserIdCollection(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user one time code in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user one time code
	 * @throws NoSuchUserOneTimeCodeException if a matching user one time code could not be found
	 */
	public static UserOneTimeCode findByUserIdCollection_First(
			long userId, OrderByComparator<UserOneTimeCode> orderByComparator)
		throws com.mypage.user.exception.NoSuchUserOneTimeCodeException {

		return getPersistence().findByUserIdCollection_First(
			userId, orderByComparator);
	}

	/**
	 * Returns the first user one time code in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user one time code, or <code>null</code> if a matching user one time code could not be found
	 */
	public static UserOneTimeCode fetchByUserIdCollection_First(
		long userId, OrderByComparator<UserOneTimeCode> orderByComparator) {

		return getPersistence().fetchByUserIdCollection_First(
			userId, orderByComparator);
	}

	/**
	 * Returns the last user one time code in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user one time code
	 * @throws NoSuchUserOneTimeCodeException if a matching user one time code could not be found
	 */
	public static UserOneTimeCode findByUserIdCollection_Last(
			long userId, OrderByComparator<UserOneTimeCode> orderByComparator)
		throws com.mypage.user.exception.NoSuchUserOneTimeCodeException {

		return getPersistence().findByUserIdCollection_Last(
			userId, orderByComparator);
	}

	/**
	 * Returns the last user one time code in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user one time code, or <code>null</code> if a matching user one time code could not be found
	 */
	public static UserOneTimeCode fetchByUserIdCollection_Last(
		long userId, OrderByComparator<UserOneTimeCode> orderByComparator) {

		return getPersistence().fetchByUserIdCollection_Last(
			userId, orderByComparator);
	}

	/**
	 * Returns the user one time codes before and after the current user one time code in the ordered set where userId = &#63;.
	 *
	 * @param userOneTimeCodeId the primary key of the current user one time code
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user one time code
	 * @throws NoSuchUserOneTimeCodeException if a user one time code with the primary key could not be found
	 */
	public static UserOneTimeCode[] findByUserIdCollection_PrevAndNext(
			long userOneTimeCodeId, long userId,
			OrderByComparator<UserOneTimeCode> orderByComparator)
		throws com.mypage.user.exception.NoSuchUserOneTimeCodeException {

		return getPersistence().findByUserIdCollection_PrevAndNext(
			userOneTimeCodeId, userId, orderByComparator);
	}

	/**
	 * Removes all the user one time codes where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserIdCollection(long userId) {
		getPersistence().removeByUserIdCollection(userId);
	}

	/**
	 * Returns the number of user one time codes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user one time codes
	 */
	public static int countByUserIdCollection(long userId) {
		return getPersistence().countByUserIdCollection(userId);
	}

	/**
	 * Returns the user one time code where userId = &#63; and sharedSecret = &#63; or throws a <code>NoSuchUserOneTimeCodeException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param sharedSecret the shared secret
	 * @return the matching user one time code
	 * @throws NoSuchUserOneTimeCodeException if a matching user one time code could not be found
	 */
	public static UserOneTimeCode findByUserIdSecret(
			long userId, String sharedSecret)
		throws com.mypage.user.exception.NoSuchUserOneTimeCodeException {

		return getPersistence().findByUserIdSecret(userId, sharedSecret);
	}

	/**
	 * Returns the user one time code where userId = &#63; and sharedSecret = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param sharedSecret the shared secret
	 * @return the matching user one time code, or <code>null</code> if a matching user one time code could not be found
	 */
	public static UserOneTimeCode fetchByUserIdSecret(
		long userId, String sharedSecret) {

		return getPersistence().fetchByUserIdSecret(userId, sharedSecret);
	}

	/**
	 * Returns the user one time code where userId = &#63; and sharedSecret = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param sharedSecret the shared secret
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user one time code, or <code>null</code> if a matching user one time code could not be found
	 */
	public static UserOneTimeCode fetchByUserIdSecret(
		long userId, String sharedSecret, boolean useFinderCache) {

		return getPersistence().fetchByUserIdSecret(
			userId, sharedSecret, useFinderCache);
	}

	/**
	 * Removes the user one time code where userId = &#63; and sharedSecret = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param sharedSecret the shared secret
	 * @return the user one time code that was removed
	 */
	public static UserOneTimeCode removeByUserIdSecret(
			long userId, String sharedSecret)
		throws com.mypage.user.exception.NoSuchUserOneTimeCodeException {

		return getPersistence().removeByUserIdSecret(userId, sharedSecret);
	}

	/**
	 * Returns the number of user one time codes where userId = &#63; and sharedSecret = &#63;.
	 *
	 * @param userId the user ID
	 * @param sharedSecret the shared secret
	 * @return the number of matching user one time codes
	 */
	public static int countByUserIdSecret(long userId, String sharedSecret) {
		return getPersistence().countByUserIdSecret(userId, sharedSecret);
	}

	/**
	 * Caches the user one time code in the entity cache if it is enabled.
	 *
	 * @param userOneTimeCode the user one time code
	 */
	public static void cacheResult(UserOneTimeCode userOneTimeCode) {
		getPersistence().cacheResult(userOneTimeCode);
	}

	/**
	 * Caches the user one time codes in the entity cache if it is enabled.
	 *
	 * @param userOneTimeCodes the user one time codes
	 */
	public static void cacheResult(List<UserOneTimeCode> userOneTimeCodes) {
		getPersistence().cacheResult(userOneTimeCodes);
	}

	/**
	 * Creates a new user one time code with the primary key. Does not add the user one time code to the database.
	 *
	 * @param userOneTimeCodeId the primary key for the new user one time code
	 * @return the new user one time code
	 */
	public static UserOneTimeCode create(long userOneTimeCodeId) {
		return getPersistence().create(userOneTimeCodeId);
	}

	/**
	 * Removes the user one time code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userOneTimeCodeId the primary key of the user one time code
	 * @return the user one time code that was removed
	 * @throws NoSuchUserOneTimeCodeException if a user one time code with the primary key could not be found
	 */
	public static UserOneTimeCode remove(long userOneTimeCodeId)
		throws com.mypage.user.exception.NoSuchUserOneTimeCodeException {

		return getPersistence().remove(userOneTimeCodeId);
	}

	public static UserOneTimeCode updateImpl(UserOneTimeCode userOneTimeCode) {
		return getPersistence().updateImpl(userOneTimeCode);
	}

	/**
	 * Returns the user one time code with the primary key or throws a <code>NoSuchUserOneTimeCodeException</code> if it could not be found.
	 *
	 * @param userOneTimeCodeId the primary key of the user one time code
	 * @return the user one time code
	 * @throws NoSuchUserOneTimeCodeException if a user one time code with the primary key could not be found
	 */
	public static UserOneTimeCode findByPrimaryKey(long userOneTimeCodeId)
		throws com.mypage.user.exception.NoSuchUserOneTimeCodeException {

		return getPersistence().findByPrimaryKey(userOneTimeCodeId);
	}

	/**
	 * Returns the user one time code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userOneTimeCodeId the primary key of the user one time code
	 * @return the user one time code, or <code>null</code> if a user one time code with the primary key could not be found
	 */
	public static UserOneTimeCode fetchByPrimaryKey(long userOneTimeCodeId) {
		return getPersistence().fetchByPrimaryKey(userOneTimeCodeId);
	}

	/**
	 * Returns all the user one time codes.
	 *
	 * @return the user one time codes
	 */
	public static List<UserOneTimeCode> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<UserOneTimeCode> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<UserOneTimeCode> findAll(
		int start, int end,
		OrderByComparator<UserOneTimeCode> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<UserOneTimeCode> findAll(
		int start, int end,
		OrderByComparator<UserOneTimeCode> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user one time codes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user one time codes.
	 *
	 * @return the number of user one time codes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserOneTimeCodePersistence getPersistence() {
		return _persistence;
	}

	private static volatile UserOneTimeCodePersistence _persistence;

}