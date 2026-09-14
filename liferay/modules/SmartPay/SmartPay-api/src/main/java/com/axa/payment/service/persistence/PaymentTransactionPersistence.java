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

import com.axa.payment.exception.NoSuchPaymentTransactionException;
import com.axa.payment.model.PaymentTransaction;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the payment transaction service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PaymentTransactionUtil
 * @generated
 */
@ProviderType
public interface PaymentTransactionPersistence
	extends BasePersistence<PaymentTransaction> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PaymentTransactionUtil} to access the payment transaction persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the payment transactions where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @return the matching payment transactions
	 */
	public java.util.List<PaymentTransaction> findBypolicyProfile(
		String policyNumber, String profileId);

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
	public java.util.List<PaymentTransaction> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end);

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
	public java.util.List<PaymentTransaction> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentTransaction>
			orderByComparator);

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
	public java.util.List<PaymentTransaction> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentTransaction>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first payment transaction in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment transaction
	 * @throws NoSuchPaymentTransactionException if a matching payment transaction could not be found
	 */
	public PaymentTransaction findBypolicyProfile_First(
			String policyNumber, String profileId,
			com.liferay.portal.kernel.util.OrderByComparator<PaymentTransaction>
				orderByComparator)
		throws NoSuchPaymentTransactionException;

	/**
	 * Returns the first payment transaction in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment transaction, or <code>null</code> if a matching payment transaction could not be found
	 */
	public PaymentTransaction fetchBypolicyProfile_First(
		String policyNumber, String profileId,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentTransaction>
			orderByComparator);

	/**
	 * Returns the last payment transaction in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment transaction
	 * @throws NoSuchPaymentTransactionException if a matching payment transaction could not be found
	 */
	public PaymentTransaction findBypolicyProfile_Last(
			String policyNumber, String profileId,
			com.liferay.portal.kernel.util.OrderByComparator<PaymentTransaction>
				orderByComparator)
		throws NoSuchPaymentTransactionException;

	/**
	 * Returns the last payment transaction in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment transaction, or <code>null</code> if a matching payment transaction could not be found
	 */
	public PaymentTransaction fetchBypolicyProfile_Last(
		String policyNumber, String profileId,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentTransaction>
			orderByComparator);

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
	public PaymentTransaction[] findBypolicyProfile_PrevAndNext(
			long paymentTransactionId, String policyNumber, String profileId,
			com.liferay.portal.kernel.util.OrderByComparator<PaymentTransaction>
				orderByComparator)
		throws NoSuchPaymentTransactionException;

	/**
	 * Removes all the payment transactions where policyNumber = &#63; and profileId = &#63; from the database.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 */
	public void removeBypolicyProfile(String policyNumber, String profileId);

	/**
	 * Returns the number of payment transactions where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @return the number of matching payment transactions
	 */
	public int countBypolicyProfile(String policyNumber, String profileId);

	/**
	 * Returns all the payment transactions where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the matching payment transactions
	 */
	public java.util.List<PaymentTransaction> findByinvoiceNumber(
		String invoiceNumber);

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
	public java.util.List<PaymentTransaction> findByinvoiceNumber(
		String invoiceNumber, int start, int end);

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
	public java.util.List<PaymentTransaction> findByinvoiceNumber(
		String invoiceNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentTransaction>
			orderByComparator);

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
	public java.util.List<PaymentTransaction> findByinvoiceNumber(
		String invoiceNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentTransaction>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first payment transaction in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment transaction
	 * @throws NoSuchPaymentTransactionException if a matching payment transaction could not be found
	 */
	public PaymentTransaction findByinvoiceNumber_First(
			String invoiceNumber,
			com.liferay.portal.kernel.util.OrderByComparator<PaymentTransaction>
				orderByComparator)
		throws NoSuchPaymentTransactionException;

	/**
	 * Returns the first payment transaction in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment transaction, or <code>null</code> if a matching payment transaction could not be found
	 */
	public PaymentTransaction fetchByinvoiceNumber_First(
		String invoiceNumber,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentTransaction>
			orderByComparator);

	/**
	 * Returns the last payment transaction in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment transaction
	 * @throws NoSuchPaymentTransactionException if a matching payment transaction could not be found
	 */
	public PaymentTransaction findByinvoiceNumber_Last(
			String invoiceNumber,
			com.liferay.portal.kernel.util.OrderByComparator<PaymentTransaction>
				orderByComparator)
		throws NoSuchPaymentTransactionException;

	/**
	 * Returns the last payment transaction in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment transaction, or <code>null</code> if a matching payment transaction could not be found
	 */
	public PaymentTransaction fetchByinvoiceNumber_Last(
		String invoiceNumber,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentTransaction>
			orderByComparator);

	/**
	 * Returns the payment transactions before and after the current payment transaction in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param paymentTransactionId the primary key of the current payment transaction
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next payment transaction
	 * @throws NoSuchPaymentTransactionException if a payment transaction with the primary key could not be found
	 */
	public PaymentTransaction[] findByinvoiceNumber_PrevAndNext(
			long paymentTransactionId, String invoiceNumber,
			com.liferay.portal.kernel.util.OrderByComparator<PaymentTransaction>
				orderByComparator)
		throws NoSuchPaymentTransactionException;

	/**
	 * Removes all the payment transactions where invoiceNumber = &#63; from the database.
	 *
	 * @param invoiceNumber the invoice number
	 */
	public void removeByinvoiceNumber(String invoiceNumber);

	/**
	 * Returns the number of payment transactions where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the number of matching payment transactions
	 */
	public int countByinvoiceNumber(String invoiceNumber);

	/**
	 * Caches the payment transaction in the entity cache if it is enabled.
	 *
	 * @param paymentTransaction the payment transaction
	 */
	public void cacheResult(PaymentTransaction paymentTransaction);

	/**
	 * Caches the payment transactions in the entity cache if it is enabled.
	 *
	 * @param paymentTransactions the payment transactions
	 */
	public void cacheResult(
		java.util.List<PaymentTransaction> paymentTransactions);

	/**
	 * Creates a new payment transaction with the primary key. Does not add the payment transaction to the database.
	 *
	 * @param paymentTransactionId the primary key for the new payment transaction
	 * @return the new payment transaction
	 */
	public PaymentTransaction create(long paymentTransactionId);

	/**
	 * Removes the payment transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param paymentTransactionId the primary key of the payment transaction
	 * @return the payment transaction that was removed
	 * @throws NoSuchPaymentTransactionException if a payment transaction with the primary key could not be found
	 */
	public PaymentTransaction remove(long paymentTransactionId)
		throws NoSuchPaymentTransactionException;

	public PaymentTransaction updateImpl(PaymentTransaction paymentTransaction);

	/**
	 * Returns the payment transaction with the primary key or throws a <code>NoSuchPaymentTransactionException</code> if it could not be found.
	 *
	 * @param paymentTransactionId the primary key of the payment transaction
	 * @return the payment transaction
	 * @throws NoSuchPaymentTransactionException if a payment transaction with the primary key could not be found
	 */
	public PaymentTransaction findByPrimaryKey(long paymentTransactionId)
		throws NoSuchPaymentTransactionException;

	/**
	 * Returns the payment transaction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param paymentTransactionId the primary key of the payment transaction
	 * @return the payment transaction, or <code>null</code> if a payment transaction with the primary key could not be found
	 */
	public PaymentTransaction fetchByPrimaryKey(long paymentTransactionId);

	/**
	 * Returns all the payment transactions.
	 *
	 * @return the payment transactions
	 */
	public java.util.List<PaymentTransaction> findAll();

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
	public java.util.List<PaymentTransaction> findAll(int start, int end);

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
	public java.util.List<PaymentTransaction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentTransaction>
			orderByComparator);

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
	public java.util.List<PaymentTransaction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentTransaction>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the payment transactions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of payment transactions.
	 *
	 * @return the number of payment transactions
	 */
	public int countAll();

}