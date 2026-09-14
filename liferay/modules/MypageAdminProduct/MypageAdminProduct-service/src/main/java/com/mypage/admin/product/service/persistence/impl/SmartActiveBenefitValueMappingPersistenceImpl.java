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

import com.mypage.admin.product.exception.NoSuchSmartActiveBenefitValueMappingException;
import com.mypage.admin.product.model.SmartActiveBenefitValueMapping;
import com.mypage.admin.product.model.impl.SmartActiveBenefitValueMappingImpl;
import com.mypage.admin.product.model.impl.SmartActiveBenefitValueMappingModelImpl;
import com.mypage.admin.product.service.persistence.SmartActiveBenefitValueMappingPersistence;
import com.mypage.admin.product.service.persistence.SmartActiveBenefitValueMappingUtil;
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
 * The persistence implementation for the smart active benefit value mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = SmartActiveBenefitValueMappingPersistence.class)
public class SmartActiveBenefitValueMappingPersistenceImpl
	extends BasePersistenceImpl<SmartActiveBenefitValueMapping>
	implements SmartActiveBenefitValueMappingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SmartActiveBenefitValueMappingUtil</code> to access the smart active benefit value mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SmartActiveBenefitValueMappingImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByBenefitValueId;
	private FinderPath _finderPathWithoutPaginationFindByBenefitValueId;
	private FinderPath _finderPathCountByBenefitValueId;

	/**
	 * Returns all the smart active benefit value mappings where smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the matching smart active benefit value mappings
	 */
	@Override
	public List<SmartActiveBenefitValueMapping> findByBenefitValueId(
		long smartActiveBenefitValueId) {

		return findByBenefitValueId(
			smartActiveBenefitValueId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the smart active benefit value mappings where smartActiveBenefitValueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param start the lower bound of the range of smart active benefit value mappings
	 * @param end the upper bound of the range of smart active benefit value mappings (not inclusive)
	 * @return the range of matching smart active benefit value mappings
	 */
	@Override
	public List<SmartActiveBenefitValueMapping> findByBenefitValueId(
		long smartActiveBenefitValueId, int start, int end) {

		return findByBenefitValueId(
			smartActiveBenefitValueId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart active benefit value mappings where smartActiveBenefitValueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param start the lower bound of the range of smart active benefit value mappings
	 * @param end the upper bound of the range of smart active benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smart active benefit value mappings
	 */
	@Override
	public List<SmartActiveBenefitValueMapping> findByBenefitValueId(
		long smartActiveBenefitValueId, int start, int end,
		OrderByComparator<SmartActiveBenefitValueMapping> orderByComparator) {

		return findByBenefitValueId(
			smartActiveBenefitValueId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart active benefit value mappings where smartActiveBenefitValueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param start the lower bound of the range of smart active benefit value mappings
	 * @param end the upper bound of the range of smart active benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smart active benefit value mappings
	 */
	@Override
	public List<SmartActiveBenefitValueMapping> findByBenefitValueId(
		long smartActiveBenefitValueId, int start, int end,
		OrderByComparator<SmartActiveBenefitValueMapping> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByBenefitValueId;
				finderArgs = new Object[] {smartActiveBenefitValueId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBenefitValueId;
			finderArgs = new Object[] {
				smartActiveBenefitValueId, start, end, orderByComparator
			};
		}

		List<SmartActiveBenefitValueMapping> list = null;

		if (useFinderCache) {
			list = (List<SmartActiveBenefitValueMapping>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SmartActiveBenefitValueMapping
						smartActiveBenefitValueMapping : list) {

					if (smartActiveBenefitValueId !=
							smartActiveBenefitValueMapping.
								getSmartActiveBenefitValueId()) {

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

			sb.append(_SQL_SELECT_SMARTACTIVEBENEFITVALUEMAPPING_WHERE);

			sb.append(
				_FINDER_COLUMN_BENEFITVALUEID_SMARTACTIVEBENEFITVALUEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					SmartActiveBenefitValueMappingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(smartActiveBenefitValueId);

				list = (List<SmartActiveBenefitValueMapping>)QueryUtil.list(
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
	 * Returns the first smart active benefit value mapping in the ordered set where smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart active benefit value mapping
	 * @throws NoSuchSmartActiveBenefitValueMappingException if a matching smart active benefit value mapping could not be found
	 */
	@Override
	public SmartActiveBenefitValueMapping findByBenefitValueId_First(
			long smartActiveBenefitValueId,
			OrderByComparator<SmartActiveBenefitValueMapping> orderByComparator)
		throws NoSuchSmartActiveBenefitValueMappingException {

		SmartActiveBenefitValueMapping smartActiveBenefitValueMapping =
			fetchByBenefitValueId_First(
				smartActiveBenefitValueId, orderByComparator);

		if (smartActiveBenefitValueMapping != null) {
			return smartActiveBenefitValueMapping;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("smartActiveBenefitValueId=");
		sb.append(smartActiveBenefitValueId);

		sb.append("}");

		throw new NoSuchSmartActiveBenefitValueMappingException(sb.toString());
	}

	/**
	 * Returns the first smart active benefit value mapping in the ordered set where smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart active benefit value mapping, or <code>null</code> if a matching smart active benefit value mapping could not be found
	 */
	@Override
	public SmartActiveBenefitValueMapping fetchByBenefitValueId_First(
		long smartActiveBenefitValueId,
		OrderByComparator<SmartActiveBenefitValueMapping> orderByComparator) {

		List<SmartActiveBenefitValueMapping> list = findByBenefitValueId(
			smartActiveBenefitValueId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last smart active benefit value mapping in the ordered set where smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart active benefit value mapping
	 * @throws NoSuchSmartActiveBenefitValueMappingException if a matching smart active benefit value mapping could not be found
	 */
	@Override
	public SmartActiveBenefitValueMapping findByBenefitValueId_Last(
			long smartActiveBenefitValueId,
			OrderByComparator<SmartActiveBenefitValueMapping> orderByComparator)
		throws NoSuchSmartActiveBenefitValueMappingException {

		SmartActiveBenefitValueMapping smartActiveBenefitValueMapping =
			fetchByBenefitValueId_Last(
				smartActiveBenefitValueId, orderByComparator);

		if (smartActiveBenefitValueMapping != null) {
			return smartActiveBenefitValueMapping;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("smartActiveBenefitValueId=");
		sb.append(smartActiveBenefitValueId);

		sb.append("}");

		throw new NoSuchSmartActiveBenefitValueMappingException(sb.toString());
	}

	/**
	 * Returns the last smart active benefit value mapping in the ordered set where smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart active benefit value mapping, or <code>null</code> if a matching smart active benefit value mapping could not be found
	 */
	@Override
	public SmartActiveBenefitValueMapping fetchByBenefitValueId_Last(
		long smartActiveBenefitValueId,
		OrderByComparator<SmartActiveBenefitValueMapping> orderByComparator) {

		int count = countByBenefitValueId(smartActiveBenefitValueId);

		if (count == 0) {
			return null;
		}

		List<SmartActiveBenefitValueMapping> list = findByBenefitValueId(
			smartActiveBenefitValueId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smart active benefit value mappings before and after the current smart active benefit value mapping in the ordered set where smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitValueMappingId the primary key of the current smart active benefit value mapping
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next smart active benefit value mapping
	 * @throws NoSuchSmartActiveBenefitValueMappingException if a smart active benefit value mapping with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefitValueMapping[] findByBenefitValueId_PrevAndNext(
			long smartActiveBenefitValueMappingId,
			long smartActiveBenefitValueId,
			OrderByComparator<SmartActiveBenefitValueMapping> orderByComparator)
		throws NoSuchSmartActiveBenefitValueMappingException {

		SmartActiveBenefitValueMapping smartActiveBenefitValueMapping =
			findByPrimaryKey(smartActiveBenefitValueMappingId);

		Session session = null;

		try {
			session = openSession();

			SmartActiveBenefitValueMapping[] array =
				new SmartActiveBenefitValueMappingImpl[3];

			array[0] = getByBenefitValueId_PrevAndNext(
				session, smartActiveBenefitValueMapping,
				smartActiveBenefitValueId, orderByComparator, true);

			array[1] = smartActiveBenefitValueMapping;

			array[2] = getByBenefitValueId_PrevAndNext(
				session, smartActiveBenefitValueMapping,
				smartActiveBenefitValueId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SmartActiveBenefitValueMapping getByBenefitValueId_PrevAndNext(
		Session session,
		SmartActiveBenefitValueMapping smartActiveBenefitValueMapping,
		long smartActiveBenefitValueId,
		OrderByComparator<SmartActiveBenefitValueMapping> orderByComparator,
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

		sb.append(_SQL_SELECT_SMARTACTIVEBENEFITVALUEMAPPING_WHERE);

		sb.append(_FINDER_COLUMN_BENEFITVALUEID_SMARTACTIVEBENEFITVALUEID_2);

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
			sb.append(SmartActiveBenefitValueMappingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(smartActiveBenefitValueId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						smartActiveBenefitValueMapping)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SmartActiveBenefitValueMapping> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smart active benefit value mappings where smartActiveBenefitValueId = &#63; from the database.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 */
	@Override
	public void removeByBenefitValueId(long smartActiveBenefitValueId) {
		for (SmartActiveBenefitValueMapping smartActiveBenefitValueMapping :
				findByBenefitValueId(
					smartActiveBenefitValueId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(smartActiveBenefitValueMapping);
		}
	}

	/**
	 * Returns the number of smart active benefit value mappings where smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the number of matching smart active benefit value mappings
	 */
	@Override
	public int countByBenefitValueId(long smartActiveBenefitValueId) {
		FinderPath finderPath = _finderPathCountByBenefitValueId;

		Object[] finderArgs = new Object[] {smartActiveBenefitValueId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SMARTACTIVEBENEFITVALUEMAPPING_WHERE);

			sb.append(
				_FINDER_COLUMN_BENEFITVALUEID_SMARTACTIVEBENEFITVALUEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(smartActiveBenefitValueId);

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
		_FINDER_COLUMN_BENEFITVALUEID_SMARTACTIVEBENEFITVALUEID_2 =
			"smartActiveBenefitValueMapping.smartActiveBenefitValueId = ?";

	private FinderPath _finderPathFetchByBenefitIdAndBenefitValueId;
	private FinderPath _finderPathCountByBenefitIdAndBenefitValueId;

	/**
	 * Returns the smart active benefit value mapping where smartActiveBenefitId = &#63; and smartActiveBenefitValueId = &#63; or throws a <code>NoSuchSmartActiveBenefitValueMappingException</code> if it could not be found.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the matching smart active benefit value mapping
	 * @throws NoSuchSmartActiveBenefitValueMappingException if a matching smart active benefit value mapping could not be found
	 */
	@Override
	public SmartActiveBenefitValueMapping findByBenefitIdAndBenefitValueId(
			long smartActiveBenefitId, long smartActiveBenefitValueId)
		throws NoSuchSmartActiveBenefitValueMappingException {

		SmartActiveBenefitValueMapping smartActiveBenefitValueMapping =
			fetchByBenefitIdAndBenefitValueId(
				smartActiveBenefitId, smartActiveBenefitValueId);

		if (smartActiveBenefitValueMapping == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("smartActiveBenefitId=");
			sb.append(smartActiveBenefitId);

			sb.append(", smartActiveBenefitValueId=");
			sb.append(smartActiveBenefitValueId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSmartActiveBenefitValueMappingException(
				sb.toString());
		}

		return smartActiveBenefitValueMapping;
	}

	/**
	 * Returns the smart active benefit value mapping where smartActiveBenefitId = &#63; and smartActiveBenefitValueId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the matching smart active benefit value mapping, or <code>null</code> if a matching smart active benefit value mapping could not be found
	 */
	@Override
	public SmartActiveBenefitValueMapping fetchByBenefitIdAndBenefitValueId(
		long smartActiveBenefitId, long smartActiveBenefitValueId) {

		return fetchByBenefitIdAndBenefitValueId(
			smartActiveBenefitId, smartActiveBenefitValueId, true);
	}

	/**
	 * Returns the smart active benefit value mapping where smartActiveBenefitId = &#63; and smartActiveBenefitValueId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active benefit value mapping, or <code>null</code> if a matching smart active benefit value mapping could not be found
	 */
	@Override
	public SmartActiveBenefitValueMapping fetchByBenefitIdAndBenefitValueId(
		long smartActiveBenefitId, long smartActiveBenefitValueId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				smartActiveBenefitId, smartActiveBenefitValueId
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByBenefitIdAndBenefitValueId, finderArgs, this);
		}

		if (result instanceof SmartActiveBenefitValueMapping) {
			SmartActiveBenefitValueMapping smartActiveBenefitValueMapping =
				(SmartActiveBenefitValueMapping)result;

			if ((smartActiveBenefitId !=
					smartActiveBenefitValueMapping.getSmartActiveBenefitId()) ||
				(smartActiveBenefitValueId !=
					smartActiveBenefitValueMapping.
						getSmartActiveBenefitValueId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SMARTACTIVEBENEFITVALUEMAPPING_WHERE);

			sb.append(
				_FINDER_COLUMN_BENEFITIDANDBENEFITVALUEID_SMARTACTIVEBENEFITID_2);

			sb.append(
				_FINDER_COLUMN_BENEFITIDANDBENEFITVALUEID_SMARTACTIVEBENEFITVALUEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(smartActiveBenefitId);

				queryPos.add(smartActiveBenefitValueId);

				List<SmartActiveBenefitValueMapping> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByBenefitIdAndBenefitValueId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									smartActiveBenefitId,
									smartActiveBenefitValueId
								};
							}

							_log.warn(
								"SmartActiveBenefitValueMappingPersistenceImpl.fetchByBenefitIdAndBenefitValueId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SmartActiveBenefitValueMapping
						smartActiveBenefitValueMapping = list.get(0);

					result = smartActiveBenefitValueMapping;

					cacheResult(smartActiveBenefitValueMapping);
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
			return (SmartActiveBenefitValueMapping)result;
		}
	}

	/**
	 * Removes the smart active benefit value mapping where smartActiveBenefitId = &#63; and smartActiveBenefitValueId = &#63; from the database.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the smart active benefit value mapping that was removed
	 */
	@Override
	public SmartActiveBenefitValueMapping removeByBenefitIdAndBenefitValueId(
			long smartActiveBenefitId, long smartActiveBenefitValueId)
		throws NoSuchSmartActiveBenefitValueMappingException {

		SmartActiveBenefitValueMapping smartActiveBenefitValueMapping =
			findByBenefitIdAndBenefitValueId(
				smartActiveBenefitId, smartActiveBenefitValueId);

		return remove(smartActiveBenefitValueMapping);
	}

	/**
	 * Returns the number of smart active benefit value mappings where smartActiveBenefitId = &#63; and smartActiveBenefitValueId = &#63;.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveBenefitValueId the smart active benefit value ID
	 * @return the number of matching smart active benefit value mappings
	 */
	@Override
	public int countByBenefitIdAndBenefitValueId(
		long smartActiveBenefitId, long smartActiveBenefitValueId) {

		FinderPath finderPath = _finderPathCountByBenefitIdAndBenefitValueId;

		Object[] finderArgs = new Object[] {
			smartActiveBenefitId, smartActiveBenefitValueId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SMARTACTIVEBENEFITVALUEMAPPING_WHERE);

			sb.append(
				_FINDER_COLUMN_BENEFITIDANDBENEFITVALUEID_SMARTACTIVEBENEFITID_2);

			sb.append(
				_FINDER_COLUMN_BENEFITIDANDBENEFITVALUEID_SMARTACTIVEBENEFITVALUEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(smartActiveBenefitId);

				queryPos.add(smartActiveBenefitValueId);

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
		_FINDER_COLUMN_BENEFITIDANDBENEFITVALUEID_SMARTACTIVEBENEFITID_2 =
			"smartActiveBenefitValueMapping.smartActiveBenefitId = ? AND ";

	private static final String
		_FINDER_COLUMN_BENEFITIDANDBENEFITVALUEID_SMARTACTIVEBENEFITVALUEID_2 =
			"smartActiveBenefitValueMapping.smartActiveBenefitValueId = ?";

	public SmartActiveBenefitValueMappingPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SmartActiveBenefitValueMapping.class);

		setModelImplClass(SmartActiveBenefitValueMappingImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the smart active benefit value mapping in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefitValueMapping the smart active benefit value mapping
	 */
	@Override
	public void cacheResult(
		SmartActiveBenefitValueMapping smartActiveBenefitValueMapping) {

		entityCache.putResult(
			SmartActiveBenefitValueMappingImpl.class,
			smartActiveBenefitValueMapping.getPrimaryKey(),
			smartActiveBenefitValueMapping);

		finderCache.putResult(
			_finderPathFetchByBenefitIdAndBenefitValueId,
			new Object[] {
				smartActiveBenefitValueMapping.getSmartActiveBenefitId(),
				smartActiveBenefitValueMapping.getSmartActiveBenefitValueId()
			},
			smartActiveBenefitValueMapping);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the smart active benefit value mappings in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefitValueMappings the smart active benefit value mappings
	 */
	@Override
	public void cacheResult(
		List<SmartActiveBenefitValueMapping> smartActiveBenefitValueMappings) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (smartActiveBenefitValueMappings.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SmartActiveBenefitValueMapping smartActiveBenefitValueMapping :
				smartActiveBenefitValueMappings) {

			if (entityCache.getResult(
					SmartActiveBenefitValueMappingImpl.class,
					smartActiveBenefitValueMapping.getPrimaryKey()) == null) {

				cacheResult(smartActiveBenefitValueMapping);
			}
		}
	}

	/**
	 * Clears the cache for all smart active benefit value mappings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SmartActiveBenefitValueMappingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the smart active benefit value mapping.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		SmartActiveBenefitValueMapping smartActiveBenefitValueMapping) {

		entityCache.removeResult(
			SmartActiveBenefitValueMappingImpl.class,
			smartActiveBenefitValueMapping);
	}

	@Override
	public void clearCache(
		List<SmartActiveBenefitValueMapping> smartActiveBenefitValueMappings) {

		for (SmartActiveBenefitValueMapping smartActiveBenefitValueMapping :
				smartActiveBenefitValueMappings) {

			entityCache.removeResult(
				SmartActiveBenefitValueMappingImpl.class,
				smartActiveBenefitValueMapping);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				SmartActiveBenefitValueMappingImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SmartActiveBenefitValueMappingModelImpl
			smartActiveBenefitValueMappingModelImpl) {

		Object[] args = new Object[] {
			smartActiveBenefitValueMappingModelImpl.getSmartActiveBenefitId(),
			smartActiveBenefitValueMappingModelImpl.
				getSmartActiveBenefitValueId()
		};

		finderCache.putResult(
			_finderPathCountByBenefitIdAndBenefitValueId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByBenefitIdAndBenefitValueId, args,
			smartActiveBenefitValueMappingModelImpl, false);
	}

	/**
	 * Creates a new smart active benefit value mapping with the primary key. Does not add the smart active benefit value mapping to the database.
	 *
	 * @param smartActiveBenefitValueMappingId the primary key for the new smart active benefit value mapping
	 * @return the new smart active benefit value mapping
	 */
	@Override
	public SmartActiveBenefitValueMapping create(
		long smartActiveBenefitValueMappingId) {

		SmartActiveBenefitValueMapping smartActiveBenefitValueMapping =
			new SmartActiveBenefitValueMappingImpl();

		smartActiveBenefitValueMapping.setNew(true);
		smartActiveBenefitValueMapping.setPrimaryKey(
			smartActiveBenefitValueMappingId);

		smartActiveBenefitValueMapping.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return smartActiveBenefitValueMapping;
	}

	/**
	 * Removes the smart active benefit value mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveBenefitValueMappingId the primary key of the smart active benefit value mapping
	 * @return the smart active benefit value mapping that was removed
	 * @throws NoSuchSmartActiveBenefitValueMappingException if a smart active benefit value mapping with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefitValueMapping remove(
			long smartActiveBenefitValueMappingId)
		throws NoSuchSmartActiveBenefitValueMappingException {

		return remove((Serializable)smartActiveBenefitValueMappingId);
	}

	/**
	 * Removes the smart active benefit value mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the smart active benefit value mapping
	 * @return the smart active benefit value mapping that was removed
	 * @throws NoSuchSmartActiveBenefitValueMappingException if a smart active benefit value mapping with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefitValueMapping remove(Serializable primaryKey)
		throws NoSuchSmartActiveBenefitValueMappingException {

		Session session = null;

		try {
			session = openSession();

			SmartActiveBenefitValueMapping smartActiveBenefitValueMapping =
				(SmartActiveBenefitValueMapping)session.get(
					SmartActiveBenefitValueMappingImpl.class, primaryKey);

			if (smartActiveBenefitValueMapping == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSmartActiveBenefitValueMappingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(smartActiveBenefitValueMapping);
		}
		catch (NoSuchSmartActiveBenefitValueMappingException
					noSuchEntityException) {

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
	protected SmartActiveBenefitValueMapping removeImpl(
		SmartActiveBenefitValueMapping smartActiveBenefitValueMapping) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(smartActiveBenefitValueMapping)) {
				smartActiveBenefitValueMapping =
					(SmartActiveBenefitValueMapping)session.get(
						SmartActiveBenefitValueMappingImpl.class,
						smartActiveBenefitValueMapping.getPrimaryKeyObj());
			}

			if (smartActiveBenefitValueMapping != null) {
				session.delete(smartActiveBenefitValueMapping);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (smartActiveBenefitValueMapping != null) {
			clearCache(smartActiveBenefitValueMapping);
		}

		return smartActiveBenefitValueMapping;
	}

	@Override
	public SmartActiveBenefitValueMapping updateImpl(
		SmartActiveBenefitValueMapping smartActiveBenefitValueMapping) {

		boolean isNew = smartActiveBenefitValueMapping.isNew();

		if (!(smartActiveBenefitValueMapping instanceof
				SmartActiveBenefitValueMappingModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					smartActiveBenefitValueMapping.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					smartActiveBenefitValueMapping);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in smartActiveBenefitValueMapping proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SmartActiveBenefitValueMapping implementation " +
					smartActiveBenefitValueMapping.getClass());
		}

		SmartActiveBenefitValueMappingModelImpl
			smartActiveBenefitValueMappingModelImpl =
				(SmartActiveBenefitValueMappingModelImpl)
					smartActiveBenefitValueMapping;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (smartActiveBenefitValueMapping.getCreateDate() == null)) {
			if (serviceContext == null) {
				smartActiveBenefitValueMapping.setCreateDate(date);
			}
			else {
				smartActiveBenefitValueMapping.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!smartActiveBenefitValueMappingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				smartActiveBenefitValueMapping.setModifiedDate(date);
			}
			else {
				smartActiveBenefitValueMapping.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(smartActiveBenefitValueMapping);
			}
			else {
				smartActiveBenefitValueMapping =
					(SmartActiveBenefitValueMapping)session.merge(
						smartActiveBenefitValueMapping);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SmartActiveBenefitValueMappingImpl.class,
			smartActiveBenefitValueMappingModelImpl, false, true);

		cacheUniqueFindersCache(smartActiveBenefitValueMappingModelImpl);

		if (isNew) {
			smartActiveBenefitValueMapping.setNew(false);
		}

		smartActiveBenefitValueMapping.resetOriginalValues();

		return smartActiveBenefitValueMapping;
	}

	/**
	 * Returns the smart active benefit value mapping with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the smart active benefit value mapping
	 * @return the smart active benefit value mapping
	 * @throws NoSuchSmartActiveBenefitValueMappingException if a smart active benefit value mapping with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefitValueMapping findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchSmartActiveBenefitValueMappingException {

		SmartActiveBenefitValueMapping smartActiveBenefitValueMapping =
			fetchByPrimaryKey(primaryKey);

		if (smartActiveBenefitValueMapping == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSmartActiveBenefitValueMappingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return smartActiveBenefitValueMapping;
	}

	/**
	 * Returns the smart active benefit value mapping with the primary key or throws a <code>NoSuchSmartActiveBenefitValueMappingException</code> if it could not be found.
	 *
	 * @param smartActiveBenefitValueMappingId the primary key of the smart active benefit value mapping
	 * @return the smart active benefit value mapping
	 * @throws NoSuchSmartActiveBenefitValueMappingException if a smart active benefit value mapping with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefitValueMapping findByPrimaryKey(
			long smartActiveBenefitValueMappingId)
		throws NoSuchSmartActiveBenefitValueMappingException {

		return findByPrimaryKey((Serializable)smartActiveBenefitValueMappingId);
	}

	/**
	 * Returns the smart active benefit value mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveBenefitValueMappingId the primary key of the smart active benefit value mapping
	 * @return the smart active benefit value mapping, or <code>null</code> if a smart active benefit value mapping with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefitValueMapping fetchByPrimaryKey(
		long smartActiveBenefitValueMappingId) {

		return fetchByPrimaryKey(
			(Serializable)smartActiveBenefitValueMappingId);
	}

	/**
	 * Returns all the smart active benefit value mappings.
	 *
	 * @return the smart active benefit value mappings
	 */
	@Override
	public List<SmartActiveBenefitValueMapping> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smart active benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit value mappings
	 * @param end the upper bound of the range of smart active benefit value mappings (not inclusive)
	 * @return the range of smart active benefit value mappings
	 */
	@Override
	public List<SmartActiveBenefitValueMapping> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart active benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit value mappings
	 * @param end the upper bound of the range of smart active benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active benefit value mappings
	 */
	@Override
	public List<SmartActiveBenefitValueMapping> findAll(
		int start, int end,
		OrderByComparator<SmartActiveBenefitValueMapping> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart active benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit value mappings
	 * @param end the upper bound of the range of smart active benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active benefit value mappings
	 */
	@Override
	public List<SmartActiveBenefitValueMapping> findAll(
		int start, int end,
		OrderByComparator<SmartActiveBenefitValueMapping> orderByComparator,
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

		List<SmartActiveBenefitValueMapping> list = null;

		if (useFinderCache) {
			list = (List<SmartActiveBenefitValueMapping>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SMARTACTIVEBENEFITVALUEMAPPING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SMARTACTIVEBENEFITVALUEMAPPING;

				sql = sql.concat(
					SmartActiveBenefitValueMappingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SmartActiveBenefitValueMapping>)QueryUtil.list(
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
	 * Removes all the smart active benefit value mappings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SmartActiveBenefitValueMapping smartActiveBenefitValueMapping :
				findAll()) {

			remove(smartActiveBenefitValueMapping);
		}
	}

	/**
	 * Returns the number of smart active benefit value mappings.
	 *
	 * @return the number of smart active benefit value mappings
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
					_SQL_COUNT_SMARTACTIVEBENEFITVALUEMAPPING);

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
		return "smartActiveBenefitValueMappingId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SMARTACTIVEBENEFITVALUEMAPPING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SmartActiveBenefitValueMappingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the smart active benefit value mapping persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SmartActiveBenefitValueMappingModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name",
				SmartActiveBenefitValueMapping.class.getName()));

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

		_finderPathWithPaginationFindByBenefitValueId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBenefitValueId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"smartActiveBenefitValueId"}, true);

		_finderPathWithoutPaginationFindByBenefitValueId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBenefitValueId",
			new String[] {Long.class.getName()},
			new String[] {"smartActiveBenefitValueId"}, true);

		_finderPathCountByBenefitValueId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBenefitValueId",
			new String[] {Long.class.getName()},
			new String[] {"smartActiveBenefitValueId"}, false);

		_finderPathFetchByBenefitIdAndBenefitValueId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByBenefitIdAndBenefitValueId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"smartActiveBenefitId", "smartActiveBenefitValueId"},
			true);

		_finderPathCountByBenefitIdAndBenefitValueId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBenefitIdAndBenefitValueId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"smartActiveBenefitId", "smartActiveBenefitValueId"},
			false);

		_setSmartActiveBenefitValueMappingUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSmartActiveBenefitValueMappingUtilPersistence(null);

		entityCache.removeCache(
			SmartActiveBenefitValueMappingImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setSmartActiveBenefitValueMappingUtilPersistence(
		SmartActiveBenefitValueMappingPersistence
			smartActiveBenefitValueMappingPersistence) {

		try {
			Field field =
				SmartActiveBenefitValueMappingUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, smartActiveBenefitValueMappingPersistence);
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

	private static final String _SQL_SELECT_SMARTACTIVEBENEFITVALUEMAPPING =
		"SELECT smartActiveBenefitValueMapping FROM SmartActiveBenefitValueMapping smartActiveBenefitValueMapping";

	private static final String
		_SQL_SELECT_SMARTACTIVEBENEFITVALUEMAPPING_WHERE =
			"SELECT smartActiveBenefitValueMapping FROM SmartActiveBenefitValueMapping smartActiveBenefitValueMapping WHERE ";

	private static final String _SQL_COUNT_SMARTACTIVEBENEFITVALUEMAPPING =
		"SELECT COUNT(smartActiveBenefitValueMapping) FROM SmartActiveBenefitValueMapping smartActiveBenefitValueMapping";

	private static final String
		_SQL_COUNT_SMARTACTIVEBENEFITVALUEMAPPING_WHERE =
			"SELECT COUNT(smartActiveBenefitValueMapping) FROM SmartActiveBenefitValueMapping smartActiveBenefitValueMapping WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"smartActiveBenefitValueMapping.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SmartActiveBenefitValueMapping exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SmartActiveBenefitValueMapping exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SmartActiveBenefitValueMappingPersistenceImpl.class);

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

	private static class SmartActiveBenefitValueMappingModelArgumentsResolver
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

			SmartActiveBenefitValueMappingModelImpl
				smartActiveBenefitValueMappingModelImpl =
					(SmartActiveBenefitValueMappingModelImpl)baseModel;

			long columnBitmask =
				smartActiveBenefitValueMappingModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					smartActiveBenefitValueMappingModelImpl, columnNames,
					original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						smartActiveBenefitValueMappingModelImpl.
							getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					smartActiveBenefitValueMappingModelImpl, columnNames,
					original);
			}

			return null;
		}

		private static Object[] _getValue(
			SmartActiveBenefitValueMappingModelImpl
				smartActiveBenefitValueMappingModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						smartActiveBenefitValueMappingModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						smartActiveBenefitValueMappingModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}