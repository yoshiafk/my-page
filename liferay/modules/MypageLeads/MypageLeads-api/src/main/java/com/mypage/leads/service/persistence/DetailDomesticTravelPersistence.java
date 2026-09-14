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

import com.mypage.leads.exception.NoSuchDetailDomesticTravelException;
import com.mypage.leads.model.DetailDomesticTravel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the detail domestic travel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see DetailDomesticTravelUtil
 * @generated
 */
@ProviderType
public interface DetailDomesticTravelPersistence
	extends BasePersistence<DetailDomesticTravel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DetailDomesticTravelUtil} to access the detail domestic travel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the detail domestic travel where LeadsId = &#63; or throws a <code>NoSuchDetailDomesticTravelException</code> if it could not be found.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail domestic travel
	 * @throws NoSuchDetailDomesticTravelException if a matching detail domestic travel could not be found
	 */
	public DetailDomesticTravel findBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailDomesticTravelException;

	/**
	 * Returns the detail domestic travel where LeadsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail domestic travel, or <code>null</code> if a matching detail domestic travel could not be found
	 */
	public DetailDomesticTravel fetchBysearchByLeadsId(long LeadsId);

	/**
	 * Returns the detail domestic travel where LeadsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching detail domestic travel, or <code>null</code> if a matching detail domestic travel could not be found
	 */
	public DetailDomesticTravel fetchBysearchByLeadsId(
		long LeadsId, boolean useFinderCache);

	/**
	 * Removes the detail domestic travel where LeadsId = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 * @return the detail domestic travel that was removed
	 */
	public DetailDomesticTravel removeBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailDomesticTravelException;

	/**
	 * Returns the number of detail domestic travels where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the number of matching detail domestic travels
	 */
	public int countBysearchByLeadsId(long LeadsId);

	/**
	 * Caches the detail domestic travel in the entity cache if it is enabled.
	 *
	 * @param detailDomesticTravel the detail domestic travel
	 */
	public void cacheResult(DetailDomesticTravel detailDomesticTravel);

	/**
	 * Caches the detail domestic travels in the entity cache if it is enabled.
	 *
	 * @param detailDomesticTravels the detail domestic travels
	 */
	public void cacheResult(
		java.util.List<DetailDomesticTravel> detailDomesticTravels);

	/**
	 * Creates a new detail domestic travel with the primary key. Does not add the detail domestic travel to the database.
	 *
	 * @param detailDomesticTravelId the primary key for the new detail domestic travel
	 * @return the new detail domestic travel
	 */
	public DetailDomesticTravel create(long detailDomesticTravelId);

	/**
	 * Removes the detail domestic travel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param detailDomesticTravelId the primary key of the detail domestic travel
	 * @return the detail domestic travel that was removed
	 * @throws NoSuchDetailDomesticTravelException if a detail domestic travel with the primary key could not be found
	 */
	public DetailDomesticTravel remove(long detailDomesticTravelId)
		throws NoSuchDetailDomesticTravelException;

	public DetailDomesticTravel updateImpl(
		DetailDomesticTravel detailDomesticTravel);

	/**
	 * Returns the detail domestic travel with the primary key or throws a <code>NoSuchDetailDomesticTravelException</code> if it could not be found.
	 *
	 * @param detailDomesticTravelId the primary key of the detail domestic travel
	 * @return the detail domestic travel
	 * @throws NoSuchDetailDomesticTravelException if a detail domestic travel with the primary key could not be found
	 */
	public DetailDomesticTravel findByPrimaryKey(long detailDomesticTravelId)
		throws NoSuchDetailDomesticTravelException;

	/**
	 * Returns the detail domestic travel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param detailDomesticTravelId the primary key of the detail domestic travel
	 * @return the detail domestic travel, or <code>null</code> if a detail domestic travel with the primary key could not be found
	 */
	public DetailDomesticTravel fetchByPrimaryKey(long detailDomesticTravelId);

	/**
	 * Returns all the detail domestic travels.
	 *
	 * @return the detail domestic travels
	 */
	public java.util.List<DetailDomesticTravel> findAll();

	/**
	 * Returns a range of all the detail domestic travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDomesticTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail domestic travels
	 * @param end the upper bound of the range of detail domestic travels (not inclusive)
	 * @return the range of detail domestic travels
	 */
	public java.util.List<DetailDomesticTravel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the detail domestic travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDomesticTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail domestic travels
	 * @param end the upper bound of the range of detail domestic travels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail domestic travels
	 */
	public java.util.List<DetailDomesticTravel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DetailDomesticTravel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the detail domestic travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDomesticTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail domestic travels
	 * @param end the upper bound of the range of detail domestic travels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail domestic travels
	 */
	public java.util.List<DetailDomesticTravel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DetailDomesticTravel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the detail domestic travels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of detail domestic travels.
	 *
	 * @return the number of detail domestic travels
	 */
	public int countAll();

}