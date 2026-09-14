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

import com.mypage.admin.product.exception.NoSuchBlacklistCustomerException;
import com.mypage.admin.product.model.BlacklistCustomer;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the blacklist customer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see BlacklistCustomerUtil
 * @generated
 */
@ProviderType
public interface BlacklistCustomerPersistence
	extends BasePersistence<BlacklistCustomer> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BlacklistCustomerUtil} to access the blacklist customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the blacklist customers where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findByfirstName(String firstName);

	/**
	 * Returns a range of all the blacklist customers where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findByfirstName(
		String firstName, int start, int end);

	/**
	 * Returns an ordered range of all the blacklist customers where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findByfirstName(
		String firstName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the blacklist customers where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findByfirstName(
		String firstName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first blacklist customer in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer findByfirstName_First(
			String firstName,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Returns the first blacklist customer in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer fetchByfirstName_First(
		String firstName,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns the last blacklist customer in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer findByfirstName_Last(
			String firstName,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Returns the last blacklist customer in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer fetchByfirstName_Last(
		String firstName,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where firstName = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public BlacklistCustomer[] findByfirstName_PrevAndNext(
			long blacklistCustomerId, String firstName,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Removes all the blacklist customers where firstName = &#63; from the database.
	 *
	 * @param firstName the first name
	 */
	public void removeByfirstName(String firstName);

	/**
	 * Returns the number of blacklist customers where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the number of matching blacklist customers
	 */
	public int countByfirstName(String firstName);

	/**
	 * Returns all the blacklist customers where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @return the matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findBymiddleName(
		String middleName);

	/**
	 * Returns a range of all the blacklist customers where middleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param middleName the middle name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findBymiddleName(
		String middleName, int start, int end);

	/**
	 * Returns an ordered range of all the blacklist customers where middleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param middleName the middle name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findBymiddleName(
		String middleName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the blacklist customers where middleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param middleName the middle name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findBymiddleName(
		String middleName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first blacklist customer in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer findBymiddleName_First(
			String middleName,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Returns the first blacklist customer in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer fetchBymiddleName_First(
		String middleName,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns the last blacklist customer in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer findBymiddleName_Last(
			String middleName,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Returns the last blacklist customer in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer fetchBymiddleName_Last(
		String middleName,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where middleName = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public BlacklistCustomer[] findBymiddleName_PrevAndNext(
			long blacklistCustomerId, String middleName,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Removes all the blacklist customers where middleName = &#63; from the database.
	 *
	 * @param middleName the middle name
	 */
	public void removeBymiddleName(String middleName);

	/**
	 * Returns the number of blacklist customers where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @return the number of matching blacklist customers
	 */
	public int countBymiddleName(String middleName);

	/**
	 * Returns all the blacklist customers where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findBylastName(String lastName);

	/**
	 * Returns a range of all the blacklist customers where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findBylastName(
		String lastName, int start, int end);

	/**
	 * Returns an ordered range of all the blacklist customers where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findBylastName(
		String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the blacklist customers where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findBylastName(
		String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first blacklist customer in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer findBylastName_First(
			String lastName,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Returns the first blacklist customer in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer fetchBylastName_First(
		String lastName,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns the last blacklist customer in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer findBylastName_Last(
			String lastName,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Returns the last blacklist customer in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer fetchBylastName_Last(
		String lastName,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where lastName = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public BlacklistCustomer[] findBylastName_PrevAndNext(
			long blacklistCustomerId, String lastName,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Removes all the blacklist customers where lastName = &#63; from the database.
	 *
	 * @param lastName the last name
	 */
	public void removeBylastName(String lastName);

	/**
	 * Returns the number of blacklist customers where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the number of matching blacklist customers
	 */
	public int countBylastName(String lastName);

	/**
	 * Returns all the blacklist customers where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @return the matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findByktp(String ktp);

	/**
	 * Returns a range of all the blacklist customers where ktp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param ktp the ktp
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findByktp(
		String ktp, int start, int end);

	/**
	 * Returns an ordered range of all the blacklist customers where ktp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param ktp the ktp
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findByktp(
		String ktp, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the blacklist customers where ktp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param ktp the ktp
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findByktp(
		String ktp, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first blacklist customer in the ordered set where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer findByktp_First(
			String ktp,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Returns the first blacklist customer in the ordered set where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer fetchByktp_First(
		String ktp,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns the last blacklist customer in the ordered set where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer findByktp_Last(
			String ktp,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Returns the last blacklist customer in the ordered set where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer fetchByktp_Last(
		String ktp,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where ktp = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param ktp the ktp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public BlacklistCustomer[] findByktp_PrevAndNext(
			long blacklistCustomerId, String ktp,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Removes all the blacklist customers where ktp = &#63; from the database.
	 *
	 * @param ktp the ktp
	 */
	public void removeByktp(String ktp);

	/**
	 * Returns the number of blacklist customers where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @return the number of matching blacklist customers
	 */
	public int countByktp(String ktp);

	/**
	 * Returns all the blacklist customers where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @return the matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findBykitas(String kitas);

	/**
	 * Returns a range of all the blacklist customers where kitas = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param kitas the kitas
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findBykitas(
		String kitas, int start, int end);

	/**
	 * Returns an ordered range of all the blacklist customers where kitas = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param kitas the kitas
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findBykitas(
		String kitas, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the blacklist customers where kitas = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param kitas the kitas
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findBykitas(
		String kitas, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first blacklist customer in the ordered set where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer findBykitas_First(
			String kitas,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Returns the first blacklist customer in the ordered set where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer fetchBykitas_First(
		String kitas,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns the last blacklist customer in the ordered set where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer findBykitas_Last(
			String kitas,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Returns the last blacklist customer in the ordered set where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer fetchBykitas_Last(
		String kitas,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where kitas = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param kitas the kitas
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public BlacklistCustomer[] findBykitas_PrevAndNext(
			long blacklistCustomerId, String kitas,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Removes all the blacklist customers where kitas = &#63; from the database.
	 *
	 * @param kitas the kitas
	 */
	public void removeBykitas(String kitas);

	/**
	 * Returns the number of blacklist customers where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @return the number of matching blacklist customers
	 */
	public int countBykitas(String kitas);

	/**
	 * Returns all the blacklist customers where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findByemail(String email);

	/**
	 * Returns a range of all the blacklist customers where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findByemail(
		String email, int start, int end);

	/**
	 * Returns an ordered range of all the blacklist customers where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findByemail(
		String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the blacklist customers where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findByemail(
		String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first blacklist customer in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer findByemail_First(
			String email,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Returns the first blacklist customer in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer fetchByemail_First(
		String email,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns the last blacklist customer in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer findByemail_Last(
			String email,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Returns the last blacklist customer in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer fetchByemail_Last(
		String email,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where email = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public BlacklistCustomer[] findByemail_PrevAndNext(
			long blacklistCustomerId, String email,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Removes all the blacklist customers where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	public void removeByemail(String email);

	/**
	 * Returns the number of blacklist customers where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching blacklist customers
	 */
	public int countByemail(String email);

	/**
	 * Returns all the blacklist customers where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findByfullName(String fullName);

	/**
	 * Returns a range of all the blacklist customers where fullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findByfullName(
		String fullName, int start, int end);

	/**
	 * Returns an ordered range of all the blacklist customers where fullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findByfullName(
		String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the blacklist customers where fullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findByfullName(
		String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first blacklist customer in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer findByfullName_First(
			String fullName,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Returns the first blacklist customer in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer fetchByfullName_First(
		String fullName,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns the last blacklist customer in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer findByfullName_Last(
			String fullName,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Returns the last blacklist customer in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public BlacklistCustomer fetchByfullName_Last(
		String fullName,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where fullName = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public BlacklistCustomer[] findByfullName_PrevAndNext(
			long blacklistCustomerId, String fullName,
			com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
				orderByComparator)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Removes all the blacklist customers where fullName = &#63; from the database.
	 *
	 * @param fullName the full name
	 */
	public void removeByfullName(String fullName);

	/**
	 * Returns the number of blacklist customers where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the number of matching blacklist customers
	 */
	public int countByfullName(String fullName);

	/**
	 * Caches the blacklist customer in the entity cache if it is enabled.
	 *
	 * @param blacklistCustomer the blacklist customer
	 */
	public void cacheResult(BlacklistCustomer blacklistCustomer);

	/**
	 * Caches the blacklist customers in the entity cache if it is enabled.
	 *
	 * @param blacklistCustomers the blacklist customers
	 */
	public void cacheResult(
		java.util.List<BlacklistCustomer> blacklistCustomers);

	/**
	 * Creates a new blacklist customer with the primary key. Does not add the blacklist customer to the database.
	 *
	 * @param blacklistCustomerId the primary key for the new blacklist customer
	 * @return the new blacklist customer
	 */
	public BlacklistCustomer create(long blacklistCustomerId);

	/**
	 * Removes the blacklist customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param blacklistCustomerId the primary key of the blacklist customer
	 * @return the blacklist customer that was removed
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public BlacklistCustomer remove(long blacklistCustomerId)
		throws NoSuchBlacklistCustomerException;

	public BlacklistCustomer updateImpl(BlacklistCustomer blacklistCustomer);

	/**
	 * Returns the blacklist customer with the primary key or throws a <code>NoSuchBlacklistCustomerException</code> if it could not be found.
	 *
	 * @param blacklistCustomerId the primary key of the blacklist customer
	 * @return the blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public BlacklistCustomer findByPrimaryKey(long blacklistCustomerId)
		throws NoSuchBlacklistCustomerException;

	/**
	 * Returns the blacklist customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param blacklistCustomerId the primary key of the blacklist customer
	 * @return the blacklist customer, or <code>null</code> if a blacklist customer with the primary key could not be found
	 */
	public BlacklistCustomer fetchByPrimaryKey(long blacklistCustomerId);

	/**
	 * Returns all the blacklist customers.
	 *
	 * @return the blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findAll();

	/**
	 * Returns a range of all the blacklist customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the blacklist customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the blacklist customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of blacklist customers
	 */
	public java.util.List<BlacklistCustomer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BlacklistCustomer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the blacklist customers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of blacklist customers.
	 *
	 * @return the number of blacklist customers
	 */
	public int countAll();

}