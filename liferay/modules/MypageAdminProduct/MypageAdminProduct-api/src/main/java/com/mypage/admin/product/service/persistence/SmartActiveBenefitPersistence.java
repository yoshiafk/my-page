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

import com.mypage.admin.product.exception.NoSuchSmartActiveBenefitException;
import com.mypage.admin.product.model.SmartActiveBenefit;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the smart active benefit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveBenefitUtil
 * @generated
 */
@ProviderType
public interface SmartActiveBenefitPersistence
	extends BasePersistence<SmartActiveBenefit> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SmartActiveBenefitUtil} to access the smart active benefit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the smart active benefits where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @return the matching smart active benefits
	 */
	public java.util.List<SmartActiveBenefit> findByBenefitTypeId(
		long smartActiveBenefitTypeId);

	/**
	 * Returns a range of all the smart active benefits where smartActiveBenefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @return the range of matching smart active benefits
	 */
	public java.util.List<SmartActiveBenefit> findByBenefitTypeId(
		long smartActiveBenefitTypeId, int start, int end);

	/**
	 * Returns an ordered range of all the smart active benefits where smartActiveBenefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smart active benefits
	 */
	public java.util.List<SmartActiveBenefit> findByBenefitTypeId(
		long smartActiveBenefitTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActiveBenefit>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smart active benefits where smartActiveBenefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smart active benefits
	 */
	public java.util.List<SmartActiveBenefit> findByBenefitTypeId(
		long smartActiveBenefitTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActiveBenefit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first smart active benefit in the ordered set where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart active benefit
	 * @throws NoSuchSmartActiveBenefitException if a matching smart active benefit could not be found
	 */
	public SmartActiveBenefit findByBenefitTypeId_First(
			long smartActiveBenefitTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<SmartActiveBenefit>
				orderByComparator)
		throws NoSuchSmartActiveBenefitException;

	/**
	 * Returns the first smart active benefit in the ordered set where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart active benefit, or <code>null</code> if a matching smart active benefit could not be found
	 */
	public SmartActiveBenefit fetchByBenefitTypeId_First(
		long smartActiveBenefitTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActiveBenefit>
			orderByComparator);

	/**
	 * Returns the last smart active benefit in the ordered set where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart active benefit
	 * @throws NoSuchSmartActiveBenefitException if a matching smart active benefit could not be found
	 */
	public SmartActiveBenefit findByBenefitTypeId_Last(
			long smartActiveBenefitTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<SmartActiveBenefit>
				orderByComparator)
		throws NoSuchSmartActiveBenefitException;

	/**
	 * Returns the last smart active benefit in the ordered set where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart active benefit, or <code>null</code> if a matching smart active benefit could not be found
	 */
	public SmartActiveBenefit fetchByBenefitTypeId_Last(
		long smartActiveBenefitTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActiveBenefit>
			orderByComparator);

	/**
	 * Returns the smart active benefits before and after the current smart active benefit in the ordered set where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitId the primary key of the current smart active benefit
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next smart active benefit
	 * @throws NoSuchSmartActiveBenefitException if a smart active benefit with the primary key could not be found
	 */
	public SmartActiveBenefit[] findByBenefitTypeId_PrevAndNext(
			long smartActiveBenefitId, long smartActiveBenefitTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<SmartActiveBenefit>
				orderByComparator)
		throws NoSuchSmartActiveBenefitException;

	/**
	 * Removes all the smart active benefits where smartActiveBenefitTypeId = &#63; from the database.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 */
	public void removeByBenefitTypeId(long smartActiveBenefitTypeId);

	/**
	 * Returns the number of smart active benefits where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @return the number of matching smart active benefits
	 */
	public int countByBenefitTypeId(long smartActiveBenefitTypeId);

	/**
	 * Returns the smart active benefit where externalCode = &#63; or throws a <code>NoSuchSmartActiveBenefitException</code> if it could not be found.
	 *
	 * @param externalCode the external code
	 * @return the matching smart active benefit
	 * @throws NoSuchSmartActiveBenefitException if a matching smart active benefit could not be found
	 */
	public SmartActiveBenefit findByExternalCode(String externalCode)
		throws NoSuchSmartActiveBenefitException;

	/**
	 * Returns the smart active benefit where externalCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCode the external code
	 * @return the matching smart active benefit, or <code>null</code> if a matching smart active benefit could not be found
	 */
	public SmartActiveBenefit fetchByExternalCode(String externalCode);

	/**
	 * Returns the smart active benefit where externalCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCode the external code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active benefit, or <code>null</code> if a matching smart active benefit could not be found
	 */
	public SmartActiveBenefit fetchByExternalCode(
		String externalCode, boolean useFinderCache);

	/**
	 * Removes the smart active benefit where externalCode = &#63; from the database.
	 *
	 * @param externalCode the external code
	 * @return the smart active benefit that was removed
	 */
	public SmartActiveBenefit removeByExternalCode(String externalCode)
		throws NoSuchSmartActiveBenefitException;

	/**
	 * Returns the number of smart active benefits where externalCode = &#63;.
	 *
	 * @param externalCode the external code
	 * @return the number of matching smart active benefits
	 */
	public int countByExternalCode(String externalCode);

	/**
	 * Caches the smart active benefit in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefit the smart active benefit
	 */
	public void cacheResult(SmartActiveBenefit smartActiveBenefit);

	/**
	 * Caches the smart active benefits in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefits the smart active benefits
	 */
	public void cacheResult(
		java.util.List<SmartActiveBenefit> smartActiveBenefits);

	/**
	 * Creates a new smart active benefit with the primary key. Does not add the smart active benefit to the database.
	 *
	 * @param smartActiveBenefitId the primary key for the new smart active benefit
	 * @return the new smart active benefit
	 */
	public SmartActiveBenefit create(long smartActiveBenefitId);

	/**
	 * Removes the smart active benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveBenefitId the primary key of the smart active benefit
	 * @return the smart active benefit that was removed
	 * @throws NoSuchSmartActiveBenefitException if a smart active benefit with the primary key could not be found
	 */
	public SmartActiveBenefit remove(long smartActiveBenefitId)
		throws NoSuchSmartActiveBenefitException;

	public SmartActiveBenefit updateImpl(SmartActiveBenefit smartActiveBenefit);

	/**
	 * Returns the smart active benefit with the primary key or throws a <code>NoSuchSmartActiveBenefitException</code> if it could not be found.
	 *
	 * @param smartActiveBenefitId the primary key of the smart active benefit
	 * @return the smart active benefit
	 * @throws NoSuchSmartActiveBenefitException if a smart active benefit with the primary key could not be found
	 */
	public SmartActiveBenefit findByPrimaryKey(long smartActiveBenefitId)
		throws NoSuchSmartActiveBenefitException;

	/**
	 * Returns the smart active benefit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveBenefitId the primary key of the smart active benefit
	 * @return the smart active benefit, or <code>null</code> if a smart active benefit with the primary key could not be found
	 */
	public SmartActiveBenefit fetchByPrimaryKey(long smartActiveBenefitId);

	/**
	 * Returns all the smart active benefits.
	 *
	 * @return the smart active benefits
	 */
	public java.util.List<SmartActiveBenefit> findAll();

	/**
	 * Returns a range of all the smart active benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @return the range of smart active benefits
	 */
	public java.util.List<SmartActiveBenefit> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the smart active benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active benefits
	 */
	public java.util.List<SmartActiveBenefit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActiveBenefit>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smart active benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active benefits
	 */
	public java.util.List<SmartActiveBenefit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActiveBenefit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the smart active benefits from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of smart active benefits.
	 *
	 * @return the number of smart active benefits
	 */
	public int countAll();

}