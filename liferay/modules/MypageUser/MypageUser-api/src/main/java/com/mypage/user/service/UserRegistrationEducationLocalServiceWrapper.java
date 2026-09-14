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
 * Provides a wrapper for {@link UserRegistrationEducationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationEducationLocalService
 * @generated
 */
public class UserRegistrationEducationLocalServiceWrapper
	implements ServiceWrapper<UserRegistrationEducationLocalService>,
			   UserRegistrationEducationLocalService {

	public UserRegistrationEducationLocalServiceWrapper(
		UserRegistrationEducationLocalService
			userRegistrationEducationLocalService) {

		_userRegistrationEducationLocalService =
			userRegistrationEducationLocalService;
	}

	@Override
	public com.mypage.user.model.UserRegistrationEducation
			addUserRegistrationEducation(
				String name, int year, int graduate, String title,
				String courseType, String eduType, long userRegistrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationEducationLocalService.
			addUserRegistrationEducation(
				name, year, graduate, title, courseType, eduType,
				userRegistrationId);
	}

	/**
	 * Adds the user registration education to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationEducationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistrationEducation the user registration education
	 * @return the user registration education that was added
	 */
	@Override
	public com.mypage.user.model.UserRegistrationEducation
		addUserRegistrationEducation(
			com.mypage.user.model.UserRegistrationEducation
				userRegistrationEducation) {

		return _userRegistrationEducationLocalService.
			addUserRegistrationEducation(userRegistrationEducation);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationEducationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new user registration education with the primary key. Does not add the user registration education to the database.
	 *
	 * @param userRegistrationEducationId the primary key for the new user registration education
	 * @return the new user registration education
	 */
	@Override
	public com.mypage.user.model.UserRegistrationEducation
		createUserRegistrationEducation(long userRegistrationEducationId) {

		return _userRegistrationEducationLocalService.
			createUserRegistrationEducation(userRegistrationEducationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationEducationLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the user registration education with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationEducationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistrationEducationId the primary key of the user registration education
	 * @return the user registration education that was removed
	 * @throws PortalException if a user registration education with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.UserRegistrationEducation
			deleteUserRegistrationEducation(long userRegistrationEducationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationEducationLocalService.
			deleteUserRegistrationEducation(userRegistrationEducationId);
	}

	/**
	 * Deletes the user registration education from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationEducationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistrationEducation the user registration education
	 * @return the user registration education that was removed
	 */
	@Override
	public com.mypage.user.model.UserRegistrationEducation
		deleteUserRegistrationEducation(
			com.mypage.user.model.UserRegistrationEducation
				userRegistrationEducation) {

		return _userRegistrationEducationLocalService.
			deleteUserRegistrationEducation(userRegistrationEducation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userRegistrationEducationLocalService.dynamicQuery();
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

		return _userRegistrationEducationLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationEducationModelImpl</code>.
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

		return _userRegistrationEducationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationEducationModelImpl</code>.
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

		return _userRegistrationEducationLocalService.dynamicQuery(
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

		return _userRegistrationEducationLocalService.dynamicQueryCount(
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

		return _userRegistrationEducationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.user.model.UserRegistrationEducation
		fetchUserRegistrationEducation(long userRegistrationEducationId) {

		return _userRegistrationEducationLocalService.
			fetchUserRegistrationEducation(userRegistrationEducationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userRegistrationEducationLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userRegistrationEducationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userRegistrationEducationLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationEducationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the user registration education with the primary key.
	 *
	 * @param userRegistrationEducationId the primary key of the user registration education
	 * @return the user registration education
	 * @throws PortalException if a user registration education with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.UserRegistrationEducation
			getUserRegistrationEducation(long userRegistrationEducationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationEducationLocalService.
			getUserRegistrationEducation(userRegistrationEducationId);
	}

	/**
	 * Returns a range of all the user registration educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationEducationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration educations
	 * @param end the upper bound of the range of user registration educations (not inclusive)
	 * @return the range of user registration educations
	 */
	@Override
	public java.util.List<com.mypage.user.model.UserRegistrationEducation>
		getUserRegistrationEducations(int start, int end) {

		return _userRegistrationEducationLocalService.
			getUserRegistrationEducations(start, end);
	}

	/**
	 * Returns the number of user registration educations.
	 *
	 * @return the number of user registration educations
	 */
	@Override
	public int getUserRegistrationEducationsCount() {
		return _userRegistrationEducationLocalService.
			getUserRegistrationEducationsCount();
	}

	/**
	 * Updates the user registration education in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationEducationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistrationEducation the user registration education
	 * @return the user registration education that was updated
	 */
	@Override
	public com.mypage.user.model.UserRegistrationEducation
		updateUserRegistrationEducation(
			com.mypage.user.model.UserRegistrationEducation
				userRegistrationEducation) {

		return _userRegistrationEducationLocalService.
			updateUserRegistrationEducation(userRegistrationEducation);
	}

	@Override
	public UserRegistrationEducationLocalService getWrappedService() {
		return _userRegistrationEducationLocalService;
	}

	@Override
	public void setWrappedService(
		UserRegistrationEducationLocalService
			userRegistrationEducationLocalService) {

		_userRegistrationEducationLocalService =
			userRegistrationEducationLocalService;
	}

	private UserRegistrationEducationLocalService
		_userRegistrationEducationLocalService;

}