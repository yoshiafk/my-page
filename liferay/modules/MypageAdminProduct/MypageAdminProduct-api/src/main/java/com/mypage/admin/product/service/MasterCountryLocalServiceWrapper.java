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
 * Provides a wrapper for {@link MasterCountryLocalService}.
 *
 * @author Gositus Team
 * @see MasterCountryLocalService
 * @generated
 */
public class MasterCountryLocalServiceWrapper
	implements MasterCountryLocalService,
			   ServiceWrapper<MasterCountryLocalService> {

	public MasterCountryLocalServiceWrapper(
		MasterCountryLocalService masterCountryLocalService) {

		_masterCountryLocalService = masterCountryLocalService;
	}

	/**
	 * Adds the master country to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterCountryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterCountry the master country
	 * @return the master country that was added
	 */
	@Override
	public com.mypage.admin.product.model.MasterCountry addMasterCountry(
		com.mypage.admin.product.model.MasterCountry masterCountry) {

		return _masterCountryLocalService.addMasterCountry(masterCountry);
	}

	@Override
	public com.mypage.admin.product.model.MasterCountry addMasterCountry(
			String name, int isPlatinum, int isGold, int isSpecialAsia,
			int isSchengen, int isSanctionCountry, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCountryLocalService.addMasterCountry(
			name, isPlatinum, isGold, isSpecialAsia, isSchengen,
			isSanctionCountry, active);
	}

	/**
	 * Creates a new master country with the primary key. Does not add the master country to the database.
	 *
	 * @param countryId the primary key for the new master country
	 * @return the new master country
	 */
	@Override
	public com.mypage.admin.product.model.MasterCountry createMasterCountry(
		long countryId) {

		return _masterCountryLocalService.createMasterCountry(countryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCountryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the master country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterCountryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param countryId the primary key of the master country
	 * @return the master country that was removed
	 * @throws PortalException if a master country with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterCountry deleteMasterCountry(
			long countryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCountryLocalService.deleteMasterCountry(countryId);
	}

	/**
	 * Deletes the master country from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterCountryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterCountry the master country
	 * @return the master country that was removed
	 */
	@Override
	public com.mypage.admin.product.model.MasterCountry deleteMasterCountry(
		com.mypage.admin.product.model.MasterCountry masterCountry) {

		return _masterCountryLocalService.deleteMasterCountry(masterCountry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCountryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _masterCountryLocalService.dynamicQuery();
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

		return _masterCountryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterCountryModelImpl</code>.
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

		return _masterCountryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterCountryModelImpl</code>.
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

		return _masterCountryLocalService.dynamicQuery(
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

		return _masterCountryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _masterCountryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.MasterCountry fetchMasterCountry(
		long countryId) {

		return _masterCountryLocalService.fetchMasterCountry(countryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _masterCountryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.MasterCountry>
		getActiveCountries() {

		return _masterCountryLocalService.getActiveCountries();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _masterCountryLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.MasterCountry>
		getMasterCountries() {

		return _masterCountryLocalService.getMasterCountries();
	}

	/**
	 * Returns a range of all the master countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @return the range of master countries
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.MasterCountry>
		getMasterCountries(int start, int end) {

		return _masterCountryLocalService.getMasterCountries(start, end);
	}

	/**
	 * Returns the number of master countries.
	 *
	 * @return the number of master countries
	 */
	@Override
	public int getMasterCountriesCount() {
		return _masterCountryLocalService.getMasterCountriesCount();
	}

	/**
	 * Returns the master country with the primary key.
	 *
	 * @param countryId the primary key of the master country
	 * @return the master country
	 * @throws PortalException if a master country with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterCountry getMasterCountry(
			long countryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCountryLocalService.getMasterCountry(countryId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.MasterCountry>
		getMasterCountryByname(String name) {

		return _masterCountryLocalService.getMasterCountryByname(name);
	}

	@Override
	public int getMasterCountryCount() {
		return _masterCountryLocalService.getMasterCountryCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterCountryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCountryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.admin.product.model.MasterCountry setActive(
			long countryId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCountryLocalService.setActive(
			countryId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.MasterCountry updateMasterCountry(
			long countryId, String name, int isPlatinum, int isGold,
			int isSpecialAsia, int isSchengen, int isSanctionCountry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCountryLocalService.updateMasterCountry(
			countryId, name, isPlatinum, isGold, isSpecialAsia, isSchengen,
			isSanctionCountry);
	}

	@Override
	public com.mypage.admin.product.model.MasterCountry updateMasterCountry(
			long countryId, String name, int isPlatinum, int isGold,
			int isSpecialAsia, int isSchengen, int isSanctionCountry,
			int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCountryLocalService.updateMasterCountry(
			countryId, name, isPlatinum, isGold, isSpecialAsia, isSchengen,
			isSanctionCountry, active);
	}

	/**
	 * Updates the master country in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterCountryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterCountry the master country
	 * @return the master country that was updated
	 */
	@Override
	public com.mypage.admin.product.model.MasterCountry updateMasterCountry(
		com.mypage.admin.product.model.MasterCountry masterCountry) {

		return _masterCountryLocalService.updateMasterCountry(masterCountry);
	}

	@Override
	public MasterCountryLocalService getWrappedService() {
		return _masterCountryLocalService;
	}

	@Override
	public void setWrappedService(
		MasterCountryLocalService masterCountryLocalService) {

		_masterCountryLocalService = masterCountryLocalService;
	}

	private MasterCountryLocalService _masterCountryLocalService;

}