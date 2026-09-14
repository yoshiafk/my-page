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
 * Provides a wrapper for {@link CreditWalletHistoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CreditWalletHistoryLocalService
 * @generated
 */
public class CreditWalletHistoryLocalServiceWrapper
	implements CreditWalletHistoryLocalService,
			   ServiceWrapper<CreditWalletHistoryLocalService> {

	public CreditWalletHistoryLocalServiceWrapper(
		CreditWalletHistoryLocalService creditWalletHistoryLocalService) {

		_creditWalletHistoryLocalService = creditWalletHistoryLocalService;
	}

	/**
	 * Adds the credit wallet history to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CreditWalletHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param creditWalletHistory the credit wallet history
	 * @return the credit wallet history that was added
	 */
	@Override
	public com.mypage.user.model.CreditWalletHistory addCreditWalletHistory(
		com.mypage.user.model.CreditWalletHistory creditWalletHistory) {

		return _creditWalletHistoryLocalService.addCreditWalletHistory(
			creditWalletHistory);
	}

	@Override
	public com.mypage.user.model.CreditWalletHistory addCreditWalletHistory(
		long mypageUserId, long creditWalletId, long leadsId, String operation,
		double amount, int active) {

		return _creditWalletHistoryLocalService.addCreditWalletHistory(
			mypageUserId, creditWalletId, leadsId, operation, amount, active);
	}

	/**
	 * Creates a new credit wallet history with the primary key. Does not add the credit wallet history to the database.
	 *
	 * @param creditWalletHistoryId the primary key for the new credit wallet history
	 * @return the new credit wallet history
	 */
	@Override
	public com.mypage.user.model.CreditWalletHistory createCreditWalletHistory(
		long creditWalletHistoryId) {

		return _creditWalletHistoryLocalService.createCreditWalletHistory(
			creditWalletHistoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creditWalletHistoryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the credit wallet history from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CreditWalletHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param creditWalletHistory the credit wallet history
	 * @return the credit wallet history that was removed
	 */
	@Override
	public com.mypage.user.model.CreditWalletHistory deleteCreditWalletHistory(
		com.mypage.user.model.CreditWalletHistory creditWalletHistory) {

		return _creditWalletHistoryLocalService.deleteCreditWalletHistory(
			creditWalletHistory);
	}

	/**
	 * Deletes the credit wallet history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CreditWalletHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param creditWalletHistoryId the primary key of the credit wallet history
	 * @return the credit wallet history that was removed
	 * @throws PortalException if a credit wallet history with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.CreditWalletHistory deleteCreditWalletHistory(
			long creditWalletHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creditWalletHistoryLocalService.deleteCreditWalletHistory(
			creditWalletHistoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creditWalletHistoryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _creditWalletHistoryLocalService.dynamicQuery();
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

		return _creditWalletHistoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.CreditWalletHistoryModelImpl</code>.
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

		return _creditWalletHistoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.CreditWalletHistoryModelImpl</code>.
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

		return _creditWalletHistoryLocalService.dynamicQuery(
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

		return _creditWalletHistoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _creditWalletHistoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.user.model.CreditWalletHistory fetchCreditWalletHistory(
		long creditWalletHistoryId) {

		return _creditWalletHistoryLocalService.fetchCreditWalletHistory(
			creditWalletHistoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _creditWalletHistoryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the credit wallet histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @return the range of credit wallet histories
	 */
	@Override
	public java.util.List<com.mypage.user.model.CreditWalletHistory>
		getCreditWalletHistories(int start, int end) {

		return _creditWalletHistoryLocalService.getCreditWalletHistories(
			start, end);
	}

	/**
	 * Returns the number of credit wallet histories.
	 *
	 * @return the number of credit wallet histories
	 */
	@Override
	public int getCreditWalletHistoriesCount() {
		return _creditWalletHistoryLocalService.getCreditWalletHistoriesCount();
	}

	/**
	 * Returns the credit wallet history with the primary key.
	 *
	 * @param creditWalletHistoryId the primary key of the credit wallet history
	 * @return the credit wallet history
	 * @throws PortalException if a credit wallet history with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.CreditWalletHistory getCreditWalletHistory(
			long creditWalletHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creditWalletHistoryLocalService.getCreditWalletHistory(
			creditWalletHistoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _creditWalletHistoryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _creditWalletHistoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creditWalletHistoryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public com.mypage.user.model.CreditWalletHistory setActive(
		long creditWalletHistoryId, int active) {

		return _creditWalletHistoryLocalService.setActive(
			creditWalletHistoryId, active);
	}

	/**
	 * Updates the credit wallet history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CreditWalletHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param creditWalletHistory the credit wallet history
	 * @return the credit wallet history that was updated
	 */
	@Override
	public com.mypage.user.model.CreditWalletHistory updateCreditWalletHistory(
		com.mypage.user.model.CreditWalletHistory creditWalletHistory) {

		return _creditWalletHistoryLocalService.updateCreditWalletHistory(
			creditWalletHistory);
	}

	@Override
	public com.mypage.user.model.CreditWalletHistory updateCreditWalletHistory(
		long creditWalletHistoryId, long mypageUserId, long creditWalletId,
		long leadsId, String operation, double amount, int active) {

		return _creditWalletHistoryLocalService.updateCreditWalletHistory(
			creditWalletHistoryId, mypageUserId, creditWalletId, leadsId,
			operation, amount, active);
	}

	@Override
	public CreditWalletHistoryLocalService getWrappedService() {
		return _creditWalletHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		CreditWalletHistoryLocalService creditWalletHistoryLocalService) {

		_creditWalletHistoryLocalService = creditWalletHistoryLocalService;
	}

	private CreditWalletHistoryLocalService _creditWalletHistoryLocalService;

}