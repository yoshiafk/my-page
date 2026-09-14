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
 * Provides a wrapper for {@link BenefitTypeLocalService}.
 *
 * @author Gositus Team
 * @see BenefitTypeLocalService
 * @generated
 */
public class BenefitTypeLocalServiceWrapper
	implements BenefitTypeLocalService,
			   ServiceWrapper<BenefitTypeLocalService> {

	public BenefitTypeLocalServiceWrapper(
		BenefitTypeLocalService benefitTypeLocalService) {

		_benefitTypeLocalService = benefitTypeLocalService;
	}

	/**
	 * Adds the benefit type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitType the benefit type
	 * @return the benefit type that was added
	 */
	@Override
	public com.mypage.admin.product.model.BenefitType addBenefitType(
		com.mypage.admin.product.model.BenefitType benefitType) {

		return _benefitTypeLocalService.addBenefitType(benefitType);
	}

	@Override
	public com.mypage.admin.product.model.BenefitType addBenefitType(
			String nameId, String nameEn, int sort, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitTypeLocalService.addBenefitType(
			nameId, nameEn, sort, active);
	}

	/**
	 * Creates a new benefit type with the primary key. Does not add the benefit type to the database.
	 *
	 * @param benefitTypeId the primary key for the new benefit type
	 * @return the new benefit type
	 */
	@Override
	public com.mypage.admin.product.model.BenefitType createBenefitType(
		long benefitTypeId) {

		return _benefitTypeLocalService.createBenefitType(benefitTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the benefit type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitType the benefit type
	 * @return the benefit type that was removed
	 */
	@Override
	public com.mypage.admin.product.model.BenefitType deleteBenefitType(
		com.mypage.admin.product.model.BenefitType benefitType) {

		return _benefitTypeLocalService.deleteBenefitType(benefitType);
	}

	/**
	 * Deletes the benefit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitTypeId the primary key of the benefit type
	 * @return the benefit type that was removed
	 * @throws PortalException if a benefit type with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.BenefitType deleteBenefitType(
			long benefitTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitTypeLocalService.deleteBenefitType(benefitTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _benefitTypeLocalService.dynamicQuery();
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

		return _benefitTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BenefitTypeModelImpl</code>.
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

		return _benefitTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BenefitTypeModelImpl</code>.
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

		return _benefitTypeLocalService.dynamicQuery(
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

		return _benefitTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _benefitTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.BenefitType fetchBenefitType(
		long benefitTypeId) {

		return _benefitTypeLocalService.fetchBenefitType(benefitTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _benefitTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.BenefitType>
		getActiveBenefitType() {

		return _benefitTypeLocalService.getActiveBenefitType();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.BenefitType>
		getAllBenefitTypes() {

		return _benefitTypeLocalService.getAllBenefitTypes();
	}

	/**
	 * Returns the benefit type with the primary key.
	 *
	 * @param benefitTypeId the primary key of the benefit type
	 * @return the benefit type
	 * @throws PortalException if a benefit type with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.BenefitType getBenefitType(
			long benefitTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitTypeLocalService.getBenefitType(benefitTypeId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.BenefitType>
		getBenefitTypeAdditional() {

		return _benefitTypeLocalService.getBenefitTypeAdditional();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.BenefitType>
		getBenefitTypeByName(String nameId, String nameEn) {

		return _benefitTypeLocalService.getBenefitTypeByName(nameId, nameEn);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.BenefitType>
		getBenefitTypeBySort(int sort) {

		return _benefitTypeLocalService.getBenefitTypeBySort(sort);
	}

	@Override
	public int getBenefitTypeCount() {
		return _benefitTypeLocalService.getBenefitTypeCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.BenefitType>
		getBenefitTypeMain() {

		return _benefitTypeLocalService.getBenefitTypeMain();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.BenefitType>
		getBenefitTypes() {

		return _benefitTypeLocalService.getBenefitTypes();
	}

	/**
	 * Returns a range of all the benefit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BenefitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit types
	 * @param end the upper bound of the range of benefit types (not inclusive)
	 * @return the range of benefit types
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.BenefitType>
		getBenefitTypes(int start, int end) {

		return _benefitTypeLocalService.getBenefitTypes(start, end);
	}

	/**
	 * Returns the number of benefit types.
	 *
	 * @return the number of benefit types
	 */
	@Override
	public int getBenefitTypesCount() {
		return _benefitTypeLocalService.getBenefitTypesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _benefitTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _benefitTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.admin.product.model.BenefitType setActive(
		long benefitTypeId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _benefitTypeLocalService.setActive(
			benefitTypeId, active, serviceContext);
	}

	/**
	 * Updates the benefit type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitType the benefit type
	 * @return the benefit type that was updated
	 */
	@Override
	public com.mypage.admin.product.model.BenefitType updateBenefitType(
		com.mypage.admin.product.model.BenefitType benefitType) {

		return _benefitTypeLocalService.updateBenefitType(benefitType);
	}

	@Override
	public com.mypage.admin.product.model.BenefitType updateBenefitType(
			long benefitTypeId, String nameId, String nameEn, int sort,
			int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitTypeLocalService.updateBenefitType(
			benefitTypeId, nameId, nameEn, sort, active);
	}

	@Override
	public BenefitTypeLocalService getWrappedService() {
		return _benefitTypeLocalService;
	}

	@Override
	public void setWrappedService(
		BenefitTypeLocalService benefitTypeLocalService) {

		_benefitTypeLocalService = benefitTypeLocalService;
	}

	private BenefitTypeLocalService _benefitTypeLocalService;

}