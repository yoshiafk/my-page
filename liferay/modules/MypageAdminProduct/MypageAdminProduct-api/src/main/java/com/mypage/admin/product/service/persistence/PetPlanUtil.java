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

import com.mypage.admin.product.model.PetPlan;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the pet plan service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.PetPlanPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PetPlanPersistence
 * @generated
 */
public class PetPlanUtil {

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
	public static void clearCache(PetPlan petPlan) {
		getPersistence().clearCache(petPlan);
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
	public static Map<Serializable, PetPlan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PetPlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PetPlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PetPlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PetPlan> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PetPlan update(PetPlan petPlan) {
		return getPersistence().update(petPlan);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PetPlan update(
		PetPlan petPlan, ServiceContext serviceContext) {

		return getPersistence().update(petPlan, serviceContext);
	}

	/**
	 * Returns all the pet plans where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching pet plans
	 */
	public static List<PetPlan> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the pet plans where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pet plans
	 * @param end the upper bound of the range of pet plans (not inclusive)
	 * @return the range of matching pet plans
	 */
	public static List<PetPlan> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the pet plans where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pet plans
	 * @param end the upper bound of the range of pet plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet plans
	 */
	public static List<PetPlan> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PetPlan> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet plans where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pet plans
	 * @param end the upper bound of the range of pet plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet plans
	 */
	public static List<PetPlan> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PetPlan> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet plan in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public static PetPlan findByUuid_First(
			String uuid, OrderByComparator<PetPlan> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first pet plan in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public static PetPlan fetchByUuid_First(
		String uuid, OrderByComparator<PetPlan> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last pet plan in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public static PetPlan findByUuid_Last(
			String uuid, OrderByComparator<PetPlan> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last pet plan in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public static PetPlan fetchByUuid_Last(
		String uuid, OrderByComparator<PetPlan> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the pet plans before and after the current pet plan in the ordered set where uuid = &#63;.
	 *
	 * @param petPlanId the primary key of the current pet plan
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet plan
	 * @throws NoSuchPetPlanException if a pet plan with the primary key could not be found
	 */
	public static PetPlan[] findByUuid_PrevAndNext(
			long petPlanId, String uuid,
			OrderByComparator<PetPlan> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().findByUuid_PrevAndNext(
			petPlanId, uuid, orderByComparator);
	}

	/**
	 * Removes all the pet plans where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of pet plans where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching pet plans
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the pet plan where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPetPlanException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public static PetPlan findByUUID_G(String uuid, long groupId)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the pet plan where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public static PetPlan fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the pet plan where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public static PetPlan fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the pet plan where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the pet plan that was removed
	 */
	public static PetPlan removeByUUID_G(String uuid, long groupId)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of pet plans where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching pet plans
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the pet plans where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching pet plans
	 */
	public static List<PetPlan> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the pet plans where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pet plans
	 * @param end the upper bound of the range of pet plans (not inclusive)
	 * @return the range of matching pet plans
	 */
	public static List<PetPlan> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the pet plans where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pet plans
	 * @param end the upper bound of the range of pet plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet plans
	 */
	public static List<PetPlan> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PetPlan> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet plans where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pet plans
	 * @param end the upper bound of the range of pet plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet plans
	 */
	public static List<PetPlan> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PetPlan> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet plan in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public static PetPlan findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PetPlan> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first pet plan in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public static PetPlan fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PetPlan> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last pet plan in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public static PetPlan findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PetPlan> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last pet plan in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public static PetPlan fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PetPlan> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the pet plans before and after the current pet plan in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param petPlanId the primary key of the current pet plan
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet plan
	 * @throws NoSuchPetPlanException if a pet plan with the primary key could not be found
	 */
	public static PetPlan[] findByUuid_C_PrevAndNext(
			long petPlanId, String uuid, long companyId,
			OrderByComparator<PetPlan> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().findByUuid_C_PrevAndNext(
			petPlanId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the pet plans where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of pet plans where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching pet plans
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the pet plans where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching pet plans
	 */
	public static List<PetPlan> findByplanName(String name) {
		return getPersistence().findByplanName(name);
	}

	/**
	 * Returns a range of all the pet plans where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet plans
	 * @param end the upper bound of the range of pet plans (not inclusive)
	 * @return the range of matching pet plans
	 */
	public static List<PetPlan> findByplanName(
		String name, int start, int end) {

		return getPersistence().findByplanName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the pet plans where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet plans
	 * @param end the upper bound of the range of pet plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet plans
	 */
	public static List<PetPlan> findByplanName(
		String name, int start, int end,
		OrderByComparator<PetPlan> orderByComparator) {

		return getPersistence().findByplanName(
			name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet plans where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet plans
	 * @param end the upper bound of the range of pet plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet plans
	 */
	public static List<PetPlan> findByplanName(
		String name, int start, int end,
		OrderByComparator<PetPlan> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByplanName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet plan in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public static PetPlan findByplanName_First(
			String name, OrderByComparator<PetPlan> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().findByplanName_First(name, orderByComparator);
	}

	/**
	 * Returns the first pet plan in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public static PetPlan fetchByplanName_First(
		String name, OrderByComparator<PetPlan> orderByComparator) {

		return getPersistence().fetchByplanName_First(name, orderByComparator);
	}

	/**
	 * Returns the last pet plan in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public static PetPlan findByplanName_Last(
			String name, OrderByComparator<PetPlan> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().findByplanName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last pet plan in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public static PetPlan fetchByplanName_Last(
		String name, OrderByComparator<PetPlan> orderByComparator) {

		return getPersistence().fetchByplanName_Last(name, orderByComparator);
	}

	/**
	 * Returns the pet plans before and after the current pet plan in the ordered set where name = &#63;.
	 *
	 * @param petPlanId the primary key of the current pet plan
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet plan
	 * @throws NoSuchPetPlanException if a pet plan with the primary key could not be found
	 */
	public static PetPlan[] findByplanName_PrevAndNext(
			long petPlanId, String name,
			OrderByComparator<PetPlan> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().findByplanName_PrevAndNext(
			petPlanId, name, orderByComparator);
	}

	/**
	 * Removes all the pet plans where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByplanName(String name) {
		getPersistence().removeByplanName(name);
	}

	/**
	 * Returns the number of pet plans where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching pet plans
	 */
	public static int countByplanName(String name) {
		return getPersistence().countByplanName(name);
	}

	/**
	 * Returns the pet plan where petPlanId = &#63; or throws a <code>NoSuchPetPlanException</code> if it could not be found.
	 *
	 * @param petPlanId the pet plan ID
	 * @return the matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public static PetPlan findBysearchPetPlanId(long petPlanId)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().findBysearchPetPlanId(petPlanId);
	}

	/**
	 * Returns the pet plan where petPlanId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param petPlanId the pet plan ID
	 * @return the matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public static PetPlan fetchBysearchPetPlanId(long petPlanId) {
		return getPersistence().fetchBysearchPetPlanId(petPlanId);
	}

	/**
	 * Returns the pet plan where petPlanId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param petPlanId the pet plan ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public static PetPlan fetchBysearchPetPlanId(
		long petPlanId, boolean useFinderCache) {

		return getPersistence().fetchBysearchPetPlanId(
			petPlanId, useFinderCache);
	}

	/**
	 * Removes the pet plan where petPlanId = &#63; from the database.
	 *
	 * @param petPlanId the pet plan ID
	 * @return the pet plan that was removed
	 */
	public static PetPlan removeBysearchPetPlanId(long petPlanId)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().removeBysearchPetPlanId(petPlanId);
	}

	/**
	 * Returns the number of pet plans where petPlanId = &#63;.
	 *
	 * @param petPlanId the pet plan ID
	 * @return the number of matching pet plans
	 */
	public static int countBysearchPetPlanId(long petPlanId) {
		return getPersistence().countBysearchPetPlanId(petPlanId);
	}

	/**
	 * Returns all the pet plans where recommended = &#63;.
	 *
	 * @param recommended the recommended
	 * @return the matching pet plans
	 */
	public static List<PetPlan> findByrecommendedPlan(int recommended) {
		return getPersistence().findByrecommendedPlan(recommended);
	}

	/**
	 * Returns a range of all the pet plans where recommended = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param recommended the recommended
	 * @param start the lower bound of the range of pet plans
	 * @param end the upper bound of the range of pet plans (not inclusive)
	 * @return the range of matching pet plans
	 */
	public static List<PetPlan> findByrecommendedPlan(
		int recommended, int start, int end) {

		return getPersistence().findByrecommendedPlan(recommended, start, end);
	}

	/**
	 * Returns an ordered range of all the pet plans where recommended = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param recommended the recommended
	 * @param start the lower bound of the range of pet plans
	 * @param end the upper bound of the range of pet plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet plans
	 */
	public static List<PetPlan> findByrecommendedPlan(
		int recommended, int start, int end,
		OrderByComparator<PetPlan> orderByComparator) {

		return getPersistence().findByrecommendedPlan(
			recommended, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet plans where recommended = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param recommended the recommended
	 * @param start the lower bound of the range of pet plans
	 * @param end the upper bound of the range of pet plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet plans
	 */
	public static List<PetPlan> findByrecommendedPlan(
		int recommended, int start, int end,
		OrderByComparator<PetPlan> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByrecommendedPlan(
			recommended, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet plan in the ordered set where recommended = &#63;.
	 *
	 * @param recommended the recommended
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public static PetPlan findByrecommendedPlan_First(
			int recommended, OrderByComparator<PetPlan> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().findByrecommendedPlan_First(
			recommended, orderByComparator);
	}

	/**
	 * Returns the first pet plan in the ordered set where recommended = &#63;.
	 *
	 * @param recommended the recommended
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public static PetPlan fetchByrecommendedPlan_First(
		int recommended, OrderByComparator<PetPlan> orderByComparator) {

		return getPersistence().fetchByrecommendedPlan_First(
			recommended, orderByComparator);
	}

	/**
	 * Returns the last pet plan in the ordered set where recommended = &#63;.
	 *
	 * @param recommended the recommended
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public static PetPlan findByrecommendedPlan_Last(
			int recommended, OrderByComparator<PetPlan> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().findByrecommendedPlan_Last(
			recommended, orderByComparator);
	}

	/**
	 * Returns the last pet plan in the ordered set where recommended = &#63;.
	 *
	 * @param recommended the recommended
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public static PetPlan fetchByrecommendedPlan_Last(
		int recommended, OrderByComparator<PetPlan> orderByComparator) {

		return getPersistence().fetchByrecommendedPlan_Last(
			recommended, orderByComparator);
	}

	/**
	 * Returns the pet plans before and after the current pet plan in the ordered set where recommended = &#63;.
	 *
	 * @param petPlanId the primary key of the current pet plan
	 * @param recommended the recommended
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet plan
	 * @throws NoSuchPetPlanException if a pet plan with the primary key could not be found
	 */
	public static PetPlan[] findByrecommendedPlan_PrevAndNext(
			long petPlanId, int recommended,
			OrderByComparator<PetPlan> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().findByrecommendedPlan_PrevAndNext(
			petPlanId, recommended, orderByComparator);
	}

	/**
	 * Removes all the pet plans where recommended = &#63; from the database.
	 *
	 * @param recommended the recommended
	 */
	public static void removeByrecommendedPlan(int recommended) {
		getPersistence().removeByrecommendedPlan(recommended);
	}

	/**
	 * Returns the number of pet plans where recommended = &#63;.
	 *
	 * @param recommended the recommended
	 * @return the number of matching pet plans
	 */
	public static int countByrecommendedPlan(int recommended) {
		return getPersistence().countByrecommendedPlan(recommended);
	}

	/**
	 * Caches the pet plan in the entity cache if it is enabled.
	 *
	 * @param petPlan the pet plan
	 */
	public static void cacheResult(PetPlan petPlan) {
		getPersistence().cacheResult(petPlan);
	}

	/**
	 * Caches the pet plans in the entity cache if it is enabled.
	 *
	 * @param petPlans the pet plans
	 */
	public static void cacheResult(List<PetPlan> petPlans) {
		getPersistence().cacheResult(petPlans);
	}

	/**
	 * Creates a new pet plan with the primary key. Does not add the pet plan to the database.
	 *
	 * @param petPlanId the primary key for the new pet plan
	 * @return the new pet plan
	 */
	public static PetPlan create(long petPlanId) {
		return getPersistence().create(petPlanId);
	}

	/**
	 * Removes the pet plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petPlanId the primary key of the pet plan
	 * @return the pet plan that was removed
	 * @throws NoSuchPetPlanException if a pet plan with the primary key could not be found
	 */
	public static PetPlan remove(long petPlanId)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().remove(petPlanId);
	}

	public static PetPlan updateImpl(PetPlan petPlan) {
		return getPersistence().updateImpl(petPlan);
	}

	/**
	 * Returns the pet plan with the primary key or throws a <code>NoSuchPetPlanException</code> if it could not be found.
	 *
	 * @param petPlanId the primary key of the pet plan
	 * @return the pet plan
	 * @throws NoSuchPetPlanException if a pet plan with the primary key could not be found
	 */
	public static PetPlan findByPrimaryKey(long petPlanId)
		throws com.mypage.admin.product.exception.NoSuchPetPlanException {

		return getPersistence().findByPrimaryKey(petPlanId);
	}

	/**
	 * Returns the pet plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petPlanId the primary key of the pet plan
	 * @return the pet plan, or <code>null</code> if a pet plan with the primary key could not be found
	 */
	public static PetPlan fetchByPrimaryKey(long petPlanId) {
		return getPersistence().fetchByPrimaryKey(petPlanId);
	}

	/**
	 * Returns all the pet plans.
	 *
	 * @return the pet plans
	 */
	public static List<PetPlan> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pet plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet plans
	 * @param end the upper bound of the range of pet plans (not inclusive)
	 * @return the range of pet plans
	 */
	public static List<PetPlan> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pet plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet plans
	 * @param end the upper bound of the range of pet plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pet plans
	 */
	public static List<PetPlan> findAll(
		int start, int end, OrderByComparator<PetPlan> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet plans
	 * @param end the upper bound of the range of pet plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pet plans
	 */
	public static List<PetPlan> findAll(
		int start, int end, OrderByComparator<PetPlan> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pet plans from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pet plans.
	 *
	 * @return the number of pet plans
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PetPlanPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PetPlanPersistence _persistence;

}