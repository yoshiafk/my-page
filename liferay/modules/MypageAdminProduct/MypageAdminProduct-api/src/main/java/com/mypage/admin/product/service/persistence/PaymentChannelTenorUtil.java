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

import com.mypage.admin.product.model.PaymentChannelTenor;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the payment channel tenor service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.PaymentChannelTenorPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PaymentChannelTenorPersistence
 * @generated
 */
public class PaymentChannelTenorUtil {

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
	public static void clearCache(PaymentChannelTenor paymentChannelTenor) {
		getPersistence().clearCache(paymentChannelTenor);
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
	public static Map<Serializable, PaymentChannelTenor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PaymentChannelTenor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PaymentChannelTenor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PaymentChannelTenor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PaymentChannelTenor> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PaymentChannelTenor update(
		PaymentChannelTenor paymentChannelTenor) {

		return getPersistence().update(paymentChannelTenor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PaymentChannelTenor update(
		PaymentChannelTenor paymentChannelTenor,
		ServiceContext serviceContext) {

		return getPersistence().update(paymentChannelTenor, serviceContext);
	}

	/**
	 * Returns all the payment channel tenors where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @return the matching payment channel tenors
	 */
	public static List<PaymentChannelTenor> findBysearchByPaymentChannelId(
		long paymentChannelId) {

		return getPersistence().findBysearchByPaymentChannelId(
			paymentChannelId);
	}

	/**
	 * Returns a range of all the payment channel tenors where paymentChannelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelTenorModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param start the lower bound of the range of payment channel tenors
	 * @param end the upper bound of the range of payment channel tenors (not inclusive)
	 * @return the range of matching payment channel tenors
	 */
	public static List<PaymentChannelTenor> findBysearchByPaymentChannelId(
		long paymentChannelId, int start, int end) {

		return getPersistence().findBysearchByPaymentChannelId(
			paymentChannelId, start, end);
	}

	/**
	 * Returns an ordered range of all the payment channel tenors where paymentChannelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelTenorModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param start the lower bound of the range of payment channel tenors
	 * @param end the upper bound of the range of payment channel tenors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching payment channel tenors
	 */
	public static List<PaymentChannelTenor> findBysearchByPaymentChannelId(
		long paymentChannelId, int start, int end,
		OrderByComparator<PaymentChannelTenor> orderByComparator) {

		return getPersistence().findBysearchByPaymentChannelId(
			paymentChannelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the payment channel tenors where paymentChannelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelTenorModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param start the lower bound of the range of payment channel tenors
	 * @param end the upper bound of the range of payment channel tenors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching payment channel tenors
	 */
	public static List<PaymentChannelTenor> findBysearchByPaymentChannelId(
		long paymentChannelId, int start, int end,
		OrderByComparator<PaymentChannelTenor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchByPaymentChannelId(
			paymentChannelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first payment channel tenor in the ordered set where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel tenor
	 * @throws NoSuchPaymentChannelTenorException if a matching payment channel tenor could not be found
	 */
	public static PaymentChannelTenor findBysearchByPaymentChannelId_First(
			long paymentChannelId,
			OrderByComparator<PaymentChannelTenor> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchPaymentChannelTenorException {

		return getPersistence().findBysearchByPaymentChannelId_First(
			paymentChannelId, orderByComparator);
	}

	/**
	 * Returns the first payment channel tenor in the ordered set where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel tenor, or <code>null</code> if a matching payment channel tenor could not be found
	 */
	public static PaymentChannelTenor fetchBysearchByPaymentChannelId_First(
		long paymentChannelId,
		OrderByComparator<PaymentChannelTenor> orderByComparator) {

		return getPersistence().fetchBysearchByPaymentChannelId_First(
			paymentChannelId, orderByComparator);
	}

	/**
	 * Returns the last payment channel tenor in the ordered set where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel tenor
	 * @throws NoSuchPaymentChannelTenorException if a matching payment channel tenor could not be found
	 */
	public static PaymentChannelTenor findBysearchByPaymentChannelId_Last(
			long paymentChannelId,
			OrderByComparator<PaymentChannelTenor> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchPaymentChannelTenorException {

		return getPersistence().findBysearchByPaymentChannelId_Last(
			paymentChannelId, orderByComparator);
	}

	/**
	 * Returns the last payment channel tenor in the ordered set where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel tenor, or <code>null</code> if a matching payment channel tenor could not be found
	 */
	public static PaymentChannelTenor fetchBysearchByPaymentChannelId_Last(
		long paymentChannelId,
		OrderByComparator<PaymentChannelTenor> orderByComparator) {

		return getPersistence().fetchBysearchByPaymentChannelId_Last(
			paymentChannelId, orderByComparator);
	}

	/**
	 * Returns the payment channel tenors before and after the current payment channel tenor in the ordered set where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelTenorId the primary key of the current payment channel tenor
	 * @param paymentChannelId the payment channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next payment channel tenor
	 * @throws NoSuchPaymentChannelTenorException if a payment channel tenor with the primary key could not be found
	 */
	public static PaymentChannelTenor[]
			findBysearchByPaymentChannelId_PrevAndNext(
				long paymentChannelTenorId, long paymentChannelId,
				OrderByComparator<PaymentChannelTenor> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchPaymentChannelTenorException {

		return getPersistence().findBysearchByPaymentChannelId_PrevAndNext(
			paymentChannelTenorId, paymentChannelId, orderByComparator);
	}

	/**
	 * Removes all the payment channel tenors where paymentChannelId = &#63; from the database.
	 *
	 * @param paymentChannelId the payment channel ID
	 */
	public static void removeBysearchByPaymentChannelId(long paymentChannelId) {
		getPersistence().removeBysearchByPaymentChannelId(paymentChannelId);
	}

	/**
	 * Returns the number of payment channel tenors where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @return the number of matching payment channel tenors
	 */
	public static int countBysearchByPaymentChannelId(long paymentChannelId) {
		return getPersistence().countBysearchByPaymentChannelId(
			paymentChannelId);
	}

	/**
	 * Caches the payment channel tenor in the entity cache if it is enabled.
	 *
	 * @param paymentChannelTenor the payment channel tenor
	 */
	public static void cacheResult(PaymentChannelTenor paymentChannelTenor) {
		getPersistence().cacheResult(paymentChannelTenor);
	}

	/**
	 * Caches the payment channel tenors in the entity cache if it is enabled.
	 *
	 * @param paymentChannelTenors the payment channel tenors
	 */
	public static void cacheResult(
		List<PaymentChannelTenor> paymentChannelTenors) {

		getPersistence().cacheResult(paymentChannelTenors);
	}

	/**
	 * Creates a new payment channel tenor with the primary key. Does not add the payment channel tenor to the database.
	 *
	 * @param paymentChannelTenorId the primary key for the new payment channel tenor
	 * @return the new payment channel tenor
	 */
	public static PaymentChannelTenor create(long paymentChannelTenorId) {
		return getPersistence().create(paymentChannelTenorId);
	}

	/**
	 * Removes the payment channel tenor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param paymentChannelTenorId the primary key of the payment channel tenor
	 * @return the payment channel tenor that was removed
	 * @throws NoSuchPaymentChannelTenorException if a payment channel tenor with the primary key could not be found
	 */
	public static PaymentChannelTenor remove(long paymentChannelTenorId)
		throws com.mypage.admin.product.exception.
			NoSuchPaymentChannelTenorException {

		return getPersistence().remove(paymentChannelTenorId);
	}

	public static PaymentChannelTenor updateImpl(
		PaymentChannelTenor paymentChannelTenor) {

		return getPersistence().updateImpl(paymentChannelTenor);
	}

	/**
	 * Returns the payment channel tenor with the primary key or throws a <code>NoSuchPaymentChannelTenorException</code> if it could not be found.
	 *
	 * @param paymentChannelTenorId the primary key of the payment channel tenor
	 * @return the payment channel tenor
	 * @throws NoSuchPaymentChannelTenorException if a payment channel tenor with the primary key could not be found
	 */
	public static PaymentChannelTenor findByPrimaryKey(
			long paymentChannelTenorId)
		throws com.mypage.admin.product.exception.
			NoSuchPaymentChannelTenorException {

		return getPersistence().findByPrimaryKey(paymentChannelTenorId);
	}

	/**
	 * Returns the payment channel tenor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param paymentChannelTenorId the primary key of the payment channel tenor
	 * @return the payment channel tenor, or <code>null</code> if a payment channel tenor with the primary key could not be found
	 */
	public static PaymentChannelTenor fetchByPrimaryKey(
		long paymentChannelTenorId) {

		return getPersistence().fetchByPrimaryKey(paymentChannelTenorId);
	}

	/**
	 * Returns all the payment channel tenors.
	 *
	 * @return the payment channel tenors
	 */
	public static List<PaymentChannelTenor> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the payment channel tenors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelTenorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment channel tenors
	 * @param end the upper bound of the range of payment channel tenors (not inclusive)
	 * @return the range of payment channel tenors
	 */
	public static List<PaymentChannelTenor> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the payment channel tenors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelTenorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment channel tenors
	 * @param end the upper bound of the range of payment channel tenors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of payment channel tenors
	 */
	public static List<PaymentChannelTenor> findAll(
		int start, int end,
		OrderByComparator<PaymentChannelTenor> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the payment channel tenors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelTenorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment channel tenors
	 * @param end the upper bound of the range of payment channel tenors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of payment channel tenors
	 */
	public static List<PaymentChannelTenor> findAll(
		int start, int end,
		OrderByComparator<PaymentChannelTenor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the payment channel tenors from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of payment channel tenors.
	 *
	 * @return the number of payment channel tenors
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PaymentChannelTenorPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PaymentChannelTenorPersistence _persistence;

}