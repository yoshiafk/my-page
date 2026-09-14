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

import com.mypage.admin.product.exception.NoSuchHealthIndividuPremiException;
import com.mypage.admin.product.model.HealthIndividuPremi;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the health individu premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see HealthIndividuPremiUtil
 * @generated
 */
@ProviderType
public interface HealthIndividuPremiPersistence
	extends BasePersistence<HealthIndividuPremi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HealthIndividuPremiUtil} to access the health individu premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the health individu premi where planId = &#63; and age = &#63; or throws a <code>NoSuchHealthIndividuPremiException</code> if it could not be found.
	 *
	 * @param planId the plan ID
	 * @param age the age
	 * @return the matching health individu premi
	 * @throws NoSuchHealthIndividuPremiException if a matching health individu premi could not be found
	 */
	public HealthIndividuPremi findBysearchByPlanIdAndAge(long planId, int age)
		throws NoSuchHealthIndividuPremiException;

	/**
	 * Returns the health individu premi where planId = &#63; and age = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param planId the plan ID
	 * @param age the age
	 * @return the matching health individu premi, or <code>null</code> if a matching health individu premi could not be found
	 */
	public HealthIndividuPremi fetchBysearchByPlanIdAndAge(
		long planId, int age);

	/**
	 * Returns the health individu premi where planId = &#63; and age = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param planId the plan ID
	 * @param age the age
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching health individu premi, or <code>null</code> if a matching health individu premi could not be found
	 */
	public HealthIndividuPremi fetchBysearchByPlanIdAndAge(
		long planId, int age, boolean useFinderCache);

	/**
	 * Removes the health individu premi where planId = &#63; and age = &#63; from the database.
	 *
	 * @param planId the plan ID
	 * @param age the age
	 * @return the health individu premi that was removed
	 */
	public HealthIndividuPremi removeBysearchByPlanIdAndAge(
			long planId, int age)
		throws NoSuchHealthIndividuPremiException;

	/**
	 * Returns the number of health individu premis where planId = &#63; and age = &#63;.
	 *
	 * @param planId the plan ID
	 * @param age the age
	 * @return the number of matching health individu premis
	 */
	public int countBysearchByPlanIdAndAge(long planId, int age);

	/**
	 * Caches the health individu premi in the entity cache if it is enabled.
	 *
	 * @param healthIndividuPremi the health individu premi
	 */
	public void cacheResult(HealthIndividuPremi healthIndividuPremi);

	/**
	 * Caches the health individu premis in the entity cache if it is enabled.
	 *
	 * @param healthIndividuPremis the health individu premis
	 */
	public void cacheResult(
		java.util.List<HealthIndividuPremi> healthIndividuPremis);

	/**
	 * Creates a new health individu premi with the primary key. Does not add the health individu premi to the database.
	 *
	 * @param healthIndividuPremiId the primary key for the new health individu premi
	 * @return the new health individu premi
	 */
	public HealthIndividuPremi create(long healthIndividuPremiId);

	/**
	 * Removes the health individu premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param healthIndividuPremiId the primary key of the health individu premi
	 * @return the health individu premi that was removed
	 * @throws NoSuchHealthIndividuPremiException if a health individu premi with the primary key could not be found
	 */
	public HealthIndividuPremi remove(long healthIndividuPremiId)
		throws NoSuchHealthIndividuPremiException;

	public HealthIndividuPremi updateImpl(
		HealthIndividuPremi healthIndividuPremi);

	/**
	 * Returns the health individu premi with the primary key or throws a <code>NoSuchHealthIndividuPremiException</code> if it could not be found.
	 *
	 * @param healthIndividuPremiId the primary key of the health individu premi
	 * @return the health individu premi
	 * @throws NoSuchHealthIndividuPremiException if a health individu premi with the primary key could not be found
	 */
	public HealthIndividuPremi findByPrimaryKey(long healthIndividuPremiId)
		throws NoSuchHealthIndividuPremiException;

	/**
	 * Returns the health individu premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param healthIndividuPremiId the primary key of the health individu premi
	 * @return the health individu premi, or <code>null</code> if a health individu premi with the primary key could not be found
	 */
	public HealthIndividuPremi fetchByPrimaryKey(long healthIndividuPremiId);

	/**
	 * Returns all the health individu premis.
	 *
	 * @return the health individu premis
	 */
	public java.util.List<HealthIndividuPremi> findAll();

	/**
	 * Returns a range of all the health individu premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu premis
	 * @param end the upper bound of the range of health individu premis (not inclusive)
	 * @return the range of health individu premis
	 */
	public java.util.List<HealthIndividuPremi> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the health individu premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu premis
	 * @param end the upper bound of the range of health individu premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of health individu premis
	 */
	public java.util.List<HealthIndividuPremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HealthIndividuPremi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the health individu premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu premis
	 * @param end the upper bound of the range of health individu premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of health individu premis
	 */
	public java.util.List<HealthIndividuPremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HealthIndividuPremi>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the health individu premis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of health individu premis.
	 *
	 * @return the number of health individu premis
	 */
	public int countAll();

}