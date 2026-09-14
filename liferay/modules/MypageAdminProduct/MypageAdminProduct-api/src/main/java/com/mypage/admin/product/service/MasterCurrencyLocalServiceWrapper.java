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
 * Provides a wrapper for {@link MasterCurrencyLocalService}.
 *
 * @author Gositus Team
 * @see MasterCurrencyLocalService
 * @generated
 */
public class MasterCurrencyLocalServiceWrapper
	implements MasterCurrencyLocalService,
			   ServiceWrapper<MasterCurrencyLocalService> {

	public MasterCurrencyLocalServiceWrapper(
		MasterCurrencyLocalService masterCurrencyLocalService) {

		_masterCurrencyLocalService = masterCurrencyLocalService;
	}

	/**
	 * Adds the master currency to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterCurrencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterCurrency the master currency
	 * @return the master currency that was added
	 */
	@Override
	public com.mypage.admin.product.model.MasterCurrency addMasterCurrency(
		com.mypage.admin.product.model.MasterCurrency masterCurrency) {

		return _masterCurrencyLocalService.addMasterCurrency(masterCurrency);
	}

	@Override
	public com.mypage.admin.product.model.MasterCurrency addMasterCurrency(
			String currencyName, double amount, int isDefault, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCurrencyLocalService.addMasterCurrency(
			currencyName, amount, isDefault, active);
	}

	/**
	 * Creates a new master currency with the primary key. Does not add the master currency to the database.
	 *
	 * @param currencyId the primary key for the new master currency
	 * @return the new master currency
	 */
	@Override
	public com.mypage.admin.product.model.MasterCurrency createMasterCurrency(
		long currencyId) {

		return _masterCurrencyLocalService.createMasterCurrency(currencyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCurrencyLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the master currency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterCurrencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param currencyId the primary key of the master currency
	 * @return the master currency that was removed
	 * @throws PortalException if a master currency with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterCurrency deleteMasterCurrency(
			long currencyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCurrencyLocalService.deleteMasterCurrency(currencyId);
	}

	/**
	 * Deletes the master currency from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterCurrencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterCurrency the master currency
	 * @return the master currency that was removed
	 */
	@Override
	public com.mypage.admin.product.model.MasterCurrency deleteMasterCurrency(
		com.mypage.admin.product.model.MasterCurrency masterCurrency) {

		return _masterCurrencyLocalService.deleteMasterCurrency(masterCurrency);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCurrencyLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _masterCurrencyLocalService.dynamicQuery();
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

		return _masterCurrencyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterCurrencyModelImpl</code>.
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

		return _masterCurrencyLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterCurrencyModelImpl</code>.
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

		return _masterCurrencyLocalService.dynamicQuery(
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

		return _masterCurrencyLocalService.dynamicQueryCount(dynamicQuery);
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

		return _masterCurrencyLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.MasterCurrency fetchMasterCurrency(
		long currencyId) {

		return _masterCurrencyLocalService.fetchMasterCurrency(currencyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _masterCurrencyLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _masterCurrencyLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.MasterCurrency>
		getMasterCurrencies() {

		return _masterCurrencyLocalService.getMasterCurrencies();
	}

	/**
	 * Returns a range of all the master currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @return the range of master currencies
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.MasterCurrency>
		getMasterCurrencies(int start, int end) {

		return _masterCurrencyLocalService.getMasterCurrencies(start, end);
	}

	/**
	 * Returns the number of master currencies.
	 *
	 * @return the number of master currencies
	 */
	@Override
	public int getMasterCurrenciesCount() {
		return _masterCurrencyLocalService.getMasterCurrenciesCount();
	}

	/**
	 * Returns the master currency with the primary key.
	 *
	 * @param currencyId the primary key of the master currency
	 * @return the master currency
	 * @throws PortalException if a master currency with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterCurrency getMasterCurrency(
			long currencyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCurrencyLocalService.getMasterCurrency(currencyId);
	}

	@Override
	public int getMasterCurrencyCount() {
		return _masterCurrencyLocalService.getMasterCurrencyCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterCurrencyLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCurrencyLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.admin.product.model.MasterCurrency searchCurrency(
		String _currency) {

		return _masterCurrencyLocalService.searchCurrency(_currency);
	}

	@Override
	public com.mypage.admin.product.model.MasterCurrency setActive(
			long currencyId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCurrencyLocalService.setActive(
			currencyId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.MasterCurrency updateMasterCurrency(
			long currencyId, String currencyName, double amount, int isDefault,
			int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterCurrencyLocalService.updateMasterCurrency(
			currencyId, currencyName, amount, isDefault, active);
	}

	/**
	 * Updates the master currency in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterCurrencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterCurrency the master currency
	 * @return the master currency that was updated
	 */
	@Override
	public com.mypage.admin.product.model.MasterCurrency updateMasterCurrency(
		com.mypage.admin.product.model.MasterCurrency masterCurrency) {

		return _masterCurrencyLocalService.updateMasterCurrency(masterCurrency);
	}

	@Override
	public MasterCurrencyLocalService getWrappedService() {
		return _masterCurrencyLocalService;
	}

	@Override
	public void setWrappedService(
		MasterCurrencyLocalService masterCurrencyLocalService) {

		_masterCurrencyLocalService = masterCurrencyLocalService;
	}

	private MasterCurrencyLocalService _masterCurrencyLocalService;

}