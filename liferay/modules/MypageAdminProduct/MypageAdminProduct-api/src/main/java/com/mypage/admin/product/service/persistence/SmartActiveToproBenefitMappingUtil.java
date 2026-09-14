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

import com.mypage.admin.product.model.SmartActiveToproBenefitMapping;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the smart active topro benefit mapping service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.SmartActiveToproBenefitMappingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveToproBenefitMappingPersistence
 * @generated
 */
public class SmartActiveToproBenefitMappingUtil {

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
		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping) {

		getPersistence().clearCache(smartActiveToproBenefitMapping);
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
	public static Map<Serializable, SmartActiveToproBenefitMapping>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SmartActiveToproBenefitMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SmartActiveToproBenefitMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SmartActiveToproBenefitMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SmartActiveToproBenefitMapping update(
		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping) {

		return getPersistence().update(smartActiveToproBenefitMapping);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SmartActiveToproBenefitMapping update(
		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping,
		ServiceContext serviceContext) {

		return getPersistence().update(
			smartActiveToproBenefitMapping, serviceContext);
	}

	/**
	 * Returns all the smart active topro benefit mappings where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @return the matching smart active topro benefit mappings
	 */
	public static List<SmartActiveToproBenefitMapping> findByToproId(
		long smartActiveToproId) {

		return getPersistence().findByToproId(smartActiveToproId);
	}

	/**
	 * Returns a range of all the smart active topro benefit mappings where smartActiveToproId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @return the range of matching smart active topro benefit mappings
	 */
	public static List<SmartActiveToproBenefitMapping> findByToproId(
		long smartActiveToproId, int start, int end) {

		return getPersistence().findByToproId(smartActiveToproId, start, end);
	}

	/**
	 * Returns an ordered range of all the smart active topro benefit mappings where smartActiveToproId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smart active topro benefit mappings
	 */
	public static List<SmartActiveToproBenefitMapping> findByToproId(
		long smartActiveToproId, int start, int end,
		OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator) {

		return getPersistence().findByToproId(
			smartActiveToproId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart active topro benefit mappings where smartActiveToproId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smart active topro benefit mappings
	 */
	public static List<SmartActiveToproBenefitMapping> findByToproId(
		long smartActiveToproId, int start, int end,
		OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByToproId(
			smartActiveToproId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first smart active topro benefit mapping in the ordered set where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart active topro benefit mapping
	 * @throws NoSuchSmartActiveToproBenefitMappingException if a matching smart active topro benefit mapping could not be found
	 */
	public static SmartActiveToproBenefitMapping findByToproId_First(
			long smartActiveToproId,
			OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveToproBenefitMappingException {

		return getPersistence().findByToproId_First(
			smartActiveToproId, orderByComparator);
	}

	/**
	 * Returns the first smart active topro benefit mapping in the ordered set where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart active topro benefit mapping, or <code>null</code> if a matching smart active topro benefit mapping could not be found
	 */
	public static SmartActiveToproBenefitMapping fetchByToproId_First(
		long smartActiveToproId,
		OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator) {

		return getPersistence().fetchByToproId_First(
			smartActiveToproId, orderByComparator);
	}

	/**
	 * Returns the last smart active topro benefit mapping in the ordered set where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart active topro benefit mapping
	 * @throws NoSuchSmartActiveToproBenefitMappingException if a matching smart active topro benefit mapping could not be found
	 */
	public static SmartActiveToproBenefitMapping findByToproId_Last(
			long smartActiveToproId,
			OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveToproBenefitMappingException {

		return getPersistence().findByToproId_Last(
			smartActiveToproId, orderByComparator);
	}

	/**
	 * Returns the last smart active topro benefit mapping in the ordered set where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart active topro benefit mapping, or <code>null</code> if a matching smart active topro benefit mapping could not be found
	 */
	public static SmartActiveToproBenefitMapping fetchByToproId_Last(
		long smartActiveToproId,
		OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator) {

		return getPersistence().fetchByToproId_Last(
			smartActiveToproId, orderByComparator);
	}

	/**
	 * Returns the smart active topro benefit mappings before and after the current smart active topro benefit mapping in the ordered set where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproBenefitMappingId the primary key of the current smart active topro benefit mapping
	 * @param smartActiveToproId the smart active topro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next smart active topro benefit mapping
	 * @throws NoSuchSmartActiveToproBenefitMappingException if a smart active topro benefit mapping with the primary key could not be found
	 */
	public static SmartActiveToproBenefitMapping[] findByToproId_PrevAndNext(
			long smartActiveToproBenefitMappingId, long smartActiveToproId,
			OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveToproBenefitMappingException {

		return getPersistence().findByToproId_PrevAndNext(
			smartActiveToproBenefitMappingId, smartActiveToproId,
			orderByComparator);
	}

	/**
	 * Removes all the smart active topro benefit mappings where smartActiveToproId = &#63; from the database.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 */
	public static void removeByToproId(long smartActiveToproId) {
		getPersistence().removeByToproId(smartActiveToproId);
	}

	/**
	 * Returns the number of smart active topro benefit mappings where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @return the number of matching smart active topro benefit mappings
	 */
	public static int countByToproId(long smartActiveToproId) {
		return getPersistence().countByToproId(smartActiveToproId);
	}

	/**
	 * Caches the smart active topro benefit mapping in the entity cache if it is enabled.
	 *
	 * @param smartActiveToproBenefitMapping the smart active topro benefit mapping
	 */
	public static void cacheResult(
		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping) {

		getPersistence().cacheResult(smartActiveToproBenefitMapping);
	}

	/**
	 * Caches the smart active topro benefit mappings in the entity cache if it is enabled.
	 *
	 * @param smartActiveToproBenefitMappings the smart active topro benefit mappings
	 */
	public static void cacheResult(
		List<SmartActiveToproBenefitMapping> smartActiveToproBenefitMappings) {

		getPersistence().cacheResult(smartActiveToproBenefitMappings);
	}

	/**
	 * Creates a new smart active topro benefit mapping with the primary key. Does not add the smart active topro benefit mapping to the database.
	 *
	 * @param smartActiveToproBenefitMappingId the primary key for the new smart active topro benefit mapping
	 * @return the new smart active topro benefit mapping
	 */
	public static SmartActiveToproBenefitMapping create(
		long smartActiveToproBenefitMappingId) {

		return getPersistence().create(smartActiveToproBenefitMappingId);
	}

	/**
	 * Removes the smart active topro benefit mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveToproBenefitMappingId the primary key of the smart active topro benefit mapping
	 * @return the smart active topro benefit mapping that was removed
	 * @throws NoSuchSmartActiveToproBenefitMappingException if a smart active topro benefit mapping with the primary key could not be found
	 */
	public static SmartActiveToproBenefitMapping remove(
			long smartActiveToproBenefitMappingId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveToproBenefitMappingException {

		return getPersistence().remove(smartActiveToproBenefitMappingId);
	}

	public static SmartActiveToproBenefitMapping updateImpl(
		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping) {

		return getPersistence().updateImpl(smartActiveToproBenefitMapping);
	}

	/**
	 * Returns the smart active topro benefit mapping with the primary key or throws a <code>NoSuchSmartActiveToproBenefitMappingException</code> if it could not be found.
	 *
	 * @param smartActiveToproBenefitMappingId the primary key of the smart active topro benefit mapping
	 * @return the smart active topro benefit mapping
	 * @throws NoSuchSmartActiveToproBenefitMappingException if a smart active topro benefit mapping with the primary key could not be found
	 */
	public static SmartActiveToproBenefitMapping findByPrimaryKey(
			long smartActiveToproBenefitMappingId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveToproBenefitMappingException {

		return getPersistence().findByPrimaryKey(
			smartActiveToproBenefitMappingId);
	}

	/**
	 * Returns the smart active topro benefit mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveToproBenefitMappingId the primary key of the smart active topro benefit mapping
	 * @return the smart active topro benefit mapping, or <code>null</code> if a smart active topro benefit mapping with the primary key could not be found
	 */
	public static SmartActiveToproBenefitMapping fetchByPrimaryKey(
		long smartActiveToproBenefitMappingId) {

		return getPersistence().fetchByPrimaryKey(
			smartActiveToproBenefitMappingId);
	}

	/**
	 * Returns all the smart active topro benefit mappings.
	 *
	 * @return the smart active topro benefit mappings
	 */
	public static List<SmartActiveToproBenefitMapping> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the smart active topro benefit mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @return the range of smart active topro benefit mappings
	 */
	public static List<SmartActiveToproBenefitMapping> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the smart active topro benefit mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active topro benefit mappings
	 */
	public static List<SmartActiveToproBenefitMapping> findAll(
		int start, int end,
		OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart active topro benefit mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active topro benefit mappings
	 */
	public static List<SmartActiveToproBenefitMapping> findAll(
		int start, int end,
		OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the smart active topro benefit mappings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of smart active topro benefit mappings.
	 *
	 * @return the number of smart active topro benefit mappings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SmartActiveToproBenefitMappingPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SmartActiveToproBenefitMappingPersistence
		_persistence;

}