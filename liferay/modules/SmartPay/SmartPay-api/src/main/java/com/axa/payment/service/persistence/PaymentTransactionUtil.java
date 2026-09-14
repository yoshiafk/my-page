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

package com.axa.payment.service.persistence;

import com.axa.payment.model.PaymentTransaction;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the payment transaction service. This utility wraps <code>com.axa.payment.service.persistence.impl.PaymentTransactionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PaymentTransactionPersistence
 * @generated
 */
public class PaymentTransactionUtil {

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
	public static void clearCache(PaymentTransaction paymentTransaction) {
		getPersistence().clearCache(paymentTransaction);
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
	public static Map<Serializable, PaymentTransaction> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PaymentTransaction> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PaymentTransaction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PaymentTransaction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PaymentTransaction> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PaymentTransaction update(
		PaymentTransaction paymentTransaction) {

		return getPersistence().update(paymentTransaction);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PaymentTransaction update(
		PaymentTransaction paymentTransaction, ServiceContext serviceContext) {

		return getPersistence().update(paymentTransaction, serviceContext);
	}

	/**
	 * Returns all the payment transactions where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @return the matching payment transactions
	 */
	public static List<PaymentTransaction> findBypolicyProfile(
		String policyNumber, String profileId) {

		return getPersistence().findBypolicyProfile(policyNumber, profileId);
	}

	/**
	 * Returns a range of all the payment transactions where policyNumber = &#63; and profileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @return the range of matching payment transactions
	 */
	public static List<PaymentTransaction> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end) {

		return getPersistence().findBypolicyProfile(
			policyNumber, profileId, start, end);
	}

	/**
	 * Returns an ordered range of all the payment transactions where policyNumber = &#63; and profileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching payment transactions
	 */
	public static List<PaymentTransaction> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end,
		OrderByComparator<PaymentTransaction> orderByComparator) {

		return getPersistence().findBypolicyProfile(
			policyNumber, profileId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the payment transactions where policyNumber = &#63; and profileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching payment transactions
	 */
	public static List<PaymentTransaction> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end,
		OrderByComparator<PaymentTransaction> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBypolicyProfile(
			policyNumber, profileId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first payment transaction in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment transaction
	 * @throws NoSuchPaymentTransactionException if a matching payment transaction could not be found
	 */
	public static PaymentTransaction findBypolicyProfile_First(
			String policyNumber, String profileId,
			OrderByComparator<PaymentTransaction> orderByComparator)
		throws com.axa.payment.exception.NoSuchPaymentTransactionException {

		return getPersistence().findBypolicyProfile_First(
			policyNumber, profileId, orderByComparator);
	}

	/**
	 * Returns the first payment transaction in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment transaction, or <code>null</code> if a matching payment transaction could not be found
	 */
	public static PaymentTransaction fetchBypolicyProfile_First(
		String policyNumber, String profileId,
		OrderByComparator<PaymentTransaction> orderByComparator) {

		return getPersistence().fetchBypolicyProfile_First(
			policyNumber, profileId, orderByComparator);
	}

	/**
	 * Returns the last payment transaction in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment transaction
	 * @throws NoSuchPaymentTransactionException if a matching payment transaction could not be found
	 */
	public static PaymentTransaction findBypolicyProfile_Last(
			String policyNumber, String profileId,
			OrderByComparator<PaymentTransaction> orderByComparator)
		throws com.axa.payment.exception.NoSuchPaymentTransactionException {

		return getPersistence().findBypolicyProfile_Last(
			policyNumber, profileId, orderByComparator);
	}

	/**
	 * Returns the last payment transaction in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment transaction, or <code>null</code> if a matching payment transaction could not be found
	 */
	public static PaymentTransaction fetchBypolicyProfile_Last(
		String policyNumber, String profileId,
		OrderByComparator<PaymentTransaction> orderByComparator) {

		return getPersistence().fetchBypolicyProfile_Last(
			policyNumber, profileId, orderByComparator);
	}

	/**
	 * Returns the payment transactions before and after the current payment transaction in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param paymentTransactionId the primary key of the current payment transaction
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next payment transaction
	 * @throws NoSuchPaymentTransactionException if a payment transaction with the primary key could not be found
	 */
	public static PaymentTransaction[] findBypolicyProfile_PrevAndNext(
			long paymentTransactionId, String policyNumber, String profileId,
			OrderByComparator<PaymentTransaction> orderByComparator)
		throws com.axa.payment.exception.NoSuchPaymentTransactionException {

		return getPersistence().findBypolicyProfile_PrevAndNext(
			paymentTransactionId, policyNumber, profileId, orderByComparator);
	}

	/**
	 * Removes all the payment transactions where policyNumber = &#63; and profileId = &#63; from the database.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 */
	public static void removeBypolicyProfile(
		String policyNumber, String profileId) {

		getPersistence().removeBypolicyProfile(policyNumber, profileId);
	}

	/**
	 * Returns the number of payment transactions where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @return the number of matching payment transactions
	 */
	public static int countBypolicyProfile(
		String policyNumber, String profileId) {

		return getPersistence().countBypolicyProfile(policyNumber, profileId);
	}

	/**
	 * Returns all the payment transactions where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the matching payment transactions
	 */
	public static List<PaymentTransaction> findByinvoiceNumber(
		String invoiceNumber) {

		return getPersistence().findByinvoiceNumber(invoiceNumber);
	}

	/**
	 * Returns a range of all the payment transactions where invoiceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceNumber the invoice number
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @return the range of matching payment transactions
	 */
	public static List<PaymentTransaction> findByinvoiceNumber(
		String invoiceNumber, int start, int end) {

		return getPersistence().findByinvoiceNumber(invoiceNumber, start, end);
	}

	/**
	 * Returns an ordered range of all the payment transactions where invoiceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceNumber the invoice number
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching payment transactions
	 */
	public static List<PaymentTransaction> findByinvoiceNumber(
		String invoiceNumber, int start, int end,
		OrderByComparator<PaymentTransaction> orderByComparator) {

		return getPersistence().findByinvoiceNumber(
			invoiceNumber, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the payment transactions where invoiceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceNumber the invoice number
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching payment transactions
	 */
	public static List<PaymentTransaction> findByinvoiceNumber(
		String invoiceNumber, int start, int end,
		OrderByComparator<PaymentTransaction> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByinvoiceNumber(
			invoiceNumber, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first payment transaction in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment transaction
	 * @throws NoSuchPaymentTransactionException if a matching payment transaction could not be found
	 */
	public static PaymentTransaction findByinvoiceNumber_First(
			String invoiceNumber,
			OrderByComparator<PaymentTransaction> orderByComparator)
		throws com.axa.payment.exception.NoSuchPaymentTransactionException {

		return getPersistence().findByinvoiceNumber_First(
			invoiceNumber, orderByComparator);
	}

	/**
	 * Returns the first payment transaction in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment transaction, or <code>null</code> if a matching payment transaction could not be found
	 */
	public static PaymentTransaction fetchByinvoiceNumber_First(
		String invoiceNumber,
		OrderByComparator<PaymentTransaction> orderByComparator) {

		return getPersistence().fetchByinvoiceNumber_First(
			invoiceNumber, orderByComparator);
	}

	/**
	 * Returns the last payment transaction in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment transaction
	 * @throws NoSuchPaymentTransactionException if a matching payment transaction could not be found
	 */
	public static PaymentTransaction findByinvoiceNumber_Last(
			String invoiceNumber,
			OrderByComparator<PaymentTransaction> orderByComparator)
		throws com.axa.payment.exception.NoSuchPaymentTransactionException {

		return getPersistence().findByinvoiceNumber_Last(
			invoiceNumber, orderByComparator);
	}

	/**
	 * Returns the last payment transaction in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment transaction, or <code>null</code> if a matching payment transaction could not be found
	 */
	public static PaymentTransaction fetchByinvoiceNumber_Last(
		String invoiceNumber,
		OrderByComparator<PaymentTransaction> orderByComparator) {

		return getPersistence().fetchByinvoiceNumber_Last(
			invoiceNumber, orderByComparator);
	}

	/**
	 * Returns the payment transactions before and after the current payment transaction in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param paymentTransactionId the primary key of the current payment transaction
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next payment transaction
	 * @throws NoSuchPaymentTransactionException if a payment transaction with the primary key could not be found
	 */
	public static PaymentTransaction[] findByinvoiceNumber_PrevAndNext(
			long paymentTransactionId, String invoiceNumber,
			OrderByComparator<PaymentTransaction> orderByComparator)
		throws com.axa.payment.exception.NoSuchPaymentTransactionException {

		return getPersistence().findByinvoiceNumber_PrevAndNext(
			paymentTransactionId, invoiceNumber, orderByComparator);
	}

	/**
	 * Removes all the payment transactions where invoiceNumber = &#63; from the database.
	 *
	 * @param invoiceNumber the invoice number
	 */
	public static void removeByinvoiceNumber(String invoiceNumber) {
		getPersistence().removeByinvoiceNumber(invoiceNumber);
	}

	/**
	 * Returns the number of payment transactions where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the number of matching payment transactions
	 */
	public static int countByinvoiceNumber(String invoiceNumber) {
		return getPersistence().countByinvoiceNumber(invoiceNumber);
	}

	/**
	 * Caches the payment transaction in the entity cache if it is enabled.
	 *
	 * @param paymentTransaction the payment transaction
	 */
	public static void cacheResult(PaymentTransaction paymentTransaction) {
		getPersistence().cacheResult(paymentTransaction);
	}

	/**
	 * Caches the payment transactions in the entity cache if it is enabled.
	 *
	 * @param paymentTransactions the payment transactions
	 */
	public static void cacheResult(
		List<PaymentTransaction> paymentTransactions) {

		getPersistence().cacheResult(paymentTransactions);
	}

	/**
	 * Creates a new payment transaction with the primary key. Does not add the payment transaction to the database.
	 *
	 * @param paymentTransactionId the primary key for the new payment transaction
	 * @return the new payment transaction
	 */
	public static PaymentTransaction create(long paymentTransactionId) {
		return getPersistence().create(paymentTransactionId);
	}

	/**
	 * Removes the payment transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param paymentTransactionId the primary key of the payment transaction
	 * @return the payment transaction that was removed
	 * @throws NoSuchPaymentTransactionException if a payment transaction with the primary key could not be found
	 */
	public static PaymentTransaction remove(long paymentTransactionId)
		throws com.axa.payment.exception.NoSuchPaymentTransactionException {

		return getPersistence().remove(paymentTransactionId);
	}

	public static PaymentTransaction updateImpl(
		PaymentTransaction paymentTransaction) {

		return getPersistence().updateImpl(paymentTransaction);
	}

	/**
	 * Returns the payment transaction with the primary key or throws a <code>NoSuchPaymentTransactionException</code> if it could not be found.
	 *
	 * @param paymentTransactionId the primary key of the payment transaction
	 * @return the payment transaction
	 * @throws NoSuchPaymentTransactionException if a payment transaction with the primary key could not be found
	 */
	public static PaymentTransaction findByPrimaryKey(long paymentTransactionId)
		throws com.axa.payment.exception.NoSuchPaymentTransactionException {

		return getPersistence().findByPrimaryKey(paymentTransactionId);
	}

	/**
	 * Returns the payment transaction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param paymentTransactionId the primary key of the payment transaction
	 * @return the payment transaction, or <code>null</code> if a payment transaction with the primary key could not be found
	 */
	public static PaymentTransaction fetchByPrimaryKey(
		long paymentTransactionId) {

		return getPersistence().fetchByPrimaryKey(paymentTransactionId);
	}

	/**
	 * Returns all the payment transactions.
	 *
	 * @return the payment transactions
	 */
	public static List<PaymentTransaction> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the payment transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @return the range of payment transactions
	 */
	public static List<PaymentTransaction> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the payment transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of payment transactions
	 */
	public static List<PaymentTransaction> findAll(
		int start, int end,
		OrderByComparator<PaymentTransaction> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the payment transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of payment transactions
	 */
	public static List<PaymentTransaction> findAll(
		int start, int end,
		OrderByComparator<PaymentTransaction> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the payment transactions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of payment transactions.
	 *
	 * @return the number of payment transactions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PaymentTransactionPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PaymentTransactionPersistence _persistence;

}