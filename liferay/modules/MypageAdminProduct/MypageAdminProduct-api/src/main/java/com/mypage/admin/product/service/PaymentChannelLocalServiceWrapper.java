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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PaymentChannelLocalService}.
 *
 * @author Gositus Team
 * @see PaymentChannelLocalService
 * @generated
 */
public class PaymentChannelLocalServiceWrapper
	implements PaymentChannelLocalService,
			   ServiceWrapper<PaymentChannelLocalService> {

	public PaymentChannelLocalServiceWrapper(
		PaymentChannelLocalService paymentChannelLocalService) {

		_paymentChannelLocalService = paymentChannelLocalService;
	}

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
	@Override
	public com.mypage.admin.product.model.PaymentChannel addPaymentChannel(
		com.mypage.admin.product.model.PaymentChannel paymentChannel) {

		return _paymentChannelLocalService.addPaymentChannel(paymentChannel);
	}

	@Override
	public com.mypage.admin.product.model.PaymentChannel addPaymentChannel(
			String code, String name, Double minPayment, Double maxPayment,
			String description, long masterBankId, String mdrAxa,
			String mdrUser, String pgFeePct, String pgFeeAmt,
			long imageFileEntryId, String imageURL, int utmOnly, String mallId,
			String sharedKey, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentChannelLocalService.addPaymentChannel(
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
	@Override
	public com.mypage.admin.product.model.PaymentChannel createPaymentChannel(
		long paymentChannelId) {

		return _paymentChannelLocalService.createPaymentChannel(
			paymentChannelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentChannelLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.mypage.admin.product.model.PaymentChannel deletePaymentChannel(
			long paymentChannelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentChannelLocalService.deletePaymentChannel(
			paymentChannelId);
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
	@Override
	public com.mypage.admin.product.model.PaymentChannel deletePaymentChannel(
		com.mypage.admin.product.model.PaymentChannel paymentChannel) {

		return _paymentChannelLocalService.deletePaymentChannel(paymentChannel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentChannelLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _paymentChannelLocalService.dynamicQuery();
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

		return _paymentChannelLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _paymentChannelLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _paymentChannelLocalService.dynamicQuery(
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

		return _paymentChannelLocalService.dynamicQueryCount(dynamicQuery);
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

		return _paymentChannelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.PaymentChannel fetchPaymentChannel(
		long paymentChannelId) {

		return _paymentChannelLocalService.fetchPaymentChannel(
			paymentChannelId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.PaymentChannel>
		findByBank(long masterBankId, int active) {

		return _paymentChannelLocalService.findByBank(masterBankId, active);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.PaymentChannel>
		findBysearchByIdAndCode(long paymentChannelId, String code) {

		return _paymentChannelLocalService.findBysearchByIdAndCode(
			paymentChannelId, code);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _paymentChannelLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _paymentChannelLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _paymentChannelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the payment channel with the primary key.
	 *
	 * @param paymentChannelId the primary key of the payment channel
	 * @return the payment channel
	 * @throws PortalException if a payment channel with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.PaymentChannel getPaymentChannel(
			long paymentChannelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentChannelLocalService.getPaymentChannel(paymentChannelId);
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
	@Override
	public java.util.List<com.mypage.admin.product.model.PaymentChannel>
		getPaymentChannels(int start, int end) {

		return _paymentChannelLocalService.getPaymentChannels(start, end);
	}

	/**
	 * Returns the number of payment channels.
	 *
	 * @return the number of payment channels
	 */
	@Override
	public int getPaymentChannelsCount() {
		return _paymentChannelLocalService.getPaymentChannelsCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentChannelLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.admin.product.model.PaymentChannel setActive(
			long paymentChannelId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentChannelLocalService.setActive(
			paymentChannelId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.PaymentChannel updatePaymentChannel(
			long paymentChannelId, String code, String name, Double minPayment,
			Double maxPayment, String description, long masterBankId,
			String mdrAxa, String mdrUser, String pgFeePct, String pgFeeAmt,
			long imageFileEntryId, String imageURL, int utmOnly, String mallId,
			String sharedKey, int active, boolean isImport)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentChannelLocalService.updatePaymentChannel(
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
	@Override
	public com.mypage.admin.product.model.PaymentChannel updatePaymentChannel(
		com.mypage.admin.product.model.PaymentChannel paymentChannel) {

		return _paymentChannelLocalService.updatePaymentChannel(paymentChannel);
	}

	@Override
	public PaymentChannelLocalService getWrappedService() {
		return _paymentChannelLocalService;
	}

	@Override
	public void setWrappedService(
		PaymentChannelLocalService paymentChannelLocalService) {

		_paymentChannelLocalService = paymentChannelLocalService;
	}

	private PaymentChannelLocalService _paymentChannelLocalService;

}