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
 * Provides a wrapper for {@link StiBenefitLocalService}.
 *
 * @author Gositus Team
 * @see StiBenefitLocalService
 * @generated
 */
public class StiBenefitLocalServiceWrapper
	implements ServiceWrapper<StiBenefitLocalService>, StiBenefitLocalService {

	public StiBenefitLocalServiceWrapper(
		StiBenefitLocalService stiBenefitLocalService) {

		_stiBenefitLocalService = stiBenefitLocalService;
	}

	/**
	 * Adds the sti benefit to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stiBenefit the sti benefit
	 * @return the sti benefit that was added
	 */
	@Override
	public com.mypage.admin.product.model.StiBenefit addStiBenefit(
		com.mypage.admin.product.model.StiBenefit stiBenefit) {

		return _stiBenefitLocalService.addStiBenefit(stiBenefit);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stiBenefitLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sti benefit with the primary key. Does not add the sti benefit to the database.
	 *
	 * @param benefitId the primary key for the new sti benefit
	 * @return the new sti benefit
	 */
	@Override
	public com.mypage.admin.product.model.StiBenefit createStiBenefit(
		long benefitId) {

		return _stiBenefitLocalService.createStiBenefit(benefitId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stiBenefitLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sti benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitId the primary key of the sti benefit
	 * @return the sti benefit that was removed
	 * @throws PortalException if a sti benefit with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.StiBenefit deleteStiBenefit(
			long benefitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stiBenefitLocalService.deleteStiBenefit(benefitId);
	}

	/**
	 * Deletes the sti benefit from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stiBenefit the sti benefit
	 * @return the sti benefit that was removed
	 */
	@Override
	public com.mypage.admin.product.model.StiBenefit deleteStiBenefit(
		com.mypage.admin.product.model.StiBenefit stiBenefit) {

		return _stiBenefitLocalService.deleteStiBenefit(stiBenefit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stiBenefitLocalService.dynamicQuery();
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

		return _stiBenefitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.StiBenefitModelImpl</code>.
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

		return _stiBenefitLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.StiBenefitModelImpl</code>.
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

		return _stiBenefitLocalService.dynamicQuery(
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

		return _stiBenefitLocalService.dynamicQueryCount(dynamicQuery);
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

		return _stiBenefitLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.StiBenefit fetchStiBenefit(
		long benefitId) {

		return _stiBenefitLocalService.fetchStiBenefit(benefitId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stiBenefitLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.StiBenefit>
		getActiveBenefit() {

		return _stiBenefitLocalService.getActiveBenefit();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.StiBenefit>
		getBenefitByPlan(String plan, long typeId) {

		return _stiBenefitLocalService.getBenefitByPlan(plan, typeId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.StiBenefit>
		getBenefitByTypeId(long typeId) {

		return _stiBenefitLocalService.getBenefitByTypeId(typeId);
	}

	@Override
	public int getBenefitCount() {
		return _stiBenefitLocalService.getBenefitCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.StiBenefit>
		getBenefits() {

		return _stiBenefitLocalService.getBenefits();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.StiBenefit>
		getBenefits(int start, int end) {

		return _stiBenefitLocalService.getBenefits(start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stiBenefitLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stiBenefitLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stiBenefitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sti benefit with the primary key.
	 *
	 * @param benefitId the primary key of the sti benefit
	 * @return the sti benefit
	 * @throws PortalException if a sti benefit with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.StiBenefit getStiBenefit(
			long benefitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stiBenefitLocalService.getStiBenefit(benefitId);
	}

	/**
	 * Returns a range of all the sti benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.StiBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti benefits
	 * @param end the upper bound of the range of sti benefits (not inclusive)
	 * @return the range of sti benefits
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.StiBenefit>
		getStiBenefits(int start, int end) {

		return _stiBenefitLocalService.getStiBenefits(start, end);
	}

	/**
	 * Returns the number of sti benefits.
	 *
	 * @return the number of sti benefits
	 */
	@Override
	public int getStiBenefitsCount() {
		return _stiBenefitLocalService.getStiBenefitsCount();
	}

	@Override
	public com.mypage.admin.product.model.StiBenefit setActive(
			long benefitId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stiBenefitLocalService.setActive(
			benefitId, active, serviceContext);
	}

	/**
	 * Updates the sti benefit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stiBenefit the sti benefit
	 * @return the sti benefit that was updated
	 */
	@Override
	public com.mypage.admin.product.model.StiBenefit updateStiBenefit(
		com.mypage.admin.product.model.StiBenefit stiBenefit) {

		return _stiBenefitLocalService.updateStiBenefit(stiBenefit);
	}

	@Override
	public StiBenefitLocalService getWrappedService() {
		return _stiBenefitLocalService;
	}

	@Override
	public void setWrappedService(
		StiBenefitLocalService stiBenefitLocalService) {

		_stiBenefitLocalService = stiBenefitLocalService;
	}

	private StiBenefitLocalService _stiBenefitLocalService;

}