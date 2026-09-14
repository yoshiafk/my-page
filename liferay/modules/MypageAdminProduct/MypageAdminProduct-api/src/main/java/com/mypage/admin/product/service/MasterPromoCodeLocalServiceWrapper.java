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
 * Provides a wrapper for {@link MasterPromoCodeLocalService}.
 *
 * @author Gositus Team
 * @see MasterPromoCodeLocalService
 * @generated
 */
public class MasterPromoCodeLocalServiceWrapper
	implements MasterPromoCodeLocalService,
			   ServiceWrapper<MasterPromoCodeLocalService> {

	public MasterPromoCodeLocalServiceWrapper(
		MasterPromoCodeLocalService masterPromoCodeLocalService) {

		_masterPromoCodeLocalService = masterPromoCodeLocalService;
	}

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
	@Override
	public com.mypage.admin.product.model.MasterPromoCode addMasterPromoCode(
		com.mypage.admin.product.model.MasterPromoCode masterPromoCode) {

		return _masterPromoCodeLocalService.addMasterPromoCode(masterPromoCode);
	}

	@Override
	public com.mypage.admin.product.model.MasterPromoCode addPromoCode(
			String productCode, String productName, String promoCode,
			double discount, String startDate, String endDate, String limit,
			String promoCodeTerms, long mypageUserId, String agentCode,
			String agentName, String deptoreCode, double commission, int active)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.text.ParseException {

		return _masterPromoCodeLocalService.addPromoCode(
			productCode, productName, promoCode, discount, startDate, endDate,
			limit, promoCodeTerms, mypageUserId, agentCode, agentName,
			deptoreCode, commission, active);
	}

	@Override
	public int countByPromoCode(long promoCodeId, String promoCode) {
		return _masterPromoCodeLocalService.countByPromoCode(
			promoCodeId, promoCode);
	}

	@Override
	public int countByUserId(long userId) {
		return _masterPromoCodeLocalService.countByUserId(userId);
	}

	/**
	 * Creates a new master promo code with the primary key. Does not add the master promo code to the database.
	 *
	 * @param promoCodeId the primary key for the new master promo code
	 * @return the new master promo code
	 */
	@Override
	public com.mypage.admin.product.model.MasterPromoCode createMasterPromoCode(
		long promoCodeId) {

		return _masterPromoCodeLocalService.createMasterPromoCode(promoCodeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterPromoCodeLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.mypage.admin.product.model.MasterPromoCode deleteMasterPromoCode(
			long promoCodeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterPromoCodeLocalService.deleteMasterPromoCode(promoCodeId);
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
	@Override
	public com.mypage.admin.product.model.MasterPromoCode deleteMasterPromoCode(
		com.mypage.admin.product.model.MasterPromoCode masterPromoCode) {

		return _masterPromoCodeLocalService.deleteMasterPromoCode(
			masterPromoCode);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterPromoCodeLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _masterPromoCodeLocalService.dynamicQuery();
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

		return _masterPromoCodeLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _masterPromoCodeLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _masterPromoCodeLocalService.dynamicQuery(
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

		return _masterPromoCodeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _masterPromoCodeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.MasterPromoCode fetchMasterPromoCode(
		long promoCodeId) {

		return _masterPromoCodeLocalService.fetchMasterPromoCode(promoCodeId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.MasterPromoCode>
		findByFilter(int start, int end, long userId) {

		return _masterPromoCodeLocalService.findByFilter(start, end, userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _masterPromoCodeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _masterPromoCodeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the master promo code with the primary key.
	 *
	 * @param promoCodeId the primary key of the master promo code
	 * @return the master promo code
	 * @throws PortalException if a master promo code with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.MasterPromoCode getMasterPromoCode(
			long promoCodeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterPromoCodeLocalService.getMasterPromoCode(promoCodeId);
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
	@Override
	public java.util.List<com.mypage.admin.product.model.MasterPromoCode>
		getMasterPromoCodes(int start, int end) {

		return _masterPromoCodeLocalService.getMasterPromoCodes(start, end);
	}

	/**
	 * Returns the number of master promo codes.
	 *
	 * @return the number of master promo codes
	 */
	@Override
	public int getMasterPromoCodesCount() {
		return _masterPromoCodeLocalService.getMasterPromoCodesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterPromoCodeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterPromoCodeLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.admin.product.model.MasterPromoCode savePromoCode(
			int isDefault, long promoCodeId, String productCode,
			String productName, String promoType, String promoCode,
			double discount, String startDate, String endDate, String activeDay,
			String limit, String network, String channel, int isB2C,
			int isB2B2C, int isB2B, String payment, String birthdayMonth,
			String remarks, long mypageUserId, String agentName,
			String deptoreCode, String commission, String plan,
			String promoCodeTerms, String travellerType, int active)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.text.ParseException {

		return _masterPromoCodeLocalService.savePromoCode(
			isDefault, promoCodeId, productCode, productName, promoType,
			promoCode, discount, startDate, endDate, activeDay, limit, network,
			channel, isB2C, isB2B2C, isB2B, payment, birthdayMonth, remarks,
			mypageUserId, agentName, deptoreCode, commission, plan,
			promoCodeTerms, travellerType, active);
	}

	@Override
	public com.mypage.admin.product.model.MasterPromoCode setActive(
			long masterPromoCodeId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterPromoCodeLocalService.setActive(
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
	@Override
	public com.mypage.admin.product.model.MasterPromoCode updateMasterPromoCode(
		com.mypage.admin.product.model.MasterPromoCode masterPromoCode) {

		return _masterPromoCodeLocalService.updateMasterPromoCode(
			masterPromoCode);
	}

	@Override
	public com.mypage.admin.product.model.MasterPromoCode updatePromoCode(
			long promoCodeId, String productCode, String productName,
			String promoCode, double discount, String startDate, String endDate,
			String limit, String promoCodeTerms, String remarks,
			long mypageUserId, String agentCode, String agentName,
			String deptoreCode, double commission, int active)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.text.ParseException {

		return _masterPromoCodeLocalService.updatePromoCode(
			promoCodeId, productCode, productName, promoCode, discount,
			startDate, endDate, limit, promoCodeTerms, remarks, mypageUserId,
			agentCode, agentName, deptoreCode, commission, active);
	}

	@Override
	public MasterPromoCodeLocalService getWrappedService() {
		return _masterPromoCodeLocalService;
	}

	@Override
	public void setWrappedService(
		MasterPromoCodeLocalService masterPromoCodeLocalService) {

		_masterPromoCodeLocalService = masterPromoCodeLocalService;
	}

	private MasterPromoCodeLocalService _masterPromoCodeLocalService;

}