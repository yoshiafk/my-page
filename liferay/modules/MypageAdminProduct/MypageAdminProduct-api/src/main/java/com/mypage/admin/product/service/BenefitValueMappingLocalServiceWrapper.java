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
 * Provides a wrapper for {@link BenefitValueMappingLocalService}.
 *
 * @author Gositus Team
 * @see BenefitValueMappingLocalService
 * @generated
 */
public class BenefitValueMappingLocalServiceWrapper
	implements BenefitValueMappingLocalService,
			   ServiceWrapper<BenefitValueMappingLocalService> {

	public BenefitValueMappingLocalServiceWrapper(
		BenefitValueMappingLocalService benefitValueMappingLocalService) {

		_benefitValueMappingLocalService = benefitValueMappingLocalService;
	}

	/**
	 * Adds the benefit value mapping to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitValueMapping the benefit value mapping
	 * @return the benefit value mapping that was added
	 */
	@Override
	public com.mypage.admin.product.model.BenefitValueMapping
		addBenefitValueMapping(
			com.mypage.admin.product.model.BenefitValueMapping
				benefitValueMapping) {

		return _benefitValueMappingLocalService.addBenefitValueMapping(
			benefitValueMapping);
	}

	@Override
	public com.mypage.admin.product.model.BenefitValueMapping
			addBenefitValueMapping(
				long benefitTypeId, long benefitId, long planId,
				String benefitValue, String benefitValueUSD, int sort,
				int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitValueMappingLocalService.addBenefitValueMapping(
			benefitTypeId, benefitId, planId, benefitValue, benefitValueUSD,
			sort, active);
	}

	/**
	 * Creates a new benefit value mapping with the primary key. Does not add the benefit value mapping to the database.
	 *
	 * @param benefitValueMappingId the primary key for the new benefit value mapping
	 * @return the new benefit value mapping
	 */
	@Override
	public com.mypage.admin.product.model.BenefitValueMapping
		createBenefitValueMapping(long benefitValueMappingId) {

		return _benefitValueMappingLocalService.createBenefitValueMapping(
			benefitValueMappingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitValueMappingLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the benefit value mapping from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitValueMapping the benefit value mapping
	 * @return the benefit value mapping that was removed
	 */
	@Override
	public com.mypage.admin.product.model.BenefitValueMapping
		deleteBenefitValueMapping(
			com.mypage.admin.product.model.BenefitValueMapping
				benefitValueMapping) {

		return _benefitValueMappingLocalService.deleteBenefitValueMapping(
			benefitValueMapping);
	}

	/**
	 * Deletes the benefit value mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitValueMappingId the primary key of the benefit value mapping
	 * @return the benefit value mapping that was removed
	 * @throws PortalException if a benefit value mapping with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.BenefitValueMapping
			deleteBenefitValueMapping(long benefitValueMappingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitValueMappingLocalService.deleteBenefitValueMapping(
			benefitValueMappingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitValueMappingLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _benefitValueMappingLocalService.dynamicQuery();
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

		return _benefitValueMappingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BenefitValueMappingModelImpl</code>.
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

		return _benefitValueMappingLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BenefitValueMappingModelImpl</code>.
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

		return _benefitValueMappingLocalService.dynamicQuery(
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

		return _benefitValueMappingLocalService.dynamicQueryCount(dynamicQuery);
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

		return _benefitValueMappingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.BenefitValueMapping
		fetchBenefitValueMapping(long benefitValueMappingId) {

		return _benefitValueMappingLocalService.fetchBenefitValueMapping(
			benefitValueMappingId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _benefitValueMappingLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.BenefitValueMapping>
		getActiveBenefitValueMapping() {

		return _benefitValueMappingLocalService.getActiveBenefitValueMapping();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.BenefitValueMapping>
		getAllBenefitValueMappingByBenefitType(long benefitTypeId) {

		return _benefitValueMappingLocalService.
			getAllBenefitValueMappingByBenefitType(benefitTypeId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.BenefitValueMapping>
		getAllBenefitValueMappings() {

		return _benefitValueMappingLocalService.getAllBenefitValueMappings();
	}

	/**
	 * Returns the benefit value mapping with the primary key.
	 *
	 * @param benefitValueMappingId the primary key of the benefit value mapping
	 * @return the benefit value mapping
	 * @throws PortalException if a benefit value mapping with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.BenefitValueMapping
			getBenefitValueMapping(long benefitValueMappingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitValueMappingLocalService.getBenefitValueMapping(
			benefitValueMappingId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.BenefitValueMapping>
		getBenefitValueMappingByBenefitTypeAndBenefit(
			long benefitTypeId, long benefitId) {

		return _benefitValueMappingLocalService.
			getBenefitValueMappingByBenefitTypeAndBenefit(
				benefitTypeId, benefitId);
	}

	@Override
	public com.mypage.admin.product.model.BenefitValueMapping
		getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
			long benefitTypeId, long benefitId, long planId) {

		return _benefitValueMappingLocalService.
			getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
				benefitTypeId, benefitId, planId);
	}

	@Override
	public int getBenefitValueMappingCount() {
		return _benefitValueMappingLocalService.getBenefitValueMappingCount();
	}

	/**
	 * Returns a range of all the benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit value mappings
	 * @param end the upper bound of the range of benefit value mappings (not inclusive)
	 * @return the range of benefit value mappings
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.BenefitValueMapping>
		getBenefitValueMappings(int start, int end) {

		return _benefitValueMappingLocalService.getBenefitValueMappings(
			start, end);
	}

	/**
	 * Returns the number of benefit value mappings.
	 *
	 * @return the number of benefit value mappings
	 */
	@Override
	public int getBenefitValueMappingsCount() {
		return _benefitValueMappingLocalService.getBenefitValueMappingsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _benefitValueMappingLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _benefitValueMappingLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitValueMappingLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public com.mypage.admin.product.model.BenefitValueMapping setActive(
			long benefitValueMappingId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitValueMappingLocalService.setActive(
			benefitValueMappingId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.BenefitValueMapping updateBenefit(
			long benefitValueMappingId, long benefitTypeId, long benefitId,
			long planId, String benefitValue, String benefitValueUSD, int sort,
			int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitValueMappingLocalService.updateBenefit(
			benefitValueMappingId, benefitTypeId, benefitId, planId,
			benefitValue, benefitValueUSD, sort, active);
	}

	/**
	 * Updates the benefit value mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitValueMapping the benefit value mapping
	 * @return the benefit value mapping that was updated
	 */
	@Override
	public com.mypage.admin.product.model.BenefitValueMapping
		updateBenefitValueMapping(
			com.mypage.admin.product.model.BenefitValueMapping
				benefitValueMapping) {

		return _benefitValueMappingLocalService.updateBenefitValueMapping(
			benefitValueMapping);
	}

	@Override
	public BenefitValueMappingLocalService getWrappedService() {
		return _benefitValueMappingLocalService;
	}

	@Override
	public void setWrappedService(
		BenefitValueMappingLocalService benefitValueMappingLocalService) {

		_benefitValueMappingLocalService = benefitValueMappingLocalService;
	}

	private BenefitValueMappingLocalService _benefitValueMappingLocalService;

}