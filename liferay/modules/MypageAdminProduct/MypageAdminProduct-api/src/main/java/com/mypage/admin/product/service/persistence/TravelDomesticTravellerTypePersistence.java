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

import com.mypage.admin.product.exception.NoSuchTravelDomesticTravellerTypeException;
import com.mypage.admin.product.model.TravelDomesticTravellerType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the travel domestic traveller type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticTravellerTypeUtil
 * @generated
 */
@ProviderType
public interface TravelDomesticTravellerTypePersistence
	extends BasePersistence<TravelDomesticTravellerType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TravelDomesticTravellerTypeUtil} to access the travel domestic traveller type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the travel domestic traveller types where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @return the matching travel domestic traveller types
	 */
	public java.util.List<TravelDomesticTravellerType>
		findBysearchTravellerTypeId(long travellerTypeId);

	/**
	 * Returns a range of all the travel domestic traveller types where travellerTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @return the range of matching travel domestic traveller types
	 */
	public java.util.List<TravelDomesticTravellerType>
		findBysearchTravellerTypeId(long travellerTypeId, int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic traveller types where travellerTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic traveller types
	 */
	public java.util.List<TravelDomesticTravellerType>
		findBysearchTravellerTypeId(
			long travellerTypeId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticTravellerType> orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic traveller types where travellerTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic traveller types
	 */
	public java.util.List<TravelDomesticTravellerType>
		findBysearchTravellerTypeId(
			long travellerTypeId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticTravellerType> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first travel domestic traveller type in the ordered set where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic traveller type
	 * @throws NoSuchTravelDomesticTravellerTypeException if a matching travel domestic traveller type could not be found
	 */
	public TravelDomesticTravellerType findBysearchTravellerTypeId_First(
			long travellerTypeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticTravellerType> orderByComparator)
		throws NoSuchTravelDomesticTravellerTypeException;

	/**
	 * Returns the first travel domestic traveller type in the ordered set where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic traveller type, or <code>null</code> if a matching travel domestic traveller type could not be found
	 */
	public TravelDomesticTravellerType fetchBysearchTravellerTypeId_First(
		long travellerTypeId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticTravellerType> orderByComparator);

	/**
	 * Returns the last travel domestic traveller type in the ordered set where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic traveller type
	 * @throws NoSuchTravelDomesticTravellerTypeException if a matching travel domestic traveller type could not be found
	 */
	public TravelDomesticTravellerType findBysearchTravellerTypeId_Last(
			long travellerTypeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticTravellerType> orderByComparator)
		throws NoSuchTravelDomesticTravellerTypeException;

	/**
	 * Returns the last travel domestic traveller type in the ordered set where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic traveller type, or <code>null</code> if a matching travel domestic traveller type could not be found
	 */
	public TravelDomesticTravellerType fetchBysearchTravellerTypeId_Last(
		long travellerTypeId,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticTravellerType> orderByComparator);

	/**
	 * Removes all the travel domestic traveller types where travellerTypeId = &#63; from the database.
	 *
	 * @param travellerTypeId the traveller type ID
	 */
	public void removeBysearchTravellerTypeId(long travellerTypeId);

	/**
	 * Returns the number of travel domestic traveller types where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @return the number of matching travel domestic traveller types
	 */
	public int countBysearchTravellerTypeId(long travellerTypeId);

	/**
	 * Caches the travel domestic traveller type in the entity cache if it is enabled.
	 *
	 * @param travelDomesticTravellerType the travel domestic traveller type
	 */
	public void cacheResult(
		TravelDomesticTravellerType travelDomesticTravellerType);

	/**
	 * Caches the travel domestic traveller types in the entity cache if it is enabled.
	 *
	 * @param travelDomesticTravellerTypes the travel domestic traveller types
	 */
	public void cacheResult(
		java.util.List<TravelDomesticTravellerType>
			travelDomesticTravellerTypes);

	/**
	 * Creates a new travel domestic traveller type with the primary key. Does not add the travel domestic traveller type to the database.
	 *
	 * @param travellerTypeId the primary key for the new travel domestic traveller type
	 * @return the new travel domestic traveller type
	 */
	public TravelDomesticTravellerType create(long travellerTypeId);

	/**
	 * Removes the travel domestic traveller type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travellerTypeId the primary key of the travel domestic traveller type
	 * @return the travel domestic traveller type that was removed
	 * @throws NoSuchTravelDomesticTravellerTypeException if a travel domestic traveller type with the primary key could not be found
	 */
	public TravelDomesticTravellerType remove(long travellerTypeId)
		throws NoSuchTravelDomesticTravellerTypeException;

	public TravelDomesticTravellerType updateImpl(
		TravelDomesticTravellerType travelDomesticTravellerType);

	/**
	 * Returns the travel domestic traveller type with the primary key or throws a <code>NoSuchTravelDomesticTravellerTypeException</code> if it could not be found.
	 *
	 * @param travellerTypeId the primary key of the travel domestic traveller type
	 * @return the travel domestic traveller type
	 * @throws NoSuchTravelDomesticTravellerTypeException if a travel domestic traveller type with the primary key could not be found
	 */
	public TravelDomesticTravellerType findByPrimaryKey(long travellerTypeId)
		throws NoSuchTravelDomesticTravellerTypeException;

	/**
	 * Returns the travel domestic traveller type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travellerTypeId the primary key of the travel domestic traveller type
	 * @return the travel domestic traveller type, or <code>null</code> if a travel domestic traveller type with the primary key could not be found
	 */
	public TravelDomesticTravellerType fetchByPrimaryKey(long travellerTypeId);

	/**
	 * Returns all the travel domestic traveller types.
	 *
	 * @return the travel domestic traveller types
	 */
	public java.util.List<TravelDomesticTravellerType> findAll();

	/**
	 * Returns a range of all the travel domestic traveller types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @return the range of travel domestic traveller types
	 */
	public java.util.List<TravelDomesticTravellerType> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic traveller types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic traveller types
	 */
	public java.util.List<TravelDomesticTravellerType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticTravellerType> orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic traveller types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic traveller types
	 */
	public java.util.List<TravelDomesticTravellerType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticTravellerType> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the travel domestic traveller types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of travel domestic traveller types.
	 *
	 * @return the number of travel domestic traveller types
	 */
	public int countAll();

}