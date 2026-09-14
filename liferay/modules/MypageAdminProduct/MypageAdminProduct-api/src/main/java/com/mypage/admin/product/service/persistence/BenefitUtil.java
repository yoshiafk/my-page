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

import com.mypage.admin.product.model.Benefit;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the benefit service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.BenefitPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see BenefitPersistence
 * @generated
 */
public class BenefitUtil {

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
	public static void clearCache(Benefit benefit) {
		getPersistence().clearCache(benefit);
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
	public static Map<Serializable, Benefit> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Benefit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Benefit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Benefit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Benefit> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Benefit update(Benefit benefit) {
		return getPersistence().update(benefit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Benefit update(
		Benefit benefit, ServiceContext serviceContext) {

		return getPersistence().update(benefit, serviceContext);
	}

	/**
	 * Caches the benefit in the entity cache if it is enabled.
	 *
	 * @param benefit the benefit
	 */
	public static void cacheResult(Benefit benefit) {
		getPersistence().cacheResult(benefit);
	}

	/**
	 * Caches the benefits in the entity cache if it is enabled.
	 *
	 * @param benefits the benefits
	 */
	public static void cacheResult(List<Benefit> benefits) {
		getPersistence().cacheResult(benefits);
	}

	/**
	 * Creates a new benefit with the primary key. Does not add the benefit to the database.
	 *
	 * @param benefitId the primary key for the new benefit
	 * @return the new benefit
	 */
	public static Benefit create(long benefitId) {
		return getPersistence().create(benefitId);
	}

	/**
	 * Removes the benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param benefitId the primary key of the benefit
	 * @return the benefit that was removed
	 * @throws NoSuchBenefitException if a benefit with the primary key could not be found
	 */
	public static Benefit remove(long benefitId)
		throws com.mypage.admin.product.exception.NoSuchBenefitException {

		return getPersistence().remove(benefitId);
	}

	public static Benefit updateImpl(Benefit benefit) {
		return getPersistence().updateImpl(benefit);
	}

	/**
	 * Returns the benefit with the primary key or throws a <code>NoSuchBenefitException</code> if it could not be found.
	 *
	 * @param benefitId the primary key of the benefit
	 * @return the benefit
	 * @throws NoSuchBenefitException if a benefit with the primary key could not be found
	 */
	public static Benefit findByPrimaryKey(long benefitId)
		throws com.mypage.admin.product.exception.NoSuchBenefitException {

		return getPersistence().findByPrimaryKey(benefitId);
	}

	/**
	 * Returns the benefit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param benefitId the primary key of the benefit
	 * @return the benefit, or <code>null</code> if a benefit with the primary key could not be found
	 */
	public static Benefit fetchByPrimaryKey(long benefitId) {
		return getPersistence().fetchByPrimaryKey(benefitId);
	}

	/**
	 * Returns all the benefits.
	 *
	 * @return the benefits
	 */
	public static List<Benefit> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefits
	 * @param end the upper bound of the range of benefits (not inclusive)
	 * @return the range of benefits
	 */
	public static List<Benefit> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefits
	 * @param end the upper bound of the range of benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of benefits
	 */
	public static List<Benefit> findAll(
		int start, int end, OrderByComparator<Benefit> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefits
	 * @param end the upper bound of the range of benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of benefits
	 */
	public static List<Benefit> findAll(
		int start, int end, OrderByComparator<Benefit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the benefits from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of benefits.
	 *
	 * @return the number of benefits
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BenefitPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BenefitPersistence _persistence;

}