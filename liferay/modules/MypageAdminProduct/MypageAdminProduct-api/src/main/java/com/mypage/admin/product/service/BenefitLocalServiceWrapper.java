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
 * Provides a wrapper for {@link BenefitLocalService}.
 *
 * @author Gositus Team
 * @see BenefitLocalService
 * @generated
 */
public class BenefitLocalServiceWrapper
	implements BenefitLocalService, ServiceWrapper<BenefitLocalService> {

	public BenefitLocalServiceWrapper(BenefitLocalService benefitLocalService) {
		_benefitLocalService = benefitLocalService;
	}

	/**
	 * Adds the benefit to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefit the benefit
	 * @return the benefit that was added
	 */
	@Override
	public com.mypage.admin.product.model.Benefit addBenefit(
		com.mypage.admin.product.model.Benefit benefit) {

		return _benefitLocalService.addBenefit(benefit);
	}

	@Override
	public com.mypage.admin.product.model.Benefit addBenefit(
			String nameId, String nameEn, int sort, int active,
			long benefitTypeId, String planName, String benefitValue,
			String externalCode, String benefitDescription)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitLocalService.addBenefit(
			nameId, nameEn, sort, active, benefitTypeId, planName, benefitValue,
			externalCode, benefitDescription);
	}

	/**
	 * Creates a new benefit with the primary key. Does not add the benefit to the database.
	 *
	 * @param benefitId the primary key for the new benefit
	 * @return the new benefit
	 */
	@Override
	public com.mypage.admin.product.model.Benefit createBenefit(
		long benefitId) {

		return _benefitLocalService.createBenefit(benefitId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the benefit from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefit the benefit
	 * @return the benefit that was removed
	 */
	@Override
	public com.mypage.admin.product.model.Benefit deleteBenefit(
		com.mypage.admin.product.model.Benefit benefit) {

		return _benefitLocalService.deleteBenefit(benefit);
	}

	/**
	 * Deletes the benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitId the primary key of the benefit
	 * @return the benefit that was removed
	 * @throws PortalException if a benefit with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.Benefit deleteBenefit(long benefitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitLocalService.deleteBenefit(benefitId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _benefitLocalService.dynamicQuery();
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

		return _benefitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BenefitModelImpl</code>.
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

		return _benefitLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BenefitModelImpl</code>.
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

		return _benefitLocalService.dynamicQuery(
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

		return _benefitLocalService.dynamicQueryCount(dynamicQuery);
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

		return _benefitLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.Benefit fetchBenefit(long benefitId) {
		return _benefitLocalService.fetchBenefit(benefitId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _benefitLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.Benefit>
		getActiveBenefit() {

		return _benefitLocalService.getActiveBenefit();
	}

	/**
	 * Returns the benefit with the primary key.
	 *
	 * @param benefitId the primary key of the benefit
	 * @return the benefit
	 * @throws PortalException if a benefit with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.Benefit getBenefit(long benefitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitLocalService.getBenefit(benefitId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.Benefit>
		getBenefitByPlan(String plan, long typeId) {

		return _benefitLocalService.getBenefitByPlan(plan, typeId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.Benefit>
		getBenefitByTypeId(long typeId) {

		return _benefitLocalService.getBenefitByTypeId(typeId);
	}

	@Override
	public int getBenefitCount() {
		return _benefitLocalService.getBenefitCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.Benefit>
		getBenefits() {

		return _benefitLocalService.getBenefits();
	}

	/**
	 * Returns a range of all the benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefits
	 * @param end the upper bound of the range of benefits (not inclusive)
	 * @return the range of benefits
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.Benefit> getBenefits(
		int start, int end) {

		return _benefitLocalService.getBenefits(start, end);
	}

	/**
	 * Returns the number of benefits.
	 *
	 * @return the number of benefits
	 */
	@Override
	public int getBenefitsCount() {
		return _benefitLocalService.getBenefitsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _benefitLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _benefitLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.admin.product.model.Benefit setActive(
			long benefitId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitLocalService.setActive(
			benefitId, active, serviceContext);
	}

	/**
	 * Updates the benefit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefit the benefit
	 * @return the benefit that was updated
	 */
	@Override
	public com.mypage.admin.product.model.Benefit updateBenefit(
		com.mypage.admin.product.model.Benefit benefit) {

		return _benefitLocalService.updateBenefit(benefit);
	}

	@Override
	public com.mypage.admin.product.model.Benefit updateBenefit(
			long benefitId, long benefitTypeId, String nameId, String nameEn,
			int sort, int active, String planName, String benefitValue,
			String externalCode, String benefitDescription)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _benefitLocalService.updateBenefit(
			benefitId, benefitTypeId, nameId, nameEn, sort, active, planName,
			benefitValue, externalCode, benefitDescription);
	}

	@Override
	public BenefitLocalService getWrappedService() {
		return _benefitLocalService;
	}

	@Override
	public void setWrappedService(BenefitLocalService benefitLocalService) {
		_benefitLocalService = benefitLocalService;
	}

	private BenefitLocalService _benefitLocalService;

}