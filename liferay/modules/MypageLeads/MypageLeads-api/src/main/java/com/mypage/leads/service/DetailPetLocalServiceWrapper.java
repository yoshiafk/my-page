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

package com.mypage.leads.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DetailPetLocalService}.
 *
 * @author Gositus
 * @see DetailPetLocalService
 * @generated
 */
public class DetailPetLocalServiceWrapper
	implements DetailPetLocalService, ServiceWrapper<DetailPetLocalService> {

	public DetailPetLocalServiceWrapper(
		DetailPetLocalService detailPetLocalService) {

		_detailPetLocalService = detailPetLocalService;
	}

	@Override
	public com.mypage.leads.model.DetailPet addDetail(
		long userId, long detailId,
		com.liferay.portal.kernel.json.JSONObject data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _detailPetLocalService.addDetail(
			userId, detailId, data, serviceContext);
	}

	/**
	 * Adds the detail pet to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailPetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailPet the detail pet
	 * @return the detail pet that was added
	 */
	@Override
	public com.mypage.leads.model.DetailPet addDetailPet(
		com.mypage.leads.model.DetailPet detailPet) {

		return _detailPetLocalService.addDetailPet(detailPet);
	}

	/**
	 * Creates a new detail pet with the primary key. Does not add the detail pet to the database.
	 *
	 * @param detailPetId the primary key for the new detail pet
	 * @return the new detail pet
	 */
	@Override
	public com.mypage.leads.model.DetailPet createDetailPet(long detailPetId) {
		return _detailPetLocalService.createDetailPet(detailPetId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailPetLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the detail pet from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailPetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailPet the detail pet
	 * @return the detail pet that was removed
	 */
	@Override
	public com.mypage.leads.model.DetailPet deleteDetailPet(
		com.mypage.leads.model.DetailPet detailPet) {

		return _detailPetLocalService.deleteDetailPet(detailPet);
	}

	/**
	 * Deletes the detail pet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailPetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailPetId the primary key of the detail pet
	 * @return the detail pet that was removed
	 * @throws PortalException if a detail pet with the primary key could not be found
	 */
	@Override
	public com.mypage.leads.model.DetailPet deleteDetailPet(long detailPetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailPetLocalService.deleteDetailPet(detailPetId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailPetLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _detailPetLocalService.dynamicQuery();
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

		return _detailPetLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailPetModelImpl</code>.
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

		return _detailPetLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailPetModelImpl</code>.
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

		return _detailPetLocalService.dynamicQuery(
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

		return _detailPetLocalService.dynamicQueryCount(dynamicQuery);
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

		return _detailPetLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.leads.model.DetailPet fetchDetailPet(long detailPetId) {
		return _detailPetLocalService.fetchDetailPet(detailPetId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _detailPetLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the detail pet with the primary key.
	 *
	 * @param detailPetId the primary key of the detail pet
	 * @return the detail pet
	 * @throws PortalException if a detail pet with the primary key could not be found
	 */
	@Override
	public com.mypage.leads.model.DetailPet getDetailPet(long detailPetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailPetLocalService.getDetailPet(detailPetId);
	}

	/**
	 * Returns a range of all the detail pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailPetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail pets
	 * @param end the upper bound of the range of detail pets (not inclusive)
	 * @return the range of detail pets
	 */
	@Override
	public java.util.List<com.mypage.leads.model.DetailPet> getDetailPets(
		int start, int end) {

		return _detailPetLocalService.getDetailPets(start, end);
	}

	/**
	 * Returns the number of detail pets.
	 *
	 * @return the number of detail pets
	 */
	@Override
	public int getDetailPetsCount() {
		return _detailPetLocalService.getDetailPetsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _detailPetLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _detailPetLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailPetLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.leads.model.DetailPet searchByLeadsId(long LeadsId) {
		return _detailPetLocalService.searchByLeadsId(LeadsId);
	}

	@Override
	public com.mypage.leads.model.DetailPet setPetCertificatePhoto(
			long leadsId, long petCerfiticatePhotoFileEntryId)
		throws Exception {

		return _detailPetLocalService.setPetCertificatePhoto(
			leadsId, petCerfiticatePhotoFileEntryId);
	}

	@Override
	public com.mypage.leads.model.DetailPet setPetPhoto(
			long leadsId, long petPhotoFileEntryId)
		throws Exception {

		return _detailPetLocalService.setPetPhoto(leadsId, petPhotoFileEntryId);
	}

	/**
	 * Updates the detail pet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailPetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailPet the detail pet
	 * @return the detail pet that was updated
	 */
	@Override
	public com.mypage.leads.model.DetailPet updateDetailPet(
		com.mypage.leads.model.DetailPet detailPet) {

		return _detailPetLocalService.updateDetailPet(detailPet);
	}

	@Override
	public DetailPetLocalService getWrappedService() {
		return _detailPetLocalService;
	}

	@Override
	public void setWrappedService(DetailPetLocalService detailPetLocalService) {
		_detailPetLocalService = detailPetLocalService;
	}

	private DetailPetLocalService _detailPetLocalService;

}