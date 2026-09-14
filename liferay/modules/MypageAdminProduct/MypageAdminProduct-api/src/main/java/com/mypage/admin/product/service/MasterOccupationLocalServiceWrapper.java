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
 * Provides a wrapper for {@link MasterOccupationLocalService}.
 *
 * @author Gositus Team
 * @see MasterOccupationLocalService
 * @generated
 */
public class MasterOccupationLocalServiceWrapper
	implements MasterOccupationLocalService,
			   ServiceWrapper<MasterOccupationLocalService> {

	public MasterOccupationLocalServiceWrapper(
		MasterOccupationLocalService masterOccupationLocalService) {

		_masterOccupationLocalService = masterOccupationLocalService;
	}

	/**
	 * Adds the master occupation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterOccupationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterOccupation the master occupation
	 * @return the master occupation that was added
	 */
	@Override
	public com.mypage.admin.product.model.MasterOccupation addMasterOccupation(
		com.mypage.admin.product.model.MasterOccupation masterOccupation) {

		return _masterOccupationLocalService.addMasterOccupation(
			masterOccupation);
	}

	@Override
	public com.mypage.admin.product.model.MasterOccupation addMasterOccupation(
		String name, long masterOccupationCategoryId, int active) {

		return _masterOccupationLocalService.addMasterOccupation(
			name, masterOccupationCategoryId, active);
	}

	/**
	 * Creates a new master occupation with the primary key. Does not add the master occupation to the database.
	 *
	 * @param masterOccupationId the primary key for the new master occupation
	 * @return the new master occupation
	 */
	@Override
	public com.mypage.admin.product.model.MasterOccupation
		createMasterOccupation(long masterOccupationId) {

		return _masterOccupationLocalService.createMasterOccupation(
			masterOccupationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterOccupationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the master occupation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterOccupationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterOccupationId the primary key of the master occupation
	 * @return the master occupation that was removed
	 * @throws PortalException if a master occupation with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterOccupation
			deleteMasterOccupation(long masterOccupationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterOccupationLocalService.deleteMasterOccupation(
			masterOccupationId);
	}

	/**
	 * Deletes the master occupation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterOccupationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterOccupation the master occupation
	 * @return the master occupation that was removed
	 */
	@Override
	public com.mypage.admin.product.model.MasterOccupation
		deleteMasterOccupation(
			com.mypage.admin.product.model.MasterOccupation masterOccupation) {

		return _masterOccupationLocalService.deleteMasterOccupation(
			masterOccupation);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterOccupationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _masterOccupationLocalService.dynamicQuery();
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

		return _masterOccupationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterOccupationModelImpl</code>.
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

		return _masterOccupationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterOccupationModelImpl</code>.
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

		return _masterOccupationLocalService.dynamicQuery(
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

		return _masterOccupationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _masterOccupationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.MasterOccupation
		fetchMasterOccupation(long masterOccupationId) {

		return _masterOccupationLocalService.fetchMasterOccupation(
			masterOccupationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _masterOccupationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _masterOccupationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the master occupation with the primary key.
	 *
	 * @param masterOccupationId the primary key of the master occupation
	 * @return the master occupation
	 * @throws PortalException if a master occupation with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterOccupation getMasterOccupation(
			long masterOccupationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterOccupationLocalService.getMasterOccupation(
			masterOccupationId);
	}

	/**
	 * Returns a range of all the master occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @return the range of master occupations
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.MasterOccupation>
		getMasterOccupations(int start, int end) {

		return _masterOccupationLocalService.getMasterOccupations(start, end);
	}

	/**
	 * Returns the number of master occupations.
	 *
	 * @return the number of master occupations
	 */
	@Override
	public int getMasterOccupationsCount() {
		return _masterOccupationLocalService.getMasterOccupationsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterOccupationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterOccupationLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.MasterOccupation>
		searchByActive(int active) {

		return _masterOccupationLocalService.searchByActive(active);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.MasterOccupation>
		searchByMasterOccupationCategoryId(long masterOccupationCategoryId) {

		return _masterOccupationLocalService.searchByMasterOccupationCategoryId(
			masterOccupationCategoryId);
	}

	@Override
	public com.mypage.admin.product.model.MasterOccupation setActive(
		long masterOccupationId, int active) {

		return _masterOccupationLocalService.setActive(
			masterOccupationId, active);
	}

	@Override
	public com.mypage.admin.product.model.MasterOccupation
			updateMasterOccupation(
				long masterOccupationId, String name,
				long masterOccupationCategoryId, int active)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationException {

		return _masterOccupationLocalService.updateMasterOccupation(
			masterOccupationId, name, masterOccupationCategoryId, active);
	}

	/**
	 * Updates the master occupation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterOccupationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterOccupation the master occupation
	 * @return the master occupation that was updated
	 */
	@Override
	public com.mypage.admin.product.model.MasterOccupation
		updateMasterOccupation(
			com.mypage.admin.product.model.MasterOccupation masterOccupation) {

		return _masterOccupationLocalService.updateMasterOccupation(
			masterOccupation);
	}

	@Override
	public MasterOccupationLocalService getWrappedService() {
		return _masterOccupationLocalService;
	}

	@Override
	public void setWrappedService(
		MasterOccupationLocalService masterOccupationLocalService) {

		_masterOccupationLocalService = masterOccupationLocalService;
	}

	private MasterOccupationLocalService _masterOccupationLocalService;

}