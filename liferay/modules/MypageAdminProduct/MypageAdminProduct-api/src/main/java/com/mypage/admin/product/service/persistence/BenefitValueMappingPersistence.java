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

import com.mypage.admin.product.exception.NoSuchBenefitValueMappingException;
import com.mypage.admin.product.model.BenefitValueMapping;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the benefit value mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see BenefitValueMappingUtil
 * @generated
 */
@ProviderType
public interface BenefitValueMappingPersistence
	extends BasePersistence<BenefitValueMapping> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BenefitValueMappingUtil} to access the benefit value mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the benefit value mappings where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @return the matching benefit value mappings
	 */
	public java.util.List<BenefitValueMapping> findByBenefitTypeId(
		long benefitTypeId);

	/**
	 * Returns a range of all the benefit value mappings where benefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param start the lower bound of the range of benefit value mappings
	 * @param end the upper bound of the range of benefit value mappings (not inclusive)
	 * @return the range of matching benefit value mappings
	 */
	public java.util.List<BenefitValueMapping> findByBenefitTypeId(
		long benefitTypeId, int start, int end);

	/**
	 * Returns an ordered range of all the benefit value mappings where benefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param start the lower bound of the range of benefit value mappings
	 * @param end the upper bound of the range of benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching benefit value mappings
	 */
	public java.util.List<BenefitValueMapping> findByBenefitTypeId(
		long benefitTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BenefitValueMapping>
			orderByComparator);

	/**
	 * Returns an ordered range of all the benefit value mappings where benefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param start the lower bound of the range of benefit value mappings
	 * @param end the upper bound of the range of benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching benefit value mappings
	 */
	public java.util.List<BenefitValueMapping> findByBenefitTypeId(
		long benefitTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BenefitValueMapping>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching benefit value mapping
	 * @throws NoSuchBenefitValueMappingException if a matching benefit value mapping could not be found
	 */
	public BenefitValueMapping findByBenefitTypeId_First(
			long benefitTypeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BenefitValueMapping> orderByComparator)
		throws NoSuchBenefitValueMappingException;

	/**
	 * Returns the first benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching benefit value mapping, or <code>null</code> if a matching benefit value mapping could not be found
	 */
	public BenefitValueMapping fetchByBenefitTypeId_First(
		long benefitTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<BenefitValueMapping>
			orderByComparator);

	/**
	 * Returns the last benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching benefit value mapping
	 * @throws NoSuchBenefitValueMappingException if a matching benefit value mapping could not be found
	 */
	public BenefitValueMapping findByBenefitTypeId_Last(
			long benefitTypeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BenefitValueMapping> orderByComparator)
		throws NoSuchBenefitValueMappingException;

	/**
	 * Returns the last benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching benefit value mapping, or <code>null</code> if a matching benefit value mapping could not be found
	 */
	public BenefitValueMapping fetchByBenefitTypeId_Last(
		long benefitTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<BenefitValueMapping>
			orderByComparator);

	/**
	 * Returns the benefit value mappings before and after the current benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitValueMappingId the primary key of the current benefit value mapping
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next benefit value mapping
	 * @throws NoSuchBenefitValueMappingException if a benefit value mapping with the primary key could not be found
	 */
	public BenefitValueMapping[] findByBenefitTypeId_PrevAndNext(
			long benefitValueMappingId, long benefitTypeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BenefitValueMapping> orderByComparator)
		throws NoSuchBenefitValueMappingException;

	/**
	 * Removes all the benefit value mappings where benefitTypeId = &#63; from the database.
	 *
	 * @param benefitTypeId the benefit type ID
	 */
	public void removeByBenefitTypeId(long benefitTypeId);

	/**
	 * Returns the number of benefit value mappings where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @return the number of matching benefit value mappings
	 */
	public int countByBenefitTypeId(long benefitTypeId);

	/**
	 * Returns all the benefit value mappings where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @return the matching benefit value mappings
	 */
	public java.util.List<BenefitValueMapping> findByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId);

	/**
	 * Returns a range of all the benefit value mappings where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param start the lower bound of the range of benefit value mappings
	 * @param end the upper bound of the range of benefit value mappings (not inclusive)
	 * @return the range of matching benefit value mappings
	 */
	public java.util.List<BenefitValueMapping> findByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId, int start, int end);

	/**
	 * Returns an ordered range of all the benefit value mappings where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param start the lower bound of the range of benefit value mappings
	 * @param end the upper bound of the range of benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching benefit value mappings
	 */
	public java.util.List<BenefitValueMapping> findByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BenefitValueMapping>
			orderByComparator);

	/**
	 * Returns an ordered range of all the benefit value mappings where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param start the lower bound of the range of benefit value mappings
	 * @param end the upper bound of the range of benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching benefit value mappings
	 */
	public java.util.List<BenefitValueMapping> findByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BenefitValueMapping>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching benefit value mapping
	 * @throws NoSuchBenefitValueMappingException if a matching benefit value mapping could not be found
	 */
	public BenefitValueMapping findByBenefitTypeIdAndBenefitId_First(
			long benefitTypeId, long benefitId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BenefitValueMapping> orderByComparator)
		throws NoSuchBenefitValueMappingException;

	/**
	 * Returns the first benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching benefit value mapping, or <code>null</code> if a matching benefit value mapping could not be found
	 */
	public BenefitValueMapping fetchByBenefitTypeIdAndBenefitId_First(
		long benefitTypeId, long benefitId,
		com.liferay.portal.kernel.util.OrderByComparator<BenefitValueMapping>
			orderByComparator);

	/**
	 * Returns the last benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching benefit value mapping
	 * @throws NoSuchBenefitValueMappingException if a matching benefit value mapping could not be found
	 */
	public BenefitValueMapping findByBenefitTypeIdAndBenefitId_Last(
			long benefitTypeId, long benefitId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BenefitValueMapping> orderByComparator)
		throws NoSuchBenefitValueMappingException;

	/**
	 * Returns the last benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching benefit value mapping, or <code>null</code> if a matching benefit value mapping could not be found
	 */
	public BenefitValueMapping fetchByBenefitTypeIdAndBenefitId_Last(
		long benefitTypeId, long benefitId,
		com.liferay.portal.kernel.util.OrderByComparator<BenefitValueMapping>
			orderByComparator);

	/**
	 * Returns the benefit value mappings before and after the current benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitValueMappingId the primary key of the current benefit value mapping
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next benefit value mapping
	 * @throws NoSuchBenefitValueMappingException if a benefit value mapping with the primary key could not be found
	 */
	public BenefitValueMapping[] findByBenefitTypeIdAndBenefitId_PrevAndNext(
			long benefitValueMappingId, long benefitTypeId, long benefitId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BenefitValueMapping> orderByComparator)
		throws NoSuchBenefitValueMappingException;

	/**
	 * Removes all the benefit value mappings where benefitTypeId = &#63; and benefitId = &#63; from the database.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 */
	public void removeByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId);

	/**
	 * Returns the number of benefit value mappings where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @return the number of matching benefit value mappings
	 */
	public int countByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId);

	/**
	 * Returns the benefit value mapping where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63; or throws a <code>NoSuchBenefitValueMappingException</code> if it could not be found.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @return the matching benefit value mapping
	 * @throws NoSuchBenefitValueMappingException if a matching benefit value mapping could not be found
	 */
	public BenefitValueMapping findByBenefitTypeIdAndBenefitIdAndPlanId(
			long benefitTypeId, long benefitId, long planId)
		throws NoSuchBenefitValueMappingException;

	/**
	 * Returns the benefit value mapping where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @return the matching benefit value mapping, or <code>null</code> if a matching benefit value mapping could not be found
	 */
	public BenefitValueMapping fetchByBenefitTypeIdAndBenefitIdAndPlanId(
		long benefitTypeId, long benefitId, long planId);

	/**
	 * Returns the benefit value mapping where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching benefit value mapping, or <code>null</code> if a matching benefit value mapping could not be found
	 */
	public BenefitValueMapping fetchByBenefitTypeIdAndBenefitIdAndPlanId(
		long benefitTypeId, long benefitId, long planId,
		boolean useFinderCache);

	/**
	 * Removes the benefit value mapping where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63; from the database.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @return the benefit value mapping that was removed
	 */
	public BenefitValueMapping removeByBenefitTypeIdAndBenefitIdAndPlanId(
			long benefitTypeId, long benefitId, long planId)
		throws NoSuchBenefitValueMappingException;

	/**
	 * Returns the number of benefit value mappings where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @return the number of matching benefit value mappings
	 */
	public int countByBenefitTypeIdAndBenefitIdAndPlanId(
		long benefitTypeId, long benefitId, long planId);

	/**
	 * Caches the benefit value mapping in the entity cache if it is enabled.
	 *
	 * @param benefitValueMapping the benefit value mapping
	 */
	public void cacheResult(BenefitValueMapping benefitValueMapping);

	/**
	 * Caches the benefit value mappings in the entity cache if it is enabled.
	 *
	 * @param benefitValueMappings the benefit value mappings
	 */
	public void cacheResult(
		java.util.List<BenefitValueMapping> benefitValueMappings);

	/**
	 * Creates a new benefit value mapping with the primary key. Does not add the benefit value mapping to the database.
	 *
	 * @param benefitValueMappingId the primary key for the new benefit value mapping
	 * @return the new benefit value mapping
	 */
	public BenefitValueMapping create(long benefitValueMappingId);

	/**
	 * Removes the benefit value mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param benefitValueMappingId the primary key of the benefit value mapping
	 * @return the benefit value mapping that was removed
	 * @throws NoSuchBenefitValueMappingException if a benefit value mapping with the primary key could not be found
	 */
	public BenefitValueMapping remove(long benefitValueMappingId)
		throws NoSuchBenefitValueMappingException;

	public BenefitValueMapping updateImpl(
		BenefitValueMapping benefitValueMapping);

	/**
	 * Returns the benefit value mapping with the primary key or throws a <code>NoSuchBenefitValueMappingException</code> if it could not be found.
	 *
	 * @param benefitValueMappingId the primary key of the benefit value mapping
	 * @return the benefit value mapping
	 * @throws NoSuchBenefitValueMappingException if a benefit value mapping with the primary key could not be found
	 */
	public BenefitValueMapping findByPrimaryKey(long benefitValueMappingId)
		throws NoSuchBenefitValueMappingException;

	/**
	 * Returns the benefit value mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param benefitValueMappingId the primary key of the benefit value mapping
	 * @return the benefit value mapping, or <code>null</code> if a benefit value mapping with the primary key could not be found
	 */
	public BenefitValueMapping fetchByPrimaryKey(long benefitValueMappingId);

	/**
	 * Returns all the benefit value mappings.
	 *
	 * @return the benefit value mappings
	 */
	public java.util.List<BenefitValueMapping> findAll();

	/**
	 * Returns a range of all the benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit value mappings
	 * @param end the upper bound of the range of benefit value mappings (not inclusive)
	 * @return the range of benefit value mappings
	 */
	public java.util.List<BenefitValueMapping> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit value mappings
	 * @param end the upper bound of the range of benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of benefit value mappings
	 */
	public java.util.List<BenefitValueMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BenefitValueMapping>
			orderByComparator);

	/**
	 * Returns an ordered range of all the benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit value mappings
	 * @param end the upper bound of the range of benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of benefit value mappings
	 */
	public java.util.List<BenefitValueMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BenefitValueMapping>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the benefit value mappings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of benefit value mappings.
	 *
	 * @return the number of benefit value mappings
	 */
	public int countAll();

}