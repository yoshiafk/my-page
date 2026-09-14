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

import com.mypage.admin.product.exception.NoSuchSmartActiveBenefitValueMappingException;
import com.mypage.admin.product.model.SmartActiveBenefitValueMapping;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the smart active benefit value mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveBenefitValueMappingUtil
 * @generated
 */
@ProviderType
public interface SmartActiveBenefitValueMappingPersistence
	extends BasePersistence<SmartActiveBenefitValueMapping> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SmartActiveBenefitValueMappingUtil} to access the smart active benefit value mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the smart active benefit value mappings where smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the matching smart active benefit value mappings
	 */
	public java.util.List<SmartActiveBenefitValueMapping> findByBenefitValueId(
		long smartActiveBenefitValueId);

	/**
	 * Returns a range of all the smart active benefit value mappings where smartActiveBenefitValueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param start the lower bound of the range of smart active benefit value mappings
	 * @param end the upper bound of the range of smart active benefit value mappings (not inclusive)
	 * @return the range of matching smart active benefit value mappings
	 */
	public java.util.List<SmartActiveBenefitValueMapping> findByBenefitValueId(
		long smartActiveBenefitValueId, int start, int end);

	/**
	 * Returns an ordered range of all the smart active benefit value mappings where smartActiveBenefitValueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param start the lower bound of the range of smart active benefit value mappings
	 * @param end the upper bound of the range of smart active benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smart active benefit value mappings
	 */
	public java.util.List<SmartActiveBenefitValueMapping> findByBenefitValueId(
		long smartActiveBenefitValueId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SmartActiveBenefitValueMapping> orderByComparator);

	/**
	 * Returns an ordered range of all the smart active benefit value mappings where smartActiveBenefitValueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param start the lower bound of the range of smart active benefit value mappings
	 * @param end the upper bound of the range of smart active benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smart active benefit value mappings
	 */
	public java.util.List<SmartActiveBenefitValueMapping> findByBenefitValueId(
		long smartActiveBenefitValueId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SmartActiveBenefitValueMapping> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first smart active benefit value mapping in the ordered set where smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart active benefit value mapping
	 * @throws NoSuchSmartActiveBenefitValueMappingException if a matching smart active benefit value mapping could not be found
	 */
	public SmartActiveBenefitValueMapping findByBenefitValueId_First(
			long smartActiveBenefitValueId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SmartActiveBenefitValueMapping> orderByComparator)
		throws NoSuchSmartActiveBenefitValueMappingException;

	/**
	 * Returns the first smart active benefit value mapping in the ordered set where smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart active benefit value mapping, or <code>null</code> if a matching smart active benefit value mapping could not be found
	 */
	public SmartActiveBenefitValueMapping fetchByBenefitValueId_First(
		long smartActiveBenefitValueId,
		com.liferay.portal.kernel.util.OrderByComparator
			<SmartActiveBenefitValueMapping> orderByComparator);

	/**
	 * Returns the last smart active benefit value mapping in the ordered set where smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart active benefit value mapping
	 * @throws NoSuchSmartActiveBenefitValueMappingException if a matching smart active benefit value mapping could not be found
	 */
	public SmartActiveBenefitValueMapping findByBenefitValueId_Last(
			long smartActiveBenefitValueId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SmartActiveBenefitValueMapping> orderByComparator)
		throws NoSuchSmartActiveBenefitValueMappingException;

	/**
	 * Returns the last smart active benefit value mapping in the ordered set where smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart active benefit value mapping, or <code>null</code> if a matching smart active benefit value mapping could not be found
	 */
	public SmartActiveBenefitValueMapping fetchByBenefitValueId_Last(
		long smartActiveBenefitValueId,
		com.liferay.portal.kernel.util.OrderByComparator
			<SmartActiveBenefitValueMapping> orderByComparator);

	/**
	 * Returns the smart active benefit value mappings before and after the current smart active benefit value mapping in the ordered set where smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitValueMappingId the primary key of the current smart active benefit value mapping
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next smart active benefit value mapping
	 * @throws NoSuchSmartActiveBenefitValueMappingException if a smart active benefit value mapping with the primary key could not be found
	 */
	public SmartActiveBenefitValueMapping[] findByBenefitValueId_PrevAndNext(
			long smartActiveBenefitValueMappingId,
			long smartActiveBenefitValueId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SmartActiveBenefitValueMapping> orderByComparator)
		throws NoSuchSmartActiveBenefitValueMappingException;

	/**
	 * Removes all the smart active benefit value mappings where smartActiveBenefitValueId = &#63; from the database.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 */
	public void removeByBenefitValueId(long smartActiveBenefitValueId);

	/**
	 * Returns the number of smart active benefit value mappings where smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the number of matching smart active benefit value mappings
	 */
	public int countByBenefitValueId(long smartActiveBenefitValueId);

	/**
	 * Returns the smart active benefit value mapping where smartActiveBenefitId = &#63; and smartActiveBenefitValueId = &#63; or throws a <code>NoSuchSmartActiveBenefitValueMappingException</code> if it could not be found.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the matching smart active benefit value mapping
	 * @throws NoSuchSmartActiveBenefitValueMappingException if a matching smart active benefit value mapping could not be found
	 */
	public SmartActiveBenefitValueMapping findByBenefitIdAndBenefitValueId(
			long smartActiveBenefitId, long smartActiveBenefitValueId)
		throws NoSuchSmartActiveBenefitValueMappingException;

	/**
	 * Returns the smart active benefit value mapping where smartActiveBenefitId = &#63; and smartActiveBenefitValueId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the matching smart active benefit value mapping, or <code>null</code> if a matching smart active benefit value mapping could not be found
	 */
	public SmartActiveBenefitValueMapping fetchByBenefitIdAndBenefitValueId(
		long smartActiveBenefitId, long smartActiveBenefitValueId);

	/**
	 * Returns the smart active benefit value mapping where smartActiveBenefitId = &#63; and smartActiveBenefitValueId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active benefit value mapping, or <code>null</code> if a matching smart active benefit value mapping could not be found
	 */
	public SmartActiveBenefitValueMapping fetchByBenefitIdAndBenefitValueId(
		long smartActiveBenefitId, long smartActiveBenefitValueId,
		boolean useFinderCache);

	/**
	 * Removes the smart active benefit value mapping where smartActiveBenefitId = &#63; and smartActiveBenefitValueId = &#63; from the database.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the smart active benefit value mapping that was removed
	 */
	public SmartActiveBenefitValueMapping removeByBenefitIdAndBenefitValueId(
			long smartActiveBenefitId, long smartActiveBenefitValueId)
		throws NoSuchSmartActiveBenefitValueMappingException;

	/**
	 * Returns the number of smart active benefit value mappings where smartActiveBenefitId = &#63; and smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the number of matching smart active benefit value mappings
	 */
	public int countByBenefitIdAndBenefitValueId(
		long smartActiveBenefitId, long smartActiveBenefitValueId);

	/**
	 * Caches the smart active benefit value mapping in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefitValueMapping the smart active benefit value mapping
	 */
	public void cacheResult(
		SmartActiveBenefitValueMapping smartActiveBenefitValueMapping);

	/**
	 * Caches the smart active benefit value mappings in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefitValueMappings the smart active benefit value mappings
	 */
	public void cacheResult(
		java.util.List<SmartActiveBenefitValueMapping>
			smartActiveBenefitValueMappings);

	/**
	 * Creates a new smart active benefit value mapping with the primary key. Does not add the smart active benefit value mapping to the database.
	 *
	 * @param smartActiveBenefitValueMappingId the primary key for the new smart active benefit value mapping
	 * @return the new smart active benefit value mapping
	 */
	public SmartActiveBenefitValueMapping create(
		long smartActiveBenefitValueMappingId);

	/**
	 * Removes the smart active benefit value mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveBenefitValueMappingId the primary key of the smart active benefit value mapping
	 * @return the smart active benefit value mapping that was removed
	 * @throws NoSuchSmartActiveBenefitValueMappingException if a smart active benefit value mapping with the primary key could not be found
	 */
	public SmartActiveBenefitValueMapping remove(
			long smartActiveBenefitValueMappingId)
		throws NoSuchSmartActiveBenefitValueMappingException;

	public SmartActiveBenefitValueMapping updateImpl(
		SmartActiveBenefitValueMapping smartActiveBenefitValueMapping);

	/**
	 * Returns the smart active benefit value mapping with the primary key or throws a <code>NoSuchSmartActiveBenefitValueMappingException</code> if it could not be found.
	 *
	 * @param smartActiveBenefitValueMappingId the primary key of the smart active benefit value mapping
	 * @return the smart active benefit value mapping
	 * @throws NoSuchSmartActiveBenefitValueMappingException if a smart active benefit value mapping with the primary key could not be found
	 */
	public SmartActiveBenefitValueMapping findByPrimaryKey(
			long smartActiveBenefitValueMappingId)
		throws NoSuchSmartActiveBenefitValueMappingException;

	/**
	 * Returns the smart active benefit value mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveBenefitValueMappingId the primary key of the smart active benefit value mapping
	 * @return the smart active benefit value mapping, or <code>null</code> if a smart active benefit value mapping with the primary key could not be found
	 */
	public SmartActiveBenefitValueMapping fetchByPrimaryKey(
		long smartActiveBenefitValueMappingId);

	/**
	 * Returns all the smart active benefit value mappings.
	 *
	 * @return the smart active benefit value mappings
	 */
	public java.util.List<SmartActiveBenefitValueMapping> findAll();

	/**
	 * Returns a range of all the smart active benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit value mappings
	 * @param end the upper bound of the range of smart active benefit value mappings (not inclusive)
	 * @return the range of smart active benefit value mappings
	 */
	public java.util.List<SmartActiveBenefitValueMapping> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the smart active benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit value mappings
	 * @param end the upper bound of the range of smart active benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active benefit value mappings
	 */
	public java.util.List<SmartActiveBenefitValueMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SmartActiveBenefitValueMapping> orderByComparator);

	/**
	 * Returns an ordered range of all the smart active benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit value mappings
	 * @param end the upper bound of the range of smart active benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active benefit value mappings
	 */
	public java.util.List<SmartActiveBenefitValueMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SmartActiveBenefitValueMapping> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the smart active benefit value mappings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of smart active benefit value mappings.
	 *
	 * @return the number of smart active benefit value mappings
	 */
	public int countAll();

}