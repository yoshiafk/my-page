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
 * Provides a wrapper for {@link SmartHealthBenefitLocalService}.
 *
 * @author Gositus Team
 * @see SmartHealthBenefitLocalService
 * @generated
 */
public class SmartHealthBenefitLocalServiceWrapper
	implements ServiceWrapper<SmartHealthBenefitLocalService>,
			   SmartHealthBenefitLocalService {

	public SmartHealthBenefitLocalServiceWrapper(
		SmartHealthBenefitLocalService smartHealthBenefitLocalService) {

		_smartHealthBenefitLocalService = smartHealthBenefitLocalService;
	}

	/**
	 * Adds the smart health benefit to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefit the smart health benefit
	 * @return the smart health benefit that was added
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthBenefit
		addSmartHealthBenefit(
			com.mypage.admin.product.model.SmartHealthBenefit
				smartHealthBenefit) {

		return _smartHealthBenefitLocalService.addSmartHealthBenefit(
			smartHealthBenefit);
	}

	/**
	 * Add Benefit
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthBenefit
			addSmartHealthBenefit(
				String benefitTitle, String benefitContent,
				long smartHealthBenefitGroupId, long smartHealthPlanId,
				int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthBenefitLocalService.addSmartHealthBenefit(
			benefitTitle, benefitContent, smartHealthBenefitGroupId,
			smartHealthPlanId, active);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthBenefitLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new smart health benefit with the primary key. Does not add the smart health benefit to the database.
	 *
	 * @param smartHealthBenefitId the primary key for the new smart health benefit
	 * @return the new smart health benefit
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthBenefit
		createSmartHealthBenefit(long smartHealthBenefitId) {

		return _smartHealthBenefitLocalService.createSmartHealthBenefit(
			smartHealthBenefitId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthBenefitLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the smart health benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefitId the primary key of the smart health benefit
	 * @return the smart health benefit that was removed
	 * @throws PortalException if a smart health benefit with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthBenefit
			deleteSmartHealthBenefit(long smartHealthBenefitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthBenefitLocalService.deleteSmartHealthBenefit(
			smartHealthBenefitId);
	}

	/**
	 * Deletes the smart health benefit from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefit the smart health benefit
	 * @return the smart health benefit that was removed
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthBenefit
		deleteSmartHealthBenefit(
			com.mypage.admin.product.model.SmartHealthBenefit
				smartHealthBenefit) {

		return _smartHealthBenefitLocalService.deleteSmartHealthBenefit(
			smartHealthBenefit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smartHealthBenefitLocalService.dynamicQuery();
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

		return _smartHealthBenefitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthBenefitModelImpl</code>.
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

		return _smartHealthBenefitLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthBenefitModelImpl</code>.
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

		return _smartHealthBenefitLocalService.dynamicQuery(
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

		return _smartHealthBenefitLocalService.dynamicQueryCount(dynamicQuery);
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

		return _smartHealthBenefitLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.SmartHealthBenefit
		fetchSmartHealthBenefit(long smartHealthBenefitId) {

		return _smartHealthBenefitLocalService.fetchSmartHealthBenefit(
			smartHealthBenefitId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smartHealthBenefitLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smartHealthBenefitLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartHealthBenefitLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthBenefitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the smart health benefit with the primary key.
	 *
	 * @param smartHealthBenefitId the primary key of the smart health benefit
	 * @return the smart health benefit
	 * @throws PortalException if a smart health benefit with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthBenefit
			getSmartHealthBenefit(long smartHealthBenefitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthBenefitLocalService.getSmartHealthBenefit(
			smartHealthBenefitId);
	}

	@Override
	public int getSmartHealthBenefitCounts() {
		return _smartHealthBenefitLocalService.getSmartHealthBenefitCounts();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartHealthBenefit>
		getSmartHealthBenefits() {

		return _smartHealthBenefitLocalService.getSmartHealthBenefits();
	}

	/**
	 * Returns a range of all the smart health benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefits
	 * @param end the upper bound of the range of smart health benefits (not inclusive)
	 * @return the range of smart health benefits
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.SmartHealthBenefit>
		getSmartHealthBenefits(int start, int end) {

		return _smartHealthBenefitLocalService.getSmartHealthBenefits(
			start, end);
	}

	/**
	 * Returns the number of smart health benefits.
	 *
	 * @return the number of smart health benefits
	 */
	@Override
	public int getSmartHealthBenefitsCount() {
		return _smartHealthBenefitLocalService.getSmartHealthBenefitsCount();
	}

	@Override
	public com.mypage.admin.product.model.SmartHealthBenefit setActive(
			long smartHealthBenefitId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthBenefitLocalService.setActive(
			smartHealthBenefitId, active, serviceContext);
	}

	/**
	 * Update Benefit
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthBenefit
			updateSmartHealthBenefit(
				long smartHealthBenefitId, String benefitTitle,
				String benefitContent, long smartHealthBenefitGroupId,
				long smartHealthPlanId, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthBenefitLocalService.updateSmartHealthBenefit(
			smartHealthBenefitId, benefitTitle, benefitContent,
			smartHealthBenefitGroupId, smartHealthPlanId, active);
	}

	/**
	 * Updates the smart health benefit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefit the smart health benefit
	 * @return the smart health benefit that was updated
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthBenefit
		updateSmartHealthBenefit(
			com.mypage.admin.product.model.SmartHealthBenefit
				smartHealthBenefit) {

		return _smartHealthBenefitLocalService.updateSmartHealthBenefit(
			smartHealthBenefit);
	}

	@Override
	public SmartHealthBenefitLocalService getWrappedService() {
		return _smartHealthBenefitLocalService;
	}

	@Override
	public void setWrappedService(
		SmartHealthBenefitLocalService smartHealthBenefitLocalService) {

		_smartHealthBenefitLocalService = smartHealthBenefitLocalService;
	}

	private SmartHealthBenefitLocalService _smartHealthBenefitLocalService;

}