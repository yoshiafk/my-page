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

import com.mypage.admin.product.exception.NoSuchMasterCountryException;
import com.mypage.admin.product.model.MasterCountry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the master country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterCountryUtil
 * @generated
 */
@ProviderType
public interface MasterCountryPersistence
	extends BasePersistence<MasterCountry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MasterCountryUtil} to access the master country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the master countries where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching master countries
	 */
	public java.util.List<MasterCountry> findBycountryName(String name);

	/**
	 * Returns a range of all the master countries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @return the range of matching master countries
	 */
	public java.util.List<MasterCountry> findBycountryName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the master countries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master countries
	 */
	public java.util.List<MasterCountry> findBycountryName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCountry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master countries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master countries
	 */
	public java.util.List<MasterCountry> findBycountryName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCountry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first master country in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master country
	 * @throws NoSuchMasterCountryException if a matching master country could not be found
	 */
	public MasterCountry findBycountryName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<MasterCountry>
				orderByComparator)
		throws NoSuchMasterCountryException;

	/**
	 * Returns the first master country in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master country, or <code>null</code> if a matching master country could not be found
	 */
	public MasterCountry fetchBycountryName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCountry>
			orderByComparator);

	/**
	 * Returns the last master country in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master country
	 * @throws NoSuchMasterCountryException if a matching master country could not be found
	 */
	public MasterCountry findBycountryName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<MasterCountry>
				orderByComparator)
		throws NoSuchMasterCountryException;

	/**
	 * Returns the last master country in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master country, or <code>null</code> if a matching master country could not be found
	 */
	public MasterCountry fetchBycountryName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCountry>
			orderByComparator);

	/**
	 * Returns the master countries before and after the current master country in the ordered set where name = &#63;.
	 *
	 * @param countryId the primary key of the current master country
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master country
	 * @throws NoSuchMasterCountryException if a master country with the primary key could not be found
	 */
	public MasterCountry[] findBycountryName_PrevAndNext(
			long countryId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<MasterCountry>
				orderByComparator)
		throws NoSuchMasterCountryException;

	/**
	 * Removes all the master countries where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeBycountryName(String name);

	/**
	 * Returns the number of master countries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching master countries
	 */
	public int countBycountryName(String name);

	/**
	 * Returns all the master countries where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @return the matching master countries
	 */
	public java.util.List<MasterCountry> findByactiveCountries(
		Integer isSanctionCountry, Integer active);

	/**
	 * Returns a range of all the master countries where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @return the range of matching master countries
	 */
	public java.util.List<MasterCountry> findByactiveCountries(
		Integer isSanctionCountry, Integer active, int start, int end);

	/**
	 * Returns an ordered range of all the master countries where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master countries
	 */
	public java.util.List<MasterCountry> findByactiveCountries(
		Integer isSanctionCountry, Integer active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCountry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master countries where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master countries
	 */
	public java.util.List<MasterCountry> findByactiveCountries(
		Integer isSanctionCountry, Integer active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCountry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first master country in the ordered set where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master country
	 * @throws NoSuchMasterCountryException if a matching master country could not be found
	 */
	public MasterCountry findByactiveCountries_First(
			Integer isSanctionCountry, Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterCountry>
				orderByComparator)
		throws NoSuchMasterCountryException;

	/**
	 * Returns the first master country in the ordered set where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master country, or <code>null</code> if a matching master country could not be found
	 */
	public MasterCountry fetchByactiveCountries_First(
		Integer isSanctionCountry, Integer active,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCountry>
			orderByComparator);

	/**
	 * Returns the last master country in the ordered set where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master country
	 * @throws NoSuchMasterCountryException if a matching master country could not be found
	 */
	public MasterCountry findByactiveCountries_Last(
			Integer isSanctionCountry, Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterCountry>
				orderByComparator)
		throws NoSuchMasterCountryException;

	/**
	 * Returns the last master country in the ordered set where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master country, or <code>null</code> if a matching master country could not be found
	 */
	public MasterCountry fetchByactiveCountries_Last(
		Integer isSanctionCountry, Integer active,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCountry>
			orderByComparator);

	/**
	 * Returns the master countries before and after the current master country in the ordered set where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param countryId the primary key of the current master country
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master country
	 * @throws NoSuchMasterCountryException if a master country with the primary key could not be found
	 */
	public MasterCountry[] findByactiveCountries_PrevAndNext(
			long countryId, Integer isSanctionCountry, Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterCountry>
				orderByComparator)
		throws NoSuchMasterCountryException;

	/**
	 * Removes all the master countries where isSanctionCountry = &#63; and active = &#63; from the database.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 */
	public void removeByactiveCountries(
		Integer isSanctionCountry, Integer active);

	/**
	 * Returns the number of master countries where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @return the number of matching master countries
	 */
	public int countByactiveCountries(
		Integer isSanctionCountry, Integer active);

	/**
	 * Caches the master country in the entity cache if it is enabled.
	 *
	 * @param masterCountry the master country
	 */
	public void cacheResult(MasterCountry masterCountry);

	/**
	 * Caches the master countries in the entity cache if it is enabled.
	 *
	 * @param masterCountries the master countries
	 */
	public void cacheResult(java.util.List<MasterCountry> masterCountries);

	/**
	 * Creates a new master country with the primary key. Does not add the master country to the database.
	 *
	 * @param countryId the primary key for the new master country
	 * @return the new master country
	 */
	public MasterCountry create(long countryId);

	/**
	 * Removes the master country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param countryId the primary key of the master country
	 * @return the master country that was removed
	 * @throws NoSuchMasterCountryException if a master country with the primary key could not be found
	 */
	public MasterCountry remove(long countryId)
		throws NoSuchMasterCountryException;

	public MasterCountry updateImpl(MasterCountry masterCountry);

	/**
	 * Returns the master country with the primary key or throws a <code>NoSuchMasterCountryException</code> if it could not be found.
	 *
	 * @param countryId the primary key of the master country
	 * @return the master country
	 * @throws NoSuchMasterCountryException if a master country with the primary key could not be found
	 */
	public MasterCountry findByPrimaryKey(long countryId)
		throws NoSuchMasterCountryException;

	/**
	 * Returns the master country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param countryId the primary key of the master country
	 * @return the master country, or <code>null</code> if a master country with the primary key could not be found
	 */
	public MasterCountry fetchByPrimaryKey(long countryId);

	/**
	 * Returns all the master countries.
	 *
	 * @return the master countries
	 */
	public java.util.List<MasterCountry> findAll();

	/**
	 * Returns a range of all the master countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @return the range of master countries
	 */
	public java.util.List<MasterCountry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the master countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master countries
	 */
	public java.util.List<MasterCountry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCountry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master countries
	 */
	public java.util.List<MasterCountry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCountry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the master countries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of master countries.
	 *
	 * @return the number of master countries
	 */
	public int countAll();

}