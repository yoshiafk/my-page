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

import com.mypage.admin.product.model.TravelDomesticRelationship;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the travel domestic relationship service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.TravelDomesticRelationshipPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticRelationshipPersistence
 * @generated
 */
public class TravelDomesticRelationshipUtil {

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
		TravelDomesticRelationship travelDomesticRelationship) {

		getPersistence().clearCache(travelDomesticRelationship);
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
	public static Map<Serializable, TravelDomesticRelationship>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TravelDomesticRelationship> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TravelDomesticRelationship> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TravelDomesticRelationship> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TravelDomesticRelationship> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TravelDomesticRelationship update(
		TravelDomesticRelationship travelDomesticRelationship) {

		return getPersistence().update(travelDomesticRelationship);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TravelDomesticRelationship update(
		TravelDomesticRelationship travelDomesticRelationship,
		ServiceContext serviceContext) {

		return getPersistence().update(
			travelDomesticRelationship, serviceContext);
	}

	/**
	 * Returns all the travel domestic relationships where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @return the matching travel domestic relationships
	 */
	public static List<TravelDomesticRelationship> findBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort) {

		return getPersistence().findBysearchInsuredType(
			travelDomesticRelationshipId, name, description, sort);
	}

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
	public static List<TravelDomesticRelationship> findBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort, int start, int end) {

		return getPersistence().findBysearchInsuredType(
			travelDomesticRelationshipId, name, description, sort, start, end);
	}

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
	public static List<TravelDomesticRelationship> findBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort, int start, int end,
		OrderByComparator<TravelDomesticRelationship> orderByComparator) {

		return getPersistence().findBysearchInsuredType(
			travelDomesticRelationshipId, name, description, sort, start, end,
			orderByComparator);
	}

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
	public static List<TravelDomesticRelationship> findBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort, int start, int end,
		OrderByComparator<TravelDomesticRelationship> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchInsuredType(
			travelDomesticRelationshipId, name, description, sort, start, end,
			orderByComparator, useFinderCache);
	}

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
	public static TravelDomesticRelationship findBysearchInsuredType_First(
			long travelDomesticRelationshipId, String name, String description,
			int sort,
			OrderByComparator<TravelDomesticRelationship> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticRelationshipException {

		return getPersistence().findBysearchInsuredType_First(
			travelDomesticRelationshipId, name, description, sort,
			orderByComparator);
	}

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
	public static TravelDomesticRelationship fetchBysearchInsuredType_First(
		long travelDomesticRelationshipId, String name, String description,
		int sort,
		OrderByComparator<TravelDomesticRelationship> orderByComparator) {

		return getPersistence().fetchBysearchInsuredType_First(
			travelDomesticRelationshipId, name, description, sort,
			orderByComparator);
	}

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
	public static TravelDomesticRelationship findBysearchInsuredType_Last(
			long travelDomesticRelationshipId, String name, String description,
			int sort,
			OrderByComparator<TravelDomesticRelationship> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticRelationshipException {

		return getPersistence().findBysearchInsuredType_Last(
			travelDomesticRelationshipId, name, description, sort,
			orderByComparator);
	}

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
	public static TravelDomesticRelationship fetchBysearchInsuredType_Last(
		long travelDomesticRelationshipId, String name, String description,
		int sort,
		OrderByComparator<TravelDomesticRelationship> orderByComparator) {

		return getPersistence().fetchBysearchInsuredType_Last(
			travelDomesticRelationshipId, name, description, sort,
			orderByComparator);
	}

	/**
	 * Removes all the travel domestic relationships where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63; from the database.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 */
	public static void removeBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort) {

		getPersistence().removeBysearchInsuredType(
			travelDomesticRelationshipId, name, description, sort);
	}

	/**
	 * Returns the number of travel domestic relationships where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @return the number of matching travel domestic relationships
	 */
	public static int countBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort) {

		return getPersistence().countBysearchInsuredType(
			travelDomesticRelationshipId, name, description, sort);
	}

	/**
	 * Caches the travel domestic relationship in the entity cache if it is enabled.
	 *
	 * @param travelDomesticRelationship the travel domestic relationship
	 */
	public static void cacheResult(
		TravelDomesticRelationship travelDomesticRelationship) {

		getPersistence().cacheResult(travelDomesticRelationship);
	}

	/**
	 * Caches the travel domestic relationships in the entity cache if it is enabled.
	 *
	 * @param travelDomesticRelationships the travel domestic relationships
	 */
	public static void cacheResult(
		List<TravelDomesticRelationship> travelDomesticRelationships) {

		getPersistence().cacheResult(travelDomesticRelationships);
	}

	/**
	 * Creates a new travel domestic relationship with the primary key. Does not add the travel domestic relationship to the database.
	 *
	 * @param travelDomesticRelationshipId the primary key for the new travel domestic relationship
	 * @return the new travel domestic relationship
	 */
	public static TravelDomesticRelationship create(
		long travelDomesticRelationshipId) {

		return getPersistence().create(travelDomesticRelationshipId);
	}

	/**
	 * Removes the travel domestic relationship with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticRelationshipId the primary key of the travel domestic relationship
	 * @return the travel domestic relationship that was removed
	 * @throws NoSuchTravelDomesticRelationshipException if a travel domestic relationship with the primary key could not be found
	 */
	public static TravelDomesticRelationship remove(
			long travelDomesticRelationshipId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticRelationshipException {

		return getPersistence().remove(travelDomesticRelationshipId);
	}

	public static TravelDomesticRelationship updateImpl(
		TravelDomesticRelationship travelDomesticRelationship) {

		return getPersistence().updateImpl(travelDomesticRelationship);
	}

	/**
	 * Returns the travel domestic relationship with the primary key or throws a <code>NoSuchTravelDomesticRelationshipException</code> if it could not be found.
	 *
	 * @param travelDomesticRelationshipId the primary key of the travel domestic relationship
	 * @return the travel domestic relationship
	 * @throws NoSuchTravelDomesticRelationshipException if a travel domestic relationship with the primary key could not be found
	 */
	public static TravelDomesticRelationship findByPrimaryKey(
			long travelDomesticRelationshipId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticRelationshipException {

		return getPersistence().findByPrimaryKey(travelDomesticRelationshipId);
	}

	/**
	 * Returns the travel domestic relationship with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticRelationshipId the primary key of the travel domestic relationship
	 * @return the travel domestic relationship, or <code>null</code> if a travel domestic relationship with the primary key could not be found
	 */
	public static TravelDomesticRelationship fetchByPrimaryKey(
		long travelDomesticRelationshipId) {

		return getPersistence().fetchByPrimaryKey(travelDomesticRelationshipId);
	}

	/**
	 * Returns all the travel domestic relationships.
	 *
	 * @return the travel domestic relationships
	 */
	public static List<TravelDomesticRelationship> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<TravelDomesticRelationship> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<TravelDomesticRelationship> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticRelationship> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<TravelDomesticRelationship> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticRelationship> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the travel domestic relationships from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of travel domestic relationships.
	 *
	 * @return the number of travel domestic relationships
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TravelDomesticRelationshipPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TravelDomesticRelationshipPersistence _persistence;

}