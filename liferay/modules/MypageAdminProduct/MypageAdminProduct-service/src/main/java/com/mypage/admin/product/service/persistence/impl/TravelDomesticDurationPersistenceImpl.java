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

import com.mypage.admin.product.exception.NoSuchTravelDomesticDurationException;
import com.mypage.admin.product.model.TravelDomesticDuration;
import com.mypage.admin.product.model.impl.TravelDomesticDurationImpl;
import com.mypage.admin.product.model.impl.TravelDomesticDurationModelImpl;
import com.mypage.admin.product.service.persistence.TravelDomesticDurationPersistence;
import com.mypage.admin.product.service.persistence.TravelDomesticDurationUtil;
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
 * The persistence implementation for the travel domestic duration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = TravelDomesticDurationPersistence.class)
public class TravelDomesticDurationPersistenceImpl
	extends BasePersistenceImpl<TravelDomesticDuration>
	implements TravelDomesticDurationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TravelDomesticDurationUtil</code> to access the travel domestic duration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TravelDomesticDurationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBysearchDuration;
	private FinderPath _finderPathWithoutPaginationFindBysearchDuration;
	private FinderPath _finderPathCountBysearchDuration;

	/**
	 * Returns all the travel domestic durations where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @return the matching travel domestic durations
	 */
	@Override
	public List<TravelDomesticDuration> findBysearchDuration(
		long travelDomesticDurationId, String code, int dayFrom, int dayTo,
		String label) {

		return findBysearchDuration(
			travelDomesticDurationId, code, dayFrom, dayTo, label,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel domestic durations where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticDurationModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @param start the lower bound of the range of travel domestic durations
	 * @param end the upper bound of the range of travel domestic durations (not inclusive)
	 * @return the range of matching travel domestic durations
	 */
	@Override
	public List<TravelDomesticDuration> findBysearchDuration(
		long travelDomesticDurationId, String code, int dayFrom, int dayTo,
		String label, int start, int end) {

		return findBysearchDuration(
			travelDomesticDurationId, code, dayFrom, dayTo, label, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the travel domestic durations where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticDurationModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @param start the lower bound of the range of travel domestic durations
	 * @param end the upper bound of the range of travel domestic durations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic durations
	 */
	@Override
	public List<TravelDomesticDuration> findBysearchDuration(
		long travelDomesticDurationId, String code, int dayFrom, int dayTo,
		String label, int start, int end,
		OrderByComparator<TravelDomesticDuration> orderByComparator) {

		return findBysearchDuration(
			travelDomesticDurationId, code, dayFrom, dayTo, label, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic durations where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticDurationModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @param start the lower bound of the range of travel domestic durations
	 * @param end the upper bound of the range of travel domestic durations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic durations
	 */
	@Override
	public List<TravelDomesticDuration> findBysearchDuration(
		long travelDomesticDurationId, String code, int dayFrom, int dayTo,
		String label, int start, int end,
		OrderByComparator<TravelDomesticDuration> orderByComparator,
		boolean useFinderCache) {

		code = Objects.toString(code, "");
		label = Objects.toString(label, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBysearchDuration;
				finderArgs = new Object[] {
					travelDomesticDurationId, code, dayFrom, dayTo, label
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchDuration;
			finderArgs = new Object[] {
				travelDomesticDurationId, code, dayFrom, dayTo, label, start,
				end, orderByComparator
			};
		}

		List<TravelDomesticDuration> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticDuration>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelDomesticDuration travelDomesticDuration : list) {
					if ((travelDomesticDurationId !=
							travelDomesticDuration.
								getTravelDomesticDurationId()) ||
						!code.equals(travelDomesticDuration.getCode()) ||
						(dayFrom != travelDomesticDuration.getDayFrom()) ||
						(dayTo != travelDomesticDuration.getDayTo()) ||
						!label.equals(travelDomesticDuration.getLabel())) {

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
					7 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(7);
			}

			sb.append(_SQL_SELECT_TRAVELDOMESTICDURATION_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHDURATION_TRAVELDOMESTICDURATIONID_2);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHDURATION_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_SEARCHDURATION_CODE_2);
			}

			sb.append(_FINDER_COLUMN_SEARCHDURATION_DAYFROM_2);

			sb.append(_FINDER_COLUMN_SEARCHDURATION_DAYTO_2);

			boolean bindLabel = false;

			if (label.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHDURATION_LABEL_3);
			}
			else {
				bindLabel = true;

				sb.append(_FINDER_COLUMN_SEARCHDURATION_LABEL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelDomesticDurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(travelDomesticDurationId);

				if (bindCode) {
					queryPos.add(code);
				}

				queryPos.add(dayFrom);

				queryPos.add(dayTo);

				if (bindLabel) {
					queryPos.add(label);
				}

				list = (List<TravelDomesticDuration>)QueryUtil.list(
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
	 * Returns the first travel domestic duration in the ordered set where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic duration
	 * @throws NoSuchTravelDomesticDurationException if a matching travel domestic duration could not be found
	 */
	@Override
	public TravelDomesticDuration findBysearchDuration_First(
			long travelDomesticDurationId, String code, int dayFrom, int dayTo,
			String label,
			OrderByComparator<TravelDomesticDuration> orderByComparator)
		throws NoSuchTravelDomesticDurationException {

		TravelDomesticDuration travelDomesticDuration =
			fetchBysearchDuration_First(
				travelDomesticDurationId, code, dayFrom, dayTo, label,
				orderByComparator);

		if (travelDomesticDuration != null) {
			return travelDomesticDuration;
		}

		StringBundler sb = new StringBundler(12);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelDomesticDurationId=");
		sb.append(travelDomesticDurationId);

		sb.append(", code=");
		sb.append(code);

		sb.append(", dayFrom=");
		sb.append(dayFrom);

		sb.append(", dayTo=");
		sb.append(dayTo);

		sb.append(", label=");
		sb.append(label);

		sb.append("}");

		throw new NoSuchTravelDomesticDurationException(sb.toString());
	}

	/**
	 * Returns the first travel domestic duration in the ordered set where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic duration, or <code>null</code> if a matching travel domestic duration could not be found
	 */
	@Override
	public TravelDomesticDuration fetchBysearchDuration_First(
		long travelDomesticDurationId, String code, int dayFrom, int dayTo,
		String label,
		OrderByComparator<TravelDomesticDuration> orderByComparator) {

		List<TravelDomesticDuration> list = findBysearchDuration(
			travelDomesticDurationId, code, dayFrom, dayTo, label, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel domestic duration in the ordered set where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic duration
	 * @throws NoSuchTravelDomesticDurationException if a matching travel domestic duration could not be found
	 */
	@Override
	public TravelDomesticDuration findBysearchDuration_Last(
			long travelDomesticDurationId, String code, int dayFrom, int dayTo,
			String label,
			OrderByComparator<TravelDomesticDuration> orderByComparator)
		throws NoSuchTravelDomesticDurationException {

		TravelDomesticDuration travelDomesticDuration =
			fetchBysearchDuration_Last(
				travelDomesticDurationId, code, dayFrom, dayTo, label,
				orderByComparator);

		if (travelDomesticDuration != null) {
			return travelDomesticDuration;
		}

		StringBundler sb = new StringBundler(12);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelDomesticDurationId=");
		sb.append(travelDomesticDurationId);

		sb.append(", code=");
		sb.append(code);

		sb.append(", dayFrom=");
		sb.append(dayFrom);

		sb.append(", dayTo=");
		sb.append(dayTo);

		sb.append(", label=");
		sb.append(label);

		sb.append("}");

		throw new NoSuchTravelDomesticDurationException(sb.toString());
	}

	/**
	 * Returns the last travel domestic duration in the ordered set where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic duration, or <code>null</code> if a matching travel domestic duration could not be found
	 */
	@Override
	public TravelDomesticDuration fetchBysearchDuration_Last(
		long travelDomesticDurationId, String code, int dayFrom, int dayTo,
		String label,
		OrderByComparator<TravelDomesticDuration> orderByComparator) {

		int count = countBysearchDuration(
			travelDomesticDurationId, code, dayFrom, dayTo, label);

		if (count == 0) {
			return null;
		}

		List<TravelDomesticDuration> list = findBysearchDuration(
			travelDomesticDurationId, code, dayFrom, dayTo, label, count - 1,
			count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the travel domestic durations where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63; from the database.
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 */
	@Override
	public void removeBysearchDuration(
		long travelDomesticDurationId, String code, int dayFrom, int dayTo,
		String label) {

		for (TravelDomesticDuration travelDomesticDuration :
				findBysearchDuration(
					travelDomesticDurationId, code, dayFrom, dayTo, label,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(travelDomesticDuration);
		}
	}

	/**
	 * Returns the number of travel domestic durations where travelDomesticDurationId = &#63; and code = &#63; and dayFrom = &#63; and dayTo = &#63; and label = &#63;.
	 *
	 * @param travelDomesticDurationId the travel domestic duration ID
	 * @param code the code
	 * @param dayFrom the day from
	 * @param dayTo the day to
	 * @param label the label
	 * @return the number of matching travel domestic durations
	 */
	@Override
	public int countBysearchDuration(
		long travelDomesticDurationId, String code, int dayFrom, int dayTo,
		String label) {

		code = Objects.toString(code, "");
		label = Objects.toString(label, "");

		FinderPath finderPath = _finderPathCountBysearchDuration;

		Object[] finderArgs = new Object[] {
			travelDomesticDurationId, code, dayFrom, dayTo, label
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_COUNT_TRAVELDOMESTICDURATION_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHDURATION_TRAVELDOMESTICDURATIONID_2);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHDURATION_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_SEARCHDURATION_CODE_2);
			}

			sb.append(_FINDER_COLUMN_SEARCHDURATION_DAYFROM_2);

			sb.append(_FINDER_COLUMN_SEARCHDURATION_DAYTO_2);

			boolean bindLabel = false;

			if (label.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHDURATION_LABEL_3);
			}
			else {
				bindLabel = true;

				sb.append(_FINDER_COLUMN_SEARCHDURATION_LABEL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(travelDomesticDurationId);

				if (bindCode) {
					queryPos.add(code);
				}

				queryPos.add(dayFrom);

				queryPos.add(dayTo);

				if (bindLabel) {
					queryPos.add(label);
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

	private static final String
		_FINDER_COLUMN_SEARCHDURATION_TRAVELDOMESTICDURATIONID_2 =
			"travelDomesticDuration.travelDomesticDurationId = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHDURATION_CODE_2 =
		"travelDomesticDuration.code = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHDURATION_CODE_3 =
		"(travelDomesticDuration.code IS NULL OR travelDomesticDuration.code = '') AND ";

	private static final String _FINDER_COLUMN_SEARCHDURATION_DAYFROM_2 =
		"travelDomesticDuration.dayFrom = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHDURATION_DAYTO_2 =
		"travelDomesticDuration.dayTo = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHDURATION_LABEL_2 =
		"travelDomesticDuration.label = ?";

	private static final String _FINDER_COLUMN_SEARCHDURATION_LABEL_3 =
		"(travelDomesticDuration.label IS NULL OR travelDomesticDuration.label = '')";

	public TravelDomesticDurationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TravelDomesticDuration.class);

		setModelImplClass(TravelDomesticDurationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the travel domestic duration in the entity cache if it is enabled.
	 *
	 * @param travelDomesticDuration the travel domestic duration
	 */
	@Override
	public void cacheResult(TravelDomesticDuration travelDomesticDuration) {
		entityCache.putResult(
			TravelDomesticDurationImpl.class,
			travelDomesticDuration.getPrimaryKey(), travelDomesticDuration);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the travel domestic durations in the entity cache if it is enabled.
	 *
	 * @param travelDomesticDurations the travel domestic durations
	 */
	@Override
	public void cacheResult(
		List<TravelDomesticDuration> travelDomesticDurations) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (travelDomesticDurations.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TravelDomesticDuration travelDomesticDuration :
				travelDomesticDurations) {

			if (entityCache.getResult(
					TravelDomesticDurationImpl.class,
					travelDomesticDuration.getPrimaryKey()) == null) {

				cacheResult(travelDomesticDuration);
			}
		}
	}

	/**
	 * Clears the cache for all travel domestic durations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TravelDomesticDurationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the travel domestic duration.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TravelDomesticDuration travelDomesticDuration) {
		entityCache.removeResult(
			TravelDomesticDurationImpl.class, travelDomesticDuration);
	}

	@Override
	public void clearCache(
		List<TravelDomesticDuration> travelDomesticDurations) {

		for (TravelDomesticDuration travelDomesticDuration :
				travelDomesticDurations) {

			entityCache.removeResult(
				TravelDomesticDurationImpl.class, travelDomesticDuration);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				TravelDomesticDurationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new travel domestic duration with the primary key. Does not add the travel domestic duration to the database.
	 *
	 * @param travelDomesticDurationId the primary key for the new travel domestic duration
	 * @return the new travel domestic duration
	 */
	@Override
	public TravelDomesticDuration create(long travelDomesticDurationId) {
		TravelDomesticDuration travelDomesticDuration =
			new TravelDomesticDurationImpl();

		travelDomesticDuration.setNew(true);
		travelDomesticDuration.setPrimaryKey(travelDomesticDurationId);

		travelDomesticDuration.setCompanyId(CompanyThreadLocal.getCompanyId());

		return travelDomesticDuration;
	}

	/**
	 * Removes the travel domestic duration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticDurationId the primary key of the travel domestic duration
	 * @return the travel domestic duration that was removed
	 * @throws NoSuchTravelDomesticDurationException if a travel domestic duration with the primary key could not be found
	 */
	@Override
	public TravelDomesticDuration remove(long travelDomesticDurationId)
		throws NoSuchTravelDomesticDurationException {

		return remove((Serializable)travelDomesticDurationId);
	}

	/**
	 * Removes the travel domestic duration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the travel domestic duration
	 * @return the travel domestic duration that was removed
	 * @throws NoSuchTravelDomesticDurationException if a travel domestic duration with the primary key could not be found
	 */
	@Override
	public TravelDomesticDuration remove(Serializable primaryKey)
		throws NoSuchTravelDomesticDurationException {

		Session session = null;

		try {
			session = openSession();

			TravelDomesticDuration travelDomesticDuration =
				(TravelDomesticDuration)session.get(
					TravelDomesticDurationImpl.class, primaryKey);

			if (travelDomesticDuration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTravelDomesticDurationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(travelDomesticDuration);
		}
		catch (NoSuchTravelDomesticDurationException noSuchEntityException) {
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
	protected TravelDomesticDuration removeImpl(
		TravelDomesticDuration travelDomesticDuration) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(travelDomesticDuration)) {
				travelDomesticDuration = (TravelDomesticDuration)session.get(
					TravelDomesticDurationImpl.class,
					travelDomesticDuration.getPrimaryKeyObj());
			}

			if (travelDomesticDuration != null) {
				session.delete(travelDomesticDuration);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (travelDomesticDuration != null) {
			clearCache(travelDomesticDuration);
		}

		return travelDomesticDuration;
	}

	@Override
	public TravelDomesticDuration updateImpl(
		TravelDomesticDuration travelDomesticDuration) {

		boolean isNew = travelDomesticDuration.isNew();

		if (!(travelDomesticDuration instanceof
				TravelDomesticDurationModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(travelDomesticDuration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					travelDomesticDuration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in travelDomesticDuration proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TravelDomesticDuration implementation " +
					travelDomesticDuration.getClass());
		}

		TravelDomesticDurationModelImpl travelDomesticDurationModelImpl =
			(TravelDomesticDurationModelImpl)travelDomesticDuration;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (travelDomesticDuration.getCreateDate() == null)) {
			if (serviceContext == null) {
				travelDomesticDuration.setCreateDate(date);
			}
			else {
				travelDomesticDuration.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!travelDomesticDurationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				travelDomesticDuration.setModifiedDate(date);
			}
			else {
				travelDomesticDuration.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(travelDomesticDuration);
			}
			else {
				travelDomesticDuration = (TravelDomesticDuration)session.merge(
					travelDomesticDuration);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TravelDomesticDurationImpl.class, travelDomesticDurationModelImpl,
			false, true);

		if (isNew) {
			travelDomesticDuration.setNew(false);
		}

		travelDomesticDuration.resetOriginalValues();

		return travelDomesticDuration;
	}

	/**
	 * Returns the travel domestic duration with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the travel domestic duration
	 * @return the travel domestic duration
	 * @throws NoSuchTravelDomesticDurationException if a travel domestic duration with the primary key could not be found
	 */
	@Override
	public TravelDomesticDuration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTravelDomesticDurationException {

		TravelDomesticDuration travelDomesticDuration = fetchByPrimaryKey(
			primaryKey);

		if (travelDomesticDuration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTravelDomesticDurationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return travelDomesticDuration;
	}

	/**
	 * Returns the travel domestic duration with the primary key or throws a <code>NoSuchTravelDomesticDurationException</code> if it could not be found.
	 *
	 * @param travelDomesticDurationId the primary key of the travel domestic duration
	 * @return the travel domestic duration
	 * @throws NoSuchTravelDomesticDurationException if a travel domestic duration with the primary key could not be found
	 */
	@Override
	public TravelDomesticDuration findByPrimaryKey(
			long travelDomesticDurationId)
		throws NoSuchTravelDomesticDurationException {

		return findByPrimaryKey((Serializable)travelDomesticDurationId);
	}

	/**
	 * Returns the travel domestic duration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticDurationId the primary key of the travel domestic duration
	 * @return the travel domestic duration, or <code>null</code> if a travel domestic duration with the primary key could not be found
	 */
	@Override
	public TravelDomesticDuration fetchByPrimaryKey(
		long travelDomesticDurationId) {

		return fetchByPrimaryKey((Serializable)travelDomesticDurationId);
	}

	/**
	 * Returns all the travel domestic durations.
	 *
	 * @return the travel domestic durations
	 */
	@Override
	public List<TravelDomesticDuration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel domestic durations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticDurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic durations
	 * @param end the upper bound of the range of travel domestic durations (not inclusive)
	 * @return the range of travel domestic durations
	 */
	@Override
	public List<TravelDomesticDuration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel domestic durations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticDurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic durations
	 * @param end the upper bound of the range of travel domestic durations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic durations
	 */
	@Override
	public List<TravelDomesticDuration> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticDuration> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic durations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticDurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic durations
	 * @param end the upper bound of the range of travel domestic durations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic durations
	 */
	@Override
	public List<TravelDomesticDuration> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticDuration> orderByComparator,
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

		List<TravelDomesticDuration> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticDuration>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAVELDOMESTICDURATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAVELDOMESTICDURATION;

				sql = sql.concat(TravelDomesticDurationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TravelDomesticDuration>)QueryUtil.list(
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
	 * Removes all the travel domestic durations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TravelDomesticDuration travelDomesticDuration : findAll()) {
			remove(travelDomesticDuration);
		}
	}

	/**
	 * Returns the number of travel domestic durations.
	 *
	 * @return the number of travel domestic durations
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
					_SQL_COUNT_TRAVELDOMESTICDURATION);

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
		return "travelDomesticDurationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAVELDOMESTICDURATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TravelDomesticDurationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the travel domestic duration persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new TravelDomesticDurationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", TravelDomesticDuration.class.getName()));

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

		_finderPathWithPaginationFindBysearchDuration = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchDuration",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {
				"travelDomesticDurationId", "code_", "dayFrom", "dayTo", "label"
			},
			true);

		_finderPathWithoutPaginationFindBysearchDuration = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysearchDuration",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				String.class.getName()
			},
			new String[] {
				"travelDomesticDurationId", "code_", "dayFrom", "dayTo", "label"
			},
			true);

		_finderPathCountBysearchDuration = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchDuration",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				String.class.getName()
			},
			new String[] {
				"travelDomesticDurationId", "code_", "dayFrom", "dayTo", "label"
			},
			false);

		_setTravelDomesticDurationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTravelDomesticDurationUtilPersistence(null);

		entityCache.removeCache(TravelDomesticDurationImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setTravelDomesticDurationUtilPersistence(
		TravelDomesticDurationPersistence travelDomesticDurationPersistence) {

		try {
			Field field = TravelDomesticDurationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, travelDomesticDurationPersistence);
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

	private static final String _SQL_SELECT_TRAVELDOMESTICDURATION =
		"SELECT travelDomesticDuration FROM TravelDomesticDuration travelDomesticDuration";

	private static final String _SQL_SELECT_TRAVELDOMESTICDURATION_WHERE =
		"SELECT travelDomesticDuration FROM TravelDomesticDuration travelDomesticDuration WHERE ";

	private static final String _SQL_COUNT_TRAVELDOMESTICDURATION =
		"SELECT COUNT(travelDomesticDuration) FROM TravelDomesticDuration travelDomesticDuration";

	private static final String _SQL_COUNT_TRAVELDOMESTICDURATION_WHERE =
		"SELECT COUNT(travelDomesticDuration) FROM TravelDomesticDuration travelDomesticDuration WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"travelDomesticDuration.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TravelDomesticDuration exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TravelDomesticDuration exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TravelDomesticDurationPersistenceImpl.class);

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

	private static class TravelDomesticDurationModelArgumentsResolver
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

			TravelDomesticDurationModelImpl travelDomesticDurationModelImpl =
				(TravelDomesticDurationModelImpl)baseModel;

			long columnBitmask =
				travelDomesticDurationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					travelDomesticDurationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						travelDomesticDurationModelImpl.getColumnBitmask(
							columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(TravelDomesticDurationPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					travelDomesticDurationModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			TravelDomesticDurationModelImpl travelDomesticDurationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						travelDomesticDurationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						travelDomesticDurationModelImpl.getColumnValue(
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

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}