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
 * Provides a wrapper for {@link MasterOccupationCategoryLocalService}.
 *
 * @author Gositus Team
 * @see MasterOccupationCategoryLocalService
 * @generated
 */
public class MasterOccupationCategoryLocalServiceWrapper
	implements MasterOccupationCategoryLocalService,
			   ServiceWrapper<MasterOccupationCategoryLocalService> {

	public MasterOccupationCategoryLocalServiceWrapper(
		MasterOccupationCategoryLocalService
			masterOccupationCategoryLocalService) {

		_masterOccupationCategoryLocalService =
			masterOccupationCategoryLocalService;
	}

	/**
	 * Adds the master occupation category to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterOccupationCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterOccupationCategory the master occupation category
	 * @return the master occupation category that was added
	 */
	@Override
	public com.mypage.admin.product.model.MasterOccupationCategory
		addMasterOccupationCategory(
			com.mypage.admin.product.model.MasterOccupationCategory
				masterOccupationCategory) {

		return _masterOccupationCategoryLocalService.
			addMasterOccupationCategory(masterOccupationCategory);
	}

	@Override
	public com.mypage.admin.product.model.MasterOccupationCategory
		addMasterOccupationCategory(String name, int active) {

		return _masterOccupationCategoryLocalService.
			addMasterOccupationCategory(name, active);
	}

	/**
	 * Creates a new master occupation category with the primary key. Does not add the master occupation category to the database.
	 *
	 * @param masterOccupationCategoryId the primary key for the new master occupation category
	 * @return the new master occupation category
	 */
	@Override
	public com.mypage.admin.product.model.MasterOccupationCategory
		createMasterOccupationCategory(long masterOccupationCategoryId) {

		return _masterOccupationCategoryLocalService.
			createMasterOccupationCategory(masterOccupationCategoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterOccupationCategoryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the master occupation category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterOccupationCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterOccupationCategoryId the primary key of the master occupation category
	 * @return the master occupation category that was removed
	 * @throws PortalException if a master occupation category with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterOccupationCategory
			deleteMasterOccupationCategory(long masterOccupationCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterOccupationCategoryLocalService.
			deleteMasterOccupationCategory(masterOccupationCategoryId);
	}

	/**
	 * Deletes the master occupation category from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterOccupationCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterOccupationCategory the master occupation category
	 * @return the master occupation category that was removed
	 */
	@Override
	public com.mypage.admin.product.model.MasterOccupationCategory
		deleteMasterOccupationCategory(
			com.mypage.admin.product.model.MasterOccupationCategory
				masterOccupationCategory) {

		return _masterOccupationCategoryLocalService.
			deleteMasterOccupationCategory(masterOccupationCategory);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterOccupationCategoryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _masterOccupationCategoryLocalService.dynamicQuery();
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

		return _masterOccupationCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterOccupationCategoryModelImpl</code>.
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

		return _masterOccupationCategoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterOccupationCategoryModelImpl</code>.
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

		return _masterOccupationCategoryLocalService.dynamicQuery(
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

		return _masterOccupationCategoryLocalService.dynamicQueryCount(
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

		return _masterOccupationCategoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.MasterOccupationCategory
		fetchMasterOccupationCategory(long masterOccupationCategoryId) {

		return _masterOccupationCategoryLocalService.
			fetchMasterOccupationCategory(masterOccupationCategoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _masterOccupationCategoryLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _masterOccupationCategoryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the master occupation categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @return the range of master occupation categories
	 */
	@Override
	public java.util.List
		<com.mypage.admin.product.model.MasterOccupationCategory>
			getMasterOccupationCategories(int start, int end) {

		return _masterOccupationCategoryLocalService.
			getMasterOccupationCategories(start, end);
	}

	/**
	 * Returns the number of master occupation categories.
	 *
	 * @return the number of master occupation categories
	 */
	@Override
	public int getMasterOccupationCategoriesCount() {
		return _masterOccupationCategoryLocalService.
			getMasterOccupationCategoriesCount();
	}

	/**
	 * Returns the master occupation category with the primary key.
	 *
	 * @param masterOccupationCategoryId the primary key of the master occupation category
	 * @return the master occupation category
	 * @throws PortalException if a master occupation category with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterOccupationCategory
			getMasterOccupationCategory(long masterOccupationCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterOccupationCategoryLocalService.
			getMasterOccupationCategory(masterOccupationCategoryId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterOccupationCategoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterOccupationCategoryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public java.util.List
		<com.mypage.admin.product.model.MasterOccupationCategory>
			searchByActive(int active) {

		return _masterOccupationCategoryLocalService.searchByActive(active);
	}

	@Override
	public com.mypage.admin.product.model.MasterOccupationCategory searchByName(
		String name) {

		return _masterOccupationCategoryLocalService.searchByName(name);
	}

	@Override
	public com.mypage.admin.product.model.MasterOccupationCategory setActive(
		long masterOccupationCategoryId, int active) {

		return _masterOccupationCategoryLocalService.setActive(
			masterOccupationCategoryId, active);
	}

	@Override
	public com.mypage.admin.product.model.MasterOccupationCategory
			updateMasterOccupationCategory(
				long masterOccupationCategoryId, String name, int active)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationCategoryException {

		return _masterOccupationCategoryLocalService.
			updateMasterOccupationCategory(
				masterOccupationCategoryId, name, active);
	}

	/**
	 * Updates the master occupation category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterOccupationCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterOccupationCategory the master occupation category
	 * @return the master occupation category that was updated
	 */
	@Override
	public com.mypage.admin.product.model.MasterOccupationCategory
		updateMasterOccupationCategory(
			com.mypage.admin.product.model.MasterOccupationCategory
				masterOccupationCategory) {

		return _masterOccupationCategoryLocalService.
			updateMasterOccupationCategory(masterOccupationCategory);
	}

	@Override
	public MasterOccupationCategoryLocalService getWrappedService() {
		return _masterOccupationCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		MasterOccupationCategoryLocalService
			masterOccupationCategoryLocalService) {

		_masterOccupationCategoryLocalService =
			masterOccupationCategoryLocalService;
	}

	private MasterOccupationCategoryLocalService
		_masterOccupationCategoryLocalService;

}