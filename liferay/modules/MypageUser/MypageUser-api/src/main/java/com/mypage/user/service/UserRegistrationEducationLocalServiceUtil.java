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

import com.mypage.user.model.UserRegistrationEducation;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for UserRegistrationEducation. This utility wraps
 * <code>com.mypage.user.service.impl.UserRegistrationEducationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationEducationLocalService
 * @generated
 */
public class UserRegistrationEducationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.user.service.impl.UserRegistrationEducationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static UserRegistrationEducation addUserRegistrationEducation(
			String name, int year, int graduate, String title,
			String courseType, String eduType, long userRegistrationId)
		throws PortalException {

		return getService().addUserRegistrationEducation(
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
	public static UserRegistrationEducation addUserRegistrationEducation(
		UserRegistrationEducation userRegistrationEducation) {

		return getService().addUserRegistrationEducation(
			userRegistrationEducation);
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
	 * Creates a new user registration education with the primary key. Does not add the user registration education to the database.
	 *
	 * @param userRegistrationEducationId the primary key for the new user registration education
	 * @return the new user registration education
	 */
	public static UserRegistrationEducation createUserRegistrationEducation(
		long userRegistrationEducationId) {

		return getService().createUserRegistrationEducation(
			userRegistrationEducationId);
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
	public static UserRegistrationEducation deleteUserRegistrationEducation(
			long userRegistrationEducationId)
		throws PortalException {

		return getService().deleteUserRegistrationEducation(
			userRegistrationEducationId);
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
	public static UserRegistrationEducation deleteUserRegistrationEducation(
		UserRegistrationEducation userRegistrationEducation) {

		return getService().deleteUserRegistrationEducation(
			userRegistrationEducation);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationEducationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationEducationModelImpl</code>.
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

	public static UserRegistrationEducation fetchUserRegistrationEducation(
		long userRegistrationEducationId) {

		return getService().fetchUserRegistrationEducation(
			userRegistrationEducationId);
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
	 * Returns the user registration education with the primary key.
	 *
	 * @param userRegistrationEducationId the primary key of the user registration education
	 * @return the user registration education
	 * @throws PortalException if a user registration education with the primary key could not be found
	 */
	public static UserRegistrationEducation getUserRegistrationEducation(
			long userRegistrationEducationId)
		throws PortalException {

		return getService().getUserRegistrationEducation(
			userRegistrationEducationId);
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
	public static List<UserRegistrationEducation> getUserRegistrationEducations(
		int start, int end) {

		return getService().getUserRegistrationEducations(start, end);
	}

	/**
	 * Returns the number of user registration educations.
	 *
	 * @return the number of user registration educations
	 */
	public static int getUserRegistrationEducationsCount() {
		return getService().getUserRegistrationEducationsCount();
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
	public static UserRegistrationEducation updateUserRegistrationEducation(
		UserRegistrationEducation userRegistrationEducation) {

		return getService().updateUserRegistrationEducation(
			userRegistrationEducation);
	}

	public static UserRegistrationEducationLocalService getService() {
		return _service;
	}

	private static volatile UserRegistrationEducationLocalService _service;

}