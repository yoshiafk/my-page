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

import com.mypage.admin.product.exception.NoSuchHealthSmeTypeException;
import com.mypage.admin.product.model.HealthSmeType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the health sme type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see HealthSmeTypeUtil
 * @generated
 */
@ProviderType
public interface HealthSmeTypePersistence
	extends BasePersistence<HealthSmeType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HealthSmeTypeUtil} to access the health sme type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the health sme type in the entity cache if it is enabled.
	 *
	 * @param healthSmeType the health sme type
	 */
	public void cacheResult(HealthSmeType healthSmeType);

	/**
	 * Caches the health sme types in the entity cache if it is enabled.
	 *
	 * @param healthSmeTypes the health sme types
	 */
	public void cacheResult(java.util.List<HealthSmeType> healthSmeTypes);

	/**
	 * Creates a new health sme type with the primary key. Does not add the health sme type to the database.
	 *
	 * @param healthSmeTypeId the primary key for the new health sme type
	 * @return the new health sme type
	 */
	public HealthSmeType create(long healthSmeTypeId);

	/**
	 * Removes the health sme type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param healthSmeTypeId the primary key of the health sme type
	 * @return the health sme type that was removed
	 * @throws NoSuchHealthSmeTypeException if a health sme type with the primary key could not be found
	 */
	public HealthSmeType remove(long healthSmeTypeId)
		throws NoSuchHealthSmeTypeException;

	public HealthSmeType updateImpl(HealthSmeType healthSmeType);

	/**
	 * Returns the health sme type with the primary key or throws a <code>NoSuchHealthSmeTypeException</code> if it could not be found.
	 *
	 * @param healthSmeTypeId the primary key of the health sme type
	 * @return the health sme type
	 * @throws NoSuchHealthSmeTypeException if a health sme type with the primary key could not be found
	 */
	public HealthSmeType findByPrimaryKey(long healthSmeTypeId)
		throws NoSuchHealthSmeTypeException;

	/**
	 * Returns the health sme type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param healthSmeTypeId the primary key of the health sme type
	 * @return the health sme type, or <code>null</code> if a health sme type with the primary key could not be found
	 */
	public HealthSmeType fetchByPrimaryKey(long healthSmeTypeId);

	/**
	 * Returns all the health sme types.
	 *
	 * @return the health sme types
	 */
	public java.util.List<HealthSmeType> findAll();

	/**
	 * Returns a range of all the health sme types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme types
	 * @param end the upper bound of the range of health sme types (not inclusive)
	 * @return the range of health sme types
	 */
	public java.util.List<HealthSmeType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the health sme types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme types
	 * @param end the upper bound of the range of health sme types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of health sme types
	 */
	public java.util.List<HealthSmeType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HealthSmeType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the health sme types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme types
	 * @param end the upper bound of the range of health sme types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of health sme types
	 */
	public java.util.List<HealthSmeType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HealthSmeType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the health sme types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of health sme types.
	 *
	 * @return the number of health sme types
	 */
	public int countAll();

}