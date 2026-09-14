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

package com.mypage.leads.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.leads.model.Payment;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the payment service. This utility wraps <code>com.mypage.leads.service.persistence.impl.PaymentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see PaymentPersistence
 * @generated
 */
public class PaymentUtil {

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
	public static void clearCache(Payment payment) {
		getPersistence().clearCache(payment);
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
	public static Map<Serializable, Payment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Payment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Payment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Payment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Payment> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Payment update(Payment payment) {
		return getPersistence().update(payment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Payment update(
		Payment payment, ServiceContext serviceContext) {

		return getPersistence().update(payment, serviceContext);
	}

	/**
	 * Returns the payment where LeadsId = &#63; or throws a <code>NoSuchPaymentException</code> if it could not be found.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching payment
	 * @throws NoSuchPaymentException if a matching payment could not be found
	 */
	public static Payment findBysearchByLeadsId(long LeadsId)
		throws com.mypage.leads.exception.NoSuchPaymentException {

		return getPersistence().findBysearchByLeadsId(LeadsId);
	}

	/**
	 * Returns the payment where LeadsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching payment, or <code>null</code> if a matching payment could not be found
	 */
	public static Payment fetchBysearchByLeadsId(long LeadsId) {
		return getPersistence().fetchBysearchByLeadsId(LeadsId);
	}

	/**
	 * Returns the payment where LeadsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching payment, or <code>null</code> if a matching payment could not be found
	 */
	public static Payment fetchBysearchByLeadsId(
		long LeadsId, boolean useFinderCache) {

		return getPersistence().fetchBysearchByLeadsId(LeadsId, useFinderCache);
	}

	/**
	 * Removes the payment where LeadsId = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 * @return the payment that was removed
	 */
	public static Payment removeBysearchByLeadsId(long LeadsId)
		throws com.mypage.leads.exception.NoSuchPaymentException {

		return getPersistence().removeBysearchByLeadsId(LeadsId);
	}

	/**
	 * Returns the number of payments where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the number of matching payments
	 */
	public static int countBysearchByLeadsId(long LeadsId) {
		return getPersistence().countBysearchByLeadsId(LeadsId);
	}

	/**
	 * Returns the payment where TransactionId = &#63; or throws a <code>NoSuchPaymentException</code> if it could not be found.
	 *
	 * @param TransactionId the transaction ID
	 * @return the matching payment
	 * @throws NoSuchPaymentException if a matching payment could not be found
	 */
	public static Payment findBysearchByTransactionId(String TransactionId)
		throws com.mypage.leads.exception.NoSuchPaymentException {

		return getPersistence().findBysearchByTransactionId(TransactionId);
	}

	/**
	 * Returns the payment where TransactionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param TransactionId the transaction ID
	 * @return the matching payment, or <code>null</code> if a matching payment could not be found
	 */
	public static Payment fetchBysearchByTransactionId(String TransactionId) {
		return getPersistence().fetchBysearchByTransactionId(TransactionId);
	}

	/**
	 * Returns the payment where TransactionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param TransactionId the transaction ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching payment, or <code>null</code> if a matching payment could not be found
	 */
	public static Payment fetchBysearchByTransactionId(
		String TransactionId, boolean useFinderCache) {

		return getPersistence().fetchBysearchByTransactionId(
			TransactionId, useFinderCache);
	}

	/**
	 * Removes the payment where TransactionId = &#63; from the database.
	 *
	 * @param TransactionId the transaction ID
	 * @return the payment that was removed
	 */
	public static Payment removeBysearchByTransactionId(String TransactionId)
		throws com.mypage.leads.exception.NoSuchPaymentException {

		return getPersistence().removeBysearchByTransactionId(TransactionId);
	}

	/**
	 * Returns the number of payments where TransactionId = &#63;.
	 *
	 * @param TransactionId the transaction ID
	 * @return the number of matching payments
	 */
	public static int countBysearchByTransactionId(String TransactionId) {
		return getPersistence().countBysearchByTransactionId(TransactionId);
	}

	/**
	 * Caches the payment in the entity cache if it is enabled.
	 *
	 * @param payment the payment
	 */
	public static void cacheResult(Payment payment) {
		getPersistence().cacheResult(payment);
	}

	/**
	 * Caches the payments in the entity cache if it is enabled.
	 *
	 * @param payments the payments
	 */
	public static void cacheResult(List<Payment> payments) {
		getPersistence().cacheResult(payments);
	}

	/**
	 * Creates a new payment with the primary key. Does not add the payment to the database.
	 *
	 * @param paymentId the primary key for the new payment
	 * @return the new payment
	 */
	public static Payment create(long paymentId) {
		return getPersistence().create(paymentId);
	}

	/**
	 * Removes the payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment that was removed
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	public static Payment remove(long paymentId)
		throws com.mypage.leads.exception.NoSuchPaymentException {

		return getPersistence().remove(paymentId);
	}

	public static Payment updateImpl(Payment payment) {
		return getPersistence().updateImpl(payment);
	}

	/**
	 * Returns the payment with the primary key or throws a <code>NoSuchPaymentException</code> if it could not be found.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	public static Payment findByPrimaryKey(long paymentId)
		throws com.mypage.leads.exception.NoSuchPaymentException {

		return getPersistence().findByPrimaryKey(paymentId);
	}

	/**
	 * Returns the payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment, or <code>null</code> if a payment with the primary key could not be found
	 */
	public static Payment fetchByPrimaryKey(long paymentId) {
		return getPersistence().fetchByPrimaryKey(paymentId);
	}

	/**
	 * Returns all the payments.
	 *
	 * @return the payments
	 */
	public static List<Payment> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @return the range of payments
	 */
	public static List<Payment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of payments
	 */
	public static List<Payment> findAll(
		int start, int end, OrderByComparator<Payment> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of payments
	 */
	public static List<Payment> findAll(
		int start, int end, OrderByComparator<Payment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the payments from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of payments.
	 *
	 * @return the number of payments
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PaymentPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PaymentPersistence _persistence;

}