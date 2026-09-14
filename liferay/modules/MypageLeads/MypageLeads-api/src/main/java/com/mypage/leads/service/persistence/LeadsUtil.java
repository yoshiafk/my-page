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

package com.mypage.leads.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.leads.model.Leads;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the leads service. This utility wraps <code>com.mypage.leads.service.persistence.impl.LeadsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see LeadsPersistence
 * @generated
 */
public class LeadsUtil {

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
	public static void clearCache(Leads leads) {
		getPersistence().clearCache(leads);
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
	public static Map<Serializable, Leads> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Leads> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Leads> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Leads> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Leads> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Leads update(Leads leads) {
		return getPersistence().update(leads);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Leads update(Leads leads, ServiceContext serviceContext) {
		return getPersistence().update(leads, serviceContext);
	}

	/**
	 * Returns the leads where Token = &#63; or throws a <code>NoSuchLeadsException</code> if it could not be found.
	 *
	 * @param Token the token
	 * @return the matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public static Leads findByfindByToken(String Token)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().findByfindByToken(Token);
	}

	/**
	 * Returns the leads where Token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param Token the token
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public static Leads fetchByfindByToken(String Token) {
		return getPersistence().fetchByfindByToken(Token);
	}

	/**
	 * Returns the leads where Token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param Token the token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public static Leads fetchByfindByToken(
		String Token, boolean useFinderCache) {

		return getPersistence().fetchByfindByToken(Token, useFinderCache);
	}

	/**
	 * Removes the leads where Token = &#63; from the database.
	 *
	 * @param Token the token
	 * @return the leads that was removed
	 */
	public static Leads removeByfindByToken(String Token)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().removeByfindByToken(Token);
	}

	/**
	 * Returns the number of leadses where Token = &#63;.
	 *
	 * @param Token the token
	 * @return the number of matching leadses
	 */
	public static int countByfindByToken(String Token) {
		return getPersistence().countByfindByToken(Token);
	}

	/**
	 * Returns the leads where ReferenceNumber = &#63; or throws a <code>NoSuchLeadsException</code> if it could not be found.
	 *
	 * @param ReferenceNumber the reference number
	 * @return the matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public static Leads findByfindByReferenceNumber(String ReferenceNumber)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().findByfindByReferenceNumber(ReferenceNumber);
	}

	/**
	 * Returns the leads where ReferenceNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ReferenceNumber the reference number
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public static Leads fetchByfindByReferenceNumber(String ReferenceNumber) {
		return getPersistence().fetchByfindByReferenceNumber(ReferenceNumber);
	}

	/**
	 * Returns the leads where ReferenceNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ReferenceNumber the reference number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public static Leads fetchByfindByReferenceNumber(
		String ReferenceNumber, boolean useFinderCache) {

		return getPersistence().fetchByfindByReferenceNumber(
			ReferenceNumber, useFinderCache);
	}

	/**
	 * Removes the leads where ReferenceNumber = &#63; from the database.
	 *
	 * @param ReferenceNumber the reference number
	 * @return the leads that was removed
	 */
	public static Leads removeByfindByReferenceNumber(String ReferenceNumber)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().removeByfindByReferenceNumber(ReferenceNumber);
	}

	/**
	 * Returns the number of leadses where ReferenceNumber = &#63;.
	 *
	 * @param ReferenceNumber the reference number
	 * @return the number of matching leadses
	 */
	public static int countByfindByReferenceNumber(String ReferenceNumber) {
		return getPersistence().countByfindByReferenceNumber(ReferenceNumber);
	}

	/**
	 * Returns all the leadses where Token = &#63;.
	 *
	 * @param Token the token
	 * @return the matching leadses
	 */
	public static List<Leads> findBysearchByToken(String Token) {
		return getPersistence().findBysearchByToken(Token);
	}

	/**
	 * Returns a range of all the leadses where Token = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param Token the token
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @return the range of matching leadses
	 */
	public static List<Leads> findBysearchByToken(
		String Token, int start, int end) {

		return getPersistence().findBysearchByToken(Token, start, end);
	}

	/**
	 * Returns an ordered range of all the leadses where Token = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param Token the token
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leadses
	 */
	public static List<Leads> findBysearchByToken(
		String Token, int start, int end,
		OrderByComparator<Leads> orderByComparator) {

		return getPersistence().findBysearchByToken(
			Token, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leadses where Token = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param Token the token
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leadses
	 */
	public static List<Leads> findBysearchByToken(
		String Token, int start, int end,
		OrderByComparator<Leads> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBysearchByToken(
			Token, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leads in the ordered set where Token = &#63;.
	 *
	 * @param Token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public static Leads findBysearchByToken_First(
			String Token, OrderByComparator<Leads> orderByComparator)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().findBysearchByToken_First(
			Token, orderByComparator);
	}

	/**
	 * Returns the first leads in the ordered set where Token = &#63;.
	 *
	 * @param Token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public static Leads fetchBysearchByToken_First(
		String Token, OrderByComparator<Leads> orderByComparator) {

		return getPersistence().fetchBysearchByToken_First(
			Token, orderByComparator);
	}

	/**
	 * Returns the last leads in the ordered set where Token = &#63;.
	 *
	 * @param Token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public static Leads findBysearchByToken_Last(
			String Token, OrderByComparator<Leads> orderByComparator)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().findBysearchByToken_Last(
			Token, orderByComparator);
	}

	/**
	 * Returns the last leads in the ordered set where Token = &#63;.
	 *
	 * @param Token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public static Leads fetchBysearchByToken_Last(
		String Token, OrderByComparator<Leads> orderByComparator) {

		return getPersistence().fetchBysearchByToken_Last(
			Token, orderByComparator);
	}

	/**
	 * Returns the leadses before and after the current leads in the ordered set where Token = &#63;.
	 *
	 * @param LeadsId the primary key of the current leads
	 * @param Token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leads
	 * @throws NoSuchLeadsException if a leads with the primary key could not be found
	 */
	public static Leads[] findBysearchByToken_PrevAndNext(
			long LeadsId, String Token,
			OrderByComparator<Leads> orderByComparator)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().findBysearchByToken_PrevAndNext(
			LeadsId, Token, orderByComparator);
	}

	/**
	 * Removes all the leadses where Token = &#63; from the database.
	 *
	 * @param Token the token
	 */
	public static void removeBysearchByToken(String Token) {
		getPersistence().removeBysearchByToken(Token);
	}

	/**
	 * Returns the number of leadses where Token = &#63;.
	 *
	 * @param Token the token
	 * @return the number of matching leadses
	 */
	public static int countBysearchByToken(String Token) {
		return getPersistence().countBysearchByToken(Token);
	}

	/**
	 * Returns all the leadses where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @return the matching leadses
	 */
	public static List<Leads> findBysearchByPromoCode(String PromoCode) {
		return getPersistence().findBysearchByPromoCode(PromoCode);
	}

	/**
	 * Returns a range of all the leadses where PromoCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param PromoCode the promo code
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @return the range of matching leadses
	 */
	public static List<Leads> findBysearchByPromoCode(
		String PromoCode, int start, int end) {

		return getPersistence().findBysearchByPromoCode(PromoCode, start, end);
	}

	/**
	 * Returns an ordered range of all the leadses where PromoCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param PromoCode the promo code
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leadses
	 */
	public static List<Leads> findBysearchByPromoCode(
		String PromoCode, int start, int end,
		OrderByComparator<Leads> orderByComparator) {

		return getPersistence().findBysearchByPromoCode(
			PromoCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leadses where PromoCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param PromoCode the promo code
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leadses
	 */
	public static List<Leads> findBysearchByPromoCode(
		String PromoCode, int start, int end,
		OrderByComparator<Leads> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBysearchByPromoCode(
			PromoCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leads in the ordered set where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public static Leads findBysearchByPromoCode_First(
			String PromoCode, OrderByComparator<Leads> orderByComparator)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().findBysearchByPromoCode_First(
			PromoCode, orderByComparator);
	}

	/**
	 * Returns the first leads in the ordered set where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public static Leads fetchBysearchByPromoCode_First(
		String PromoCode, OrderByComparator<Leads> orderByComparator) {

		return getPersistence().fetchBysearchByPromoCode_First(
			PromoCode, orderByComparator);
	}

	/**
	 * Returns the last leads in the ordered set where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public static Leads findBysearchByPromoCode_Last(
			String PromoCode, OrderByComparator<Leads> orderByComparator)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().findBysearchByPromoCode_Last(
			PromoCode, orderByComparator);
	}

	/**
	 * Returns the last leads in the ordered set where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public static Leads fetchBysearchByPromoCode_Last(
		String PromoCode, OrderByComparator<Leads> orderByComparator) {

		return getPersistence().fetchBysearchByPromoCode_Last(
			PromoCode, orderByComparator);
	}

	/**
	 * Returns the leadses before and after the current leads in the ordered set where PromoCode = &#63;.
	 *
	 * @param LeadsId the primary key of the current leads
	 * @param PromoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leads
	 * @throws NoSuchLeadsException if a leads with the primary key could not be found
	 */
	public static Leads[] findBysearchByPromoCode_PrevAndNext(
			long LeadsId, String PromoCode,
			OrderByComparator<Leads> orderByComparator)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().findBysearchByPromoCode_PrevAndNext(
			LeadsId, PromoCode, orderByComparator);
	}

	/**
	 * Removes all the leadses where PromoCode = &#63; from the database.
	 *
	 * @param PromoCode the promo code
	 */
	public static void removeBysearchByPromoCode(String PromoCode) {
		getPersistence().removeBysearchByPromoCode(PromoCode);
	}

	/**
	 * Returns the number of leadses where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @return the number of matching leadses
	 */
	public static int countBysearchByPromoCode(String PromoCode) {
		return getPersistence().countBysearchByPromoCode(PromoCode);
	}

	/**
	 * Returns all the leadses where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching leadses
	 */
	public static List<Leads> findByMyPageUserId(long mypageUserId) {
		return getPersistence().findByMyPageUserId(mypageUserId);
	}

	/**
	 * Returns a range of all the leadses where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @return the range of matching leadses
	 */
	public static List<Leads> findByMyPageUserId(
		long mypageUserId, int start, int end) {

		return getPersistence().findByMyPageUserId(mypageUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the leadses where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leadses
	 */
	public static List<Leads> findByMyPageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<Leads> orderByComparator) {

		return getPersistence().findByMyPageUserId(
			mypageUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leadses where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leadses
	 */
	public static List<Leads> findByMyPageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<Leads> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByMyPageUserId(
			mypageUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leads in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public static Leads findByMyPageUserId_First(
			long mypageUserId, OrderByComparator<Leads> orderByComparator)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().findByMyPageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the first leads in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public static Leads fetchByMyPageUserId_First(
		long mypageUserId, OrderByComparator<Leads> orderByComparator) {

		return getPersistence().fetchByMyPageUserId_First(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last leads in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public static Leads findByMyPageUserId_Last(
			long mypageUserId, OrderByComparator<Leads> orderByComparator)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().findByMyPageUserId_Last(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the last leads in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public static Leads fetchByMyPageUserId_Last(
		long mypageUserId, OrderByComparator<Leads> orderByComparator) {

		return getPersistence().fetchByMyPageUserId_Last(
			mypageUserId, orderByComparator);
	}

	/**
	 * Returns the leadses before and after the current leads in the ordered set where mypageUserId = &#63;.
	 *
	 * @param LeadsId the primary key of the current leads
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leads
	 * @throws NoSuchLeadsException if a leads with the primary key could not be found
	 */
	public static Leads[] findByMyPageUserId_PrevAndNext(
			long LeadsId, long mypageUserId,
			OrderByComparator<Leads> orderByComparator)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().findByMyPageUserId_PrevAndNext(
			LeadsId, mypageUserId, orderByComparator);
	}

	/**
	 * Removes all the leadses where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	public static void removeByMyPageUserId(long mypageUserId) {
		getPersistence().removeByMyPageUserId(mypageUserId);
	}

	/**
	 * Returns the number of leadses where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching leadses
	 */
	public static int countByMyPageUserId(long mypageUserId) {
		return getPersistence().countByMyPageUserId(mypageUserId);
	}

	/**
	 * Returns the leads where LeadsParentId = &#63; or throws a <code>NoSuchLeadsException</code> if it could not be found.
	 *
	 * @param LeadsParentId the leads parent ID
	 * @return the matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public static Leads findByfindByLeadsParentId(long LeadsParentId)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().findByfindByLeadsParentId(LeadsParentId);
	}

	/**
	 * Returns the leads where LeadsParentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsParentId the leads parent ID
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public static Leads fetchByfindByLeadsParentId(long LeadsParentId) {
		return getPersistence().fetchByfindByLeadsParentId(LeadsParentId);
	}

	/**
	 * Returns the leads where LeadsParentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsParentId the leads parent ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public static Leads fetchByfindByLeadsParentId(
		long LeadsParentId, boolean useFinderCache) {

		return getPersistence().fetchByfindByLeadsParentId(
			LeadsParentId, useFinderCache);
	}

	/**
	 * Removes the leads where LeadsParentId = &#63; from the database.
	 *
	 * @param LeadsParentId the leads parent ID
	 * @return the leads that was removed
	 */
	public static Leads removeByfindByLeadsParentId(long LeadsParentId)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().removeByfindByLeadsParentId(LeadsParentId);
	}

	/**
	 * Returns the number of leadses where LeadsParentId = &#63;.
	 *
	 * @param LeadsParentId the leads parent ID
	 * @return the number of matching leadses
	 */
	public static int countByfindByLeadsParentId(long LeadsParentId) {
		return getPersistence().countByfindByLeadsParentId(LeadsParentId);
	}

	/**
	 * Returns the leads where idPhotoFileEntryId = &#63; or throws a <code>NoSuchLeadsException</code> if it could not be found.
	 *
	 * @param idPhotoFileEntryId the id photo file entry ID
	 * @return the matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public static Leads findByidPhotoFileEntryId(long idPhotoFileEntryId)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().findByidPhotoFileEntryId(idPhotoFileEntryId);
	}

	/**
	 * Returns the leads where idPhotoFileEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idPhotoFileEntryId the id photo file entry ID
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public static Leads fetchByidPhotoFileEntryId(long idPhotoFileEntryId) {
		return getPersistence().fetchByidPhotoFileEntryId(idPhotoFileEntryId);
	}

	/**
	 * Returns the leads where idPhotoFileEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idPhotoFileEntryId the id photo file entry ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public static Leads fetchByidPhotoFileEntryId(
		long idPhotoFileEntryId, boolean useFinderCache) {

		return getPersistence().fetchByidPhotoFileEntryId(
			idPhotoFileEntryId, useFinderCache);
	}

	/**
	 * Removes the leads where idPhotoFileEntryId = &#63; from the database.
	 *
	 * @param idPhotoFileEntryId the id photo file entry ID
	 * @return the leads that was removed
	 */
	public static Leads removeByidPhotoFileEntryId(long idPhotoFileEntryId)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().removeByidPhotoFileEntryId(idPhotoFileEntryId);
	}

	/**
	 * Returns the number of leadses where idPhotoFileEntryId = &#63;.
	 *
	 * @param idPhotoFileEntryId the id photo file entry ID
	 * @return the number of matching leadses
	 */
	public static int countByidPhotoFileEntryId(long idPhotoFileEntryId) {
		return getPersistence().countByidPhotoFileEntryId(idPhotoFileEntryId);
	}

	/**
	 * Caches the leads in the entity cache if it is enabled.
	 *
	 * @param leads the leads
	 */
	public static void cacheResult(Leads leads) {
		getPersistence().cacheResult(leads);
	}

	/**
	 * Caches the leadses in the entity cache if it is enabled.
	 *
	 * @param leadses the leadses
	 */
	public static void cacheResult(List<Leads> leadses) {
		getPersistence().cacheResult(leadses);
	}

	/**
	 * Creates a new leads with the primary key. Does not add the leads to the database.
	 *
	 * @param LeadsId the primary key for the new leads
	 * @return the new leads
	 */
	public static Leads create(long LeadsId) {
		return getPersistence().create(LeadsId);
	}

	/**
	 * Removes the leads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param LeadsId the primary key of the leads
	 * @return the leads that was removed
	 * @throws NoSuchLeadsException if a leads with the primary key could not be found
	 */
	public static Leads remove(long LeadsId)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().remove(LeadsId);
	}

	public static Leads updateImpl(Leads leads) {
		return getPersistence().updateImpl(leads);
	}

	/**
	 * Returns the leads with the primary key or throws a <code>NoSuchLeadsException</code> if it could not be found.
	 *
	 * @param LeadsId the primary key of the leads
	 * @return the leads
	 * @throws NoSuchLeadsException if a leads with the primary key could not be found
	 */
	public static Leads findByPrimaryKey(long LeadsId)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getPersistence().findByPrimaryKey(LeadsId);
	}

	/**
	 * Returns the leads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param LeadsId the primary key of the leads
	 * @return the leads, or <code>null</code> if a leads with the primary key could not be found
	 */
	public static Leads fetchByPrimaryKey(long LeadsId) {
		return getPersistence().fetchByPrimaryKey(LeadsId);
	}

	/**
	 * Returns all the leadses.
	 *
	 * @return the leadses
	 */
	public static List<Leads> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the leadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @return the range of leadses
	 */
	public static List<Leads> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the leadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leadses
	 */
	public static List<Leads> findAll(
		int start, int end, OrderByComparator<Leads> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leadses
	 */
	public static List<Leads> findAll(
		int start, int end, OrderByComparator<Leads> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the leadses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of leadses.
	 *
	 * @return the number of leadses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LeadsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile LeadsPersistence _persistence;

}