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
 * Provides a wrapper for {@link HealthSmeTemplateLocalService}.
 *
 * @author Gositus Team
 * @see HealthSmeTemplateLocalService
 * @generated
 */
public class HealthSmeTemplateLocalServiceWrapper
	implements HealthSmeTemplateLocalService,
			   ServiceWrapper<HealthSmeTemplateLocalService> {

	public HealthSmeTemplateLocalServiceWrapper(
		HealthSmeTemplateLocalService healthSmeTemplateLocalService) {

		_healthSmeTemplateLocalService = healthSmeTemplateLocalService;
	}

	/**
	 * Adds the health sme template to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HealthSmeTemplateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param healthSmeTemplate the health sme template
	 * @return the health sme template that was added
	 */
	@Override
	public com.mypage.admin.product.model.HealthSmeTemplate
		addHealthSmeTemplate(
			com.mypage.admin.product.model.HealthSmeTemplate
				healthSmeTemplate) {

		return _healthSmeTemplateLocalService.addHealthSmeTemplate(
			healthSmeTemplate);
	}

	/**
	 * Creates a new health sme template with the primary key. Does not add the health sme template to the database.
	 *
	 * @param healthSmeTemplateId the primary key for the new health sme template
	 * @return the new health sme template
	 */
	@Override
	public com.mypage.admin.product.model.HealthSmeTemplate
		createHealthSmeTemplate(long healthSmeTemplateId) {

		return _healthSmeTemplateLocalService.createHealthSmeTemplate(
			healthSmeTemplateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthSmeTemplateLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the health sme template from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HealthSmeTemplateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param healthSmeTemplate the health sme template
	 * @return the health sme template that was removed
	 */
	@Override
	public com.mypage.admin.product.model.HealthSmeTemplate
		deleteHealthSmeTemplate(
			com.mypage.admin.product.model.HealthSmeTemplate
				healthSmeTemplate) {

		return _healthSmeTemplateLocalService.deleteHealthSmeTemplate(
			healthSmeTemplate);
	}

	/**
	 * Deletes the health sme template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HealthSmeTemplateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param healthSmeTemplateId the primary key of the health sme template
	 * @return the health sme template that was removed
	 * @throws PortalException if a health sme template with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.HealthSmeTemplate
			deleteHealthSmeTemplate(long healthSmeTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthSmeTemplateLocalService.deleteHealthSmeTemplate(
			healthSmeTemplateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthSmeTemplateLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _healthSmeTemplateLocalService.dynamicQuery();
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

		return _healthSmeTemplateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.HealthSmeTemplateModelImpl</code>.
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

		return _healthSmeTemplateLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.HealthSmeTemplateModelImpl</code>.
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

		return _healthSmeTemplateLocalService.dynamicQuery(
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

		return _healthSmeTemplateLocalService.dynamicQueryCount(dynamicQuery);
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

		return _healthSmeTemplateLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.HealthSmeTemplate
		fetchHealthSmeTemplate(long healthSmeTemplateId) {

		return _healthSmeTemplateLocalService.fetchHealthSmeTemplate(
			healthSmeTemplateId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _healthSmeTemplateLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the health sme template with the primary key.
	 *
	 * @param healthSmeTemplateId the primary key of the health sme template
	 * @return the health sme template
	 * @throws PortalException if a health sme template with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.HealthSmeTemplate
			getHealthSmeTemplate(long healthSmeTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthSmeTemplateLocalService.getHealthSmeTemplate(
			healthSmeTemplateId);
	}

	/**
	 * Returns a range of all the health sme templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.HealthSmeTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme templates
	 * @param end the upper bound of the range of health sme templates (not inclusive)
	 * @return the range of health sme templates
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.HealthSmeTemplate>
		getHealthSmeTemplates(int start, int end) {

		return _healthSmeTemplateLocalService.getHealthSmeTemplates(start, end);
	}

	/**
	 * Returns the number of health sme templates.
	 *
	 * @return the number of health sme templates
	 */
	@Override
	public int getHealthSmeTemplatesCount() {
		return _healthSmeTemplateLocalService.getHealthSmeTemplatesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _healthSmeTemplateLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _healthSmeTemplateLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthSmeTemplateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the health sme template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HealthSmeTemplateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param healthSmeTemplate the health sme template
	 * @return the health sme template that was updated
	 */
	@Override
	public com.mypage.admin.product.model.HealthSmeTemplate
		updateHealthSmeTemplate(
			com.mypage.admin.product.model.HealthSmeTemplate
				healthSmeTemplate) {

		return _healthSmeTemplateLocalService.updateHealthSmeTemplate(
			healthSmeTemplate);
	}

	@Override
	public HealthSmeTemplateLocalService getWrappedService() {
		return _healthSmeTemplateLocalService;
	}

	@Override
	public void setWrappedService(
		HealthSmeTemplateLocalService healthSmeTemplateLocalService) {

		_healthSmeTemplateLocalService = healthSmeTemplateLocalService;
	}

	private HealthSmeTemplateLocalService _healthSmeTemplateLocalService;

}