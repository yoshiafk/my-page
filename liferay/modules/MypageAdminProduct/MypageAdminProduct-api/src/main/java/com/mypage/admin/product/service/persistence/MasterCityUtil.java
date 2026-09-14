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

import com.mypage.admin.product.model.MasterCity;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the master city service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.MasterCityPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterCityPersistence
 * @generated
 */
public class MasterCityUtil {

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
	public static void clearCache(MasterCity masterCity) {
		getPersistence().clearCache(masterCity);
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
	public static Map<Serializable, MasterCity> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MasterCity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MasterCity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MasterCity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MasterCity> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MasterCity update(MasterCity masterCity) {
		return getPersistence().update(masterCity);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MasterCity update(
		MasterCity masterCity, ServiceContext serviceContext) {

		return getPersistence().update(masterCity, serviceContext);
	}

	/**
	 * Returns all the master cities where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching master cities
	 */
	public static List<MasterCity> findByactiveCities(Integer active) {
		return getPersistence().findByactiveCities(active);
	}

	/**
	 * Returns a range of all the master cities where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @return the range of matching master cities
	 */
	public static List<MasterCity> findByactiveCities(
		Integer active, int start, int end) {

		return getPersistence().findByactiveCities(active, start, end);
	}

	/**
	 * Returns an ordered range of all the master cities where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master cities
	 */
	public static List<MasterCity> findByactiveCities(
		Integer active, int start, int end,
		OrderByComparator<MasterCity> orderByComparator) {

		return getPersistence().findByactiveCities(
			active, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master cities where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master cities
	 */
	public static List<MasterCity> findByactiveCities(
		Integer active, int start, int end,
		OrderByComparator<MasterCity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByactiveCities(
			active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first master city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master city
	 * @throws NoSuchMasterCityException if a matching master city could not be found
	 */
	public static MasterCity findByactiveCities_First(
			Integer active, OrderByComparator<MasterCity> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterCityException {

		return getPersistence().findByactiveCities_First(
			active, orderByComparator);
	}

	/**
	 * Returns the first master city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master city, or <code>null</code> if a matching master city could not be found
	 */
	public static MasterCity fetchByactiveCities_First(
		Integer active, OrderByComparator<MasterCity> orderByComparator) {

		return getPersistence().fetchByactiveCities_First(
			active, orderByComparator);
	}

	/**
	 * Returns the last master city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master city
	 * @throws NoSuchMasterCityException if a matching master city could not be found
	 */
	public static MasterCity findByactiveCities_Last(
			Integer active, OrderByComparator<MasterCity> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterCityException {

		return getPersistence().findByactiveCities_Last(
			active, orderByComparator);
	}

	/**
	 * Returns the last master city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master city, or <code>null</code> if a matching master city could not be found
	 */
	public static MasterCity fetchByactiveCities_Last(
		Integer active, OrderByComparator<MasterCity> orderByComparator) {

		return getPersistence().fetchByactiveCities_Last(
			active, orderByComparator);
	}

	/**
	 * Returns the master cities before and after the current master city in the ordered set where active = &#63;.
	 *
	 * @param masterCityId the primary key of the current master city
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master city
	 * @throws NoSuchMasterCityException if a master city with the primary key could not be found
	 */
	public static MasterCity[] findByactiveCities_PrevAndNext(
			long masterCityId, Integer active,
			OrderByComparator<MasterCity> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterCityException {

		return getPersistence().findByactiveCities_PrevAndNext(
			masterCityId, active, orderByComparator);
	}

	/**
	 * Removes all the master cities where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public static void removeByactiveCities(Integer active) {
		getPersistence().removeByactiveCities(active);
	}

	/**
	 * Returns the number of master cities where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching master cities
	 */
	public static int countByactiveCities(Integer active) {
		return getPersistence().countByactiveCities(active);
	}

	/**
	 * Returns all the master cities where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @return the matching master cities
	 */
	public static List<MasterCity> findBysearchByProvinceId(long provinceId) {
		return getPersistence().findBysearchByProvinceId(provinceId);
	}

	/**
	 * Returns a range of all the master cities where provinceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param provinceId the province ID
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @return the range of matching master cities
	 */
	public static List<MasterCity> findBysearchByProvinceId(
		long provinceId, int start, int end) {

		return getPersistence().findBysearchByProvinceId(
			provinceId, start, end);
	}

	/**
	 * Returns an ordered range of all the master cities where provinceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param provinceId the province ID
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master cities
	 */
	public static List<MasterCity> findBysearchByProvinceId(
		long provinceId, int start, int end,
		OrderByComparator<MasterCity> orderByComparator) {

		return getPersistence().findBysearchByProvinceId(
			provinceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master cities where provinceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param provinceId the province ID
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master cities
	 */
	public static List<MasterCity> findBysearchByProvinceId(
		long provinceId, int start, int end,
		OrderByComparator<MasterCity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchByProvinceId(
			provinceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first master city in the ordered set where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master city
	 * @throws NoSuchMasterCityException if a matching master city could not be found
	 */
	public static MasterCity findBysearchByProvinceId_First(
			long provinceId, OrderByComparator<MasterCity> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterCityException {

		return getPersistence().findBysearchByProvinceId_First(
			provinceId, orderByComparator);
	}

	/**
	 * Returns the first master city in the ordered set where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master city, or <code>null</code> if a matching master city could not be found
	 */
	public static MasterCity fetchBysearchByProvinceId_First(
		long provinceId, OrderByComparator<MasterCity> orderByComparator) {

		return getPersistence().fetchBysearchByProvinceId_First(
			provinceId, orderByComparator);
	}

	/**
	 * Returns the last master city in the ordered set where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master city
	 * @throws NoSuchMasterCityException if a matching master city could not be found
	 */
	public static MasterCity findBysearchByProvinceId_Last(
			long provinceId, OrderByComparator<MasterCity> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterCityException {

		return getPersistence().findBysearchByProvinceId_Last(
			provinceId, orderByComparator);
	}

	/**
	 * Returns the last master city in the ordered set where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master city, or <code>null</code> if a matching master city could not be found
	 */
	public static MasterCity fetchBysearchByProvinceId_Last(
		long provinceId, OrderByComparator<MasterCity> orderByComparator) {

		return getPersistence().fetchBysearchByProvinceId_Last(
			provinceId, orderByComparator);
	}

	/**
	 * Returns the master cities before and after the current master city in the ordered set where provinceId = &#63;.
	 *
	 * @param masterCityId the primary key of the current master city
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master city
	 * @throws NoSuchMasterCityException if a master city with the primary key could not be found
	 */
	public static MasterCity[] findBysearchByProvinceId_PrevAndNext(
			long masterCityId, long provinceId,
			OrderByComparator<MasterCity> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterCityException {

		return getPersistence().findBysearchByProvinceId_PrevAndNext(
			masterCityId, provinceId, orderByComparator);
	}

	/**
	 * Removes all the master cities where provinceId = &#63; from the database.
	 *
	 * @param provinceId the province ID
	 */
	public static void removeBysearchByProvinceId(long provinceId) {
		getPersistence().removeBysearchByProvinceId(provinceId);
	}

	/**
	 * Returns the number of master cities where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @return the number of matching master cities
	 */
	public static int countBysearchByProvinceId(long provinceId) {
		return getPersistence().countBysearchByProvinceId(provinceId);
	}

	/**
	 * Caches the master city in the entity cache if it is enabled.
	 *
	 * @param masterCity the master city
	 */
	public static void cacheResult(MasterCity masterCity) {
		getPersistence().cacheResult(masterCity);
	}

	/**
	 * Caches the master cities in the entity cache if it is enabled.
	 *
	 * @param masterCities the master cities
	 */
	public static void cacheResult(List<MasterCity> masterCities) {
		getPersistence().cacheResult(masterCities);
	}

	/**
	 * Creates a new master city with the primary key. Does not add the master city to the database.
	 *
	 * @param masterCityId the primary key for the new master city
	 * @return the new master city
	 */
	public static MasterCity create(long masterCityId) {
		return getPersistence().create(masterCityId);
	}

	/**
	 * Removes the master city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterCityId the primary key of the master city
	 * @return the master city that was removed
	 * @throws NoSuchMasterCityException if a master city with the primary key could not be found
	 */
	public static MasterCity remove(long masterCityId)
		throws com.mypage.admin.product.exception.NoSuchMasterCityException {

		return getPersistence().remove(masterCityId);
	}

	public static MasterCity updateImpl(MasterCity masterCity) {
		return getPersistence().updateImpl(masterCity);
	}

	/**
	 * Returns the master city with the primary key or throws a <code>NoSuchMasterCityException</code> if it could not be found.
	 *
	 * @param masterCityId the primary key of the master city
	 * @return the master city
	 * @throws NoSuchMasterCityException if a master city with the primary key could not be found
	 */
	public static MasterCity findByPrimaryKey(long masterCityId)
		throws com.mypage.admin.product.exception.NoSuchMasterCityException {

		return getPersistence().findByPrimaryKey(masterCityId);
	}

	/**
	 * Returns the master city with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterCityId the primary key of the master city
	 * @return the master city, or <code>null</code> if a master city with the primary key could not be found
	 */
	public static MasterCity fetchByPrimaryKey(long masterCityId) {
		return getPersistence().fetchByPrimaryKey(masterCityId);
	}

	/**
	 * Returns all the master cities.
	 *
	 * @return the master cities
	 */
	public static List<MasterCity> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the master cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @return the range of master cities
	 */
	public static List<MasterCity> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the master cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master cities
	 */
	public static List<MasterCity> findAll(
		int start, int end, OrderByComparator<MasterCity> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master cities
	 */
	public static List<MasterCity> findAll(
		int start, int end, OrderByComparator<MasterCity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the master cities from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of master cities.
	 *
	 * @return the number of master cities
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MasterCityPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MasterCityPersistence _persistence;

}