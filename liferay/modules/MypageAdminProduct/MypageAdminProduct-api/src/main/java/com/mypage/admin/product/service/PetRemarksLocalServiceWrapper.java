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
 * Provides a wrapper for {@link PetRemarksLocalService}.
 *
 * @author Gositus Team
 * @see PetRemarksLocalService
 * @generated
 */
public class PetRemarksLocalServiceWrapper
	implements PetRemarksLocalService, ServiceWrapper<PetRemarksLocalService> {

	public PetRemarksLocalServiceWrapper(
		PetRemarksLocalService petRemarksLocalService) {

		_petRemarksLocalService = petRemarksLocalService;
	}

	/**
	 * Adds the pet remarks to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetRemarksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petRemarks the pet remarks
	 * @return the pet remarks that was added
	 */
	@Override
	public com.mypage.admin.product.model.PetRemarks addPetRemarks(
		com.mypage.admin.product.model.PetRemarks petRemarks) {

		return _petRemarksLocalService.addPetRemarks(petRemarks);
	}

	/**
	 * Add New Pet Remarks
	 *
	 * @param name
	 * @param code
	 * @return
	 * @throws PortalException
	 */
	@Override
	public com.mypage.admin.product.model.PetRemarks addPetRemarks(
			String name, String code, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petRemarksLocalService.addPetRemarks(name, code, active);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petRemarksLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new pet remarks with the primary key. Does not add the pet remarks to the database.
	 *
	 * @param petRemarksId the primary key for the new pet remarks
	 * @return the new pet remarks
	 */
	@Override
	public com.mypage.admin.product.model.PetRemarks createPetRemarks(
		long petRemarksId) {

		return _petRemarksLocalService.createPetRemarks(petRemarksId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petRemarksLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the pet remarks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetRemarksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petRemarksId the primary key of the pet remarks
	 * @return the pet remarks that was removed
	 * @throws PortalException if a pet remarks with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.PetRemarks deletePetRemarks(
			long petRemarksId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petRemarksLocalService.deletePetRemarks(petRemarksId);
	}

	/**
	 * Deletes the pet remarks from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetRemarksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petRemarks the pet remarks
	 * @return the pet remarks that was removed
	 */
	@Override
	public com.mypage.admin.product.model.PetRemarks deletePetRemarks(
		com.mypage.admin.product.model.PetRemarks petRemarks) {

		return _petRemarksLocalService.deletePetRemarks(petRemarks);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _petRemarksLocalService.dynamicQuery();
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

		return _petRemarksLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetRemarksModelImpl</code>.
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

		return _petRemarksLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetRemarksModelImpl</code>.
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

		return _petRemarksLocalService.dynamicQuery(
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

		return _petRemarksLocalService.dynamicQueryCount(dynamicQuery);
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

		return _petRemarksLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.PetRemarks fetchPetRemarks(
		long petRemarksId) {

		return _petRemarksLocalService.fetchPetRemarks(petRemarksId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _petRemarksLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _petRemarksLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _petRemarksLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petRemarksLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.PetRemarks>
		getPetRemarks() {

		return _petRemarksLocalService.getPetRemarks();
	}

	/**
	 * Get Remarks List
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.PetRemarks>
		getPetRemarks(int start, int end) {

		return _petRemarksLocalService.getPetRemarks(start, end);
	}

	/**
	 * Returns the pet remarks with the primary key.
	 *
	 * @param petRemarksId the primary key of the pet remarks
	 * @return the pet remarks
	 * @throws PortalException if a pet remarks with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.PetRemarks getPetRemarks(
			long petRemarksId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petRemarksLocalService.getPetRemarks(petRemarksId);
	}

	/**
	 * Get Remarks Count
	 */
	@Override
	public int getPetRemarksCount() {
		return _petRemarksLocalService.getPetRemarksCount();
	}

	/**
	 * Returns a range of all the pet remarkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @return the range of pet remarkses
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.PetRemarks>
		getPetRemarkses(int start, int end) {

		return _petRemarksLocalService.getPetRemarkses(start, end);
	}

	/**
	 * Returns the number of pet remarkses.
	 *
	 * @return the number of pet remarkses
	 */
	@Override
	public int getPetRemarksesCount() {
		return _petRemarksLocalService.getPetRemarksesCount();
	}

	@Override
	public com.mypage.admin.product.model.PetRemarks setActive(
			long userId, long petRemarksId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petRemarksLocalService.setActive(
			userId, petRemarksId, active, serviceContext);
	}

	/**
	 * Update Pet Remarks
	 *
	 * @param petRemarksId
	 * @param name
	 * @param code
	 * @return
	 * @throws PortalException
	 */
	@Override
	public com.mypage.admin.product.model.PetRemarks updatePetRemarks(
			long petRemarksId, String name, String code, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petRemarksLocalService.updatePetRemarks(
			petRemarksId, name, code, active);
	}

	/**
	 * Updates the pet remarks in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetRemarksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petRemarks the pet remarks
	 * @return the pet remarks that was updated
	 */
	@Override
	public com.mypage.admin.product.model.PetRemarks updatePetRemarks(
		com.mypage.admin.product.model.PetRemarks petRemarks) {

		return _petRemarksLocalService.updatePetRemarks(petRemarks);
	}

	@Override
	public PetRemarksLocalService getWrappedService() {
		return _petRemarksLocalService;
	}

	@Override
	public void setWrappedService(
		PetRemarksLocalService petRemarksLocalService) {

		_petRemarksLocalService = petRemarksLocalService;
	}

	private PetRemarksLocalService _petRemarksLocalService;

}