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

import com.mypage.user.exception.NoSuchMypageUserLicensesException;
import com.mypage.user.model.MypageUserLicenses;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the mypage user licenses service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserLicensesUtil
 * @generated
 */
@ProviderType
public interface MypageUserLicensesPersistence
	extends BasePersistence<MypageUserLicenses> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MypageUserLicensesUtil} to access the mypage user licenses persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the mypage user licenseses where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching mypage user licenseses
	 */
	public java.util.List<MypageUserLicenses> findBygetByMypageUserId(
		long mypageUserId);

	/**
	 * Returns a range of all the mypage user licenseses where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @return the range of matching mypage user licenseses
	 */
	public java.util.List<MypageUserLicenses> findBygetByMypageUserId(
		long mypageUserId, int start, int end);

	/**
	 * Returns an ordered range of all the mypage user licenseses where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching mypage user licenseses
	 */
	public java.util.List<MypageUserLicenses> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserLicenses>
			orderByComparator);

	/**
	 * Returns an ordered range of all the mypage user licenseses where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching mypage user licenseses
	 */
	public java.util.List<MypageUserLicenses> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserLicenses>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first mypage user licenses in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user licenses
	 * @throws NoSuchMypageUserLicensesException if a matching mypage user licenses could not be found
	 */
	public MypageUserLicenses findBygetByMypageUserId_First(
			long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<MypageUserLicenses>
				orderByComparator)
		throws NoSuchMypageUserLicensesException;

	/**
	 * Returns the first mypage user licenses in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user licenses, or <code>null</code> if a matching mypage user licenses could not be found
	 */
	public MypageUserLicenses fetchBygetByMypageUserId_First(
		long mypageUserId,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserLicenses>
			orderByComparator);

	/**
	 * Returns the last mypage user licenses in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user licenses
	 * @throws NoSuchMypageUserLicensesException if a matching mypage user licenses could not be found
	 */
	public MypageUserLicenses findBygetByMypageUserId_Last(
			long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<MypageUserLicenses>
				orderByComparator)
		throws NoSuchMypageUserLicensesException;

	/**
	 * Returns the last mypage user licenses in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user licenses, or <code>null</code> if a matching mypage user licenses could not be found
	 */
	public MypageUserLicenses fetchBygetByMypageUserId_Last(
		long mypageUserId,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserLicenses>
			orderByComparator);

	/**
	 * Returns the mypage user licenseses before and after the current mypage user licenses in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserLicensesId the primary key of the current mypage user licenses
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next mypage user licenses
	 * @throws NoSuchMypageUserLicensesException if a mypage user licenses with the primary key could not be found
	 */
	public MypageUserLicenses[] findBygetByMypageUserId_PrevAndNext(
			long mypageUserLicensesId, long mypageUserId,
			com.liferay.portal.kernel.util.OrderByComparator<MypageUserLicenses>
				orderByComparator)
		throws NoSuchMypageUserLicensesException;

	/**
	 * Removes all the mypage user licenseses where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	public void removeBygetByMypageUserId(long mypageUserId);

	/**
	 * Returns the number of mypage user licenseses where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching mypage user licenseses
	 */
	public int countBygetByMypageUserId(long mypageUserId);

	/**
	 * Caches the mypage user licenses in the entity cache if it is enabled.
	 *
	 * @param mypageUserLicenses the mypage user licenses
	 */
	public void cacheResult(MypageUserLicenses mypageUserLicenses);

	/**
	 * Caches the mypage user licenseses in the entity cache if it is enabled.
	 *
	 * @param mypageUserLicenseses the mypage user licenseses
	 */
	public void cacheResult(
		java.util.List<MypageUserLicenses> mypageUserLicenseses);

	/**
	 * Creates a new mypage user licenses with the primary key. Does not add the mypage user licenses to the database.
	 *
	 * @param mypageUserLicensesId the primary key for the new mypage user licenses
	 * @return the new mypage user licenses
	 */
	public MypageUserLicenses create(long mypageUserLicensesId);

	/**
	 * Removes the mypage user licenses with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserLicensesId the primary key of the mypage user licenses
	 * @return the mypage user licenses that was removed
	 * @throws NoSuchMypageUserLicensesException if a mypage user licenses with the primary key could not be found
	 */
	public MypageUserLicenses remove(long mypageUserLicensesId)
		throws NoSuchMypageUserLicensesException;

	public MypageUserLicenses updateImpl(MypageUserLicenses mypageUserLicenses);

	/**
	 * Returns the mypage user licenses with the primary key or throws a <code>NoSuchMypageUserLicensesException</code> if it could not be found.
	 *
	 * @param mypageUserLicensesId the primary key of the mypage user licenses
	 * @return the mypage user licenses
	 * @throws NoSuchMypageUserLicensesException if a mypage user licenses with the primary key could not be found
	 */
	public MypageUserLicenses findByPrimaryKey(long mypageUserLicensesId)
		throws NoSuchMypageUserLicensesException;

	/**
	 * Returns the mypage user licenses with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserLicensesId the primary key of the mypage user licenses
	 * @return the mypage user licenses, or <code>null</code> if a mypage user licenses with the primary key could not be found
	 */
	public MypageUserLicenses fetchByPrimaryKey(long mypageUserLicensesId);

	/**
	 * Returns all the mypage user licenseses.
	 *
	 * @return the mypage user licenseses
	 */
	public java.util.List<MypageUserLicenses> findAll();

	/**
	 * Returns a range of all the mypage user licenseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @return the range of mypage user licenseses
	 */
	public java.util.List<MypageUserLicenses> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the mypage user licenseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage user licenseses
	 */
	public java.util.List<MypageUserLicenses> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserLicenses>
			orderByComparator);

	/**
	 * Returns an ordered range of all the mypage user licenseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage user licenseses
	 */
	public java.util.List<MypageUserLicenses> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserLicenses>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the mypage user licenseses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of mypage user licenseses.
	 *
	 * @return the number of mypage user licenseses
	 */
	public int countAll();

}