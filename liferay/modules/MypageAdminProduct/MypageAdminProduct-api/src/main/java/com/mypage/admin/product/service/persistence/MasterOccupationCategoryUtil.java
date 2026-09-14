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

import com.mypage.admin.product.model.MasterOccupationCategory;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the master occupation category service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.MasterOccupationCategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterOccupationCategoryPersistence
 * @generated
 */
public class MasterOccupationCategoryUtil {

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
		MasterOccupationCategory masterOccupationCategory) {

		getPersistence().clearCache(masterOccupationCategory);
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
	public static Map<Serializable, MasterOccupationCategory>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MasterOccupationCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MasterOccupationCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MasterOccupationCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MasterOccupationCategory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MasterOccupationCategory update(
		MasterOccupationCategory masterOccupationCategory) {

		return getPersistence().update(masterOccupationCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MasterOccupationCategory update(
		MasterOccupationCategory masterOccupationCategory,
		ServiceContext serviceContext) {

		return getPersistence().update(
			masterOccupationCategory, serviceContext);
	}

	/**
	 * Returns all the master occupation categories where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching master occupation categories
	 */
	public static List<MasterOccupationCategory> findBysearchByActive(
		Integer active) {

		return getPersistence().findBysearchByActive(active);
	}

	/**
	 * Returns a range of all the master occupation categories where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @return the range of matching master occupation categories
	 */
	public static List<MasterOccupationCategory> findBysearchByActive(
		Integer active, int start, int end) {

		return getPersistence().findBysearchByActive(active, start, end);
	}

	/**
	 * Returns an ordered range of all the master occupation categories where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master occupation categories
	 */
	public static List<MasterOccupationCategory> findBysearchByActive(
		Integer active, int start, int end,
		OrderByComparator<MasterOccupationCategory> orderByComparator) {

		return getPersistence().findBysearchByActive(
			active, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master occupation categories where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master occupation categories
	 */
	public static List<MasterOccupationCategory> findBysearchByActive(
		Integer active, int start, int end,
		OrderByComparator<MasterOccupationCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchByActive(
			active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first master occupation category in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation category
	 * @throws NoSuchMasterOccupationCategoryException if a matching master occupation category could not be found
	 */
	public static MasterOccupationCategory findBysearchByActive_First(
			Integer active,
			OrderByComparator<MasterOccupationCategory> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationCategoryException {

		return getPersistence().findBysearchByActive_First(
			active, orderByComparator);
	}

	/**
	 * Returns the first master occupation category in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation category, or <code>null</code> if a matching master occupation category could not be found
	 */
	public static MasterOccupationCategory fetchBysearchByActive_First(
		Integer active,
		OrderByComparator<MasterOccupationCategory> orderByComparator) {

		return getPersistence().fetchBysearchByActive_First(
			active, orderByComparator);
	}

	/**
	 * Returns the last master occupation category in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation category
	 * @throws NoSuchMasterOccupationCategoryException if a matching master occupation category could not be found
	 */
	public static MasterOccupationCategory findBysearchByActive_Last(
			Integer active,
			OrderByComparator<MasterOccupationCategory> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationCategoryException {

		return getPersistence().findBysearchByActive_Last(
			active, orderByComparator);
	}

	/**
	 * Returns the last master occupation category in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation category, or <code>null</code> if a matching master occupation category could not be found
	 */
	public static MasterOccupationCategory fetchBysearchByActive_Last(
		Integer active,
		OrderByComparator<MasterOccupationCategory> orderByComparator) {

		return getPersistence().fetchBysearchByActive_Last(
			active, orderByComparator);
	}

	/**
	 * Returns the master occupation categories before and after the current master occupation category in the ordered set where active = &#63;.
	 *
	 * @param masterOccupationCategoryId the primary key of the current master occupation category
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master occupation category
	 * @throws NoSuchMasterOccupationCategoryException if a master occupation category with the primary key could not be found
	 */
	public static MasterOccupationCategory[] findBysearchByActive_PrevAndNext(
			long masterOccupationCategoryId, Integer active,
			OrderByComparator<MasterOccupationCategory> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationCategoryException {

		return getPersistence().findBysearchByActive_PrevAndNext(
			masterOccupationCategoryId, active, orderByComparator);
	}

	/**
	 * Removes all the master occupation categories where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public static void removeBysearchByActive(Integer active) {
		getPersistence().removeBysearchByActive(active);
	}

	/**
	 * Returns the number of master occupation categories where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching master occupation categories
	 */
	public static int countBysearchByActive(Integer active) {
		return getPersistence().countBysearchByActive(active);
	}

	/**
	 * Returns the master occupation category where name = &#63; or throws a <code>NoSuchMasterOccupationCategoryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching master occupation category
	 * @throws NoSuchMasterOccupationCategoryException if a matching master occupation category could not be found
	 */
	public static MasterOccupationCategory findBysearchName(String name)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationCategoryException {

		return getPersistence().findBysearchName(name);
	}

	/**
	 * Returns the master occupation category where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching master occupation category, or <code>null</code> if a matching master occupation category could not be found
	 */
	public static MasterOccupationCategory fetchBysearchName(String name) {
		return getPersistence().fetchBysearchName(name);
	}

	/**
	 * Returns the master occupation category where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching master occupation category, or <code>null</code> if a matching master occupation category could not be found
	 */
	public static MasterOccupationCategory fetchBysearchName(
		String name, boolean useFinderCache) {

		return getPersistence().fetchBysearchName(name, useFinderCache);
	}

	/**
	 * Removes the master occupation category where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the master occupation category that was removed
	 */
	public static MasterOccupationCategory removeBysearchName(String name)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationCategoryException {

		return getPersistence().removeBysearchName(name);
	}

	/**
	 * Returns the number of master occupation categories where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching master occupation categories
	 */
	public static int countBysearchName(String name) {
		return getPersistence().countBysearchName(name);
	}

	/**
	 * Caches the master occupation category in the entity cache if it is enabled.
	 *
	 * @param masterOccupationCategory the master occupation category
	 */
	public static void cacheResult(
		MasterOccupationCategory masterOccupationCategory) {

		getPersistence().cacheResult(masterOccupationCategory);
	}

	/**
	 * Caches the master occupation categories in the entity cache if it is enabled.
	 *
	 * @param masterOccupationCategories the master occupation categories
	 */
	public static void cacheResult(
		List<MasterOccupationCategory> masterOccupationCategories) {

		getPersistence().cacheResult(masterOccupationCategories);
	}

	/**
	 * Creates a new master occupation category with the primary key. Does not add the master occupation category to the database.
	 *
	 * @param masterOccupationCategoryId the primary key for the new master occupation category
	 * @return the new master occupation category
	 */
	public static MasterOccupationCategory create(
		long masterOccupationCategoryId) {

		return getPersistence().create(masterOccupationCategoryId);
	}

	/**
	 * Removes the master occupation category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterOccupationCategoryId the primary key of the master occupation category
	 * @return the master occupation category that was removed
	 * @throws NoSuchMasterOccupationCategoryException if a master occupation category with the primary key could not be found
	 */
	public static MasterOccupationCategory remove(
			long masterOccupationCategoryId)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationCategoryException {

		return getPersistence().remove(masterOccupationCategoryId);
	}

	public static MasterOccupationCategory updateImpl(
		MasterOccupationCategory masterOccupationCategory) {

		return getPersistence().updateImpl(masterOccupationCategory);
	}

	/**
	 * Returns the master occupation category with the primary key or throws a <code>NoSuchMasterOccupationCategoryException</code> if it could not be found.
	 *
	 * @param masterOccupationCategoryId the primary key of the master occupation category
	 * @return the master occupation category
	 * @throws NoSuchMasterOccupationCategoryException if a master occupation category with the primary key could not be found
	 */
	public static MasterOccupationCategory findByPrimaryKey(
			long masterOccupationCategoryId)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationCategoryException {

		return getPersistence().findByPrimaryKey(masterOccupationCategoryId);
	}

	/**
	 * Returns the master occupation category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterOccupationCategoryId the primary key of the master occupation category
	 * @return the master occupation category, or <code>null</code> if a master occupation category with the primary key could not be found
	 */
	public static MasterOccupationCategory fetchByPrimaryKey(
		long masterOccupationCategoryId) {

		return getPersistence().fetchByPrimaryKey(masterOccupationCategoryId);
	}

	/**
	 * Returns all the master occupation categories.
	 *
	 * @return the master occupation categories
	 */
	public static List<MasterOccupationCategory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the master occupation categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @return the range of master occupation categories
	 */
	public static List<MasterOccupationCategory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the master occupation categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master occupation categories
	 */
	public static List<MasterOccupationCategory> findAll(
		int start, int end,
		OrderByComparator<MasterOccupationCategory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master occupation categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master occupation categories
	 */
	public static List<MasterOccupationCategory> findAll(
		int start, int end,
		OrderByComparator<MasterOccupationCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the master occupation categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of master occupation categories.
	 *
	 * @return the number of master occupation categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MasterOccupationCategoryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MasterOccupationCategoryPersistence _persistence;

}