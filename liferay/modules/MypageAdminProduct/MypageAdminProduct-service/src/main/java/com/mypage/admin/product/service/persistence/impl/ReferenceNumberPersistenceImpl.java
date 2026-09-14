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

import com.mypage.admin.product.exception.NoSuchReferenceNumberException;
import com.mypage.admin.product.model.ReferenceNumber;
import com.mypage.admin.product.model.impl.ReferenceNumberImpl;
import com.mypage.admin.product.model.impl.ReferenceNumberModelImpl;
import com.mypage.admin.product.service.persistence.ReferenceNumberPersistence;
import com.mypage.admin.product.service.persistence.ReferenceNumberUtil;
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
 * The persistence implementation for the reference number service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = ReferenceNumberPersistence.class)
public class ReferenceNumberPersistenceImpl
	extends BasePersistenceImpl<ReferenceNumber>
	implements ReferenceNumberPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ReferenceNumberUtil</code> to access the reference number persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ReferenceNumberImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBysearchReferenceNumber;
	private FinderPath _finderPathCountBysearchReferenceNumber;

	/**
	 * Returns the reference number where userRole = &#63; and channel = &#63; and type = &#63; and productCode = &#63; and businessType = &#63; and currency = &#63; or throws a <code>NoSuchReferenceNumberException</code> if it could not be found.
	 *
	 * @param userRole the user role
	 * @param channel the channel
	 * @param type the type
	 * @param productCode the product code
	 * @param businessType the business type
	 * @param currency the currency
	 * @return the matching reference number
	 * @throws NoSuchReferenceNumberException if a matching reference number could not be found
	 */
	@Override
	public ReferenceNumber findBysearchReferenceNumber(
			String userRole, String channel, String type, String productCode,
			String businessType, String currency)
		throws NoSuchReferenceNumberException {

		ReferenceNumber referenceNumber = fetchBysearchReferenceNumber(
			userRole, channel, type, productCode, businessType, currency);

		if (referenceNumber == null) {
			StringBundler sb = new StringBundler(14);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userRole=");
			sb.append(userRole);

			sb.append(", channel=");
			sb.append(channel);

			sb.append(", type=");
			sb.append(type);

			sb.append(", productCode=");
			sb.append(productCode);

			sb.append(", businessType=");
			sb.append(businessType);

			sb.append(", currency=");
			sb.append(currency);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchReferenceNumberException(sb.toString());
		}

		return referenceNumber;
	}

	/**
	 * Returns the reference number where userRole = &#63; and channel = &#63; and type = &#63; and productCode = &#63; and businessType = &#63; and currency = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userRole the user role
	 * @param channel the channel
	 * @param type the type
	 * @param productCode the product code
	 * @param businessType the business type
	 * @param currency the currency
	 * @return the matching reference number, or <code>null</code> if a matching reference number could not be found
	 */
	@Override
	public ReferenceNumber fetchBysearchReferenceNumber(
		String userRole, String channel, String type, String productCode,
		String businessType, String currency) {

		return fetchBysearchReferenceNumber(
			userRole, channel, type, productCode, businessType, currency, true);
	}

	/**
	 * Returns the reference number where userRole = &#63; and channel = &#63; and type = &#63; and productCode = &#63; and businessType = &#63; and currency = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userRole the user role
	 * @param channel the channel
	 * @param type the type
	 * @param productCode the product code
	 * @param businessType the business type
	 * @param currency the currency
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching reference number, or <code>null</code> if a matching reference number could not be found
	 */
	@Override
	public ReferenceNumber fetchBysearchReferenceNumber(
		String userRole, String channel, String type, String productCode,
		String businessType, String currency, boolean useFinderCache) {

		userRole = Objects.toString(userRole, "");
		channel = Objects.toString(channel, "");
		type = Objects.toString(type, "");
		productCode = Objects.toString(productCode, "");
		businessType = Objects.toString(businessType, "");
		currency = Objects.toString(currency, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				userRole, channel, type, productCode, businessType, currency
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBysearchReferenceNumber, finderArgs, this);
		}

		if (result instanceof ReferenceNumber) {
			ReferenceNumber referenceNumber = (ReferenceNumber)result;

			if (!Objects.equals(userRole, referenceNumber.getUserRole()) ||
				!Objects.equals(channel, referenceNumber.getChannel()) ||
				!Objects.equals(type, referenceNumber.getType()) ||
				!Objects.equals(
					productCode, referenceNumber.getProductCode()) ||
				!Objects.equals(
					businessType, referenceNumber.getBusinessType()) ||
				!Objects.equals(currency, referenceNumber.getCurrency())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_SQL_SELECT_REFERENCENUMBER_WHERE);

			boolean bindUserRole = false;

			if (userRole.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_USERROLE_3);
			}
			else {
				bindUserRole = true;

				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_USERROLE_2);
			}

			boolean bindChannel = false;

			if (channel.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_CHANNEL_3);
			}
			else {
				bindChannel = true;

				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_CHANNEL_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_TYPE_2);
			}

			boolean bindProductCode = false;

			if (productCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_PRODUCTCODE_3);
			}
			else {
				bindProductCode = true;

				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_PRODUCTCODE_2);
			}

			boolean bindBusinessType = false;

			if (businessType.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_BUSINESSTYPE_3);
			}
			else {
				bindBusinessType = true;

				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_BUSINESSTYPE_2);
			}

			boolean bindCurrency = false;

			if (currency.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_CURRENCY_3);
			}
			else {
				bindCurrency = true;

				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_CURRENCY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserRole) {
					queryPos.add(userRole);
				}

				if (bindChannel) {
					queryPos.add(channel);
				}

				if (bindType) {
					queryPos.add(type);
				}

				if (bindProductCode) {
					queryPos.add(productCode);
				}

				if (bindBusinessType) {
					queryPos.add(businessType);
				}

				if (bindCurrency) {
					queryPos.add(currency);
				}

				List<ReferenceNumber> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBysearchReferenceNumber, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									userRole, channel, type, productCode,
									businessType, currency
								};
							}

							_log.warn(
								"ReferenceNumberPersistenceImpl.fetchBysearchReferenceNumber(String, String, String, String, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ReferenceNumber referenceNumber = list.get(0);

					result = referenceNumber;

					cacheResult(referenceNumber);
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
			return (ReferenceNumber)result;
		}
	}

	/**
	 * Removes the reference number where userRole = &#63; and channel = &#63; and type = &#63; and productCode = &#63; and businessType = &#63; and currency = &#63; from the database.
	 *
	 * @param userRole the user role
	 * @param channel the channel
	 * @param type the type
	 * @param productCode the product code
	 * @param businessType the business type
	 * @param currency the currency
	 * @return the reference number that was removed
	 */
	@Override
	public ReferenceNumber removeBysearchReferenceNumber(
			String userRole, String channel, String type, String productCode,
			String businessType, String currency)
		throws NoSuchReferenceNumberException {

		ReferenceNumber referenceNumber = findBysearchReferenceNumber(
			userRole, channel, type, productCode, businessType, currency);

		return remove(referenceNumber);
	}

	/**
	 * Returns the number of reference numbers where userRole = &#63; and channel = &#63; and type = &#63; and productCode = &#63; and businessType = &#63; and currency = &#63;.
	 *
	 * @param userRole the user role
	 * @param channel the channel
	 * @param type the type
	 * @param productCode the product code
	 * @param businessType the business type
	 * @param currency the currency
	 * @return the number of matching reference numbers
	 */
	@Override
	public int countBysearchReferenceNumber(
		String userRole, String channel, String type, String productCode,
		String businessType, String currency) {

		userRole = Objects.toString(userRole, "");
		channel = Objects.toString(channel, "");
		type = Objects.toString(type, "");
		productCode = Objects.toString(productCode, "");
		businessType = Objects.toString(businessType, "");
		currency = Objects.toString(currency, "");

		FinderPath finderPath = _finderPathCountBysearchReferenceNumber;

		Object[] finderArgs = new Object[] {
			userRole, channel, type, productCode, businessType, currency
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(7);

			sb.append(_SQL_COUNT_REFERENCENUMBER_WHERE);

			boolean bindUserRole = false;

			if (userRole.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_USERROLE_3);
			}
			else {
				bindUserRole = true;

				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_USERROLE_2);
			}

			boolean bindChannel = false;

			if (channel.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_CHANNEL_3);
			}
			else {
				bindChannel = true;

				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_CHANNEL_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_TYPE_2);
			}

			boolean bindProductCode = false;

			if (productCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_PRODUCTCODE_3);
			}
			else {
				bindProductCode = true;

				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_PRODUCTCODE_2);
			}

			boolean bindBusinessType = false;

			if (businessType.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_BUSINESSTYPE_3);
			}
			else {
				bindBusinessType = true;

				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_BUSINESSTYPE_2);
			}

			boolean bindCurrency = false;

			if (currency.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_CURRENCY_3);
			}
			else {
				bindCurrency = true;

				sb.append(_FINDER_COLUMN_SEARCHREFERENCENUMBER_CURRENCY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserRole) {
					queryPos.add(userRole);
				}

				if (bindChannel) {
					queryPos.add(channel);
				}

				if (bindType) {
					queryPos.add(type);
				}

				if (bindProductCode) {
					queryPos.add(productCode);
				}

				if (bindBusinessType) {
					queryPos.add(businessType);
				}

				if (bindCurrency) {
					queryPos.add(currency);
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
		_FINDER_COLUMN_SEARCHREFERENCENUMBER_USERROLE_2 =
			"referenceNumber.userRole = ? AND ";

	private static final String
		_FINDER_COLUMN_SEARCHREFERENCENUMBER_USERROLE_3 =
			"(referenceNumber.userRole IS NULL OR referenceNumber.userRole = '') AND ";

	private static final String _FINDER_COLUMN_SEARCHREFERENCENUMBER_CHANNEL_2 =
		"referenceNumber.channel = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHREFERENCENUMBER_CHANNEL_3 =
		"(referenceNumber.channel IS NULL OR referenceNumber.channel = '') AND ";

	private static final String _FINDER_COLUMN_SEARCHREFERENCENUMBER_TYPE_2 =
		"referenceNumber.type = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHREFERENCENUMBER_TYPE_3 =
		"(referenceNumber.type IS NULL OR referenceNumber.type = '') AND ";

	private static final String
		_FINDER_COLUMN_SEARCHREFERENCENUMBER_PRODUCTCODE_2 =
			"referenceNumber.productCode = ? AND ";

	private static final String
		_FINDER_COLUMN_SEARCHREFERENCENUMBER_PRODUCTCODE_3 =
			"(referenceNumber.productCode IS NULL OR referenceNumber.productCode = '') AND ";

	private static final String
		_FINDER_COLUMN_SEARCHREFERENCENUMBER_BUSINESSTYPE_2 =
			"referenceNumber.businessType = ? AND ";

	private static final String
		_FINDER_COLUMN_SEARCHREFERENCENUMBER_BUSINESSTYPE_3 =
			"(referenceNumber.businessType IS NULL OR referenceNumber.businessType = '') AND ";

	private static final String
		_FINDER_COLUMN_SEARCHREFERENCENUMBER_CURRENCY_2 =
			"referenceNumber.currency = ? AND referenceNumber.active=1";

	private static final String
		_FINDER_COLUMN_SEARCHREFERENCENUMBER_CURRENCY_3 =
			"(referenceNumber.currency IS NULL OR referenceNumber.currency = '') AND referenceNumber.active=1";

	public ReferenceNumberPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");
		dbColumnNames.put("currency", "currency_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ReferenceNumber.class);

		setModelImplClass(ReferenceNumberImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the reference number in the entity cache if it is enabled.
	 *
	 * @param referenceNumber the reference number
	 */
	@Override
	public void cacheResult(ReferenceNumber referenceNumber) {
		entityCache.putResult(
			ReferenceNumberImpl.class, referenceNumber.getPrimaryKey(),
			referenceNumber);

		finderCache.putResult(
			_finderPathFetchBysearchReferenceNumber,
			new Object[] {
				referenceNumber.getUserRole(), referenceNumber.getChannel(),
				referenceNumber.getType(), referenceNumber.getProductCode(),
				referenceNumber.getBusinessType(), referenceNumber.getCurrency()
			},
			referenceNumber);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the reference numbers in the entity cache if it is enabled.
	 *
	 * @param referenceNumbers the reference numbers
	 */
	@Override
	public void cacheResult(List<ReferenceNumber> referenceNumbers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (referenceNumbers.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ReferenceNumber referenceNumber : referenceNumbers) {
			if (entityCache.getResult(
					ReferenceNumberImpl.class,
					referenceNumber.getPrimaryKey()) == null) {

				cacheResult(referenceNumber);
			}
		}
	}

	/**
	 * Clears the cache for all reference numbers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ReferenceNumberImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the reference number.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ReferenceNumber referenceNumber) {
		entityCache.removeResult(ReferenceNumberImpl.class, referenceNumber);
	}

	@Override
	public void clearCache(List<ReferenceNumber> referenceNumbers) {
		for (ReferenceNumber referenceNumber : referenceNumbers) {
			entityCache.removeResult(
				ReferenceNumberImpl.class, referenceNumber);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ReferenceNumberImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ReferenceNumberModelImpl referenceNumberModelImpl) {

		Object[] args = new Object[] {
			referenceNumberModelImpl.getUserRole(),
			referenceNumberModelImpl.getChannel(),
			referenceNumberModelImpl.getType(),
			referenceNumberModelImpl.getProductCode(),
			referenceNumberModelImpl.getBusinessType(),
			referenceNumberModelImpl.getCurrency()
		};

		finderCache.putResult(
			_finderPathCountBysearchReferenceNumber, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchBysearchReferenceNumber, args,
			referenceNumberModelImpl, false);
	}

	/**
	 * Creates a new reference number with the primary key. Does not add the reference number to the database.
	 *
	 * @param referenceNumberId the primary key for the new reference number
	 * @return the new reference number
	 */
	@Override
	public ReferenceNumber create(long referenceNumberId) {
		ReferenceNumber referenceNumber = new ReferenceNumberImpl();

		referenceNumber.setNew(true);
		referenceNumber.setPrimaryKey(referenceNumberId);

		referenceNumber.setCompanyId(CompanyThreadLocal.getCompanyId());

		return referenceNumber;
	}

	/**
	 * Removes the reference number with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param referenceNumberId the primary key of the reference number
	 * @return the reference number that was removed
	 * @throws NoSuchReferenceNumberException if a reference number with the primary key could not be found
	 */
	@Override
	public ReferenceNumber remove(long referenceNumberId)
		throws NoSuchReferenceNumberException {

		return remove((Serializable)referenceNumberId);
	}

	/**
	 * Removes the reference number with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the reference number
	 * @return the reference number that was removed
	 * @throws NoSuchReferenceNumberException if a reference number with the primary key could not be found
	 */
	@Override
	public ReferenceNumber remove(Serializable primaryKey)
		throws NoSuchReferenceNumberException {

		Session session = null;

		try {
			session = openSession();

			ReferenceNumber referenceNumber = (ReferenceNumber)session.get(
				ReferenceNumberImpl.class, primaryKey);

			if (referenceNumber == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchReferenceNumberException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(referenceNumber);
		}
		catch (NoSuchReferenceNumberException noSuchEntityException) {
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
	protected ReferenceNumber removeImpl(ReferenceNumber referenceNumber) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(referenceNumber)) {
				referenceNumber = (ReferenceNumber)session.get(
					ReferenceNumberImpl.class,
					referenceNumber.getPrimaryKeyObj());
			}

			if (referenceNumber != null) {
				session.delete(referenceNumber);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (referenceNumber != null) {
			clearCache(referenceNumber);
		}

		return referenceNumber;
	}

	@Override
	public ReferenceNumber updateImpl(ReferenceNumber referenceNumber) {
		boolean isNew = referenceNumber.isNew();

		if (!(referenceNumber instanceof ReferenceNumberModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(referenceNumber.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					referenceNumber);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in referenceNumber proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ReferenceNumber implementation " +
					referenceNumber.getClass());
		}

		ReferenceNumberModelImpl referenceNumberModelImpl =
			(ReferenceNumberModelImpl)referenceNumber;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (referenceNumber.getCreateDate() == null)) {
			if (serviceContext == null) {
				referenceNumber.setCreateDate(date);
			}
			else {
				referenceNumber.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!referenceNumberModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				referenceNumber.setModifiedDate(date);
			}
			else {
				referenceNumber.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(referenceNumber);
			}
			else {
				referenceNumber = (ReferenceNumber)session.merge(
					referenceNumber);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ReferenceNumberImpl.class, referenceNumberModelImpl, false, true);

		cacheUniqueFindersCache(referenceNumberModelImpl);

		if (isNew) {
			referenceNumber.setNew(false);
		}

		referenceNumber.resetOriginalValues();

		return referenceNumber;
	}

	/**
	 * Returns the reference number with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the reference number
	 * @return the reference number
	 * @throws NoSuchReferenceNumberException if a reference number with the primary key could not be found
	 */
	@Override
	public ReferenceNumber findByPrimaryKey(Serializable primaryKey)
		throws NoSuchReferenceNumberException {

		ReferenceNumber referenceNumber = fetchByPrimaryKey(primaryKey);

		if (referenceNumber == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchReferenceNumberException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return referenceNumber;
	}

	/**
	 * Returns the reference number with the primary key or throws a <code>NoSuchReferenceNumberException</code> if it could not be found.
	 *
	 * @param referenceNumberId the primary key of the reference number
	 * @return the reference number
	 * @throws NoSuchReferenceNumberException if a reference number with the primary key could not be found
	 */
	@Override
	public ReferenceNumber findByPrimaryKey(long referenceNumberId)
		throws NoSuchReferenceNumberException {

		return findByPrimaryKey((Serializable)referenceNumberId);
	}

	/**
	 * Returns the reference number with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param referenceNumberId the primary key of the reference number
	 * @return the reference number, or <code>null</code> if a reference number with the primary key could not be found
	 */
	@Override
	public ReferenceNumber fetchByPrimaryKey(long referenceNumberId) {
		return fetchByPrimaryKey((Serializable)referenceNumberId);
	}

	/**
	 * Returns all the reference numbers.
	 *
	 * @return the reference numbers
	 */
	@Override
	public List<ReferenceNumber> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the reference numbers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceNumberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference numbers
	 * @param end the upper bound of the range of reference numbers (not inclusive)
	 * @return the range of reference numbers
	 */
	@Override
	public List<ReferenceNumber> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the reference numbers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceNumberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference numbers
	 * @param end the upper bound of the range of reference numbers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of reference numbers
	 */
	@Override
	public List<ReferenceNumber> findAll(
		int start, int end,
		OrderByComparator<ReferenceNumber> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the reference numbers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceNumberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference numbers
	 * @param end the upper bound of the range of reference numbers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of reference numbers
	 */
	@Override
	public List<ReferenceNumber> findAll(
		int start, int end,
		OrderByComparator<ReferenceNumber> orderByComparator,
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

		List<ReferenceNumber> list = null;

		if (useFinderCache) {
			list = (List<ReferenceNumber>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_REFERENCENUMBER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_REFERENCENUMBER;

				sql = sql.concat(ReferenceNumberModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ReferenceNumber>)QueryUtil.list(
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
	 * Removes all the reference numbers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ReferenceNumber referenceNumber : findAll()) {
			remove(referenceNumber);
		}
	}

	/**
	 * Returns the number of reference numbers.
	 *
	 * @return the number of reference numbers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_REFERENCENUMBER);

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
		return "referenceNumberId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_REFERENCENUMBER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ReferenceNumberModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the reference number persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ReferenceNumberModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ReferenceNumber.class.getName()));

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

		_finderPathFetchBysearchReferenceNumber = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBysearchReferenceNumber",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {
				"userRole", "channel", "type_", "productCode", "businessType",
				"currency_"
			},
			true);

		_finderPathCountBysearchReferenceNumber = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysearchReferenceNumber",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {
				"userRole", "channel", "type_", "productCode", "businessType",
				"currency_"
			},
			false);

		_setReferenceNumberUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setReferenceNumberUtilPersistence(null);

		entityCache.removeCache(ReferenceNumberImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setReferenceNumberUtilPersistence(
		ReferenceNumberPersistence referenceNumberPersistence) {

		try {
			Field field = ReferenceNumberUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, referenceNumberPersistence);
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

	private static final String _SQL_SELECT_REFERENCENUMBER =
		"SELECT referenceNumber FROM ReferenceNumber referenceNumber";

	private static final String _SQL_SELECT_REFERENCENUMBER_WHERE =
		"SELECT referenceNumber FROM ReferenceNumber referenceNumber WHERE ";

	private static final String _SQL_COUNT_REFERENCENUMBER =
		"SELECT COUNT(referenceNumber) FROM ReferenceNumber referenceNumber";

	private static final String _SQL_COUNT_REFERENCENUMBER_WHERE =
		"SELECT COUNT(referenceNumber) FROM ReferenceNumber referenceNumber WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "referenceNumber.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ReferenceNumber exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ReferenceNumber exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ReferenceNumberPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type", "currency", "active"});

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

	private static class ReferenceNumberModelArgumentsResolver
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

			ReferenceNumberModelImpl referenceNumberModelImpl =
				(ReferenceNumberModelImpl)baseModel;

			long columnBitmask = referenceNumberModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					referenceNumberModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						referenceNumberModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					referenceNumberModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			ReferenceNumberModelImpl referenceNumberModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						referenceNumberModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = referenceNumberModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}