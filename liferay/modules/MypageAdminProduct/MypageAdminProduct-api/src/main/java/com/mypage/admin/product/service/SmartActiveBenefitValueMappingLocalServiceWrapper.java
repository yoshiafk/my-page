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
 * Provides a wrapper for {@link SmartActiveBenefitValueMappingLocalService}.
 *
 * @author Gositus Team
 * @see SmartActiveBenefitValueMappingLocalService
 * @generated
 */
public class SmartActiveBenefitValueMappingLocalServiceWrapper
	implements ServiceWrapper<SmartActiveBenefitValueMappingLocalService>,
			   SmartActiveBenefitValueMappingLocalService {

	public SmartActiveBenefitValueMappingLocalServiceWrapper(
		SmartActiveBenefitValueMappingLocalService
			smartActiveBenefitValueMappingLocalService) {

		_smartActiveBenefitValueMappingLocalService =
			smartActiveBenefitValueMappingLocalService;
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValueMapping
			addBenefitValueMapping(
				long benefitTypeId, long benefitId, long benefitValueId,
				String benefitValue, java.math.BigDecimal limitValue,
				int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitValueMappingLocalService.
			addBenefitValueMapping(
				benefitTypeId, benefitId, benefitValueId, benefitValue,
				limitValue, active);
	}

	/**
	 * Adds the smart active benefit value mapping to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitValueMapping the smart active benefit value mapping
	 * @return the smart active benefit value mapping that was added
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValueMapping
		addSmartActiveBenefitValueMapping(
			com.mypage.admin.product.model.SmartActiveBenefitValueMapping
				smartActiveBenefitValueMapping) {

		return _smartActiveBenefitValueMappingLocalService.
			addSmartActiveBenefitValueMapping(smartActiveBenefitValueMapping);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitValueMappingLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new smart active benefit value mapping with the primary key. Does not add the smart active benefit value mapping to the database.
	 *
	 * @param smartActiveBenefitValueMappingId the primary key for the new smart active benefit value mapping
	 * @return the new smart active benefit value mapping
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValueMapping
		createSmartActiveBenefitValueMapping(
			long smartActiveBenefitValueMappingId) {

		return _smartActiveBenefitValueMappingLocalService.
			createSmartActiveBenefitValueMapping(
				smartActiveBenefitValueMappingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitValueMappingLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the smart active benefit value mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitValueMappingId the primary key of the smart active benefit value mapping
	 * @return the smart active benefit value mapping that was removed
	 * @throws PortalException if a smart active benefit value mapping with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValueMapping
			deleteSmartActiveBenefitValueMapping(
				long smartActiveBenefitValueMappingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitValueMappingLocalService.
			deleteSmartActiveBenefitValueMapping(
				smartActiveBenefitValueMappingId);
	}

	/**
	 * Deletes the smart active benefit value mapping from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitValueMapping the smart active benefit value mapping
	 * @return the smart active benefit value mapping that was removed
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValueMapping
		deleteSmartActiveBenefitValueMapping(
			com.mypage.admin.product.model.SmartActiveBenefitValueMapping
				smartActiveBenefitValueMapping) {

		return _smartActiveBenefitValueMappingLocalService.
			deleteSmartActiveBenefitValueMapping(
				smartActiveBenefitValueMapping);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smartActiveBenefitValueMappingLocalService.dynamicQuery();
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

		return _smartActiveBenefitValueMappingLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitValueMappingModelImpl</code>.
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

		return _smartActiveBenefitValueMappingLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitValueMappingModelImpl</code>.
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

		return _smartActiveBenefitValueMappingLocalService.dynamicQuery(
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

		return _smartActiveBenefitValueMappingLocalService.dynamicQueryCount(
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

		return _smartActiveBenefitValueMappingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValueMapping
		fetchSmartActiveBenefitValueMapping(
			long smartActiveBenefitValueMappingId) {

		return _smartActiveBenefitValueMappingLocalService.
			fetchSmartActiveBenefitValueMapping(
				smartActiveBenefitValueMappingId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smartActiveBenefitValueMappingLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public java.util.List
		<com.mypage.admin.product.model.SmartActiveBenefitValueMapping>
			getAllBenefitValueMappings() {

		return _smartActiveBenefitValueMappingLocalService.
			getAllBenefitValueMappings();
	}

	@Override
	public java.util.List
		<com.mypage.admin.product.model.SmartActiveBenefitValueMapping>
			getAllByBenefitValue(long benefitValueId) {

		return _smartActiveBenefitValueMappingLocalService.getAllByBenefitValue(
			benefitValueId);
	}

	@Override
	public java.util.List
		<com.mypage.admin.product.model.SmartActiveBenefitValueMapping>
			getBenefitValueMapping() {

		return _smartActiveBenefitValueMappingLocalService.
			getBenefitValueMapping();
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValueMapping
		getBenefitValueMappingByBenefitIdAndBenefitValueId(
			long smartActiveBenefitId, long smartActiveBenefitValueId) {

		return _smartActiveBenefitValueMappingLocalService.
			getBenefitValueMappingByBenefitIdAndBenefitValueId(
				smartActiveBenefitId, smartActiveBenefitValueId);
	}

	@Override
	public int getBenefitValueMappingCount() {
		return _smartActiveBenefitValueMappingLocalService.
			getBenefitValueMappingCount();
	}

	@Override
	public java.util.List
		<com.mypage.admin.product.model.SmartActiveBenefitValueMapping>
			getBenefitValueMappings(int start, int end) {

		return _smartActiveBenefitValueMappingLocalService.
			getBenefitValueMappings(start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smartActiveBenefitValueMappingLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartActiveBenefitValueMappingLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitValueMappingLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the smart active benefit value mapping with the primary key.
	 *
	 * @param smartActiveBenefitValueMappingId the primary key of the smart active benefit value mapping
	 * @return the smart active benefit value mapping
	 * @throws PortalException if a smart active benefit value mapping with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValueMapping
			getSmartActiveBenefitValueMapping(
				long smartActiveBenefitValueMappingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitValueMappingLocalService.
			getSmartActiveBenefitValueMapping(smartActiveBenefitValueMappingId);
	}

	/**
	 * Returns a range of all the smart active benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit value mappings
	 * @param end the upper bound of the range of smart active benefit value mappings (not inclusive)
	 * @return the range of smart active benefit value mappings
	 */
	@Override
	public java.util.List
		<com.mypage.admin.product.model.SmartActiveBenefitValueMapping>
			getSmartActiveBenefitValueMappings(int start, int end) {

		return _smartActiveBenefitValueMappingLocalService.
			getSmartActiveBenefitValueMappings(start, end);
	}

	/**
	 * Returns the number of smart active benefit value mappings.
	 *
	 * @return the number of smart active benefit value mappings
	 */
	@Override
	public int getSmartActiveBenefitValueMappingsCount() {
		return _smartActiveBenefitValueMappingLocalService.
			getSmartActiveBenefitValueMappingsCount();
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValueMapping
			setActive(
				long benefitValueMappingId, int active,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitValueMappingLocalService.setActive(
			benefitValueMappingId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValueMapping
			updateBenefitValueMapping(
				long benefitValueMappingId, long benefitTypeId, long benefitId,
				long benefitValueId, String benefitValue,
				java.math.BigDecimal limitValue, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitValueMappingLocalService.
			updateBenefitValueMapping(
				benefitValueMappingId, benefitTypeId, benefitId, benefitValueId,
				benefitValue, limitValue, active);
	}

	/**
	 * Updates the smart active benefit value mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitValueMapping the smart active benefit value mapping
	 * @return the smart active benefit value mapping that was updated
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValueMapping
		updateSmartActiveBenefitValueMapping(
			com.mypage.admin.product.model.SmartActiveBenefitValueMapping
				smartActiveBenefitValueMapping) {

		return _smartActiveBenefitValueMappingLocalService.
			updateSmartActiveBenefitValueMapping(
				smartActiveBenefitValueMapping);
	}

	@Override
	public SmartActiveBenefitValueMappingLocalService getWrappedService() {
		return _smartActiveBenefitValueMappingLocalService;
	}

	@Override
	public void setWrappedService(
		SmartActiveBenefitValueMappingLocalService
			smartActiveBenefitValueMappingLocalService) {

		_smartActiveBenefitValueMappingLocalService =
			smartActiveBenefitValueMappingLocalService;
	}

	private SmartActiveBenefitValueMappingLocalService
		_smartActiveBenefitValueMappingLocalService;

}