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
 * Provides a wrapper for {@link MasterBankLocalService}.
 *
 * @author Gositus Team
 * @see MasterBankLocalService
 * @generated
 */
public class MasterBankLocalServiceWrapper
	implements MasterBankLocalService, ServiceWrapper<MasterBankLocalService> {

	public MasterBankLocalServiceWrapper(
		MasterBankLocalService masterBankLocalService) {

		_masterBankLocalService = masterBankLocalService;
	}

	/**
	 * Adds the master bank to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterBankLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterBank the master bank
	 * @return the master bank that was added
	 */
	@Override
	public com.mypage.admin.product.model.MasterBank addMasterBank(
		com.mypage.admin.product.model.MasterBank masterBank) {

		return _masterBankLocalService.addMasterBank(masterBank);
	}

	@Override
	public com.mypage.admin.product.model.MasterBank addMasterBank(
			String bankCode, String bankDesc, String name, String detail,
			String imageURL, long imageFileEntryId, int order, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterBankLocalService.addMasterBank(
			bankCode, bankDesc, name, detail, imageURL, imageFileEntryId, order,
			active);
	}

	/**
	 * Creates a new master bank with the primary key. Does not add the master bank to the database.
	 *
	 * @param masterBankId the primary key for the new master bank
	 * @return the new master bank
	 */
	@Override
	public com.mypage.admin.product.model.MasterBank createMasterBank(
		long masterBankId) {

		return _masterBankLocalService.createMasterBank(masterBankId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterBankLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the master bank with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterBankLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterBankId the primary key of the master bank
	 * @return the master bank that was removed
	 * @throws PortalException if a master bank with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterBank deleteMasterBank(
			long masterBankId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterBankLocalService.deleteMasterBank(masterBankId);
	}

	/**
	 * Deletes the master bank from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterBankLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterBank the master bank
	 * @return the master bank that was removed
	 */
	@Override
	public com.mypage.admin.product.model.MasterBank deleteMasterBank(
		com.mypage.admin.product.model.MasterBank masterBank) {

		return _masterBankLocalService.deleteMasterBank(masterBank);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterBankLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _masterBankLocalService.dynamicQuery();
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

		return _masterBankLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterBankModelImpl</code>.
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

		return _masterBankLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterBankModelImpl</code>.
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

		return _masterBankLocalService.dynamicQuery(
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

		return _masterBankLocalService.dynamicQueryCount(dynamicQuery);
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

		return _masterBankLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.MasterBank fetchMasterBank(
		long masterBankId) {

		return _masterBankLocalService.fetchMasterBank(masterBankId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.MasterBank> findByName(
		String name, int active) {

		return _masterBankLocalService.findByName(name, active);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _masterBankLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.MasterBank>
		getActiveBanks() {

		return _masterBankLocalService.getActiveBanks();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _masterBankLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the master bank with the primary key.
	 *
	 * @param masterBankId the primary key of the master bank
	 * @return the master bank
	 * @throws PortalException if a master bank with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterBank getMasterBank(
			long masterBankId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterBankLocalService.getMasterBank(masterBankId);
	}

	/**
	 * Returns a range of all the master banks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @return the range of master banks
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.MasterBank>
		getMasterBanks(int start, int end) {

		return _masterBankLocalService.getMasterBanks(start, end);
	}

	/**
	 * Returns the number of master banks.
	 *
	 * @return the number of master banks
	 */
	@Override
	public int getMasterBanksCount() {
		return _masterBankLocalService.getMasterBanksCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterBankLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterBankLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.admin.product.model.MasterBank setActive(
			long masterBankId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterBankLocalService.setActive(
			masterBankId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.MasterBank updateMasterBank(
			long masterBankId, String bankCode, String bankDesc, String name,
			String detail, String imageURL, long imageFileEntryId, int order,
			int active, boolean isImport)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterBankLocalService.updateMasterBank(
			masterBankId, bankCode, bankDesc, name, detail, imageURL,
			imageFileEntryId, order, active, isImport);
	}

	/**
	 * Updates the master bank in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterBankLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterBank the master bank
	 * @return the master bank that was updated
	 */
	@Override
	public com.mypage.admin.product.model.MasterBank updateMasterBank(
		com.mypage.admin.product.model.MasterBank masterBank) {

		return _masterBankLocalService.updateMasterBank(masterBank);
	}

	@Override
	public MasterBankLocalService getWrappedService() {
		return _masterBankLocalService;
	}

	@Override
	public void setWrappedService(
		MasterBankLocalService masterBankLocalService) {

		_masterBankLocalService = masterBankLocalService;
	}

	private MasterBankLocalService _masterBankLocalService;

}