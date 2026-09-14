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

import com.mypage.admin.product.exception.NoSuchMasterBranchException;
import com.mypage.admin.product.model.MasterBranch;
import com.mypage.admin.product.model.impl.MasterBranchImpl;
import com.mypage.admin.product.model.impl.MasterBranchModelImpl;
import com.mypage.admin.product.service.persistence.MasterBranchPersistence;
import com.mypage.admin.product.service.persistence.MasterBranchUtil;
import com.mypage.admin.product.service.persistence.impl.constants.MPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the master branch service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = MasterBranchPersistence.class)
public class MasterBranchPersistenceImpl
	extends BasePersistenceImpl<MasterBranch>
	implements MasterBranchPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MasterBranchUtil</code> to access the master branch persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MasterBranchImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBysearchByName;
	private FinderPath _finderPathWithoutPaginationFindBysearchByName;
	private FinderPath _finderPathCountBysearchByName;

	/**
	 * Returns all the master branches where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching master branches
	 */
	@Override
	public List<MasterBranch> findBysearchByName(String name) {
		return findBysearchByName(
			name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master branches where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @return the range of matching master branches
	 */
	@Override
	public List<MasterBranch> findBysearchByName(
		String name, int start, int end) {

		return findBysearchByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master branches where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master branches
	 */
	@Override
	public List<MasterBranch> findBysearchByName(
		String name, int start, int end,
		OrderByComparator<MasterBranch> orderByComparator) {

		return findBysearchByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master branches where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master branches
	 */
	@Override
	public List<MasterBranch> findBysearchByName(
		String name, int start, int end,
		OrderByComparator<MasterBranch> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBysearchByName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchByName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<MasterBranch> list = null;

		if (useFinderCache) {
			list = (List<MasterBranch>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MasterBranch masterBranch : list) {
					if (!name.equals(masterBranch.getName())) {
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

			sb.append(_SQL_SELECT_MASTERBRANCH_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHBYNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_SEARCHBYNAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MasterBranchModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<MasterBranch>)QueryUtil.list(
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
	 * Returns the first master branch in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master branch
	 * @throws NoSuchMasterBranchException if a matching master branch could not be found
	 */
	@Override
	public MasterBranch findBysearchByName_First(
			String name, OrderByComparator<MasterBranch> orderByComparator)
		throws NoSuchMasterBranchException {

		MasterBranch masterBranch = fetchBysearchByName_First(
			name, orderByComparator);

		if (masterBranch != null) {
			return masterBranch;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchMasterBranchException(sb.toString());
	}

	/**
	 * Returns the first master branch in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master branch, or <code>null</code> if a matching master branch could not be found
	 */
	@Override
	public MasterBranch fetchBysearchByName_First(
		String name, OrderByComparator<MasterBranch> orderByComparator) {

		List<MasterBranch> list = findBysearchByName(
			name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master branch in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master branch
	 * @throws NoSuchMasterBranchException if a matching master branch could not be found
	 */
	@Override
	public MasterBranch findBysearchByName_Last(
			String name, OrderByComparator<MasterBranch> orderByComparator)
		throws NoSuchMasterBranchException {

		MasterBranch masterBranch = fetchBysearchByName_Last(
			name, orderByComparator);

		if (masterBranch != null) {
			return masterBranch;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchMasterBranchException(sb.toString());
	}

	/**
	 * Returns the last master branch in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master branch, or <code>null</code> if a matching master branch could not be found
	 */
	@Override
	public MasterBranch fetchBysearchByName_Last(
		String name, OrderByComparator<MasterBranch> orderByComparator) {

		int count = countBysearchByName(name);

		if (count == 0) {
			return null;
		}

		List<MasterBranch> list = findBysearchByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master branches before and after the current master branch in the ordered set where name = &#63;.
	 *
	 * @param masterBranchId the primary key of the current master branch
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master branch
	 * @throws NoSuchMasterBranchException if a master branch with the primary key could not be found
	 */
	@Override
	public MasterBranch[] findBysearchByName_PrevAndNext(
			long masterBranchId, String name,
			OrderByComparator<MasterBranch> orderByComparator)
		throws NoSuchMasterBranchException {

		name = Objects.toString(name, "");

		MasterBranch masterBranch = findByPrimaryKey(masterBranchId);

		Session session = null;

		try {
			session = openSession();

			MasterBranch[] array = new MasterBranchImpl[3];

			array[0] = getBysearchByName_PrevAndNext(
				session, masterBranch, name, orderByComparator, true);

			array[1] = masterBranch;

			array[2] = getBysearchByName_PrevAndNext(
				session, masterBranch, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterBranch getBysearchByName_PrevAndNext(
		Session session, MasterBranch masterBranch, String name,
		OrderByComparator<MasterBranch> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MASTERBRANCH_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_SEARCHBYNAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_SEARCHBYNAME_NAME_2);
		}

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
			sb.append(MasterBranchModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(masterBranch)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MasterBranch> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master branches where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeBysearchByName(String name) {
		for (MasterBranch masterBranch :
				findBysearchByName(
					name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(masterBranch);
		}
	}

	/**
	 * Returns the number of master branches where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching master branches
	 */
	@Override
	public int countBysearchByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountBysearchByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MASTERBRANCH_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHBYNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_SEARCHBYNAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
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

	private static final String _FINDER_COLUMN_SEARCHBYNAME_NAME_2 =
		"masterBranch.name = ?";

	private static final String _FINDER_COLUMN_SEARCHBYNAME_NAME_3 =
		"(masterBranch.name IS NULL OR masterBranch.name = '')";

	public MasterBranchPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MasterBranch.class);

		setModelImplClass(MasterBranchImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the master branch in the entity cache if it is enabled.
	 *
	 * @param masterBranch the master branch
	 */
	@Override
	public void cacheResult(MasterBranch masterBranch) {
		entityCache.putResult(
			MasterBranchImpl.class, masterBranch.getPrimaryKey(), masterBranch);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the master branches in the entity cache if it is enabled.
	 *
	 * @param masterBranches the master branches
	 */
	@Override
	public void cacheResult(List<MasterBranch> masterBranches) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (masterBranches.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MasterBranch masterBranch : masterBranches) {
			if (entityCache.getResult(
					MasterBranchImpl.class, masterBranch.getPrimaryKey()) ==
						null) {

				cacheResult(masterBranch);
			}
		}
	}

	/**
	 * Clears the cache for all master branches.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MasterBranchImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the master branch.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MasterBranch masterBranch) {
		entityCache.removeResult(MasterBranchImpl.class, masterBranch);
	}

	@Override
	public void clearCache(List<MasterBranch> masterBranches) {
		for (MasterBranch masterBranch : masterBranches) {
			entityCache.removeResult(MasterBranchImpl.class, masterBranch);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MasterBranchImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new master branch with the primary key. Does not add the master branch to the database.
	 *
	 * @param masterBranchId the primary key for the new master branch
	 * @return the new master branch
	 */
	@Override
	public MasterBranch create(long masterBranchId) {
		MasterBranch masterBranch = new MasterBranchImpl();

		masterBranch.setNew(true);
		masterBranch.setPrimaryKey(masterBranchId);

		masterBranch.setCompanyId(CompanyThreadLocal.getCompanyId());

		return masterBranch;
	}

	/**
	 * Removes the master branch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterBranchId the primary key of the master branch
	 * @return the master branch that was removed
	 * @throws NoSuchMasterBranchException if a master branch with the primary key could not be found
	 */
	@Override
	public MasterBranch remove(long masterBranchId)
		throws NoSuchMasterBranchException {

		return remove((Serializable)masterBranchId);
	}

	/**
	 * Removes the master branch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the master branch
	 * @return the master branch that was removed
	 * @throws NoSuchMasterBranchException if a master branch with the primary key could not be found
	 */
	@Override
	public MasterBranch remove(Serializable primaryKey)
		throws NoSuchMasterBranchException {

		Session session = null;

		try {
			session = openSession();

			MasterBranch masterBranch = (MasterBranch)session.get(
				MasterBranchImpl.class, primaryKey);

			if (masterBranch == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasterBranchException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(masterBranch);
		}
		catch (NoSuchMasterBranchException noSuchEntityException) {
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
	protected MasterBranch removeImpl(MasterBranch masterBranch) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(masterBranch)) {
				masterBranch = (MasterBranch)session.get(
					MasterBranchImpl.class, masterBranch.getPrimaryKeyObj());
			}

			if (masterBranch != null) {
				session.delete(masterBranch);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (masterBranch != null) {
			clearCache(masterBranch);
		}

		return masterBranch;
	}

	@Override
	public MasterBranch updateImpl(MasterBranch masterBranch) {
		boolean isNew = masterBranch.isNew();

		if (!(masterBranch instanceof MasterBranchModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(masterBranch.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					masterBranch);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in masterBranch proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MasterBranch implementation " +
					masterBranch.getClass());
		}

		MasterBranchModelImpl masterBranchModelImpl =
			(MasterBranchModelImpl)masterBranch;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (masterBranch.getCreateDate() == null)) {
			if (serviceContext == null) {
				masterBranch.setCreateDate(date);
			}
			else {
				masterBranch.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!masterBranchModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				masterBranch.setModifiedDate(date);
			}
			else {
				masterBranch.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(masterBranch);
			}
			else {
				masterBranch = (MasterBranch)session.merge(masterBranch);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MasterBranchImpl.class, masterBranchModelImpl, false, true);

		if (isNew) {
			masterBranch.setNew(false);
		}

		masterBranch.resetOriginalValues();

		return masterBranch;
	}

	/**
	 * Returns the master branch with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the master branch
	 * @return the master branch
	 * @throws NoSuchMasterBranchException if a master branch with the primary key could not be found
	 */
	@Override
	public MasterBranch findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMasterBranchException {

		MasterBranch masterBranch = fetchByPrimaryKey(primaryKey);

		if (masterBranch == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasterBranchException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return masterBranch;
	}

	/**
	 * Returns the master branch with the primary key or throws a <code>NoSuchMasterBranchException</code> if it could not be found.
	 *
	 * @param masterBranchId the primary key of the master branch
	 * @return the master branch
	 * @throws NoSuchMasterBranchException if a master branch with the primary key could not be found
	 */
	@Override
	public MasterBranch findByPrimaryKey(long masterBranchId)
		throws NoSuchMasterBranchException {

		return findByPrimaryKey((Serializable)masterBranchId);
	}

	/**
	 * Returns the master branch with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterBranchId the primary key of the master branch
	 * @return the master branch, or <code>null</code> if a master branch with the primary key could not be found
	 */
	@Override
	public MasterBranch fetchByPrimaryKey(long masterBranchId) {
		return fetchByPrimaryKey((Serializable)masterBranchId);
	}

	/**
	 * Returns all the master branches.
	 *
	 * @return the master branches
	 */
	@Override
	public List<MasterBranch> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master branches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @return the range of master branches
	 */
	@Override
	public List<MasterBranch> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the master branches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master branches
	 */
	@Override
	public List<MasterBranch> findAll(
		int start, int end, OrderByComparator<MasterBranch> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master branches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master branches
	 */
	@Override
	public List<MasterBranch> findAll(
		int start, int end, OrderByComparator<MasterBranch> orderByComparator,
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

		List<MasterBranch> list = null;

		if (useFinderCache) {
			list = (List<MasterBranch>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MASTERBRANCH);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MASTERBRANCH;

				sql = sql.concat(MasterBranchModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MasterBranch>)QueryUtil.list(
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
	 * Removes all the master branches from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MasterBranch masterBranch : findAll()) {
			remove(masterBranch);
		}
	}

	/**
	 * Returns the number of master branches.
	 *
	 * @return the number of master branches
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MASTERBRANCH);

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
		return "masterBranchId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MASTERBRANCH;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MasterBranchModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the master branch persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new MasterBranchModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MasterBranch.class.getName()));

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

		_finderPathWithPaginationFindBysearchByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchByName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"name"}, true);

		_finderPathWithoutPaginationFindBysearchByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysearchByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountBysearchByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_setMasterBranchUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMasterBranchUtilPersistence(null);

		entityCache.removeCache(MasterBranchImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setMasterBranchUtilPersistence(
		MasterBranchPersistence masterBranchPersistence) {

		try {
			Field field = MasterBranchUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, masterBranchPersistence);
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

	private static final String _SQL_SELECT_MASTERBRANCH =
		"SELECT masterBranch FROM MasterBranch masterBranch";

	private static final String _SQL_SELECT_MASTERBRANCH_WHERE =
		"SELECT masterBranch FROM MasterBranch masterBranch WHERE ";

	private static final String _SQL_COUNT_MASTERBRANCH =
		"SELECT COUNT(masterBranch) FROM MasterBranch masterBranch";

	private static final String _SQL_COUNT_MASTERBRANCH_WHERE =
		"SELECT COUNT(masterBranch) FROM MasterBranch masterBranch WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "masterBranch.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MasterBranch exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MasterBranch exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MasterBranchPersistenceImpl.class);

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

	private static class MasterBranchModelArgumentsResolver
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

			MasterBranchModelImpl masterBranchModelImpl =
				(MasterBranchModelImpl)baseModel;

			long columnBitmask = masterBranchModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(masterBranchModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						masterBranchModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(masterBranchModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			MasterBranchModelImpl masterBranchModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = masterBranchModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = masterBranchModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}