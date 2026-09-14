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

package com.mypage.user.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.mypage.user.exception.NoSuchUserRegistrationEducationException;
import com.mypage.user.model.UserRegistrationEducation;
import com.mypage.user.model.impl.UserRegistrationEducationImpl;
import com.mypage.user.model.impl.UserRegistrationEducationModelImpl;
import com.mypage.user.service.persistence.UserRegistrationEducationPersistence;
import com.mypage.user.service.persistence.UserRegistrationEducationUtil;
import com.mypage.user.service.persistence.impl.constants.MPUPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the user registration education service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UserRegistrationEducationPersistence.class)
public class UserRegistrationEducationPersistenceImpl
	extends BasePersistenceImpl<UserRegistrationEducation>
	implements UserRegistrationEducationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserRegistrationEducationUtil</code> to access the user registration education persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserRegistrationEducationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUserRegistrationId;
	private FinderPath _finderPathWithoutPaginationFindByUserRegistrationId;
	private FinderPath _finderPathCountByUserRegistrationId;

	/**
	 * Returns all the user registration educations where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the matching user registration educations
	 */
	@Override
	public List<UserRegistrationEducation> findByUserRegistrationId(
		long userRegistrationId) {

		return findByUserRegistrationId(
			userRegistrationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserRegistrationEducation> findByUserRegistrationId(
		long userRegistrationId, int start, int end) {

		return findByUserRegistrationId(userRegistrationId, start, end, null);
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
	@Override
	public List<UserRegistrationEducation> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		OrderByComparator<UserRegistrationEducation> orderByComparator) {

		return findByUserRegistrationId(
			userRegistrationId, start, end, orderByComparator, true);
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
	@Override
	public List<UserRegistrationEducation> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		OrderByComparator<UserRegistrationEducation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByUserRegistrationId;
				finderArgs = new Object[] {userRegistrationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserRegistrationId;
			finderArgs = new Object[] {
				userRegistrationId, start, end, orderByComparator
			};
		}

		List<UserRegistrationEducation> list = null;

		if (useFinderCache) {
			list = (List<UserRegistrationEducation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserRegistrationEducation userRegistrationEducation :
						list) {

					if (userRegistrationId !=
							userRegistrationEducation.getUserRegistrationId()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_USERREGISTRATIONEDUCATION_WHERE);

			sb.append(_FINDER_COLUMN_USERREGISTRATIONID_USERREGISTRATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserRegistrationEducationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userRegistrationId);

				list = (List<UserRegistrationEducation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user registration education in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration education
	 * @throws NoSuchUserRegistrationEducationException if a matching user registration education could not be found
	 */
	@Override
	public UserRegistrationEducation findByUserRegistrationId_First(
			long userRegistrationId,
			OrderByComparator<UserRegistrationEducation> orderByComparator)
		throws NoSuchUserRegistrationEducationException {

		UserRegistrationEducation userRegistrationEducation =
			fetchByUserRegistrationId_First(
				userRegistrationId, orderByComparator);

		if (userRegistrationEducation != null) {
			return userRegistrationEducation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userRegistrationId=");
		sb.append(userRegistrationId);

		sb.append("}");

		throw new NoSuchUserRegistrationEducationException(sb.toString());
	}

	/**
	 * Returns the first user registration education in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration education, or <code>null</code> if a matching user registration education could not be found
	 */
	@Override
	public UserRegistrationEducation fetchByUserRegistrationId_First(
		long userRegistrationId,
		OrderByComparator<UserRegistrationEducation> orderByComparator) {

		List<UserRegistrationEducation> list = findByUserRegistrationId(
			userRegistrationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user registration education in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration education
	 * @throws NoSuchUserRegistrationEducationException if a matching user registration education could not be found
	 */
	@Override
	public UserRegistrationEducation findByUserRegistrationId_Last(
			long userRegistrationId,
			OrderByComparator<UserRegistrationEducation> orderByComparator)
		throws NoSuchUserRegistrationEducationException {

		UserRegistrationEducation userRegistrationEducation =
			fetchByUserRegistrationId_Last(
				userRegistrationId, orderByComparator);

		if (userRegistrationEducation != null) {
			return userRegistrationEducation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userRegistrationId=");
		sb.append(userRegistrationId);

		sb.append("}");

		throw new NoSuchUserRegistrationEducationException(sb.toString());
	}

	/**
	 * Returns the last user registration education in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration education, or <code>null</code> if a matching user registration education could not be found
	 */
	@Override
	public UserRegistrationEducation fetchByUserRegistrationId_Last(
		long userRegistrationId,
		OrderByComparator<UserRegistrationEducation> orderByComparator) {

		int count = countByUserRegistrationId(userRegistrationId);

		if (count == 0) {
			return null;
		}

		List<UserRegistrationEducation> list = findByUserRegistrationId(
			userRegistrationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserRegistrationEducation[] findByUserRegistrationId_PrevAndNext(
			long userRegistrationEducationId, long userRegistrationId,
			OrderByComparator<UserRegistrationEducation> orderByComparator)
		throws NoSuchUserRegistrationEducationException {

		UserRegistrationEducation userRegistrationEducation = findByPrimaryKey(
			userRegistrationEducationId);

		Session session = null;

		try {
			session = openSession();

			UserRegistrationEducation[] array =
				new UserRegistrationEducationImpl[3];

			array[0] = getByUserRegistrationId_PrevAndNext(
				session, userRegistrationEducation, userRegistrationId,
				orderByComparator, true);

			array[1] = userRegistrationEducation;

			array[2] = getByUserRegistrationId_PrevAndNext(
				session, userRegistrationEducation, userRegistrationId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserRegistrationEducation getByUserRegistrationId_PrevAndNext(
		Session session, UserRegistrationEducation userRegistrationEducation,
		long userRegistrationId,
		OrderByComparator<UserRegistrationEducation> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_USERREGISTRATIONEDUCATION_WHERE);

		sb.append(_FINDER_COLUMN_USERREGISTRATIONID_USERREGISTRATIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(UserRegistrationEducationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userRegistrationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						userRegistrationEducation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserRegistrationEducation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user registration educations where userRegistrationId = &#63; from the database.
	 *
	 * @param userRegistrationId the user registration ID
	 */
	@Override
	public void removeByUserRegistrationId(long userRegistrationId) {
		for (UserRegistrationEducation userRegistrationEducation :
				findByUserRegistrationId(
					userRegistrationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userRegistrationEducation);
		}
	}

	/**
	 * Returns the number of user registration educations where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the number of matching user registration educations
	 */
	@Override
	public int countByUserRegistrationId(long userRegistrationId) {
		FinderPath finderPath = _finderPathCountByUserRegistrationId;

		Object[] finderArgs = new Object[] {userRegistrationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERREGISTRATIONEDUCATION_WHERE);

			sb.append(_FINDER_COLUMN_USERREGISTRATIONID_USERREGISTRATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userRegistrationId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_USERREGISTRATIONID_USERREGISTRATIONID_2 =
			"userRegistrationEducation.userRegistrationId = ?";

	public UserRegistrationEducationPersistenceImpl() {
		setModelClass(UserRegistrationEducation.class);

		setModelImplClass(UserRegistrationEducationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the user registration education in the entity cache if it is enabled.
	 *
	 * @param userRegistrationEducation the user registration education
	 */
	@Override
	public void cacheResult(
		UserRegistrationEducation userRegistrationEducation) {

		entityCache.putResult(
			UserRegistrationEducationImpl.class,
			userRegistrationEducation.getPrimaryKey(),
			userRegistrationEducation);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the user registration educations in the entity cache if it is enabled.
	 *
	 * @param userRegistrationEducations the user registration educations
	 */
	@Override
	public void cacheResult(
		List<UserRegistrationEducation> userRegistrationEducations) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (userRegistrationEducations.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UserRegistrationEducation userRegistrationEducation :
				userRegistrationEducations) {

			if (entityCache.getResult(
					UserRegistrationEducationImpl.class,
					userRegistrationEducation.getPrimaryKey()) == null) {

				cacheResult(userRegistrationEducation);
			}
		}
	}

	/**
	 * Clears the cache for all user registration educations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserRegistrationEducationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user registration education.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		UserRegistrationEducation userRegistrationEducation) {

		entityCache.removeResult(
			UserRegistrationEducationImpl.class, userRegistrationEducation);
	}

	@Override
	public void clearCache(
		List<UserRegistrationEducation> userRegistrationEducations) {

		for (UserRegistrationEducation userRegistrationEducation :
				userRegistrationEducations) {

			entityCache.removeResult(
				UserRegistrationEducationImpl.class, userRegistrationEducation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				UserRegistrationEducationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new user registration education with the primary key. Does not add the user registration education to the database.
	 *
	 * @param userRegistrationEducationId the primary key for the new user registration education
	 * @return the new user registration education
	 */
	@Override
	public UserRegistrationEducation create(long userRegistrationEducationId) {
		UserRegistrationEducation userRegistrationEducation =
			new UserRegistrationEducationImpl();

		userRegistrationEducation.setNew(true);
		userRegistrationEducation.setPrimaryKey(userRegistrationEducationId);

		userRegistrationEducation.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return userRegistrationEducation;
	}

	/**
	 * Removes the user registration education with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRegistrationEducationId the primary key of the user registration education
	 * @return the user registration education that was removed
	 * @throws NoSuchUserRegistrationEducationException if a user registration education with the primary key could not be found
	 */
	@Override
	public UserRegistrationEducation remove(long userRegistrationEducationId)
		throws NoSuchUserRegistrationEducationException {

		return remove((Serializable)userRegistrationEducationId);
	}

	/**
	 * Removes the user registration education with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user registration education
	 * @return the user registration education that was removed
	 * @throws NoSuchUserRegistrationEducationException if a user registration education with the primary key could not be found
	 */
	@Override
	public UserRegistrationEducation remove(Serializable primaryKey)
		throws NoSuchUserRegistrationEducationException {

		Session session = null;

		try {
			session = openSession();

			UserRegistrationEducation userRegistrationEducation =
				(UserRegistrationEducation)session.get(
					UserRegistrationEducationImpl.class, primaryKey);

			if (userRegistrationEducation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserRegistrationEducationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userRegistrationEducation);
		}
		catch (NoSuchUserRegistrationEducationException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected UserRegistrationEducation removeImpl(
		UserRegistrationEducation userRegistrationEducation) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userRegistrationEducation)) {
				userRegistrationEducation =
					(UserRegistrationEducation)session.get(
						UserRegistrationEducationImpl.class,
						userRegistrationEducation.getPrimaryKeyObj());
			}

			if (userRegistrationEducation != null) {
				session.delete(userRegistrationEducation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userRegistrationEducation != null) {
			clearCache(userRegistrationEducation);
		}

		return userRegistrationEducation;
	}

	@Override
	public UserRegistrationEducation updateImpl(
		UserRegistrationEducation userRegistrationEducation) {

		boolean isNew = userRegistrationEducation.isNew();

		if (!(userRegistrationEducation instanceof
				UserRegistrationEducationModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userRegistrationEducation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					userRegistrationEducation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userRegistrationEducation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserRegistrationEducation implementation " +
					userRegistrationEducation.getClass());
		}

		UserRegistrationEducationModelImpl userRegistrationEducationModelImpl =
			(UserRegistrationEducationModelImpl)userRegistrationEducation;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (userRegistrationEducation.getCreateDate() == null)) {
			if (serviceContext == null) {
				userRegistrationEducation.setCreateDate(date);
			}
			else {
				userRegistrationEducation.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!userRegistrationEducationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userRegistrationEducation.setModifiedDate(date);
			}
			else {
				userRegistrationEducation.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userRegistrationEducation);
			}
			else {
				userRegistrationEducation =
					(UserRegistrationEducation)session.merge(
						userRegistrationEducation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UserRegistrationEducationImpl.class,
			userRegistrationEducationModelImpl, false, true);

		if (isNew) {
			userRegistrationEducation.setNew(false);
		}

		userRegistrationEducation.resetOriginalValues();

		return userRegistrationEducation;
	}

	/**
	 * Returns the user registration education with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user registration education
	 * @return the user registration education
	 * @throws NoSuchUserRegistrationEducationException if a user registration education with the primary key could not be found
	 */
	@Override
	public UserRegistrationEducation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserRegistrationEducationException {

		UserRegistrationEducation userRegistrationEducation = fetchByPrimaryKey(
			primaryKey);

		if (userRegistrationEducation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserRegistrationEducationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userRegistrationEducation;
	}

	/**
	 * Returns the user registration education with the primary key or throws a <code>NoSuchUserRegistrationEducationException</code> if it could not be found.
	 *
	 * @param userRegistrationEducationId the primary key of the user registration education
	 * @return the user registration education
	 * @throws NoSuchUserRegistrationEducationException if a user registration education with the primary key could not be found
	 */
	@Override
	public UserRegistrationEducation findByPrimaryKey(
			long userRegistrationEducationId)
		throws NoSuchUserRegistrationEducationException {

		return findByPrimaryKey((Serializable)userRegistrationEducationId);
	}

	/**
	 * Returns the user registration education with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRegistrationEducationId the primary key of the user registration education
	 * @return the user registration education, or <code>null</code> if a user registration education with the primary key could not be found
	 */
	@Override
	public UserRegistrationEducation fetchByPrimaryKey(
		long userRegistrationEducationId) {

		return fetchByPrimaryKey((Serializable)userRegistrationEducationId);
	}

	/**
	 * Returns all the user registration educations.
	 *
	 * @return the user registration educations
	 */
	@Override
	public List<UserRegistrationEducation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserRegistrationEducation> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<UserRegistrationEducation> findAll(
		int start, int end,
		OrderByComparator<UserRegistrationEducation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<UserRegistrationEducation> findAll(
		int start, int end,
		OrderByComparator<UserRegistrationEducation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<UserRegistrationEducation> list = null;

		if (useFinderCache) {
			list = (List<UserRegistrationEducation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERREGISTRATIONEDUCATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERREGISTRATIONEDUCATION;

				sql = sql.concat(
					UserRegistrationEducationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserRegistrationEducation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user registration educations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserRegistrationEducation userRegistrationEducation : findAll()) {
			remove(userRegistrationEducation);
		}
	}

	/**
	 * Returns the number of user registration educations.
	 *
	 * @return the number of user registration educations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_USERREGISTRATIONEDUCATION);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "userRegistrationEducationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERREGISTRATIONEDUCATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserRegistrationEducationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user registration education persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new UserRegistrationEducationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", UserRegistrationEducation.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUserRegistrationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserRegistrationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userRegistrationId"}, true);

		_finderPathWithoutPaginationFindByUserRegistrationId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByUserRegistrationId", new String[] {Long.class.getName()},
				new String[] {"userRegistrationId"}, true);

		_finderPathCountByUserRegistrationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserRegistrationId", new String[] {Long.class.getName()},
			new String[] {"userRegistrationId"}, false);

		_setUserRegistrationEducationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setUserRegistrationEducationUtilPersistence(null);

		entityCache.removeCache(UserRegistrationEducationImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setUserRegistrationEducationUtilPersistence(
		UserRegistrationEducationPersistence
			userRegistrationEducationPersistence) {

		try {
			Field field = UserRegistrationEducationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, userRegistrationEducationPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MPUPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MPUPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MPUPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_USERREGISTRATIONEDUCATION =
		"SELECT userRegistrationEducation FROM UserRegistrationEducation userRegistrationEducation";

	private static final String _SQL_SELECT_USERREGISTRATIONEDUCATION_WHERE =
		"SELECT userRegistrationEducation FROM UserRegistrationEducation userRegistrationEducation WHERE ";

	private static final String _SQL_COUNT_USERREGISTRATIONEDUCATION =
		"SELECT COUNT(userRegistrationEducation) FROM UserRegistrationEducation userRegistrationEducation";

	private static final String _SQL_COUNT_USERREGISTRATIONEDUCATION_WHERE =
		"SELECT COUNT(userRegistrationEducation) FROM UserRegistrationEducation userRegistrationEducation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"userRegistrationEducation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserRegistrationEducation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserRegistrationEducation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserRegistrationEducationPersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class UserRegistrationEducationModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			UserRegistrationEducationModelImpl
				userRegistrationEducationModelImpl =
					(UserRegistrationEducationModelImpl)baseModel;

			long columnBitmask =
				userRegistrationEducationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					userRegistrationEducationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						userRegistrationEducationModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					userRegistrationEducationModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			UserRegistrationEducationModelImpl
				userRegistrationEducationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						userRegistrationEducationModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						userRegistrationEducationModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}