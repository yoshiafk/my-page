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

package com.mypage.user.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CreditWalletLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CreditWalletLocalService
 * @generated
 */
public class CreditWalletLocalServiceWrapper
	implements CreditWalletLocalService,
			   ServiceWrapper<CreditWalletLocalService> {

	public CreditWalletLocalServiceWrapper(
		CreditWalletLocalService creditWalletLocalService) {

		_creditWalletLocalService = creditWalletLocalService;
	}

	/**
	 * Adds the credit wallet to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CreditWalletLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param creditWallet the credit wallet
	 * @return the credit wallet that was added
	 */
	@Override
	public com.mypage.user.model.CreditWallet addCreditWallet(
		com.mypage.user.model.CreditWallet creditWallet) {

		return _creditWalletLocalService.addCreditWallet(creditWallet);
	}

	@Override
	public com.mypage.user.model.CreditWallet addCreditWallet(
		long creditTypeId, java.util.Date dateIssued,
		java.util.Date dateExpired, double amount, int active) {

		return _creditWalletLocalService.addCreditWallet(
			creditTypeId, dateIssued, dateExpired, amount, active);
	}

	/**
	 * Creates a new credit wallet with the primary key. Does not add the credit wallet to the database.
	 *
	 * @param creditWalletId the primary key for the new credit wallet
	 * @return the new credit wallet
	 */
	@Override
	public com.mypage.user.model.CreditWallet createCreditWallet(
		long creditWalletId) {

		return _creditWalletLocalService.createCreditWallet(creditWalletId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creditWalletLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the credit wallet from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CreditWalletLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param creditWallet the credit wallet
	 * @return the credit wallet that was removed
	 */
	@Override
	public com.mypage.user.model.CreditWallet deleteCreditWallet(
		com.mypage.user.model.CreditWallet creditWallet) {

		return _creditWalletLocalService.deleteCreditWallet(creditWallet);
	}

	/**
	 * Deletes the credit wallet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CreditWalletLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param creditWalletId the primary key of the credit wallet
	 * @return the credit wallet that was removed
	 * @throws PortalException if a credit wallet with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.CreditWallet deleteCreditWallet(
			long creditWalletId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creditWalletLocalService.deleteCreditWallet(creditWalletId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creditWalletLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _creditWalletLocalService.dynamicQuery();
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

		return _creditWalletLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.CreditWalletModelImpl</code>.
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

		return _creditWalletLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.CreditWalletModelImpl</code>.
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

		return _creditWalletLocalService.dynamicQuery(
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

		return _creditWalletLocalService.dynamicQueryCount(dynamicQuery);
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

		return _creditWalletLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.user.model.CreditWallet fetchCreditWallet(
		long creditWalletId) {

		return _creditWalletLocalService.fetchCreditWallet(creditWalletId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _creditWalletLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the credit wallet with the primary key.
	 *
	 * @param creditWalletId the primary key of the credit wallet
	 * @return the credit wallet
	 * @throws PortalException if a credit wallet with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.CreditWallet getCreditWallet(
			long creditWalletId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creditWalletLocalService.getCreditWallet(creditWalletId);
	}

	/**
	 * Returns a range of all the credit wallets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.CreditWalletModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallets
	 * @param end the upper bound of the range of credit wallets (not inclusive)
	 * @return the range of credit wallets
	 */
	@Override
	public java.util.List<com.mypage.user.model.CreditWallet> getCreditWallets(
		int start, int end) {

		return _creditWalletLocalService.getCreditWallets(start, end);
	}

	/**
	 * Returns the number of credit wallets.
	 *
	 * @return the number of credit wallets
	 */
	@Override
	public int getCreditWalletsCount() {
		return _creditWalletLocalService.getCreditWalletsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _creditWalletLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _creditWalletLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creditWalletLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.user.model.CreditWallet setActive(
		long creditWalletId, int active) {

		return _creditWalletLocalService.setActive(creditWalletId, active);
	}

	/**
	 * Updates the credit wallet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CreditWalletLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param creditWallet the credit wallet
	 * @return the credit wallet that was updated
	 */
	@Override
	public com.mypage.user.model.CreditWallet updateCreditWallet(
		com.mypage.user.model.CreditWallet creditWallet) {

		return _creditWalletLocalService.updateCreditWallet(creditWallet);
	}

	@Override
	public com.mypage.user.model.CreditWallet updateCreditWallet(
		long creditWalletId, long creditTypeId, java.util.Date dateIssued,
		java.util.Date dateExpired, double amount, int active) {

		return _creditWalletLocalService.updateCreditWallet(
			creditWalletId, creditTypeId, dateIssued, dateExpired, amount,
			active);
	}

	@Override
	public CreditWalletLocalService getWrappedService() {
		return _creditWalletLocalService;
	}

	@Override
	public void setWrappedService(
		CreditWalletLocalService creditWalletLocalService) {

		_creditWalletLocalService = creditWalletLocalService;
	}

	private CreditWalletLocalService _creditWalletLocalService;

}