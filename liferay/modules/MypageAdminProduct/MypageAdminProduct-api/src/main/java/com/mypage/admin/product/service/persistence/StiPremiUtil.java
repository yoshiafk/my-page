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

import com.mypage.admin.product.model.StiPremi;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the sti premi service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.StiPremiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see StiPremiPersistence
 * @generated
 */
public class StiPremiUtil {

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
	public static void clearCache(StiPremi stiPremi) {
		getPersistence().clearCache(stiPremi);
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
	public static Map<Serializable, StiPremi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StiPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StiPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StiPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StiPremi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StiPremi update(StiPremi stiPremi) {
		return getPersistence().update(stiPremi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StiPremi update(
		StiPremi stiPremi, ServiceContext serviceContext) {

		return getPersistence().update(stiPremi, serviceContext);
	}

	/**
	 * Returns all the sti premis where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @return the matching sti premis
	 */
	public static List<StiPremi> findByCurrencyAndTravellerType(
		String currency, String travellerType) {

		return getPersistence().findByCurrencyAndTravellerType(
			currency, travellerType);
	}

	/**
	 * Returns a range of all the sti premis where currency = &#63; and travellerType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiPremiModelImpl</code>.
	 * </p>
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param start the lower bound of the range of sti premis
	 * @param end the upper bound of the range of sti premis (not inclusive)
	 * @return the range of matching sti premis
	 */
	public static List<StiPremi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end) {

		return getPersistence().findByCurrencyAndTravellerType(
			currency, travellerType, start, end);
	}

	/**
	 * Returns an ordered range of all the sti premis where currency = &#63; and travellerType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiPremiModelImpl</code>.
	 * </p>
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param start the lower bound of the range of sti premis
	 * @param end the upper bound of the range of sti premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sti premis
	 */
	public static List<StiPremi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end,
		OrderByComparator<StiPremi> orderByComparator) {

		return getPersistence().findByCurrencyAndTravellerType(
			currency, travellerType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sti premis where currency = &#63; and travellerType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiPremiModelImpl</code>.
	 * </p>
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param start the lower bound of the range of sti premis
	 * @param end the upper bound of the range of sti premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sti premis
	 */
	public static List<StiPremi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end,
		OrderByComparator<StiPremi> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCurrencyAndTravellerType(
			currency, travellerType, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first sti premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sti premi
	 * @throws NoSuchStiPremiException if a matching sti premi could not be found
	 */
	public static StiPremi findByCurrencyAndTravellerType_First(
			String currency, String travellerType,
			OrderByComparator<StiPremi> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchStiPremiException {

		return getPersistence().findByCurrencyAndTravellerType_First(
			currency, travellerType, orderByComparator);
	}

	/**
	 * Returns the first sti premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sti premi, or <code>null</code> if a matching sti premi could not be found
	 */
	public static StiPremi fetchByCurrencyAndTravellerType_First(
		String currency, String travellerType,
		OrderByComparator<StiPremi> orderByComparator) {

		return getPersistence().fetchByCurrencyAndTravellerType_First(
			currency, travellerType, orderByComparator);
	}

	/**
	 * Returns the last sti premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sti premi
	 * @throws NoSuchStiPremiException if a matching sti premi could not be found
	 */
	public static StiPremi findByCurrencyAndTravellerType_Last(
			String currency, String travellerType,
			OrderByComparator<StiPremi> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchStiPremiException {

		return getPersistence().findByCurrencyAndTravellerType_Last(
			currency, travellerType, orderByComparator);
	}

	/**
	 * Returns the last sti premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sti premi, or <code>null</code> if a matching sti premi could not be found
	 */
	public static StiPremi fetchByCurrencyAndTravellerType_Last(
		String currency, String travellerType,
		OrderByComparator<StiPremi> orderByComparator) {

		return getPersistence().fetchByCurrencyAndTravellerType_Last(
			currency, travellerType, orderByComparator);
	}

	/**
	 * Returns the sti premis before and after the current sti premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param premiId the primary key of the current sti premi
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sti premi
	 * @throws NoSuchStiPremiException if a sti premi with the primary key could not be found
	 */
	public static StiPremi[] findByCurrencyAndTravellerType_PrevAndNext(
			long premiId, String currency, String travellerType,
			OrderByComparator<StiPremi> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchStiPremiException {

		return getPersistence().findByCurrencyAndTravellerType_PrevAndNext(
			premiId, currency, travellerType, orderByComparator);
	}

	/**
	 * Removes all the sti premis where currency = &#63; and travellerType = &#63; from the database.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 */
	public static void removeByCurrencyAndTravellerType(
		String currency, String travellerType) {

		getPersistence().removeByCurrencyAndTravellerType(
			currency, travellerType);
	}

	/**
	 * Returns the number of sti premis where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @return the number of matching sti premis
	 */
	public static int countByCurrencyAndTravellerType(
		String currency, String travellerType) {

		return getPersistence().countByCurrencyAndTravellerType(
			currency, travellerType);
	}

	/**
	 * Caches the sti premi in the entity cache if it is enabled.
	 *
	 * @param stiPremi the sti premi
	 */
	public static void cacheResult(StiPremi stiPremi) {
		getPersistence().cacheResult(stiPremi);
	}

	/**
	 * Caches the sti premis in the entity cache if it is enabled.
	 *
	 * @param stiPremis the sti premis
	 */
	public static void cacheResult(List<StiPremi> stiPremis) {
		getPersistence().cacheResult(stiPremis);
	}

	/**
	 * Creates a new sti premi with the primary key. Does not add the sti premi to the database.
	 *
	 * @param premiId the primary key for the new sti premi
	 * @return the new sti premi
	 */
	public static StiPremi create(long premiId) {
		return getPersistence().create(premiId);
	}

	/**
	 * Removes the sti premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param premiId the primary key of the sti premi
	 * @return the sti premi that was removed
	 * @throws NoSuchStiPremiException if a sti premi with the primary key could not be found
	 */
	public static StiPremi remove(long premiId)
		throws com.mypage.admin.product.exception.NoSuchStiPremiException {

		return getPersistence().remove(premiId);
	}

	public static StiPremi updateImpl(StiPremi stiPremi) {
		return getPersistence().updateImpl(stiPremi);
	}

	/**
	 * Returns the sti premi with the primary key or throws a <code>NoSuchStiPremiException</code> if it could not be found.
	 *
	 * @param premiId the primary key of the sti premi
	 * @return the sti premi
	 * @throws NoSuchStiPremiException if a sti premi with the primary key could not be found
	 */
	public static StiPremi findByPrimaryKey(long premiId)
		throws com.mypage.admin.product.exception.NoSuchStiPremiException {

		return getPersistence().findByPrimaryKey(premiId);
	}

	/**
	 * Returns the sti premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param premiId the primary key of the sti premi
	 * @return the sti premi, or <code>null</code> if a sti premi with the primary key could not be found
	 */
	public static StiPremi fetchByPrimaryKey(long premiId) {
		return getPersistence().fetchByPrimaryKey(premiId);
	}

	/**
	 * Returns all the sti premis.
	 *
	 * @return the sti premis
	 */
	public static List<StiPremi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sti premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti premis
	 * @param end the upper bound of the range of sti premis (not inclusive)
	 * @return the range of sti premis
	 */
	public static List<StiPremi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sti premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti premis
	 * @param end the upper bound of the range of sti premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sti premis
	 */
	public static List<StiPremi> findAll(
		int start, int end, OrderByComparator<StiPremi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sti premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti premis
	 * @param end the upper bound of the range of sti premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sti premis
	 */
	public static List<StiPremi> findAll(
		int start, int end, OrderByComparator<StiPremi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sti premis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sti premis.
	 *
	 * @return the number of sti premis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StiPremiPersistence getPersistence() {
		return _persistence;
	}

	private static volatile StiPremiPersistence _persistence;

}