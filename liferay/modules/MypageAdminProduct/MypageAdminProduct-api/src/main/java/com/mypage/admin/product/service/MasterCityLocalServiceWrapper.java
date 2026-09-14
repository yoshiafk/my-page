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
 * Provides a wrapper for {@link MasterCityLocalService}.
 *
 * @author Gositus Team
 * @see MasterCityLocalService
 * @generated
 */
public class MasterCityLocalServiceWrapper
	implements MasterCityLocalService, ServiceWrapper<MasterCityLocalService> {

	public MasterCityLocalServiceWrapper(
		MasterCityLocalService masterCityLocalService) {

		_masterCityLocalService = masterCityLocalService;
	}

	/**
	 * Adds the master city to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterCityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterCity the master city
	 * @return the master city that was added
	 */
	@Override
	public com.mypage.admin.product.model.MasterCity addMasterCity(
		com.mypage.admin.product.model.MasterCity masterCity) {

		return _masterCityLocalService.addMasterCity(masterCity);
	}

	@Override
	public com.mypage.admin.product.model.MasterCity addMasterCity(
			String name, long provinceId, String status, int parEarthquakeZone,
			int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCityLocalService.addMasterCity(
			name, provinceId, status, parEarthquakeZone, active);
	}

	/**
	 * Creates a new master city with the primary key. Does not add the master city to the database.
	 *
	 * @param masterCityId the primary key for the new master city
	 * @return the new master city
	 */
	@Override
	public com.mypage.admin.product.model.MasterCity createMasterCity(
		long masterCityId) {

		return _masterCityLocalService.createMasterCity(masterCityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCityLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the master city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterCityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterCityId the primary key of the master city
	 * @return the master city that was removed
	 * @throws PortalException if a master city with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterCity deleteMasterCity(
			long masterCityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCityLocalService.deleteMasterCity(masterCityId);
	}

	/**
	 * Deletes the master city from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterCityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterCity the master city
	 * @return the master city that was removed
	 */
	@Override
	public com.mypage.admin.product.model.MasterCity deleteMasterCity(
		com.mypage.admin.product.model.MasterCity masterCity) {

		return _masterCityLocalService.deleteMasterCity(masterCity);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCityLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _masterCityLocalService.dynamicQuery();
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

		return _masterCityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterCityModelImpl</code>.
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

		return _masterCityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterCityModelImpl</code>.
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

		return _masterCityLocalService.dynamicQuery(
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

		return _masterCityLocalService.dynamicQueryCount(dynamicQuery);
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

		return _masterCityLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.MasterCity fetchMasterCity(
		long masterCityId) {

		return _masterCityLocalService.fetchMasterCity(masterCityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _masterCityLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.MasterCity>
		getActiveCities() {

		return _masterCityLocalService.getActiveCities();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.MasterCity>
		getCityProvinceMap() {

		return _masterCityLocalService.getCityProvinceMap();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _masterCityLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getJsonCities() {
		return _masterCityLocalService.getJsonCities();
	}

	/**
	 * Returns a range of all the master cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @return the range of master cities
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.MasterCity>
		getMasterCities(int start, int end) {

		return _masterCityLocalService.getMasterCities(start, end);
	}

	/**
	 * Returns the number of master cities.
	 *
	 * @return the number of master cities
	 */
	@Override
	public int getMasterCitiesCount() {
		return _masterCityLocalService.getMasterCitiesCount();
	}

	/**
	 * Returns the master city with the primary key.
	 *
	 * @param masterCityId the primary key of the master city
	 * @return the master city
	 * @throws PortalException if a master city with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterCity getMasterCity(
			long masterCityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCityLocalService.getMasterCity(masterCityId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterCityLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCityLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.MasterCity>
		searchByProvinceId(long provinceId) {

		return _masterCityLocalService.searchByProvinceId(provinceId);
	}

	@Override
	public com.mypage.admin.product.model.MasterCity setActive(
			long masterCityId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCityLocalService.setActive(
			masterCityId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.MasterCity updateMasterCity(
			long masterCityId, String name, long provinceId, String status,
			int parEarthquakeZone, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCityLocalService.updateMasterCity(
			masterCityId, name, provinceId, status, parEarthquakeZone, active);
	}

	/**
	 * Updates the master city in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterCityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterCity the master city
	 * @return the master city that was updated
	 */
	@Override
	public com.mypage.admin.product.model.MasterCity updateMasterCity(
		com.mypage.admin.product.model.MasterCity masterCity) {

		return _masterCityLocalService.updateMasterCity(masterCity);
	}

	@Override
	public MasterCityLocalService getWrappedService() {
		return _masterCityLocalService;
	}

	@Override
	public void setWrappedService(
		MasterCityLocalService masterCityLocalService) {

		_masterCityLocalService = masterCityLocalService;
	}

	private MasterCityLocalService _masterCityLocalService;

}