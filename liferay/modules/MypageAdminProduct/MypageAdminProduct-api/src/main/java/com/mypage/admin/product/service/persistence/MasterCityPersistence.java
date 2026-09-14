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

import com.mypage.admin.product.exception.NoSuchMasterCityException;
import com.mypage.admin.product.model.MasterCity;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the master city service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterCityUtil
 * @generated
 */
@ProviderType
public interface MasterCityPersistence extends BasePersistence<MasterCity> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MasterCityUtil} to access the master city persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the master cities where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching master cities
	 */
	public java.util.List<MasterCity> findByactiveCities(Integer active);

	/**
	 * Returns a range of all the master cities where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @return the range of matching master cities
	 */
	public java.util.List<MasterCity> findByactiveCities(
		Integer active, int start, int end);

	/**
	 * Returns an ordered range of all the master cities where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master cities
	 */
	public java.util.List<MasterCity> findByactiveCities(
		Integer active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master cities where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master cities
	 */
	public java.util.List<MasterCity> findByactiveCities(
		Integer active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first master city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master city
	 * @throws NoSuchMasterCityException if a matching master city could not be found
	 */
	public MasterCity findByactiveCities_First(
			Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterCity>
				orderByComparator)
		throws NoSuchMasterCityException;

	/**
	 * Returns the first master city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master city, or <code>null</code> if a matching master city could not be found
	 */
	public MasterCity fetchByactiveCities_First(
		Integer active,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCity>
			orderByComparator);

	/**
	 * Returns the last master city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master city
	 * @throws NoSuchMasterCityException if a matching master city could not be found
	 */
	public MasterCity findByactiveCities_Last(
			Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterCity>
				orderByComparator)
		throws NoSuchMasterCityException;

	/**
	 * Returns the last master city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master city, or <code>null</code> if a matching master city could not be found
	 */
	public MasterCity fetchByactiveCities_Last(
		Integer active,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCity>
			orderByComparator);

	/**
	 * Returns the master cities before and after the current master city in the ordered set where active = &#63;.
	 *
	 * @param masterCityId the primary key of the current master city
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master city
	 * @throws NoSuchMasterCityException if a master city with the primary key could not be found
	 */
	public MasterCity[] findByactiveCities_PrevAndNext(
			long masterCityId, Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterCity>
				orderByComparator)
		throws NoSuchMasterCityException;

	/**
	 * Removes all the master cities where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeByactiveCities(Integer active);

	/**
	 * Returns the number of master cities where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching master cities
	 */
	public int countByactiveCities(Integer active);

	/**
	 * Returns all the master cities where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @return the matching master cities
	 */
	public java.util.List<MasterCity> findBysearchByProvinceId(long provinceId);

	/**
	 * Returns a range of all the master cities where provinceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param provinceId the province ID
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @return the range of matching master cities
	 */
	public java.util.List<MasterCity> findBysearchByProvinceId(
		long provinceId, int start, int end);

	/**
	 * Returns an ordered range of all the master cities where provinceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param provinceId the province ID
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master cities
	 */
	public java.util.List<MasterCity> findBysearchByProvinceId(
		long provinceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master cities where provinceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param provinceId the province ID
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master cities
	 */
	public java.util.List<MasterCity> findBysearchByProvinceId(
		long provinceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first master city in the ordered set where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master city
	 * @throws NoSuchMasterCityException if a matching master city could not be found
	 */
	public MasterCity findBysearchByProvinceId_First(
			long provinceId,
			com.liferay.portal.kernel.util.OrderByComparator<MasterCity>
				orderByComparator)
		throws NoSuchMasterCityException;

	/**
	 * Returns the first master city in the ordered set where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master city, or <code>null</code> if a matching master city could not be found
	 */
	public MasterCity fetchBysearchByProvinceId_First(
		long provinceId,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCity>
			orderByComparator);

	/**
	 * Returns the last master city in the ordered set where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master city
	 * @throws NoSuchMasterCityException if a matching master city could not be found
	 */
	public MasterCity findBysearchByProvinceId_Last(
			long provinceId,
			com.liferay.portal.kernel.util.OrderByComparator<MasterCity>
				orderByComparator)
		throws NoSuchMasterCityException;

	/**
	 * Returns the last master city in the ordered set where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master city, or <code>null</code> if a matching master city could not be found
	 */
	public MasterCity fetchBysearchByProvinceId_Last(
		long provinceId,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCity>
			orderByComparator);

	/**
	 * Returns the master cities before and after the current master city in the ordered set where provinceId = &#63;.
	 *
	 * @param masterCityId the primary key of the current master city
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master city
	 * @throws NoSuchMasterCityException if a master city with the primary key could not be found
	 */
	public MasterCity[] findBysearchByProvinceId_PrevAndNext(
			long masterCityId, long provinceId,
			com.liferay.portal.kernel.util.OrderByComparator<MasterCity>
				orderByComparator)
		throws NoSuchMasterCityException;

	/**
	 * Removes all the master cities where provinceId = &#63; from the database.
	 *
	 * @param provinceId the province ID
	 */
	public void removeBysearchByProvinceId(long provinceId);

	/**
	 * Returns the number of master cities where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @return the number of matching master cities
	 */
	public int countBysearchByProvinceId(long provinceId);

	/**
	 * Caches the master city in the entity cache if it is enabled.
	 *
	 * @param masterCity the master city
	 */
	public void cacheResult(MasterCity masterCity);

	/**
	 * Caches the master cities in the entity cache if it is enabled.
	 *
	 * @param masterCities the master cities
	 */
	public void cacheResult(java.util.List<MasterCity> masterCities);

	/**
	 * Creates a new master city with the primary key. Does not add the master city to the database.
	 *
	 * @param masterCityId the primary key for the new master city
	 * @return the new master city
	 */
	public MasterCity create(long masterCityId);

	/**
	 * Removes the master city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterCityId the primary key of the master city
	 * @return the master city that was removed
	 * @throws NoSuchMasterCityException if a master city with the primary key could not be found
	 */
	public MasterCity remove(long masterCityId)
		throws NoSuchMasterCityException;

	public MasterCity updateImpl(MasterCity masterCity);

	/**
	 * Returns the master city with the primary key or throws a <code>NoSuchMasterCityException</code> if it could not be found.
	 *
	 * @param masterCityId the primary key of the master city
	 * @return the master city
	 * @throws NoSuchMasterCityException if a master city with the primary key could not be found
	 */
	public MasterCity findByPrimaryKey(long masterCityId)
		throws NoSuchMasterCityException;

	/**
	 * Returns the master city with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterCityId the primary key of the master city
	 * @return the master city, or <code>null</code> if a master city with the primary key could not be found
	 */
	public MasterCity fetchByPrimaryKey(long masterCityId);

	/**
	 * Returns all the master cities.
	 *
	 * @return the master cities
	 */
	public java.util.List<MasterCity> findAll();

	/**
	 * Returns a range of all the master cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @return the range of master cities
	 */
	public java.util.List<MasterCity> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the master cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master cities
	 */
	public java.util.List<MasterCity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master cities
	 */
	public java.util.List<MasterCity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the master cities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of master cities.
	 *
	 * @return the number of master cities
	 */
	public int countAll();

}