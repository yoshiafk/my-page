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
 * Provides a wrapper for {@link PetAnimalTypeLocalService}.
 *
 * @author Gositus Team
 * @see PetAnimalTypeLocalService
 * @generated
 */
public class PetAnimalTypeLocalServiceWrapper
	implements PetAnimalTypeLocalService,
			   ServiceWrapper<PetAnimalTypeLocalService> {

	public PetAnimalTypeLocalServiceWrapper(
		PetAnimalTypeLocalService petAnimalTypeLocalService) {

		_petAnimalTypeLocalService = petAnimalTypeLocalService;
	}

	/**
	 * Adds the pet animal type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetAnimalTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petAnimalType the pet animal type
	 * @return the pet animal type that was added
	 */
	@Override
	public com.mypage.admin.product.model.PetAnimalType addPetAnimalType(
		com.mypage.admin.product.model.PetAnimalType petAnimalType) {

		return _petAnimalTypeLocalService.addPetAnimalType(petAnimalType);
	}

	@Override
	public com.mypage.admin.product.model.PetAnimalType addPetAnimalType(
			String name, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petAnimalTypeLocalService.addPetAnimalType(name, active);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petAnimalTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new pet animal type with the primary key. Does not add the pet animal type to the database.
	 *
	 * @param petAnimalTypeId the primary key for the new pet animal type
	 * @return the new pet animal type
	 */
	@Override
	public com.mypage.admin.product.model.PetAnimalType createPetAnimalType(
		long petAnimalTypeId) {

		return _petAnimalTypeLocalService.createPetAnimalType(petAnimalTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petAnimalTypeLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the pet animal type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetAnimalTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petAnimalTypeId the primary key of the pet animal type
	 * @return the pet animal type that was removed
	 * @throws PortalException if a pet animal type with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.PetAnimalType deletePetAnimalType(
			long petAnimalTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petAnimalTypeLocalService.deletePetAnimalType(petAnimalTypeId);
	}

	/**
	 * Deletes the pet animal type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetAnimalTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petAnimalType the pet animal type
	 * @return the pet animal type that was removed
	 */
	@Override
	public com.mypage.admin.product.model.PetAnimalType deletePetAnimalType(
		com.mypage.admin.product.model.PetAnimalType petAnimalType) {

		return _petAnimalTypeLocalService.deletePetAnimalType(petAnimalType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _petAnimalTypeLocalService.dynamicQuery();
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

		return _petAnimalTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetAnimalTypeModelImpl</code>.
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

		return _petAnimalTypeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetAnimalTypeModelImpl</code>.
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

		return _petAnimalTypeLocalService.dynamicQuery(
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

		return _petAnimalTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _petAnimalTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.PetAnimalType fetchPetAnimalType(
		long petAnimalTypeId) {

		return _petAnimalTypeLocalService.fetchPetAnimalType(petAnimalTypeId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.PetAnimalType>
		findByName(String name) {

		return _petAnimalTypeLocalService.findByName(name);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _petAnimalTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _petAnimalTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _petAnimalTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petAnimalTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the pet animal type with the primary key.
	 *
	 * @param petAnimalTypeId the primary key of the pet animal type
	 * @return the pet animal type
	 * @throws PortalException if a pet animal type with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.PetAnimalType getPetAnimalType(
			long petAnimalTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petAnimalTypeLocalService.getPetAnimalType(petAnimalTypeId);
	}

	/**
	 * Returns a range of all the pet animal types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @return the range of pet animal types
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.PetAnimalType>
		getPetAnimalTypes(int start, int end) {

		return _petAnimalTypeLocalService.getPetAnimalTypes(start, end);
	}

	/**
	 * Returns the number of pet animal types.
	 *
	 * @return the number of pet animal types
	 */
	@Override
	public int getPetAnimalTypesCount() {
		return _petAnimalTypeLocalService.getPetAnimalTypesCount();
	}

	@Override
	public com.mypage.admin.product.model.PetAnimalType searchPetAnimalTypeId(
		long petAnimalTypeId) {

		return _petAnimalTypeLocalService.searchPetAnimalTypeId(
			petAnimalTypeId);
	}

	@Override
	public com.mypage.admin.product.model.PetAnimalType setActive(
			long petAnimalTypeId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petAnimalTypeLocalService.setActive(
			petAnimalTypeId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.PetAnimalType updatePetAnimalType(
			long petAnimalTypeId, String name, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petAnimalTypeLocalService.updatePetAnimalType(
			petAnimalTypeId, name, active);
	}

	/**
	 * Updates the pet animal type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetAnimalTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petAnimalType the pet animal type
	 * @return the pet animal type that was updated
	 */
	@Override
	public com.mypage.admin.product.model.PetAnimalType updatePetAnimalType(
		com.mypage.admin.product.model.PetAnimalType petAnimalType) {

		return _petAnimalTypeLocalService.updatePetAnimalType(petAnimalType);
	}

	@Override
	public PetAnimalTypeLocalService getWrappedService() {
		return _petAnimalTypeLocalService;
	}

	@Override
	public void setWrappedService(
		PetAnimalTypeLocalService petAnimalTypeLocalService) {

		_petAnimalTypeLocalService = petAnimalTypeLocalService;
	}

	private PetAnimalTypeLocalService _petAnimalTypeLocalService;

}