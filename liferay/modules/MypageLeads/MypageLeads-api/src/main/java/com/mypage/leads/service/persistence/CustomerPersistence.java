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

import com.mypage.leads.exception.NoSuchCustomerException;
import com.mypage.leads.model.Customer;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the customer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see CustomerUtil
 * @generated
 */
@ProviderType
public interface CustomerPersistence extends BasePersistence<Customer> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CustomerUtil} to access the customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the customers where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching customers
	 */
	public java.util.List<Customer> findBysearchByLeadsId(long LeadsId);

	/**
	 * Returns a range of all the customers where LeadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param LeadsId the leads ID
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @return the range of matching customers
	 */
	public java.util.List<Customer> findBysearchByLeadsId(
		long LeadsId, int start, int end);

	/**
	 * Returns an ordered range of all the customers where LeadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param LeadsId the leads ID
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching customers
	 */
	public java.util.List<Customer> findBysearchByLeadsId(
		long LeadsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the customers where LeadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param LeadsId the leads ID
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching customers
	 */
	public java.util.List<Customer> findBysearchByLeadsId(
		long LeadsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first customer in the ordered set where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	public Customer findBysearchByLeadsId_First(
			long LeadsId,
			com.liferay.portal.kernel.util.OrderByComparator<Customer>
				orderByComparator)
		throws NoSuchCustomerException;

	/**
	 * Returns the first customer in the ordered set where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer, or <code>null</code> if a matching customer could not be found
	 */
	public Customer fetchBysearchByLeadsId_First(
		long LeadsId,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator);

	/**
	 * Returns the last customer in the ordered set where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	public Customer findBysearchByLeadsId_Last(
			long LeadsId,
			com.liferay.portal.kernel.util.OrderByComparator<Customer>
				orderByComparator)
		throws NoSuchCustomerException;

	/**
	 * Returns the last customer in the ordered set where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer, or <code>null</code> if a matching customer could not be found
	 */
	public Customer fetchBysearchByLeadsId_Last(
		long LeadsId,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator);

	/**
	 * Returns the customers before and after the current customer in the ordered set where LeadsId = &#63;.
	 *
	 * @param customerId the primary key of the current customer
	 * @param LeadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next customer
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	public Customer[] findBysearchByLeadsId_PrevAndNext(
			long customerId, long LeadsId,
			com.liferay.portal.kernel.util.OrderByComparator<Customer>
				orderByComparator)
		throws NoSuchCustomerException;

	/**
	 * Removes all the customers where LeadsId = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 */
	public void removeBysearchByLeadsId(long LeadsId);

	/**
	 * Returns the number of customers where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the number of matching customers
	 */
	public int countBysearchByLeadsId(long LeadsId);

	/**
	 * Returns all the customers where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @return the matching customers
	 */
	public java.util.List<Customer> findBysearchByLeadsIdAndProductCode(
		long LeadsId, String ProductCode);

	/**
	 * Returns a range of all the customers where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @return the range of matching customers
	 */
	public java.util.List<Customer> findBysearchByLeadsIdAndProductCode(
		long LeadsId, String ProductCode, int start, int end);

	/**
	 * Returns an ordered range of all the customers where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching customers
	 */
	public java.util.List<Customer> findBysearchByLeadsIdAndProductCode(
		long LeadsId, String ProductCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the customers where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching customers
	 */
	public java.util.List<Customer> findBysearchByLeadsIdAndProductCode(
		long LeadsId, String ProductCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first customer in the ordered set where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	public Customer findBysearchByLeadsIdAndProductCode_First(
			long LeadsId, String ProductCode,
			com.liferay.portal.kernel.util.OrderByComparator<Customer>
				orderByComparator)
		throws NoSuchCustomerException;

	/**
	 * Returns the first customer in the ordered set where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer, or <code>null</code> if a matching customer could not be found
	 */
	public Customer fetchBysearchByLeadsIdAndProductCode_First(
		long LeadsId, String ProductCode,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator);

	/**
	 * Returns the last customer in the ordered set where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	public Customer findBysearchByLeadsIdAndProductCode_Last(
			long LeadsId, String ProductCode,
			com.liferay.portal.kernel.util.OrderByComparator<Customer>
				orderByComparator)
		throws NoSuchCustomerException;

	/**
	 * Returns the last customer in the ordered set where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer, or <code>null</code> if a matching customer could not be found
	 */
	public Customer fetchBysearchByLeadsIdAndProductCode_Last(
		long LeadsId, String ProductCode,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator);

	/**
	 * Returns the customers before and after the current customer in the ordered set where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * @param customerId the primary key of the current customer
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next customer
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	public Customer[] findBysearchByLeadsIdAndProductCode_PrevAndNext(
			long customerId, long LeadsId, String ProductCode,
			com.liferay.portal.kernel.util.OrderByComparator<Customer>
				orderByComparator)
		throws NoSuchCustomerException;

	/**
	 * Removes all the customers where LeadsId = &#63; and ProductCode = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 */
	public void removeBysearchByLeadsIdAndProductCode(
		long LeadsId, String ProductCode);

	/**
	 * Returns the number of customers where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @return the number of matching customers
	 */
	public int countBysearchByLeadsIdAndProductCode(
		long LeadsId, String ProductCode);

	/**
	 * Caches the customer in the entity cache if it is enabled.
	 *
	 * @param customer the customer
	 */
	public void cacheResult(Customer customer);

	/**
	 * Caches the customers in the entity cache if it is enabled.
	 *
	 * @param customers the customers
	 */
	public void cacheResult(java.util.List<Customer> customers);

	/**
	 * Creates a new customer with the primary key. Does not add the customer to the database.
	 *
	 * @param customerId the primary key for the new customer
	 * @return the new customer
	 */
	public Customer create(long customerId);

	/**
	 * Removes the customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer that was removed
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	public Customer remove(long customerId) throws NoSuchCustomerException;

	public Customer updateImpl(Customer customer);

	/**
	 * Returns the customer with the primary key or throws a <code>NoSuchCustomerException</code> if it could not be found.
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	public Customer findByPrimaryKey(long customerId)
		throws NoSuchCustomerException;

	/**
	 * Returns the customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer, or <code>null</code> if a customer with the primary key could not be found
	 */
	public Customer fetchByPrimaryKey(long customerId);

	/**
	 * Returns all the customers.
	 *
	 * @return the customers
	 */
	public java.util.List<Customer> findAll();

	/**
	 * Returns a range of all the customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @return the range of customers
	 */
	public java.util.List<Customer> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of customers
	 */
	public java.util.List<Customer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of customers
	 */
	public java.util.List<Customer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the customers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of customers.
	 *
	 * @return the number of customers
	 */
	public int countAll();

}