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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.user.model.UserOneTimeCode;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for UserOneTimeCode. This utility wraps
 * <code>com.mypage.user.service.impl.UserOneTimeCodeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserOneTimeCodeLocalService
 * @generated
 */
public class UserOneTimeCodeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.user.service.impl.UserOneTimeCodeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static UserOneTimeCode addUserOneTimeCode(
		UserOneTimeCode userOneTimeCode) {

		return getService().addUserOneTimeCode(userOneTimeCode);
	}

	public static UserOneTimeCode addUserOTP(
		long userId, String sharedSecret, int expiresIn) {

		return getService().addUserOTP(userId, sharedSecret, expiresIn);
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
	 * Creates a new user one time code with the primary key. Does not add the user one time code to the database.
	 *
	 * @param userOneTimeCodeId the primary key for the new user one time code
	 * @return the new user one time code
	 */
	public static UserOneTimeCode createUserOneTimeCode(
		long userOneTimeCodeId) {

		return getService().createUserOneTimeCode(userOneTimeCodeId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static UserOneTimeCode deleteUserOneTimeCode(long userOneTimeCodeId)
		throws PortalException {

		return getService().deleteUserOneTimeCode(userOneTimeCodeId);
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
	public static UserOneTimeCode deleteUserOneTimeCode(
		UserOneTimeCode userOneTimeCode) {

		return getService().deleteUserOneTimeCode(userOneTimeCode);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserOneTimeCodeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserOneTimeCodeModelImpl</code>.
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

	public static UserOneTimeCode fetchUserOneTimeCode(long userOneTimeCodeId) {
		return getService().fetchUserOneTimeCode(userOneTimeCodeId);
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
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user one time code with the primary key.
	 *
	 * @param userOneTimeCodeId the primary key of the user one time code
	 * @return the user one time code
	 * @throws PortalException if a user one time code with the primary key could not be found
	 */
	public static UserOneTimeCode getUserOneTimeCode(long userOneTimeCodeId)
		throws PortalException {

		return getService().getUserOneTimeCode(userOneTimeCodeId);
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
	public static List<UserOneTimeCode> getUserOneTimeCodes(
		int start, int end) {

		return getService().getUserOneTimeCodes(start, end);
	}

	/**
	 * Returns the number of user one time codes.
	 *
	 * @return the number of user one time codes
	 */
	public static int getUserOneTimeCodesCount() {
		return getService().getUserOneTimeCodesCount();
	}

	public static UserOneTimeCode getUserOTP(long userId, String sharedSecret) {
		return getService().getUserOTP(userId, sharedSecret);
	}

	public static List<UserOneTimeCode> getUserOTPUnused(long userId) {
		return getService().getUserOTPUnused(userId);
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
	public static UserOneTimeCode updateUserOneTimeCode(
		UserOneTimeCode userOneTimeCode) {

		return getService().updateUserOneTimeCode(userOneTimeCode);
	}

	public static UserOneTimeCode updateUserOTP(
		long userId, String sharedSecret) {

		return getService().updateUserOTP(userId, sharedSecret);
	}

	public static UserOneTimeCodeLocalService getService() {
		return _service;
	}

	private static volatile UserOneTimeCodeLocalService _service;

}