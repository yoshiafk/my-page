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

package com.mypage.user.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.user.model.CreditWallet;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the credit wallet service. This utility wraps <code>com.mypage.user.service.persistence.impl.CreditWalletPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CreditWalletPersistence
 * @generated
 */
public class CreditWalletUtil {

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
	public static void clearCache(CreditWallet creditWallet) {
		getPersistence().clearCache(creditWallet);
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
	public static Map<Serializable, CreditWallet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CreditWallet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CreditWallet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CreditWallet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CreditWallet> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CreditWallet update(CreditWallet creditWallet) {
		return getPersistence().update(creditWallet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CreditWallet update(
		CreditWallet creditWallet, ServiceContext serviceContext) {

		return getPersistence().update(creditWallet, serviceContext);
	}

	/**
	 * Caches the credit wallet in the entity cache if it is enabled.
	 *
	 * @param creditWallet the credit wallet
	 */
	public static void cacheResult(CreditWallet creditWallet) {
		getPersistence().cacheResult(creditWallet);
	}

	/**
	 * Caches the credit wallets in the entity cache if it is enabled.
	 *
	 * @param creditWallets the credit wallets
	 */
	public static void cacheResult(List<CreditWallet> creditWallets) {
		getPersistence().cacheResult(creditWallets);
	}

	/**
	 * Creates a new credit wallet with the primary key. Does not add the credit wallet to the database.
	 *
	 * @param creditWalletId the primary key for the new credit wallet
	 * @return the new credit wallet
	 */
	public static CreditWallet create(long creditWalletId) {
		return getPersistence().create(creditWalletId);
	}

	/**
	 * Removes the credit wallet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creditWalletId the primary key of the credit wallet
	 * @return the credit wallet that was removed
	 * @throws NoSuchCreditWalletException if a credit wallet with the primary key could not be found
	 */
	public static CreditWallet remove(long creditWalletId)
		throws com.mypage.user.exception.NoSuchCreditWalletException {

		return getPersistence().remove(creditWalletId);
	}

	public static CreditWallet updateImpl(CreditWallet creditWallet) {
		return getPersistence().updateImpl(creditWallet);
	}

	/**
	 * Returns the credit wallet with the primary key or throws a <code>NoSuchCreditWalletException</code> if it could not be found.
	 *
	 * @param creditWalletId the primary key of the credit wallet
	 * @return the credit wallet
	 * @throws NoSuchCreditWalletException if a credit wallet with the primary key could not be found
	 */
	public static CreditWallet findByPrimaryKey(long creditWalletId)
		throws com.mypage.user.exception.NoSuchCreditWalletException {

		return getPersistence().findByPrimaryKey(creditWalletId);
	}

	/**
	 * Returns the credit wallet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param creditWalletId the primary key of the credit wallet
	 * @return the credit wallet, or <code>null</code> if a credit wallet with the primary key could not be found
	 */
	public static CreditWallet fetchByPrimaryKey(long creditWalletId) {
		return getPersistence().fetchByPrimaryKey(creditWalletId);
	}

	/**
	 * Returns all the credit wallets.
	 *
	 * @return the credit wallets
	 */
	public static List<CreditWallet> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the credit wallets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallets
	 * @param end the upper bound of the range of credit wallets (not inclusive)
	 * @return the range of credit wallets
	 */
	public static List<CreditWallet> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the credit wallets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallets
	 * @param end the upper bound of the range of credit wallets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of credit wallets
	 */
	public static List<CreditWallet> findAll(
		int start, int end, OrderByComparator<CreditWallet> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the credit wallets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallets
	 * @param end the upper bound of the range of credit wallets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of credit wallets
	 */
	public static List<CreditWallet> findAll(
		int start, int end, OrderByComparator<CreditWallet> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the credit wallets from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of credit wallets.
	 *
	 * @return the number of credit wallets
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CreditWalletPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CreditWalletPersistence _persistence;

}