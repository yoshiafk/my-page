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
 * Provides a wrapper for {@link IndustryCategoryLocalService}.
 *
 * @author Gositus Team
 * @see IndustryCategoryLocalService
 * @generated
 */
public class IndustryCategoryLocalServiceWrapper
	implements IndustryCategoryLocalService,
			   ServiceWrapper<IndustryCategoryLocalService> {

	public IndustryCategoryLocalServiceWrapper(
		IndustryCategoryLocalService industryCategoryLocalService) {

		_industryCategoryLocalService = industryCategoryLocalService;
	}

	/**
	 * Adds the industry category to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IndustryCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param industryCategory the industry category
	 * @return the industry category that was added
	 */
	@Override
	public com.mypage.admin.product.model.IndustryCategory addIndustryCategory(
		com.mypage.admin.product.model.IndustryCategory industryCategory) {

		return _industryCategoryLocalService.addIndustryCategory(
			industryCategory);
	}

	@Override
	public com.mypage.admin.product.model.IndustryCategory addIndustryCategory(
			String name, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _industryCategoryLocalService.addIndustryCategory(name, active);
	}

	/**
	 * Creates a new industry category with the primary key. Does not add the industry category to the database.
	 *
	 * @param industryCategoryId the primary key for the new industry category
	 * @return the new industry category
	 */
	@Override
	public com.mypage.admin.product.model.IndustryCategory
		createIndustryCategory(long industryCategoryId) {

		return _industryCategoryLocalService.createIndustryCategory(
			industryCategoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _industryCategoryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the industry category from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IndustryCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param industryCategory the industry category
	 * @return the industry category that was removed
	 */
	@Override
	public com.mypage.admin.product.model.IndustryCategory
		deleteIndustryCategory(
			com.mypage.admin.product.model.IndustryCategory industryCategory) {

		return _industryCategoryLocalService.deleteIndustryCategory(
			industryCategory);
	}

	/**
	 * Deletes the industry category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IndustryCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param industryCategoryId the primary key of the industry category
	 * @return the industry category that was removed
	 * @throws PortalException if a industry category with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.IndustryCategory
			deleteIndustryCategory(long industryCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _industryCategoryLocalService.deleteIndustryCategory(
			industryCategoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _industryCategoryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _industryCategoryLocalService.dynamicQuery();
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

		return _industryCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.IndustryCategoryModelImpl</code>.
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

		return _industryCategoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.IndustryCategoryModelImpl</code>.
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

		return _industryCategoryLocalService.dynamicQuery(
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

		return _industryCategoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _industryCategoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.IndustryCategory
		fetchIndustryCategory(long industryCategoryId) {

		return _industryCategoryLocalService.fetchIndustryCategory(
			industryCategoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _industryCategoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.IndustryCategory>
		getActiveIndustryCategories() {

		return _industryCategoryLocalService.getActiveIndustryCategories();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _industryCategoryLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.IndustryCategory>
		getIndustryCategories() {

		return _industryCategoryLocalService.getIndustryCategories();
	}

	/**
	 * Returns a range of all the industry categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.IndustryCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of industry categories
	 * @param end the upper bound of the range of industry categories (not inclusive)
	 * @return the range of industry categories
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.IndustryCategory>
		getIndustryCategories(int start, int end) {

		return _industryCategoryLocalService.getIndustryCategories(start, end);
	}

	/**
	 * Returns the number of industry categories.
	 *
	 * @return the number of industry categories
	 */
	@Override
	public int getIndustryCategoriesCount() {
		return _industryCategoryLocalService.getIndustryCategoriesCount();
	}

	/**
	 * Returns the industry category with the primary key.
	 *
	 * @param industryCategoryId the primary key of the industry category
	 * @return the industry category
	 * @throws PortalException if a industry category with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.IndustryCategory getIndustryCategory(
			long industryCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _industryCategoryLocalService.getIndustryCategory(
			industryCategoryId);
	}

	@Override
	public int getIndustryCategoryCount() {
		return _industryCategoryLocalService.getIndustryCategoryCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _industryCategoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _industryCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.admin.product.model.IndustryCategory setActive(
			long industryCategoryId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _industryCategoryLocalService.setActive(
			industryCategoryId, active, serviceContext);
	}

	/**
	 * Updates the industry category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IndustryCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param industryCategory the industry category
	 * @return the industry category that was updated
	 */
	@Override
	public com.mypage.admin.product.model.IndustryCategory
		updateIndustryCategory(
			com.mypage.admin.product.model.IndustryCategory industryCategory) {

		return _industryCategoryLocalService.updateIndustryCategory(
			industryCategory);
	}

	@Override
	public com.mypage.admin.product.model.IndustryCategory
			updateIndustryCategory(
				long industryCategoryId, String name, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _industryCategoryLocalService.updateIndustryCategory(
			industryCategoryId, name, active);
	}

	@Override
	public IndustryCategoryLocalService getWrappedService() {
		return _industryCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		IndustryCategoryLocalService industryCategoryLocalService) {

		_industryCategoryLocalService = industryCategoryLocalService;
	}

	private IndustryCategoryLocalService _industryCategoryLocalService;

}