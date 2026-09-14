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

package com.axa.payment.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserTransactionTokenLocalService}.
 *
 * @author Gositus Team
 * @see UserTransactionTokenLocalService
 * @generated
 */
public class UserTransactionTokenLocalServiceWrapper
	implements ServiceWrapper<UserTransactionTokenLocalService>,
			   UserTransactionTokenLocalService {

	public UserTransactionTokenLocalServiceWrapper(
		UserTransactionTokenLocalService userTransactionTokenLocalService) {

		_userTransactionTokenLocalService = userTransactionTokenLocalService;
	}

	/**
	 * Adds the user transaction token to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserTransactionTokenLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userTransactionToken the user transaction token
	 * @return the user transaction token that was added
	 */
	@Override
	public com.axa.payment.model.UserTransactionToken addUserTransactionToken(
		com.axa.payment.model.UserTransactionToken userTransactionToken) {

		return _userTransactionTokenLocalService.addUserTransactionToken(
			userTransactionToken);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userTransactionTokenLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new user transaction token with the primary key. Does not add the user transaction token to the database.
	 *
	 * @param userTransactionTokenId the primary key for the new user transaction token
	 * @return the new user transaction token
	 */
	@Override
	public com.axa.payment.model.UserTransactionToken
		createUserTransactionToken(long userTransactionTokenId) {

		return _userTransactionTokenLocalService.createUserTransactionToken(
			userTransactionTokenId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userTransactionTokenLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the user transaction token with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserTransactionTokenLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userTransactionTokenId the primary key of the user transaction token
	 * @return the user transaction token that was removed
	 * @throws PortalException if a user transaction token with the primary key could not be found
	 */
	@Override
	public com.axa.payment.model.UserTransactionToken
			deleteUserTransactionToken(long userTransactionTokenId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userTransactionTokenLocalService.deleteUserTransactionToken(
			userTransactionTokenId);
	}

	/**
	 * Deletes the user transaction token from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserTransactionTokenLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userTransactionToken the user transaction token
	 * @return the user transaction token that was removed
	 */
	@Override
	public com.axa.payment.model.UserTransactionToken
		deleteUserTransactionToken(
			com.axa.payment.model.UserTransactionToken userTransactionToken) {

		return _userTransactionTokenLocalService.deleteUserTransactionToken(
			userTransactionToken);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userTransactionTokenLocalService.dynamicQuery();
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

		return _userTransactionTokenLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.axa.payment.model.impl.UserTransactionTokenModelImpl</code>.
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

		return _userTransactionTokenLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.axa.payment.model.impl.UserTransactionTokenModelImpl</code>.
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

		return _userTransactionTokenLocalService.dynamicQuery(
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

		return _userTransactionTokenLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _userTransactionTokenLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.axa.payment.model.UserTransactionToken fetchUserTransactionToken(
		long userTransactionTokenId) {

		return _userTransactionTokenLocalService.fetchUserTransactionToken(
			userTransactionTokenId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userTransactionTokenLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userTransactionTokenLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userTransactionTokenLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userTransactionTokenLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the user transaction token with the primary key.
	 *
	 * @param userTransactionTokenId the primary key of the user transaction token
	 * @return the user transaction token
	 * @throws PortalException if a user transaction token with the primary key could not be found
	 */
	@Override
	public com.axa.payment.model.UserTransactionToken getUserTransactionToken(
			long userTransactionTokenId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userTransactionTokenLocalService.getUserTransactionToken(
			userTransactionTokenId);
	}

	/**
	 * Returns a range of all the user transaction tokens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.axa.payment.model.impl.UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @return the range of user transaction tokens
	 */
	@Override
	public java.util.List<com.axa.payment.model.UserTransactionToken>
		getUserTransactionTokens(int start, int end) {

		return _userTransactionTokenLocalService.getUserTransactionTokens(
			start, end);
	}

	/**
	 * Returns the number of user transaction tokens.
	 *
	 * @return the number of user transaction tokens
	 */
	@Override
	public int getUserTransactionTokensCount() {
		return _userTransactionTokenLocalService.
			getUserTransactionTokensCount();
	}

	@Override
	public com.axa.payment.model.UserTransactionToken updateToken(
		String policyNumber, String profileId, String invoiceNumber,
		String referenceNumber, String fullName, String email,
		String phoneNumber, double amount, String channel,
		String virtualAccount1, String virtualAccount2, String token,
		long expiresIn) {

		return _userTransactionTokenLocalService.updateToken(
			policyNumber, profileId, invoiceNumber, referenceNumber, fullName,
			email, phoneNumber, amount, channel, virtualAccount1,
			virtualAccount2, token, expiresIn);
	}

	/**
	 * Updates the user transaction token in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserTransactionTokenLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userTransactionToken the user transaction token
	 * @return the user transaction token that was updated
	 */
	@Override
	public com.axa.payment.model.UserTransactionToken
		updateUserTransactionToken(
			com.axa.payment.model.UserTransactionToken userTransactionToken) {

		return _userTransactionTokenLocalService.updateUserTransactionToken(
			userTransactionToken);
	}

	@Override
	public UserTransactionTokenLocalService getWrappedService() {
		return _userTransactionTokenLocalService;
	}

	@Override
	public void setWrappedService(
		UserTransactionTokenLocalService userTransactionTokenLocalService) {

		_userTransactionTokenLocalService = userTransactionTokenLocalService;
	}

	private UserTransactionTokenLocalService _userTransactionTokenLocalService;

}