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
 * Provides a wrapper for {@link HealthIndividuPremiLocalService}.
 *
 * @author Gositus Team
 * @see HealthIndividuPremiLocalService
 * @generated
 */
public class HealthIndividuPremiLocalServiceWrapper
	implements HealthIndividuPremiLocalService,
			   ServiceWrapper<HealthIndividuPremiLocalService> {

	public HealthIndividuPremiLocalServiceWrapper(
		HealthIndividuPremiLocalService healthIndividuPremiLocalService) {

		_healthIndividuPremiLocalService = healthIndividuPremiLocalService;
	}

	/**
	 * Adds the health individu premi to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HealthIndividuPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param healthIndividuPremi the health individu premi
	 * @return the health individu premi that was added
	 */
	@Override
	public com.mypage.admin.product.model.HealthIndividuPremi
		addHealthIndividuPremi(
			com.mypage.admin.product.model.HealthIndividuPremi
				healthIndividuPremi) {

		return _healthIndividuPremiLocalService.addHealthIndividuPremi(
			healthIndividuPremi);
	}

	/**
	 * Creates a new health individu premi with the primary key. Does not add the health individu premi to the database.
	 *
	 * @param healthIndividuPremiId the primary key for the new health individu premi
	 * @return the new health individu premi
	 */
	@Override
	public com.mypage.admin.product.model.HealthIndividuPremi
		createHealthIndividuPremi(long healthIndividuPremiId) {

		return _healthIndividuPremiLocalService.createHealthIndividuPremi(
			healthIndividuPremiId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthIndividuPremiLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the health individu premi from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HealthIndividuPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param healthIndividuPremi the health individu premi
	 * @return the health individu premi that was removed
	 */
	@Override
	public com.mypage.admin.product.model.HealthIndividuPremi
		deleteHealthIndividuPremi(
			com.mypage.admin.product.model.HealthIndividuPremi
				healthIndividuPremi) {

		return _healthIndividuPremiLocalService.deleteHealthIndividuPremi(
			healthIndividuPremi);
	}

	/**
	 * Deletes the health individu premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HealthIndividuPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param healthIndividuPremiId the primary key of the health individu premi
	 * @return the health individu premi that was removed
	 * @throws PortalException if a health individu premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.HealthIndividuPremi
			deleteHealthIndividuPremi(long healthIndividuPremiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthIndividuPremiLocalService.deleteHealthIndividuPremi(
			healthIndividuPremiId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthIndividuPremiLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _healthIndividuPremiLocalService.dynamicQuery();
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

		return _healthIndividuPremiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.HealthIndividuPremiModelImpl</code>.
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

		return _healthIndividuPremiLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.HealthIndividuPremiModelImpl</code>.
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

		return _healthIndividuPremiLocalService.dynamicQuery(
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

		return _healthIndividuPremiLocalService.dynamicQueryCount(dynamicQuery);
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

		return _healthIndividuPremiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.HealthIndividuPremi
		fetchHealthIndividuPremi(long healthIndividuPremiId) {

		return _healthIndividuPremiLocalService.fetchHealthIndividuPremi(
			healthIndividuPremiId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _healthIndividuPremiLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the health individu premi with the primary key.
	 *
	 * @param healthIndividuPremiId the primary key of the health individu premi
	 * @return the health individu premi
	 * @throws PortalException if a health individu premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.HealthIndividuPremi
			getHealthIndividuPremi(long healthIndividuPremiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthIndividuPremiLocalService.getHealthIndividuPremi(
			healthIndividuPremiId);
	}

	/**
	 * Returns a range of all the health individu premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.HealthIndividuPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu premis
	 * @param end the upper bound of the range of health individu premis (not inclusive)
	 * @return the range of health individu premis
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.HealthIndividuPremi>
		getHealthIndividuPremis(int start, int end) {

		return _healthIndividuPremiLocalService.getHealthIndividuPremis(
			start, end);
	}

	/**
	 * Returns the number of health individu premis.
	 *
	 * @return the number of health individu premis
	 */
	@Override
	public int getHealthIndividuPremisCount() {
		return _healthIndividuPremiLocalService.getHealthIndividuPremisCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _healthIndividuPremiLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _healthIndividuPremiLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthIndividuPremiLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the health individu premi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HealthIndividuPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param healthIndividuPremi the health individu premi
	 * @return the health individu premi that was updated
	 */
	@Override
	public com.mypage.admin.product.model.HealthIndividuPremi
		updateHealthIndividuPremi(
			com.mypage.admin.product.model.HealthIndividuPremi
				healthIndividuPremi) {

		return _healthIndividuPremiLocalService.updateHealthIndividuPremi(
			healthIndividuPremi);
	}

	@Override
	public HealthIndividuPremiLocalService getWrappedService() {
		return _healthIndividuPremiLocalService;
	}

	@Override
	public void setWrappedService(
		HealthIndividuPremiLocalService healthIndividuPremiLocalService) {

		_healthIndividuPremiLocalService = healthIndividuPremiLocalService;
	}

	private HealthIndividuPremiLocalService _healthIndividuPremiLocalService;

}