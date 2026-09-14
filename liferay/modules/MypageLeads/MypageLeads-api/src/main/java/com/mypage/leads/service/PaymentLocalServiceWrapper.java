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

package com.mypage.leads.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PaymentLocalService}.
 *
 * @author Gositus
 * @see PaymentLocalService
 * @generated
 */
public class PaymentLocalServiceWrapper
	implements PaymentLocalService, ServiceWrapper<PaymentLocalService> {

	public PaymentLocalServiceWrapper(PaymentLocalService paymentLocalService) {
		_paymentLocalService = paymentLocalService;
	}

	@Override
	public com.mypage.leads.model.Payment addPayment(
		long userId, long paymentId,
		com.liferay.portal.kernel.json.JSONObject data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _paymentLocalService.addPayment(
			userId, paymentId, data, serviceContext);
	}

	/**
	 * Adds the payment to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payment the payment
	 * @return the payment that was added
	 */
	@Override
	public com.mypage.leads.model.Payment addPayment(
		com.mypage.leads.model.Payment payment) {

		return _paymentLocalService.addPayment(payment);
	}

	/**
	 * Creates a new payment with the primary key. Does not add the payment to the database.
	 *
	 * @param paymentId the primary key for the new payment
	 * @return the new payment
	 */
	@Override
	public com.mypage.leads.model.Payment createPayment(long paymentId) {
		return _paymentLocalService.createPayment(paymentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment that was removed
	 * @throws PortalException if a payment with the primary key could not be found
	 */
	@Override
	public com.mypage.leads.model.Payment deletePayment(long paymentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentLocalService.deletePayment(paymentId);
	}

	/**
	 * Deletes the payment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payment the payment
	 * @return the payment that was removed
	 */
	@Override
	public com.mypage.leads.model.Payment deletePayment(
		com.mypage.leads.model.Payment payment) {

		return _paymentLocalService.deletePayment(payment);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _paymentLocalService.dynamicQuery();
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

		return _paymentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.PaymentModelImpl</code>.
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

		return _paymentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.PaymentModelImpl</code>.
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

		return _paymentLocalService.dynamicQuery(
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

		return _paymentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _paymentLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.mypage.leads.model.Payment fetchPayment(long paymentId) {
		return _paymentLocalService.fetchPayment(paymentId);
	}

	@Override
	public com.mypage.leads.model.Payment findByLeadsId(long LeadsId) {
		return _paymentLocalService.findByLeadsId(LeadsId);
	}

	@Override
	public com.mypage.leads.model.Payment findByTransactionId(
		String TransactionId) {

		return _paymentLocalService.findByTransactionId(TransactionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _paymentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _paymentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _paymentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the payment with the primary key.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment
	 * @throws PortalException if a payment with the primary key could not be found
	 */
	@Override
	public com.mypage.leads.model.Payment getPayment(long paymentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentLocalService.getPayment(paymentId);
	}

	/**
	 * Returns a range of all the payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @return the range of payments
	 */
	@Override
	public java.util.List<com.mypage.leads.model.Payment> getPayments(
		int start, int end) {

		return _paymentLocalService.getPayments(start, end);
	}

	/**
	 * Returns the number of payments.
	 *
	 * @return the number of payments
	 */
	@Override
	public int getPaymentsCount() {
		return _paymentLocalService.getPaymentsCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.leads.model.Payment setActive(
			long id, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _paymentLocalService.setActive(id, active, serviceContext);
	}

	/**
	 * Updates the payment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payment the payment
	 * @return the payment that was updated
	 */
	@Override
	public com.mypage.leads.model.Payment updatePayment(
		com.mypage.leads.model.Payment payment) {

		return _paymentLocalService.updatePayment(payment);
	}

	@Override
	public PaymentLocalService getWrappedService() {
		return _paymentLocalService;
	}

	@Override
	public void setWrappedService(PaymentLocalService paymentLocalService) {
		_paymentLocalService = paymentLocalService;
	}

	private PaymentLocalService _paymentLocalService;

}