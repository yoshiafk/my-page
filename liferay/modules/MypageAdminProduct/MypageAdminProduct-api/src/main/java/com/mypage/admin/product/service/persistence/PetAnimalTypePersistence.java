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

import com.mypage.admin.product.exception.NoSuchPetAnimalTypeException;
import com.mypage.admin.product.model.PetAnimalType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pet animal type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PetAnimalTypeUtil
 * @generated
 */
@ProviderType
public interface PetAnimalTypePersistence
	extends BasePersistence<PetAnimalType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PetAnimalTypeUtil} to access the pet animal type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the pet animal types where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching pet animal types
	 */
	public java.util.List<PetAnimalType> findByfindByName(String name);

	/**
	 * Returns a range of all the pet animal types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @return the range of matching pet animal types
	 */
	public java.util.List<PetAnimalType> findByfindByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the pet animal types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet animal types
	 */
	public java.util.List<PetAnimalType> findByfindByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetAnimalType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pet animal types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet animal types
	 */
	public java.util.List<PetAnimalType> findByfindByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetAnimalType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet animal type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet animal type
	 * @throws NoSuchPetAnimalTypeException if a matching pet animal type could not be found
	 */
	public PetAnimalType findByfindByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<PetAnimalType>
				orderByComparator)
		throws NoSuchPetAnimalTypeException;

	/**
	 * Returns the first pet animal type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet animal type, or <code>null</code> if a matching pet animal type could not be found
	 */
	public PetAnimalType fetchByfindByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<PetAnimalType>
			orderByComparator);

	/**
	 * Returns the last pet animal type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet animal type
	 * @throws NoSuchPetAnimalTypeException if a matching pet animal type could not be found
	 */
	public PetAnimalType findByfindByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<PetAnimalType>
				orderByComparator)
		throws NoSuchPetAnimalTypeException;

	/**
	 * Returns the last pet animal type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet animal type, or <code>null</code> if a matching pet animal type could not be found
	 */
	public PetAnimalType fetchByfindByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<PetAnimalType>
			orderByComparator);

	/**
	 * Returns the pet animal types before and after the current pet animal type in the ordered set where name = &#63;.
	 *
	 * @param petAnimalTypeId the primary key of the current pet animal type
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet animal type
	 * @throws NoSuchPetAnimalTypeException if a pet animal type with the primary key could not be found
	 */
	public PetAnimalType[] findByfindByName_PrevAndNext(
			long petAnimalTypeId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<PetAnimalType>
				orderByComparator)
		throws NoSuchPetAnimalTypeException;

	/**
	 * Removes all the pet animal types where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByfindByName(String name);

	/**
	 * Returns the number of pet animal types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching pet animal types
	 */
	public int countByfindByName(String name);

	/**
	 * Returns the pet animal type where petAnimalTypeId = &#63; or throws a <code>NoSuchPetAnimalTypeException</code> if it could not be found.
	 *
	 * @param petAnimalTypeId the pet animal type ID
	 * @return the matching pet animal type
	 * @throws NoSuchPetAnimalTypeException if a matching pet animal type could not be found
	 */
	public PetAnimalType findBysearchPetAnimalTypeId(long petAnimalTypeId)
		throws NoSuchPetAnimalTypeException;

	/**
	 * Returns the pet animal type where petAnimalTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param petAnimalTypeId the pet animal type ID
	 * @return the matching pet animal type, or <code>null</code> if a matching pet animal type could not be found
	 */
	public PetAnimalType fetchBysearchPetAnimalTypeId(long petAnimalTypeId);

	/**
	 * Returns the pet animal type where petAnimalTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param petAnimalTypeId the pet animal type ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet animal type, or <code>null</code> if a matching pet animal type could not be found
	 */
	public PetAnimalType fetchBysearchPetAnimalTypeId(
		long petAnimalTypeId, boolean useFinderCache);

	/**
	 * Removes the pet animal type where petAnimalTypeId = &#63; from the database.
	 *
	 * @param petAnimalTypeId the pet animal type ID
	 * @return the pet animal type that was removed
	 */
	public PetAnimalType removeBysearchPetAnimalTypeId(long petAnimalTypeId)
		throws NoSuchPetAnimalTypeException;

	/**
	 * Returns the number of pet animal types where petAnimalTypeId = &#63;.
	 *
	 * @param petAnimalTypeId the pet animal type ID
	 * @return the number of matching pet animal types
	 */
	public int countBysearchPetAnimalTypeId(long petAnimalTypeId);

	/**
	 * Caches the pet animal type in the entity cache if it is enabled.
	 *
	 * @param petAnimalType the pet animal type
	 */
	public void cacheResult(PetAnimalType petAnimalType);

	/**
	 * Caches the pet animal types in the entity cache if it is enabled.
	 *
	 * @param petAnimalTypes the pet animal types
	 */
	public void cacheResult(java.util.List<PetAnimalType> petAnimalTypes);

	/**
	 * Creates a new pet animal type with the primary key. Does not add the pet animal type to the database.
	 *
	 * @param petAnimalTypeId the primary key for the new pet animal type
	 * @return the new pet animal type
	 */
	public PetAnimalType create(long petAnimalTypeId);

	/**
	 * Removes the pet animal type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petAnimalTypeId the primary key of the pet animal type
	 * @return the pet animal type that was removed
	 * @throws NoSuchPetAnimalTypeException if a pet animal type with the primary key could not be found
	 */
	public PetAnimalType remove(long petAnimalTypeId)
		throws NoSuchPetAnimalTypeException;

	public PetAnimalType updateImpl(PetAnimalType petAnimalType);

	/**
	 * Returns the pet animal type with the primary key or throws a <code>NoSuchPetAnimalTypeException</code> if it could not be found.
	 *
	 * @param petAnimalTypeId the primary key of the pet animal type
	 * @return the pet animal type
	 * @throws NoSuchPetAnimalTypeException if a pet animal type with the primary key could not be found
	 */
	public PetAnimalType findByPrimaryKey(long petAnimalTypeId)
		throws NoSuchPetAnimalTypeException;

	/**
	 * Returns the pet animal type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petAnimalTypeId the primary key of the pet animal type
	 * @return the pet animal type, or <code>null</code> if a pet animal type with the primary key could not be found
	 */
	public PetAnimalType fetchByPrimaryKey(long petAnimalTypeId);

	/**
	 * Returns all the pet animal types.
	 *
	 * @return the pet animal types
	 */
	public java.util.List<PetAnimalType> findAll();

	/**
	 * Returns a range of all the pet animal types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @return the range of pet animal types
	 */
	public java.util.List<PetAnimalType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pet animal types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pet animal types
	 */
	public java.util.List<PetAnimalType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetAnimalType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pet animal types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pet animal types
	 */
	public java.util.List<PetAnimalType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetAnimalType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pet animal types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pet animal types.
	 *
	 * @return the number of pet animal types
	 */
	public int countAll();

}