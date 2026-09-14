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
 * Provides a wrapper for {@link UserRegistrationJobExpLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationJobExpLocalService
 * @generated
 */
public class UserRegistrationJobExpLocalServiceWrapper
	implements ServiceWrapper<UserRegistrationJobExpLocalService>,
			   UserRegistrationJobExpLocalService {

	public UserRegistrationJobExpLocalServiceWrapper(
		UserRegistrationJobExpLocalService userRegistrationJobExpLocalService) {

		_userRegistrationJobExpLocalService =
			userRegistrationJobExpLocalService;
	}

	@Override
	public com.mypage.user.model.UserRegistrationJobExp
			addUserRegistrationJobExp(
				String name, int year, String jobHead, String jobPosition,
				String jobIncome, int otherInsuranceCompany,
				long userRegistrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationJobExpLocalService.addUserRegistrationJobExp(
			name, year, jobHead, jobPosition, jobIncome, otherInsuranceCompany,
			userRegistrationId);
	}

	/**
	 * Adds the user registration job exp to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationJobExpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistrationJobExp the user registration job exp
	 * @return the user registration job exp that was added
	 */
	@Override
	public com.mypage.user.model.UserRegistrationJobExp
		addUserRegistrationJobExp(
			com.mypage.user.model.UserRegistrationJobExp
				userRegistrationJobExp) {

		return _userRegistrationJobExpLocalService.addUserRegistrationJobExp(
			userRegistrationJobExp);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationJobExpLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new user registration job exp with the primary key. Does not add the user registration job exp to the database.
	 *
	 * @param userRegistrationJobExpId the primary key for the new user registration job exp
	 * @return the new user registration job exp
	 */
	@Override
	public com.mypage.user.model.UserRegistrationJobExp
		createUserRegistrationJobExp(long userRegistrationJobExpId) {

		return _userRegistrationJobExpLocalService.createUserRegistrationJobExp(
			userRegistrationJobExpId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationJobExpLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the user registration job exp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationJobExpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistrationJobExpId the primary key of the user registration job exp
	 * @return the user registration job exp that was removed
	 * @throws PortalException if a user registration job exp with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.UserRegistrationJobExp
			deleteUserRegistrationJobExp(long userRegistrationJobExpId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationJobExpLocalService.deleteUserRegistrationJobExp(
			userRegistrationJobExpId);
	}

	/**
	 * Deletes the user registration job exp from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationJobExpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistrationJobExp the user registration job exp
	 * @return the user registration job exp that was removed
	 */
	@Override
	public com.mypage.user.model.UserRegistrationJobExp
		deleteUserRegistrationJobExp(
			com.mypage.user.model.UserRegistrationJobExp
				userRegistrationJobExp) {

		return _userRegistrationJobExpLocalService.deleteUserRegistrationJobExp(
			userRegistrationJobExp);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userRegistrationJobExpLocalService.dynamicQuery();
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

		return _userRegistrationJobExpLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationJobExpModelImpl</code>.
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

		return _userRegistrationJobExpLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationJobExpModelImpl</code>.
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

		return _userRegistrationJobExpLocalService.dynamicQuery(
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

		return _userRegistrationJobExpLocalService.dynamicQueryCount(
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

		return _userRegistrationJobExpLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.user.model.UserRegistrationJobExp
		fetchUserRegistrationJobExp(long userRegistrationJobExpId) {

		return _userRegistrationJobExpLocalService.fetchUserRegistrationJobExp(
			userRegistrationJobExpId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userRegistrationJobExpLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userRegistrationJobExpLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userRegistrationJobExpLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationJobExpLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the user registration job exp with the primary key.
	 *
	 * @param userRegistrationJobExpId the primary key of the user registration job exp
	 * @return the user registration job exp
	 * @throws PortalException if a user registration job exp with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.UserRegistrationJobExp
			getUserRegistrationJobExp(long userRegistrationJobExpId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRegistrationJobExpLocalService.getUserRegistrationJobExp(
			userRegistrationJobExpId);
	}

	/**
	 * Returns a range of all the user registration job exps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationJobExpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration job exps
	 * @param end the upper bound of the range of user registration job exps (not inclusive)
	 * @return the range of user registration job exps
	 */
	@Override
	public java.util.List<com.mypage.user.model.UserRegistrationJobExp>
		getUserRegistrationJobExps(int start, int end) {

		return _userRegistrationJobExpLocalService.getUserRegistrationJobExps(
			start, end);
	}

	/**
	 * Returns the number of user registration job exps.
	 *
	 * @return the number of user registration job exps
	 */
	@Override
	public int getUserRegistrationJobExpsCount() {
		return _userRegistrationJobExpLocalService.
			getUserRegistrationJobExpsCount();
	}

	/**
	 * Updates the user registration job exp in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserRegistrationJobExpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userRegistrationJobExp the user registration job exp
	 * @return the user registration job exp that was updated
	 */
	@Override
	public com.mypage.user.model.UserRegistrationJobExp
		updateUserRegistrationJobExp(
			com.mypage.user.model.UserRegistrationJobExp
				userRegistrationJobExp) {

		return _userRegistrationJobExpLocalService.updateUserRegistrationJobExp(
			userRegistrationJobExp);
	}

	@Override
	public UserRegistrationJobExpLocalService getWrappedService() {
		return _userRegistrationJobExpLocalService;
	}

	@Override
	public void setWrappedService(
		UserRegistrationJobExpLocalService userRegistrationJobExpLocalService) {

		_userRegistrationJobExpLocalService =
			userRegistrationJobExpLocalService;
	}

	private UserRegistrationJobExpLocalService
		_userRegistrationJobExpLocalService;

}