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

package com.mypage.leads.service.persistence.impl;

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

import com.mypage.leads.exception.NoSuchDetailDriveException;
import com.mypage.leads.model.DetailDrive;
import com.mypage.leads.model.impl.DetailDriveImpl;
import com.mypage.leads.model.impl.DetailDriveModelImpl;
import com.mypage.leads.service.persistence.DetailDrivePersistence;
import com.mypage.leads.service.persistence.DetailDriveUtil;
import com.mypage.leads.service.persistence.impl.constants.MPLPersistenceConstants;

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

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the detail drive service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @generated
 */
@Component(service = DetailDrivePersistence.class)
public class DetailDrivePersistenceImpl
	extends BasePersistenceImpl<DetailDrive> implements DetailDrivePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DetailDriveUtil</code> to access the detail drive persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DetailDriveImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByLeadsId;
	private FinderPath _finderPathWithoutPaginationFindByLeadsId;
	private FinderPath _finderPathCountByLeadsId;

	/**
	 * Returns all the detail drives where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @return the matching detail drives
	 */
	@Override
	public List<DetailDrive> findByLeadsId(long leadsId) {
		return findByLeadsId(
			leadsId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the detail drives where leadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDriveModelImpl</code>.
	 * </p>
	 *
	 * @param leadsId the leads ID
	 * @param start the lower bound of the range of detail drives
	 * @param end the upper bound of the range of detail drives (not inclusive)
	 * @return the range of matching detail drives
	 */
	@Override
	public List<DetailDrive> findByLeadsId(long leadsId, int start, int end) {
		return findByLeadsId(leadsId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the detail drives where leadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDriveModelImpl</code>.
	 * </p>
	 *
	 * @param leadsId the leads ID
	 * @param start the lower bound of the range of detail drives
	 * @param end the upper bound of the range of detail drives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching detail drives
	 */
	@Override
	public List<DetailDrive> findByLeadsId(
		long leadsId, int start, int end,
		OrderByComparator<DetailDrive> orderByComparator) {

		return findByLeadsId(leadsId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the detail drives where leadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDriveModelImpl</code>.
	 * </p>
	 *
	 * @param leadsId the leads ID
	 * @param start the lower bound of the range of detail drives
	 * @param end the upper bound of the range of detail drives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching detail drives
	 */
	@Override
	public List<DetailDrive> findByLeadsId(
		long leadsId, int start, int end,
		OrderByComparator<DetailDrive> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLeadsId;
				finderArgs = new Object[] {leadsId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLeadsId;
			finderArgs = new Object[] {leadsId, start, end, orderByComparator};
		}

		List<DetailDrive> list = null;

		if (useFinderCache) {
			list = (List<DetailDrive>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DetailDrive detailDrive : list) {
					if (leadsId != detailDrive.getLeadsId()) {
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

			sb.append(_SQL_SELECT_DETAILDRIVE_WHERE);

			sb.append(_FINDER_COLUMN_LEADSID_LEADSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DetailDriveModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leadsId);

				list = (List<DetailDrive>)QueryUtil.list(
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
	 * Returns the first detail drive in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching detail drive
	 * @throws NoSuchDetailDriveException if a matching detail drive could not be found
	 */
	@Override
	public DetailDrive findByLeadsId_First(
			long leadsId, OrderByComparator<DetailDrive> orderByComparator)
		throws NoSuchDetailDriveException {

		DetailDrive detailDrive = fetchByLeadsId_First(
			leadsId, orderByComparator);

		if (detailDrive != null) {
			return detailDrive;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("leadsId=");
		sb.append(leadsId);

		sb.append("}");

		throw new NoSuchDetailDriveException(sb.toString());
	}

	/**
	 * Returns the first detail drive in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching detail drive, or <code>null</code> if a matching detail drive could not be found
	 */
	@Override
	public DetailDrive fetchByLeadsId_First(
		long leadsId, OrderByComparator<DetailDrive> orderByComparator) {

		List<DetailDrive> list = findByLeadsId(
			leadsId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last detail drive in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching detail drive
	 * @throws NoSuchDetailDriveException if a matching detail drive could not be found
	 */
	@Override
	public DetailDrive findByLeadsId_Last(
			long leadsId, OrderByComparator<DetailDrive> orderByComparator)
		throws NoSuchDetailDriveException {

		DetailDrive detailDrive = fetchByLeadsId_Last(
			leadsId, orderByComparator);

		if (detailDrive != null) {
			return detailDrive;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("leadsId=");
		sb.append(leadsId);

		sb.append("}");

		throw new NoSuchDetailDriveException(sb.toString());
	}

	/**
	 * Returns the last detail drive in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching detail drive, or <code>null</code> if a matching detail drive could not be found
	 */
	@Override
	public DetailDrive fetchByLeadsId_Last(
		long leadsId, OrderByComparator<DetailDrive> orderByComparator) {

		int count = countByLeadsId(leadsId);

		if (count == 0) {
			return null;
		}

		List<DetailDrive> list = findByLeadsId(
			leadsId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the detail drives before and after the current detail drive in the ordered set where leadsId = &#63;.
	 *
	 * @param detailDriveId the primary key of the current detail drive
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next detail drive
	 * @throws NoSuchDetailDriveException if a detail drive with the primary key could not be found
	 */
	@Override
	public DetailDrive[] findByLeadsId_PrevAndNext(
			long detailDriveId, long leadsId,
			OrderByComparator<DetailDrive> orderByComparator)
		throws NoSuchDetailDriveException {

		DetailDrive detailDrive = findByPrimaryKey(detailDriveId);

		Session session = null;

		try {
			session = openSession();

			DetailDrive[] array = new DetailDriveImpl[3];

			array[0] = getByLeadsId_PrevAndNext(
				session, detailDrive, leadsId, orderByComparator, true);

			array[1] = detailDrive;

			array[2] = getByLeadsId_PrevAndNext(
				session, detailDrive, leadsId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DetailDrive getByLeadsId_PrevAndNext(
		Session session, DetailDrive detailDrive, long leadsId,
		OrderByComparator<DetailDrive> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DETAILDRIVE_WHERE);

		sb.append(_FINDER_COLUMN_LEADSID_LEADSID_2);

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
			sb.append(DetailDriveModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(leadsId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(detailDrive)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DetailDrive> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the detail drives where leadsId = &#63; from the database.
	 *
	 * @param leadsId the leads ID
	 */
	@Override
	public void removeByLeadsId(long leadsId) {
		for (DetailDrive detailDrive :
				findByLeadsId(
					leadsId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(detailDrive);
		}
	}

	/**
	 * Returns the number of detail drives where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @return the number of matching detail drives
	 */
	@Override
	public int countByLeadsId(long leadsId) {
		FinderPath finderPath = _finderPathCountByLeadsId;

		Object[] finderArgs = new Object[] {leadsId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DETAILDRIVE_WHERE);

			sb.append(_FINDER_COLUMN_LEADSID_LEADSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leadsId);

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

	private static final String _FINDER_COLUMN_LEADSID_LEADSID_2 =
		"detailDrive.leadsId = ?";

	public DetailDrivePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("currency", "currency_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DetailDrive.class);

		setModelImplClass(DetailDriveImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the detail drive in the entity cache if it is enabled.
	 *
	 * @param detailDrive the detail drive
	 */
	@Override
	public void cacheResult(DetailDrive detailDrive) {
		entityCache.putResult(
			DetailDriveImpl.class, detailDrive.getPrimaryKey(), detailDrive);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the detail drives in the entity cache if it is enabled.
	 *
	 * @param detailDrives the detail drives
	 */
	@Override
	public void cacheResult(List<DetailDrive> detailDrives) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (detailDrives.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DetailDrive detailDrive : detailDrives) {
			if (entityCache.getResult(
					DetailDriveImpl.class, detailDrive.getPrimaryKey()) ==
						null) {

				cacheResult(detailDrive);
			}
		}
	}

	/**
	 * Clears the cache for all detail drives.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DetailDriveImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the detail drive.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DetailDrive detailDrive) {
		entityCache.removeResult(DetailDriveImpl.class, detailDrive);
	}

	@Override
	public void clearCache(List<DetailDrive> detailDrives) {
		for (DetailDrive detailDrive : detailDrives) {
			entityCache.removeResult(DetailDriveImpl.class, detailDrive);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DetailDriveImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new detail drive with the primary key. Does not add the detail drive to the database.
	 *
	 * @param detailDriveId the primary key for the new detail drive
	 * @return the new detail drive
	 */
	@Override
	public DetailDrive create(long detailDriveId) {
		DetailDrive detailDrive = new DetailDriveImpl();

		detailDrive.setNew(true);
		detailDrive.setPrimaryKey(detailDriveId);

		detailDrive.setCompanyId(CompanyThreadLocal.getCompanyId());

		return detailDrive;
	}

	/**
	 * Removes the detail drive with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param detailDriveId the primary key of the detail drive
	 * @return the detail drive that was removed
	 * @throws NoSuchDetailDriveException if a detail drive with the primary key could not be found
	 */
	@Override
	public DetailDrive remove(long detailDriveId)
		throws NoSuchDetailDriveException {

		return remove((Serializable)detailDriveId);
	}

	/**
	 * Removes the detail drive with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the detail drive
	 * @return the detail drive that was removed
	 * @throws NoSuchDetailDriveException if a detail drive with the primary key could not be found
	 */
	@Override
	public DetailDrive remove(Serializable primaryKey)
		throws NoSuchDetailDriveException {

		Session session = null;

		try {
			session = openSession();

			DetailDrive detailDrive = (DetailDrive)session.get(
				DetailDriveImpl.class, primaryKey);

			if (detailDrive == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDetailDriveException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(detailDrive);
		}
		catch (NoSuchDetailDriveException noSuchEntityException) {
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
	protected DetailDrive removeImpl(DetailDrive detailDrive) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(detailDrive)) {
				detailDrive = (DetailDrive)session.get(
					DetailDriveImpl.class, detailDrive.getPrimaryKeyObj());
			}

			if (detailDrive != null) {
				session.delete(detailDrive);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (detailDrive != null) {
			clearCache(detailDrive);
		}

		return detailDrive;
	}

	@Override
	public DetailDrive updateImpl(DetailDrive detailDrive) {
		boolean isNew = detailDrive.isNew();

		if (!(detailDrive instanceof DetailDriveModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(detailDrive.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(detailDrive);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in detailDrive proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DetailDrive implementation " +
					detailDrive.getClass());
		}

		DetailDriveModelImpl detailDriveModelImpl =
			(DetailDriveModelImpl)detailDrive;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (detailDrive.getCreateDate() == null)) {
			if (serviceContext == null) {
				detailDrive.setCreateDate(date);
			}
			else {
				detailDrive.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!detailDriveModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				detailDrive.setModifiedDate(date);
			}
			else {
				detailDrive.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(detailDrive);
			}
			else {
				detailDrive = (DetailDrive)session.merge(detailDrive);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DetailDriveImpl.class, detailDriveModelImpl, false, true);

		if (isNew) {
			detailDrive.setNew(false);
		}

		detailDrive.resetOriginalValues();

		return detailDrive;
	}

	/**
	 * Returns the detail drive with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the detail drive
	 * @return the detail drive
	 * @throws NoSuchDetailDriveException if a detail drive with the primary key could not be found
	 */
	@Override
	public DetailDrive findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDetailDriveException {

		DetailDrive detailDrive = fetchByPrimaryKey(primaryKey);

		if (detailDrive == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDetailDriveException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return detailDrive;
	}

	/**
	 * Returns the detail drive with the primary key or throws a <code>NoSuchDetailDriveException</code> if it could not be found.
	 *
	 * @param detailDriveId the primary key of the detail drive
	 * @return the detail drive
	 * @throws NoSuchDetailDriveException if a detail drive with the primary key could not be found
	 */
	@Override
	public DetailDrive findByPrimaryKey(long detailDriveId)
		throws NoSuchDetailDriveException {

		return findByPrimaryKey((Serializable)detailDriveId);
	}

	/**
	 * Returns the detail drive with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param detailDriveId the primary key of the detail drive
	 * @return the detail drive, or <code>null</code> if a detail drive with the primary key could not be found
	 */
	@Override
	public DetailDrive fetchByPrimaryKey(long detailDriveId) {
		return fetchByPrimaryKey((Serializable)detailDriveId);
	}

	/**
	 * Returns all the detail drives.
	 *
	 * @return the detail drives
	 */
	@Override
	public List<DetailDrive> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the detail drives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDriveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail drives
	 * @param end the upper bound of the range of detail drives (not inclusive)
	 * @return the range of detail drives
	 */
	@Override
	public List<DetailDrive> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the detail drives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDriveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail drives
	 * @param end the upper bound of the range of detail drives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail drives
	 */
	@Override
	public List<DetailDrive> findAll(
		int start, int end, OrderByComparator<DetailDrive> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the detail drives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDriveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail drives
	 * @param end the upper bound of the range of detail drives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail drives
	 */
	@Override
	public List<DetailDrive> findAll(
		int start, int end, OrderByComparator<DetailDrive> orderByComparator,
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

		List<DetailDrive> list = null;

		if (useFinderCache) {
			list = (List<DetailDrive>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DETAILDRIVE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DETAILDRIVE;

				sql = sql.concat(DetailDriveModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DetailDrive>)QueryUtil.list(
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
	 * Removes all the detail drives from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DetailDrive detailDrive : findAll()) {
			remove(detailDrive);
		}
	}

	/**
	 * Returns the number of detail drives.
	 *
	 * @return the number of detail drives
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DETAILDRIVE);

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
		return "detailDriveId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DETAILDRIVE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DetailDriveModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the detail drive persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new DetailDriveModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DetailDrive.class.getName()));

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

		_finderPathWithPaginationFindByLeadsId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLeadsId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"leadsId"}, true);

		_finderPathWithoutPaginationFindByLeadsId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLeadsId",
			new String[] {Long.class.getName()}, new String[] {"leadsId"},
			true);

		_finderPathCountByLeadsId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeadsId",
			new String[] {Long.class.getName()}, new String[] {"leadsId"},
			false);

		_setDetailDriveUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDetailDriveUtilPersistence(null);

		entityCache.removeCache(DetailDriveImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setDetailDriveUtilPersistence(
		DetailDrivePersistence detailDrivePersistence) {

		try {
			Field field = DetailDriveUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, detailDrivePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MPLPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MPLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MPLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_DETAILDRIVE =
		"SELECT detailDrive FROM DetailDrive detailDrive";

	private static final String _SQL_SELECT_DETAILDRIVE_WHERE =
		"SELECT detailDrive FROM DetailDrive detailDrive WHERE ";

	private static final String _SQL_COUNT_DETAILDRIVE =
		"SELECT COUNT(detailDrive) FROM DetailDrive detailDrive";

	private static final String _SQL_COUNT_DETAILDRIVE_WHERE =
		"SELECT COUNT(detailDrive) FROM DetailDrive detailDrive WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "detailDrive.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DetailDrive exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DetailDrive exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DetailDrivePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"currency", "active"});

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

	private static class DetailDriveModelArgumentsResolver
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

			DetailDriveModelImpl detailDriveModelImpl =
				(DetailDriveModelImpl)baseModel;

			if (!checkColumn ||
				_hasModifiedColumns(detailDriveModelImpl, columnNames)) {

				return _getValue(detailDriveModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			DetailDriveModelImpl detailDriveModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = detailDriveModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = detailDriveModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static boolean _hasModifiedColumns(
			DetailDriveModelImpl detailDriveModelImpl, String[] columnNames) {

			if (columnNames.length == 0) {
				return false;
			}

			for (String columnName : columnNames) {
				if (!Objects.equals(
						detailDriveModelImpl.getColumnOriginalValue(columnName),
						detailDriveModelImpl.getColumnValue(columnName))) {

					return true;
				}
			}

			return false;
		}

	}

}