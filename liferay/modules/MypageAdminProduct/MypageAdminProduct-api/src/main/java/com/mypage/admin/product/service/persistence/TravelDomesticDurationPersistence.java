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

import com.mypage.admin.product.exception.NoSuchTravelDomesticDurationException;
import com.mypage.admin.product.model.TravelDomesticDuration;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the travel domestic duration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticDurationUtil
 * @generated
 */
@ProviderType
public interface TravelDomesticDurationPersistence
	extends BasePersistence<TravelDomesticDuration> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TravelDomesticDurationUtil} to access the travel domestic duration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the travel domestic durations where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @return the matching travel domestic durations
	 */
	public java.util.List<TravelDomesticDuration> findBysearchDuration(
		long travelDomesticDurationId, String code, int dayFrom, int dayTo,
		String label);

	/**
	 * Returns a range of all the travel domestic durations where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticDurationModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @param start the lower bound of the range of travel domestic durations
	 * @param end the upper bound of the range of travel domestic durations (not inclusive)
	 * @return the range of matching travel domestic durations
	 */
	public java.util.List<TravelDomesticDuration> findBysearchDuration(
		long travelDomesticDurationId, String code, int dayFrom, int dayTo,
		String label, int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic durations where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticDurationModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @param start the lower bound of the range of travel domestic durations
	 * @param end the upper bound of the range of travel domestic durations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic durations
	 */
	public java.util.List<TravelDomesticDuration> findBysearchDuration(
		long travelDomesticDurationId, String code, int dayFrom, int dayTo,
		String label, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticDuration>
			orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic durations where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticDurationModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @param start the lower bound of the range of travel domestic durations
	 * @param end the upper bound of the range of travel domestic durations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic durations
	 */
	public java.util.List<TravelDomesticDuration> findBysearchDuration(
		long travelDomesticDurationId, String code, int dayFrom, int dayTo,
		String label, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticDuration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel domestic duration in the ordered set where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic duration
	 * @throws NoSuchTravelDomesticDurationException if a matching travel domestic duration could not be found
	 */
	public TravelDomesticDuration findBysearchDuration_First(
			long travelDomesticDurationId, String code, int dayFrom, int dayTo,
			String label,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticDuration> orderByComparator)
		throws NoSuchTravelDomesticDurationException;

	/**
	 * Returns the first travel domestic duration in the ordered set where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic duration, or <code>null</code> if a matching travel domestic duration could not be found
	 */
	public TravelDomesticDuration fetchBysearchDuration_First(
		long travelDomesticDurationId, String code, int dayFrom, int dayTo,
		String label,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticDuration>
			orderByComparator);

	/**
	 * Returns the last travel domestic duration in the ordered set where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic duration
	 * @throws NoSuchTravelDomesticDurationException if a matching travel domestic duration could not be found
	 */
	public TravelDomesticDuration findBysearchDuration_Last(
			long travelDomesticDurationId, String code, int dayFrom, int dayTo,
			String label,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticDuration> orderByComparator)
		throws NoSuchTravelDomesticDurationException;

	/**
	 * Returns the last travel domestic duration in the ordered set where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic duration, or <code>null</code> if a matching travel domestic duration could not be found
	 */
	public TravelDomesticDuration fetchBysearchDuration_Last(
		long travelDomesticDurationId, String code, int dayFrom, int dayTo,
		String label,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticDuration>
			orderByComparator);

	/**
	 * Removes all the travel domestic durations where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63; from the database.
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 */
	public void removeBysearchDuration(
		long travelDomesticDurationId, String code, int dayFrom, int dayTo,
		String label);

	/**
	 * Returns the number of travel domestic durations where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @return the number of matching travel domestic durations
	 */
	public int countBysearchDuration(
		long travelDomesticDurationId, String code, int dayFrom, int dayTo,
		String label);

	/**
	 * Caches the travel domestic duration in the entity cache if it is enabled.
	 *
	 * @param travelDomesticDuration the travel domestic duration
	 */
	public void cacheResult(TravelDomesticDuration travelDomesticDuration);

	/**
	 * Caches the travel domestic durations in the entity cache if it is enabled.
	 *
	 * @param travelDomesticDurations the travel domestic durations
	 */
	public void cacheResult(
		java.util.List<TravelDomesticDuration> travelDomesticDurations);

	/**
	 * Creates a new travel domestic duration with the primary key. Does not add the travel domestic duration to the database.
	 *
	 * @param travelDomesticDurationId the primary key for the new travel domestic duration
	 * @return the new travel domestic duration
	 */
	public TravelDomesticDuration create(long travelDomesticDurationId);

	/**
	 * Removes the travel domestic duration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticDurationId the primary key of the travel domestic duration
	 * @return the travel domestic duration that was removed
	 * @throws NoSuchTravelDomesticDurationException if a travel domestic duration with the primary key could not be found
	 */
	public TravelDomesticDuration remove(long travelDomesticDurationId)
		throws NoSuchTravelDomesticDurationException;

	public TravelDomesticDuration updateImpl(
		TravelDomesticDuration travelDomesticDuration);

	/**
	 * Returns the travel domestic duration with the primary key or throws a <code>NoSuchTravelDomesticDurationException</code> if it could not be found.
	 *
	 * @param travelDomesticDurationId the primary key of the travel domestic duration
	 * @return the travel domestic duration
	 * @throws NoSuchTravelDomesticDurationException if a travel domestic duration with the primary key could not be found
	 */
	public TravelDomesticDuration findByPrimaryKey(
			long travelDomesticDurationId)
		throws NoSuchTravelDomesticDurationException;

	/**
	 * Returns the travel domestic duration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticDurationId the primary key of the travel domestic duration
	 * @return the travel domestic duration, or <code>null</code> if a travel domestic duration with the primary key could not be found
	 */
	public TravelDomesticDuration fetchByPrimaryKey(
		long travelDomesticDurationId);

	/**
	 * Returns all the travel domestic durations.
	 *
	 * @return the travel domestic durations
	 */
	public java.util.List<TravelDomesticDuration> findAll();

	/**
	 * Returns a range of all the travel domestic durations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticDurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic durations
	 * @param end the upper bound of the range of travel domestic durations (not inclusive)
	 * @return the range of travel domestic durations
	 */
	public java.util.List<TravelDomesticDuration> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic durations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticDurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic durations
	 * @param end the upper bound of the range of travel domestic durations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic durations
	 */
	public java.util.List<TravelDomesticDuration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticDuration>
			orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic durations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticDurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic durations
	 * @param end the upper bound of the range of travel domestic durations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic durations
	 */
	public java.util.List<TravelDomesticDuration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticDuration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the travel domestic durations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of travel domestic durations.
	 *
	 * @return the number of travel domestic durations
	 */
	public int countAll();

}