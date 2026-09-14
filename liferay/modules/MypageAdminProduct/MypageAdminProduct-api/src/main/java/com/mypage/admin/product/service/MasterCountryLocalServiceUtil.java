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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.MasterCountry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for MasterCountry. This utility wraps
 * <code>com.mypage.admin.product.service.impl.MasterCountryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see MasterCountryLocalService
 * @generated
 */
public class MasterCountryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.MasterCountryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the master country to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterCountryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterCountry the master country
	 * @return the master country that was added
	 */
	public static MasterCountry addMasterCountry(MasterCountry masterCountry) {
		return getService().addMasterCountry(masterCountry);
	}

	public static MasterCountry addMasterCountry(
			String name, int isPlatinum, int isGold, int isSpecialAsia,
			int isSchengen, int isSanctionCountry, int active)
		throws PortalException {

		return getService().addMasterCountry(
			name, isPlatinum, isGold, isSpecialAsia, isSchengen,
			isSanctionCountry, active);
	}

	/**
	 * Creates a new master country with the primary key. Does not add the master country to the database.
	 *
	 * @param countryId the primary key for the new master country
	 * @return the new master country
	 */
	public static MasterCountry createMasterCountry(long countryId) {
		return getService().createMasterCountry(countryId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the master country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterCountryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param countryId the primary key of the master country
	 * @return the master country that was removed
	 * @throws PortalException if a master country with the primary key could not be found
	 */
	public static MasterCountry deleteMasterCountry(long countryId)
		throws PortalException {

		return getService().deleteMasterCountry(countryId);
	}

	/**
	 * Deletes the master country from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterCountryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterCountry the master country
	 * @return the master country that was removed
	 */
	public static MasterCountry deleteMasterCountry(
		MasterCountry masterCountry) {

		return getService().deleteMasterCountry(masterCountry);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static MasterCountry fetchMasterCountry(long countryId) {
		return getService().fetchMasterCountry(countryId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<MasterCountry> getActiveCountries() {
		return getService().getActiveCountries();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<MasterCountry> getMasterCountries() {
		return getService().getMasterCountries();
	}

	/**
	 * Returns a range of all the master countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @return the range of master countries
	 */
	public static List<MasterCountry> getMasterCountries(int start, int end) {
		return getService().getMasterCountries(start, end);
	}

	/**
	 * Returns the number of master countries.
	 *
	 * @return the number of master countries
	 */
	public static int getMasterCountriesCount() {
		return getService().getMasterCountriesCount();
	}

	/**
	 * Returns the master country with the primary key.
	 *
	 * @param countryId the primary key of the master country
	 * @return the master country
	 * @throws PortalException if a master country with the primary key could not be found
	 */
	public static MasterCountry getMasterCountry(long countryId)
		throws PortalException {

		return getService().getMasterCountry(countryId);
	}

	public static List<MasterCountry> getMasterCountryByname(String name) {
		return getService().getMasterCountryByname(name);
	}

	public static int getMasterCountryCount() {
		return getService().getMasterCountryCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static MasterCountry setActive(
			long countryId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(countryId, active, serviceContext);
	}

	public static MasterCountry updateMasterCountry(
			long countryId, String name, int isPlatinum, int isGold,
			int isSpecialAsia, int isSchengen, int isSanctionCountry)
		throws PortalException {

		return getService().updateMasterCountry(
			countryId, name, isPlatinum, isGold, isSpecialAsia, isSchengen,
			isSanctionCountry);
	}

	public static MasterCountry updateMasterCountry(
			long countryId, String name, int isPlatinum, int isGold,
			int isSpecialAsia, int isSchengen, int isSanctionCountry,
			int active)
		throws PortalException {

		return getService().updateMasterCountry(
			countryId, name, isPlatinum, isGold, isSpecialAsia, isSchengen,
			isSanctionCountry, active);
	}

	/**
	 * Updates the master country in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterCountryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterCountry the master country
	 * @return the master country that was updated
	 */
	public static MasterCountry updateMasterCountry(
		MasterCountry masterCountry) {

		return getService().updateMasterCountry(masterCountry);
	}

	public static MasterCountryLocalService getService() {
		return _service;
	}

	private static volatile MasterCountryLocalService _service;

}