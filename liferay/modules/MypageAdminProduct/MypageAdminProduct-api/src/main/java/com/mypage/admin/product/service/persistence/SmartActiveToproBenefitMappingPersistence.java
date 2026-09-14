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

import com.mypage.admin.product.exception.NoSuchSmartActiveToproBenefitMappingException;
import com.mypage.admin.product.model.SmartActiveToproBenefitMapping;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the smart active topro benefit mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveToproBenefitMappingUtil
 * @generated
 */
@ProviderType
public interface SmartActiveToproBenefitMappingPersistence
	extends BasePersistence<SmartActiveToproBenefitMapping> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SmartActiveToproBenefitMappingUtil} to access the smart active topro benefit mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the smart active topro benefit mappings where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @return the matching smart active topro benefit mappings
	 */
	public java.util.List<SmartActiveToproBenefitMapping> findByToproId(
		long smartActiveToproId);

	/**
	 * Returns a range of all the smart active topro benefit mappings where smartActiveToproId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @return the range of matching smart active topro benefit mappings
	 */
	public java.util.List<SmartActiveToproBenefitMapping> findByToproId(
		long smartActiveToproId, int start, int end);

	/**
	 * Returns an ordered range of all the smart active topro benefit mappings where smartActiveToproId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smart active topro benefit mappings
	 */
	public java.util.List<SmartActiveToproBenefitMapping> findByToproId(
		long smartActiveToproId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SmartActiveToproBenefitMapping> orderByComparator);

	/**
	 * Returns an ordered range of all the smart active topro benefit mappings where smartActiveToproId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smart active topro benefit mappings
	 */
	public java.util.List<SmartActiveToproBenefitMapping> findByToproId(
		long smartActiveToproId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SmartActiveToproBenefitMapping> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first smart active topro benefit mapping in the ordered set where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart active topro benefit mapping
	 * @throws NoSuchSmartActiveToproBenefitMappingException if a matching smart active topro benefit mapping could not be found
	 */
	public SmartActiveToproBenefitMapping findByToproId_First(
			long smartActiveToproId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SmartActiveToproBenefitMapping> orderByComparator)
		throws NoSuchSmartActiveToproBenefitMappingException;

	/**
	 * Returns the first smart active topro benefit mapping in the ordered set where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart active topro benefit mapping, or <code>null</code> if a matching smart active topro benefit mapping could not be found
	 */
	public SmartActiveToproBenefitMapping fetchByToproId_First(
		long smartActiveToproId,
		com.liferay.portal.kernel.util.OrderByComparator
			<SmartActiveToproBenefitMapping> orderByComparator);

	/**
	 * Returns the last smart active topro benefit mapping in the ordered set where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart active topro benefit mapping
	 * @throws NoSuchSmartActiveToproBenefitMappingException if a matching smart active topro benefit mapping could not be found
	 */
	public SmartActiveToproBenefitMapping findByToproId_Last(
			long smartActiveToproId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SmartActiveToproBenefitMapping> orderByComparator)
		throws NoSuchSmartActiveToproBenefitMappingException;

	/**
	 * Returns the last smart active topro benefit mapping in the ordered set where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart active topro benefit mapping, or <code>null</code> if a matching smart active topro benefit mapping could not be found
	 */
	public SmartActiveToproBenefitMapping fetchByToproId_Last(
		long smartActiveToproId,
		com.liferay.portal.kernel.util.OrderByComparator
			<SmartActiveToproBenefitMapping> orderByComparator);

	/**
	 * Returns the smart active topro benefit mappings before and after the current smart active topro benefit mapping in the ordered set where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproBenefitMappingId the primary key of the current smart active topro benefit mapping
	 * @param smartActiveToproId the smart active topro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next smart active topro benefit mapping
	 * @throws NoSuchSmartActiveToproBenefitMappingException if a smart active topro benefit mapping with the primary key could not be found
	 */
	public SmartActiveToproBenefitMapping[] findByToproId_PrevAndNext(
			long smartActiveToproBenefitMappingId, long smartActiveToproId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SmartActiveToproBenefitMapping> orderByComparator)
		throws NoSuchSmartActiveToproBenefitMappingException;

	/**
	 * Removes all the smart active topro benefit mappings where smartActiveToproId = &#63; from the database.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 */
	public void removeByToproId(long smartActiveToproId);

	/**
	 * Returns the number of smart active topro benefit mappings where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @return the number of matching smart active topro benefit mappings
	 */
	public int countByToproId(long smartActiveToproId);

	/**
	 * Caches the smart active topro benefit mapping in the entity cache if it is enabled.
	 *
	 * @param smartActiveToproBenefitMapping the smart active topro benefit mapping
	 */
	public void cacheResult(
		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping);

	/**
	 * Caches the smart active topro benefit mappings in the entity cache if it is enabled.
	 *
	 * @param smartActiveToproBenefitMappings the smart active topro benefit mappings
	 */
	public void cacheResult(
		java.util.List<SmartActiveToproBenefitMapping>
			smartActiveToproBenefitMappings);

	/**
	 * Creates a new smart active topro benefit mapping with the primary key. Does not add the smart active topro benefit mapping to the database.
	 *
	 * @param smartActiveToproBenefitMappingId the primary key for the new smart active topro benefit mapping
	 * @return the new smart active topro benefit mapping
	 */
	public SmartActiveToproBenefitMapping create(
		long smartActiveToproBenefitMappingId);

	/**
	 * Removes the smart active topro benefit mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveToproBenefitMappingId the primary key of the smart active topro benefit mapping
	 * @return the smart active topro benefit mapping that was removed
	 * @throws NoSuchSmartActiveToproBenefitMappingException if a smart active topro benefit mapping with the primary key could not be found
	 */
	public SmartActiveToproBenefitMapping remove(
			long smartActiveToproBenefitMappingId)
		throws NoSuchSmartActiveToproBenefitMappingException;

	public SmartActiveToproBenefitMapping updateImpl(
		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping);

	/**
	 * Returns the smart active topro benefit mapping with the primary key or throws a <code>NoSuchSmartActiveToproBenefitMappingException</code> if it could not be found.
	 *
	 * @param smartActiveToproBenefitMappingId the primary key of the smart active topro benefit mapping
	 * @return the smart active topro benefit mapping
	 * @throws NoSuchSmartActiveToproBenefitMappingException if a smart active topro benefit mapping with the primary key could not be found
	 */
	public SmartActiveToproBenefitMapping findByPrimaryKey(
			long smartActiveToproBenefitMappingId)
		throws NoSuchSmartActiveToproBenefitMappingException;

	/**
	 * Returns the smart active topro benefit mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveToproBenefitMappingId the primary key of the smart active topro benefit mapping
	 * @return the smart active topro benefit mapping, or <code>null</code> if a smart active topro benefit mapping with the primary key could not be found
	 */
	public SmartActiveToproBenefitMapping fetchByPrimaryKey(
		long smartActiveToproBenefitMappingId);

	/**
	 * Returns all the smart active topro benefit mappings.
	 *
	 * @return the smart active topro benefit mappings
	 */
	public java.util.List<SmartActiveToproBenefitMapping> findAll();

	/**
	 * Returns a range of all the smart active topro benefit mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @return the range of smart active topro benefit mappings
	 */
	public java.util.List<SmartActiveToproBenefitMapping> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the smart active topro benefit mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active topro benefit mappings
	 */
	public java.util.List<SmartActiveToproBenefitMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SmartActiveToproBenefitMapping> orderByComparator);

	/**
	 * Returns an ordered range of all the smart active topro benefit mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active topro benefit mappings
	 */
	public java.util.List<SmartActiveToproBenefitMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SmartActiveToproBenefitMapping> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the smart active topro benefit mappings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of smart active topro benefit mappings.
	 *
	 * @return the number of smart active topro benefit mappings
	 */
	public int countAll();

}