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

import com.mypage.admin.product.model.MasterBranch;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the master branch service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.MasterBranchPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterBranchPersistence
 * @generated
 */
public class MasterBranchUtil {

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
	public static void clearCache(MasterBranch masterBranch) {
		getPersistence().clearCache(masterBranch);
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
	public static Map<Serializable, MasterBranch> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MasterBranch> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MasterBranch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MasterBranch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MasterBranch> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MasterBranch update(MasterBranch masterBranch) {
		return getPersistence().update(masterBranch);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MasterBranch update(
		MasterBranch masterBranch, ServiceContext serviceContext) {

		return getPersistence().update(masterBranch, serviceContext);
	}

	/**
	 * Returns all the master branches where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching master branches
	 */
	public static List<MasterBranch> findBysearchByName(String name) {
		return getPersistence().findBysearchByName(name);
	}

	/**
	 * Returns a range of all the master branches where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @return the range of matching master branches
	 */
	public static List<MasterBranch> findBysearchByName(
		String name, int start, int end) {

		return getPersistence().findBysearchByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the master branches where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master branches
	 */
	public static List<MasterBranch> findBysearchByName(
		String name, int start, int end,
		OrderByComparator<MasterBranch> orderByComparator) {

		return getPersistence().findBysearchByName(
			name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master branches where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master branches
	 */
	public static List<MasterBranch> findBysearchByName(
		String name, int start, int end,
		OrderByComparator<MasterBranch> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first master branch in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master branch
	 * @throws NoSuchMasterBranchException if a matching master branch could not be found
	 */
	public static MasterBranch findBysearchByName_First(
			String name, OrderByComparator<MasterBranch> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterBranchException {

		return getPersistence().findBysearchByName_First(
			name, orderByComparator);
	}

	/**
	 * Returns the first master branch in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master branch, or <code>null</code> if a matching master branch could not be found
	 */
	public static MasterBranch fetchBysearchByName_First(
		String name, OrderByComparator<MasterBranch> orderByComparator) {

		return getPersistence().fetchBysearchByName_First(
			name, orderByComparator);
	}

	/**
	 * Returns the last master branch in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master branch
	 * @throws NoSuchMasterBranchException if a matching master branch could not be found
	 */
	public static MasterBranch findBysearchByName_Last(
			String name, OrderByComparator<MasterBranch> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterBranchException {

		return getPersistence().findBysearchByName_Last(
			name, orderByComparator);
	}

	/**
	 * Returns the last master branch in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master branch, or <code>null</code> if a matching master branch could not be found
	 */
	public static MasterBranch fetchBysearchByName_Last(
		String name, OrderByComparator<MasterBranch> orderByComparator) {

		return getPersistence().fetchBysearchByName_Last(
			name, orderByComparator);
	}

	/**
	 * Returns the master branches before and after the current master branch in the ordered set where name = &#63;.
	 *
	 * @param masterBranchId the primary key of the current master branch
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master branch
	 * @throws NoSuchMasterBranchException if a master branch with the primary key could not be found
	 */
	public static MasterBranch[] findBysearchByName_PrevAndNext(
			long masterBranchId, String name,
			OrderByComparator<MasterBranch> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterBranchException {

		return getPersistence().findBysearchByName_PrevAndNext(
			masterBranchId, name, orderByComparator);
	}

	/**
	 * Removes all the master branches where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeBysearchByName(String name) {
		getPersistence().removeBysearchByName(name);
	}

	/**
	 * Returns the number of master branches where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching master branches
	 */
	public static int countBysearchByName(String name) {
		return getPersistence().countBysearchByName(name);
	}

	/**
	 * Caches the master branch in the entity cache if it is enabled.
	 *
	 * @param masterBranch the master branch
	 */
	public static void cacheResult(MasterBranch masterBranch) {
		getPersistence().cacheResult(masterBranch);
	}

	/**
	 * Caches the master branches in the entity cache if it is enabled.
	 *
	 * @param masterBranches the master branches
	 */
	public static void cacheResult(List<MasterBranch> masterBranches) {
		getPersistence().cacheResult(masterBranches);
	}

	/**
	 * Creates a new master branch with the primary key. Does not add the master branch to the database.
	 *
	 * @param masterBranchId the primary key for the new master branch
	 * @return the new master branch
	 */
	public static MasterBranch create(long masterBranchId) {
		return getPersistence().create(masterBranchId);
	}

	/**
	 * Removes the master branch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterBranchId the primary key of the master branch
	 * @return the master branch that was removed
	 * @throws NoSuchMasterBranchException if a master branch with the primary key could not be found
	 */
	public static MasterBranch remove(long masterBranchId)
		throws com.mypage.admin.product.exception.NoSuchMasterBranchException {

		return getPersistence().remove(masterBranchId);
	}

	public static MasterBranch updateImpl(MasterBranch masterBranch) {
		return getPersistence().updateImpl(masterBranch);
	}

	/**
	 * Returns the master branch with the primary key or throws a <code>NoSuchMasterBranchException</code> if it could not be found.
	 *
	 * @param masterBranchId the primary key of the master branch
	 * @return the master branch
	 * @throws NoSuchMasterBranchException if a master branch with the primary key could not be found
	 */
	public static MasterBranch findByPrimaryKey(long masterBranchId)
		throws com.mypage.admin.product.exception.NoSuchMasterBranchException {

		return getPersistence().findByPrimaryKey(masterBranchId);
	}

	/**
	 * Returns the master branch with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterBranchId the primary key of the master branch
	 * @return the master branch, or <code>null</code> if a master branch with the primary key could not be found
	 */
	public static MasterBranch fetchByPrimaryKey(long masterBranchId) {
		return getPersistence().fetchByPrimaryKey(masterBranchId);
	}

	/**
	 * Returns all the master branches.
	 *
	 * @return the master branches
	 */
	public static List<MasterBranch> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the master branches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @return the range of master branches
	 */
	public static List<MasterBranch> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the master branches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master branches
	 */
	public static List<MasterBranch> findAll(
		int start, int end, OrderByComparator<MasterBranch> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master branches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master branches
	 */
	public static List<MasterBranch> findAll(
		int start, int end, OrderByComparator<MasterBranch> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the master branches from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of master branches.
	 *
	 * @return the number of master branches
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MasterBranchPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MasterBranchPersistence _persistence;

}