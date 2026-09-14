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

package com.mypage.admin.product.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import com.mypage.admin.product.model.StiBenefitValueMapping;
import com.mypage.admin.product.service.StiBenefitValueMappingLocalService;
import com.mypage.admin.product.service.StiBenefitValueMappingLocalServiceUtil;
import com.mypage.admin.product.service.persistence.BenefitPersistence;
import com.mypage.admin.product.service.persistence.BenefitTypePersistence;
import com.mypage.admin.product.service.persistence.BenefitValueMappingPersistence;
import com.mypage.admin.product.service.persistence.BlacklistCustomerPersistence;
import com.mypage.admin.product.service.persistence.CompanyTypePersistence;
import com.mypage.admin.product.service.persistence.HealthIndividuPlanPersistence;
import com.mypage.admin.product.service.persistence.HealthIndividuPremiPersistence;
import com.mypage.admin.product.service.persistence.HealthSmeFacilityPersistence;
import com.mypage.admin.product.service.persistence.HealthSmePremiPersistence;
import com.mypage.admin.product.service.persistence.HealthSmeTemplatePersistence;
import com.mypage.admin.product.service.persistence.HealthSmeTypePersistence;
import com.mypage.admin.product.service.persistence.IndustryCategoryPersistence;
import com.mypage.admin.product.service.persistence.IndustryPersistence;
import com.mypage.admin.product.service.persistence.IntTravelStandardNewPremiPersistence;
import com.mypage.admin.product.service.persistence.JobPositionPersistence;
import com.mypage.admin.product.service.persistence.MasterBankPersistence;
import com.mypage.admin.product.service.persistence.MasterBranchPersistence;
import com.mypage.admin.product.service.persistence.MasterCityPersistence;
import com.mypage.admin.product.service.persistence.MasterCountryPersistence;
import com.mypage.admin.product.service.persistence.MasterCurrencyPersistence;
import com.mypage.admin.product.service.persistence.MasterGlobalVariablePersistence;
import com.mypage.admin.product.service.persistence.MasterOccupationCategoryPersistence;
import com.mypage.admin.product.service.persistence.MasterOccupationPersistence;
import com.mypage.admin.product.service.persistence.MasterPromoCodePersistence;
import com.mypage.admin.product.service.persistence.MasterProvincePersistence;
import com.mypage.admin.product.service.persistence.PaymentChannelPersistence;
import com.mypage.admin.product.service.persistence.PaymentChannelTenorPersistence;
import com.mypage.admin.product.service.persistence.PersonalAccidentPremiPersistence;
import com.mypage.admin.product.service.persistence.PetAnimalTypePersistence;
import com.mypage.admin.product.service.persistence.PetDetailPersistence;
import com.mypage.admin.product.service.persistence.PetPlanPersistence;
import com.mypage.admin.product.service.persistence.PetRateFinder;
import com.mypage.admin.product.service.persistence.PetRatePersistence;
import com.mypage.admin.product.service.persistence.PetRemarksPersistence;
import com.mypage.admin.product.service.persistence.PremiPersistence;
import com.mypage.admin.product.service.persistence.ProductConfigurationPersistence;
import com.mypage.admin.product.service.persistence.PromocodesPersistence;
import com.mypage.admin.product.service.persistence.ReferenceNumberPersistence;
import com.mypage.admin.product.service.persistence.SmartActiveBenefitPersistence;
import com.mypage.admin.product.service.persistence.SmartActiveBenefitTypePersistence;
import com.mypage.admin.product.service.persistence.SmartActiveBenefitValueMappingPersistence;
import com.mypage.admin.product.service.persistence.SmartActiveBenefitValuePersistence;
import com.mypage.admin.product.service.persistence.SmartActiveClassRatePersistence;
import com.mypage.admin.product.service.persistence.SmartActiveFeaturePersistence;
import com.mypage.admin.product.service.persistence.SmartActiveLinkPersistence;
import com.mypage.admin.product.service.persistence.SmartActiveOccupationPersistence;
import com.mypage.admin.product.service.persistence.SmartActivePremiPersistence;
import com.mypage.admin.product.service.persistence.SmartActiveToproBenefitMappingPersistence;
import com.mypage.admin.product.service.persistence.SmartActiveToproPersistence;
import com.mypage.admin.product.service.persistence.SmartHealthBenefitGroupPersistence;
import com.mypage.admin.product.service.persistence.SmartHealthBenefitPersistence;
import com.mypage.admin.product.service.persistence.SmartHealthPlanPersistence;
import com.mypage.admin.product.service.persistence.SmartHealthPremiPersistence;
import com.mypage.admin.product.service.persistence.SmartTravelIntLinkPersistence;
import com.mypage.admin.product.service.persistence.SmartTravelIntPlanPersistence;
import com.mypage.admin.product.service.persistence.StiBenefitPersistence;
import com.mypage.admin.product.service.persistence.StiBenefitValueMappingPersistence;
import com.mypage.admin.product.service.persistence.StiPremiPersistence;
import com.mypage.admin.product.service.persistence.TravelDomesticBenefitGroupPersistence;
import com.mypage.admin.product.service.persistence.TravelDomesticBenefitPersistence;
import com.mypage.admin.product.service.persistence.TravelDomesticDurationPersistence;
import com.mypage.admin.product.service.persistence.TravelDomesticInsuredTypePersistence;
import com.mypage.admin.product.service.persistence.TravelDomesticPlanPersistence;
import com.mypage.admin.product.service.persistence.TravelDomesticPremiFinder;
import com.mypage.admin.product.service.persistence.TravelDomesticPremiPersistence;
import com.mypage.admin.product.service.persistence.TravelDomesticRelationshipPersistence;
import com.mypage.admin.product.service.persistence.TravelDomesticTravellerTypePersistence;
import com.mypage.admin.product.service.persistence.TravelIntBenefitPersistence;
import com.mypage.admin.product.service.persistence.TravelIntBenefitValuePersistence;
import com.mypage.admin.product.service.persistence.TravelInternationalPremiPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the sti benefit value mapping local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.mypage.admin.product.service.impl.StiBenefitValueMappingLocalServiceImpl}.
 * </p>
 *
 * @author Gositus Team
 * @see com.mypage.admin.product.service.impl.StiBenefitValueMappingLocalServiceImpl
 * @generated
 */
public abstract class StiBenefitValueMappingLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   StiBenefitValueMappingLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>StiBenefitValueMappingLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>StiBenefitValueMappingLocalServiceUtil</code>.
	 */

	/**
	 * Adds the sti benefit value mapping to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stiBenefitValueMapping the sti benefit value mapping
	 * @return the sti benefit value mapping that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public StiBenefitValueMapping addStiBenefitValueMapping(
		StiBenefitValueMapping stiBenefitValueMapping) {

		stiBenefitValueMapping.setNew(true);

		return stiBenefitValueMappingPersistence.update(stiBenefitValueMapping);
	}

	/**
	 * Creates a new sti benefit value mapping with the primary key. Does not add the sti benefit value mapping to the database.
	 *
	 * @param benefitValueMappingId the primary key for the new sti benefit value mapping
	 * @return the new sti benefit value mapping
	 */
	@Override
	@Transactional(enabled = false)
	public StiBenefitValueMapping createStiBenefitValueMapping(
		long benefitValueMappingId) {

		return stiBenefitValueMappingPersistence.create(benefitValueMappingId);
	}

	/**
	 * Deletes the sti benefit value mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitValueMappingId the primary key of the sti benefit value mapping
	 * @return the sti benefit value mapping that was removed
	 * @throws PortalException if a sti benefit value mapping with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public StiBenefitValueMapping deleteStiBenefitValueMapping(
			long benefitValueMappingId)
		throws PortalException {

		return stiBenefitValueMappingPersistence.remove(benefitValueMappingId);
	}

	/**
	 * Deletes the sti benefit value mapping from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stiBenefitValueMapping the sti benefit value mapping
	 * @return the sti benefit value mapping that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public StiBenefitValueMapping deleteStiBenefitValueMapping(
		StiBenefitValueMapping stiBenefitValueMapping) {

		return stiBenefitValueMappingPersistence.remove(stiBenefitValueMapping);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			StiBenefitValueMapping.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return stiBenefitValueMappingPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return stiBenefitValueMappingPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return stiBenefitValueMappingPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return stiBenefitValueMappingPersistence.countWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return stiBenefitValueMappingPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public StiBenefitValueMapping fetchStiBenefitValueMapping(
		long benefitValueMappingId) {

		return stiBenefitValueMappingPersistence.fetchByPrimaryKey(
			benefitValueMappingId);
	}

	/**
	 * Returns the sti benefit value mapping with the primary key.
	 *
	 * @param benefitValueMappingId the primary key of the sti benefit value mapping
	 * @return the sti benefit value mapping
	 * @throws PortalException if a sti benefit value mapping with the primary key could not be found
	 */
	@Override
	public StiBenefitValueMapping getStiBenefitValueMapping(
			long benefitValueMappingId)
		throws PortalException {

		return stiBenefitValueMappingPersistence.findByPrimaryKey(
			benefitValueMappingId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			stiBenefitValueMappingLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(StiBenefitValueMapping.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"benefitValueMappingId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			stiBenefitValueMappingLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			StiBenefitValueMapping.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"benefitValueMappingId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			stiBenefitValueMappingLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(StiBenefitValueMapping.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"benefitValueMappingId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return stiBenefitValueMappingPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return stiBenefitValueMappingLocalService.deleteStiBenefitValueMapping(
			(StiBenefitValueMapping)persistedModel);
	}

	public BasePersistence<StiBenefitValueMapping> getBasePersistence() {
		return stiBenefitValueMappingPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return stiBenefitValueMappingPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the sti benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @return the range of sti benefit value mappings
	 */
	@Override
	public List<StiBenefitValueMapping> getStiBenefitValueMappings(
		int start, int end) {

		return stiBenefitValueMappingPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of sti benefit value mappings.
	 *
	 * @return the number of sti benefit value mappings
	 */
	@Override
	public int getStiBenefitValueMappingsCount() {
		return stiBenefitValueMappingPersistence.countAll();
	}

	/**
	 * Updates the sti benefit value mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stiBenefitValueMapping the sti benefit value mapping
	 * @return the sti benefit value mapping that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public StiBenefitValueMapping updateStiBenefitValueMapping(
		StiBenefitValueMapping stiBenefitValueMapping) {

		return stiBenefitValueMappingPersistence.update(stiBenefitValueMapping);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			StiBenefitValueMappingLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		stiBenefitValueMappingLocalService =
			(StiBenefitValueMappingLocalService)aopProxy;

		_setLocalServiceUtilService(stiBenefitValueMappingLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return StiBenefitValueMappingLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return StiBenefitValueMapping.class;
	}

	protected String getModelClassName() {
		return StiBenefitValueMapping.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				stiBenefitValueMappingPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		StiBenefitValueMappingLocalService stiBenefitValueMappingLocalService) {

		try {
			Field field =
				StiBenefitValueMappingLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, stiBenefitValueMappingLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected BenefitPersistence benefitPersistence;

	@Reference
	protected BenefitTypePersistence benefitTypePersistence;

	@Reference
	protected BenefitValueMappingPersistence benefitValueMappingPersistence;

	@Reference
	protected BlacklistCustomerPersistence blacklistCustomerPersistence;

	@Reference
	protected CompanyTypePersistence companyTypePersistence;

	@Reference
	protected HealthIndividuPlanPersistence healthIndividuPlanPersistence;

	@Reference
	protected HealthIndividuPremiPersistence healthIndividuPremiPersistence;

	@Reference
	protected HealthSmeFacilityPersistence healthSmeFacilityPersistence;

	@Reference
	protected HealthSmePremiPersistence healthSmePremiPersistence;

	@Reference
	protected HealthSmeTemplatePersistence healthSmeTemplatePersistence;

	@Reference
	protected HealthSmeTypePersistence healthSmeTypePersistence;

	@Reference
	protected IndustryPersistence industryPersistence;

	@Reference
	protected IndustryCategoryPersistence industryCategoryPersistence;

	@Reference
	protected IntTravelStandardNewPremiPersistence
		intTravelStandardNewPremiPersistence;

	@Reference
	protected JobPositionPersistence jobPositionPersistence;

	@Reference
	protected MasterBankPersistence masterBankPersistence;

	@Reference
	protected MasterBranchPersistence masterBranchPersistence;

	@Reference
	protected MasterCityPersistence masterCityPersistence;

	@Reference
	protected MasterCountryPersistence masterCountryPersistence;

	@Reference
	protected MasterCurrencyPersistence masterCurrencyPersistence;

	@Reference
	protected MasterGlobalVariablePersistence masterGlobalVariablePersistence;

	@Reference
	protected MasterOccupationPersistence masterOccupationPersistence;

	@Reference
	protected MasterOccupationCategoryPersistence
		masterOccupationCategoryPersistence;

	@Reference
	protected MasterPromoCodePersistence masterPromoCodePersistence;

	@Reference
	protected MasterProvincePersistence masterProvincePersistence;

	@Reference
	protected PaymentChannelPersistence paymentChannelPersistence;

	@Reference
	protected PaymentChannelTenorPersistence paymentChannelTenorPersistence;

	@Reference
	protected PersonalAccidentPremiPersistence personalAccidentPremiPersistence;

	@Reference
	protected PetAnimalTypePersistence petAnimalTypePersistence;

	@Reference
	protected PetDetailPersistence petDetailPersistence;

	@Reference
	protected PetPlanPersistence petPlanPersistence;

	@Reference
	protected PetRatePersistence petRatePersistence;

	@Reference
	protected PetRateFinder petRateFinder;

	@Reference
	protected PetRemarksPersistence petRemarksPersistence;

	@Reference
	protected PremiPersistence premiPersistence;

	@Reference
	protected ProductConfigurationPersistence productConfigurationPersistence;

	@Reference
	protected PromocodesPersistence promocodesPersistence;

	@Reference
	protected ReferenceNumberPersistence referenceNumberPersistence;

	@Reference
	protected SmartActiveBenefitPersistence smartActiveBenefitPersistence;

	@Reference
	protected SmartActiveBenefitTypePersistence
		smartActiveBenefitTypePersistence;

	@Reference
	protected SmartActiveBenefitValuePersistence
		smartActiveBenefitValuePersistence;

	@Reference
	protected SmartActiveBenefitValueMappingPersistence
		smartActiveBenefitValueMappingPersistence;

	@Reference
	protected SmartActiveClassRatePersistence smartActiveClassRatePersistence;

	@Reference
	protected SmartActiveFeaturePersistence smartActiveFeaturePersistence;

	@Reference
	protected SmartActiveLinkPersistence smartActiveLinkPersistence;

	@Reference
	protected SmartActiveOccupationPersistence smartActiveOccupationPersistence;

	@Reference
	protected SmartActivePremiPersistence smartActivePremiPersistence;

	@Reference
	protected SmartActiveToproPersistence smartActiveToproPersistence;

	@Reference
	protected SmartActiveToproBenefitMappingPersistence
		smartActiveToproBenefitMappingPersistence;

	@Reference
	protected SmartHealthBenefitPersistence smartHealthBenefitPersistence;

	@Reference
	protected SmartHealthBenefitGroupPersistence
		smartHealthBenefitGroupPersistence;

	@Reference
	protected SmartHealthPlanPersistence smartHealthPlanPersistence;

	@Reference
	protected SmartHealthPremiPersistence smartHealthPremiPersistence;

	@Reference
	protected SmartTravelIntLinkPersistence smartTravelIntLinkPersistence;

	@Reference
	protected SmartTravelIntPlanPersistence smartTravelIntPlanPersistence;

	@Reference
	protected StiBenefitPersistence stiBenefitPersistence;

	protected StiBenefitValueMappingLocalService
		stiBenefitValueMappingLocalService;

	@Reference
	protected StiBenefitValueMappingPersistence
		stiBenefitValueMappingPersistence;

	@Reference
	protected StiPremiPersistence stiPremiPersistence;

	@Reference
	protected TravelDomesticBenefitPersistence travelDomesticBenefitPersistence;

	@Reference
	protected TravelDomesticBenefitGroupPersistence
		travelDomesticBenefitGroupPersistence;

	@Reference
	protected TravelDomesticDurationPersistence
		travelDomesticDurationPersistence;

	@Reference
	protected TravelDomesticInsuredTypePersistence
		travelDomesticInsuredTypePersistence;

	@Reference
	protected TravelDomesticPlanPersistence travelDomesticPlanPersistence;

	@Reference
	protected TravelDomesticPremiPersistence travelDomesticPremiPersistence;

	@Reference
	protected TravelDomesticPremiFinder travelDomesticPremiFinder;

	@Reference
	protected TravelDomesticRelationshipPersistence
		travelDomesticRelationshipPersistence;

	@Reference
	protected TravelDomesticTravellerTypePersistence
		travelDomesticTravellerTypePersistence;

	@Reference
	protected TravelIntBenefitPersistence travelIntBenefitPersistence;

	@Reference
	protected TravelIntBenefitValuePersistence travelIntBenefitValuePersistence;

	@Reference
	protected TravelInternationalPremiPersistence
		travelInternationalPremiPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}