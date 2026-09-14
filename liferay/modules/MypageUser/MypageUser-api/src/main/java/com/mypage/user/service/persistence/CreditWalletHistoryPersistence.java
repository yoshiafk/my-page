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

import com.mypage.user.exception.NoSuchCreditWalletHistoryException;
import com.mypage.user.model.CreditWalletHistory;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the credit wallet history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CreditWalletHistoryUtil
 * @generated
 */
@ProviderType
public interface CreditWalletHistoryPersistence
	extends BasePersistence<CreditWalletHistory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CreditWalletHistoryUtil} to access the credit wallet history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the credit wallet histories where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the matching credit wallet histories
	 */
	public java.util.List<CreditWalletHistory> findBygetCreditWalletId(
		long creditWalletId);

	/**
	 * Returns a range of all the credit wallet histories where creditWalletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @return the range of matching credit wallet histories
	 */
	public java.util.List<CreditWalletHistory> findBygetCreditWalletId(
		long creditWalletId, int start, int end);

	/**
	 * Returns an ordered range of all the credit wallet histories where creditWalletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching credit wallet histories
	 */
	public java.util.List<CreditWalletHistory> findBygetCreditWalletId(
		long creditWalletId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CreditWalletHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the credit wallet histories where creditWalletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching credit wallet histories
	 */
	public java.util.List<CreditWalletHistory> findBygetCreditWalletId(
		long creditWalletId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CreditWalletHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first credit wallet history in the ordered set where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit wallet history
	 * @throws NoSuchCreditWalletHistoryException if a matching credit wallet history could not be found
	 */
	public CreditWalletHistory findBygetCreditWalletId_First(
			long creditWalletId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CreditWalletHistory> orderByComparator)
		throws NoSuchCreditWalletHistoryException;

	/**
	 * Returns the first credit wallet history in the ordered set where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit wallet history, or <code>null</code> if a matching credit wallet history could not be found
	 */
	public CreditWalletHistory fetchBygetCreditWalletId_First(
		long creditWalletId,
		com.liferay.portal.kernel.util.OrderByComparator<CreditWalletHistory>
			orderByComparator);

	/**
	 * Returns the last credit wallet history in the ordered set where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit wallet history
	 * @throws NoSuchCreditWalletHistoryException if a matching credit wallet history could not be found
	 */
	public CreditWalletHistory findBygetCreditWalletId_Last(
			long creditWalletId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CreditWalletHistory> orderByComparator)
		throws NoSuchCreditWalletHistoryException;

	/**
	 * Returns the last credit wallet history in the ordered set where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit wallet history, or <code>null</code> if a matching credit wallet history could not be found
	 */
	public CreditWalletHistory fetchBygetCreditWalletId_Last(
		long creditWalletId,
		com.liferay.portal.kernel.util.OrderByComparator<CreditWalletHistory>
			orderByComparator);

	/**
	 * Returns the credit wallet histories before and after the current credit wallet history in the ordered set where creditWalletId = &#63;.
	 *
	 * @param creditWalletHistoryId the primary key of the current credit wallet history
	 * @param creditWalletId the credit wallet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next credit wallet history
	 * @throws NoSuchCreditWalletHistoryException if a credit wallet history with the primary key could not be found
	 */
	public CreditWalletHistory[] findBygetCreditWalletId_PrevAndNext(
			long creditWalletHistoryId, long creditWalletId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CreditWalletHistory> orderByComparator)
		throws NoSuchCreditWalletHistoryException;

	/**
	 * Removes all the credit wallet histories where creditWalletId = &#63; from the database.
	 *
	 * @param creditWalletId the credit wallet ID
	 */
	public void removeBygetCreditWalletId(long creditWalletId);

	/**
	 * Returns the number of credit wallet histories where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the number of matching credit wallet histories
	 */
	public int countBygetCreditWalletId(long creditWalletId);

	/**
	 * Caches the credit wallet history in the entity cache if it is enabled.
	 *
	 * @param creditWalletHistory the credit wallet history
	 */
	public void cacheResult(CreditWalletHistory creditWalletHistory);

	/**
	 * Caches the credit wallet histories in the entity cache if it is enabled.
	 *
	 * @param creditWalletHistories the credit wallet histories
	 */
	public void cacheResult(
		java.util.List<CreditWalletHistory> creditWalletHistories);

	/**
	 * Creates a new credit wallet history with the primary key. Does not add the credit wallet history to the database.
	 *
	 * @param creditWalletHistoryId the primary key for the new credit wallet history
	 * @return the new credit wallet history
	 */
	public CreditWalletHistory create(long creditWalletHistoryId);

	/**
	 * Removes the credit wallet history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creditWalletHistoryId the primary key of the credit wallet history
	 * @return the credit wallet history that was removed
	 * @throws NoSuchCreditWalletHistoryException if a credit wallet history with the primary key could not be found
	 */
	public CreditWalletHistory remove(long creditWalletHistoryId)
		throws NoSuchCreditWalletHistoryException;

	public CreditWalletHistory updateImpl(
		CreditWalletHistory creditWalletHistory);

	/**
	 * Returns the credit wallet history with the primary key or throws a <code>NoSuchCreditWalletHistoryException</code> if it could not be found.
	 *
	 * @param creditWalletHistoryId the primary key of the credit wallet history
	 * @return the credit wallet history
	 * @throws NoSuchCreditWalletHistoryException if a credit wallet history with the primary key could not be found
	 */
	public CreditWalletHistory findByPrimaryKey(long creditWalletHistoryId)
		throws NoSuchCreditWalletHistoryException;

	/**
	 * Returns the credit wallet history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param creditWalletHistoryId the primary key of the credit wallet history
	 * @return the credit wallet history, or <code>null</code> if a credit wallet history with the primary key could not be found
	 */
	public CreditWalletHistory fetchByPrimaryKey(long creditWalletHistoryId);

	/**
	 * Returns all the credit wallet histories.
	 *
	 * @return the credit wallet histories
	 */
	public java.util.List<CreditWalletHistory> findAll();

	/**
	 * Returns a range of all the credit wallet histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @return the range of credit wallet histories
	 */
	public java.util.List<CreditWalletHistory> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the credit wallet histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of credit wallet histories
	 */
	public java.util.List<CreditWalletHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CreditWalletHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the credit wallet histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of credit wallet histories
	 */
	public java.util.List<CreditWalletHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CreditWalletHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the credit wallet histories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of credit wallet histories.
	 *
	 * @return the number of credit wallet histories
	 */
	public int countAll();

}