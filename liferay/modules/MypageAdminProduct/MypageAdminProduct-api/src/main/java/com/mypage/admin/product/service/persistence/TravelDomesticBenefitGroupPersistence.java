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

import com.mypage.admin.product.exception.NoSuchTravelDomesticBenefitGroupException;
import com.mypage.admin.product.model.TravelDomesticBenefitGroup;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the travel domestic benefit group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticBenefitGroupUtil
 * @generated
 */
@ProviderType
public interface TravelDomesticBenefitGroupPersistence
	extends BasePersistence<TravelDomesticBenefitGroup> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TravelDomesticBenefitGroupUtil} to access the travel domestic benefit group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the travel domestic benefit groups where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @return the matching travel domestic benefit groups
	 */
	public java.util.List<TravelDomesticBenefitGroup>
		findBysearchTravelDomesticBenefitGroupId(
			long travelDomesticBenefitGroupId);

	/**
	 * Returns a range of all the travel domestic benefit groups where travelDomesticBenefitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @return the range of matching travel domestic benefit groups
	 */
	public java.util.List<TravelDomesticBenefitGroup>
		findBysearchTravelDomesticBenefitGroupId(
			long travelDomesticBenefitGroupId, int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic benefit groups where travelDomesticBenefitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic benefit groups
	 */
	public java.util.List<TravelDomesticBenefitGroup>
		findBysearchTravelDomesticBenefitGroupId(
			long travelDomesticBenefitGroupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticBenefitGroup> orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic benefit groups where travelDomesticBenefitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic benefit groups
	 */
	public java.util.List<TravelDomesticBenefitGroup>
		findBysearchTravelDomesticBenefitGroupId(
			long travelDomesticBenefitGroupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticBenefitGroup> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first travel domestic benefit group in the ordered set where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit group
	 * @throws NoSuchTravelDomesticBenefitGroupException if a matching travel domestic benefit group could not be found
	 */
	public TravelDomesticBenefitGroup
			findBysearchTravelDomesticBenefitGroupId_First(
				long travelDomesticBenefitGroupId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TravelDomesticBenefitGroup> orderByComparator)
		throws NoSuchTravelDomesticBenefitGroupException;

	/**
	 * Returns the first travel domestic benefit group in the ordered set where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit group, or <code>null</code> if a matching travel domestic benefit group could not be found
	 */
	public TravelDomesticBenefitGroup
		fetchBysearchTravelDomesticBenefitGroupId_First(
			long travelDomesticBenefitGroupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticBenefitGroup> orderByComparator);

	/**
	 * Returns the last travel domestic benefit group in the ordered set where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit group
	 * @throws NoSuchTravelDomesticBenefitGroupException if a matching travel domestic benefit group could not be found
	 */
	public TravelDomesticBenefitGroup
			findBysearchTravelDomesticBenefitGroupId_Last(
				long travelDomesticBenefitGroupId,
				com.liferay.portal.kernel.util.OrderByComparator
					<TravelDomesticBenefitGroup> orderByComparator)
		throws NoSuchTravelDomesticBenefitGroupException;

	/**
	 * Returns the last travel domestic benefit group in the ordered set where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit group, or <code>null</code> if a matching travel domestic benefit group could not be found
	 */
	public TravelDomesticBenefitGroup
		fetchBysearchTravelDomesticBenefitGroupId_Last(
			long travelDomesticBenefitGroupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticBenefitGroup> orderByComparator);

	/**
	 * Removes all the travel domestic benefit groups where travelDomesticBenefitGroupId = &#63; from the database.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 */
	public void removeBysearchTravelDomesticBenefitGroupId(
		long travelDomesticBenefitGroupId);

	/**
	 * Returns the number of travel domestic benefit groups where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @return the number of matching travel domestic benefit groups
	 */
	public int countBysearchTravelDomesticBenefitGroupId(
		long travelDomesticBenefitGroupId);

	/**
	 * Returns the travel domestic benefit group where code = &#63; or throws a <code>NoSuchTravelDomesticBenefitGroupException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching travel domestic benefit group
	 * @throws NoSuchTravelDomesticBenefitGroupException if a matching travel domestic benefit group could not be found
	 */
	public TravelDomesticBenefitGroup
			findBysearchTravelDomesticBenefitGroupCode(String code)
		throws NoSuchTravelDomesticBenefitGroupException;

	/**
	 * Returns the travel domestic benefit group where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching travel domestic benefit group, or <code>null</code> if a matching travel domestic benefit group could not be found
	 */
	public TravelDomesticBenefitGroup
		fetchBysearchTravelDomesticBenefitGroupCode(String code);

	/**
	 * Returns the travel domestic benefit group where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching travel domestic benefit group, or <code>null</code> if a matching travel domestic benefit group could not be found
	 */
	public TravelDomesticBenefitGroup
		fetchBysearchTravelDomesticBenefitGroupCode(
			String code, boolean useFinderCache);

	/**
	 * Removes the travel domestic benefit group where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the travel domestic benefit group that was removed
	 */
	public TravelDomesticBenefitGroup
			removeBysearchTravelDomesticBenefitGroupCode(String code)
		throws NoSuchTravelDomesticBenefitGroupException;

	/**
	 * Returns the number of travel domestic benefit groups where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching travel domestic benefit groups
	 */
	public int countBysearchTravelDomesticBenefitGroupCode(String code);

	/**
	 * Caches the travel domestic benefit group in the entity cache if it is enabled.
	 *
	 * @param travelDomesticBenefitGroup the travel domestic benefit group
	 */
	public void cacheResult(
		TravelDomesticBenefitGroup travelDomesticBenefitGroup);

	/**
	 * Caches the travel domestic benefit groups in the entity cache if it is enabled.
	 *
	 * @param travelDomesticBenefitGroups the travel domestic benefit groups
	 */
	public void cacheResult(
		java.util.List<TravelDomesticBenefitGroup> travelDomesticBenefitGroups);

	/**
	 * Creates a new travel domestic benefit group with the primary key. Does not add the travel domestic benefit group to the database.
	 *
	 * @param travelDomesticBenefitGroupId the primary key for the new travel domestic benefit group
	 * @return the new travel domestic benefit group
	 */
	public TravelDomesticBenefitGroup create(long travelDomesticBenefitGroupId);

	/**
	 * Removes the travel domestic benefit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticBenefitGroupId the primary key of the travel domestic benefit group
	 * @return the travel domestic benefit group that was removed
	 * @throws NoSuchTravelDomesticBenefitGroupException if a travel domestic benefit group with the primary key could not be found
	 */
	public TravelDomesticBenefitGroup remove(long travelDomesticBenefitGroupId)
		throws NoSuchTravelDomesticBenefitGroupException;

	public TravelDomesticBenefitGroup updateImpl(
		TravelDomesticBenefitGroup travelDomesticBenefitGroup);

	/**
	 * Returns the travel domestic benefit group with the primary key or throws a <code>NoSuchTravelDomesticBenefitGroupException</code> if it could not be found.
	 *
	 * @param travelDomesticBenefitGroupId the primary key of the travel domestic benefit group
	 * @return the travel domestic benefit group
	 * @throws NoSuchTravelDomesticBenefitGroupException if a travel domestic benefit group with the primary key could not be found
	 */
	public TravelDomesticBenefitGroup findByPrimaryKey(
			long travelDomesticBenefitGroupId)
		throws NoSuchTravelDomesticBenefitGroupException;

	/**
	 * Returns the travel domestic benefit group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticBenefitGroupId the primary key of the travel domestic benefit group
	 * @return the travel domestic benefit group, or <code>null</code> if a travel domestic benefit group with the primary key could not be found
	 */
	public TravelDomesticBenefitGroup fetchByPrimaryKey(
		long travelDomesticBenefitGroupId);

	/**
	 * Returns all the travel domestic benefit groups.
	 *
	 * @return the travel domestic benefit groups
	 */
	public java.util.List<TravelDomesticBenefitGroup> findAll();

	/**
	 * Returns a range of all the travel domestic benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @return the range of travel domestic benefit groups
	 */
	public java.util.List<TravelDomesticBenefitGroup> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic benefit groups
	 */
	public java.util.List<TravelDomesticBenefitGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticBenefitGroup> orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic benefit groups
	 */
	public java.util.List<TravelDomesticBenefitGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticBenefitGroup> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the travel domestic benefit groups from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of travel domestic benefit groups.
	 *
	 * @return the number of travel domestic benefit groups
	 */
	public int countAll();

}