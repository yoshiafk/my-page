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

package com.mypage.admin.product.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.MasterPromoCode;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the master promo code service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.MasterPromoCodePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterPromoCodePersistence
 * @generated
 */
public class MasterPromoCodeUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(MasterPromoCode masterPromoCode) {
		getPersistence().clearCache(masterPromoCode);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, MasterPromoCode> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MasterPromoCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MasterPromoCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MasterPromoCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MasterPromoCode> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MasterPromoCode update(MasterPromoCode masterPromoCode) {
		return getPersistence().update(masterPromoCode);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MasterPromoCode update(
		MasterPromoCode masterPromoCode, ServiceContext serviceContext) {

		return getPersistence().update(masterPromoCode, serviceContext);
	}

	/**
	 * Returns all the master promo codes where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @return the matching master promo codes
	 */
	public static List<MasterPromoCode> findBypromoCode(String promoCode) {
		return getPersistence().findBypromoCode(promoCode);
	}

	/**
	 * Returns a range of all the master promo codes where promoCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterPromoCodeModelImpl</code>.
	 * </p>
	 *
	 * @param promoCode the promo code
	 * @param start the lower bound of the range of master promo codes
	 * @param end the upper bound of the range of master promo codes (not inclusive)
	 * @return the range of matching master promo codes
	 */
	public static List<MasterPromoCode> findBypromoCode(
		String promoCode, int start, int end) {

		return getPersistence().findBypromoCode(promoCode, start, end);
	}

	/**
	 * Returns an ordered range of all the master promo codes where promoCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterPromoCodeModelImpl</code>.
	 * </p>
	 *
	 * @param promoCode the promo code
	 * @param start the lower bound of the range of master promo codes
	 * @param end the upper bound of the range of master promo codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master promo codes
	 */
	public static List<MasterPromoCode> findBypromoCode(
		String promoCode, int start, int end,
		OrderByComparator<MasterPromoCode> orderByComparator) {

		return getPersistence().findBypromoCode(
			promoCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master promo codes where promoCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterPromoCodeModelImpl</code>.
	 * </p>
	 *
	 * @param promoCode the promo code
	 * @param start the lower bound of the range of master promo codes
	 * @param end the upper bound of the range of master promo codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master promo codes
	 */
	public static List<MasterPromoCode> findBypromoCode(
		String promoCode, int start, int end,
		OrderByComparator<MasterPromoCode> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBypromoCode(
			promoCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first master promo code in the ordered set where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master promo code
	 * @throws NoSuchMasterPromoCodeException if a matching master promo code could not be found
	 */
	public static MasterPromoCode findBypromoCode_First(
			String promoCode,
			OrderByComparator<MasterPromoCode> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterPromoCodeException {

		return getPersistence().findBypromoCode_First(
			promoCode, orderByComparator);
	}

	/**
	 * Returns the first master promo code in the ordered set where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master promo code, or <code>null</code> if a matching master promo code could not be found
	 */
	public static MasterPromoCode fetchBypromoCode_First(
		String promoCode,
		OrderByComparator<MasterPromoCode> orderByComparator) {

		return getPersistence().fetchBypromoCode_First(
			promoCode, orderByComparator);
	}

	/**
	 * Returns the last master promo code in the ordered set where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master promo code
	 * @throws NoSuchMasterPromoCodeException if a matching master promo code could not be found
	 */
	public static MasterPromoCode findBypromoCode_Last(
			String promoCode,
			OrderByComparator<MasterPromoCode> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterPromoCodeException {

		return getPersistence().findBypromoCode_Last(
			promoCode, orderByComparator);
	}

	/**
	 * Returns the last master promo code in the ordered set where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master promo code, or <code>null</code> if a matching master promo code could not be found
	 */
	public static MasterPromoCode fetchBypromoCode_Last(
		String promoCode,
		OrderByComparator<MasterPromoCode> orderByComparator) {

		return getPersistence().fetchBypromoCode_Last(
			promoCode, orderByComparator);
	}

	/**
	 * Returns the master promo codes before and after the current master promo code in the ordered set where promoCode = &#63;.
	 *
	 * @param promoCodeId the primary key of the current master promo code
	 * @param promoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master promo code
	 * @throws NoSuchMasterPromoCodeException if a master promo code with the primary key could not be found
	 */
	public static MasterPromoCode[] findBypromoCode_PrevAndNext(
			long promoCodeId, String promoCode,
			OrderByComparator<MasterPromoCode> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterPromoCodeException {

		return getPersistence().findBypromoCode_PrevAndNext(
			promoCodeId, promoCode, orderByComparator);
	}

	/**
	 * Removes all the master promo codes where promoCode = &#63; from the database.
	 *
	 * @param promoCode the promo code
	 */
	public static void removeBypromoCode(String promoCode) {
		getPersistence().removeBypromoCode(promoCode);
	}

	/**
	 * Returns the number of master promo codes where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @return the number of matching master promo codes
	 */
	public static int countBypromoCode(String promoCode) {
		return getPersistence().countBypromoCode(promoCode);
	}

	/**
	 * Returns all the master promo codes where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching master promo codes
	 */
	public static List<MasterPromoCode> findBymypageUserId(long mypageUserId) {
		return getPersistence().findBymypageUserId(mypageUserId);
	}

	/**
	 * Returns a range of all the master promo codes where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterPromoCodeModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of master promo codes
	 * @param end the upper bound of the range of master promo codes (not inclusive)
	 * @return the range of matching master promo codes
	 */
	public static List<MasterPromoCode> findBymypageUserId(
		long mypageUserId, int start, int end) {

		return getPersistence().findBymypageUserId(mypageUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the master promo codes where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterPromoCodeModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of master promo codes
	 * @param end the upper bound of the range of master promo codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master promo codes
	 */
	public static List<MasterPromoCode> findBymypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MasterPromoCode> orderByComparator) {

		return getPersistence().findBymypageUserId(
			mypageUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master promo codes where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterPromoCodeModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of master promo codes
	 * @param end the upper bound of the range of master promo codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master promo codes
	 */
	public static List<MasterPromoCode> findBymypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MasterPromoCode> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBymypageUserId(
			mypageUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first master promo code in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master promo code
	 * @throws NoSuchMasterPromoCodeException if a matching master promo code could not be found
	 */
	public static MasterPromoCode findBymypageUserId_First(
			long mypageUserId,
			OrderByComparator<MasterPromoCode> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterPromoCodeException {

		return getPersistence().findBymypageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the first master promo code in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master promo code, or <code>null</code> if a matching master promo code could not be found
	 */
	public static MasterPromoCode fetchBymypageUserId_First(
		long mypageUserId,
		OrderByComparator<MasterPromoCode> orderByComparator) {

		return getPersistence().fetchBymypageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last master promo code in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master promo code
	 * @throws NoSuchMasterPromoCodeException if a matching master promo code could not be found
	 */
	public static MasterPromoCode findBymypageUserId_Last(
			long mypageUserId,
			OrderByComparator<MasterPromoCode> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterPromoCodeException {

		return getPersistence().findBymypageUserId_Last(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last master promo code in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master promo code, or <code>null</code> if a matching master promo code could not be found
	 */
	public static MasterPromoCode fetchBymypageUserId_Last(
		long mypageUserId,
		OrderByComparator<MasterPromoCode> orderByComparator) {

		return getPersistence().fetchBymypageUserId_Last(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the master promo codes before and after the current master promo code in the ordered set where mypageUserId = &#63;.
	 *
	 * @param promoCodeId the primary key of the current master promo code
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master promo code
	 * @throws NoSuchMasterPromoCodeException if a master promo code with the primary key could not be found
	 */
	public static MasterPromoCode[] findBymypageUserId_PrevAndNext(
			long promoCodeId, long mypageUserId,
			OrderByComparator<MasterPromoCode> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterPromoCodeException {

		return getPersistence().findBymypageUserId_PrevAndNext(
			promoCodeId, mypageUserId, orderByComparator);
	}

	/**
	 * Removes all the master promo codes where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	public static void removeBymypageUserId(long mypageUserId) {
		getPersistence().removeBymypageUserId(mypageUserId);
	}

	/**
	 * Returns the number of master promo codes where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching master promo codes
	 */
	public static int countBymypageUserId(long mypageUserId) {
		return getPersistence().countBymypageUserId(mypageUserId);
	}

	/**
	 * Caches the master promo code in the entity cache if it is enabled.
	 *
	 * @param masterPromoCode the master promo code
	 */
	public static void cacheResult(MasterPromoCode masterPromoCode) {
		getPersistence().cacheResult(masterPromoCode);
	}

	/**
	 * Caches the master promo codes in the entity cache if it is enabled.
	 *
	 * @param masterPromoCodes the master promo codes
	 */
	public static void cacheResult(List<MasterPromoCode> masterPromoCodes) {
		getPersistence().cacheResult(masterPromoCodes);
	}

	/**
	 * Creates a new master promo code with the primary key. Does not add the master promo code to the database.
	 *
	 * @param promoCodeId the primary key for the new master promo code
	 * @return the new master promo code
	 */
	public static MasterPromoCode create(long promoCodeId) {
		return getPersistence().create(promoCodeId);
	}

	/**
	 * Removes the master promo code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param promoCodeId the primary key of the master promo code
	 * @return the master promo code that was removed
	 * @throws NoSuchMasterPromoCodeException if a master promo code with the primary key could not be found
	 */
	public static MasterPromoCode remove(long promoCodeId)
		throws com.mypage.admin.product.exception.
			NoSuchMasterPromoCodeException {

		return getPersistence().remove(promoCodeId);
	}

	public static MasterPromoCode updateImpl(MasterPromoCode masterPromoCode) {
		return getPersistence().updateImpl(masterPromoCode);
	}

	/**
	 * Returns the master promo code with the primary key or throws a <code>NoSuchMasterPromoCodeException</code> if it could not be found.
	 *
	 * @param promoCodeId the primary key of the master promo code
	 * @return the master promo code
	 * @throws NoSuchMasterPromoCodeException if a master promo code with the primary key could not be found
	 */
	public static MasterPromoCode findByPrimaryKey(long promoCodeId)
		throws com.mypage.admin.product.exception.
			NoSuchMasterPromoCodeException {

		return getPersistence().findByPrimaryKey(promoCodeId);
	}

	/**
	 * Returns the master promo code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param promoCodeId the primary key of the master promo code
	 * @return the master promo code, or <code>null</code> if a master promo code with the primary key could not be found
	 */
	public static MasterPromoCode fetchByPrimaryKey(long promoCodeId) {
		return getPersistence().fetchByPrimaryKey(promoCodeId);
	}

	/**
	 * Returns all the master promo codes.
	 *
	 * @return the master promo codes
	 */
	public static List<MasterPromoCode> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the master promo codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterPromoCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master promo codes
	 * @param end the upper bound of the range of master promo codes (not inclusive)
	 * @return the range of master promo codes
	 */
	public static List<MasterPromoCode> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the master promo codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterPromoCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master promo codes
	 * @param end the upper bound of the range of master promo codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master promo codes
	 */
	public static List<MasterPromoCode> findAll(
		int start, int end,
		OrderByComparator<MasterPromoCode> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master promo codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterPromoCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master promo codes
	 * @param end the upper bound of the range of master promo codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master promo codes
	 */
	public static List<MasterPromoCode> findAll(
		int start, int end,
		OrderByComparator<MasterPromoCode> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the master promo codes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of master promo codes.
	 *
	 * @return the number of master promo codes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MasterPromoCodePersistence getPersistence() {
		return _persistence;
	}

	private static volatile MasterPromoCodePersistence _persistence;

}