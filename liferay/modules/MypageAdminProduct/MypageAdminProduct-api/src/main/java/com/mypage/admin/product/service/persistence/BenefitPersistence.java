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

import com.mypage.admin.product.exception.NoSuchBenefitException;
import com.mypage.admin.product.model.Benefit;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the benefit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see BenefitUtil
 * @generated
 */
@ProviderType
public interface BenefitPersistence extends BasePersistence<Benefit> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BenefitUtil} to access the benefit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the benefit in the entity cache if it is enabled.
	 *
	 * @param benefit the benefit
	 */
	public void cacheResult(Benefit benefit);

	/**
	 * Caches the benefits in the entity cache if it is enabled.
	 *
	 * @param benefits the benefits
	 */
	public void cacheResult(java.util.List<Benefit> benefits);

	/**
	 * Creates a new benefit with the primary key. Does not add the benefit to the database.
	 *
	 * @param benefitId the primary key for the new benefit
	 * @return the new benefit
	 */
	public Benefit create(long benefitId);

	/**
	 * Removes the benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param benefitId the primary key of the benefit
	 * @return the benefit that was removed
	 * @throws NoSuchBenefitException if a benefit with the primary key could not be found
	 */
	public Benefit remove(long benefitId) throws NoSuchBenefitException;

	public Benefit updateImpl(Benefit benefit);

	/**
	 * Returns the benefit with the primary key or throws a <code>NoSuchBenefitException</code> if it could not be found.
	 *
	 * @param benefitId the primary key of the benefit
	 * @return the benefit
	 * @throws NoSuchBenefitException if a benefit with the primary key could not be found
	 */
	public Benefit findByPrimaryKey(long benefitId)
		throws NoSuchBenefitException;

	/**
	 * Returns the benefit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param benefitId the primary key of the benefit
	 * @return the benefit, or <code>null</code> if a benefit with the primary key could not be found
	 */
	public Benefit fetchByPrimaryKey(long benefitId);

	/**
	 * Returns all the benefits.
	 *
	 * @return the benefits
	 */
	public java.util.List<Benefit> findAll();

	/**
	 * Returns a range of all the benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefits
	 * @param end the upper bound of the range of benefits (not inclusive)
	 * @return the range of benefits
	 */
	public java.util.List<Benefit> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefits
	 * @param end the upper bound of the range of benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of benefits
	 */
	public java.util.List<Benefit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Benefit>
			orderByComparator);

	/**
	 * Returns an ordered range of all the benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefits
	 * @param end the upper bound of the range of benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of benefits
	 */
	public java.util.List<Benefit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Benefit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the benefits from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of benefits.
	 *
	 * @return the number of benefits
	 */
	public int countAll();

}