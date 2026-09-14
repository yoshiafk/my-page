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

import com.mypage.admin.product.exception.NoSuchBenefitTypeException;
import com.mypage.admin.product.model.BenefitType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the benefit type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see BenefitTypeUtil
 * @generated
 */
@ProviderType
public interface BenefitTypePersistence extends BasePersistence<BenefitType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BenefitTypeUtil} to access the benefit type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the benefit type in the entity cache if it is enabled.
	 *
	 * @param benefitType the benefit type
	 */
	public void cacheResult(BenefitType benefitType);

	/**
	 * Caches the benefit types in the entity cache if it is enabled.
	 *
	 * @param benefitTypes the benefit types
	 */
	public void cacheResult(java.util.List<BenefitType> benefitTypes);

	/**
	 * Creates a new benefit type with the primary key. Does not add the benefit type to the database.
	 *
	 * @param benefitTypeId the primary key for the new benefit type
	 * @return the new benefit type
	 */
	public BenefitType create(long benefitTypeId);

	/**
	 * Removes the benefit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param benefitTypeId the primary key of the benefit type
	 * @return the benefit type that was removed
	 * @throws NoSuchBenefitTypeException if a benefit type with the primary key could not be found
	 */
	public BenefitType remove(long benefitTypeId)
		throws NoSuchBenefitTypeException;

	public BenefitType updateImpl(BenefitType benefitType);

	/**
	 * Returns the benefit type with the primary key or throws a <code>NoSuchBenefitTypeException</code> if it could not be found.
	 *
	 * @param benefitTypeId the primary key of the benefit type
	 * @return the benefit type
	 * @throws NoSuchBenefitTypeException if a benefit type with the primary key could not be found
	 */
	public BenefitType findByPrimaryKey(long benefitTypeId)
		throws NoSuchBenefitTypeException;

	/**
	 * Returns the benefit type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param benefitTypeId the primary key of the benefit type
	 * @return the benefit type, or <code>null</code> if a benefit type with the primary key could not be found
	 */
	public BenefitType fetchByPrimaryKey(long benefitTypeId);

	/**
	 * Returns all the benefit types.
	 *
	 * @return the benefit types
	 */
	public java.util.List<BenefitType> findAll();

	/**
	 * Returns a range of all the benefit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit types
	 * @param end the upper bound of the range of benefit types (not inclusive)
	 * @return the range of benefit types
	 */
	public java.util.List<BenefitType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the benefit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit types
	 * @param end the upper bound of the range of benefit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of benefit types
	 */
	public java.util.List<BenefitType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BenefitType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the benefit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit types
	 * @param end the upper bound of the range of benefit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of benefit types
	 */
	public java.util.List<BenefitType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BenefitType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the benefit types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of benefit types.
	 *
	 * @return the number of benefit types
	 */
	public int countAll();

}