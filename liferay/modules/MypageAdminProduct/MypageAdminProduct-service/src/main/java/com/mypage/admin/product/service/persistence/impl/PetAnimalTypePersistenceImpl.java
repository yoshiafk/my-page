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

import com.mypage.admin.product.exception.NoSuchPetAnimalTypeException;
import com.mypage.admin.product.model.PetAnimalType;
import com.mypage.admin.product.model.impl.PetAnimalTypeImpl;
import com.mypage.admin.product.model.impl.PetAnimalTypeModelImpl;
import com.mypage.admin.product.service.persistence.PetAnimalTypePersistence;
import com.mypage.admin.product.service.persistence.PetAnimalTypeUtil;
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
 * The persistence implementation for the pet animal type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = PetAnimalTypePersistence.class)
public class PetAnimalTypePersistenceImpl
	extends BasePersistenceImpl<PetAnimalType>
	implements PetAnimalTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PetAnimalTypeUtil</code> to access the pet animal type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PetAnimalTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByfindByName;
	private FinderPath _finderPathWithoutPaginationFindByfindByName;
	private FinderPath _finderPathCountByfindByName;

	/**
	 * Returns all the pet animal types where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching pet animal types
	 */
	@Override
	public List<PetAnimalType> findByfindByName(String name) {
		return findByfindByName(
			name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pet animal types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @return the range of matching pet animal types
	 */
	@Override
	public List<PetAnimalType> findByfindByName(
		String name, int start, int end) {

		return findByfindByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pet animal types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet animal types
	 */
	@Override
	public List<PetAnimalType> findByfindByName(
		String name, int start, int end,
		OrderByComparator<PetAnimalType> orderByComparator) {

		return findByfindByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pet animal types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet animal types
	 */
	@Override
	public List<PetAnimalType> findByfindByName(
		String name, int start, int end,
		OrderByComparator<PetAnimalType> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfindByName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfindByName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<PetAnimalType> list = null;

		if (useFinderCache) {
			list = (List<PetAnimalType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PetAnimalType petAnimalType : list) {
					if (!name.equals(petAnimalType.getName())) {
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

			sb.append(_SQL_SELECT_PETANIMALTYPE_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_FINDBYNAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PetAnimalTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<PetAnimalType>)QueryUtil.list(
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
	 * Returns the first pet animal type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet animal type
	 * @throws NoSuchPetAnimalTypeException if a matching pet animal type could not be found
	 */
	@Override
	public PetAnimalType findByfindByName_First(
			String name, OrderByComparator<PetAnimalType> orderByComparator)
		throws NoSuchPetAnimalTypeException {

		PetAnimalType petAnimalType = fetchByfindByName_First(
			name, orderByComparator);

		if (petAnimalType != null) {
			return petAnimalType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchPetAnimalTypeException(sb.toString());
	}

	/**
	 * Returns the first pet animal type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet animal type, or <code>null</code> if a matching pet animal type could not be found
	 */
	@Override
	public PetAnimalType fetchByfindByName_First(
		String name, OrderByComparator<PetAnimalType> orderByComparator) {

		List<PetAnimalType> list = findByfindByName(
			name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pet animal type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet animal type
	 * @throws NoSuchPetAnimalTypeException if a matching pet animal type could not be found
	 */
	@Override
	public PetAnimalType findByfindByName_Last(
			String name, OrderByComparator<PetAnimalType> orderByComparator)
		throws NoSuchPetAnimalTypeException {

		PetAnimalType petAnimalType = fetchByfindByName_Last(
			name, orderByComparator);

		if (petAnimalType != null) {
			return petAnimalType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchPetAnimalTypeException(sb.toString());
	}

	/**
	 * Returns the last pet animal type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet animal type, or <code>null</code> if a matching pet animal type could not be found
	 */
	@Override
	public PetAnimalType fetchByfindByName_Last(
		String name, OrderByComparator<PetAnimalType> orderByComparator) {

		int count = countByfindByName(name);

		if (count == 0) {
			return null;
		}

		List<PetAnimalType> list = findByfindByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pet animal types before and after the current pet animal type in the ordered set where name = &#63;.
	 *
	 * @param petAnimalTypeId the primary key of the current pet animal type
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet animal type
	 * @throws NoSuchPetAnimalTypeException if a pet animal type with the primary key could not be found
	 */
	@Override
	public PetAnimalType[] findByfindByName_PrevAndNext(
			long petAnimalTypeId, String name,
			OrderByComparator<PetAnimalType> orderByComparator)
		throws NoSuchPetAnimalTypeException {

		name = Objects.toString(name, "");

		PetAnimalType petAnimalType = findByPrimaryKey(petAnimalTypeId);

		Session session = null;

		try {
			session = openSession();

			PetAnimalType[] array = new PetAnimalTypeImpl[3];

			array[0] = getByfindByName_PrevAndNext(
				session, petAnimalType, name, orderByComparator, true);

			array[1] = petAnimalType;

			array[2] = getByfindByName_PrevAndNext(
				session, petAnimalType, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PetAnimalType getByfindByName_PrevAndNext(
		Session session, PetAnimalType petAnimalType, String name,
		OrderByComparator<PetAnimalType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PETANIMALTYPE_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_FINDBYNAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_FINDBYNAME_NAME_2);
		}

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
			sb.append(PetAnimalTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						petAnimalType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PetAnimalType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pet animal types where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByfindByName(String name) {
		for (PetAnimalType petAnimalType :
				findByfindByName(
					name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(petAnimalType);
		}
	}

	/**
	 * Returns the number of pet animal types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching pet animal types
	 */
	@Override
	public int countByfindByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByfindByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PETANIMALTYPE_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_FINDBYNAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
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

	private static final String _FINDER_COLUMN_FINDBYNAME_NAME_2 =
		"petAnimalType.name = ?";

	private static final String _FINDER_COLUMN_FINDBYNAME_NAME_3 =
		"(petAnimalType.name IS NULL OR petAnimalType.name = '')";

	private FinderPath _finderPathFetchBysearchPetAnimalTypeId;
	private FinderPath _finderPathCountBysearchPetAnimalTypeId;

	/**
	 * Returns the pet animal type where petAnimalTypeId = &#63; or throws a <code>NoSuchPetAnimalTypeException</code> if it could not be found.
	 *
	 * @param petAnimalTypeId the pet animal type ID
	 * @return the matching pet animal type
	 * @throws NoSuchPetAnimalTypeException if a matching pet animal type could not be found
	 */
	@Override
	public PetAnimalType findBysearchPetAnimalTypeId(long petAnimalTypeId)
		throws NoSuchPetAnimalTypeException {

		PetAnimalType petAnimalType = fetchBysearchPetAnimalTypeId(
			petAnimalTypeId);

		if (petAnimalType == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("petAnimalTypeId=");
			sb.append(petAnimalTypeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPetAnimalTypeException(sb.toString());
		}

		return petAnimalType;
	}

	/**
	 * Returns the pet animal type where petAnimalTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param petAnimalTypeId the pet animal type ID
	 * @return the matching pet animal type, or <code>null</code> if a matching pet animal type could not be found
	 */
	@Override
	public PetAnimalType fetchBysearchPetAnimalTypeId(long petAnimalTypeId) {
		return fetchBysearchPetAnimalTypeId(petAnimalTypeId, true);
	}

	/**
	 * Returns the pet animal type where petAnimalTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param petAnimalTypeId the pet animal type ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet animal type, or <code>null</code> if a matching pet animal type could not be found
	 */
	@Override
	public PetAnimalType fetchBysearchPetAnimalTypeId(
		long petAnimalTypeId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {petAnimalTypeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBysearchPetAnimalTypeId, finderArgs, this);
		}

		if (result instanceof PetAnimalType) {
			PetAnimalType petAnimalType = (PetAnimalType)result;

			if (petAnimalTypeId != petAnimalType.getPetAnimalTypeId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PETANIMALTYPE_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHPETANIMALTYPEID_PETANIMALTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(petAnimalTypeId);

				List<PetAnimalType> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBysearchPetAnimalTypeId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {petAnimalTypeId};
							}

							_log.warn(
								"PetAnimalTypePersistenceImpl.fetchBysearchPetAnimalTypeId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PetAnimalType petAnimalType = list.get(0);

					result = petAnimalType;

					cacheResult(petAnimalType);
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
			return (PetAnimalType)result;
		}
	}

	/**
	 * Removes the pet animal type where petAnimalTypeId = &#63; from the database.
	 *
	 * @param petAnimalTypeId the pet animal type ID
	 * @return the pet animal type that was removed
	 */
	@Override
	public PetAnimalType removeBysearchPetAnimalTypeId(long petAnimalTypeId)
		throws NoSuchPetAnimalTypeException {

		PetAnimalType petAnimalType = findBysearchPetAnimalTypeId(
			petAnimalTypeId);

		return remove(petAnimalType);
	}

	/**
	 * Returns the number of pet animal types where petAnimalTypeId = &#63;.
	 *
	 * @param petAnimalTypeId the pet animal type ID
	 * @return the number of matching pet animal types
	 */
	@Override
	public int countBysearchPetAnimalTypeId(long petAnimalTypeId) {
		FinderPath finderPath = _finderPathCountBysearchPetAnimalTypeId;

		Object[] finderArgs = new Object[] {petAnimalTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PETANIMALTYPE_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHPETANIMALTYPEID_PETANIMALTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(petAnimalTypeId);

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
		_FINDER_COLUMN_SEARCHPETANIMALTYPEID_PETANIMALTYPEID_2 =
			"petAnimalType.petAnimalTypeId = ?";

	public PetAnimalTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PetAnimalType.class);

		setModelImplClass(PetAnimalTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the pet animal type in the entity cache if it is enabled.
	 *
	 * @param petAnimalType the pet animal type
	 */
	@Override
	public void cacheResult(PetAnimalType petAnimalType) {
		entityCache.putResult(
			PetAnimalTypeImpl.class, petAnimalType.getPrimaryKey(),
			petAnimalType);

		finderCache.putResult(
			_finderPathFetchBysearchPetAnimalTypeId,
			new Object[] {petAnimalType.getPetAnimalTypeId()}, petAnimalType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the pet animal types in the entity cache if it is enabled.
	 *
	 * @param petAnimalTypes the pet animal types
	 */
	@Override
	public void cacheResult(List<PetAnimalType> petAnimalTypes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (petAnimalTypes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PetAnimalType petAnimalType : petAnimalTypes) {
			if (entityCache.getResult(
					PetAnimalTypeImpl.class, petAnimalType.getPrimaryKey()) ==
						null) {

				cacheResult(petAnimalType);
			}
		}
	}

	/**
	 * Clears the cache for all pet animal types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PetAnimalTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pet animal type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PetAnimalType petAnimalType) {
		entityCache.removeResult(PetAnimalTypeImpl.class, petAnimalType);
	}

	@Override
	public void clearCache(List<PetAnimalType> petAnimalTypes) {
		for (PetAnimalType petAnimalType : petAnimalTypes) {
			entityCache.removeResult(PetAnimalTypeImpl.class, petAnimalType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PetAnimalTypeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PetAnimalTypeModelImpl petAnimalTypeModelImpl) {

		Object[] args = new Object[] {
			petAnimalTypeModelImpl.getPetAnimalTypeId()
		};

		finderCache.putResult(
			_finderPathCountBysearchPetAnimalTypeId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchBysearchPetAnimalTypeId, args,
			petAnimalTypeModelImpl, false);
	}

	/**
	 * Creates a new pet animal type with the primary key. Does not add the pet animal type to the database.
	 *
	 * @param petAnimalTypeId the primary key for the new pet animal type
	 * @return the new pet animal type
	 */
	@Override
	public PetAnimalType create(long petAnimalTypeId) {
		PetAnimalType petAnimalType = new PetAnimalTypeImpl();

		petAnimalType.setNew(true);
		petAnimalType.setPrimaryKey(petAnimalTypeId);

		petAnimalType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return petAnimalType;
	}

	/**
	 * Removes the pet animal type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petAnimalTypeId the primary key of the pet animal type
	 * @return the pet animal type that was removed
	 * @throws NoSuchPetAnimalTypeException if a pet animal type with the primary key could not be found
	 */
	@Override
	public PetAnimalType remove(long petAnimalTypeId)
		throws NoSuchPetAnimalTypeException {

		return remove((Serializable)petAnimalTypeId);
	}

	/**
	 * Removes the pet animal type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pet animal type
	 * @return the pet animal type that was removed
	 * @throws NoSuchPetAnimalTypeException if a pet animal type with the primary key could not be found
	 */
	@Override
	public PetAnimalType remove(Serializable primaryKey)
		throws NoSuchPetAnimalTypeException {

		Session session = null;

		try {
			session = openSession();

			PetAnimalType petAnimalType = (PetAnimalType)session.get(
				PetAnimalTypeImpl.class, primaryKey);

			if (petAnimalType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPetAnimalTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(petAnimalType);
		}
		catch (NoSuchPetAnimalTypeException noSuchEntityException) {
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
	protected PetAnimalType removeImpl(PetAnimalType petAnimalType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(petAnimalType)) {
				petAnimalType = (PetAnimalType)session.get(
					PetAnimalTypeImpl.class, petAnimalType.getPrimaryKeyObj());
			}

			if (petAnimalType != null) {
				session.delete(petAnimalType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (petAnimalType != null) {
			clearCache(petAnimalType);
		}

		return petAnimalType;
	}

	@Override
	public PetAnimalType updateImpl(PetAnimalType petAnimalType) {
		boolean isNew = petAnimalType.isNew();

		if (!(petAnimalType instanceof PetAnimalTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(petAnimalType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					petAnimalType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in petAnimalType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PetAnimalType implementation " +
					petAnimalType.getClass());
		}

		PetAnimalTypeModelImpl petAnimalTypeModelImpl =
			(PetAnimalTypeModelImpl)petAnimalType;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (petAnimalType.getCreateDate() == null)) {
			if (serviceContext == null) {
				petAnimalType.setCreateDate(date);
			}
			else {
				petAnimalType.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!petAnimalTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				petAnimalType.setModifiedDate(date);
			}
			else {
				petAnimalType.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(petAnimalType);
			}
			else {
				petAnimalType = (PetAnimalType)session.merge(petAnimalType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PetAnimalTypeImpl.class, petAnimalTypeModelImpl, false, true);

		cacheUniqueFindersCache(petAnimalTypeModelImpl);

		if (isNew) {
			petAnimalType.setNew(false);
		}

		petAnimalType.resetOriginalValues();

		return petAnimalType;
	}

	/**
	 * Returns the pet animal type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pet animal type
	 * @return the pet animal type
	 * @throws NoSuchPetAnimalTypeException if a pet animal type with the primary key could not be found
	 */
	@Override
	public PetAnimalType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPetAnimalTypeException {

		PetAnimalType petAnimalType = fetchByPrimaryKey(primaryKey);

		if (petAnimalType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPetAnimalTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return petAnimalType;
	}

	/**
	 * Returns the pet animal type with the primary key or throws a <code>NoSuchPetAnimalTypeException</code> if it could not be found.
	 *
	 * @param petAnimalTypeId the primary key of the pet animal type
	 * @return the pet animal type
	 * @throws NoSuchPetAnimalTypeException if a pet animal type with the primary key could not be found
	 */
	@Override
	public PetAnimalType findByPrimaryKey(long petAnimalTypeId)
		throws NoSuchPetAnimalTypeException {

		return findByPrimaryKey((Serializable)petAnimalTypeId);
	}

	/**
	 * Returns the pet animal type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petAnimalTypeId the primary key of the pet animal type
	 * @return the pet animal type, or <code>null</code> if a pet animal type with the primary key could not be found
	 */
	@Override
	public PetAnimalType fetchByPrimaryKey(long petAnimalTypeId) {
		return fetchByPrimaryKey((Serializable)petAnimalTypeId);
	}

	/**
	 * Returns all the pet animal types.
	 *
	 * @return the pet animal types
	 */
	@Override
	public List<PetAnimalType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pet animal types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @return the range of pet animal types
	 */
	@Override
	public List<PetAnimalType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pet animal types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pet animal types
	 */
	@Override
	public List<PetAnimalType> findAll(
		int start, int end,
		OrderByComparator<PetAnimalType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pet animal types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetAnimalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet animal types
	 * @param end the upper bound of the range of pet animal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pet animal types
	 */
	@Override
	public List<PetAnimalType> findAll(
		int start, int end, OrderByComparator<PetAnimalType> orderByComparator,
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

		List<PetAnimalType> list = null;

		if (useFinderCache) {
			list = (List<PetAnimalType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PETANIMALTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PETANIMALTYPE;

				sql = sql.concat(PetAnimalTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PetAnimalType>)QueryUtil.list(
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
	 * Removes all the pet animal types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PetAnimalType petAnimalType : findAll()) {
			remove(petAnimalType);
		}
	}

	/**
	 * Returns the number of pet animal types.
	 *
	 * @return the number of pet animal types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PETANIMALTYPE);

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
		return "petAnimalTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PETANIMALTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PetAnimalTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pet animal type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PetAnimalTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PetAnimalType.class.getName()));

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

		_finderPathWithPaginationFindByfindByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfindByName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"name"}, true);

		_finderPathWithoutPaginationFindByfindByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfindByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByfindByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_finderPathFetchBysearchPetAnimalTypeId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBysearchPetAnimalTypeId",
			new String[] {Long.class.getName()},
			new String[] {"petAnimalTypeId"}, true);

		_finderPathCountBysearchPetAnimalTypeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysearchPetAnimalTypeId", new String[] {Long.class.getName()},
			new String[] {"petAnimalTypeId"}, false);

		_setPetAnimalTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPetAnimalTypeUtilPersistence(null);

		entityCache.removeCache(PetAnimalTypeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPetAnimalTypeUtilPersistence(
		PetAnimalTypePersistence petAnimalTypePersistence) {

		try {
			Field field = PetAnimalTypeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, petAnimalTypePersistence);
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

	private static final String _SQL_SELECT_PETANIMALTYPE =
		"SELECT petAnimalType FROM PetAnimalType petAnimalType";

	private static final String _SQL_SELECT_PETANIMALTYPE_WHERE =
		"SELECT petAnimalType FROM PetAnimalType petAnimalType WHERE ";

	private static final String _SQL_COUNT_PETANIMALTYPE =
		"SELECT COUNT(petAnimalType) FROM PetAnimalType petAnimalType";

	private static final String _SQL_COUNT_PETANIMALTYPE_WHERE =
		"SELECT COUNT(petAnimalType) FROM PetAnimalType petAnimalType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "petAnimalType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PetAnimalType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PetAnimalType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PetAnimalTypePersistenceImpl.class);

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

	private static class PetAnimalTypeModelArgumentsResolver
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

			PetAnimalTypeModelImpl petAnimalTypeModelImpl =
				(PetAnimalTypeModelImpl)baseModel;

			long columnBitmask = petAnimalTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(petAnimalTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						petAnimalTypeModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(PetAnimalTypePersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(petAnimalTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PetAnimalTypeModelImpl petAnimalTypeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						petAnimalTypeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = petAnimalTypeModelImpl.getColumnValue(
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

			orderByColumnsBitmask |= PetAnimalTypeModelImpl.getColumnBitmask(
				"name");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}