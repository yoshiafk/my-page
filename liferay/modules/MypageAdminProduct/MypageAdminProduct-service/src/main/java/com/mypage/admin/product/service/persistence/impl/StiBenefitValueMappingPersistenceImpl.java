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

import com.mypage.admin.product.exception.NoSuchStiBenefitValueMappingException;
import com.mypage.admin.product.model.StiBenefitValueMapping;
import com.mypage.admin.product.model.impl.StiBenefitValueMappingImpl;
import com.mypage.admin.product.model.impl.StiBenefitValueMappingModelImpl;
import com.mypage.admin.product.service.persistence.StiBenefitValueMappingPersistence;
import com.mypage.admin.product.service.persistence.StiBenefitValueMappingUtil;
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
 * The persistence implementation for the sti benefit value mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = StiBenefitValueMappingPersistence.class)
public class StiBenefitValueMappingPersistenceImpl
	extends BasePersistenceImpl<StiBenefitValueMapping>
	implements StiBenefitValueMappingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StiBenefitValueMappingUtil</code> to access the sti benefit value mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StiBenefitValueMappingImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByBenefitTypeId;
	private FinderPath _finderPathWithoutPaginationFindByBenefitTypeId;
	private FinderPath _finderPathCountByBenefitTypeId;

	/**
	 * Returns all the sti benefit value mappings where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @return the matching sti benefit value mappings
	 */
	@Override
	public List<StiBenefitValueMapping> findByBenefitTypeId(
		long benefitTypeId) {

		return findByBenefitTypeId(
			benefitTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sti benefit value mappings where benefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @return the range of matching sti benefit value mappings
	 */
	@Override
	public List<StiBenefitValueMapping> findByBenefitTypeId(
		long benefitTypeId, int start, int end) {

		return findByBenefitTypeId(benefitTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sti benefit value mappings where benefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sti benefit value mappings
	 */
	@Override
	public List<StiBenefitValueMapping> findByBenefitTypeId(
		long benefitTypeId, int start, int end,
		OrderByComparator<StiBenefitValueMapping> orderByComparator) {

		return findByBenefitTypeId(
			benefitTypeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sti benefit value mappings where benefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sti benefit value mappings
	 */
	@Override
	public List<StiBenefitValueMapping> findByBenefitTypeId(
		long benefitTypeId, int start, int end,
		OrderByComparator<StiBenefitValueMapping> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByBenefitTypeId;
				finderArgs = new Object[] {benefitTypeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBenefitTypeId;
			finderArgs = new Object[] {
				benefitTypeId, start, end, orderByComparator
			};
		}

		List<StiBenefitValueMapping> list = null;

		if (useFinderCache) {
			list = (List<StiBenefitValueMapping>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StiBenefitValueMapping stiBenefitValueMapping : list) {
					if (benefitTypeId !=
							stiBenefitValueMapping.getBenefitTypeId()) {

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

			sb.append(_SQL_SELECT_STIBENEFITVALUEMAPPING_WHERE);

			sb.append(_FINDER_COLUMN_BENEFITTYPEID_BENEFITTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StiBenefitValueMappingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(benefitTypeId);

				list = (List<StiBenefitValueMapping>)QueryUtil.list(
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
	 * Returns the first sti benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sti benefit value mapping
	 * @throws NoSuchStiBenefitValueMappingException if a matching sti benefit value mapping could not be found
	 */
	@Override
	public StiBenefitValueMapping findByBenefitTypeId_First(
			long benefitTypeId,
			OrderByComparator<StiBenefitValueMapping> orderByComparator)
		throws NoSuchStiBenefitValueMappingException {

		StiBenefitValueMapping stiBenefitValueMapping =
			fetchByBenefitTypeId_First(benefitTypeId, orderByComparator);

		if (stiBenefitValueMapping != null) {
			return stiBenefitValueMapping;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("benefitTypeId=");
		sb.append(benefitTypeId);

		sb.append("}");

		throw new NoSuchStiBenefitValueMappingException(sb.toString());
	}

	/**
	 * Returns the first sti benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sti benefit value mapping, or <code>null</code> if a matching sti benefit value mapping could not be found
	 */
	@Override
	public StiBenefitValueMapping fetchByBenefitTypeId_First(
		long benefitTypeId,
		OrderByComparator<StiBenefitValueMapping> orderByComparator) {

		List<StiBenefitValueMapping> list = findByBenefitTypeId(
			benefitTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sti benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sti benefit value mapping
	 * @throws NoSuchStiBenefitValueMappingException if a matching sti benefit value mapping could not be found
	 */
	@Override
	public StiBenefitValueMapping findByBenefitTypeId_Last(
			long benefitTypeId,
			OrderByComparator<StiBenefitValueMapping> orderByComparator)
		throws NoSuchStiBenefitValueMappingException {

		StiBenefitValueMapping stiBenefitValueMapping =
			fetchByBenefitTypeId_Last(benefitTypeId, orderByComparator);

		if (stiBenefitValueMapping != null) {
			return stiBenefitValueMapping;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("benefitTypeId=");
		sb.append(benefitTypeId);

		sb.append("}");

		throw new NoSuchStiBenefitValueMappingException(sb.toString());
	}

	/**
	 * Returns the last sti benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sti benefit value mapping, or <code>null</code> if a matching sti benefit value mapping could not be found
	 */
	@Override
	public StiBenefitValueMapping fetchByBenefitTypeId_Last(
		long benefitTypeId,
		OrderByComparator<StiBenefitValueMapping> orderByComparator) {

		int count = countByBenefitTypeId(benefitTypeId);

		if (count == 0) {
			return null;
		}

		List<StiBenefitValueMapping> list = findByBenefitTypeId(
			benefitTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sti benefit value mappings before and after the current sti benefit value mapping in the ordered set where benefitTypeId = &#63;.
	 *
	 * @param benefitValueMappingId the primary key of the current sti benefit value mapping
	 * @param benefitTypeId the benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sti benefit value mapping
	 * @throws NoSuchStiBenefitValueMappingException if a sti benefit value mapping with the primary key could not be found
	 */
	@Override
	public StiBenefitValueMapping[] findByBenefitTypeId_PrevAndNext(
			long benefitValueMappingId, long benefitTypeId,
			OrderByComparator<StiBenefitValueMapping> orderByComparator)
		throws NoSuchStiBenefitValueMappingException {

		StiBenefitValueMapping stiBenefitValueMapping = findByPrimaryKey(
			benefitValueMappingId);

		Session session = null;

		try {
			session = openSession();

			StiBenefitValueMapping[] array = new StiBenefitValueMappingImpl[3];

			array[0] = getByBenefitTypeId_PrevAndNext(
				session, stiBenefitValueMapping, benefitTypeId,
				orderByComparator, true);

			array[1] = stiBenefitValueMapping;

			array[2] = getByBenefitTypeId_PrevAndNext(
				session, stiBenefitValueMapping, benefitTypeId,
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

	protected StiBenefitValueMapping getByBenefitTypeId_PrevAndNext(
		Session session, StiBenefitValueMapping stiBenefitValueMapping,
		long benefitTypeId,
		OrderByComparator<StiBenefitValueMapping> orderByComparator,
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

		sb.append(_SQL_SELECT_STIBENEFITVALUEMAPPING_WHERE);

		sb.append(_FINDER_COLUMN_BENEFITTYPEID_BENEFITTYPEID_2);

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
			sb.append(StiBenefitValueMappingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(benefitTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						stiBenefitValueMapping)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StiBenefitValueMapping> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sti benefit value mappings where benefitTypeId = &#63; from the database.
	 *
	 * @param benefitTypeId the benefit type ID
	 */
	@Override
	public void removeByBenefitTypeId(long benefitTypeId) {
		for (StiBenefitValueMapping stiBenefitValueMapping :
				findByBenefitTypeId(
					benefitTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(stiBenefitValueMapping);
		}
	}

	/**
	 * Returns the number of sti benefit value mappings where benefitTypeId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @return the number of matching sti benefit value mappings
	 */
	@Override
	public int countByBenefitTypeId(long benefitTypeId) {
		FinderPath finderPath = _finderPathCountByBenefitTypeId;

		Object[] finderArgs = new Object[] {benefitTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STIBENEFITVALUEMAPPING_WHERE);

			sb.append(_FINDER_COLUMN_BENEFITTYPEID_BENEFITTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(benefitTypeId);

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

	private static final String _FINDER_COLUMN_BENEFITTYPEID_BENEFITTYPEID_2 =
		"stiBenefitValueMapping.benefitTypeId = ?";

	private FinderPath _finderPathWithPaginationFindByBenefitTypeIdAndBenefitId;
	private FinderPath
		_finderPathWithoutPaginationFindByBenefitTypeIdAndBenefitId;
	private FinderPath _finderPathCountByBenefitTypeIdAndBenefitId;

	/**
	 * Returns all the sti benefit value mappings where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @return the matching sti benefit value mappings
	 */
	@Override
	public List<StiBenefitValueMapping> findByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId) {

		return findByBenefitTypeIdAndBenefitId(
			benefitTypeId, benefitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the sti benefit value mappings where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @return the range of matching sti benefit value mappings
	 */
	@Override
	public List<StiBenefitValueMapping> findByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId, int start, int end) {

		return findByBenefitTypeIdAndBenefitId(
			benefitTypeId, benefitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sti benefit value mappings where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sti benefit value mappings
	 */
	@Override
	public List<StiBenefitValueMapping> findByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId, int start, int end,
		OrderByComparator<StiBenefitValueMapping> orderByComparator) {

		return findByBenefitTypeIdAndBenefitId(
			benefitTypeId, benefitId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sti benefit value mappings where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sti benefit value mappings
	 */
	@Override
	public List<StiBenefitValueMapping> findByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId, int start, int end,
		OrderByComparator<StiBenefitValueMapping> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByBenefitTypeIdAndBenefitId;
				finderArgs = new Object[] {benefitTypeId, benefitId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByBenefitTypeIdAndBenefitId;
			finderArgs = new Object[] {
				benefitTypeId, benefitId, start, end, orderByComparator
			};
		}

		List<StiBenefitValueMapping> list = null;

		if (useFinderCache) {
			list = (List<StiBenefitValueMapping>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StiBenefitValueMapping stiBenefitValueMapping : list) {
					if ((benefitTypeId !=
							stiBenefitValueMapping.getBenefitTypeId()) ||
						(benefitId != stiBenefitValueMapping.getBenefitId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_STIBENEFITVALUEMAPPING_WHERE);

			sb.append(_FINDER_COLUMN_BENEFITTYPEIDANDBENEFITID_BENEFITTYPEID_2);

			sb.append(_FINDER_COLUMN_BENEFITTYPEIDANDBENEFITID_BENEFITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StiBenefitValueMappingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(benefitTypeId);

				queryPos.add(benefitId);

				list = (List<StiBenefitValueMapping>)QueryUtil.list(
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
	 * Returns the first sti benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sti benefit value mapping
	 * @throws NoSuchStiBenefitValueMappingException if a matching sti benefit value mapping could not be found
	 */
	@Override
	public StiBenefitValueMapping findByBenefitTypeIdAndBenefitId_First(
			long benefitTypeId, long benefitId,
			OrderByComparator<StiBenefitValueMapping> orderByComparator)
		throws NoSuchStiBenefitValueMappingException {

		StiBenefitValueMapping stiBenefitValueMapping =
			fetchByBenefitTypeIdAndBenefitId_First(
				benefitTypeId, benefitId, orderByComparator);

		if (stiBenefitValueMapping != null) {
			return stiBenefitValueMapping;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("benefitTypeId=");
		sb.append(benefitTypeId);

		sb.append(", benefitId=");
		sb.append(benefitId);

		sb.append("}");

		throw new NoSuchStiBenefitValueMappingException(sb.toString());
	}

	/**
	 * Returns the first sti benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sti benefit value mapping, or <code>null</code> if a matching sti benefit value mapping could not be found
	 */
	@Override
	public StiBenefitValueMapping fetchByBenefitTypeIdAndBenefitId_First(
		long benefitTypeId, long benefitId,
		OrderByComparator<StiBenefitValueMapping> orderByComparator) {

		List<StiBenefitValueMapping> list = findByBenefitTypeIdAndBenefitId(
			benefitTypeId, benefitId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sti benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sti benefit value mapping
	 * @throws NoSuchStiBenefitValueMappingException if a matching sti benefit value mapping could not be found
	 */
	@Override
	public StiBenefitValueMapping findByBenefitTypeIdAndBenefitId_Last(
			long benefitTypeId, long benefitId,
			OrderByComparator<StiBenefitValueMapping> orderByComparator)
		throws NoSuchStiBenefitValueMappingException {

		StiBenefitValueMapping stiBenefitValueMapping =
			fetchByBenefitTypeIdAndBenefitId_Last(
				benefitTypeId, benefitId, orderByComparator);

		if (stiBenefitValueMapping != null) {
			return stiBenefitValueMapping;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("benefitTypeId=");
		sb.append(benefitTypeId);

		sb.append(", benefitId=");
		sb.append(benefitId);

		sb.append("}");

		throw new NoSuchStiBenefitValueMappingException(sb.toString());
	}

	/**
	 * Returns the last sti benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sti benefit value mapping, or <code>null</code> if a matching sti benefit value mapping could not be found
	 */
	@Override
	public StiBenefitValueMapping fetchByBenefitTypeIdAndBenefitId_Last(
		long benefitTypeId, long benefitId,
		OrderByComparator<StiBenefitValueMapping> orderByComparator) {

		int count = countByBenefitTypeIdAndBenefitId(benefitTypeId, benefitId);

		if (count == 0) {
			return null;
		}

		List<StiBenefitValueMapping> list = findByBenefitTypeIdAndBenefitId(
			benefitTypeId, benefitId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sti benefit value mappings before and after the current sti benefit value mapping in the ordered set where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitValueMappingId the primary key of the current sti benefit value mapping
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sti benefit value mapping
	 * @throws NoSuchStiBenefitValueMappingException if a sti benefit value mapping with the primary key could not be found
	 */
	@Override
	public StiBenefitValueMapping[] findByBenefitTypeIdAndBenefitId_PrevAndNext(
			long benefitValueMappingId, long benefitTypeId, long benefitId,
			OrderByComparator<StiBenefitValueMapping> orderByComparator)
		throws NoSuchStiBenefitValueMappingException {

		StiBenefitValueMapping stiBenefitValueMapping = findByPrimaryKey(
			benefitValueMappingId);

		Session session = null;

		try {
			session = openSession();

			StiBenefitValueMapping[] array = new StiBenefitValueMappingImpl[3];

			array[0] = getByBenefitTypeIdAndBenefitId_PrevAndNext(
				session, stiBenefitValueMapping, benefitTypeId, benefitId,
				orderByComparator, true);

			array[1] = stiBenefitValueMapping;

			array[2] = getByBenefitTypeIdAndBenefitId_PrevAndNext(
				session, stiBenefitValueMapping, benefitTypeId, benefitId,
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

	protected StiBenefitValueMapping getByBenefitTypeIdAndBenefitId_PrevAndNext(
		Session session, StiBenefitValueMapping stiBenefitValueMapping,
		long benefitTypeId, long benefitId,
		OrderByComparator<StiBenefitValueMapping> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_STIBENEFITVALUEMAPPING_WHERE);

		sb.append(_FINDER_COLUMN_BENEFITTYPEIDANDBENEFITID_BENEFITTYPEID_2);

		sb.append(_FINDER_COLUMN_BENEFITTYPEIDANDBENEFITID_BENEFITID_2);

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
			sb.append(StiBenefitValueMappingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(benefitTypeId);

		queryPos.add(benefitId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						stiBenefitValueMapping)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StiBenefitValueMapping> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sti benefit value mappings where benefitTypeId = &#63; and benefitId = &#63; from the database.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 */
	@Override
	public void removeByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId) {

		for (StiBenefitValueMapping stiBenefitValueMapping :
				findByBenefitTypeIdAndBenefitId(
					benefitTypeId, benefitId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(stiBenefitValueMapping);
		}
	}

	/**
	 * Returns the number of sti benefit value mappings where benefitTypeId = &#63; and benefitId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @return the number of matching sti benefit value mappings
	 */
	@Override
	public int countByBenefitTypeIdAndBenefitId(
		long benefitTypeId, long benefitId) {

		FinderPath finderPath = _finderPathCountByBenefitTypeIdAndBenefitId;

		Object[] finderArgs = new Object[] {benefitTypeId, benefitId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_STIBENEFITVALUEMAPPING_WHERE);

			sb.append(_FINDER_COLUMN_BENEFITTYPEIDANDBENEFITID_BENEFITTYPEID_2);

			sb.append(_FINDER_COLUMN_BENEFITTYPEIDANDBENEFITID_BENEFITID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(benefitTypeId);

				queryPos.add(benefitId);

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
		_FINDER_COLUMN_BENEFITTYPEIDANDBENEFITID_BENEFITTYPEID_2 =
			"stiBenefitValueMapping.benefitTypeId = ? AND ";

	private static final String
		_FINDER_COLUMN_BENEFITTYPEIDANDBENEFITID_BENEFITID_2 =
			"stiBenefitValueMapping.benefitId = ? AND stiBenefitValueMapping.active=1";

	private FinderPath _finderPathFetchByBenefitTypeIdAndBenefitIdAndPlanId;
	private FinderPath _finderPathCountByBenefitTypeIdAndBenefitIdAndPlanId;

	/**
	 * Returns the sti benefit value mapping where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63; or throws a <code>NoSuchStiBenefitValueMappingException</code> if it could not be found.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @return the matching sti benefit value mapping
	 * @throws NoSuchStiBenefitValueMappingException if a matching sti benefit value mapping could not be found
	 */
	@Override
	public StiBenefitValueMapping findByBenefitTypeIdAndBenefitIdAndPlanId(
			long benefitTypeId, long benefitId, long planId)
		throws NoSuchStiBenefitValueMappingException {

		StiBenefitValueMapping stiBenefitValueMapping =
			fetchByBenefitTypeIdAndBenefitIdAndPlanId(
				benefitTypeId, benefitId, planId);

		if (stiBenefitValueMapping == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("benefitTypeId=");
			sb.append(benefitTypeId);

			sb.append(", benefitId=");
			sb.append(benefitId);

			sb.append(", planId=");
			sb.append(planId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchStiBenefitValueMappingException(sb.toString());
		}

		return stiBenefitValueMapping;
	}

	/**
	 * Returns the sti benefit value mapping where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @return the matching sti benefit value mapping, or <code>null</code> if a matching sti benefit value mapping could not be found
	 */
	@Override
	public StiBenefitValueMapping fetchByBenefitTypeIdAndBenefitIdAndPlanId(
		long benefitTypeId, long benefitId, long planId) {

		return fetchByBenefitTypeIdAndBenefitIdAndPlanId(
			benefitTypeId, benefitId, planId, true);
	}

	/**
	 * Returns the sti benefit value mapping where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sti benefit value mapping, or <code>null</code> if a matching sti benefit value mapping could not be found
	 */
	@Override
	public StiBenefitValueMapping fetchByBenefitTypeIdAndBenefitIdAndPlanId(
		long benefitTypeId, long benefitId, long planId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {benefitTypeId, benefitId, planId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByBenefitTypeIdAndBenefitIdAndPlanId,
				finderArgs, this);
		}

		if (result instanceof StiBenefitValueMapping) {
			StiBenefitValueMapping stiBenefitValueMapping =
				(StiBenefitValueMapping)result;

			if ((benefitTypeId != stiBenefitValueMapping.getBenefitTypeId()) ||
				(benefitId != stiBenefitValueMapping.getBenefitId()) ||
				(planId != stiBenefitValueMapping.getPlanId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_STIBENEFITVALUEMAPPING_WHERE);

			sb.append(
				_FINDER_COLUMN_BENEFITTYPEIDANDBENEFITIDANDPLANID_BENEFITTYPEID_2);

			sb.append(
				_FINDER_COLUMN_BENEFITTYPEIDANDBENEFITIDANDPLANID_BENEFITID_2);

			sb.append(
				_FINDER_COLUMN_BENEFITTYPEIDANDBENEFITIDANDPLANID_PLANID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(benefitTypeId);

				queryPos.add(benefitId);

				queryPos.add(planId);

				List<StiBenefitValueMapping> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByBenefitTypeIdAndBenefitIdAndPlanId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									benefitTypeId, benefitId, planId
								};
							}

							_log.warn(
								"StiBenefitValueMappingPersistenceImpl.fetchByBenefitTypeIdAndBenefitIdAndPlanId(long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					StiBenefitValueMapping stiBenefitValueMapping = list.get(0);

					result = stiBenefitValueMapping;

					cacheResult(stiBenefitValueMapping);
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
			return (StiBenefitValueMapping)result;
		}
	}

	/**
	 * Removes the sti benefit value mapping where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63; from the database.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @return the sti benefit value mapping that was removed
	 */
	@Override
	public StiBenefitValueMapping removeByBenefitTypeIdAndBenefitIdAndPlanId(
			long benefitTypeId, long benefitId, long planId)
		throws NoSuchStiBenefitValueMappingException {

		StiBenefitValueMapping stiBenefitValueMapping =
			findByBenefitTypeIdAndBenefitIdAndPlanId(
				benefitTypeId, benefitId, planId);

		return remove(stiBenefitValueMapping);
	}

	/**
	 * Returns the number of sti benefit value mappings where benefitTypeId = &#63; and benefitId = &#63; and planId = &#63;.
	 *
	 * @param benefitTypeId the benefit type ID
	 * @param benefitId the benefit ID
	 * @param planId the plan ID
	 * @return the number of matching sti benefit value mappings
	 */
	@Override
	public int countByBenefitTypeIdAndBenefitIdAndPlanId(
		long benefitTypeId, long benefitId, long planId) {

		FinderPath finderPath =
			_finderPathCountByBenefitTypeIdAndBenefitIdAndPlanId;

		Object[] finderArgs = new Object[] {benefitTypeId, benefitId, planId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_STIBENEFITVALUEMAPPING_WHERE);

			sb.append(
				_FINDER_COLUMN_BENEFITTYPEIDANDBENEFITIDANDPLANID_BENEFITTYPEID_2);

			sb.append(
				_FINDER_COLUMN_BENEFITTYPEIDANDBENEFITIDANDPLANID_BENEFITID_2);

			sb.append(
				_FINDER_COLUMN_BENEFITTYPEIDANDBENEFITIDANDPLANID_PLANID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(benefitTypeId);

				queryPos.add(benefitId);

				queryPos.add(planId);

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
		_FINDER_COLUMN_BENEFITTYPEIDANDBENEFITIDANDPLANID_BENEFITTYPEID_2 =
			"stiBenefitValueMapping.benefitTypeId = ? AND ";

	private static final String
		_FINDER_COLUMN_BENEFITTYPEIDANDBENEFITIDANDPLANID_BENEFITID_2 =
			"stiBenefitValueMapping.benefitId = ? AND ";

	private static final String
		_FINDER_COLUMN_BENEFITTYPEIDANDBENEFITIDANDPLANID_PLANID_2 =
			"stiBenefitValueMapping.planId = ? AND stiBenefitValueMapping.active=1";

	public StiBenefitValueMappingPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(StiBenefitValueMapping.class);

		setModelImplClass(StiBenefitValueMappingImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the sti benefit value mapping in the entity cache if it is enabled.
	 *
	 * @param stiBenefitValueMapping the sti benefit value mapping
	 */
	@Override
	public void cacheResult(StiBenefitValueMapping stiBenefitValueMapping) {
		entityCache.putResult(
			StiBenefitValueMappingImpl.class,
			stiBenefitValueMapping.getPrimaryKey(), stiBenefitValueMapping);

		finderCache.putResult(
			_finderPathFetchByBenefitTypeIdAndBenefitIdAndPlanId,
			new Object[] {
				stiBenefitValueMapping.getBenefitTypeId(),
				stiBenefitValueMapping.getBenefitId(),
				stiBenefitValueMapping.getPlanId()
			},
			stiBenefitValueMapping);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sti benefit value mappings in the entity cache if it is enabled.
	 *
	 * @param stiBenefitValueMappings the sti benefit value mappings
	 */
	@Override
	public void cacheResult(
		List<StiBenefitValueMapping> stiBenefitValueMappings) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (stiBenefitValueMappings.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (StiBenefitValueMapping stiBenefitValueMapping :
				stiBenefitValueMappings) {

			if (entityCache.getResult(
					StiBenefitValueMappingImpl.class,
					stiBenefitValueMapping.getPrimaryKey()) == null) {

				cacheResult(stiBenefitValueMapping);
			}
		}
	}

	/**
	 * Clears the cache for all sti benefit value mappings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StiBenefitValueMappingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sti benefit value mapping.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StiBenefitValueMapping stiBenefitValueMapping) {
		entityCache.removeResult(
			StiBenefitValueMappingImpl.class, stiBenefitValueMapping);
	}

	@Override
	public void clearCache(
		List<StiBenefitValueMapping> stiBenefitValueMappings) {

		for (StiBenefitValueMapping stiBenefitValueMapping :
				stiBenefitValueMappings) {

			entityCache.removeResult(
				StiBenefitValueMappingImpl.class, stiBenefitValueMapping);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				StiBenefitValueMappingImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		StiBenefitValueMappingModelImpl stiBenefitValueMappingModelImpl) {

		Object[] args = new Object[] {
			stiBenefitValueMappingModelImpl.getBenefitTypeId(),
			stiBenefitValueMappingModelImpl.getBenefitId(),
			stiBenefitValueMappingModelImpl.getPlanId()
		};

		finderCache.putResult(
			_finderPathCountByBenefitTypeIdAndBenefitIdAndPlanId, args,
			Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByBenefitTypeIdAndBenefitIdAndPlanId, args,
			stiBenefitValueMappingModelImpl, false);
	}

	/**
	 * Creates a new sti benefit value mapping with the primary key. Does not add the sti benefit value mapping to the database.
	 *
	 * @param benefitValueMappingId the primary key for the new sti benefit value mapping
	 * @return the new sti benefit value mapping
	 */
	@Override
	public StiBenefitValueMapping create(long benefitValueMappingId) {
		StiBenefitValueMapping stiBenefitValueMapping =
			new StiBenefitValueMappingImpl();

		stiBenefitValueMapping.setNew(true);
		stiBenefitValueMapping.setPrimaryKey(benefitValueMappingId);

		stiBenefitValueMapping.setCompanyId(CompanyThreadLocal.getCompanyId());

		return stiBenefitValueMapping;
	}

	/**
	 * Removes the sti benefit value mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param benefitValueMappingId the primary key of the sti benefit value mapping
	 * @return the sti benefit value mapping that was removed
	 * @throws NoSuchStiBenefitValueMappingException if a sti benefit value mapping with the primary key could not be found
	 */
	@Override
	public StiBenefitValueMapping remove(long benefitValueMappingId)
		throws NoSuchStiBenefitValueMappingException {

		return remove((Serializable)benefitValueMappingId);
	}

	/**
	 * Removes the sti benefit value mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sti benefit value mapping
	 * @return the sti benefit value mapping that was removed
	 * @throws NoSuchStiBenefitValueMappingException if a sti benefit value mapping with the primary key could not be found
	 */
	@Override
	public StiBenefitValueMapping remove(Serializable primaryKey)
		throws NoSuchStiBenefitValueMappingException {

		Session session = null;

		try {
			session = openSession();

			StiBenefitValueMapping stiBenefitValueMapping =
				(StiBenefitValueMapping)session.get(
					StiBenefitValueMappingImpl.class, primaryKey);

			if (stiBenefitValueMapping == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStiBenefitValueMappingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stiBenefitValueMapping);
		}
		catch (NoSuchStiBenefitValueMappingException noSuchEntityException) {
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
	protected StiBenefitValueMapping removeImpl(
		StiBenefitValueMapping stiBenefitValueMapping) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stiBenefitValueMapping)) {
				stiBenefitValueMapping = (StiBenefitValueMapping)session.get(
					StiBenefitValueMappingImpl.class,
					stiBenefitValueMapping.getPrimaryKeyObj());
			}

			if (stiBenefitValueMapping != null) {
				session.delete(stiBenefitValueMapping);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stiBenefitValueMapping != null) {
			clearCache(stiBenefitValueMapping);
		}

		return stiBenefitValueMapping;
	}

	@Override
	public StiBenefitValueMapping updateImpl(
		StiBenefitValueMapping stiBenefitValueMapping) {

		boolean isNew = stiBenefitValueMapping.isNew();

		if (!(stiBenefitValueMapping instanceof
				StiBenefitValueMappingModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stiBenefitValueMapping.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					stiBenefitValueMapping);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stiBenefitValueMapping proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StiBenefitValueMapping implementation " +
					stiBenefitValueMapping.getClass());
		}

		StiBenefitValueMappingModelImpl stiBenefitValueMappingModelImpl =
			(StiBenefitValueMappingModelImpl)stiBenefitValueMapping;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (stiBenefitValueMapping.getCreateDate() == null)) {
			if (serviceContext == null) {
				stiBenefitValueMapping.setCreateDate(date);
			}
			else {
				stiBenefitValueMapping.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!stiBenefitValueMappingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				stiBenefitValueMapping.setModifiedDate(date);
			}
			else {
				stiBenefitValueMapping.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(stiBenefitValueMapping);
			}
			else {
				stiBenefitValueMapping = (StiBenefitValueMapping)session.merge(
					stiBenefitValueMapping);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			StiBenefitValueMappingImpl.class, stiBenefitValueMappingModelImpl,
			false, true);

		cacheUniqueFindersCache(stiBenefitValueMappingModelImpl);

		if (isNew) {
			stiBenefitValueMapping.setNew(false);
		}

		stiBenefitValueMapping.resetOriginalValues();

		return stiBenefitValueMapping;
	}

	/**
	 * Returns the sti benefit value mapping with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sti benefit value mapping
	 * @return the sti benefit value mapping
	 * @throws NoSuchStiBenefitValueMappingException if a sti benefit value mapping with the primary key could not be found
	 */
	@Override
	public StiBenefitValueMapping findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStiBenefitValueMappingException {

		StiBenefitValueMapping stiBenefitValueMapping = fetchByPrimaryKey(
			primaryKey);

		if (stiBenefitValueMapping == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStiBenefitValueMappingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stiBenefitValueMapping;
	}

	/**
	 * Returns the sti benefit value mapping with the primary key or throws a <code>NoSuchStiBenefitValueMappingException</code> if it could not be found.
	 *
	 * @param benefitValueMappingId the primary key of the sti benefit value mapping
	 * @return the sti benefit value mapping
	 * @throws NoSuchStiBenefitValueMappingException if a sti benefit value mapping with the primary key could not be found
	 */
	@Override
	public StiBenefitValueMapping findByPrimaryKey(long benefitValueMappingId)
		throws NoSuchStiBenefitValueMappingException {

		return findByPrimaryKey((Serializable)benefitValueMappingId);
	}

	/**
	 * Returns the sti benefit value mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param benefitValueMappingId the primary key of the sti benefit value mapping
	 * @return the sti benefit value mapping, or <code>null</code> if a sti benefit value mapping with the primary key could not be found
	 */
	@Override
	public StiBenefitValueMapping fetchByPrimaryKey(
		long benefitValueMappingId) {

		return fetchByPrimaryKey((Serializable)benefitValueMappingId);
	}

	/**
	 * Returns all the sti benefit value mappings.
	 *
	 * @return the sti benefit value mappings
	 */
	@Override
	public List<StiBenefitValueMapping> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sti benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @return the range of sti benefit value mappings
	 */
	@Override
	public List<StiBenefitValueMapping> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sti benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sti benefit value mappings
	 */
	@Override
	public List<StiBenefitValueMapping> findAll(
		int start, int end,
		OrderByComparator<StiBenefitValueMapping> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sti benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sti benefit value mappings
	 */
	@Override
	public List<StiBenefitValueMapping> findAll(
		int start, int end,
		OrderByComparator<StiBenefitValueMapping> orderByComparator,
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

		List<StiBenefitValueMapping> list = null;

		if (useFinderCache) {
			list = (List<StiBenefitValueMapping>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STIBENEFITVALUEMAPPING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STIBENEFITVALUEMAPPING;

				sql = sql.concat(StiBenefitValueMappingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StiBenefitValueMapping>)QueryUtil.list(
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
	 * Removes all the sti benefit value mappings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StiBenefitValueMapping stiBenefitValueMapping : findAll()) {
			remove(stiBenefitValueMapping);
		}
	}

	/**
	 * Returns the number of sti benefit value mappings.
	 *
	 * @return the number of sti benefit value mappings
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
					_SQL_COUNT_STIBENEFITVALUEMAPPING);

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
		return "benefitValueMappingId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STIBENEFITVALUEMAPPING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StiBenefitValueMappingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sti benefit value mapping persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new StiBenefitValueMappingModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", StiBenefitValueMapping.class.getName()));

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

		_finderPathWithPaginationFindByBenefitTypeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBenefitTypeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"benefitTypeId"}, true);

		_finderPathWithoutPaginationFindByBenefitTypeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBenefitTypeId",
			new String[] {Long.class.getName()}, new String[] {"benefitTypeId"},
			true);

		_finderPathCountByBenefitTypeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBenefitTypeId",
			new String[] {Long.class.getName()}, new String[] {"benefitTypeId"},
			false);

		_finderPathWithPaginationFindByBenefitTypeIdAndBenefitId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByBenefitTypeIdAndBenefitId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"benefitTypeId", "benefitId"}, true);

		_finderPathWithoutPaginationFindByBenefitTypeIdAndBenefitId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByBenefitTypeIdAndBenefitId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"benefitTypeId", "benefitId"}, true);

		_finderPathCountByBenefitTypeIdAndBenefitId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBenefitTypeIdAndBenefitId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"benefitTypeId", "benefitId"}, false);

		_finderPathFetchByBenefitTypeIdAndBenefitIdAndPlanId =
			_createFinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByBenefitTypeIdAndBenefitIdAndPlanId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {"benefitTypeId", "benefitId", "planId"}, true);

		_finderPathCountByBenefitTypeIdAndBenefitIdAndPlanId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByBenefitTypeIdAndBenefitIdAndPlanId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {"benefitTypeId", "benefitId", "planId"}, false);

		_setStiBenefitValueMappingUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setStiBenefitValueMappingUtilPersistence(null);

		entityCache.removeCache(StiBenefitValueMappingImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setStiBenefitValueMappingUtilPersistence(
		StiBenefitValueMappingPersistence stiBenefitValueMappingPersistence) {

		try {
			Field field = StiBenefitValueMappingUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, stiBenefitValueMappingPersistence);
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

	private static final String _SQL_SELECT_STIBENEFITVALUEMAPPING =
		"SELECT stiBenefitValueMapping FROM StiBenefitValueMapping stiBenefitValueMapping";

	private static final String _SQL_SELECT_STIBENEFITVALUEMAPPING_WHERE =
		"SELECT stiBenefitValueMapping FROM StiBenefitValueMapping stiBenefitValueMapping WHERE ";

	private static final String _SQL_COUNT_STIBENEFITVALUEMAPPING =
		"SELECT COUNT(stiBenefitValueMapping) FROM StiBenefitValueMapping stiBenefitValueMapping";

	private static final String _SQL_COUNT_STIBENEFITVALUEMAPPING_WHERE =
		"SELECT COUNT(stiBenefitValueMapping) FROM StiBenefitValueMapping stiBenefitValueMapping WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"stiBenefitValueMapping.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StiBenefitValueMapping exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No StiBenefitValueMapping exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StiBenefitValueMappingPersistenceImpl.class);

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

	private static class StiBenefitValueMappingModelArgumentsResolver
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

			StiBenefitValueMappingModelImpl stiBenefitValueMappingModelImpl =
				(StiBenefitValueMappingModelImpl)baseModel;

			long columnBitmask =
				stiBenefitValueMappingModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					stiBenefitValueMappingModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						stiBenefitValueMappingModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					stiBenefitValueMappingModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			StiBenefitValueMappingModelImpl stiBenefitValueMappingModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						stiBenefitValueMappingModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						stiBenefitValueMappingModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}