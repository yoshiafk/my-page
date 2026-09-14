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

import com.mypage.admin.product.exception.NoSuchMasterCurrencyException;
import com.mypage.admin.product.model.MasterCurrency;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the master currency service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterCurrencyUtil
 * @generated
 */
@ProviderType
public interface MasterCurrencyPersistence
	extends BasePersistence<MasterCurrency> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MasterCurrencyUtil} to access the master currency persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the master currencies where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching master currencies
	 */
	public java.util.List<MasterCurrency> findBycurrencyName(String name);

	/**
	 * Returns a range of all the master currencies where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @return the range of matching master currencies
	 */
	public java.util.List<MasterCurrency> findBycurrencyName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the master currencies where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master currencies
	 */
	public java.util.List<MasterCurrency> findBycurrencyName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCurrency>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master currencies where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master currencies
	 */
	public java.util.List<MasterCurrency> findBycurrencyName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCurrency>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first master currency in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master currency
	 * @throws NoSuchMasterCurrencyException if a matching master currency could not be found
	 */
	public MasterCurrency findBycurrencyName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<MasterCurrency>
				orderByComparator)
		throws NoSuchMasterCurrencyException;

	/**
	 * Returns the first master currency in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master currency, or <code>null</code> if a matching master currency could not be found
	 */
	public MasterCurrency fetchBycurrencyName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCurrency>
			orderByComparator);

	/**
	 * Returns the last master currency in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master currency
	 * @throws NoSuchMasterCurrencyException if a matching master currency could not be found
	 */
	public MasterCurrency findBycurrencyName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<MasterCurrency>
				orderByComparator)
		throws NoSuchMasterCurrencyException;

	/**
	 * Returns the last master currency in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master currency, or <code>null</code> if a matching master currency could not be found
	 */
	public MasterCurrency fetchBycurrencyName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCurrency>
			orderByComparator);

	/**
	 * Returns the master currencies before and after the current master currency in the ordered set where name = &#63;.
	 *
	 * @param currencyId the primary key of the current master currency
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master currency
	 * @throws NoSuchMasterCurrencyException if a master currency with the primary key could not be found
	 */
	public MasterCurrency[] findBycurrencyName_PrevAndNext(
			long currencyId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<MasterCurrency>
				orderByComparator)
		throws NoSuchMasterCurrencyException;

	/**
	 * Removes all the master currencies where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeBycurrencyName(String name);

	/**
	 * Returns the number of master currencies where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching master currencies
	 */
	public int countBycurrencyName(String name);

	/**
	 * Returns the master currency where name = &#63; or throws a <code>NoSuchMasterCurrencyException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching master currency
	 * @throws NoSuchMasterCurrencyException if a matching master currency could not be found
	 */
	public MasterCurrency findBysearchCurrency(String name)
		throws NoSuchMasterCurrencyException;

	/**
	 * Returns the master currency where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching master currency, or <code>null</code> if a matching master currency could not be found
	 */
	public MasterCurrency fetchBysearchCurrency(String name);

	/**
	 * Returns the master currency where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching master currency, or <code>null</code> if a matching master currency could not be found
	 */
	public MasterCurrency fetchBysearchCurrency(
		String name, boolean useFinderCache);

	/**
	 * Removes the master currency where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the master currency that was removed
	 */
	public MasterCurrency removeBysearchCurrency(String name)
		throws NoSuchMasterCurrencyException;

	/**
	 * Returns the number of master currencies where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching master currencies
	 */
	public int countBysearchCurrency(String name);

	/**
	 * Caches the master currency in the entity cache if it is enabled.
	 *
	 * @param masterCurrency the master currency
	 */
	public void cacheResult(MasterCurrency masterCurrency);

	/**
	 * Caches the master currencies in the entity cache if it is enabled.
	 *
	 * @param masterCurrencies the master currencies
	 */
	public void cacheResult(java.util.List<MasterCurrency> masterCurrencies);

	/**
	 * Creates a new master currency with the primary key. Does not add the master currency to the database.
	 *
	 * @param currencyId the primary key for the new master currency
	 * @return the new master currency
	 */
	public MasterCurrency create(long currencyId);

	/**
	 * Removes the master currency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param currencyId the primary key of the master currency
	 * @return the master currency that was removed
	 * @throws NoSuchMasterCurrencyException if a master currency with the primary key could not be found
	 */
	public MasterCurrency remove(long currencyId)
		throws NoSuchMasterCurrencyException;

	public MasterCurrency updateImpl(MasterCurrency masterCurrency);

	/**
	 * Returns the master currency with the primary key or throws a <code>NoSuchMasterCurrencyException</code> if it could not be found.
	 *
	 * @param currencyId the primary key of the master currency
	 * @return the master currency
	 * @throws NoSuchMasterCurrencyException if a master currency with the primary key could not be found
	 */
	public MasterCurrency findByPrimaryKey(long currencyId)
		throws NoSuchMasterCurrencyException;

	/**
	 * Returns the master currency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param currencyId the primary key of the master currency
	 * @return the master currency, or <code>null</code> if a master currency with the primary key could not be found
	 */
	public MasterCurrency fetchByPrimaryKey(long currencyId);

	/**
	 * Returns all the master currencies.
	 *
	 * @return the master currencies
	 */
	public java.util.List<MasterCurrency> findAll();

	/**
	 * Returns a range of all the master currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @return the range of master currencies
	 */
	public java.util.List<MasterCurrency> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the master currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master currencies
	 */
	public java.util.List<MasterCurrency> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCurrency>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master currencies
	 */
	public java.util.List<MasterCurrency> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterCurrency>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the master currencies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of master currencies.
	 *
	 * @return the number of master currencies
	 */
	public int countAll();

}