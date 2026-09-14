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

package com.axa.payment.service;

import com.axa.payment.model.PaymentTransaction;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PaymentTransaction. This utility wraps
 * <code>com.axa.payment.service.impl.PaymentTransactionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see PaymentTransactionLocalService
 * @generated
 */
public class PaymentTransactionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.axa.payment.service.impl.PaymentTransactionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the payment transaction to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentTransactionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param paymentTransaction the payment transaction
	 * @return the payment transaction that was added
	 */
	public static PaymentTransaction addPaymentTransaction(
		PaymentTransaction paymentTransaction) {

		return getService().addPaymentTransaction(paymentTransaction);
	}

	public static PaymentTransaction addTransaction(
		String policyNumber, String profileId, String invoiceNumber,
		String referenceNumber, String policyDueDate, double amount) {

		return getService().addTransaction(
			policyNumber, profileId, invoiceNumber, referenceNumber,
			policyDueDate, amount);
	}

	public static int countByPolicyProfileInvoice(
		String policyNumber, String profileId, String invoiceNumber) {

		return getService().countByPolicyProfileInvoice(
			policyNumber, profileId, invoiceNumber);
	}

	/**
	 * Creates a new payment transaction with the primary key. Does not add the payment transaction to the database.
	 *
	 * @param paymentTransactionId the primary key for the new payment transaction
	 * @return the new payment transaction
	 */
	public static PaymentTransaction createPaymentTransaction(
		long paymentTransactionId) {

		return getService().createPaymentTransaction(paymentTransactionId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the payment transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentTransactionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param paymentTransactionId the primary key of the payment transaction
	 * @return the payment transaction that was removed
	 * @throws PortalException if a payment transaction with the primary key could not be found
	 */
	public static PaymentTransaction deletePaymentTransaction(
			long paymentTransactionId)
		throws PortalException {

		return getService().deletePaymentTransaction(paymentTransactionId);
	}

	/**
	 * Deletes the payment transaction from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentTransactionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param paymentTransaction the payment transaction
	 * @return the payment transaction that was removed
	 */
	public static PaymentTransaction deletePaymentTransaction(
		PaymentTransaction paymentTransaction) {

		return getService().deletePaymentTransaction(paymentTransaction);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.axa.payment.model.impl.PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.axa.payment.model.impl.PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static PaymentTransaction fetchPaymentTransaction(
		long paymentTransactionId) {

		return getService().fetchPaymentTransaction(paymentTransactionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static PaymentTransaction getByInvoiceNumber(String invoiceNumber) {
		return getService().getByInvoiceNumber(invoiceNumber);
	}

	public static List<PaymentTransaction> getByPolicyProfile(
		String policyNumber, String profileId) {

		return getService().getByPolicyProfile(policyNumber, profileId);
	}

	public static List<PaymentTransaction> getByStatus(int limit) {
		return getService().getByStatus(limit);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Returns the payment transaction with the primary key.
	 *
	 * @param paymentTransactionId the primary key of the payment transaction
	 * @return the payment transaction
	 * @throws PortalException if a payment transaction with the primary key could not be found
	 */
	public static PaymentTransaction getPaymentTransaction(
			long paymentTransactionId)
		throws PortalException {

		return getService().getPaymentTransaction(paymentTransactionId);
	}

	/**
	 * Returns a range of all the payment transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.axa.payment.model.impl.PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @return the range of payment transactions
	 */
	public static List<PaymentTransaction> getPaymentTransactions(
		int start, int end) {

		return getService().getPaymentTransactions(start, end);
	}

	/**
	 * Returns the number of payment transactions.
	 *
	 * @return the number of payment transactions
	 */
	public static int getPaymentTransactionsCount() {
		return getService().getPaymentTransactionsCount();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the payment transaction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentTransactionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param paymentTransaction the payment transaction
	 * @return the payment transaction that was updated
	 */
	public static PaymentTransaction updatePaymentTransaction(
		PaymentTransaction paymentTransaction) {

		return getService().updatePaymentTransaction(paymentTransaction);
	}

	public static PaymentTransaction updateTransactionMethodChannel(
		String invoiceNumber, String requestId, String paymentMethod,
		String paymentChannel) {

		return getService().updateTransactionMethodChannel(
			invoiceNumber, requestId, paymentMethod, paymentChannel);
	}

	public static PaymentTransactionLocalService getService() {
		return _service;
	}

	private static volatile PaymentTransactionLocalService _service;

}