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

import com.mypage.user.exception.NoSuchMypageUserWorkingHourException;
import com.mypage.user.model.MypageUserWorkingHour;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the mypage user working hour service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserWorkingHourUtil
 * @generated
 */
@ProviderType
public interface MypageUserWorkingHourPersistence
	extends BasePersistence<MypageUserWorkingHour> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MypageUserWorkingHourUtil} to access the mypage user working hour persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the mypage user working hours where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching mypage user working hours
	 */
	public java.util.List<MypageUserWorkingHour> findBygetByMypageUserId(
		long mypageUserId);

	/**
	 * Returns a range of all the mypage user working hours where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @return the range of matching mypage user working hours
	 */
	public java.util.List<MypageUserWorkingHour> findBygetByMypageUserId(
		long mypageUserId, int start, int end);

	/**
	 * Returns an ordered range of all the mypage user working hours where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching mypage user working hours
	 */
	public java.util.List<MypageUserWorkingHour> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserWorkingHour>
			orderByComparator);

	/**
	 * Returns an ordered range of all the mypage user working hours where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching mypage user working hours
	 */
	public java.util.List<MypageUserWorkingHour> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserWorkingHour>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first mypage user working hour in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user working hour
	 * @throws NoSuchMypageUserWorkingHourException if a matching mypage user working hour could not be found
	 */
	public MypageUserWorkingHour findBygetByMypageUserId_First(
			long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<MypageUserWorkingHour> orderByComparator)
		throws NoSuchMypageUserWorkingHourException;

	/**
	 * Returns the first mypage user working hour in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user working hour, or <code>null</code> if a matching mypage user working hour could not be found
	 */
	public MypageUserWorkingHour fetchBygetByMypageUserId_First(
		long mypageUserId,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserWorkingHour>
			orderByComparator);

	/**
	 * Returns the last mypage user working hour in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user working hour
	 * @throws NoSuchMypageUserWorkingHourException if a matching mypage user working hour could not be found
	 */
	public MypageUserWorkingHour findBygetByMypageUserId_Last(
			long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<MypageUserWorkingHour> orderByComparator)
		throws NoSuchMypageUserWorkingHourException;

	/**
	 * Returns the last mypage user working hour in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user working hour, or <code>null</code> if a matching mypage user working hour could not be found
	 */
	public MypageUserWorkingHour fetchBygetByMypageUserId_Last(
		long mypageUserId,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserWorkingHour>
			orderByComparator);

	/**
	 * Returns the mypage user working hours before and after the current mypage user working hour in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserWorkingHourId the primary key of the current mypage user working hour
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next mypage user working hour
	 * @throws NoSuchMypageUserWorkingHourException if a mypage user working hour with the primary key could not be found
	 */
	public MypageUserWorkingHour[] findBygetByMypageUserId_PrevAndNext(
			long mypageUserWorkingHourId, long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<MypageUserWorkingHour> orderByComparator)
		throws NoSuchMypageUserWorkingHourException;

	/**
	 * Removes all the mypage user working hours where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	public void removeBygetByMypageUserId(long mypageUserId);

	/**
	 * Returns the number of mypage user working hours where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching mypage user working hours
	 */
	public int countBygetByMypageUserId(long mypageUserId);

	/**
	 * Caches the mypage user working hour in the entity cache if it is enabled.
	 *
	 * @param mypageUserWorkingHour the mypage user working hour
	 */
	public void cacheResult(MypageUserWorkingHour mypageUserWorkingHour);

	/**
	 * Caches the mypage user working hours in the entity cache if it is enabled.
	 *
	 * @param mypageUserWorkingHours the mypage user working hours
	 */
	public void cacheResult(
		java.util.List<MypageUserWorkingHour> mypageUserWorkingHours);

	/**
	 * Creates a new mypage user working hour with the primary key. Does not add the mypage user working hour to the database.
	 *
	 * @param mypageUserWorkingHourId the primary key for the new mypage user working hour
	 * @return the new mypage user working hour
	 */
	public MypageUserWorkingHour create(long mypageUserWorkingHourId);

	/**
	 * Removes the mypage user working hour with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserWorkingHourId the primary key of the mypage user working hour
	 * @return the mypage user working hour that was removed
	 * @throws NoSuchMypageUserWorkingHourException if a mypage user working hour with the primary key could not be found
	 */
	public MypageUserWorkingHour remove(long mypageUserWorkingHourId)
		throws NoSuchMypageUserWorkingHourException;

	public MypageUserWorkingHour updateImpl(
		MypageUserWorkingHour mypageUserWorkingHour);

	/**
	 * Returns the mypage user working hour with the primary key or throws a <code>NoSuchMypageUserWorkingHourException</code> if it could not be found.
	 *
	 * @param mypageUserWorkingHourId the primary key of the mypage user working hour
	 * @return the mypage user working hour
	 * @throws NoSuchMypageUserWorkingHourException if a mypage user working hour with the primary key could not be found
	 */
	public MypageUserWorkingHour findByPrimaryKey(long mypageUserWorkingHourId)
		throws NoSuchMypageUserWorkingHourException;

	/**
	 * Returns the mypage user working hour with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserWorkingHourId the primary key of the mypage user working hour
	 * @return the mypage user working hour, or <code>null</code> if a mypage user working hour with the primary key could not be found
	 */
	public MypageUserWorkingHour fetchByPrimaryKey(
		long mypageUserWorkingHourId);

	/**
	 * Returns all the mypage user working hours.
	 *
	 * @return the mypage user working hours
	 */
	public java.util.List<MypageUserWorkingHour> findAll();

	/**
	 * Returns a range of all the mypage user working hours.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @return the range of mypage user working hours
	 */
	public java.util.List<MypageUserWorkingHour> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the mypage user working hours.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage user working hours
	 */
	public java.util.List<MypageUserWorkingHour> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserWorkingHour>
			orderByComparator);

	/**
	 * Returns an ordered range of all the mypage user working hours.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage user working hours
	 */
	public java.util.List<MypageUserWorkingHour> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserWorkingHour>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the mypage user working hours from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of mypage user working hours.
	 *
	 * @return the number of mypage user working hours
	 */
	public int countAll();

}