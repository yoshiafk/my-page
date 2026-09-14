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

import com.mypage.admin.product.model.PaymentChannelTenor;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for PaymentChannelTenor. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Gositus Team
 * @see PaymentChannelTenorLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PaymentChannelTenorLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.PaymentChannelTenorLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the payment channel tenor local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link PaymentChannelTenorLocalServiceUtil} if injection and service tracking are not available.
	 */
	public PaymentChannelTenor addPaymentChannelTenor(
			long paymentChannelId, String promoid, String tenor, String tenorid,
			String acquirer, int active)
		throws PortalException;

	/**
	 * Adds the payment channel tenor to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentChannelTenorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param paymentChannelTenor the payment channel tenor
	 * @return the payment channel tenor that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PaymentChannelTenor addPaymentChannelTenor(
		PaymentChannelTenor paymentChannelTenor);

	/**
	 * Creates a new payment channel tenor with the primary key. Does not add the payment channel tenor to the database.
	 *
	 * @param paymentChannelTenorId the primary key for the new payment channel tenor
	 * @return the new payment channel tenor
	 */
	@Transactional(enabled = false)
	public PaymentChannelTenor createPaymentChannelTenor(
		long paymentChannelTenorId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the payment channel tenor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentChannelTenorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param paymentChannelTenorId the primary key of the payment channel tenor
	 * @return the payment channel tenor that was removed
	 * @throws PortalException if a payment channel tenor with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public PaymentChannelTenor deletePaymentChannelTenor(
			long paymentChannelTenorId)
		throws PortalException;

	/**
	 * Deletes the payment channel tenor from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentChannelTenorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param paymentChannelTenor the payment channel tenor
	 * @return the payment channel tenor that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public PaymentChannelTenor deletePaymentChannelTenor(
		PaymentChannelTenor paymentChannelTenor);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PaymentChannelTenorModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PaymentChannelTenorModelImpl</code>.
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
	public PaymentChannelTenor fetchPaymentChannelTenor(
		long paymentChannelTenorId);

	public List<PaymentChannelTenor> findBysearchByPaymentChannelId(
		long paymentChannelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * Returns the payment channel tenor with the primary key.
	 *
	 * @param paymentChannelTenorId the primary key of the payment channel tenor
	 * @return the payment channel tenor
	 * @throws PortalException if a payment channel tenor with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PaymentChannelTenor getPaymentChannelTenor(
			long paymentChannelTenorId)
		throws PortalException;

	/**
	 * Returns a range of all the payment channel tenors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PaymentChannelTenorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment channel tenors
	 * @param end the upper bound of the range of payment channel tenors (not inclusive)
	 * @return the range of payment channel tenors
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PaymentChannelTenor> getPaymentChannelTenors(
		int start, int end);

	/**
	 * Returns the number of payment channel tenors.
	 *
	 * @return the number of payment channel tenors
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPaymentChannelTenorsCount();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public void removeByPaymentChannelId(long paymentChannelId);

	public PaymentChannelTenor setActive(
			long paymentChannelTenorId, int active,
			ServiceContext serviceContext)
		throws PortalException;

	public PaymentChannelTenor updatePaymentChannelTenor(
			long paymentChannelTenorId, long paymentChannelId, String promoid,
			String tenor, String tenorid, String acquirer, int active)
		throws PortalException;

	/**
	 * Updates the payment channel tenor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PaymentChannelTenorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param paymentChannelTenor the payment channel tenor
	 * @return the payment channel tenor that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PaymentChannelTenor updatePaymentChannelTenor(
		PaymentChannelTenor paymentChannelTenor);

}