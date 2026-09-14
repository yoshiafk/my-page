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

import com.mypage.admin.product.exception.NoSuchTravelDomesticInsuredTypeException;
import com.mypage.admin.product.model.TravelDomesticInsuredType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the travel domestic insured type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticInsuredTypeUtil
 * @generated
 */
@ProviderType
public interface TravelDomesticInsuredTypePersistence
	extends BasePersistence<TravelDomesticInsuredType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TravelDomesticInsuredTypeUtil} to access the travel domestic insured type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @return the matching travel domestic insured types
	 */
	public java.util.List<TravelDomesticInsuredType> findBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code);

	/**
	 * Returns a range of all the travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @return the range of matching travel domestic insured types
	 */
	public java.util.List<TravelDomesticInsuredType> findBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code, int start,
		int end);

	/**
	 * Returns an ordered range of all the travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic insured types
	 */
	public java.util.List<TravelDomesticInsuredType> findBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticInsuredType> orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic insured types
	 */
	public java.util.List<TravelDomesticInsuredType> findBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticInsuredType> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel domestic insured type in the ordered set where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic insured type
	 * @throws NoSuchTravelDomesticInsuredTypeException if a matching travel domestic insured type could not be found
	 */
	public TravelDomesticInsuredType findBysearchInsuredType_First(
			long travelDomesticInsuredTypeId, String name, String code,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticInsuredType> orderByComparator)
		throws NoSuchTravelDomesticInsuredTypeException;

	/**
	 * Returns the first travel domestic insured type in the ordered set where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic insured type, or <code>null</code> if a matching travel domestic insured type could not be found
	 */
	public TravelDomesticInsuredType fetchBysearchInsuredType_First(
		long travelDomesticInsuredTypeId, String name, String code,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticInsuredType> orderByComparator);

	/**
	 * Returns the last travel domestic insured type in the ordered set where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic insured type
	 * @throws NoSuchTravelDomesticInsuredTypeException if a matching travel domestic insured type could not be found
	 */
	public TravelDomesticInsuredType findBysearchInsuredType_Last(
			long travelDomesticInsuredTypeId, String name, String code,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticInsuredType> orderByComparator)
		throws NoSuchTravelDomesticInsuredTypeException;

	/**
	 * Returns the last travel domestic insured type in the ordered set where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic insured type, or <code>null</code> if a matching travel domestic insured type could not be found
	 */
	public TravelDomesticInsuredType fetchBysearchInsuredType_Last(
		long travelDomesticInsuredTypeId, String name, String code,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticInsuredType> orderByComparator);

	/**
	 * Removes all the travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63; from the database.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 */
	public void removeBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code);

	/**
	 * Returns the number of travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @return the number of matching travel domestic insured types
	 */
	public int countBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code);

	/**
	 * Caches the travel domestic insured type in the entity cache if it is enabled.
	 *
	 * @param travelDomesticInsuredType the travel domestic insured type
	 */
	public void cacheResult(
		TravelDomesticInsuredType travelDomesticInsuredType);

	/**
	 * Caches the travel domestic insured types in the entity cache if it is enabled.
	 *
	 * @param travelDomesticInsuredTypes the travel domestic insured types
	 */
	public void cacheResult(
		java.util.List<TravelDomesticInsuredType> travelDomesticInsuredTypes);

	/**
	 * Creates a new travel domestic insured type with the primary key. Does not add the travel domestic insured type to the database.
	 *
	 * @param travelDomesticInsuredTypeId the primary key for the new travel domestic insured type
	 * @return the new travel domestic insured type
	 */
	public TravelDomesticInsuredType create(long travelDomesticInsuredTypeId);

	/**
	 * Removes the travel domestic insured type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticInsuredTypeId the primary key of the travel domestic insured type
	 * @return the travel domestic insured type that was removed
	 * @throws NoSuchTravelDomesticInsuredTypeException if a travel domestic insured type with the primary key could not be found
	 */
	public TravelDomesticInsuredType remove(long travelDomesticInsuredTypeId)
		throws NoSuchTravelDomesticInsuredTypeException;

	public TravelDomesticInsuredType updateImpl(
		TravelDomesticInsuredType travelDomesticInsuredType);

	/**
	 * Returns the travel domestic insured type with the primary key or throws a <code>NoSuchTravelDomesticInsuredTypeException</code> if it could not be found.
	 *
	 * @param travelDomesticInsuredTypeId the primary key of the travel domestic insured type
	 * @return the travel domestic insured type
	 * @throws NoSuchTravelDomesticInsuredTypeException if a travel domestic insured type with the primary key could not be found
	 */
	public TravelDomesticInsuredType findByPrimaryKey(
			long travelDomesticInsuredTypeId)
		throws NoSuchTravelDomesticInsuredTypeException;

	/**
	 * Returns the travel domestic insured type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticInsuredTypeId the primary key of the travel domestic insured type
	 * @return the travel domestic insured type, or <code>null</code> if a travel domestic insured type with the primary key could not be found
	 */
	public TravelDomesticInsuredType fetchByPrimaryKey(
		long travelDomesticInsuredTypeId);

	/**
	 * Returns all the travel domestic insured types.
	 *
	 * @return the travel domestic insured types
	 */
	public java.util.List<TravelDomesticInsuredType> findAll();

	/**
	 * Returns a range of all the travel domestic insured types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @return the range of travel domestic insured types
	 */
	public java.util.List<TravelDomesticInsuredType> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic insured types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic insured types
	 */
	public java.util.List<TravelDomesticInsuredType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticInsuredType> orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic insured types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic insured types
	 */
	public java.util.List<TravelDomesticInsuredType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticInsuredType> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the travel domestic insured types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of travel domestic insured types.
	 *
	 * @return the number of travel domestic insured types
	 */
	public int countAll();

}