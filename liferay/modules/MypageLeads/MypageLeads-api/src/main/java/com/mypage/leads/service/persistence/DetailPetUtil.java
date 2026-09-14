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

package com.mypage.leads.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.leads.model.DetailPet;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the detail pet service. This utility wraps <code>com.mypage.leads.service.persistence.impl.DetailPetPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see DetailPetPersistence
 * @generated
 */
public class DetailPetUtil {

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
	public static void clearCache(DetailPet detailPet) {
		getPersistence().clearCache(detailPet);
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
	public static Map<Serializable, DetailPet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DetailPet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DetailPet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DetailPet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DetailPet> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DetailPet update(DetailPet detailPet) {
		return getPersistence().update(detailPet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DetailPet update(
		DetailPet detailPet, ServiceContext serviceContext) {

		return getPersistence().update(detailPet, serviceContext);
	}

	/**
	 * Returns the detail pet where LeadsId = &#63; or throws a <code>NoSuchDetailPetException</code> if it could not be found.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail pet
	 * @throws NoSuchDetailPetException if a matching detail pet could not be found
	 */
	public static DetailPet findBysearchByLeadsId(long LeadsId)
		throws com.mypage.leads.exception.NoSuchDetailPetException {

		return getPersistence().findBysearchByLeadsId(LeadsId);
	}

	/**
	 * Returns the detail pet where LeadsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail pet, or <code>null</code> if a matching detail pet could not be found
	 */
	public static DetailPet fetchBysearchByLeadsId(long LeadsId) {
		return getPersistence().fetchBysearchByLeadsId(LeadsId);
	}

	/**
	 * Returns the detail pet where LeadsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching detail pet, or <code>null</code> if a matching detail pet could not be found
	 */
	public static DetailPet fetchBysearchByLeadsId(
		long LeadsId, boolean useFinderCache) {

		return getPersistence().fetchBysearchByLeadsId(LeadsId, useFinderCache);
	}

	/**
	 * Removes the detail pet where LeadsId = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 * @return the detail pet that was removed
	 */
	public static DetailPet removeBysearchByLeadsId(long LeadsId)
		throws com.mypage.leads.exception.NoSuchDetailPetException {

		return getPersistence().removeBysearchByLeadsId(LeadsId);
	}

	/**
	 * Returns the number of detail pets where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the number of matching detail pets
	 */
	public static int countBysearchByLeadsId(long LeadsId) {
		return getPersistence().countBysearchByLeadsId(LeadsId);
	}

	/**
	 * Caches the detail pet in the entity cache if it is enabled.
	 *
	 * @param detailPet the detail pet
	 */
	public static void cacheResult(DetailPet detailPet) {
		getPersistence().cacheResult(detailPet);
	}

	/**
	 * Caches the detail pets in the entity cache if it is enabled.
	 *
	 * @param detailPets the detail pets
	 */
	public static void cacheResult(List<DetailPet> detailPets) {
		getPersistence().cacheResult(detailPets);
	}

	/**
	 * Creates a new detail pet with the primary key. Does not add the detail pet to the database.
	 *
	 * @param detailPetId the primary key for the new detail pet
	 * @return the new detail pet
	 */
	public static DetailPet create(long detailPetId) {
		return getPersistence().create(detailPetId);
	}

	/**
	 * Removes the detail pet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param detailPetId the primary key of the detail pet
	 * @return the detail pet that was removed
	 * @throws NoSuchDetailPetException if a detail pet with the primary key could not be found
	 */
	public static DetailPet remove(long detailPetId)
		throws com.mypage.leads.exception.NoSuchDetailPetException {

		return getPersistence().remove(detailPetId);
	}

	public static DetailPet updateImpl(DetailPet detailPet) {
		return getPersistence().updateImpl(detailPet);
	}

	/**
	 * Returns the detail pet with the primary key or throws a <code>NoSuchDetailPetException</code> if it could not be found.
	 *
	 * @param detailPetId the primary key of the detail pet
	 * @return the detail pet
	 * @throws NoSuchDetailPetException if a detail pet with the primary key could not be found
	 */
	public static DetailPet findByPrimaryKey(long detailPetId)
		throws com.mypage.leads.exception.NoSuchDetailPetException {

		return getPersistence().findByPrimaryKey(detailPetId);
	}

	/**
	 * Returns the detail pet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param detailPetId the primary key of the detail pet
	 * @return the detail pet, or <code>null</code> if a detail pet with the primary key could not be found
	 */
	public static DetailPet fetchByPrimaryKey(long detailPetId) {
		return getPersistence().fetchByPrimaryKey(detailPetId);
	}

	/**
	 * Returns all the detail pets.
	 *
	 * @return the detail pets
	 */
	public static List<DetailPet> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the detail pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailPetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail pets
	 * @param end the upper bound of the range of detail pets (not inclusive)
	 * @return the range of detail pets
	 */
	public static List<DetailPet> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the detail pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailPetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail pets
	 * @param end the upper bound of the range of detail pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail pets
	 */
	public static List<DetailPet> findAll(
		int start, int end, OrderByComparator<DetailPet> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the detail pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailPetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail pets
	 * @param end the upper bound of the range of detail pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail pets
	 */
	public static List<DetailPet> findAll(
		int start, int end, OrderByComparator<DetailPet> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the detail pets from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of detail pets.
	 *
	 * @return the number of detail pets
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DetailPetPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DetailPetPersistence _persistence;

}