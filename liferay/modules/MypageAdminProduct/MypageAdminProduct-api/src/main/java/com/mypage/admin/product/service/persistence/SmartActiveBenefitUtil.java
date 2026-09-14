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

import com.mypage.admin.product.model.SmartActiveBenefit;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the smart active benefit service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.SmartActiveBenefitPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveBenefitPersistence
 * @generated
 */
public class SmartActiveBenefitUtil {

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
	public static void clearCache(SmartActiveBenefit smartActiveBenefit) {
		getPersistence().clearCache(smartActiveBenefit);
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
	public static Map<Serializable, SmartActiveBenefit> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SmartActiveBenefit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SmartActiveBenefit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SmartActiveBenefit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SmartActiveBenefit> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SmartActiveBenefit update(
		SmartActiveBenefit smartActiveBenefit) {

		return getPersistence().update(smartActiveBenefit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SmartActiveBenefit update(
		SmartActiveBenefit smartActiveBenefit, ServiceContext serviceContext) {

		return getPersistence().update(smartActiveBenefit, serviceContext);
	}

	/**
	 * Returns all the smart active benefits where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @return the matching smart active benefits
	 */
	public static List<SmartActiveBenefit> findByBenefitTypeId(
		long smartActiveBenefitTypeId) {

		return getPersistence().findByBenefitTypeId(smartActiveBenefitTypeId);
	}

	/**
	 * Returns a range of all the smart active benefits where smartActiveBenefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @return the range of matching smart active benefits
	 */
	public static List<SmartActiveBenefit> findByBenefitTypeId(
		long smartActiveBenefitTypeId, int start, int end) {

		return getPersistence().findByBenefitTypeId(
			smartActiveBenefitTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the smart active benefits where smartActiveBenefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smart active benefits
	 */
	public static List<SmartActiveBenefit> findByBenefitTypeId(
		long smartActiveBenefitTypeId, int start, int end,
		OrderByComparator<SmartActiveBenefit> orderByComparator) {

		return getPersistence().findByBenefitTypeId(
			smartActiveBenefitTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart active benefits where smartActiveBenefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smart active benefits
	 */
	public static List<SmartActiveBenefit> findByBenefitTypeId(
		long smartActiveBenefitTypeId, int start, int end,
		OrderByComparator<SmartActiveBenefit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByBenefitTypeId(
			smartActiveBenefitTypeId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first smart active benefit in the ordered set where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart active benefit
	 * @throws NoSuchSmartActiveBenefitException if a matching smart active benefit could not be found
	 */
	public static SmartActiveBenefit findByBenefitTypeId_First(
			long smartActiveBenefitTypeId,
			OrderByComparator<SmartActiveBenefit> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveBenefitException {

		return getPersistence().findByBenefitTypeId_First(
			smartActiveBenefitTypeId, orderByComparator);
	}

	/**
	 * Returns the first smart active benefit in the ordered set where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart active benefit, or <code>null</code> if a matching smart active benefit could not be found
	 */
	public static SmartActiveBenefit fetchByBenefitTypeId_First(
		long smartActiveBenefitTypeId,
		OrderByComparator<SmartActiveBenefit> orderByComparator) {

		return getPersistence().fetchByBenefitTypeId_First(
			smartActiveBenefitTypeId, orderByComparator);
	}

	/**
	 * Returns the last smart active benefit in the ordered set where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart active benefit
	 * @throws NoSuchSmartActiveBenefitException if a matching smart active benefit could not be found
	 */
	public static SmartActiveBenefit findByBenefitTypeId_Last(
			long smartActiveBenefitTypeId,
			OrderByComparator<SmartActiveBenefit> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveBenefitException {

		return getPersistence().findByBenefitTypeId_Last(
			smartActiveBenefitTypeId, orderByComparator);
	}

	/**
	 * Returns the last smart active benefit in the ordered set where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart active benefit, or <code>null</code> if a matching smart active benefit could not be found
	 */
	public static SmartActiveBenefit fetchByBenefitTypeId_Last(
		long smartActiveBenefitTypeId,
		OrderByComparator<SmartActiveBenefit> orderByComparator) {

		return getPersistence().fetchByBenefitTypeId_Last(
			smartActiveBenefitTypeId, orderByComparator);
	}

	/**
	 * Returns the smart active benefits before and after the current smart active benefit in the ordered set where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitId the primary key of the current smart active benefit
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next smart active benefit
	 * @throws NoSuchSmartActiveBenefitException if a smart active benefit with the primary key could not be found
	 */
	public static SmartActiveBenefit[] findByBenefitTypeId_PrevAndNext(
			long smartActiveBenefitId, long smartActiveBenefitTypeId,
			OrderByComparator<SmartActiveBenefit> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveBenefitException {

		return getPersistence().findByBenefitTypeId_PrevAndNext(
			smartActiveBenefitId, smartActiveBenefitTypeId, orderByComparator);
	}

	/**
	 * Removes all the smart active benefits where smartActiveBenefitTypeId = &#63; from the database.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 */
	public static void removeByBenefitTypeId(long smartActiveBenefitTypeId) {
		getPersistence().removeByBenefitTypeId(smartActiveBenefitTypeId);
	}

	/**
	 * Returns the number of smart active benefits where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @return the number of matching smart active benefits
	 */
	public static int countByBenefitTypeId(long smartActiveBenefitTypeId) {
		return getPersistence().countByBenefitTypeId(smartActiveBenefitTypeId);
	}

	/**
	 * Returns the smart active benefit where externalCode = &#63; or throws a <code>NoSuchSmartActiveBenefitException</code> if it could not be found.
	 *
	 * @param externalCode the external code
	 * @return the matching smart active benefit
	 * @throws NoSuchSmartActiveBenefitException if a matching smart active benefit could not be found
	 */
	public static SmartActiveBenefit findByExternalCode(String externalCode)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveBenefitException {

		return getPersistence().findByExternalCode(externalCode);
	}

	/**
	 * Returns the smart active benefit where externalCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCode the external code
	 * @return the matching smart active benefit, or <code>null</code> if a matching smart active benefit could not be found
	 */
	public static SmartActiveBenefit fetchByExternalCode(String externalCode) {
		return getPersistence().fetchByExternalCode(externalCode);
	}

	/**
	 * Returns the smart active benefit where externalCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCode the external code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active benefit, or <code>null</code> if a matching smart active benefit could not be found
	 */
	public static SmartActiveBenefit fetchByExternalCode(
		String externalCode, boolean useFinderCache) {

		return getPersistence().fetchByExternalCode(
			externalCode, useFinderCache);
	}

	/**
	 * Removes the smart active benefit where externalCode = &#63; from the database.
	 *
	 * @param externalCode the external code
	 * @return the smart active benefit that was removed
	 */
	public static SmartActiveBenefit removeByExternalCode(String externalCode)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveBenefitException {

		return getPersistence().removeByExternalCode(externalCode);
	}

	/**
	 * Returns the number of smart active benefits where externalCode = &#63;.
	 *
	 * @param externalCode the external code
	 * @return the number of matching smart active benefits
	 */
	public static int countByExternalCode(String externalCode) {
		return getPersistence().countByExternalCode(externalCode);
	}

	/**
	 * Caches the smart active benefit in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefit the smart active benefit
	 */
	public static void cacheResult(SmartActiveBenefit smartActiveBenefit) {
		getPersistence().cacheResult(smartActiveBenefit);
	}

	/**
	 * Caches the smart active benefits in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefits the smart active benefits
	 */
	public static void cacheResult(
		List<SmartActiveBenefit> smartActiveBenefits) {

		getPersistence().cacheResult(smartActiveBenefits);
	}

	/**
	 * Creates a new smart active benefit with the primary key. Does not add the smart active benefit to the database.
	 *
	 * @param smartActiveBenefitId the primary key for the new smart active benefit
	 * @return the new smart active benefit
	 */
	public static SmartActiveBenefit create(long smartActiveBenefitId) {
		return getPersistence().create(smartActiveBenefitId);
	}

	/**
	 * Removes the smart active benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveBenefitId the primary key of the smart active benefit
	 * @return the smart active benefit that was removed
	 * @throws NoSuchSmartActiveBenefitException if a smart active benefit with the primary key could not be found
	 */
	public static SmartActiveBenefit remove(long smartActiveBenefitId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveBenefitException {

		return getPersistence().remove(smartActiveBenefitId);
	}

	public static SmartActiveBenefit updateImpl(
		SmartActiveBenefit smartActiveBenefit) {

		return getPersistence().updateImpl(smartActiveBenefit);
	}

	/**
	 * Returns the smart active benefit with the primary key or throws a <code>NoSuchSmartActiveBenefitException</code> if it could not be found.
	 *
	 * @param smartActiveBenefitId the primary key of the smart active benefit
	 * @return the smart active benefit
	 * @throws NoSuchSmartActiveBenefitException if a smart active benefit with the primary key could not be found
	 */
	public static SmartActiveBenefit findByPrimaryKey(long smartActiveBenefitId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveBenefitException {

		return getPersistence().findByPrimaryKey(smartActiveBenefitId);
	}

	/**
	 * Returns the smart active benefit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveBenefitId the primary key of the smart active benefit
	 * @return the smart active benefit, or <code>null</code> if a smart active benefit with the primary key could not be found
	 */
	public static SmartActiveBenefit fetchByPrimaryKey(
		long smartActiveBenefitId) {

		return getPersistence().fetchByPrimaryKey(smartActiveBenefitId);
	}

	/**
	 * Returns all the smart active benefits.
	 *
	 * @return the smart active benefits
	 */
	public static List<SmartActiveBenefit> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the smart active benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @return the range of smart active benefits
	 */
	public static List<SmartActiveBenefit> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the smart active benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active benefits
	 */
	public static List<SmartActiveBenefit> findAll(
		int start, int end,
		OrderByComparator<SmartActiveBenefit> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart active benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active benefits
	 */
	public static List<SmartActiveBenefit> findAll(
		int start, int end,
		OrderByComparator<SmartActiveBenefit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the smart active benefits from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of smart active benefits.
	 *
	 * @return the number of smart active benefits
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SmartActiveBenefitPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SmartActiveBenefitPersistence _persistence;

}