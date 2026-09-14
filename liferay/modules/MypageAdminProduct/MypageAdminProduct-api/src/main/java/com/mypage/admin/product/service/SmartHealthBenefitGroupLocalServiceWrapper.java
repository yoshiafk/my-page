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
 * Provides a wrapper for {@link SmartHealthBenefitGroupLocalService}.
 *
 * @author Gositus Team
 * @see SmartHealthBenefitGroupLocalService
 * @generated
 */
public class SmartHealthBenefitGroupLocalServiceWrapper
	implements ServiceWrapper<SmartHealthBenefitGroupLocalService>,
			   SmartHealthBenefitGroupLocalService {

	public SmartHealthBenefitGroupLocalServiceWrapper(
		SmartHealthBenefitGroupLocalService
			smartHealthBenefitGroupLocalService) {

		_smartHealthBenefitGroupLocalService =
			smartHealthBenefitGroupLocalService;
	}

	/**
	 * Adds the smart health benefit group to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefitGroup the smart health benefit group
	 * @return the smart health benefit group that was added
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthBenefitGroup
		addSmartHealthBenefitGroup(
			com.mypage.admin.product.model.SmartHealthBenefitGroup
				smartHealthBenefitGroup) {

		return _smartHealthBenefitGroupLocalService.addSmartHealthBenefitGroup(
			smartHealthBenefitGroup);
	}

	/**
	 * Add Benefit Group
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthBenefitGroup
			addSmartHealthBenefitGroup(
				String groupName, String groupDescription, String groupCode,
				int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthBenefitGroupLocalService.addSmartHealthBenefitGroup(
			groupName, groupDescription, groupCode, active);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthBenefitGroupLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new smart health benefit group with the primary key. Does not add the smart health benefit group to the database.
	 *
	 * @param smartHealthBenefitGroupId the primary key for the new smart health benefit group
	 * @return the new smart health benefit group
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthBenefitGroup
		createSmartHealthBenefitGroup(long smartHealthBenefitGroupId) {

		return _smartHealthBenefitGroupLocalService.
			createSmartHealthBenefitGroup(smartHealthBenefitGroupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthBenefitGroupLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the smart health benefit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefitGroupId the primary key of the smart health benefit group
	 * @return the smart health benefit group that was removed
	 * @throws PortalException if a smart health benefit group with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthBenefitGroup
			deleteSmartHealthBenefitGroup(long smartHealthBenefitGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthBenefitGroupLocalService.
			deleteSmartHealthBenefitGroup(smartHealthBenefitGroupId);
	}

	/**
	 * Deletes the smart health benefit group from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefitGroup the smart health benefit group
	 * @return the smart health benefit group that was removed
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthBenefitGroup
		deleteSmartHealthBenefitGroup(
			com.mypage.admin.product.model.SmartHealthBenefitGroup
				smartHealthBenefitGroup) {

		return _smartHealthBenefitGroupLocalService.
			deleteSmartHealthBenefitGroup(smartHealthBenefitGroup);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smartHealthBenefitGroupLocalService.dynamicQuery();
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

		return _smartHealthBenefitGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthBenefitGroupModelImpl</code>.
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

		return _smartHealthBenefitGroupLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthBenefitGroupModelImpl</code>.
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

		return _smartHealthBenefitGroupLocalService.dynamicQuery(
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

		return _smartHealthBenefitGroupLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _smartHealthBenefitGroupLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.SmartHealthBenefitGroup
		fetchSmartHealthBenefitGroup(long smartHealthBenefitGroupId) {

		return _smartHealthBenefitGroupLocalService.
			fetchSmartHealthBenefitGroup(smartHealthBenefitGroupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smartHealthBenefitGroupLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smartHealthBenefitGroupLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartHealthBenefitGroupLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthBenefitGroupLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the smart health benefit group with the primary key.
	 *
	 * @param smartHealthBenefitGroupId the primary key of the smart health benefit group
	 * @return the smart health benefit group
	 * @throws PortalException if a smart health benefit group with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthBenefitGroup
			getSmartHealthBenefitGroup(long smartHealthBenefitGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthBenefitGroupLocalService.getSmartHealthBenefitGroup(
			smartHealthBenefitGroupId);
	}

	@Override
	public int getSmartHealthBenefitGroupCounts() {
		return _smartHealthBenefitGroupLocalService.
			getSmartHealthBenefitGroupCounts();
	}

	@Override
	public java.util.List
		<com.mypage.admin.product.model.SmartHealthBenefitGroup>
			getSmartHealthBenefitGroups() {

		return _smartHealthBenefitGroupLocalService.
			getSmartHealthBenefitGroups();
	}

	/**
	 * Returns a range of all the smart health benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefit groups
	 * @param end the upper bound of the range of smart health benefit groups (not inclusive)
	 * @return the range of smart health benefit groups
	 */
	@Override
	public java.util.List
		<com.mypage.admin.product.model.SmartHealthBenefitGroup>
			getSmartHealthBenefitGroups(int start, int end) {

		return _smartHealthBenefitGroupLocalService.getSmartHealthBenefitGroups(
			start, end);
	}

	/**
	 * Returns the number of smart health benefit groups.
	 *
	 * @return the number of smart health benefit groups
	 */
	@Override
	public int getSmartHealthBenefitGroupsCount() {
		return _smartHealthBenefitGroupLocalService.
			getSmartHealthBenefitGroupsCount();
	}

	@Override
	public com.mypage.admin.product.model.SmartHealthBenefitGroup setActive(
			long smartHealthBenefitGroupId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthBenefitGroupLocalService.setActive(
			smartHealthBenefitGroupId, active, serviceContext);
	}

	/**
	 * Update Benefit Group
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthBenefitGroup
			updateSmartHealthBenefitGroup(
				long smartHealthBenefitGroupId, String groupName,
				String groupDescription, String groupCode, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthBenefitGroupLocalService.
			updateSmartHealthBenefitGroup(
				smartHealthBenefitGroupId, groupName, groupDescription,
				groupCode, active);
	}

	/**
	 * Updates the smart health benefit group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefitGroup the smart health benefit group
	 * @return the smart health benefit group that was updated
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthBenefitGroup
		updateSmartHealthBenefitGroup(
			com.mypage.admin.product.model.SmartHealthBenefitGroup
				smartHealthBenefitGroup) {

		return _smartHealthBenefitGroupLocalService.
			updateSmartHealthBenefitGroup(smartHealthBenefitGroup);
	}

	@Override
	public SmartHealthBenefitGroupLocalService getWrappedService() {
		return _smartHealthBenefitGroupLocalService;
	}

	@Override
	public void setWrappedService(
		SmartHealthBenefitGroupLocalService
			smartHealthBenefitGroupLocalService) {

		_smartHealthBenefitGroupLocalService =
			smartHealthBenefitGroupLocalService;
	}

	private SmartHealthBenefitGroupLocalService
		_smartHealthBenefitGroupLocalService;

}