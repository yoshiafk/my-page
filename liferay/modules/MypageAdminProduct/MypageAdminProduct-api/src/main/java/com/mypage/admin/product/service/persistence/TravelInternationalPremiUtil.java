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

import com.mypage.admin.product.model.TravelInternationalPremi;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the travel international premi service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.TravelInternationalPremiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelInternationalPremiPersistence
 * @generated
 */
public class TravelInternationalPremiUtil {

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
		TravelInternationalPremi travelInternationalPremi) {

		getPersistence().clearCache(travelInternationalPremi);
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
	public static Map<Serializable, TravelInternationalPremi>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TravelInternationalPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TravelInternationalPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TravelInternationalPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TravelInternationalPremi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TravelInternationalPremi update(
		TravelInternationalPremi travelInternationalPremi) {

		return getPersistence().update(travelInternationalPremi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TravelInternationalPremi update(
		TravelInternationalPremi travelInternationalPremi,
		ServiceContext serviceContext) {

		return getPersistence().update(
			travelInternationalPremi, serviceContext);
	}

	/**
	 * Returns all the travel international premis where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration = &#63; and maxDuration = &#63; and active = &#63;.
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param active the active
	 * @return the matching travel international premis
	 */
	public static List<TravelInternationalPremi> findBysearchPackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int active) {

		return getPersistence().findBysearchPackage(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration, active);
	}

	/**
	 * Returns a range of all the travel international premis where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration = &#63; and maxDuration = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelInternationalPremiModelImpl</code>.
	 * </p>
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param active the active
	 * @param start the lower bound of the range of travel international premis
	 * @param end the upper bound of the range of travel international premis (not inclusive)
	 * @return the range of matching travel international premis
	 */
	public static List<TravelInternationalPremi> findBysearchPackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int active,
		int start, int end) {

		return getPersistence().findBysearchPackage(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration, active, start, end);
	}

	/**
	 * Returns an ordered range of all the travel international premis where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration = &#63; and maxDuration = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelInternationalPremiModelImpl</code>.
	 * </p>
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param active the active
	 * @param start the lower bound of the range of travel international premis
	 * @param end the upper bound of the range of travel international premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel international premis
	 */
	public static List<TravelInternationalPremi> findBysearchPackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int active,
		int start, int end,
		OrderByComparator<TravelInternationalPremi> orderByComparator) {

		return getPersistence().findBysearchPackage(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration, active, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel international premis where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration = &#63; and maxDuration = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelInternationalPremiModelImpl</code>.
	 * </p>
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param active the active
	 * @param start the lower bound of the range of travel international premis
	 * @param end the upper bound of the range of travel international premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel international premis
	 */
	public static List<TravelInternationalPremi> findBysearchPackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int active,
		int start, int end,
		OrderByComparator<TravelInternationalPremi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchPackage(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration, active, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first travel international premi in the ordered set where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration = &#63; and maxDuration = &#63; and active = &#63;.
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel international premi
	 * @throws NoSuchTravelInternationalPremiException if a matching travel international premi could not be found
	 */
	public static TravelInternationalPremi findBysearchPackage_First(
			String packageType, String peopleType, String currency,
			int adultCount, int childrenCount, int minDuration, int maxDuration,
			int active,
			OrderByComparator<TravelInternationalPremi> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelInternationalPremiException {

		return getPersistence().findBysearchPackage_First(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration, active, orderByComparator);
	}

	/**
	 * Returns the first travel international premi in the ordered set where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration = &#63; and maxDuration = &#63; and active = &#63;.
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel international premi, or <code>null</code> if a matching travel international premi could not be found
	 */
	public static TravelInternationalPremi fetchBysearchPackage_First(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int active,
		OrderByComparator<TravelInternationalPremi> orderByComparator) {

		return getPersistence().fetchBysearchPackage_First(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration, active, orderByComparator);
	}

	/**
	 * Returns the last travel international premi in the ordered set where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration = &#63; and maxDuration = &#63; and active = &#63;.
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel international premi
	 * @throws NoSuchTravelInternationalPremiException if a matching travel international premi could not be found
	 */
	public static TravelInternationalPremi findBysearchPackage_Last(
			String packageType, String peopleType, String currency,
			int adultCount, int childrenCount, int minDuration, int maxDuration,
			int active,
			OrderByComparator<TravelInternationalPremi> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelInternationalPremiException {

		return getPersistence().findBysearchPackage_Last(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration, active, orderByComparator);
	}

	/**
	 * Returns the last travel international premi in the ordered set where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration = &#63; and maxDuration = &#63; and active = &#63;.
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel international premi, or <code>null</code> if a matching travel international premi could not be found
	 */
	public static TravelInternationalPremi fetchBysearchPackage_Last(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int active,
		OrderByComparator<TravelInternationalPremi> orderByComparator) {

		return getPersistence().fetchBysearchPackage_Last(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration, active, orderByComparator);
	}

	/**
	 * Returns the travel international premis before and after the current travel international premi in the ordered set where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration = &#63; and maxDuration = &#63; and active = &#63;.
	 *
	 * @param premiId the primary key of the current travel international premi
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel international premi
	 * @throws NoSuchTravelInternationalPremiException if a travel international premi with the primary key could not be found
	 */
	public static TravelInternationalPremi[] findBysearchPackage_PrevAndNext(
			long premiId, String packageType, String peopleType,
			String currency, int adultCount, int childrenCount, int minDuration,
			int maxDuration, int active,
			OrderByComparator<TravelInternationalPremi> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelInternationalPremiException {

		return getPersistence().findBysearchPackage_PrevAndNext(
			premiId, packageType, peopleType, currency, adultCount,
			childrenCount, minDuration, maxDuration, active, orderByComparator);
	}

	/**
	 * Removes all the travel international premis where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration = &#63; and maxDuration = &#63; and active = &#63; from the database.
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param active the active
	 */
	public static void removeBysearchPackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int active) {

		getPersistence().removeBysearchPackage(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration, active);
	}

	/**
	 * Returns the number of travel international premis where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration = &#63; and maxDuration = &#63; and active = &#63;.
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param active the active
	 * @return the number of matching travel international premis
	 */
	public static int countBysearchPackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int active) {

		return getPersistence().countBysearchPackage(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration, active);
	}

	/**
	 * Returns all the travel international premis where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration &le; &#63; and maxDuration &ge; &#63;.
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @return the matching travel international premis
	 */
	public static List<TravelInternationalPremi> findBygetActivePackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration) {

		return getPersistence().findBygetActivePackage(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration);
	}

	/**
	 * Returns a range of all the travel international premis where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration &le; &#63; and maxDuration &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelInternationalPremiModelImpl</code>.
	 * </p>
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param start the lower bound of the range of travel international premis
	 * @param end the upper bound of the range of travel international premis (not inclusive)
	 * @return the range of matching travel international premis
	 */
	public static List<TravelInternationalPremi> findBygetActivePackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int start,
		int end) {

		return getPersistence().findBygetActivePackage(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration, start, end);
	}

	/**
	 * Returns an ordered range of all the travel international premis where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration &le; &#63; and maxDuration &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelInternationalPremiModelImpl</code>.
	 * </p>
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param start the lower bound of the range of travel international premis
	 * @param end the upper bound of the range of travel international premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel international premis
	 */
	public static List<TravelInternationalPremi> findBygetActivePackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int start, int end,
		OrderByComparator<TravelInternationalPremi> orderByComparator) {

		return getPersistence().findBygetActivePackage(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel international premis where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration &le; &#63; and maxDuration &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelInternationalPremiModelImpl</code>.
	 * </p>
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param start the lower bound of the range of travel international premis
	 * @param end the upper bound of the range of travel international premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel international premis
	 */
	public static List<TravelInternationalPremi> findBygetActivePackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int start, int end,
		OrderByComparator<TravelInternationalPremi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBygetActivePackage(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first travel international premi in the ordered set where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration &le; &#63; and maxDuration &ge; &#63;.
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel international premi
	 * @throws NoSuchTravelInternationalPremiException if a matching travel international premi could not be found
	 */
	public static TravelInternationalPremi findBygetActivePackage_First(
			String packageType, String peopleType, String currency,
			int adultCount, int childrenCount, int minDuration, int maxDuration,
			OrderByComparator<TravelInternationalPremi> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelInternationalPremiException {

		return getPersistence().findBygetActivePackage_First(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration, orderByComparator);
	}

	/**
	 * Returns the first travel international premi in the ordered set where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration &le; &#63; and maxDuration &ge; &#63;.
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel international premi, or <code>null</code> if a matching travel international premi could not be found
	 */
	public static TravelInternationalPremi fetchBygetActivePackage_First(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration,
		OrderByComparator<TravelInternationalPremi> orderByComparator) {

		return getPersistence().fetchBygetActivePackage_First(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration, orderByComparator);
	}

	/**
	 * Returns the last travel international premi in the ordered set where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration &le; &#63; and maxDuration &ge; &#63;.
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel international premi
	 * @throws NoSuchTravelInternationalPremiException if a matching travel international premi could not be found
	 */
	public static TravelInternationalPremi findBygetActivePackage_Last(
			String packageType, String peopleType, String currency,
			int adultCount, int childrenCount, int minDuration, int maxDuration,
			OrderByComparator<TravelInternationalPremi> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelInternationalPremiException {

		return getPersistence().findBygetActivePackage_Last(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration, orderByComparator);
	}

	/**
	 * Returns the last travel international premi in the ordered set where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration &le; &#63; and maxDuration &ge; &#63;.
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel international premi, or <code>null</code> if a matching travel international premi could not be found
	 */
	public static TravelInternationalPremi fetchBygetActivePackage_Last(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration,
		OrderByComparator<TravelInternationalPremi> orderByComparator) {

		return getPersistence().fetchBygetActivePackage_Last(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration, orderByComparator);
	}

	/**
	 * Returns the travel international premis before and after the current travel international premi in the ordered set where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration &le; &#63; and maxDuration &ge; &#63;.
	 *
	 * @param premiId the primary key of the current travel international premi
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel international premi
	 * @throws NoSuchTravelInternationalPremiException if a travel international premi with the primary key could not be found
	 */
	public static TravelInternationalPremi[] findBygetActivePackage_PrevAndNext(
			long premiId, String packageType, String peopleType,
			String currency, int adultCount, int childrenCount, int minDuration,
			int maxDuration,
			OrderByComparator<TravelInternationalPremi> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelInternationalPremiException {

		return getPersistence().findBygetActivePackage_PrevAndNext(
			premiId, packageType, peopleType, currency, adultCount,
			childrenCount, minDuration, maxDuration, orderByComparator);
	}

	/**
	 * Removes all the travel international premis where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration &le; &#63; and maxDuration &ge; &#63; from the database.
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 */
	public static void removeBygetActivePackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration) {

		getPersistence().removeBygetActivePackage(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration);
	}

	/**
	 * Returns the number of travel international premis where packageType = &#63; and peopleType = &#63; and currency = &#63; and adultCount = &#63; and childrenCount = &#63; and minDuration &le; &#63; and maxDuration &ge; &#63;.
	 *
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param adultCount the adult count
	 * @param childrenCount the children count
	 * @param minDuration the min duration
	 * @param maxDuration the max duration
	 * @return the number of matching travel international premis
	 */
	public static int countBygetActivePackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration) {

		return getPersistence().countBygetActivePackage(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration);
	}

	/**
	 * Caches the travel international premi in the entity cache if it is enabled.
	 *
	 * @param travelInternationalPremi the travel international premi
	 */
	public static void cacheResult(
		TravelInternationalPremi travelInternationalPremi) {

		getPersistence().cacheResult(travelInternationalPremi);
	}

	/**
	 * Caches the travel international premis in the entity cache if it is enabled.
	 *
	 * @param travelInternationalPremis the travel international premis
	 */
	public static void cacheResult(
		List<TravelInternationalPremi> travelInternationalPremis) {

		getPersistence().cacheResult(travelInternationalPremis);
	}

	/**
	 * Creates a new travel international premi with the primary key. Does not add the travel international premi to the database.
	 *
	 * @param premiId the primary key for the new travel international premi
	 * @return the new travel international premi
	 */
	public static TravelInternationalPremi create(long premiId) {
		return getPersistence().create(premiId);
	}

	/**
	 * Removes the travel international premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param premiId the primary key of the travel international premi
	 * @return the travel international premi that was removed
	 * @throws NoSuchTravelInternationalPremiException if a travel international premi with the primary key could not be found
	 */
	public static TravelInternationalPremi remove(long premiId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelInternationalPremiException {

		return getPersistence().remove(premiId);
	}

	public static TravelInternationalPremi updateImpl(
		TravelInternationalPremi travelInternationalPremi) {

		return getPersistence().updateImpl(travelInternationalPremi);
	}

	/**
	 * Returns the travel international premi with the primary key or throws a <code>NoSuchTravelInternationalPremiException</code> if it could not be found.
	 *
	 * @param premiId the primary key of the travel international premi
	 * @return the travel international premi
	 * @throws NoSuchTravelInternationalPremiException if a travel international premi with the primary key could not be found
	 */
	public static TravelInternationalPremi findByPrimaryKey(long premiId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelInternationalPremiException {

		return getPersistence().findByPrimaryKey(premiId);
	}

	/**
	 * Returns the travel international premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param premiId the primary key of the travel international premi
	 * @return the travel international premi, or <code>null</code> if a travel international premi with the primary key could not be found
	 */
	public static TravelInternationalPremi fetchByPrimaryKey(long premiId) {
		return getPersistence().fetchByPrimaryKey(premiId);
	}

	/**
	 * Returns all the travel international premis.
	 *
	 * @return the travel international premis
	 */
	public static List<TravelInternationalPremi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the travel international premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelInternationalPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel international premis
	 * @param end the upper bound of the range of travel international premis (not inclusive)
	 * @return the range of travel international premis
	 */
	public static List<TravelInternationalPremi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the travel international premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelInternationalPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel international premis
	 * @param end the upper bound of the range of travel international premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel international premis
	 */
	public static List<TravelInternationalPremi> findAll(
		int start, int end,
		OrderByComparator<TravelInternationalPremi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel international premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelInternationalPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel international premis
	 * @param end the upper bound of the range of travel international premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel international premis
	 */
	public static List<TravelInternationalPremi> findAll(
		int start, int end,
		OrderByComparator<TravelInternationalPremi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the travel international premis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of travel international premis.
	 *
	 * @return the number of travel international premis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TravelInternationalPremiPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TravelInternationalPremiPersistence _persistence;

}