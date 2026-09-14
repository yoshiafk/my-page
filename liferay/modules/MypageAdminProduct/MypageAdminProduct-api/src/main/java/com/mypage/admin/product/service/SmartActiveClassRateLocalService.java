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

import com.mypage.admin.product.model.SmartActiveClassRate;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SmartActiveClassRate. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Gositus Team
 * @see SmartActiveClassRateLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SmartActiveClassRateLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.SmartActiveClassRateLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the smart active class rate local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SmartActiveClassRateLocalServiceUtil} if injection and service tracking are not available.
	 */
	public SmartActiveClassRate addClassRate(
			String nameId, String nameEn, int active)
		throws PortalException;

	/**
	 * Adds the smart active class rate to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveClassRateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveClassRate the smart active class rate
	 * @return the smart active class rate that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SmartActiveClassRate addSmartActiveClassRate(
		SmartActiveClassRate smartActiveClassRate);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new smart active class rate with the primary key. Does not add the smart active class rate to the database.
	 *
	 * @param smartActiveClassRateId the primary key for the new smart active class rate
	 * @return the new smart active class rate
	 */
	@Transactional(enabled = false)
	public SmartActiveClassRate createSmartActiveClassRate(
		long smartActiveClassRateId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the smart active class rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveClassRateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveClassRateId the primary key of the smart active class rate
	 * @return the smart active class rate that was removed
	 * @throws PortalException if a smart active class rate with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public SmartActiveClassRate deleteSmartActiveClassRate(
			long smartActiveClassRateId)
		throws PortalException;

	/**
	 * Deletes the smart active class rate from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveClassRateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveClassRate the smart active class rate
	 * @return the smart active class rate that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public SmartActiveClassRate deleteSmartActiveClassRate(
		SmartActiveClassRate smartActiveClassRate);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveClassRateModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveClassRateModelImpl</code>.
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
	public SmartActiveClassRate fetchSmartActiveClassRate(
		long smartActiveClassRateId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartActiveClassRate> getActiveClassRate();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartActiveClassRate> getAllClassRates();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartActiveClassRate> getClassRateByName(
		String nameId, String nameEn);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartActiveClassRate> getClassRateBySort(int sort);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getClassRateIdByNameId(String nameId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartActiveClassRate> getClassRates();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartActiveClassRate> getClassRates(int start, int end);

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

	/**
	 * Returns the smart active class rate with the primary key.
	 *
	 * @param smartActiveClassRateId the primary key of the smart active class rate
	 * @return the smart active class rate
	 * @throws PortalException if a smart active class rate with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SmartActiveClassRate getSmartActiveClassRate(
			long smartActiveClassRateId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSmartActiveClassRateCount();

	/**
	 * Returns a range of all the smart active class rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveClassRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active class rates
	 * @param end the upper bound of the range of smart active class rates (not inclusive)
	 * @return the range of smart active class rates
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartActiveClassRate> getSmartActiveClassRates(
		int start, int end);

	/**
	 * Returns the number of smart active class rates.
	 *
	 * @return the number of smart active class rates
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSmartActiveClassRatesCount();

	public SmartActiveClassRate setActive(
		long classRateId, int active, ServiceContext serviceContext);

	public SmartActiveClassRate updateClassRate(
			long classRateId, String nameId, String nameEn, int active)
		throws PortalException;

	/**
	 * Updates the smart active class rate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveClassRateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveClassRate the smart active class rate
	 * @return the smart active class rate that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SmartActiveClassRate updateSmartActiveClassRate(
		SmartActiveClassRate smartActiveClassRate);

}