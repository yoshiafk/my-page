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

import com.mypage.admin.product.model.MasterCurrency;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the master currency service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.MasterCurrencyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterCurrencyPersistence
 * @generated
 */
public class MasterCurrencyUtil {

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
	public static void clearCache(MasterCurrency masterCurrency) {
		getPersistence().clearCache(masterCurrency);
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
	public static Map<Serializable, MasterCurrency> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MasterCurrency> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MasterCurrency> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MasterCurrency> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MasterCurrency> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MasterCurrency update(MasterCurrency masterCurrency) {
		return getPersistence().update(masterCurrency);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MasterCurrency update(
		MasterCurrency masterCurrency, ServiceContext serviceContext) {

		return getPersistence().update(masterCurrency, serviceContext);
	}

	/**
	 * Returns all the master currencies where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching master currencies
	 */
	public static List<MasterCurrency> findBycurrencyName(String name) {
		return getPersistence().findBycurrencyName(name);
	}

	/**
	 * Returns a range of all the master currencies where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @return the range of matching master currencies
	 */
	public static List<MasterCurrency> findBycurrencyName(
		String name, int start, int end) {

		return getPersistence().findBycurrencyName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the master currencies where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master currencies
	 */
	public static List<MasterCurrency> findBycurrencyName(
		String name, int start, int end,
		OrderByComparator<MasterCurrency> orderByComparator) {

		return getPersistence().findBycurrencyName(
			name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master currencies where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master currencies
	 */
	public static List<MasterCurrency> findBycurrencyName(
		String name, int start, int end,
		OrderByComparator<MasterCurrency> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBycurrencyName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first master currency in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master currency
	 * @throws NoSuchMasterCurrencyException if a matching master currency could not be found
	 */
	public static MasterCurrency findBycurrencyName_First(
			String name, OrderByComparator<MasterCurrency> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterCurrencyException {

		return getPersistence().findBycurrencyName_First(
			name, orderByComparator);
	}

	/**
	 * Returns the first master currency in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master currency, or <code>null</code> if a matching master currency could not be found
	 */
	public static MasterCurrency fetchBycurrencyName_First(
		String name, OrderByComparator<MasterCurrency> orderByComparator) {

		return getPersistence().fetchBycurrencyName_First(
			name, orderByComparator);
	}

	/**
	 * Returns the last master currency in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master currency
	 * @throws NoSuchMasterCurrencyException if a matching master currency could not be found
	 */
	public static MasterCurrency findBycurrencyName_Last(
			String name, OrderByComparator<MasterCurrency> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterCurrencyException {

		return getPersistence().findBycurrencyName_Last(
			name, orderByComparator);
	}

	/**
	 * Returns the last master currency in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master currency, or <code>null</code> if a matching master currency could not be found
	 */
	public static MasterCurrency fetchBycurrencyName_Last(
		String name, OrderByComparator<MasterCurrency> orderByComparator) {

		return getPersistence().fetchBycurrencyName_Last(
			name, orderByComparator);
	}

	/**
	 * Returns the master currencies before and after the current master currency in the ordered set where name = &#63;.
	 *
	 * @param currencyId the primary key of the current master currency
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master currency
	 * @throws NoSuchMasterCurrencyException if a master currency with the primary key could not be found
	 */
	public static MasterCurrency[] findBycurrencyName_PrevAndNext(
			long currencyId, String name,
			OrderByComparator<MasterCurrency> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterCurrencyException {

		return getPersistence().findBycurrencyName_PrevAndNext(
			currencyId, name, orderByComparator);
	}

	/**
	 * Removes all the master currencies where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeBycurrencyName(String name) {
		getPersistence().removeBycurrencyName(name);
	}

	/**
	 * Returns the number of master currencies where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching master currencies
	 */
	public static int countBycurrencyName(String name) {
		return getPersistence().countBycurrencyName(name);
	}

	/**
	 * Returns the master currency where name = &#63; or throws a <code>NoSuchMasterCurrencyException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching master currency
	 * @throws NoSuchMasterCurrencyException if a matching master currency could not be found
	 */
	public static MasterCurrency findBysearchCurrency(String name)
		throws com.mypage.admin.product.exception.
			NoSuchMasterCurrencyException {

		return getPersistence().findBysearchCurrency(name);
	}

	/**
	 * Returns the master currency where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching master currency, or <code>null</code> if a matching master currency could not be found
	 */
	public static MasterCurrency fetchBysearchCurrency(String name) {
		return getPersistence().fetchBysearchCurrency(name);
	}

	/**
	 * Returns the master currency where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching master currency, or <code>null</code> if a matching master currency could not be found
	 */
	public static MasterCurrency fetchBysearchCurrency(
		String name, boolean useFinderCache) {

		return getPersistence().fetchBysearchCurrency(name, useFinderCache);
	}

	/**
	 * Removes the master currency where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the master currency that was removed
	 */
	public static MasterCurrency removeBysearchCurrency(String name)
		throws com.mypage.admin.product.exception.
			NoSuchMasterCurrencyException {

		return getPersistence().removeBysearchCurrency(name);
	}

	/**
	 * Returns the number of master currencies where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching master currencies
	 */
	public static int countBysearchCurrency(String name) {
		return getPersistence().countBysearchCurrency(name);
	}

	/**
	 * Caches the master currency in the entity cache if it is enabled.
	 *
	 * @param masterCurrency the master currency
	 */
	public static void cacheResult(MasterCurrency masterCurrency) {
		getPersistence().cacheResult(masterCurrency);
	}

	/**
	 * Caches the master currencies in the entity cache if it is enabled.
	 *
	 * @param masterCurrencies the master currencies
	 */
	public static void cacheResult(List<MasterCurrency> masterCurrencies) {
		getPersistence().cacheResult(masterCurrencies);
	}

	/**
	 * Creates a new master currency with the primary key. Does not add the master currency to the database.
	 *
	 * @param currencyId the primary key for the new master currency
	 * @return the new master currency
	 */
	public static MasterCurrency create(long currencyId) {
		return getPersistence().create(currencyId);
	}

	/**
	 * Removes the master currency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param currencyId the primary key of the master currency
	 * @return the master currency that was removed
	 * @throws NoSuchMasterCurrencyException if a master currency with the primary key could not be found
	 */
	public static MasterCurrency remove(long currencyId)
		throws com.mypage.admin.product.exception.
			NoSuchMasterCurrencyException {

		return getPersistence().remove(currencyId);
	}

	public static MasterCurrency updateImpl(MasterCurrency masterCurrency) {
		return getPersistence().updateImpl(masterCurrency);
	}

	/**
	 * Returns the master currency with the primary key or throws a <code>NoSuchMasterCurrencyException</code> if it could not be found.
	 *
	 * @param currencyId the primary key of the master currency
	 * @return the master currency
	 * @throws NoSuchMasterCurrencyException if a master currency with the primary key could not be found
	 */
	public static MasterCurrency findByPrimaryKey(long currencyId)
		throws com.mypage.admin.product.exception.
			NoSuchMasterCurrencyException {

		return getPersistence().findByPrimaryKey(currencyId);
	}

	/**
	 * Returns the master currency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param currencyId the primary key of the master currency
	 * @return the master currency, or <code>null</code> if a master currency with the primary key could not be found
	 */
	public static MasterCurrency fetchByPrimaryKey(long currencyId) {
		return getPersistence().fetchByPrimaryKey(currencyId);
	}

	/**
	 * Returns all the master currencies.
	 *
	 * @return the master currencies
	 */
	public static List<MasterCurrency> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the master currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @return the range of master currencies
	 */
	public static List<MasterCurrency> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the master currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master currencies
	 */
	public static List<MasterCurrency> findAll(
		int start, int end,
		OrderByComparator<MasterCurrency> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master currencies
	 */
	public static List<MasterCurrency> findAll(
		int start, int end, OrderByComparator<MasterCurrency> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the master currencies from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of master currencies.
	 *
	 * @return the number of master currencies
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MasterCurrencyPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MasterCurrencyPersistence _persistence;

}