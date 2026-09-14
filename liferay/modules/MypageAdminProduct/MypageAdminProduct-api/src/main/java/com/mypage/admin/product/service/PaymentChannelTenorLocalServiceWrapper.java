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
 * Provides a wrapper for {@link PaymentChannelTenorLocalService}.
 *
 * @author Gositus Team
 * @see PaymentChannelTenorLocalService
 * @generated
 */
public class PaymentChannelTenorLocalServiceWrapper
	implements PaymentChannelTenorLocalService,
			   ServiceWrapper<PaymentChannelTenorLocalService> {

	public PaymentChannelTenorLocalServiceWrapper(
		PaymentChannelTenorLocalService paymentChannelTenorLocalService) {

		_paymentChannelTenorLocalService = paymentChannelTenorLocalService;
	}

	@Override
	public com.mypage.admin.product.model.PaymentChannelTenor
			addPaymentChannelTenor(
				long paymentChannelId, String promoid, String tenor,
				String tenorid, String acquirer, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentChannelTenorLocalService.addPaymentChannelTenor(
			paymentChannelId, promoid, tenor, tenorid, acquirer, active);
	}

	/**
	 * Adds the payment channel tenor to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentChannelTenorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param paymentChannelTenor the payment channel tenor
	 * @return the payment channel tenor that was added
	 */
	@Override
	public com.mypage.admin.product.model.PaymentChannelTenor
		addPaymentChannelTenor(
			com.mypage.admin.product.model.PaymentChannelTenor
				paymentChannelTenor) {

		return _paymentChannelTenorLocalService.addPaymentChannelTenor(
			paymentChannelTenor);
	}

	/**
	 * Creates a new payment channel tenor with the primary key. Does not add the payment channel tenor to the database.
	 *
	 * @param paymentChannelTenorId the primary key for the new payment channel tenor
	 * @return the new payment channel tenor
	 */
	@Override
	public com.mypage.admin.product.model.PaymentChannelTenor
		createPaymentChannelTenor(long paymentChannelTenorId) {

		return _paymentChannelTenorLocalService.createPaymentChannelTenor(
			paymentChannelTenorId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentChannelTenorLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the payment channel tenor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentChannelTenorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param paymentChannelTenorId the primary key of the payment channel tenor
	 * @return the payment channel tenor that was removed
	 * @throws PortalException if a payment channel tenor with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.PaymentChannelTenor
			deletePaymentChannelTenor(long paymentChannelTenorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentChannelTenorLocalService.deletePaymentChannelTenor(
			paymentChannelTenorId);
	}

	/**
	 * Deletes the payment channel tenor from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentChannelTenorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param paymentChannelTenor the payment channel tenor
	 * @return the payment channel tenor that was removed
	 */
	@Override
	public com.mypage.admin.product.model.PaymentChannelTenor
		deletePaymentChannelTenor(
			com.mypage.admin.product.model.PaymentChannelTenor
				paymentChannelTenor) {

		return _paymentChannelTenorLocalService.deletePaymentChannelTenor(
			paymentChannelTenor);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentChannelTenorLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _paymentChannelTenorLocalService.dynamicQuery();
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

		return _paymentChannelTenorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PaymentChannelTenorModelImpl</code>.
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

		return _paymentChannelTenorLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PaymentChannelTenorModelImpl</code>.
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

		return _paymentChannelTenorLocalService.dynamicQuery(
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

		return _paymentChannelTenorLocalService.dynamicQueryCount(dynamicQuery);
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

		return _paymentChannelTenorLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.PaymentChannelTenor
		fetchPaymentChannelTenor(long paymentChannelTenorId) {

		return _paymentChannelTenorLocalService.fetchPaymentChannelTenor(
			paymentChannelTenorId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.PaymentChannelTenor>
		findBysearchByPaymentChannelId(long paymentChannelId) {

		return _paymentChannelTenorLocalService.findBysearchByPaymentChannelId(
			paymentChannelId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _paymentChannelTenorLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _paymentChannelTenorLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _paymentChannelTenorLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the payment channel tenor with the primary key.
	 *
	 * @param paymentChannelTenorId the primary key of the payment channel tenor
	 * @return the payment channel tenor
	 * @throws PortalException if a payment channel tenor with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.PaymentChannelTenor
			getPaymentChannelTenor(long paymentChannelTenorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentChannelTenorLocalService.getPaymentChannelTenor(
			paymentChannelTenorId);
	}

	/**
	 * Returns a range of all the payment channel tenors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PaymentChannelTenorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment channel tenors
	 * @param end the upper bound of the range of payment channel tenors (not inclusive)
	 * @return the range of payment channel tenors
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.PaymentChannelTenor>
		getPaymentChannelTenors(int start, int end) {

		return _paymentChannelTenorLocalService.getPaymentChannelTenors(
			start, end);
	}

	/**
	 * Returns the number of payment channel tenors.
	 *
	 * @return the number of payment channel tenors
	 */
	@Override
	public int getPaymentChannelTenorsCount() {
		return _paymentChannelTenorLocalService.getPaymentChannelTenorsCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentChannelTenorLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public void removeByPaymentChannelId(long paymentChannelId) {
		_paymentChannelTenorLocalService.removeByPaymentChannelId(
			paymentChannelId);
	}

	@Override
	public com.mypage.admin.product.model.PaymentChannelTenor setActive(
			long paymentChannelTenorId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentChannelTenorLocalService.setActive(
			paymentChannelTenorId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.PaymentChannelTenor
			updatePaymentChannelTenor(
				long paymentChannelTenorId, long paymentChannelId,
				String promoid, String tenor, String tenorid, String acquirer,
				int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentChannelTenorLocalService.updatePaymentChannelTenor(
			paymentChannelTenorId, paymentChannelId, promoid, tenor, tenorid,
			acquirer, active);
	}

	/**
	 * Updates the payment channel tenor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentChannelTenorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param paymentChannelTenor the payment channel tenor
	 * @return the payment channel tenor that was updated
	 */
	@Override
	public com.mypage.admin.product.model.PaymentChannelTenor
		updatePaymentChannelTenor(
			com.mypage.admin.product.model.PaymentChannelTenor
				paymentChannelTenor) {

		return _paymentChannelTenorLocalService.updatePaymentChannelTenor(
			paymentChannelTenor);
	}

	@Override
	public PaymentChannelTenorLocalService getWrappedService() {
		return _paymentChannelTenorLocalService;
	}

	@Override
	public void setWrappedService(
		PaymentChannelTenorLocalService paymentChannelTenorLocalService) {

		_paymentChannelTenorLocalService = paymentChannelTenorLocalService;
	}

	private PaymentChannelTenorLocalService _paymentChannelTenorLocalService;

}