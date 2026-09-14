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

import com.mypage.admin.product.exception.NoSuchSmartActivePremiException;
import com.mypage.admin.product.model.SmartActivePremi;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the smart active premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActivePremiUtil
 * @generated
 */
@ProviderType
public interface SmartActivePremiPersistence
	extends BasePersistence<SmartActivePremi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SmartActivePremiUtil} to access the smart active premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the smart active premi where smartActiveBenefitId = &#63; and smartActiveClassRateId = &#63; or throws a <code>NoSuchSmartActivePremiException</code> if it could not be found.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveClassRateId the smart active class rate ID
	 * @return the matching smart active premi
	 * @throws NoSuchSmartActivePremiException if a matching smart active premi could not be found
	 */
	public SmartActivePremi findByBenefitIdAndClassId(
			long smartActiveBenefitId, long smartActiveClassRateId)
		throws NoSuchSmartActivePremiException;

	/**
	 * Returns the smart active premi where smartActiveBenefitId = &#63; and smartActiveClassRateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveClassRateId the smart active class rate ID
	 * @return the matching smart active premi, or <code>null</code> if a matching smart active premi could not be found
	 */
	public SmartActivePremi fetchByBenefitIdAndClassId(
		long smartActiveBenefitId, long smartActiveClassRateId);

	/**
	 * Returns the smart active premi where smartActiveBenefitId = &#63; and smartActiveClassRateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveClassRateId the smart active class rate ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active premi, or <code>null</code> if a matching smart active premi could not be found
	 */
	public SmartActivePremi fetchByBenefitIdAndClassId(
		long smartActiveBenefitId, long smartActiveClassRateId,
		boolean useFinderCache);

	/**
	 * Removes the smart active premi where smartActiveBenefitId = &#63; and smartActiveClassRateId = &#63; from the database.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveClassRateId the smart active class rate ID
	 * @return the smart active premi that was removed
	 */
	public SmartActivePremi removeByBenefitIdAndClassId(
			long smartActiveBenefitId, long smartActiveClassRateId)
		throws NoSuchSmartActivePremiException;

	/**
	 * Returns the number of smart active premis where smartActiveBenefitId = &#63; and smartActiveClassRateId = &#63;.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveClassRateId the smart active class rate ID
	 * @return the number of matching smart active premis
	 */
	public int countByBenefitIdAndClassId(
		long smartActiveBenefitId, long smartActiveClassRateId);

	/**
	 * Caches the smart active premi in the entity cache if it is enabled.
	 *
	 * @param smartActivePremi the smart active premi
	 */
	public void cacheResult(SmartActivePremi smartActivePremi);

	/**
	 * Caches the smart active premis in the entity cache if it is enabled.
	 *
	 * @param smartActivePremis the smart active premis
	 */
	public void cacheResult(java.util.List<SmartActivePremi> smartActivePremis);

	/**
	 * Creates a new smart active premi with the primary key. Does not add the smart active premi to the database.
	 *
	 * @param smartActivePremiId the primary key for the new smart active premi
	 * @return the new smart active premi
	 */
	public SmartActivePremi create(long smartActivePremiId);

	/**
	 * Removes the smart active premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActivePremiId the primary key of the smart active premi
	 * @return the smart active premi that was removed
	 * @throws NoSuchSmartActivePremiException if a smart active premi with the primary key could not be found
	 */
	public SmartActivePremi remove(long smartActivePremiId)
		throws NoSuchSmartActivePremiException;

	public SmartActivePremi updateImpl(SmartActivePremi smartActivePremi);

	/**
	 * Returns the smart active premi with the primary key or throws a <code>NoSuchSmartActivePremiException</code> if it could not be found.
	 *
	 * @param smartActivePremiId the primary key of the smart active premi
	 * @return the smart active premi
	 * @throws NoSuchSmartActivePremiException if a smart active premi with the primary key could not be found
	 */
	public SmartActivePremi findByPrimaryKey(long smartActivePremiId)
		throws NoSuchSmartActivePremiException;

	/**
	 * Returns the smart active premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActivePremiId the primary key of the smart active premi
	 * @return the smart active premi, or <code>null</code> if a smart active premi with the primary key could not be found
	 */
	public SmartActivePremi fetchByPrimaryKey(long smartActivePremiId);

	/**
	 * Returns all the smart active premis.
	 *
	 * @return the smart active premis
	 */
	public java.util.List<SmartActivePremi> findAll();

	/**
	 * Returns a range of all the smart active premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActivePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active premis
	 * @param end the upper bound of the range of smart active premis (not inclusive)
	 * @return the range of smart active premis
	 */
	public java.util.List<SmartActivePremi> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the smart active premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActivePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active premis
	 * @param end the upper bound of the range of smart active premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active premis
	 */
	public java.util.List<SmartActivePremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActivePremi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smart active premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActivePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active premis
	 * @param end the upper bound of the range of smart active premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active premis
	 */
	public java.util.List<SmartActivePremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActivePremi>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the smart active premis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of smart active premis.
	 *
	 * @return the number of smart active premis
	 */
	public int countAll();

}