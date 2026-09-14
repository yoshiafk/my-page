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
 * Provides a wrapper for {@link MypageUserLicensesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserLicensesLocalService
 * @generated
 */
public class MypageUserLicensesLocalServiceWrapper
	implements MypageUserLicensesLocalService,
			   ServiceWrapper<MypageUserLicensesLocalService> {

	public MypageUserLicensesLocalServiceWrapper(
		MypageUserLicensesLocalService mypageUserLicensesLocalService) {

		_mypageUserLicensesLocalService = mypageUserLicensesLocalService;
	}

	@Override
	public com.mypage.user.model.MypageUserLicenses addMypageUserLicense(
		long mypageUserId, long productId) {

		return _mypageUserLicensesLocalService.addMypageUserLicense(
			mypageUserId, productId);
	}

	/**
	 * Adds the mypage user licenses to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserLicensesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserLicenses the mypage user licenses
	 * @return the mypage user licenses that was added
	 */
	@Override
	public com.mypage.user.model.MypageUserLicenses addMypageUserLicenses(
		com.mypage.user.model.MypageUserLicenses mypageUserLicenses) {

		return _mypageUserLicensesLocalService.addMypageUserLicenses(
			mypageUserLicenses);
	}

	/**
	 * Creates a new mypage user licenses with the primary key. Does not add the mypage user licenses to the database.
	 *
	 * @param mypageUserLicensesId the primary key for the new mypage user licenses
	 * @return the new mypage user licenses
	 */
	@Override
	public com.mypage.user.model.MypageUserLicenses createMypageUserLicenses(
		long mypageUserLicensesId) {

		return _mypageUserLicensesLocalService.createMypageUserLicenses(
			mypageUserLicensesId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserLicensesLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the mypage user licenses with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserLicensesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserLicensesId the primary key of the mypage user licenses
	 * @return the mypage user licenses that was removed
	 * @throws PortalException if a mypage user licenses with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.MypageUserLicenses deleteMypageUserLicenses(
			long mypageUserLicensesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserLicensesLocalService.deleteMypageUserLicenses(
			mypageUserLicensesId);
	}

	/**
	 * Deletes the mypage user licenses from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserLicensesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserLicenses the mypage user licenses
	 * @return the mypage user licenses that was removed
	 */
	@Override
	public com.mypage.user.model.MypageUserLicenses deleteMypageUserLicenses(
		com.mypage.user.model.MypageUserLicenses mypageUserLicenses) {

		return _mypageUserLicensesLocalService.deleteMypageUserLicenses(
			mypageUserLicenses);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserLicensesLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mypageUserLicensesLocalService.dynamicQuery();
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

		return _mypageUserLicensesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserLicensesModelImpl</code>.
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

		return _mypageUserLicensesLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserLicensesModelImpl</code>.
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

		return _mypageUserLicensesLocalService.dynamicQuery(
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

		return _mypageUserLicensesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _mypageUserLicensesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.user.model.MypageUserLicenses fetchMypageUserLicenses(
		long mypageUserLicensesId) {

		return _mypageUserLicensesLocalService.fetchMypageUserLicenses(
			mypageUserLicensesId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _mypageUserLicensesLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.user.model.MypageUserLicenses>
		getByMypageUserId(long mypageUserId) {

		return _mypageUserLicensesLocalService.getByMypageUserId(mypageUserId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _mypageUserLicensesLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the mypage user licenses with the primary key.
	 *
	 * @param mypageUserLicensesId the primary key of the mypage user licenses
	 * @return the mypage user licenses
	 * @throws PortalException if a mypage user licenses with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.MypageUserLicenses getMypageUserLicenses(
			long mypageUserLicensesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserLicensesLocalService.getMypageUserLicenses(
			mypageUserLicensesId);
	}

	/**
	 * Returns a range of all the mypage user licenseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @return the range of mypage user licenseses
	 */
	@Override
	public java.util.List<com.mypage.user.model.MypageUserLicenses>
		getMypageUserLicenseses(int start, int end) {

		return _mypageUserLicensesLocalService.getMypageUserLicenseses(
			start, end);
	}

	/**
	 * Returns the number of mypage user licenseses.
	 *
	 * @return the number of mypage user licenseses
	 */
	@Override
	public int getMypageUserLicensesesCount() {
		return _mypageUserLicensesLocalService.getMypageUserLicensesesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mypageUserLicensesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserLicensesLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void removeByMypageUserId(long mypageUserId) {
		_mypageUserLicensesLocalService.removeByMypageUserId(mypageUserId);
	}

	/**
	 * Updates the mypage user licenses in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserLicensesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserLicenses the mypage user licenses
	 * @return the mypage user licenses that was updated
	 */
	@Override
	public com.mypage.user.model.MypageUserLicenses updateMypageUserLicenses(
		com.mypage.user.model.MypageUserLicenses mypageUserLicenses) {

		return _mypageUserLicensesLocalService.updateMypageUserLicenses(
			mypageUserLicenses);
	}

	@Override
	public MypageUserLicensesLocalService getWrappedService() {
		return _mypageUserLicensesLocalService;
	}

	@Override
	public void setWrappedService(
		MypageUserLicensesLocalService mypageUserLicensesLocalService) {

		_mypageUserLicensesLocalService = mypageUserLicensesLocalService;
	}

	private MypageUserLicensesLocalService _mypageUserLicensesLocalService;

}