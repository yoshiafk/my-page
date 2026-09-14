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

import com.mypage.admin.product.model.MasterProvince;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the master province service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.MasterProvincePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterProvincePersistence
 * @generated
 */
public class MasterProvinceUtil {

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
	public static void clearCache(MasterProvince masterProvince) {
		getPersistence().clearCache(masterProvince);
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
	public static Map<Serializable, MasterProvince> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MasterProvince> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MasterProvince> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MasterProvince> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MasterProvince> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MasterProvince update(MasterProvince masterProvince) {
		return getPersistence().update(masterProvince);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MasterProvince update(
		MasterProvince masterProvince, ServiceContext serviceContext) {

		return getPersistence().update(masterProvince, serviceContext);
	}

	/**
	 * Returns all the master provinces where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching master provinces
	 */
	public static List<MasterProvince> findByactiveProvinces(Integer active) {
		return getPersistence().findByactiveProvinces(active);
	}

	/**
	 * Returns a range of all the master provinces where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @return the range of matching master provinces
	 */
	public static List<MasterProvince> findByactiveProvinces(
		Integer active, int start, int end) {

		return getPersistence().findByactiveProvinces(active, start, end);
	}

	/**
	 * Returns an ordered range of all the master provinces where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master provinces
	 */
	public static List<MasterProvince> findByactiveProvinces(
		Integer active, int start, int end,
		OrderByComparator<MasterProvince> orderByComparator) {

		return getPersistence().findByactiveProvinces(
			active, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master provinces where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master provinces
	 */
	public static List<MasterProvince> findByactiveProvinces(
		Integer active, int start, int end,
		OrderByComparator<MasterProvince> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByactiveProvinces(
			active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first master province in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master province
	 * @throws NoSuchMasterProvinceException if a matching master province could not be found
	 */
	public static MasterProvince findByactiveProvinces_First(
			Integer active, OrderByComparator<MasterProvince> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterProvinceException {

		return getPersistence().findByactiveProvinces_First(
			active, orderByComparator);
	}

	/**
	 * Returns the first master province in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master province, or <code>null</code> if a matching master province could not be found
	 */
	public static MasterProvince fetchByactiveProvinces_First(
		Integer active, OrderByComparator<MasterProvince> orderByComparator) {

		return getPersistence().fetchByactiveProvinces_First(
			active, orderByComparator);
	}

	/**
	 * Returns the last master province in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master province
	 * @throws NoSuchMasterProvinceException if a matching master province could not be found
	 */
	public static MasterProvince findByactiveProvinces_Last(
			Integer active, OrderByComparator<MasterProvince> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterProvinceException {

		return getPersistence().findByactiveProvinces_Last(
			active, orderByComparator);
	}

	/**
	 * Returns the last master province in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master province, or <code>null</code> if a matching master province could not be found
	 */
	public static MasterProvince fetchByactiveProvinces_Last(
		Integer active, OrderByComparator<MasterProvince> orderByComparator) {

		return getPersistence().fetchByactiveProvinces_Last(
			active, orderByComparator);
	}

	/**
	 * Returns the master provinces before and after the current master province in the ordered set where active = &#63;.
	 *
	 * @param masterProvinceId the primary key of the current master province
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master province
	 * @throws NoSuchMasterProvinceException if a master province with the primary key could not be found
	 */
	public static MasterProvince[] findByactiveProvinces_PrevAndNext(
			long masterProvinceId, Integer active,
			OrderByComparator<MasterProvince> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterProvinceException {

		return getPersistence().findByactiveProvinces_PrevAndNext(
			masterProvinceId, active, orderByComparator);
	}

	/**
	 * Removes all the master provinces where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public static void removeByactiveProvinces(Integer active) {
		getPersistence().removeByactiveProvinces(active);
	}

	/**
	 * Returns the number of master provinces where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching master provinces
	 */
	public static int countByactiveProvinces(Integer active) {
		return getPersistence().countByactiveProvinces(active);
	}

	/**
	 * Caches the master province in the entity cache if it is enabled.
	 *
	 * @param masterProvince the master province
	 */
	public static void cacheResult(MasterProvince masterProvince) {
		getPersistence().cacheResult(masterProvince);
	}

	/**
	 * Caches the master provinces in the entity cache if it is enabled.
	 *
	 * @param masterProvinces the master provinces
	 */
	public static void cacheResult(List<MasterProvince> masterProvinces) {
		getPersistence().cacheResult(masterProvinces);
	}

	/**
	 * Creates a new master province with the primary key. Does not add the master province to the database.
	 *
	 * @param masterProvinceId the primary key for the new master province
	 * @return the new master province
	 */
	public static MasterProvince create(long masterProvinceId) {
		return getPersistence().create(masterProvinceId);
	}

	/**
	 * Removes the master province with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterProvinceId the primary key of the master province
	 * @return the master province that was removed
	 * @throws NoSuchMasterProvinceException if a master province with the primary key could not be found
	 */
	public static MasterProvince remove(long masterProvinceId)
		throws com.mypage.admin.product.exception.
			NoSuchMasterProvinceException {

		return getPersistence().remove(masterProvinceId);
	}

	public static MasterProvince updateImpl(MasterProvince masterProvince) {
		return getPersistence().updateImpl(masterProvince);
	}

	/**
	 * Returns the master province with the primary key or throws a <code>NoSuchMasterProvinceException</code> if it could not be found.
	 *
	 * @param masterProvinceId the primary key of the master province
	 * @return the master province
	 * @throws NoSuchMasterProvinceException if a master province with the primary key could not be found
	 */
	public static MasterProvince findByPrimaryKey(long masterProvinceId)
		throws com.mypage.admin.product.exception.
			NoSuchMasterProvinceException {

		return getPersistence().findByPrimaryKey(masterProvinceId);
	}

	/**
	 * Returns the master province with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterProvinceId the primary key of the master province
	 * @return the master province, or <code>null</code> if a master province with the primary key could not be found
	 */
	public static MasterProvince fetchByPrimaryKey(long masterProvinceId) {
		return getPersistence().fetchByPrimaryKey(masterProvinceId);
	}

	/**
	 * Returns all the master provinces.
	 *
	 * @return the master provinces
	 */
	public static List<MasterProvince> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the master provinces.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @return the range of master provinces
	 */
	public static List<MasterProvince> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the master provinces.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master provinces
	 */
	public static List<MasterProvince> findAll(
		int start, int end,
		OrderByComparator<MasterProvince> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master provinces.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master provinces
	 */
	public static List<MasterProvince> findAll(
		int start, int end, OrderByComparator<MasterProvince> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the master provinces from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of master provinces.
	 *
	 * @return the number of master provinces
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MasterProvincePersistence getPersistence() {
		return _persistence;
	}

	private static volatile MasterProvincePersistence _persistence;

}