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
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.TravelIntBenefitValue;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for TravelIntBenefitValue. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Gositus Team
 * @see TravelIntBenefitValueLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TravelIntBenefitValueLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.TravelIntBenefitValueLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the travel int benefit value local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link TravelIntBenefitValueLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Add
	 */
	public TravelIntBenefitValue addTravelIntBenefitValue(
			long travelIntBenefitId, String currencyName, String packageType,
			String benefitValue, int active)
		throws PortalException;

	/**
	 * Adds the travel int benefit value to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelIntBenefitValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelIntBenefitValue the travel int benefit value
	 * @return the travel int benefit value that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TravelIntBenefitValue addTravelIntBenefitValue(
		TravelIntBenefitValue travelIntBenefitValue);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new travel int benefit value with the primary key. Does not add the travel int benefit value to the database.
	 *
	 * @param travelIntBenefitValueId the primary key for the new travel int benefit value
	 * @return the new travel int benefit value
	 */
	@Transactional(enabled = false)
	public TravelIntBenefitValue createTravelIntBenefitValue(
		long travelIntBenefitValueId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the travel int benefit value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelIntBenefitValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelIntBenefitValueId the primary key of the travel int benefit value
	 * @return the travel int benefit value that was removed
	 * @throws PortalException if a travel int benefit value with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public TravelIntBenefitValue deleteTravelIntBenefitValue(
			long travelIntBenefitValueId)
		throws PortalException;

	/**
	 * Deletes the travel int benefit value from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelIntBenefitValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelIntBenefitValue the travel int benefit value
	 * @return the travel int benefit value that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public TravelIntBenefitValue deleteTravelIntBenefitValue(
		TravelIntBenefitValue travelIntBenefitValue);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelIntBenefitValueModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelIntBenefitValueModelImpl</code>.
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
	public TravelIntBenefitValue fetchTravelIntBenefitValue(
		long travelIntBenefitValueId);

	public List<TravelIntBenefitValue> findByPackageType(String packageType);

	public List<TravelIntBenefitValue> findByPackageTypeAndCurrencyName(
		long benefitParentId, String packageType, String currencyName);

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
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the travel int benefit value with the primary key.
	 *
	 * @param travelIntBenefitValueId the primary key of the travel int benefit value
	 * @return the travel int benefit value
	 * @throws PortalException if a travel int benefit value with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TravelIntBenefitValue getTravelIntBenefitValue(
			long travelIntBenefitValueId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int gettravelIntBenefitValueCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TravelIntBenefitValue> getTravelIntBenefitValues();

	/**
	 * Returns a range of all the travel int benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @return the range of travel int benefit values
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TravelIntBenefitValue> getTravelIntBenefitValues(
		int start, int end);

	/**
	 * Returns the number of travel int benefit values.
	 *
	 * @return the number of travel int benefit values
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTravelIntBenefitValuesCount();

	/**
	 * Update
	 */
	public TravelIntBenefitValue updateTravelIntBenefitValue(
			long travelIntBenefitValueId, long travelIntBenefitId,
			String currencyName, String packageType, String benefitValue,
			int active)
		throws PortalException;

	/**
	 * Updates the travel int benefit value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelIntBenefitValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelIntBenefitValue the travel int benefit value
	 * @return the travel int benefit value that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TravelIntBenefitValue updateTravelIntBenefitValue(
		TravelIntBenefitValue travelIntBenefitValue);

}