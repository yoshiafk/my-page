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

import com.mypage.admin.product.exception.NoSuchTravelDomesticRelationshipException;
import com.mypage.admin.product.model.TravelDomesticRelationship;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the travel domestic relationship service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticRelationshipUtil
 * @generated
 */
@ProviderType
public interface TravelDomesticRelationshipPersistence
	extends BasePersistence<TravelDomesticRelationship> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TravelDomesticRelationshipUtil} to access the travel domestic relationship persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the travel domestic relationships where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @return the matching travel domestic relationships
	 */
	public java.util.List<TravelDomesticRelationship> findBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort);

	/**
	 * Returns a range of all the travel domestic relationships where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticRelationshipModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @param start the lower bound of the range of travel domestic relationships
	 * @param end the upper bound of the range of travel domestic relationships (not inclusive)
	 * @return the range of matching travel domestic relationships
	 */
	public java.util.List<TravelDomesticRelationship> findBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort, int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic relationships where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticRelationshipModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @param start the lower bound of the range of travel domestic relationships
	 * @param end the upper bound of the range of travel domestic relationships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic relationships
	 */
	public java.util.List<TravelDomesticRelationship> findBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticRelationship> orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic relationships where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticRelationshipModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @param start the lower bound of the range of travel domestic relationships
	 * @param end the upper bound of the range of travel domestic relationships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic relationships
	 */
	public java.util.List<TravelDomesticRelationship> findBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticRelationship> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel domestic relationship in the ordered set where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic relationship
	 * @throws NoSuchTravelDomesticRelationshipException if a matching travel domestic relationship could not be found
	 */
	public TravelDomesticRelationship findBysearchInsuredType_First(
			long travelDomesticRelationshipId, String name, String description,
			int sort,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticRelationship> orderByComparator)
		throws NoSuchTravelDomesticRelationshipException;

	/**
	 * Returns the first travel domestic relationship in the ordered set where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic relationship, or <code>null</code> if a matching travel domestic relationship could not be found
	 */
	public TravelDomesticRelationship fetchBysearchInsuredType_First(
		long travelDomesticRelationshipId, String name, String description,
		int sort,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticRelationship> orderByComparator);

	/**
	 * Returns the last travel domestic relationship in the ordered set where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic relationship
	 * @throws NoSuchTravelDomesticRelationshipException if a matching travel domestic relationship could not be found
	 */
	public TravelDomesticRelationship findBysearchInsuredType_Last(
			long travelDomesticRelationshipId, String name, String description,
			int sort,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticRelationship> orderByComparator)
		throws NoSuchTravelDomesticRelationshipException;

	/**
	 * Returns the last travel domestic relationship in the ordered set where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic relationship, or <code>null</code> if a matching travel domestic relationship could not be found
	 */
	public TravelDomesticRelationship fetchBysearchInsuredType_Last(
		long travelDomesticRelationshipId, String name, String description,
		int sort,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticRelationship> orderByComparator);

	/**
	 * Removes all the travel domestic relationships where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63; from the database.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 */
	public void removeBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort);

	/**
	 * Returns the number of travel domestic relationships where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @return the number of matching travel domestic relationships
	 */
	public int countBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort);

	/**
	 * Caches the travel domestic relationship in the entity cache if it is enabled.
	 *
	 * @param travelDomesticRelationship the travel domestic relationship
	 */
	public void cacheResult(
		TravelDomesticRelationship travelDomesticRelationship);

	/**
	 * Caches the travel domestic relationships in the entity cache if it is enabled.
	 *
	 * @param travelDomesticRelationships the travel domestic relationships
	 */
	public void cacheResult(
		java.util.List<TravelDomesticRelationship> travelDomesticRelationships);

	/**
	 * Creates a new travel domestic relationship with the primary key. Does not add the travel domestic relationship to the database.
	 *
	 * @param travelDomesticRelationshipId the primary key for the new travel domestic relationship
	 * @return the new travel domestic relationship
	 */
	public TravelDomesticRelationship create(long travelDomesticRelationshipId);

	/**
	 * Removes the travel domestic relationship with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticRelationshipId the primary key of the travel domestic relationship
	 * @return the travel domestic relationship that was removed
	 * @throws NoSuchTravelDomesticRelationshipException if a travel domestic relationship with the primary key could not be found
	 */
	public TravelDomesticRelationship remove(long travelDomesticRelationshipId)
		throws NoSuchTravelDomesticRelationshipException;

	public TravelDomesticRelationship updateImpl(
		TravelDomesticRelationship travelDomesticRelationship);

	/**
	 * Returns the travel domestic relationship with the primary key or throws a <code>NoSuchTravelDomesticRelationshipException</code> if it could not be found.
	 *
	 * @param travelDomesticRelationshipId the primary key of the travel domestic relationship
	 * @return the travel domestic relationship
	 * @throws NoSuchTravelDomesticRelationshipException if a travel domestic relationship with the primary key could not be found
	 */
	public TravelDomesticRelationship findByPrimaryKey(
			long travelDomesticRelationshipId)
		throws NoSuchTravelDomesticRelationshipException;

	/**
	 * Returns the travel domestic relationship with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticRelationshipId the primary key of the travel domestic relationship
	 * @return the travel domestic relationship, or <code>null</code> if a travel domestic relationship with the primary key could not be found
	 */
	public TravelDomesticRelationship fetchByPrimaryKey(
		long travelDomesticRelationshipId);

	/**
	 * Returns all the travel domestic relationships.
	 *
	 * @return the travel domestic relationships
	 */
	public java.util.List<TravelDomesticRelationship> findAll();

	/**
	 * Returns a range of all the travel domestic relationships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticRelationshipModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic relationships
	 * @param end the upper bound of the range of travel domestic relationships (not inclusive)
	 * @return the range of travel domestic relationships
	 */
	public java.util.List<TravelDomesticRelationship> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic relationships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticRelationshipModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic relationships
	 * @param end the upper bound of the range of travel domestic relationships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic relationships
	 */
	public java.util.List<TravelDomesticRelationship> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticRelationship> orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic relationships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticRelationshipModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic relationships
	 * @param end the upper bound of the range of travel domestic relationships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic relationships
	 */
	public java.util.List<TravelDomesticRelationship> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<TravelDomesticRelationship> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the travel domestic relationships from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of travel domestic relationships.
	 *
	 * @return the number of travel domestic relationships
	 */
	public int countAll();

}