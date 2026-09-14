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

import com.mypage.admin.product.exception.NoSuchMasterBankException;
import com.mypage.admin.product.model.MasterBank;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the master bank service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterBankUtil
 * @generated
 */
@ProviderType
public interface MasterBankPersistence extends BasePersistence<MasterBank> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MasterBankUtil} to access the master bank persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the master banks where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching master banks
	 */
	public java.util.List<MasterBank> findByactiveBanks(Integer active);

	/**
	 * Returns a range of all the master banks where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @return the range of matching master banks
	 */
	public java.util.List<MasterBank> findByactiveBanks(
		Integer active, int start, int end);

	/**
	 * Returns an ordered range of all the master banks where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master banks
	 */
	public java.util.List<MasterBank> findByactiveBanks(
		Integer active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterBank>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master banks where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master banks
	 */
	public java.util.List<MasterBank> findByactiveBanks(
		Integer active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterBank>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first master bank in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master bank
	 * @throws NoSuchMasterBankException if a matching master bank could not be found
	 */
	public MasterBank findByactiveBanks_First(
			Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterBank>
				orderByComparator)
		throws NoSuchMasterBankException;

	/**
	 * Returns the first master bank in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master bank, or <code>null</code> if a matching master bank could not be found
	 */
	public MasterBank fetchByactiveBanks_First(
		Integer active,
		com.liferay.portal.kernel.util.OrderByComparator<MasterBank>
			orderByComparator);

	/**
	 * Returns the last master bank in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master bank
	 * @throws NoSuchMasterBankException if a matching master bank could not be found
	 */
	public MasterBank findByactiveBanks_Last(
			Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterBank>
				orderByComparator)
		throws NoSuchMasterBankException;

	/**
	 * Returns the last master bank in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master bank, or <code>null</code> if a matching master bank could not be found
	 */
	public MasterBank fetchByactiveBanks_Last(
		Integer active,
		com.liferay.portal.kernel.util.OrderByComparator<MasterBank>
			orderByComparator);

	/**
	 * Returns the master banks before and after the current master bank in the ordered set where active = &#63;.
	 *
	 * @param masterBankId the primary key of the current master bank
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master bank
	 * @throws NoSuchMasterBankException if a master bank with the primary key could not be found
	 */
	public MasterBank[] findByactiveBanks_PrevAndNext(
			long masterBankId, Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterBank>
				orderByComparator)
		throws NoSuchMasterBankException;

	/**
	 * Removes all the master banks where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeByactiveBanks(Integer active);

	/**
	 * Returns the number of master banks where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching master banks
	 */
	public int countByactiveBanks(Integer active);

	/**
	 * Returns all the master banks where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @return the matching master banks
	 */
	public java.util.List<MasterBank> findBysearchByName(
		String name, Integer active);

	/**
	 * Returns a range of all the master banks where name = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @return the range of matching master banks
	 */
	public java.util.List<MasterBank> findBysearchByName(
		String name, Integer active, int start, int end);

	/**
	 * Returns an ordered range of all the master banks where name = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master banks
	 */
	public java.util.List<MasterBank> findBysearchByName(
		String name, Integer active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterBank>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master banks where name = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master banks
	 */
	public java.util.List<MasterBank> findBysearchByName(
		String name, Integer active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterBank>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first master bank in the ordered set where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master bank
	 * @throws NoSuchMasterBankException if a matching master bank could not be found
	 */
	public MasterBank findBysearchByName_First(
			String name, Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterBank>
				orderByComparator)
		throws NoSuchMasterBankException;

	/**
	 * Returns the first master bank in the ordered set where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master bank, or <code>null</code> if a matching master bank could not be found
	 */
	public MasterBank fetchBysearchByName_First(
		String name, Integer active,
		com.liferay.portal.kernel.util.OrderByComparator<MasterBank>
			orderByComparator);

	/**
	 * Returns the last master bank in the ordered set where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master bank
	 * @throws NoSuchMasterBankException if a matching master bank could not be found
	 */
	public MasterBank findBysearchByName_Last(
			String name, Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterBank>
				orderByComparator)
		throws NoSuchMasterBankException;

	/**
	 * Returns the last master bank in the ordered set where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master bank, or <code>null</code> if a matching master bank could not be found
	 */
	public MasterBank fetchBysearchByName_Last(
		String name, Integer active,
		com.liferay.portal.kernel.util.OrderByComparator<MasterBank>
			orderByComparator);

	/**
	 * Returns the master banks before and after the current master bank in the ordered set where name = &#63; and active = &#63;.
	 *
	 * @param masterBankId the primary key of the current master bank
	 * @param name the name
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master bank
	 * @throws NoSuchMasterBankException if a master bank with the primary key could not be found
	 */
	public MasterBank[] findBysearchByName_PrevAndNext(
			long masterBankId, String name, Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterBank>
				orderByComparator)
		throws NoSuchMasterBankException;

	/**
	 * Removes all the master banks where name = &#63; and active = &#63; from the database.
	 *
	 * @param name the name
	 * @param active the active
	 */
	public void removeBysearchByName(String name, Integer active);

	/**
	 * Returns the number of master banks where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @return the number of matching master banks
	 */
	public int countBysearchByName(String name, Integer active);

	/**
	 * Caches the master bank in the entity cache if it is enabled.
	 *
	 * @param masterBank the master bank
	 */
	public void cacheResult(MasterBank masterBank);

	/**
	 * Caches the master banks in the entity cache if it is enabled.
	 *
	 * @param masterBanks the master banks
	 */
	public void cacheResult(java.util.List<MasterBank> masterBanks);

	/**
	 * Creates a new master bank with the primary key. Does not add the master bank to the database.
	 *
	 * @param masterBankId the primary key for the new master bank
	 * @return the new master bank
	 */
	public MasterBank create(long masterBankId);

	/**
	 * Removes the master bank with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterBankId the primary key of the master bank
	 * @return the master bank that was removed
	 * @throws NoSuchMasterBankException if a master bank with the primary key could not be found
	 */
	public MasterBank remove(long masterBankId)
		throws NoSuchMasterBankException;

	public MasterBank updateImpl(MasterBank masterBank);

	/**
	 * Returns the master bank with the primary key or throws a <code>NoSuchMasterBankException</code> if it could not be found.
	 *
	 * @param masterBankId the primary key of the master bank
	 * @return the master bank
	 * @throws NoSuchMasterBankException if a master bank with the primary key could not be found
	 */
	public MasterBank findByPrimaryKey(long masterBankId)
		throws NoSuchMasterBankException;

	/**
	 * Returns the master bank with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterBankId the primary key of the master bank
	 * @return the master bank, or <code>null</code> if a master bank with the primary key could not be found
	 */
	public MasterBank fetchByPrimaryKey(long masterBankId);

	/**
	 * Returns all the master banks.
	 *
	 * @return the master banks
	 */
	public java.util.List<MasterBank> findAll();

	/**
	 * Returns a range of all the master banks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @return the range of master banks
	 */
	public java.util.List<MasterBank> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the master banks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master banks
	 */
	public java.util.List<MasterBank> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterBank>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master banks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master banks
	 */
	public java.util.List<MasterBank> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterBank>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the master banks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of master banks.
	 *
	 * @return the number of master banks
	 */
	public int countAll();

}