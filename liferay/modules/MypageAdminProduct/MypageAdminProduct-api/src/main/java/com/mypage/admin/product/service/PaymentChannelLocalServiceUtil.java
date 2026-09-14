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

package com.mypage.admin.product.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.PaymentChannel;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PaymentChannel. This utility wraps
 * <code>com.mypage.admin.product.service.impl.PaymentChannelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see PaymentChannelLocalService
 * @generated
 */
public class PaymentChannelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.PaymentChannelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the payment channel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentChannelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param paymentChannel the payment channel
	 * @return the payment channel that was added
	 */
	public static PaymentChannel addPaymentChannel(
		PaymentChannel paymentChannel) {

		return getService().addPaymentChannel(paymentChannel);
	}

	public static PaymentChannel addPaymentChannel(
			String code, String name, Double minPayment, Double maxPayment,
			String description, long masterBankId, String mdrAxa,
			String mdrUser, String pgFeePct, String pgFeeAmt,
			long imageFileEntryId, String imageURL, int utmOnly, String mallId,
			String sharedKey, int active)
		throws PortalException {

		return getService().addPaymentChannel(
			code, name, minPayment, maxPayment, description, masterBankId,
			mdrAxa, mdrUser, pgFeePct, pgFeeAmt, imageFileEntryId, imageURL,
			utmOnly, mallId, sharedKey, active);
	}

	/**
	 * Creates a new payment channel with the primary key. Does not add the payment channel to the database.
	 *
	 * @param paymentChannelId the primary key for the new payment channel
	 * @return the new payment channel
	 */
	public static PaymentChannel createPaymentChannel(long paymentChannelId) {
		return getService().createPaymentChannel(paymentChannelId);
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
	 * Deletes the payment channel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentChannelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param paymentChannelId the primary key of the payment channel
	 * @return the payment channel that was removed
	 * @throws PortalException if a payment channel with the primary key could not be found
	 */
	public static PaymentChannel deletePaymentChannel(long paymentChannelId)
		throws PortalException {

		return getService().deletePaymentChannel(paymentChannelId);
	}

	/**
	 * Deletes the payment channel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentChannelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param paymentChannel the payment channel
	 * @return the payment channel that was removed
	 */
	public static PaymentChannel deletePaymentChannel(
		PaymentChannel paymentChannel) {

		return getService().deletePaymentChannel(paymentChannel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PaymentChannelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PaymentChannelModelImpl</code>.
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

	public static PaymentChannel fetchPaymentChannel(long paymentChannelId) {
		return getService().fetchPaymentChannel(paymentChannelId);
	}

	public static List<PaymentChannel> findByBank(
		long masterBankId, int active) {

		return getService().findByBank(masterBankId, active);
	}

	public static List<PaymentChannel> findBysearchByIdAndCode(
		long paymentChannelId, String code) {

		return getService().findBysearchByIdAndCode(paymentChannelId, code);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the payment channel with the primary key.
	 *
	 * @param paymentChannelId the primary key of the payment channel
	 * @return the payment channel
	 * @throws PortalException if a payment channel with the primary key could not be found
	 */
	public static PaymentChannel getPaymentChannel(long paymentChannelId)
		throws PortalException {

		return getService().getPaymentChannel(paymentChannelId);
	}

	/**
	 * Returns a range of all the payment channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @return the range of payment channels
	 */
	public static List<PaymentChannel> getPaymentChannels(int start, int end) {
		return getService().getPaymentChannels(start, end);
	}

	/**
	 * Returns the number of payment channels.
	 *
	 * @return the number of payment channels
	 */
	public static int getPaymentChannelsCount() {
		return getService().getPaymentChannelsCount();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static PaymentChannel setActive(
			long paymentChannelId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(paymentChannelId, active, serviceContext);
	}

	public static PaymentChannel updatePaymentChannel(
			long paymentChannelId, String code, String name, Double minPayment,
			Double maxPayment, String description, long masterBankId,
			String mdrAxa, String mdrUser, String pgFeePct, String pgFeeAmt,
			long imageFileEntryId, String imageURL, int utmOnly, String mallId,
			String sharedKey, int active, boolean isImport)
		throws PortalException {

		return getService().updatePaymentChannel(
			paymentChannelId, code, name, minPayment, maxPayment, description,
			masterBankId, mdrAxa, mdrUser, pgFeePct, pgFeeAmt, imageFileEntryId,
			imageURL, utmOnly, mallId, sharedKey, active, isImport);
	}

	/**
	 * Updates the payment channel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentChannelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param paymentChannel the payment channel
	 * @return the payment channel that was updated
	 */
	public static PaymentChannel updatePaymentChannel(
		PaymentChannel paymentChannel) {

		return getService().updatePaymentChannel(paymentChannel);
	}

	public static PaymentChannelLocalService getService() {
		return _service;
	}

	private static volatile PaymentChannelLocalService _service;

}