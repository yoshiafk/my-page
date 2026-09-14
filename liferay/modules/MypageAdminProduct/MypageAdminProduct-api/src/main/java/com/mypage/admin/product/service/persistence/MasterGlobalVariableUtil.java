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

import com.mypage.admin.product.model.MasterGlobalVariable;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the master global variable service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.MasterGlobalVariablePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterGlobalVariablePersistence
 * @generated
 */
public class MasterGlobalVariableUtil {

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
	public static void clearCache(MasterGlobalVariable masterGlobalVariable) {
		getPersistence().clearCache(masterGlobalVariable);
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
	public static Map<Serializable, MasterGlobalVariable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MasterGlobalVariable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MasterGlobalVariable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MasterGlobalVariable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MasterGlobalVariable> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MasterGlobalVariable update(
		MasterGlobalVariable masterGlobalVariable) {

		return getPersistence().update(masterGlobalVariable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MasterGlobalVariable update(
		MasterGlobalVariable masterGlobalVariable,
		ServiceContext serviceContext) {

		return getPersistence().update(masterGlobalVariable, serviceContext);
	}

	/**
	 * Caches the master global variable in the entity cache if it is enabled.
	 *
	 * @param masterGlobalVariable the master global variable
	 */
	public static void cacheResult(MasterGlobalVariable masterGlobalVariable) {
		getPersistence().cacheResult(masterGlobalVariable);
	}

	/**
	 * Caches the master global variables in the entity cache if it is enabled.
	 *
	 * @param masterGlobalVariables the master global variables
	 */
	public static void cacheResult(
		List<MasterGlobalVariable> masterGlobalVariables) {

		getPersistence().cacheResult(masterGlobalVariables);
	}

	/**
	 * Creates a new master global variable with the primary key. Does not add the master global variable to the database.
	 *
	 * @param masterGlobalVariableId the primary key for the new master global variable
	 * @return the new master global variable
	 */
	public static MasterGlobalVariable create(long masterGlobalVariableId) {
		return getPersistence().create(masterGlobalVariableId);
	}

	/**
	 * Removes the master global variable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterGlobalVariableId the primary key of the master global variable
	 * @return the master global variable that was removed
	 * @throws NoSuchMasterGlobalVariableException if a master global variable with the primary key could not be found
	 */
	public static MasterGlobalVariable remove(long masterGlobalVariableId)
		throws com.mypage.admin.product.exception.
			NoSuchMasterGlobalVariableException {

		return getPersistence().remove(masterGlobalVariableId);
	}

	public static MasterGlobalVariable updateImpl(
		MasterGlobalVariable masterGlobalVariable) {

		return getPersistence().updateImpl(masterGlobalVariable);
	}

	/**
	 * Returns the master global variable with the primary key or throws a <code>NoSuchMasterGlobalVariableException</code> if it could not be found.
	 *
	 * @param masterGlobalVariableId the primary key of the master global variable
	 * @return the master global variable
	 * @throws NoSuchMasterGlobalVariableException if a master global variable with the primary key could not be found
	 */
	public static MasterGlobalVariable findByPrimaryKey(
			long masterGlobalVariableId)
		throws com.mypage.admin.product.exception.
			NoSuchMasterGlobalVariableException {

		return getPersistence().findByPrimaryKey(masterGlobalVariableId);
	}

	/**
	 * Returns the master global variable with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterGlobalVariableId the primary key of the master global variable
	 * @return the master global variable, or <code>null</code> if a master global variable with the primary key could not be found
	 */
	public static MasterGlobalVariable fetchByPrimaryKey(
		long masterGlobalVariableId) {

		return getPersistence().fetchByPrimaryKey(masterGlobalVariableId);
	}

	/**
	 * Returns all the master global variables.
	 *
	 * @return the master global variables
	 */
	public static List<MasterGlobalVariable> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the master global variables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterGlobalVariableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master global variables
	 * @param end the upper bound of the range of master global variables (not inclusive)
	 * @return the range of master global variables
	 */
	public static List<MasterGlobalVariable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the master global variables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterGlobalVariableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master global variables
	 * @param end the upper bound of the range of master global variables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master global variables
	 */
	public static List<MasterGlobalVariable> findAll(
		int start, int end,
		OrderByComparator<MasterGlobalVariable> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master global variables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterGlobalVariableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master global variables
	 * @param end the upper bound of the range of master global variables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master global variables
	 */
	public static List<MasterGlobalVariable> findAll(
		int start, int end,
		OrderByComparator<MasterGlobalVariable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the master global variables from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of master global variables.
	 *
	 * @return the number of master global variables
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MasterGlobalVariablePersistence getPersistence() {
		return _persistence;
	}

	private static volatile MasterGlobalVariablePersistence _persistence;

}