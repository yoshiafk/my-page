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
 * Provides a wrapper for {@link SmartActiveBenefitLocalService}.
 *
 * @author Gositus Team
 * @see SmartActiveBenefitLocalService
 * @generated
 */
public class SmartActiveBenefitLocalServiceWrapper
	implements ServiceWrapper<SmartActiveBenefitLocalService>,
			   SmartActiveBenefitLocalService {

	public SmartActiveBenefitLocalServiceWrapper(
		SmartActiveBenefitLocalService smartActiveBenefitLocalService) {

		_smartActiveBenefitLocalService = smartActiveBenefitLocalService;
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefit addBenefit(
			String nameId, String nameEn, int sort, int active,
			long benefitTypeId, String benefitLimit, String externalCode,
			String benefitDescription)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitLocalService.addBenefit(
			nameId, nameEn, sort, active, benefitTypeId, benefitLimit,
			externalCode, benefitDescription);
	}

	/**
	 * Adds the smart active benefit to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefit the smart active benefit
	 * @return the smart active benefit that was added
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefit
		addSmartActiveBenefit(
			com.mypage.admin.product.model.SmartActiveBenefit
				smartActiveBenefit) {

		return _smartActiveBenefitLocalService.addSmartActiveBenefit(
			smartActiveBenefit);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new smart active benefit with the primary key. Does not add the smart active benefit to the database.
	 *
	 * @param smartActiveBenefitId the primary key for the new smart active benefit
	 * @return the new smart active benefit
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefit
		createSmartActiveBenefit(long smartActiveBenefitId) {

		return _smartActiveBenefitLocalService.createSmartActiveBenefit(
			smartActiveBenefitId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the smart active benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitId the primary key of the smart active benefit
	 * @return the smart active benefit that was removed
	 * @throws PortalException if a smart active benefit with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefit
			deleteSmartActiveBenefit(long smartActiveBenefitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitLocalService.deleteSmartActiveBenefit(
			smartActiveBenefitId);
	}

	/**
	 * Deletes the smart active benefit from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefit the smart active benefit
	 * @return the smart active benefit that was removed
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefit
		deleteSmartActiveBenefit(
			com.mypage.admin.product.model.SmartActiveBenefit
				smartActiveBenefit) {

		return _smartActiveBenefitLocalService.deleteSmartActiveBenefit(
			smartActiveBenefit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smartActiveBenefitLocalService.dynamicQuery();
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

		return _smartActiveBenefitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitModelImpl</code>.
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

		return _smartActiveBenefitLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitModelImpl</code>.
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

		return _smartActiveBenefitLocalService.dynamicQuery(
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

		return _smartActiveBenefitLocalService.dynamicQueryCount(dynamicQuery);
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

		return _smartActiveBenefitLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefit
		fetchSmartActiveBenefit(long smartActiveBenefitId) {

		return _smartActiveBenefitLocalService.fetchSmartActiveBenefit(
			smartActiveBenefitId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smartActiveBenefitLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveBenefit>
		getActiveBenefit() {

		return _smartActiveBenefitLocalService.getActiveBenefit();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveBenefit>
		getBenefitByTypeId(long typeId) {

		return _smartActiveBenefitLocalService.getBenefitByTypeId(typeId);
	}

	@Override
	public int getBenefitCount() {
		return _smartActiveBenefitLocalService.getBenefitCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveBenefit>
		getBenefits() {

		return _smartActiveBenefitLocalService.getBenefits();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveBenefit>
		getBenefits(int start, int end) {

		return _smartActiveBenefitLocalService.getBenefits(start, end);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefit getByExternalCode(
		String externalCode) {

		return _smartActiveBenefitLocalService.getByExternalCode(externalCode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smartActiveBenefitLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartActiveBenefitLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the smart active benefit with the primary key.
	 *
	 * @param smartActiveBenefitId the primary key of the smart active benefit
	 * @return the smart active benefit
	 * @throws PortalException if a smart active benefit with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefit
			getSmartActiveBenefit(long smartActiveBenefitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitLocalService.getSmartActiveBenefit(
			smartActiveBenefitId);
	}

	/**
	 * Returns a range of all the smart active benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @return the range of smart active benefits
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveBenefit>
		getSmartActiveBenefits(int start, int end) {

		return _smartActiveBenefitLocalService.getSmartActiveBenefits(
			start, end);
	}

	/**
	 * Returns the number of smart active benefits.
	 *
	 * @return the number of smart active benefits
	 */
	@Override
	public int getSmartActiveBenefitsCount() {
		return _smartActiveBenefitLocalService.getSmartActiveBenefitsCount();
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefit setActive(
			long benefitId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitLocalService.setActive(
			benefitId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefit updateBenefit(
			long benefitId, long benefitTypeId, String nameId, String nameEn,
			int sort, int active, String benefitLimit, String externalCode,
			String benefitDescription)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitLocalService.updateBenefit(
			benefitId, benefitTypeId, nameId, nameEn, sort, active,
			benefitLimit, externalCode, benefitDescription);
	}

	/**
	 * Updates the smart active benefit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefit the smart active benefit
	 * @return the smart active benefit that was updated
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefit
		updateSmartActiveBenefit(
			com.mypage.admin.product.model.SmartActiveBenefit
				smartActiveBenefit) {

		return _smartActiveBenefitLocalService.updateSmartActiveBenefit(
			smartActiveBenefit);
	}

	@Override
	public SmartActiveBenefitLocalService getWrappedService() {
		return _smartActiveBenefitLocalService;
	}

	@Override
	public void setWrappedService(
		SmartActiveBenefitLocalService smartActiveBenefitLocalService) {

		_smartActiveBenefitLocalService = smartActiveBenefitLocalService;
	}

	private SmartActiveBenefitLocalService _smartActiveBenefitLocalService;

}