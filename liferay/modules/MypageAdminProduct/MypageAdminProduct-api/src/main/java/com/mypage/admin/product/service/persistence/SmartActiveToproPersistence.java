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

import com.mypage.admin.product.exception.NoSuchSmartActiveToproException;
import com.mypage.admin.product.model.SmartActiveTopro;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the smart active topro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveToproUtil
 * @generated
 */
@ProviderType
public interface SmartActiveToproPersistence
	extends BasePersistence<SmartActiveTopro> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SmartActiveToproUtil} to access the smart active topro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the smart active topro where topro = &#63; or throws a <code>NoSuchSmartActiveToproException</code> if it could not be found.
	 *
	 * @param topro the topro
	 * @return the matching smart active topro
	 * @throws NoSuchSmartActiveToproException if a matching smart active topro could not be found
	 */
	public SmartActiveTopro findBytopro(String topro)
		throws NoSuchSmartActiveToproException;

	/**
	 * Returns the smart active topro where topro = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param topro the topro
	 * @return the matching smart active topro, or <code>null</code> if a matching smart active topro could not be found
	 */
	public SmartActiveTopro fetchBytopro(String topro);

	/**
	 * Returns the smart active topro where topro = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param topro the topro
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active topro, or <code>null</code> if a matching smart active topro could not be found
	 */
	public SmartActiveTopro fetchBytopro(String topro, boolean useFinderCache);

	/**
	 * Removes the smart active topro where topro = &#63; from the database.
	 *
	 * @param topro the topro
	 * @return the smart active topro that was removed
	 */
	public SmartActiveTopro removeBytopro(String topro)
		throws NoSuchSmartActiveToproException;

	/**
	 * Returns the number of smart active topros where topro = &#63;.
	 *
	 * @param topro the topro
	 * @return the number of matching smart active topros
	 */
	public int countBytopro(String topro);

	/**
	 * Returns the smart active topro where smartActiveBenefitValueId = &#63; or throws a <code>NoSuchSmartActiveToproException</code> if it could not be found.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the matching smart active topro
	 * @throws NoSuchSmartActiveToproException if a matching smart active topro could not be found
	 */
	public SmartActiveTopro findByBenefitValueId(long smartActiveBenefitValueId)
		throws NoSuchSmartActiveToproException;

	/**
	 * Returns the smart active topro where smartActiveBenefitValueId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the matching smart active topro, or <code>null</code> if a matching smart active topro could not be found
	 */
	public SmartActiveTopro fetchByBenefitValueId(
		long smartActiveBenefitValueId);

	/**
	 * Returns the smart active topro where smartActiveBenefitValueId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active topro, or <code>null</code> if a matching smart active topro could not be found
	 */
	public SmartActiveTopro fetchByBenefitValueId(
		long smartActiveBenefitValueId, boolean useFinderCache);

	/**
	 * Removes the smart active topro where smartActiveBenefitValueId = &#63; from the database.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the smart active topro that was removed
	 */
	public SmartActiveTopro removeByBenefitValueId(
			long smartActiveBenefitValueId)
		throws NoSuchSmartActiveToproException;

	/**
	 * Returns the number of smart active topros where smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the number of matching smart active topros
	 */
	public int countByBenefitValueId(long smartActiveBenefitValueId);

	/**
	 * Caches the smart active topro in the entity cache if it is enabled.
	 *
	 * @param smartActiveTopro the smart active topro
	 */
	public void cacheResult(SmartActiveTopro smartActiveTopro);

	/**
	 * Caches the smart active topros in the entity cache if it is enabled.
	 *
	 * @param smartActiveTopros the smart active topros
	 */
	public void cacheResult(java.util.List<SmartActiveTopro> smartActiveTopros);

	/**
	 * Creates a new smart active topro with the primary key. Does not add the smart active topro to the database.
	 *
	 * @param smartActiveToproId the primary key for the new smart active topro
	 * @return the new smart active topro
	 */
	public SmartActiveTopro create(long smartActiveToproId);

	/**
	 * Removes the smart active topro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveToproId the primary key of the smart active topro
	 * @return the smart active topro that was removed
	 * @throws NoSuchSmartActiveToproException if a smart active topro with the primary key could not be found
	 */
	public SmartActiveTopro remove(long smartActiveToproId)
		throws NoSuchSmartActiveToproException;

	public SmartActiveTopro updateImpl(SmartActiveTopro smartActiveTopro);

	/**
	 * Returns the smart active topro with the primary key or throws a <code>NoSuchSmartActiveToproException</code> if it could not be found.
	 *
	 * @param smartActiveToproId the primary key of the smart active topro
	 * @return the smart active topro
	 * @throws NoSuchSmartActiveToproException if a smart active topro with the primary key could not be found
	 */
	public SmartActiveTopro findByPrimaryKey(long smartActiveToproId)
		throws NoSuchSmartActiveToproException;

	/**
	 * Returns the smart active topro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveToproId the primary key of the smart active topro
	 * @return the smart active topro, or <code>null</code> if a smart active topro with the primary key could not be found
	 */
	public SmartActiveTopro fetchByPrimaryKey(long smartActiveToproId);

	/**
	 * Returns all the smart active topros.
	 *
	 * @return the smart active topros
	 */
	public java.util.List<SmartActiveTopro> findAll();

	/**
	 * Returns a range of all the smart active topros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active topros
	 * @param end the upper bound of the range of smart active topros (not inclusive)
	 * @return the range of smart active topros
	 */
	public java.util.List<SmartActiveTopro> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the smart active topros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active topros
	 * @param end the upper bound of the range of smart active topros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active topros
	 */
	public java.util.List<SmartActiveTopro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActiveTopro>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smart active topros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active topros
	 * @param end the upper bound of the range of smart active topros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active topros
	 */
	public java.util.List<SmartActiveTopro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActiveTopro>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the smart active topros from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of smart active topros.
	 *
	 * @return the number of smart active topros
	 */
	public int countAll();

}