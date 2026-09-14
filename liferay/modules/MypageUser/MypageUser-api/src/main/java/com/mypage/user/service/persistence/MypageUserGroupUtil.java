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

import com.mypage.user.model.MypageUserGroup;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the mypage user group service. This utility wraps <code>com.mypage.user.service.persistence.impl.MypageUserGroupPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserGroupPersistence
 * @generated
 */
public class MypageUserGroupUtil {

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
	public static void clearCache(MypageUserGroup mypageUserGroup) {
		getPersistence().clearCache(mypageUserGroup);
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
	public static Map<Serializable, MypageUserGroup> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MypageUserGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MypageUserGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MypageUserGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MypageUserGroup> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MypageUserGroup update(MypageUserGroup mypageUserGroup) {
		return getPersistence().update(mypageUserGroup);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MypageUserGroup update(
		MypageUserGroup mypageUserGroup, ServiceContext serviceContext) {

		return getPersistence().update(mypageUserGroup, serviceContext);
	}

	/**
	 * Caches the mypage user group in the entity cache if it is enabled.
	 *
	 * @param mypageUserGroup the mypage user group
	 */
	public static void cacheResult(MypageUserGroup mypageUserGroup) {
		getPersistence().cacheResult(mypageUserGroup);
	}

	/**
	 * Caches the mypage user groups in the entity cache if it is enabled.
	 *
	 * @param mypageUserGroups the mypage user groups
	 */
	public static void cacheResult(List<MypageUserGroup> mypageUserGroups) {
		getPersistence().cacheResult(mypageUserGroups);
	}

	/**
	 * Creates a new mypage user group with the primary key. Does not add the mypage user group to the database.
	 *
	 * @param mypageUserGroupId the primary key for the new mypage user group
	 * @return the new mypage user group
	 */
	public static MypageUserGroup create(long mypageUserGroupId) {
		return getPersistence().create(mypageUserGroupId);
	}

	/**
	 * Removes the mypage user group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserGroupId the primary key of the mypage user group
	 * @return the mypage user group that was removed
	 * @throws NoSuchMypageUserGroupException if a mypage user group with the primary key could not be found
	 */
	public static MypageUserGroup remove(long mypageUserGroupId)
		throws com.mypage.user.exception.NoSuchMypageUserGroupException {

		return getPersistence().remove(mypageUserGroupId);
	}

	public static MypageUserGroup updateImpl(MypageUserGroup mypageUserGroup) {
		return getPersistence().updateImpl(mypageUserGroup);
	}

	/**
	 * Returns the mypage user group with the primary key or throws a <code>NoSuchMypageUserGroupException</code> if it could not be found.
	 *
	 * @param mypageUserGroupId the primary key of the mypage user group
	 * @return the mypage user group
	 * @throws NoSuchMypageUserGroupException if a mypage user group with the primary key could not be found
	 */
	public static MypageUserGroup findByPrimaryKey(long mypageUserGroupId)
		throws com.mypage.user.exception.NoSuchMypageUserGroupException {

		return getPersistence().findByPrimaryKey(mypageUserGroupId);
	}

	/**
	 * Returns the mypage user group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserGroupId the primary key of the mypage user group
	 * @return the mypage user group, or <code>null</code> if a mypage user group with the primary key could not be found
	 */
	public static MypageUserGroup fetchByPrimaryKey(long mypageUserGroupId) {
		return getPersistence().fetchByPrimaryKey(mypageUserGroupId);
	}

	/**
	 * Returns all the mypage user groups.
	 *
	 * @return the mypage user groups
	 */
	public static List<MypageUserGroup> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the mypage user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user groups
	 * @param end the upper bound of the range of mypage user groups (not inclusive)
	 * @return the range of mypage user groups
	 */
	public static List<MypageUserGroup> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the mypage user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user groups
	 * @param end the upper bound of the range of mypage user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage user groups
	 */
	public static List<MypageUserGroup> findAll(
		int start, int end,
		OrderByComparator<MypageUserGroup> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the mypage user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user groups
	 * @param end the upper bound of the range of mypage user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage user groups
	 */
	public static List<MypageUserGroup> findAll(
		int start, int end,
		OrderByComparator<MypageUserGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the mypage user groups from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of mypage user groups.
	 *
	 * @return the number of mypage user groups
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MypageUserGroupPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MypageUserGroupPersistence _persistence;

}