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

import com.mypage.admin.product.model.PaymentChannelTenor;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PaymentChannelTenor. This utility wraps
 * <code>com.mypage.admin.product.service.impl.PaymentChannelTenorLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see PaymentChannelTenorLocalService
 * @generated
 */
public class PaymentChannelTenorLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.PaymentChannelTenorLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static PaymentChannelTenor addPaymentChannelTenor(
			long paymentChannelId, String promoid, String tenor, String tenorid,
			String acquirer, int active)
		throws PortalException {

		return getService().addPaymentChannelTenor(
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
	public static PaymentChannelTenor addPaymentChannelTenor(
		PaymentChannelTenor paymentChannelTenor) {

		return getService().addPaymentChannelTenor(paymentChannelTenor);
	}

	/**
	 * Creates a new payment channel tenor with the primary key. Does not add the payment channel tenor to the database.
	 *
	 * @param paymentChannelTenorId the primary key for the new payment channel tenor
	 * @return the new payment channel tenor
	 */
	public static PaymentChannelTenor createPaymentChannelTenor(
		long paymentChannelTenorId) {

		return getService().createPaymentChannelTenor(paymentChannelTenorId);
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
	public static PaymentChannelTenor deletePaymentChannelTenor(
			long paymentChannelTenorId)
		throws PortalException {

		return getService().deletePaymentChannelTenor(paymentChannelTenorId);
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
	public static PaymentChannelTenor deletePaymentChannelTenor(
		PaymentChannelTenor paymentChannelTenor) {

		return getService().deletePaymentChannelTenor(paymentChannelTenor);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PaymentChannelTenorModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PaymentChannelTenorModelImpl</code>.
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

	public static PaymentChannelTenor fetchPaymentChannelTenor(
		long paymentChannelTenorId) {

		return getService().fetchPaymentChannelTenor(paymentChannelTenorId);
	}

	public static List<PaymentChannelTenor> findBysearchByPaymentChannelId(
		long paymentChannelId) {

		return getService().findBysearchByPaymentChannelId(paymentChannelId);
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
	 * Returns the payment channel tenor with the primary key.
	 *
	 * @param paymentChannelTenorId the primary key of the payment channel tenor
	 * @return the payment channel tenor
	 * @throws PortalException if a payment channel tenor with the primary key could not be found
	 */
	public static PaymentChannelTenor getPaymentChannelTenor(
			long paymentChannelTenorId)
		throws PortalException {

		return getService().getPaymentChannelTenor(paymentChannelTenorId);
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
	public static List<PaymentChannelTenor> getPaymentChannelTenors(
		int start, int end) {

		return getService().getPaymentChannelTenors(start, end);
	}

	/**
	 * Returns the number of payment channel tenors.
	 *
	 * @return the number of payment channel tenors
	 */
	public static int getPaymentChannelTenorsCount() {
		return getService().getPaymentChannelTenorsCount();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static void removeByPaymentChannelId(long paymentChannelId) {
		getService().removeByPaymentChannelId(paymentChannelId);
	}

	public static PaymentChannelTenor setActive(
			long paymentChannelTenorId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			paymentChannelTenorId, active, serviceContext);
	}

	public static PaymentChannelTenor updatePaymentChannelTenor(
			long paymentChannelTenorId, long paymentChannelId, String promoid,
			String tenor, String tenorid, String acquirer, int active)
		throws PortalException {

		return getService().updatePaymentChannelTenor(
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
	public static PaymentChannelTenor updatePaymentChannelTenor(
		PaymentChannelTenor paymentChannelTenor) {

		return getService().updatePaymentChannelTenor(paymentChannelTenor);
	}

	public static PaymentChannelTenorLocalService getService() {
		return _service;
	}

	private static volatile PaymentChannelTenorLocalService _service;

}