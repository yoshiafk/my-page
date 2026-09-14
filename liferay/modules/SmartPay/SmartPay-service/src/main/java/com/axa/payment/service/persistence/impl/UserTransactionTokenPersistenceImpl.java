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

package com.axa.payment.service.persistence.impl;

import com.axa.payment.exception.NoSuchUserTransactionTokenException;
import com.axa.payment.model.UserTransactionToken;
import com.axa.payment.model.impl.UserTransactionTokenImpl;
import com.axa.payment.model.impl.UserTransactionTokenModelImpl;
import com.axa.payment.service.persistence.UserTransactionTokenPersistence;
import com.axa.payment.service.persistence.UserTransactionTokenUtil;
import com.axa.payment.service.persistence.impl.constants.APPersistenceConstants;

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

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
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
 * The persistence implementation for the user transaction token service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = UserTransactionTokenPersistence.class)
public class UserTransactionTokenPersistenceImpl
	extends BasePersistenceImpl<UserTransactionToken>
	implements UserTransactionTokenPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserTransactionTokenUtil</code> to access the user transaction token persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserTransactionTokenImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBypolicyProfile;
	private FinderPath _finderPathWithoutPaginationFindBypolicyProfile;
	private FinderPath _finderPathCountBypolicyProfile;

	/**
	 * Returns all the user transaction tokens where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @return the matching user transaction tokens
	 */
	@Override
	public List<UserTransactionToken> findBypolicyProfile(
		String policyNumber, String profileId) {

		return findBypolicyProfile(
			policyNumber, profileId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the user transaction tokens where policyNumber = &#63; and profileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @return the range of matching user transaction tokens
	 */
	@Override
	public List<UserTransactionToken> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end) {

		return findBypolicyProfile(policyNumber, profileId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user transaction tokens where policyNumber = &#63; and profileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user transaction tokens
	 */
	@Override
	public List<UserTransactionToken> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		return findBypolicyProfile(
			policyNumber, profileId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user transaction tokens where policyNumber = &#63; and profileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user transaction tokens
	 */
	@Override
	public List<UserTransactionToken> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end,
		OrderByComparator<UserTransactionToken> orderByComparator,
		boolean useFinderCache) {

		policyNumber = Objects.toString(policyNumber, "");
		profileId = Objects.toString(profileId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBypolicyProfile;
				finderArgs = new Object[] {policyNumber, profileId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBypolicyProfile;
			finderArgs = new Object[] {
				policyNumber, profileId, start, end, orderByComparator
			};
		}

		List<UserTransactionToken> list = null;

		if (useFinderCache) {
			list = (List<UserTransactionToken>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserTransactionToken userTransactionToken : list) {
					if (!policyNumber.equals(
							userTransactionToken.getPolicyNumber()) ||
						!profileId.equals(
							userTransactionToken.getProfileId())) {

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

			sb.append(_SQL_SELECT_USERTRANSACTIONTOKEN_WHERE);

			boolean bindPolicyNumber = false;

			if (policyNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYPROFILE_POLICYNUMBER_3);
			}
			else {
				bindPolicyNumber = true;

				sb.append(_FINDER_COLUMN_POLICYPROFILE_POLICYNUMBER_2);
			}

			boolean bindProfileId = false;

			if (profileId.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYPROFILE_PROFILEID_3);
			}
			else {
				bindProfileId = true;

				sb.append(_FINDER_COLUMN_POLICYPROFILE_PROFILEID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserTransactionTokenModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPolicyNumber) {
					queryPos.add(policyNumber);
				}

				if (bindProfileId) {
					queryPos.add(profileId);
				}

				list = (List<UserTransactionToken>)QueryUtil.list(
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
	 * Returns the first user transaction token in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	@Override
	public UserTransactionToken findBypolicyProfile_First(
			String policyNumber, String profileId,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException {

		UserTransactionToken userTransactionToken = fetchBypolicyProfile_First(
			policyNumber, profileId, orderByComparator);

		if (userTransactionToken != null) {
			return userTransactionToken;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNumber=");
		sb.append(policyNumber);

		sb.append(", profileId=");
		sb.append(profileId);

		sb.append("}");

		throw new NoSuchUserTransactionTokenException(sb.toString());
	}

	/**
	 * Returns the first user transaction token in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	@Override
	public UserTransactionToken fetchBypolicyProfile_First(
		String policyNumber, String profileId,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		List<UserTransactionToken> list = findBypolicyProfile(
			policyNumber, profileId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user transaction token in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	@Override
	public UserTransactionToken findBypolicyProfile_Last(
			String policyNumber, String profileId,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException {

		UserTransactionToken userTransactionToken = fetchBypolicyProfile_Last(
			policyNumber, profileId, orderByComparator);

		if (userTransactionToken != null) {
			return userTransactionToken;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNumber=");
		sb.append(policyNumber);

		sb.append(", profileId=");
		sb.append(profileId);

		sb.append("}");

		throw new NoSuchUserTransactionTokenException(sb.toString());
	}

	/**
	 * Returns the last user transaction token in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	@Override
	public UserTransactionToken fetchBypolicyProfile_Last(
		String policyNumber, String profileId,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		int count = countBypolicyProfile(policyNumber, profileId);

		if (count == 0) {
			return null;
		}

		List<UserTransactionToken> list = findBypolicyProfile(
			policyNumber, profileId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user transaction tokens before and after the current user transaction token in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param userTransactionTokenId the primary key of the current user transaction token
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user transaction token
	 * @throws NoSuchUserTransactionTokenException if a user transaction token with the primary key could not be found
	 */
	@Override
	public UserTransactionToken[] findBypolicyProfile_PrevAndNext(
			long userTransactionTokenId, String policyNumber, String profileId,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException {

		policyNumber = Objects.toString(policyNumber, "");
		profileId = Objects.toString(profileId, "");

		UserTransactionToken userTransactionToken = findByPrimaryKey(
			userTransactionTokenId);

		Session session = null;

		try {
			session = openSession();

			UserTransactionToken[] array = new UserTransactionTokenImpl[3];

			array[0] = getBypolicyProfile_PrevAndNext(
				session, userTransactionToken, policyNumber, profileId,
				orderByComparator, true);

			array[1] = userTransactionToken;

			array[2] = getBypolicyProfile_PrevAndNext(
				session, userTransactionToken, policyNumber, profileId,
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

	protected UserTransactionToken getBypolicyProfile_PrevAndNext(
		Session session, UserTransactionToken userTransactionToken,
		String policyNumber, String profileId,
		OrderByComparator<UserTransactionToken> orderByComparator,
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

		sb.append(_SQL_SELECT_USERTRANSACTIONTOKEN_WHERE);

		boolean bindPolicyNumber = false;

		if (policyNumber.isEmpty()) {
			sb.append(_FINDER_COLUMN_POLICYPROFILE_POLICYNUMBER_3);
		}
		else {
			bindPolicyNumber = true;

			sb.append(_FINDER_COLUMN_POLICYPROFILE_POLICYNUMBER_2);
		}

		boolean bindProfileId = false;

		if (profileId.isEmpty()) {
			sb.append(_FINDER_COLUMN_POLICYPROFILE_PROFILEID_3);
		}
		else {
			bindProfileId = true;

			sb.append(_FINDER_COLUMN_POLICYPROFILE_PROFILEID_2);
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
			sb.append(UserTransactionTokenModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPolicyNumber) {
			queryPos.add(policyNumber);
		}

		if (bindProfileId) {
			queryPos.add(profileId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						userTransactionToken)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserTransactionToken> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user transaction tokens where policyNumber = &#63; and profileId = &#63; from the database.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 */
	@Override
	public void removeBypolicyProfile(String policyNumber, String profileId) {
		for (UserTransactionToken userTransactionToken :
				findBypolicyProfile(
					policyNumber, profileId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(userTransactionToken);
		}
	}

	/**
	 * Returns the number of user transaction tokens where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @return the number of matching user transaction tokens
	 */
	@Override
	public int countBypolicyProfile(String policyNumber, String profileId) {
		policyNumber = Objects.toString(policyNumber, "");
		profileId = Objects.toString(profileId, "");

		FinderPath finderPath = _finderPathCountBypolicyProfile;

		Object[] finderArgs = new Object[] {policyNumber, profileId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_USERTRANSACTIONTOKEN_WHERE);

			boolean bindPolicyNumber = false;

			if (policyNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYPROFILE_POLICYNUMBER_3);
			}
			else {
				bindPolicyNumber = true;

				sb.append(_FINDER_COLUMN_POLICYPROFILE_POLICYNUMBER_2);
			}

			boolean bindProfileId = false;

			if (profileId.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYPROFILE_PROFILEID_3);
			}
			else {
				bindProfileId = true;

				sb.append(_FINDER_COLUMN_POLICYPROFILE_PROFILEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPolicyNumber) {
					queryPos.add(policyNumber);
				}

				if (bindProfileId) {
					queryPos.add(profileId);
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

	private static final String _FINDER_COLUMN_POLICYPROFILE_POLICYNUMBER_2 =
		"userTransactionToken.policyNumber = ? AND ";

	private static final String _FINDER_COLUMN_POLICYPROFILE_POLICYNUMBER_3 =
		"(userTransactionToken.policyNumber IS NULL OR userTransactionToken.policyNumber = '') AND ";

	private static final String _FINDER_COLUMN_POLICYPROFILE_PROFILEID_2 =
		"userTransactionToken.profileId = ?";

	private static final String _FINDER_COLUMN_POLICYPROFILE_PROFILEID_3 =
		"(userTransactionToken.profileId IS NULL OR userTransactionToken.profileId = '')";

	private FinderPath _finderPathWithPaginationFindByinvoiceNumber;
	private FinderPath _finderPathWithoutPaginationFindByinvoiceNumber;
	private FinderPath _finderPathCountByinvoiceNumber;

	/**
	 * Returns all the user transaction tokens where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the matching user transaction tokens
	 */
	@Override
	public List<UserTransactionToken> findByinvoiceNumber(
		String invoiceNumber) {

		return findByinvoiceNumber(
			invoiceNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user transaction tokens where invoiceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceNumber the invoice number
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @return the range of matching user transaction tokens
	 */
	@Override
	public List<UserTransactionToken> findByinvoiceNumber(
		String invoiceNumber, int start, int end) {

		return findByinvoiceNumber(invoiceNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user transaction tokens where invoiceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceNumber the invoice number
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user transaction tokens
	 */
	@Override
	public List<UserTransactionToken> findByinvoiceNumber(
		String invoiceNumber, int start, int end,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		return findByinvoiceNumber(
			invoiceNumber, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user transaction tokens where invoiceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceNumber the invoice number
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user transaction tokens
	 */
	@Override
	public List<UserTransactionToken> findByinvoiceNumber(
		String invoiceNumber, int start, int end,
		OrderByComparator<UserTransactionToken> orderByComparator,
		boolean useFinderCache) {

		invoiceNumber = Objects.toString(invoiceNumber, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByinvoiceNumber;
				finderArgs = new Object[] {invoiceNumber};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByinvoiceNumber;
			finderArgs = new Object[] {
				invoiceNumber, start, end, orderByComparator
			};
		}

		List<UserTransactionToken> list = null;

		if (useFinderCache) {
			list = (List<UserTransactionToken>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserTransactionToken userTransactionToken : list) {
					if (!invoiceNumber.equals(
							userTransactionToken.getInvoiceNumber())) {

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

			sb.append(_SQL_SELECT_USERTRANSACTIONTOKEN_WHERE);

			boolean bindInvoiceNumber = false;

			if (invoiceNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_3);
			}
			else {
				bindInvoiceNumber = true;

				sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserTransactionTokenModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindInvoiceNumber) {
					queryPos.add(invoiceNumber);
				}

				list = (List<UserTransactionToken>)QueryUtil.list(
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
	 * Returns the first user transaction token in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	@Override
	public UserTransactionToken findByinvoiceNumber_First(
			String invoiceNumber,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException {

		UserTransactionToken userTransactionToken = fetchByinvoiceNumber_First(
			invoiceNumber, orderByComparator);

		if (userTransactionToken != null) {
			return userTransactionToken;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("invoiceNumber=");
		sb.append(invoiceNumber);

		sb.append("}");

		throw new NoSuchUserTransactionTokenException(sb.toString());
	}

	/**
	 * Returns the first user transaction token in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	@Override
	public UserTransactionToken fetchByinvoiceNumber_First(
		String invoiceNumber,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		List<UserTransactionToken> list = findByinvoiceNumber(
			invoiceNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user transaction token in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	@Override
	public UserTransactionToken findByinvoiceNumber_Last(
			String invoiceNumber,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException {

		UserTransactionToken userTransactionToken = fetchByinvoiceNumber_Last(
			invoiceNumber, orderByComparator);

		if (userTransactionToken != null) {
			return userTransactionToken;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("invoiceNumber=");
		sb.append(invoiceNumber);

		sb.append("}");

		throw new NoSuchUserTransactionTokenException(sb.toString());
	}

	/**
	 * Returns the last user transaction token in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	@Override
	public UserTransactionToken fetchByinvoiceNumber_Last(
		String invoiceNumber,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		int count = countByinvoiceNumber(invoiceNumber);

		if (count == 0) {
			return null;
		}

		List<UserTransactionToken> list = findByinvoiceNumber(
			invoiceNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user transaction tokens before and after the current user transaction token in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param userTransactionTokenId the primary key of the current user transaction token
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user transaction token
	 * @throws NoSuchUserTransactionTokenException if a user transaction token with the primary key could not be found
	 */
	@Override
	public UserTransactionToken[] findByinvoiceNumber_PrevAndNext(
			long userTransactionTokenId, String invoiceNumber,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException {

		invoiceNumber = Objects.toString(invoiceNumber, "");

		UserTransactionToken userTransactionToken = findByPrimaryKey(
			userTransactionTokenId);

		Session session = null;

		try {
			session = openSession();

			UserTransactionToken[] array = new UserTransactionTokenImpl[3];

			array[0] = getByinvoiceNumber_PrevAndNext(
				session, userTransactionToken, invoiceNumber, orderByComparator,
				true);

			array[1] = userTransactionToken;

			array[2] = getByinvoiceNumber_PrevAndNext(
				session, userTransactionToken, invoiceNumber, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserTransactionToken getByinvoiceNumber_PrevAndNext(
		Session session, UserTransactionToken userTransactionToken,
		String invoiceNumber,
		OrderByComparator<UserTransactionToken> orderByComparator,
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

		sb.append(_SQL_SELECT_USERTRANSACTIONTOKEN_WHERE);

		boolean bindInvoiceNumber = false;

		if (invoiceNumber.isEmpty()) {
			sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_3);
		}
		else {
			bindInvoiceNumber = true;

			sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_2);
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
			sb.append(UserTransactionTokenModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindInvoiceNumber) {
			queryPos.add(invoiceNumber);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						userTransactionToken)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserTransactionToken> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user transaction tokens where invoiceNumber = &#63; from the database.
	 *
	 * @param invoiceNumber the invoice number
	 */
	@Override
	public void removeByinvoiceNumber(String invoiceNumber) {
		for (UserTransactionToken userTransactionToken :
				findByinvoiceNumber(
					invoiceNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userTransactionToken);
		}
	}

	/**
	 * Returns the number of user transaction tokens where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the number of matching user transaction tokens
	 */
	@Override
	public int countByinvoiceNumber(String invoiceNumber) {
		invoiceNumber = Objects.toString(invoiceNumber, "");

		FinderPath finderPath = _finderPathCountByinvoiceNumber;

		Object[] finderArgs = new Object[] {invoiceNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERTRANSACTIONTOKEN_WHERE);

			boolean bindInvoiceNumber = false;

			if (invoiceNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_3);
			}
			else {
				bindInvoiceNumber = true;

				sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindInvoiceNumber) {
					queryPos.add(invoiceNumber);
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

	private static final String _FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_2 =
		"userTransactionToken.invoiceNumber = ?";

	private static final String _FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_3 =
		"(userTransactionToken.invoiceNumber IS NULL OR userTransactionToken.invoiceNumber = '')";

	private FinderPath _finderPathWithPaginationFindBytoken;
	private FinderPath _finderPathWithoutPaginationFindBytoken;
	private FinderPath _finderPathCountBytoken;

	/**
	 * Returns all the user transaction tokens where token = &#63;.
	 *
	 * @param token the token
	 * @return the matching user transaction tokens
	 */
	@Override
	public List<UserTransactionToken> findBytoken(String token) {
		return findBytoken(token, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user transaction tokens where token = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param token the token
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @return the range of matching user transaction tokens
	 */
	@Override
	public List<UserTransactionToken> findBytoken(
		String token, int start, int end) {

		return findBytoken(token, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user transaction tokens where token = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param token the token
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user transaction tokens
	 */
	@Override
	public List<UserTransactionToken> findBytoken(
		String token, int start, int end,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		return findBytoken(token, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user transaction tokens where token = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param token the token
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user transaction tokens
	 */
	@Override
	public List<UserTransactionToken> findBytoken(
		String token, int start, int end,
		OrderByComparator<UserTransactionToken> orderByComparator,
		boolean useFinderCache) {

		token = Objects.toString(token, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBytoken;
				finderArgs = new Object[] {token};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBytoken;
			finderArgs = new Object[] {token, start, end, orderByComparator};
		}

		List<UserTransactionToken> list = null;

		if (useFinderCache) {
			list = (List<UserTransactionToken>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserTransactionToken userTransactionToken : list) {
					if (!token.equals(userTransactionToken.getToken())) {
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

			sb.append(_SQL_SELECT_USERTRANSACTIONTOKEN_WHERE);

			boolean bindToken = false;

			if (token.isEmpty()) {
				sb.append(_FINDER_COLUMN_TOKEN_TOKEN_3);
			}
			else {
				bindToken = true;

				sb.append(_FINDER_COLUMN_TOKEN_TOKEN_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserTransactionTokenModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindToken) {
					queryPos.add(token);
				}

				list = (List<UserTransactionToken>)QueryUtil.list(
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
	 * Returns the first user transaction token in the ordered set where token = &#63;.
	 *
	 * @param token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	@Override
	public UserTransactionToken findBytoken_First(
			String token,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException {

		UserTransactionToken userTransactionToken = fetchBytoken_First(
			token, orderByComparator);

		if (userTransactionToken != null) {
			return userTransactionToken;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("token=");
		sb.append(token);

		sb.append("}");

		throw new NoSuchUserTransactionTokenException(sb.toString());
	}

	/**
	 * Returns the first user transaction token in the ordered set where token = &#63;.
	 *
	 * @param token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	@Override
	public UserTransactionToken fetchBytoken_First(
		String token,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		List<UserTransactionToken> list = findBytoken(
			token, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user transaction token in the ordered set where token = &#63;.
	 *
	 * @param token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token
	 * @throws NoSuchUserTransactionTokenException if a matching user transaction token could not be found
	 */
	@Override
	public UserTransactionToken findBytoken_Last(
			String token,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException {

		UserTransactionToken userTransactionToken = fetchBytoken_Last(
			token, orderByComparator);

		if (userTransactionToken != null) {
			return userTransactionToken;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("token=");
		sb.append(token);

		sb.append("}");

		throw new NoSuchUserTransactionTokenException(sb.toString());
	}

	/**
	 * Returns the last user transaction token in the ordered set where token = &#63;.
	 *
	 * @param token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user transaction token, or <code>null</code> if a matching user transaction token could not be found
	 */
	@Override
	public UserTransactionToken fetchBytoken_Last(
		String token,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		int count = countBytoken(token);

		if (count == 0) {
			return null;
		}

		List<UserTransactionToken> list = findBytoken(
			token, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user transaction tokens before and after the current user transaction token in the ordered set where token = &#63;.
	 *
	 * @param userTransactionTokenId the primary key of the current user transaction token
	 * @param token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user transaction token
	 * @throws NoSuchUserTransactionTokenException if a user transaction token with the primary key could not be found
	 */
	@Override
	public UserTransactionToken[] findBytoken_PrevAndNext(
			long userTransactionTokenId, String token,
			OrderByComparator<UserTransactionToken> orderByComparator)
		throws NoSuchUserTransactionTokenException {

		token = Objects.toString(token, "");

		UserTransactionToken userTransactionToken = findByPrimaryKey(
			userTransactionTokenId);

		Session session = null;

		try {
			session = openSession();

			UserTransactionToken[] array = new UserTransactionTokenImpl[3];

			array[0] = getBytoken_PrevAndNext(
				session, userTransactionToken, token, orderByComparator, true);

			array[1] = userTransactionToken;

			array[2] = getBytoken_PrevAndNext(
				session, userTransactionToken, token, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserTransactionToken getBytoken_PrevAndNext(
		Session session, UserTransactionToken userTransactionToken,
		String token, OrderByComparator<UserTransactionToken> orderByComparator,
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

		sb.append(_SQL_SELECT_USERTRANSACTIONTOKEN_WHERE);

		boolean bindToken = false;

		if (token.isEmpty()) {
			sb.append(_FINDER_COLUMN_TOKEN_TOKEN_3);
		}
		else {
			bindToken = true;

			sb.append(_FINDER_COLUMN_TOKEN_TOKEN_2);
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
			sb.append(UserTransactionTokenModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindToken) {
			queryPos.add(token);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						userTransactionToken)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserTransactionToken> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user transaction tokens where token = &#63; from the database.
	 *
	 * @param token the token
	 */
	@Override
	public void removeBytoken(String token) {
		for (UserTransactionToken userTransactionToken :
				findBytoken(
					token, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userTransactionToken);
		}
	}

	/**
	 * Returns the number of user transaction tokens where token = &#63;.
	 *
	 * @param token the token
	 * @return the number of matching user transaction tokens
	 */
	@Override
	public int countBytoken(String token) {
		token = Objects.toString(token, "");

		FinderPath finderPath = _finderPathCountBytoken;

		Object[] finderArgs = new Object[] {token};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERTRANSACTIONTOKEN_WHERE);

			boolean bindToken = false;

			if (token.isEmpty()) {
				sb.append(_FINDER_COLUMN_TOKEN_TOKEN_3);
			}
			else {
				bindToken = true;

				sb.append(_FINDER_COLUMN_TOKEN_TOKEN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindToken) {
					queryPos.add(token);
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

	private static final String _FINDER_COLUMN_TOKEN_TOKEN_2 =
		"userTransactionToken.token = ?";

	private static final String _FINDER_COLUMN_TOKEN_TOKEN_3 =
		"(userTransactionToken.token IS NULL OR userTransactionToken.token = '')";

	public UserTransactionTokenPersistenceImpl() {
		setModelClass(UserTransactionToken.class);

		setModelImplClass(UserTransactionTokenImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the user transaction token in the entity cache if it is enabled.
	 *
	 * @param userTransactionToken the user transaction token
	 */
	@Override
	public void cacheResult(UserTransactionToken userTransactionToken) {
		entityCache.putResult(
			UserTransactionTokenImpl.class,
			userTransactionToken.getPrimaryKey(), userTransactionToken);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the user transaction tokens in the entity cache if it is enabled.
	 *
	 * @param userTransactionTokens the user transaction tokens
	 */
	@Override
	public void cacheResult(List<UserTransactionToken> userTransactionTokens) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (userTransactionTokens.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UserTransactionToken userTransactionToken :
				userTransactionTokens) {

			if (entityCache.getResult(
					UserTransactionTokenImpl.class,
					userTransactionToken.getPrimaryKey()) == null) {

				cacheResult(userTransactionToken);
			}
		}
	}

	/**
	 * Clears the cache for all user transaction tokens.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserTransactionTokenImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user transaction token.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserTransactionToken userTransactionToken) {
		entityCache.removeResult(
			UserTransactionTokenImpl.class, userTransactionToken);
	}

	@Override
	public void clearCache(List<UserTransactionToken> userTransactionTokens) {
		for (UserTransactionToken userTransactionToken :
				userTransactionTokens) {

			entityCache.removeResult(
				UserTransactionTokenImpl.class, userTransactionToken);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				UserTransactionTokenImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new user transaction token with the primary key. Does not add the user transaction token to the database.
	 *
	 * @param userTransactionTokenId the primary key for the new user transaction token
	 * @return the new user transaction token
	 */
	@Override
	public UserTransactionToken create(long userTransactionTokenId) {
		UserTransactionToken userTransactionToken =
			new UserTransactionTokenImpl();

		userTransactionToken.setNew(true);
		userTransactionToken.setPrimaryKey(userTransactionTokenId);

		userTransactionToken.setCompanyId(CompanyThreadLocal.getCompanyId());

		return userTransactionToken;
	}

	/**
	 * Removes the user transaction token with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userTransactionTokenId the primary key of the user transaction token
	 * @return the user transaction token that was removed
	 * @throws NoSuchUserTransactionTokenException if a user transaction token with the primary key could not be found
	 */
	@Override
	public UserTransactionToken remove(long userTransactionTokenId)
		throws NoSuchUserTransactionTokenException {

		return remove((Serializable)userTransactionTokenId);
	}

	/**
	 * Removes the user transaction token with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user transaction token
	 * @return the user transaction token that was removed
	 * @throws NoSuchUserTransactionTokenException if a user transaction token with the primary key could not be found
	 */
	@Override
	public UserTransactionToken remove(Serializable primaryKey)
		throws NoSuchUserTransactionTokenException {

		Session session = null;

		try {
			session = openSession();

			UserTransactionToken userTransactionToken =
				(UserTransactionToken)session.get(
					UserTransactionTokenImpl.class, primaryKey);

			if (userTransactionToken == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserTransactionTokenException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userTransactionToken);
		}
		catch (NoSuchUserTransactionTokenException noSuchEntityException) {
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
	protected UserTransactionToken removeImpl(
		UserTransactionToken userTransactionToken) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userTransactionToken)) {
				userTransactionToken = (UserTransactionToken)session.get(
					UserTransactionTokenImpl.class,
					userTransactionToken.getPrimaryKeyObj());
			}

			if (userTransactionToken != null) {
				session.delete(userTransactionToken);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userTransactionToken != null) {
			clearCache(userTransactionToken);
		}

		return userTransactionToken;
	}

	@Override
	public UserTransactionToken updateImpl(
		UserTransactionToken userTransactionToken) {

		boolean isNew = userTransactionToken.isNew();

		if (!(userTransactionToken instanceof UserTransactionTokenModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userTransactionToken.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					userTransactionToken);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userTransactionToken proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserTransactionToken implementation " +
					userTransactionToken.getClass());
		}

		UserTransactionTokenModelImpl userTransactionTokenModelImpl =
			(UserTransactionTokenModelImpl)userTransactionToken;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (userTransactionToken.getCreateDate() == null)) {
			if (serviceContext == null) {
				userTransactionToken.setCreateDate(date);
			}
			else {
				userTransactionToken.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!userTransactionTokenModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userTransactionToken.setModifiedDate(date);
			}
			else {
				userTransactionToken.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userTransactionToken);
			}
			else {
				userTransactionToken = (UserTransactionToken)session.merge(
					userTransactionToken);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UserTransactionTokenImpl.class, userTransactionTokenModelImpl,
			false, true);

		if (isNew) {
			userTransactionToken.setNew(false);
		}

		userTransactionToken.resetOriginalValues();

		return userTransactionToken;
	}

	/**
	 * Returns the user transaction token with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user transaction token
	 * @return the user transaction token
	 * @throws NoSuchUserTransactionTokenException if a user transaction token with the primary key could not be found
	 */
	@Override
	public UserTransactionToken findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserTransactionTokenException {

		UserTransactionToken userTransactionToken = fetchByPrimaryKey(
			primaryKey);

		if (userTransactionToken == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserTransactionTokenException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userTransactionToken;
	}

	/**
	 * Returns the user transaction token with the primary key or throws a <code>NoSuchUserTransactionTokenException</code> if it could not be found.
	 *
	 * @param userTransactionTokenId the primary key of the user transaction token
	 * @return the user transaction token
	 * @throws NoSuchUserTransactionTokenException if a user transaction token with the primary key could not be found
	 */
	@Override
	public UserTransactionToken findByPrimaryKey(long userTransactionTokenId)
		throws NoSuchUserTransactionTokenException {

		return findByPrimaryKey((Serializable)userTransactionTokenId);
	}

	/**
	 * Returns the user transaction token with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userTransactionTokenId the primary key of the user transaction token
	 * @return the user transaction token, or <code>null</code> if a user transaction token with the primary key could not be found
	 */
	@Override
	public UserTransactionToken fetchByPrimaryKey(long userTransactionTokenId) {
		return fetchByPrimaryKey((Serializable)userTransactionTokenId);
	}

	/**
	 * Returns all the user transaction tokens.
	 *
	 * @return the user transaction tokens
	 */
	@Override
	public List<UserTransactionToken> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user transaction tokens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @return the range of user transaction tokens
	 */
	@Override
	public List<UserTransactionToken> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user transaction tokens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user transaction tokens
	 */
	@Override
	public List<UserTransactionToken> findAll(
		int start, int end,
		OrderByComparator<UserTransactionToken> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user transaction tokens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTransactionTokenModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user transaction tokens
	 * @param end the upper bound of the range of user transaction tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user transaction tokens
	 */
	@Override
	public List<UserTransactionToken> findAll(
		int start, int end,
		OrderByComparator<UserTransactionToken> orderByComparator,
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

		List<UserTransactionToken> list = null;

		if (useFinderCache) {
			list = (List<UserTransactionToken>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERTRANSACTIONTOKEN);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERTRANSACTIONTOKEN;

				sql = sql.concat(UserTransactionTokenModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserTransactionToken>)QueryUtil.list(
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
	 * Removes all the user transaction tokens from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserTransactionToken userTransactionToken : findAll()) {
			remove(userTransactionToken);
		}
	}

	/**
	 * Returns the number of user transaction tokens.
	 *
	 * @return the number of user transaction tokens
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
					_SQL_COUNT_USERTRANSACTIONTOKEN);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "userTransactionTokenId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERTRANSACTIONTOKEN;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserTransactionTokenModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user transaction token persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new UserTransactionTokenModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", UserTransactionToken.class.getName()));

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

		_finderPathWithPaginationFindBypolicyProfile = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypolicyProfile",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"policyNumber", "profileId"}, true);

		_finderPathWithoutPaginationFindBypolicyProfile = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypolicyProfile",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"policyNumber", "profileId"}, true);

		_finderPathCountBypolicyProfile = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypolicyProfile",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"policyNumber", "profileId"}, false);

		_finderPathWithPaginationFindByinvoiceNumber = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByinvoiceNumber",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"invoiceNumber"}, true);

		_finderPathWithoutPaginationFindByinvoiceNumber = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByinvoiceNumber",
			new String[] {String.class.getName()},
			new String[] {"invoiceNumber"}, true);

		_finderPathCountByinvoiceNumber = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByinvoiceNumber",
			new String[] {String.class.getName()},
			new String[] {"invoiceNumber"}, false);

		_finderPathWithPaginationFindBytoken = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytoken",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"token"}, true);

		_finderPathWithoutPaginationFindBytoken = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytoken",
			new String[] {String.class.getName()}, new String[] {"token"},
			true);

		_finderPathCountBytoken = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytoken",
			new String[] {String.class.getName()}, new String[] {"token"},
			false);

		_setUserTransactionTokenUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setUserTransactionTokenUtilPersistence(null);

		entityCache.removeCache(UserTransactionTokenImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setUserTransactionTokenUtilPersistence(
		UserTransactionTokenPersistence userTransactionTokenPersistence) {

		try {
			Field field = UserTransactionTokenUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, userTransactionTokenPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = APPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = APPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = APPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_USERTRANSACTIONTOKEN =
		"SELECT userTransactionToken FROM UserTransactionToken userTransactionToken";

	private static final String _SQL_SELECT_USERTRANSACTIONTOKEN_WHERE =
		"SELECT userTransactionToken FROM UserTransactionToken userTransactionToken WHERE ";

	private static final String _SQL_COUNT_USERTRANSACTIONTOKEN =
		"SELECT COUNT(userTransactionToken) FROM UserTransactionToken userTransactionToken";

	private static final String _SQL_COUNT_USERTRANSACTIONTOKEN_WHERE =
		"SELECT COUNT(userTransactionToken) FROM UserTransactionToken userTransactionToken WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"userTransactionToken.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserTransactionToken exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserTransactionToken exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserTransactionTokenPersistenceImpl.class);

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

	private static class UserTransactionTokenModelArgumentsResolver
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

			UserTransactionTokenModelImpl userTransactionTokenModelImpl =
				(UserTransactionTokenModelImpl)baseModel;

			long columnBitmask =
				userTransactionTokenModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					userTransactionTokenModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						userTransactionTokenModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					userTransactionTokenModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			UserTransactionTokenModelImpl userTransactionTokenModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						userTransactionTokenModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = userTransactionTokenModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}