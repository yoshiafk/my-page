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
 * Provides a wrapper for {@link IndustryLocalService}.
 *
 * @author Gositus Team
 * @see IndustryLocalService
 * @generated
 */
public class IndustryLocalServiceWrapper
	implements IndustryLocalService, ServiceWrapper<IndustryLocalService> {

	public IndustryLocalServiceWrapper(
		IndustryLocalService industryLocalService) {

		_industryLocalService = industryLocalService;
	}

	/**
	 * Adds the industry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IndustryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param industry the industry
	 * @return the industry that was added
	 */
	@Override
	public com.mypage.admin.product.model.Industry addIndustry(
		com.mypage.admin.product.model.Industry industry) {

		return _industryLocalService.addIndustry(industry);
	}

	@Override
	public com.mypage.admin.product.model.Industry addIndustry(
			String name, long industryCategoryId, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _industryLocalService.addIndustry(
			name, industryCategoryId, active);
	}

	/**
	 * Creates a new industry with the primary key. Does not add the industry to the database.
	 *
	 * @param industryId the primary key for the new industry
	 * @return the new industry
	 */
	@Override
	public com.mypage.admin.product.model.Industry createIndustry(
		long industryId) {

		return _industryLocalService.createIndustry(industryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _industryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the industry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IndustryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param industry the industry
	 * @return the industry that was removed
	 */
	@Override
	public com.mypage.admin.product.model.Industry deleteIndustry(
		com.mypage.admin.product.model.Industry industry) {

		return _industryLocalService.deleteIndustry(industry);
	}

	/**
	 * Deletes the industry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IndustryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param industryId the primary key of the industry
	 * @return the industry that was removed
	 * @throws PortalException if a industry with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.Industry deleteIndustry(
			long industryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _industryLocalService.deleteIndustry(industryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _industryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _industryLocalService.dynamicQuery();
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

		return _industryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.IndustryModelImpl</code>.
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

		return _industryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.IndustryModelImpl</code>.
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

		return _industryLocalService.dynamicQuery(
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

		return _industryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _industryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.Industry fetchIndustry(
		long industryId) {

		return _industryLocalService.fetchIndustry(industryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _industryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _industryLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.Industry>
		getIndustries() {

		return _industryLocalService.getIndustries();
	}

	/**
	 * Returns a range of all the industries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.IndustryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @return the range of industries
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.Industry>
		getIndustries(int start, int end) {

		return _industryLocalService.getIndustries(start, end);
	}

	/**
	 * Returns the number of industries.
	 *
	 * @return the number of industries
	 */
	@Override
	public int getIndustriesCount() {
		return _industryLocalService.getIndustriesCount();
	}

	/**
	 * Returns the industry with the primary key.
	 *
	 * @param industryId the primary key of the industry
	 * @return the industry
	 * @throws PortalException if a industry with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.Industry getIndustry(long industryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _industryLocalService.getIndustry(industryId);
	}

	@Override
	public int getIndustryCount() {
		return _industryLocalService.getIndustryCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _industryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _industryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.admin.product.model.Industry setActive(
			long industryId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _industryLocalService.setActive(
			industryId, active, serviceContext);
	}

	/**
	 * Updates the industry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IndustryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param industry the industry
	 * @return the industry that was updated
	 */
	@Override
	public com.mypage.admin.product.model.Industry updateIndustry(
		com.mypage.admin.product.model.Industry industry) {

		return _industryLocalService.updateIndustry(industry);
	}

	@Override
	public com.mypage.admin.product.model.Industry updateIndustry(
			long industryId, long industryCategoryId, String name, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _industryLocalService.updateIndustry(
			industryId, industryCategoryId, name, active);
	}

	@Override
	public IndustryLocalService getWrappedService() {
		return _industryLocalService;
	}

	@Override
	public void setWrappedService(IndustryLocalService industryLocalService) {
		_industryLocalService = industryLocalService;
	}

	private IndustryLocalService _industryLocalService;

}