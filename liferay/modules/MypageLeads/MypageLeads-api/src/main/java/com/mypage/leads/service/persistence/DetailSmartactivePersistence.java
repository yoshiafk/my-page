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

import com.mypage.leads.exception.NoSuchDetailSmartactiveException;
import com.mypage.leads.model.DetailSmartactive;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the detail smartactive service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see DetailSmartactiveUtil
 * @generated
 */
@ProviderType
public interface DetailSmartactivePersistence
	extends BasePersistence<DetailSmartactive> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DetailSmartactiveUtil} to access the detail smartactive persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the detail smartactive where LeadsId = &#63; or throws a <code>NoSuchDetailSmartactiveException</code> if it could not be found.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail smartactive
	 * @throws NoSuchDetailSmartactiveException if a matching detail smartactive could not be found
	 */
	public DetailSmartactive findBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailSmartactiveException;

	/**
	 * Returns the detail smartactive where LeadsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail smartactive, or <code>null</code> if a matching detail smartactive could not be found
	 */
	public DetailSmartactive fetchBysearchByLeadsId(long LeadsId);

	/**
	 * Returns the detail smartactive where LeadsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching detail smartactive, or <code>null</code> if a matching detail smartactive could not be found
	 */
	public DetailSmartactive fetchBysearchByLeadsId(
		long LeadsId, boolean useFinderCache);

	/**
	 * Removes the detail smartactive where LeadsId = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 * @return the detail smartactive that was removed
	 */
	public DetailSmartactive removeBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailSmartactiveException;

	/**
	 * Returns the number of detail smartactives where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the number of matching detail smartactives
	 */
	public int countBysearchByLeadsId(long LeadsId);

	/**
	 * Caches the detail smartactive in the entity cache if it is enabled.
	 *
	 * @param detailSmartactive the detail smartactive
	 */
	public void cacheResult(DetailSmartactive detailSmartactive);

	/**
	 * Caches the detail smartactives in the entity cache if it is enabled.
	 *
	 * @param detailSmartactives the detail smartactives
	 */
	public void cacheResult(
		java.util.List<DetailSmartactive> detailSmartactives);

	/**
	 * Creates a new detail smartactive with the primary key. Does not add the detail smartactive to the database.
	 *
	 * @param DetailId the primary key for the new detail smartactive
	 * @return the new detail smartactive
	 */
	public DetailSmartactive create(long DetailId);

	/**
	 * Removes the detail smartactive with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param DetailId the primary key of the detail smartactive
	 * @return the detail smartactive that was removed
	 * @throws NoSuchDetailSmartactiveException if a detail smartactive with the primary key could not be found
	 */
	public DetailSmartactive remove(long DetailId)
		throws NoSuchDetailSmartactiveException;

	public DetailSmartactive updateImpl(DetailSmartactive detailSmartactive);

	/**
	 * Returns the detail smartactive with the primary key or throws a <code>NoSuchDetailSmartactiveException</code> if it could not be found.
	 *
	 * @param DetailId the primary key of the detail smartactive
	 * @return the detail smartactive
	 * @throws NoSuchDetailSmartactiveException if a detail smartactive with the primary key could not be found
	 */
	public DetailSmartactive findByPrimaryKey(long DetailId)
		throws NoSuchDetailSmartactiveException;

	/**
	 * Returns the detail smartactive with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param DetailId the primary key of the detail smartactive
	 * @return the detail smartactive, or <code>null</code> if a detail smartactive with the primary key could not be found
	 */
	public DetailSmartactive fetchByPrimaryKey(long DetailId);

	/**
	 * Returns all the detail smartactives.
	 *
	 * @return the detail smartactives
	 */
	public java.util.List<DetailSmartactive> findAll();

	/**
	 * Returns a range of all the detail smartactives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailSmartactiveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail smartactives
	 * @param end the upper bound of the range of detail smartactives (not inclusive)
	 * @return the range of detail smartactives
	 */
	public java.util.List<DetailSmartactive> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the detail smartactives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailSmartactiveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail smartactives
	 * @param end the upper bound of the range of detail smartactives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail smartactives
	 */
	public java.util.List<DetailSmartactive> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DetailSmartactive>
			orderByComparator);

	/**
	 * Returns an ordered range of all the detail smartactives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailSmartactiveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail smartactives
	 * @param end the upper bound of the range of detail smartactives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail smartactives
	 */
	public java.util.List<DetailSmartactive> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DetailSmartactive>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the detail smartactives from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of detail smartactives.
	 *
	 * @return the number of detail smartactives
	 */
	public int countAll();

}