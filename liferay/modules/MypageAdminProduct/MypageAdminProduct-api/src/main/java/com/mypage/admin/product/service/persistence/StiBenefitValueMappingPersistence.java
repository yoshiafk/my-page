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

import com.mypage.admin.product.exception.NoSuchStiBenefitValueMappingException;
import com.mypage.admin.product.model.StiBenefitValueMapping;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sti benefit value mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see StiBenefitValueMappingUtil
 * @generated
 */
@ProviderType
public interface StiBenefitValueMappingPersistence
	extends BasePersistence<StiBenefitValueMapping> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StiBenefitValueMappingUtil} to access the sti benefit value mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the sti benefit value mappings where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @return the matching sti benefit value mappings
	 */
	public java.util.List<StiBenefitValueMapping> findByBenefitTypeId(
		long benefitTypeId);

	/**
	 * Returns a range of all the sti benefit value mappings where benefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @return the range of matching sti benefit value mappings
	 */
	public java.util.List<StiBenefitValueMapping> findByBenefitTypeId(
		long benefitTypeId, int start, int end);

	/**
	 * Returns an ordered range of all the sti benefit value mappings where benefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sti benefit value mappings
	 */
	public java.util.List<StiBenefitValueMapping> findByBenefitTypeId(
		long benefitTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StiBenefitValueMapping>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sti benefit value mappings where benefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sti benefit value mappings
	 */
	public java.util.List<StiBenefitValueMapping> findByBenefitTypeId(
		long benefitTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StiBenefitValueMapping>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sti benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sti benefit value mapping
	 * @throws NoSuchStiBenefitValueMappingException if a matching sti benefit value mapping could not be found
	 */
	public StiBenefitValueMapping findByBenefitTypeId_First(
			long benefitTypeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<StiBenefitValueMapping> orderByComparator)
		throws NoSuchStiBenefitValueMappingException;

	/**
	 * Returns the first sti benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sti benefit value mapping, or <code>null</code> if a matching sti benefit value mapping could not be found
	 */
	public StiBenefitValueMapping fetchByBenefitTypeId_First(
		long benefitTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<StiBenefitValueMapping>
			orderByComparator);

	/**
	 * Returns the last sti benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sti benefit value mapping
	 * @throws NoSuchStiBenefitValueMappingException if a matching sti benefit value mapping could not be found
	 */
	public StiBenefitValueMapping findByBenefitTypeId_Last(
			long benefitTypeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<StiBenefitValueMapping> orderByComparator)
		throws NoSuchStiBenefitValueMappingException;

	/**
	 * Returns the last sti benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sti benefit value mapping, or <code>null</code> if a matching sti benefit value mapping could not be found
	 */
	public StiBenefitValueMapping fetchByBenefitTypeId_Last(
		long benefitTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<StiBenefitValueMapping>
			orderByComparator);

	/**
	 * Returns the sti benefit value mappings before and after the current sti benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitValueMappingId the primary key of the current sti benefit value mapping
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sti benefit value mapping
	 * @throws NoSuchStiBenefitValueMappingException if a sti benefit value mapping with the primary key could not be found
	 */
	public StiBenefitValueMapping[] findByBenefitTypeId_PrevAndNext(
			long benefitValueMappingId, long benefitTypeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<StiBenefitValueMapping> orderByComparator)
		throws NoSuchStiBenefitValueMappingException;

	/**
	 * Removes all the sti benefit value mappings where benefitTypeId = &#63; from the database.
	 *
	 * @param benefitTypeId the benefit type ID
	 */
	public void removeByBenefitTypeId(long benefitTypeId);

	/**
	 * Returns the number of sti benefit value mappings where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @return the number of matching sti benefit value mappings
	 */
	public int countByBenefitTypeId(long benefitTypeId);

	/**
	 * Returns all the sti benefit value mappings where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @return the matching sti benefit value mappings
	 */
	public java.util.List<StiBenefitValueMapping>
		findByBenefitTypeIdAndBenefitId(long benefitTypeId, long benefitId);

	/**
	 * Returns a range of all the sti benefit value mappings where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @return the range of matching sti benefit value mappings
	 */
	public java.util.List<StiBenefitValueMapping>
		findByBenefitTypeIdAndBenefitId(
			long benefitTypeId, long benefitId, int start, int end);

	/**
	 * Returns an ordered range of all the sti benefit value mappings where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sti benefit value mappings
	 */
	public java.util.List<StiBenefitValueMapping>
		findByBenefitTypeIdAndBenefitId(
			long benefitTypeId, long benefitId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<StiBenefitValueMapping> orderByComparator);

	/**
	 * Returns an ordered range of all the sti benefit value mappings where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sti benefit value mappings
	 */
	public java.util.List<StiBenefitValueMapping>
		findByBenefitTypeIdAndBenefitId(
			long benefitTypeId, long benefitId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<StiBenefitValueMapping> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first sti benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sti benefit value mapping
	 * @throws NoSuchStiBenefitValueMappingException if a matching sti benefit value mapping could not be found
	 */
	public StiBenefitValueMapping findByBenefitTypeIdAndBenefitId_First(
			long benefitTypeId, long benefitId,
			com.liferay.portal.kernel.util.OrderByComparator
				<StiBenefitValueMapping> orderByComparator)
		throws NoSuchStiBenefitValueMappingException;

	/**
	 * Returns the first sti benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sti benefit value mapping, or <code>null</code> if a matching sti benefit value mapping could not be found
	 */
	public StiBenefitValueMapping fetchByBenefitTypeIdAndBenefitId_First(
		long benefitTypeId, long benefitId,
		com.liferay.portal.kernel.util.OrderByComparator<StiBenefitValueMapping>
			orderByComparator);

	/**
	 * Returns the last sti benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sti benefit value mapping
	 * @throws NoSuchStiBenefitValueMappingException if a matching sti benefit value mapping could not be found
	 */
	public StiBenefitValueMapping findByBenefitTypeIdAndBenefitId_Last(
			long benefitTypeId, long benefitId,
			com.liferay.portal.kernel.util.OrderByComparator
				<StiBenefitValueMapping> orderByComparator)
		throws NoSuchStiBenefitValueMappingException;

	/**
	 * Returns the last sti benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sti benefit value mapping, or <code>null</code> if a matching sti benefit value mapping could not be found
	 */
	public StiBenefitValueMapping fetchByBenefitTypeIdAndBenefitId_Last(
		long benefitTypeId, long benefitId,
		com.liferay.portal.kernel.util.OrderByComparator<StiBenefitValueMapping>
			orderByComparator);

	/**
	 * Returns the sti benefit value mappings before and after the current sti benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitValueMappingId the primary key of the current sti benefit value mapping
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sti benefit value mapping
	 * @throws NoSuchStiBenefitValueMappingException if a sti benefit value mapping with the primary key could not be found
	 */
	public StiBenefitValueMapping[] findByBenefitTypeIdAndBenefitId_PrevAndNext(
			long benefitValueMappingId, long benefitTypeId, long benefitId,
			com.liferay.portal.kernel.util.OrderByComparator
				<StiBenefitValueMapping> orderByComparator)
		throws NoSuchStiBenefitValueMappingException;

	/**
	 * Removes all the sti benefit value mappings where benefitTypeId = &#63; and benefitId = &#63; from the database.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 */
	public void removeByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId);

	/**
	 * Returns the number of sti benefit value mappings where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @return the number of matching sti benefit value mappings
	 */
	public int countByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId);

	/**
	 * Returns the sti benefit value mapping where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63; or throws a <code>NoSuchStiBenefitValueMappingException</code> if it could not be found.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @return the matching sti benefit value mapping
	 * @throws NoSuchStiBenefitValueMappingException if a matching sti benefit value mapping could not be found
	 */
	public StiBenefitValueMapping findByBenefitTypeIdAndBenefitIdAndPlanId(
			long benefitTypeId, long benefitId, long planId)
		throws NoSuchStiBenefitValueMappingException;

	/**
	 * Returns the sti benefit value mapping where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @return the matching sti benefit value mapping, or <code>null</code> if a matching sti benefit value mapping could not be found
	 */
	public StiBenefitValueMapping fetchByBenefitTypeIdAndBenefitIdAndPlanId(
		long benefitTypeId, long benefitId, long planId);

	/**
	 * Returns the sti benefit value mapping where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sti benefit value mapping, or <code>null</code> if a matching sti benefit value mapping could not be found
	 */
	public StiBenefitValueMapping fetchByBenefitTypeIdAndBenefitIdAndPlanId(
		long benefitTypeId, long benefitId, long planId,
		boolean useFinderCache);

	/**
	 * Removes the sti benefit value mapping where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63; from the database.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @return the sti benefit value mapping that was removed
	 */
	public StiBenefitValueMapping removeByBenefitTypeIdAndBenefitIdAndPlanId(
			long benefitTypeId, long benefitId, long planId)
		throws NoSuchStiBenefitValueMappingException;

	/**
	 * Returns the number of sti benefit value mappings where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @return the number of matching sti benefit value mappings
	 */
	public int countByBenefitTypeIdAndBenefitIdAndPlanId(
		long benefitTypeId, long benefitId, long planId);

	/**
	 * Caches the sti benefit value mapping in the entity cache if it is enabled.
	 *
	 * @param stiBenefitValueMapping the sti benefit value mapping
	 */
	public void cacheResult(StiBenefitValueMapping stiBenefitValueMapping);

	/**
	 * Caches the sti benefit value mappings in the entity cache if it is enabled.
	 *
	 * @param stiBenefitValueMappings the sti benefit value mappings
	 */
	public void cacheResult(
		java.util.List<StiBenefitValueMapping> stiBenefitValueMappings);

	/**
	 * Creates a new sti benefit value mapping with the primary key. Does not add the sti benefit value mapping to the database.
	 *
	 * @param benefitValueMappingId the primary key for the new sti benefit value mapping
	 * @return the new sti benefit value mapping
	 */
	public StiBenefitValueMapping create(long benefitValueMappingId);

	/**
	 * Removes the sti benefit value mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param benefitValueMappingId the primary key of the sti benefit value mapping
	 * @return the sti benefit value mapping that was removed
	 * @throws NoSuchStiBenefitValueMappingException if a sti benefit value mapping with the primary key could not be found
	 */
	public StiBenefitValueMapping remove(long benefitValueMappingId)
		throws NoSuchStiBenefitValueMappingException;

	public StiBenefitValueMapping updateImpl(
		StiBenefitValueMapping stiBenefitValueMapping);

	/**
	 * Returns the sti benefit value mapping with the primary key or throws a <code>NoSuchStiBenefitValueMappingException</code> if it could not be found.
	 *
	 * @param benefitValueMappingId the primary key of the sti benefit value mapping
	 * @return the sti benefit value mapping
	 * @throws NoSuchStiBenefitValueMappingException if a sti benefit value mapping with the primary key could not be found
	 */
	public StiBenefitValueMapping findByPrimaryKey(long benefitValueMappingId)
		throws NoSuchStiBenefitValueMappingException;

	/**
	 * Returns the sti benefit value mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param benefitValueMappingId the primary key of the sti benefit value mapping
	 * @return the sti benefit value mapping, or <code>null</code> if a sti benefit value mapping with the primary key could not be found
	 */
	public StiBenefitValueMapping fetchByPrimaryKey(long benefitValueMappingId);

	/**
	 * Returns all the sti benefit value mappings.
	 *
	 * @return the sti benefit value mappings
	 */
	public java.util.List<StiBenefitValueMapping> findAll();

	/**
	 * Returns a range of all the sti benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @return the range of sti benefit value mappings
	 */
	public java.util.List<StiBenefitValueMapping> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the sti benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sti benefit value mappings
	 */
	public java.util.List<StiBenefitValueMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StiBenefitValueMapping>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sti benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sti benefit value mappings
	 */
	public java.util.List<StiBenefitValueMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StiBenefitValueMapping>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sti benefit value mappings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sti benefit value mappings.
	 *
	 * @return the number of sti benefit value mappings
	 */
	public int countAll();

}