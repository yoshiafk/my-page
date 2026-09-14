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

import com.mypage.user.model.UserRegistrationLiability;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for UserRegistrationLiability. This utility wraps
 * <code>com.mypage.user.service.impl.UserRegistrationLiabilityLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationLiabilityLocalService
 * @generated
 */
public class UserRegistrationLiabilityLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.user.service.impl.UserRegistrationLiabilityLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static UserRegistrationLiability addUserRegistrationLiability(
			String name, String relationship, int age, long userRegistrationId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addUserRegistrationLiability(
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
	public static UserRegistrationLiability addUserRegistrationLiability(
		UserRegistrationLiability userRegistrationLiability) {

		return getService().addUserRegistrationLiability(
			userRegistrationLiability);
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
	 * Creates a new user registration liability with the primary key. Does not add the user registration liability to the database.
	 *
	 * @param userRegistrationLiabilityId the primary key for the new user registration liability
	 * @return the new user registration liability
	 */
	public static UserRegistrationLiability createUserRegistrationLiability(
		long userRegistrationLiabilityId) {

		return getService().createUserRegistrationLiability(
			userRegistrationLiabilityId);
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
	public static UserRegistrationLiability deleteUserRegistrationLiability(
			long userRegistrationLiabilityId)
		throws PortalException {

		return getService().deleteUserRegistrationLiability(
			userRegistrationLiabilityId);
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
	public static UserRegistrationLiability deleteUserRegistrationLiability(
		UserRegistrationLiability userRegistrationLiability) {

		return getService().deleteUserRegistrationLiability(
			userRegistrationLiability);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationLiabilityModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.UserRegistrationLiabilityModelImpl</code>.
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

	public static UserRegistrationLiability fetchUserRegistrationLiability(
		long userRegistrationLiabilityId) {

		return getService().fetchUserRegistrationLiability(
			userRegistrationLiabilityId);
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
	public static List<UserRegistrationLiability>
		getUserRegistrationLiabilities(int start, int end) {

		return getService().getUserRegistrationLiabilities(start, end);
	}

	/**
	 * Returns the number of user registration liabilities.
	 *
	 * @return the number of user registration liabilities
	 */
	public static int getUserRegistrationLiabilitiesCount() {
		return getService().getUserRegistrationLiabilitiesCount();
	}

	/**
	 * Returns the user registration liability with the primary key.
	 *
	 * @param userRegistrationLiabilityId the primary key of the user registration liability
	 * @return the user registration liability
	 * @throws PortalException if a user registration liability with the primary key could not be found
	 */
	public static UserRegistrationLiability getUserRegistrationLiability(
			long userRegistrationLiabilityId)
		throws PortalException {

		return getService().getUserRegistrationLiability(
			userRegistrationLiabilityId);
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
	public static UserRegistrationLiability updateUserRegistrationLiability(
		UserRegistrationLiability userRegistrationLiability) {

		return getService().updateUserRegistrationLiability(
			userRegistrationLiability);
	}

	public static UserRegistrationLiabilityLocalService getService() {
		return _service;
	}

	private static volatile UserRegistrationLiabilityLocalService _service;

}