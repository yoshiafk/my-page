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

import com.mypage.admin.product.model.Premi;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the premi service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.PremiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PremiPersistence
 * @generated
 */
public class PremiUtil {

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
	public static void clearCache(Premi premi) {
		getPersistence().clearCache(premi);
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
	public static Map<Serializable, Premi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Premi> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Premi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Premi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Premi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Premi update(Premi premi) {
		return getPersistence().update(premi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Premi update(Premi premi, ServiceContext serviceContext) {
		return getPersistence().update(premi, serviceContext);
	}

	/**
	 * Returns all the premis where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @return the matching premis
	 */
	public static List<Premi> findByCurrencyAndTravellerType(
		String currency, String travellerType) {

		return getPersistence().findByCurrencyAndTravellerType(
			currency, travellerType);
	}

	/**
	 * Returns a range of all the premis where currency = &#63; and travellerType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PremiModelImpl</code>.
	 * </p>
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param start the lower bound of the range of premis
	 * @param end the upper bound of the range of premis (not inclusive)
	 * @return the range of matching premis
	 */
	public static List<Premi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end) {

		return getPersistence().findByCurrencyAndTravellerType(
			currency, travellerType, start, end);
	}

	/**
	 * Returns an ordered range of all the premis where currency = &#63; and travellerType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PremiModelImpl</code>.
	 * </p>
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param start the lower bound of the range of premis
	 * @param end the upper bound of the range of premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching premis
	 */
	public static List<Premi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end,
		OrderByComparator<Premi> orderByComparator) {

		return getPersistence().findByCurrencyAndTravellerType(
			currency, travellerType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the premis where currency = &#63; and travellerType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PremiModelImpl</code>.
	 * </p>
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param start the lower bound of the range of premis
	 * @param end the upper bound of the range of premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching premis
	 */
	public static List<Premi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end,
		OrderByComparator<Premi> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCurrencyAndTravellerType(
			currency, travellerType, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching premi
	 * @throws NoSuchPremiException if a matching premi could not be found
	 */
	public static Premi findByCurrencyAndTravellerType_First(
			String currency, String travellerType,
			OrderByComparator<Premi> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPremiException {

		return getPersistence().findByCurrencyAndTravellerType_First(
			currency, travellerType, orderByComparator);
	}

	/**
	 * Returns the first premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching premi, or <code>null</code> if a matching premi could not be found
	 */
	public static Premi fetchByCurrencyAndTravellerType_First(
		String currency, String travellerType,
		OrderByComparator<Premi> orderByComparator) {

		return getPersistence().fetchByCurrencyAndTravellerType_First(
			currency, travellerType, orderByComparator);
	}

	/**
	 * Returns the last premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching premi
	 * @throws NoSuchPremiException if a matching premi could not be found
	 */
	public static Premi findByCurrencyAndTravellerType_Last(
			String currency, String travellerType,
			OrderByComparator<Premi> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPremiException {

		return getPersistence().findByCurrencyAndTravellerType_Last(
			currency, travellerType, orderByComparator);
	}

	/**
	 * Returns the last premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching premi, or <code>null</code> if a matching premi could not be found
	 */
	public static Premi fetchByCurrencyAndTravellerType_Last(
		String currency, String travellerType,
		OrderByComparator<Premi> orderByComparator) {

		return getPersistence().fetchByCurrencyAndTravellerType_Last(
			currency, travellerType, orderByComparator);
	}

	/**
	 * Returns the premis before and after the current premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param premiId the primary key of the current premi
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next premi
	 * @throws NoSuchPremiException if a premi with the primary key could not be found
	 */
	public static Premi[] findByCurrencyAndTravellerType_PrevAndNext(
			long premiId, String currency, String travellerType,
			OrderByComparator<Premi> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPremiException {

		return getPersistence().findByCurrencyAndTravellerType_PrevAndNext(
			premiId, currency, travellerType, orderByComparator);
	}

	/**
	 * Removes all the premis where currency = &#63; and travellerType = &#63; from the database.
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
	 * Returns the number of premis where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @return the number of matching premis
	 */
	public static int countByCurrencyAndTravellerType(
		String currency, String travellerType) {

		return getPersistence().countByCurrencyAndTravellerType(
			currency, travellerType);
	}

	/**
	 * Caches the premi in the entity cache if it is enabled.
	 *
	 * @param premi the premi
	 */
	public static void cacheResult(Premi premi) {
		getPersistence().cacheResult(premi);
	}

	/**
	 * Caches the premis in the entity cache if it is enabled.
	 *
	 * @param premis the premis
	 */
	public static void cacheResult(List<Premi> premis) {
		getPersistence().cacheResult(premis);
	}

	/**
	 * Creates a new premi with the primary key. Does not add the premi to the database.
	 *
	 * @param premiId the primary key for the new premi
	 * @return the new premi
	 */
	public static Premi create(long premiId) {
		return getPersistence().create(premiId);
	}

	/**
	 * Removes the premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param premiId the primary key of the premi
	 * @return the premi that was removed
	 * @throws NoSuchPremiException if a premi with the primary key could not be found
	 */
	public static Premi remove(long premiId)
		throws com.mypage.admin.product.exception.NoSuchPremiException {

		return getPersistence().remove(premiId);
	}

	public static Premi updateImpl(Premi premi) {
		return getPersistence().updateImpl(premi);
	}

	/**
	 * Returns the premi with the primary key or throws a <code>NoSuchPremiException</code> if it could not be found.
	 *
	 * @param premiId the primary key of the premi
	 * @return the premi
	 * @throws NoSuchPremiException if a premi with the primary key could not be found
	 */
	public static Premi findByPrimaryKey(long premiId)
		throws com.mypage.admin.product.exception.NoSuchPremiException {

		return getPersistence().findByPrimaryKey(premiId);
	}

	/**
	 * Returns the premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param premiId the primary key of the premi
	 * @return the premi, or <code>null</code> if a premi with the primary key could not be found
	 */
	public static Premi fetchByPrimaryKey(long premiId) {
		return getPersistence().fetchByPrimaryKey(premiId);
	}

	/**
	 * Returns all the premis.
	 *
	 * @return the premis
	 */
	public static List<Premi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of premis
	 * @param end the upper bound of the range of premis (not inclusive)
	 * @return the range of premis
	 */
	public static List<Premi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of premis
	 * @param end the upper bound of the range of premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of premis
	 */
	public static List<Premi> findAll(
		int start, int end, OrderByComparator<Premi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of premis
	 * @param end the upper bound of the range of premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of premis
	 */
	public static List<Premi> findAll(
		int start, int end, OrderByComparator<Premi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the premis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of premis.
	 *
	 * @return the number of premis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PremiPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PremiPersistence _persistence;

}