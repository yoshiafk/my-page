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

import com.mypage.admin.product.exception.NoSuchPetRemarksException;
import com.mypage.admin.product.model.PetRemarks;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pet remarks service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PetRemarksUtil
 * @generated
 */
@ProviderType
public interface PetRemarksPersistence extends BasePersistence<PetRemarks> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PetRemarksUtil} to access the pet remarks persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the pet remarkses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching pet remarkses
	 */
	public java.util.List<PetRemarks> findByfindByName(String name);

	/**
	 * Returns a range of all the pet remarkses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @return the range of matching pet remarkses
	 */
	public java.util.List<PetRemarks> findByfindByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the pet remarkses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet remarkses
	 */
	public java.util.List<PetRemarks> findByfindByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetRemarks>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pet remarkses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet remarkses
	 */
	public java.util.List<PetRemarks> findByfindByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetRemarks>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet remarks in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet remarks
	 * @throws NoSuchPetRemarksException if a matching pet remarks could not be found
	 */
	public PetRemarks findByfindByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<PetRemarks>
				orderByComparator)
		throws NoSuchPetRemarksException;

	/**
	 * Returns the first pet remarks in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet remarks, or <code>null</code> if a matching pet remarks could not be found
	 */
	public PetRemarks fetchByfindByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<PetRemarks>
			orderByComparator);

	/**
	 * Returns the last pet remarks in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet remarks
	 * @throws NoSuchPetRemarksException if a matching pet remarks could not be found
	 */
	public PetRemarks findByfindByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<PetRemarks>
				orderByComparator)
		throws NoSuchPetRemarksException;

	/**
	 * Returns the last pet remarks in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet remarks, or <code>null</code> if a matching pet remarks could not be found
	 */
	public PetRemarks fetchByfindByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<PetRemarks>
			orderByComparator);

	/**
	 * Returns the pet remarkses before and after the current pet remarks in the ordered set where name = &#63;.
	 *
	 * @param petRemarksId the primary key of the current pet remarks
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet remarks
	 * @throws NoSuchPetRemarksException if a pet remarks with the primary key could not be found
	 */
	public PetRemarks[] findByfindByName_PrevAndNext(
			long petRemarksId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<PetRemarks>
				orderByComparator)
		throws NoSuchPetRemarksException;

	/**
	 * Removes all the pet remarkses where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByfindByName(String name);

	/**
	 * Returns the number of pet remarkses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching pet remarkses
	 */
	public int countByfindByName(String name);

	/**
	 * Caches the pet remarks in the entity cache if it is enabled.
	 *
	 * @param petRemarks the pet remarks
	 */
	public void cacheResult(PetRemarks petRemarks);

	/**
	 * Caches the pet remarkses in the entity cache if it is enabled.
	 *
	 * @param petRemarkses the pet remarkses
	 */
	public void cacheResult(java.util.List<PetRemarks> petRemarkses);

	/**
	 * Creates a new pet remarks with the primary key. Does not add the pet remarks to the database.
	 *
	 * @param petRemarksId the primary key for the new pet remarks
	 * @return the new pet remarks
	 */
	public PetRemarks create(long petRemarksId);

	/**
	 * Removes the pet remarks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petRemarksId the primary key of the pet remarks
	 * @return the pet remarks that was removed
	 * @throws NoSuchPetRemarksException if a pet remarks with the primary key could not be found
	 */
	public PetRemarks remove(long petRemarksId)
		throws NoSuchPetRemarksException;

	public PetRemarks updateImpl(PetRemarks petRemarks);

	/**
	 * Returns the pet remarks with the primary key or throws a <code>NoSuchPetRemarksException</code> if it could not be found.
	 *
	 * @param petRemarksId the primary key of the pet remarks
	 * @return the pet remarks
	 * @throws NoSuchPetRemarksException if a pet remarks with the primary key could not be found
	 */
	public PetRemarks findByPrimaryKey(long petRemarksId)
		throws NoSuchPetRemarksException;

	/**
	 * Returns the pet remarks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petRemarksId the primary key of the pet remarks
	 * @return the pet remarks, or <code>null</code> if a pet remarks with the primary key could not be found
	 */
	public PetRemarks fetchByPrimaryKey(long petRemarksId);

	/**
	 * Returns all the pet remarkses.
	 *
	 * @return the pet remarkses
	 */
	public java.util.List<PetRemarks> findAll();

	/**
	 * Returns a range of all the pet remarkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @return the range of pet remarkses
	 */
	public java.util.List<PetRemarks> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pet remarkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pet remarkses
	 */
	public java.util.List<PetRemarks> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetRemarks>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pet remarkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pet remarkses
	 */
	public java.util.List<PetRemarks> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetRemarks>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pet remarkses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pet remarkses.
	 *
	 * @return the number of pet remarkses
	 */
	public int countAll();

}