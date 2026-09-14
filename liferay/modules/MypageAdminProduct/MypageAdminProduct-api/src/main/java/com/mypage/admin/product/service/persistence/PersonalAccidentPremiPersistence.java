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

import com.mypage.admin.product.exception.NoSuchPersonalAccidentPremiException;
import com.mypage.admin.product.model.PersonalAccidentPremi;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the personal accident premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PersonalAccidentPremiUtil
 * @generated
 */
@ProviderType
public interface PersonalAccidentPremiPersistence
	extends BasePersistence<PersonalAccidentPremi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersonalAccidentPremiUtil} to access the personal accident premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the personal accident premi in the entity cache if it is enabled.
	 *
	 * @param personalAccidentPremi the personal accident premi
	 */
	public void cacheResult(PersonalAccidentPremi personalAccidentPremi);

	/**
	 * Caches the personal accident premis in the entity cache if it is enabled.
	 *
	 * @param personalAccidentPremis the personal accident premis
	 */
	public void cacheResult(
		java.util.List<PersonalAccidentPremi> personalAccidentPremis);

	/**
	 * Creates a new personal accident premi with the primary key. Does not add the personal accident premi to the database.
	 *
	 * @param personalAccidentPremiId the primary key for the new personal accident premi
	 * @return the new personal accident premi
	 */
	public PersonalAccidentPremi create(long personalAccidentPremiId);

	/**
	 * Removes the personal accident premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personalAccidentPremiId the primary key of the personal accident premi
	 * @return the personal accident premi that was removed
	 * @throws NoSuchPersonalAccidentPremiException if a personal accident premi with the primary key could not be found
	 */
	public PersonalAccidentPremi remove(long personalAccidentPremiId)
		throws NoSuchPersonalAccidentPremiException;

	public PersonalAccidentPremi updateImpl(
		PersonalAccidentPremi personalAccidentPremi);

	/**
	 * Returns the personal accident premi with the primary key or throws a <code>NoSuchPersonalAccidentPremiException</code> if it could not be found.
	 *
	 * @param personalAccidentPremiId the primary key of the personal accident premi
	 * @return the personal accident premi
	 * @throws NoSuchPersonalAccidentPremiException if a personal accident premi with the primary key could not be found
	 */
	public PersonalAccidentPremi findByPrimaryKey(long personalAccidentPremiId)
		throws NoSuchPersonalAccidentPremiException;

	/**
	 * Returns the personal accident premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personalAccidentPremiId the primary key of the personal accident premi
	 * @return the personal accident premi, or <code>null</code> if a personal accident premi with the primary key could not be found
	 */
	public PersonalAccidentPremi fetchByPrimaryKey(
		long personalAccidentPremiId);

	/**
	 * Returns all the personal accident premis.
	 *
	 * @return the personal accident premis
	 */
	public java.util.List<PersonalAccidentPremi> findAll();

	/**
	 * Returns a range of all the personal accident premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalAccidentPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal accident premis
	 * @param end the upper bound of the range of personal accident premis (not inclusive)
	 * @return the range of personal accident premis
	 */
	public java.util.List<PersonalAccidentPremi> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the personal accident premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalAccidentPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal accident premis
	 * @param end the upper bound of the range of personal accident premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of personal accident premis
	 */
	public java.util.List<PersonalAccidentPremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalAccidentPremi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the personal accident premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalAccidentPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal accident premis
	 * @param end the upper bound of the range of personal accident premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of personal accident premis
	 */
	public java.util.List<PersonalAccidentPremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalAccidentPremi>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the personal accident premis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of personal accident premis.
	 *
	 * @return the number of personal accident premis
	 */
	public int countAll();

}