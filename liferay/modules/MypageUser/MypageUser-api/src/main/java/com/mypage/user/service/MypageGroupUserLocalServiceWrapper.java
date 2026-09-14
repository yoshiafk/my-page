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
 * Provides a wrapper for {@link MypageGroupUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MypageGroupUserLocalService
 * @generated
 */
public class MypageGroupUserLocalServiceWrapper
	implements MypageGroupUserLocalService,
			   ServiceWrapper<MypageGroupUserLocalService> {

	public MypageGroupUserLocalServiceWrapper(
		MypageGroupUserLocalService mypageGroupUserLocalService) {

		_mypageGroupUserLocalService = mypageGroupUserLocalService;
	}

	@Override
	public com.mypage.user.model.MypageGroupUser addGroupUser(
			long mypageGroupId, java.util.List<Long> mypageUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageGroupUserLocalService.addGroupUser(
			mypageGroupId, mypageUserId);
	}

	/**
	 * Adds the mypage group user to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageGroupUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageGroupUser the mypage group user
	 * @return the mypage group user that was added
	 */
	@Override
	public com.mypage.user.model.MypageGroupUser addMypageGroupUser(
		com.mypage.user.model.MypageGroupUser mypageGroupUser) {

		return _mypageGroupUserLocalService.addMypageGroupUser(mypageGroupUser);
	}

	/**
	 * Creates a new mypage group user with the primary key. Does not add the mypage group user to the database.
	 *
	 * @param mypageGroupUserId the primary key for the new mypage group user
	 * @return the new mypage group user
	 */
	@Override
	public com.mypage.user.model.MypageGroupUser createMypageGroupUser(
		long mypageGroupUserId) {

		return _mypageGroupUserLocalService.createMypageGroupUser(
			mypageGroupUserId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageGroupUserLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the mypage group user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageGroupUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageGroupUserId the primary key of the mypage group user
	 * @return the mypage group user that was removed
	 * @throws PortalException if a mypage group user with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.MypageGroupUser deleteMypageGroupUser(
			long mypageGroupUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageGroupUserLocalService.deleteMypageGroupUser(
			mypageGroupUserId);
	}

	/**
	 * Deletes the mypage group user from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageGroupUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageGroupUser the mypage group user
	 * @return the mypage group user that was removed
	 */
	@Override
	public com.mypage.user.model.MypageGroupUser deleteMypageGroupUser(
		com.mypage.user.model.MypageGroupUser mypageGroupUser) {

		return _mypageGroupUserLocalService.deleteMypageGroupUser(
			mypageGroupUser);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageGroupUserLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mypageGroupUserLocalService.dynamicQuery();
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

		return _mypageGroupUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageGroupUserModelImpl</code>.
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

		return _mypageGroupUserLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageGroupUserModelImpl</code>.
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

		return _mypageGroupUserLocalService.dynamicQuery(
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

		return _mypageGroupUserLocalService.dynamicQueryCount(dynamicQuery);
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

		return _mypageGroupUserLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.user.model.MypageGroupUser fetchMypageGroupUser(
		long mypageGroupUserId) {

		return _mypageGroupUserLocalService.fetchMypageGroupUser(
			mypageGroupUserId);
	}

	@Override
	public java.util.List<com.mypage.user.model.MypageUser> findBymypageGroupId(
		long mypageGroupId) {

		return _mypageGroupUserLocalService.findBymypageGroupId(mypageGroupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _mypageGroupUserLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.user.model.MypageUserGroup>
		getActiveGroup() {

		return _mypageGroupUserLocalService.getActiveGroup();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _mypageGroupUserLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the mypage group user with the primary key.
	 *
	 * @param mypageGroupUserId the primary key of the mypage group user
	 * @return the mypage group user
	 * @throws PortalException if a mypage group user with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.MypageGroupUser getMypageGroupUser(
			long mypageGroupUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageGroupUserLocalService.getMypageGroupUser(
			mypageGroupUserId);
	}

	/**
	 * Returns a range of all the mypage group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageGroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage group users
	 * @param end the upper bound of the range of mypage group users (not inclusive)
	 * @return the range of mypage group users
	 */
	@Override
	public java.util.List<com.mypage.user.model.MypageGroupUser>
		getMypageGroupUsers(int start, int end) {

		return _mypageGroupUserLocalService.getMypageGroupUsers(start, end);
	}

	/**
	 * Returns the number of mypage group users.
	 *
	 * @return the number of mypage group users
	 */
	@Override
	public int getMypageGroupUsersCount() {
		return _mypageGroupUserLocalService.getMypageGroupUsersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mypageGroupUserLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageGroupUserLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.user.model.MypageGroupUser removeGroupUser(
			long mypageGroupId, java.util.List<Long> mypageUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageGroupUserLocalService.removeGroupUser(
			mypageGroupId, mypageUserId);
	}

	/**
	 * Updates the mypage group user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageGroupUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageGroupUser the mypage group user
	 * @return the mypage group user that was updated
	 */
	@Override
	public com.mypage.user.model.MypageGroupUser updateMypageGroupUser(
		com.mypage.user.model.MypageGroupUser mypageGroupUser) {

		return _mypageGroupUserLocalService.updateMypageGroupUser(
			mypageGroupUser);
	}

	@Override
	public MypageGroupUserLocalService getWrappedService() {
		return _mypageGroupUserLocalService;
	}

	@Override
	public void setWrappedService(
		MypageGroupUserLocalService mypageGroupUserLocalService) {

		_mypageGroupUserLocalService = mypageGroupUserLocalService;
	}

	private MypageGroupUserLocalService _mypageGroupUserLocalService;

}