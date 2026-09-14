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

import com.mypage.admin.product.exception.NoSuchSmartActiveOccupationException;
import com.mypage.admin.product.model.SmartActiveOccupation;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the smart active occupation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveOccupationUtil
 * @generated
 */
@ProviderType
public interface SmartActiveOccupationPersistence
	extends BasePersistence<SmartActiveOccupation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SmartActiveOccupationUtil} to access the smart active occupation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the smart active occupation where code = &#63; or throws a <code>NoSuchSmartActiveOccupationException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching smart active occupation
	 * @throws NoSuchSmartActiveOccupationException if a matching smart active occupation could not be found
	 */
	public SmartActiveOccupation findBycode(String code)
		throws NoSuchSmartActiveOccupationException;

	/**
	 * Returns the smart active occupation where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching smart active occupation, or <code>null</code> if a matching smart active occupation could not be found
	 */
	public SmartActiveOccupation fetchBycode(String code);

	/**
	 * Returns the smart active occupation where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active occupation, or <code>null</code> if a matching smart active occupation could not be found
	 */
	public SmartActiveOccupation fetchBycode(
		String code, boolean useFinderCache);

	/**
	 * Removes the smart active occupation where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the smart active occupation that was removed
	 */
	public SmartActiveOccupation removeBycode(String code)
		throws NoSuchSmartActiveOccupationException;

	/**
	 * Returns the number of smart active occupations where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching smart active occupations
	 */
	public int countBycode(String code);

	/**
	 * Caches the smart active occupation in the entity cache if it is enabled.
	 *
	 * @param smartActiveOccupation the smart active occupation
	 */
	public void cacheResult(SmartActiveOccupation smartActiveOccupation);

	/**
	 * Caches the smart active occupations in the entity cache if it is enabled.
	 *
	 * @param smartActiveOccupations the smart active occupations
	 */
	public void cacheResult(
		java.util.List<SmartActiveOccupation> smartActiveOccupations);

	/**
	 * Creates a new smart active occupation with the primary key. Does not add the smart active occupation to the database.
	 *
	 * @param smartActiveOccupationId the primary key for the new smart active occupation
	 * @return the new smart active occupation
	 */
	public SmartActiveOccupation create(long smartActiveOccupationId);

	/**
	 * Removes the smart active occupation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveOccupationId the primary key of the smart active occupation
	 * @return the smart active occupation that was removed
	 * @throws NoSuchSmartActiveOccupationException if a smart active occupation with the primary key could not be found
	 */
	public SmartActiveOccupation remove(long smartActiveOccupationId)
		throws NoSuchSmartActiveOccupationException;

	public SmartActiveOccupation updateImpl(
		SmartActiveOccupation smartActiveOccupation);

	/**
	 * Returns the smart active occupation with the primary key or throws a <code>NoSuchSmartActiveOccupationException</code> if it could not be found.
	 *
	 * @param smartActiveOccupationId the primary key of the smart active occupation
	 * @return the smart active occupation
	 * @throws NoSuchSmartActiveOccupationException if a smart active occupation with the primary key could not be found
	 */
	public SmartActiveOccupation findByPrimaryKey(long smartActiveOccupationId)
		throws NoSuchSmartActiveOccupationException;

	/**
	 * Returns the smart active occupation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveOccupationId the primary key of the smart active occupation
	 * @return the smart active occupation, or <code>null</code> if a smart active occupation with the primary key could not be found
	 */
	public SmartActiveOccupation fetchByPrimaryKey(
		long smartActiveOccupationId);

	/**
	 * Returns all the smart active occupations.
	 *
	 * @return the smart active occupations
	 */
	public java.util.List<SmartActiveOccupation> findAll();

	/**
	 * Returns a range of all the smart active occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active occupations
	 * @param end the upper bound of the range of smart active occupations (not inclusive)
	 * @return the range of smart active occupations
	 */
	public java.util.List<SmartActiveOccupation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the smart active occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active occupations
	 * @param end the upper bound of the range of smart active occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active occupations
	 */
	public java.util.List<SmartActiveOccupation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActiveOccupation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smart active occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active occupations
	 * @param end the upper bound of the range of smart active occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active occupations
	 */
	public java.util.List<SmartActiveOccupation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActiveOccupation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the smart active occupations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of smart active occupations.
	 *
	 * @return the number of smart active occupations
	 */
	public int countAll();

}