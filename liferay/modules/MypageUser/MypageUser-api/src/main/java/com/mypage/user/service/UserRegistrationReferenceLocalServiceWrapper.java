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
 * Provides a wrapper for {@link UserRegistrationReferenceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationReferenceLocalService
 * @generated
 */
public class UserRegistrationReferenceLocalServiceWrapper
	implements ServiceWrapper<UserRegistrationReferenceLocalService>,
			   UserRegistrationReferenceLocalService {

	public UserRegistrationReferenceLocalServiceWrapper(
		UserRegistrationReferenceLocalService
			userRegistrationReferenceLocalService) {

		_userRegistrationReferenceLocalService =
			userRegistrationReferenceLocalService;
	}

	@Override
	public com.mypage.user.model.UserRegistrationReference
			addUserRegistrationReference(
				String name, String relation, int age, String address,
				String phone, String job, int year, long userRegistrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationReferenceLocalService.
			addUserRegistrationReference(
				name, relation, age, address, phone, job, year,
				userRegistrationId);
	}

	/**
	 * Adds the user registration reference to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationReferenceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistrationReference the user registration reference
	 * @return the user registration reference that was added
	 */
	@Override
	public com.mypage.user.model.UserRegistrationReference
		addUserRegistrationReference(
			com.mypage.user.model.UserRegistrationReference
				userRegistrationReference) {

		return _userRegistrationReferenceLocalService.
			addUserRegistrationReference(userRegistrationReference);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationReferenceLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new user registration reference with the primary key. Does not add the user registration reference to the database.
	 *
	 * @param userRegistrationReferenceId the primary key for the new user registration reference
	 * @return the new user registration reference
	 */
	@Override
	public com.mypage.user.model.UserRegistrationReference
		createUserRegistrationReference(long userRegistrationReferenceId) {

		return _userRegistrationReferenceLocalService.
			createUserRegistrationReference(userRegistrationReferenceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationReferenceLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the user registration reference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationReferenceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistrationReferenceId the primary key of the user registration reference
	 * @return the user registration reference that was removed
	 * @throws PortalException if a user registration reference with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.UserRegistrationReference
			deleteUserRegistrationReference(long userRegistrationReferenceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationReferenceLocalService.
			deleteUserRegistrationReference(userRegistrationReferenceId);
	}

	/**
	 * Deletes the user registration reference from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationReferenceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistrationReference the user registration reference
	 * @return the user registration reference that was removed
	 */
	@Override
	public com.mypage.user.model.UserRegistrationReference
		deleteUserRegistrationReference(
			com.mypage.user.model.UserRegistrationReference
				userRegistrationReference) {

		return _userRegistrationReferenceLocalService.
			deleteUserRegistrationReference(userRegistrationReference);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userRegistrationReferenceLocalService.dynamicQuery();
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

		return _userRegistrationReferenceLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationReferenceModelImpl</code>.
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

		return _userRegistrationReferenceLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationReferenceModelImpl</code>.
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

		return _userRegistrationReferenceLocalService.dynamicQuery(
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

		return _userRegistrationReferenceLocalService.dynamicQueryCount(
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

		return _userRegistrationReferenceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.user.model.UserRegistrationReference
		fetchUserRegistrationReference(long userRegistrationReferenceId) {

		return _userRegistrationReferenceLocalService.
			fetchUserRegistrationReference(userRegistrationReferenceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userRegistrationReferenceLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userRegistrationReferenceLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userRegistrationReferenceLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationReferenceLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the user registration reference with the primary key.
	 *
	 * @param userRegistrationReferenceId the primary key of the user registration reference
	 * @return the user registration reference
	 * @throws PortalException if a user registration reference with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.UserRegistrationReference
			getUserRegistrationReference(long userRegistrationReferenceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationReferenceLocalService.
			getUserRegistrationReference(userRegistrationReferenceId);
	}

	/**
	 * Returns a range of all the user registration references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationReferenceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration references
	 * @param end the upper bound of the range of user registration references (not inclusive)
	 * @return the range of user registration references
	 */
	@Override
	public java.util.List<com.mypage.user.model.UserRegistrationReference>
		getUserRegistrationReferences(int start, int end) {

		return _userRegistrationReferenceLocalService.
			getUserRegistrationReferences(start, end);
	}

	/**
	 * Returns the number of user registration references.
	 *
	 * @return the number of user registration references
	 */
	@Override
	public int getUserRegistrationReferencesCount() {
		return _userRegistrationReferenceLocalService.
			getUserRegistrationReferencesCount();
	}

	/**
	 * Updates the user registration reference in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationReferenceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistrationReference the user registration reference
	 * @return the user registration reference that was updated
	 */
	@Override
	public com.mypage.user.model.UserRegistrationReference
		updateUserRegistrationReference(
			com.mypage.user.model.UserRegistrationReference
				userRegistrationReference) {

		return _userRegistrationReferenceLocalService.
			updateUserRegistrationReference(userRegistrationReference);
	}

	@Override
	public UserRegistrationReferenceLocalService getWrappedService() {
		return _userRegistrationReferenceLocalService;
	}

	@Override
	public void setWrappedService(
		UserRegistrationReferenceLocalService
			userRegistrationReferenceLocalService) {

		_userRegistrationReferenceLocalService =
			userRegistrationReferenceLocalService;
	}

	private UserRegistrationReferenceLocalService
		_userRegistrationReferenceLocalService;

}