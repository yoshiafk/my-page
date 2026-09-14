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

package com.mypage.admin.product.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.SmartHealthBenefitGroup;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the smart health benefit group service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.SmartHealthBenefitGroupPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartHealthBenefitGroupPersistence
 * @generated
 */
public class SmartHealthBenefitGroupUtil {

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
		SmartHealthBenefitGroup smartHealthBenefitGroup) {

		getPersistence().clearCache(smartHealthBenefitGroup);
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
	public static Map<Serializable, SmartHealthBenefitGroup> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SmartHealthBenefitGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SmartHealthBenefitGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SmartHealthBenefitGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SmartHealthBenefitGroup> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SmartHealthBenefitGroup update(
		SmartHealthBenefitGroup smartHealthBenefitGroup) {

		return getPersistence().update(smartHealthBenefitGroup);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SmartHealthBenefitGroup update(
		SmartHealthBenefitGroup smartHealthBenefitGroup,
		ServiceContext serviceContext) {

		return getPersistence().update(smartHealthBenefitGroup, serviceContext);
	}

	/**
	 * Returns the smart health benefit group where groupCode = &#63; or throws a <code>NoSuchSmartHealthBenefitGroupException</code> if it could not be found.
	 *
	 * @param groupCode the group code
	 * @return the matching smart health benefit group
	 * @throws NoSuchSmartHealthBenefitGroupException if a matching smart health benefit group could not be found
	 */
	public static SmartHealthBenefitGroup findBygroupCode(String groupCode)
		throws com.mypage.admin.product.exception.
			NoSuchSmartHealthBenefitGroupException {

		return getPersistence().findBygroupCode(groupCode);
	}

	/**
	 * Returns the smart health benefit group where groupCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupCode the group code
	 * @return the matching smart health benefit group, or <code>null</code> if a matching smart health benefit group could not be found
	 */
	public static SmartHealthBenefitGroup fetchBygroupCode(String groupCode) {
		return getPersistence().fetchBygroupCode(groupCode);
	}

	/**
	 * Returns the smart health benefit group where groupCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupCode the group code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart health benefit group, or <code>null</code> if a matching smart health benefit group could not be found
	 */
	public static SmartHealthBenefitGroup fetchBygroupCode(
		String groupCode, boolean useFinderCache) {

		return getPersistence().fetchBygroupCode(groupCode, useFinderCache);
	}

	/**
	 * Removes the smart health benefit group where groupCode = &#63; from the database.
	 *
	 * @param groupCode the group code
	 * @return the smart health benefit group that was removed
	 */
	public static SmartHealthBenefitGroup removeBygroupCode(String groupCode)
		throws com.mypage.admin.product.exception.
			NoSuchSmartHealthBenefitGroupException {

		return getPersistence().removeBygroupCode(groupCode);
	}

	/**
	 * Returns the number of smart health benefit groups where groupCode = &#63;.
	 *
	 * @param groupCode the group code
	 * @return the number of matching smart health benefit groups
	 */
	public static int countBygroupCode(String groupCode) {
		return getPersistence().countBygroupCode(groupCode);
	}

	/**
	 * Caches the smart health benefit group in the entity cache if it is enabled.
	 *
	 * @param smartHealthBenefitGroup the smart health benefit group
	 */
	public static void cacheResult(
		SmartHealthBenefitGroup smartHealthBenefitGroup) {

		getPersistence().cacheResult(smartHealthBenefitGroup);
	}

	/**
	 * Caches the smart health benefit groups in the entity cache if it is enabled.
	 *
	 * @param smartHealthBenefitGroups the smart health benefit groups
	 */
	public static void cacheResult(
		List<SmartHealthBenefitGroup> smartHealthBenefitGroups) {

		getPersistence().cacheResult(smartHealthBenefitGroups);
	}

	/**
	 * Creates a new smart health benefit group with the primary key. Does not add the smart health benefit group to the database.
	 *
	 * @param smartHealthBenefitGroupId the primary key for the new smart health benefit group
	 * @return the new smart health benefit group
	 */
	public static SmartHealthBenefitGroup create(
		long smartHealthBenefitGroupId) {

		return getPersistence().create(smartHealthBenefitGroupId);
	}

	/**
	 * Removes the smart health benefit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartHealthBenefitGroupId the primary key of the smart health benefit group
	 * @return the smart health benefit group that was removed
	 * @throws NoSuchSmartHealthBenefitGroupException if a smart health benefit group with the primary key could not be found
	 */
	public static SmartHealthBenefitGroup remove(long smartHealthBenefitGroupId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartHealthBenefitGroupException {

		return getPersistence().remove(smartHealthBenefitGroupId);
	}

	public static SmartHealthBenefitGroup updateImpl(
		SmartHealthBenefitGroup smartHealthBenefitGroup) {

		return getPersistence().updateImpl(smartHealthBenefitGroup);
	}

	/**
	 * Returns the smart health benefit group with the primary key or throws a <code>NoSuchSmartHealthBenefitGroupException</code> if it could not be found.
	 *
	 * @param smartHealthBenefitGroupId the primary key of the smart health benefit group
	 * @return the smart health benefit group
	 * @throws NoSuchSmartHealthBenefitGroupException if a smart health benefit group with the primary key could not be found
	 */
	public static SmartHealthBenefitGroup findByPrimaryKey(
			long smartHealthBenefitGroupId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartHealthBenefitGroupException {

		return getPersistence().findByPrimaryKey(smartHealthBenefitGroupId);
	}

	/**
	 * Returns the smart health benefit group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartHealthBenefitGroupId the primary key of the smart health benefit group
	 * @return the smart health benefit group, or <code>null</code> if a smart health benefit group with the primary key could not be found
	 */
	public static SmartHealthBenefitGroup fetchByPrimaryKey(
		long smartHealthBenefitGroupId) {

		return getPersistence().fetchByPrimaryKey(smartHealthBenefitGroupId);
	}

	/**
	 * Returns all the smart health benefit groups.
	 *
	 * @return the smart health benefit groups
	 */
	public static List<SmartHealthBenefitGroup> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the smart health benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefit groups
	 * @param end the upper bound of the range of smart health benefit groups (not inclusive)
	 * @return the range of smart health benefit groups
	 */
	public static List<SmartHealthBenefitGroup> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the smart health benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefit groups
	 * @param end the upper bound of the range of smart health benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart health benefit groups
	 */
	public static List<SmartHealthBenefitGroup> findAll(
		int start, int end,
		OrderByComparator<SmartHealthBenefitGroup> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart health benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefit groups
	 * @param end the upper bound of the range of smart health benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart health benefit groups
	 */
	public static List<SmartHealthBenefitGroup> findAll(
		int start, int end,
		OrderByComparator<SmartHealthBenefitGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the smart health benefit groups from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of smart health benefit groups.
	 *
	 * @return the number of smart health benefit groups
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SmartHealthBenefitGroupPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SmartHealthBenefitGroupPersistence _persistence;

}