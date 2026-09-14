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

import com.mypage.admin.product.model.MasterCountry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the master country service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.MasterCountryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterCountryPersistence
 * @generated
 */
public class MasterCountryUtil {

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
	public static void clearCache(MasterCountry masterCountry) {
		getPersistence().clearCache(masterCountry);
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
	public static Map<Serializable, MasterCountry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MasterCountry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MasterCountry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MasterCountry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MasterCountry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MasterCountry update(MasterCountry masterCountry) {
		return getPersistence().update(masterCountry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MasterCountry update(
		MasterCountry masterCountry, ServiceContext serviceContext) {

		return getPersistence().update(masterCountry, serviceContext);
	}

	/**
	 * Returns all the master countries where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching master countries
	 */
	public static List<MasterCountry> findBycountryName(String name) {
		return getPersistence().findBycountryName(name);
	}

	/**
	 * Returns a range of all the master countries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @return the range of matching master countries
	 */
	public static List<MasterCountry> findBycountryName(
		String name, int start, int end) {

		return getPersistence().findBycountryName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the master countries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master countries
	 */
	public static List<MasterCountry> findBycountryName(
		String name, int start, int end,
		OrderByComparator<MasterCountry> orderByComparator) {

		return getPersistence().findBycountryName(
			name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master countries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master countries
	 */
	public static List<MasterCountry> findBycountryName(
		String name, int start, int end,
		OrderByComparator<MasterCountry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBycountryName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first master country in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master country
	 * @throws NoSuchMasterCountryException if a matching master country could not be found
	 */
	public static MasterCountry findBycountryName_First(
			String name, OrderByComparator<MasterCountry> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterCountryException {

		return getPersistence().findBycountryName_First(
			name, orderByComparator);
	}

	/**
	 * Returns the first master country in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master country, or <code>null</code> if a matching master country could not be found
	 */
	public static MasterCountry fetchBycountryName_First(
		String name, OrderByComparator<MasterCountry> orderByComparator) {

		return getPersistence().fetchBycountryName_First(
			name, orderByComparator);
	}

	/**
	 * Returns the last master country in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master country
	 * @throws NoSuchMasterCountryException if a matching master country could not be found
	 */
	public static MasterCountry findBycountryName_Last(
			String name, OrderByComparator<MasterCountry> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterCountryException {

		return getPersistence().findBycountryName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last master country in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master country, or <code>null</code> if a matching master country could not be found
	 */
	public static MasterCountry fetchBycountryName_Last(
		String name, OrderByComparator<MasterCountry> orderByComparator) {

		return getPersistence().fetchBycountryName_Last(
			name, orderByComparator);
	}

	/**
	 * Returns the master countries before and after the current master country in the ordered set where name = &#63;.
	 *
	 * @param countryId the primary key of the current master country
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master country
	 * @throws NoSuchMasterCountryException if a master country with the primary key could not be found
	 */
	public static MasterCountry[] findBycountryName_PrevAndNext(
			long countryId, String name,
			OrderByComparator<MasterCountry> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterCountryException {

		return getPersistence().findBycountryName_PrevAndNext(
			countryId, name, orderByComparator);
	}

	/**
	 * Removes all the master countries where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeBycountryName(String name) {
		getPersistence().removeBycountryName(name);
	}

	/**
	 * Returns the number of master countries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching master countries
	 */
	public static int countBycountryName(String name) {
		return getPersistence().countBycountryName(name);
	}

	/**
	 * Returns all the master countries where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @return the matching master countries
	 */
	public static List<MasterCountry> findByactiveCountries(
		Integer isSanctionCountry, Integer active) {

		return getPersistence().findByactiveCountries(
			isSanctionCountry, active);
	}

	/**
	 * Returns a range of all the master countries where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @return the range of matching master countries
	 */
	public static List<MasterCountry> findByactiveCountries(
		Integer isSanctionCountry, Integer active, int start, int end) {

		return getPersistence().findByactiveCountries(
			isSanctionCountry, active, start, end);
	}

	/**
	 * Returns an ordered range of all the master countries where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master countries
	 */
	public static List<MasterCountry> findByactiveCountries(
		Integer isSanctionCountry, Integer active, int start, int end,
		OrderByComparator<MasterCountry> orderByComparator) {

		return getPersistence().findByactiveCountries(
			isSanctionCountry, active, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master countries where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master countries
	 */
	public static List<MasterCountry> findByactiveCountries(
		Integer isSanctionCountry, Integer active, int start, int end,
		OrderByComparator<MasterCountry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByactiveCountries(
			isSanctionCountry, active, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first master country in the ordered set where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master country
	 * @throws NoSuchMasterCountryException if a matching master country could not be found
	 */
	public static MasterCountry findByactiveCountries_First(
			Integer isSanctionCountry, Integer active,
			OrderByComparator<MasterCountry> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterCountryException {

		return getPersistence().findByactiveCountries_First(
			isSanctionCountry, active, orderByComparator);
	}

	/**
	 * Returns the first master country in the ordered set where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master country, or <code>null</code> if a matching master country could not be found
	 */
	public static MasterCountry fetchByactiveCountries_First(
		Integer isSanctionCountry, Integer active,
		OrderByComparator<MasterCountry> orderByComparator) {

		return getPersistence().fetchByactiveCountries_First(
			isSanctionCountry, active, orderByComparator);
	}

	/**
	 * Returns the last master country in the ordered set where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master country
	 * @throws NoSuchMasterCountryException if a matching master country could not be found
	 */
	public static MasterCountry findByactiveCountries_Last(
			Integer isSanctionCountry, Integer active,
			OrderByComparator<MasterCountry> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterCountryException {

		return getPersistence().findByactiveCountries_Last(
			isSanctionCountry, active, orderByComparator);
	}

	/**
	 * Returns the last master country in the ordered set where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master country, or <code>null</code> if a matching master country could not be found
	 */
	public static MasterCountry fetchByactiveCountries_Last(
		Integer isSanctionCountry, Integer active,
		OrderByComparator<MasterCountry> orderByComparator) {

		return getPersistence().fetchByactiveCountries_Last(
			isSanctionCountry, active, orderByComparator);
	}

	/**
	 * Returns the master countries before and after the current master country in the ordered set where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param countryId the primary key of the current master country
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master country
	 * @throws NoSuchMasterCountryException if a master country with the primary key could not be found
	 */
	public static MasterCountry[] findByactiveCountries_PrevAndNext(
			long countryId, Integer isSanctionCountry, Integer active,
			OrderByComparator<MasterCountry> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterCountryException {

		return getPersistence().findByactiveCountries_PrevAndNext(
			countryId, isSanctionCountry, active, orderByComparator);
	}

	/**
	 * Removes all the master countries where isSanctionCountry = &#63; and active = &#63; from the database.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 */
	public static void removeByactiveCountries(
		Integer isSanctionCountry, Integer active) {

		getPersistence().removeByactiveCountries(isSanctionCountry, active);
	}

	/**
	 * Returns the number of master countries where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @return the number of matching master countries
	 */
	public static int countByactiveCountries(
		Integer isSanctionCountry, Integer active) {

		return getPersistence().countByactiveCountries(
			isSanctionCountry, active);
	}

	/**
	 * Caches the master country in the entity cache if it is enabled.
	 *
	 * @param masterCountry the master country
	 */
	public static void cacheResult(MasterCountry masterCountry) {
		getPersistence().cacheResult(masterCountry);
	}

	/**
	 * Caches the master countries in the entity cache if it is enabled.
	 *
	 * @param masterCountries the master countries
	 */
	public static void cacheResult(List<MasterCountry> masterCountries) {
		getPersistence().cacheResult(masterCountries);
	}

	/**
	 * Creates a new master country with the primary key. Does not add the master country to the database.
	 *
	 * @param countryId the primary key for the new master country
	 * @return the new master country
	 */
	public static MasterCountry create(long countryId) {
		return getPersistence().create(countryId);
	}

	/**
	 * Removes the master country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param countryId the primary key of the master country
	 * @return the master country that was removed
	 * @throws NoSuchMasterCountryException if a master country with the primary key could not be found
	 */
	public static MasterCountry remove(long countryId)
		throws com.mypage.admin.product.exception.NoSuchMasterCountryException {

		return getPersistence().remove(countryId);
	}

	public static MasterCountry updateImpl(MasterCountry masterCountry) {
		return getPersistence().updateImpl(masterCountry);
	}

	/**
	 * Returns the master country with the primary key or throws a <code>NoSuchMasterCountryException</code> if it could not be found.
	 *
	 * @param countryId the primary key of the master country
	 * @return the master country
	 * @throws NoSuchMasterCountryException if a master country with the primary key could not be found
	 */
	public static MasterCountry findByPrimaryKey(long countryId)
		throws com.mypage.admin.product.exception.NoSuchMasterCountryException {

		return getPersistence().findByPrimaryKey(countryId);
	}

	/**
	 * Returns the master country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param countryId the primary key of the master country
	 * @return the master country, or <code>null</code> if a master country with the primary key could not be found
	 */
	public static MasterCountry fetchByPrimaryKey(long countryId) {
		return getPersistence().fetchByPrimaryKey(countryId);
	}

	/**
	 * Returns all the master countries.
	 *
	 * @return the master countries
	 */
	public static List<MasterCountry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the master countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @return the range of master countries
	 */
	public static List<MasterCountry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the master countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master countries
	 */
	public static List<MasterCountry> findAll(
		int start, int end,
		OrderByComparator<MasterCountry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master countries
	 */
	public static List<MasterCountry> findAll(
		int start, int end, OrderByComparator<MasterCountry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the master countries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of master countries.
	 *
	 * @return the number of master countries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MasterCountryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MasterCountryPersistence _persistence;

}