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

package com.mypage.admin.product.service;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.BlacklistCustomer;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for BlacklistCustomer. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Gositus Team
 * @see BlacklistCustomerLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface BlacklistCustomerLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.BlacklistCustomerLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the blacklist customer local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link BlacklistCustomerLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the blacklist customer to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlacklistCustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blacklistCustomer the blacklist customer
	 * @return the blacklist customer that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public BlacklistCustomer addBlacklistCustomer(
		BlacklistCustomer blacklistCustomer);

	public BlacklistCustomer addBlacklistCustomer(
			String fullName, String firstName, String middleName,
			String lastName, String ktp, String kitas, String email,
			Date dateOfBirth, int active)
		throws PortalException;

	public List<BlacklistCustomer> blacklistFullName(String fullName);

	public List<BlacklistCustomer> checkBlackList(
		String fullName, String ktp, String kitas, String email,
		Date dateOfBirth);

	/**
	 * Creates a new blacklist customer with the primary key. Does not add the blacklist customer to the database.
	 *
	 * @param blacklistCustomerId the primary key for the new blacklist customer
	 * @return the new blacklist customer
	 */
	@Transactional(enabled = false)
	public BlacklistCustomer createBlacklistCustomer(long blacklistCustomerId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the blacklist customer from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlacklistCustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blacklistCustomer the blacklist customer
	 * @return the blacklist customer that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public BlacklistCustomer deleteBlacklistCustomer(
		BlacklistCustomer blacklistCustomer);

	/**
	 * Deletes the blacklist customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlacklistCustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blacklistCustomerId the primary key of the blacklist customer
	 * @return the blacklist customer that was removed
	 * @throws PortalException if a blacklist customer with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public BlacklistCustomer deleteBlacklistCustomer(long blacklistCustomerId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BlacklistCustomer fetchBlacklistCustomer(long blacklistCustomerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the blacklist customer with the primary key.
	 *
	 * @param blacklistCustomerId the primary key of the blacklist customer
	 * @return the blacklist customer
	 * @throws PortalException if a blacklist customer with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BlacklistCustomer getBlacklistCustomer(long blacklistCustomerId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBlacklistCustomerCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BlacklistCustomer> getBlacklistCustomers();

	/**
	 * Returns a range of all the blacklist customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of blacklist customers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BlacklistCustomer> getBlacklistCustomers(int start, int end);

	/**
	 * Returns the number of blacklist customers.
	 *
	 * @return the number of blacklist customers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBlacklistCustomersCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public BlacklistCustomer setActive(
			long blacklistCustomerId, int active, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Updates the blacklist customer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlacklistCustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blacklistCustomer the blacklist customer
	 * @return the blacklist customer that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public BlacklistCustomer updateBlacklistCustomer(
		BlacklistCustomer blacklistCustomer);

	public BlacklistCustomer updateBlacklistCustomer(
			long blacklistCustomerId, String fullName, String firstName,
			String middleName, String lastName, String ktp, String kitas,
			String email, Date dateOfBirth)
		throws PortalException;

	public BlacklistCustomer updateBlacklistCustomer(
			long blacklistCustomerId, String fullName, String firstName,
			String middleName, String lastName, String ktp, String kitas,
			String email, Date dateOfBirth, int active)
		throws PortalException;

}