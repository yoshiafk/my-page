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

import com.mypage.admin.product.exception.NoSuchSmartActiveBenefitException;
import com.mypage.admin.product.model.SmartActiveBenefit;
import com.mypage.admin.product.model.impl.SmartActiveBenefitImpl;
import com.mypage.admin.product.model.impl.SmartActiveBenefitModelImpl;
import com.mypage.admin.product.service.persistence.SmartActiveBenefitPersistence;
import com.mypage.admin.product.service.persistence.SmartActiveBenefitUtil;
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
 * The persistence implementation for the smart active benefit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = SmartActiveBenefitPersistence.class)
public class SmartActiveBenefitPersistenceImpl
	extends BasePersistenceImpl<SmartActiveBenefit>
	implements SmartActiveBenefitPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SmartActiveBenefitUtil</code> to access the smart active benefit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SmartActiveBenefitImpl.class.getName();

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
	 * Returns all the smart active benefits where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @return the matching smart active benefits
	 */
	@Override
	public List<SmartActiveBenefit> findByBenefitTypeId(
		long smartActiveBenefitTypeId) {

		return findByBenefitTypeId(
			smartActiveBenefitTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the smart active benefits where smartActiveBenefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @return the range of matching smart active benefits
	 */
	@Override
	public List<SmartActiveBenefit> findByBenefitTypeId(
		long smartActiveBenefitTypeId, int start, int end) {

		return findByBenefitTypeId(smartActiveBenefitTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart active benefits where smartActiveBenefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smart active benefits
	 */
	@Override
	public List<SmartActiveBenefit> findByBenefitTypeId(
		long smartActiveBenefitTypeId, int start, int end,
		OrderByComparator<SmartActiveBenefit> orderByComparator) {

		return findByBenefitTypeId(
			smartActiveBenefitTypeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart active benefits where smartActiveBenefitTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smart active benefits
	 */
	@Override
	public List<SmartActiveBenefit> findByBenefitTypeId(
		long smartActiveBenefitTypeId, int start, int end,
		OrderByComparator<SmartActiveBenefit> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByBenefitTypeId;
				finderArgs = new Object[] {smartActiveBenefitTypeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBenefitTypeId;
			finderArgs = new Object[] {
				smartActiveBenefitTypeId, start, end, orderByComparator
			};
		}

		List<SmartActiveBenefit> list = null;

		if (useFinderCache) {
			list = (List<SmartActiveBenefit>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SmartActiveBenefit smartActiveBenefit : list) {
					if (smartActiveBenefitTypeId !=
							smartActiveBenefit.getSmartActiveBenefitTypeId()) {

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

			sb.append(_SQL_SELECT_SMARTACTIVEBENEFIT_WHERE);

			sb.append(_FINDER_COLUMN_BENEFITTYPEID_SMARTACTIVEBENEFITTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SmartActiveBenefitModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(smartActiveBenefitTypeId);

				list = (List<SmartActiveBenefit>)QueryUtil.list(
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
	 * Returns the first smart active benefit in the ordered set where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart active benefit
	 * @throws NoSuchSmartActiveBenefitException if a matching smart active benefit could not be found
	 */
	@Override
	public SmartActiveBenefit findByBenefitTypeId_First(
			long smartActiveBenefitTypeId,
			OrderByComparator<SmartActiveBenefit> orderByComparator)
		throws NoSuchSmartActiveBenefitException {

		SmartActiveBenefit smartActiveBenefit = fetchByBenefitTypeId_First(
			smartActiveBenefitTypeId, orderByComparator);

		if (smartActiveBenefit != null) {
			return smartActiveBenefit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("smartActiveBenefitTypeId=");
		sb.append(smartActiveBenefitTypeId);

		sb.append("}");

		throw new NoSuchSmartActiveBenefitException(sb.toString());
	}

	/**
	 * Returns the first smart active benefit in the ordered set where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart active benefit, or <code>null</code> if a matching smart active benefit could not be found
	 */
	@Override
	public SmartActiveBenefit fetchByBenefitTypeId_First(
		long smartActiveBenefitTypeId,
		OrderByComparator<SmartActiveBenefit> orderByComparator) {

		List<SmartActiveBenefit> list = findByBenefitTypeId(
			smartActiveBenefitTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last smart active benefit in the ordered set where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart active benefit
	 * @throws NoSuchSmartActiveBenefitException if a matching smart active benefit could not be found
	 */
	@Override
	public SmartActiveBenefit findByBenefitTypeId_Last(
			long smartActiveBenefitTypeId,
			OrderByComparator<SmartActiveBenefit> orderByComparator)
		throws NoSuchSmartActiveBenefitException {

		SmartActiveBenefit smartActiveBenefit = fetchByBenefitTypeId_Last(
			smartActiveBenefitTypeId, orderByComparator);

		if (smartActiveBenefit != null) {
			return smartActiveBenefit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("smartActiveBenefitTypeId=");
		sb.append(smartActiveBenefitTypeId);

		sb.append("}");

		throw new NoSuchSmartActiveBenefitException(sb.toString());
	}

	/**
	 * Returns the last smart active benefit in the ordered set where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart active benefit, or <code>null</code> if a matching smart active benefit could not be found
	 */
	@Override
	public SmartActiveBenefit fetchByBenefitTypeId_Last(
		long smartActiveBenefitTypeId,
		OrderByComparator<SmartActiveBenefit> orderByComparator) {

		int count = countByBenefitTypeId(smartActiveBenefitTypeId);

		if (count == 0) {
			return null;
		}

		List<SmartActiveBenefit> list = findByBenefitTypeId(
			smartActiveBenefitTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smart active benefits before and after the current smart active benefit in the ordered set where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitId the primary key of the current smart active benefit
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next smart active benefit
	 * @throws NoSuchSmartActiveBenefitException if a smart active benefit with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefit[] findByBenefitTypeId_PrevAndNext(
			long smartActiveBenefitId, long smartActiveBenefitTypeId,
			OrderByComparator<SmartActiveBenefit> orderByComparator)
		throws NoSuchSmartActiveBenefitException {

		SmartActiveBenefit smartActiveBenefit = findByPrimaryKey(
			smartActiveBenefitId);

		Session session = null;

		try {
			session = openSession();

			SmartActiveBenefit[] array = new SmartActiveBenefitImpl[3];

			array[0] = getByBenefitTypeId_PrevAndNext(
				session, smartActiveBenefit, smartActiveBenefitTypeId,
				orderByComparator, true);

			array[1] = smartActiveBenefit;

			array[2] = getByBenefitTypeId_PrevAndNext(
				session, smartActiveBenefit, smartActiveBenefitTypeId,
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

	protected SmartActiveBenefit getByBenefitTypeId_PrevAndNext(
		Session session, SmartActiveBenefit smartActiveBenefit,
		long smartActiveBenefitTypeId,
		OrderByComparator<SmartActiveBenefit> orderByComparator,
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

		sb.append(_SQL_SELECT_SMARTACTIVEBENEFIT_WHERE);

		sb.append(_FINDER_COLUMN_BENEFITTYPEID_SMARTACTIVEBENEFITTYPEID_2);

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
			sb.append(SmartActiveBenefitModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(smartActiveBenefitTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						smartActiveBenefit)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SmartActiveBenefit> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smart active benefits where smartActiveBenefitTypeId = &#63; from the database.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 */
	@Override
	public void removeByBenefitTypeId(long smartActiveBenefitTypeId) {
		for (SmartActiveBenefit smartActiveBenefit :
				findByBenefitTypeId(
					smartActiveBenefitTypeId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(smartActiveBenefit);
		}
	}

	/**
	 * Returns the number of smart active benefits where smartActiveBenefitTypeId = &#63;.
	 *
	 * @param smartActiveBenefitTypeId the smart active benefit type ID
	 * @return the number of matching smart active benefits
	 */
	@Override
	public int countByBenefitTypeId(long smartActiveBenefitTypeId) {
		FinderPath finderPath = _finderPathCountByBenefitTypeId;

		Object[] finderArgs = new Object[] {smartActiveBenefitTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SMARTACTIVEBENEFIT_WHERE);

			sb.append(_FINDER_COLUMN_BENEFITTYPEID_SMARTACTIVEBENEFITTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(smartActiveBenefitTypeId);

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
		_FINDER_COLUMN_BENEFITTYPEID_SMARTACTIVEBENEFITTYPEID_2 =
			"smartActiveBenefit.smartActiveBenefitTypeId = ?";

	private FinderPath _finderPathFetchByExternalCode;
	private FinderPath _finderPathCountByExternalCode;

	/**
	 * Returns the smart active benefit where externalCode = &#63; or throws a <code>NoSuchSmartActiveBenefitException</code> if it could not be found.
	 *
	 * @param externalCode the external code
	 * @return the matching smart active benefit
	 * @throws NoSuchSmartActiveBenefitException if a matching smart active benefit could not be found
	 */
	@Override
	public SmartActiveBenefit findByExternalCode(String externalCode)
		throws NoSuchSmartActiveBenefitException {

		SmartActiveBenefit smartActiveBenefit = fetchByExternalCode(
			externalCode);

		if (smartActiveBenefit == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("externalCode=");
			sb.append(externalCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSmartActiveBenefitException(sb.toString());
		}

		return smartActiveBenefit;
	}

	/**
	 * Returns the smart active benefit where externalCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCode the external code
	 * @return the matching smart active benefit, or <code>null</code> if a matching smart active benefit could not be found
	 */
	@Override
	public SmartActiveBenefit fetchByExternalCode(String externalCode) {
		return fetchByExternalCode(externalCode, true);
	}

	/**
	 * Returns the smart active benefit where externalCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCode the external code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active benefit, or <code>null</code> if a matching smart active benefit could not be found
	 */
	@Override
	public SmartActiveBenefit fetchByExternalCode(
		String externalCode, boolean useFinderCache) {

		externalCode = Objects.toString(externalCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {externalCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByExternalCode, finderArgs, this);
		}

		if (result instanceof SmartActiveBenefit) {
			SmartActiveBenefit smartActiveBenefit = (SmartActiveBenefit)result;

			if (!Objects.equals(
					externalCode, smartActiveBenefit.getExternalCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SMARTACTIVEBENEFIT_WHERE);

			boolean bindExternalCode = false;

			if (externalCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_EXTERNALCODE_EXTERNALCODE_3);
			}
			else {
				bindExternalCode = true;

				sb.append(_FINDER_COLUMN_EXTERNALCODE_EXTERNALCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindExternalCode) {
					queryPos.add(externalCode);
				}

				List<SmartActiveBenefit> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByExternalCode, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {externalCode};
							}

							_log.warn(
								"SmartActiveBenefitPersistenceImpl.fetchByExternalCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SmartActiveBenefit smartActiveBenefit = list.get(0);

					result = smartActiveBenefit;

					cacheResult(smartActiveBenefit);
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
			return (SmartActiveBenefit)result;
		}
	}

	/**
	 * Removes the smart active benefit where externalCode = &#63; from the database.
	 *
	 * @param externalCode the external code
	 * @return the smart active benefit that was removed
	 */
	@Override
	public SmartActiveBenefit removeByExternalCode(String externalCode)
		throws NoSuchSmartActiveBenefitException {

		SmartActiveBenefit smartActiveBenefit = findByExternalCode(
			externalCode);

		return remove(smartActiveBenefit);
	}

	/**
	 * Returns the number of smart active benefits where externalCode = &#63;.
	 *
	 * @param externalCode the external code
	 * @return the number of matching smart active benefits
	 */
	@Override
	public int countByExternalCode(String externalCode) {
		externalCode = Objects.toString(externalCode, "");

		FinderPath finderPath = _finderPathCountByExternalCode;

		Object[] finderArgs = new Object[] {externalCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SMARTACTIVEBENEFIT_WHERE);

			boolean bindExternalCode = false;

			if (externalCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_EXTERNALCODE_EXTERNALCODE_3);
			}
			else {
				bindExternalCode = true;

				sb.append(_FINDER_COLUMN_EXTERNALCODE_EXTERNALCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindExternalCode) {
					queryPos.add(externalCode);
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

	private static final String _FINDER_COLUMN_EXTERNALCODE_EXTERNALCODE_2 =
		"smartActiveBenefit.externalCode = ?";

	private static final String _FINDER_COLUMN_EXTERNALCODE_EXTERNALCODE_3 =
		"(smartActiveBenefit.externalCode IS NULL OR smartActiveBenefit.externalCode = '')";

	public SmartActiveBenefitPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SmartActiveBenefit.class);

		setModelImplClass(SmartActiveBenefitImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the smart active benefit in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefit the smart active benefit
	 */
	@Override
	public void cacheResult(SmartActiveBenefit smartActiveBenefit) {
		entityCache.putResult(
			SmartActiveBenefitImpl.class, smartActiveBenefit.getPrimaryKey(),
			smartActiveBenefit);

		finderCache.putResult(
			_finderPathFetchByExternalCode,
			new Object[] {smartActiveBenefit.getExternalCode()},
			smartActiveBenefit);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the smart active benefits in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefits the smart active benefits
	 */
	@Override
	public void cacheResult(List<SmartActiveBenefit> smartActiveBenefits) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (smartActiveBenefits.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SmartActiveBenefit smartActiveBenefit : smartActiveBenefits) {
			if (entityCache.getResult(
					SmartActiveBenefitImpl.class,
					smartActiveBenefit.getPrimaryKey()) == null) {

				cacheResult(smartActiveBenefit);
			}
		}
	}

	/**
	 * Clears the cache for all smart active benefits.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SmartActiveBenefitImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the smart active benefit.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SmartActiveBenefit smartActiveBenefit) {
		entityCache.removeResult(
			SmartActiveBenefitImpl.class, smartActiveBenefit);
	}

	@Override
	public void clearCache(List<SmartActiveBenefit> smartActiveBenefits) {
		for (SmartActiveBenefit smartActiveBenefit : smartActiveBenefits) {
			entityCache.removeResult(
				SmartActiveBenefitImpl.class, smartActiveBenefit);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SmartActiveBenefitImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SmartActiveBenefitModelImpl smartActiveBenefitModelImpl) {

		Object[] args = new Object[] {
			smartActiveBenefitModelImpl.getExternalCode()
		};

		finderCache.putResult(
			_finderPathCountByExternalCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByExternalCode, args, smartActiveBenefitModelImpl,
			false);
	}

	/**
	 * Creates a new smart active benefit with the primary key. Does not add the smart active benefit to the database.
	 *
	 * @param smartActiveBenefitId the primary key for the new smart active benefit
	 * @return the new smart active benefit
	 */
	@Override
	public SmartActiveBenefit create(long smartActiveBenefitId) {
		SmartActiveBenefit smartActiveBenefit = new SmartActiveBenefitImpl();

		smartActiveBenefit.setNew(true);
		smartActiveBenefit.setPrimaryKey(smartActiveBenefitId);

		smartActiveBenefit.setCompanyId(CompanyThreadLocal.getCompanyId());

		return smartActiveBenefit;
	}

	/**
	 * Removes the smart active benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveBenefitId the primary key of the smart active benefit
	 * @return the smart active benefit that was removed
	 * @throws NoSuchSmartActiveBenefitException if a smart active benefit with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefit remove(long smartActiveBenefitId)
		throws NoSuchSmartActiveBenefitException {

		return remove((Serializable)smartActiveBenefitId);
	}

	/**
	 * Removes the smart active benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the smart active benefit
	 * @return the smart active benefit that was removed
	 * @throws NoSuchSmartActiveBenefitException if a smart active benefit with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefit remove(Serializable primaryKey)
		throws NoSuchSmartActiveBenefitException {

		Session session = null;

		try {
			session = openSession();

			SmartActiveBenefit smartActiveBenefit =
				(SmartActiveBenefit)session.get(
					SmartActiveBenefitImpl.class, primaryKey);

			if (smartActiveBenefit == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSmartActiveBenefitException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(smartActiveBenefit);
		}
		catch (NoSuchSmartActiveBenefitException noSuchEntityException) {
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
	protected SmartActiveBenefit removeImpl(
		SmartActiveBenefit smartActiveBenefit) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(smartActiveBenefit)) {
				smartActiveBenefit = (SmartActiveBenefit)session.get(
					SmartActiveBenefitImpl.class,
					smartActiveBenefit.getPrimaryKeyObj());
			}

			if (smartActiveBenefit != null) {
				session.delete(smartActiveBenefit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (smartActiveBenefit != null) {
			clearCache(smartActiveBenefit);
		}

		return smartActiveBenefit;
	}

	@Override
	public SmartActiveBenefit updateImpl(
		SmartActiveBenefit smartActiveBenefit) {

		boolean isNew = smartActiveBenefit.isNew();

		if (!(smartActiveBenefit instanceof SmartActiveBenefitModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(smartActiveBenefit.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					smartActiveBenefit);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in smartActiveBenefit proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SmartActiveBenefit implementation " +
					smartActiveBenefit.getClass());
		}

		SmartActiveBenefitModelImpl smartActiveBenefitModelImpl =
			(SmartActiveBenefitModelImpl)smartActiveBenefit;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (smartActiveBenefit.getCreateDate() == null)) {
			if (serviceContext == null) {
				smartActiveBenefit.setCreateDate(date);
			}
			else {
				smartActiveBenefit.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!smartActiveBenefitModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				smartActiveBenefit.setModifiedDate(date);
			}
			else {
				smartActiveBenefit.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(smartActiveBenefit);
			}
			else {
				smartActiveBenefit = (SmartActiveBenefit)session.merge(
					smartActiveBenefit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SmartActiveBenefitImpl.class, smartActiveBenefitModelImpl, false,
			true);

		cacheUniqueFindersCache(smartActiveBenefitModelImpl);

		if (isNew) {
			smartActiveBenefit.setNew(false);
		}

		smartActiveBenefit.resetOriginalValues();

		return smartActiveBenefit;
	}

	/**
	 * Returns the smart active benefit with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the smart active benefit
	 * @return the smart active benefit
	 * @throws NoSuchSmartActiveBenefitException if a smart active benefit with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSmartActiveBenefitException {

		SmartActiveBenefit smartActiveBenefit = fetchByPrimaryKey(primaryKey);

		if (smartActiveBenefit == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSmartActiveBenefitException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return smartActiveBenefit;
	}

	/**
	 * Returns the smart active benefit with the primary key or throws a <code>NoSuchSmartActiveBenefitException</code> if it could not be found.
	 *
	 * @param smartActiveBenefitId the primary key of the smart active benefit
	 * @return the smart active benefit
	 * @throws NoSuchSmartActiveBenefitException if a smart active benefit with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefit findByPrimaryKey(long smartActiveBenefitId)
		throws NoSuchSmartActiveBenefitException {

		return findByPrimaryKey((Serializable)smartActiveBenefitId);
	}

	/**
	 * Returns the smart active benefit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveBenefitId the primary key of the smart active benefit
	 * @return the smart active benefit, or <code>null</code> if a smart active benefit with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefit fetchByPrimaryKey(long smartActiveBenefitId) {
		return fetchByPrimaryKey((Serializable)smartActiveBenefitId);
	}

	/**
	 * Returns all the smart active benefits.
	 *
	 * @return the smart active benefits
	 */
	@Override
	public List<SmartActiveBenefit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smart active benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @return the range of smart active benefits
	 */
	@Override
	public List<SmartActiveBenefit> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart active benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active benefits
	 */
	@Override
	public List<SmartActiveBenefit> findAll(
		int start, int end,
		OrderByComparator<SmartActiveBenefit> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart active benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active benefits
	 */
	@Override
	public List<SmartActiveBenefit> findAll(
		int start, int end,
		OrderByComparator<SmartActiveBenefit> orderByComparator,
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

		List<SmartActiveBenefit> list = null;

		if (useFinderCache) {
			list = (List<SmartActiveBenefit>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SMARTACTIVEBENEFIT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SMARTACTIVEBENEFIT;

				sql = sql.concat(SmartActiveBenefitModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SmartActiveBenefit>)QueryUtil.list(
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
	 * Removes all the smart active benefits from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SmartActiveBenefit smartActiveBenefit : findAll()) {
			remove(smartActiveBenefit);
		}
	}

	/**
	 * Returns the number of smart active benefits.
	 *
	 * @return the number of smart active benefits
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
					_SQL_COUNT_SMARTACTIVEBENEFIT);

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
		return "smartActiveBenefitId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SMARTACTIVEBENEFIT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SmartActiveBenefitModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the smart active benefit persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SmartActiveBenefitModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SmartActiveBenefit.class.getName()));

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
			new String[] {"smartActiveBenefitTypeId"}, true);

		_finderPathWithoutPaginationFindByBenefitTypeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBenefitTypeId",
			new String[] {Long.class.getName()},
			new String[] {"smartActiveBenefitTypeId"}, true);

		_finderPathCountByBenefitTypeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBenefitTypeId",
			new String[] {Long.class.getName()},
			new String[] {"smartActiveBenefitTypeId"}, false);

		_finderPathFetchByExternalCode = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByExternalCode",
			new String[] {String.class.getName()},
			new String[] {"externalCode"}, true);

		_finderPathCountByExternalCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExternalCode",
			new String[] {String.class.getName()},
			new String[] {"externalCode"}, false);

		_setSmartActiveBenefitUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSmartActiveBenefitUtilPersistence(null);

		entityCache.removeCache(SmartActiveBenefitImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setSmartActiveBenefitUtilPersistence(
		SmartActiveBenefitPersistence smartActiveBenefitPersistence) {

		try {
			Field field = SmartActiveBenefitUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, smartActiveBenefitPersistence);
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

	private static final String _SQL_SELECT_SMARTACTIVEBENEFIT =
		"SELECT smartActiveBenefit FROM SmartActiveBenefit smartActiveBenefit";

	private static final String _SQL_SELECT_SMARTACTIVEBENEFIT_WHERE =
		"SELECT smartActiveBenefit FROM SmartActiveBenefit smartActiveBenefit WHERE ";

	private static final String _SQL_COUNT_SMARTACTIVEBENEFIT =
		"SELECT COUNT(smartActiveBenefit) FROM SmartActiveBenefit smartActiveBenefit";

	private static final String _SQL_COUNT_SMARTACTIVEBENEFIT_WHERE =
		"SELECT COUNT(smartActiveBenefit) FROM SmartActiveBenefit smartActiveBenefit WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "smartActiveBenefit.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SmartActiveBenefit exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SmartActiveBenefit exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SmartActiveBenefitPersistenceImpl.class);

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

	private static class SmartActiveBenefitModelArgumentsResolver
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

			SmartActiveBenefitModelImpl smartActiveBenefitModelImpl =
				(SmartActiveBenefitModelImpl)baseModel;

			long columnBitmask = smartActiveBenefitModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					smartActiveBenefitModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						smartActiveBenefitModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					smartActiveBenefitModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SmartActiveBenefitModelImpl smartActiveBenefitModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						smartActiveBenefitModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = smartActiveBenefitModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}