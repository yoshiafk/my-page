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
 * Provides a wrapper for {@link StiBenefitValueMappingLocalService}.
 *
 * @author Gositus Team
 * @see StiBenefitValueMappingLocalService
 * @generated
 */
public class StiBenefitValueMappingLocalServiceWrapper
	implements ServiceWrapper<StiBenefitValueMappingLocalService>,
			   StiBenefitValueMappingLocalService {

	public StiBenefitValueMappingLocalServiceWrapper(
		StiBenefitValueMappingLocalService stiBenefitValueMappingLocalService) {

		_stiBenefitValueMappingLocalService =
			stiBenefitValueMappingLocalService;
	}

	/**
	 * Adds the sti benefit value mapping to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stiBenefitValueMapping the sti benefit value mapping
	 * @return the sti benefit value mapping that was added
	 */
	@Override
	public com.mypage.admin.product.model.StiBenefitValueMapping
		addStiBenefitValueMapping(
			com.mypage.admin.product.model.StiBenefitValueMapping
				stiBenefitValueMapping) {

		return _stiBenefitValueMappingLocalService.addStiBenefitValueMapping(
			stiBenefitValueMapping);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stiBenefitValueMappingLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new sti benefit value mapping with the primary key. Does not add the sti benefit value mapping to the database.
	 *
	 * @param benefitValueMappingId the primary key for the new sti benefit value mapping
	 * @return the new sti benefit value mapping
	 */
	@Override
	public com.mypage.admin.product.model.StiBenefitValueMapping
		createStiBenefitValueMapping(long benefitValueMappingId) {

		return _stiBenefitValueMappingLocalService.createStiBenefitValueMapping(
			benefitValueMappingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stiBenefitValueMappingLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the sti benefit value mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitValueMappingId the primary key of the sti benefit value mapping
	 * @return the sti benefit value mapping that was removed
	 * @throws PortalException if a sti benefit value mapping with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.StiBenefitValueMapping
			deleteStiBenefitValueMapping(long benefitValueMappingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stiBenefitValueMappingLocalService.deleteStiBenefitValueMapping(
			benefitValueMappingId);
	}

	/**
	 * Deletes the sti benefit value mapping from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stiBenefitValueMapping the sti benefit value mapping
	 * @return the sti benefit value mapping that was removed
	 */
	@Override
	public com.mypage.admin.product.model.StiBenefitValueMapping
		deleteStiBenefitValueMapping(
			com.mypage.admin.product.model.StiBenefitValueMapping
				stiBenefitValueMapping) {

		return _stiBenefitValueMappingLocalService.deleteStiBenefitValueMapping(
			stiBenefitValueMapping);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stiBenefitValueMappingLocalService.dynamicQuery();
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

		return _stiBenefitValueMappingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.StiBenefitValueMappingModelImpl</code>.
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

		return _stiBenefitValueMappingLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.StiBenefitValueMappingModelImpl</code>.
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

		return _stiBenefitValueMappingLocalService.dynamicQuery(
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

		return _stiBenefitValueMappingLocalService.dynamicQueryCount(
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

		return _stiBenefitValueMappingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.StiBenefitValueMapping
		fetchStiBenefitValueMapping(long benefitValueMappingId) {

		return _stiBenefitValueMappingLocalService.fetchStiBenefitValueMapping(
			benefitValueMappingId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stiBenefitValueMappingLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.StiBenefitValueMapping>
		getActiveBenefitValueMapping() {

		return _stiBenefitValueMappingLocalService.
			getActiveBenefitValueMapping();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.StiBenefitValueMapping>
		getAllBenefitValueMappingByBenefitType(long benefitTypeId) {

		return _stiBenefitValueMappingLocalService.
			getAllBenefitValueMappingByBenefitType(benefitTypeId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.StiBenefitValueMapping>
		getAllBenefitValueMappings() {

		return _stiBenefitValueMappingLocalService.getAllBenefitValueMappings();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.StiBenefitValueMapping>
		getBenefitValueMappingByBenefitTypeAndBenefit(
			long benefitTypeId, long benefitId) {

		return _stiBenefitValueMappingLocalService.
			getBenefitValueMappingByBenefitTypeAndBenefit(
				benefitTypeId, benefitId);
	}

	@Override
	public com.mypage.admin.product.model.StiBenefitValueMapping
		getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
			long benefitTypeId, long benefitId, long planId) {

		return _stiBenefitValueMappingLocalService.
			getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
				benefitTypeId, benefitId, planId);
	}

	@Override
	public int getBenefitValueMappingCount() {
		return _stiBenefitValueMappingLocalService.
			getBenefitValueMappingCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.StiBenefitValueMapping>
		getBenefitValueMappings(int start, int end) {

		return _stiBenefitValueMappingLocalService.getBenefitValueMappings(
			start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stiBenefitValueMappingLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stiBenefitValueMappingLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stiBenefitValueMappingLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the sti benefit value mapping with the primary key.
	 *
	 * @param benefitValueMappingId the primary key of the sti benefit value mapping
	 * @return the sti benefit value mapping
	 * @throws PortalException if a sti benefit value mapping with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.StiBenefitValueMapping
			getStiBenefitValueMapping(long benefitValueMappingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stiBenefitValueMappingLocalService.getStiBenefitValueMapping(
			benefitValueMappingId);
	}

	/**
	 * Returns a range of all the sti benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @return the range of sti benefit value mappings
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.StiBenefitValueMapping>
		getStiBenefitValueMappings(int start, int end) {

		return _stiBenefitValueMappingLocalService.getStiBenefitValueMappings(
			start, end);
	}

	/**
	 * Returns the number of sti benefit value mappings.
	 *
	 * @return the number of sti benefit value mappings
	 */
	@Override
	public int getStiBenefitValueMappingsCount() {
		return _stiBenefitValueMappingLocalService.
			getStiBenefitValueMappingsCount();
	}

	@Override
	public com.mypage.admin.product.model.StiBenefitValueMapping setActive(
			long benefitValueMappingId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stiBenefitValueMappingLocalService.setActive(
			benefitValueMappingId, active, serviceContext);
	}

	/**
	 * Updates the sti benefit value mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stiBenefitValueMapping the sti benefit value mapping
	 * @return the sti benefit value mapping that was updated
	 */
	@Override
	public com.mypage.admin.product.model.StiBenefitValueMapping
		updateStiBenefitValueMapping(
			com.mypage.admin.product.model.StiBenefitValueMapping
				stiBenefitValueMapping) {

		return _stiBenefitValueMappingLocalService.updateStiBenefitValueMapping(
			stiBenefitValueMapping);
	}

	@Override
	public StiBenefitValueMappingLocalService getWrappedService() {
		return _stiBenefitValueMappingLocalService;
	}

	@Override
	public void setWrappedService(
		StiBenefitValueMappingLocalService stiBenefitValueMappingLocalService) {

		_stiBenefitValueMappingLocalService =
			stiBenefitValueMappingLocalService;
	}

	private StiBenefitValueMappingLocalService
		_stiBenefitValueMappingLocalService;

}