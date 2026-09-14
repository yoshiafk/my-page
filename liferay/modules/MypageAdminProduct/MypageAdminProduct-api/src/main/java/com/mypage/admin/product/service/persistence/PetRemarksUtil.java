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

import com.mypage.admin.product.model.PetRemarks;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the pet remarks service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.PetRemarksPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PetRemarksPersistence
 * @generated
 */
public class PetRemarksUtil {

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
	public static void clearCache(PetRemarks petRemarks) {
		getPersistence().clearCache(petRemarks);
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
	public static Map<Serializable, PetRemarks> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PetRemarks> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PetRemarks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PetRemarks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PetRemarks> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PetRemarks update(PetRemarks petRemarks) {
		return getPersistence().update(petRemarks);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PetRemarks update(
		PetRemarks petRemarks, ServiceContext serviceContext) {

		return getPersistence().update(petRemarks, serviceContext);
	}

	/**
	 * Returns all the pet remarkses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching pet remarkses
	 */
	public static List<PetRemarks> findByfindByName(String name) {
		return getPersistence().findByfindByName(name);
	}

	/**
	 * Returns a range of all the pet remarkses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @return the range of matching pet remarkses
	 */
	public static List<PetRemarks> findByfindByName(
		String name, int start, int end) {

		return getPersistence().findByfindByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the pet remarkses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet remarkses
	 */
	public static List<PetRemarks> findByfindByName(
		String name, int start, int end,
		OrderByComparator<PetRemarks> orderByComparator) {

		return getPersistence().findByfindByName(
			name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet remarkses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet remarkses
	 */
	public static List<PetRemarks> findByfindByName(
		String name, int start, int end,
		OrderByComparator<PetRemarks> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfindByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet remarks in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet remarks
	 * @throws NoSuchPetRemarksException if a matching pet remarks could not be found
	 */
	public static PetRemarks findByfindByName_First(
			String name, OrderByComparator<PetRemarks> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetRemarksException {

		return getPersistence().findByfindByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first pet remarks in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet remarks, or <code>null</code> if a matching pet remarks could not be found
	 */
	public static PetRemarks fetchByfindByName_First(
		String name, OrderByComparator<PetRemarks> orderByComparator) {

		return getPersistence().fetchByfindByName_First(
			name, orderByComparator);
	}

	/**
	 * Returns the last pet remarks in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet remarks
	 * @throws NoSuchPetRemarksException if a matching pet remarks could not be found
	 */
	public static PetRemarks findByfindByName_Last(
			String name, OrderByComparator<PetRemarks> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetRemarksException {

		return getPersistence().findByfindByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last pet remarks in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet remarks, or <code>null</code> if a matching pet remarks could not be found
	 */
	public static PetRemarks fetchByfindByName_Last(
		String name, OrderByComparator<PetRemarks> orderByComparator) {

		return getPersistence().fetchByfindByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the pet remarkses before and after the current pet remarks in the ordered set where name = &#63;.
	 *
	 * @param petRemarksId the primary key of the current pet remarks
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet remarks
	 * @throws NoSuchPetRemarksException if a pet remarks with the primary key could not be found
	 */
	public static PetRemarks[] findByfindByName_PrevAndNext(
			long petRemarksId, String name,
			OrderByComparator<PetRemarks> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetRemarksException {

		return getPersistence().findByfindByName_PrevAndNext(
			petRemarksId, name, orderByComparator);
	}

	/**
	 * Removes all the pet remarkses where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByfindByName(String name) {
		getPersistence().removeByfindByName(name);
	}

	/**
	 * Returns the number of pet remarkses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching pet remarkses
	 */
	public static int countByfindByName(String name) {
		return getPersistence().countByfindByName(name);
	}

	/**
	 * Caches the pet remarks in the entity cache if it is enabled.
	 *
	 * @param petRemarks the pet remarks
	 */
	public static void cacheResult(PetRemarks petRemarks) {
		getPersistence().cacheResult(petRemarks);
	}

	/**
	 * Caches the pet remarkses in the entity cache if it is enabled.
	 *
	 * @param petRemarkses the pet remarkses
	 */
	public static void cacheResult(List<PetRemarks> petRemarkses) {
		getPersistence().cacheResult(petRemarkses);
	}

	/**
	 * Creates a new pet remarks with the primary key. Does not add the pet remarks to the database.
	 *
	 * @param petRemarksId the primary key for the new pet remarks
	 * @return the new pet remarks
	 */
	public static PetRemarks create(long petRemarksId) {
		return getPersistence().create(petRemarksId);
	}

	/**
	 * Removes the pet remarks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petRemarksId the primary key of the pet remarks
	 * @return the pet remarks that was removed
	 * @throws NoSuchPetRemarksException if a pet remarks with the primary key could not be found
	 */
	public static PetRemarks remove(long petRemarksId)
		throws com.mypage.admin.product.exception.NoSuchPetRemarksException {

		return getPersistence().remove(petRemarksId);
	}

	public static PetRemarks updateImpl(PetRemarks petRemarks) {
		return getPersistence().updateImpl(petRemarks);
	}

	/**
	 * Returns the pet remarks with the primary key or throws a <code>NoSuchPetRemarksException</code> if it could not be found.
	 *
	 * @param petRemarksId the primary key of the pet remarks
	 * @return the pet remarks
	 * @throws NoSuchPetRemarksException if a pet remarks with the primary key could not be found
	 */
	public static PetRemarks findByPrimaryKey(long petRemarksId)
		throws com.mypage.admin.product.exception.NoSuchPetRemarksException {

		return getPersistence().findByPrimaryKey(petRemarksId);
	}

	/**
	 * Returns the pet remarks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petRemarksId the primary key of the pet remarks
	 * @return the pet remarks, or <code>null</code> if a pet remarks with the primary key could not be found
	 */
	public static PetRemarks fetchByPrimaryKey(long petRemarksId) {
		return getPersistence().fetchByPrimaryKey(petRemarksId);
	}

	/**
	 * Returns all the pet remarkses.
	 *
	 * @return the pet remarkses
	 */
	public static List<PetRemarks> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pet remarkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @return the range of pet remarkses
	 */
	public static List<PetRemarks> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pet remarkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pet remarkses
	 */
	public static List<PetRemarks> findAll(
		int start, int end, OrderByComparator<PetRemarks> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet remarkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pet remarkses
	 */
	public static List<PetRemarks> findAll(
		int start, int end, OrderByComparator<PetRemarks> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pet remarkses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pet remarkses.
	 *
	 * @return the number of pet remarkses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PetRemarksPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PetRemarksPersistence _persistence;

}