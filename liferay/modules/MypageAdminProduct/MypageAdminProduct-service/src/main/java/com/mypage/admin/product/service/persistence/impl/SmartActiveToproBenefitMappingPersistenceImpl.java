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

import com.mypage.admin.product.exception.NoSuchSmartActiveToproBenefitMappingException;
import com.mypage.admin.product.model.SmartActiveToproBenefitMapping;
import com.mypage.admin.product.model.impl.SmartActiveToproBenefitMappingImpl;
import com.mypage.admin.product.model.impl.SmartActiveToproBenefitMappingModelImpl;
import com.mypage.admin.product.service.persistence.SmartActiveToproBenefitMappingPersistence;
import com.mypage.admin.product.service.persistence.SmartActiveToproBenefitMappingUtil;
import com.mypage.admin.product.service.persistence.impl.constants.MPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the smart active topro benefit mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = SmartActiveToproBenefitMappingPersistence.class)
public class SmartActiveToproBenefitMappingPersistenceImpl
	extends BasePersistenceImpl<SmartActiveToproBenefitMapping>
	implements SmartActiveToproBenefitMappingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SmartActiveToproBenefitMappingUtil</code> to access the smart active topro benefit mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SmartActiveToproBenefitMappingImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByToproId;
	private FinderPath _finderPathWithoutPaginationFindByToproId;
	private FinderPath _finderPathCountByToproId;

	/**
	 * Returns all the smart active topro benefit mappings where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @return the matching smart active topro benefit mappings
	 */
	@Override
	public List<SmartActiveToproBenefitMapping> findByToproId(
		long smartActiveToproId) {

		return findByToproId(
			smartActiveToproId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smart active topro benefit mappings where smartActiveToproId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @return the range of matching smart active topro benefit mappings
	 */
	@Override
	public List<SmartActiveToproBenefitMapping> findByToproId(
		long smartActiveToproId, int start, int end) {

		return findByToproId(smartActiveToproId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart active topro benefit mappings where smartActiveToproId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smart active topro benefit mappings
	 */
	@Override
	public List<SmartActiveToproBenefitMapping> findByToproId(
		long smartActiveToproId, int start, int end,
		OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator) {

		return findByToproId(
			smartActiveToproId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart active topro benefit mappings where smartActiveToproId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smart active topro benefit mappings
	 */
	@Override
	public List<SmartActiveToproBenefitMapping> findByToproId(
		long smartActiveToproId, int start, int end,
		OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByToproId;
				finderArgs = new Object[] {smartActiveToproId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByToproId;
			finderArgs = new Object[] {
				smartActiveToproId, start, end, orderByComparator
			};
		}

		List<SmartActiveToproBenefitMapping> list = null;

		if (useFinderCache) {
			list = (List<SmartActiveToproBenefitMapping>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SmartActiveToproBenefitMapping
						smartActiveToproBenefitMapping : list) {

					if (smartActiveToproId !=
							smartActiveToproBenefitMapping.
								getSmartActiveToproId()) {

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

			sb.append(_SQL_SELECT_SMARTACTIVETOPROBENEFITMAPPING_WHERE);

			sb.append(_FINDER_COLUMN_TOPROID_SMARTACTIVETOPROID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					SmartActiveToproBenefitMappingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(smartActiveToproId);

				list = (List<SmartActiveToproBenefitMapping>)QueryUtil.list(
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
	 * Returns the first smart active topro benefit mapping in the ordered set where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart active topro benefit mapping
	 * @throws NoSuchSmartActiveToproBenefitMappingException if a matching smart active topro benefit mapping could not be found
	 */
	@Override
	public SmartActiveToproBenefitMapping findByToproId_First(
			long smartActiveToproId,
			OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator)
		throws NoSuchSmartActiveToproBenefitMappingException {

		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping =
			fetchByToproId_First(smartActiveToproId, orderByComparator);

		if (smartActiveToproBenefitMapping != null) {
			return smartActiveToproBenefitMapping;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("smartActiveToproId=");
		sb.append(smartActiveToproId);

		sb.append("}");

		throw new NoSuchSmartActiveToproBenefitMappingException(sb.toString());
	}

	/**
	 * Returns the first smart active topro benefit mapping in the ordered set where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart active topro benefit mapping, or <code>null</code> if a matching smart active topro benefit mapping could not be found
	 */
	@Override
	public SmartActiveToproBenefitMapping fetchByToproId_First(
		long smartActiveToproId,
		OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator) {

		List<SmartActiveToproBenefitMapping> list = findByToproId(
			smartActiveToproId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last smart active topro benefit mapping in the ordered set where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart active topro benefit mapping
	 * @throws NoSuchSmartActiveToproBenefitMappingException if a matching smart active topro benefit mapping could not be found
	 */
	@Override
	public SmartActiveToproBenefitMapping findByToproId_Last(
			long smartActiveToproId,
			OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator)
		throws NoSuchSmartActiveToproBenefitMappingException {

		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping =
			fetchByToproId_Last(smartActiveToproId, orderByComparator);

		if (smartActiveToproBenefitMapping != null) {
			return smartActiveToproBenefitMapping;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("smartActiveToproId=");
		sb.append(smartActiveToproId);

		sb.append("}");

		throw new NoSuchSmartActiveToproBenefitMappingException(sb.toString());
	}

	/**
	 * Returns the last smart active topro benefit mapping in the ordered set where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart active topro benefit mapping, or <code>null</code> if a matching smart active topro benefit mapping could not be found
	 */
	@Override
	public SmartActiveToproBenefitMapping fetchByToproId_Last(
		long smartActiveToproId,
		OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator) {

		int count = countByToproId(smartActiveToproId);

		if (count == 0) {
			return null;
		}

		List<SmartActiveToproBenefitMapping> list = findByToproId(
			smartActiveToproId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smart active topro benefit mappings before and after the current smart active topro benefit mapping in the ordered set where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproBenefitMappingId the primary key of the current smart active topro benefit mapping
	 * @param smartActiveToproId the smart active topro ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next smart active topro benefit mapping
	 * @throws NoSuchSmartActiveToproBenefitMappingException if a smart active topro benefit mapping with the primary key could not be found
	 */
	@Override
	public SmartActiveToproBenefitMapping[] findByToproId_PrevAndNext(
			long smartActiveToproBenefitMappingId, long smartActiveToproId,
			OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator)
		throws NoSuchSmartActiveToproBenefitMappingException {

		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping =
			findByPrimaryKey(smartActiveToproBenefitMappingId);

		Session session = null;

		try {
			session = openSession();

			SmartActiveToproBenefitMapping[] array =
				new SmartActiveToproBenefitMappingImpl[3];

			array[0] = getByToproId_PrevAndNext(
				session, smartActiveToproBenefitMapping, smartActiveToproId,
				orderByComparator, true);

			array[1] = smartActiveToproBenefitMapping;

			array[2] = getByToproId_PrevAndNext(
				session, smartActiveToproBenefitMapping, smartActiveToproId,
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

	protected SmartActiveToproBenefitMapping getByToproId_PrevAndNext(
		Session session,
		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping,
		long smartActiveToproId,
		OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator,
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

		sb.append(_SQL_SELECT_SMARTACTIVETOPROBENEFITMAPPING_WHERE);

		sb.append(_FINDER_COLUMN_TOPROID_SMARTACTIVETOPROID_2);

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
			sb.append(SmartActiveToproBenefitMappingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(smartActiveToproId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						smartActiveToproBenefitMapping)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SmartActiveToproBenefitMapping> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smart active topro benefit mappings where smartActiveToproId = &#63; from the database.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 */
	@Override
	public void removeByToproId(long smartActiveToproId) {
		for (SmartActiveToproBenefitMapping smartActiveToproBenefitMapping :
				findByToproId(
					smartActiveToproId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(smartActiveToproBenefitMapping);
		}
	}

	/**
	 * Returns the number of smart active topro benefit mappings where smartActiveToproId = &#63;.
	 *
	 * @param smartActiveToproId the smart active topro ID
	 * @return the number of matching smart active topro benefit mappings
	 */
	@Override
	public int countByToproId(long smartActiveToproId) {
		FinderPath finderPath = _finderPathCountByToproId;

		Object[] finderArgs = new Object[] {smartActiveToproId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SMARTACTIVETOPROBENEFITMAPPING_WHERE);

			sb.append(_FINDER_COLUMN_TOPROID_SMARTACTIVETOPROID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(smartActiveToproId);

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

	private static final String _FINDER_COLUMN_TOPROID_SMARTACTIVETOPROID_2 =
		"smartActiveToproBenefitMapping.smartActiveToproId = ?";

	public SmartActiveToproBenefitMappingPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SmartActiveToproBenefitMapping.class);

		setModelImplClass(SmartActiveToproBenefitMappingImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the smart active topro benefit mapping in the entity cache if it is enabled.
	 *
	 * @param smartActiveToproBenefitMapping the smart active topro benefit mapping
	 */
	@Override
	public void cacheResult(
		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping) {

		entityCache.putResult(
			SmartActiveToproBenefitMappingImpl.class,
			smartActiveToproBenefitMapping.getPrimaryKey(),
			smartActiveToproBenefitMapping);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the smart active topro benefit mappings in the entity cache if it is enabled.
	 *
	 * @param smartActiveToproBenefitMappings the smart active topro benefit mappings
	 */
	@Override
	public void cacheResult(
		List<SmartActiveToproBenefitMapping> smartActiveToproBenefitMappings) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (smartActiveToproBenefitMappings.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SmartActiveToproBenefitMapping smartActiveToproBenefitMapping :
				smartActiveToproBenefitMappings) {

			if (entityCache.getResult(
					SmartActiveToproBenefitMappingImpl.class,
					smartActiveToproBenefitMapping.getPrimaryKey()) == null) {

				cacheResult(smartActiveToproBenefitMapping);
			}
		}
	}

	/**
	 * Clears the cache for all smart active topro benefit mappings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SmartActiveToproBenefitMappingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the smart active topro benefit mapping.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping) {

		entityCache.removeResult(
			SmartActiveToproBenefitMappingImpl.class,
			smartActiveToproBenefitMapping);
	}

	@Override
	public void clearCache(
		List<SmartActiveToproBenefitMapping> smartActiveToproBenefitMappings) {

		for (SmartActiveToproBenefitMapping smartActiveToproBenefitMapping :
				smartActiveToproBenefitMappings) {

			entityCache.removeResult(
				SmartActiveToproBenefitMappingImpl.class,
				smartActiveToproBenefitMapping);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				SmartActiveToproBenefitMappingImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new smart active topro benefit mapping with the primary key. Does not add the smart active topro benefit mapping to the database.
	 *
	 * @param smartActiveToproBenefitMappingId the primary key for the new smart active topro benefit mapping
	 * @return the new smart active topro benefit mapping
	 */
	@Override
	public SmartActiveToproBenefitMapping create(
		long smartActiveToproBenefitMappingId) {

		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping =
			new SmartActiveToproBenefitMappingImpl();

		smartActiveToproBenefitMapping.setNew(true);
		smartActiveToproBenefitMapping.setPrimaryKey(
			smartActiveToproBenefitMappingId);

		smartActiveToproBenefitMapping.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return smartActiveToproBenefitMapping;
	}

	/**
	 * Removes the smart active topro benefit mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveToproBenefitMappingId the primary key of the smart active topro benefit mapping
	 * @return the smart active topro benefit mapping that was removed
	 * @throws NoSuchSmartActiveToproBenefitMappingException if a smart active topro benefit mapping with the primary key could not be found
	 */
	@Override
	public SmartActiveToproBenefitMapping remove(
			long smartActiveToproBenefitMappingId)
		throws NoSuchSmartActiveToproBenefitMappingException {

		return remove((Serializable)smartActiveToproBenefitMappingId);
	}

	/**
	 * Removes the smart active topro benefit mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the smart active topro benefit mapping
	 * @return the smart active topro benefit mapping that was removed
	 * @throws NoSuchSmartActiveToproBenefitMappingException if a smart active topro benefit mapping with the primary key could not be found
	 */
	@Override
	public SmartActiveToproBenefitMapping remove(Serializable primaryKey)
		throws NoSuchSmartActiveToproBenefitMappingException {

		Session session = null;

		try {
			session = openSession();

			SmartActiveToproBenefitMapping smartActiveToproBenefitMapping =
				(SmartActiveToproBenefitMapping)session.get(
					SmartActiveToproBenefitMappingImpl.class, primaryKey);

			if (smartActiveToproBenefitMapping == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSmartActiveToproBenefitMappingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(smartActiveToproBenefitMapping);
		}
		catch (NoSuchSmartActiveToproBenefitMappingException
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
	protected SmartActiveToproBenefitMapping removeImpl(
		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(smartActiveToproBenefitMapping)) {
				smartActiveToproBenefitMapping =
					(SmartActiveToproBenefitMapping)session.get(
						SmartActiveToproBenefitMappingImpl.class,
						smartActiveToproBenefitMapping.getPrimaryKeyObj());
			}

			if (smartActiveToproBenefitMapping != null) {
				session.delete(smartActiveToproBenefitMapping);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (smartActiveToproBenefitMapping != null) {
			clearCache(smartActiveToproBenefitMapping);
		}

		return smartActiveToproBenefitMapping;
	}

	@Override
	public SmartActiveToproBenefitMapping updateImpl(
		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping) {

		boolean isNew = smartActiveToproBenefitMapping.isNew();

		if (!(smartActiveToproBenefitMapping instanceof
				SmartActiveToproBenefitMappingModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					smartActiveToproBenefitMapping.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					smartActiveToproBenefitMapping);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in smartActiveToproBenefitMapping proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SmartActiveToproBenefitMapping implementation " +
					smartActiveToproBenefitMapping.getClass());
		}

		SmartActiveToproBenefitMappingModelImpl
			smartActiveToproBenefitMappingModelImpl =
				(SmartActiveToproBenefitMappingModelImpl)
					smartActiveToproBenefitMapping;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (smartActiveToproBenefitMapping.getCreateDate() == null)) {
			if (serviceContext == null) {
				smartActiveToproBenefitMapping.setCreateDate(date);
			}
			else {
				smartActiveToproBenefitMapping.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!smartActiveToproBenefitMappingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				smartActiveToproBenefitMapping.setModifiedDate(date);
			}
			else {
				smartActiveToproBenefitMapping.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(smartActiveToproBenefitMapping);
			}
			else {
				smartActiveToproBenefitMapping =
					(SmartActiveToproBenefitMapping)session.merge(
						smartActiveToproBenefitMapping);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SmartActiveToproBenefitMappingImpl.class,
			smartActiveToproBenefitMappingModelImpl, false, true);

		if (isNew) {
			smartActiveToproBenefitMapping.setNew(false);
		}

		smartActiveToproBenefitMapping.resetOriginalValues();

		return smartActiveToproBenefitMapping;
	}

	/**
	 * Returns the smart active topro benefit mapping with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the smart active topro benefit mapping
	 * @return the smart active topro benefit mapping
	 * @throws NoSuchSmartActiveToproBenefitMappingException if a smart active topro benefit mapping with the primary key could not be found
	 */
	@Override
	public SmartActiveToproBenefitMapping findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchSmartActiveToproBenefitMappingException {

		SmartActiveToproBenefitMapping smartActiveToproBenefitMapping =
			fetchByPrimaryKey(primaryKey);

		if (smartActiveToproBenefitMapping == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSmartActiveToproBenefitMappingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return smartActiveToproBenefitMapping;
	}

	/**
	 * Returns the smart active topro benefit mapping with the primary key or throws a <code>NoSuchSmartActiveToproBenefitMappingException</code> if it could not be found.
	 *
	 * @param smartActiveToproBenefitMappingId the primary key of the smart active topro benefit mapping
	 * @return the smart active topro benefit mapping
	 * @throws NoSuchSmartActiveToproBenefitMappingException if a smart active topro benefit mapping with the primary key could not be found
	 */
	@Override
	public SmartActiveToproBenefitMapping findByPrimaryKey(
			long smartActiveToproBenefitMappingId)
		throws NoSuchSmartActiveToproBenefitMappingException {

		return findByPrimaryKey((Serializable)smartActiveToproBenefitMappingId);
	}

	/**
	 * Returns the smart active topro benefit mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveToproBenefitMappingId the primary key of the smart active topro benefit mapping
	 * @return the smart active topro benefit mapping, or <code>null</code> if a smart active topro benefit mapping with the primary key could not be found
	 */
	@Override
	public SmartActiveToproBenefitMapping fetchByPrimaryKey(
		long smartActiveToproBenefitMappingId) {

		return fetchByPrimaryKey(
			(Serializable)smartActiveToproBenefitMappingId);
	}

	/**
	 * Returns all the smart active topro benefit mappings.
	 *
	 * @return the smart active topro benefit mappings
	 */
	@Override
	public List<SmartActiveToproBenefitMapping> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smart active topro benefit mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @return the range of smart active topro benefit mappings
	 */
	@Override
	public List<SmartActiveToproBenefitMapping> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart active topro benefit mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active topro benefit mappings
	 */
	@Override
	public List<SmartActiveToproBenefitMapping> findAll(
		int start, int end,
		OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart active topro benefit mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveToproBenefitMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active topro benefit mappings
	 * @param end the upper bound of the range of smart active topro benefit mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active topro benefit mappings
	 */
	@Override
	public List<SmartActiveToproBenefitMapping> findAll(
		int start, int end,
		OrderByComparator<SmartActiveToproBenefitMapping> orderByComparator,
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

		List<SmartActiveToproBenefitMapping> list = null;

		if (useFinderCache) {
			list = (List<SmartActiveToproBenefitMapping>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SMARTACTIVETOPROBENEFITMAPPING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SMARTACTIVETOPROBENEFITMAPPING;

				sql = sql.concat(
					SmartActiveToproBenefitMappingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SmartActiveToproBenefitMapping>)QueryUtil.list(
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
	 * Removes all the smart active topro benefit mappings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SmartActiveToproBenefitMapping smartActiveToproBenefitMapping :
				findAll()) {

			remove(smartActiveToproBenefitMapping);
		}
	}

	/**
	 * Returns the number of smart active topro benefit mappings.
	 *
	 * @return the number of smart active topro benefit mappings
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
					_SQL_COUNT_SMARTACTIVETOPROBENEFITMAPPING);

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
		return "smartActiveToproBenefitMappingId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SMARTACTIVETOPROBENEFITMAPPING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SmartActiveToproBenefitMappingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the smart active topro benefit mapping persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SmartActiveToproBenefitMappingModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name",
				SmartActiveToproBenefitMapping.class.getName()));

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

		_finderPathWithPaginationFindByToproId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByToproId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"smartActiveToproId"}, true);

		_finderPathWithoutPaginationFindByToproId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByToproId",
			new String[] {Long.class.getName()},
			new String[] {"smartActiveToproId"}, true);

		_finderPathCountByToproId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByToproId",
			new String[] {Long.class.getName()},
			new String[] {"smartActiveToproId"}, false);

		_setSmartActiveToproBenefitMappingUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSmartActiveToproBenefitMappingUtilPersistence(null);

		entityCache.removeCache(
			SmartActiveToproBenefitMappingImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setSmartActiveToproBenefitMappingUtilPersistence(
		SmartActiveToproBenefitMappingPersistence
			smartActiveToproBenefitMappingPersistence) {

		try {
			Field field =
				SmartActiveToproBenefitMappingUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, smartActiveToproBenefitMappingPersistence);
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

	private static final String _SQL_SELECT_SMARTACTIVETOPROBENEFITMAPPING =
		"SELECT smartActiveToproBenefitMapping FROM SmartActiveToproBenefitMapping smartActiveToproBenefitMapping";

	private static final String
		_SQL_SELECT_SMARTACTIVETOPROBENEFITMAPPING_WHERE =
			"SELECT smartActiveToproBenefitMapping FROM SmartActiveToproBenefitMapping smartActiveToproBenefitMapping WHERE ";

	private static final String _SQL_COUNT_SMARTACTIVETOPROBENEFITMAPPING =
		"SELECT COUNT(smartActiveToproBenefitMapping) FROM SmartActiveToproBenefitMapping smartActiveToproBenefitMapping";

	private static final String
		_SQL_COUNT_SMARTACTIVETOPROBENEFITMAPPING_WHERE =
			"SELECT COUNT(smartActiveToproBenefitMapping) FROM SmartActiveToproBenefitMapping smartActiveToproBenefitMapping WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"smartActiveToproBenefitMapping.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SmartActiveToproBenefitMapping exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SmartActiveToproBenefitMapping exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SmartActiveToproBenefitMappingPersistenceImpl.class);

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

	private static class SmartActiveToproBenefitMappingModelArgumentsResolver
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

			SmartActiveToproBenefitMappingModelImpl
				smartActiveToproBenefitMappingModelImpl =
					(SmartActiveToproBenefitMappingModelImpl)baseModel;

			long columnBitmask =
				smartActiveToproBenefitMappingModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					smartActiveToproBenefitMappingModelImpl, columnNames,
					original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						smartActiveToproBenefitMappingModelImpl.
							getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					smartActiveToproBenefitMappingModelImpl, columnNames,
					original);
			}

			return null;
		}

		private static Object[] _getValue(
			SmartActiveToproBenefitMappingModelImpl
				smartActiveToproBenefitMappingModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						smartActiveToproBenefitMappingModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						smartActiveToproBenefitMappingModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}