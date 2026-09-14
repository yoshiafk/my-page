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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.user.model.CreditWallet;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CreditWallet. This utility wraps
 * <code>com.mypage.user.service.impl.CreditWalletLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CreditWalletLocalService
 * @generated
 */
public class CreditWalletLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.user.service.impl.CreditWalletLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static CreditWallet addCreditWallet(CreditWallet creditWallet) {
		return getService().addCreditWallet(creditWallet);
	}

	public static CreditWallet addCreditWallet(
		long creditTypeId, java.util.Date dateIssued,
		java.util.Date dateExpired, double amount, int active) {

		return getService().addCreditWallet(
			creditTypeId, dateIssued, dateExpired, amount, active);
	}

	/**
	 * Creates a new credit wallet with the primary key. Does not add the credit wallet to the database.
	 *
	 * @param creditWalletId the primary key for the new credit wallet
	 * @return the new credit wallet
	 */
	public static CreditWallet createCreditWallet(long creditWalletId) {
		return getService().createCreditWallet(creditWalletId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static CreditWallet deleteCreditWallet(CreditWallet creditWallet) {
		return getService().deleteCreditWallet(creditWallet);
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
	public static CreditWallet deleteCreditWallet(long creditWalletId)
		throws PortalException {

		return getService().deleteCreditWallet(creditWalletId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static CreditWallet fetchCreditWallet(long creditWalletId) {
		return getService().fetchCreditWallet(creditWalletId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the credit wallet with the primary key.
	 *
	 * @param creditWalletId the primary key of the credit wallet
	 * @return the credit wallet
	 * @throws PortalException if a credit wallet with the primary key could not be found
	 */
	public static CreditWallet getCreditWallet(long creditWalletId)
		throws PortalException {

		return getService().getCreditWallet(creditWalletId);
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
	public static List<CreditWallet> getCreditWallets(int start, int end) {
		return getService().getCreditWallets(start, end);
	}

	/**
	 * Returns the number of credit wallets.
	 *
	 * @return the number of credit wallets
	 */
	public static int getCreditWalletsCount() {
		return getService().getCreditWalletsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static CreditWallet setActive(long creditWalletId, int active) {
		return getService().setActive(creditWalletId, active);
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
	public static CreditWallet updateCreditWallet(CreditWallet creditWallet) {
		return getService().updateCreditWallet(creditWallet);
	}

	public static CreditWallet updateCreditWallet(
		long creditWalletId, long creditTypeId, java.util.Date dateIssued,
		java.util.Date dateExpired, double amount, int active) {

		return getService().updateCreditWallet(
			creditWalletId, creditTypeId, dateIssued, dateExpired, amount,
			active);
	}

	public static CreditWalletLocalService getService() {
		return _service;
	}

	private static volatile CreditWalletLocalService _service;

}