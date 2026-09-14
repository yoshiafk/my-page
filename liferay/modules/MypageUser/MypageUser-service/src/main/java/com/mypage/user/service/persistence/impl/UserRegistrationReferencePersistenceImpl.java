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

import com.mypage.user.exception.NoSuchUserRegistrationReferenceException;
import com.mypage.user.model.UserRegistrationReference;
import com.mypage.user.model.impl.UserRegistrationReferenceImpl;
import com.mypage.user.model.impl.UserRegistrationReferenceModelImpl;
import com.mypage.user.service.persistence.UserRegistrationReferencePersistence;
import com.mypage.user.service.persistence.UserRegistrationReferenceUtil;
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
 * The persistence implementation for the user registration reference service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UserRegistrationReferencePersistence.class)
public class UserRegistrationReferencePersistenceImpl
	extends BasePersistenceImpl<UserRegistrationReference>
	implements UserRegistrationReferencePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserRegistrationReferenceUtil</code> to access the user registration reference persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserRegistrationReferenceImpl.class.getName();

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
	 * Returns all the user registration references where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the matching user registration references
	 */
	@Override
	public List<UserRegistrationReference> findByUserRegistrationId(
		long userRegistrationId) {

		return findByUserRegistrationId(
			userRegistrationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user registration references where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationReferenceModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration references
	 * @param end the upper bound of the range of user registration references (not inclusive)
	 * @return the range of matching user registration references
	 */
	@Override
	public List<UserRegistrationReference> findByUserRegistrationId(
		long userRegistrationId, int start, int end) {

		return findByUserRegistrationId(userRegistrationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user registration references where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationReferenceModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration references
	 * @param end the upper bound of the range of user registration references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user registration references
	 */
	@Override
	public List<UserRegistrationReference> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		OrderByComparator<UserRegistrationReference> orderByComparator) {

		return findByUserRegistrationId(
			userRegistrationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user registration references where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationReferenceModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration references
	 * @param end the upper bound of the range of user registration references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user registration references
	 */
	@Override
	public List<UserRegistrationReference> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		OrderByComparator<UserRegistrationReference> orderByComparator,
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

		List<UserRegistrationReference> list = null;

		if (useFinderCache) {
			list = (List<UserRegistrationReference>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserRegistrationReference userRegistrationReference :
						list) {

					if (userRegistrationId !=
							userRegistrationReference.getUserRegistrationId()) {

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

			sb.append(_SQL_SELECT_USERREGISTRATIONREFERENCE_WHERE);

			sb.append(_FINDER_COLUMN_USERREGISTRATIONID_USERREGISTRATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserRegistrationReferenceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userRegistrationId);

				list = (List<UserRegistrationReference>)QueryUtil.list(
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
	 * Returns the first user registration reference in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration reference
	 * @throws NoSuchUserRegistrationReferenceException if a matching user registration reference could not be found
	 */
	@Override
	public UserRegistrationReference findByUserRegistrationId_First(
			long userRegistrationId,
			OrderByComparator<UserRegistrationReference> orderByComparator)
		throws NoSuchUserRegistrationReferenceException {

		UserRegistrationReference userRegistrationReference =
			fetchByUserRegistrationId_First(
				userRegistrationId, orderByComparator);

		if (userRegistrationReference != null) {
			return userRegistrationReference;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userRegistrationId=");
		sb.append(userRegistrationId);

		sb.append("}");

		throw new NoSuchUserRegistrationReferenceException(sb.toString());
	}

	/**
	 * Returns the first user registration reference in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration reference, or <code>null</code> if a matching user registration reference could not be found
	 */
	@Override
	public UserRegistrationReference fetchByUserRegistrationId_First(
		long userRegistrationId,
		OrderByComparator<UserRegistrationReference> orderByComparator) {

		List<UserRegistrationReference> list = findByUserRegistrationId(
			userRegistrationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user registration reference in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration reference
	 * @throws NoSuchUserRegistrationReferenceException if a matching user registration reference could not be found
	 */
	@Override
	public UserRegistrationReference findByUserRegistrationId_Last(
			long userRegistrationId,
			OrderByComparator<UserRegistrationReference> orderByComparator)
		throws NoSuchUserRegistrationReferenceException {

		UserRegistrationReference userRegistrationReference =
			fetchByUserRegistrationId_Last(
				userRegistrationId, orderByComparator);

		if (userRegistrationReference != null) {
			return userRegistrationReference;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userRegistrationId=");
		sb.append(userRegistrationId);

		sb.append("}");

		throw new NoSuchUserRegistrationReferenceException(sb.toString());
	}

	/**
	 * Returns the last user registration reference in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration reference, or <code>null</code> if a matching user registration reference could not be found
	 */
	@Override
	public UserRegistrationReference fetchByUserRegistrationId_Last(
		long userRegistrationId,
		OrderByComparator<UserRegistrationReference> orderByComparator) {

		int count = countByUserRegistrationId(userRegistrationId);

		if (count == 0) {
			return null;
		}

		List<UserRegistrationReference> list = findByUserRegistrationId(
			userRegistrationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user registration references before and after the current user registration reference in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationReferenceId the primary key of the current user registration reference
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user registration reference
	 * @throws NoSuchUserRegistrationReferenceException if a user registration reference with the primary key could not be found
	 */
	@Override
	public UserRegistrationReference[] findByUserRegistrationId_PrevAndNext(
			long userRegistrationReferenceId, long userRegistrationId,
			OrderByComparator<UserRegistrationReference> orderByComparator)
		throws NoSuchUserRegistrationReferenceException {

		UserRegistrationReference userRegistrationReference = findByPrimaryKey(
			userRegistrationReferenceId);

		Session session = null;

		try {
			session = openSession();

			UserRegistrationReference[] array =
				new UserRegistrationReferenceImpl[3];

			array[0] = getByUserRegistrationId_PrevAndNext(
				session, userRegistrationReference, userRegistrationId,
				orderByComparator, true);

			array[1] = userRegistrationReference;

			array[2] = getByUserRegistrationId_PrevAndNext(
				session, userRegistrationReference, userRegistrationId,
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

	protected UserRegistrationReference getByUserRegistrationId_PrevAndNext(
		Session session, UserRegistrationReference userRegistrationReference,
		long userRegistrationId,
		OrderByComparator<UserRegistrationReference> orderByComparator,
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

		sb.append(_SQL_SELECT_USERREGISTRATIONREFERENCE_WHERE);

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
			sb.append(UserRegistrationReferenceModelImpl.ORDER_BY_JPQL);
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
						userRegistrationReference)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserRegistrationReference> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user registration references where userRegistrationId = &#63; from the database.
	 *
	 * @param userRegistrationId the user registration ID
	 */
	@Override
	public void removeByUserRegistrationId(long userRegistrationId) {
		for (UserRegistrationReference userRegistrationReference :
				findByUserRegistrationId(
					userRegistrationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userRegistrationReference);
		}
	}

	/**
	 * Returns the number of user registration references where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the number of matching user registration references
	 */
	@Override
	public int countByUserRegistrationId(long userRegistrationId) {
		FinderPath finderPath = _finderPathCountByUserRegistrationId;

		Object[] finderArgs = new Object[] {userRegistrationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERREGISTRATIONREFERENCE_WHERE);

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
			"userRegistrationReference.userRegistrationId = ?";

	public UserRegistrationReferencePersistenceImpl() {
		setModelClass(UserRegistrationReference.class);

		setModelImplClass(UserRegistrationReferenceImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the user registration reference in the entity cache if it is enabled.
	 *
	 * @param userRegistrationReference the user registration reference
	 */
	@Override
	public void cacheResult(
		UserRegistrationReference userRegistrationReference) {

		entityCache.putResult(
			UserRegistrationReferenceImpl.class,
			userRegistrationReference.getPrimaryKey(),
			userRegistrationReference);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the user registration references in the entity cache if it is enabled.
	 *
	 * @param userRegistrationReferences the user registration references
	 */
	@Override
	public void cacheResult(
		List<UserRegistrationReference> userRegistrationReferences) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (userRegistrationReferences.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UserRegistrationReference userRegistrationReference :
				userRegistrationReferences) {

			if (entityCache.getResult(
					UserRegistrationReferenceImpl.class,
					userRegistrationReference.getPrimaryKey()) == null) {

				cacheResult(userRegistrationReference);
			}
		}
	}

	/**
	 * Clears the cache for all user registration references.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserRegistrationReferenceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user registration reference.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		UserRegistrationReference userRegistrationReference) {

		entityCache.removeResult(
			UserRegistrationReferenceImpl.class, userRegistrationReference);
	}

	@Override
	public void clearCache(
		List<UserRegistrationReference> userRegistrationReferences) {

		for (UserRegistrationReference userRegistrationReference :
				userRegistrationReferences) {

			entityCache.removeResult(
				UserRegistrationReferenceImpl.class, userRegistrationReference);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				UserRegistrationReferenceImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new user registration reference with the primary key. Does not add the user registration reference to the database.
	 *
	 * @param userRegistrationReferenceId the primary key for the new user registration reference
	 * @return the new user registration reference
	 */
	@Override
	public UserRegistrationReference create(long userRegistrationReferenceId) {
		UserRegistrationReference userRegistrationReference =
			new UserRegistrationReferenceImpl();

		userRegistrationReference.setNew(true);
		userRegistrationReference.setPrimaryKey(userRegistrationReferenceId);

		userRegistrationReference.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return userRegistrationReference;
	}

	/**
	 * Removes the user registration reference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRegistrationReferenceId the primary key of the user registration reference
	 * @return the user registration reference that was removed
	 * @throws NoSuchUserRegistrationReferenceException if a user registration reference with the primary key could not be found
	 */
	@Override
	public UserRegistrationReference remove(long userRegistrationReferenceId)
		throws NoSuchUserRegistrationReferenceException {

		return remove((Serializable)userRegistrationReferenceId);
	}

	/**
	 * Removes the user registration reference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user registration reference
	 * @return the user registration reference that was removed
	 * @throws NoSuchUserRegistrationReferenceException if a user registration reference with the primary key could not be found
	 */
	@Override
	public UserRegistrationReference remove(Serializable primaryKey)
		throws NoSuchUserRegistrationReferenceException {

		Session session = null;

		try {
			session = openSession();

			UserRegistrationReference userRegistrationReference =
				(UserRegistrationReference)session.get(
					UserRegistrationReferenceImpl.class, primaryKey);

			if (userRegistrationReference == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserRegistrationReferenceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userRegistrationReference);
		}
		catch (NoSuchUserRegistrationReferenceException noSuchEntityException) {
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
	protected UserRegistrationReference removeImpl(
		UserRegistrationReference userRegistrationReference) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userRegistrationReference)) {
				userRegistrationReference =
					(UserRegistrationReference)session.get(
						UserRegistrationReferenceImpl.class,
						userRegistrationReference.getPrimaryKeyObj());
			}

			if (userRegistrationReference != null) {
				session.delete(userRegistrationReference);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userRegistrationReference != null) {
			clearCache(userRegistrationReference);
		}

		return userRegistrationReference;
	}

	@Override
	public UserRegistrationReference updateImpl(
		UserRegistrationReference userRegistrationReference) {

		boolean isNew = userRegistrationReference.isNew();

		if (!(userRegistrationReference instanceof
				UserRegistrationReferenceModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userRegistrationReference.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					userRegistrationReference);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userRegistrationReference proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserRegistrationReference implementation " +
					userRegistrationReference.getClass());
		}

		UserRegistrationReferenceModelImpl userRegistrationReferenceModelImpl =
			(UserRegistrationReferenceModelImpl)userRegistrationReference;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (userRegistrationReference.getCreateDate() == null)) {
			if (serviceContext == null) {
				userRegistrationReference.setCreateDate(date);
			}
			else {
				userRegistrationReference.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!userRegistrationReferenceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userRegistrationReference.setModifiedDate(date);
			}
			else {
				userRegistrationReference.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userRegistrationReference);
			}
			else {
				userRegistrationReference =
					(UserRegistrationReference)session.merge(
						userRegistrationReference);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UserRegistrationReferenceImpl.class,
			userRegistrationReferenceModelImpl, false, true);

		if (isNew) {
			userRegistrationReference.setNew(false);
		}

		userRegistrationReference.resetOriginalValues();

		return userRegistrationReference;
	}

	/**
	 * Returns the user registration reference with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user registration reference
	 * @return the user registration reference
	 * @throws NoSuchUserRegistrationReferenceException if a user registration reference with the primary key could not be found
	 */
	@Override
	public UserRegistrationReference findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserRegistrationReferenceException {

		UserRegistrationReference userRegistrationReference = fetchByPrimaryKey(
			primaryKey);

		if (userRegistrationReference == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserRegistrationReferenceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userRegistrationReference;
	}

	/**
	 * Returns the user registration reference with the primary key or throws a <code>NoSuchUserRegistrationReferenceException</code> if it could not be found.
	 *
	 * @param userRegistrationReferenceId the primary key of the user registration reference
	 * @return the user registration reference
	 * @throws NoSuchUserRegistrationReferenceException if a user registration reference with the primary key could not be found
	 */
	@Override
	public UserRegistrationReference findByPrimaryKey(
			long userRegistrationReferenceId)
		throws NoSuchUserRegistrationReferenceException {

		return findByPrimaryKey((Serializable)userRegistrationReferenceId);
	}

	/**
	 * Returns the user registration reference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRegistrationReferenceId the primary key of the user registration reference
	 * @return the user registration reference, or <code>null</code> if a user registration reference with the primary key could not be found
	 */
	@Override
	public UserRegistrationReference fetchByPrimaryKey(
		long userRegistrationReferenceId) {

		return fetchByPrimaryKey((Serializable)userRegistrationReferenceId);
	}

	/**
	 * Returns all the user registration references.
	 *
	 * @return the user registration references
	 */
	@Override
	public List<UserRegistrationReference> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user registration references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationReferenceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration references
	 * @param end the upper bound of the range of user registration references (not inclusive)
	 * @return the range of user registration references
	 */
	@Override
	public List<UserRegistrationReference> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user registration references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationReferenceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration references
	 * @param end the upper bound of the range of user registration references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user registration references
	 */
	@Override
	public List<UserRegistrationReference> findAll(
		int start, int end,
		OrderByComparator<UserRegistrationReference> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user registration references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationReferenceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration references
	 * @param end the upper bound of the range of user registration references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user registration references
	 */
	@Override
	public List<UserRegistrationReference> findAll(
		int start, int end,
		OrderByComparator<UserRegistrationReference> orderByComparator,
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

		List<UserRegistrationReference> list = null;

		if (useFinderCache) {
			list = (List<UserRegistrationReference>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERREGISTRATIONREFERENCE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERREGISTRATIONREFERENCE;

				sql = sql.concat(
					UserRegistrationReferenceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserRegistrationReference>)QueryUtil.list(
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
	 * Removes all the user registration references from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserRegistrationReference userRegistrationReference : findAll()) {
			remove(userRegistrationReference);
		}
	}

	/**
	 * Returns the number of user registration references.
	 *
	 * @return the number of user registration references
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
					_SQL_COUNT_USERREGISTRATIONREFERENCE);

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
		return "userRegistrationReferenceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERREGISTRATIONREFERENCE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserRegistrationReferenceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user registration reference persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new UserRegistrationReferenceModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", UserRegistrationReference.class.getName()));

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

		_setUserRegistrationReferenceUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setUserRegistrationReferenceUtilPersistence(null);

		entityCache.removeCache(UserRegistrationReferenceImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setUserRegistrationReferenceUtilPersistence(
		UserRegistrationReferencePersistence
			userRegistrationReferencePersistence) {

		try {
			Field field = UserRegistrationReferenceUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, userRegistrationReferencePersistence);
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

	private static final String _SQL_SELECT_USERREGISTRATIONREFERENCE =
		"SELECT userRegistrationReference FROM UserRegistrationReference userRegistrationReference";

	private static final String _SQL_SELECT_USERREGISTRATIONREFERENCE_WHERE =
		"SELECT userRegistrationReference FROM UserRegistrationReference userRegistrationReference WHERE ";

	private static final String _SQL_COUNT_USERREGISTRATIONREFERENCE =
		"SELECT COUNT(userRegistrationReference) FROM UserRegistrationReference userRegistrationReference";

	private static final String _SQL_COUNT_USERREGISTRATIONREFERENCE_WHERE =
		"SELECT COUNT(userRegistrationReference) FROM UserRegistrationReference userRegistrationReference WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"userRegistrationReference.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserRegistrationReference exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserRegistrationReference exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserRegistrationReferencePersistenceImpl.class);

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

	private static class UserRegistrationReferenceModelArgumentsResolver
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

			UserRegistrationReferenceModelImpl
				userRegistrationReferenceModelImpl =
					(UserRegistrationReferenceModelImpl)baseModel;

			long columnBitmask =
				userRegistrationReferenceModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					userRegistrationReferenceModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						userRegistrationReferenceModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					userRegistrationReferenceModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			UserRegistrationReferenceModelImpl
				userRegistrationReferenceModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						userRegistrationReferenceModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						userRegistrationReferenceModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}