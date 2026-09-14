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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.MasterPromoCode;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for MasterPromoCode. This utility wraps
 * <code>com.mypage.admin.product.service.impl.MasterPromoCodeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see MasterPromoCodeLocalService
 * @generated
 */
public class MasterPromoCodeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.MasterPromoCodeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the master promo code to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterPromoCodeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterPromoCode the master promo code
	 * @return the master promo code that was added
	 */
	public static MasterPromoCode addMasterPromoCode(
		MasterPromoCode masterPromoCode) {

		return getService().addMasterPromoCode(masterPromoCode);
	}

	public static MasterPromoCode addPromoCode(
			String productCode, String productName, String promoCode,
			double discount, String startDate, String endDate, String limit,
			String promoCodeTerms, long mypageUserId, String agentCode,
			String agentName, String deptoreCode, double commission, int active)
		throws java.text.ParseException, PortalException {

		return getService().addPromoCode(
			productCode, productName, promoCode, discount, startDate, endDate,
			limit, promoCodeTerms, mypageUserId, agentCode, agentName,
			deptoreCode, commission, active);
	}

	public static int countByPromoCode(long promoCodeId, String promoCode) {
		return getService().countByPromoCode(promoCodeId, promoCode);
	}

	public static int countByUserId(long userId) {
		return getService().countByUserId(userId);
	}

	/**
	 * Creates a new master promo code with the primary key. Does not add the master promo code to the database.
	 *
	 * @param promoCodeId the primary key for the new master promo code
	 * @return the new master promo code
	 */
	public static MasterPromoCode createMasterPromoCode(long promoCodeId) {
		return getService().createMasterPromoCode(promoCodeId);
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
	 * Deletes the master promo code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterPromoCodeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param promoCodeId the primary key of the master promo code
	 * @return the master promo code that was removed
	 * @throws PortalException if a master promo code with the primary key could not be found
	 */
	public static MasterPromoCode deleteMasterPromoCode(long promoCodeId)
		throws PortalException {

		return getService().deleteMasterPromoCode(promoCodeId);
	}

	/**
	 * Deletes the master promo code from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterPromoCodeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterPromoCode the master promo code
	 * @return the master promo code that was removed
	 */
	public static MasterPromoCode deleteMasterPromoCode(
		MasterPromoCode masterPromoCode) {

		return getService().deleteMasterPromoCode(masterPromoCode);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterPromoCodeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterPromoCodeModelImpl</code>.
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

	public static MasterPromoCode fetchMasterPromoCode(long promoCodeId) {
		return getService().fetchMasterPromoCode(promoCodeId);
	}

	public static List<MasterPromoCode> findByFilter(
		int start, int end, long userId) {

		return getService().findByFilter(start, end, userId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the master promo code with the primary key.
	 *
	 * @param promoCodeId the primary key of the master promo code
	 * @return the master promo code
	 * @throws PortalException if a master promo code with the primary key could not be found
	 */
	public static MasterPromoCode getMasterPromoCode(long promoCodeId)
		throws PortalException {

		return getService().getMasterPromoCode(promoCodeId);
	}

	/**
	 * Returns a range of all the master promo codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterPromoCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master promo codes
	 * @param end the upper bound of the range of master promo codes (not inclusive)
	 * @return the range of master promo codes
	 */
	public static List<MasterPromoCode> getMasterPromoCodes(
		int start, int end) {

		return getService().getMasterPromoCodes(start, end);
	}

	/**
	 * Returns the number of master promo codes.
	 *
	 * @return the number of master promo codes
	 */
	public static int getMasterPromoCodesCount() {
		return getService().getMasterPromoCodesCount();
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

	public static MasterPromoCode savePromoCode(
			int isDefault, long promoCodeId, String productCode,
			String productName, String promoType, String promoCode,
			double discount, String startDate, String endDate, String activeDay,
			String limit, String network, String channel, int isB2C,
			int isB2B2C, int isB2B, String payment, String birthdayMonth,
			String remarks, long mypageUserId, String agentName,
			String deptoreCode, String commission, String plan,
			String promoCodeTerms, String travellerType, int active)
		throws java.text.ParseException, PortalException {

		return getService().savePromoCode(
			isDefault, promoCodeId, productCode, productName, promoType,
			promoCode, discount, startDate, endDate, activeDay, limit, network,
			channel, isB2C, isB2B2C, isB2B, payment, birthdayMonth, remarks,
			mypageUserId, agentName, deptoreCode, commission, plan,
			promoCodeTerms, travellerType, active);
	}

	public static MasterPromoCode setActive(
			long masterPromoCodeId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			masterPromoCodeId, active, serviceContext);
	}

	/**
	 * Updates the master promo code in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterPromoCodeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterPromoCode the master promo code
	 * @return the master promo code that was updated
	 */
	public static MasterPromoCode updateMasterPromoCode(
		MasterPromoCode masterPromoCode) {

		return getService().updateMasterPromoCode(masterPromoCode);
	}

	public static MasterPromoCode updatePromoCode(
			long promoCodeId, String productCode, String productName,
			String promoCode, double discount, String startDate, String endDate,
			String limit, String promoCodeTerms, String remarks,
			long mypageUserId, String agentCode, String agentName,
			String deptoreCode, double commission, int active)
		throws java.text.ParseException, PortalException {

		return getService().updatePromoCode(
			promoCodeId, productCode, productName, promoCode, discount,
			startDate, endDate, limit, promoCodeTerms, remarks, mypageUserId,
			agentCode, agentName, deptoreCode, commission, active);
	}

	public static MasterPromoCodeLocalService getService() {
		return _service;
	}

	private static volatile MasterPromoCodeLocalService _service;

}