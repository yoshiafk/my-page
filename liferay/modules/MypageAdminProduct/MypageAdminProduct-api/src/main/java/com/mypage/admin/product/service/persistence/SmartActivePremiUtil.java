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

import com.mypage.admin.product.model.SmartActivePremi;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the smart active premi service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.SmartActivePremiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActivePremiPersistence
 * @generated
 */
public class SmartActivePremiUtil {

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
	public static void clearCache(SmartActivePremi smartActivePremi) {
		getPersistence().clearCache(smartActivePremi);
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
	public static Map<Serializable, SmartActivePremi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SmartActivePremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SmartActivePremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SmartActivePremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SmartActivePremi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SmartActivePremi update(SmartActivePremi smartActivePremi) {
		return getPersistence().update(smartActivePremi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SmartActivePremi update(
		SmartActivePremi smartActivePremi, ServiceContext serviceContext) {

		return getPersistence().update(smartActivePremi, serviceContext);
	}

	/**
	 * Returns the smart active premi where smartActiveBenefitId = &#63; and smartActiveClassRateId = &#63; or throws a <code>NoSuchSmartActivePremiException</code> if it could not be found.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveClassRateId the smart active class rate ID
	 * @return the matching smart active premi
	 * @throws NoSuchSmartActivePremiException if a matching smart active premi could not be found
	 */
	public static SmartActivePremi findByBenefitIdAndClassId(
			long smartActiveBenefitId, long smartActiveClassRateId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActivePremiException {

		return getPersistence().findByBenefitIdAndClassId(
			smartActiveBenefitId, smartActiveClassRateId);
	}

	/**
	 * Returns the smart active premi where smartActiveBenefitId = &#63; and smartActiveClassRateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveClassRateId the smart active class rate ID
	 * @return the matching smart active premi, or <code>null</code> if a matching smart active premi could not be found
	 */
	public static SmartActivePremi fetchByBenefitIdAndClassId(
		long smartActiveBenefitId, long smartActiveClassRateId) {

		return getPersistence().fetchByBenefitIdAndClassId(
			smartActiveBenefitId, smartActiveClassRateId);
	}

	/**
	 * Returns the smart active premi where smartActiveBenefitId = &#63; and smartActiveClassRateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveClassRateId the smart active class rate ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active premi, or <code>null</code> if a matching smart active premi could not be found
	 */
	public static SmartActivePremi fetchByBenefitIdAndClassId(
		long smartActiveBenefitId, long smartActiveClassRateId,
		boolean useFinderCache) {

		return getPersistence().fetchByBenefitIdAndClassId(
			smartActiveBenefitId, smartActiveClassRateId, useFinderCache);
	}

	/**
	 * Removes the smart active premi where smartActiveBenefitId = &#63; and smartActiveClassRateId = &#63; from the database.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveClassRateId the smart active class rate ID
	 * @return the smart active premi that was removed
	 */
	public static SmartActivePremi removeByBenefitIdAndClassId(
			long smartActiveBenefitId, long smartActiveClassRateId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActivePremiException {

		return getPersistence().removeByBenefitIdAndClassId(
			smartActiveBenefitId, smartActiveClassRateId);
	}

	/**
	 * Returns the number of smart active premis where smartActiveBenefitId = &#63; and smartActiveClassRateId = &#63;.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveClassRateId the smart active class rate ID
	 * @return the number of matching smart active premis
	 */
	public static int countByBenefitIdAndClassId(
		long smartActiveBenefitId, long smartActiveClassRateId) {

		return getPersistence().countByBenefitIdAndClassId(
			smartActiveBenefitId, smartActiveClassRateId);
	}

	/**
	 * Caches the smart active premi in the entity cache if it is enabled.
	 *
	 * @param smartActivePremi the smart active premi
	 */
	public static void cacheResult(SmartActivePremi smartActivePremi) {
		getPersistence().cacheResult(smartActivePremi);
	}

	/**
	 * Caches the smart active premis in the entity cache if it is enabled.
	 *
	 * @param smartActivePremis the smart active premis
	 */
	public static void cacheResult(List<SmartActivePremi> smartActivePremis) {
		getPersistence().cacheResult(smartActivePremis);
	}

	/**
	 * Creates a new smart active premi with the primary key. Does not add the smart active premi to the database.
	 *
	 * @param smartActivePremiId the primary key for the new smart active premi
	 * @return the new smart active premi
	 */
	public static SmartActivePremi create(long smartActivePremiId) {
		return getPersistence().create(smartActivePremiId);
	}

	/**
	 * Removes the smart active premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActivePremiId the primary key of the smart active premi
	 * @return the smart active premi that was removed
	 * @throws NoSuchSmartActivePremiException if a smart active premi with the primary key could not be found
	 */
	public static SmartActivePremi remove(long smartActivePremiId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActivePremiException {

		return getPersistence().remove(smartActivePremiId);
	}

	public static SmartActivePremi updateImpl(
		SmartActivePremi smartActivePremi) {

		return getPersistence().updateImpl(smartActivePremi);
	}

	/**
	 * Returns the smart active premi with the primary key or throws a <code>NoSuchSmartActivePremiException</code> if it could not be found.
	 *
	 * @param smartActivePremiId the primary key of the smart active premi
	 * @return the smart active premi
	 * @throws NoSuchSmartActivePremiException if a smart active premi with the primary key could not be found
	 */
	public static SmartActivePremi findByPrimaryKey(long smartActivePremiId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActivePremiException {

		return getPersistence().findByPrimaryKey(smartActivePremiId);
	}

	/**
	 * Returns the smart active premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActivePremiId the primary key of the smart active premi
	 * @return the smart active premi, or <code>null</code> if a smart active premi with the primary key could not be found
	 */
	public static SmartActivePremi fetchByPrimaryKey(long smartActivePremiId) {
		return getPersistence().fetchByPrimaryKey(smartActivePremiId);
	}

	/**
	 * Returns all the smart active premis.
	 *
	 * @return the smart active premis
	 */
	public static List<SmartActivePremi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the smart active premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActivePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active premis
	 * @param end the upper bound of the range of smart active premis (not inclusive)
	 * @return the range of smart active premis
	 */
	public static List<SmartActivePremi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the smart active premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActivePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active premis
	 * @param end the upper bound of the range of smart active premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active premis
	 */
	public static List<SmartActivePremi> findAll(
		int start, int end,
		OrderByComparator<SmartActivePremi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart active premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActivePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active premis
	 * @param end the upper bound of the range of smart active premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active premis
	 */
	public static List<SmartActivePremi> findAll(
		int start, int end,
		OrderByComparator<SmartActivePremi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the smart active premis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of smart active premis.
	 *
	 * @return the number of smart active premis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SmartActivePremiPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SmartActivePremiPersistence _persistence;

}