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

import com.mypage.admin.product.exception.NoSuchSmartActiveClassRateException;
import com.mypage.admin.product.model.SmartActiveClassRate;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the smart active class rate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveClassRateUtil
 * @generated
 */
@ProviderType
public interface SmartActiveClassRatePersistence
	extends BasePersistence<SmartActiveClassRate> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SmartActiveClassRateUtil} to access the smart active class rate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the smart active class rate in the entity cache if it is enabled.
	 *
	 * @param smartActiveClassRate the smart active class rate
	 */
	public void cacheResult(SmartActiveClassRate smartActiveClassRate);

	/**
	 * Caches the smart active class rates in the entity cache if it is enabled.
	 *
	 * @param smartActiveClassRates the smart active class rates
	 */
	public void cacheResult(
		java.util.List<SmartActiveClassRate> smartActiveClassRates);

	/**
	 * Creates a new smart active class rate with the primary key. Does not add the smart active class rate to the database.
	 *
	 * @param smartActiveClassRateId the primary key for the new smart active class rate
	 * @return the new smart active class rate
	 */
	public SmartActiveClassRate create(long smartActiveClassRateId);

	/**
	 * Removes the smart active class rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveClassRateId the primary key of the smart active class rate
	 * @return the smart active class rate that was removed
	 * @throws NoSuchSmartActiveClassRateException if a smart active class rate with the primary key could not be found
	 */
	public SmartActiveClassRate remove(long smartActiveClassRateId)
		throws NoSuchSmartActiveClassRateException;

	public SmartActiveClassRate updateImpl(
		SmartActiveClassRate smartActiveClassRate);

	/**
	 * Returns the smart active class rate with the primary key or throws a <code>NoSuchSmartActiveClassRateException</code> if it could not be found.
	 *
	 * @param smartActiveClassRateId the primary key of the smart active class rate
	 * @return the smart active class rate
	 * @throws NoSuchSmartActiveClassRateException if a smart active class rate with the primary key could not be found
	 */
	public SmartActiveClassRate findByPrimaryKey(long smartActiveClassRateId)
		throws NoSuchSmartActiveClassRateException;

	/**
	 * Returns the smart active class rate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveClassRateId the primary key of the smart active class rate
	 * @return the smart active class rate, or <code>null</code> if a smart active class rate with the primary key could not be found
	 */
	public SmartActiveClassRate fetchByPrimaryKey(long smartActiveClassRateId);

	/**
	 * Returns all the smart active class rates.
	 *
	 * @return the smart active class rates
	 */
	public java.util.List<SmartActiveClassRate> findAll();

	/**
	 * Returns a range of all the smart active class rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active class rates
	 * @param end the upper bound of the range of smart active class rates (not inclusive)
	 * @return the range of smart active class rates
	 */
	public java.util.List<SmartActiveClassRate> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the smart active class rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active class rates
	 * @param end the upper bound of the range of smart active class rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active class rates
	 */
	public java.util.List<SmartActiveClassRate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActiveClassRate>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smart active class rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active class rates
	 * @param end the upper bound of the range of smart active class rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active class rates
	 */
	public java.util.List<SmartActiveClassRate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActiveClassRate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the smart active class rates from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of smart active class rates.
	 *
	 * @return the number of smart active class rates
	 */
	public int countAll();

}