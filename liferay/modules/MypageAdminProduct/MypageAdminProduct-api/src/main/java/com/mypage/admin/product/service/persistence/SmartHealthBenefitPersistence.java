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

import com.mypage.admin.product.exception.NoSuchSmartHealthBenefitException;
import com.mypage.admin.product.model.SmartHealthBenefit;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the smart health benefit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartHealthBenefitUtil
 * @generated
 */
@ProviderType
public interface SmartHealthBenefitPersistence
	extends BasePersistence<SmartHealthBenefit> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SmartHealthBenefitUtil} to access the smart health benefit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the smart health benefits where smartHealthPlanId = &#63;.
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @return the matching smart health benefits
	 */
	public java.util.List<SmartHealthBenefit> findBysmartHealthPlanId(
		long smartHealthPlanId);

	/**
	 * Returns a range of all the smart health benefits where smartHealthPlanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @param start the lower bound of the range of smart health benefits
	 * @param end the upper bound of the range of smart health benefits (not inclusive)
	 * @return the range of matching smart health benefits
	 */
	public java.util.List<SmartHealthBenefit> findBysmartHealthPlanId(
		long smartHealthPlanId, int start, int end);

	/**
	 * Returns an ordered range of all the smart health benefits where smartHealthPlanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @param start the lower bound of the range of smart health benefits
	 * @param end the upper bound of the range of smart health benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smart health benefits
	 */
	public java.util.List<SmartHealthBenefit> findBysmartHealthPlanId(
		long smartHealthPlanId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartHealthBenefit>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smart health benefits where smartHealthPlanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @param start the lower bound of the range of smart health benefits
	 * @param end the upper bound of the range of smart health benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smart health benefits
	 */
	public java.util.List<SmartHealthBenefit> findBysmartHealthPlanId(
		long smartHealthPlanId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartHealthBenefit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first smart health benefit in the ordered set where smartHealthPlanId = &#63;.
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart health benefit
	 * @throws NoSuchSmartHealthBenefitException if a matching smart health benefit could not be found
	 */
	public SmartHealthBenefit findBysmartHealthPlanId_First(
			long smartHealthPlanId,
			com.liferay.portal.kernel.util.OrderByComparator<SmartHealthBenefit>
				orderByComparator)
		throws NoSuchSmartHealthBenefitException;

	/**
	 * Returns the first smart health benefit in the ordered set where smartHealthPlanId = &#63;.
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart health benefit, or <code>null</code> if a matching smart health benefit could not be found
	 */
	public SmartHealthBenefit fetchBysmartHealthPlanId_First(
		long smartHealthPlanId,
		com.liferay.portal.kernel.util.OrderByComparator<SmartHealthBenefit>
			orderByComparator);

	/**
	 * Returns the last smart health benefit in the ordered set where smartHealthPlanId = &#63;.
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart health benefit
	 * @throws NoSuchSmartHealthBenefitException if a matching smart health benefit could not be found
	 */
	public SmartHealthBenefit findBysmartHealthPlanId_Last(
			long smartHealthPlanId,
			com.liferay.portal.kernel.util.OrderByComparator<SmartHealthBenefit>
				orderByComparator)
		throws NoSuchSmartHealthBenefitException;

	/**
	 * Returns the last smart health benefit in the ordered set where smartHealthPlanId = &#63;.
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart health benefit, or <code>null</code> if a matching smart health benefit could not be found
	 */
	public SmartHealthBenefit fetchBysmartHealthPlanId_Last(
		long smartHealthPlanId,
		com.liferay.portal.kernel.util.OrderByComparator<SmartHealthBenefit>
			orderByComparator);

	/**
	 * Returns the smart health benefits before and after the current smart health benefit in the ordered set where smartHealthPlanId = &#63;.
	 *
	 * @param smartHealthBenefitId the primary key of the current smart health benefit
	 * @param smartHealthPlanId the smart health plan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next smart health benefit
	 * @throws NoSuchSmartHealthBenefitException if a smart health benefit with the primary key could not be found
	 */
	public SmartHealthBenefit[] findBysmartHealthPlanId_PrevAndNext(
			long smartHealthBenefitId, long smartHealthPlanId,
			com.liferay.portal.kernel.util.OrderByComparator<SmartHealthBenefit>
				orderByComparator)
		throws NoSuchSmartHealthBenefitException;

	/**
	 * Removes all the smart health benefits where smartHealthPlanId = &#63; from the database.
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 */
	public void removeBysmartHealthPlanId(long smartHealthPlanId);

	/**
	 * Returns the number of smart health benefits where smartHealthPlanId = &#63;.
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @return the number of matching smart health benefits
	 */
	public int countBysmartHealthPlanId(long smartHealthPlanId);

	/**
	 * Caches the smart health benefit in the entity cache if it is enabled.
	 *
	 * @param smartHealthBenefit the smart health benefit
	 */
	public void cacheResult(SmartHealthBenefit smartHealthBenefit);

	/**
	 * Caches the smart health benefits in the entity cache if it is enabled.
	 *
	 * @param smartHealthBenefits the smart health benefits
	 */
	public void cacheResult(
		java.util.List<SmartHealthBenefit> smartHealthBenefits);

	/**
	 * Creates a new smart health benefit with the primary key. Does not add the smart health benefit to the database.
	 *
	 * @param smartHealthBenefitId the primary key for the new smart health benefit
	 * @return the new smart health benefit
	 */
	public SmartHealthBenefit create(long smartHealthBenefitId);

	/**
	 * Removes the smart health benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartHealthBenefitId the primary key of the smart health benefit
	 * @return the smart health benefit that was removed
	 * @throws NoSuchSmartHealthBenefitException if a smart health benefit with the primary key could not be found
	 */
	public SmartHealthBenefit remove(long smartHealthBenefitId)
		throws NoSuchSmartHealthBenefitException;

	public SmartHealthBenefit updateImpl(SmartHealthBenefit smartHealthBenefit);

	/**
	 * Returns the smart health benefit with the primary key or throws a <code>NoSuchSmartHealthBenefitException</code> if it could not be found.
	 *
	 * @param smartHealthBenefitId the primary key of the smart health benefit
	 * @return the smart health benefit
	 * @throws NoSuchSmartHealthBenefitException if a smart health benefit with the primary key could not be found
	 */
	public SmartHealthBenefit findByPrimaryKey(long smartHealthBenefitId)
		throws NoSuchSmartHealthBenefitException;

	/**
	 * Returns the smart health benefit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartHealthBenefitId the primary key of the smart health benefit
	 * @return the smart health benefit, or <code>null</code> if a smart health benefit with the primary key could not be found
	 */
	public SmartHealthBenefit fetchByPrimaryKey(long smartHealthBenefitId);

	/**
	 * Returns all the smart health benefits.
	 *
	 * @return the smart health benefits
	 */
	public java.util.List<SmartHealthBenefit> findAll();

	/**
	 * Returns a range of all the smart health benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefits
	 * @param end the upper bound of the range of smart health benefits (not inclusive)
	 * @return the range of smart health benefits
	 */
	public java.util.List<SmartHealthBenefit> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the smart health benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefits
	 * @param end the upper bound of the range of smart health benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart health benefits
	 */
	public java.util.List<SmartHealthBenefit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartHealthBenefit>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smart health benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefits
	 * @param end the upper bound of the range of smart health benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart health benefits
	 */
	public java.util.List<SmartHealthBenefit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartHealthBenefit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the smart health benefits from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of smart health benefits.
	 *
	 * @return the number of smart health benefits
	 */
	public int countAll();

}