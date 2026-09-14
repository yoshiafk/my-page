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

import com.mypage.admin.product.exception.NoSuchPetRemarksException;
import com.mypage.admin.product.model.PetRemarks;
import com.mypage.admin.product.model.impl.PetRemarksImpl;
import com.mypage.admin.product.model.impl.PetRemarksModelImpl;
import com.mypage.admin.product.service.persistence.PetRemarksPersistence;
import com.mypage.admin.product.service.persistence.PetRemarksUtil;
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
 * The persistence implementation for the pet remarks service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = PetRemarksPersistence.class)
public class PetRemarksPersistenceImpl
	extends BasePersistenceImpl<PetRemarks> implements PetRemarksPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PetRemarksUtil</code> to access the pet remarks persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PetRemarksImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByfindByName;
	private FinderPath _finderPathWithoutPaginationFindByfindByName;
	private FinderPath _finderPathCountByfindByName;

	/**
	 * Returns all the pet remarkses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching pet remarkses
	 */
	@Override
	public List<PetRemarks> findByfindByName(String name) {
		return findByfindByName(
			name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pet remarkses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @return the range of matching pet remarkses
	 */
	@Override
	public List<PetRemarks> findByfindByName(String name, int start, int end) {
		return findByfindByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pet remarkses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet remarkses
	 */
	@Override
	public List<PetRemarks> findByfindByName(
		String name, int start, int end,
		OrderByComparator<PetRemarks> orderByComparator) {

		return findByfindByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pet remarkses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet remarkses
	 */
	@Override
	public List<PetRemarks> findByfindByName(
		String name, int start, int end,
		OrderByComparator<PetRemarks> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfindByName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfindByName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<PetRemarks> list = null;

		if (useFinderCache) {
			list = (List<PetRemarks>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PetRemarks petRemarks : list) {
					if (!name.equals(petRemarks.getName())) {
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

			sb.append(_SQL_SELECT_PETREMARKS_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_FINDBYNAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PetRemarksModelImpl.ORDER_BY_JPQL);
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

				list = (List<PetRemarks>)QueryUtil.list(
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
	 * Returns the first pet remarks in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet remarks
	 * @throws NoSuchPetRemarksException if a matching pet remarks could not be found
	 */
	@Override
	public PetRemarks findByfindByName_First(
			String name, OrderByComparator<PetRemarks> orderByComparator)
		throws NoSuchPetRemarksException {

		PetRemarks petRemarks = fetchByfindByName_First(
			name, orderByComparator);

		if (petRemarks != null) {
			return petRemarks;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchPetRemarksException(sb.toString());
	}

	/**
	 * Returns the first pet remarks in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet remarks, or <code>null</code> if a matching pet remarks could not be found
	 */
	@Override
	public PetRemarks fetchByfindByName_First(
		String name, OrderByComparator<PetRemarks> orderByComparator) {

		List<PetRemarks> list = findByfindByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pet remarks in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet remarks
	 * @throws NoSuchPetRemarksException if a matching pet remarks could not be found
	 */
	@Override
	public PetRemarks findByfindByName_Last(
			String name, OrderByComparator<PetRemarks> orderByComparator)
		throws NoSuchPetRemarksException {

		PetRemarks petRemarks = fetchByfindByName_Last(name, orderByComparator);

		if (petRemarks != null) {
			return petRemarks;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchPetRemarksException(sb.toString());
	}

	/**
	 * Returns the last pet remarks in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet remarks, or <code>null</code> if a matching pet remarks could not be found
	 */
	@Override
	public PetRemarks fetchByfindByName_Last(
		String name, OrderByComparator<PetRemarks> orderByComparator) {

		int count = countByfindByName(name);

		if (count == 0) {
			return null;
		}

		List<PetRemarks> list = findByfindByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pet remarkses before and after the current pet remarks in the ordered set where name = &#63;.
	 *
	 * @param petRemarksId the primary key of the current pet remarks
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet remarks
	 * @throws NoSuchPetRemarksException if a pet remarks with the primary key could not be found
	 */
	@Override
	public PetRemarks[] findByfindByName_PrevAndNext(
			long petRemarksId, String name,
			OrderByComparator<PetRemarks> orderByComparator)
		throws NoSuchPetRemarksException {

		name = Objects.toString(name, "");

		PetRemarks petRemarks = findByPrimaryKey(petRemarksId);

		Session session = null;

		try {
			session = openSession();

			PetRemarks[] array = new PetRemarksImpl[3];

			array[0] = getByfindByName_PrevAndNext(
				session, petRemarks, name, orderByComparator, true);

			array[1] = petRemarks;

			array[2] = getByfindByName_PrevAndNext(
				session, petRemarks, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PetRemarks getByfindByName_PrevAndNext(
		Session session, PetRemarks petRemarks, String name,
		OrderByComparator<PetRemarks> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PETREMARKS_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_FINDBYNAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_FINDBYNAME_NAME_2);
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
			sb.append(PetRemarksModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(petRemarks)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PetRemarks> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pet remarkses where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByfindByName(String name) {
		for (PetRemarks petRemarks :
				findByfindByName(
					name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(petRemarks);
		}
	}

	/**
	 * Returns the number of pet remarkses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching pet remarkses
	 */
	@Override
	public int countByfindByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByfindByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PETREMARKS_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_FINDBYNAME_NAME_2);
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

	private static final String _FINDER_COLUMN_FINDBYNAME_NAME_2 =
		"petRemarks.name = ?";

	private static final String _FINDER_COLUMN_FINDBYNAME_NAME_3 =
		"(petRemarks.name IS NULL OR petRemarks.name = '')";

	public PetRemarksPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PetRemarks.class);

		setModelImplClass(PetRemarksImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the pet remarks in the entity cache if it is enabled.
	 *
	 * @param petRemarks the pet remarks
	 */
	@Override
	public void cacheResult(PetRemarks petRemarks) {
		entityCache.putResult(
			PetRemarksImpl.class, petRemarks.getPrimaryKey(), petRemarks);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the pet remarkses in the entity cache if it is enabled.
	 *
	 * @param petRemarkses the pet remarkses
	 */
	@Override
	public void cacheResult(List<PetRemarks> petRemarkses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (petRemarkses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PetRemarks petRemarks : petRemarkses) {
			if (entityCache.getResult(
					PetRemarksImpl.class, petRemarks.getPrimaryKey()) == null) {

				cacheResult(petRemarks);
			}
		}
	}

	/**
	 * Clears the cache for all pet remarkses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PetRemarksImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pet remarks.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PetRemarks petRemarks) {
		entityCache.removeResult(PetRemarksImpl.class, petRemarks);
	}

	@Override
	public void clearCache(List<PetRemarks> petRemarkses) {
		for (PetRemarks petRemarks : petRemarkses) {
			entityCache.removeResult(PetRemarksImpl.class, petRemarks);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PetRemarksImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new pet remarks with the primary key. Does not add the pet remarks to the database.
	 *
	 * @param petRemarksId the primary key for the new pet remarks
	 * @return the new pet remarks
	 */
	@Override
	public PetRemarks create(long petRemarksId) {
		PetRemarks petRemarks = new PetRemarksImpl();

		petRemarks.setNew(true);
		petRemarks.setPrimaryKey(petRemarksId);

		petRemarks.setCompanyId(CompanyThreadLocal.getCompanyId());

		return petRemarks;
	}

	/**
	 * Removes the pet remarks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petRemarksId the primary key of the pet remarks
	 * @return the pet remarks that was removed
	 * @throws NoSuchPetRemarksException if a pet remarks with the primary key could not be found
	 */
	@Override
	public PetRemarks remove(long petRemarksId)
		throws NoSuchPetRemarksException {

		return remove((Serializable)petRemarksId);
	}

	/**
	 * Removes the pet remarks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pet remarks
	 * @return the pet remarks that was removed
	 * @throws NoSuchPetRemarksException if a pet remarks with the primary key could not be found
	 */
	@Override
	public PetRemarks remove(Serializable primaryKey)
		throws NoSuchPetRemarksException {

		Session session = null;

		try {
			session = openSession();

			PetRemarks petRemarks = (PetRemarks)session.get(
				PetRemarksImpl.class, primaryKey);

			if (petRemarks == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPetRemarksException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(petRemarks);
		}
		catch (NoSuchPetRemarksException noSuchEntityException) {
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
	protected PetRemarks removeImpl(PetRemarks petRemarks) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(petRemarks)) {
				petRemarks = (PetRemarks)session.get(
					PetRemarksImpl.class, petRemarks.getPrimaryKeyObj());
			}

			if (petRemarks != null) {
				session.delete(petRemarks);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (petRemarks != null) {
			clearCache(petRemarks);
		}

		return petRemarks;
	}

	@Override
	public PetRemarks updateImpl(PetRemarks petRemarks) {
		boolean isNew = petRemarks.isNew();

		if (!(petRemarks instanceof PetRemarksModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(petRemarks.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(petRemarks);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in petRemarks proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PetRemarks implementation " +
					petRemarks.getClass());
		}

		PetRemarksModelImpl petRemarksModelImpl =
			(PetRemarksModelImpl)petRemarks;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (petRemarks.getCreateDate() == null)) {
			if (serviceContext == null) {
				petRemarks.setCreateDate(date);
			}
			else {
				petRemarks.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!petRemarksModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				petRemarks.setModifiedDate(date);
			}
			else {
				petRemarks.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(petRemarks);
			}
			else {
				petRemarks = (PetRemarks)session.merge(petRemarks);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PetRemarksImpl.class, petRemarksModelImpl, false, true);

		if (isNew) {
			petRemarks.setNew(false);
		}

		petRemarks.resetOriginalValues();

		return petRemarks;
	}

	/**
	 * Returns the pet remarks with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pet remarks
	 * @return the pet remarks
	 * @throws NoSuchPetRemarksException if a pet remarks with the primary key could not be found
	 */
	@Override
	public PetRemarks findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPetRemarksException {

		PetRemarks petRemarks = fetchByPrimaryKey(primaryKey);

		if (petRemarks == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPetRemarksException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return petRemarks;
	}

	/**
	 * Returns the pet remarks with the primary key or throws a <code>NoSuchPetRemarksException</code> if it could not be found.
	 *
	 * @param petRemarksId the primary key of the pet remarks
	 * @return the pet remarks
	 * @throws NoSuchPetRemarksException if a pet remarks with the primary key could not be found
	 */
	@Override
	public PetRemarks findByPrimaryKey(long petRemarksId)
		throws NoSuchPetRemarksException {

		return findByPrimaryKey((Serializable)petRemarksId);
	}

	/**
	 * Returns the pet remarks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petRemarksId the primary key of the pet remarks
	 * @return the pet remarks, or <code>null</code> if a pet remarks with the primary key could not be found
	 */
	@Override
	public PetRemarks fetchByPrimaryKey(long petRemarksId) {
		return fetchByPrimaryKey((Serializable)petRemarksId);
	}

	/**
	 * Returns all the pet remarkses.
	 *
	 * @return the pet remarkses
	 */
	@Override
	public List<PetRemarks> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pet remarkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @return the range of pet remarkses
	 */
	@Override
	public List<PetRemarks> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pet remarkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pet remarkses
	 */
	@Override
	public List<PetRemarks> findAll(
		int start, int end, OrderByComparator<PetRemarks> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pet remarkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pet remarkses
	 */
	@Override
	public List<PetRemarks> findAll(
		int start, int end, OrderByComparator<PetRemarks> orderByComparator,
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

		List<PetRemarks> list = null;

		if (useFinderCache) {
			list = (List<PetRemarks>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PETREMARKS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PETREMARKS;

				sql = sql.concat(PetRemarksModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PetRemarks>)QueryUtil.list(
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
	 * Removes all the pet remarkses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PetRemarks petRemarks : findAll()) {
			remove(petRemarks);
		}
	}

	/**
	 * Returns the number of pet remarkses.
	 *
	 * @return the number of pet remarkses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PETREMARKS);

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
		return "petRemarksId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PETREMARKS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PetRemarksModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pet remarks persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PetRemarksModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PetRemarks.class.getName()));

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

		_finderPathWithPaginationFindByfindByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfindByName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"name"}, true);

		_finderPathWithoutPaginationFindByfindByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfindByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByfindByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_setPetRemarksUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPetRemarksUtilPersistence(null);

		entityCache.removeCache(PetRemarksImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPetRemarksUtilPersistence(
		PetRemarksPersistence petRemarksPersistence) {

		try {
			Field field = PetRemarksUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, petRemarksPersistence);
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

	private static final String _SQL_SELECT_PETREMARKS =
		"SELECT petRemarks FROM PetRemarks petRemarks";

	private static final String _SQL_SELECT_PETREMARKS_WHERE =
		"SELECT petRemarks FROM PetRemarks petRemarks WHERE ";

	private static final String _SQL_COUNT_PETREMARKS =
		"SELECT COUNT(petRemarks) FROM PetRemarks petRemarks";

	private static final String _SQL_COUNT_PETREMARKS_WHERE =
		"SELECT COUNT(petRemarks) FROM PetRemarks petRemarks WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "petRemarks.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PetRemarks exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PetRemarks exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PetRemarksPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"code", "active"});

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

	private static class PetRemarksModelArgumentsResolver
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

			PetRemarksModelImpl petRemarksModelImpl =
				(PetRemarksModelImpl)baseModel;

			long columnBitmask = petRemarksModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(petRemarksModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						petRemarksModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(PetRemarksPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(petRemarksModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PetRemarksModelImpl petRemarksModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = petRemarksModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = petRemarksModelImpl.getColumnValue(
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

			orderByColumnsBitmask |= PetRemarksModelImpl.getColumnBitmask(
				"name");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}