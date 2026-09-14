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

package com.aii.esppk.admin.service;

import com.aii.esppk.admin.model.SppkUser;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SppkUser. This utility wraps
 * <code>com.aii.esppk.admin.service.impl.SppkUserLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus
 * @see SppkUserLocalService
 * @generated
 */
public class SppkUserLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.aii.esppk.admin.service.impl.SppkUserLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the sppk user to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SppkUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sppkUser the sppk user
	 * @return the sppk user that was added
	 */
	public static SppkUser addSppkUser(SppkUser sppkUser) {
		return getService().addSppkUser(sppkUser);
	}

	public static SppkUser addSppkUser(
			String fullName, String loginCode, String password, String email,
			String roleCode, int allAccess, int accessData,
			int accessMonitoring, int active)
		throws PortalException {

		return getService().addSppkUser(
			fullName, loginCode, password, email, roleCode, allAccess,
			accessData, accessMonitoring, active);
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
	 * Creates a new sppk user with the primary key. Does not add the sppk user to the database.
	 *
	 * @param sppkUserId the primary key for the new sppk user
	 * @return the new sppk user
	 */
	public static SppkUser createSppkUser(long sppkUserId) {
		return getService().createSppkUser(sppkUserId);
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
	 * Deletes the sppk user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SppkUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sppkUserId the primary key of the sppk user
	 * @return the sppk user that was removed
	 * @throws PortalException if a sppk user with the primary key could not be found
	 */
	public static SppkUser deleteSppkUser(long sppkUserId)
		throws PortalException {

		return getService().deleteSppkUser(sppkUserId);
	}

	/**
	 * Deletes the sppk user from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SppkUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sppkUser the sppk user
	 * @return the sppk user that was removed
	 */
	public static SppkUser deleteSppkUser(SppkUser sppkUser) {
		return getService().deleteSppkUser(sppkUser);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aii.esppk.admin.model.impl.SppkUserModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aii.esppk.admin.model.impl.SppkUserModelImpl</code>.
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

	public static SppkUser fetchSppkUser(long sppkUserId) {
		return getService().fetchSppkUser(sppkUserId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static SppkUser getByLoginCode(String username) {
		return getService().getByLoginCode(username);
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
	 * Returns the sppk user with the primary key.
	 *
	 * @param sppkUserId the primary key of the sppk user
	 * @return the sppk user
	 * @throws PortalException if a sppk user with the primary key could not be found
	 */
	public static SppkUser getSppkUser(long sppkUserId) throws PortalException {
		return getService().getSppkUser(sppkUserId);
	}

	public static int getSppkUserCount() {
		return getService().getSppkUserCount();
	}

	public static List<SppkUser> getSppkUsers() {
		return getService().getSppkUsers();
	}

	/**
	 * Returns a range of all the sppk users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aii.esppk.admin.model.impl.SppkUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sppk users
	 * @param end the upper bound of the range of sppk users (not inclusive)
	 * @return the range of sppk users
	 */
	public static List<SppkUser> getSppkUsers(int start, int end) {
		return getService().getSppkUsers(start, end);
	}

	/**
	 * Returns the number of sppk users.
	 *
	 * @return the number of sppk users
	 */
	public static int getSppkUsersCount() {
		return getService().getSppkUsersCount();
	}

	public static SppkUser setActive(
		long sppkUserId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().setActive(sppkUserId, active, serviceContext);
	}

	public static SppkUser updateOtp(long sppkUserId) {
		return getService().updateOtp(sppkUserId);
	}

	public static SppkUser updateSppkUser(
			long sppkUserId, String fullName, String loginCode, String password,
			String email, String roleCode, int allAccess, int accessData,
			int accessMonitoring, int active)
		throws PortalException {

		return getService().updateSppkUser(
			sppkUserId, fullName, loginCode, password, email, roleCode,
			allAccess, accessData, accessMonitoring, active);
	}

	/**
	 * Updates the sppk user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SppkUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sppkUser the sppk user
	 * @return the sppk user that was updated
	 */
	public static SppkUser updateSppkUser(SppkUser sppkUser) {
		return getService().updateSppkUser(sppkUser);
	}

	public static SppkUser verifyOtp(String email, String otpCode) {
		return getService().verifyOtp(email, otpCode);
	}

	public static SppkUserLocalService getService() {
		return _service;
	}

	private static volatile SppkUserLocalService _service;

}