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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.user.model.UserRegistrationEducation;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the user registration education service. This utility wraps <code>com.mypage.user.service.persistence.impl.UserRegistrationEducationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationEducationPersistence
 * @generated
 */
public class UserRegistrationEducationUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		UserRegistrationEducation userRegistrationEducation) {

		getPersistence().clearCache(userRegistrationEducation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, UserRegistrationEducation>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserRegistrationEducation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserRegistrationEducation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserRegistrationEducation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserRegistrationEducation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserRegistrationEducation update(
		UserRegistrationEducation userRegistrationEducation) {

		return getPersistence().update(userRegistrationEducation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserRegistrationEducation update(
		UserRegistrationEducation userRegistrationEducation,
		ServiceContext serviceContext) {

		return getPersistence().update(
			userRegistrationEducation, serviceContext);
	}

	/**
	 * Returns all the user registration educations where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the matching user registration educations
	 */
	public static List<UserRegistrationEducation> findByUserRegistrationId(
		long userRegistrationId) {

		return getPersistence().findByUserRegistrationId(userRegistrationId);
	}

	/**
	 * Returns a range of all the user registration educations where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationEducationModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration educations
	 * @param end the upper bound of the range of user registration educations (not inclusive)
	 * @return the range of matching user registration educations
	 */
	public static List<UserRegistrationEducation> findByUserRegistrationId(
		long userRegistrationId, int start, int end) {

		return getPersistence().findByUserRegistrationId(
			userRegistrationId, start, end);
	}

	/**
	 * Returns an ordered range of all the user registration educations where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationEducationModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration educations
	 * @param end the upper bound of the range of user registration educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user registration educations
	 */
	public static List<UserRegistrationEducation> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		OrderByComparator<UserRegistrationEducation> orderByComparator) {

		return getPersistence().findByUserRegistrationId(
			userRegistrationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user registration educations where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationEducationModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration educations
	 * @param end the upper bound of the range of user registration educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user registration educations
	 */
	public static List<UserRegistrationEducation> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		OrderByComparator<UserRegistrationEducation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserRegistrationId(
			userRegistrationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user registration education in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration education
	 * @throws NoSuchUserRegistrationEducationException if a matching user registration education could not be found
	 */
	public static UserRegistrationEducation findByUserRegistrationId_First(
			long userRegistrationId,
			OrderByComparator<UserRegistrationEducation> orderByComparator)
		throws com.mypage.user.exception.
			NoSuchUserRegistrationEducationException {

		return getPersistence().findByUserRegistrationId_First(
			userRegistrationId, orderByComparator);
	}

	/**
	 * Returns the first user registration education in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration education, or <code>null</code> if a matching user registration education could not be found
	 */
	public static UserRegistrationEducation fetchByUserRegistrationId_First(
		long userRegistrationId,
		OrderByComparator<UserRegistrationEducation> orderByComparator) {

		return getPersistence().fetchByUserRegistrationId_First(
			userRegistrationId, orderByComparator);
	}

	/**
	 * Returns the last user registration education in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration education
	 * @throws NoSuchUserRegistrationEducationException if a matching user registration education could not be found
	 */
	public static UserRegistrationEducation findByUserRegistrationId_Last(
			long userRegistrationId,
			OrderByComparator<UserRegistrationEducation> orderByComparator)
		throws com.mypage.user.exception.
			NoSuchUserRegistrationEducationException {

		return getPersistence().findByUserRegistrationId_Last(
			userRegistrationId, orderByComparator);
	}

	/**
	 * Returns the last user registration education in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration education, or <code>null</code> if a matching user registration education could not be found
	 */
	public static UserRegistrationEducation fetchByUserRegistrationId_Last(
		long userRegistrationId,
		OrderByComparator<UserRegistrationEducation> orderByComparator) {

		return getPersistence().fetchByUserRegistrationId_Last(
			userRegistrationId, orderByComparator);
	}

	/**
	 * Returns the user registration educations before and after the current user registration education in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationEducationId the primary key of the current user registration education
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user registration education
	 * @throws NoSuchUserRegistrationEducationException if a user registration education with the primary key could not be found
	 */
	public static UserRegistrationEducation[]
			findByUserRegistrationId_PrevAndNext(
				long userRegistrationEducationId, long userRegistrationId,
				OrderByComparator<UserRegistrationEducation> orderByComparator)
		throws com.mypage.user.exception.
			NoSuchUserRegistrationEducationException {

		return getPersistence().findByUserRegistrationId_PrevAndNext(
			userRegistrationEducationId, userRegistrationId, orderByComparator);
	}

	/**
	 * Removes all the user registration educations where userRegistrationId = &#63; from the database.
	 *
	 * @param userRegistrationId the user registration ID
	 */
	public static void removeByUserRegistrationId(long userRegistrationId) {
		getPersistence().removeByUserRegistrationId(userRegistrationId);
	}

	/**
	 * Returns the number of user registration educations where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the number of matching user registration educations
	 */
	public static int countByUserRegistrationId(long userRegistrationId) {
		return getPersistence().countByUserRegistrationId(userRegistrationId);
	}

	/**
	 * Caches the user registration education in the entity cache if it is enabled.
	 *
	 * @param userRegistrationEducation the user registration education
	 */
	public static void cacheResult(
		UserRegistrationEducation userRegistrationEducation) {

		getPersistence().cacheResult(userRegistrationEducation);
	}

	/**
	 * Caches the user registration educations in the entity cache if it is enabled.
	 *
	 * @param userRegistrationEducations the user registration educations
	 */
	public static void cacheResult(
		List<UserRegistrationEducation> userRegistrationEducations) {

		getPersistence().cacheResult(userRegistrationEducations);
	}

	/**
	 * Creates a new user registration education with the primary key. Does not add the user registration education to the database.
	 *
	 * @param userRegistrationEducationId the primary key for the new user registration education
	 * @return the new user registration education
	 */
	public static UserRegistrationEducation create(
		long userRegistrationEducationId) {

		return getPersistence().create(userRegistrationEducationId);
	}

	/**
	 * Removes the user registration education with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRegistrationEducationId the primary key of the user registration education
	 * @return the user registration education that was removed
	 * @throws NoSuchUserRegistrationEducationException if a user registration education with the primary key could not be found
	 */
	public static UserRegistrationEducation remove(
			long userRegistrationEducationId)
		throws com.mypage.user.exception.
			NoSuchUserRegistrationEducationException {

		return getPersistence().remove(userRegistrationEducationId);
	}

	public static UserRegistrationEducation updateImpl(
		UserRegistrationEducation userRegistrationEducation) {

		return getPersistence().updateImpl(userRegistrationEducation);
	}

	/**
	 * Returns the user registration education with the primary key or throws a <code>NoSuchUserRegistrationEducationException</code> if it could not be found.
	 *
	 * @param userRegistrationEducationId the primary key of the user registration education
	 * @return the user registration education
	 * @throws NoSuchUserRegistrationEducationException if a user registration education with the primary key could not be found
	 */
	public static UserRegistrationEducation findByPrimaryKey(
			long userRegistrationEducationId)
		throws com.mypage.user.exception.
			NoSuchUserRegistrationEducationException {

		return getPersistence().findByPrimaryKey(userRegistrationEducationId);
	}

	/**
	 * Returns the user registration education with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRegistrationEducationId the primary key of the user registration education
	 * @return the user registration education, or <code>null</code> if a user registration education with the primary key could not be found
	 */
	public static UserRegistrationEducation fetchByPrimaryKey(
		long userRegistrationEducationId) {

		return getPersistence().fetchByPrimaryKey(userRegistrationEducationId);
	}

	/**
	 * Returns all the user registration educations.
	 *
	 * @return the user registration educations
	 */
	public static List<UserRegistrationEducation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user registration educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationEducationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration educations
	 * @param end the upper bound of the range of user registration educations (not inclusive)
	 * @return the range of user registration educations
	 */
	public static List<UserRegistrationEducation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user registration educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationEducationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration educations
	 * @param end the upper bound of the range of user registration educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user registration educations
	 */
	public static List<UserRegistrationEducation> findAll(
		int start, int end,
		OrderByComparator<UserRegistrationEducation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user registration educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationEducationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration educations
	 * @param end the upper bound of the range of user registration educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user registration educations
	 */
	public static List<UserRegistrationEducation> findAll(
		int start, int end,
		OrderByComparator<UserRegistrationEducation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user registration educations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user registration educations.
	 *
	 * @return the number of user registration educations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserRegistrationEducationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile UserRegistrationEducationPersistence _persistence;

}