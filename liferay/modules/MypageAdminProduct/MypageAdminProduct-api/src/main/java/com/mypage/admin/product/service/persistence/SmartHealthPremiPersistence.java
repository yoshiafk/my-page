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

import com.mypage.admin.product.exception.NoSuchSmartHealthPremiException;
import com.mypage.admin.product.model.SmartHealthPremi;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the smart health premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartHealthPremiUtil
 * @generated
 */
@ProviderType
public interface SmartHealthPremiPersistence
	extends BasePersistence<SmartHealthPremi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SmartHealthPremiUtil} to access the smart health premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the smart health premi in the entity cache if it is enabled.
	 *
	 * @param smartHealthPremi the smart health premi
	 */
	public void cacheResult(SmartHealthPremi smartHealthPremi);

	/**
	 * Caches the smart health premis in the entity cache if it is enabled.
	 *
	 * @param smartHealthPremis the smart health premis
	 */
	public void cacheResult(java.util.List<SmartHealthPremi> smartHealthPremis);

	/**
	 * Creates a new smart health premi with the primary key. Does not add the smart health premi to the database.
	 *
	 * @param smartHealthPremiId the primary key for the new smart health premi
	 * @return the new smart health premi
	 */
	public SmartHealthPremi create(long smartHealthPremiId);

	/**
	 * Removes the smart health premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartHealthPremiId the primary key of the smart health premi
	 * @return the smart health premi that was removed
	 * @throws NoSuchSmartHealthPremiException if a smart health premi with the primary key could not be found
	 */
	public SmartHealthPremi remove(long smartHealthPremiId)
		throws NoSuchSmartHealthPremiException;

	public SmartHealthPremi updateImpl(SmartHealthPremi smartHealthPremi);

	/**
	 * Returns the smart health premi with the primary key or throws a <code>NoSuchSmartHealthPremiException</code> if it could not be found.
	 *
	 * @param smartHealthPremiId the primary key of the smart health premi
	 * @return the smart health premi
	 * @throws NoSuchSmartHealthPremiException if a smart health premi with the primary key could not be found
	 */
	public SmartHealthPremi findByPrimaryKey(long smartHealthPremiId)
		throws NoSuchSmartHealthPremiException;

	/**
	 * Returns the smart health premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartHealthPremiId the primary key of the smart health premi
	 * @return the smart health premi, or <code>null</code> if a smart health premi with the primary key could not be found
	 */
	public SmartHealthPremi fetchByPrimaryKey(long smartHealthPremiId);

	/**
	 * Returns all the smart health premis.
	 *
	 * @return the smart health premis
	 */
	public java.util.List<SmartHealthPremi> findAll();

	/**
	 * Returns a range of all the smart health premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health premis
	 * @param end the upper bound of the range of smart health premis (not inclusive)
	 * @return the range of smart health premis
	 */
	public java.util.List<SmartHealthPremi> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the smart health premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health premis
	 * @param end the upper bound of the range of smart health premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart health premis
	 */
	public java.util.List<SmartHealthPremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartHealthPremi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smart health premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health premis
	 * @param end the upper bound of the range of smart health premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart health premis
	 */
	public java.util.List<SmartHealthPremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartHealthPremi>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the smart health premis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of smart health premis.
	 *
	 * @return the number of smart health premis
	 */
	public int countAll();

}