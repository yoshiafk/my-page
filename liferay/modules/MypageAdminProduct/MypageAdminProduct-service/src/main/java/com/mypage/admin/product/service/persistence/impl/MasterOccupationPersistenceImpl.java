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

import com.mypage.admin.product.exception.NoSuchMasterOccupationException;
import com.mypage.admin.product.model.MasterOccupation;
import com.mypage.admin.product.model.impl.MasterOccupationImpl;
import com.mypage.admin.product.model.impl.MasterOccupationModelImpl;
import com.mypage.admin.product.service.persistence.MasterOccupationPersistence;
import com.mypage.admin.product.service.persistence.MasterOccupationUtil;
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
 * The persistence implementation for the master occupation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = MasterOccupationPersistence.class)
public class MasterOccupationPersistenceImpl
	extends BasePersistenceImpl<MasterOccupation>
	implements MasterOccupationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MasterOccupationUtil</code> to access the master occupation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MasterOccupationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBysearchByActive;
	private FinderPath _finderPathWithoutPaginationFindBysearchByActive;
	private FinderPath _finderPathCountBysearchByActive;

	/**
	 * Returns all the master occupations where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching master occupations
	 */
	@Override
	public List<MasterOccupation> findBysearchByActive(Integer active) {
		return findBysearchByActive(
			active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master occupations where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @return the range of matching master occupations
	 */
	@Override
	public List<MasterOccupation> findBysearchByActive(
		Integer active, int start, int end) {

		return findBysearchByActive(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master occupations where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master occupations
	 */
	@Override
	public List<MasterOccupation> findBysearchByActive(
		Integer active, int start, int end,
		OrderByComparator<MasterOccupation> orderByComparator) {

		return findBysearchByActive(
			active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master occupations where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master occupations
	 */
	@Override
	public List<MasterOccupation> findBysearchByActive(
		Integer active, int start, int end,
		OrderByComparator<MasterOccupation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBysearchByActive;
				finderArgs = new Object[] {active};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchByActive;
			finderArgs = new Object[] {active, start, end, orderByComparator};
		}

		List<MasterOccupation> list = null;

		if (useFinderCache) {
			list = (List<MasterOccupation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MasterOccupation masterOccupation : list) {
					if (!Objects.equals(active, masterOccupation.getActive())) {
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

			sb.append(_SQL_SELECT_MASTEROCCUPATION_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MasterOccupationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(active.intValue());

				list = (List<MasterOccupation>)QueryUtil.list(
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
	 * Returns the first master occupation in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation
	 * @throws NoSuchMasterOccupationException if a matching master occupation could not be found
	 */
	@Override
	public MasterOccupation findBysearchByActive_First(
			Integer active,
			OrderByComparator<MasterOccupation> orderByComparator)
		throws NoSuchMasterOccupationException {

		MasterOccupation masterOccupation = fetchBysearchByActive_First(
			active, orderByComparator);

		if (masterOccupation != null) {
			return masterOccupation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchMasterOccupationException(sb.toString());
	}

	/**
	 * Returns the first master occupation in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation, or <code>null</code> if a matching master occupation could not be found
	 */
	@Override
	public MasterOccupation fetchBysearchByActive_First(
		Integer active, OrderByComparator<MasterOccupation> orderByComparator) {

		List<MasterOccupation> list = findBysearchByActive(
			active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master occupation in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation
	 * @throws NoSuchMasterOccupationException if a matching master occupation could not be found
	 */
	@Override
	public MasterOccupation findBysearchByActive_Last(
			Integer active,
			OrderByComparator<MasterOccupation> orderByComparator)
		throws NoSuchMasterOccupationException {

		MasterOccupation masterOccupation = fetchBysearchByActive_Last(
			active, orderByComparator);

		if (masterOccupation != null) {
			return masterOccupation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchMasterOccupationException(sb.toString());
	}

	/**
	 * Returns the last master occupation in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation, or <code>null</code> if a matching master occupation could not be found
	 */
	@Override
	public MasterOccupation fetchBysearchByActive_Last(
		Integer active, OrderByComparator<MasterOccupation> orderByComparator) {

		int count = countBysearchByActive(active);

		if (count == 0) {
			return null;
		}

		List<MasterOccupation> list = findBysearchByActive(
			active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master occupations before and after the current master occupation in the ordered set where active = &#63;.
	 *
	 * @param masterOccupationId the primary key of the current master occupation
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master occupation
	 * @throws NoSuchMasterOccupationException if a master occupation with the primary key could not be found
	 */
	@Override
	public MasterOccupation[] findBysearchByActive_PrevAndNext(
			long masterOccupationId, Integer active,
			OrderByComparator<MasterOccupation> orderByComparator)
		throws NoSuchMasterOccupationException {

		MasterOccupation masterOccupation = findByPrimaryKey(
			masterOccupationId);

		Session session = null;

		try {
			session = openSession();

			MasterOccupation[] array = new MasterOccupationImpl[3];

			array[0] = getBysearchByActive_PrevAndNext(
				session, masterOccupation, active, orderByComparator, true);

			array[1] = masterOccupation;

			array[2] = getBysearchByActive_PrevAndNext(
				session, masterOccupation, active, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterOccupation getBysearchByActive_PrevAndNext(
		Session session, MasterOccupation masterOccupation, Integer active,
		OrderByComparator<MasterOccupation> orderByComparator,
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

		sb.append(_SQL_SELECT_MASTEROCCUPATION_WHERE);

		sb.append(_FINDER_COLUMN_SEARCHBYACTIVE_ACTIVE_2);

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
			sb.append(MasterOccupationModelImpl.ORDER_BY_JPQL);
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
						masterOccupation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MasterOccupation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master occupations where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	@Override
	public void removeBysearchByActive(Integer active) {
		for (MasterOccupation masterOccupation :
				findBysearchByActive(
					active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(masterOccupation);
		}
	}

	/**
	 * Returns the number of master occupations where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching master occupations
	 */
	@Override
	public int countBysearchByActive(Integer active) {
		FinderPath finderPath = _finderPathCountBysearchByActive;

		Object[] finderArgs = new Object[] {active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MASTEROCCUPATION_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYACTIVE_ACTIVE_2);

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

	private static final String _FINDER_COLUMN_SEARCHBYACTIVE_ACTIVE_2 =
		"masterOccupation.active = ?";

	private FinderPath
		_finderPathWithPaginationFindBysearchByMasterOccupationCategoryId;
	private FinderPath
		_finderPathWithoutPaginationFindBysearchByMasterOccupationCategoryId;
	private FinderPath _finderPathCountBysearchByMasterOccupationCategoryId;

	/**
	 * Returns all the master occupations where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @return the matching master occupations
	 */
	@Override
	public List<MasterOccupation> findBysearchByMasterOccupationCategoryId(
		long masterOccupationCategoryId) {

		return findBysearchByMasterOccupationCategoryId(
			masterOccupationCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the master occupations where masterOccupationCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @return the range of matching master occupations
	 */
	@Override
	public List<MasterOccupation> findBysearchByMasterOccupationCategoryId(
		long masterOccupationCategoryId, int start, int end) {

		return findBysearchByMasterOccupationCategoryId(
			masterOccupationCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master occupations where masterOccupationCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master occupations
	 */
	@Override
	public List<MasterOccupation> findBysearchByMasterOccupationCategoryId(
		long masterOccupationCategoryId, int start, int end,
		OrderByComparator<MasterOccupation> orderByComparator) {

		return findBysearchByMasterOccupationCategoryId(
			masterOccupationCategoryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master occupations where masterOccupationCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master occupations
	 */
	@Override
	public List<MasterOccupation> findBysearchByMasterOccupationCategoryId(
		long masterOccupationCategoryId, int start, int end,
		OrderByComparator<MasterOccupation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBysearchByMasterOccupationCategoryId;
				finderArgs = new Object[] {masterOccupationCategoryId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBysearchByMasterOccupationCategoryId;
			finderArgs = new Object[] {
				masterOccupationCategoryId, start, end, orderByComparator
			};
		}

		List<MasterOccupation> list = null;

		if (useFinderCache) {
			list = (List<MasterOccupation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MasterOccupation masterOccupation : list) {
					if (masterOccupationCategoryId !=
							masterOccupation.getMasterOccupationCategoryId()) {

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

			sb.append(_SQL_SELECT_MASTEROCCUPATION_WHERE);

			sb.append(
				_FINDER_COLUMN_SEARCHBYMASTEROCCUPATIONCATEGORYID_MASTEROCCUPATIONCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MasterOccupationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(masterOccupationCategoryId);

				list = (List<MasterOccupation>)QueryUtil.list(
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
	 * Returns the first master occupation in the ordered set where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation
	 * @throws NoSuchMasterOccupationException if a matching master occupation could not be found
	 */
	@Override
	public MasterOccupation findBysearchByMasterOccupationCategoryId_First(
			long masterOccupationCategoryId,
			OrderByComparator<MasterOccupation> orderByComparator)
		throws NoSuchMasterOccupationException {

		MasterOccupation masterOccupation =
			fetchBysearchByMasterOccupationCategoryId_First(
				masterOccupationCategoryId, orderByComparator);

		if (masterOccupation != null) {
			return masterOccupation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("masterOccupationCategoryId=");
		sb.append(masterOccupationCategoryId);

		sb.append("}");

		throw new NoSuchMasterOccupationException(sb.toString());
	}

	/**
	 * Returns the first master occupation in the ordered set where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation, or <code>null</code> if a matching master occupation could not be found
	 */
	@Override
	public MasterOccupation fetchBysearchByMasterOccupationCategoryId_First(
		long masterOccupationCategoryId,
		OrderByComparator<MasterOccupation> orderByComparator) {

		List<MasterOccupation> list = findBysearchByMasterOccupationCategoryId(
			masterOccupationCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master occupation in the ordered set where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation
	 * @throws NoSuchMasterOccupationException if a matching master occupation could not be found
	 */
	@Override
	public MasterOccupation findBysearchByMasterOccupationCategoryId_Last(
			long masterOccupationCategoryId,
			OrderByComparator<MasterOccupation> orderByComparator)
		throws NoSuchMasterOccupationException {

		MasterOccupation masterOccupation =
			fetchBysearchByMasterOccupationCategoryId_Last(
				masterOccupationCategoryId, orderByComparator);

		if (masterOccupation != null) {
			return masterOccupation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("masterOccupationCategoryId=");
		sb.append(masterOccupationCategoryId);

		sb.append("}");

		throw new NoSuchMasterOccupationException(sb.toString());
	}

	/**
	 * Returns the last master occupation in the ordered set where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation, or <code>null</code> if a matching master occupation could not be found
	 */
	@Override
	public MasterOccupation fetchBysearchByMasterOccupationCategoryId_Last(
		long masterOccupationCategoryId,
		OrderByComparator<MasterOccupation> orderByComparator) {

		int count = countBysearchByMasterOccupationCategoryId(
			masterOccupationCategoryId);

		if (count == 0) {
			return null;
		}

		List<MasterOccupation> list = findBysearchByMasterOccupationCategoryId(
			masterOccupationCategoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master occupations before and after the current master occupation in the ordered set where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationId the primary key of the current master occupation
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master occupation
	 * @throws NoSuchMasterOccupationException if a master occupation with the primary key could not be found
	 */
	@Override
	public MasterOccupation[]
			findBysearchByMasterOccupationCategoryId_PrevAndNext(
				long masterOccupationId, long masterOccupationCategoryId,
				OrderByComparator<MasterOccupation> orderByComparator)
		throws NoSuchMasterOccupationException {

		MasterOccupation masterOccupation = findByPrimaryKey(
			masterOccupationId);

		Session session = null;

		try {
			session = openSession();

			MasterOccupation[] array = new MasterOccupationImpl[3];

			array[0] = getBysearchByMasterOccupationCategoryId_PrevAndNext(
				session, masterOccupation, masterOccupationCategoryId,
				orderByComparator, true);

			array[1] = masterOccupation;

			array[2] = getBysearchByMasterOccupationCategoryId_PrevAndNext(
				session, masterOccupation, masterOccupationCategoryId,
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

	protected MasterOccupation
		getBysearchByMasterOccupationCategoryId_PrevAndNext(
			Session session, MasterOccupation masterOccupation,
			long masterOccupationCategoryId,
			OrderByComparator<MasterOccupation> orderByComparator,
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

		sb.append(_SQL_SELECT_MASTEROCCUPATION_WHERE);

		sb.append(
			_FINDER_COLUMN_SEARCHBYMASTEROCCUPATIONCATEGORYID_MASTEROCCUPATIONCATEGORYID_2);

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
			sb.append(MasterOccupationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(masterOccupationCategoryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						masterOccupation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MasterOccupation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master occupations where masterOccupationCategoryId = &#63; from the database.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 */
	@Override
	public void removeBysearchByMasterOccupationCategoryId(
		long masterOccupationCategoryId) {

		for (MasterOccupation masterOccupation :
				findBysearchByMasterOccupationCategoryId(
					masterOccupationCategoryId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(masterOccupation);
		}
	}

	/**
	 * Returns the number of master occupations where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @return the number of matching master occupations
	 */
	@Override
	public int countBysearchByMasterOccupationCategoryId(
		long masterOccupationCategoryId) {

		FinderPath finderPath =
			_finderPathCountBysearchByMasterOccupationCategoryId;

		Object[] finderArgs = new Object[] {masterOccupationCategoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MASTEROCCUPATION_WHERE);

			sb.append(
				_FINDER_COLUMN_SEARCHBYMASTEROCCUPATIONCATEGORYID_MASTEROCCUPATIONCATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(masterOccupationCategoryId);

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
		_FINDER_COLUMN_SEARCHBYMASTEROCCUPATIONCATEGORYID_MASTEROCCUPATIONCATEGORYID_2 =
			"masterOccupation.masterOccupationCategoryId = ? AND masterOccupation.active=1";

	public MasterOccupationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MasterOccupation.class);

		setModelImplClass(MasterOccupationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the master occupation in the entity cache if it is enabled.
	 *
	 * @param masterOccupation the master occupation
	 */
	@Override
	public void cacheResult(MasterOccupation masterOccupation) {
		entityCache.putResult(
			MasterOccupationImpl.class, masterOccupation.getPrimaryKey(),
			masterOccupation);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the master occupations in the entity cache if it is enabled.
	 *
	 * @param masterOccupations the master occupations
	 */
	@Override
	public void cacheResult(List<MasterOccupation> masterOccupations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (masterOccupations.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MasterOccupation masterOccupation : masterOccupations) {
			if (entityCache.getResult(
					MasterOccupationImpl.class,
					masterOccupation.getPrimaryKey()) == null) {

				cacheResult(masterOccupation);
			}
		}
	}

	/**
	 * Clears the cache for all master occupations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MasterOccupationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the master occupation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MasterOccupation masterOccupation) {
		entityCache.removeResult(MasterOccupationImpl.class, masterOccupation);
	}

	@Override
	public void clearCache(List<MasterOccupation> masterOccupations) {
		for (MasterOccupation masterOccupation : masterOccupations) {
			entityCache.removeResult(
				MasterOccupationImpl.class, masterOccupation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MasterOccupationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new master occupation with the primary key. Does not add the master occupation to the database.
	 *
	 * @param masterOccupationId the primary key for the new master occupation
	 * @return the new master occupation
	 */
	@Override
	public MasterOccupation create(long masterOccupationId) {
		MasterOccupation masterOccupation = new MasterOccupationImpl();

		masterOccupation.setNew(true);
		masterOccupation.setPrimaryKey(masterOccupationId);

		masterOccupation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return masterOccupation;
	}

	/**
	 * Removes the master occupation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterOccupationId the primary key of the master occupation
	 * @return the master occupation that was removed
	 * @throws NoSuchMasterOccupationException if a master occupation with the primary key could not be found
	 */
	@Override
	public MasterOccupation remove(long masterOccupationId)
		throws NoSuchMasterOccupationException {

		return remove((Serializable)masterOccupationId);
	}

	/**
	 * Removes the master occupation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the master occupation
	 * @return the master occupation that was removed
	 * @throws NoSuchMasterOccupationException if a master occupation with the primary key could not be found
	 */
	@Override
	public MasterOccupation remove(Serializable primaryKey)
		throws NoSuchMasterOccupationException {

		Session session = null;

		try {
			session = openSession();

			MasterOccupation masterOccupation = (MasterOccupation)session.get(
				MasterOccupationImpl.class, primaryKey);

			if (masterOccupation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasterOccupationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(masterOccupation);
		}
		catch (NoSuchMasterOccupationException noSuchEntityException) {
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
	protected MasterOccupation removeImpl(MasterOccupation masterOccupation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(masterOccupation)) {
				masterOccupation = (MasterOccupation)session.get(
					MasterOccupationImpl.class,
					masterOccupation.getPrimaryKeyObj());
			}

			if (masterOccupation != null) {
				session.delete(masterOccupation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (masterOccupation != null) {
			clearCache(masterOccupation);
		}

		return masterOccupation;
	}

	@Override
	public MasterOccupation updateImpl(MasterOccupation masterOccupation) {
		boolean isNew = masterOccupation.isNew();

		if (!(masterOccupation instanceof MasterOccupationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(masterOccupation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					masterOccupation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in masterOccupation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MasterOccupation implementation " +
					masterOccupation.getClass());
		}

		MasterOccupationModelImpl masterOccupationModelImpl =
			(MasterOccupationModelImpl)masterOccupation;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (masterOccupation.getCreateDate() == null)) {
			if (serviceContext == null) {
				masterOccupation.setCreateDate(date);
			}
			else {
				masterOccupation.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!masterOccupationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				masterOccupation.setModifiedDate(date);
			}
			else {
				masterOccupation.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(masterOccupation);
			}
			else {
				masterOccupation = (MasterOccupation)session.merge(
					masterOccupation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MasterOccupationImpl.class, masterOccupationModelImpl, false, true);

		if (isNew) {
			masterOccupation.setNew(false);
		}

		masterOccupation.resetOriginalValues();

		return masterOccupation;
	}

	/**
	 * Returns the master occupation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the master occupation
	 * @return the master occupation
	 * @throws NoSuchMasterOccupationException if a master occupation with the primary key could not be found
	 */
	@Override
	public MasterOccupation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMasterOccupationException {

		MasterOccupation masterOccupation = fetchByPrimaryKey(primaryKey);

		if (masterOccupation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasterOccupationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return masterOccupation;
	}

	/**
	 * Returns the master occupation with the primary key or throws a <code>NoSuchMasterOccupationException</code> if it could not be found.
	 *
	 * @param masterOccupationId the primary key of the master occupation
	 * @return the master occupation
	 * @throws NoSuchMasterOccupationException if a master occupation with the primary key could not be found
	 */
	@Override
	public MasterOccupation findByPrimaryKey(long masterOccupationId)
		throws NoSuchMasterOccupationException {

		return findByPrimaryKey((Serializable)masterOccupationId);
	}

	/**
	 * Returns the master occupation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterOccupationId the primary key of the master occupation
	 * @return the master occupation, or <code>null</code> if a master occupation with the primary key could not be found
	 */
	@Override
	public MasterOccupation fetchByPrimaryKey(long masterOccupationId) {
		return fetchByPrimaryKey((Serializable)masterOccupationId);
	}

	/**
	 * Returns all the master occupations.
	 *
	 * @return the master occupations
	 */
	@Override
	public List<MasterOccupation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @return the range of master occupations
	 */
	@Override
	public List<MasterOccupation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the master occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master occupations
	 */
	@Override
	public List<MasterOccupation> findAll(
		int start, int end,
		OrderByComparator<MasterOccupation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master occupations
	 */
	@Override
	public List<MasterOccupation> findAll(
		int start, int end,
		OrderByComparator<MasterOccupation> orderByComparator,
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

		List<MasterOccupation> list = null;

		if (useFinderCache) {
			list = (List<MasterOccupation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MASTEROCCUPATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MASTEROCCUPATION;

				sql = sql.concat(MasterOccupationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MasterOccupation>)QueryUtil.list(
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
	 * Removes all the master occupations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MasterOccupation masterOccupation : findAll()) {
			remove(masterOccupation);
		}
	}

	/**
	 * Returns the number of master occupations.
	 *
	 * @return the number of master occupations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MASTEROCCUPATION);

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
		return "masterOccupationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MASTEROCCUPATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MasterOccupationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the master occupation persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new MasterOccupationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MasterOccupation.class.getName()));

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

		_finderPathWithPaginationFindBysearchByActive = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchByActive",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"active_"}, true);

		_finderPathWithoutPaginationFindBysearchByActive = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysearchByActive",
			new String[] {Integer.class.getName()}, new String[] {"active_"},
			true);

		_finderPathCountBysearchByActive = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchByActive",
			new String[] {Integer.class.getName()}, new String[] {"active_"},
			false);

		_finderPathWithPaginationFindBysearchByMasterOccupationCategoryId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBysearchByMasterOccupationCategoryId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"masterOccupationCategoryId"}, true);

		_finderPathWithoutPaginationFindBysearchByMasterOccupationCategoryId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBysearchByMasterOccupationCategoryId",
				new String[] {Long.class.getName()},
				new String[] {"masterOccupationCategoryId"}, true);

		_finderPathCountBysearchByMasterOccupationCategoryId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countBysearchByMasterOccupationCategoryId",
				new String[] {Long.class.getName()},
				new String[] {"masterOccupationCategoryId"}, false);

		_setMasterOccupationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMasterOccupationUtilPersistence(null);

		entityCache.removeCache(MasterOccupationImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setMasterOccupationUtilPersistence(
		MasterOccupationPersistence masterOccupationPersistence) {

		try {
			Field field = MasterOccupationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, masterOccupationPersistence);
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

	private static final String _SQL_SELECT_MASTEROCCUPATION =
		"SELECT masterOccupation FROM MasterOccupation masterOccupation";

	private static final String _SQL_SELECT_MASTEROCCUPATION_WHERE =
		"SELECT masterOccupation FROM MasterOccupation masterOccupation WHERE ";

	private static final String _SQL_COUNT_MASTEROCCUPATION =
		"SELECT COUNT(masterOccupation) FROM MasterOccupation masterOccupation";

	private static final String _SQL_COUNT_MASTEROCCUPATION_WHERE =
		"SELECT COUNT(masterOccupation) FROM MasterOccupation masterOccupation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "masterOccupation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MasterOccupation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MasterOccupation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MasterOccupationPersistenceImpl.class);

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

	private static class MasterOccupationModelArgumentsResolver
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

			MasterOccupationModelImpl masterOccupationModelImpl =
				(MasterOccupationModelImpl)baseModel;

			long columnBitmask = masterOccupationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					masterOccupationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						masterOccupationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					masterOccupationModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			MasterOccupationModelImpl masterOccupationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						masterOccupationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = masterOccupationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}