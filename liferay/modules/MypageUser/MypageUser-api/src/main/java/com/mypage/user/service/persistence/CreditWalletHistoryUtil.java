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

import com.mypage.user.model.CreditWalletHistory;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the credit wallet history service. This utility wraps <code>com.mypage.user.service.persistence.impl.CreditWalletHistoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CreditWalletHistoryPersistence
 * @generated
 */
public class CreditWalletHistoryUtil {

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
	public static void clearCache(CreditWalletHistory creditWalletHistory) {
		getPersistence().clearCache(creditWalletHistory);
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
	public static Map<Serializable, CreditWalletHistory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CreditWalletHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CreditWalletHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CreditWalletHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CreditWalletHistory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CreditWalletHistory update(
		CreditWalletHistory creditWalletHistory) {

		return getPersistence().update(creditWalletHistory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CreditWalletHistory update(
		CreditWalletHistory creditWalletHistory,
		ServiceContext serviceContext) {

		return getPersistence().update(creditWalletHistory, serviceContext);
	}

	/**
	 * Returns all the credit wallet histories where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the matching credit wallet histories
	 */
	public static List<CreditWalletHistory> findBygetCreditWalletId(
		long creditWalletId) {

		return getPersistence().findBygetCreditWalletId(creditWalletId);
	}

	/**
	 * Returns a range of all the credit wallet histories where creditWalletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @return the range of matching credit wallet histories
	 */
	public static List<CreditWalletHistory> findBygetCreditWalletId(
		long creditWalletId, int start, int end) {

		return getPersistence().findBygetCreditWalletId(
			creditWalletId, start, end);
	}

	/**
	 * Returns an ordered range of all the credit wallet histories where creditWalletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching credit wallet histories
	 */
	public static List<CreditWalletHistory> findBygetCreditWalletId(
		long creditWalletId, int start, int end,
		OrderByComparator<CreditWalletHistory> orderByComparator) {

		return getPersistence().findBygetCreditWalletId(
			creditWalletId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the credit wallet histories where creditWalletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching credit wallet histories
	 */
	public static List<CreditWalletHistory> findBygetCreditWalletId(
		long creditWalletId, int start, int end,
		OrderByComparator<CreditWalletHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBygetCreditWalletId(
			creditWalletId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first credit wallet history in the ordered set where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit wallet history
	 * @throws NoSuchCreditWalletHistoryException if a matching credit wallet history could not be found
	 */
	public static CreditWalletHistory findBygetCreditWalletId_First(
			long creditWalletId,
			OrderByComparator<CreditWalletHistory> orderByComparator)
		throws com.mypage.user.exception.NoSuchCreditWalletHistoryException {

		return getPersistence().findBygetCreditWalletId_First(
			creditWalletId, orderByComparator);
	}

	/**
	 * Returns the first credit wallet history in the ordered set where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit wallet history, or <code>null</code> if a matching credit wallet history could not be found
	 */
	public static CreditWalletHistory fetchBygetCreditWalletId_First(
		long creditWalletId,
		OrderByComparator<CreditWalletHistory> orderByComparator) {

		return getPersistence().fetchBygetCreditWalletId_First(
			creditWalletId, orderByComparator);
	}

	/**
	 * Returns the last credit wallet history in the ordered set where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit wallet history
	 * @throws NoSuchCreditWalletHistoryException if a matching credit wallet history could not be found
	 */
	public static CreditWalletHistory findBygetCreditWalletId_Last(
			long creditWalletId,
			OrderByComparator<CreditWalletHistory> orderByComparator)
		throws com.mypage.user.exception.NoSuchCreditWalletHistoryException {

		return getPersistence().findBygetCreditWalletId_Last(
			creditWalletId, orderByComparator);
	}

	/**
	 * Returns the last credit wallet history in the ordered set where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit wallet history, or <code>null</code> if a matching credit wallet history could not be found
	 */
	public static CreditWalletHistory fetchBygetCreditWalletId_Last(
		long creditWalletId,
		OrderByComparator<CreditWalletHistory> orderByComparator) {

		return getPersistence().fetchBygetCreditWalletId_Last(
			creditWalletId, orderByComparator);
	}

	/**
	 * Returns the credit wallet histories before and after the current credit wallet history in the ordered set where creditWalletId = &#63;.
	 *
	 * @param creditWalletHistoryId the primary key of the current credit wallet history
	 * @param creditWalletId the credit wallet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next credit wallet history
	 * @throws NoSuchCreditWalletHistoryException if a credit wallet history with the primary key could not be found
	 */
	public static CreditWalletHistory[] findBygetCreditWalletId_PrevAndNext(
			long creditWalletHistoryId, long creditWalletId,
			OrderByComparator<CreditWalletHistory> orderByComparator)
		throws com.mypage.user.exception.NoSuchCreditWalletHistoryException {

		return getPersistence().findBygetCreditWalletId_PrevAndNext(
			creditWalletHistoryId, creditWalletId, orderByComparator);
	}

	/**
	 * Removes all the credit wallet histories where creditWalletId = &#63; from the database.
	 *
	 * @param creditWalletId the credit wallet ID
	 */
	public static void removeBygetCreditWalletId(long creditWalletId) {
		getPersistence().removeBygetCreditWalletId(creditWalletId);
	}

	/**
	 * Returns the number of credit wallet histories where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the number of matching credit wallet histories
	 */
	public static int countBygetCreditWalletId(long creditWalletId) {
		return getPersistence().countBygetCreditWalletId(creditWalletId);
	}

	/**
	 * Caches the credit wallet history in the entity cache if it is enabled.
	 *
	 * @param creditWalletHistory the credit wallet history
	 */
	public static void cacheResult(CreditWalletHistory creditWalletHistory) {
		getPersistence().cacheResult(creditWalletHistory);
	}

	/**
	 * Caches the credit wallet histories in the entity cache if it is enabled.
	 *
	 * @param creditWalletHistories the credit wallet histories
	 */
	public static void cacheResult(
		List<CreditWalletHistory> creditWalletHistories) {

		getPersistence().cacheResult(creditWalletHistories);
	}

	/**
	 * Creates a new credit wallet history with the primary key. Does not add the credit wallet history to the database.
	 *
	 * @param creditWalletHistoryId the primary key for the new credit wallet history
	 * @return the new credit wallet history
	 */
	public static CreditWalletHistory create(long creditWalletHistoryId) {
		return getPersistence().create(creditWalletHistoryId);
	}

	/**
	 * Removes the credit wallet history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creditWalletHistoryId the primary key of the credit wallet history
	 * @return the credit wallet history that was removed
	 * @throws NoSuchCreditWalletHistoryException if a credit wallet history with the primary key could not be found
	 */
	public static CreditWalletHistory remove(long creditWalletHistoryId)
		throws com.mypage.user.exception.NoSuchCreditWalletHistoryException {

		return getPersistence().remove(creditWalletHistoryId);
	}

	public static CreditWalletHistory updateImpl(
		CreditWalletHistory creditWalletHistory) {

		return getPersistence().updateImpl(creditWalletHistory);
	}

	/**
	 * Returns the credit wallet history with the primary key or throws a <code>NoSuchCreditWalletHistoryException</code> if it could not be found.
	 *
	 * @param creditWalletHistoryId the primary key of the credit wallet history
	 * @return the credit wallet history
	 * @throws NoSuchCreditWalletHistoryException if a credit wallet history with the primary key could not be found
	 */
	public static CreditWalletHistory findByPrimaryKey(
			long creditWalletHistoryId)
		throws com.mypage.user.exception.NoSuchCreditWalletHistoryException {

		return getPersistence().findByPrimaryKey(creditWalletHistoryId);
	}

	/**
	 * Returns the credit wallet history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param creditWalletHistoryId the primary key of the credit wallet history
	 * @return the credit wallet history, or <code>null</code> if a credit wallet history with the primary key could not be found
	 */
	public static CreditWalletHistory fetchByPrimaryKey(
		long creditWalletHistoryId) {

		return getPersistence().fetchByPrimaryKey(creditWalletHistoryId);
	}

	/**
	 * Returns all the credit wallet histories.
	 *
	 * @return the credit wallet histories
	 */
	public static List<CreditWalletHistory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the credit wallet histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @return the range of credit wallet histories
	 */
	public static List<CreditWalletHistory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the credit wallet histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of credit wallet histories
	 */
	public static List<CreditWalletHistory> findAll(
		int start, int end,
		OrderByComparator<CreditWalletHistory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the credit wallet histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of credit wallet histories
	 */
	public static List<CreditWalletHistory> findAll(
		int start, int end,
		OrderByComparator<CreditWalletHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the credit wallet histories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of credit wallet histories.
	 *
	 * @return the number of credit wallet histories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CreditWalletHistoryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CreditWalletHistoryPersistence _persistence;

}