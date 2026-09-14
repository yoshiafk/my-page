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

import com.mypage.admin.product.model.SmartActiveFeature;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the smart active feature service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.SmartActiveFeaturePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveFeaturePersistence
 * @generated
 */
public class SmartActiveFeatureUtil {

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
	public static void clearCache(SmartActiveFeature smartActiveFeature) {
		getPersistence().clearCache(smartActiveFeature);
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
	public static Map<Serializable, SmartActiveFeature> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SmartActiveFeature> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SmartActiveFeature> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SmartActiveFeature> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SmartActiveFeature> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SmartActiveFeature update(
		SmartActiveFeature smartActiveFeature) {

		return getPersistence().update(smartActiveFeature);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SmartActiveFeature update(
		SmartActiveFeature smartActiveFeature, ServiceContext serviceContext) {

		return getPersistence().update(smartActiveFeature, serviceContext);
	}

	/**
	 * Caches the smart active feature in the entity cache if it is enabled.
	 *
	 * @param smartActiveFeature the smart active feature
	 */
	public static void cacheResult(SmartActiveFeature smartActiveFeature) {
		getPersistence().cacheResult(smartActiveFeature);
	}

	/**
	 * Caches the smart active features in the entity cache if it is enabled.
	 *
	 * @param smartActiveFeatures the smart active features
	 */
	public static void cacheResult(
		List<SmartActiveFeature> smartActiveFeatures) {

		getPersistence().cacheResult(smartActiveFeatures);
	}

	/**
	 * Creates a new smart active feature with the primary key. Does not add the smart active feature to the database.
	 *
	 * @param smartActiveFeatureId the primary key for the new smart active feature
	 * @return the new smart active feature
	 */
	public static SmartActiveFeature create(long smartActiveFeatureId) {
		return getPersistence().create(smartActiveFeatureId);
	}

	/**
	 * Removes the smart active feature with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveFeatureId the primary key of the smart active feature
	 * @return the smart active feature that was removed
	 * @throws NoSuchSmartActiveFeatureException if a smart active feature with the primary key could not be found
	 */
	public static SmartActiveFeature remove(long smartActiveFeatureId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveFeatureException {

		return getPersistence().remove(smartActiveFeatureId);
	}

	public static SmartActiveFeature updateImpl(
		SmartActiveFeature smartActiveFeature) {

		return getPersistence().updateImpl(smartActiveFeature);
	}

	/**
	 * Returns the smart active feature with the primary key or throws a <code>NoSuchSmartActiveFeatureException</code> if it could not be found.
	 *
	 * @param smartActiveFeatureId the primary key of the smart active feature
	 * @return the smart active feature
	 * @throws NoSuchSmartActiveFeatureException if a smart active feature with the primary key could not be found
	 */
	public static SmartActiveFeature findByPrimaryKey(long smartActiveFeatureId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveFeatureException {

		return getPersistence().findByPrimaryKey(smartActiveFeatureId);
	}

	/**
	 * Returns the smart active feature with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveFeatureId the primary key of the smart active feature
	 * @return the smart active feature, or <code>null</code> if a smart active feature with the primary key could not be found
	 */
	public static SmartActiveFeature fetchByPrimaryKey(
		long smartActiveFeatureId) {

		return getPersistence().fetchByPrimaryKey(smartActiveFeatureId);
	}

	/**
	 * Returns all the smart active features.
	 *
	 * @return the smart active features
	 */
	public static List<SmartActiveFeature> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the smart active features.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveFeatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active features
	 * @param end the upper bound of the range of smart active features (not inclusive)
	 * @return the range of smart active features
	 */
	public static List<SmartActiveFeature> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the smart active features.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveFeatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active features
	 * @param end the upper bound of the range of smart active features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active features
	 */
	public static List<SmartActiveFeature> findAll(
		int start, int end,
		OrderByComparator<SmartActiveFeature> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart active features.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveFeatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active features
	 * @param end the upper bound of the range of smart active features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active features
	 */
	public static List<SmartActiveFeature> findAll(
		int start, int end,
		OrderByComparator<SmartActiveFeature> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the smart active features from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of smart active features.
	 *
	 * @return the number of smart active features
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SmartActiveFeaturePersistence getPersistence() {
		return _persistence;
	}

	private static volatile SmartActiveFeaturePersistence _persistence;

}