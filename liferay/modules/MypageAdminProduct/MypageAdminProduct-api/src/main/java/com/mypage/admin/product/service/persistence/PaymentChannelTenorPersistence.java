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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.admin.product.exception.NoSuchPaymentChannelTenorException;
import com.mypage.admin.product.model.PaymentChannelTenor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the payment channel tenor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PaymentChannelTenorUtil
 * @generated
 */
@ProviderType
public interface PaymentChannelTenorPersistence
	extends BasePersistence<PaymentChannelTenor> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PaymentChannelTenorUtil} to access the payment channel tenor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the payment channel tenors where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @return the matching payment channel tenors
	 */
	public java.util.List<PaymentChannelTenor> findBysearchByPaymentChannelId(
		long paymentChannelId);

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
	public java.util.List<PaymentChannelTenor> findBysearchByPaymentChannelId(
		long paymentChannelId, int start, int end);

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
	public java.util.List<PaymentChannelTenor> findBysearchByPaymentChannelId(
		long paymentChannelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentChannelTenor>
			orderByComparator);

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
	public java.util.List<PaymentChannelTenor> findBysearchByPaymentChannelId(
		long paymentChannelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentChannelTenor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first payment channel tenor in the ordered set where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel tenor
	 * @throws NoSuchPaymentChannelTenorException if a matching payment channel tenor could not be found
	 */
	public PaymentChannelTenor findBysearchByPaymentChannelId_First(
			long paymentChannelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PaymentChannelTenor> orderByComparator)
		throws NoSuchPaymentChannelTenorException;

	/**
	 * Returns the first payment channel tenor in the ordered set where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel tenor, or <code>null</code> if a matching payment channel tenor could not be found
	 */
	public PaymentChannelTenor fetchBysearchByPaymentChannelId_First(
		long paymentChannelId,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentChannelTenor>
			orderByComparator);

	/**
	 * Returns the last payment channel tenor in the ordered set where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel tenor
	 * @throws NoSuchPaymentChannelTenorException if a matching payment channel tenor could not be found
	 */
	public PaymentChannelTenor findBysearchByPaymentChannelId_Last(
			long paymentChannelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PaymentChannelTenor> orderByComparator)
		throws NoSuchPaymentChannelTenorException;

	/**
	 * Returns the last payment channel tenor in the ordered set where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel tenor, or <code>null</code> if a matching payment channel tenor could not be found
	 */
	public PaymentChannelTenor fetchBysearchByPaymentChannelId_Last(
		long paymentChannelId,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentChannelTenor>
			orderByComparator);

	/**
	 * Returns the payment channel tenors before and after the current payment channel tenor in the ordered set where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelTenorId the primary key of the current payment channel tenor
	 * @param paymentChannelId the payment channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next payment channel tenor
	 * @throws NoSuchPaymentChannelTenorException if a payment channel tenor with the primary key could not be found
	 */
	public PaymentChannelTenor[] findBysearchByPaymentChannelId_PrevAndNext(
			long paymentChannelTenorId, long paymentChannelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PaymentChannelTenor> orderByComparator)
		throws NoSuchPaymentChannelTenorException;

	/**
	 * Removes all the payment channel tenors where paymentChannelId = &#63; from the database.
	 *
	 * @param paymentChannelId the payment channel ID
	 */
	public void removeBysearchByPaymentChannelId(long paymentChannelId);

	/**
	 * Returns the number of payment channel tenors where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @return the number of matching payment channel tenors
	 */
	public int countBysearchByPaymentChannelId(long paymentChannelId);

	/**
	 * Caches the payment channel tenor in the entity cache if it is enabled.
	 *
	 * @param paymentChannelTenor the payment channel tenor
	 */
	public void cacheResult(PaymentChannelTenor paymentChannelTenor);

	/**
	 * Caches the payment channel tenors in the entity cache if it is enabled.
	 *
	 * @param paymentChannelTenors the payment channel tenors
	 */
	public void cacheResult(
		java.util.List<PaymentChannelTenor> paymentChannelTenors);

	/**
	 * Creates a new payment channel tenor with the primary key. Does not add the payment channel tenor to the database.
	 *
	 * @param paymentChannelTenorId the primary key for the new payment channel tenor
	 * @return the new payment channel tenor
	 */
	public PaymentChannelTenor create(long paymentChannelTenorId);

	/**
	 * Removes the payment channel tenor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param paymentChannelTenorId the primary key of the payment channel tenor
	 * @return the payment channel tenor that was removed
	 * @throws NoSuchPaymentChannelTenorException if a payment channel tenor with the primary key could not be found
	 */
	public PaymentChannelTenor remove(long paymentChannelTenorId)
		throws NoSuchPaymentChannelTenorException;

	public PaymentChannelTenor updateImpl(
		PaymentChannelTenor paymentChannelTenor);

	/**
	 * Returns the payment channel tenor with the primary key or throws a <code>NoSuchPaymentChannelTenorException</code> if it could not be found.
	 *
	 * @param paymentChannelTenorId the primary key of the payment channel tenor
	 * @return the payment channel tenor
	 * @throws NoSuchPaymentChannelTenorException if a payment channel tenor with the primary key could not be found
	 */
	public PaymentChannelTenor findByPrimaryKey(long paymentChannelTenorId)
		throws NoSuchPaymentChannelTenorException;

	/**
	 * Returns the payment channel tenor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param paymentChannelTenorId the primary key of the payment channel tenor
	 * @return the payment channel tenor, or <code>null</code> if a payment channel tenor with the primary key could not be found
	 */
	public PaymentChannelTenor fetchByPrimaryKey(long paymentChannelTenorId);

	/**
	 * Returns all the payment channel tenors.
	 *
	 * @return the payment channel tenors
	 */
	public java.util.List<PaymentChannelTenor> findAll();

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
	public java.util.List<PaymentChannelTenor> findAll(int start, int end);

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
	public java.util.List<PaymentChannelTenor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentChannelTenor>
			orderByComparator);

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
	public java.util.List<PaymentChannelTenor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentChannelTenor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the payment channel tenors from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of payment channel tenors.
	 *
	 * @return the number of payment channel tenors
	 */
	public int countAll();

}