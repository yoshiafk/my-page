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

import com.mypage.admin.product.exception.NoSuchReferenceNumberException;
import com.mypage.admin.product.model.ReferenceNumber;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the reference number service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see ReferenceNumberUtil
 * @generated
 */
@ProviderType
public interface ReferenceNumberPersistence
	extends BasePersistence<ReferenceNumber> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReferenceNumberUtil} to access the reference number persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the reference number where userRole = &#63; and channel = &#63; and type = &#63; and productCode = &#63; and businessType = &#63; and currency = &#63; or throws a <code>NoSuchReferenceNumberException</code> if it could not be found.
	 *
	 * @param userRole the user role
	 * @param channel the channel
	 * @param type the type
	 * @param productCode the product code
	 * @param businessType the business type
	 * @param currency the currency
	 * @return the matching reference number
	 * @throws NoSuchReferenceNumberException if a matching reference number could not be found
	 */
	public ReferenceNumber findBysearchReferenceNumber(
			String userRole, String channel, String type, String productCode,
			String businessType, String currency)
		throws NoSuchReferenceNumberException;

	/**
	 * Returns the reference number where userRole = &#63; and channel = &#63; and type = &#63; and productCode = &#63; and businessType = &#63; and currency = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userRole the user role
	 * @param channel the channel
	 * @param type the type
	 * @param productCode the product code
	 * @param businessType the business type
	 * @param currency the currency
	 * @return the matching reference number, or <code>null</code> if a matching reference number could not be found
	 */
	public ReferenceNumber fetchBysearchReferenceNumber(
		String userRole, String channel, String type, String productCode,
		String businessType, String currency);

	/**
	 * Returns the reference number where userRole = &#63; and channel = &#63; and type = &#63; and productCode = &#63; and businessType = &#63; and currency = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userRole the user role
	 * @param channel the channel
	 * @param type the type
	 * @param productCode the product code
	 * @param businessType the business type
	 * @param currency the currency
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching reference number, or <code>null</code> if a matching reference number could not be found
	 */
	public ReferenceNumber fetchBysearchReferenceNumber(
		String userRole, String channel, String type, String productCode,
		String businessType, String currency, boolean useFinderCache);

	/**
	 * Removes the reference number where userRole = &#63; and channel = &#63; and type = &#63; and productCode = &#63; and businessType = &#63; and currency = &#63; from the database.
	 *
	 * @param userRole the user role
	 * @param channel the channel
	 * @param type the type
	 * @param productCode the product code
	 * @param businessType the business type
	 * @param currency the currency
	 * @return the reference number that was removed
	 */
	public ReferenceNumber removeBysearchReferenceNumber(
			String userRole, String channel, String type, String productCode,
			String businessType, String currency)
		throws NoSuchReferenceNumberException;

	/**
	 * Returns the number of reference numbers where userRole = &#63; and channel = &#63; and type = &#63; and productCode = &#63; and businessType = &#63; and currency = &#63;.
	 *
	 * @param userRole the user role
	 * @param channel the channel
	 * @param type the type
	 * @param productCode the product code
	 * @param businessType the business type
	 * @param currency the currency
	 * @return the number of matching reference numbers
	 */
	public int countBysearchReferenceNumber(
		String userRole, String channel, String type, String productCode,
		String businessType, String currency);

	/**
	 * Caches the reference number in the entity cache if it is enabled.
	 *
	 * @param referenceNumber the reference number
	 */
	public void cacheResult(ReferenceNumber referenceNumber);

	/**
	 * Caches the reference numbers in the entity cache if it is enabled.
	 *
	 * @param referenceNumbers the reference numbers
	 */
	public void cacheResult(java.util.List<ReferenceNumber> referenceNumbers);

	/**
	 * Creates a new reference number with the primary key. Does not add the reference number to the database.
	 *
	 * @param referenceNumberId the primary key for the new reference number
	 * @return the new reference number
	 */
	public ReferenceNumber create(long referenceNumberId);

	/**
	 * Removes the reference number with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param referenceNumberId the primary key of the reference number
	 * @return the reference number that was removed
	 * @throws NoSuchReferenceNumberException if a reference number with the primary key could not be found
	 */
	public ReferenceNumber remove(long referenceNumberId)
		throws NoSuchReferenceNumberException;

	public ReferenceNumber updateImpl(ReferenceNumber referenceNumber);

	/**
	 * Returns the reference number with the primary key or throws a <code>NoSuchReferenceNumberException</code> if it could not be found.
	 *
	 * @param referenceNumberId the primary key of the reference number
	 * @return the reference number
	 * @throws NoSuchReferenceNumberException if a reference number with the primary key could not be found
	 */
	public ReferenceNumber findByPrimaryKey(long referenceNumberId)
		throws NoSuchReferenceNumberException;

	/**
	 * Returns the reference number with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param referenceNumberId the primary key of the reference number
	 * @return the reference number, or <code>null</code> if a reference number with the primary key could not be found
	 */
	public ReferenceNumber fetchByPrimaryKey(long referenceNumberId);

	/**
	 * Returns all the reference numbers.
	 *
	 * @return the reference numbers
	 */
	public java.util.List<ReferenceNumber> findAll();

	/**
	 * Returns a range of all the reference numbers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceNumberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference numbers
	 * @param end the upper bound of the range of reference numbers (not inclusive)
	 * @return the range of reference numbers
	 */
	public java.util.List<ReferenceNumber> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the reference numbers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceNumberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference numbers
	 * @param end the upper bound of the range of reference numbers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of reference numbers
	 */
	public java.util.List<ReferenceNumber> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReferenceNumber>
			orderByComparator);

	/**
	 * Returns an ordered range of all the reference numbers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceNumberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference numbers
	 * @param end the upper bound of the range of reference numbers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of reference numbers
	 */
	public java.util.List<ReferenceNumber> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReferenceNumber>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the reference numbers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of reference numbers.
	 *
	 * @return the number of reference numbers
	 */
	public int countAll();

}