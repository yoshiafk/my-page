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

package com.mypage.admin.product.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MasterBranchLocalService}.
 *
 * @author Gositus Team
 * @see MasterBranchLocalService
 * @generated
 */
public class MasterBranchLocalServiceWrapper
	implements MasterBranchLocalService,
			   ServiceWrapper<MasterBranchLocalService> {

	public MasterBranchLocalServiceWrapper(
		MasterBranchLocalService masterBranchLocalService) {

		_masterBranchLocalService = masterBranchLocalService;
	}

	/**
	 * Adds the master branch to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterBranchLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterBranch the master branch
	 * @return the master branch that was added
	 */
	@Override
	public com.mypage.admin.product.model.MasterBranch addMasterBranch(
		com.mypage.admin.product.model.MasterBranch masterBranch) {

		return _masterBranchLocalService.addMasterBranch(masterBranch);
	}

	@Override
	public com.mypage.admin.product.model.MasterBranch addMasterBranch(
		String name, String agiCode, String magiCode, int active) {

		return _masterBranchLocalService.addMasterBranch(
			name, agiCode, magiCode, active);
	}

	/**
	 * Creates a new master branch with the primary key. Does not add the master branch to the database.
	 *
	 * @param masterBranchId the primary key for the new master branch
	 * @return the new master branch
	 */
	@Override
	public com.mypage.admin.product.model.MasterBranch createMasterBranch(
		long masterBranchId) {

		return _masterBranchLocalService.createMasterBranch(masterBranchId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterBranchLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the master branch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterBranchLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterBranchId the primary key of the master branch
	 * @return the master branch that was removed
	 * @throws PortalException if a master branch with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterBranch deleteMasterBranch(
			long masterBranchId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterBranchLocalService.deleteMasterBranch(masterBranchId);
	}

	/**
	 * Deletes the master branch from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterBranchLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterBranch the master branch
	 * @return the master branch that was removed
	 */
	@Override
	public com.mypage.admin.product.model.MasterBranch deleteMasterBranch(
		com.mypage.admin.product.model.MasterBranch masterBranch) {

		return _masterBranchLocalService.deleteMasterBranch(masterBranch);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterBranchLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _masterBranchLocalService.dynamicQuery();
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

		return _masterBranchLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterBranchModelImpl</code>.
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

		return _masterBranchLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterBranchModelImpl</code>.
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

		return _masterBranchLocalService.dynamicQuery(
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

		return _masterBranchLocalService.dynamicQueryCount(dynamicQuery);
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

		return _masterBranchLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.MasterBranch fetchMasterBranch(
		long masterBranchId) {

		return _masterBranchLocalService.fetchMasterBranch(masterBranchId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _masterBranchLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _masterBranchLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the master branch with the primary key.
	 *
	 * @param masterBranchId the primary key of the master branch
	 * @return the master branch
	 * @throws PortalException if a master branch with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterBranch getMasterBranch(
			long masterBranchId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterBranchLocalService.getMasterBranch(masterBranchId);
	}

	/**
	 * Returns a range of all the master branches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @return the range of master branches
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.MasterBranch>
		getMasterBranches(int start, int end) {

		return _masterBranchLocalService.getMasterBranches(start, end);
	}

	/**
	 * Returns the number of master branches.
	 *
	 * @return the number of master branches
	 */
	@Override
	public int getMasterBranchesCount() {
		return _masterBranchLocalService.getMasterBranchesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterBranchLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterBranchLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.MasterBranch>
		serachByName(String name) {

		return _masterBranchLocalService.serachByName(name);
	}

	@Override
	public com.mypage.admin.product.model.MasterBranch setActive(
		long masterBranchId, int active) {

		return _masterBranchLocalService.setActive(masterBranchId, active);
	}

	@Override
	public com.mypage.admin.product.model.MasterBranch updateMasterBranch(
		long masterBranchId, String name, String agiCode, String magiCode,
		int active) {

		return _masterBranchLocalService.updateMasterBranch(
			masterBranchId, name, agiCode, magiCode, active);
	}

	/**
	 * Updates the master branch in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterBranchLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterBranch the master branch
	 * @return the master branch that was updated
	 */
	@Override
	public com.mypage.admin.product.model.MasterBranch updateMasterBranch(
		com.mypage.admin.product.model.MasterBranch masterBranch) {

		return _masterBranchLocalService.updateMasterBranch(masterBranch);
	}

	@Override
	public MasterBranchLocalService getWrappedService() {
		return _masterBranchLocalService;
	}

	@Override
	public void setWrappedService(
		MasterBranchLocalService masterBranchLocalService) {

		_masterBranchLocalService = masterBranchLocalService;
	}

	private MasterBranchLocalService _masterBranchLocalService;

}