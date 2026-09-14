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
 * Provides a wrapper for {@link SmartActiveOccupationLocalService}.
 *
 * @author Gositus Team
 * @see SmartActiveOccupationLocalService
 * @generated
 */
public class SmartActiveOccupationLocalServiceWrapper
	implements ServiceWrapper<SmartActiveOccupationLocalService>,
			   SmartActiveOccupationLocalService {

	public SmartActiveOccupationLocalServiceWrapper(
		SmartActiveOccupationLocalService smartActiveOccupationLocalService) {

		_smartActiveOccupationLocalService = smartActiveOccupationLocalService;
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveOccupation addOccupation(
			String code, String nameId, String nameEn, long classRateId,
			int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveOccupationLocalService.addOccupation(
			code, nameId, nameEn, classRateId, active);
	}

	/**
	 * Adds the smart active occupation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveOccupationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveOccupation the smart active occupation
	 * @return the smart active occupation that was added
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveOccupation
		addSmartActiveOccupation(
			com.mypage.admin.product.model.SmartActiveOccupation
				smartActiveOccupation) {

		return _smartActiveOccupationLocalService.addSmartActiveOccupation(
			smartActiveOccupation);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveOccupationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new smart active occupation with the primary key. Does not add the smart active occupation to the database.
	 *
	 * @param smartActiveOccupationId the primary key for the new smart active occupation
	 * @return the new smart active occupation
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveOccupation
		createSmartActiveOccupation(long smartActiveOccupationId) {

		return _smartActiveOccupationLocalService.createSmartActiveOccupation(
			smartActiveOccupationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveOccupationLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the smart active occupation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveOccupationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveOccupationId the primary key of the smart active occupation
	 * @return the smart active occupation that was removed
	 * @throws PortalException if a smart active occupation with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveOccupation
			deleteSmartActiveOccupation(long smartActiveOccupationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveOccupationLocalService.deleteSmartActiveOccupation(
			smartActiveOccupationId);
	}

	/**
	 * Deletes the smart active occupation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveOccupationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveOccupation the smart active occupation
	 * @return the smart active occupation that was removed
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveOccupation
		deleteSmartActiveOccupation(
			com.mypage.admin.product.model.SmartActiveOccupation
				smartActiveOccupation) {

		return _smartActiveOccupationLocalService.deleteSmartActiveOccupation(
			smartActiveOccupation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smartActiveOccupationLocalService.dynamicQuery();
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

		return _smartActiveOccupationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveOccupationModelImpl</code>.
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

		return _smartActiveOccupationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveOccupationModelImpl</code>.
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

		return _smartActiveOccupationLocalService.dynamicQuery(
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

		return _smartActiveOccupationLocalService.dynamicQueryCount(
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

		return _smartActiveOccupationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveOccupation
		fetchSmartActiveOccupation(long smartActiveOccupationId) {

		return _smartActiveOccupationLocalService.fetchSmartActiveOccupation(
			smartActiveOccupationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smartActiveOccupationLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveOccupation>
		getActiveOccupation() {

		return _smartActiveOccupationLocalService.getActiveOccupation();
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveOccupation getByCode(
		String code) {

		return _smartActiveOccupationLocalService.getByCode(code);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smartActiveOccupationLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveOccupation>
		getOccupationByClassRate(long typeId) {

		return _smartActiveOccupationLocalService.getOccupationByClassRate(
			typeId);
	}

	@Override
	public int getOccupationCount() {
		return _smartActiveOccupationLocalService.getOccupationCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveOccupation>
		getOccupations() {

		return _smartActiveOccupationLocalService.getOccupations();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveOccupation>
		getOccupations(int start, int end) {

		return _smartActiveOccupationLocalService.getOccupations(start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartActiveOccupationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveOccupationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the smart active occupation with the primary key.
	 *
	 * @param smartActiveOccupationId the primary key of the smart active occupation
	 * @return the smart active occupation
	 * @throws PortalException if a smart active occupation with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveOccupation
			getSmartActiveOccupation(long smartActiveOccupationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveOccupationLocalService.getSmartActiveOccupation(
			smartActiveOccupationId);
	}

	/**
	 * Returns a range of all the smart active occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active occupations
	 * @param end the upper bound of the range of smart active occupations (not inclusive)
	 * @return the range of smart active occupations
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveOccupation>
		getSmartActiveOccupations(int start, int end) {

		return _smartActiveOccupationLocalService.getSmartActiveOccupations(
			start, end);
	}

	/**
	 * Returns the number of smart active occupations.
	 *
	 * @return the number of smart active occupations
	 */
	@Override
	public int getSmartActiveOccupationsCount() {
		return _smartActiveOccupationLocalService.
			getSmartActiveOccupationsCount();
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveOccupation setActive(
			long occupationId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveOccupationLocalService.setActive(
			occupationId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveOccupation
			updateOccupation(
				long occupationId, String code, String nameId, String nameEn,
				long classRateId, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveOccupationLocalService.updateOccupation(
			occupationId, code, nameId, nameEn, classRateId, active);
	}

	/**
	 * Updates the smart active occupation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveOccupationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveOccupation the smart active occupation
	 * @return the smart active occupation that was updated
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveOccupation
		updateSmartActiveOccupation(
			com.mypage.admin.product.model.SmartActiveOccupation
				smartActiveOccupation) {

		return _smartActiveOccupationLocalService.updateSmartActiveOccupation(
			smartActiveOccupation);
	}

	@Override
	public SmartActiveOccupationLocalService getWrappedService() {
		return _smartActiveOccupationLocalService;
	}

	@Override
	public void setWrappedService(
		SmartActiveOccupationLocalService smartActiveOccupationLocalService) {

		_smartActiveOccupationLocalService = smartActiveOccupationLocalService;
	}

	private SmartActiveOccupationLocalService
		_smartActiveOccupationLocalService;

}