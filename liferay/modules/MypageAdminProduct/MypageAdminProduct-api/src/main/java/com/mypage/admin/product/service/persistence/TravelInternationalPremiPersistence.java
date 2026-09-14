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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.admin.product.exception.NoSuchTravelInternationalPremiException;
import com.mypage.admin.product.model.TravelInternationalPremi;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the travel international premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelInternationalPremiUtil
 * @generated
 */
@ProviderType
public interface TravelInternationalPremiPersistence
	extends BasePersistence<TravelInternationalPremi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TravelInternationalPremiUtil} to access the travel international premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

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
	public java.util.List<TravelInternationalPremi> findBysearchPackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int active);

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
	public java.util.List<TravelInternationalPremi> findBysearchPackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int active,
		int start, int end);

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
	public java.util.List<TravelInternationalPremi> findBysearchPackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int active,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelInternationalPremi> orderByComparator);

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
	public java.util.List<TravelInternationalPremi> findBysearchPackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int active,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelInternationalPremi> orderByComparator,
		boolean useFinderCache);

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
	public TravelInternationalPremi findBysearchPackage_First(
			String packageType, String peopleType, String currency,
			int adultCount, int childrenCount, int minDuration, int maxDuration,
			int active,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelInternationalPremi> orderByComparator)
		throws NoSuchTravelInternationalPremiException;

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
	public TravelInternationalPremi fetchBysearchPackage_First(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int active,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelInternationalPremi> orderByComparator);

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
	public TravelInternationalPremi findBysearchPackage_Last(
			String packageType, String peopleType, String currency,
			int adultCount, int childrenCount, int minDuration, int maxDuration,
			int active,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelInternationalPremi> orderByComparator)
		throws NoSuchTravelInternationalPremiException;

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
	public TravelInternationalPremi fetchBysearchPackage_Last(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int active,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelInternationalPremi> orderByComparator);

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
	public TravelInternationalPremi[] findBysearchPackage_PrevAndNext(
			long premiId, String packageType, String peopleType,
			String currency, int adultCount, int childrenCount, int minDuration,
			int maxDuration, int active,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelInternationalPremi> orderByComparator)
		throws NoSuchTravelInternationalPremiException;

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
	public void removeBysearchPackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int active);

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
	public int countBysearchPackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int active);

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
	public java.util.List<TravelInternationalPremi> findBygetActivePackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration);

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
	public java.util.List<TravelInternationalPremi> findBygetActivePackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int start,
		int end);

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
	public java.util.List<TravelInternationalPremi> findBygetActivePackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelInternationalPremi> orderByComparator);

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
	public java.util.List<TravelInternationalPremi> findBygetActivePackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelInternationalPremi> orderByComparator,
		boolean useFinderCache);

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
	public TravelInternationalPremi findBygetActivePackage_First(
			String packageType, String peopleType, String currency,
			int adultCount, int childrenCount, int minDuration, int maxDuration,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelInternationalPremi> orderByComparator)
		throws NoSuchTravelInternationalPremiException;

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
	public TravelInternationalPremi fetchBygetActivePackage_First(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelInternationalPremi> orderByComparator);

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
	public TravelInternationalPremi findBygetActivePackage_Last(
			String packageType, String peopleType, String currency,
			int adultCount, int childrenCount, int minDuration, int maxDuration,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelInternationalPremi> orderByComparator)
		throws NoSuchTravelInternationalPremiException;

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
	public TravelInternationalPremi fetchBygetActivePackage_Last(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelInternationalPremi> orderByComparator);

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
	public TravelInternationalPremi[] findBygetActivePackage_PrevAndNext(
			long premiId, String packageType, String peopleType,
			String currency, int adultCount, int childrenCount, int minDuration,
			int maxDuration,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelInternationalPremi> orderByComparator)
		throws NoSuchTravelInternationalPremiException;

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
	public void removeBygetActivePackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration);

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
	public int countBygetActivePackage(
		String packageType, String peopleType, String currency, int adultCount,
		int childrenCount, int minDuration, int maxDuration);

	/**
	 * Caches the travel international premi in the entity cache if it is enabled.
	 *
	 * @param travelInternationalPremi the travel international premi
	 */
	public void cacheResult(TravelInternationalPremi travelInternationalPremi);

	/**
	 * Caches the travel international premis in the entity cache if it is enabled.
	 *
	 * @param travelInternationalPremis the travel international premis
	 */
	public void cacheResult(
		java.util.List<TravelInternationalPremi> travelInternationalPremis);

	/**
	 * Creates a new travel international premi with the primary key. Does not add the travel international premi to the database.
	 *
	 * @param premiId the primary key for the new travel international premi
	 * @return the new travel international premi
	 */
	public TravelInternationalPremi create(long premiId);

	/**
	 * Removes the travel international premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param premiId the primary key of the travel international premi
	 * @return the travel international premi that was removed
	 * @throws NoSuchTravelInternationalPremiException if a travel international premi with the primary key could not be found
	 */
	public TravelInternationalPremi remove(long premiId)
		throws NoSuchTravelInternationalPremiException;

	public TravelInternationalPremi updateImpl(
		TravelInternationalPremi travelInternationalPremi);

	/**
	 * Returns the travel international premi with the primary key or throws a <code>NoSuchTravelInternationalPremiException</code> if it could not be found.
	 *
	 * @param premiId the primary key of the travel international premi
	 * @return the travel international premi
	 * @throws NoSuchTravelInternationalPremiException if a travel international premi with the primary key could not be found
	 */
	public TravelInternationalPremi findByPrimaryKey(long premiId)
		throws NoSuchTravelInternationalPremiException;

	/**
	 * Returns the travel international premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param premiId the primary key of the travel international premi
	 * @return the travel international premi, or <code>null</code> if a travel international premi with the primary key could not be found
	 */
	public TravelInternationalPremi fetchByPrimaryKey(long premiId);

	/**
	 * Returns all the travel international premis.
	 *
	 * @return the travel international premis
	 */
	public java.util.List<TravelInternationalPremi> findAll();

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
	public java.util.List<TravelInternationalPremi> findAll(int start, int end);

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
	public java.util.List<TravelInternationalPremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelInternationalPremi> orderByComparator);

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
	public java.util.List<TravelInternationalPremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelInternationalPremi> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the travel international premis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of travel international premis.
	 *
	 * @return the number of travel international premis
	 */
	public int countAll();

}