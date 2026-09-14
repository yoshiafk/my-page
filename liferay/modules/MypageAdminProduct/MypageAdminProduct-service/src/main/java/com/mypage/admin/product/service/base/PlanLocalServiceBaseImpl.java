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

import com.mypage.admin.product.model.Plan;
import com.mypage.admin.product.service.PlanLocalService;
import com.mypage.admin.product.service.PlanLocalServiceUtil;
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
import com.mypage.admin.product.service.persistence.PlanPersistence;
import com.mypage.admin.product.service.persistence.PremiPersistence;
import com.mypage.admin.product.service.persistence.ProductConfigurationPersistence;
import com.mypage.admin.product.service.persistence.PromocodesPersistence;
import com.mypage.admin.product.service.persistence.ReferenceNumberPersistence;
import com.mypage.admin.product.service.persistence.SmartHealthBenefitGroupPersistence;
import com.mypage.admin.product.service.persistence.SmartHealthBenefitPersistence;
import com.mypage.admin.product.service.persistence.SmartHealthPlanPersistence;
import com.mypage.admin.product.service.persistence.SmartHealthPremiPersistence;
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
 * Provides the base implementation for the plan local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.mypage.admin.product.service.impl.PlanLocalServiceImpl}.
 * </p>
 *
 * @author Gositus Team
 * @see com.mypage.admin.product.service.impl.PlanLocalServiceImpl
 * @generated
 */
public abstract class PlanLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, PlanLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>PlanLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>PlanLocalServiceUtil</code>.
	 */

	/**
	 * Adds the plan to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param plan the plan
	 * @return the plan that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Plan addPlan(Plan plan) {
		plan.setNew(true);

		return planPersistence.update(plan);
	}

	/**
	 * Creates a new plan with the primary key. Does not add the plan to the database.
	 *
	 * @param planId the primary key for the new plan
	 * @return the new plan
	 */
	@Override
	@Transactional(enabled = false)
	public Plan createPlan(long planId) {
		return planPersistence.create(planId);
	}

	/**
	 * Deletes the plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param planId the primary key of the plan
	 * @return the plan that was removed
	 * @throws PortalException if a plan with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Plan deletePlan(long planId) throws PortalException {
		return planPersistence.remove(planId);
	}

	/**
	 * Deletes the plan from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param plan the plan
	 * @return the plan that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Plan deletePlan(Plan plan) {
		return planPersistence.remove(plan);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Plan.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return planPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PlanModelImpl</code>.
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

		return planPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PlanModelImpl</code>.
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

		return planPersistence.findWithDynamicQuery(
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
		return planPersistence.countWithDynamicQuery(dynamicQuery);
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

		return planPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Plan fetchPlan(long planId) {
		return planPersistence.fetchByPrimaryKey(planId);
	}

	/**
	 * Returns the plan with the primary key.
	 *
	 * @param planId the primary key of the plan
	 * @return the plan
	 * @throws PortalException if a plan with the primary key could not be found
	 */
	@Override
	public Plan getPlan(long planId) throws PortalException {
		return planPersistence.findByPrimaryKey(planId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(planLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Plan.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("planId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(planLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Plan.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("planId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(planLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Plan.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("planId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return planPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return planLocalService.deletePlan((Plan)persistedModel);
	}

	public BasePersistence<Plan> getBasePersistence() {
		return planPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return planPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of plans
	 * @param end the upper bound of the range of plans (not inclusive)
	 * @return the range of plans
	 */
	@Override
	public List<Plan> getPlans(int start, int end) {
		return planPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of plans.
	 *
	 * @return the number of plans
	 */
	@Override
	public int getPlansCount() {
		return planPersistence.countAll();
	}

	/**
	 * Updates the plan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param plan the plan
	 * @return the plan that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Plan updatePlan(Plan plan) {
		return planPersistence.update(plan);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			PlanLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		planLocalService = (PlanLocalService)aopProxy;

		_setLocalServiceUtilService(planLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return PlanLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Plan.class;
	}

	protected String getModelClassName() {
		return Plan.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = planPersistence.getDataSource();

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
		PlanLocalService planLocalService) {

		try {
			Field field = PlanLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, planLocalService);
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

	protected PlanLocalService planLocalService;

	@Reference
	protected PlanPersistence planPersistence;

	@Reference
	protected PremiPersistence premiPersistence;

	@Reference
	protected ProductConfigurationPersistence productConfigurationPersistence;

	@Reference
	protected PromocodesPersistence promocodesPersistence;

	@Reference
	protected ReferenceNumberPersistence referenceNumberPersistence;

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