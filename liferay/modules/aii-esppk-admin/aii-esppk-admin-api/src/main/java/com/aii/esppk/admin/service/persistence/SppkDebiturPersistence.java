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

package com.aii.esppk.admin.service.persistence;

import com.aii.esppk.admin.exception.NoSuchSppkDebiturException;
import com.aii.esppk.admin.model.SppkDebitur;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sppk debitur service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see SppkDebiturUtil
 * @generated
 */
@ProviderType
public interface SppkDebiturPersistence extends BasePersistence<SppkDebitur> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SppkDebiturUtil} to access the sppk debitur persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the sppk debitur in the entity cache if it is enabled.
	 *
	 * @param sppkDebitur the sppk debitur
	 */
	public void cacheResult(SppkDebitur sppkDebitur);

	/**
	 * Caches the sppk debiturs in the entity cache if it is enabled.
	 *
	 * @param sppkDebiturs the sppk debiturs
	 */
	public void cacheResult(java.util.List<SppkDebitur> sppkDebiturs);

	/**
	 * Creates a new sppk debitur with the primary key. Does not add the sppk debitur to the database.
	 *
	 * @param sppkDebiturId the primary key for the new sppk debitur
	 * @return the new sppk debitur
	 */
	public SppkDebitur create(long sppkDebiturId);

	/**
	 * Removes the sppk debitur with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sppkDebiturId the primary key of the sppk debitur
	 * @return the sppk debitur that was removed
	 * @throws NoSuchSppkDebiturException if a sppk debitur with the primary key could not be found
	 */
	public SppkDebitur remove(long sppkDebiturId)
		throws NoSuchSppkDebiturException;

	public SppkDebitur updateImpl(SppkDebitur sppkDebitur);

	/**
	 * Returns the sppk debitur with the primary key or throws a <code>NoSuchSppkDebiturException</code> if it could not be found.
	 *
	 * @param sppkDebiturId the primary key of the sppk debitur
	 * @return the sppk debitur
	 * @throws NoSuchSppkDebiturException if a sppk debitur with the primary key could not be found
	 */
	public SppkDebitur findByPrimaryKey(long sppkDebiturId)
		throws NoSuchSppkDebiturException;

	/**
	 * Returns the sppk debitur with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sppkDebiturId the primary key of the sppk debitur
	 * @return the sppk debitur, or <code>null</code> if a sppk debitur with the primary key could not be found
	 */
	public SppkDebitur fetchByPrimaryKey(long sppkDebiturId);

	/**
	 * Returns all the sppk debiturs.
	 *
	 * @return the sppk debiturs
	 */
	public java.util.List<SppkDebitur> findAll();

	/**
	 * Returns a range of all the sppk debiturs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkDebiturModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sppk debiturs
	 * @param end the upper bound of the range of sppk debiturs (not inclusive)
	 * @return the range of sppk debiturs
	 */
	public java.util.List<SppkDebitur> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the sppk debiturs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkDebiturModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sppk debiturs
	 * @param end the upper bound of the range of sppk debiturs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sppk debiturs
	 */
	public java.util.List<SppkDebitur> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SppkDebitur>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sppk debiturs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkDebiturModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sppk debiturs
	 * @param end the upper bound of the range of sppk debiturs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sppk debiturs
	 */
	public java.util.List<SppkDebitur> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SppkDebitur>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sppk debiturs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sppk debiturs.
	 *
	 * @return the number of sppk debiturs
	 */
	public int countAll();

}