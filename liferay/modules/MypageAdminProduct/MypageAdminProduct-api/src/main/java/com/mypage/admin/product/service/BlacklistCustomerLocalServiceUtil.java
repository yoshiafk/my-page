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

import com.mypage.admin.product.model.BlacklistCustomer;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for BlacklistCustomer. This utility wraps
 * <code>com.mypage.admin.product.service.impl.BlacklistCustomerLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see BlacklistCustomerLocalService
 * @generated
 */
public class BlacklistCustomerLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.BlacklistCustomerLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the blacklist customer to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlacklistCustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blacklistCustomer the blacklist customer
	 * @return the blacklist customer that was added
	 */
	public static BlacklistCustomer addBlacklistCustomer(
		BlacklistCustomer blacklistCustomer) {

		return getService().addBlacklistCustomer(blacklistCustomer);
	}

	public static BlacklistCustomer addBlacklistCustomer(
			String fullName, String firstName, String middleName,
			String lastName, String ktp, String kitas, String email,
			java.util.Date dateOfBirth, int active)
		throws PortalException {

		return getService().addBlacklistCustomer(
			fullName, firstName, middleName, lastName, ktp, kitas, email,
			dateOfBirth, active);
	}

	public static List<BlacklistCustomer> blacklistFullName(String fullName) {
		return getService().blacklistFullName(fullName);
	}

	public static List<BlacklistCustomer> checkBlackList(
		String fullName, String ktp, String kitas, String email,
		java.util.Date dateOfBirth) {

		return getService().checkBlackList(
			fullName, ktp, kitas, email, dateOfBirth);
	}

	/**
	 * Creates a new blacklist customer with the primary key. Does not add the blacklist customer to the database.
	 *
	 * @param blacklistCustomerId the primary key for the new blacklist customer
	 * @return the new blacklist customer
	 */
	public static BlacklistCustomer createBlacklistCustomer(
		long blacklistCustomerId) {

		return getService().createBlacklistCustomer(blacklistCustomerId);
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
	 * Deletes the blacklist customer from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlacklistCustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blacklistCustomer the blacklist customer
	 * @return the blacklist customer that was removed
	 */
	public static BlacklistCustomer deleteBlacklistCustomer(
		BlacklistCustomer blacklistCustomer) {

		return getService().deleteBlacklistCustomer(blacklistCustomer);
	}

	/**
	 * Deletes the blacklist customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlacklistCustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blacklistCustomerId the primary key of the blacklist customer
	 * @return the blacklist customer that was removed
	 * @throws PortalException if a blacklist customer with the primary key could not be found
	 */
	public static BlacklistCustomer deleteBlacklistCustomer(
			long blacklistCustomerId)
		throws PortalException {

		return getService().deleteBlacklistCustomer(blacklistCustomerId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BlacklistCustomerModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BlacklistCustomerModelImpl</code>.
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

	public static BlacklistCustomer fetchBlacklistCustomer(
		long blacklistCustomerId) {

		return getService().fetchBlacklistCustomer(blacklistCustomerId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the blacklist customer with the primary key.
	 *
	 * @param blacklistCustomerId the primary key of the blacklist customer
	 * @return the blacklist customer
	 * @throws PortalException if a blacklist customer with the primary key could not be found
	 */
	public static BlacklistCustomer getBlacklistCustomer(
			long blacklistCustomerId)
		throws PortalException {

		return getService().getBlacklistCustomer(blacklistCustomerId);
	}

	public static int getBlacklistCustomerCount() {
		return getService().getBlacklistCustomerCount();
	}

	public static List<BlacklistCustomer> getBlacklistCustomers() {
		return getService().getBlacklistCustomers();
	}

	/**
	 * Returns a range of all the blacklist customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of blacklist customers
	 */
	public static List<BlacklistCustomer> getBlacklistCustomers(
		int start, int end) {

		return getService().getBlacklistCustomers(start, end);
	}

	/**
	 * Returns the number of blacklist customers.
	 *
	 * @return the number of blacklist customers
	 */
	public static int getBlacklistCustomersCount() {
		return getService().getBlacklistCustomersCount();
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
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static BlacklistCustomer setActive(
			long blacklistCustomerId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			blacklistCustomerId, active, serviceContext);
	}

	/**
	 * Updates the blacklist customer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlacklistCustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blacklistCustomer the blacklist customer
	 * @return the blacklist customer that was updated
	 */
	public static BlacklistCustomer updateBlacklistCustomer(
		BlacklistCustomer blacklistCustomer) {

		return getService().updateBlacklistCustomer(blacklistCustomer);
	}

	public static BlacklistCustomer updateBlacklistCustomer(
			long blacklistCustomerId, String fullName, String firstName,
			String middleName, String lastName, String ktp, String kitas,
			String email, java.util.Date dateOfBirth)
		throws PortalException {

		return getService().updateBlacklistCustomer(
			blacklistCustomerId, fullName, firstName, middleName, lastName, ktp,
			kitas, email, dateOfBirth);
	}

	public static BlacklistCustomer updateBlacklistCustomer(
			long blacklistCustomerId, String fullName, String firstName,
			String middleName, String lastName, String ktp, String kitas,
			String email, java.util.Date dateOfBirth, int active)
		throws PortalException {

		return getService().updateBlacklistCustomer(
			blacklistCustomerId, fullName, firstName, middleName, lastName, ktp,
			kitas, email, dateOfBirth, active);
	}

	public static BlacklistCustomerLocalService getService() {
		return _service;
	}

	private static volatile BlacklistCustomerLocalService _service;

}