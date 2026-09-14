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

import com.mypage.admin.product.model.PaymentChannel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the payment channel service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.PaymentChannelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PaymentChannelPersistence
 * @generated
 */
public class PaymentChannelUtil {

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
	public static void clearCache(PaymentChannel paymentChannel) {
		getPersistence().clearCache(paymentChannel);
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
	public static Map<Serializable, PaymentChannel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PaymentChannel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PaymentChannel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PaymentChannel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PaymentChannel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PaymentChannel update(PaymentChannel paymentChannel) {
		return getPersistence().update(paymentChannel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PaymentChannel update(
		PaymentChannel paymentChannel, ServiceContext serviceContext) {

		return getPersistence().update(paymentChannel, serviceContext);
	}

	/**
	 * Returns all the payment channels where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @return the matching payment channels
	 */
	public static List<PaymentChannel> findBysearchByBank(
		long masterBankId, Integer active) {

		return getPersistence().findBysearchByBank(masterBankId, active);
	}

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
	public static List<PaymentChannel> findBysearchByBank(
		long masterBankId, Integer active, int start, int end) {

		return getPersistence().findBysearchByBank(
			masterBankId, active, start, end);
	}

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
	public static List<PaymentChannel> findBysearchByBank(
		long masterBankId, Integer active, int start, int end,
		OrderByComparator<PaymentChannel> orderByComparator) {

		return getPersistence().findBysearchByBank(
			masterBankId, active, start, end, orderByComparator);
	}

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
	public static List<PaymentChannel> findBysearchByBank(
		long masterBankId, Integer active, int start, int end,
		OrderByComparator<PaymentChannel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchByBank(
			masterBankId, active, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first payment channel in the ordered set where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel
	 * @throws NoSuchPaymentChannelException if a matching payment channel could not be found
	 */
	public static PaymentChannel findBysearchByBank_First(
			long masterBankId, Integer active,
			OrderByComparator<PaymentChannel> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchPaymentChannelException {

		return getPersistence().findBysearchByBank_First(
			masterBankId, active, orderByComparator);
	}

	/**
	 * Returns the first payment channel in the ordered set where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel, or <code>null</code> if a matching payment channel could not be found
	 */
	public static PaymentChannel fetchBysearchByBank_First(
		long masterBankId, Integer active,
		OrderByComparator<PaymentChannel> orderByComparator) {

		return getPersistence().fetchBysearchByBank_First(
			masterBankId, active, orderByComparator);
	}

	/**
	 * Returns the last payment channel in the ordered set where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel
	 * @throws NoSuchPaymentChannelException if a matching payment channel could not be found
	 */
	public static PaymentChannel findBysearchByBank_Last(
			long masterBankId, Integer active,
			OrderByComparator<PaymentChannel> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchPaymentChannelException {

		return getPersistence().findBysearchByBank_Last(
			masterBankId, active, orderByComparator);
	}

	/**
	 * Returns the last payment channel in the ordered set where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel, or <code>null</code> if a matching payment channel could not be found
	 */
	public static PaymentChannel fetchBysearchByBank_Last(
		long masterBankId, Integer active,
		OrderByComparator<PaymentChannel> orderByComparator) {

		return getPersistence().fetchBysearchByBank_Last(
			masterBankId, active, orderByComparator);
	}

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
	public static PaymentChannel[] findBysearchByBank_PrevAndNext(
			long paymentChannelId, long masterBankId, Integer active,
			OrderByComparator<PaymentChannel> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchPaymentChannelException {

		return getPersistence().findBysearchByBank_PrevAndNext(
			paymentChannelId, masterBankId, active, orderByComparator);
	}

	/**
	 * Removes all the payment channels where masterBankId = &#63; and active = &#63; from the database.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 */
	public static void removeBysearchByBank(long masterBankId, Integer active) {
		getPersistence().removeBysearchByBank(masterBankId, active);
	}

	/**
	 * Returns the number of payment channels where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @return the number of matching payment channels
	 */
	public static int countBysearchByBank(long masterBankId, Integer active) {
		return getPersistence().countBysearchByBank(masterBankId, active);
	}

	/**
	 * Returns all the payment channels where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @return the matching payment channels
	 */
	public static List<PaymentChannel> findBysearchByIdAndCode(
		long paymentChannelId, String code) {

		return getPersistence().findBysearchByIdAndCode(paymentChannelId, code);
	}

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
	public static List<PaymentChannel> findBysearchByIdAndCode(
		long paymentChannelId, String code, int start, int end) {

		return getPersistence().findBysearchByIdAndCode(
			paymentChannelId, code, start, end);
	}

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
	public static List<PaymentChannel> findBysearchByIdAndCode(
		long paymentChannelId, String code, int start, int end,
		OrderByComparator<PaymentChannel> orderByComparator) {

		return getPersistence().findBysearchByIdAndCode(
			paymentChannelId, code, start, end, orderByComparator);
	}

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
	public static List<PaymentChannel> findBysearchByIdAndCode(
		long paymentChannelId, String code, int start, int end,
		OrderByComparator<PaymentChannel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchByIdAndCode(
			paymentChannelId, code, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first payment channel in the ordered set where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel
	 * @throws NoSuchPaymentChannelException if a matching payment channel could not be found
	 */
	public static PaymentChannel findBysearchByIdAndCode_First(
			long paymentChannelId, String code,
			OrderByComparator<PaymentChannel> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchPaymentChannelException {

		return getPersistence().findBysearchByIdAndCode_First(
			paymentChannelId, code, orderByComparator);
	}

	/**
	 * Returns the first payment channel in the ordered set where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel, or <code>null</code> if a matching payment channel could not be found
	 */
	public static PaymentChannel fetchBysearchByIdAndCode_First(
		long paymentChannelId, String code,
		OrderByComparator<PaymentChannel> orderByComparator) {

		return getPersistence().fetchBysearchByIdAndCode_First(
			paymentChannelId, code, orderByComparator);
	}

	/**
	 * Returns the last payment channel in the ordered set where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel
	 * @throws NoSuchPaymentChannelException if a matching payment channel could not be found
	 */
	public static PaymentChannel findBysearchByIdAndCode_Last(
			long paymentChannelId, String code,
			OrderByComparator<PaymentChannel> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchPaymentChannelException {

		return getPersistence().findBysearchByIdAndCode_Last(
			paymentChannelId, code, orderByComparator);
	}

	/**
	 * Returns the last payment channel in the ordered set where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel, or <code>null</code> if a matching payment channel could not be found
	 */
	public static PaymentChannel fetchBysearchByIdAndCode_Last(
		long paymentChannelId, String code,
		OrderByComparator<PaymentChannel> orderByComparator) {

		return getPersistence().fetchBysearchByIdAndCode_Last(
			paymentChannelId, code, orderByComparator);
	}

	/**
	 * Removes all the payment channels where paymentChannelId = &#63; and code = &#63; from the database.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 */
	public static void removeBysearchByIdAndCode(
		long paymentChannelId, String code) {

		getPersistence().removeBysearchByIdAndCode(paymentChannelId, code);
	}

	/**
	 * Returns the number of payment channels where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @return the number of matching payment channels
	 */
	public static int countBysearchByIdAndCode(
		long paymentChannelId, String code) {

		return getPersistence().countBysearchByIdAndCode(
			paymentChannelId, code);
	}

	/**
	 * Caches the payment channel in the entity cache if it is enabled.
	 *
	 * @param paymentChannel the payment channel
	 */
	public static void cacheResult(PaymentChannel paymentChannel) {
		getPersistence().cacheResult(paymentChannel);
	}

	/**
	 * Caches the payment channels in the entity cache if it is enabled.
	 *
	 * @param paymentChannels the payment channels
	 */
	public static void cacheResult(List<PaymentChannel> paymentChannels) {
		getPersistence().cacheResult(paymentChannels);
	}

	/**
	 * Creates a new payment channel with the primary key. Does not add the payment channel to the database.
	 *
	 * @param paymentChannelId the primary key for the new payment channel
	 * @return the new payment channel
	 */
	public static PaymentChannel create(long paymentChannelId) {
		return getPersistence().create(paymentChannelId);
	}

	/**
	 * Removes the payment channel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param paymentChannelId the primary key of the payment channel
	 * @return the payment channel that was removed
	 * @throws NoSuchPaymentChannelException if a payment channel with the primary key could not be found
	 */
	public static PaymentChannel remove(long paymentChannelId)
		throws com.mypage.admin.product.exception.
			NoSuchPaymentChannelException {

		return getPersistence().remove(paymentChannelId);
	}

	public static PaymentChannel updateImpl(PaymentChannel paymentChannel) {
		return getPersistence().updateImpl(paymentChannel);
	}

	/**
	 * Returns the payment channel with the primary key or throws a <code>NoSuchPaymentChannelException</code> if it could not be found.
	 *
	 * @param paymentChannelId the primary key of the payment channel
	 * @return the payment channel
	 * @throws NoSuchPaymentChannelException if a payment channel with the primary key could not be found
	 */
	public static PaymentChannel findByPrimaryKey(long paymentChannelId)
		throws com.mypage.admin.product.exception.
			NoSuchPaymentChannelException {

		return getPersistence().findByPrimaryKey(paymentChannelId);
	}

	/**
	 * Returns the payment channel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param paymentChannelId the primary key of the payment channel
	 * @return the payment channel, or <code>null</code> if a payment channel with the primary key could not be found
	 */
	public static PaymentChannel fetchByPrimaryKey(long paymentChannelId) {
		return getPersistence().fetchByPrimaryKey(paymentChannelId);
	}

	/**
	 * Returns all the payment channels.
	 *
	 * @return the payment channels
	 */
	public static List<PaymentChannel> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<PaymentChannel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<PaymentChannel> findAll(
		int start, int end,
		OrderByComparator<PaymentChannel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<PaymentChannel> findAll(
		int start, int end, OrderByComparator<PaymentChannel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the payment channels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of payment channels.
	 *
	 * @return the number of payment channels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PaymentChannelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PaymentChannelPersistence _persistence;

}