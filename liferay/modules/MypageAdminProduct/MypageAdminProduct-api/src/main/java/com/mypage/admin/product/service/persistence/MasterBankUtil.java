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

import com.mypage.admin.product.model.MasterBank;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the master bank service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.MasterBankPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterBankPersistence
 * @generated
 */
public class MasterBankUtil {

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
	public static void clearCache(MasterBank masterBank) {
		getPersistence().clearCache(masterBank);
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
	public static Map<Serializable, MasterBank> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MasterBank> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MasterBank> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MasterBank> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MasterBank> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MasterBank update(MasterBank masterBank) {
		return getPersistence().update(masterBank);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MasterBank update(
		MasterBank masterBank, ServiceContext serviceContext) {

		return getPersistence().update(masterBank, serviceContext);
	}

	/**
	 * Returns all the master banks where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching master banks
	 */
	public static List<MasterBank> findByactiveBanks(Integer active) {
		return getPersistence().findByactiveBanks(active);
	}

	/**
	 * Returns a range of all the master banks where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @return the range of matching master banks
	 */
	public static List<MasterBank> findByactiveBanks(
		Integer active, int start, int end) {

		return getPersistence().findByactiveBanks(active, start, end);
	}

	/**
	 * Returns an ordered range of all the master banks where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master banks
	 */
	public static List<MasterBank> findByactiveBanks(
		Integer active, int start, int end,
		OrderByComparator<MasterBank> orderByComparator) {

		return getPersistence().findByactiveBanks(
			active, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master banks where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master banks
	 */
	public static List<MasterBank> findByactiveBanks(
		Integer active, int start, int end,
		OrderByComparator<MasterBank> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByactiveBanks(
			active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first master bank in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master bank
	 * @throws NoSuchMasterBankException if a matching master bank could not be found
	 */
	public static MasterBank findByactiveBanks_First(
			Integer active, OrderByComparator<MasterBank> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterBankException {

		return getPersistence().findByactiveBanks_First(
			active, orderByComparator);
	}

	/**
	 * Returns the first master bank in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master bank, or <code>null</code> if a matching master bank could not be found
	 */
	public static MasterBank fetchByactiveBanks_First(
		Integer active, OrderByComparator<MasterBank> orderByComparator) {

		return getPersistence().fetchByactiveBanks_First(
			active, orderByComparator);
	}

	/**
	 * Returns the last master bank in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master bank
	 * @throws NoSuchMasterBankException if a matching master bank could not be found
	 */
	public static MasterBank findByactiveBanks_Last(
			Integer active, OrderByComparator<MasterBank> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterBankException {

		return getPersistence().findByactiveBanks_Last(
			active, orderByComparator);
	}

	/**
	 * Returns the last master bank in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master bank, or <code>null</code> if a matching master bank could not be found
	 */
	public static MasterBank fetchByactiveBanks_Last(
		Integer active, OrderByComparator<MasterBank> orderByComparator) {

		return getPersistence().fetchByactiveBanks_Last(
			active, orderByComparator);
	}

	/**
	 * Returns the master banks before and after the current master bank in the ordered set where active = &#63;.
	 *
	 * @param masterBankId the primary key of the current master bank
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master bank
	 * @throws NoSuchMasterBankException if a master bank with the primary key could not be found
	 */
	public static MasterBank[] findByactiveBanks_PrevAndNext(
			long masterBankId, Integer active,
			OrderByComparator<MasterBank> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterBankException {

		return getPersistence().findByactiveBanks_PrevAndNext(
			masterBankId, active, orderByComparator);
	}

	/**
	 * Removes all the master banks where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public static void removeByactiveBanks(Integer active) {
		getPersistence().removeByactiveBanks(active);
	}

	/**
	 * Returns the number of master banks where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching master banks
	 */
	public static int countByactiveBanks(Integer active) {
		return getPersistence().countByactiveBanks(active);
	}

	/**
	 * Returns all the master banks where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @return the matching master banks
	 */
	public static List<MasterBank> findBysearchByName(
		String name, Integer active) {

		return getPersistence().findBysearchByName(name, active);
	}

	/**
	 * Returns a range of all the master banks where name = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @return the range of matching master banks
	 */
	public static List<MasterBank> findBysearchByName(
		String name, Integer active, int start, int end) {

		return getPersistence().findBysearchByName(name, active, start, end);
	}

	/**
	 * Returns an ordered range of all the master banks where name = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master banks
	 */
	public static List<MasterBank> findBysearchByName(
		String name, Integer active, int start, int end,
		OrderByComparator<MasterBank> orderByComparator) {

		return getPersistence().findBysearchByName(
			name, active, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master banks where name = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master banks
	 */
	public static List<MasterBank> findBysearchByName(
		String name, Integer active, int start, int end,
		OrderByComparator<MasterBank> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchByName(
			name, active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first master bank in the ordered set where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master bank
	 * @throws NoSuchMasterBankException if a matching master bank could not be found
	 */
	public static MasterBank findBysearchByName_First(
			String name, Integer active,
			OrderByComparator<MasterBank> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterBankException {

		return getPersistence().findBysearchByName_First(
			name, active, orderByComparator);
	}

	/**
	 * Returns the first master bank in the ordered set where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master bank, or <code>null</code> if a matching master bank could not be found
	 */
	public static MasterBank fetchBysearchByName_First(
		String name, Integer active,
		OrderByComparator<MasterBank> orderByComparator) {

		return getPersistence().fetchBysearchByName_First(
			name, active, orderByComparator);
	}

	/**
	 * Returns the last master bank in the ordered set where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master bank
	 * @throws NoSuchMasterBankException if a matching master bank could not be found
	 */
	public static MasterBank findBysearchByName_Last(
			String name, Integer active,
			OrderByComparator<MasterBank> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterBankException {

		return getPersistence().findBysearchByName_Last(
			name, active, orderByComparator);
	}

	/**
	 * Returns the last master bank in the ordered set where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master bank, or <code>null</code> if a matching master bank could not be found
	 */
	public static MasterBank fetchBysearchByName_Last(
		String name, Integer active,
		OrderByComparator<MasterBank> orderByComparator) {

		return getPersistence().fetchBysearchByName_Last(
			name, active, orderByComparator);
	}

	/**
	 * Returns the master banks before and after the current master bank in the ordered set where name = &#63; and active = &#63;.
	 *
	 * @param masterBankId the primary key of the current master bank
	 * @param name the name
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master bank
	 * @throws NoSuchMasterBankException if a master bank with the primary key could not be found
	 */
	public static MasterBank[] findBysearchByName_PrevAndNext(
			long masterBankId, String name, Integer active,
			OrderByComparator<MasterBank> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchMasterBankException {

		return getPersistence().findBysearchByName_PrevAndNext(
			masterBankId, name, active, orderByComparator);
	}

	/**
	 * Removes all the master banks where name = &#63; and active = &#63; from the database.
	 *
	 * @param name the name
	 * @param active the active
	 */
	public static void removeBysearchByName(String name, Integer active) {
		getPersistence().removeBysearchByName(name, active);
	}

	/**
	 * Returns the number of master banks where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @return the number of matching master banks
	 */
	public static int countBysearchByName(String name, Integer active) {
		return getPersistence().countBysearchByName(name, active);
	}

	/**
	 * Caches the master bank in the entity cache if it is enabled.
	 *
	 * @param masterBank the master bank
	 */
	public static void cacheResult(MasterBank masterBank) {
		getPersistence().cacheResult(masterBank);
	}

	/**
	 * Caches the master banks in the entity cache if it is enabled.
	 *
	 * @param masterBanks the master banks
	 */
	public static void cacheResult(List<MasterBank> masterBanks) {
		getPersistence().cacheResult(masterBanks);
	}

	/**
	 * Creates a new master bank with the primary key. Does not add the master bank to the database.
	 *
	 * @param masterBankId the primary key for the new master bank
	 * @return the new master bank
	 */
	public static MasterBank create(long masterBankId) {
		return getPersistence().create(masterBankId);
	}

	/**
	 * Removes the master bank with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterBankId the primary key of the master bank
	 * @return the master bank that was removed
	 * @throws NoSuchMasterBankException if a master bank with the primary key could not be found
	 */
	public static MasterBank remove(long masterBankId)
		throws com.mypage.admin.product.exception.NoSuchMasterBankException {

		return getPersistence().remove(masterBankId);
	}

	public static MasterBank updateImpl(MasterBank masterBank) {
		return getPersistence().updateImpl(masterBank);
	}

	/**
	 * Returns the master bank with the primary key or throws a <code>NoSuchMasterBankException</code> if it could not be found.
	 *
	 * @param masterBankId the primary key of the master bank
	 * @return the master bank
	 * @throws NoSuchMasterBankException if a master bank with the primary key could not be found
	 */
	public static MasterBank findByPrimaryKey(long masterBankId)
		throws com.mypage.admin.product.exception.NoSuchMasterBankException {

		return getPersistence().findByPrimaryKey(masterBankId);
	}

	/**
	 * Returns the master bank with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterBankId the primary key of the master bank
	 * @return the master bank, or <code>null</code> if a master bank with the primary key could not be found
	 */
	public static MasterBank fetchByPrimaryKey(long masterBankId) {
		return getPersistence().fetchByPrimaryKey(masterBankId);
	}

	/**
	 * Returns all the master banks.
	 *
	 * @return the master banks
	 */
	public static List<MasterBank> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the master banks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @return the range of master banks
	 */
	public static List<MasterBank> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the master banks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master banks
	 */
	public static List<MasterBank> findAll(
		int start, int end, OrderByComparator<MasterBank> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master banks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master banks
	 */
	public static List<MasterBank> findAll(
		int start, int end, OrderByComparator<MasterBank> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the master banks from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of master banks.
	 *
	 * @return the number of master banks
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MasterBankPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MasterBankPersistence _persistence;

}