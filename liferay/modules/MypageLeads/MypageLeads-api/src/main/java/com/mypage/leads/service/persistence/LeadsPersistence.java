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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.leads.exception.NoSuchLeadsException;
import com.mypage.leads.model.Leads;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leads service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see LeadsUtil
 * @generated
 */
@ProviderType
public interface LeadsPersistence extends BasePersistence<Leads> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeadsUtil} to access the leads persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the leads where Token = &#63; or throws a <code>NoSuchLeadsException</code> if it could not be found.
	 *
	 * @param Token the token
	 * @return the matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public Leads findByfindByToken(String Token) throws NoSuchLeadsException;

	/**
	 * Returns the leads where Token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param Token the token
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public Leads fetchByfindByToken(String Token);

	/**
	 * Returns the leads where Token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param Token the token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public Leads fetchByfindByToken(String Token, boolean useFinderCache);

	/**
	 * Removes the leads where Token = &#63; from the database.
	 *
	 * @param Token the token
	 * @return the leads that was removed
	 */
	public Leads removeByfindByToken(String Token) throws NoSuchLeadsException;

	/**
	 * Returns the number of leadses where Token = &#63;.
	 *
	 * @param Token the token
	 * @return the number of matching leadses
	 */
	public int countByfindByToken(String Token);

	/**
	 * Returns the leads where ReferenceNumber = &#63; or throws a <code>NoSuchLeadsException</code> if it could not be found.
	 *
	 * @param ReferenceNumber the reference number
	 * @return the matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public Leads findByfindByReferenceNumber(String ReferenceNumber)
		throws NoSuchLeadsException;

	/**
	 * Returns the leads where ReferenceNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ReferenceNumber the reference number
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public Leads fetchByfindByReferenceNumber(String ReferenceNumber);

	/**
	 * Returns the leads where ReferenceNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ReferenceNumber the reference number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public Leads fetchByfindByReferenceNumber(
		String ReferenceNumber, boolean useFinderCache);

	/**
	 * Removes the leads where ReferenceNumber = &#63; from the database.
	 *
	 * @param ReferenceNumber the reference number
	 * @return the leads that was removed
	 */
	public Leads removeByfindByReferenceNumber(String ReferenceNumber)
		throws NoSuchLeadsException;

	/**
	 * Returns the number of leadses where ReferenceNumber = &#63;.
	 *
	 * @param ReferenceNumber the reference number
	 * @return the number of matching leadses
	 */
	public int countByfindByReferenceNumber(String ReferenceNumber);

	/**
	 * Returns all the leadses where Token = &#63;.
	 *
	 * @param Token the token
	 * @return the matching leadses
	 */
	public java.util.List<Leads> findBysearchByToken(String Token);

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
	public java.util.List<Leads> findBysearchByToken(
		String Token, int start, int end);

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
	public java.util.List<Leads> findBysearchByToken(
		String Token, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Leads>
			orderByComparator);

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
	public java.util.List<Leads> findBysearchByToken(
		String Token, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Leads>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leads in the ordered set where Token = &#63;.
	 *
	 * @param Token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public Leads findBysearchByToken_First(
			String Token,
			com.liferay.portal.kernel.util.OrderByComparator<Leads>
				orderByComparator)
		throws NoSuchLeadsException;

	/**
	 * Returns the first leads in the ordered set where Token = &#63;.
	 *
	 * @param Token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public Leads fetchBysearchByToken_First(
		String Token,
		com.liferay.portal.kernel.util.OrderByComparator<Leads>
			orderByComparator);

	/**
	 * Returns the last leads in the ordered set where Token = &#63;.
	 *
	 * @param Token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public Leads findBysearchByToken_Last(
			String Token,
			com.liferay.portal.kernel.util.OrderByComparator<Leads>
				orderByComparator)
		throws NoSuchLeadsException;

	/**
	 * Returns the last leads in the ordered set where Token = &#63;.
	 *
	 * @param Token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public Leads fetchBysearchByToken_Last(
		String Token,
		com.liferay.portal.kernel.util.OrderByComparator<Leads>
			orderByComparator);

	/**
	 * Returns the leadses before and after the current leads in the ordered set where Token = &#63;.
	 *
	 * @param LeadsId the primary key of the current leads
	 * @param Token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leads
	 * @throws NoSuchLeadsException if a leads with the primary key could not be found
	 */
	public Leads[] findBysearchByToken_PrevAndNext(
			long LeadsId, String Token,
			com.liferay.portal.kernel.util.OrderByComparator<Leads>
				orderByComparator)
		throws NoSuchLeadsException;

	/**
	 * Removes all the leadses where Token = &#63; from the database.
	 *
	 * @param Token the token
	 */
	public void removeBysearchByToken(String Token);

	/**
	 * Returns the number of leadses where Token = &#63;.
	 *
	 * @param Token the token
	 * @return the number of matching leadses
	 */
	public int countBysearchByToken(String Token);

	/**
	 * Returns all the leadses where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @return the matching leadses
	 */
	public java.util.List<Leads> findBysearchByPromoCode(String PromoCode);

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
	public java.util.List<Leads> findBysearchByPromoCode(
		String PromoCode, int start, int end);

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
	public java.util.List<Leads> findBysearchByPromoCode(
		String PromoCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Leads>
			orderByComparator);

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
	public java.util.List<Leads> findBysearchByPromoCode(
		String PromoCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Leads>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leads in the ordered set where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public Leads findBysearchByPromoCode_First(
			String PromoCode,
			com.liferay.portal.kernel.util.OrderByComparator<Leads>
				orderByComparator)
		throws NoSuchLeadsException;

	/**
	 * Returns the first leads in the ordered set where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public Leads fetchBysearchByPromoCode_First(
		String PromoCode,
		com.liferay.portal.kernel.util.OrderByComparator<Leads>
			orderByComparator);

	/**
	 * Returns the last leads in the ordered set where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public Leads findBysearchByPromoCode_Last(
			String PromoCode,
			com.liferay.portal.kernel.util.OrderByComparator<Leads>
				orderByComparator)
		throws NoSuchLeadsException;

	/**
	 * Returns the last leads in the ordered set where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public Leads fetchBysearchByPromoCode_Last(
		String PromoCode,
		com.liferay.portal.kernel.util.OrderByComparator<Leads>
			orderByComparator);

	/**
	 * Returns the leadses before and after the current leads in the ordered set where PromoCode = &#63;.
	 *
	 * @param LeadsId the primary key of the current leads
	 * @param PromoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leads
	 * @throws NoSuchLeadsException if a leads with the primary key could not be found
	 */
	public Leads[] findBysearchByPromoCode_PrevAndNext(
			long LeadsId, String PromoCode,
			com.liferay.portal.kernel.util.OrderByComparator<Leads>
				orderByComparator)
		throws NoSuchLeadsException;

	/**
	 * Removes all the leadses where PromoCode = &#63; from the database.
	 *
	 * @param PromoCode the promo code
	 */
	public void removeBysearchByPromoCode(String PromoCode);

	/**
	 * Returns the number of leadses where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @return the number of matching leadses
	 */
	public int countBysearchByPromoCode(String PromoCode);

	/**
	 * Returns all the leadses where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching leadses
	 */
	public java.util.List<Leads> findByMyPageUserId(long mypageUserId);

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
	public java.util.List<Leads> findByMyPageUserId(
		long mypageUserId, int start, int end);

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
	public java.util.List<Leads> findByMyPageUserId(
		long mypageUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Leads>
			orderByComparator);

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
	public java.util.List<Leads> findByMyPageUserId(
		long mypageUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Leads>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leads in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public Leads findByMyPageUserId_First(
			long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Leads>
				orderByComparator)
		throws NoSuchLeadsException;

	/**
	 * Returns the first leads in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public Leads fetchByMyPageUserId_First(
		long mypageUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Leads>
			orderByComparator);

	/**
	 * Returns the last leads in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public Leads findByMyPageUserId_Last(
			long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Leads>
				orderByComparator)
		throws NoSuchLeadsException;

	/**
	 * Returns the last leads in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public Leads fetchByMyPageUserId_Last(
		long mypageUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Leads>
			orderByComparator);

	/**
	 * Returns the leadses before and after the current leads in the ordered set where mypageUserId = &#63;.
	 *
	 * @param LeadsId the primary key of the current leads
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leads
	 * @throws NoSuchLeadsException if a leads with the primary key could not be found
	 */
	public Leads[] findByMyPageUserId_PrevAndNext(
			long LeadsId, long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Leads>
				orderByComparator)
		throws NoSuchLeadsException;

	/**
	 * Removes all the leadses where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	public void removeByMyPageUserId(long mypageUserId);

	/**
	 * Returns the number of leadses where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching leadses
	 */
	public int countByMyPageUserId(long mypageUserId);

	/**
	 * Returns the leads where LeadsParentId = &#63; or throws a <code>NoSuchLeadsException</code> if it could not be found.
	 *
	 * @param LeadsParentId the leads parent ID
	 * @return the matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public Leads findByfindByLeadsParentId(long LeadsParentId)
		throws NoSuchLeadsException;

	/**
	 * Returns the leads where LeadsParentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsParentId the leads parent ID
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public Leads fetchByfindByLeadsParentId(long LeadsParentId);

	/**
	 * Returns the leads where LeadsParentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsParentId the leads parent ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public Leads fetchByfindByLeadsParentId(
		long LeadsParentId, boolean useFinderCache);

	/**
	 * Removes the leads where LeadsParentId = &#63; from the database.
	 *
	 * @param LeadsParentId the leads parent ID
	 * @return the leads that was removed
	 */
	public Leads removeByfindByLeadsParentId(long LeadsParentId)
		throws NoSuchLeadsException;

	/**
	 * Returns the number of leadses where LeadsParentId = &#63;.
	 *
	 * @param LeadsParentId the leads parent ID
	 * @return the number of matching leadses
	 */
	public int countByfindByLeadsParentId(long LeadsParentId);

	/**
	 * Returns the leads where idPhotoFileEntryId = &#63; or throws a <code>NoSuchLeadsException</code> if it could not be found.
	 *
	 * @param idPhotoFileEntryId the id photo file entry ID
	 * @return the matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	public Leads findByidPhotoFileEntryId(long idPhotoFileEntryId)
		throws NoSuchLeadsException;

	/**
	 * Returns the leads where idPhotoFileEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idPhotoFileEntryId the id photo file entry ID
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public Leads fetchByidPhotoFileEntryId(long idPhotoFileEntryId);

	/**
	 * Returns the leads where idPhotoFileEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idPhotoFileEntryId the id photo file entry ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	public Leads fetchByidPhotoFileEntryId(
		long idPhotoFileEntryId, boolean useFinderCache);

	/**
	 * Removes the leads where idPhotoFileEntryId = &#63; from the database.
	 *
	 * @param idPhotoFileEntryId the id photo file entry ID
	 * @return the leads that was removed
	 */
	public Leads removeByidPhotoFileEntryId(long idPhotoFileEntryId)
		throws NoSuchLeadsException;

	/**
	 * Returns the number of leadses where idPhotoFileEntryId = &#63;.
	 *
	 * @param idPhotoFileEntryId the id photo file entry ID
	 * @return the number of matching leadses
	 */
	public int countByidPhotoFileEntryId(long idPhotoFileEntryId);

	/**
	 * Caches the leads in the entity cache if it is enabled.
	 *
	 * @param leads the leads
	 */
	public void cacheResult(Leads leads);

	/**
	 * Caches the leadses in the entity cache if it is enabled.
	 *
	 * @param leadses the leadses
	 */
	public void cacheResult(java.util.List<Leads> leadses);

	/**
	 * Creates a new leads with the primary key. Does not add the leads to the database.
	 *
	 * @param LeadsId the primary key for the new leads
	 * @return the new leads
	 */
	public Leads create(long LeadsId);

	/**
	 * Removes the leads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param LeadsId the primary key of the leads
	 * @return the leads that was removed
	 * @throws NoSuchLeadsException if a leads with the primary key could not be found
	 */
	public Leads remove(long LeadsId) throws NoSuchLeadsException;

	public Leads updateImpl(Leads leads);

	/**
	 * Returns the leads with the primary key or throws a <code>NoSuchLeadsException</code> if it could not be found.
	 *
	 * @param LeadsId the primary key of the leads
	 * @return the leads
	 * @throws NoSuchLeadsException if a leads with the primary key could not be found
	 */
	public Leads findByPrimaryKey(long LeadsId) throws NoSuchLeadsException;

	/**
	 * Returns the leads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param LeadsId the primary key of the leads
	 * @return the leads, or <code>null</code> if a leads with the primary key could not be found
	 */
	public Leads fetchByPrimaryKey(long LeadsId);

	/**
	 * Returns all the leadses.
	 *
	 * @return the leadses
	 */
	public java.util.List<Leads> findAll();

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
	public java.util.List<Leads> findAll(int start, int end);

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
	public java.util.List<Leads> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Leads>
			orderByComparator);

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
	public java.util.List<Leads> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Leads>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leadses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leadses.
	 *
	 * @return the number of leadses
	 */
	public int countAll();

}