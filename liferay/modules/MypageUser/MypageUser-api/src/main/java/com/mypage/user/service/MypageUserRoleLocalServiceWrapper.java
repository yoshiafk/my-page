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
 * Provides a wrapper for {@link MypageUserRoleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserRoleLocalService
 * @generated
 */
public class MypageUserRoleLocalServiceWrapper
	implements MypageUserRoleLocalService,
			   ServiceWrapper<MypageUserRoleLocalService> {

	public MypageUserRoleLocalServiceWrapper(
		MypageUserRoleLocalService mypageUserRoleLocalService) {

		_mypageUserRoleLocalService = mypageUserRoleLocalService;
	}

	/**
	 * Adds the mypage user role to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserRole the mypage user role
	 * @return the mypage user role that was added
	 */
	@Override
	public com.mypage.user.model.MypageUserRole addMypageUserRole(
		com.mypage.user.model.MypageUserRole mypageUserRole) {

		return _mypageUserRoleLocalService.addMypageUserRole(mypageUserRole);
	}

	@Override
	public com.mypage.user.model.MypageUserRole addUserRole(
			String name, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserRoleLocalService.addUserRole(name, active);
	}

	/**
	 * Creates a new mypage user role with the primary key. Does not add the mypage user role to the database.
	 *
	 * @param mypageUserRoleId the primary key for the new mypage user role
	 * @return the new mypage user role
	 */
	@Override
	public com.mypage.user.model.MypageUserRole createMypageUserRole(
		long mypageUserRoleId) {

		return _mypageUserRoleLocalService.createMypageUserRole(
			mypageUserRoleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserRoleLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the mypage user role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserRoleId the primary key of the mypage user role
	 * @return the mypage user role that was removed
	 * @throws PortalException if a mypage user role with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.MypageUserRole deleteMypageUserRole(
			long mypageUserRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserRoleLocalService.deleteMypageUserRole(
			mypageUserRoleId);
	}

	/**
	 * Deletes the mypage user role from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserRole the mypage user role
	 * @return the mypage user role that was removed
	 */
	@Override
	public com.mypage.user.model.MypageUserRole deleteMypageUserRole(
		com.mypage.user.model.MypageUserRole mypageUserRole) {

		return _mypageUserRoleLocalService.deleteMypageUserRole(mypageUserRole);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserRoleLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mypageUserRoleLocalService.dynamicQuery();
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

		return _mypageUserRoleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserRoleModelImpl</code>.
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

		return _mypageUserRoleLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserRoleModelImpl</code>.
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

		return _mypageUserRoleLocalService.dynamicQuery(
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

		return _mypageUserRoleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _mypageUserRoleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.user.model.MypageUserRole fetchMypageUserRole(
		long mypageUserRoleId) {

		return _mypageUserRoleLocalService.fetchMypageUserRole(
			mypageUserRoleId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _mypageUserRoleLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.user.model.MypageUserRole>
		getActiveRole() {

		return _mypageUserRoleLocalService.getActiveRole();
	}

	@Override
	public com.mypage.user.model.MypageUserRole getByName(String name) {
		return _mypageUserRoleLocalService.getByName(name);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _mypageUserRoleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the mypage user role with the primary key.
	 *
	 * @param mypageUserRoleId the primary key of the mypage user role
	 * @return the mypage user role
	 * @throws PortalException if a mypage user role with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.MypageUserRole getMypageUserRole(
			long mypageUserRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserRoleLocalService.getMypageUserRole(mypageUserRoleId);
	}

	/**
	 * Returns a range of all the mypage user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user roles
	 * @param end the upper bound of the range of mypage user roles (not inclusive)
	 * @return the range of mypage user roles
	 */
	@Override
	public java.util.List<com.mypage.user.model.MypageUserRole>
		getMypageUserRoles(int start, int end) {

		return _mypageUserRoleLocalService.getMypageUserRoles(start, end);
	}

	/**
	 * Returns the number of mypage user roles.
	 *
	 * @return the number of mypage user roles
	 */
	@Override
	public int getMypageUserRolesCount() {
		return _mypageUserRoleLocalService.getMypageUserRolesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mypageUserRoleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserRoleLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.user.model.MypageUserRole setActive(
			long mypageUserRoleId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserRoleLocalService.setActive(
			mypageUserRoleId, active, serviceContext);
	}

	/**
	 * Updates the mypage user role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserRole the mypage user role
	 * @return the mypage user role that was updated
	 */
	@Override
	public com.mypage.user.model.MypageUserRole updateMypageUserRole(
		com.mypage.user.model.MypageUserRole mypageUserRole) {

		return _mypageUserRoleLocalService.updateMypageUserRole(mypageUserRole);
	}

	@Override
	public com.mypage.user.model.MypageUserRole updateUserRole(
			long mypageUserRoleId, String name, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserRoleLocalService.updateUserRole(
			mypageUserRoleId, name, active);
	}

	@Override
	public MypageUserRoleLocalService getWrappedService() {
		return _mypageUserRoleLocalService;
	}

	@Override
	public void setWrappedService(
		MypageUserRoleLocalService mypageUserRoleLocalService) {

		_mypageUserRoleLocalService = mypageUserRoleLocalService;
	}

	private MypageUserRoleLocalService _mypageUserRoleLocalService;

}