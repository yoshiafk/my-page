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

import com.mypage.user.model.MypageUser;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the mypage user service. This utility wraps <code>com.mypage.user.service.persistence.impl.MypageUserPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserPersistence
 * @generated
 */
public class MypageUserUtil {

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
	public static void clearCache(MypageUser mypageUser) {
		getPersistence().clearCache(mypageUser);
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
	public static Map<Serializable, MypageUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MypageUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MypageUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MypageUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MypageUser> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MypageUser update(MypageUser mypageUser) {
		return getPersistence().update(mypageUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MypageUser update(
		MypageUser mypageUser, ServiceContext serviceContext) {

		return getPersistence().update(mypageUser, serviceContext);
	}

	/**
	 * Returns the mypage user where liferayUserId = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	public static MypageUser findBygetByLiferayUserId(long liferayUserId)
		throws com.mypage.user.exception.NoSuchMypageUserException {

		return getPersistence().findBygetByLiferayUserId(liferayUserId);
	}

	/**
	 * Returns the mypage user where liferayUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public static MypageUser fetchBygetByLiferayUserId(long liferayUserId) {
		return getPersistence().fetchBygetByLiferayUserId(liferayUserId);
	}

	/**
	 * Returns the mypage user where liferayUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param liferayUserId the liferay user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public static MypageUser fetchBygetByLiferayUserId(
		long liferayUserId, boolean useFinderCache) {

		return getPersistence().fetchBygetByLiferayUserId(
			liferayUserId, useFinderCache);
	}

	/**
	 * Removes the mypage user where liferayUserId = &#63; from the database.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the mypage user that was removed
	 */
	public static MypageUser removeBygetByLiferayUserId(long liferayUserId)
		throws com.mypage.user.exception.NoSuchMypageUserException {

		return getPersistence().removeBygetByLiferayUserId(liferayUserId);
	}

	/**
	 * Returns the number of mypage users where liferayUserId = &#63;.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the number of matching mypage users
	 */
	public static int countBygetByLiferayUserId(long liferayUserId) {
		return getPersistence().countBygetByLiferayUserId(liferayUserId);
	}

	/**
	 * Returns the mypage user where creditWalletId = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	public static MypageUser findBycreditWalletId(long creditWalletId)
		throws com.mypage.user.exception.NoSuchMypageUserException {

		return getPersistence().findBycreditWalletId(creditWalletId);
	}

	/**
	 * Returns the mypage user where creditWalletId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public static MypageUser fetchBycreditWalletId(long creditWalletId) {
		return getPersistence().fetchBycreditWalletId(creditWalletId);
	}

	/**
	 * Returns the mypage user where creditWalletId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public static MypageUser fetchBycreditWalletId(
		long creditWalletId, boolean useFinderCache) {

		return getPersistence().fetchBycreditWalletId(
			creditWalletId, useFinderCache);
	}

	/**
	 * Removes the mypage user where creditWalletId = &#63; from the database.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the mypage user that was removed
	 */
	public static MypageUser removeBycreditWalletId(long creditWalletId)
		throws com.mypage.user.exception.NoSuchMypageUserException {

		return getPersistence().removeBycreditWalletId(creditWalletId);
	}

	/**
	 * Returns the number of mypage users where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the number of matching mypage users
	 */
	public static int countBycreditWalletId(long creditWalletId) {
		return getPersistence().countBycreditWalletId(creditWalletId);
	}

	/**
	 * Returns the mypage user where prettyUrl = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param prettyUrl the pretty url
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	public static MypageUser findByPrettyUrl(String prettyUrl)
		throws com.mypage.user.exception.NoSuchMypageUserException {

		return getPersistence().findByPrettyUrl(prettyUrl);
	}

	/**
	 * Returns the mypage user where prettyUrl = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param prettyUrl the pretty url
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public static MypageUser fetchByPrettyUrl(String prettyUrl) {
		return getPersistence().fetchByPrettyUrl(prettyUrl);
	}

	/**
	 * Returns the mypage user where prettyUrl = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param prettyUrl the pretty url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public static MypageUser fetchByPrettyUrl(
		String prettyUrl, boolean useFinderCache) {

		return getPersistence().fetchByPrettyUrl(prettyUrl, useFinderCache);
	}

	/**
	 * Removes the mypage user where prettyUrl = &#63; from the database.
	 *
	 * @param prettyUrl the pretty url
	 * @return the mypage user that was removed
	 */
	public static MypageUser removeByPrettyUrl(String prettyUrl)
		throws com.mypage.user.exception.NoSuchMypageUserException {

		return getPersistence().removeByPrettyUrl(prettyUrl);
	}

	/**
	 * Returns the number of mypage users where prettyUrl = &#63;.
	 *
	 * @param prettyUrl the pretty url
	 * @return the number of matching mypage users
	 */
	public static int countByPrettyUrl(String prettyUrl) {
		return getPersistence().countByPrettyUrl(prettyUrl);
	}

	/**
	 * Returns the mypage user where code = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	public static MypageUser findByAgentCode(String code)
		throws com.mypage.user.exception.NoSuchMypageUserException {

		return getPersistence().findByAgentCode(code);
	}

	/**
	 * Returns the mypage user where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public static MypageUser fetchByAgentCode(String code) {
		return getPersistence().fetchByAgentCode(code);
	}

	/**
	 * Returns the mypage user where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public static MypageUser fetchByAgentCode(
		String code, boolean useFinderCache) {

		return getPersistence().fetchByAgentCode(code, useFinderCache);
	}

	/**
	 * Removes the mypage user where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the mypage user that was removed
	 */
	public static MypageUser removeByAgentCode(String code)
		throws com.mypage.user.exception.NoSuchMypageUserException {

		return getPersistence().removeByAgentCode(code);
	}

	/**
	 * Returns the number of mypage users where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching mypage users
	 */
	public static int countByAgentCode(String code) {
		return getPersistence().countByAgentCode(code);
	}

	/**
	 * Returns the mypage user where email = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	public static MypageUser findByEmailAddress(String email)
		throws com.mypage.user.exception.NoSuchMypageUserException {

		return getPersistence().findByEmailAddress(email);
	}

	/**
	 * Returns the mypage user where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public static MypageUser fetchByEmailAddress(String email) {
		return getPersistence().fetchByEmailAddress(email);
	}

	/**
	 * Returns the mypage user where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public static MypageUser fetchByEmailAddress(
		String email, boolean useFinderCache) {

		return getPersistence().fetchByEmailAddress(email, useFinderCache);
	}

	/**
	 * Removes the mypage user where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the mypage user that was removed
	 */
	public static MypageUser removeByEmailAddress(String email)
		throws com.mypage.user.exception.NoSuchMypageUserException {

		return getPersistence().removeByEmailAddress(email);
	}

	/**
	 * Returns the number of mypage users where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching mypage users
	 */
	public static int countByEmailAddress(String email) {
		return getPersistence().countByEmailAddress(email);
	}

	/**
	 * Returns the mypage user where deptoreCode = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param deptoreCode the deptore code
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	public static MypageUser findByDeptoreCode(String deptoreCode)
		throws com.mypage.user.exception.NoSuchMypageUserException {

		return getPersistence().findByDeptoreCode(deptoreCode);
	}

	/**
	 * Returns the mypage user where deptoreCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param deptoreCode the deptore code
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public static MypageUser fetchByDeptoreCode(String deptoreCode) {
		return getPersistence().fetchByDeptoreCode(deptoreCode);
	}

	/**
	 * Returns the mypage user where deptoreCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param deptoreCode the deptore code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public static MypageUser fetchByDeptoreCode(
		String deptoreCode, boolean useFinderCache) {

		return getPersistence().fetchByDeptoreCode(deptoreCode, useFinderCache);
	}

	/**
	 * Removes the mypage user where deptoreCode = &#63; from the database.
	 *
	 * @param deptoreCode the deptore code
	 * @return the mypage user that was removed
	 */
	public static MypageUser removeByDeptoreCode(String deptoreCode)
		throws com.mypage.user.exception.NoSuchMypageUserException {

		return getPersistence().removeByDeptoreCode(deptoreCode);
	}

	/**
	 * Returns the number of mypage users where deptoreCode = &#63;.
	 *
	 * @param deptoreCode the deptore code
	 * @return the number of matching mypage users
	 */
	public static int countByDeptoreCode(String deptoreCode) {
		return getPersistence().countByDeptoreCode(deptoreCode);
	}

	/**
	 * Returns the mypage user where mypageUserRoleId = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	public static MypageUser findByRoleId(long mypageUserRoleId)
		throws com.mypage.user.exception.NoSuchMypageUserException {

		return getPersistence().findByRoleId(mypageUserRoleId);
	}

	/**
	 * Returns the mypage user where mypageUserRoleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public static MypageUser fetchByRoleId(long mypageUserRoleId) {
		return getPersistence().fetchByRoleId(mypageUserRoleId);
	}

	/**
	 * Returns the mypage user where mypageUserRoleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	public static MypageUser fetchByRoleId(
		long mypageUserRoleId, boolean useFinderCache) {

		return getPersistence().fetchByRoleId(mypageUserRoleId, useFinderCache);
	}

	/**
	 * Removes the mypage user where mypageUserRoleId = &#63; from the database.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the mypage user that was removed
	 */
	public static MypageUser removeByRoleId(long mypageUserRoleId)
		throws com.mypage.user.exception.NoSuchMypageUserException {

		return getPersistence().removeByRoleId(mypageUserRoleId);
	}

	/**
	 * Returns the number of mypage users where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the number of matching mypage users
	 */
	public static int countByRoleId(long mypageUserRoleId) {
		return getPersistence().countByRoleId(mypageUserRoleId);
	}

	/**
	 * Caches the mypage user in the entity cache if it is enabled.
	 *
	 * @param mypageUser the mypage user
	 */
	public static void cacheResult(MypageUser mypageUser) {
		getPersistence().cacheResult(mypageUser);
	}

	/**
	 * Caches the mypage users in the entity cache if it is enabled.
	 *
	 * @param mypageUsers the mypage users
	 */
	public static void cacheResult(List<MypageUser> mypageUsers) {
		getPersistence().cacheResult(mypageUsers);
	}

	/**
	 * Creates a new mypage user with the primary key. Does not add the mypage user to the database.
	 *
	 * @param mypageUserId the primary key for the new mypage user
	 * @return the new mypage user
	 */
	public static MypageUser create(long mypageUserId) {
		return getPersistence().create(mypageUserId);
	}

	/**
	 * Removes the mypage user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserId the primary key of the mypage user
	 * @return the mypage user that was removed
	 * @throws NoSuchMypageUserException if a mypage user with the primary key could not be found
	 */
	public static MypageUser remove(long mypageUserId)
		throws com.mypage.user.exception.NoSuchMypageUserException {

		return getPersistence().remove(mypageUserId);
	}

	public static MypageUser updateImpl(MypageUser mypageUser) {
		return getPersistence().updateImpl(mypageUser);
	}

	/**
	 * Returns the mypage user with the primary key or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param mypageUserId the primary key of the mypage user
	 * @return the mypage user
	 * @throws NoSuchMypageUserException if a mypage user with the primary key could not be found
	 */
	public static MypageUser findByPrimaryKey(long mypageUserId)
		throws com.mypage.user.exception.NoSuchMypageUserException {

		return getPersistence().findByPrimaryKey(mypageUserId);
	}

	/**
	 * Returns the mypage user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserId the primary key of the mypage user
	 * @return the mypage user, or <code>null</code> if a mypage user with the primary key could not be found
	 */
	public static MypageUser fetchByPrimaryKey(long mypageUserId) {
		return getPersistence().fetchByPrimaryKey(mypageUserId);
	}

	/**
	 * Returns all the mypage users.
	 *
	 * @return the mypage users
	 */
	public static List<MypageUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the mypage users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage users
	 * @param end the upper bound of the range of mypage users (not inclusive)
	 * @return the range of mypage users
	 */
	public static List<MypageUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the mypage users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage users
	 * @param end the upper bound of the range of mypage users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage users
	 */
	public static List<MypageUser> findAll(
		int start, int end, OrderByComparator<MypageUser> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the mypage users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage users
	 * @param end the upper bound of the range of mypage users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage users
	 */
	public static List<MypageUser> findAll(
		int start, int end, OrderByComparator<MypageUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the mypage users from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of mypage users.
	 *
	 * @return the number of mypage users
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MypageUserPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MypageUserPersistence _persistence;

}