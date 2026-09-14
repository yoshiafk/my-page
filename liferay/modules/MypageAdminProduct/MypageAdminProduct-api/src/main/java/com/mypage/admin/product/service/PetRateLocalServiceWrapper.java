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
 * Provides a wrapper for {@link PetRateLocalService}.
 *
 * @author Gositus Team
 * @see PetRateLocalService
 * @generated
 */
public class PetRateLocalServiceWrapper
	implements PetRateLocalService, ServiceWrapper<PetRateLocalService> {

	public PetRateLocalServiceWrapper(PetRateLocalService petRateLocalService) {
		_petRateLocalService = petRateLocalService;
	}

	/**
	 * Add New Pet Rate
	 */
	@Override
	public com.mypage.admin.product.model.PetRate addPetRate(
			long petPlanId, long petRemarksId, String petRate, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petRateLocalService.addPetRate(
			petPlanId, petRemarksId, petRate, active);
	}

	/**
	 * Adds the pet rate to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetRateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petRate the pet rate
	 * @return the pet rate that was added
	 */
	@Override
	public com.mypage.admin.product.model.PetRate addPetRate(
		com.mypage.admin.product.model.PetRate petRate) {

		return _petRateLocalService.addPetRate(petRate);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petRateLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new pet rate with the primary key. Does not add the pet rate to the database.
	 *
	 * @param petRateId the primary key for the new pet rate
	 * @return the new pet rate
	 */
	@Override
	public com.mypage.admin.product.model.PetRate createPetRate(
		long petRateId) {

		return _petRateLocalService.createPetRate(petRateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petRateLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the pet rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetRateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petRateId the primary key of the pet rate
	 * @return the pet rate that was removed
	 * @throws PortalException if a pet rate with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.PetRate deletePetRate(long petRateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petRateLocalService.deletePetRate(petRateId);
	}

	/**
	 * Deletes the pet rate from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetRateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petRate the pet rate
	 * @return the pet rate that was removed
	 */
	@Override
	public com.mypage.admin.product.model.PetRate deletePetRate(
		com.mypage.admin.product.model.PetRate petRate) {

		return _petRateLocalService.deletePetRate(petRate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _petRateLocalService.dynamicQuery();
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

		return _petRateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetRateModelImpl</code>.
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

		return _petRateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetRateModelImpl</code>.
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

		return _petRateLocalService.dynamicQuery(
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

		return _petRateLocalService.dynamicQueryCount(dynamicQuery);
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

		return _petRateLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.PetRate fetchPetRate(long petRateId) {
		return _petRateLocalService.fetchPetRate(petRateId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _petRateLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<Object[]> getAllPetRateCombinedWithPlanAndRemarks() {
		return _petRateLocalService.getAllPetRateCombinedWithPlanAndRemarks();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _petRateLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _petRateLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petRateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the pet rate with the primary key.
	 *
	 * @param petRateId the primary key of the pet rate
	 * @return the pet rate
	 * @throws PortalException if a pet rate with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.PetRate getPetRate(long petRateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petRateLocalService.getPetRate(petRateId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.PetRate>
		getPetRates() {

		return _petRateLocalService.getPetRates();
	}

	/**
	 * Returns a range of all the pet rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @return the range of pet rates
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.PetRate> getPetRates(
		int start, int end) {

		return _petRateLocalService.getPetRates(start, end);
	}

	/**
	 * Returns the number of pet rates.
	 *
	 * @return the number of pet rates
	 */
	@Override
	public int getPetRatesCount() {
		return _petRateLocalService.getPetRatesCount();
	}

	@Override
	public com.mypage.admin.product.model.PetRate getSingleRateCoba(
		long petRateId) {

		return _petRateLocalService.getSingleRateCoba(petRateId);
	}

	@Override
	public com.mypage.admin.product.model.PetRate searchByPetPlanAndPetRemarks(
		long petPlan, long petRemarks) {

		return _petRateLocalService.searchByPetPlanAndPetRemarks(
			petPlan, petRemarks);
	}

	/**
	 * Set status for pet rate
	 */
	@Override
	public com.mypage.admin.product.model.PetRate setActive(
			long userId, long petRateId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petRateLocalService.setActive(
			userId, petRateId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.PetRate updatePetRate(
			long petRateId, long petPlanId, long petRemarksId, String petRate,
			int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petRateLocalService.updatePetRate(
			petRateId, petPlanId, petRemarksId, petRate, active);
	}

	/**
	 * Updates the pet rate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetRateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petRate the pet rate
	 * @return the pet rate that was updated
	 */
	@Override
	public com.mypage.admin.product.model.PetRate updatePetRate(
		com.mypage.admin.product.model.PetRate petRate) {

		return _petRateLocalService.updatePetRate(petRate);
	}

	@Override
	public PetRateLocalService getWrappedService() {
		return _petRateLocalService;
	}

	@Override
	public void setWrappedService(PetRateLocalService petRateLocalService) {
		_petRateLocalService = petRateLocalService;
	}

	private PetRateLocalService _petRateLocalService;

}