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

import com.mypage.admin.product.exception.NoSuchTravelDomesticTravellerTypeException;
import com.mypage.admin.product.model.TravelDomesticTravellerType;
import com.mypage.admin.product.model.impl.TravelDomesticTravellerTypeImpl;
import com.mypage.admin.product.model.impl.TravelDomesticTravellerTypeModelImpl;
import com.mypage.admin.product.service.persistence.TravelDomesticTravellerTypePersistence;
import com.mypage.admin.product.service.persistence.TravelDomesticTravellerTypeUtil;
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
 * The persistence implementation for the travel domestic traveller type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = TravelDomesticTravellerTypePersistence.class)
public class TravelDomesticTravellerTypePersistenceImpl
	extends BasePersistenceImpl<TravelDomesticTravellerType>
	implements TravelDomesticTravellerTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TravelDomesticTravellerTypeUtil</code> to access the travel domestic traveller type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TravelDomesticTravellerTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBysearchTravellerTypeId;
	private FinderPath _finderPathWithoutPaginationFindBysearchTravellerTypeId;
	private FinderPath _finderPathCountBysearchTravellerTypeId;

	/**
	 * Returns all the travel domestic traveller types where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @return the matching travel domestic traveller types
	 */
	@Override
	public List<TravelDomesticTravellerType> findBysearchTravellerTypeId(
		long travellerTypeId) {

		return findBysearchTravellerTypeId(
			travellerTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel domestic traveller types where travellerTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @return the range of matching travel domestic traveller types
	 */
	@Override
	public List<TravelDomesticTravellerType> findBysearchTravellerTypeId(
		long travellerTypeId, int start, int end) {

		return findBysearchTravellerTypeId(travellerTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel domestic traveller types where travellerTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic traveller types
	 */
	@Override
	public List<TravelDomesticTravellerType> findBysearchTravellerTypeId(
		long travellerTypeId, int start, int end,
		OrderByComparator<TravelDomesticTravellerType> orderByComparator) {

		return findBysearchTravellerTypeId(
			travellerTypeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic traveller types where travellerTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic traveller types
	 */
	@Override
	public List<TravelDomesticTravellerType> findBysearchTravellerTypeId(
		long travellerTypeId, int start, int end,
		OrderByComparator<TravelDomesticTravellerType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBysearchTravellerTypeId;
				finderArgs = new Object[] {travellerTypeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchTravellerTypeId;
			finderArgs = new Object[] {
				travellerTypeId, start, end, orderByComparator
			};
		}

		List<TravelDomesticTravellerType> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticTravellerType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelDomesticTravellerType travelDomesticTravellerType :
						list) {

					if (travellerTypeId !=
							travelDomesticTravellerType.getTravellerTypeId()) {

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

			sb.append(_SQL_SELECT_TRAVELDOMESTICTRAVELLERTYPE_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHTRAVELLERTYPEID_TRAVELLERTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelDomesticTravellerTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(travellerTypeId);

				list = (List<TravelDomesticTravellerType>)QueryUtil.list(
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
	 * Returns the first travel domestic traveller type in the ordered set where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic traveller type
	 * @throws NoSuchTravelDomesticTravellerTypeException if a matching travel domestic traveller type could not be found
	 */
	@Override
	public TravelDomesticTravellerType findBysearchTravellerTypeId_First(
			long travellerTypeId,
			OrderByComparator<TravelDomesticTravellerType> orderByComparator)
		throws NoSuchTravelDomesticTravellerTypeException {

		TravelDomesticTravellerType travelDomesticTravellerType =
			fetchBysearchTravellerTypeId_First(
				travellerTypeId, orderByComparator);

		if (travelDomesticTravellerType != null) {
			return travelDomesticTravellerType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travellerTypeId=");
		sb.append(travellerTypeId);

		sb.append("}");

		throw new NoSuchTravelDomesticTravellerTypeException(sb.toString());
	}

	/**
	 * Returns the first travel domestic traveller type in the ordered set where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic traveller type, or <code>null</code> if a matching travel domestic traveller type could not be found
	 */
	@Override
	public TravelDomesticTravellerType fetchBysearchTravellerTypeId_First(
		long travellerTypeId,
		OrderByComparator<TravelDomesticTravellerType> orderByComparator) {

		List<TravelDomesticTravellerType> list = findBysearchTravellerTypeId(
			travellerTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel domestic traveller type in the ordered set where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic traveller type
	 * @throws NoSuchTravelDomesticTravellerTypeException if a matching travel domestic traveller type could not be found
	 */
	@Override
	public TravelDomesticTravellerType findBysearchTravellerTypeId_Last(
			long travellerTypeId,
			OrderByComparator<TravelDomesticTravellerType> orderByComparator)
		throws NoSuchTravelDomesticTravellerTypeException {

		TravelDomesticTravellerType travelDomesticTravellerType =
			fetchBysearchTravellerTypeId_Last(
				travellerTypeId, orderByComparator);

		if (travelDomesticTravellerType != null) {
			return travelDomesticTravellerType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travellerTypeId=");
		sb.append(travellerTypeId);

		sb.append("}");

		throw new NoSuchTravelDomesticTravellerTypeException(sb.toString());
	}

	/**
	 * Returns the last travel domestic traveller type in the ordered set where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic traveller type, or <code>null</code> if a matching travel domestic traveller type could not be found
	 */
	@Override
	public TravelDomesticTravellerType fetchBysearchTravellerTypeId_Last(
		long travellerTypeId,
		OrderByComparator<TravelDomesticTravellerType> orderByComparator) {

		int count = countBysearchTravellerTypeId(travellerTypeId);

		if (count == 0) {
			return null;
		}

		List<TravelDomesticTravellerType> list = findBysearchTravellerTypeId(
			travellerTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the travel domestic traveller types where travellerTypeId = &#63; from the database.
	 *
	 * @param travellerTypeId the traveller type ID
	 */
	@Override
	public void removeBysearchTravellerTypeId(long travellerTypeId) {
		for (TravelDomesticTravellerType travelDomesticTravellerType :
				findBysearchTravellerTypeId(
					travellerTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(travelDomesticTravellerType);
		}
	}

	/**
	 * Returns the number of travel domestic traveller types where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @return the number of matching travel domestic traveller types
	 */
	@Override
	public int countBysearchTravellerTypeId(long travellerTypeId) {
		FinderPath finderPath = _finderPathCountBysearchTravellerTypeId;

		Object[] finderArgs = new Object[] {travellerTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAVELDOMESTICTRAVELLERTYPE_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHTRAVELLERTYPEID_TRAVELLERTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(travellerTypeId);

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
		_FINDER_COLUMN_SEARCHTRAVELLERTYPEID_TRAVELLERTYPEID_2 =
			"travelDomesticTravellerType.travellerTypeId = ?";

	public TravelDomesticTravellerTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TravelDomesticTravellerType.class);

		setModelImplClass(TravelDomesticTravellerTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the travel domestic traveller type in the entity cache if it is enabled.
	 *
	 * @param travelDomesticTravellerType the travel domestic traveller type
	 */
	@Override
	public void cacheResult(
		TravelDomesticTravellerType travelDomesticTravellerType) {

		entityCache.putResult(
			TravelDomesticTravellerTypeImpl.class,
			travelDomesticTravellerType.getPrimaryKey(),
			travelDomesticTravellerType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the travel domestic traveller types in the entity cache if it is enabled.
	 *
	 * @param travelDomesticTravellerTypes the travel domestic traveller types
	 */
	@Override
	public void cacheResult(
		List<TravelDomesticTravellerType> travelDomesticTravellerTypes) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (travelDomesticTravellerTypes.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TravelDomesticTravellerType travelDomesticTravellerType :
				travelDomesticTravellerTypes) {

			if (entityCache.getResult(
					TravelDomesticTravellerTypeImpl.class,
					travelDomesticTravellerType.getPrimaryKey()) == null) {

				cacheResult(travelDomesticTravellerType);
			}
		}
	}

	/**
	 * Clears the cache for all travel domestic traveller types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TravelDomesticTravellerTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the travel domestic traveller type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		TravelDomesticTravellerType travelDomesticTravellerType) {

		entityCache.removeResult(
			TravelDomesticTravellerTypeImpl.class, travelDomesticTravellerType);
	}

	@Override
	public void clearCache(
		List<TravelDomesticTravellerType> travelDomesticTravellerTypes) {

		for (TravelDomesticTravellerType travelDomesticTravellerType :
				travelDomesticTravellerTypes) {

			entityCache.removeResult(
				TravelDomesticTravellerTypeImpl.class,
				travelDomesticTravellerType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				TravelDomesticTravellerTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new travel domestic traveller type with the primary key. Does not add the travel domestic traveller type to the database.
	 *
	 * @param travellerTypeId the primary key for the new travel domestic traveller type
	 * @return the new travel domestic traveller type
	 */
	@Override
	public TravelDomesticTravellerType create(long travellerTypeId) {
		TravelDomesticTravellerType travelDomesticTravellerType =
			new TravelDomesticTravellerTypeImpl();

		travelDomesticTravellerType.setNew(true);
		travelDomesticTravellerType.setPrimaryKey(travellerTypeId);

		travelDomesticTravellerType.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return travelDomesticTravellerType;
	}

	/**
	 * Removes the travel domestic traveller type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travellerTypeId the primary key of the travel domestic traveller type
	 * @return the travel domestic traveller type that was removed
	 * @throws NoSuchTravelDomesticTravellerTypeException if a travel domestic traveller type with the primary key could not be found
	 */
	@Override
	public TravelDomesticTravellerType remove(long travellerTypeId)
		throws NoSuchTravelDomesticTravellerTypeException {

		return remove((Serializable)travellerTypeId);
	}

	/**
	 * Removes the travel domestic traveller type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the travel domestic traveller type
	 * @return the travel domestic traveller type that was removed
	 * @throws NoSuchTravelDomesticTravellerTypeException if a travel domestic traveller type with the primary key could not be found
	 */
	@Override
	public TravelDomesticTravellerType remove(Serializable primaryKey)
		throws NoSuchTravelDomesticTravellerTypeException {

		Session session = null;

		try {
			session = openSession();

			TravelDomesticTravellerType travelDomesticTravellerType =
				(TravelDomesticTravellerType)session.get(
					TravelDomesticTravellerTypeImpl.class, primaryKey);

			if (travelDomesticTravellerType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTravelDomesticTravellerTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(travelDomesticTravellerType);
		}
		catch (NoSuchTravelDomesticTravellerTypeException
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
	protected TravelDomesticTravellerType removeImpl(
		TravelDomesticTravellerType travelDomesticTravellerType) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(travelDomesticTravellerType)) {
				travelDomesticTravellerType =
					(TravelDomesticTravellerType)session.get(
						TravelDomesticTravellerTypeImpl.class,
						travelDomesticTravellerType.getPrimaryKeyObj());
			}

			if (travelDomesticTravellerType != null) {
				session.delete(travelDomesticTravellerType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (travelDomesticTravellerType != null) {
			clearCache(travelDomesticTravellerType);
		}

		return travelDomesticTravellerType;
	}

	@Override
	public TravelDomesticTravellerType updateImpl(
		TravelDomesticTravellerType travelDomesticTravellerType) {

		boolean isNew = travelDomesticTravellerType.isNew();

		if (!(travelDomesticTravellerType instanceof
				TravelDomesticTravellerTypeModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					travelDomesticTravellerType.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					travelDomesticTravellerType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in travelDomesticTravellerType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TravelDomesticTravellerType implementation " +
					travelDomesticTravellerType.getClass());
		}

		TravelDomesticTravellerTypeModelImpl
			travelDomesticTravellerTypeModelImpl =
				(TravelDomesticTravellerTypeModelImpl)
					travelDomesticTravellerType;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (travelDomesticTravellerType.getCreateDate() == null)) {
			if (serviceContext == null) {
				travelDomesticTravellerType.setCreateDate(date);
			}
			else {
				travelDomesticTravellerType.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!travelDomesticTravellerTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				travelDomesticTravellerType.setModifiedDate(date);
			}
			else {
				travelDomesticTravellerType.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(travelDomesticTravellerType);
			}
			else {
				travelDomesticTravellerType =
					(TravelDomesticTravellerType)session.merge(
						travelDomesticTravellerType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TravelDomesticTravellerTypeImpl.class,
			travelDomesticTravellerTypeModelImpl, false, true);

		if (isNew) {
			travelDomesticTravellerType.setNew(false);
		}

		travelDomesticTravellerType.resetOriginalValues();

		return travelDomesticTravellerType;
	}

	/**
	 * Returns the travel domestic traveller type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the travel domestic traveller type
	 * @return the travel domestic traveller type
	 * @throws NoSuchTravelDomesticTravellerTypeException if a travel domestic traveller type with the primary key could not be found
	 */
	@Override
	public TravelDomesticTravellerType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTravelDomesticTravellerTypeException {

		TravelDomesticTravellerType travelDomesticTravellerType =
			fetchByPrimaryKey(primaryKey);

		if (travelDomesticTravellerType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTravelDomesticTravellerTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return travelDomesticTravellerType;
	}

	/**
	 * Returns the travel domestic traveller type with the primary key or throws a <code>NoSuchTravelDomesticTravellerTypeException</code> if it could not be found.
	 *
	 * @param travellerTypeId the primary key of the travel domestic traveller type
	 * @return the travel domestic traveller type
	 * @throws NoSuchTravelDomesticTravellerTypeException if a travel domestic traveller type with the primary key could not be found
	 */
	@Override
	public TravelDomesticTravellerType findByPrimaryKey(long travellerTypeId)
		throws NoSuchTravelDomesticTravellerTypeException {

		return findByPrimaryKey((Serializable)travellerTypeId);
	}

	/**
	 * Returns the travel domestic traveller type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travellerTypeId the primary key of the travel domestic traveller type
	 * @return the travel domestic traveller type, or <code>null</code> if a travel domestic traveller type with the primary key could not be found
	 */
	@Override
	public TravelDomesticTravellerType fetchByPrimaryKey(long travellerTypeId) {
		return fetchByPrimaryKey((Serializable)travellerTypeId);
	}

	/**
	 * Returns all the travel domestic traveller types.
	 *
	 * @return the travel domestic traveller types
	 */
	@Override
	public List<TravelDomesticTravellerType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel domestic traveller types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @return the range of travel domestic traveller types
	 */
	@Override
	public List<TravelDomesticTravellerType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel domestic traveller types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic traveller types
	 */
	@Override
	public List<TravelDomesticTravellerType> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticTravellerType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic traveller types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic traveller types
	 */
	@Override
	public List<TravelDomesticTravellerType> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticTravellerType> orderByComparator,
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

		List<TravelDomesticTravellerType> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticTravellerType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAVELDOMESTICTRAVELLERTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAVELDOMESTICTRAVELLERTYPE;

				sql = sql.concat(
					TravelDomesticTravellerTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TravelDomesticTravellerType>)QueryUtil.list(
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
	 * Removes all the travel domestic traveller types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TravelDomesticTravellerType travelDomesticTravellerType :
				findAll()) {

			remove(travelDomesticTravellerType);
		}
	}

	/**
	 * Returns the number of travel domestic traveller types.
	 *
	 * @return the number of travel domestic traveller types
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
					_SQL_COUNT_TRAVELDOMESTICTRAVELLERTYPE);

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
		return "travellerTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAVELDOMESTICTRAVELLERTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TravelDomesticTravellerTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the travel domestic traveller type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new TravelDomesticTravellerTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name",
				TravelDomesticTravellerType.class.getName()));

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

		_finderPathWithPaginationFindBysearchTravellerTypeId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBysearchTravellerTypeId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"travellerTypeId"}, true);

		_finderPathWithoutPaginationFindBysearchTravellerTypeId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBysearchTravellerTypeId",
				new String[] {Long.class.getName()},
				new String[] {"travellerTypeId"}, true);

		_finderPathCountBysearchTravellerTypeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysearchTravellerTypeId", new String[] {Long.class.getName()},
			new String[] {"travellerTypeId"}, false);

		_setTravelDomesticTravellerTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTravelDomesticTravellerTypeUtilPersistence(null);

		entityCache.removeCache(
			TravelDomesticTravellerTypeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setTravelDomesticTravellerTypeUtilPersistence(
		TravelDomesticTravellerTypePersistence
			travelDomesticTravellerTypePersistence) {

		try {
			Field field =
				TravelDomesticTravellerTypeUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, travelDomesticTravellerTypePersistence);
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

	private static final String _SQL_SELECT_TRAVELDOMESTICTRAVELLERTYPE =
		"SELECT travelDomesticTravellerType FROM TravelDomesticTravellerType travelDomesticTravellerType";

	private static final String _SQL_SELECT_TRAVELDOMESTICTRAVELLERTYPE_WHERE =
		"SELECT travelDomesticTravellerType FROM TravelDomesticTravellerType travelDomesticTravellerType WHERE ";

	private static final String _SQL_COUNT_TRAVELDOMESTICTRAVELLERTYPE =
		"SELECT COUNT(travelDomesticTravellerType) FROM TravelDomesticTravellerType travelDomesticTravellerType";

	private static final String _SQL_COUNT_TRAVELDOMESTICTRAVELLERTYPE_WHERE =
		"SELECT COUNT(travelDomesticTravellerType) FROM TravelDomesticTravellerType travelDomesticTravellerType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"travelDomesticTravellerType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TravelDomesticTravellerType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TravelDomesticTravellerType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TravelDomesticTravellerTypePersistenceImpl.class);

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

	private static class TravelDomesticTravellerTypeModelArgumentsResolver
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

			TravelDomesticTravellerTypeModelImpl
				travelDomesticTravellerTypeModelImpl =
					(TravelDomesticTravellerTypeModelImpl)baseModel;

			long columnBitmask =
				travelDomesticTravellerTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					travelDomesticTravellerTypeModelImpl, columnNames,
					original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						travelDomesticTravellerTypeModelImpl.getColumnBitmask(
							columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(TravelDomesticTravellerTypePersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					travelDomesticTravellerTypeModelImpl, columnNames,
					original);
			}

			return null;
		}

		private static Object[] _getValue(
			TravelDomesticTravellerTypeModelImpl
				travelDomesticTravellerTypeModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						travelDomesticTravellerTypeModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						travelDomesticTravellerTypeModelImpl.getColumnValue(
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