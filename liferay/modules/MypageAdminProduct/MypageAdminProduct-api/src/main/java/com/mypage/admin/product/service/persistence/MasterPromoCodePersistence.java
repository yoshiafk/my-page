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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.admin.product.exception.NoSuchMasterPromoCodeException;
import com.mypage.admin.product.model.MasterPromoCode;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the master promo code service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterPromoCodeUtil
 * @generated
 */
@ProviderType
public interface MasterPromoCodePersistence
	extends BasePersistence<MasterPromoCode> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MasterPromoCodeUtil} to access the master promo code persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the master promo codes where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @return the matching master promo codes
	 */
	public java.util.List<MasterPromoCode> findBypromoCode(String promoCode);

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
	public java.util.List<MasterPromoCode> findBypromoCode(
		String promoCode, int start, int end);

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
	public java.util.List<MasterPromoCode> findBypromoCode(
		String promoCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterPromoCode>
			orderByComparator);

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
	public java.util.List<MasterPromoCode> findBypromoCode(
		String promoCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterPromoCode>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first master promo code in the ordered set where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master promo code
	 * @throws NoSuchMasterPromoCodeException if a matching master promo code could not be found
	 */
	public MasterPromoCode findBypromoCode_First(
			String promoCode,
			com.liferay.portal.kernel.util.OrderByComparator<MasterPromoCode>
				orderByComparator)
		throws NoSuchMasterPromoCodeException;

	/**
	 * Returns the first master promo code in the ordered set where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master promo code, or <code>null</code> if a matching master promo code could not be found
	 */
	public MasterPromoCode fetchBypromoCode_First(
		String promoCode,
		com.liferay.portal.kernel.util.OrderByComparator<MasterPromoCode>
			orderByComparator);

	/**
	 * Returns the last master promo code in the ordered set where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master promo code
	 * @throws NoSuchMasterPromoCodeException if a matching master promo code could not be found
	 */
	public MasterPromoCode findBypromoCode_Last(
			String promoCode,
			com.liferay.portal.kernel.util.OrderByComparator<MasterPromoCode>
				orderByComparator)
		throws NoSuchMasterPromoCodeException;

	/**
	 * Returns the last master promo code in the ordered set where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master promo code, or <code>null</code> if a matching master promo code could not be found
	 */
	public MasterPromoCode fetchBypromoCode_Last(
		String promoCode,
		com.liferay.portal.kernel.util.OrderByComparator<MasterPromoCode>
			orderByComparator);

	/**
	 * Returns the master promo codes before and after the current master promo code in the ordered set where promoCode = &#63;.
	 *
	 * @param promoCodeId the primary key of the current master promo code
	 * @param promoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master promo code
	 * @throws NoSuchMasterPromoCodeException if a master promo code with the primary key could not be found
	 */
	public MasterPromoCode[] findBypromoCode_PrevAndNext(
			long promoCodeId, String promoCode,
			com.liferay.portal.kernel.util.OrderByComparator<MasterPromoCode>
				orderByComparator)
		throws NoSuchMasterPromoCodeException;

	/**
	 * Removes all the master promo codes where promoCode = &#63; from the database.
	 *
	 * @param promoCode the promo code
	 */
	public void removeBypromoCode(String promoCode);

	/**
	 * Returns the number of master promo codes where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @return the number of matching master promo codes
	 */
	public int countBypromoCode(String promoCode);

	/**
	 * Returns all the master promo codes where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching master promo codes
	 */
	public java.util.List<MasterPromoCode> findBymypageUserId(
		long mypageUserId);

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
	public java.util.List<MasterPromoCode> findBymypageUserId(
		long mypageUserId, int start, int end);

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
	public java.util.List<MasterPromoCode> findBymypageUserId(
		long mypageUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterPromoCode>
			orderByComparator);

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
	public java.util.List<MasterPromoCode> findBymypageUserId(
		long mypageUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterPromoCode>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first master promo code in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master promo code
	 * @throws NoSuchMasterPromoCodeException if a matching master promo code could not be found
	 */
	public MasterPromoCode findBymypageUserId_First(
			long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<MasterPromoCode>
				orderByComparator)
		throws NoSuchMasterPromoCodeException;

	/**
	 * Returns the first master promo code in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master promo code, or <code>null</code> if a matching master promo code could not be found
	 */
	public MasterPromoCode fetchBymypageUserId_First(
		long mypageUserId,
		com.liferay.portal.kernel.util.OrderByComparator<MasterPromoCode>
			orderByComparator);

	/**
	 * Returns the last master promo code in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master promo code
	 * @throws NoSuchMasterPromoCodeException if a matching master promo code could not be found
	 */
	public MasterPromoCode findBymypageUserId_Last(
			long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<MasterPromoCode>
				orderByComparator)
		throws NoSuchMasterPromoCodeException;

	/**
	 * Returns the last master promo code in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master promo code, or <code>null</code> if a matching master promo code could not be found
	 */
	public MasterPromoCode fetchBymypageUserId_Last(
		long mypageUserId,
		com.liferay.portal.kernel.util.OrderByComparator<MasterPromoCode>
			orderByComparator);

	/**
	 * Returns the master promo codes before and after the current master promo code in the ordered set where mypageUserId = &#63;.
	 *
	 * @param promoCodeId the primary key of the current master promo code
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master promo code
	 * @throws NoSuchMasterPromoCodeException if a master promo code with the primary key could not be found
	 */
	public MasterPromoCode[] findBymypageUserId_PrevAndNext(
			long promoCodeId, long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<MasterPromoCode>
				orderByComparator)
		throws NoSuchMasterPromoCodeException;

	/**
	 * Removes all the master promo codes where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	public void removeBymypageUserId(long mypageUserId);

	/**
	 * Returns the number of master promo codes where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching master promo codes
	 */
	public int countBymypageUserId(long mypageUserId);

	/**
	 * Caches the master promo code in the entity cache if it is enabled.
	 *
	 * @param masterPromoCode the master promo code
	 */
	public void cacheResult(MasterPromoCode masterPromoCode);

	/**
	 * Caches the master promo codes in the entity cache if it is enabled.
	 *
	 * @param masterPromoCodes the master promo codes
	 */
	public void cacheResult(java.util.List<MasterPromoCode> masterPromoCodes);

	/**
	 * Creates a new master promo code with the primary key. Does not add the master promo code to the database.
	 *
	 * @param promoCodeId the primary key for the new master promo code
	 * @return the new master promo code
	 */
	public MasterPromoCode create(long promoCodeId);

	/**
	 * Removes the master promo code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param promoCodeId the primary key of the master promo code
	 * @return the master promo code that was removed
	 * @throws NoSuchMasterPromoCodeException if a master promo code with the primary key could not be found
	 */
	public MasterPromoCode remove(long promoCodeId)
		throws NoSuchMasterPromoCodeException;

	public MasterPromoCode updateImpl(MasterPromoCode masterPromoCode);

	/**
	 * Returns the master promo code with the primary key or throws a <code>NoSuchMasterPromoCodeException</code> if it could not be found.
	 *
	 * @param promoCodeId the primary key of the master promo code
	 * @return the master promo code
	 * @throws NoSuchMasterPromoCodeException if a master promo code with the primary key could not be found
	 */
	public MasterPromoCode findByPrimaryKey(long promoCodeId)
		throws NoSuchMasterPromoCodeException;

	/**
	 * Returns the master promo code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param promoCodeId the primary key of the master promo code
	 * @return the master promo code, or <code>null</code> if a master promo code with the primary key could not be found
	 */
	public MasterPromoCode fetchByPrimaryKey(long promoCodeId);

	/**
	 * Returns all the master promo codes.
	 *
	 * @return the master promo codes
	 */
	public java.util.List<MasterPromoCode> findAll();

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
	public java.util.List<MasterPromoCode> findAll(int start, int end);

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
	public java.util.List<MasterPromoCode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterPromoCode>
			orderByComparator);

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
	public java.util.List<MasterPromoCode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterPromoCode>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the master promo codes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of master promo codes.
	 *
	 * @return the number of master promo codes
	 */
	public int countAll();

}