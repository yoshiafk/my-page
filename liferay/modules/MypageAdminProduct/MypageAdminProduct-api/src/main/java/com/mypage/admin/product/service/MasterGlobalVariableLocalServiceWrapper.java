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
 * Provides a wrapper for {@link MasterGlobalVariableLocalService}.
 *
 * @author Gositus Team
 * @see MasterGlobalVariableLocalService
 * @generated
 */
public class MasterGlobalVariableLocalServiceWrapper
	implements MasterGlobalVariableLocalService,
			   ServiceWrapper<MasterGlobalVariableLocalService> {

	public MasterGlobalVariableLocalServiceWrapper(
		MasterGlobalVariableLocalService masterGlobalVariableLocalService) {

		_masterGlobalVariableLocalService = masterGlobalVariableLocalService;
	}

	/**
	 * Adds the master global variable to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterGlobalVariableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterGlobalVariable the master global variable
	 * @return the master global variable that was added
	 */
	@Override
	public com.mypage.admin.product.model.MasterGlobalVariable
		addMasterGlobalVariable(
			com.mypage.admin.product.model.MasterGlobalVariable
				masterGlobalVariable) {

		return _masterGlobalVariableLocalService.addMasterGlobalVariable(
			masterGlobalVariable);
	}

	@Override
	public com.mypage.admin.product.model.MasterGlobalVariable
			addMasterGlobalVariable(
				String group, String name, String value, String imageURL,
				long imageFileEntryId, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterGlobalVariableLocalService.addMasterGlobalVariable(
			group, name, value, imageURL, imageFileEntryId, active);
	}

	/**
	 * Creates a new master global variable with the primary key. Does not add the master global variable to the database.
	 *
	 * @param masterGlobalVariableId the primary key for the new master global variable
	 * @return the new master global variable
	 */
	@Override
	public com.mypage.admin.product.model.MasterGlobalVariable
		createMasterGlobalVariable(long masterGlobalVariableId) {

		return _masterGlobalVariableLocalService.createMasterGlobalVariable(
			masterGlobalVariableId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterGlobalVariableLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the master global variable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterGlobalVariableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterGlobalVariableId the primary key of the master global variable
	 * @return the master global variable that was removed
	 * @throws PortalException if a master global variable with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterGlobalVariable
			deleteMasterGlobalVariable(long masterGlobalVariableId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterGlobalVariableLocalService.deleteMasterGlobalVariable(
			masterGlobalVariableId);
	}

	/**
	 * Deletes the master global variable from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterGlobalVariableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterGlobalVariable the master global variable
	 * @return the master global variable that was removed
	 */
	@Override
	public com.mypage.admin.product.model.MasterGlobalVariable
		deleteMasterGlobalVariable(
			com.mypage.admin.product.model.MasterGlobalVariable
				masterGlobalVariable) {

		return _masterGlobalVariableLocalService.deleteMasterGlobalVariable(
			masterGlobalVariable);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterGlobalVariableLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _masterGlobalVariableLocalService.dynamicQuery();
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

		return _masterGlobalVariableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterGlobalVariableModelImpl</code>.
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

		return _masterGlobalVariableLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterGlobalVariableModelImpl</code>.
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

		return _masterGlobalVariableLocalService.dynamicQuery(
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

		return _masterGlobalVariableLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _masterGlobalVariableLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.MasterGlobalVariable
		fetchMasterGlobalVariable(long masterGlobalVariableId) {

		return _masterGlobalVariableLocalService.fetchMasterGlobalVariable(
			masterGlobalVariableId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _masterGlobalVariableLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.MasterGlobalVariable>
		getActiveGlobalVariableByGroup(String groupName) {

		return _masterGlobalVariableLocalService.getActiveGlobalVariableByGroup(
			groupName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _masterGlobalVariableLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the master global variable with the primary key.
	 *
	 * @param masterGlobalVariableId the primary key of the master global variable
	 * @return the master global variable
	 * @throws PortalException if a master global variable with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterGlobalVariable
			getMasterGlobalVariable(long masterGlobalVariableId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterGlobalVariableLocalService.getMasterGlobalVariable(
			masterGlobalVariableId);
	}

	/**
	 * Returns a range of all the master global variables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterGlobalVariableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master global variables
	 * @param end the upper bound of the range of master global variables (not inclusive)
	 * @return the range of master global variables
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.MasterGlobalVariable>
		getMasterGlobalVariables(int start, int end) {

		return _masterGlobalVariableLocalService.getMasterGlobalVariables(
			start, end);
	}

	/**
	 * Returns the number of master global variables.
	 *
	 * @return the number of master global variables
	 */
	@Override
	public int getMasterGlobalVariablesCount() {
		return _masterGlobalVariableLocalService.
			getMasterGlobalVariablesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterGlobalVariableLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterGlobalVariableLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public com.mypage.admin.product.model.MasterGlobalVariable setActive(
			long masterGlobalVariableId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterGlobalVariableLocalService.setActive(
			masterGlobalVariableId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.MasterGlobalVariable
			updateMasterGlobalVariable(
				long masterGlobalVariableId, String group, String name,
				String value, String imageURL, long imageFileEntryId,
				int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterGlobalVariableLocalService.updateMasterGlobalVariable(
			masterGlobalVariableId, group, name, value, imageURL,
			imageFileEntryId, active);
	}

	/**
	 * Updates the master global variable in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterGlobalVariableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterGlobalVariable the master global variable
	 * @return the master global variable that was updated
	 */
	@Override
	public com.mypage.admin.product.model.MasterGlobalVariable
		updateMasterGlobalVariable(
			com.mypage.admin.product.model.MasterGlobalVariable
				masterGlobalVariable) {

		return _masterGlobalVariableLocalService.updateMasterGlobalVariable(
			masterGlobalVariable);
	}

	@Override
	public MasterGlobalVariableLocalService getWrappedService() {
		return _masterGlobalVariableLocalService;
	}

	@Override
	public void setWrappedService(
		MasterGlobalVariableLocalService masterGlobalVariableLocalService) {

		_masterGlobalVariableLocalService = masterGlobalVariableLocalService;
	}

	private MasterGlobalVariableLocalService _masterGlobalVariableLocalService;

}