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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PaymentTransactionLocalService}.
 *
 * @author Gositus Team
 * @see PaymentTransactionLocalService
 * @generated
 */
public class PaymentTransactionLocalServiceWrapper
	implements PaymentTransactionLocalService,
			   ServiceWrapper<PaymentTransactionLocalService> {

	public PaymentTransactionLocalServiceWrapper(
		PaymentTransactionLocalService paymentTransactionLocalService) {

		_paymentTransactionLocalService = paymentTransactionLocalService;
	}

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
	@Override
	public com.axa.payment.model.PaymentTransaction addPaymentTransaction(
		com.axa.payment.model.PaymentTransaction paymentTransaction) {

		return _paymentTransactionLocalService.addPaymentTransaction(
			paymentTransaction);
	}

	@Override
	public com.axa.payment.model.PaymentTransaction addTransaction(
		String policyNumber, String profileId, String invoiceNumber,
		String referenceNumber, String policyDueDate, double amount) {

		return _paymentTransactionLocalService.addTransaction(
			policyNumber, profileId, invoiceNumber, referenceNumber,
			policyDueDate, amount);
	}

	@Override
	public int countByPolicyProfileInvoice(
		String policyNumber, String profileId, String invoiceNumber) {

		return _paymentTransactionLocalService.countByPolicyProfileInvoice(
			policyNumber, profileId, invoiceNumber);
	}

	/**
	 * Creates a new payment transaction with the primary key. Does not add the payment transaction to the database.
	 *
	 * @param paymentTransactionId the primary key for the new payment transaction
	 * @return the new payment transaction
	 */
	@Override
	public com.axa.payment.model.PaymentTransaction createPaymentTransaction(
		long paymentTransactionId) {

		return _paymentTransactionLocalService.createPaymentTransaction(
			paymentTransactionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentTransactionLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.axa.payment.model.PaymentTransaction deletePaymentTransaction(
			long paymentTransactionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentTransactionLocalService.deletePaymentTransaction(
			paymentTransactionId);
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
	@Override
	public com.axa.payment.model.PaymentTransaction deletePaymentTransaction(
		com.axa.payment.model.PaymentTransaction paymentTransaction) {

		return _paymentTransactionLocalService.deletePaymentTransaction(
			paymentTransaction);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentTransactionLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _paymentTransactionLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _paymentTransactionLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _paymentTransactionLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _paymentTransactionLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _paymentTransactionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _paymentTransactionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.axa.payment.model.PaymentTransaction fetchPaymentTransaction(
		long paymentTransactionId) {

		return _paymentTransactionLocalService.fetchPaymentTransaction(
			paymentTransactionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _paymentTransactionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.axa.payment.model.PaymentTransaction getByInvoiceNumber(
		String invoiceNumber) {

		return _paymentTransactionLocalService.getByInvoiceNumber(
			invoiceNumber);
	}

	@Override
	public java.util.List<com.axa.payment.model.PaymentTransaction>
		getByPolicyProfile(String policyNumber, String profileId) {

		return _paymentTransactionLocalService.getByPolicyProfile(
			policyNumber, profileId);
	}

	@Override
	public java.util.List<com.axa.payment.model.PaymentTransaction> getByStatus(
		int limit) {

		return _paymentTransactionLocalService.getByStatus(limit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _paymentTransactionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _paymentTransactionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the payment transaction with the primary key.
	 *
	 * @param paymentTransactionId the primary key of the payment transaction
	 * @return the payment transaction
	 * @throws PortalException if a payment transaction with the primary key could not be found
	 */
	@Override
	public com.axa.payment.model.PaymentTransaction getPaymentTransaction(
			long paymentTransactionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentTransactionLocalService.getPaymentTransaction(
			paymentTransactionId);
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
	@Override
	public java.util.List<com.axa.payment.model.PaymentTransaction>
		getPaymentTransactions(int start, int end) {

		return _paymentTransactionLocalService.getPaymentTransactions(
			start, end);
	}

	/**
	 * Returns the number of payment transactions.
	 *
	 * @return the number of payment transactions
	 */
	@Override
	public int getPaymentTransactionsCount() {
		return _paymentTransactionLocalService.getPaymentTransactionsCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentTransactionLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.axa.payment.model.PaymentTransaction updatePaymentTransaction(
		com.axa.payment.model.PaymentTransaction paymentTransaction) {

		return _paymentTransactionLocalService.updatePaymentTransaction(
			paymentTransaction);
	}

	@Override
	public com.axa.payment.model.PaymentTransaction
		updateTransactionMethodChannel(
			String invoiceNumber, String requestId, String paymentMethod,
			String paymentChannel) {

		return _paymentTransactionLocalService.updateTransactionMethodChannel(
			invoiceNumber, requestId, paymentMethod, paymentChannel);
	}

	@Override
	public PaymentTransactionLocalService getWrappedService() {
		return _paymentTransactionLocalService;
	}

	@Override
	public void setWrappedService(
		PaymentTransactionLocalService paymentTransactionLocalService) {

		_paymentTransactionLocalService = paymentTransactionLocalService;
	}

	private PaymentTransactionLocalService _paymentTransactionLocalService;

}