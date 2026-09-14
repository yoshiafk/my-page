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

import com.mypage.admin.product.exception.NoSuchStiBenefitException;
import com.mypage.admin.product.model.StiBenefit;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sti benefit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see StiBenefitUtil
 * @generated
 */
@ProviderType
public interface StiBenefitPersistence extends BasePersistence<StiBenefit> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StiBenefitUtil} to access the sti benefit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the sti benefit in the entity cache if it is enabled.
	 *
	 * @param stiBenefit the sti benefit
	 */
	public void cacheResult(StiBenefit stiBenefit);

	/**
	 * Caches the sti benefits in the entity cache if it is enabled.
	 *
	 * @param stiBenefits the sti benefits
	 */
	public void cacheResult(java.util.List<StiBenefit> stiBenefits);

	/**
	 * Creates a new sti benefit with the primary key. Does not add the sti benefit to the database.
	 *
	 * @param benefitId the primary key for the new sti benefit
	 * @return the new sti benefit
	 */
	public StiBenefit create(long benefitId);

	/**
	 * Removes the sti benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param benefitId the primary key of the sti benefit
	 * @return the sti benefit that was removed
	 * @throws NoSuchStiBenefitException if a sti benefit with the primary key could not be found
	 */
	public StiBenefit remove(long benefitId) throws NoSuchStiBenefitException;

	public StiBenefit updateImpl(StiBenefit stiBenefit);

	/**
	 * Returns the sti benefit with the primary key or throws a <code>NoSuchStiBenefitException</code> if it could not be found.
	 *
	 * @param benefitId the primary key of the sti benefit
	 * @return the sti benefit
	 * @throws NoSuchStiBenefitException if a sti benefit with the primary key could not be found
	 */
	public StiBenefit findByPrimaryKey(long benefitId)
		throws NoSuchStiBenefitException;

	/**
	 * Returns the sti benefit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param benefitId the primary key of the sti benefit
	 * @return the sti benefit, or <code>null</code> if a sti benefit with the primary key could not be found
	 */
	public StiBenefit fetchByPrimaryKey(long benefitId);

	/**
	 * Returns all the sti benefits.
	 *
	 * @return the sti benefits
	 */
	public java.util.List<StiBenefit> findAll();

	/**
	 * Returns a range of all the sti benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti benefits
	 * @param end the upper bound of the range of sti benefits (not inclusive)
	 * @return the range of sti benefits
	 */
	public java.util.List<StiBenefit> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the sti benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti benefits
	 * @param end the upper bound of the range of sti benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sti benefits
	 */
	public java.util.List<StiBenefit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StiBenefit>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sti benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti benefits
	 * @param end the upper bound of the range of sti benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sti benefits
	 */
	public java.util.List<StiBenefit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StiBenefit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sti benefits from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sti benefits.
	 *
	 * @return the number of sti benefits
	 */
	public int countAll();

}