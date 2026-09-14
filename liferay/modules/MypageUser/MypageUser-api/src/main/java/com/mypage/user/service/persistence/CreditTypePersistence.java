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

import com.mypage.user.exception.NoSuchCreditTypeException;
import com.mypage.user.model.CreditType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the credit type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CreditTypeUtil
 * @generated
 */
@ProviderType
public interface CreditTypePersistence extends BasePersistence<CreditType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CreditTypeUtil} to access the credit type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the credit type where mypageUserId = &#63; or throws a <code>NoSuchCreditTypeException</code> if it could not be found.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching credit type
	 * @throws NoSuchCreditTypeException if a matching credit type could not be found
	 */
	public CreditType findBygetByMypageUserId(long mypageUserId)
		throws NoSuchCreditTypeException;

	/**
	 * Returns the credit type where mypageUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching credit type, or <code>null</code> if a matching credit type could not be found
	 */
	public CreditType fetchBygetByMypageUserId(long mypageUserId);

	/**
	 * Returns the credit type where mypageUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching credit type, or <code>null</code> if a matching credit type could not be found
	 */
	public CreditType fetchBygetByMypageUserId(
		long mypageUserId, boolean useFinderCache);

	/**
	 * Removes the credit type where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the credit type that was removed
	 */
	public CreditType removeBygetByMypageUserId(long mypageUserId)
		throws NoSuchCreditTypeException;

	/**
	 * Returns the number of credit types where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching credit types
	 */
	public int countBygetByMypageUserId(long mypageUserId);

	/**
	 * Caches the credit type in the entity cache if it is enabled.
	 *
	 * @param creditType the credit type
	 */
	public void cacheResult(CreditType creditType);

	/**
	 * Caches the credit types in the entity cache if it is enabled.
	 *
	 * @param creditTypes the credit types
	 */
	public void cacheResult(java.util.List<CreditType> creditTypes);

	/**
	 * Creates a new credit type with the primary key. Does not add the credit type to the database.
	 *
	 * @param creditTypeId the primary key for the new credit type
	 * @return the new credit type
	 */
	public CreditType create(long creditTypeId);

	/**
	 * Removes the credit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creditTypeId the primary key of the credit type
	 * @return the credit type that was removed
	 * @throws NoSuchCreditTypeException if a credit type with the primary key could not be found
	 */
	public CreditType remove(long creditTypeId)
		throws NoSuchCreditTypeException;

	public CreditType updateImpl(CreditType creditType);

	/**
	 * Returns the credit type with the primary key or throws a <code>NoSuchCreditTypeException</code> if it could not be found.
	 *
	 * @param creditTypeId the primary key of the credit type
	 * @return the credit type
	 * @throws NoSuchCreditTypeException if a credit type with the primary key could not be found
	 */
	public CreditType findByPrimaryKey(long creditTypeId)
		throws NoSuchCreditTypeException;

	/**
	 * Returns the credit type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param creditTypeId the primary key of the credit type
	 * @return the credit type, or <code>null</code> if a credit type with the primary key could not be found
	 */
	public CreditType fetchByPrimaryKey(long creditTypeId);

	/**
	 * Returns all the credit types.
	 *
	 * @return the credit types
	 */
	public java.util.List<CreditType> findAll();

	/**
	 * Returns a range of all the credit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit types
	 * @param end the upper bound of the range of credit types (not inclusive)
	 * @return the range of credit types
	 */
	public java.util.List<CreditType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the credit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit types
	 * @param end the upper bound of the range of credit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of credit types
	 */
	public java.util.List<CreditType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CreditType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the credit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit types
	 * @param end the upper bound of the range of credit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of credit types
	 */
	public java.util.List<CreditType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CreditType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the credit types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of credit types.
	 *
	 * @return the number of credit types
	 */
	public int countAll();

}