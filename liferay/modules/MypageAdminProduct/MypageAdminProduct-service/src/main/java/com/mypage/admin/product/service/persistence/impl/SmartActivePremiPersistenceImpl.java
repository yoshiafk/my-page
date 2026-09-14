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

import com.mypage.admin.product.exception.NoSuchSmartActivePremiException;
import com.mypage.admin.product.model.SmartActivePremi;
import com.mypage.admin.product.model.impl.SmartActivePremiImpl;
import com.mypage.admin.product.model.impl.SmartActivePremiModelImpl;
import com.mypage.admin.product.service.persistence.SmartActivePremiPersistence;
import com.mypage.admin.product.service.persistence.SmartActivePremiUtil;
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
 * The persistence implementation for the smart active premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = SmartActivePremiPersistence.class)
public class SmartActivePremiPersistenceImpl
	extends BasePersistenceImpl<SmartActivePremi>
	implements SmartActivePremiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SmartActivePremiUtil</code> to access the smart active premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SmartActivePremiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByBenefitIdAndClassId;
	private FinderPath _finderPathCountByBenefitIdAndClassId;

	/**
	 * Returns the smart active premi where smartActiveBenefitId = &#63; and smartActiveClassRateId = &#63; or throws a <code>NoSuchSmartActivePremiException</code> if it could not be found.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveClassRateId the smart active class rate ID
	 * @return the matching smart active premi
	 * @throws NoSuchSmartActivePremiException if a matching smart active premi could not be found
	 */
	@Override
	public SmartActivePremi findByBenefitIdAndClassId(
			long smartActiveBenefitId, long smartActiveClassRateId)
		throws NoSuchSmartActivePremiException {

		SmartActivePremi smartActivePremi = fetchByBenefitIdAndClassId(
			smartActiveBenefitId, smartActiveClassRateId);

		if (smartActivePremi == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("smartActiveBenefitId=");
			sb.append(smartActiveBenefitId);

			sb.append(", smartActiveClassRateId=");
			sb.append(smartActiveClassRateId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSmartActivePremiException(sb.toString());
		}

		return smartActivePremi;
	}

	/**
	 * Returns the smart active premi where smartActiveBenefitId = &#63; and smartActiveClassRateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveClassRateId the smart active class rate ID
	 * @return the matching smart active premi, or <code>null</code> if a matching smart active premi could not be found
	 */
	@Override
	public SmartActivePremi fetchByBenefitIdAndClassId(
		long smartActiveBenefitId, long smartActiveClassRateId) {

		return fetchByBenefitIdAndClassId(
			smartActiveBenefitId, smartActiveClassRateId, true);
	}

	/**
	 * Returns the smart active premi where smartActiveBenefitId = &#63; and smartActiveClassRateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveClassRateId the smart active class rate ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active premi, or <code>null</code> if a matching smart active premi could not be found
	 */
	@Override
	public SmartActivePremi fetchByBenefitIdAndClassId(
		long smartActiveBenefitId, long smartActiveClassRateId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				smartActiveBenefitId, smartActiveClassRateId
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByBenefitIdAndClassId, finderArgs, this);
		}

		if (result instanceof SmartActivePremi) {
			SmartActivePremi smartActivePremi = (SmartActivePremi)result;

			if ((smartActiveBenefitId !=
					smartActivePremi.getSmartActiveBenefitId()) ||
				(smartActiveClassRateId !=
					smartActivePremi.getSmartActiveClassRateId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SMARTACTIVEPREMI_WHERE);

			sb.append(
				_FINDER_COLUMN_BENEFITIDANDCLASSID_SMARTACTIVEBENEFITID_2);

			sb.append(
				_FINDER_COLUMN_BENEFITIDANDCLASSID_SMARTACTIVECLASSRATEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(smartActiveBenefitId);

				queryPos.add(smartActiveClassRateId);

				List<SmartActivePremi> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByBenefitIdAndClassId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									smartActiveBenefitId, smartActiveClassRateId
								};
							}

							_log.warn(
								"SmartActivePremiPersistenceImpl.fetchByBenefitIdAndClassId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SmartActivePremi smartActivePremi = list.get(0);

					result = smartActivePremi;

					cacheResult(smartActivePremi);
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
			return (SmartActivePremi)result;
		}
	}

	/**
	 * Removes the smart active premi where smartActiveBenefitId = &#63; and smartActiveClassRateId = &#63; from the database.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveClassRateId the smart active class rate ID
	 * @return the smart active premi that was removed
	 */
	@Override
	public SmartActivePremi removeByBenefitIdAndClassId(
			long smartActiveBenefitId, long smartActiveClassRateId)
		throws NoSuchSmartActivePremiException {

		SmartActivePremi smartActivePremi = findByBenefitIdAndClassId(
			smartActiveBenefitId, smartActiveClassRateId);

		return remove(smartActivePremi);
	}

	/**
	 * Returns the number of smart active premis where smartActiveBenefitId = &#63; and smartActiveClassRateId = &#63;.
	 *
	 * @param smartActiveBenefitId the smart active benefit ID
	 * @param smartActiveClassRateId the smart active class rate ID
	 * @return the number of matching smart active premis
	 */
	@Override
	public int countByBenefitIdAndClassId(
		long smartActiveBenefitId, long smartActiveClassRateId) {

		FinderPath finderPath = _finderPathCountByBenefitIdAndClassId;

		Object[] finderArgs = new Object[] {
			smartActiveBenefitId, smartActiveClassRateId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SMARTACTIVEPREMI_WHERE);

			sb.append(
				_FINDER_COLUMN_BENEFITIDANDCLASSID_SMARTACTIVEBENEFITID_2);

			sb.append(
				_FINDER_COLUMN_BENEFITIDANDCLASSID_SMARTACTIVECLASSRATEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(smartActiveBenefitId);

				queryPos.add(smartActiveClassRateId);

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
		_FINDER_COLUMN_BENEFITIDANDCLASSID_SMARTACTIVEBENEFITID_2 =
			"smartActivePremi.smartActiveBenefitId = ? AND ";

	private static final String
		_FINDER_COLUMN_BENEFITIDANDCLASSID_SMARTACTIVECLASSRATEID_2 =
			"smartActivePremi.smartActiveClassRateId = ?";

	public SmartActivePremiPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SmartActivePremi.class);

		setModelImplClass(SmartActivePremiImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the smart active premi in the entity cache if it is enabled.
	 *
	 * @param smartActivePremi the smart active premi
	 */
	@Override
	public void cacheResult(SmartActivePremi smartActivePremi) {
		entityCache.putResult(
			SmartActivePremiImpl.class, smartActivePremi.getPrimaryKey(),
			smartActivePremi);

		finderCache.putResult(
			_finderPathFetchByBenefitIdAndClassId,
			new Object[] {
				smartActivePremi.getSmartActiveBenefitId(),
				smartActivePremi.getSmartActiveClassRateId()
			},
			smartActivePremi);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the smart active premis in the entity cache if it is enabled.
	 *
	 * @param smartActivePremis the smart active premis
	 */
	@Override
	public void cacheResult(List<SmartActivePremi> smartActivePremis) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (smartActivePremis.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SmartActivePremi smartActivePremi : smartActivePremis) {
			if (entityCache.getResult(
					SmartActivePremiImpl.class,
					smartActivePremi.getPrimaryKey()) == null) {

				cacheResult(smartActivePremi);
			}
		}
	}

	/**
	 * Clears the cache for all smart active premis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SmartActivePremiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the smart active premi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SmartActivePremi smartActivePremi) {
		entityCache.removeResult(SmartActivePremiImpl.class, smartActivePremi);
	}

	@Override
	public void clearCache(List<SmartActivePremi> smartActivePremis) {
		for (SmartActivePremi smartActivePremi : smartActivePremis) {
			entityCache.removeResult(
				SmartActivePremiImpl.class, smartActivePremi);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SmartActivePremiImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SmartActivePremiModelImpl smartActivePremiModelImpl) {

		Object[] args = new Object[] {
			smartActivePremiModelImpl.getSmartActiveBenefitId(),
			smartActivePremiModelImpl.getSmartActiveClassRateId()
		};

		finderCache.putResult(
			_finderPathCountByBenefitIdAndClassId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByBenefitIdAndClassId, args,
			smartActivePremiModelImpl, false);
	}

	/**
	 * Creates a new smart active premi with the primary key. Does not add the smart active premi to the database.
	 *
	 * @param smartActivePremiId the primary key for the new smart active premi
	 * @return the new smart active premi
	 */
	@Override
	public SmartActivePremi create(long smartActivePremiId) {
		SmartActivePremi smartActivePremi = new SmartActivePremiImpl();

		smartActivePremi.setNew(true);
		smartActivePremi.setPrimaryKey(smartActivePremiId);

		smartActivePremi.setCompanyId(CompanyThreadLocal.getCompanyId());

		return smartActivePremi;
	}

	/**
	 * Removes the smart active premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActivePremiId the primary key of the smart active premi
	 * @return the smart active premi that was removed
	 * @throws NoSuchSmartActivePremiException if a smart active premi with the primary key could not be found
	 */
	@Override
	public SmartActivePremi remove(long smartActivePremiId)
		throws NoSuchSmartActivePremiException {

		return remove((Serializable)smartActivePremiId);
	}

	/**
	 * Removes the smart active premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the smart active premi
	 * @return the smart active premi that was removed
	 * @throws NoSuchSmartActivePremiException if a smart active premi with the primary key could not be found
	 */
	@Override
	public SmartActivePremi remove(Serializable primaryKey)
		throws NoSuchSmartActivePremiException {

		Session session = null;

		try {
			session = openSession();

			SmartActivePremi smartActivePremi = (SmartActivePremi)session.get(
				SmartActivePremiImpl.class, primaryKey);

			if (smartActivePremi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSmartActivePremiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(smartActivePremi);
		}
		catch (NoSuchSmartActivePremiException noSuchEntityException) {
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
	protected SmartActivePremi removeImpl(SmartActivePremi smartActivePremi) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(smartActivePremi)) {
				smartActivePremi = (SmartActivePremi)session.get(
					SmartActivePremiImpl.class,
					smartActivePremi.getPrimaryKeyObj());
			}

			if (smartActivePremi != null) {
				session.delete(smartActivePremi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (smartActivePremi != null) {
			clearCache(smartActivePremi);
		}

		return smartActivePremi;
	}

	@Override
	public SmartActivePremi updateImpl(SmartActivePremi smartActivePremi) {
		boolean isNew = smartActivePremi.isNew();

		if (!(smartActivePremi instanceof SmartActivePremiModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(smartActivePremi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					smartActivePremi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in smartActivePremi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SmartActivePremi implementation " +
					smartActivePremi.getClass());
		}

		SmartActivePremiModelImpl smartActivePremiModelImpl =
			(SmartActivePremiModelImpl)smartActivePremi;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (smartActivePremi.getCreateDate() == null)) {
			if (serviceContext == null) {
				smartActivePremi.setCreateDate(date);
			}
			else {
				smartActivePremi.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!smartActivePremiModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				smartActivePremi.setModifiedDate(date);
			}
			else {
				smartActivePremi.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(smartActivePremi);
			}
			else {
				smartActivePremi = (SmartActivePremi)session.merge(
					smartActivePremi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SmartActivePremiImpl.class, smartActivePremiModelImpl, false, true);

		cacheUniqueFindersCache(smartActivePremiModelImpl);

		if (isNew) {
			smartActivePremi.setNew(false);
		}

		smartActivePremi.resetOriginalValues();

		return smartActivePremi;
	}

	/**
	 * Returns the smart active premi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the smart active premi
	 * @return the smart active premi
	 * @throws NoSuchSmartActivePremiException if a smart active premi with the primary key could not be found
	 */
	@Override
	public SmartActivePremi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSmartActivePremiException {

		SmartActivePremi smartActivePremi = fetchByPrimaryKey(primaryKey);

		if (smartActivePremi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSmartActivePremiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return smartActivePremi;
	}

	/**
	 * Returns the smart active premi with the primary key or throws a <code>NoSuchSmartActivePremiException</code> if it could not be found.
	 *
	 * @param smartActivePremiId the primary key of the smart active premi
	 * @return the smart active premi
	 * @throws NoSuchSmartActivePremiException if a smart active premi with the primary key could not be found
	 */
	@Override
	public SmartActivePremi findByPrimaryKey(long smartActivePremiId)
		throws NoSuchSmartActivePremiException {

		return findByPrimaryKey((Serializable)smartActivePremiId);
	}

	/**
	 * Returns the smart active premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActivePremiId the primary key of the smart active premi
	 * @return the smart active premi, or <code>null</code> if a smart active premi with the primary key could not be found
	 */
	@Override
	public SmartActivePremi fetchByPrimaryKey(long smartActivePremiId) {
		return fetchByPrimaryKey((Serializable)smartActivePremiId);
	}

	/**
	 * Returns all the smart active premis.
	 *
	 * @return the smart active premis
	 */
	@Override
	public List<SmartActivePremi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smart active premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActivePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active premis
	 * @param end the upper bound of the range of smart active premis (not inclusive)
	 * @return the range of smart active premis
	 */
	@Override
	public List<SmartActivePremi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart active premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActivePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active premis
	 * @param end the upper bound of the range of smart active premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active premis
	 */
	@Override
	public List<SmartActivePremi> findAll(
		int start, int end,
		OrderByComparator<SmartActivePremi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart active premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActivePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active premis
	 * @param end the upper bound of the range of smart active premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active premis
	 */
	@Override
	public List<SmartActivePremi> findAll(
		int start, int end,
		OrderByComparator<SmartActivePremi> orderByComparator,
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

		List<SmartActivePremi> list = null;

		if (useFinderCache) {
			list = (List<SmartActivePremi>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SMARTACTIVEPREMI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SMARTACTIVEPREMI;

				sql = sql.concat(SmartActivePremiModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SmartActivePremi>)QueryUtil.list(
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
	 * Removes all the smart active premis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SmartActivePremi smartActivePremi : findAll()) {
			remove(smartActivePremi);
		}
	}

	/**
	 * Returns the number of smart active premis.
	 *
	 * @return the number of smart active premis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SMARTACTIVEPREMI);

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
		return "smartActivePremiId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SMARTACTIVEPREMI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SmartActivePremiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the smart active premi persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SmartActivePremiModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SmartActivePremi.class.getName()));

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

		_finderPathFetchByBenefitIdAndClassId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByBenefitIdAndClassId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"smartActiveBenefitId", "smartActiveClassRateId"},
			true);

		_finderPathCountByBenefitIdAndClassId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBenefitIdAndClassId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"smartActiveBenefitId", "smartActiveClassRateId"},
			false);

		_setSmartActivePremiUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSmartActivePremiUtilPersistence(null);

		entityCache.removeCache(SmartActivePremiImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setSmartActivePremiUtilPersistence(
		SmartActivePremiPersistence smartActivePremiPersistence) {

		try {
			Field field = SmartActivePremiUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, smartActivePremiPersistence);
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

	private static final String _SQL_SELECT_SMARTACTIVEPREMI =
		"SELECT smartActivePremi FROM SmartActivePremi smartActivePremi";

	private static final String _SQL_SELECT_SMARTACTIVEPREMI_WHERE =
		"SELECT smartActivePremi FROM SmartActivePremi smartActivePremi WHERE ";

	private static final String _SQL_COUNT_SMARTACTIVEPREMI =
		"SELECT COUNT(smartActivePremi) FROM SmartActivePremi smartActivePremi";

	private static final String _SQL_COUNT_SMARTACTIVEPREMI_WHERE =
		"SELECT COUNT(smartActivePremi) FROM SmartActivePremi smartActivePremi WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "smartActivePremi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SmartActivePremi exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SmartActivePremi exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SmartActivePremiPersistenceImpl.class);

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

	private static class SmartActivePremiModelArgumentsResolver
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

			SmartActivePremiModelImpl smartActivePremiModelImpl =
				(SmartActivePremiModelImpl)baseModel;

			long columnBitmask = smartActivePremiModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					smartActivePremiModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						smartActivePremiModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					smartActivePremiModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SmartActivePremiModelImpl smartActivePremiModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						smartActivePremiModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = smartActivePremiModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}