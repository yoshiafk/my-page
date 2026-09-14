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

import com.mypage.admin.product.exception.NoSuchMasterGlobalVariableException;
import com.mypage.admin.product.model.MasterGlobalVariable;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the master global variable service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterGlobalVariableUtil
 * @generated
 */
@ProviderType
public interface MasterGlobalVariablePersistence
	extends BasePersistence<MasterGlobalVariable> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MasterGlobalVariableUtil} to access the master global variable persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the master global variable in the entity cache if it is enabled.
	 *
	 * @param masterGlobalVariable the master global variable
	 */
	public void cacheResult(MasterGlobalVariable masterGlobalVariable);

	/**
	 * Caches the master global variables in the entity cache if it is enabled.
	 *
	 * @param masterGlobalVariables the master global variables
	 */
	public void cacheResult(
		java.util.List<MasterGlobalVariable> masterGlobalVariables);

	/**
	 * Creates a new master global variable with the primary key. Does not add the master global variable to the database.
	 *
	 * @param masterGlobalVariableId the primary key for the new master global variable
	 * @return the new master global variable
	 */
	public MasterGlobalVariable create(long masterGlobalVariableId);

	/**
	 * Removes the master global variable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterGlobalVariableId the primary key of the master global variable
	 * @return the master global variable that was removed
	 * @throws NoSuchMasterGlobalVariableException if a master global variable with the primary key could not be found
	 */
	public MasterGlobalVariable remove(long masterGlobalVariableId)
		throws NoSuchMasterGlobalVariableException;

	public MasterGlobalVariable updateImpl(
		MasterGlobalVariable masterGlobalVariable);

	/**
	 * Returns the master global variable with the primary key or throws a <code>NoSuchMasterGlobalVariableException</code> if it could not be found.
	 *
	 * @param masterGlobalVariableId the primary key of the master global variable
	 * @return the master global variable
	 * @throws NoSuchMasterGlobalVariableException if a master global variable with the primary key could not be found
	 */
	public MasterGlobalVariable findByPrimaryKey(long masterGlobalVariableId)
		throws NoSuchMasterGlobalVariableException;

	/**
	 * Returns the master global variable with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterGlobalVariableId the primary key of the master global variable
	 * @return the master global variable, or <code>null</code> if a master global variable with the primary key could not be found
	 */
	public MasterGlobalVariable fetchByPrimaryKey(long masterGlobalVariableId);

	/**
	 * Returns all the master global variables.
	 *
	 * @return the master global variables
	 */
	public java.util.List<MasterGlobalVariable> findAll();

	/**
	 * Returns a range of all the master global variables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterGlobalVariableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master global variables
	 * @param end the upper bound of the range of master global variables (not inclusive)
	 * @return the range of master global variables
	 */
	public java.util.List<MasterGlobalVariable> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the master global variables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterGlobalVariableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master global variables
	 * @param end the upper bound of the range of master global variables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master global variables
	 */
	public java.util.List<MasterGlobalVariable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterGlobalVariable>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master global variables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterGlobalVariableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master global variables
	 * @param end the upper bound of the range of master global variables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master global variables
	 */
	public java.util.List<MasterGlobalVariable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterGlobalVariable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the master global variables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of master global variables.
	 *
	 * @return the number of master global variables
	 */
	public int countAll();

}