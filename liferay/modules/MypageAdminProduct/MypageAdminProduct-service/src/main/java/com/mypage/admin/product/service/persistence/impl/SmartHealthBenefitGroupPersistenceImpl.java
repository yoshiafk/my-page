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

package com.mypage.admin.product.service.persistence.impl;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.mypage.admin.product.exception.NoSuchSmartHealthBenefitGroupException;
import com.mypage.admin.product.model.SmartHealthBenefitGroup;
import com.mypage.admin.product.model.impl.SmartHealthBenefitGroupImpl;
import com.mypage.admin.product.model.impl.SmartHealthBenefitGroupModelImpl;
import com.mypage.admin.product.service.persistence.SmartHealthBenefitGroupPersistence;
import com.mypage.admin.product.service.persistence.SmartHealthBenefitGroupUtil;
import com.mypage.admin.product.service.persistence.impl.constants.MPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
 * The persistence implementation for the smart health benefit group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = SmartHealthBenefitGroupPersistence.class)
public class SmartHealthBenefitGroupPersistenceImpl
	extends BasePersistenceImpl<SmartHealthBenefitGroup>
	implements SmartHealthBenefitGroupPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SmartHealthBenefitGroupUtil</code> to access the smart health benefit group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SmartHealthBenefitGroupImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBygroupCode;
	private FinderPath _finderPathCountBygroupCode;

	/**
	 * Returns the smart health benefit group where groupCode = &#63; or throws a <code>NoSuchSmartHealthBenefitGroupException</code> if it could not be found.
	 *
	 * @param groupCode the group code
	 * @return the matching smart health benefit group
	 * @throws NoSuchSmartHealthBenefitGroupException if a matching smart health benefit group could not be found
	 */
	@Override
	public SmartHealthBenefitGroup findBygroupCode(String groupCode)
		throws NoSuchSmartHealthBenefitGroupException {

		SmartHealthBenefitGroup smartHealthBenefitGroup = fetchBygroupCode(
			groupCode);

		if (smartHealthBenefitGroup == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupCode=");
			sb.append(groupCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSmartHealthBenefitGroupException(sb.toString());
		}

		return smartHealthBenefitGroup;
	}

	/**
	 * Returns the smart health benefit group where groupCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupCode the group code
	 * @return the matching smart health benefit group, or <code>null</code> if a matching smart health benefit group could not be found
	 */
	@Override
	public SmartHealthBenefitGroup fetchBygroupCode(String groupCode) {
		return fetchBygroupCode(groupCode, true);
	}

	/**
	 * Returns the smart health benefit group where groupCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupCode the group code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart health benefit group, or <code>null</code> if a matching smart health benefit group could not be found
	 */
	@Override
	public SmartHealthBenefitGroup fetchBygroupCode(
		String groupCode, boolean useFinderCache) {

		groupCode = Objects.toString(groupCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBygroupCode, finderArgs, this);
		}

		if (result instanceof SmartHealthBenefitGroup) {
			SmartHealthBenefitGroup smartHealthBenefitGroup =
				(SmartHealthBenefitGroup)result;

			if (!Objects.equals(
					groupCode, smartHealthBenefitGroup.getGroupCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SMARTHEALTHBENEFITGROUP_WHERE);

			boolean bindGroupCode = false;

			if (groupCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_GROUPCODE_GROUPCODE_3);
			}
			else {
				bindGroupCode = true;

				sb.append(_FINDER_COLUMN_GROUPCODE_GROUPCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGroupCode) {
					queryPos.add(groupCode);
				}

				List<SmartHealthBenefitGroup> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBygroupCode, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {groupCode};
							}

							_log.warn(
								"SmartHealthBenefitGroupPersistenceImpl.fetchBygroupCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SmartHealthBenefitGroup smartHealthBenefitGroup = list.get(
						0);

					result = smartHealthBenefitGroup;

					cacheResult(smartHealthBenefitGroup);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SmartHealthBenefitGroup)result;
		}
	}

	/**
	 * Removes the smart health benefit group where groupCode = &#63; from the database.
	 *
	 * @param groupCode the group code
	 * @return the smart health benefit group that was removed
	 */
	@Override
	public SmartHealthBenefitGroup removeBygroupCode(String groupCode)
		throws NoSuchSmartHealthBenefitGroupException {

		SmartHealthBenefitGroup smartHealthBenefitGroup = findBygroupCode(
			groupCode);

		return remove(smartHealthBenefitGroup);
	}

	/**
	 * Returns the number of smart health benefit groups where groupCode = &#63;.
	 *
	 * @param groupCode the group code
	 * @return the number of matching smart health benefit groups
	 */
	@Override
	public int countBygroupCode(String groupCode) {
		groupCode = Objects.toString(groupCode, "");

		FinderPath finderPath = _finderPathCountBygroupCode;

		Object[] finderArgs = new Object[] {groupCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SMARTHEALTHBENEFITGROUP_WHERE);

			boolean bindGroupCode = false;

			if (groupCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_GROUPCODE_GROUPCODE_3);
			}
			else {
				bindGroupCode = true;

				sb.append(_FINDER_COLUMN_GROUPCODE_GROUPCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGroupCode) {
					queryPos.add(groupCode);
				}

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

	private static final String _FINDER_COLUMN_GROUPCODE_GROUPCODE_2 =
		"smartHealthBenefitGroup.groupCode = ?";

	private static final String _FINDER_COLUMN_GROUPCODE_GROUPCODE_3 =
		"(smartHealthBenefitGroup.groupCode IS NULL OR smartHealthBenefitGroup.groupCode = '')";

	public SmartHealthBenefitGroupPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SmartHealthBenefitGroup.class);

		setModelImplClass(SmartHealthBenefitGroupImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the smart health benefit group in the entity cache if it is enabled.
	 *
	 * @param smartHealthBenefitGroup the smart health benefit group
	 */
	@Override
	public void cacheResult(SmartHealthBenefitGroup smartHealthBenefitGroup) {
		entityCache.putResult(
			SmartHealthBenefitGroupImpl.class,
			smartHealthBenefitGroup.getPrimaryKey(), smartHealthBenefitGroup);

		finderCache.putResult(
			_finderPathFetchBygroupCode,
			new Object[] {smartHealthBenefitGroup.getGroupCode()},
			smartHealthBenefitGroup);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the smart health benefit groups in the entity cache if it is enabled.
	 *
	 * @param smartHealthBenefitGroups the smart health benefit groups
	 */
	@Override
	public void cacheResult(
		List<SmartHealthBenefitGroup> smartHealthBenefitGroups) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (smartHealthBenefitGroups.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SmartHealthBenefitGroup smartHealthBenefitGroup :
				smartHealthBenefitGroups) {

			if (entityCache.getResult(
					SmartHealthBenefitGroupImpl.class,
					smartHealthBenefitGroup.getPrimaryKey()) == null) {

				cacheResult(smartHealthBenefitGroup);
			}
		}
	}

	/**
	 * Clears the cache for all smart health benefit groups.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SmartHealthBenefitGroupImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the smart health benefit group.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SmartHealthBenefitGroup smartHealthBenefitGroup) {
		entityCache.removeResult(
			SmartHealthBenefitGroupImpl.class, smartHealthBenefitGroup);
	}

	@Override
	public void clearCache(
		List<SmartHealthBenefitGroup> smartHealthBenefitGroups) {

		for (SmartHealthBenefitGroup smartHealthBenefitGroup :
				smartHealthBenefitGroups) {

			entityCache.removeResult(
				SmartHealthBenefitGroupImpl.class, smartHealthBenefitGroup);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				SmartHealthBenefitGroupImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SmartHealthBenefitGroupModelImpl smartHealthBenefitGroupModelImpl) {

		Object[] args = new Object[] {
			smartHealthBenefitGroupModelImpl.getGroupCode()
		};

		finderCache.putResult(
			_finderPathCountBygroupCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBygroupCode, args, smartHealthBenefitGroupModelImpl,
			false);
	}

	/**
	 * Creates a new smart health benefit group with the primary key. Does not add the smart health benefit group to the database.
	 *
	 * @param smartHealthBenefitGroupId the primary key for the new smart health benefit group
	 * @return the new smart health benefit group
	 */
	@Override
	public SmartHealthBenefitGroup create(long smartHealthBenefitGroupId) {
		SmartHealthBenefitGroup smartHealthBenefitGroup =
			new SmartHealthBenefitGroupImpl();

		smartHealthBenefitGroup.setNew(true);
		smartHealthBenefitGroup.setPrimaryKey(smartHealthBenefitGroupId);

		smartHealthBenefitGroup.setCompanyId(CompanyThreadLocal.getCompanyId());

		return smartHealthBenefitGroup;
	}

	/**
	 * Removes the smart health benefit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartHealthBenefitGroupId the primary key of the smart health benefit group
	 * @return the smart health benefit group that was removed
	 * @throws NoSuchSmartHealthBenefitGroupException if a smart health benefit group with the primary key could not be found
	 */
	@Override
	public SmartHealthBenefitGroup remove(long smartHealthBenefitGroupId)
		throws NoSuchSmartHealthBenefitGroupException {

		return remove((Serializable)smartHealthBenefitGroupId);
	}

	/**
	 * Removes the smart health benefit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the smart health benefit group
	 * @return the smart health benefit group that was removed
	 * @throws NoSuchSmartHealthBenefitGroupException if a smart health benefit group with the primary key could not be found
	 */
	@Override
	public SmartHealthBenefitGroup remove(Serializable primaryKey)
		throws NoSuchSmartHealthBenefitGroupException {

		Session session = null;

		try {
			session = openSession();

			SmartHealthBenefitGroup smartHealthBenefitGroup =
				(SmartHealthBenefitGroup)session.get(
					SmartHealthBenefitGroupImpl.class, primaryKey);

			if (smartHealthBenefitGroup == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSmartHealthBenefitGroupException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(smartHealthBenefitGroup);
		}
		catch (NoSuchSmartHealthBenefitGroupException noSuchEntityException) {
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
	protected SmartHealthBenefitGroup removeImpl(
		SmartHealthBenefitGroup smartHealthBenefitGroup) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(smartHealthBenefitGroup)) {
				smartHealthBenefitGroup = (SmartHealthBenefitGroup)session.get(
					SmartHealthBenefitGroupImpl.class,
					smartHealthBenefitGroup.getPrimaryKeyObj());
			}

			if (smartHealthBenefitGroup != null) {
				session.delete(smartHealthBenefitGroup);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (smartHealthBenefitGroup != null) {
			clearCache(smartHealthBenefitGroup);
		}

		return smartHealthBenefitGroup;
	}

	@Override
	public SmartHealthBenefitGroup updateImpl(
		SmartHealthBenefitGroup smartHealthBenefitGroup) {

		boolean isNew = smartHealthBenefitGroup.isNew();

		if (!(smartHealthBenefitGroup instanceof
				SmartHealthBenefitGroupModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(smartHealthBenefitGroup.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					smartHealthBenefitGroup);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in smartHealthBenefitGroup proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SmartHealthBenefitGroup implementation " +
					smartHealthBenefitGroup.getClass());
		}

		SmartHealthBenefitGroupModelImpl smartHealthBenefitGroupModelImpl =
			(SmartHealthBenefitGroupModelImpl)smartHealthBenefitGroup;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (smartHealthBenefitGroup.getCreateDate() == null)) {
			if (serviceContext == null) {
				smartHealthBenefitGroup.setCreateDate(date);
			}
			else {
				smartHealthBenefitGroup.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!smartHealthBenefitGroupModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				smartHealthBenefitGroup.setModifiedDate(date);
			}
			else {
				smartHealthBenefitGroup.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(smartHealthBenefitGroup);
			}
			else {
				smartHealthBenefitGroup =
					(SmartHealthBenefitGroup)session.merge(
						smartHealthBenefitGroup);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SmartHealthBenefitGroupImpl.class, smartHealthBenefitGroupModelImpl,
			false, true);

		cacheUniqueFindersCache(smartHealthBenefitGroupModelImpl);

		if (isNew) {
			smartHealthBenefitGroup.setNew(false);
		}

		smartHealthBenefitGroup.resetOriginalValues();

		return smartHealthBenefitGroup;
	}

	/**
	 * Returns the smart health benefit group with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the smart health benefit group
	 * @return the smart health benefit group
	 * @throws NoSuchSmartHealthBenefitGroupException if a smart health benefit group with the primary key could not be found
	 */
	@Override
	public SmartHealthBenefitGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSmartHealthBenefitGroupException {

		SmartHealthBenefitGroup smartHealthBenefitGroup = fetchByPrimaryKey(
			primaryKey);

		if (smartHealthBenefitGroup == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSmartHealthBenefitGroupException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return smartHealthBenefitGroup;
	}

	/**
	 * Returns the smart health benefit group with the primary key or throws a <code>NoSuchSmartHealthBenefitGroupException</code> if it could not be found.
	 *
	 * @param smartHealthBenefitGroupId the primary key of the smart health benefit group
	 * @return the smart health benefit group
	 * @throws NoSuchSmartHealthBenefitGroupException if a smart health benefit group with the primary key could not be found
	 */
	@Override
	public SmartHealthBenefitGroup findByPrimaryKey(
			long smartHealthBenefitGroupId)
		throws NoSuchSmartHealthBenefitGroupException {

		return findByPrimaryKey((Serializable)smartHealthBenefitGroupId);
	}

	/**
	 * Returns the smart health benefit group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartHealthBenefitGroupId the primary key of the smart health benefit group
	 * @return the smart health benefit group, or <code>null</code> if a smart health benefit group with the primary key could not be found
	 */
	@Override
	public SmartHealthBenefitGroup fetchByPrimaryKey(
		long smartHealthBenefitGroupId) {

		return fetchByPrimaryKey((Serializable)smartHealthBenefitGroupId);
	}

	/**
	 * Returns all the smart health benefit groups.
	 *
	 * @return the smart health benefit groups
	 */
	@Override
	public List<SmartHealthBenefitGroup> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smart health benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefit groups
	 * @param end the upper bound of the range of smart health benefit groups (not inclusive)
	 * @return the range of smart health benefit groups
	 */
	@Override
	public List<SmartHealthBenefitGroup> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart health benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefit groups
	 * @param end the upper bound of the range of smart health benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart health benefit groups
	 */
	@Override
	public List<SmartHealthBenefitGroup> findAll(
		int start, int end,
		OrderByComparator<SmartHealthBenefitGroup> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart health benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefit groups
	 * @param end the upper bound of the range of smart health benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart health benefit groups
	 */
	@Override
	public List<SmartHealthBenefitGroup> findAll(
		int start, int end,
		OrderByComparator<SmartHealthBenefitGroup> orderByComparator,
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

		List<SmartHealthBenefitGroup> list = null;

		if (useFinderCache) {
			list = (List<SmartHealthBenefitGroup>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SMARTHEALTHBENEFITGROUP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SMARTHEALTHBENEFITGROUP;

				sql = sql.concat(
					SmartHealthBenefitGroupModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SmartHealthBenefitGroup>)QueryUtil.list(
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
	 * Removes all the smart health benefit groups from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SmartHealthBenefitGroup smartHealthBenefitGroup : findAll()) {
			remove(smartHealthBenefitGroup);
		}
	}

	/**
	 * Returns the number of smart health benefit groups.
	 *
	 * @return the number of smart health benefit groups
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
					_SQL_COUNT_SMARTHEALTHBENEFITGROUP);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "smartHealthBenefitGroupId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SMARTHEALTHBENEFITGROUP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SmartHealthBenefitGroupModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the smart health benefit group persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SmartHealthBenefitGroupModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SmartHealthBenefitGroup.class.getName()));

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

		_finderPathFetchBygroupCode = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBygroupCode",
			new String[] {String.class.getName()}, new String[] {"groupCode"},
			true);

		_finderPathCountBygroupCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygroupCode",
			new String[] {String.class.getName()}, new String[] {"groupCode"},
			false);

		_setSmartHealthBenefitGroupUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSmartHealthBenefitGroupUtilPersistence(null);

		entityCache.removeCache(SmartHealthBenefitGroupImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setSmartHealthBenefitGroupUtilPersistence(
		SmartHealthBenefitGroupPersistence smartHealthBenefitGroupPersistence) {

		try {
			Field field = SmartHealthBenefitGroupUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, smartHealthBenefitGroupPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MPPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_SMARTHEALTHBENEFITGROUP =
		"SELECT smartHealthBenefitGroup FROM SmartHealthBenefitGroup smartHealthBenefitGroup";

	private static final String _SQL_SELECT_SMARTHEALTHBENEFITGROUP_WHERE =
		"SELECT smartHealthBenefitGroup FROM SmartHealthBenefitGroup smartHealthBenefitGroup WHERE ";

	private static final String _SQL_COUNT_SMARTHEALTHBENEFITGROUP =
		"SELECT COUNT(smartHealthBenefitGroup) FROM SmartHealthBenefitGroup smartHealthBenefitGroup";

	private static final String _SQL_COUNT_SMARTHEALTHBENEFITGROUP_WHERE =
		"SELECT COUNT(smartHealthBenefitGroup) FROM SmartHealthBenefitGroup smartHealthBenefitGroup WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"smartHealthBenefitGroup.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SmartHealthBenefitGroup exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SmartHealthBenefitGroup exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SmartHealthBenefitGroupPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"active"});

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

	private static class SmartHealthBenefitGroupModelArgumentsResolver
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

			SmartHealthBenefitGroupModelImpl smartHealthBenefitGroupModelImpl =
				(SmartHealthBenefitGroupModelImpl)baseModel;

			long columnBitmask =
				smartHealthBenefitGroupModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					smartHealthBenefitGroupModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						smartHealthBenefitGroupModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					smartHealthBenefitGroupModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SmartHealthBenefitGroupModelImpl smartHealthBenefitGroupModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						smartHealthBenefitGroupModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						smartHealthBenefitGroupModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}