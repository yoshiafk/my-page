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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SppkUserLocalService}.
 *
 * @author Gositus
 * @see SppkUserLocalService
 * @generated
 */
public class SppkUserLocalServiceWrapper
	implements ServiceWrapper<SppkUserLocalService>, SppkUserLocalService {

	public SppkUserLocalServiceWrapper(
		SppkUserLocalService sppkUserLocalService) {

		_sppkUserLocalService = sppkUserLocalService;
	}

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
	@Override
	public com.aii.esppk.admin.model.SppkUser addSppkUser(
		com.aii.esppk.admin.model.SppkUser sppkUser) {

		return _sppkUserLocalService.addSppkUser(sppkUser);
	}

	@Override
	public com.aii.esppk.admin.model.SppkUser addSppkUser(
			String fullName, String loginCode, String password, String email,
			String roleCode, int allAccess, int accessData,
			int accessMonitoring, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkUserLocalService.addSppkUser(
			fullName, loginCode, password, email, roleCode, allAccess,
			accessData, accessMonitoring, active);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkUserLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sppk user with the primary key. Does not add the sppk user to the database.
	 *
	 * @param sppkUserId the primary key for the new sppk user
	 * @return the new sppk user
	 */
	@Override
	public com.aii.esppk.admin.model.SppkUser createSppkUser(long sppkUserId) {
		return _sppkUserLocalService.createSppkUser(sppkUserId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkUserLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.aii.esppk.admin.model.SppkUser deleteSppkUser(long sppkUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkUserLocalService.deleteSppkUser(sppkUserId);
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
	@Override
	public com.aii.esppk.admin.model.SppkUser deleteSppkUser(
		com.aii.esppk.admin.model.SppkUser sppkUser) {

		return _sppkUserLocalService.deleteSppkUser(sppkUser);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sppkUserLocalService.dynamicQuery();
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

		return _sppkUserLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _sppkUserLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _sppkUserLocalService.dynamicQuery(
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

		return _sppkUserLocalService.dynamicQueryCount(dynamicQuery);
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

		return _sppkUserLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.aii.esppk.admin.model.SppkUser fetchSppkUser(long sppkUserId) {
		return _sppkUserLocalService.fetchSppkUser(sppkUserId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _sppkUserLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.aii.esppk.admin.model.SppkUser getByLoginCode(String username) {
		return _sppkUserLocalService.getByLoginCode(username);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _sppkUserLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sppkUserLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sppk user with the primary key.
	 *
	 * @param sppkUserId the primary key of the sppk user
	 * @return the sppk user
	 * @throws PortalException if a sppk user with the primary key could not be found
	 */
	@Override
	public com.aii.esppk.admin.model.SppkUser getSppkUser(long sppkUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkUserLocalService.getSppkUser(sppkUserId);
	}

	@Override
	public int getSppkUserCount() {
		return _sppkUserLocalService.getSppkUserCount();
	}

	@Override
	public java.util.List<com.aii.esppk.admin.model.SppkUser> getSppkUsers() {
		return _sppkUserLocalService.getSppkUsers();
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
	@Override
	public java.util.List<com.aii.esppk.admin.model.SppkUser> getSppkUsers(
		int start, int end) {

		return _sppkUserLocalService.getSppkUsers(start, end);
	}

	/**
	 * Returns the number of sppk users.
	 *
	 * @return the number of sppk users
	 */
	@Override
	public int getSppkUsersCount() {
		return _sppkUserLocalService.getSppkUsersCount();
	}

	@Override
	public com.aii.esppk.admin.model.SppkUser setActive(
		long sppkUserId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _sppkUserLocalService.setActive(
			sppkUserId, active, serviceContext);
	}

	@Override
	public com.aii.esppk.admin.model.SppkUser updateOtp(long sppkUserId) {
		return _sppkUserLocalService.updateOtp(sppkUserId);
	}

	@Override
	public com.aii.esppk.admin.model.SppkUser updateSppkUser(
			long sppkUserId, String fullName, String loginCode, String password,
			String email, String roleCode, int allAccess, int accessData,
			int accessMonitoring, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkUserLocalService.updateSppkUser(
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
	@Override
	public com.aii.esppk.admin.model.SppkUser updateSppkUser(
		com.aii.esppk.admin.model.SppkUser sppkUser) {

		return _sppkUserLocalService.updateSppkUser(sppkUser);
	}

	@Override
	public com.aii.esppk.admin.model.SppkUser verifyOtp(
		String email, String otpCode) {

		return _sppkUserLocalService.verifyOtp(email, otpCode);
	}

	@Override
	public SppkUserLocalService getWrappedService() {
		return _sppkUserLocalService;
	}

	@Override
	public void setWrappedService(SppkUserLocalService sppkUserLocalService) {
		_sppkUserLocalService = sppkUserLocalService;
	}

	private SppkUserLocalService _sppkUserLocalService;

}