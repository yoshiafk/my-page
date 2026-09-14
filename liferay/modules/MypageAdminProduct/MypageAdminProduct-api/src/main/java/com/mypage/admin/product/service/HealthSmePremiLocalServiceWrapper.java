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
 * Provides a wrapper for {@link HealthSmePremiLocalService}.
 *
 * @author Gositus Team
 * @see HealthSmePremiLocalService
 * @generated
 */
public class HealthSmePremiLocalServiceWrapper
	implements HealthSmePremiLocalService,
			   ServiceWrapper<HealthSmePremiLocalService> {

	public HealthSmePremiLocalServiceWrapper(
		HealthSmePremiLocalService healthSmePremiLocalService) {

		_healthSmePremiLocalService = healthSmePremiLocalService;
	}

	/**
	 * Adds the health sme premi to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HealthSmePremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param healthSmePremi the health sme premi
	 * @return the health sme premi that was added
	 */
	@Override
	public com.mypage.admin.product.model.HealthSmePremi addHealthSmePremi(
		com.mypage.admin.product.model.HealthSmePremi healthSmePremi) {

		return _healthSmePremiLocalService.addHealthSmePremi(healthSmePremi);
	}

	/**
	 * Creates a new health sme premi with the primary key. Does not add the health sme premi to the database.
	 *
	 * @param healthSmePremiId the primary key for the new health sme premi
	 * @return the new health sme premi
	 */
	@Override
	public com.mypage.admin.product.model.HealthSmePremi createHealthSmePremi(
		long healthSmePremiId) {

		return _healthSmePremiLocalService.createHealthSmePremi(
			healthSmePremiId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthSmePremiLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the health sme premi from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HealthSmePremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param healthSmePremi the health sme premi
	 * @return the health sme premi that was removed
	 */
	@Override
	public com.mypage.admin.product.model.HealthSmePremi deleteHealthSmePremi(
		com.mypage.admin.product.model.HealthSmePremi healthSmePremi) {

		return _healthSmePremiLocalService.deleteHealthSmePremi(healthSmePremi);
	}

	/**
	 * Deletes the health sme premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HealthSmePremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param healthSmePremiId the primary key of the health sme premi
	 * @return the health sme premi that was removed
	 * @throws PortalException if a health sme premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.HealthSmePremi deleteHealthSmePremi(
			long healthSmePremiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthSmePremiLocalService.deleteHealthSmePremi(
			healthSmePremiId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthSmePremiLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _healthSmePremiLocalService.dynamicQuery();
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

		return _healthSmePremiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.HealthSmePremiModelImpl</code>.
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

		return _healthSmePremiLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.HealthSmePremiModelImpl</code>.
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

		return _healthSmePremiLocalService.dynamicQuery(
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

		return _healthSmePremiLocalService.dynamicQueryCount(dynamicQuery);
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

		return _healthSmePremiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.HealthSmePremi fetchHealthSmePremi(
		long healthSmePremiId) {

		return _healthSmePremiLocalService.fetchHealthSmePremi(
			healthSmePremiId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _healthSmePremiLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the health sme premi with the primary key.
	 *
	 * @param healthSmePremiId the primary key of the health sme premi
	 * @return the health sme premi
	 * @throws PortalException if a health sme premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.HealthSmePremi getHealthSmePremi(
			long healthSmePremiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthSmePremiLocalService.getHealthSmePremi(healthSmePremiId);
	}

	/**
	 * Returns a range of all the health sme premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.HealthSmePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme premis
	 * @param end the upper bound of the range of health sme premis (not inclusive)
	 * @return the range of health sme premis
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.HealthSmePremi>
		getHealthSmePremis(int start, int end) {

		return _healthSmePremiLocalService.getHealthSmePremis(start, end);
	}

	/**
	 * Returns the number of health sme premis.
	 *
	 * @return the number of health sme premis
	 */
	@Override
	public int getHealthSmePremisCount() {
		return _healthSmePremiLocalService.getHealthSmePremisCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _healthSmePremiLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _healthSmePremiLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthSmePremiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the health sme premi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HealthSmePremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param healthSmePremi the health sme premi
	 * @return the health sme premi that was updated
	 */
	@Override
	public com.mypage.admin.product.model.HealthSmePremi updateHealthSmePremi(
		com.mypage.admin.product.model.HealthSmePremi healthSmePremi) {

		return _healthSmePremiLocalService.updateHealthSmePremi(healthSmePremi);
	}

	@Override
	public HealthSmePremiLocalService getWrappedService() {
		return _healthSmePremiLocalService;
	}

	@Override
	public void setWrappedService(
		HealthSmePremiLocalService healthSmePremiLocalService) {

		_healthSmePremiLocalService = healthSmePremiLocalService;
	}

	private HealthSmePremiLocalService _healthSmePremiLocalService;

}