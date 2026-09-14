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
 * Provides a wrapper for {@link UserOneTimeCodeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserOneTimeCodeLocalService
 * @generated
 */
public class UserOneTimeCodeLocalServiceWrapper
	implements ServiceWrapper<UserOneTimeCodeLocalService>,
			   UserOneTimeCodeLocalService {

	public UserOneTimeCodeLocalServiceWrapper(
		UserOneTimeCodeLocalService userOneTimeCodeLocalService) {

		_userOneTimeCodeLocalService = userOneTimeCodeLocalService;
	}

	/**
	 * Adds the user one time code to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserOneTimeCodeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userOneTimeCode the user one time code
	 * @return the user one time code that was added
	 */
	@Override
	public com.mypage.user.model.UserOneTimeCode addUserOneTimeCode(
		com.mypage.user.model.UserOneTimeCode userOneTimeCode) {

		return _userOneTimeCodeLocalService.addUserOneTimeCode(userOneTimeCode);
	}

	@Override
	public com.mypage.user.model.UserOneTimeCode addUserOTP(
		long userId, String sharedSecret, int expiresIn) {

		return _userOneTimeCodeLocalService.addUserOTP(
			userId, sharedSecret, expiresIn);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userOneTimeCodeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new user one time code with the primary key. Does not add the user one time code to the database.
	 *
	 * @param userOneTimeCodeId the primary key for the new user one time code
	 * @return the new user one time code
	 */
	@Override
	public com.mypage.user.model.UserOneTimeCode createUserOneTimeCode(
		long userOneTimeCodeId) {

		return _userOneTimeCodeLocalService.createUserOneTimeCode(
			userOneTimeCodeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userOneTimeCodeLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the user one time code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserOneTimeCodeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userOneTimeCodeId the primary key of the user one time code
	 * @return the user one time code that was removed
	 * @throws PortalException if a user one time code with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.UserOneTimeCode deleteUserOneTimeCode(
			long userOneTimeCodeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userOneTimeCodeLocalService.deleteUserOneTimeCode(
			userOneTimeCodeId);
	}

	/**
	 * Deletes the user one time code from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserOneTimeCodeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userOneTimeCode the user one time code
	 * @return the user one time code that was removed
	 */
	@Override
	public com.mypage.user.model.UserOneTimeCode deleteUserOneTimeCode(
		com.mypage.user.model.UserOneTimeCode userOneTimeCode) {

		return _userOneTimeCodeLocalService.deleteUserOneTimeCode(
			userOneTimeCode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userOneTimeCodeLocalService.dynamicQuery();
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

		return _userOneTimeCodeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserOneTimeCodeModelImpl</code>.
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

		return _userOneTimeCodeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserOneTimeCodeModelImpl</code>.
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

		return _userOneTimeCodeLocalService.dynamicQuery(
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

		return _userOneTimeCodeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _userOneTimeCodeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.user.model.UserOneTimeCode fetchUserOneTimeCode(
		long userOneTimeCodeId) {

		return _userOneTimeCodeLocalService.fetchUserOneTimeCode(
			userOneTimeCodeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userOneTimeCodeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userOneTimeCodeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userOneTimeCodeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userOneTimeCodeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user one time code with the primary key.
	 *
	 * @param userOneTimeCodeId the primary key of the user one time code
	 * @return the user one time code
	 * @throws PortalException if a user one time code with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.UserOneTimeCode getUserOneTimeCode(
			long userOneTimeCodeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userOneTimeCodeLocalService.getUserOneTimeCode(
			userOneTimeCodeId);
	}

	/**
	 * Returns a range of all the user one time codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserOneTimeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user one time codes
	 * @param end the upper bound of the range of user one time codes (not inclusive)
	 * @return the range of user one time codes
	 */
	@Override
	public java.util.List<com.mypage.user.model.UserOneTimeCode>
		getUserOneTimeCodes(int start, int end) {

		return _userOneTimeCodeLocalService.getUserOneTimeCodes(start, end);
	}

	/**
	 * Returns the number of user one time codes.
	 *
	 * @return the number of user one time codes
	 */
	@Override
	public int getUserOneTimeCodesCount() {
		return _userOneTimeCodeLocalService.getUserOneTimeCodesCount();
	}

	@Override
	public com.mypage.user.model.UserOneTimeCode getUserOTP(
		long userId, String sharedSecret) {

		return _userOneTimeCodeLocalService.getUserOTP(userId, sharedSecret);
	}

	@Override
	public java.util.List<com.mypage.user.model.UserOneTimeCode>
		getUserOTPUnused(long userId) {

		return _userOneTimeCodeLocalService.getUserOTPUnused(userId);
	}

	/**
	 * Updates the user one time code in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserOneTimeCodeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userOneTimeCode the user one time code
	 * @return the user one time code that was updated
	 */
	@Override
	public com.mypage.user.model.UserOneTimeCode updateUserOneTimeCode(
		com.mypage.user.model.UserOneTimeCode userOneTimeCode) {

		return _userOneTimeCodeLocalService.updateUserOneTimeCode(
			userOneTimeCode);
	}

	@Override
	public com.mypage.user.model.UserOneTimeCode updateUserOTP(
		long userId, String sharedSecret) {

		return _userOneTimeCodeLocalService.updateUserOTP(userId, sharedSecret);
	}

	@Override
	public UserOneTimeCodeLocalService getWrappedService() {
		return _userOneTimeCodeLocalService;
	}

	@Override
	public void setWrappedService(
		UserOneTimeCodeLocalService userOneTimeCodeLocalService) {

		_userOneTimeCodeLocalService = userOneTimeCodeLocalService;
	}

	private UserOneTimeCodeLocalService _userOneTimeCodeLocalService;

}