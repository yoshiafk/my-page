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
 * Provides a wrapper for {@link BlacklistCustomerLocalService}.
 *
 * @author Gositus Team
 * @see BlacklistCustomerLocalService
 * @generated
 */
public class BlacklistCustomerLocalServiceWrapper
	implements BlacklistCustomerLocalService,
			   ServiceWrapper<BlacklistCustomerLocalService> {

	public BlacklistCustomerLocalServiceWrapper(
		BlacklistCustomerLocalService blacklistCustomerLocalService) {

		_blacklistCustomerLocalService = blacklistCustomerLocalService;
	}

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
	@Override
	public com.mypage.admin.product.model.BlacklistCustomer
		addBlacklistCustomer(
			com.mypage.admin.product.model.BlacklistCustomer
				blacklistCustomer) {

		return _blacklistCustomerLocalService.addBlacklistCustomer(
			blacklistCustomer);
	}

	@Override
	public com.mypage.admin.product.model.BlacklistCustomer
			addBlacklistCustomer(
				String fullName, String firstName, String middleName,
				String lastName, String ktp, String kitas, String email,
				java.util.Date dateOfBirth, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blacklistCustomerLocalService.addBlacklistCustomer(
			fullName, firstName, middleName, lastName, ktp, kitas, email,
			dateOfBirth, active);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.BlacklistCustomer>
		blacklistFullName(String fullName) {

		return _blacklistCustomerLocalService.blacklistFullName(fullName);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.BlacklistCustomer>
		checkBlackList(
			String fullName, String ktp, String kitas, String email,
			java.util.Date dateOfBirth) {

		return _blacklistCustomerLocalService.checkBlackList(
			fullName, ktp, kitas, email, dateOfBirth);
	}

	/**
	 * Creates a new blacklist customer with the primary key. Does not add the blacklist customer to the database.
	 *
	 * @param blacklistCustomerId the primary key for the new blacklist customer
	 * @return the new blacklist customer
	 */
	@Override
	public com.mypage.admin.product.model.BlacklistCustomer
		createBlacklistCustomer(long blacklistCustomerId) {

		return _blacklistCustomerLocalService.createBlacklistCustomer(
			blacklistCustomerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blacklistCustomerLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.mypage.admin.product.model.BlacklistCustomer
		deleteBlacklistCustomer(
			com.mypage.admin.product.model.BlacklistCustomer
				blacklistCustomer) {

		return _blacklistCustomerLocalService.deleteBlacklistCustomer(
			blacklistCustomer);
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
	@Override
	public com.mypage.admin.product.model.BlacklistCustomer
			deleteBlacklistCustomer(long blacklistCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blacklistCustomerLocalService.deleteBlacklistCustomer(
			blacklistCustomerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blacklistCustomerLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _blacklistCustomerLocalService.dynamicQuery();
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

		return _blacklistCustomerLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _blacklistCustomerLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _blacklistCustomerLocalService.dynamicQuery(
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

		return _blacklistCustomerLocalService.dynamicQueryCount(dynamicQuery);
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

		return _blacklistCustomerLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.BlacklistCustomer
		fetchBlacklistCustomer(long blacklistCustomerId) {

		return _blacklistCustomerLocalService.fetchBlacklistCustomer(
			blacklistCustomerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _blacklistCustomerLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the blacklist customer with the primary key.
	 *
	 * @param blacklistCustomerId the primary key of the blacklist customer
	 * @return the blacklist customer
	 * @throws PortalException if a blacklist customer with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.BlacklistCustomer
			getBlacklistCustomer(long blacklistCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blacklistCustomerLocalService.getBlacklistCustomer(
			blacklistCustomerId);
	}

	@Override
	public int getBlacklistCustomerCount() {
		return _blacklistCustomerLocalService.getBlacklistCustomerCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.BlacklistCustomer>
		getBlacklistCustomers() {

		return _blacklistCustomerLocalService.getBlacklistCustomers();
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
	@Override
	public java.util.List<com.mypage.admin.product.model.BlacklistCustomer>
		getBlacklistCustomers(int start, int end) {

		return _blacklistCustomerLocalService.getBlacklistCustomers(start, end);
	}

	/**
	 * Returns the number of blacklist customers.
	 *
	 * @return the number of blacklist customers
	 */
	@Override
	public int getBlacklistCustomersCount() {
		return _blacklistCustomerLocalService.getBlacklistCustomersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _blacklistCustomerLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _blacklistCustomerLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blacklistCustomerLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.admin.product.model.BlacklistCustomer setActive(
			long blacklistCustomerId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blacklistCustomerLocalService.setActive(
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
	@Override
	public com.mypage.admin.product.model.BlacklistCustomer
		updateBlacklistCustomer(
			com.mypage.admin.product.model.BlacklistCustomer
				blacklistCustomer) {

		return _blacklistCustomerLocalService.updateBlacklistCustomer(
			blacklistCustomer);
	}

	@Override
	public com.mypage.admin.product.model.BlacklistCustomer
			updateBlacklistCustomer(
				long blacklistCustomerId, String fullName, String firstName,
				String middleName, String lastName, String ktp, String kitas,
				String email, java.util.Date dateOfBirth)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blacklistCustomerLocalService.updateBlacklistCustomer(
			blacklistCustomerId, fullName, firstName, middleName, lastName, ktp,
			kitas, email, dateOfBirth);
	}

	@Override
	public com.mypage.admin.product.model.BlacklistCustomer
			updateBlacklistCustomer(
				long blacklistCustomerId, String fullName, String firstName,
				String middleName, String lastName, String ktp, String kitas,
				String email, java.util.Date dateOfBirth, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blacklistCustomerLocalService.updateBlacklistCustomer(
			blacklistCustomerId, fullName, firstName, middleName, lastName, ktp,
			kitas, email, dateOfBirth, active);
	}

	@Override
	public BlacklistCustomerLocalService getWrappedService() {
		return _blacklistCustomerLocalService;
	}

	@Override
	public void setWrappedService(
		BlacklistCustomerLocalService blacklistCustomerLocalService) {

		_blacklistCustomerLocalService = blacklistCustomerLocalService;
	}

	private BlacklistCustomerLocalService _blacklistCustomerLocalService;

}