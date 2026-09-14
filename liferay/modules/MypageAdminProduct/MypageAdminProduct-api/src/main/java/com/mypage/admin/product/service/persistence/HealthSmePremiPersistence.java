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

import com.mypage.admin.product.exception.NoSuchHealthSmePremiException;
import com.mypage.admin.product.model.HealthSmePremi;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the health sme premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see HealthSmePremiUtil
 * @generated
 */
@ProviderType
public interface HealthSmePremiPersistence
	extends BasePersistence<HealthSmePremi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HealthSmePremiUtil} to access the health sme premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the health sme premi in the entity cache if it is enabled.
	 *
	 * @param healthSmePremi the health sme premi
	 */
	public void cacheResult(HealthSmePremi healthSmePremi);

	/**
	 * Caches the health sme premis in the entity cache if it is enabled.
	 *
	 * @param healthSmePremis the health sme premis
	 */
	public void cacheResult(java.util.List<HealthSmePremi> healthSmePremis);

	/**
	 * Creates a new health sme premi with the primary key. Does not add the health sme premi to the database.
	 *
	 * @param healthSmePremiId the primary key for the new health sme premi
	 * @return the new health sme premi
	 */
	public HealthSmePremi create(long healthSmePremiId);

	/**
	 * Removes the health sme premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param healthSmePremiId the primary key of the health sme premi
	 * @return the health sme premi that was removed
	 * @throws NoSuchHealthSmePremiException if a health sme premi with the primary key could not be found
	 */
	public HealthSmePremi remove(long healthSmePremiId)
		throws NoSuchHealthSmePremiException;

	public HealthSmePremi updateImpl(HealthSmePremi healthSmePremi);

	/**
	 * Returns the health sme premi with the primary key or throws a <code>NoSuchHealthSmePremiException</code> if it could not be found.
	 *
	 * @param healthSmePremiId the primary key of the health sme premi
	 * @return the health sme premi
	 * @throws NoSuchHealthSmePremiException if a health sme premi with the primary key could not be found
	 */
	public HealthSmePremi findByPrimaryKey(long healthSmePremiId)
		throws NoSuchHealthSmePremiException;

	/**
	 * Returns the health sme premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param healthSmePremiId the primary key of the health sme premi
	 * @return the health sme premi, or <code>null</code> if a health sme premi with the primary key could not be found
	 */
	public HealthSmePremi fetchByPrimaryKey(long healthSmePremiId);

	/**
	 * Returns all the health sme premis.
	 *
	 * @return the health sme premis
	 */
	public java.util.List<HealthSmePremi> findAll();

	/**
	 * Returns a range of all the health sme premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme premis
	 * @param end the upper bound of the range of health sme premis (not inclusive)
	 * @return the range of health sme premis
	 */
	public java.util.List<HealthSmePremi> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the health sme premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme premis
	 * @param end the upper bound of the range of health sme premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of health sme premis
	 */
	public java.util.List<HealthSmePremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HealthSmePremi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the health sme premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme premis
	 * @param end the upper bound of the range of health sme premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of health sme premis
	 */
	public java.util.List<HealthSmePremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HealthSmePremi>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the health sme premis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of health sme premis.
	 *
	 * @return the number of health sme premis
	 */
	public int countAll();

}