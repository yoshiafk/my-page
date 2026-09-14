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

import com.mypage.admin.product.exception.NoSuchMasterProvinceException;
import com.mypage.admin.product.model.MasterProvince;
import com.mypage.admin.product.model.impl.MasterProvinceImpl;
import com.mypage.admin.product.model.impl.MasterProvinceModelImpl;
import com.mypage.admin.product.service.persistence.MasterProvincePersistence;
import com.mypage.admin.product.service.persistence.MasterProvinceUtil;
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
 * The persistence implementation for the master province service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = MasterProvincePersistence.class)
public class MasterProvincePersistenceImpl
	extends BasePersistenceImpl<MasterProvince>
	implements MasterProvincePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MasterProvinceUtil</code> to access the master province persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MasterProvinceImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByactiveProvinces;
	private FinderPath _finderPathWithoutPaginationFindByactiveProvinces;
	private FinderPath _finderPathCountByactiveProvinces;

	/**
	 * Returns all the master provinces where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching master provinces
	 */
	@Override
	public List<MasterProvince> findByactiveProvinces(Integer active) {
		return findByactiveProvinces(
			active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master provinces where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @return the range of matching master provinces
	 */
	@Override
	public List<MasterProvince> findByactiveProvinces(
		Integer active, int start, int end) {

		return findByactiveProvinces(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master provinces where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master provinces
	 */
	@Override
	public List<MasterProvince> findByactiveProvinces(
		Integer active, int start, int end,
		OrderByComparator<MasterProvince> orderByComparator) {

		return findByactiveProvinces(
			active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master provinces where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master provinces
	 */
	@Override
	public List<MasterProvince> findByactiveProvinces(
		Integer active, int start, int end,
		OrderByComparator<MasterProvince> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByactiveProvinces;
				finderArgs = new Object[] {active};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByactiveProvinces;
			finderArgs = new Object[] {active, start, end, orderByComparator};
		}

		List<MasterProvince> list = null;

		if (useFinderCache) {
			list = (List<MasterProvince>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MasterProvince masterProvince : list) {
					if (!Objects.equals(active, masterProvince.getActive())) {
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

			sb.append(_SQL_SELECT_MASTERPROVINCE_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVEPROVINCES_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MasterProvinceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(active.intValue());

				list = (List<MasterProvince>)QueryUtil.list(
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
	 * Returns the first master province in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master province
	 * @throws NoSuchMasterProvinceException if a matching master province could not be found
	 */
	@Override
	public MasterProvince findByactiveProvinces_First(
			Integer active, OrderByComparator<MasterProvince> orderByComparator)
		throws NoSuchMasterProvinceException {

		MasterProvince masterProvince = fetchByactiveProvinces_First(
			active, orderByComparator);

		if (masterProvince != null) {
			return masterProvince;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchMasterProvinceException(sb.toString());
	}

	/**
	 * Returns the first master province in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master province, or <code>null</code> if a matching master province could not be found
	 */
	@Override
	public MasterProvince fetchByactiveProvinces_First(
		Integer active, OrderByComparator<MasterProvince> orderByComparator) {

		List<MasterProvince> list = findByactiveProvinces(
			active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master province in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master province
	 * @throws NoSuchMasterProvinceException if a matching master province could not be found
	 */
	@Override
	public MasterProvince findByactiveProvinces_Last(
			Integer active, OrderByComparator<MasterProvince> orderByComparator)
		throws NoSuchMasterProvinceException {

		MasterProvince masterProvince = fetchByactiveProvinces_Last(
			active, orderByComparator);

		if (masterProvince != null) {
			return masterProvince;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchMasterProvinceException(sb.toString());
	}

	/**
	 * Returns the last master province in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master province, or <code>null</code> if a matching master province could not be found
	 */
	@Override
	public MasterProvince fetchByactiveProvinces_Last(
		Integer active, OrderByComparator<MasterProvince> orderByComparator) {

		int count = countByactiveProvinces(active);

		if (count == 0) {
			return null;
		}

		List<MasterProvince> list = findByactiveProvinces(
			active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master provinces before and after the current master province in the ordered set where active = &#63;.
	 *
	 * @param masterProvinceId the primary key of the current master province
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master province
	 * @throws NoSuchMasterProvinceException if a master province with the primary key could not be found
	 */
	@Override
	public MasterProvince[] findByactiveProvinces_PrevAndNext(
			long masterProvinceId, Integer active,
			OrderByComparator<MasterProvince> orderByComparator)
		throws NoSuchMasterProvinceException {

		MasterProvince masterProvince = findByPrimaryKey(masterProvinceId);

		Session session = null;

		try {
			session = openSession();

			MasterProvince[] array = new MasterProvinceImpl[3];

			array[0] = getByactiveProvinces_PrevAndNext(
				session, masterProvince, active, orderByComparator, true);

			array[1] = masterProvince;

			array[2] = getByactiveProvinces_PrevAndNext(
				session, masterProvince, active, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterProvince getByactiveProvinces_PrevAndNext(
		Session session, MasterProvince masterProvince, Integer active,
		OrderByComparator<MasterProvince> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MASTERPROVINCE_WHERE);

		sb.append(_FINDER_COLUMN_ACTIVEPROVINCES_ACTIVE_2);

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
			sb.append(MasterProvinceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(active.intValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						masterProvince)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MasterProvince> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master provinces where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	@Override
	public void removeByactiveProvinces(Integer active) {
		for (MasterProvince masterProvince :
				findByactiveProvinces(
					active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(masterProvince);
		}
	}

	/**
	 * Returns the number of master provinces where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching master provinces
	 */
	@Override
	public int countByactiveProvinces(Integer active) {
		FinderPath finderPath = _finderPathCountByactiveProvinces;

		Object[] finderArgs = new Object[] {active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MASTERPROVINCE_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVEPROVINCES_ACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(active.intValue());

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

	private static final String _FINDER_COLUMN_ACTIVEPROVINCES_ACTIVE_2 =
		"masterProvince.active = ?";

	public MasterProvincePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MasterProvince.class);

		setModelImplClass(MasterProvinceImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the master province in the entity cache if it is enabled.
	 *
	 * @param masterProvince the master province
	 */
	@Override
	public void cacheResult(MasterProvince masterProvince) {
		entityCache.putResult(
			MasterProvinceImpl.class, masterProvince.getPrimaryKey(),
			masterProvince);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the master provinces in the entity cache if it is enabled.
	 *
	 * @param masterProvinces the master provinces
	 */
	@Override
	public void cacheResult(List<MasterProvince> masterProvinces) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (masterProvinces.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MasterProvince masterProvince : masterProvinces) {
			if (entityCache.getResult(
					MasterProvinceImpl.class, masterProvince.getPrimaryKey()) ==
						null) {

				cacheResult(masterProvince);
			}
		}
	}

	/**
	 * Clears the cache for all master provinces.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MasterProvinceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the master province.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MasterProvince masterProvince) {
		entityCache.removeResult(MasterProvinceImpl.class, masterProvince);
	}

	@Override
	public void clearCache(List<MasterProvince> masterProvinces) {
		for (MasterProvince masterProvince : masterProvinces) {
			entityCache.removeResult(MasterProvinceImpl.class, masterProvince);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MasterProvinceImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new master province with the primary key. Does not add the master province to the database.
	 *
	 * @param masterProvinceId the primary key for the new master province
	 * @return the new master province
	 */
	@Override
	public MasterProvince create(long masterProvinceId) {
		MasterProvince masterProvince = new MasterProvinceImpl();

		masterProvince.setNew(true);
		masterProvince.setPrimaryKey(masterProvinceId);

		masterProvince.setCompanyId(CompanyThreadLocal.getCompanyId());

		return masterProvince;
	}

	/**
	 * Removes the master province with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterProvinceId the primary key of the master province
	 * @return the master province that was removed
	 * @throws NoSuchMasterProvinceException if a master province with the primary key could not be found
	 */
	@Override
	public MasterProvince remove(long masterProvinceId)
		throws NoSuchMasterProvinceException {

		return remove((Serializable)masterProvinceId);
	}

	/**
	 * Removes the master province with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the master province
	 * @return the master province that was removed
	 * @throws NoSuchMasterProvinceException if a master province with the primary key could not be found
	 */
	@Override
	public MasterProvince remove(Serializable primaryKey)
		throws NoSuchMasterProvinceException {

		Session session = null;

		try {
			session = openSession();

			MasterProvince masterProvince = (MasterProvince)session.get(
				MasterProvinceImpl.class, primaryKey);

			if (masterProvince == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasterProvinceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(masterProvince);
		}
		catch (NoSuchMasterProvinceException noSuchEntityException) {
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
	protected MasterProvince removeImpl(MasterProvince masterProvince) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(masterProvince)) {
				masterProvince = (MasterProvince)session.get(
					MasterProvinceImpl.class,
					masterProvince.getPrimaryKeyObj());
			}

			if (masterProvince != null) {
				session.delete(masterProvince);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (masterProvince != null) {
			clearCache(masterProvince);
		}

		return masterProvince;
	}

	@Override
	public MasterProvince updateImpl(MasterProvince masterProvince) {
		boolean isNew = masterProvince.isNew();

		if (!(masterProvince instanceof MasterProvinceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(masterProvince.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					masterProvince);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in masterProvince proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MasterProvince implementation " +
					masterProvince.getClass());
		}

		MasterProvinceModelImpl masterProvinceModelImpl =
			(MasterProvinceModelImpl)masterProvince;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (masterProvince.getCreateDate() == null)) {
			if (serviceContext == null) {
				masterProvince.setCreateDate(date);
			}
			else {
				masterProvince.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!masterProvinceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				masterProvince.setModifiedDate(date);
			}
			else {
				masterProvince.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(masterProvince);
			}
			else {
				masterProvince = (MasterProvince)session.merge(masterProvince);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MasterProvinceImpl.class, masterProvinceModelImpl, false, true);

		if (isNew) {
			masterProvince.setNew(false);
		}

		masterProvince.resetOriginalValues();

		return masterProvince;
	}

	/**
	 * Returns the master province with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the master province
	 * @return the master province
	 * @throws NoSuchMasterProvinceException if a master province with the primary key could not be found
	 */
	@Override
	public MasterProvince findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMasterProvinceException {

		MasterProvince masterProvince = fetchByPrimaryKey(primaryKey);

		if (masterProvince == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasterProvinceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return masterProvince;
	}

	/**
	 * Returns the master province with the primary key or throws a <code>NoSuchMasterProvinceException</code> if it could not be found.
	 *
	 * @param masterProvinceId the primary key of the master province
	 * @return the master province
	 * @throws NoSuchMasterProvinceException if a master province with the primary key could not be found
	 */
	@Override
	public MasterProvince findByPrimaryKey(long masterProvinceId)
		throws NoSuchMasterProvinceException {

		return findByPrimaryKey((Serializable)masterProvinceId);
	}

	/**
	 * Returns the master province with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterProvinceId the primary key of the master province
	 * @return the master province, or <code>null</code> if a master province with the primary key could not be found
	 */
	@Override
	public MasterProvince fetchByPrimaryKey(long masterProvinceId) {
		return fetchByPrimaryKey((Serializable)masterProvinceId);
	}

	/**
	 * Returns all the master provinces.
	 *
	 * @return the master provinces
	 */
	@Override
	public List<MasterProvince> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master provinces.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @return the range of master provinces
	 */
	@Override
	public List<MasterProvince> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the master provinces.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master provinces
	 */
	@Override
	public List<MasterProvince> findAll(
		int start, int end,
		OrderByComparator<MasterProvince> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master provinces.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master provinces
	 */
	@Override
	public List<MasterProvince> findAll(
		int start, int end, OrderByComparator<MasterProvince> orderByComparator,
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

		List<MasterProvince> list = null;

		if (useFinderCache) {
			list = (List<MasterProvince>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MASTERPROVINCE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MASTERPROVINCE;

				sql = sql.concat(MasterProvinceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MasterProvince>)QueryUtil.list(
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
	 * Removes all the master provinces from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MasterProvince masterProvince : findAll()) {
			remove(masterProvince);
		}
	}

	/**
	 * Returns the number of master provinces.
	 *
	 * @return the number of master provinces
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MASTERPROVINCE);

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
		return "masterProvinceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MASTERPROVINCE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MasterProvinceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the master province persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new MasterProvinceModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MasterProvince.class.getName()));

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

		_finderPathWithPaginationFindByactiveProvinces = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByactiveProvinces",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"active_"}, true);

		_finderPathWithoutPaginationFindByactiveProvinces = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByactiveProvinces",
			new String[] {Integer.class.getName()}, new String[] {"active_"},
			true);

		_finderPathCountByactiveProvinces = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByactiveProvinces",
			new String[] {Integer.class.getName()}, new String[] {"active_"},
			false);

		_setMasterProvinceUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMasterProvinceUtilPersistence(null);

		entityCache.removeCache(MasterProvinceImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setMasterProvinceUtilPersistence(
		MasterProvincePersistence masterProvincePersistence) {

		try {
			Field field = MasterProvinceUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, masterProvincePersistence);
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

	private static final String _SQL_SELECT_MASTERPROVINCE =
		"SELECT masterProvince FROM MasterProvince masterProvince";

	private static final String _SQL_SELECT_MASTERPROVINCE_WHERE =
		"SELECT masterProvince FROM MasterProvince masterProvince WHERE ";

	private static final String _SQL_COUNT_MASTERPROVINCE =
		"SELECT COUNT(masterProvince) FROM MasterProvince masterProvince";

	private static final String _SQL_COUNT_MASTERPROVINCE_WHERE =
		"SELECT COUNT(masterProvince) FROM MasterProvince masterProvince WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "masterProvince.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MasterProvince exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MasterProvince exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MasterProvincePersistenceImpl.class);

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

	private static class MasterProvinceModelArgumentsResolver
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

			MasterProvinceModelImpl masterProvinceModelImpl =
				(MasterProvinceModelImpl)baseModel;

			long columnBitmask = masterProvinceModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					masterProvinceModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						masterProvinceModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(MasterProvincePersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					masterProvinceModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			MasterProvinceModelImpl masterProvinceModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						masterProvinceModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = masterProvinceModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |= MasterProvinceModelImpl.getColumnBitmask(
				"name");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}