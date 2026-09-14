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

import com.mypage.admin.product.exception.NoSuchHealthIndividuPremiException;
import com.mypage.admin.product.model.HealthIndividuPremi;
import com.mypage.admin.product.model.impl.HealthIndividuPremiImpl;
import com.mypage.admin.product.model.impl.HealthIndividuPremiModelImpl;
import com.mypage.admin.product.service.persistence.HealthIndividuPremiPersistence;
import com.mypage.admin.product.service.persistence.HealthIndividuPremiUtil;
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
 * The persistence implementation for the health individu premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = HealthIndividuPremiPersistence.class)
public class HealthIndividuPremiPersistenceImpl
	extends BasePersistenceImpl<HealthIndividuPremi>
	implements HealthIndividuPremiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HealthIndividuPremiUtil</code> to access the health individu premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HealthIndividuPremiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBysearchByPlanIdAndAge;
	private FinderPath _finderPathCountBysearchByPlanIdAndAge;

	/**
	 * Returns the health individu premi where planId = &#63; and age = &#63; or throws a <code>NoSuchHealthIndividuPremiException</code> if it could not be found.
	 *
	 * @param planId the plan ID
	 * @param age the age
	 * @return the matching health individu premi
	 * @throws NoSuchHealthIndividuPremiException if a matching health individu premi could not be found
	 */
	@Override
	public HealthIndividuPremi findBysearchByPlanIdAndAge(long planId, int age)
		throws NoSuchHealthIndividuPremiException {

		HealthIndividuPremi healthIndividuPremi = fetchBysearchByPlanIdAndAge(
			planId, age);

		if (healthIndividuPremi == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("planId=");
			sb.append(planId);

			sb.append(", age=");
			sb.append(age);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchHealthIndividuPremiException(sb.toString());
		}

		return healthIndividuPremi;
	}

	/**
	 * Returns the health individu premi where planId = &#63; and age = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param planId the plan ID
	 * @param age the age
	 * @return the matching health individu premi, or <code>null</code> if a matching health individu premi could not be found
	 */
	@Override
	public HealthIndividuPremi fetchBysearchByPlanIdAndAge(
		long planId, int age) {

		return fetchBysearchByPlanIdAndAge(planId, age, true);
	}

	/**
	 * Returns the health individu premi where planId = &#63; and age = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param planId the plan ID
	 * @param age the age
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching health individu premi, or <code>null</code> if a matching health individu premi could not be found
	 */
	@Override
	public HealthIndividuPremi fetchBysearchByPlanIdAndAge(
		long planId, int age, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {planId, age};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBysearchByPlanIdAndAge, finderArgs, this);
		}

		if (result instanceof HealthIndividuPremi) {
			HealthIndividuPremi healthIndividuPremi =
				(HealthIndividuPremi)result;

			if ((planId != healthIndividuPremi.getPlanId()) ||
				(age != healthIndividuPremi.getAge())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_HEALTHINDIVIDUPREMI_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYPLANIDANDAGE_PLANID_2);

			sb.append(_FINDER_COLUMN_SEARCHBYPLANIDANDAGE_AGE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(planId);

				queryPos.add(age);

				List<HealthIndividuPremi> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBysearchByPlanIdAndAge, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {planId, age};
							}

							_log.warn(
								"HealthIndividuPremiPersistenceImpl.fetchBysearchByPlanIdAndAge(long, int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					HealthIndividuPremi healthIndividuPremi = list.get(0);

					result = healthIndividuPremi;

					cacheResult(healthIndividuPremi);
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
			return (HealthIndividuPremi)result;
		}
	}

	/**
	 * Removes the health individu premi where planId = &#63; and age = &#63; from the database.
	 *
	 * @param planId the plan ID
	 * @param age the age
	 * @return the health individu premi that was removed
	 */
	@Override
	public HealthIndividuPremi removeBysearchByPlanIdAndAge(
			long planId, int age)
		throws NoSuchHealthIndividuPremiException {

		HealthIndividuPremi healthIndividuPremi = findBysearchByPlanIdAndAge(
			planId, age);

		return remove(healthIndividuPremi);
	}

	/**
	 * Returns the number of health individu premis where planId = &#63; and age = &#63;.
	 *
	 * @param planId the plan ID
	 * @param age the age
	 * @return the number of matching health individu premis
	 */
	@Override
	public int countBysearchByPlanIdAndAge(long planId, int age) {
		FinderPath finderPath = _finderPathCountBysearchByPlanIdAndAge;

		Object[] finderArgs = new Object[] {planId, age};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_HEALTHINDIVIDUPREMI_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYPLANIDANDAGE_PLANID_2);

			sb.append(_FINDER_COLUMN_SEARCHBYPLANIDANDAGE_AGE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(planId);

				queryPos.add(age);

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

	private static final String _FINDER_COLUMN_SEARCHBYPLANIDANDAGE_PLANID_2 =
		"healthIndividuPremi.planId = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHBYPLANIDANDAGE_AGE_2 =
		"healthIndividuPremi.age = ? AND healthIndividuPremi.active=1";

	public HealthIndividuPremiPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(HealthIndividuPremi.class);

		setModelImplClass(HealthIndividuPremiImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the health individu premi in the entity cache if it is enabled.
	 *
	 * @param healthIndividuPremi the health individu premi
	 */
	@Override
	public void cacheResult(HealthIndividuPremi healthIndividuPremi) {
		entityCache.putResult(
			HealthIndividuPremiImpl.class, healthIndividuPremi.getPrimaryKey(),
			healthIndividuPremi);

		finderCache.putResult(
			_finderPathFetchBysearchByPlanIdAndAge,
			new Object[] {
				healthIndividuPremi.getPlanId(), healthIndividuPremi.getAge()
			},
			healthIndividuPremi);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the health individu premis in the entity cache if it is enabled.
	 *
	 * @param healthIndividuPremis the health individu premis
	 */
	@Override
	public void cacheResult(List<HealthIndividuPremi> healthIndividuPremis) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (healthIndividuPremis.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (HealthIndividuPremi healthIndividuPremi : healthIndividuPremis) {
			if (entityCache.getResult(
					HealthIndividuPremiImpl.class,
					healthIndividuPremi.getPrimaryKey()) == null) {

				cacheResult(healthIndividuPremi);
			}
		}
	}

	/**
	 * Clears the cache for all health individu premis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HealthIndividuPremiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the health individu premi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HealthIndividuPremi healthIndividuPremi) {
		entityCache.removeResult(
			HealthIndividuPremiImpl.class, healthIndividuPremi);
	}

	@Override
	public void clearCache(List<HealthIndividuPremi> healthIndividuPremis) {
		for (HealthIndividuPremi healthIndividuPremi : healthIndividuPremis) {
			entityCache.removeResult(
				HealthIndividuPremiImpl.class, healthIndividuPremi);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(HealthIndividuPremiImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		HealthIndividuPremiModelImpl healthIndividuPremiModelImpl) {

		Object[] args = new Object[] {
			healthIndividuPremiModelImpl.getPlanId(),
			healthIndividuPremiModelImpl.getAge()
		};

		finderCache.putResult(
			_finderPathCountBysearchByPlanIdAndAge, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchBysearchByPlanIdAndAge, args,
			healthIndividuPremiModelImpl, false);
	}

	/**
	 * Creates a new health individu premi with the primary key. Does not add the health individu premi to the database.
	 *
	 * @param healthIndividuPremiId the primary key for the new health individu premi
	 * @return the new health individu premi
	 */
	@Override
	public HealthIndividuPremi create(long healthIndividuPremiId) {
		HealthIndividuPremi healthIndividuPremi = new HealthIndividuPremiImpl();

		healthIndividuPremi.setNew(true);
		healthIndividuPremi.setPrimaryKey(healthIndividuPremiId);

		healthIndividuPremi.setCompanyId(CompanyThreadLocal.getCompanyId());

		return healthIndividuPremi;
	}

	/**
	 * Removes the health individu premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param healthIndividuPremiId the primary key of the health individu premi
	 * @return the health individu premi that was removed
	 * @throws NoSuchHealthIndividuPremiException if a health individu premi with the primary key could not be found
	 */
	@Override
	public HealthIndividuPremi remove(long healthIndividuPremiId)
		throws NoSuchHealthIndividuPremiException {

		return remove((Serializable)healthIndividuPremiId);
	}

	/**
	 * Removes the health individu premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the health individu premi
	 * @return the health individu premi that was removed
	 * @throws NoSuchHealthIndividuPremiException if a health individu premi with the primary key could not be found
	 */
	@Override
	public HealthIndividuPremi remove(Serializable primaryKey)
		throws NoSuchHealthIndividuPremiException {

		Session session = null;

		try {
			session = openSession();

			HealthIndividuPremi healthIndividuPremi =
				(HealthIndividuPremi)session.get(
					HealthIndividuPremiImpl.class, primaryKey);

			if (healthIndividuPremi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHealthIndividuPremiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(healthIndividuPremi);
		}
		catch (NoSuchHealthIndividuPremiException noSuchEntityException) {
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
	protected HealthIndividuPremi removeImpl(
		HealthIndividuPremi healthIndividuPremi) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(healthIndividuPremi)) {
				healthIndividuPremi = (HealthIndividuPremi)session.get(
					HealthIndividuPremiImpl.class,
					healthIndividuPremi.getPrimaryKeyObj());
			}

			if (healthIndividuPremi != null) {
				session.delete(healthIndividuPremi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (healthIndividuPremi != null) {
			clearCache(healthIndividuPremi);
		}

		return healthIndividuPremi;
	}

	@Override
	public HealthIndividuPremi updateImpl(
		HealthIndividuPremi healthIndividuPremi) {

		boolean isNew = healthIndividuPremi.isNew();

		if (!(healthIndividuPremi instanceof HealthIndividuPremiModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(healthIndividuPremi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					healthIndividuPremi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in healthIndividuPremi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom HealthIndividuPremi implementation " +
					healthIndividuPremi.getClass());
		}

		HealthIndividuPremiModelImpl healthIndividuPremiModelImpl =
			(HealthIndividuPremiModelImpl)healthIndividuPremi;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (healthIndividuPremi.getCreateDate() == null)) {
			if (serviceContext == null) {
				healthIndividuPremi.setCreateDate(date);
			}
			else {
				healthIndividuPremi.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!healthIndividuPremiModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				healthIndividuPremi.setModifiedDate(date);
			}
			else {
				healthIndividuPremi.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(healthIndividuPremi);
			}
			else {
				healthIndividuPremi = (HealthIndividuPremi)session.merge(
					healthIndividuPremi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			HealthIndividuPremiImpl.class, healthIndividuPremiModelImpl, false,
			true);

		cacheUniqueFindersCache(healthIndividuPremiModelImpl);

		if (isNew) {
			healthIndividuPremi.setNew(false);
		}

		healthIndividuPremi.resetOriginalValues();

		return healthIndividuPremi;
	}

	/**
	 * Returns the health individu premi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the health individu premi
	 * @return the health individu premi
	 * @throws NoSuchHealthIndividuPremiException if a health individu premi with the primary key could not be found
	 */
	@Override
	public HealthIndividuPremi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHealthIndividuPremiException {

		HealthIndividuPremi healthIndividuPremi = fetchByPrimaryKey(primaryKey);

		if (healthIndividuPremi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHealthIndividuPremiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return healthIndividuPremi;
	}

	/**
	 * Returns the health individu premi with the primary key or throws a <code>NoSuchHealthIndividuPremiException</code> if it could not be found.
	 *
	 * @param healthIndividuPremiId the primary key of the health individu premi
	 * @return the health individu premi
	 * @throws NoSuchHealthIndividuPremiException if a health individu premi with the primary key could not be found
	 */
	@Override
	public HealthIndividuPremi findByPrimaryKey(long healthIndividuPremiId)
		throws NoSuchHealthIndividuPremiException {

		return findByPrimaryKey((Serializable)healthIndividuPremiId);
	}

	/**
	 * Returns the health individu premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param healthIndividuPremiId the primary key of the health individu premi
	 * @return the health individu premi, or <code>null</code> if a health individu premi with the primary key could not be found
	 */
	@Override
	public HealthIndividuPremi fetchByPrimaryKey(long healthIndividuPremiId) {
		return fetchByPrimaryKey((Serializable)healthIndividuPremiId);
	}

	/**
	 * Returns all the health individu premis.
	 *
	 * @return the health individu premis
	 */
	@Override
	public List<HealthIndividuPremi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the health individu premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu premis
	 * @param end the upper bound of the range of health individu premis (not inclusive)
	 * @return the range of health individu premis
	 */
	@Override
	public List<HealthIndividuPremi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the health individu premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu premis
	 * @param end the upper bound of the range of health individu premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of health individu premis
	 */
	@Override
	public List<HealthIndividuPremi> findAll(
		int start, int end,
		OrderByComparator<HealthIndividuPremi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the health individu premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu premis
	 * @param end the upper bound of the range of health individu premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of health individu premis
	 */
	@Override
	public List<HealthIndividuPremi> findAll(
		int start, int end,
		OrderByComparator<HealthIndividuPremi> orderByComparator,
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

		List<HealthIndividuPremi> list = null;

		if (useFinderCache) {
			list = (List<HealthIndividuPremi>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HEALTHINDIVIDUPREMI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HEALTHINDIVIDUPREMI;

				sql = sql.concat(HealthIndividuPremiModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<HealthIndividuPremi>)QueryUtil.list(
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
	 * Removes all the health individu premis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (HealthIndividuPremi healthIndividuPremi : findAll()) {
			remove(healthIndividuPremi);
		}
	}

	/**
	 * Returns the number of health individu premis.
	 *
	 * @return the number of health individu premis
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
					_SQL_COUNT_HEALTHINDIVIDUPREMI);

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
		return "healthIndividuPremiId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_HEALTHINDIVIDUPREMI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HealthIndividuPremiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the health individu premi persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new HealthIndividuPremiModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", HealthIndividuPremi.class.getName()));

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

		_finderPathFetchBysearchByPlanIdAndAge = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBysearchByPlanIdAndAge",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"planId", "age"}, true);

		_finderPathCountBysearchByPlanIdAndAge = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysearchByPlanIdAndAge",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"planId", "age"}, false);

		_setHealthIndividuPremiUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setHealthIndividuPremiUtilPersistence(null);

		entityCache.removeCache(HealthIndividuPremiImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setHealthIndividuPremiUtilPersistence(
		HealthIndividuPremiPersistence healthIndividuPremiPersistence) {

		try {
			Field field = HealthIndividuPremiUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, healthIndividuPremiPersistence);
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

	private static final String _SQL_SELECT_HEALTHINDIVIDUPREMI =
		"SELECT healthIndividuPremi FROM HealthIndividuPremi healthIndividuPremi";

	private static final String _SQL_SELECT_HEALTHINDIVIDUPREMI_WHERE =
		"SELECT healthIndividuPremi FROM HealthIndividuPremi healthIndividuPremi WHERE ";

	private static final String _SQL_COUNT_HEALTHINDIVIDUPREMI =
		"SELECT COUNT(healthIndividuPremi) FROM HealthIndividuPremi healthIndividuPremi";

	private static final String _SQL_COUNT_HEALTHINDIVIDUPREMI_WHERE =
		"SELECT COUNT(healthIndividuPremi) FROM HealthIndividuPremi healthIndividuPremi WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "healthIndividuPremi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No HealthIndividuPremi exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No HealthIndividuPremi exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		HealthIndividuPremiPersistenceImpl.class);

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

	private static class HealthIndividuPremiModelArgumentsResolver
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

			HealthIndividuPremiModelImpl healthIndividuPremiModelImpl =
				(HealthIndividuPremiModelImpl)baseModel;

			long columnBitmask =
				healthIndividuPremiModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					healthIndividuPremiModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						healthIndividuPremiModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					healthIndividuPremiModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			HealthIndividuPremiModelImpl healthIndividuPremiModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						healthIndividuPremiModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = healthIndividuPremiModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}