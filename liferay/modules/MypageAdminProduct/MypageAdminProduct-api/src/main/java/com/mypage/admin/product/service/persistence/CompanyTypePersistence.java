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

import com.mypage.admin.product.exception.NoSuchCompanyTypeException;
import com.mypage.admin.product.model.CompanyType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the company type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see CompanyTypeUtil
 * @generated
 */
@ProviderType
public interface CompanyTypePersistence extends BasePersistence<CompanyType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CompanyTypeUtil} to access the company type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the company type in the entity cache if it is enabled.
	 *
	 * @param companyType the company type
	 */
	public void cacheResult(CompanyType companyType);

	/**
	 * Caches the company types in the entity cache if it is enabled.
	 *
	 * @param companyTypes the company types
	 */
	public void cacheResult(java.util.List<CompanyType> companyTypes);

	/**
	 * Creates a new company type with the primary key. Does not add the company type to the database.
	 *
	 * @param companyTypeId the primary key for the new company type
	 * @return the new company type
	 */
	public CompanyType create(long companyTypeId);

	/**
	 * Removes the company type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param companyTypeId the primary key of the company type
	 * @return the company type that was removed
	 * @throws NoSuchCompanyTypeException if a company type with the primary key could not be found
	 */
	public CompanyType remove(long companyTypeId)
		throws NoSuchCompanyTypeException;

	public CompanyType updateImpl(CompanyType companyType);

	/**
	 * Returns the company type with the primary key or throws a <code>NoSuchCompanyTypeException</code> if it could not be found.
	 *
	 * @param companyTypeId the primary key of the company type
	 * @return the company type
	 * @throws NoSuchCompanyTypeException if a company type with the primary key could not be found
	 */
	public CompanyType findByPrimaryKey(long companyTypeId)
		throws NoSuchCompanyTypeException;

	/**
	 * Returns the company type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param companyTypeId the primary key of the company type
	 * @return the company type, or <code>null</code> if a company type with the primary key could not be found
	 */
	public CompanyType fetchByPrimaryKey(long companyTypeId);

	/**
	 * Returns all the company types.
	 *
	 * @return the company types
	 */
	public java.util.List<CompanyType> findAll();

	/**
	 * Returns a range of all the company types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of company types
	 * @param end the upper bound of the range of company types (not inclusive)
	 * @return the range of company types
	 */
	public java.util.List<CompanyType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the company types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of company types
	 * @param end the upper bound of the range of company types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of company types
	 */
	public java.util.List<CompanyType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompanyType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the company types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of company types
	 * @param end the upper bound of the range of company types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of company types
	 */
	public java.util.List<CompanyType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompanyType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the company types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of company types.
	 *
	 * @return the number of company types
	 */
	public int countAll();

}