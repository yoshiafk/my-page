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
 * Provides a wrapper for {@link CompanyTypeLocalService}.
 *
 * @author Gositus Team
 * @see CompanyTypeLocalService
 * @generated
 */
public class CompanyTypeLocalServiceWrapper
	implements CompanyTypeLocalService,
			   ServiceWrapper<CompanyTypeLocalService> {

	public CompanyTypeLocalServiceWrapper(
		CompanyTypeLocalService companyTypeLocalService) {

		_companyTypeLocalService = companyTypeLocalService;
	}

	/**
	 * Adds the company type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompanyTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param companyType the company type
	 * @return the company type that was added
	 */
	@Override
	public com.mypage.admin.product.model.CompanyType addCompanyType(
		com.mypage.admin.product.model.CompanyType companyType) {

		return _companyTypeLocalService.addCompanyType(companyType);
	}

	@Override
	public com.mypage.admin.product.model.CompanyType addCompanyType(
			String name, String label, int sort, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyTypeLocalService.addCompanyType(
			name, label, sort, active);
	}

	/**
	 * Creates a new company type with the primary key. Does not add the company type to the database.
	 *
	 * @param companyTypeId the primary key for the new company type
	 * @return the new company type
	 */
	@Override
	public com.mypage.admin.product.model.CompanyType createCompanyType(
		long companyTypeId) {

		return _companyTypeLocalService.createCompanyType(companyTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the company type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompanyTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param companyType the company type
	 * @return the company type that was removed
	 */
	@Override
	public com.mypage.admin.product.model.CompanyType deleteCompanyType(
		com.mypage.admin.product.model.CompanyType companyType) {

		return _companyTypeLocalService.deleteCompanyType(companyType);
	}

	/**
	 * Deletes the company type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompanyTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param companyTypeId the primary key of the company type
	 * @return the company type that was removed
	 * @throws PortalException if a company type with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.CompanyType deleteCompanyType(
			long companyTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyTypeLocalService.deleteCompanyType(companyTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _companyTypeLocalService.dynamicQuery();
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

		return _companyTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.CompanyTypeModelImpl</code>.
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

		return _companyTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.CompanyTypeModelImpl</code>.
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

		return _companyTypeLocalService.dynamicQuery(
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

		return _companyTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _companyTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.CompanyType fetchCompanyType(
		long companyTypeId) {

		return _companyTypeLocalService.fetchCompanyType(companyTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _companyTypeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the company type with the primary key.
	 *
	 * @param companyTypeId the primary key of the company type
	 * @return the company type
	 * @throws PortalException if a company type with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.CompanyType getCompanyType(
			long companyTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyTypeLocalService.getCompanyType(companyTypeId);
	}

	@Override
	public int getCompanyTypeCount() {
		return _companyTypeLocalService.getCompanyTypeCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.CompanyType>
		getCompanyTypes() {

		return _companyTypeLocalService.getCompanyTypes();
	}

	/**
	 * Returns a range of all the company types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.CompanyTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of company types
	 * @param end the upper bound of the range of company types (not inclusive)
	 * @return the range of company types
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.CompanyType>
		getCompanyTypes(int start, int end) {

		return _companyTypeLocalService.getCompanyTypes(start, end);
	}

	/**
	 * Returns the number of company types.
	 *
	 * @return the number of company types
	 */
	@Override
	public int getCompanyTypesCount() {
		return _companyTypeLocalService.getCompanyTypesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _companyTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _companyTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.admin.product.model.CompanyType setActive(
			long userId, long companyTypeId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyTypeLocalService.setActive(
			userId, companyTypeId, active, serviceContext);
	}

	/**
	 * Updates the company type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompanyTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param companyType the company type
	 * @return the company type that was updated
	 */
	@Override
	public com.mypage.admin.product.model.CompanyType updateCompanyType(
		com.mypage.admin.product.model.CompanyType companyType) {

		return _companyTypeLocalService.updateCompanyType(companyType);
	}

	@Override
	public com.mypage.admin.product.model.CompanyType updateCompanyType(
			long companyTypeId, String name, String label, int sort, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyTypeLocalService.updateCompanyType(
			companyTypeId, name, label, sort, active);
	}

	@Override
	public CompanyTypeLocalService getWrappedService() {
		return _companyTypeLocalService;
	}

	@Override
	public void setWrappedService(
		CompanyTypeLocalService companyTypeLocalService) {

		_companyTypeLocalService = companyTypeLocalService;
	}

	private CompanyTypeLocalService _companyTypeLocalService;

}