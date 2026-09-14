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
 * Provides a wrapper for {@link MasterProvinceLocalService}.
 *
 * @author Gositus Team
 * @see MasterProvinceLocalService
 * @generated
 */
public class MasterProvinceLocalServiceWrapper
	implements MasterProvinceLocalService,
			   ServiceWrapper<MasterProvinceLocalService> {

	public MasterProvinceLocalServiceWrapper(
		MasterProvinceLocalService masterProvinceLocalService) {

		_masterProvinceLocalService = masterProvinceLocalService;
	}

	/**
	 * Adds the master province to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterProvinceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterProvince the master province
	 * @return the master province that was added
	 */
	@Override
	public com.mypage.admin.product.model.MasterProvince addMasterProvince(
		com.mypage.admin.product.model.MasterProvince masterProvince) {

		return _masterProvinceLocalService.addMasterProvince(masterProvince);
	}

	@Override
	public com.mypage.admin.product.model.MasterProvince addMasterProvince(
			String name, int countryId, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterProvinceLocalService.addMasterProvince(
			name, countryId, active);
	}

	/**
	 * Creates a new master province with the primary key. Does not add the master province to the database.
	 *
	 * @param masterProvinceId the primary key for the new master province
	 * @return the new master province
	 */
	@Override
	public com.mypage.admin.product.model.MasterProvince createMasterProvince(
		long masterProvinceId) {

		return _masterProvinceLocalService.createMasterProvince(
			masterProvinceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterProvinceLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the master province with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterProvinceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterProvinceId the primary key of the master province
	 * @return the master province that was removed
	 * @throws PortalException if a master province with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterProvince deleteMasterProvince(
			long masterProvinceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterProvinceLocalService.deleteMasterProvince(
			masterProvinceId);
	}

	/**
	 * Deletes the master province from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterProvinceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterProvince the master province
	 * @return the master province that was removed
	 */
	@Override
	public com.mypage.admin.product.model.MasterProvince deleteMasterProvince(
		com.mypage.admin.product.model.MasterProvince masterProvince) {

		return _masterProvinceLocalService.deleteMasterProvince(masterProvince);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterProvinceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _masterProvinceLocalService.dynamicQuery();
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

		return _masterProvinceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterProvinceModelImpl</code>.
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

		return _masterProvinceLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterProvinceModelImpl</code>.
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

		return _masterProvinceLocalService.dynamicQuery(
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

		return _masterProvinceLocalService.dynamicQueryCount(dynamicQuery);
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

		return _masterProvinceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.MasterProvince fetchMasterProvince(
		long masterProvinceId) {

		return _masterProvinceLocalService.fetchMasterProvince(
			masterProvinceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _masterProvinceLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.MasterProvince>
		getActiveProvinces() {

		return _masterProvinceLocalService.getActiveProvinces();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _masterProvinceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the master province with the primary key.
	 *
	 * @param masterProvinceId the primary key of the master province
	 * @return the master province
	 * @throws PortalException if a master province with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterProvince getMasterProvince(
			long masterProvinceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterProvinceLocalService.getMasterProvince(masterProvinceId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.MasterProvince>
		getMasterProvinceByname(String name) {

		return _masterProvinceLocalService.getMasterProvinceByname(name);
	}

	/**
	 * Returns a range of all the master provinces.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @return the range of master provinces
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.MasterProvince>
		getMasterProvinces(int start, int end) {

		return _masterProvinceLocalService.getMasterProvinces(start, end);
	}

	/**
	 * Returns the number of master provinces.
	 *
	 * @return the number of master provinces
	 */
	@Override
	public int getMasterProvincesCount() {
		return _masterProvinceLocalService.getMasterProvincesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterProvinceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterProvinceLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.admin.product.model.MasterProvince setActive(
			long masterProvinceId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterProvinceLocalService.setActive(
			masterProvinceId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.MasterProvince updateMasterProvince(
			long masterProvinceId, String name, int countryId, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterProvinceLocalService.updateMasterProvince(
			masterProvinceId, name, countryId, active);
	}

	/**
	 * Updates the master province in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterProvinceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterProvince the master province
	 * @return the master province that was updated
	 */
	@Override
	public com.mypage.admin.product.model.MasterProvince updateMasterProvince(
		com.mypage.admin.product.model.MasterProvince masterProvince) {

		return _masterProvinceLocalService.updateMasterProvince(masterProvince);
	}

	@Override
	public MasterProvinceLocalService getWrappedService() {
		return _masterProvinceLocalService;
	}

	@Override
	public void setWrappedService(
		MasterProvinceLocalService masterProvinceLocalService) {

		_masterProvinceLocalService = masterProvinceLocalService;
	}

	private MasterProvinceLocalService _masterProvinceLocalService;

}