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

import com.aii.esppk.admin.model.SppkUser;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the sppk user service. This utility wraps <code>com.aii.esppk.admin.service.persistence.impl.SppkUserPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see SppkUserPersistence
 * @generated
 */
public class SppkUserUtil {

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
	public static void clearCache(SppkUser sppkUser) {
		getPersistence().clearCache(sppkUser);
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
	public static Map<Serializable, SppkUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SppkUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SppkUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SppkUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SppkUser> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SppkUser update(SppkUser sppkUser) {
		return getPersistence().update(sppkUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SppkUser update(
		SppkUser sppkUser, ServiceContext serviceContext) {

		return getPersistence().update(sppkUser, serviceContext);
	}

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; or throws a <code>NoSuchSppkUserException</code> if it could not be found.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @return the matching sppk user
	 * @throws NoSuchSppkUserException if a matching sppk user could not be found
	 */
	public static SppkUser findBysppkLoginCode(String sppkLoginCode)
		throws com.aii.esppk.admin.exception.NoSuchSppkUserException {

		return getPersistence().findBysppkLoginCode(sppkLoginCode);
	}

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	public static SppkUser fetchBysppkLoginCode(String sppkLoginCode) {
		return getPersistence().fetchBysppkLoginCode(sppkLoginCode);
	}

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	public static SppkUser fetchBysppkLoginCode(
		String sppkLoginCode, boolean useFinderCache) {

		return getPersistence().fetchBysppkLoginCode(
			sppkLoginCode, useFinderCache);
	}

	/**
	 * Removes the sppk user where sppkLoginCode = &#63; from the database.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @return the sppk user that was removed
	 */
	public static SppkUser removeBysppkLoginCode(String sppkLoginCode)
		throws com.aii.esppk.admin.exception.NoSuchSppkUserException {

		return getPersistence().removeBysppkLoginCode(sppkLoginCode);
	}

	/**
	 * Returns the number of sppk users where sppkLoginCode = &#63;.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @return the number of matching sppk users
	 */
	public static int countBysppkLoginCode(String sppkLoginCode) {
		return getPersistence().countBysppkLoginCode(sppkLoginCode);
	}

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; and password = &#63; or throws a <code>NoSuchSppkUserException</code> if it could not be found.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param password the password
	 * @return the matching sppk user
	 * @throws NoSuchSppkUserException if a matching sppk user could not be found
	 */
	public static SppkUser findBysppkLoginCodeAndPassword(
			String sppkLoginCode, String password)
		throws com.aii.esppk.admin.exception.NoSuchSppkUserException {

		return getPersistence().findBysppkLoginCodeAndPassword(
			sppkLoginCode, password);
	}

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; and password = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param password the password
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	public static SppkUser fetchBysppkLoginCodeAndPassword(
		String sppkLoginCode, String password) {

		return getPersistence().fetchBysppkLoginCodeAndPassword(
			sppkLoginCode, password);
	}

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; and password = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param password the password
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	public static SppkUser fetchBysppkLoginCodeAndPassword(
		String sppkLoginCode, String password, boolean useFinderCache) {

		return getPersistence().fetchBysppkLoginCodeAndPassword(
			sppkLoginCode, password, useFinderCache);
	}

	/**
	 * Removes the sppk user where sppkLoginCode = &#63; and password = &#63; from the database.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param password the password
	 * @return the sppk user that was removed
	 */
	public static SppkUser removeBysppkLoginCodeAndPassword(
			String sppkLoginCode, String password)
		throws com.aii.esppk.admin.exception.NoSuchSppkUserException {

		return getPersistence().removeBysppkLoginCodeAndPassword(
			sppkLoginCode, password);
	}

	/**
	 * Returns the number of sppk users where sppkLoginCode = &#63; and password = &#63;.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param password the password
	 * @return the number of matching sppk users
	 */
	public static int countBysppkLoginCodeAndPassword(
		String sppkLoginCode, String password) {

		return getPersistence().countBysppkLoginCodeAndPassword(
			sppkLoginCode, password);
	}

	/**
	 * Returns all the sppk users where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @return the matching sppk users
	 */
	public static List<SppkUser> findByfullName(String fullName) {
		return getPersistence().findByfullName(fullName);
	}

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
	public static List<SppkUser> findByfullName(
		String fullName, int start, int end) {

		return getPersistence().findByfullName(fullName, start, end);
	}

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
	public static List<SppkUser> findByfullName(
		String fullName, int start, int end,
		OrderByComparator<SppkUser> orderByComparator) {

		return getPersistence().findByfullName(
			fullName, start, end, orderByComparator);
	}

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
	public static List<SppkUser> findByfullName(
		String fullName, int start, int end,
		OrderByComparator<SppkUser> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByfullName(
			fullName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sppk user in the ordered set where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sppk user
	 * @throws NoSuchSppkUserException if a matching sppk user could not be found
	 */
	public static SppkUser findByfullName_First(
			String fullName, OrderByComparator<SppkUser> orderByComparator)
		throws com.aii.esppk.admin.exception.NoSuchSppkUserException {

		return getPersistence().findByfullName_First(
			fullName, orderByComparator);
	}

	/**
	 * Returns the first sppk user in the ordered set where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	public static SppkUser fetchByfullName_First(
		String fullName, OrderByComparator<SppkUser> orderByComparator) {

		return getPersistence().fetchByfullName_First(
			fullName, orderByComparator);
	}

	/**
	 * Returns the last sppk user in the ordered set where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sppk user
	 * @throws NoSuchSppkUserException if a matching sppk user could not be found
	 */
	public static SppkUser findByfullName_Last(
			String fullName, OrderByComparator<SppkUser> orderByComparator)
		throws com.aii.esppk.admin.exception.NoSuchSppkUserException {

		return getPersistence().findByfullName_Last(
			fullName, orderByComparator);
	}

	/**
	 * Returns the last sppk user in the ordered set where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	public static SppkUser fetchByfullName_Last(
		String fullName, OrderByComparator<SppkUser> orderByComparator) {

		return getPersistence().fetchByfullName_Last(
			fullName, orderByComparator);
	}

	/**
	 * Returns the sppk users before and after the current sppk user in the ordered set where fullName LIKE &#63;.
	 *
	 * @param sppkUserId the primary key of the current sppk user
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sppk user
	 * @throws NoSuchSppkUserException if a sppk user with the primary key could not be found
	 */
	public static SppkUser[] findByfullName_PrevAndNext(
			long sppkUserId, String fullName,
			OrderByComparator<SppkUser> orderByComparator)
		throws com.aii.esppk.admin.exception.NoSuchSppkUserException {

		return getPersistence().findByfullName_PrevAndNext(
			sppkUserId, fullName, orderByComparator);
	}

	/**
	 * Removes all the sppk users where fullName LIKE &#63; from the database.
	 *
	 * @param fullName the full name
	 */
	public static void removeByfullName(String fullName) {
		getPersistence().removeByfullName(fullName);
	}

	/**
	 * Returns the number of sppk users where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @return the number of matching sppk users
	 */
	public static int countByfullName(String fullName) {
		return getPersistence().countByfullName(fullName);
	}

	/**
	 * Returns the sppk user where email = &#63; and otpCode = &#63; or throws a <code>NoSuchSppkUserException</code> if it could not be found.
	 *
	 * @param email the email
	 * @param otpCode the otp code
	 * @return the matching sppk user
	 * @throws NoSuchSppkUserException if a matching sppk user could not be found
	 */
	public static SppkUser findByemailAndOtpCode(String email, String otpCode)
		throws com.aii.esppk.admin.exception.NoSuchSppkUserException {

		return getPersistence().findByemailAndOtpCode(email, otpCode);
	}

	/**
	 * Returns the sppk user where email = &#63; and otpCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @param otpCode the otp code
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	public static SppkUser fetchByemailAndOtpCode(
		String email, String otpCode) {

		return getPersistence().fetchByemailAndOtpCode(email, otpCode);
	}

	/**
	 * Returns the sppk user where email = &#63; and otpCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param otpCode the otp code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	public static SppkUser fetchByemailAndOtpCode(
		String email, String otpCode, boolean useFinderCache) {

		return getPersistence().fetchByemailAndOtpCode(
			email, otpCode, useFinderCache);
	}

	/**
	 * Removes the sppk user where email = &#63; and otpCode = &#63; from the database.
	 *
	 * @param email the email
	 * @param otpCode the otp code
	 * @return the sppk user that was removed
	 */
	public static SppkUser removeByemailAndOtpCode(String email, String otpCode)
		throws com.aii.esppk.admin.exception.NoSuchSppkUserException {

		return getPersistence().removeByemailAndOtpCode(email, otpCode);
	}

	/**
	 * Returns the number of sppk users where email = &#63; and otpCode = &#63;.
	 *
	 * @param email the email
	 * @param otpCode the otp code
	 * @return the number of matching sppk users
	 */
	public static int countByemailAndOtpCode(String email, String otpCode) {
		return getPersistence().countByemailAndOtpCode(email, otpCode);
	}

	/**
	 * Caches the sppk user in the entity cache if it is enabled.
	 *
	 * @param sppkUser the sppk user
	 */
	public static void cacheResult(SppkUser sppkUser) {
		getPersistence().cacheResult(sppkUser);
	}

	/**
	 * Caches the sppk users in the entity cache if it is enabled.
	 *
	 * @param sppkUsers the sppk users
	 */
	public static void cacheResult(List<SppkUser> sppkUsers) {
		getPersistence().cacheResult(sppkUsers);
	}

	/**
	 * Creates a new sppk user with the primary key. Does not add the sppk user to the database.
	 *
	 * @param sppkUserId the primary key for the new sppk user
	 * @return the new sppk user
	 */
	public static SppkUser create(long sppkUserId) {
		return getPersistence().create(sppkUserId);
	}

	/**
	 * Removes the sppk user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sppkUserId the primary key of the sppk user
	 * @return the sppk user that was removed
	 * @throws NoSuchSppkUserException if a sppk user with the primary key could not be found
	 */
	public static SppkUser remove(long sppkUserId)
		throws com.aii.esppk.admin.exception.NoSuchSppkUserException {

		return getPersistence().remove(sppkUserId);
	}

	public static SppkUser updateImpl(SppkUser sppkUser) {
		return getPersistence().updateImpl(sppkUser);
	}

	/**
	 * Returns the sppk user with the primary key or throws a <code>NoSuchSppkUserException</code> if it could not be found.
	 *
	 * @param sppkUserId the primary key of the sppk user
	 * @return the sppk user
	 * @throws NoSuchSppkUserException if a sppk user with the primary key could not be found
	 */
	public static SppkUser findByPrimaryKey(long sppkUserId)
		throws com.aii.esppk.admin.exception.NoSuchSppkUserException {

		return getPersistence().findByPrimaryKey(sppkUserId);
	}

	/**
	 * Returns the sppk user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sppkUserId the primary key of the sppk user
	 * @return the sppk user, or <code>null</code> if a sppk user with the primary key could not be found
	 */
	public static SppkUser fetchByPrimaryKey(long sppkUserId) {
		return getPersistence().fetchByPrimaryKey(sppkUserId);
	}

	/**
	 * Returns all the sppk users.
	 *
	 * @return the sppk users
	 */
	public static List<SppkUser> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<SppkUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<SppkUser> findAll(
		int start, int end, OrderByComparator<SppkUser> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<SppkUser> findAll(
		int start, int end, OrderByComparator<SppkUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sppk users from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sppk users.
	 *
	 * @return the number of sppk users
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SppkUserPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SppkUserPersistence _persistence;

}