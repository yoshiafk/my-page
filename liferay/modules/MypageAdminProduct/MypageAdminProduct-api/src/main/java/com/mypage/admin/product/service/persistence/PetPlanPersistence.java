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

import com.mypage.admin.product.exception.NoSuchPetPlanException;
import com.mypage.admin.product.model.PetPlan;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pet plan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PetPlanUtil
 * @generated
 */
@ProviderType
public interface PetPlanPersistence extends BasePersistence<PetPlan> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PetPlanUtil} to access the pet plan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the pet plans where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching pet plans
	 */
	public java.util.List<PetPlan> findByUuid(String uuid);

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
	public java.util.List<PetPlan> findByUuid(String uuid, int start, int end);

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
	public java.util.List<PetPlan> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator);

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
	public java.util.List<PetPlan> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet plan in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public PetPlan findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
				orderByComparator)
		throws NoSuchPetPlanException;

	/**
	 * Returns the first pet plan in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public PetPlan fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator);

	/**
	 * Returns the last pet plan in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public PetPlan findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
				orderByComparator)
		throws NoSuchPetPlanException;

	/**
	 * Returns the last pet plan in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public PetPlan fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator);

	/**
	 * Returns the pet plans before and after the current pet plan in the ordered set where uuid = &#63;.
	 *
	 * @param petPlanId the primary key of the current pet plan
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet plan
	 * @throws NoSuchPetPlanException if a pet plan with the primary key could not be found
	 */
	public PetPlan[] findByUuid_PrevAndNext(
			long petPlanId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
				orderByComparator)
		throws NoSuchPetPlanException;

	/**
	 * Removes all the pet plans where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of pet plans where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching pet plans
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the pet plan where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPetPlanException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public PetPlan findByUUID_G(String uuid, long groupId)
		throws NoSuchPetPlanException;

	/**
	 * Returns the pet plan where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public PetPlan fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the pet plan where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public PetPlan fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the pet plan where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the pet plan that was removed
	 */
	public PetPlan removeByUUID_G(String uuid, long groupId)
		throws NoSuchPetPlanException;

	/**
	 * Returns the number of pet plans where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching pet plans
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the pet plans where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching pet plans
	 */
	public java.util.List<PetPlan> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<PetPlan> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<PetPlan> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator);

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
	public java.util.List<PetPlan> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet plan in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public PetPlan findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
				orderByComparator)
		throws NoSuchPetPlanException;

	/**
	 * Returns the first pet plan in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public PetPlan fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator);

	/**
	 * Returns the last pet plan in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public PetPlan findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
				orderByComparator)
		throws NoSuchPetPlanException;

	/**
	 * Returns the last pet plan in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public PetPlan fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator);

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
	public PetPlan[] findByUuid_C_PrevAndNext(
			long petPlanId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
				orderByComparator)
		throws NoSuchPetPlanException;

	/**
	 * Removes all the pet plans where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of pet plans where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching pet plans
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the pet plans where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching pet plans
	 */
	public java.util.List<PetPlan> findByplanName(String name);

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
	public java.util.List<PetPlan> findByplanName(
		String name, int start, int end);

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
	public java.util.List<PetPlan> findByplanName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator);

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
	public java.util.List<PetPlan> findByplanName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet plan in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public PetPlan findByplanName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
				orderByComparator)
		throws NoSuchPetPlanException;

	/**
	 * Returns the first pet plan in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public PetPlan fetchByplanName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator);

	/**
	 * Returns the last pet plan in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public PetPlan findByplanName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
				orderByComparator)
		throws NoSuchPetPlanException;

	/**
	 * Returns the last pet plan in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public PetPlan fetchByplanName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator);

	/**
	 * Returns the pet plans before and after the current pet plan in the ordered set where name = &#63;.
	 *
	 * @param petPlanId the primary key of the current pet plan
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet plan
	 * @throws NoSuchPetPlanException if a pet plan with the primary key could not be found
	 */
	public PetPlan[] findByplanName_PrevAndNext(
			long petPlanId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
				orderByComparator)
		throws NoSuchPetPlanException;

	/**
	 * Removes all the pet plans where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByplanName(String name);

	/**
	 * Returns the number of pet plans where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching pet plans
	 */
	public int countByplanName(String name);

	/**
	 * Returns the pet plan where petPlanId = &#63; or throws a <code>NoSuchPetPlanException</code> if it could not be found.
	 *
	 * @param petPlanId the pet plan ID
	 * @return the matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public PetPlan findBysearchPetPlanId(long petPlanId)
		throws NoSuchPetPlanException;

	/**
	 * Returns the pet plan where petPlanId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param petPlanId the pet plan ID
	 * @return the matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public PetPlan fetchBysearchPetPlanId(long petPlanId);

	/**
	 * Returns the pet plan where petPlanId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param petPlanId the pet plan ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public PetPlan fetchBysearchPetPlanId(
		long petPlanId, boolean useFinderCache);

	/**
	 * Removes the pet plan where petPlanId = &#63; from the database.
	 *
	 * @param petPlanId the pet plan ID
	 * @return the pet plan that was removed
	 */
	public PetPlan removeBysearchPetPlanId(long petPlanId)
		throws NoSuchPetPlanException;

	/**
	 * Returns the number of pet plans where petPlanId = &#63;.
	 *
	 * @param petPlanId the pet plan ID
	 * @return the number of matching pet plans
	 */
	public int countBysearchPetPlanId(long petPlanId);

	/**
	 * Returns all the pet plans where recommended = &#63;.
	 *
	 * @param recommended the recommended
	 * @return the matching pet plans
	 */
	public java.util.List<PetPlan> findByrecommendedPlan(int recommended);

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
	public java.util.List<PetPlan> findByrecommendedPlan(
		int recommended, int start, int end);

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
	public java.util.List<PetPlan> findByrecommendedPlan(
		int recommended, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator);

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
	public java.util.List<PetPlan> findByrecommendedPlan(
		int recommended, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet plan in the ordered set where recommended = &#63;.
	 *
	 * @param recommended the recommended
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public PetPlan findByrecommendedPlan_First(
			int recommended,
			com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
				orderByComparator)
		throws NoSuchPetPlanException;

	/**
	 * Returns the first pet plan in the ordered set where recommended = &#63;.
	 *
	 * @param recommended the recommended
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public PetPlan fetchByrecommendedPlan_First(
		int recommended,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator);

	/**
	 * Returns the last pet plan in the ordered set where recommended = &#63;.
	 *
	 * @param recommended the recommended
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet plan
	 * @throws NoSuchPetPlanException if a matching pet plan could not be found
	 */
	public PetPlan findByrecommendedPlan_Last(
			int recommended,
			com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
				orderByComparator)
		throws NoSuchPetPlanException;

	/**
	 * Returns the last pet plan in the ordered set where recommended = &#63;.
	 *
	 * @param recommended the recommended
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public PetPlan fetchByrecommendedPlan_Last(
		int recommended,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator);

	/**
	 * Returns the pet plans before and after the current pet plan in the ordered set where recommended = &#63;.
	 *
	 * @param petPlanId the primary key of the current pet plan
	 * @param recommended the recommended
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet plan
	 * @throws NoSuchPetPlanException if a pet plan with the primary key could not be found
	 */
	public PetPlan[] findByrecommendedPlan_PrevAndNext(
			long petPlanId, int recommended,
			com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
				orderByComparator)
		throws NoSuchPetPlanException;

	/**
	 * Removes all the pet plans where recommended = &#63; from the database.
	 *
	 * @param recommended the recommended
	 */
	public void removeByrecommendedPlan(int recommended);

	/**
	 * Returns the number of pet plans where recommended = &#63;.
	 *
	 * @param recommended the recommended
	 * @return the number of matching pet plans
	 */
	public int countByrecommendedPlan(int recommended);

	/**
	 * Caches the pet plan in the entity cache if it is enabled.
	 *
	 * @param petPlan the pet plan
	 */
	public void cacheResult(PetPlan petPlan);

	/**
	 * Caches the pet plans in the entity cache if it is enabled.
	 *
	 * @param petPlans the pet plans
	 */
	public void cacheResult(java.util.List<PetPlan> petPlans);

	/**
	 * Creates a new pet plan with the primary key. Does not add the pet plan to the database.
	 *
	 * @param petPlanId the primary key for the new pet plan
	 * @return the new pet plan
	 */
	public PetPlan create(long petPlanId);

	/**
	 * Removes the pet plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petPlanId the primary key of the pet plan
	 * @return the pet plan that was removed
	 * @throws NoSuchPetPlanException if a pet plan with the primary key could not be found
	 */
	public PetPlan remove(long petPlanId) throws NoSuchPetPlanException;

	public PetPlan updateImpl(PetPlan petPlan);

	/**
	 * Returns the pet plan with the primary key or throws a <code>NoSuchPetPlanException</code> if it could not be found.
	 *
	 * @param petPlanId the primary key of the pet plan
	 * @return the pet plan
	 * @throws NoSuchPetPlanException if a pet plan with the primary key could not be found
	 */
	public PetPlan findByPrimaryKey(long petPlanId)
		throws NoSuchPetPlanException;

	/**
	 * Returns the pet plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petPlanId the primary key of the pet plan
	 * @return the pet plan, or <code>null</code> if a pet plan with the primary key could not be found
	 */
	public PetPlan fetchByPrimaryKey(long petPlanId);

	/**
	 * Returns all the pet plans.
	 *
	 * @return the pet plans
	 */
	public java.util.List<PetPlan> findAll();

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
	public java.util.List<PetPlan> findAll(int start, int end);

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
	public java.util.List<PetPlan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator);

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
	public java.util.List<PetPlan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetPlan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pet plans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pet plans.
	 *
	 * @return the number of pet plans
	 */
	public int countAll();

}