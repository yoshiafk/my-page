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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.BlacklistCustomer;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the blacklist customer service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.BlacklistCustomerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see BlacklistCustomerPersistence
 * @generated
 */
public class BlacklistCustomerUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(BlacklistCustomer blacklistCustomer) {
		getPersistence().clearCache(blacklistCustomer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, BlacklistCustomer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BlacklistCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BlacklistCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BlacklistCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BlacklistCustomer update(
		BlacklistCustomer blacklistCustomer) {

		return getPersistence().update(blacklistCustomer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BlacklistCustomer update(
		BlacklistCustomer blacklistCustomer, ServiceContext serviceContext) {

		return getPersistence().update(blacklistCustomer, serviceContext);
	}

	/**
	 * Returns all the blacklist customers where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the matching blacklist customers
	 */
	public static List<BlacklistCustomer> findByfirstName(String firstName) {
		return getPersistence().findByfirstName(firstName);
	}

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
	public static List<BlacklistCustomer> findByfirstName(
		String firstName, int start, int end) {

		return getPersistence().findByfirstName(firstName, start, end);
	}

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
	public static List<BlacklistCustomer> findByfirstName(
		String firstName, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().findByfirstName(
			firstName, start, end, orderByComparator);
	}

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
	public static List<BlacklistCustomer> findByfirstName(
		String firstName, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfirstName(
			firstName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first blacklist customer in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer findByfirstName_First(
			String firstName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findByfirstName_First(
			firstName, orderByComparator);
	}

	/**
	 * Returns the first blacklist customer in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer fetchByfirstName_First(
		String firstName,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().fetchByfirstName_First(
			firstName, orderByComparator);
	}

	/**
	 * Returns the last blacklist customer in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer findByfirstName_Last(
			String firstName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findByfirstName_Last(
			firstName, orderByComparator);
	}

	/**
	 * Returns the last blacklist customer in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer fetchByfirstName_Last(
		String firstName,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().fetchByfirstName_Last(
			firstName, orderByComparator);
	}

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where firstName = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public static BlacklistCustomer[] findByfirstName_PrevAndNext(
			long blacklistCustomerId, String firstName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findByfirstName_PrevAndNext(
			blacklistCustomerId, firstName, orderByComparator);
	}

	/**
	 * Removes all the blacklist customers where firstName = &#63; from the database.
	 *
	 * @param firstName the first name
	 */
	public static void removeByfirstName(String firstName) {
		getPersistence().removeByfirstName(firstName);
	}

	/**
	 * Returns the number of blacklist customers where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the number of matching blacklist customers
	 */
	public static int countByfirstName(String firstName) {
		return getPersistence().countByfirstName(firstName);
	}

	/**
	 * Returns all the blacklist customers where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @return the matching blacklist customers
	 */
	public static List<BlacklistCustomer> findBymiddleName(String middleName) {
		return getPersistence().findBymiddleName(middleName);
	}

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
	public static List<BlacklistCustomer> findBymiddleName(
		String middleName, int start, int end) {

		return getPersistence().findBymiddleName(middleName, start, end);
	}

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
	public static List<BlacklistCustomer> findBymiddleName(
		String middleName, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().findBymiddleName(
			middleName, start, end, orderByComparator);
	}

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
	public static List<BlacklistCustomer> findBymiddleName(
		String middleName, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBymiddleName(
			middleName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first blacklist customer in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer findBymiddleName_First(
			String middleName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findBymiddleName_First(
			middleName, orderByComparator);
	}

	/**
	 * Returns the first blacklist customer in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer fetchBymiddleName_First(
		String middleName,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().fetchBymiddleName_First(
			middleName, orderByComparator);
	}

	/**
	 * Returns the last blacklist customer in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer findBymiddleName_Last(
			String middleName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findBymiddleName_Last(
			middleName, orderByComparator);
	}

	/**
	 * Returns the last blacklist customer in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer fetchBymiddleName_Last(
		String middleName,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().fetchBymiddleName_Last(
			middleName, orderByComparator);
	}

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where middleName = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public static BlacklistCustomer[] findBymiddleName_PrevAndNext(
			long blacklistCustomerId, String middleName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findBymiddleName_PrevAndNext(
			blacklistCustomerId, middleName, orderByComparator);
	}

	/**
	 * Removes all the blacklist customers where middleName = &#63; from the database.
	 *
	 * @param middleName the middle name
	 */
	public static void removeBymiddleName(String middleName) {
		getPersistence().removeBymiddleName(middleName);
	}

	/**
	 * Returns the number of blacklist customers where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @return the number of matching blacklist customers
	 */
	public static int countBymiddleName(String middleName) {
		return getPersistence().countBymiddleName(middleName);
	}

	/**
	 * Returns all the blacklist customers where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the matching blacklist customers
	 */
	public static List<BlacklistCustomer> findBylastName(String lastName) {
		return getPersistence().findBylastName(lastName);
	}

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
	public static List<BlacklistCustomer> findBylastName(
		String lastName, int start, int end) {

		return getPersistence().findBylastName(lastName, start, end);
	}

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
	public static List<BlacklistCustomer> findBylastName(
		String lastName, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().findBylastName(
			lastName, start, end, orderByComparator);
	}

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
	public static List<BlacklistCustomer> findBylastName(
		String lastName, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBylastName(
			lastName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first blacklist customer in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer findBylastName_First(
			String lastName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findBylastName_First(
			lastName, orderByComparator);
	}

	/**
	 * Returns the first blacklist customer in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer fetchBylastName_First(
		String lastName,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().fetchBylastName_First(
			lastName, orderByComparator);
	}

	/**
	 * Returns the last blacklist customer in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer findBylastName_Last(
			String lastName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findBylastName_Last(
			lastName, orderByComparator);
	}

	/**
	 * Returns the last blacklist customer in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer fetchBylastName_Last(
		String lastName,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().fetchBylastName_Last(
			lastName, orderByComparator);
	}

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where lastName = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public static BlacklistCustomer[] findBylastName_PrevAndNext(
			long blacklistCustomerId, String lastName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findBylastName_PrevAndNext(
			blacklistCustomerId, lastName, orderByComparator);
	}

	/**
	 * Removes all the blacklist customers where lastName = &#63; from the database.
	 *
	 * @param lastName the last name
	 */
	public static void removeBylastName(String lastName) {
		getPersistence().removeBylastName(lastName);
	}

	/**
	 * Returns the number of blacklist customers where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the number of matching blacklist customers
	 */
	public static int countBylastName(String lastName) {
		return getPersistence().countBylastName(lastName);
	}

	/**
	 * Returns all the blacklist customers where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @return the matching blacklist customers
	 */
	public static List<BlacklistCustomer> findByktp(String ktp) {
		return getPersistence().findByktp(ktp);
	}

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
	public static List<BlacklistCustomer> findByktp(
		String ktp, int start, int end) {

		return getPersistence().findByktp(ktp, start, end);
	}

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
	public static List<BlacklistCustomer> findByktp(
		String ktp, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().findByktp(ktp, start, end, orderByComparator);
	}

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
	public static List<BlacklistCustomer> findByktp(
		String ktp, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByktp(
			ktp, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first blacklist customer in the ordered set where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer findByktp_First(
			String ktp, OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findByktp_First(ktp, orderByComparator);
	}

	/**
	 * Returns the first blacklist customer in the ordered set where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer fetchByktp_First(
		String ktp, OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().fetchByktp_First(ktp, orderByComparator);
	}

	/**
	 * Returns the last blacklist customer in the ordered set where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer findByktp_Last(
			String ktp, OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findByktp_Last(ktp, orderByComparator);
	}

	/**
	 * Returns the last blacklist customer in the ordered set where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer fetchByktp_Last(
		String ktp, OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().fetchByktp_Last(ktp, orderByComparator);
	}

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where ktp = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param ktp the ktp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public static BlacklistCustomer[] findByktp_PrevAndNext(
			long blacklistCustomerId, String ktp,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findByktp_PrevAndNext(
			blacklistCustomerId, ktp, orderByComparator);
	}

	/**
	 * Removes all the blacklist customers where ktp = &#63; from the database.
	 *
	 * @param ktp the ktp
	 */
	public static void removeByktp(String ktp) {
		getPersistence().removeByktp(ktp);
	}

	/**
	 * Returns the number of blacklist customers where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @return the number of matching blacklist customers
	 */
	public static int countByktp(String ktp) {
		return getPersistence().countByktp(ktp);
	}

	/**
	 * Returns all the blacklist customers where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @return the matching blacklist customers
	 */
	public static List<BlacklistCustomer> findBykitas(String kitas) {
		return getPersistence().findBykitas(kitas);
	}

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
	public static List<BlacklistCustomer> findBykitas(
		String kitas, int start, int end) {

		return getPersistence().findBykitas(kitas, start, end);
	}

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
	public static List<BlacklistCustomer> findBykitas(
		String kitas, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().findBykitas(
			kitas, start, end, orderByComparator);
	}

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
	public static List<BlacklistCustomer> findBykitas(
		String kitas, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBykitas(
			kitas, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first blacklist customer in the ordered set where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer findBykitas_First(
			String kitas,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findBykitas_First(kitas, orderByComparator);
	}

	/**
	 * Returns the first blacklist customer in the ordered set where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer fetchBykitas_First(
		String kitas, OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().fetchBykitas_First(kitas, orderByComparator);
	}

	/**
	 * Returns the last blacklist customer in the ordered set where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer findBykitas_Last(
			String kitas,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findBykitas_Last(kitas, orderByComparator);
	}

	/**
	 * Returns the last blacklist customer in the ordered set where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer fetchBykitas_Last(
		String kitas, OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().fetchBykitas_Last(kitas, orderByComparator);
	}

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where kitas = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param kitas the kitas
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public static BlacklistCustomer[] findBykitas_PrevAndNext(
			long blacklistCustomerId, String kitas,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findBykitas_PrevAndNext(
			blacklistCustomerId, kitas, orderByComparator);
	}

	/**
	 * Removes all the blacklist customers where kitas = &#63; from the database.
	 *
	 * @param kitas the kitas
	 */
	public static void removeBykitas(String kitas) {
		getPersistence().removeBykitas(kitas);
	}

	/**
	 * Returns the number of blacklist customers where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @return the number of matching blacklist customers
	 */
	public static int countBykitas(String kitas) {
		return getPersistence().countBykitas(kitas);
	}

	/**
	 * Returns all the blacklist customers where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching blacklist customers
	 */
	public static List<BlacklistCustomer> findByemail(String email) {
		return getPersistence().findByemail(email);
	}

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
	public static List<BlacklistCustomer> findByemail(
		String email, int start, int end) {

		return getPersistence().findByemail(email, start, end);
	}

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
	public static List<BlacklistCustomer> findByemail(
		String email, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().findByemail(
			email, start, end, orderByComparator);
	}

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
	public static List<BlacklistCustomer> findByemail(
		String email, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByemail(
			email, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first blacklist customer in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer findByemail_First(
			String email,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findByemail_First(email, orderByComparator);
	}

	/**
	 * Returns the first blacklist customer in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer fetchByemail_First(
		String email, OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().fetchByemail_First(email, orderByComparator);
	}

	/**
	 * Returns the last blacklist customer in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer findByemail_Last(
			String email,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findByemail_Last(email, orderByComparator);
	}

	/**
	 * Returns the last blacklist customer in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer fetchByemail_Last(
		String email, OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().fetchByemail_Last(email, orderByComparator);
	}

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where email = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public static BlacklistCustomer[] findByemail_PrevAndNext(
			long blacklistCustomerId, String email,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findByemail_PrevAndNext(
			blacklistCustomerId, email, orderByComparator);
	}

	/**
	 * Removes all the blacklist customers where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	public static void removeByemail(String email) {
		getPersistence().removeByemail(email);
	}

	/**
	 * Returns the number of blacklist customers where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching blacklist customers
	 */
	public static int countByemail(String email) {
		return getPersistence().countByemail(email);
	}

	/**
	 * Returns all the blacklist customers where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the matching blacklist customers
	 */
	public static List<BlacklistCustomer> findByfullName(String fullName) {
		return getPersistence().findByfullName(fullName);
	}

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
	public static List<BlacklistCustomer> findByfullName(
		String fullName, int start, int end) {

		return getPersistence().findByfullName(fullName, start, end);
	}

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
	public static List<BlacklistCustomer> findByfullName(
		String fullName, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().findByfullName(
			fullName, start, end, orderByComparator);
	}

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
	public static List<BlacklistCustomer> findByfullName(
		String fullName, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfullName(
			fullName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first blacklist customer in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer findByfullName_First(
			String fullName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findByfullName_First(
			fullName, orderByComparator);
	}

	/**
	 * Returns the first blacklist customer in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer fetchByfullName_First(
		String fullName,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().fetchByfullName_First(
			fullName, orderByComparator);
	}

	/**
	 * Returns the last blacklist customer in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer findByfullName_Last(
			String fullName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findByfullName_Last(
			fullName, orderByComparator);
	}

	/**
	 * Returns the last blacklist customer in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	public static BlacklistCustomer fetchByfullName_Last(
		String fullName,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().fetchByfullName_Last(
			fullName, orderByComparator);
	}

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where fullName = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public static BlacklistCustomer[] findByfullName_PrevAndNext(
			long blacklistCustomerId, String fullName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findByfullName_PrevAndNext(
			blacklistCustomerId, fullName, orderByComparator);
	}

	/**
	 * Removes all the blacklist customers where fullName = &#63; from the database.
	 *
	 * @param fullName the full name
	 */
	public static void removeByfullName(String fullName) {
		getPersistence().removeByfullName(fullName);
	}

	/**
	 * Returns the number of blacklist customers where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the number of matching blacklist customers
	 */
	public static int countByfullName(String fullName) {
		return getPersistence().countByfullName(fullName);
	}

	/**
	 * Caches the blacklist customer in the entity cache if it is enabled.
	 *
	 * @param blacklistCustomer the blacklist customer
	 */
	public static void cacheResult(BlacklistCustomer blacklistCustomer) {
		getPersistence().cacheResult(blacklistCustomer);
	}

	/**
	 * Caches the blacklist customers in the entity cache if it is enabled.
	 *
	 * @param blacklistCustomers the blacklist customers
	 */
	public static void cacheResult(List<BlacklistCustomer> blacklistCustomers) {
		getPersistence().cacheResult(blacklistCustomers);
	}

	/**
	 * Creates a new blacklist customer with the primary key. Does not add the blacklist customer to the database.
	 *
	 * @param blacklistCustomerId the primary key for the new blacklist customer
	 * @return the new blacklist customer
	 */
	public static BlacklistCustomer create(long blacklistCustomerId) {
		return getPersistence().create(blacklistCustomerId);
	}

	/**
	 * Removes the blacklist customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param blacklistCustomerId the primary key of the blacklist customer
	 * @return the blacklist customer that was removed
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public static BlacklistCustomer remove(long blacklistCustomerId)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().remove(blacklistCustomerId);
	}

	public static BlacklistCustomer updateImpl(
		BlacklistCustomer blacklistCustomer) {

		return getPersistence().updateImpl(blacklistCustomer);
	}

	/**
	 * Returns the blacklist customer with the primary key or throws a <code>NoSuchBlacklistCustomerException</code> if it could not be found.
	 *
	 * @param blacklistCustomerId the primary key of the blacklist customer
	 * @return the blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	public static BlacklistCustomer findByPrimaryKey(long blacklistCustomerId)
		throws com.mypage.admin.product.exception.
			NoSuchBlacklistCustomerException {

		return getPersistence().findByPrimaryKey(blacklistCustomerId);
	}

	/**
	 * Returns the blacklist customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param blacklistCustomerId the primary key of the blacklist customer
	 * @return the blacklist customer, or <code>null</code> if a blacklist customer with the primary key could not be found
	 */
	public static BlacklistCustomer fetchByPrimaryKey(
		long blacklistCustomerId) {

		return getPersistence().fetchByPrimaryKey(blacklistCustomerId);
	}

	/**
	 * Returns all the blacklist customers.
	 *
	 * @return the blacklist customers
	 */
	public static List<BlacklistCustomer> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<BlacklistCustomer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<BlacklistCustomer> findAll(
		int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<BlacklistCustomer> findAll(
		int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the blacklist customers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of blacklist customers.
	 *
	 * @return the number of blacklist customers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BlacklistCustomerPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BlacklistCustomerPersistence _persistence;

}