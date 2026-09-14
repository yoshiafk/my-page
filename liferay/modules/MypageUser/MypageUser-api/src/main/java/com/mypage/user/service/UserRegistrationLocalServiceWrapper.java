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

package com.mypage.user.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationLocalService
 * @generated
 */
public class UserRegistrationLocalServiceWrapper
	implements ServiceWrapper<UserRegistrationLocalService>,
			   UserRegistrationLocalService {

	public UserRegistrationLocalServiceWrapper(
		UserRegistrationLocalService userRegistrationLocalService) {

		_userRegistrationLocalService = userRegistrationLocalService;
	}

	@Override
	public com.mypage.user.model.UserRegistration addUserRegistration(
			com.liferay.portal.kernel.json.JSONObject params,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationLocalService.addUserRegistration(
			params, serviceContext);
	}

	/**
	 * Adds the user registration to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistration the user registration
	 * @return the user registration that was added
	 */
	@Override
	public com.mypage.user.model.UserRegistration addUserRegistration(
		com.mypage.user.model.UserRegistration userRegistration) {

		return _userRegistrationLocalService.addUserRegistration(
			userRegistration);
	}

	@Override
	public java.util.List<com.mypage.user.model.UserRegistration>
			checkExistingUserRegistration(String fullName, String idNumber)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationLocalService.checkExistingUserRegistration(
			fullName, idNumber);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new user registration with the primary key. Does not add the user registration to the database.
	 *
	 * @param userRegistrationId the primary key for the new user registration
	 * @return the new user registration
	 */
	@Override
	public com.mypage.user.model.UserRegistration createUserRegistration(
		long userRegistrationId) {

		return _userRegistrationLocalService.createUserRegistration(
			userRegistrationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the user registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistrationId the primary key of the user registration
	 * @return the user registration that was removed
	 * @throws PortalException if a user registration with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.UserRegistration deleteUserRegistration(
			long userRegistrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationLocalService.deleteUserRegistration(
			userRegistrationId);
	}

	/**
	 * Deletes the user registration from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistration the user registration
	 * @return the user registration that was removed
	 */
	@Override
	public com.mypage.user.model.UserRegistration deleteUserRegistration(
		com.mypage.user.model.UserRegistration userRegistration) {

		return _userRegistrationLocalService.deleteUserRegistration(
			userRegistration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userRegistrationLocalService.dynamicQuery();
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

		return _userRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationModelImpl</code>.
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

		return _userRegistrationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationModelImpl</code>.
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

		return _userRegistrationLocalService.dynamicQuery(
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

		return _userRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _userRegistrationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.user.model.UserRegistration fetchUserRegistration(
		long userRegistrationId) {

		return _userRegistrationLocalService.fetchUserRegistration(
			userRegistrationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userRegistrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userRegistrationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userRegistrationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user registration with the primary key.
	 *
	 * @param userRegistrationId the primary key of the user registration
	 * @return the user registration
	 * @throws PortalException if a user registration with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.UserRegistration getUserRegistration(
			long userRegistrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationLocalService.getUserRegistration(
			userRegistrationId);
	}

	/**
	 * Returns a range of all the user registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registrations
	 * @param end the upper bound of the range of user registrations (not inclusive)
	 * @return the range of user registrations
	 */
	@Override
	public java.util.List<com.mypage.user.model.UserRegistration>
		getUserRegistrations(int start, int end) {

		return _userRegistrationLocalService.getUserRegistrations(start, end);
	}

	/**
	 * Returns the number of user registrations.
	 *
	 * @return the number of user registrations
	 */
	@Override
	public int getUserRegistrationsCount() {
		return _userRegistrationLocalService.getUserRegistrationsCount();
	}

	@Override
	public com.mypage.user.model.UserRegistration setActive(
			long userId, long userRegistrationId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationLocalService.setActive(
			userId, userRegistrationId, active, serviceContext);
	}

	/**
	 * Updates the user registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistration the user registration
	 * @return the user registration that was updated
	 */
	@Override
	public com.mypage.user.model.UserRegistration updateUserRegistration(
		com.mypage.user.model.UserRegistration userRegistration) {

		return _userRegistrationLocalService.updateUserRegistration(
			userRegistration);
	}

	@Override
	public UserRegistrationLocalService getWrappedService() {
		return _userRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		UserRegistrationLocalService userRegistrationLocalService) {

		_userRegistrationLocalService = userRegistrationLocalService;
	}

	private UserRegistrationLocalService _userRegistrationLocalService;

}