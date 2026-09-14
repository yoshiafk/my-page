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

package com.mypage.user.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.user.exception.NoSuchCreditWalletException;
import com.mypage.user.model.CreditWallet;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the credit wallet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CreditWalletUtil
 * @generated
 */
@ProviderType
public interface CreditWalletPersistence extends BasePersistence<CreditWallet> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CreditWalletUtil} to access the credit wallet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the credit wallet in the entity cache if it is enabled.
	 *
	 * @param creditWallet the credit wallet
	 */
	public void cacheResult(CreditWallet creditWallet);

	/**
	 * Caches the credit wallets in the entity cache if it is enabled.
	 *
	 * @param creditWallets the credit wallets
	 */
	public void cacheResult(java.util.List<CreditWallet> creditWallets);

	/**
	 * Creates a new credit wallet with the primary key. Does not add the credit wallet to the database.
	 *
	 * @param creditWalletId the primary key for the new credit wallet
	 * @return the new credit wallet
	 */
	public CreditWallet create(long creditWalletId);

	/**
	 * Removes the credit wallet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creditWalletId the primary key of the credit wallet
	 * @return the credit wallet that was removed
	 * @throws NoSuchCreditWalletException if a credit wallet with the primary key could not be found
	 */
	public CreditWallet remove(long creditWalletId)
		throws NoSuchCreditWalletException;

	public CreditWallet updateImpl(CreditWallet creditWallet);

	/**
	 * Returns the credit wallet with the primary key or throws a <code>NoSuchCreditWalletException</code> if it could not be found.
	 *
	 * @param creditWalletId the primary key of the credit wallet
	 * @return the credit wallet
	 * @throws NoSuchCreditWalletException if a credit wallet with the primary key could not be found
	 */
	public CreditWallet findByPrimaryKey(long creditWalletId)
		throws NoSuchCreditWalletException;

	/**
	 * Returns the credit wallet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param creditWalletId the primary key of the credit wallet
	 * @return the credit wallet, or <code>null</code> if a credit wallet with the primary key could not be found
	 */
	public CreditWallet fetchByPrimaryKey(long creditWalletId);

	/**
	 * Returns all the credit wallets.
	 *
	 * @return the credit wallets
	 */
	public java.util.List<CreditWallet> findAll();

	/**
	 * Returns a range of all the credit wallets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallets
	 * @param end the upper bound of the range of credit wallets (not inclusive)
	 * @return the range of credit wallets
	 */
	public java.util.List<CreditWallet> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the credit wallets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallets
	 * @param end the upper bound of the range of credit wallets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of credit wallets
	 */
	public java.util.List<CreditWallet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CreditWallet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the credit wallets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallets
	 * @param end the upper bound of the range of credit wallets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of credit wallets
	 */
	public java.util.List<CreditWallet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CreditWallet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the credit wallets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of credit wallets.
	 *
	 * @return the number of credit wallets
	 */
	public int countAll();

}