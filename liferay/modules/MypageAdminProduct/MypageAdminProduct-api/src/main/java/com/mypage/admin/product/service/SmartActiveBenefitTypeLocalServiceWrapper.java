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
 * Provides a wrapper for {@link SmartActiveBenefitTypeLocalService}.
 *
 * @author Gositus Team
 * @see SmartActiveBenefitTypeLocalService
 * @generated
 */
public class SmartActiveBenefitTypeLocalServiceWrapper
	implements ServiceWrapper<SmartActiveBenefitTypeLocalService>,
			   SmartActiveBenefitTypeLocalService {

	public SmartActiveBenefitTypeLocalServiceWrapper(
		SmartActiveBenefitTypeLocalService smartActiveBenefitTypeLocalService) {

		_smartActiveBenefitTypeLocalService =
			smartActiveBenefitTypeLocalService;
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitType addBenefitType(
			String nameId, String nameEn, int sort, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitTypeLocalService.addBenefitType(
			nameId, nameEn, sort, active);
	}

	/**
	 * Adds the smart active benefit type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitType the smart active benefit type
	 * @return the smart active benefit type that was added
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitType
		addSmartActiveBenefitType(
			com.mypage.admin.product.model.SmartActiveBenefitType
				smartActiveBenefitType) {

		return _smartActiveBenefitTypeLocalService.addSmartActiveBenefitType(
			smartActiveBenefitType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitTypeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new smart active benefit type with the primary key. Does not add the smart active benefit type to the database.
	 *
	 * @param smartActiveBenefitTypeId the primary key for the new smart active benefit type
	 * @return the new smart active benefit type
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitType
		createSmartActiveBenefitType(long smartActiveBenefitTypeId) {

		return _smartActiveBenefitTypeLocalService.createSmartActiveBenefitType(
			smartActiveBenefitTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitTypeLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the smart active benefit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitTypeId the primary key of the smart active benefit type
	 * @return the smart active benefit type that was removed
	 * @throws PortalException if a smart active benefit type with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitType
			deleteSmartActiveBenefitType(long smartActiveBenefitTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitTypeLocalService.deleteSmartActiveBenefitType(
			smartActiveBenefitTypeId);
	}

	/**
	 * Deletes the smart active benefit type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitType the smart active benefit type
	 * @return the smart active benefit type that was removed
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitType
		deleteSmartActiveBenefitType(
			com.mypage.admin.product.model.SmartActiveBenefitType
				smartActiveBenefitType) {

		return _smartActiveBenefitTypeLocalService.deleteSmartActiveBenefitType(
			smartActiveBenefitType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smartActiveBenefitTypeLocalService.dynamicQuery();
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

		return _smartActiveBenefitTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitTypeModelImpl</code>.
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

		return _smartActiveBenefitTypeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitTypeModelImpl</code>.
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

		return _smartActiveBenefitTypeLocalService.dynamicQuery(
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

		return _smartActiveBenefitTypeLocalService.dynamicQueryCount(
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

		return _smartActiveBenefitTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitType
		fetchSmartActiveBenefitType(long smartActiveBenefitTypeId) {

		return _smartActiveBenefitTypeLocalService.fetchSmartActiveBenefitType(
			smartActiveBenefitTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smartActiveBenefitTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveBenefitType>
		getActiveBenefitType() {

		return _smartActiveBenefitTypeLocalService.getActiveBenefitType();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveBenefitType>
		getAllBenefitTypes() {

		return _smartActiveBenefitTypeLocalService.getAllBenefitTypes();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveBenefitType>
		getBenefitTypeAdditional() {

		return _smartActiveBenefitTypeLocalService.getBenefitTypeAdditional();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveBenefitType>
		getBenefitTypeByName(String nameId, String nameEn) {

		return _smartActiveBenefitTypeLocalService.getBenefitTypeByName(
			nameId, nameEn);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveBenefitType>
		getBenefitTypeBySort(int sort) {

		return _smartActiveBenefitTypeLocalService.getBenefitTypeBySort(sort);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveBenefitType>
		getBenefitTypeMain() {

		return _smartActiveBenefitTypeLocalService.getBenefitTypeMain();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveBenefitType>
		getBenefitTypes() {

		return _smartActiveBenefitTypeLocalService.getBenefitTypes();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveBenefitType>
		getBenefitTypes(int start, int end) {

		return _smartActiveBenefitTypeLocalService.getBenefitTypes(start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smartActiveBenefitTypeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartActiveBenefitTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitTypeLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the smart active benefit type with the primary key.
	 *
	 * @param smartActiveBenefitTypeId the primary key of the smart active benefit type
	 * @return the smart active benefit type
	 * @throws PortalException if a smart active benefit type with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitType
			getSmartActiveBenefitType(long smartActiveBenefitTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitTypeLocalService.getSmartActiveBenefitType(
			smartActiveBenefitTypeId);
	}

	@Override
	public int getSmartActiveBenefitTypeCount() {
		return _smartActiveBenefitTypeLocalService.
			getSmartActiveBenefitTypeCount();
	}

	/**
	 * Returns a range of all the smart active benefit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit types
	 * @param end the upper bound of the range of smart active benefit types (not inclusive)
	 * @return the range of smart active benefit types
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveBenefitType>
		getSmartActiveBenefitTypes(int start, int end) {

		return _smartActiveBenefitTypeLocalService.getSmartActiveBenefitTypes(
			start, end);
	}

	/**
	 * Returns the number of smart active benefit types.
	 *
	 * @return the number of smart active benefit types
	 */
	@Override
	public int getSmartActiveBenefitTypesCount() {
		return _smartActiveBenefitTypeLocalService.
			getSmartActiveBenefitTypesCount();
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitType setActive(
		long benefitTypeId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _smartActiveBenefitTypeLocalService.setActive(
			benefitTypeId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitType
			updateBenefitType(
				long benefitTypeId, String nameId, String nameEn, int sort,
				int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitTypeLocalService.updateBenefitType(
			benefitTypeId, nameId, nameEn, sort, active);
	}

	/**
	 * Updates the smart active benefit type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitType the smart active benefit type
	 * @return the smart active benefit type that was updated
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitType
		updateSmartActiveBenefitType(
			com.mypage.admin.product.model.SmartActiveBenefitType
				smartActiveBenefitType) {

		return _smartActiveBenefitTypeLocalService.updateSmartActiveBenefitType(
			smartActiveBenefitType);
	}

	@Override
	public SmartActiveBenefitTypeLocalService getWrappedService() {
		return _smartActiveBenefitTypeLocalService;
	}

	@Override
	public void setWrappedService(
		SmartActiveBenefitTypeLocalService smartActiveBenefitTypeLocalService) {

		_smartActiveBenefitTypeLocalService =
			smartActiveBenefitTypeLocalService;
	}

	private SmartActiveBenefitTypeLocalService
		_smartActiveBenefitTypeLocalService;

}