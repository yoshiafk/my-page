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

import com.mypage.admin.product.exception.NoSuchTravelIntBenefitValueException;
import com.mypage.admin.product.model.TravelIntBenefitValue;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the travel int benefit value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelIntBenefitValueUtil
 * @generated
 */
@ProviderType
public interface TravelIntBenefitValuePersistence
	extends BasePersistence<TravelIntBenefitValue> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TravelIntBenefitValueUtil} to access the travel int benefit value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the travel int benefit values where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @return the matching travel int benefit values
	 */
	public java.util.List<TravelIntBenefitValue> findByPackageType(
		String packageType);

	/**
	 * Returns a range of all the travel int benefit values where packageType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param packageType the package type
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @return the range of matching travel int benefit values
	 */
	public java.util.List<TravelIntBenefitValue> findByPackageType(
		String packageType, int start, int end);

	/**
	 * Returns an ordered range of all the travel int benefit values where packageType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param packageType the package type
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel int benefit values
	 */
	public java.util.List<TravelIntBenefitValue> findByPackageType(
		String packageType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelIntBenefitValue>
			orderByComparator);

	/**
	 * Returns an ordered range of all the travel int benefit values where packageType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param packageType the package type
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel int benefit values
	 */
	public java.util.List<TravelIntBenefitValue> findByPackageType(
		String packageType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelIntBenefitValue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel int benefit value in the ordered set where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel int benefit value
	 * @throws NoSuchTravelIntBenefitValueException if a matching travel int benefit value could not be found
	 */
	public TravelIntBenefitValue findByPackageType_First(
			String packageType,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelIntBenefitValue> orderByComparator)
		throws NoSuchTravelIntBenefitValueException;

	/**
	 * Returns the first travel int benefit value in the ordered set where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel int benefit value, or <code>null</code> if a matching travel int benefit value could not be found
	 */
	public TravelIntBenefitValue fetchByPackageType_First(
		String packageType,
		com.liferay.portal.kernel.util.OrderByComparator<TravelIntBenefitValue>
			orderByComparator);

	/**
	 * Returns the last travel int benefit value in the ordered set where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel int benefit value
	 * @throws NoSuchTravelIntBenefitValueException if a matching travel int benefit value could not be found
	 */
	public TravelIntBenefitValue findByPackageType_Last(
			String packageType,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelIntBenefitValue> orderByComparator)
		throws NoSuchTravelIntBenefitValueException;

	/**
	 * Returns the last travel int benefit value in the ordered set where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel int benefit value, or <code>null</code> if a matching travel int benefit value could not be found
	 */
	public TravelIntBenefitValue fetchByPackageType_Last(
		String packageType,
		com.liferay.portal.kernel.util.OrderByComparator<TravelIntBenefitValue>
			orderByComparator);

	/**
	 * Returns the travel int benefit values before and after the current travel int benefit value in the ordered set where packageType = &#63;.
	 *
	 * @param travelIntBenefitValueId the primary key of the current travel int benefit value
	 * @param packageType the package type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel int benefit value
	 * @throws NoSuchTravelIntBenefitValueException if a travel int benefit value with the primary key could not be found
	 */
	public TravelIntBenefitValue[] findByPackageType_PrevAndNext(
			long travelIntBenefitValueId, String packageType,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelIntBenefitValue> orderByComparator)
		throws NoSuchTravelIntBenefitValueException;

	/**
	 * Removes all the travel int benefit values where packageType = &#63; from the database.
	 *
	 * @param packageType the package type
	 */
	public void removeByPackageType(String packageType);

	/**
	 * Returns the number of travel int benefit values where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @return the number of matching travel int benefit values
	 */
	public int countByPackageType(String packageType);

	/**
	 * Caches the travel int benefit value in the entity cache if it is enabled.
	 *
	 * @param travelIntBenefitValue the travel int benefit value
	 */
	public void cacheResult(TravelIntBenefitValue travelIntBenefitValue);

	/**
	 * Caches the travel int benefit values in the entity cache if it is enabled.
	 *
	 * @param travelIntBenefitValues the travel int benefit values
	 */
	public void cacheResult(
		java.util.List<TravelIntBenefitValue> travelIntBenefitValues);

	/**
	 * Creates a new travel int benefit value with the primary key. Does not add the travel int benefit value to the database.
	 *
	 * @param travelIntBenefitValueId the primary key for the new travel int benefit value
	 * @return the new travel int benefit value
	 */
	public TravelIntBenefitValue create(long travelIntBenefitValueId);

	/**
	 * Removes the travel int benefit value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelIntBenefitValueId the primary key of the travel int benefit value
	 * @return the travel int benefit value that was removed
	 * @throws NoSuchTravelIntBenefitValueException if a travel int benefit value with the primary key could not be found
	 */
	public TravelIntBenefitValue remove(long travelIntBenefitValueId)
		throws NoSuchTravelIntBenefitValueException;

	public TravelIntBenefitValue updateImpl(
		TravelIntBenefitValue travelIntBenefitValue);

	/**
	 * Returns the travel int benefit value with the primary key or throws a <code>NoSuchTravelIntBenefitValueException</code> if it could not be found.
	 *
	 * @param travelIntBenefitValueId the primary key of the travel int benefit value
	 * @return the travel int benefit value
	 * @throws NoSuchTravelIntBenefitValueException if a travel int benefit value with the primary key could not be found
	 */
	public TravelIntBenefitValue findByPrimaryKey(long travelIntBenefitValueId)
		throws NoSuchTravelIntBenefitValueException;

	/**
	 * Returns the travel int benefit value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelIntBenefitValueId the primary key of the travel int benefit value
	 * @return the travel int benefit value, or <code>null</code> if a travel int benefit value with the primary key could not be found
	 */
	public TravelIntBenefitValue fetchByPrimaryKey(
		long travelIntBenefitValueId);

	/**
	 * Returns all the travel int benefit values.
	 *
	 * @return the travel int benefit values
	 */
	public java.util.List<TravelIntBenefitValue> findAll();

	/**
	 * Returns a range of all the travel int benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @return the range of travel int benefit values
	 */
	public java.util.List<TravelIntBenefitValue> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the travel int benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel int benefit values
	 */
	public java.util.List<TravelIntBenefitValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelIntBenefitValue>
			orderByComparator);

	/**
	 * Returns an ordered range of all the travel int benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel int benefit values
	 */
	public java.util.List<TravelIntBenefitValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelIntBenefitValue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the travel int benefit values from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of travel int benefit values.
	 *
	 * @return the number of travel int benefit values
	 */
	public int countAll();

}