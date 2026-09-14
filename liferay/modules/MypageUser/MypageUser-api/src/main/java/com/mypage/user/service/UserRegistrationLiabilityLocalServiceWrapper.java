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
 * Provides a wrapper for {@link UserRegistrationLiabilityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationLiabilityLocalService
 * @generated
 */
public class UserRegistrationLiabilityLocalServiceWrapper
	implements ServiceWrapper<UserRegistrationLiabilityLocalService>,
			   UserRegistrationLiabilityLocalService {

	public UserRegistrationLiabilityLocalServiceWrapper(
		UserRegistrationLiabilityLocalService
			userRegistrationLiabilityLocalService) {

		_userRegistrationLiabilityLocalService =
			userRegistrationLiabilityLocalService;
	}

	@Override
	public com.mypage.user.model.UserRegistrationLiability
			addUserRegistrationLiability(
				String name, String relationship, int age,
				long userRegistrationId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationLiabilityLocalService.
			addUserRegistrationLiability(
				name, relationship, age, userRegistrationId, serviceContext);
	}

	/**
	 * Adds the user registration liability to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationLiabilityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistrationLiability the user registration liability
	 * @return the user registration liability that was added
	 */
	@Override
	public com.mypage.user.model.UserRegistrationLiability
		addUserRegistrationLiability(
			com.mypage.user.model.UserRegistrationLiability
				userRegistrationLiability) {

		return _userRegistrationLiabilityLocalService.
			addUserRegistrationLiability(userRegistrationLiability);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationLiabilityLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new user registration liability with the primary key. Does not add the user registration liability to the database.
	 *
	 * @param userRegistrationLiabilityId the primary key for the new user registration liability
	 * @return the new user registration liability
	 */
	@Override
	public com.mypage.user.model.UserRegistrationLiability
		createUserRegistrationLiability(long userRegistrationLiabilityId) {

		return _userRegistrationLiabilityLocalService.
			createUserRegistrationLiability(userRegistrationLiabilityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationLiabilityLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the user registration liability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationLiabilityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistrationLiabilityId the primary key of the user registration liability
	 * @return the user registration liability that was removed
	 * @throws PortalException if a user registration liability with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.UserRegistrationLiability
			deleteUserRegistrationLiability(long userRegistrationLiabilityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationLiabilityLocalService.
			deleteUserRegistrationLiability(userRegistrationLiabilityId);
	}

	/**
	 * Deletes the user registration liability from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationLiabilityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistrationLiability the user registration liability
	 * @return the user registration liability that was removed
	 */
	@Override
	public com.mypage.user.model.UserRegistrationLiability
		deleteUserRegistrationLiability(
			com.mypage.user.model.UserRegistrationLiability
				userRegistrationLiability) {

		return _userRegistrationLiabilityLocalService.
			deleteUserRegistrationLiability(userRegistrationLiability);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userRegistrationLiabilityLocalService.dynamicQuery();
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

		return _userRegistrationLiabilityLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationLiabilityModelImpl</code>.
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

		return _userRegistrationLiabilityLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationLiabilityModelImpl</code>.
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

		return _userRegistrationLiabilityLocalService.dynamicQuery(
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

		return _userRegistrationLiabilityLocalService.dynamicQueryCount(
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

		return _userRegistrationLiabilityLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.user.model.UserRegistrationLiability
		fetchUserRegistrationLiability(long userRegistrationLiabilityId) {

		return _userRegistrationLiabilityLocalService.
			fetchUserRegistrationLiability(userRegistrationLiabilityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userRegistrationLiabilityLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userRegistrationLiabilityLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userRegistrationLiabilityLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationLiabilityLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the user registration liabilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationLiabilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration liabilities
	 * @param end the upper bound of the range of user registration liabilities (not inclusive)
	 * @return the range of user registration liabilities
	 */
	@Override
	public java.util.List<com.mypage.user.model.UserRegistrationLiability>
		getUserRegistrationLiabilities(int start, int end) {

		return _userRegistrationLiabilityLocalService.
			getUserRegistrationLiabilities(start, end);
	}

	/**
	 * Returns the number of user registration liabilities.
	 *
	 * @return the number of user registration liabilities
	 */
	@Override
	public int getUserRegistrationLiabilitiesCount() {
		return _userRegistrationLiabilityLocalService.
			getUserRegistrationLiabilitiesCount();
	}

	/**
	 * Returns the user registration liability with the primary key.
	 *
	 * @param userRegistrationLiabilityId the primary key of the user registration liability
	 * @return the user registration liability
	 * @throws PortalException if a user registration liability with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.UserRegistrationLiability
			getUserRegistrationLiability(long userRegistrationLiabilityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationLiabilityLocalService.
			getUserRegistrationLiability(userRegistrationLiabilityId);
	}

	/**
	 * Updates the user registration liability in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationLiabilityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistrationLiability the user registration liability
	 * @return the user registration liability that was updated
	 */
	@Override
	public com.mypage.user.model.UserRegistrationLiability
		updateUserRegistrationLiability(
			com.mypage.user.model.UserRegistrationLiability
				userRegistrationLiability) {

		return _userRegistrationLiabilityLocalService.
			updateUserRegistrationLiability(userRegistrationLiability);
	}

	@Override
	public UserRegistrationLiabilityLocalService getWrappedService() {
		return _userRegistrationLiabilityLocalService;
	}

	@Override
	public void setWrappedService(
		UserRegistrationLiabilityLocalService
			userRegistrationLiabilityLocalService) {

		_userRegistrationLiabilityLocalService =
			userRegistrationLiabilityLocalService;
	}

	private UserRegistrationLiabilityLocalService
		_userRegistrationLiabilityLocalService;

}