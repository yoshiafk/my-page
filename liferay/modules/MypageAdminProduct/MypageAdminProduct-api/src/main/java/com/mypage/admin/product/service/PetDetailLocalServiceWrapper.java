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
 * Provides a wrapper for {@link PetDetailLocalService}.
 *
 * @author Gositus Team
 * @see PetDetailLocalService
 * @generated
 */
public class PetDetailLocalServiceWrapper
	implements PetDetailLocalService, ServiceWrapper<PetDetailLocalService> {

	public PetDetailLocalServiceWrapper(
		PetDetailLocalService petDetailLocalService) {

		_petDetailLocalService = petDetailLocalService;
	}

	/**
	 * Adds the pet detail to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petDetail the pet detail
	 * @return the pet detail that was added
	 */
	@Override
	public com.mypage.admin.product.model.PetDetail addPetDetail(
		com.mypage.admin.product.model.PetDetail petDetail) {

		return _petDetailLocalService.addPetDetail(petDetail);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petDetailLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new pet detail with the primary key. Does not add the pet detail to the database.
	 *
	 * @param petDetailId the primary key for the new pet detail
	 * @return the new pet detail
	 */
	@Override
	public com.mypage.admin.product.model.PetDetail createPetDetail(
		long petDetailId) {

		return _petDetailLocalService.createPetDetail(petDetailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petDetailLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the pet detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petDetailId the primary key of the pet detail
	 * @return the pet detail that was removed
	 * @throws PortalException if a pet detail with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.PetDetail deletePetDetail(
			long petDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petDetailLocalService.deletePetDetail(petDetailId);
	}

	/**
	 * Deletes the pet detail from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petDetail the pet detail
	 * @return the pet detail that was removed
	 */
	@Override
	public com.mypage.admin.product.model.PetDetail deletePetDetail(
		com.mypage.admin.product.model.PetDetail petDetail) {

		return _petDetailLocalService.deletePetDetail(petDetail);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _petDetailLocalService.dynamicQuery();
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

		return _petDetailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetDetailModelImpl</code>.
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

		return _petDetailLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetDetailModelImpl</code>.
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

		return _petDetailLocalService.dynamicQuery(
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

		return _petDetailLocalService.dynamicQueryCount(dynamicQuery);
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

		return _petDetailLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.PetDetail fetchPetDetail(
		long petDetailId) {

		return _petDetailLocalService.fetchPetDetail(petDetailId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _petDetailLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _petDetailLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _petDetailLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petDetailLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the pet detail with the primary key.
	 *
	 * @param petDetailId the primary key of the pet detail
	 * @return the pet detail
	 * @throws PortalException if a pet detail with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.PetDetail getPetDetail(
			long petDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petDetailLocalService.getPetDetail(petDetailId);
	}

	/**
	 * Returns a range of all the pet details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet details
	 * @param end the upper bound of the range of pet details (not inclusive)
	 * @return the range of pet details
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.PetDetail>
		getPetDetails(int start, int end) {

		return _petDetailLocalService.getPetDetails(start, end);
	}

	/**
	 * Returns the number of pet details.
	 *
	 * @return the number of pet details
	 */
	@Override
	public int getPetDetailsCount() {
		return _petDetailLocalService.getPetDetailsCount();
	}

	/**
	 * Updates the pet detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petDetail the pet detail
	 * @return the pet detail that was updated
	 */
	@Override
	public com.mypage.admin.product.model.PetDetail updatePetDetail(
		com.mypage.admin.product.model.PetDetail petDetail) {

		return _petDetailLocalService.updatePetDetail(petDetail);
	}

	@Override
	public PetDetailLocalService getWrappedService() {
		return _petDetailLocalService;
	}

	@Override
	public void setWrappedService(PetDetailLocalService petDetailLocalService) {
		_petDetailLocalService = petDetailLocalService;
	}

	private PetDetailLocalService _petDetailLocalService;

}