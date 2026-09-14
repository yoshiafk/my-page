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

import com.mypage.leads.exception.NoSuchDetailInternationalTravelException;
import com.mypage.leads.model.DetailInternationalTravel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the detail international travel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see DetailInternationalTravelUtil
 * @generated
 */
@ProviderType
public interface DetailInternationalTravelPersistence
	extends BasePersistence<DetailInternationalTravel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DetailInternationalTravelUtil} to access the detail international travel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the detail international travel where LeadsId = &#63; or throws a <code>NoSuchDetailInternationalTravelException</code> if it could not be found.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail international travel
	 * @throws NoSuchDetailInternationalTravelException if a matching detail international travel could not be found
	 */
	public DetailInternationalTravel findBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailInternationalTravelException;

	/**
	 * Returns the detail international travel where LeadsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail international travel, or <code>null</code> if a matching detail international travel could not be found
	 */
	public DetailInternationalTravel fetchBysearchByLeadsId(long LeadsId);

	/**
	 * Returns the detail international travel where LeadsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching detail international travel, or <code>null</code> if a matching detail international travel could not be found
	 */
	public DetailInternationalTravel fetchBysearchByLeadsId(
		long LeadsId, boolean useFinderCache);

	/**
	 * Removes the detail international travel where LeadsId = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 * @return the detail international travel that was removed
	 */
	public DetailInternationalTravel removeBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailInternationalTravelException;

	/**
	 * Returns the number of detail international travels where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the number of matching detail international travels
	 */
	public int countBysearchByLeadsId(long LeadsId);

	/**
	 * Caches the detail international travel in the entity cache if it is enabled.
	 *
	 * @param detailInternationalTravel the detail international travel
	 */
	public void cacheResult(
		DetailInternationalTravel detailInternationalTravel);

	/**
	 * Caches the detail international travels in the entity cache if it is enabled.
	 *
	 * @param detailInternationalTravels the detail international travels
	 */
	public void cacheResult(
		java.util.List<DetailInternationalTravel> detailInternationalTravels);

	/**
	 * Creates a new detail international travel with the primary key. Does not add the detail international travel to the database.
	 *
	 * @param DetailId the primary key for the new detail international travel
	 * @return the new detail international travel
	 */
	public DetailInternationalTravel create(long DetailId);

	/**
	 * Removes the detail international travel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param DetailId the primary key of the detail international travel
	 * @return the detail international travel that was removed
	 * @throws NoSuchDetailInternationalTravelException if a detail international travel with the primary key could not be found
	 */
	public DetailInternationalTravel remove(long DetailId)
		throws NoSuchDetailInternationalTravelException;

	public DetailInternationalTravel updateImpl(
		DetailInternationalTravel detailInternationalTravel);

	/**
	 * Returns the detail international travel with the primary key or throws a <code>NoSuchDetailInternationalTravelException</code> if it could not be found.
	 *
	 * @param DetailId the primary key of the detail international travel
	 * @return the detail international travel
	 * @throws NoSuchDetailInternationalTravelException if a detail international travel with the primary key could not be found
	 */
	public DetailInternationalTravel findByPrimaryKey(long DetailId)
		throws NoSuchDetailInternationalTravelException;

	/**
	 * Returns the detail international travel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param DetailId the primary key of the detail international travel
	 * @return the detail international travel, or <code>null</code> if a detail international travel with the primary key could not be found
	 */
	public DetailInternationalTravel fetchByPrimaryKey(long DetailId);

	/**
	 * Returns all the detail international travels.
	 *
	 * @return the detail international travels
	 */
	public java.util.List<DetailInternationalTravel> findAll();

	/**
	 * Returns a range of all the detail international travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailInternationalTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail international travels
	 * @param end the upper bound of the range of detail international travels (not inclusive)
	 * @return the range of detail international travels
	 */
	public java.util.List<DetailInternationalTravel> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the detail international travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailInternationalTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail international travels
	 * @param end the upper bound of the range of detail international travels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail international travels
	 */
	public java.util.List<DetailInternationalTravel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DetailInternationalTravel> orderByComparator);

	/**
	 * Returns an ordered range of all the detail international travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailInternationalTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail international travels
	 * @param end the upper bound of the range of detail international travels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail international travels
	 */
	public java.util.List<DetailInternationalTravel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DetailInternationalTravel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the detail international travels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of detail international travels.
	 *
	 * @return the number of detail international travels
	 */
	public int countAll();

}