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

import com.mypage.admin.product.exception.NoSuchPaymentChannelException;
import com.mypage.admin.product.model.PaymentChannel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the payment channel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PaymentChannelUtil
 * @generated
 */
@ProviderType
public interface PaymentChannelPersistence
	extends BasePersistence<PaymentChannel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PaymentChannelUtil} to access the payment channel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the payment channels where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @return the matching payment channels
	 */
	public java.util.List<PaymentChannel> findBysearchByBank(
		long masterBankId, Integer active);

	/**
	 * Returns a range of all the payment channels where masterBankId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @return the range of matching payment channels
	 */
	public java.util.List<PaymentChannel> findBysearchByBank(
		long masterBankId, Integer active, int start, int end);

	/**
	 * Returns an ordered range of all the payment channels where masterBankId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching payment channels
	 */
	public java.util.List<PaymentChannel> findBysearchByBank(
		long masterBankId, Integer active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentChannel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the payment channels where masterBankId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching payment channels
	 */
	public java.util.List<PaymentChannel> findBysearchByBank(
		long masterBankId, Integer active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentChannel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first payment channel in the ordered set where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel
	 * @throws NoSuchPaymentChannelException if a matching payment channel could not be found
	 */
	public PaymentChannel findBysearchByBank_First(
			long masterBankId, Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<PaymentChannel>
				orderByComparator)
		throws NoSuchPaymentChannelException;

	/**
	 * Returns the first payment channel in the ordered set where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel, or <code>null</code> if a matching payment channel could not be found
	 */
	public PaymentChannel fetchBysearchByBank_First(
		long masterBankId, Integer active,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentChannel>
			orderByComparator);

	/**
	 * Returns the last payment channel in the ordered set where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel
	 * @throws NoSuchPaymentChannelException if a matching payment channel could not be found
	 */
	public PaymentChannel findBysearchByBank_Last(
			long masterBankId, Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<PaymentChannel>
				orderByComparator)
		throws NoSuchPaymentChannelException;

	/**
	 * Returns the last payment channel in the ordered set where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel, or <code>null</code> if a matching payment channel could not be found
	 */
	public PaymentChannel fetchBysearchByBank_Last(
		long masterBankId, Integer active,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentChannel>
			orderByComparator);

	/**
	 * Returns the payment channels before and after the current payment channel in the ordered set where masterBankId = &#63; and active = &#63;.
	 *
	 * @param paymentChannelId the primary key of the current payment channel
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next payment channel
	 * @throws NoSuchPaymentChannelException if a payment channel with the primary key could not be found
	 */
	public PaymentChannel[] findBysearchByBank_PrevAndNext(
			long paymentChannelId, long masterBankId, Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<PaymentChannel>
				orderByComparator)
		throws NoSuchPaymentChannelException;

	/**
	 * Removes all the payment channels where masterBankId = &#63; and active = &#63; from the database.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 */
	public void removeBysearchByBank(long masterBankId, Integer active);

	/**
	 * Returns the number of payment channels where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @return the number of matching payment channels
	 */
	public int countBysearchByBank(long masterBankId, Integer active);

	/**
	 * Returns all the payment channels where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @return the matching payment channels
	 */
	public java.util.List<PaymentChannel> findBysearchByIdAndCode(
		long paymentChannelId, String code);

	/**
	 * Returns a range of all the payment channels where paymentChannelId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @return the range of matching payment channels
	 */
	public java.util.List<PaymentChannel> findBysearchByIdAndCode(
		long paymentChannelId, String code, int start, int end);

	/**
	 * Returns an ordered range of all the payment channels where paymentChannelId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching payment channels
	 */
	public java.util.List<PaymentChannel> findBysearchByIdAndCode(
		long paymentChannelId, String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentChannel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the payment channels where paymentChannelId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching payment channels
	 */
	public java.util.List<PaymentChannel> findBysearchByIdAndCode(
		long paymentChannelId, String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentChannel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first payment channel in the ordered set where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel
	 * @throws NoSuchPaymentChannelException if a matching payment channel could not be found
	 */
	public PaymentChannel findBysearchByIdAndCode_First(
			long paymentChannelId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<PaymentChannel>
				orderByComparator)
		throws NoSuchPaymentChannelException;

	/**
	 * Returns the first payment channel in the ordered set where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel, or <code>null</code> if a matching payment channel could not be found
	 */
	public PaymentChannel fetchBysearchByIdAndCode_First(
		long paymentChannelId, String code,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentChannel>
			orderByComparator);

	/**
	 * Returns the last payment channel in the ordered set where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel
	 * @throws NoSuchPaymentChannelException if a matching payment channel could not be found
	 */
	public PaymentChannel findBysearchByIdAndCode_Last(
			long paymentChannelId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<PaymentChannel>
				orderByComparator)
		throws NoSuchPaymentChannelException;

	/**
	 * Returns the last payment channel in the ordered set where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel, or <code>null</code> if a matching payment channel could not be found
	 */
	public PaymentChannel fetchBysearchByIdAndCode_Last(
		long paymentChannelId, String code,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentChannel>
			orderByComparator);

	/**
	 * Removes all the payment channels where paymentChannelId = &#63; and code = &#63; from the database.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 */
	public void removeBysearchByIdAndCode(long paymentChannelId, String code);

	/**
	 * Returns the number of payment channels where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @return the number of matching payment channels
	 */
	public int countBysearchByIdAndCode(long paymentChannelId, String code);

	/**
	 * Caches the payment channel in the entity cache if it is enabled.
	 *
	 * @param paymentChannel the payment channel
	 */
	public void cacheResult(PaymentChannel paymentChannel);

	/**
	 * Caches the payment channels in the entity cache if it is enabled.
	 *
	 * @param paymentChannels the payment channels
	 */
	public void cacheResult(java.util.List<PaymentChannel> paymentChannels);

	/**
	 * Creates a new payment channel with the primary key. Does not add the payment channel to the database.
	 *
	 * @param paymentChannelId the primary key for the new payment channel
	 * @return the new payment channel
	 */
	public PaymentChannel create(long paymentChannelId);

	/**
	 * Removes the payment channel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param paymentChannelId the primary key of the payment channel
	 * @return the payment channel that was removed
	 * @throws NoSuchPaymentChannelException if a payment channel with the primary key could not be found
	 */
	public PaymentChannel remove(long paymentChannelId)
		throws NoSuchPaymentChannelException;

	public PaymentChannel updateImpl(PaymentChannel paymentChannel);

	/**
	 * Returns the payment channel with the primary key or throws a <code>NoSuchPaymentChannelException</code> if it could not be found.
	 *
	 * @param paymentChannelId the primary key of the payment channel
	 * @return the payment channel
	 * @throws NoSuchPaymentChannelException if a payment channel with the primary key could not be found
	 */
	public PaymentChannel findByPrimaryKey(long paymentChannelId)
		throws NoSuchPaymentChannelException;

	/**
	 * Returns the payment channel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param paymentChannelId the primary key of the payment channel
	 * @return the payment channel, or <code>null</code> if a payment channel with the primary key could not be found
	 */
	public PaymentChannel fetchByPrimaryKey(long paymentChannelId);

	/**
	 * Returns all the payment channels.
	 *
	 * @return the payment channels
	 */
	public java.util.List<PaymentChannel> findAll();

	/**
	 * Returns a range of all the payment channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @return the range of payment channels
	 */
	public java.util.List<PaymentChannel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the payment channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of payment channels
	 */
	public java.util.List<PaymentChannel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentChannel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the payment channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of payment channels
	 */
	public java.util.List<PaymentChannel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PaymentChannel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the payment channels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of payment channels.
	 *
	 * @return the number of payment channels
	 */
	public int countAll();

}