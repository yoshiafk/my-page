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

import com.mypage.admin.product.model.PetDetail;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the pet detail service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.PetDetailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PetDetailPersistence
 * @generated
 */
public class PetDetailUtil {

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
	public static void clearCache(PetDetail petDetail) {
		getPersistence().clearCache(petDetail);
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
	public static Map<Serializable, PetDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PetDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PetDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PetDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PetDetail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PetDetail update(PetDetail petDetail) {
		return getPersistence().update(petDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PetDetail update(
		PetDetail petDetail, ServiceContext serviceContext) {

		return getPersistence().update(petDetail, serviceContext);
	}

	/**
	 * Caches the pet detail in the entity cache if it is enabled.
	 *
	 * @param petDetail the pet detail
	 */
	public static void cacheResult(PetDetail petDetail) {
		getPersistence().cacheResult(petDetail);
	}

	/**
	 * Caches the pet details in the entity cache if it is enabled.
	 *
	 * @param petDetails the pet details
	 */
	public static void cacheResult(List<PetDetail> petDetails) {
		getPersistence().cacheResult(petDetails);
	}

	/**
	 * Creates a new pet detail with the primary key. Does not add the pet detail to the database.
	 *
	 * @param petDetailId the primary key for the new pet detail
	 * @return the new pet detail
	 */
	public static PetDetail create(long petDetailId) {
		return getPersistence().create(petDetailId);
	}

	/**
	 * Removes the pet detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petDetailId the primary key of the pet detail
	 * @return the pet detail that was removed
	 * @throws NoSuchPetDetailException if a pet detail with the primary key could not be found
	 */
	public static PetDetail remove(long petDetailId)
		throws com.mypage.admin.product.exception.NoSuchPetDetailException {

		return getPersistence().remove(petDetailId);
	}

	public static PetDetail updateImpl(PetDetail petDetail) {
		return getPersistence().updateImpl(petDetail);
	}

	/**
	 * Returns the pet detail with the primary key or throws a <code>NoSuchPetDetailException</code> if it could not be found.
	 *
	 * @param petDetailId the primary key of the pet detail
	 * @return the pet detail
	 * @throws NoSuchPetDetailException if a pet detail with the primary key could not be found
	 */
	public static PetDetail findByPrimaryKey(long petDetailId)
		throws com.mypage.admin.product.exception.NoSuchPetDetailException {

		return getPersistence().findByPrimaryKey(petDetailId);
	}

	/**
	 * Returns the pet detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petDetailId the primary key of the pet detail
	 * @return the pet detail, or <code>null</code> if a pet detail with the primary key could not be found
	 */
	public static PetDetail fetchByPrimaryKey(long petDetailId) {
		return getPersistence().fetchByPrimaryKey(petDetailId);
	}

	/**
	 * Returns all the pet details.
	 *
	 * @return the pet details
	 */
	public static List<PetDetail> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pet details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet details
	 * @param end the upper bound of the range of pet details (not inclusive)
	 * @return the range of pet details
	 */
	public static List<PetDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pet details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet details
	 * @param end the upper bound of the range of pet details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pet details
	 */
	public static List<PetDetail> findAll(
		int start, int end, OrderByComparator<PetDetail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet details
	 * @param end the upper bound of the range of pet details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pet details
	 */
	public static List<PetDetail> findAll(
		int start, int end, OrderByComparator<PetDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pet details from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pet details.
	 *
	 * @return the number of pet details
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PetDetailPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PetDetailPersistence _persistence;

}