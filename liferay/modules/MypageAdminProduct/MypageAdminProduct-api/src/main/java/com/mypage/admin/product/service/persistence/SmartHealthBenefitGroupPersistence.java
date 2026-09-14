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

import com.mypage.admin.product.exception.NoSuchSmartHealthBenefitGroupException;
import com.mypage.admin.product.model.SmartHealthBenefitGroup;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the smart health benefit group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartHealthBenefitGroupUtil
 * @generated
 */
@ProviderType
public interface SmartHealthBenefitGroupPersistence
	extends BasePersistence<SmartHealthBenefitGroup> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SmartHealthBenefitGroupUtil} to access the smart health benefit group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the smart health benefit group where groupCode = &#63; or throws a <code>NoSuchSmartHealthBenefitGroupException</code> if it could not be found.
	 *
	 * @param groupCode the group code
	 * @return the matching smart health benefit group
	 * @throws NoSuchSmartHealthBenefitGroupException if a matching smart health benefit group could not be found
	 */
	public SmartHealthBenefitGroup findBygroupCode(String groupCode)
		throws NoSuchSmartHealthBenefitGroupException;

	/**
	 * Returns the smart health benefit group where groupCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupCode the group code
	 * @return the matching smart health benefit group, or <code>null</code> if a matching smart health benefit group could not be found
	 */
	public SmartHealthBenefitGroup fetchBygroupCode(String groupCode);

	/**
	 * Returns the smart health benefit group where groupCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupCode the group code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart health benefit group, or <code>null</code> if a matching smart health benefit group could not be found
	 */
	public SmartHealthBenefitGroup fetchBygroupCode(
		String groupCode, boolean useFinderCache);

	/**
	 * Removes the smart health benefit group where groupCode = &#63; from the database.
	 *
	 * @param groupCode the group code
	 * @return the smart health benefit group that was removed
	 */
	public SmartHealthBenefitGroup removeBygroupCode(String groupCode)
		throws NoSuchSmartHealthBenefitGroupException;

	/**
	 * Returns the number of smart health benefit groups where groupCode = &#63;.
	 *
	 * @param groupCode the group code
	 * @return the number of matching smart health benefit groups
	 */
	public int countBygroupCode(String groupCode);

	/**
	 * Caches the smart health benefit group in the entity cache if it is enabled.
	 *
	 * @param smartHealthBenefitGroup the smart health benefit group
	 */
	public void cacheResult(SmartHealthBenefitGroup smartHealthBenefitGroup);

	/**
	 * Caches the smart health benefit groups in the entity cache if it is enabled.
	 *
	 * @param smartHealthBenefitGroups the smart health benefit groups
	 */
	public void cacheResult(
		java.util.List<SmartHealthBenefitGroup> smartHealthBenefitGroups);

	/**
	 * Creates a new smart health benefit group with the primary key. Does not add the smart health benefit group to the database.
	 *
	 * @param smartHealthBenefitGroupId the primary key for the new smart health benefit group
	 * @return the new smart health benefit group
	 */
	public SmartHealthBenefitGroup create(long smartHealthBenefitGroupId);

	/**
	 * Removes the smart health benefit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartHealthBenefitGroupId the primary key of the smart health benefit group
	 * @return the smart health benefit group that was removed
	 * @throws NoSuchSmartHealthBenefitGroupException if a smart health benefit group with the primary key could not be found
	 */
	public SmartHealthBenefitGroup remove(long smartHealthBenefitGroupId)
		throws NoSuchSmartHealthBenefitGroupException;

	public SmartHealthBenefitGroup updateImpl(
		SmartHealthBenefitGroup smartHealthBenefitGroup);

	/**
	 * Returns the smart health benefit group with the primary key or throws a <code>NoSuchSmartHealthBenefitGroupException</code> if it could not be found.
	 *
	 * @param smartHealthBenefitGroupId the primary key of the smart health benefit group
	 * @return the smart health benefit group
	 * @throws NoSuchSmartHealthBenefitGroupException if a smart health benefit group with the primary key could not be found
	 */
	public SmartHealthBenefitGroup findByPrimaryKey(
			long smartHealthBenefitGroupId)
		throws NoSuchSmartHealthBenefitGroupException;

	/**
	 * Returns the smart health benefit group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartHealthBenefitGroupId the primary key of the smart health benefit group
	 * @return the smart health benefit group, or <code>null</code> if a smart health benefit group with the primary key could not be found
	 */
	public SmartHealthBenefitGroup fetchByPrimaryKey(
		long smartHealthBenefitGroupId);

	/**
	 * Returns all the smart health benefit groups.
	 *
	 * @return the smart health benefit groups
	 */
	public java.util.List<SmartHealthBenefitGroup> findAll();

	/**
	 * Returns a range of all the smart health benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefit groups
	 * @param end the upper bound of the range of smart health benefit groups (not inclusive)
	 * @return the range of smart health benefit groups
	 */
	public java.util.List<SmartHealthBenefitGroup> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the smart health benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefit groups
	 * @param end the upper bound of the range of smart health benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart health benefit groups
	 */
	public java.util.List<SmartHealthBenefitGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SmartHealthBenefitGroup> orderByComparator);

	/**
	 * Returns an ordered range of all the smart health benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefit groups
	 * @param end the upper bound of the range of smart health benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart health benefit groups
	 */
	public java.util.List<SmartHealthBenefitGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SmartHealthBenefitGroup> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the smart health benefit groups from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of smart health benefit groups.
	 *
	 * @return the number of smart health benefit groups
	 */
	public int countAll();

}