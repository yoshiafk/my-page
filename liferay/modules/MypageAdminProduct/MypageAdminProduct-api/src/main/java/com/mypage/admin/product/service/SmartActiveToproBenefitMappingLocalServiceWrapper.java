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
 * Provides a wrapper for {@link SmartActiveToproBenefitMappingLocalService}.
 *
 * @author Gositus Team
 * @see SmartActiveToproBenefitMappingLocalService
 * @generated
 */
public class SmartActiveToproBenefitMappingLocalServiceWrapper
	implements ServiceWrapper<SmartActiveToproBenefitMappingLocalService>,
			   SmartActiveToproBenefitMappingLocalService {

	public SmartActiveToproBenefitMappingLocalServiceWrapper(
		SmartActiveToproBenefitMappingLocalService
			smartActiveToproBenefitMappingLocalService) {

		_smartActiveToproBenefitMappingLocalService =
			smartActiveToproBenefitMappingLocalService;
	}

	/**
	 * Adds the smart active topro benefit mapping to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveToproBenefitMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveToproBenefitMapping the smart active topro benefit mapping
	 * @return the smart active topro benefit mapping that was added
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveToproBenefitMapping
		addSmartActiveToproBenefitMapping(
			com.mypage.admin.product.model.SmartActiveToproBenefitMapping
				smartActiveToproBenefitMapping) {

		return _smartActiveToproBenefitMappingLocalService.
			addSmartActiveToproBenefitMapping(smartActiveToproBenefitMapping);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveToproBenefitMapping
			addToproBenefitMapping(
				long toproId, String listBenefitId, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveToproBenefitMappingLocalService.
			addToproBenefitMapping(toproId, listBenefitId, active);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveToproBenefitMappingLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new smart active topro benefit mapping with the primary key. Does not add the smart active topro benefit mapping to the database.
	 *
	 * @param smartActiveToproBenefitMappingId the primary key for the new smart active topro benefit mapping
	 * @return the new smart active topro benefit mapping
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveToproBenefitMapping
		createSmartActiveToproBenefitMapping(
			long smartActiveToproBenefitMappingId) {

		return _smartActiveToproBenefitMappingLocalService.
			createSmartActiveToproBenefitMapping(
				smartActiveToproBenefitMappingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveToproBenefitMappingLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the smart active topro benefit mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveToproBenefitMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveToproBenefitMappingId the primary key of the smart active topro benefit mapping
	 * @return the smart active topro benefit mapping that was removed
	 * @throws PortalException if a smart active topro benefit mapping with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveToproBenefitMapping
			deleteSmartActiveToproBenefitMapping(
				long smartActiveToproBenefitMappingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveToproBenefitMappingLocalService.
			deleteSmartActiveToproBenefitMapping(
				smartActiveToproBenefitMappingId);
	}

	/**
	 * Deletes the smart active topro benefit mapping from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveToproBenefitMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveToproBenefitMapping the smart active topro benefit mapping
	 * @return the smart active topro benefit mapping that was removed
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveToproBenefitMapping
		deleteSmartActiveToproBenefitMapping(
			com.mypage.admin.product.model.SmartActiveToproBenefitMapping
				smartActiveToproBenefitMapping) {

		return _smartActiveToproBenefitMappingLocalService.
			deleteSmartActiveToproBenefitMapping(
				smartActiveToproBenefitMapping);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smartActiveToproBenefitMappingLocalService.dynamicQuery();
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

		return _smartActiveToproBenefitMappingLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveToproBenefitMappingModelImpl</code>.
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

		return _smartActiveToproBenefitMappingLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveToproBenefitMappingModelImpl</code>.
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

		return _smartActiveToproBenefitMappingLocalService.dynamicQuery(
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

		return _smartActiveToproBenefitMappingLocalService.dynamicQueryCount(
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

		return _smartActiveToproBenefitMappingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveToproBenefitMapping
		fetchSmartActiveToproBenefitMapping(
			long smartActiveToproBenefitMappingId) {

		return _smartActiveToproBenefitMappingLocalService.
			fetchSmartActiveToproBenefitMapping(
				smartActiveToproBenefitMappingId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smartActiveToproBenefitMappingLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public java.util.List
		<com.mypage.admin.product.model.SmartActiveToproBenefitMapping>
			getAllToproBenefitMappings() {

		return _smartActiveToproBenefitMappingLocalService.
			getAllToproBenefitMappings();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smartActiveToproBenefitMappingLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartActiveToproBenefitMappingLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveToproBenefitMappingLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the smart active topro benefit mapping with the primary key.
	 *
	 * @param smartActiveToproBenefitMappingId the primary key of the smart active topro benefit mapping
	 * @return the smart active topro benefit mapping
	 * @throws PortalException if a smart active topro benefit mapping with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveToproBenefitMapping
			getSmartActiveToproBenefitMapping(
				long smartActiveToproBenefitMappingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveToproBenefitMappingLocalService.
			getSmartActiveToproBenefitMapping(smartActiveToproBenefitMappingId);
	}

	/**
	 * Returns a range of all the smart active topro benefit mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @return the range of smart active topro benefit mappings
	 */
	@Override
	public java.util.List
		<com.mypage.admin.product.model.SmartActiveToproBenefitMapping>
			getSmartActiveToproBenefitMappings(int start, int end) {

		return _smartActiveToproBenefitMappingLocalService.
			getSmartActiveToproBenefitMappings(start, end);
	}

	/**
	 * Returns the number of smart active topro benefit mappings.
	 *
	 * @return the number of smart active topro benefit mappings
	 */
	@Override
	public int getSmartActiveToproBenefitMappingsCount() {
		return _smartActiveToproBenefitMappingLocalService.
			getSmartActiveToproBenefitMappingsCount();
	}

	@Override
	public java.util.List
		<com.mypage.admin.product.model.SmartActiveToproBenefitMapping>
			getToproBenefitMapping() {

		return _smartActiveToproBenefitMappingLocalService.
			getToproBenefitMapping();
	}

	@Override
	public int getToproBenefitMappingCount() {
		return _smartActiveToproBenefitMappingLocalService.
			getToproBenefitMappingCount();
	}

	@Override
	public java.util.List
		<com.mypage.admin.product.model.SmartActiveToproBenefitMapping>
			getToproBenefitMappings(int start, int end) {

		return _smartActiveToproBenefitMappingLocalService.
			getToproBenefitMappings(start, end);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveToproBenefitMapping
			setActive(
				long toproBenefitMappingId, int active,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveToproBenefitMappingLocalService.setActive(
			toproBenefitMappingId, active, serviceContext);
	}

	/**
	 * Updates the smart active topro benefit mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveToproBenefitMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveToproBenefitMapping the smart active topro benefit mapping
	 * @return the smart active topro benefit mapping that was updated
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveToproBenefitMapping
		updateSmartActiveToproBenefitMapping(
			com.mypage.admin.product.model.SmartActiveToproBenefitMapping
				smartActiveToproBenefitMapping) {

		return _smartActiveToproBenefitMappingLocalService.
			updateSmartActiveToproBenefitMapping(
				smartActiveToproBenefitMapping);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveToproBenefitMapping
			updateToproBenefitMapping(
				long toproBenefitMappingId, long toproId, String listBenefitId,
				int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveToproBenefitMappingLocalService.
			updateToproBenefitMapping(
				toproBenefitMappingId, toproId, listBenefitId, active);
	}

	@Override
	public SmartActiveToproBenefitMappingLocalService getWrappedService() {
		return _smartActiveToproBenefitMappingLocalService;
	}

	@Override
	public void setWrappedService(
		SmartActiveToproBenefitMappingLocalService
			smartActiveToproBenefitMappingLocalService) {

		_smartActiveToproBenefitMappingLocalService =
			smartActiveToproBenefitMappingLocalService;
	}

	private SmartActiveToproBenefitMappingLocalService
		_smartActiveToproBenefitMappingLocalService;

}