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

import com.mypage.admin.product.exception.NoSuchIntTravelStandardNewPremiException;
import com.mypage.admin.product.model.IntTravelStandardNewPremi;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the int travel standard new premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see IntTravelStandardNewPremiUtil
 * @generated
 */
@ProviderType
public interface IntTravelStandardNewPremiPersistence
	extends BasePersistence<IntTravelStandardNewPremi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IntTravelStandardNewPremiUtil} to access the int travel standard new premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the int travel standard new premi where travelType = &#63; and packageType = &#63; and peopleType = &#63; and currency = &#63; and mainInsured = &#63; and spouse = &#63; and child = &#63; or throws a <code>NoSuchIntTravelStandardNewPremiException</code> if it could not be found.
	 *
	 * @param travelType the travel type
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param mainInsured the main insured
	 * @param spouse the spouse
	 * @param child the child
	 * @return the matching int travel standard new premi
	 * @throws NoSuchIntTravelStandardNewPremiException if a matching int travel standard new premi could not be found
	 */
	public IntTravelStandardNewPremi findBySpecificPremi(
			String travelType, String packageType, String peopleType,
			String currency, int mainInsured, int spouse, int child)
		throws NoSuchIntTravelStandardNewPremiException;

	/**
	 * Returns the int travel standard new premi where travelType = &#63; and packageType = &#63; and peopleType = &#63; and currency = &#63; and mainInsured = &#63; and spouse = &#63; and child = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param travelType the travel type
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param mainInsured the main insured
	 * @param spouse the spouse
	 * @param child the child
	 * @return the matching int travel standard new premi, or <code>null</code> if a matching int travel standard new premi could not be found
	 */
	public IntTravelStandardNewPremi fetchBySpecificPremi(
		String travelType, String packageType, String peopleType,
		String currency, int mainInsured, int spouse, int child);

	/**
	 * Returns the int travel standard new premi where travelType = &#63; and packageType = &#63; and peopleType = &#63; and currency = &#63; and mainInsured = &#63; and spouse = &#63; and child = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param travelType the travel type
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param mainInsured the main insured
	 * @param spouse the spouse
	 * @param child the child
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching int travel standard new premi, or <code>null</code> if a matching int travel standard new premi could not be found
	 */
	public IntTravelStandardNewPremi fetchBySpecificPremi(
		String travelType, String packageType, String peopleType,
		String currency, int mainInsured, int spouse, int child,
		boolean useFinderCache);

	/**
	 * Removes the int travel standard new premi where travelType = &#63; and packageType = &#63; and peopleType = &#63; and currency = &#63; and mainInsured = &#63; and spouse = &#63; and child = &#63; from the database.
	 *
	 * @param travelType the travel type
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param mainInsured the main insured
	 * @param spouse the spouse
	 * @param child the child
	 * @return the int travel standard new premi that was removed
	 */
	public IntTravelStandardNewPremi removeBySpecificPremi(
			String travelType, String packageType, String peopleType,
			String currency, int mainInsured, int spouse, int child)
		throws NoSuchIntTravelStandardNewPremiException;

	/**
	 * Returns the number of int travel standard new premis where travelType = &#63; and packageType = &#63; and peopleType = &#63; and currency = &#63; and mainInsured = &#63; and spouse = &#63; and child = &#63;.
	 *
	 * @param travelType the travel type
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param mainInsured the main insured
	 * @param spouse the spouse
	 * @param child the child
	 * @return the number of matching int travel standard new premis
	 */
	public int countBySpecificPremi(
		String travelType, String packageType, String peopleType,
		String currency, int mainInsured, int spouse, int child);

	/**
	 * Caches the int travel standard new premi in the entity cache if it is enabled.
	 *
	 * @param intTravelStandardNewPremi the int travel standard new premi
	 */
	public void cacheResult(
		IntTravelStandardNewPremi intTravelStandardNewPremi);

	/**
	 * Caches the int travel standard new premis in the entity cache if it is enabled.
	 *
	 * @param intTravelStandardNewPremis the int travel standard new premis
	 */
	public void cacheResult(
		java.util.List<IntTravelStandardNewPremi> intTravelStandardNewPremis);

	/**
	 * Creates a new int travel standard new premi with the primary key. Does not add the int travel standard new premi to the database.
	 *
	 * @param intTravelStandardNewPremiId the primary key for the new int travel standard new premi
	 * @return the new int travel standard new premi
	 */
	public IntTravelStandardNewPremi create(long intTravelStandardNewPremiId);

	/**
	 * Removes the int travel standard new premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param intTravelStandardNewPremiId the primary key of the int travel standard new premi
	 * @return the int travel standard new premi that was removed
	 * @throws NoSuchIntTravelStandardNewPremiException if a int travel standard new premi with the primary key could not be found
	 */
	public IntTravelStandardNewPremi remove(long intTravelStandardNewPremiId)
		throws NoSuchIntTravelStandardNewPremiException;

	public IntTravelStandardNewPremi updateImpl(
		IntTravelStandardNewPremi intTravelStandardNewPremi);

	/**
	 * Returns the int travel standard new premi with the primary key or throws a <code>NoSuchIntTravelStandardNewPremiException</code> if it could not be found.
	 *
	 * @param intTravelStandardNewPremiId the primary key of the int travel standard new premi
	 * @return the int travel standard new premi
	 * @throws NoSuchIntTravelStandardNewPremiException if a int travel standard new premi with the primary key could not be found
	 */
	public IntTravelStandardNewPremi findByPrimaryKey(
			long intTravelStandardNewPremiId)
		throws NoSuchIntTravelStandardNewPremiException;

	/**
	 * Returns the int travel standard new premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param intTravelStandardNewPremiId the primary key of the int travel standard new premi
	 * @return the int travel standard new premi, or <code>null</code> if a int travel standard new premi with the primary key could not be found
	 */
	public IntTravelStandardNewPremi fetchByPrimaryKey(
		long intTravelStandardNewPremiId);

	/**
	 * Returns all the int travel standard new premis.
	 *
	 * @return the int travel standard new premis
	 */
	public java.util.List<IntTravelStandardNewPremi> findAll();

	/**
	 * Returns a range of all the int travel standard new premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IntTravelStandardNewPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of int travel standard new premis
	 * @param end the upper bound of the range of int travel standard new premis (not inclusive)
	 * @return the range of int travel standard new premis
	 */
	public java.util.List<IntTravelStandardNewPremi> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the int travel standard new premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IntTravelStandardNewPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of int travel standard new premis
	 * @param end the upper bound of the range of int travel standard new premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of int travel standard new premis
	 */
	public java.util.List<IntTravelStandardNewPremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<IntTravelStandardNewPremi> orderByComparator);

	/**
	 * Returns an ordered range of all the int travel standard new premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IntTravelStandardNewPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of int travel standard new premis
	 * @param end the upper bound of the range of int travel standard new premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of int travel standard new premis
	 */
	public java.util.List<IntTravelStandardNewPremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<IntTravelStandardNewPremi> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the int travel standard new premis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of int travel standard new premis.
	 *
	 * @return the number of int travel standard new premis
	 */
	public int countAll();

}