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

import com.mypage.admin.product.exception.NoSuchSmartActiveBenefitValueException;
import com.mypage.admin.product.model.SmartActiveBenefitValue;
import com.mypage.admin.product.model.impl.SmartActiveBenefitValueImpl;
import com.mypage.admin.product.model.impl.SmartActiveBenefitValueModelImpl;
import com.mypage.admin.product.service.persistence.SmartActiveBenefitValuePersistence;
import com.mypage.admin.product.service.persistence.SmartActiveBenefitValueUtil;
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
 * The persistence implementation for the smart active benefit value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = SmartActiveBenefitValuePersistence.class)
public class SmartActiveBenefitValuePersistenceImpl
	extends BasePersistenceImpl<SmartActiveBenefitValue>
	implements SmartActiveBenefitValuePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SmartActiveBenefitValueUtil</code> to access the smart active benefit value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SmartActiveBenefitValueImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByValue;
	private FinderPath _finderPathCountByValue;

	/**
	 * Returns the smart active benefit value where value = &#63; or throws a <code>NoSuchSmartActiveBenefitValueException</code> if it could not be found.
	 *
	 * @param value the value
	 * @return the matching smart active benefit value
	 * @throws NoSuchSmartActiveBenefitValueException if a matching smart active benefit value could not be found
	 */
	@Override
	public SmartActiveBenefitValue findByValue(long value)
		throws NoSuchSmartActiveBenefitValueException {

		SmartActiveBenefitValue smartActiveBenefitValue = fetchByValue(value);

		if (smartActiveBenefitValue == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("value=");
			sb.append(value);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSmartActiveBenefitValueException(sb.toString());
		}

		return smartActiveBenefitValue;
	}

	/**
	 * Returns the smart active benefit value where value = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param value the value
	 * @return the matching smart active benefit value, or <code>null</code> if a matching smart active benefit value could not be found
	 */
	@Override
	public SmartActiveBenefitValue fetchByValue(long value) {
		return fetchByValue(value, true);
	}

	/**
	 * Returns the smart active benefit value where value = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param value the value
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active benefit value, or <code>null</code> if a matching smart active benefit value could not be found
	 */
	@Override
	public SmartActiveBenefitValue fetchByValue(
		long value, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {value};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByValue, finderArgs, this);
		}

		if (result instanceof SmartActiveBenefitValue) {
			SmartActiveBenefitValue smartActiveBenefitValue =
				(SmartActiveBenefitValue)result;

			if (value != smartActiveBenefitValue.getValue()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SMARTACTIVEBENEFITVALUE_WHERE);

			sb.append(_FINDER_COLUMN_VALUE_VALUE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(value);

				List<SmartActiveBenefitValue> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByValue, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {value};
							}

							_log.warn(
								"SmartActiveBenefitValuePersistenceImpl.fetchByValue(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SmartActiveBenefitValue smartActiveBenefitValue = list.get(
						0);

					result = smartActiveBenefitValue;

					cacheResult(smartActiveBenefitValue);
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
			return (SmartActiveBenefitValue)result;
		}
	}

	/**
	 * Removes the smart active benefit value where value = &#63; from the database.
	 *
	 * @param value the value
	 * @return the smart active benefit value that was removed
	 */
	@Override
	public SmartActiveBenefitValue removeByValue(long value)
		throws NoSuchSmartActiveBenefitValueException {

		SmartActiveBenefitValue smartActiveBenefitValue = findByValue(value);

		return remove(smartActiveBenefitValue);
	}

	/**
	 * Returns the number of smart active benefit values where value = &#63;.
	 *
	 * @param value the value
	 * @return the number of matching smart active benefit values
	 */
	@Override
	public int countByValue(long value) {
		FinderPath finderPath = _finderPathCountByValue;

		Object[] finderArgs = new Object[] {value};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SMARTACTIVEBENEFITVALUE_WHERE);

			sb.append(_FINDER_COLUMN_VALUE_VALUE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(value);

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

	private static final String _FINDER_COLUMN_VALUE_VALUE_2 =
		"smartActiveBenefitValue.value = ?";

	public SmartActiveBenefitValuePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SmartActiveBenefitValue.class);

		setModelImplClass(SmartActiveBenefitValueImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the smart active benefit value in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefitValue the smart active benefit value
	 */
	@Override
	public void cacheResult(SmartActiveBenefitValue smartActiveBenefitValue) {
		entityCache.putResult(
			SmartActiveBenefitValueImpl.class,
			smartActiveBenefitValue.getPrimaryKey(), smartActiveBenefitValue);

		finderCache.putResult(
			_finderPathFetchByValue,
			new Object[] {smartActiveBenefitValue.getValue()},
			smartActiveBenefitValue);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the smart active benefit values in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefitValues the smart active benefit values
	 */
	@Override
	public void cacheResult(
		List<SmartActiveBenefitValue> smartActiveBenefitValues) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (smartActiveBenefitValues.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SmartActiveBenefitValue smartActiveBenefitValue :
				smartActiveBenefitValues) {

			if (entityCache.getResult(
					SmartActiveBenefitValueImpl.class,
					smartActiveBenefitValue.getPrimaryKey()) == null) {

				cacheResult(smartActiveBenefitValue);
			}
		}
	}

	/**
	 * Clears the cache for all smart active benefit values.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SmartActiveBenefitValueImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the smart active benefit value.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SmartActiveBenefitValue smartActiveBenefitValue) {
		entityCache.removeResult(
			SmartActiveBenefitValueImpl.class, smartActiveBenefitValue);
	}

	@Override
	public void clearCache(
		List<SmartActiveBenefitValue> smartActiveBenefitValues) {

		for (SmartActiveBenefitValue smartActiveBenefitValue :
				smartActiveBenefitValues) {

			entityCache.removeResult(
				SmartActiveBenefitValueImpl.class, smartActiveBenefitValue);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				SmartActiveBenefitValueImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SmartActiveBenefitValueModelImpl smartActiveBenefitValueModelImpl) {

		Object[] args = new Object[] {
			smartActiveBenefitValueModelImpl.getValue()
		};

		finderCache.putResult(
			_finderPathCountByValue, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByValue, args, smartActiveBenefitValueModelImpl,
			false);
	}

	/**
	 * Creates a new smart active benefit value with the primary key. Does not add the smart active benefit value to the database.
	 *
	 * @param smartActiveBenefitValueId the primary key for the new smart active benefit value
	 * @return the new smart active benefit value
	 */
	@Override
	public SmartActiveBenefitValue create(long smartActiveBenefitValueId) {
		SmartActiveBenefitValue smartActiveBenefitValue =
			new SmartActiveBenefitValueImpl();

		smartActiveBenefitValue.setNew(true);
		smartActiveBenefitValue.setPrimaryKey(smartActiveBenefitValueId);

		smartActiveBenefitValue.setCompanyId(CompanyThreadLocal.getCompanyId());

		return smartActiveBenefitValue;
	}

	/**
	 * Removes the smart active benefit value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveBenefitValueId the primary key of the smart active benefit value
	 * @return the smart active benefit value that was removed
	 * @throws NoSuchSmartActiveBenefitValueException if a smart active benefit value with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefitValue remove(long smartActiveBenefitValueId)
		throws NoSuchSmartActiveBenefitValueException {

		return remove((Serializable)smartActiveBenefitValueId);
	}

	/**
	 * Removes the smart active benefit value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the smart active benefit value
	 * @return the smart active benefit value that was removed
	 * @throws NoSuchSmartActiveBenefitValueException if a smart active benefit value with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefitValue remove(Serializable primaryKey)
		throws NoSuchSmartActiveBenefitValueException {

		Session session = null;

		try {
			session = openSession();

			SmartActiveBenefitValue smartActiveBenefitValue =
				(SmartActiveBenefitValue)session.get(
					SmartActiveBenefitValueImpl.class, primaryKey);

			if (smartActiveBenefitValue == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSmartActiveBenefitValueException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(smartActiveBenefitValue);
		}
		catch (NoSuchSmartActiveBenefitValueException noSuchEntityException) {
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
	protected SmartActiveBenefitValue removeImpl(
		SmartActiveBenefitValue smartActiveBenefitValue) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(smartActiveBenefitValue)) {
				smartActiveBenefitValue = (SmartActiveBenefitValue)session.get(
					SmartActiveBenefitValueImpl.class,
					smartActiveBenefitValue.getPrimaryKeyObj());
			}

			if (smartActiveBenefitValue != null) {
				session.delete(smartActiveBenefitValue);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (smartActiveBenefitValue != null) {
			clearCache(smartActiveBenefitValue);
		}

		return smartActiveBenefitValue;
	}

	@Override
	public SmartActiveBenefitValue updateImpl(
		SmartActiveBenefitValue smartActiveBenefitValue) {

		boolean isNew = smartActiveBenefitValue.isNew();

		if (!(smartActiveBenefitValue instanceof
				SmartActiveBenefitValueModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(smartActiveBenefitValue.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					smartActiveBenefitValue);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in smartActiveBenefitValue proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SmartActiveBenefitValue implementation " +
					smartActiveBenefitValue.getClass());
		}

		SmartActiveBenefitValueModelImpl smartActiveBenefitValueModelImpl =
			(SmartActiveBenefitValueModelImpl)smartActiveBenefitValue;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (smartActiveBenefitValue.getCreateDate() == null)) {
			if (serviceContext == null) {
				smartActiveBenefitValue.setCreateDate(date);
			}
			else {
				smartActiveBenefitValue.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!smartActiveBenefitValueModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				smartActiveBenefitValue.setModifiedDate(date);
			}
			else {
				smartActiveBenefitValue.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(smartActiveBenefitValue);
			}
			else {
				smartActiveBenefitValue =
					(SmartActiveBenefitValue)session.merge(
						smartActiveBenefitValue);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SmartActiveBenefitValueImpl.class, smartActiveBenefitValueModelImpl,
			false, true);

		cacheUniqueFindersCache(smartActiveBenefitValueModelImpl);

		if (isNew) {
			smartActiveBenefitValue.setNew(false);
		}

		smartActiveBenefitValue.resetOriginalValues();

		return smartActiveBenefitValue;
	}

	/**
	 * Returns the smart active benefit value with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the smart active benefit value
	 * @return the smart active benefit value
	 * @throws NoSuchSmartActiveBenefitValueException if a smart active benefit value with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefitValue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSmartActiveBenefitValueException {

		SmartActiveBenefitValue smartActiveBenefitValue = fetchByPrimaryKey(
			primaryKey);

		if (smartActiveBenefitValue == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSmartActiveBenefitValueException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return smartActiveBenefitValue;
	}

	/**
	 * Returns the smart active benefit value with the primary key or throws a <code>NoSuchSmartActiveBenefitValueException</code> if it could not be found.
	 *
	 * @param smartActiveBenefitValueId the primary key of the smart active benefit value
	 * @return the smart active benefit value
	 * @throws NoSuchSmartActiveBenefitValueException if a smart active benefit value with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefitValue findByPrimaryKey(
			long smartActiveBenefitValueId)
		throws NoSuchSmartActiveBenefitValueException {

		return findByPrimaryKey((Serializable)smartActiveBenefitValueId);
	}

	/**
	 * Returns the smart active benefit value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveBenefitValueId the primary key of the smart active benefit value
	 * @return the smart active benefit value, or <code>null</code> if a smart active benefit value with the primary key could not be found
	 */
	@Override
	public SmartActiveBenefitValue fetchByPrimaryKey(
		long smartActiveBenefitValueId) {

		return fetchByPrimaryKey((Serializable)smartActiveBenefitValueId);
	}

	/**
	 * Returns all the smart active benefit values.
	 *
	 * @return the smart active benefit values
	 */
	@Override
	public List<SmartActiveBenefitValue> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smart active benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit values
	 * @param end the upper bound of the range of smart active benefit values (not inclusive)
	 * @return the range of smart active benefit values
	 */
	@Override
	public List<SmartActiveBenefitValue> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart active benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit values
	 * @param end the upper bound of the range of smart active benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active benefit values
	 */
	@Override
	public List<SmartActiveBenefitValue> findAll(
		int start, int end,
		OrderByComparator<SmartActiveBenefitValue> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart active benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit values
	 * @param end the upper bound of the range of smart active benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active benefit values
	 */
	@Override
	public List<SmartActiveBenefitValue> findAll(
		int start, int end,
		OrderByComparator<SmartActiveBenefitValue> orderByComparator,
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

		List<SmartActiveBenefitValue> list = null;

		if (useFinderCache) {
			list = (List<SmartActiveBenefitValue>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SMARTACTIVEBENEFITVALUE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SMARTACTIVEBENEFITVALUE;

				sql = sql.concat(
					SmartActiveBenefitValueModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SmartActiveBenefitValue>)QueryUtil.list(
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
	 * Removes all the smart active benefit values from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SmartActiveBenefitValue smartActiveBenefitValue : findAll()) {
			remove(smartActiveBenefitValue);
		}
	}

	/**
	 * Returns the number of smart active benefit values.
	 *
	 * @return the number of smart active benefit values
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
					_SQL_COUNT_SMARTACTIVEBENEFITVALUE);

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
		return "smartActiveBenefitValueId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SMARTACTIVEBENEFITVALUE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SmartActiveBenefitValueModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the smart active benefit value persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SmartActiveBenefitValueModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SmartActiveBenefitValue.class.getName()));

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

		_finderPathFetchByValue = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByValue",
			new String[] {Long.class.getName()}, new String[] {"value"}, true);

		_finderPathCountByValue = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByValue",
			new String[] {Long.class.getName()}, new String[] {"value"}, false);

		_setSmartActiveBenefitValueUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSmartActiveBenefitValueUtilPersistence(null);

		entityCache.removeCache(SmartActiveBenefitValueImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setSmartActiveBenefitValueUtilPersistence(
		SmartActiveBenefitValuePersistence smartActiveBenefitValuePersistence) {

		try {
			Field field = SmartActiveBenefitValueUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, smartActiveBenefitValuePersistence);
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

	private static final String _SQL_SELECT_SMARTACTIVEBENEFITVALUE =
		"SELECT smartActiveBenefitValue FROM SmartActiveBenefitValue smartActiveBenefitValue";

	private static final String _SQL_SELECT_SMARTACTIVEBENEFITVALUE_WHERE =
		"SELECT smartActiveBenefitValue FROM SmartActiveBenefitValue smartActiveBenefitValue WHERE ";

	private static final String _SQL_COUNT_SMARTACTIVEBENEFITVALUE =
		"SELECT COUNT(smartActiveBenefitValue) FROM SmartActiveBenefitValue smartActiveBenefitValue";

	private static final String _SQL_COUNT_SMARTACTIVEBENEFITVALUE_WHERE =
		"SELECT COUNT(smartActiveBenefitValue) FROM SmartActiveBenefitValue smartActiveBenefitValue WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"smartActiveBenefitValue.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SmartActiveBenefitValue exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SmartActiveBenefitValue exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SmartActiveBenefitValuePersistenceImpl.class);

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

	private static class SmartActiveBenefitValueModelArgumentsResolver
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

			SmartActiveBenefitValueModelImpl smartActiveBenefitValueModelImpl =
				(SmartActiveBenefitValueModelImpl)baseModel;

			long columnBitmask =
				smartActiveBenefitValueModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					smartActiveBenefitValueModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						smartActiveBenefitValueModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					smartActiveBenefitValueModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SmartActiveBenefitValueModelImpl smartActiveBenefitValueModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						smartActiveBenefitValueModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						smartActiveBenefitValueModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}