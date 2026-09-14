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

package com.mypage.leads.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.leads.exception.NoSuchDetailHealthIndividuException;
import com.mypage.leads.model.DetailHealthIndividu;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the detail health individu service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see DetailHealthIndividuUtil
 * @generated
 */
@ProviderType
public interface DetailHealthIndividuPersistence
	extends BasePersistence<DetailHealthIndividu> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DetailHealthIndividuUtil} to access the detail health individu persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the detail health individu where LeadsId = &#63; or throws a <code>NoSuchDetailHealthIndividuException</code> if it could not be found.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail health individu
	 * @throws NoSuchDetailHealthIndividuException if a matching detail health individu could not be found
	 */
	public DetailHealthIndividu findBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailHealthIndividuException;

	/**
	 * Returns the detail health individu where LeadsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail health individu, or <code>null</code> if a matching detail health individu could not be found
	 */
	public DetailHealthIndividu fetchBysearchByLeadsId(long LeadsId);

	/**
	 * Returns the detail health individu where LeadsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching detail health individu, or <code>null</code> if a matching detail health individu could not be found
	 */
	public DetailHealthIndividu fetchBysearchByLeadsId(
		long LeadsId, boolean useFinderCache);

	/**
	 * Removes the detail health individu where LeadsId = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 * @return the detail health individu that was removed
	 */
	public DetailHealthIndividu removeBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailHealthIndividuException;

	/**
	 * Returns the number of detail health individus where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the number of matching detail health individus
	 */
	public int countBysearchByLeadsId(long LeadsId);

	/**
	 * Caches the detail health individu in the entity cache if it is enabled.
	 *
	 * @param detailHealthIndividu the detail health individu
	 */
	public void cacheResult(DetailHealthIndividu detailHealthIndividu);

	/**
	 * Caches the detail health individus in the entity cache if it is enabled.
	 *
	 * @param detailHealthIndividus the detail health individus
	 */
	public void cacheResult(
		java.util.List<DetailHealthIndividu> detailHealthIndividus);

	/**
	 * Creates a new detail health individu with the primary key. Does not add the detail health individu to the database.
	 *
	 * @param detailHealthIndividuId the primary key for the new detail health individu
	 * @return the new detail health individu
	 */
	public DetailHealthIndividu create(long detailHealthIndividuId);

	/**
	 * Removes the detail health individu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param detailHealthIndividuId the primary key of the detail health individu
	 * @return the detail health individu that was removed
	 * @throws NoSuchDetailHealthIndividuException if a detail health individu with the primary key could not be found
	 */
	public DetailHealthIndividu remove(long detailHealthIndividuId)
		throws NoSuchDetailHealthIndividuException;

	public DetailHealthIndividu updateImpl(
		DetailHealthIndividu detailHealthIndividu);

	/**
	 * Returns the detail health individu with the primary key or throws a <code>NoSuchDetailHealthIndividuException</code> if it could not be found.
	 *
	 * @param detailHealthIndividuId the primary key of the detail health individu
	 * @return the detail health individu
	 * @throws NoSuchDetailHealthIndividuException if a detail health individu with the primary key could not be found
	 */
	public DetailHealthIndividu findByPrimaryKey(long detailHealthIndividuId)
		throws NoSuchDetailHealthIndividuException;

	/**
	 * Returns the detail health individu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param detailHealthIndividuId the primary key of the detail health individu
	 * @return the detail health individu, or <code>null</code> if a detail health individu with the primary key could not be found
	 */
	public DetailHealthIndividu fetchByPrimaryKey(long detailHealthIndividuId);

	/**
	 * Returns all the detail health individus.
	 *
	 * @return the detail health individus
	 */
	public java.util.List<DetailHealthIndividu> findAll();

	/**
	 * Returns a range of all the detail health individus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailHealthIndividuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail health individus
	 * @param end the upper bound of the range of detail health individus (not inclusive)
	 * @return the range of detail health individus
	 */
	public java.util.List<DetailHealthIndividu> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the detail health individus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailHealthIndividuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail health individus
	 * @param end the upper bound of the range of detail health individus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail health individus
	 */
	public java.util.List<DetailHealthIndividu> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DetailHealthIndividu>
			orderByComparator);

	/**
	 * Returns an ordered range of all the detail health individus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailHealthIndividuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail health individus
	 * @param end the upper bound of the range of detail health individus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail health individus
	 */
	public java.util.List<DetailHealthIndividu> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DetailHealthIndividu>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the detail health individus from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of detail health individus.
	 *
	 * @return the number of detail health individus
	 */
	public int countAll();

}