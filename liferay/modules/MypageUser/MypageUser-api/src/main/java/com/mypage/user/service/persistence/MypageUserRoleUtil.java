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

import com.mypage.user.model.MypageUserRole;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the mypage user role service. This utility wraps <code>com.mypage.user.service.persistence.impl.MypageUserRolePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserRolePersistence
 * @generated
 */
public class MypageUserRoleUtil {

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
	public static void clearCache(MypageUserRole mypageUserRole) {
		getPersistence().clearCache(mypageUserRole);
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
	public static Map<Serializable, MypageUserRole> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MypageUserRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MypageUserRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MypageUserRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MypageUserRole> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MypageUserRole update(MypageUserRole mypageUserRole) {
		return getPersistence().update(mypageUserRole);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MypageUserRole update(
		MypageUserRole mypageUserRole, ServiceContext serviceContext) {

		return getPersistence().update(mypageUserRole, serviceContext);
	}

	/**
	 * Caches the mypage user role in the entity cache if it is enabled.
	 *
	 * @param mypageUserRole the mypage user role
	 */
	public static void cacheResult(MypageUserRole mypageUserRole) {
		getPersistence().cacheResult(mypageUserRole);
	}

	/**
	 * Caches the mypage user roles in the entity cache if it is enabled.
	 *
	 * @param mypageUserRoles the mypage user roles
	 */
	public static void cacheResult(List<MypageUserRole> mypageUserRoles) {
		getPersistence().cacheResult(mypageUserRoles);
	}

	/**
	 * Creates a new mypage user role with the primary key. Does not add the mypage user role to the database.
	 *
	 * @param mypageUserRoleId the primary key for the new mypage user role
	 * @return the new mypage user role
	 */
	public static MypageUserRole create(long mypageUserRoleId) {
		return getPersistence().create(mypageUserRoleId);
	}

	/**
	 * Removes the mypage user role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserRoleId the primary key of the mypage user role
	 * @return the mypage user role that was removed
	 * @throws NoSuchMypageUserRoleException if a mypage user role with the primary key could not be found
	 */
	public static MypageUserRole remove(long mypageUserRoleId)
		throws com.mypage.user.exception.NoSuchMypageUserRoleException {

		return getPersistence().remove(mypageUserRoleId);
	}

	public static MypageUserRole updateImpl(MypageUserRole mypageUserRole) {
		return getPersistence().updateImpl(mypageUserRole);
	}

	/**
	 * Returns the mypage user role with the primary key or throws a <code>NoSuchMypageUserRoleException</code> if it could not be found.
	 *
	 * @param mypageUserRoleId the primary key of the mypage user role
	 * @return the mypage user role
	 * @throws NoSuchMypageUserRoleException if a mypage user role with the primary key could not be found
	 */
	public static MypageUserRole findByPrimaryKey(long mypageUserRoleId)
		throws com.mypage.user.exception.NoSuchMypageUserRoleException {

		return getPersistence().findByPrimaryKey(mypageUserRoleId);
	}

	/**
	 * Returns the mypage user role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserRoleId the primary key of the mypage user role
	 * @return the mypage user role, or <code>null</code> if a mypage user role with the primary key could not be found
	 */
	public static MypageUserRole fetchByPrimaryKey(long mypageUserRoleId) {
		return getPersistence().fetchByPrimaryKey(mypageUserRoleId);
	}

	/**
	 * Returns all the mypage user roles.
	 *
	 * @return the mypage user roles
	 */
	public static List<MypageUserRole> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the mypage user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user roles
	 * @param end the upper bound of the range of mypage user roles (not inclusive)
	 * @return the range of mypage user roles
	 */
	public static List<MypageUserRole> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the mypage user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user roles
	 * @param end the upper bound of the range of mypage user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage user roles
	 */
	public static List<MypageUserRole> findAll(
		int start, int end,
		OrderByComparator<MypageUserRole> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the mypage user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user roles
	 * @param end the upper bound of the range of mypage user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage user roles
	 */
	public static List<MypageUserRole> findAll(
		int start, int end, OrderByComparator<MypageUserRole> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the mypage user roles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of mypage user roles.
	 *
	 * @return the number of mypage user roles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MypageUserRolePersistence getPersistence() {
		return _persistence;
	}

	private static volatile MypageUserRolePersistence _persistence;

}