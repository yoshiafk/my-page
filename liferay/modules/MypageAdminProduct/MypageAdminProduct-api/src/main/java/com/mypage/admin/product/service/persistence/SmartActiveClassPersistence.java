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

import com.mypage.admin.product.exception.NoSuchSmartActiveClassException;
import com.mypage.admin.product.model.SmartActiveClass;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the smart active class service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveClassUtil
 * @generated
 */
@ProviderType
public interface SmartActiveClassPersistence
	extends BasePersistence<SmartActiveClass> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SmartActiveClassUtil} to access the smart active class persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the smart active class in the entity cache if it is enabled.
	 *
	 * @param smartActiveClass the smart active class
	 */
	public void cacheResult(SmartActiveClass smartActiveClass);

	/**
	 * Caches the smart active classes in the entity cache if it is enabled.
	 *
	 * @param smartActiveClasses the smart active classes
	 */
	public void cacheResult(
		java.util.List<SmartActiveClass> smartActiveClasses);

	/**
	 * Creates a new smart active class with the primary key. Does not add the smart active class to the database.
	 *
	 * @param smartActiveClassId the primary key for the new smart active class
	 * @return the new smart active class
	 */
	public SmartActiveClass create(long smartActiveClassId);

	/**
	 * Removes the smart active class with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveClassId the primary key of the smart active class
	 * @return the smart active class that was removed
	 * @throws NoSuchSmartActiveClassException if a smart active class with the primary key could not be found
	 */
	public SmartActiveClass remove(long smartActiveClassId)
		throws NoSuchSmartActiveClassException;

	public SmartActiveClass updateImpl(SmartActiveClass smartActiveClass);

	/**
	 * Returns the smart active class with the primary key or throws a <code>NoSuchSmartActiveClassException</code> if it could not be found.
	 *
	 * @param smartActiveClassId the primary key of the smart active class
	 * @return the smart active class
	 * @throws NoSuchSmartActiveClassException if a smart active class with the primary key could not be found
	 */
	public SmartActiveClass findByPrimaryKey(long smartActiveClassId)
		throws NoSuchSmartActiveClassException;

	/**
	 * Returns the smart active class with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveClassId the primary key of the smart active class
	 * @return the smart active class, or <code>null</code> if a smart active class with the primary key could not be found
	 */
	public SmartActiveClass fetchByPrimaryKey(long smartActiveClassId);

	/**
	 * Returns all the smart active classes.
	 *
	 * @return the smart active classes
	 */
	public java.util.List<SmartActiveClass> findAll();

	/**
	 * Returns a range of all the smart active classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active classes
	 * @param end the upper bound of the range of smart active classes (not inclusive)
	 * @return the range of smart active classes
	 */
	public java.util.List<SmartActiveClass> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the smart active classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active classes
	 * @param end the upper bound of the range of smart active classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active classes
	 */
	public java.util.List<SmartActiveClass> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActiveClass>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smart active classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active classes
	 * @param end the upper bound of the range of smart active classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active classes
	 */
	public java.util.List<SmartActiveClass> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActiveClass>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the smart active classes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of smart active classes.
	 *
	 * @return the number of smart active classes
	 */
	public int countAll();

}