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

import com.mypage.admin.product.model.PetAnimalType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the pet animal type service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.PetAnimalTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PetAnimalTypePersistence
 * @generated
 */
public class PetAnimalTypeUtil {

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
	public static void clearCache(PetAnimalType petAnimalType) {
		getPersistence().clearCache(petAnimalType);
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
	public static Map<Serializable, PetAnimalType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PetAnimalType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PetAnimalType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PetAnimalType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PetAnimalType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PetAnimalType update(PetAnimalType petAnimalType) {
		return getPersistence().update(petAnimalType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PetAnimalType update(
		PetAnimalType petAnimalType, ServiceContext serviceContext) {

		return getPersistence().update(petAnimalType, serviceContext);
	}

	/**
	 * Returns all the pet animal types where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching pet animal types
	 */
	public static List<PetAnimalType> findByfindByName(String name) {
		return getPersistence().findByfindByName(name);
	}

	/**
	 * Returns a range of all the pet animal types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @return the range of matching pet animal types
	 */
	public static List<PetAnimalType> findByfindByName(
		String name, int start, int end) {

		return getPersistence().findByfindByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the pet animal types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet animal types
	 */
	public static List<PetAnimalType> findByfindByName(
		String name, int start, int end,
		OrderByComparator<PetAnimalType> orderByComparator) {

		return getPersistence().findByfindByName(
			name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet animal types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet animal types
	 */
	public static List<PetAnimalType> findByfindByName(
		String name, int start, int end,
		OrderByComparator<PetAnimalType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfindByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet animal type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet animal type
	 * @throws NoSuchPetAnimalTypeException if a matching pet animal type could not be found
	 */
	public static PetAnimalType findByfindByName_First(
			String name, OrderByComparator<PetAnimalType> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetAnimalTypeException {

		return getPersistence().findByfindByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first pet animal type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet animal type, or <code>null</code> if a matching pet animal type could not be found
	 */
	public static PetAnimalType fetchByfindByName_First(
		String name, OrderByComparator<PetAnimalType> orderByComparator) {

		return getPersistence().fetchByfindByName_First(
			name, orderByComparator);
	}

	/**
	 * Returns the last pet animal type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet animal type
	 * @throws NoSuchPetAnimalTypeException if a matching pet animal type could not be found
	 */
	public static PetAnimalType findByfindByName_Last(
			String name, OrderByComparator<PetAnimalType> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetAnimalTypeException {

		return getPersistence().findByfindByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last pet animal type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet animal type, or <code>null</code> if a matching pet animal type could not be found
	 */
	public static PetAnimalType fetchByfindByName_Last(
		String name, OrderByComparator<PetAnimalType> orderByComparator) {

		return getPersistence().fetchByfindByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the pet animal types before and after the current pet animal type in the ordered set where name = &#63;.
	 *
	 * @param petAnimalTypeId the primary key of the current pet animal type
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet animal type
	 * @throws NoSuchPetAnimalTypeException if a pet animal type with the primary key could not be found
	 */
	public static PetAnimalType[] findByfindByName_PrevAndNext(
			long petAnimalTypeId, String name,
			OrderByComparator<PetAnimalType> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetAnimalTypeException {

		return getPersistence().findByfindByName_PrevAndNext(
			petAnimalTypeId, name, orderByComparator);
	}

	/**
	 * Removes all the pet animal types where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByfindByName(String name) {
		getPersistence().removeByfindByName(name);
	}

	/**
	 * Returns the number of pet animal types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching pet animal types
	 */
	public static int countByfindByName(String name) {
		return getPersistence().countByfindByName(name);
	}

	/**
	 * Returns the pet animal type where petAnimalTypeId = &#63; or throws a <code>NoSuchPetAnimalTypeException</code> if it could not be found.
	 *
	 * @param petAnimalTypeId the pet animal type ID
	 * @return the matching pet animal type
	 * @throws NoSuchPetAnimalTypeException if a matching pet animal type could not be found
	 */
	public static PetAnimalType findBysearchPetAnimalTypeId(
			long petAnimalTypeId)
		throws com.mypage.admin.product.exception.NoSuchPetAnimalTypeException {

		return getPersistence().findBysearchPetAnimalTypeId(petAnimalTypeId);
	}

	/**
	 * Returns the pet animal type where petAnimalTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param petAnimalTypeId the pet animal type ID
	 * @return the matching pet animal type, or <code>null</code> if a matching pet animal type could not be found
	 */
	public static PetAnimalType fetchBysearchPetAnimalTypeId(
		long petAnimalTypeId) {

		return getPersistence().fetchBysearchPetAnimalTypeId(petAnimalTypeId);
	}

	/**
	 * Returns the pet animal type where petAnimalTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param petAnimalTypeId the pet animal type ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet animal type, or <code>null</code> if a matching pet animal type could not be found
	 */
	public static PetAnimalType fetchBysearchPetAnimalTypeId(
		long petAnimalTypeId, boolean useFinderCache) {

		return getPersistence().fetchBysearchPetAnimalTypeId(
			petAnimalTypeId, useFinderCache);
	}

	/**
	 * Removes the pet animal type where petAnimalTypeId = &#63; from the database.
	 *
	 * @param petAnimalTypeId the pet animal type ID
	 * @return the pet animal type that was removed
	 */
	public static PetAnimalType removeBysearchPetAnimalTypeId(
			long petAnimalTypeId)
		throws com.mypage.admin.product.exception.NoSuchPetAnimalTypeException {

		return getPersistence().removeBysearchPetAnimalTypeId(petAnimalTypeId);
	}

	/**
	 * Returns the number of pet animal types where petAnimalTypeId = &#63;.
	 *
	 * @param petAnimalTypeId the pet animal type ID
	 * @return the number of matching pet animal types
	 */
	public static int countBysearchPetAnimalTypeId(long petAnimalTypeId) {
		return getPersistence().countBysearchPetAnimalTypeId(petAnimalTypeId);
	}

	/**
	 * Caches the pet animal type in the entity cache if it is enabled.
	 *
	 * @param petAnimalType the pet animal type
	 */
	public static void cacheResult(PetAnimalType petAnimalType) {
		getPersistence().cacheResult(petAnimalType);
	}

	/**
	 * Caches the pet animal types in the entity cache if it is enabled.
	 *
	 * @param petAnimalTypes the pet animal types
	 */
	public static void cacheResult(List<PetAnimalType> petAnimalTypes) {
		getPersistence().cacheResult(petAnimalTypes);
	}

	/**
	 * Creates a new pet animal type with the primary key. Does not add the pet animal type to the database.
	 *
	 * @param petAnimalTypeId the primary key for the new pet animal type
	 * @return the new pet animal type
	 */
	public static PetAnimalType create(long petAnimalTypeId) {
		return getPersistence().create(petAnimalTypeId);
	}

	/**
	 * Removes the pet animal type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petAnimalTypeId the primary key of the pet animal type
	 * @return the pet animal type that was removed
	 * @throws NoSuchPetAnimalTypeException if a pet animal type with the primary key could not be found
	 */
	public static PetAnimalType remove(long petAnimalTypeId)
		throws com.mypage.admin.product.exception.NoSuchPetAnimalTypeException {

		return getPersistence().remove(petAnimalTypeId);
	}

	public static PetAnimalType updateImpl(PetAnimalType petAnimalType) {
		return getPersistence().updateImpl(petAnimalType);
	}

	/**
	 * Returns the pet animal type with the primary key or throws a <code>NoSuchPetAnimalTypeException</code> if it could not be found.
	 *
	 * @param petAnimalTypeId the primary key of the pet animal type
	 * @return the pet animal type
	 * @throws NoSuchPetAnimalTypeException if a pet animal type with the primary key could not be found
	 */
	public static PetAnimalType findByPrimaryKey(long petAnimalTypeId)
		throws com.mypage.admin.product.exception.NoSuchPetAnimalTypeException {

		return getPersistence().findByPrimaryKey(petAnimalTypeId);
	}

	/**
	 * Returns the pet animal type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petAnimalTypeId the primary key of the pet animal type
	 * @return the pet animal type, or <code>null</code> if a pet animal type with the primary key could not be found
	 */
	public static PetAnimalType fetchByPrimaryKey(long petAnimalTypeId) {
		return getPersistence().fetchByPrimaryKey(petAnimalTypeId);
	}

	/**
	 * Returns all the pet animal types.
	 *
	 * @return the pet animal types
	 */
	public static List<PetAnimalType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pet animal types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @return the range of pet animal types
	 */
	public static List<PetAnimalType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pet animal types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pet animal types
	 */
	public static List<PetAnimalType> findAll(
		int start, int end,
		OrderByComparator<PetAnimalType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet animal types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pet animal types
	 */
	public static List<PetAnimalType> findAll(
		int start, int end, OrderByComparator<PetAnimalType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pet animal types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pet animal types.
	 *
	 * @return the number of pet animal types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PetAnimalTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile PetAnimalTypePersistence _persistence;

}