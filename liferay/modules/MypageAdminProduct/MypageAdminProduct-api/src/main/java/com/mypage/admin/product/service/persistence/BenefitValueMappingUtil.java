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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.BenefitValueMapping;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the benefit value mapping service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.BenefitValueMappingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see BenefitValueMappingPersistence
 * @generated
 */
public class BenefitValueMappingUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(BenefitValueMapping benefitValueMapping) {
		getPersistence().clearCache(benefitValueMapping);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, BenefitValueMapping> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BenefitValueMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BenefitValueMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BenefitValueMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BenefitValueMapping> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BenefitValueMapping update(
		BenefitValueMapping benefitValueMapping) {

		return getPersistence().update(benefitValueMapping);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BenefitValueMapping update(
		BenefitValueMapping benefitValueMapping,
		ServiceContext serviceContext) {

		return getPersistence().update(benefitValueMapping, serviceContext);
	}

	/**
	 * Returns all the benefit value mappings where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @return the matching benefit value mappings
	 */
	public static List<BenefitValueMapping> findByBenefitTypeId(
		long benefitTypeId) {

		return getPersistence().findByBenefitTypeId(benefitTypeId);
	}

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
	public static List<BenefitValueMapping> findByBenefitTypeId(
		long benefitTypeId, int start, int end) {

		return getPersistence().findByBenefitTypeId(benefitTypeId, start, end);
	}

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
	public static List<BenefitValueMapping> findByBenefitTypeId(
		long benefitTypeId, int start, int end,
		OrderByComparator<BenefitValueMapping> orderByComparator) {

		return getPersistence().findByBenefitTypeId(
			benefitTypeId, start, end, orderByComparator);
	}

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
	public static List<BenefitValueMapping> findByBenefitTypeId(
		long benefitTypeId, int start, int end,
		OrderByComparator<BenefitValueMapping> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByBenefitTypeId(
			benefitTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching benefit value mapping
	 * @throws NoSuchBenefitValueMappingException if a matching benefit value mapping could not be found
	 */
	public static BenefitValueMapping findByBenefitTypeId_First(
			long benefitTypeId,
			OrderByComparator<BenefitValueMapping> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBenefitValueMappingException {

		return getPersistence().findByBenefitTypeId_First(
			benefitTypeId, orderByComparator);
	}

	/**
	 * Returns the first benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching benefit value mapping, or <code>null</code> if a matching benefit value mapping could not be found
	 */
	public static BenefitValueMapping fetchByBenefitTypeId_First(
		long benefitTypeId,
		OrderByComparator<BenefitValueMapping> orderByComparator) {

		return getPersistence().fetchByBenefitTypeId_First(
			benefitTypeId, orderByComparator);
	}

	/**
	 * Returns the last benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching benefit value mapping
	 * @throws NoSuchBenefitValueMappingException if a matching benefit value mapping could not be found
	 */
	public static BenefitValueMapping findByBenefitTypeId_Last(
			long benefitTypeId,
			OrderByComparator<BenefitValueMapping> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBenefitValueMappingException {

		return getPersistence().findByBenefitTypeId_Last(
			benefitTypeId, orderByComparator);
	}

	/**
	 * Returns the last benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching benefit value mapping, or <code>null</code> if a matching benefit value mapping could not be found
	 */
	public static BenefitValueMapping fetchByBenefitTypeId_Last(
		long benefitTypeId,
		OrderByComparator<BenefitValueMapping> orderByComparator) {

		return getPersistence().fetchByBenefitTypeId_Last(
			benefitTypeId, orderByComparator);
	}

	/**
	 * Returns the benefit value mappings before and after the current benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitValueMappingId the primary key of the current benefit value mapping
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next benefit value mapping
	 * @throws NoSuchBenefitValueMappingException if a benefit value mapping with the primary key could not be found
	 */
	public static BenefitValueMapping[] findByBenefitTypeId_PrevAndNext(
			long benefitValueMappingId, long benefitTypeId,
			OrderByComparator<BenefitValueMapping> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBenefitValueMappingException {

		return getPersistence().findByBenefitTypeId_PrevAndNext(
			benefitValueMappingId, benefitTypeId, orderByComparator);
	}

	/**
	 * Removes all the benefit value mappings where benefitTypeId = &#63; from the database.
	 *
	 * @param benefitTypeId the benefit type ID
	 */
	public static void removeByBenefitTypeId(long benefitTypeId) {
		getPersistence().removeByBenefitTypeId(benefitTypeId);
	}

	/**
	 * Returns the number of benefit value mappings where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @return the number of matching benefit value mappings
	 */
	public static int countByBenefitTypeId(long benefitTypeId) {
		return getPersistence().countByBenefitTypeId(benefitTypeId);
	}

	/**
	 * Returns all the benefit value mappings where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @return the matching benefit value mappings
	 */
	public static List<BenefitValueMapping> findByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId) {

		return getPersistence().findByBenefitTypeIdAndBenefitId(
			benefitTypeId, benefitId);
	}

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
	public static List<BenefitValueMapping> findByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId, int start, int end) {

		return getPersistence().findByBenefitTypeIdAndBenefitId(
			benefitTypeId, benefitId, start, end);
	}

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
	public static List<BenefitValueMapping> findByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId, int start, int end,
		OrderByComparator<BenefitValueMapping> orderByComparator) {

		return getPersistence().findByBenefitTypeIdAndBenefitId(
			benefitTypeId, benefitId, start, end, orderByComparator);
	}

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
	public static List<BenefitValueMapping> findByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId, int start, int end,
		OrderByComparator<BenefitValueMapping> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByBenefitTypeIdAndBenefitId(
			benefitTypeId, benefitId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching benefit value mapping
	 * @throws NoSuchBenefitValueMappingException if a matching benefit value mapping could not be found
	 */
	public static BenefitValueMapping findByBenefitTypeIdAndBenefitId_First(
			long benefitTypeId, long benefitId,
			OrderByComparator<BenefitValueMapping> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBenefitValueMappingException {

		return getPersistence().findByBenefitTypeIdAndBenefitId_First(
			benefitTypeId, benefitId, orderByComparator);
	}

	/**
	 * Returns the first benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching benefit value mapping, or <code>null</code> if a matching benefit value mapping could not be found
	 */
	public static BenefitValueMapping fetchByBenefitTypeIdAndBenefitId_First(
		long benefitTypeId, long benefitId,
		OrderByComparator<BenefitValueMapping> orderByComparator) {

		return getPersistence().fetchByBenefitTypeIdAndBenefitId_First(
			benefitTypeId, benefitId, orderByComparator);
	}

	/**
	 * Returns the last benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching benefit value mapping
	 * @throws NoSuchBenefitValueMappingException if a matching benefit value mapping could not be found
	 */
	public static BenefitValueMapping findByBenefitTypeIdAndBenefitId_Last(
			long benefitTypeId, long benefitId,
			OrderByComparator<BenefitValueMapping> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBenefitValueMappingException {

		return getPersistence().findByBenefitTypeIdAndBenefitId_Last(
			benefitTypeId, benefitId, orderByComparator);
	}

	/**
	 * Returns the last benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching benefit value mapping, or <code>null</code> if a matching benefit value mapping could not be found
	 */
	public static BenefitValueMapping fetchByBenefitTypeIdAndBenefitId_Last(
		long benefitTypeId, long benefitId,
		OrderByComparator<BenefitValueMapping> orderByComparator) {

		return getPersistence().fetchByBenefitTypeIdAndBenefitId_Last(
			benefitTypeId, benefitId, orderByComparator);
	}

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
	public static BenefitValueMapping[]
			findByBenefitTypeIdAndBenefitId_PrevAndNext(
				long benefitValueMappingId, long benefitTypeId, long benefitId,
				OrderByComparator<BenefitValueMapping> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchBenefitValueMappingException {

		return getPersistence().findByBenefitTypeIdAndBenefitId_PrevAndNext(
			benefitValueMappingId, benefitTypeId, benefitId, orderByComparator);
	}

	/**
	 * Removes all the benefit value mappings where benefitTypeId = &#63; and benefitId = &#63; from the database.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 */
	public static void removeByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId) {

		getPersistence().removeByBenefitTypeIdAndBenefitId(
			benefitTypeId, benefitId);
	}

	/**
	 * Returns the number of benefit value mappings where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @return the number of matching benefit value mappings
	 */
	public static int countByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId) {

		return getPersistence().countByBenefitTypeIdAndBenefitId(
			benefitTypeId, benefitId);
	}

	/**
	 * Returns the benefit value mapping where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63; or throws a <code>NoSuchBenefitValueMappingException</code> if it could not be found.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @return the matching benefit value mapping
	 * @throws NoSuchBenefitValueMappingException if a matching benefit value mapping could not be found
	 */
	public static BenefitValueMapping findByBenefitTypeIdAndBenefitIdAndPlanId(
			long benefitTypeId, long benefitId, long planId)
		throws com.mypage.admin.product.exception.
			NoSuchBenefitValueMappingException {

		return getPersistence().findByBenefitTypeIdAndBenefitIdAndPlanId(
			benefitTypeId, benefitId, planId);
	}

	/**
	 * Returns the benefit value mapping where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @return the matching benefit value mapping, or <code>null</code> if a matching benefit value mapping could not be found
	 */
	public static BenefitValueMapping fetchByBenefitTypeIdAndBenefitIdAndPlanId(
		long benefitTypeId, long benefitId, long planId) {

		return getPersistence().fetchByBenefitTypeIdAndBenefitIdAndPlanId(
			benefitTypeId, benefitId, planId);
	}

	/**
	 * Returns the benefit value mapping where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching benefit value mapping, or <code>null</code> if a matching benefit value mapping could not be found
	 */
	public static BenefitValueMapping fetchByBenefitTypeIdAndBenefitIdAndPlanId(
		long benefitTypeId, long benefitId, long planId,
		boolean useFinderCache) {

		return getPersistence().fetchByBenefitTypeIdAndBenefitIdAndPlanId(
			benefitTypeId, benefitId, planId, useFinderCache);
	}

	/**
	 * Removes the benefit value mapping where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63; from the database.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @return the benefit value mapping that was removed
	 */
	public static BenefitValueMapping
			removeByBenefitTypeIdAndBenefitIdAndPlanId(
				long benefitTypeId, long benefitId, long planId)
		throws com.mypage.admin.product.exception.
			NoSuchBenefitValueMappingException {

		return getPersistence().removeByBenefitTypeIdAndBenefitIdAndPlanId(
			benefitTypeId, benefitId, planId);
	}

	/**
	 * Returns the number of benefit value mappings where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @return the number of matching benefit value mappings
	 */
	public static int countByBenefitTypeIdAndBenefitIdAndPlanId(
		long benefitTypeId, long benefitId, long planId) {

		return getPersistence().countByBenefitTypeIdAndBenefitIdAndPlanId(
			benefitTypeId, benefitId, planId);
	}

	/**
	 * Caches the benefit value mapping in the entity cache if it is enabled.
	 *
	 * @param benefitValueMapping the benefit value mapping
	 */
	public static void cacheResult(BenefitValueMapping benefitValueMapping) {
		getPersistence().cacheResult(benefitValueMapping);
	}

	/**
	 * Caches the benefit value mappings in the entity cache if it is enabled.
	 *
	 * @param benefitValueMappings the benefit value mappings
	 */
	public static void cacheResult(
		List<BenefitValueMapping> benefitValueMappings) {

		getPersistence().cacheResult(benefitValueMappings);
	}

	/**
	 * Creates a new benefit value mapping with the primary key. Does not add the benefit value mapping to the database.
	 *
	 * @param benefitValueMappingId the primary key for the new benefit value mapping
	 * @return the new benefit value mapping
	 */
	public static BenefitValueMapping create(long benefitValueMappingId) {
		return getPersistence().create(benefitValueMappingId);
	}

	/**
	 * Removes the benefit value mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param benefitValueMappingId the primary key of the benefit value mapping
	 * @return the benefit value mapping that was removed
	 * @throws NoSuchBenefitValueMappingException if a benefit value mapping with the primary key could not be found
	 */
	public static BenefitValueMapping remove(long benefitValueMappingId)
		throws com.mypage.admin.product.exception.
			NoSuchBenefitValueMappingException {

		return getPersistence().remove(benefitValueMappingId);
	}

	public static BenefitValueMapping updateImpl(
		BenefitValueMapping benefitValueMapping) {

		return getPersistence().updateImpl(benefitValueMapping);
	}

	/**
	 * Returns the benefit value mapping with the primary key or throws a <code>NoSuchBenefitValueMappingException</code> if it could not be found.
	 *
	 * @param benefitValueMappingId the primary key of the benefit value mapping
	 * @return the benefit value mapping
	 * @throws NoSuchBenefitValueMappingException if a benefit value mapping with the primary key could not be found
	 */
	public static BenefitValueMapping findByPrimaryKey(
			long benefitValueMappingId)
		throws com.mypage.admin.product.exception.
			NoSuchBenefitValueMappingException {

		return getPersistence().findByPrimaryKey(benefitValueMappingId);
	}

	/**
	 * Returns the benefit value mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param benefitValueMappingId the primary key of the benefit value mapping
	 * @return the benefit value mapping, or <code>null</code> if a benefit value mapping with the primary key could not be found
	 */
	public static BenefitValueMapping fetchByPrimaryKey(
		long benefitValueMappingId) {

		return getPersistence().fetchByPrimaryKey(benefitValueMappingId);
	}

	/**
	 * Returns all the benefit value mappings.
	 *
	 * @return the benefit value mappings
	 */
	public static List<BenefitValueMapping> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<BenefitValueMapping> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<BenefitValueMapping> findAll(
		int start, int end,
		OrderByComparator<BenefitValueMapping> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<BenefitValueMapping> findAll(
		int start, int end,
		OrderByComparator<BenefitValueMapping> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the benefit value mappings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of benefit value mappings.
	 *
	 * @return the number of benefit value mappings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BenefitValueMappingPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BenefitValueMappingPersistence _persistence;

}