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

import com.mypage.user.model.CreditWalletHistory;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CreditWalletHistory. This utility wraps
 * <code>com.mypage.user.service.impl.CreditWalletHistoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CreditWalletHistoryLocalService
 * @generated
 */
public class CreditWalletHistoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.user.service.impl.CreditWalletHistoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static CreditWalletHistory addCreditWalletHistory(
		CreditWalletHistory creditWalletHistory) {

		return getService().addCreditWalletHistory(creditWalletHistory);
	}

	public static CreditWalletHistory addCreditWalletHistory(
		long mypageUserId, long creditWalletId, long leadsId, String operation,
		double amount, int active) {

		return getService().addCreditWalletHistory(
			mypageUserId, creditWalletId, leadsId, operation, amount, active);
	}

	/**
	 * Creates a new credit wallet history with the primary key. Does not add the credit wallet history to the database.
	 *
	 * @param creditWalletHistoryId the primary key for the new credit wallet history
	 * @return the new credit wallet history
	 */
	public static CreditWalletHistory createCreditWalletHistory(
		long creditWalletHistoryId) {

		return getService().createCreditWalletHistory(creditWalletHistoryId);
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
	 * Deletes the credit wallet history from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CreditWalletHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param creditWalletHistory the credit wallet history
	 * @return the credit wallet history that was removed
	 */
	public static CreditWalletHistory deleteCreditWalletHistory(
		CreditWalletHistory creditWalletHistory) {

		return getService().deleteCreditWalletHistory(creditWalletHistory);
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
	public static CreditWalletHistory deleteCreditWalletHistory(
			long creditWalletHistoryId)
		throws PortalException {

		return getService().deleteCreditWalletHistory(creditWalletHistoryId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.CreditWalletHistoryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.CreditWalletHistoryModelImpl</code>.
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

	public static CreditWalletHistory fetchCreditWalletHistory(
		long creditWalletHistoryId) {

		return getService().fetchCreditWalletHistory(creditWalletHistoryId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	public static List<CreditWalletHistory> getCreditWalletHistories(
		int start, int end) {

		return getService().getCreditWalletHistories(start, end);
	}

	/**
	 * Returns the number of credit wallet histories.
	 *
	 * @return the number of credit wallet histories
	 */
	public static int getCreditWalletHistoriesCount() {
		return getService().getCreditWalletHistoriesCount();
	}

	/**
	 * Returns the credit wallet history with the primary key.
	 *
	 * @param creditWalletHistoryId the primary key of the credit wallet history
	 * @return the credit wallet history
	 * @throws PortalException if a credit wallet history with the primary key could not be found
	 */
	public static CreditWalletHistory getCreditWalletHistory(
			long creditWalletHistoryId)
		throws PortalException {

		return getService().getCreditWalletHistory(creditWalletHistoryId);
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

	public static CreditWalletHistory setActive(
		long creditWalletHistoryId, int active) {

		return getService().setActive(creditWalletHistoryId, active);
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
	public static CreditWalletHistory updateCreditWalletHistory(
		CreditWalletHistory creditWalletHistory) {

		return getService().updateCreditWalletHistory(creditWalletHistory);
	}

	public static CreditWalletHistory updateCreditWalletHistory(
		long creditWalletHistoryId, long mypageUserId, long creditWalletId,
		long leadsId, String operation, double amount, int active) {

		return getService().updateCreditWalletHistory(
			creditWalletHistoryId, mypageUserId, creditWalletId, leadsId,
			operation, amount, active);
	}

	public static CreditWalletHistoryLocalService getService() {
		return _service;
	}

	private static volatile CreditWalletHistoryLocalService _service;

}