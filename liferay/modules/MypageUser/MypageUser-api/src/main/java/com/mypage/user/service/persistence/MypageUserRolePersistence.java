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

package com.mypage.user.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.user.exception.NoSuchMypageUserRoleException;
import com.mypage.user.model.MypageUserRole;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the mypage user role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserRoleUtil
 * @generated
 */
@ProviderType
public interface MypageUserRolePersistence
	extends BasePersistence<MypageUserRole> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MypageUserRoleUtil} to access the mypage user role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the mypage user role in the entity cache if it is enabled.
	 *
	 * @param mypageUserRole the mypage user role
	 */
	public void cacheResult(MypageUserRole mypageUserRole);

	/**
	 * Caches the mypage user roles in the entity cache if it is enabled.
	 *
	 * @param mypageUserRoles the mypage user roles
	 */
	public void cacheResult(java.util.List<MypageUserRole> mypageUserRoles);

	/**
	 * Creates a new mypage user role with the primary key. Does not add the mypage user role to the database.
	 *
	 * @param mypageUserRoleId the primary key for the new mypage user role
	 * @return the new mypage user role
	 */
	public MypageUserRole create(long mypageUserRoleId);

	/**
	 * Removes the mypage user role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserRoleId the primary key of the mypage user role
	 * @return the mypage user role that was removed
	 * @throws NoSuchMypageUserRoleException if a mypage user role with the primary key could not be found
	 */
	public MypageUserRole remove(long mypageUserRoleId)
		throws NoSuchMypageUserRoleException;

	public MypageUserRole updateImpl(MypageUserRole mypageUserRole);

	/**
	 * Returns the mypage user role with the primary key or throws a <code>NoSuchMypageUserRoleException</code> if it could not be found.
	 *
	 * @param mypageUserRoleId the primary key of the mypage user role
	 * @return the mypage user role
	 * @throws NoSuchMypageUserRoleException if a mypage user role with the primary key could not be found
	 */
	public MypageUserRole findByPrimaryKey(long mypageUserRoleId)
		throws NoSuchMypageUserRoleException;

	/**
	 * Returns the mypage user role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserRoleId the primary key of the mypage user role
	 * @return the mypage user role, or <code>null</code> if a mypage user role with the primary key could not be found
	 */
	public MypageUserRole fetchByPrimaryKey(long mypageUserRoleId);

	/**
	 * Returns all the mypage user roles.
	 *
	 * @return the mypage user roles
	 */
	public java.util.List<MypageUserRole> findAll();

	/**
	 * Returns a range of all the mypage user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user roles
	 * @param end the upper bound of the range of mypage user roles (not inclusive)
	 * @return the range of mypage user roles
	 */
	public java.util.List<MypageUserRole> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the mypage user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user roles
	 * @param end the upper bound of the range of mypage user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage user roles
	 */
	public java.util.List<MypageUserRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserRole>
			orderByComparator);

	/**
	 * Returns an ordered range of all the mypage user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user roles
	 * @param end the upper bound of the range of mypage user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage user roles
	 */
	public java.util.List<MypageUserRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MypageUserRole>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the mypage user roles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of mypage user roles.
	 *
	 * @return the number of mypage user roles
	 */
	public int countAll();

}