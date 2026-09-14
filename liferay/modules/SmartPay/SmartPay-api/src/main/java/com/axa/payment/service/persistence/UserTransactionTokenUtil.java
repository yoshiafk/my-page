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

package com.axa.payment.service.persistence;

import com.axa.payment.model.UserTransactionToken;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the user transaction token service. This utility wraps <code>com.axa.payment.service.persistence.impl.UserTransactionTokenPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see UserTransactionTokenPersistence
 * @generated
 */
public class UserTransactionTokenUtil {

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
	public static void clearCache(UserTransactionToken userTransactionToken) {
		getPersistence().clearCache(userTransactionToken);
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
	public static Map<Serializable, UserTransactionToken> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserTransactionToken> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserTransactionToken> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserTransactionToken> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserTransactionToken update(
		UserTransactionToken userTransactionToken) {

		return getPersistence().update(userTransactionToken);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserTransactionToken update(
		UserTransactionToken userTransactionToken,
		ServiceContext serviceContext) {

		return getPersistence().update(userTransactionToken, serviceContext);
	}

	/**
	 * Returns all the user transaction tokens where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @return the matching user transaction tokens
	 */
	public static List<UserTransactionToken> findBypolicyProfile(
		String policyNumber, String profileId) {

		return getPersistence().findBypolicyProfile(policyNumber, profileId);
	}

	/**
	 * Returns a range of all the user transaction tokens where policyNumber = &#63; and profileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @return the range of matching user transaction tokens
	 */
	public static List<UserTransactionToken> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end) {

		return getPersistence().findBypolicyProfile(
			policyNumber, profileId, start, end);
	}

	/**
	 * Returns an ordered range of all the user transaction tokens where policyNumber = &#63; and profileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user transaction tokens
	 */
	public static List<UserTransactionToken> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		return getPersistence().findBypolicyProfile(
			policyNumber, profileId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user transaction tokens where policyNumber = &#63; and profileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user transaction tokens
	 */
	public static List<UserTransactionToken> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end,
		OrderByComparator<UserTransactionToken> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBypolicyProfile(
			policyNumber, profileId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first user transaction token in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	public static UserTransactionToken findBypolicyProfile_First(
			String policyNumber, String profileId,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws com.axa.payment.exception.NoSuchUserTransactionTokenException {

		return getPersistence().findBypolicyProfile_First(
			policyNumber, profileId, orderByComparator);
	}

	/**
	 * Returns the first user transaction token in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	public static UserTransactionToken fetchBypolicyProfile_First(
		String policyNumber, String profileId,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		return getPersistence().fetchBypolicyProfile_First(
			policyNumber, profileId, orderByComparator);
	}

	/**
	 * Returns the last user transaction token in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	public static UserTransactionToken findBypolicyProfile_Last(
			String policyNumber, String profileId,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws com.axa.payment.exception.NoSuchUserTransactionTokenException {

		return getPersistence().findBypolicyProfile_Last(
			policyNumber, profileId, orderByComparator);
	}

	/**
	 * Returns the last user transaction token in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	public static UserTransactionToken fetchBypolicyProfile_Last(
		String policyNumber, String profileId,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		return getPersistence().fetchBypolicyProfile_Last(
			policyNumber, profileId, orderByComparator);
	}

	/**
	 * Returns the user transaction tokens before and after the current user transaction token in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param userTransactionTokenId the primary key of the current user transaction token
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user transaction token
	 * @throws NoSuchUserTransactionTokenException if a user transaction token with the primary key could not be found
	 */
	public static UserTransactionToken[] findBypolicyProfile_PrevAndNext(
			long userTransactionTokenId, String policyNumber, String profileId,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws com.axa.payment.exception.NoSuchUserTransactionTokenException {

		return getPersistence().findBypolicyProfile_PrevAndNext(
			userTransactionTokenId, policyNumber, profileId, orderByComparator);
	}

	/**
	 * Removes all the user transaction tokens where policyNumber = &#63; and profileId = &#63; from the database.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 */
	public static void removeBypolicyProfile(
		String policyNumber, String profileId) {

		getPersistence().removeBypolicyProfile(policyNumber, profileId);
	}

	/**
	 * Returns the number of user transaction tokens where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @return the number of matching user transaction tokens
	 */
	public static int countBypolicyProfile(
		String policyNumber, String profileId) {

		return getPersistence().countBypolicyProfile(policyNumber, profileId);
	}

	/**
	 * Returns all the user transaction tokens where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the matching user transaction tokens
	 */
	public static List<UserTransactionToken> findByinvoiceNumber(
		String invoiceNumber) {

		return getPersistence().findByinvoiceNumber(invoiceNumber);
	}

	/**
	 * Returns a range of all the user transaction tokens where invoiceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceNumber the invoice number
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @return the range of matching user transaction tokens
	 */
	public static List<UserTransactionToken> findByinvoiceNumber(
		String invoiceNumber, int start, int end) {

		return getPersistence().findByinvoiceNumber(invoiceNumber, start, end);
	}

	/**
	 * Returns an ordered range of all the user transaction tokens where invoiceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceNumber the invoice number
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user transaction tokens
	 */
	public static List<UserTransactionToken> findByinvoiceNumber(
		String invoiceNumber, int start, int end,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		return getPersistence().findByinvoiceNumber(
			invoiceNumber, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user transaction tokens where invoiceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceNumber the invoice number
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user transaction tokens
	 */
	public static List<UserTransactionToken> findByinvoiceNumber(
		String invoiceNumber, int start, int end,
		OrderByComparator<UserTransactionToken> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByinvoiceNumber(
			invoiceNumber, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user transaction token in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	public static UserTransactionToken findByinvoiceNumber_First(
			String invoiceNumber,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws com.axa.payment.exception.NoSuchUserTransactionTokenException {

		return getPersistence().findByinvoiceNumber_First(
			invoiceNumber, orderByComparator);
	}

	/**
	 * Returns the first user transaction token in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	public static UserTransactionToken fetchByinvoiceNumber_First(
		String invoiceNumber,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		return getPersistence().fetchByinvoiceNumber_First(
			invoiceNumber, orderByComparator);
	}

	/**
	 * Returns the last user transaction token in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	public static UserTransactionToken findByinvoiceNumber_Last(
			String invoiceNumber,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws com.axa.payment.exception.NoSuchUserTransactionTokenException {

		return getPersistence().findByinvoiceNumber_Last(
			invoiceNumber, orderByComparator);
	}

	/**
	 * Returns the last user transaction token in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	public static UserTransactionToken fetchByinvoiceNumber_Last(
		String invoiceNumber,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		return getPersistence().fetchByinvoiceNumber_Last(
			invoiceNumber, orderByComparator);
	}

	/**
	 * Returns the user transaction tokens before and after the current user transaction token in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param userTransactionTokenId the primary key of the current user transaction token
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user transaction token
	 * @throws NoSuchUserTransactionTokenException if a user transaction token with the primary key could not be found
	 */
	public static UserTransactionToken[] findByinvoiceNumber_PrevAndNext(
			long userTransactionTokenId, String invoiceNumber,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws com.axa.payment.exception.NoSuchUserTransactionTokenException {

		return getPersistence().findByinvoiceNumber_PrevAndNext(
			userTransactionTokenId, invoiceNumber, orderByComparator);
	}

	/**
	 * Removes all the user transaction tokens where invoiceNumber = &#63; from the database.
	 *
	 * @param invoiceNumber the invoice number
	 */
	public static void removeByinvoiceNumber(String invoiceNumber) {
		getPersistence().removeByinvoiceNumber(invoiceNumber);
	}

	/**
	 * Returns the number of user transaction tokens where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the number of matching user transaction tokens
	 */
	public static int countByinvoiceNumber(String invoiceNumber) {
		return getPersistence().countByinvoiceNumber(invoiceNumber);
	}

	/**
	 * Returns all the user transaction tokens where token = &#63;.
	 *
	 * @param token the token
	 * @return the matching user transaction tokens
	 */
	public static List<UserTransactionToken> findBytoken(String token) {
		return getPersistence().findBytoken(token);
	}

	/**
	 * Returns a range of all the user transaction tokens where token = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param token the token
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @return the range of matching user transaction tokens
	 */
	public static List<UserTransactionToken> findBytoken(
		String token, int start, int end) {

		return getPersistence().findBytoken(token, start, end);
	}

	/**
	 * Returns an ordered range of all the user transaction tokens where token = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param token the token
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user transaction tokens
	 */
	public static List<UserTransactionToken> findBytoken(
		String token, int start, int end,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		return getPersistence().findBytoken(
			token, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user transaction tokens where token = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param token the token
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user transaction tokens
	 */
	public static List<UserTransactionToken> findBytoken(
		String token, int start, int end,
		OrderByComparator<UserTransactionToken> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBytoken(
			token, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user transaction token in the ordered set where token = &#63;.
	 *
	 * @param token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	public static UserTransactionToken findBytoken_First(
			String token,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws com.axa.payment.exception.NoSuchUserTransactionTokenException {

		return getPersistence().findBytoken_First(token, orderByComparator);
	}

	/**
	 * Returns the first user transaction token in the ordered set where token = &#63;.
	 *
	 * @param token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	public static UserTransactionToken fetchBytoken_First(
		String token,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		return getPersistence().fetchBytoken_First(token, orderByComparator);
	}

	/**
	 * Returns the last user transaction token in the ordered set where token = &#63;.
	 *
	 * @param token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	public static UserTransactionToken findBytoken_Last(
			String token,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws com.axa.payment.exception.NoSuchUserTransactionTokenException {

		return getPersistence().findBytoken_Last(token, orderByComparator);
	}

	/**
	 * Returns the last user transaction token in the ordered set where token = &#63;.
	 *
	 * @param token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	public static UserTransactionToken fetchBytoken_Last(
		String token,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		return getPersistence().fetchBytoken_Last(token, orderByComparator);
	}

	/**
	 * Returns the user transaction tokens before and after the current user transaction token in the ordered set where token = &#63;.
	 *
	 * @param userTransactionTokenId the primary key of the current user transaction token
	 * @param token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user transaction token
	 * @throws NoSuchUserTransactionTokenException if a user transaction token with the primary key could not be found
	 */
	public static UserTransactionToken[] findBytoken_PrevAndNext(
			long userTransactionTokenId, String token,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws com.axa.payment.exception.NoSuchUserTransactionTokenException {

		return getPersistence().findBytoken_PrevAndNext(
			userTransactionTokenId, token, orderByComparator);
	}

	/**
	 * Removes all the user transaction tokens where token = &#63; from the database.
	 *
	 * @param token the token
	 */
	public static void removeBytoken(String token) {
		getPersistence().removeBytoken(token);
	}

	/**
	 * Returns the number of user transaction tokens where token = &#63;.
	 *
	 * @param token the token
	 * @return the number of matching user transaction tokens
	 */
	public static int countBytoken(String token) {
		return getPersistence().countBytoken(token);
	}

	/**
	 * Caches the user transaction token in the entity cache if it is enabled.
	 *
	 * @param userTransactionToken the user transaction token
	 */
	public static void cacheResult(UserTransactionToken userTransactionToken) {
		getPersistence().cacheResult(userTransactionToken);
	}

	/**
	 * Caches the user transaction tokens in the entity cache if it is enabled.
	 *
	 * @param userTransactionTokens the user transaction tokens
	 */
	public static void cacheResult(
		List<UserTransactionToken> userTransactionTokens) {

		getPersistence().cacheResult(userTransactionTokens);
	}

	/**
	 * Creates a new user transaction token with the primary key. Does not add the user transaction token to the database.
	 *
	 * @param userTransactionTokenId the primary key for the new user transaction token
	 * @return the new user transaction token
	 */
	public static UserTransactionToken create(long userTransactionTokenId) {
		return getPersistence().create(userTransactionTokenId);
	}

	/**
	 * Removes the user transaction token with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userTransactionTokenId the primary key of the user transaction token
	 * @return the user transaction token that was removed
	 * @throws NoSuchUserTransactionTokenException if a user transaction token with the primary key could not be found
	 */
	public static UserTransactionToken remove(long userTransactionTokenId)
		throws com.axa.payment.exception.NoSuchUserTransactionTokenException {

		return getPersistence().remove(userTransactionTokenId);
	}

	public static UserTransactionToken updateImpl(
		UserTransactionToken userTransactionToken) {

		return getPersistence().updateImpl(userTransactionToken);
	}

	/**
	 * Returns the user transaction token with the primary key or throws a <code>NoSuchUserTransactionTokenException</code> if it could not be found.
	 *
	 * @param userTransactionTokenId the primary key of the user transaction token
	 * @return the user transaction token
	 * @throws NoSuchUserTransactionTokenException if a user transaction token with the primary key could not be found
	 */
	public static UserTransactionToken findByPrimaryKey(
			long userTransactionTokenId)
		throws com.axa.payment.exception.NoSuchUserTransactionTokenException {

		return getPersistence().findByPrimaryKey(userTransactionTokenId);
	}

	/**
	 * Returns the user transaction token with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userTransactionTokenId the primary key of the user transaction token
	 * @return the user transaction token, or <code>null</code> if a user transaction token with the primary key could not be found
	 */
	public static UserTransactionToken fetchByPrimaryKey(
		long userTransactionTokenId) {

		return getPersistence().fetchByPrimaryKey(userTransactionTokenId);
	}

	/**
	 * Returns all the user transaction tokens.
	 *
	 * @return the user transaction tokens
	 */
	public static List<UserTransactionToken> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user transaction tokens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @return the range of user transaction tokens
	 */
	public static List<UserTransactionToken> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user transaction tokens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user transaction tokens
	 */
	public static List<UserTransactionToken> findAll(
		int start, int end,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user transaction tokens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user transaction tokens
	 */
	public static List<UserTransactionToken> findAll(
		int start, int end,
		OrderByComparator<UserTransactionToken> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user transaction tokens from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user transaction tokens.
	 *
	 * @return the number of user transaction tokens
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserTransactionTokenPersistence getPersistence() {
		return _persistence;
	}

	private static volatile UserTransactionTokenPersistence _persistence;

}