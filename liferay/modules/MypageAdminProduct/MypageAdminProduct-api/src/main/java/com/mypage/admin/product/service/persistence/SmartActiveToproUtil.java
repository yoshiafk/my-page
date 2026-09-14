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

import com.mypage.admin.product.model.SmartActiveTopro;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the smart active topro service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.SmartActiveToproPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveToproPersistence
 * @generated
 */
public class SmartActiveToproUtil {

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
	public static void clearCache(SmartActiveTopro smartActiveTopro) {
		getPersistence().clearCache(smartActiveTopro);
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
	public static Map<Serializable, SmartActiveTopro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SmartActiveTopro> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SmartActiveTopro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SmartActiveTopro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SmartActiveTopro> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SmartActiveTopro update(SmartActiveTopro smartActiveTopro) {
		return getPersistence().update(smartActiveTopro);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SmartActiveTopro update(
		SmartActiveTopro smartActiveTopro, ServiceContext serviceContext) {

		return getPersistence().update(smartActiveTopro, serviceContext);
	}

	/**
	 * Returns the smart active topro where topro = &#63; or throws a <code>NoSuchSmartActiveToproException</code> if it could not be found.
	 *
	 * @param topro the topro
	 * @return the matching smart active topro
	 * @throws NoSuchSmartActiveToproException if a matching smart active topro could not be found
	 */
	public static SmartActiveTopro findBytopro(String topro)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveToproException {

		return getPersistence().findBytopro(topro);
	}

	/**
	 * Returns the smart active topro where topro = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param topro the topro
	 * @return the matching smart active topro, or <code>null</code> if a matching smart active topro could not be found
	 */
	public static SmartActiveTopro fetchBytopro(String topro) {
		return getPersistence().fetchBytopro(topro);
	}

	/**
	 * Returns the smart active topro where topro = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param topro the topro
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active topro, or <code>null</code> if a matching smart active topro could not be found
	 */
	public static SmartActiveTopro fetchBytopro(
		String topro, boolean useFinderCache) {

		return getPersistence().fetchBytopro(topro, useFinderCache);
	}

	/**
	 * Removes the smart active topro where topro = &#63; from the database.
	 *
	 * @param topro the topro
	 * @return the smart active topro that was removed
	 */
	public static SmartActiveTopro removeBytopro(String topro)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveToproException {

		return getPersistence().removeBytopro(topro);
	}

	/**
	 * Returns the number of smart active topros where topro = &#63;.
	 *
	 * @param topro the topro
	 * @return the number of matching smart active topros
	 */
	public static int countBytopro(String topro) {
		return getPersistence().countBytopro(topro);
	}

	/**
	 * Returns the smart active topro where smartActiveBenefitValueId = &#63; or throws a <code>NoSuchSmartActiveToproException</code> if it could not be found.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the matching smart active topro
	 * @throws NoSuchSmartActiveToproException if a matching smart active topro could not be found
	 */
	public static SmartActiveTopro findByBenefitValueId(
			long smartActiveBenefitValueId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveToproException {

		return getPersistence().findByBenefitValueId(smartActiveBenefitValueId);
	}

	/**
	 * Returns the smart active topro where smartActiveBenefitValueId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the matching smart active topro, or <code>null</code> if a matching smart active topro could not be found
	 */
	public static SmartActiveTopro fetchByBenefitValueId(
		long smartActiveBenefitValueId) {

		return getPersistence().fetchByBenefitValueId(
			smartActiveBenefitValueId);
	}

	/**
	 * Returns the smart active topro where smartActiveBenefitValueId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active topro, or <code>null</code> if a matching smart active topro could not be found
	 */
	public static SmartActiveTopro fetchByBenefitValueId(
		long smartActiveBenefitValueId, boolean useFinderCache) {

		return getPersistence().fetchByBenefitValueId(
			smartActiveBenefitValueId, useFinderCache);
	}

	/**
	 * Removes the smart active topro where smartActiveBenefitValueId = &#63; from the database.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the smart active topro that was removed
	 */
	public static SmartActiveTopro removeByBenefitValueId(
			long smartActiveBenefitValueId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveToproException {

		return getPersistence().removeByBenefitValueId(
			smartActiveBenefitValueId);
	}

	/**
	 * Returns the number of smart active topros where smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the number of matching smart active topros
	 */
	public static int countByBenefitValueId(long smartActiveBenefitValueId) {
		return getPersistence().countByBenefitValueId(
			smartActiveBenefitValueId);
	}

	/**
	 * Caches the smart active topro in the entity cache if it is enabled.
	 *
	 * @param smartActiveTopro the smart active topro
	 */
	public static void cacheResult(SmartActiveTopro smartActiveTopro) {
		getPersistence().cacheResult(smartActiveTopro);
	}

	/**
	 * Caches the smart active topros in the entity cache if it is enabled.
	 *
	 * @param smartActiveTopros the smart active topros
	 */
	public static void cacheResult(List<SmartActiveTopro> smartActiveTopros) {
		getPersistence().cacheResult(smartActiveTopros);
	}

	/**
	 * Creates a new smart active topro with the primary key. Does not add the smart active topro to the database.
	 *
	 * @param smartActiveToproId the primary key for the new smart active topro
	 * @return the new smart active topro
	 */
	public static SmartActiveTopro create(long smartActiveToproId) {
		return getPersistence().create(smartActiveToproId);
	}

	/**
	 * Removes the smart active topro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveToproId the primary key of the smart active topro
	 * @return the smart active topro that was removed
	 * @throws NoSuchSmartActiveToproException if a smart active topro with the primary key could not be found
	 */
	public static SmartActiveTopro remove(long smartActiveToproId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveToproException {

		return getPersistence().remove(smartActiveToproId);
	}

	public static SmartActiveTopro updateImpl(
		SmartActiveTopro smartActiveTopro) {

		return getPersistence().updateImpl(smartActiveTopro);
	}

	/**
	 * Returns the smart active topro with the primary key or throws a <code>NoSuchSmartActiveToproException</code> if it could not be found.
	 *
	 * @param smartActiveToproId the primary key of the smart active topro
	 * @return the smart active topro
	 * @throws NoSuchSmartActiveToproException if a smart active topro with the primary key could not be found
	 */
	public static SmartActiveTopro findByPrimaryKey(long smartActiveToproId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveToproException {

		return getPersistence().findByPrimaryKey(smartActiveToproId);
	}

	/**
	 * Returns the smart active topro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveToproId the primary key of the smart active topro
	 * @return the smart active topro, or <code>null</code> if a smart active topro with the primary key could not be found
	 */
	public static SmartActiveTopro fetchByPrimaryKey(long smartActiveToproId) {
		return getPersistence().fetchByPrimaryKey(smartActiveToproId);
	}

	/**
	 * Returns all the smart active topros.
	 *
	 * @return the smart active topros
	 */
	public static List<SmartActiveTopro> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the smart active topros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active topros
	 * @param end the upper bound of the range of smart active topros (not inclusive)
	 * @return the range of smart active topros
	 */
	public static List<SmartActiveTopro> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the smart active topros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active topros
	 * @param end the upper bound of the range of smart active topros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active topros
	 */
	public static List<SmartActiveTopro> findAll(
		int start, int end,
		OrderByComparator<SmartActiveTopro> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart active topros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active topros
	 * @param end the upper bound of the range of smart active topros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active topros
	 */
	public static List<SmartActiveTopro> findAll(
		int start, int end,
		OrderByComparator<SmartActiveTopro> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the smart active topros from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of smart active topros.
	 *
	 * @return the number of smart active topros
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SmartActiveToproPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SmartActiveToproPersistence _persistence;

}