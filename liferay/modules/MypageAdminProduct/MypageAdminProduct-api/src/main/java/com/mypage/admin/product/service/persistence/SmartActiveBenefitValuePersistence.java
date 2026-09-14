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

import com.mypage.admin.product.exception.NoSuchSmartActiveBenefitValueException;
import com.mypage.admin.product.model.SmartActiveBenefitValue;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the smart active benefit value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveBenefitValueUtil
 * @generated
 */
@ProviderType
public interface SmartActiveBenefitValuePersistence
	extends BasePersistence<SmartActiveBenefitValue> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SmartActiveBenefitValueUtil} to access the smart active benefit value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the smart active benefit value where value = &#63; or throws a <code>NoSuchSmartActiveBenefitValueException</code> if it could not be found.
	 *
	 * @param value the value
	 * @return the matching smart active benefit value
	 * @throws NoSuchSmartActiveBenefitValueException if a matching smart active benefit value could not be found
	 */
	public SmartActiveBenefitValue findByValue(long value)
		throws NoSuchSmartActiveBenefitValueException;

	/**
	 * Returns the smart active benefit value where value = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param value the value
	 * @return the matching smart active benefit value, or <code>null</code> if a matching smart active benefit value could not be found
	 */
	public SmartActiveBenefitValue fetchByValue(long value);

	/**
	 * Returns the smart active benefit value where value = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param value the value
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active benefit value, or <code>null</code> if a matching smart active benefit value could not be found
	 */
	public SmartActiveBenefitValue fetchByValue(
		long value, boolean useFinderCache);

	/**
	 * Removes the smart active benefit value where value = &#63; from the database.
	 *
	 * @param value the value
	 * @return the smart active benefit value that was removed
	 */
	public SmartActiveBenefitValue removeByValue(long value)
		throws NoSuchSmartActiveBenefitValueException;

	/**
	 * Returns the number of smart active benefit values where value = &#63;.
	 *
	 * @param value the value
	 * @return the number of matching smart active benefit values
	 */
	public int countByValue(long value);

	/**
	 * Caches the smart active benefit value in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefitValue the smart active benefit value
	 */
	public void cacheResult(SmartActiveBenefitValue smartActiveBenefitValue);

	/**
	 * Caches the smart active benefit values in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefitValues the smart active benefit values
	 */
	public void cacheResult(
		java.util.List<SmartActiveBenefitValue> smartActiveBenefitValues);

	/**
	 * Creates a new smart active benefit value with the primary key. Does not add the smart active benefit value to the database.
	 *
	 * @param smartActiveBenefitValueId the primary key for the new smart active benefit value
	 * @return the new smart active benefit value
	 */
	public SmartActiveBenefitValue create(long smartActiveBenefitValueId);

	/**
	 * Removes the smart active benefit value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveBenefitValueId the primary key of the smart active benefit value
	 * @return the smart active benefit value that was removed
	 * @throws NoSuchSmartActiveBenefitValueException if a smart active benefit value with the primary key could not be found
	 */
	public SmartActiveBenefitValue remove(long smartActiveBenefitValueId)
		throws NoSuchSmartActiveBenefitValueException;

	public SmartActiveBenefitValue updateImpl(
		SmartActiveBenefitValue smartActiveBenefitValue);

	/**
	 * Returns the smart active benefit value with the primary key or throws a <code>NoSuchSmartActiveBenefitValueException</code> if it could not be found.
	 *
	 * @param smartActiveBenefitValueId the primary key of the smart active benefit value
	 * @return the smart active benefit value
	 * @throws NoSuchSmartActiveBenefitValueException if a smart active benefit value with the primary key could not be found
	 */
	public SmartActiveBenefitValue findByPrimaryKey(
			long smartActiveBenefitValueId)
		throws NoSuchSmartActiveBenefitValueException;

	/**
	 * Returns the smart active benefit value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveBenefitValueId the primary key of the smart active benefit value
	 * @return the smart active benefit value, or <code>null</code> if a smart active benefit value with the primary key could not be found
	 */
	public SmartActiveBenefitValue fetchByPrimaryKey(
		long smartActiveBenefitValueId);

	/**
	 * Returns all the smart active benefit values.
	 *
	 * @return the smart active benefit values
	 */
	public java.util.List<SmartActiveBenefitValue> findAll();

	/**
	 * Returns a range of all the smart active benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit values
	 * @param end the upper bound of the range of smart active benefit values (not inclusive)
	 * @return the range of smart active benefit values
	 */
	public java.util.List<SmartActiveBenefitValue> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the smart active benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit values
	 * @param end the upper bound of the range of smart active benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active benefit values
	 */
	public java.util.List<SmartActiveBenefitValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SmartActiveBenefitValue> orderByComparator);

	/**
	 * Returns an ordered range of all the smart active benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit values
	 * @param end the upper bound of the range of smart active benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active benefit values
	 */
	public java.util.List<SmartActiveBenefitValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SmartActiveBenefitValue> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the smart active benefit values from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of smart active benefit values.
	 *
	 * @return the number of smart active benefit values
	 */
	public int countAll();

}