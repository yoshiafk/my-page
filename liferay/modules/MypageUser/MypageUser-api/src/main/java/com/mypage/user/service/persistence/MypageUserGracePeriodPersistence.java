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

package com.mypage.user.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.user.exception.NoSuchMypageUserGracePeriodException;
import com.mypage.user.model.MypageUserGracePeriod;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the mypage user grace period service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserGracePeriodUtil
 * @generated
 */
@ProviderType
public interface MypageUserGracePeriodPersistence
	extends BasePersistence<MypageUserGracePeriod> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MypageUserGracePeriodUtil} to access the mypage user grace period persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the mypage user grace periods where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching mypage user grace periods
	 */
	public java.util.List<MypageUserGracePeriod> findBygetByMypageUserId(
		long mypageUserId);

	/**
	 * Returns a range of all the mypage user grace periods where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @return the range of matching mypage user grace periods
	 */
	public java.util.List<MypageUserGracePeriod> findBygetByMypageUserId(
		long mypageUserId, int start, int end);

	/**
	 * Returns an ordered range of all the mypage user grace periods where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching mypage user grace periods
	 */
	public java.util.List<MypageUserGracePeriod> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserGracePeriod>
			orderByComparator);

	/**
	 * Returns an ordered range of all the mypage user grace periods where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching mypage user grace periods
	 */
	public java.util.List<MypageUserGracePeriod> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserGracePeriod>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first mypage user grace period in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user grace period
	 * @throws NoSuchMypageUserGracePeriodException if a matching mypage user grace period could not be found
	 */
	public MypageUserGracePeriod findBygetByMypageUserId_First(
			long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<MypageUserGracePeriod> orderByComparator)
		throws NoSuchMypageUserGracePeriodException;

	/**
	 * Returns the first mypage user grace period in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user grace period, or <code>null</code> if a matching mypage user grace period could not be found
	 */
	public MypageUserGracePeriod fetchBygetByMypageUserId_First(
		long mypageUserId,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserGracePeriod>
			orderByComparator);

	/**
	 * Returns the last mypage user grace period in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user grace period
	 * @throws NoSuchMypageUserGracePeriodException if a matching mypage user grace period could not be found
	 */
	public MypageUserGracePeriod findBygetByMypageUserId_Last(
			long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<MypageUserGracePeriod> orderByComparator)
		throws NoSuchMypageUserGracePeriodException;

	/**
	 * Returns the last mypage user grace period in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user grace period, or <code>null</code> if a matching mypage user grace period could not be found
	 */
	public MypageUserGracePeriod fetchBygetByMypageUserId_Last(
		long mypageUserId,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserGracePeriod>
			orderByComparator);

	/**
	 * Returns the mypage user grace periods before and after the current mypage user grace period in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserGracePeriodId the primary key of the current mypage user grace period
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next mypage user grace period
	 * @throws NoSuchMypageUserGracePeriodException if a mypage user grace period with the primary key could not be found
	 */
	public MypageUserGracePeriod[] findBygetByMypageUserId_PrevAndNext(
			long mypageUserGracePeriodId, long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<MypageUserGracePeriod> orderByComparator)
		throws NoSuchMypageUserGracePeriodException;

	/**
	 * Removes all the mypage user grace periods where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	public void removeBygetByMypageUserId(long mypageUserId);

	/**
	 * Returns the number of mypage user grace periods where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching mypage user grace periods
	 */
	public int countBygetByMypageUserId(long mypageUserId);

	/**
	 * Caches the mypage user grace period in the entity cache if it is enabled.
	 *
	 * @param mypageUserGracePeriod the mypage user grace period
	 */
	public void cacheResult(MypageUserGracePeriod mypageUserGracePeriod);

	/**
	 * Caches the mypage user grace periods in the entity cache if it is enabled.
	 *
	 * @param mypageUserGracePeriods the mypage user grace periods
	 */
	public void cacheResult(
		java.util.List<MypageUserGracePeriod> mypageUserGracePeriods);

	/**
	 * Creates a new mypage user grace period with the primary key. Does not add the mypage user grace period to the database.
	 *
	 * @param mypageUserGracePeriodId the primary key for the new mypage user grace period
	 * @return the new mypage user grace period
	 */
	public MypageUserGracePeriod create(long mypageUserGracePeriodId);

	/**
	 * Removes the mypage user grace period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserGracePeriodId the primary key of the mypage user grace period
	 * @return the mypage user grace period that was removed
	 * @throws NoSuchMypageUserGracePeriodException if a mypage user grace period with the primary key could not be found
	 */
	public MypageUserGracePeriod remove(long mypageUserGracePeriodId)
		throws NoSuchMypageUserGracePeriodException;

	public MypageUserGracePeriod updateImpl(
		MypageUserGracePeriod mypageUserGracePeriod);

	/**
	 * Returns the mypage user grace period with the primary key or throws a <code>NoSuchMypageUserGracePeriodException</code> if it could not be found.
	 *
	 * @param mypageUserGracePeriodId the primary key of the mypage user grace period
	 * @return the mypage user grace period
	 * @throws NoSuchMypageUserGracePeriodException if a mypage user grace period with the primary key could not be found
	 */
	public MypageUserGracePeriod findByPrimaryKey(long mypageUserGracePeriodId)
		throws NoSuchMypageUserGracePeriodException;

	/**
	 * Returns the mypage user grace period with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserGracePeriodId the primary key of the mypage user grace period
	 * @return the mypage user grace period, or <code>null</code> if a mypage user grace period with the primary key could not be found
	 */
	public MypageUserGracePeriod fetchByPrimaryKey(
		long mypageUserGracePeriodId);

	/**
	 * Returns all the mypage user grace periods.
	 *
	 * @return the mypage user grace periods
	 */
	public java.util.List<MypageUserGracePeriod> findAll();

	/**
	 * Returns a range of all the mypage user grace periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @return the range of mypage user grace periods
	 */
	public java.util.List<MypageUserGracePeriod> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the mypage user grace periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage user grace periods
	 */
	public java.util.List<MypageUserGracePeriod> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserGracePeriod>
			orderByComparator);

	/**
	 * Returns an ordered range of all the mypage user grace periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage user grace periods
	 */
	public java.util.List<MypageUserGracePeriod> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserGracePeriod>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the mypage user grace periods from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of mypage user grace periods.
	 *
	 * @return the number of mypage user grace periods
	 */
	public int countAll();

}