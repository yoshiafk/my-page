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

import com.mypage.admin.product.model.TravelDomesticBenefitGroup;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the travel domestic benefit group service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.TravelDomesticBenefitGroupPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticBenefitGroupPersistence
 * @generated
 */
public class TravelDomesticBenefitGroupUtil {

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
		TravelDomesticBenefitGroup travelDomesticBenefitGroup) {

		getPersistence().clearCache(travelDomesticBenefitGroup);
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
	public static Map<Serializable, TravelDomesticBenefitGroup>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TravelDomesticBenefitGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TravelDomesticBenefitGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TravelDomesticBenefitGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TravelDomesticBenefitGroup> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TravelDomesticBenefitGroup update(
		TravelDomesticBenefitGroup travelDomesticBenefitGroup) {

		return getPersistence().update(travelDomesticBenefitGroup);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TravelDomesticBenefitGroup update(
		TravelDomesticBenefitGroup travelDomesticBenefitGroup,
		ServiceContext serviceContext) {

		return getPersistence().update(
			travelDomesticBenefitGroup, serviceContext);
	}

	/**
	 * Returns all the travel domestic benefit groups where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @return the matching travel domestic benefit groups
	 */
	public static List<TravelDomesticBenefitGroup>
		findBysearchTravelDomesticBenefitGroupId(
			long travelDomesticBenefitGroupId) {

		return getPersistence().findBysearchTravelDomesticBenefitGroupId(
			travelDomesticBenefitGroupId);
	}

	/**
	 * Returns a range of all the travel domestic benefit groups where travelDomesticBenefitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @return the range of matching travel domestic benefit groups
	 */
	public static List<TravelDomesticBenefitGroup>
		findBysearchTravelDomesticBenefitGroupId(
			long travelDomesticBenefitGroupId, int start, int end) {

		return getPersistence().findBysearchTravelDomesticBenefitGroupId(
			travelDomesticBenefitGroupId, start, end);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefit groups where travelDomesticBenefitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic benefit groups
	 */
	public static List<TravelDomesticBenefitGroup>
		findBysearchTravelDomesticBenefitGroupId(
			long travelDomesticBenefitGroupId, int start, int end,
			OrderByComparator<TravelDomesticBenefitGroup> orderByComparator) {

		return getPersistence().findBysearchTravelDomesticBenefitGroupId(
			travelDomesticBenefitGroupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefit groups where travelDomesticBenefitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic benefit groups
	 */
	public static List<TravelDomesticBenefitGroup>
		findBysearchTravelDomesticBenefitGroupId(
			long travelDomesticBenefitGroupId, int start, int end,
			OrderByComparator<TravelDomesticBenefitGroup> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findBysearchTravelDomesticBenefitGroupId(
			travelDomesticBenefitGroupId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first travel domestic benefit group in the ordered set where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit group
	 * @throws NoSuchTravelDomesticBenefitGroupException if a matching travel domestic benefit group could not be found
	 */
	public static TravelDomesticBenefitGroup
			findBysearchTravelDomesticBenefitGroupId_First(
				long travelDomesticBenefitGroupId,
				OrderByComparator<TravelDomesticBenefitGroup> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticBenefitGroupException {

		return getPersistence().findBysearchTravelDomesticBenefitGroupId_First(
			travelDomesticBenefitGroupId, orderByComparator);
	}

	/**
	 * Returns the first travel domestic benefit group in the ordered set where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit group, or <code>null</code> if a matching travel domestic benefit group could not be found
	 */
	public static TravelDomesticBenefitGroup
		fetchBysearchTravelDomesticBenefitGroupId_First(
			long travelDomesticBenefitGroupId,
			OrderByComparator<TravelDomesticBenefitGroup> orderByComparator) {

		return getPersistence().fetchBysearchTravelDomesticBenefitGroupId_First(
			travelDomesticBenefitGroupId, orderByComparator);
	}

	/**
	 * Returns the last travel domestic benefit group in the ordered set where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit group
	 * @throws NoSuchTravelDomesticBenefitGroupException if a matching travel domestic benefit group could not be found
	 */
	public static TravelDomesticBenefitGroup
			findBysearchTravelDomesticBenefitGroupId_Last(
				long travelDomesticBenefitGroupId,
				OrderByComparator<TravelDomesticBenefitGroup> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticBenefitGroupException {

		return getPersistence().findBysearchTravelDomesticBenefitGroupId_Last(
			travelDomesticBenefitGroupId, orderByComparator);
	}

	/**
	 * Returns the last travel domestic benefit group in the ordered set where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit group, or <code>null</code> if a matching travel domestic benefit group could not be found
	 */
	public static TravelDomesticBenefitGroup
		fetchBysearchTravelDomesticBenefitGroupId_Last(
			long travelDomesticBenefitGroupId,
			OrderByComparator<TravelDomesticBenefitGroup> orderByComparator) {

		return getPersistence().fetchBysearchTravelDomesticBenefitGroupId_Last(
			travelDomesticBenefitGroupId, orderByComparator);
	}

	/**
	 * Removes all the travel domestic benefit groups where travelDomesticBenefitGroupId = &#63; from the database.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 */
	public static void removeBysearchTravelDomesticBenefitGroupId(
		long travelDomesticBenefitGroupId) {

		getPersistence().removeBysearchTravelDomesticBenefitGroupId(
			travelDomesticBenefitGroupId);
	}

	/**
	 * Returns the number of travel domestic benefit groups where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @return the number of matching travel domestic benefit groups
	 */
	public static int countBysearchTravelDomesticBenefitGroupId(
		long travelDomesticBenefitGroupId) {

		return getPersistence().countBysearchTravelDomesticBenefitGroupId(
			travelDomesticBenefitGroupId);
	}

	/**
	 * Returns the travel domestic benefit group where code = &#63; or throws a <code>NoSuchTravelDomesticBenefitGroupException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching travel domestic benefit group
	 * @throws NoSuchTravelDomesticBenefitGroupException if a matching travel domestic benefit group could not be found
	 */
	public static TravelDomesticBenefitGroup
			findBysearchTravelDomesticBenefitGroupCode(String code)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticBenefitGroupException {

		return getPersistence().findBysearchTravelDomesticBenefitGroupCode(
			code);
	}

	/**
	 * Returns the travel domestic benefit group where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching travel domestic benefit group, or <code>null</code> if a matching travel domestic benefit group could not be found
	 */
	public static TravelDomesticBenefitGroup
		fetchBysearchTravelDomesticBenefitGroupCode(String code) {

		return getPersistence().fetchBysearchTravelDomesticBenefitGroupCode(
			code);
	}

	/**
	 * Returns the travel domestic benefit group where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching travel domestic benefit group, or <code>null</code> if a matching travel domestic benefit group could not be found
	 */
	public static TravelDomesticBenefitGroup
		fetchBysearchTravelDomesticBenefitGroupCode(
			String code, boolean useFinderCache) {

		return getPersistence().fetchBysearchTravelDomesticBenefitGroupCode(
			code, useFinderCache);
	}

	/**
	 * Removes the travel domestic benefit group where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the travel domestic benefit group that was removed
	 */
	public static TravelDomesticBenefitGroup
			removeBysearchTravelDomesticBenefitGroupCode(String code)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticBenefitGroupException {

		return getPersistence().removeBysearchTravelDomesticBenefitGroupCode(
			code);
	}

	/**
	 * Returns the number of travel domestic benefit groups where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching travel domestic benefit groups
	 */
	public static int countBysearchTravelDomesticBenefitGroupCode(String code) {
		return getPersistence().countBysearchTravelDomesticBenefitGroupCode(
			code);
	}

	/**
	 * Caches the travel domestic benefit group in the entity cache if it is enabled.
	 *
	 * @param travelDomesticBenefitGroup the travel domestic benefit group
	 */
	public static void cacheResult(
		TravelDomesticBenefitGroup travelDomesticBenefitGroup) {

		getPersistence().cacheResult(travelDomesticBenefitGroup);
	}

	/**
	 * Caches the travel domestic benefit groups in the entity cache if it is enabled.
	 *
	 * @param travelDomesticBenefitGroups the travel domestic benefit groups
	 */
	public static void cacheResult(
		List<TravelDomesticBenefitGroup> travelDomesticBenefitGroups) {

		getPersistence().cacheResult(travelDomesticBenefitGroups);
	}

	/**
	 * Creates a new travel domestic benefit group with the primary key. Does not add the travel domestic benefit group to the database.
	 *
	 * @param travelDomesticBenefitGroupId the primary key for the new travel domestic benefit group
	 * @return the new travel domestic benefit group
	 */
	public static TravelDomesticBenefitGroup create(
		long travelDomesticBenefitGroupId) {

		return getPersistence().create(travelDomesticBenefitGroupId);
	}

	/**
	 * Removes the travel domestic benefit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticBenefitGroupId the primary key of the travel domestic benefit group
	 * @return the travel domestic benefit group that was removed
	 * @throws NoSuchTravelDomesticBenefitGroupException if a travel domestic benefit group with the primary key could not be found
	 */
	public static TravelDomesticBenefitGroup remove(
			long travelDomesticBenefitGroupId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticBenefitGroupException {

		return getPersistence().remove(travelDomesticBenefitGroupId);
	}

	public static TravelDomesticBenefitGroup updateImpl(
		TravelDomesticBenefitGroup travelDomesticBenefitGroup) {

		return getPersistence().updateImpl(travelDomesticBenefitGroup);
	}

	/**
	 * Returns the travel domestic benefit group with the primary key or throws a <code>NoSuchTravelDomesticBenefitGroupException</code> if it could not be found.
	 *
	 * @param travelDomesticBenefitGroupId the primary key of the travel domestic benefit group
	 * @return the travel domestic benefit group
	 * @throws NoSuchTravelDomesticBenefitGroupException if a travel domestic benefit group with the primary key could not be found
	 */
	public static TravelDomesticBenefitGroup findByPrimaryKey(
			long travelDomesticBenefitGroupId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticBenefitGroupException {

		return getPersistence().findByPrimaryKey(travelDomesticBenefitGroupId);
	}

	/**
	 * Returns the travel domestic benefit group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticBenefitGroupId the primary key of the travel domestic benefit group
	 * @return the travel domestic benefit group, or <code>null</code> if a travel domestic benefit group with the primary key could not be found
	 */
	public static TravelDomesticBenefitGroup fetchByPrimaryKey(
		long travelDomesticBenefitGroupId) {

		return getPersistence().fetchByPrimaryKey(travelDomesticBenefitGroupId);
	}

	/**
	 * Returns all the travel domestic benefit groups.
	 *
	 * @return the travel domestic benefit groups
	 */
	public static List<TravelDomesticBenefitGroup> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the travel domestic benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @return the range of travel domestic benefit groups
	 */
	public static List<TravelDomesticBenefitGroup> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic benefit groups
	 */
	public static List<TravelDomesticBenefitGroup> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticBenefitGroup> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic benefit groups
	 */
	public static List<TravelDomesticBenefitGroup> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticBenefitGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the travel domestic benefit groups from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of travel domestic benefit groups.
	 *
	 * @return the number of travel domestic benefit groups
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TravelDomesticBenefitGroupPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TravelDomesticBenefitGroupPersistence _persistence;

}