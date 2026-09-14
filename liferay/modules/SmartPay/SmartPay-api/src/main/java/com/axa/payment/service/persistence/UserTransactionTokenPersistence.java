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

import com.axa.payment.exception.NoSuchUserTransactionTokenException;
import com.axa.payment.model.UserTransactionToken;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user transaction token service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see UserTransactionTokenUtil
 * @generated
 */
@ProviderType
public interface UserTransactionTokenPersistence
	extends BasePersistence<UserTransactionToken> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserTransactionTokenUtil} to access the user transaction token persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user transaction tokens where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @return the matching user transaction tokens
	 */
	public java.util.List<UserTransactionToken> findBypolicyProfile(
		String policyNumber, String profileId);

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
	public java.util.List<UserTransactionToken> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end);

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
	public java.util.List<UserTransactionToken> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserTransactionToken>
			orderByComparator);

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
	public java.util.List<UserTransactionToken> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserTransactionToken>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user transaction token in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	public UserTransactionToken findBypolicyProfile_First(
			String policyNumber, String profileId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException;

	/**
	 * Returns the first user transaction token in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	public UserTransactionToken fetchBypolicyProfile_First(
		String policyNumber, String profileId,
		com.liferay.portal.kernel.util.OrderByComparator<UserTransactionToken>
			orderByComparator);

	/**
	 * Returns the last user transaction token in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	public UserTransactionToken findBypolicyProfile_Last(
			String policyNumber, String profileId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException;

	/**
	 * Returns the last user transaction token in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	public UserTransactionToken fetchBypolicyProfile_Last(
		String policyNumber, String profileId,
		com.liferay.portal.kernel.util.OrderByComparator<UserTransactionToken>
			orderByComparator);

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
	public UserTransactionToken[] findBypolicyProfile_PrevAndNext(
			long userTransactionTokenId, String policyNumber, String profileId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException;

	/**
	 * Removes all the user transaction tokens where policyNumber = &#63; and profileId = &#63; from the database.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 */
	public void removeBypolicyProfile(String policyNumber, String profileId);

	/**
	 * Returns the number of user transaction tokens where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @return the number of matching user transaction tokens
	 */
	public int countBypolicyProfile(String policyNumber, String profileId);

	/**
	 * Returns all the user transaction tokens where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the matching user transaction tokens
	 */
	public java.util.List<UserTransactionToken> findByinvoiceNumber(
		String invoiceNumber);

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
	public java.util.List<UserTransactionToken> findByinvoiceNumber(
		String invoiceNumber, int start, int end);

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
	public java.util.List<UserTransactionToken> findByinvoiceNumber(
		String invoiceNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserTransactionToken>
			orderByComparator);

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
	public java.util.List<UserTransactionToken> findByinvoiceNumber(
		String invoiceNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserTransactionToken>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user transaction token in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	public UserTransactionToken findByinvoiceNumber_First(
			String invoiceNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException;

	/**
	 * Returns the first user transaction token in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	public UserTransactionToken fetchByinvoiceNumber_First(
		String invoiceNumber,
		com.liferay.portal.kernel.util.OrderByComparator<UserTransactionToken>
			orderByComparator);

	/**
	 * Returns the last user transaction token in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	public UserTransactionToken findByinvoiceNumber_Last(
			String invoiceNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException;

	/**
	 * Returns the last user transaction token in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	public UserTransactionToken fetchByinvoiceNumber_Last(
		String invoiceNumber,
		com.liferay.portal.kernel.util.OrderByComparator<UserTransactionToken>
			orderByComparator);

	/**
	 * Returns the user transaction tokens before and after the current user transaction token in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param userTransactionTokenId the primary key of the current user transaction token
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user transaction token
	 * @throws NoSuchUserTransactionTokenException if a user transaction token with the primary key could not be found
	 */
	public UserTransactionToken[] findByinvoiceNumber_PrevAndNext(
			long userTransactionTokenId, String invoiceNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException;

	/**
	 * Removes all the user transaction tokens where invoiceNumber = &#63; from the database.
	 *
	 * @param invoiceNumber the invoice number
	 */
	public void removeByinvoiceNumber(String invoiceNumber);

	/**
	 * Returns the number of user transaction tokens where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the number of matching user transaction tokens
	 */
	public int countByinvoiceNumber(String invoiceNumber);

	/**
	 * Returns all the user transaction tokens where token = &#63;.
	 *
	 * @param token the token
	 * @return the matching user transaction tokens
	 */
	public java.util.List<UserTransactionToken> findBytoken(String token);

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
	public java.util.List<UserTransactionToken> findBytoken(
		String token, int start, int end);

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
	public java.util.List<UserTransactionToken> findBytoken(
		String token, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserTransactionToken>
			orderByComparator);

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
	public java.util.List<UserTransactionToken> findBytoken(
		String token, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserTransactionToken>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user transaction token in the ordered set where token = &#63;.
	 *
	 * @param token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	public UserTransactionToken findBytoken_First(
			String token,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException;

	/**
	 * Returns the first user transaction token in the ordered set where token = &#63;.
	 *
	 * @param token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	public UserTransactionToken fetchBytoken_First(
		String token,
		com.liferay.portal.kernel.util.OrderByComparator<UserTransactionToken>
			orderByComparator);

	/**
	 * Returns the last user transaction token in the ordered set where token = &#63;.
	 *
	 * @param token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	public UserTransactionToken findBytoken_Last(
			String token,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException;

	/**
	 * Returns the last user transaction token in the ordered set where token = &#63;.
	 *
	 * @param token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	public UserTransactionToken fetchBytoken_Last(
		String token,
		com.liferay.portal.kernel.util.OrderByComparator<UserTransactionToken>
			orderByComparator);

	/**
	 * Returns the user transaction tokens before and after the current user transaction token in the ordered set where token = &#63;.
	 *
	 * @param userTransactionTokenId the primary key of the current user transaction token
	 * @param token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user transaction token
	 * @throws NoSuchUserTransactionTokenException if a user transaction token with the primary key could not be found
	 */
	public UserTransactionToken[] findBytoken_PrevAndNext(
			long userTransactionTokenId, String token,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException;

	/**
	 * Removes all the user transaction tokens where token = &#63; from the database.
	 *
	 * @param token the token
	 */
	public void removeBytoken(String token);

	/**
	 * Returns the number of user transaction tokens where token = &#63;.
	 *
	 * @param token the token
	 * @return the number of matching user transaction tokens
	 */
	public int countBytoken(String token);

	/**
	 * Caches the user transaction token in the entity cache if it is enabled.
	 *
	 * @param userTransactionToken the user transaction token
	 */
	public void cacheResult(UserTransactionToken userTransactionToken);

	/**
	 * Caches the user transaction tokens in the entity cache if it is enabled.
	 *
	 * @param userTransactionTokens the user transaction tokens
	 */
	public void cacheResult(
		java.util.List<UserTransactionToken> userTransactionTokens);

	/**
	 * Creates a new user transaction token with the primary key. Does not add the user transaction token to the database.
	 *
	 * @param userTransactionTokenId the primary key for the new user transaction token
	 * @return the new user transaction token
	 */
	public UserTransactionToken create(long userTransactionTokenId);

	/**
	 * Removes the user transaction token with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userTransactionTokenId the primary key of the user transaction token
	 * @return the user transaction token that was removed
	 * @throws NoSuchUserTransactionTokenException if a user transaction token with the primary key could not be found
	 */
	public UserTransactionToken remove(long userTransactionTokenId)
		throws NoSuchUserTransactionTokenException;

	public UserTransactionToken updateImpl(
		UserTransactionToken userTransactionToken);

	/**
	 * Returns the user transaction token with the primary key or throws a <code>NoSuchUserTransactionTokenException</code> if it could not be found.
	 *
	 * @param userTransactionTokenId the primary key of the user transaction token
	 * @return the user transaction token
	 * @throws NoSuchUserTransactionTokenException if a user transaction token with the primary key could not be found
	 */
	public UserTransactionToken findByPrimaryKey(long userTransactionTokenId)
		throws NoSuchUserTransactionTokenException;

	/**
	 * Returns the user transaction token with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userTransactionTokenId the primary key of the user transaction token
	 * @return the user transaction token, or <code>null</code> if a user transaction token with the primary key could not be found
	 */
	public UserTransactionToken fetchByPrimaryKey(long userTransactionTokenId);

	/**
	 * Returns all the user transaction tokens.
	 *
	 * @return the user transaction tokens
	 */
	public java.util.List<UserTransactionToken> findAll();

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
	public java.util.List<UserTransactionToken> findAll(int start, int end);

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
	public java.util.List<UserTransactionToken> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserTransactionToken>
			orderByComparator);

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
	public java.util.List<UserTransactionToken> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserTransactionToken>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user transaction tokens from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user transaction tokens.
	 *
	 * @return the number of user transaction tokens
	 */
	public int countAll();

}