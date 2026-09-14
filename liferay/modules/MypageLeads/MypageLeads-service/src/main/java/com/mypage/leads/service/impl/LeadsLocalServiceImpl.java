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

package com.mypage.leads.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.leads.exception.NoSuchLeadsException;
import com.mypage.leads.model.Leads;
import com.mypage.leads.service.base.LeadsLocalServiceBaseImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus
 */
@Component(
	property = "model.class.name=com.mypage.leads.model.Leads",
	service = AopService.class
)
public class LeadsLocalServiceImpl extends LeadsLocalServiceBaseImpl {
	
	public Leads setActive(long id, int active, ServiceContext serviceContext) throws PortalException {
		Leads _leads = null;

		try {
			_leads = leadsPersistence.findByPrimaryKey(id);
			Date now = new Date();
			_leads.setActive(active);
			_leads.setModifiedDate(serviceContext.getModifiedDate(now));

			leadsPersistence.update(_leads);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}

		return _leads;
	}

	public Leads addLeads(long userId, long LeadsId, JSONObject data, ServiceContext serviceContext) {
		Leads _leads = null;

		try {
			if (LeadsId == 0) {
				LeadsId = counterLocalService.increment();
				_leads = leadsPersistence.create(LeadsId);
				if (Validator.isNull(data.getString("Token"))) {
					String test = StringUtil.randomString(5) + LeadsId + StringUtil.randomString(5);
					String token = Base64.encode(test.getBytes());
					data.put("Token", token);
				}
				// New leads or kyc default to active
				data.put("Active", 1);
			} else {
				_leads = leadsPersistence.findByPrimaryKey(LeadsId);
			}

			long groupId = serviceContext.getScopeGroupId();
			User user = userLocalService.getUserById(userId);
			Date now = new Date();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			boolean isKyc = false;

			if (Validator.isNotNull(data.get("LeadsType"))) {
				isKyc = data.getString("LeadsType").equalsIgnoreCase("kyc");
				_leads.setLeadsType(data.getString("LeadsType").toLowerCase());
			} else {
				// do not proceed if leadsType is unknown
				return null;
			}

			if (Validator.isNotNull(data.getString("Dob"))) {
				Date dob = sdf.parse(data.getString("Dob"));
				_leads.setDob(dob);
			}

			if (Validator.isNotNull(data.get("PolicyStartDate"))) {
				Date policyStartDate = sdf.parse(data.getString("PolicyStartDate"));
				_leads.setPolicyStartDate(policyStartDate);
			}
			if (Validator.isNotNull(data.get("PolicyEndDate"))) {
				Date policyEndDate = sdf.parse(data.getString("PolicyEndDate"));
				_leads.setPolicyEndDate(policyEndDate);
			}
			
			// B2B/B2B2C
			if(LeadsId != 0) {
				
				//_leads.setMypageUserId(data.getLong("ManagedBy"));
				
				_leads.setManagedBy(data.getString("ManagedBy"));
				
				_leads.setBussinesModel(data.getString("BussinesModel"));
				_leads.setChannel(data.getString("Channel"));
			}

			_leads.setCommercialOffers(data.getInt("CommercialOffers"));
			_leads.setPolicyNumber(data.getString("PolicyNumber"));
			_leads.setReferenceNumber(data.getString("ReferenceNumber"));
			_leads.setCurrency(data.getString("Currency"));
			_leads.setPolicyCost(Double.isNaN(data.getDouble("PolicyCost")) ? 0 : data.getDouble("PolicyCost"));
			_leads.setStampDuty(Double.isNaN(data.getDouble("StampDuty")) ? 0 : data.getDouble("StampDuty"));
			_leads.setPremium(Double.isNaN(data.getDouble("Premium")) ? 0 : data.getDouble("Premium"));
			_leads.setNetPremium(Double.isNaN(data.getDouble("NetPremium")) ? 0 : data.getDouble("NetPremium"));
			_leads.setDiscount(Double.isNaN(data.getDouble("Discount")) ? 0 : data.getDouble("Discount"));
			_leads.setDiscountAmount(
					Double.isNaN(data.getDouble("DiscountAmount")) ? 0 : data.getDouble("DiscountAmount"));
			_leads.setCommission(Double.isNaN(data.getDouble("Commission")) ? 0 : data.getDouble("Commission"));

			_leads.setPromoCode(data.getString("PromoCode"));
			_leads.setProductCode(data.getString("ProductCode"));
			_leads.setUtmSource(data.getString("UtmSource"));
			_leads.setUtmMedium(data.getString("UtmMedium"));
			_leads.setUtmCampaign(data.getString("UtmCampaign"));
			_leads.setUtmTerm(data.getString("UtmTerm"));
			_leads.setUtmContent(data.getString("UtmContent"));
			_leads.setClickId(data.getString("ClickId"));
			_leads.setName(data.getString("Name"));
			_leads.setBirthPlace(data.getString("BirthPlace"));
			_leads.setEmail(data.getString("Email"));
			_leads.setMobilePhone(data.getString("MobilePhone"));
			_leads.setGender(data.getString("Gender"));
			_leads.setNationality(data.getString("Nationality"));
			_leads.setIdNumber(data.getString("IdNumber"));
			_leads.setPassportNumber(data.getString("PassportNumber"));
			_leads.setKitasNumber(data.getString("KitasNumber"));
			_leads.setAddress(data.getString("Address"));
			_leads.setAddress2(data.getString("Address2"));
			_leads.setProvince(data.getString("Province"));
			_leads.setCity(data.getString("City"));
			_leads.setZip(data.getString("Zip"));
			_leads.setActive(data.getInt("Active"));
			_leads.setToken(data.getString("Token"));
			_leads.setTempCode(data.getString("TempCode"));
			
			//_leads.setMypageUserId(data.getLong("ManagedBy"));
			
			//set manageBY to ManageBy
			_leads.setManagedBy(data.getString("ManagedBy"));
			
			_leads.setLeadsParentId(data.getLong("LeadsParentId"));

			_leads.setIsPep(data.getInt("isPEP"));
			
			//additional sti
			_leads.setCountryCode(data.getString("CountryCode"));
			_leads.setJob(data.getString("Job"));
			_leads.setAge(data.getInt("Age"));
			_leads.setMaritalStatus(data.getString("MaritalStatus"));
			_leads.setPhone(data.getString("Phone"));
			
			_leads.setIdPhotoFileEntryId(data.getLong(("IdPhotoFileEntry")));
			_leads.setPhotoFileUrl(data.getString("PhotoFileUrl"));
			
			_leads.setUserId(userId);
			_leads.setGroupId(groupId);
			_leads.setCompanyId(user.getCompanyId());
			_leads.setUserName(user.getFullName());
			_leads.setCreateDate(serviceContext.getCreateDate(now));
			_leads.setModifiedDate(serviceContext.getModifiedDate(now));
			_leads.setExpandoBridgeAttributes(serviceContext);

			leadsPersistence.update(_leads);

			// Register permission
			if (LeadsId == 0) {
				resourceLocalService.addResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
						serviceContext.getUserId(), Leads.class.getName(), "leadsId", false, true, true);
			} else {
				resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
						Leads.class.getName(), "leadsId", serviceContext.getModelPermissions());
			}

			return _leads;
		} catch (Exception e) {
			log.debug(e.getMessage());
		}

		return _leads;
	}
	
	public Leads updateLeads(long userId, long LeadsId, JSONObject data, ServiceContext serviceContext) {
		Leads _leads = null;

		if (LeadsId == 0) {
			LeadsId = counterLocalService.increment();
			_leads = leadsPersistence.create(LeadsId);
			if (Validator.isNull(data.getString("Token"))) {
				String test = StringUtil.randomString(5) + LeadsId + StringUtil.randomString(5);
				String token = Base64.encode(test.getBytes());
				data.put("Token", token);
			}
			// New leads or kyc default to active
			data.put("Active", 1);
		} else {
			try {
				_leads = leadsPersistence.findByPrimaryKey(LeadsId);	
			} catch (NoSuchLeadsException e) {
				log.debug(e.getMessage());
				throw new Error("Lead is not found");
			}
		}

		long groupId = serviceContext.getScopeGroupId();
		User user = null;
		try {
			user = userLocalService.getUserById(userId);
		} catch (PortalException e) {
			log.debug(e.getMessage());
			throw new Error("User is not found");
		}

		boolean isKyc = false;

		if (Validator.isNull(_leads.getLeadsType())) {
			if (Validator.isNotNull(data.get("LeadsType"))) {
				isKyc = data.getString("LeadsType").equalsIgnoreCase("kyc");
				_leads.setLeadsType(data.getString("LeadsType").toLowerCase());
			} else {
				// do not proceed if leadsType is unknown
				return null;
			}
		}
		
		Date now = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		if (Validator.isNotNull(data.getString("Dob"))) {
			Date dob = null;
			try {
				//dob = dateFormatter.parse(data.getString("Dob")); //error kalau pakai ini 0032-05-06 00:00:00.000000
				dob = sdf.parse(data.getString("Dob"));
			} catch (ParseException e) {
				log.debug(e.getMessage());
			}
			_leads.setDob(dob);
		}

		if (Validator.isNotNull(data.get("PolicyStartDate"))) {
			Date policyStartDate = null;
			try {
				policyStartDate = dateFormatter.parse(data.getString("PolicyStartDate"));
			} catch (ParseException e) {
				log.debug(e.getMessage());
			}
			_leads.setPolicyStartDate(policyStartDate);
		}
		if (Validator.isNotNull(data.get("PolicyEndDate"))) {
			Date policyEndDate = null;
			try {
				policyEndDate = dateFormatter.parse(data.getString("PolicyEndDate"));
			} catch (ParseException e) {
				log.debug(e.getMessage());
			}
			_leads.setPolicyEndDate(policyEndDate);
		}

		if (Validator.isNotNull(data.get("CommercialOffers")))
			_leads.setCommercialOffers(data.getInt("CommercialOffers"));
		if (Validator.isNotNull(data.get("PolicyNumber")))
			_leads.setPolicyNumber(data.getString("PolicyNumber"));
		if (Validator.isNotNull(data.get("ReferenceNumber")))
			_leads.setReferenceNumber(data.getString("ReferenceNumber"));
		if (Validator.isNotNull(data.get("Currency")))
			_leads.setCurrency(data.getString("Currency"));
		if (Validator.isNotNull(data.get("PolicyCost")))
			_leads.setPolicyCost(Double.isNaN(data.getDouble("PolicyCost")) ? 0 : data.getDouble("PolicyCost"));
		if (Validator.isNotNull(data.get("StampDuty")))
			_leads.setStampDuty(Double.isNaN(data.getDouble("StampDuty")) ? 0 : data.getDouble("StampDuty"));
		if (Validator.isNotNull(data.get("Premium")))
			_leads.setPremium(Double.isNaN(data.getDouble("Premium")) ? 0 : data.getDouble("Premium"));
		if (Validator.isNotNull(data.get("NetPremium")))
			_leads.setNetPremium(Double.isNaN(data.getDouble("NetPremium")) ? 0 : data.getDouble("NetPremium"));
		if (Validator.isNotNull(data.get("Discount")))
			_leads.setDiscount(Double.isNaN(data.getDouble("Discount")) ? 0 : data.getDouble("Discount"));
		if (Validator.isNotNull(data.get("DiscountAmount")))
			_leads.setDiscountAmount(
					Double.isNaN(data.getDouble("DiscountAmount")) ? 0 : data.getDouble("DiscountAmount"));
		if (Validator.isNotNull(data.get("Commission")))
			_leads.setCommission(Double.isNaN(data.getDouble("Commission")) ? 0 : data.getDouble("Commission"));
		if (Validator.isNotNull(data.get("BussinesModel")))
			_leads.setBussinesModel(data.getString("BussinesModel"));
		if (Validator.isNotNull(data.get("Channel")))
			_leads.setChannel(data.getString("Channel"));
		
//		if (Validator.isNotNull(data.get("PromoCode"))) {
//			_leads.setPromoCode(data.getString("PromoCode"));
//		}
		
		if(data.has("PromoCode")) {
			_leads.setPromoCode(data.getString("PromoCode"));	
		}
		
		
		if (Validator.isNotNull(data.get("ProductCode")))
			_leads.setProductCode(data.getString("ProductCode"));
		if (Validator.isNotNull(data.get("UtmSource")))
			_leads.setUtmSource(data.getString("UtmSource"));
		if (Validator.isNotNull(data.get("UtmMedium")))
			_leads.setUtmMedium(data.getString("UtmMedium"));
		if (Validator.isNotNull(data.get("UtmCampaign")))
			_leads.setUtmCampaign(data.getString("UtmCampaign"));
		if (Validator.isNotNull(data.get("UtmTerm")))
			_leads.setUtmTerm(data.getString("UtmTerm"));
		if (Validator.isNotNull(data.get("UtmContent")))
			_leads.setUtmContent(data.getString("UtmContent"));
		if (Validator.isNotNull(data.get("ClickId")))
			_leads.setClickId(data.getString("ClickId"));
		if (Validator.isNotNull(data.get("Name")))
			_leads.setName(data.getString("Name"));
		if (Validator.isNotNull(data.get("BirthPlace")))
			_leads.setBirthPlace(data.getString("BirthPlace"));
		if (Validator.isNotNull(data.get("Email")))
			_leads.setEmail(data.getString("Email"));
		if (Validator.isNotNull(data.get("MobilePhone")))
			_leads.setMobilePhone(data.getString("MobilePhone"));
		if (Validator.isNotNull(data.get("Gender")))
			_leads.setGender(data.getString("Gender"));
		if (Validator.isNotNull(data.get("Nationality")))
			_leads.setNationality(data.getString("Nationality"));
		if (Validator.isNotNull(data.get("IdNumber")))
			_leads.setIdNumber(data.getString("IdNumber"));
		if (Validator.isNotNull(data.get("PassportNumber")))
			_leads.setPassportNumber(data.getString("PassportNumber"));
		if (Validator.isNotNull(data.get("KitasNumber")))
			_leads.setKitasNumber(data.getString("KitasNumber"));
		if (Validator.isNotNull(data.get("Address")))
			_leads.setAddress(data.getString("Address"));
		if (Validator.isNotNull(data.get("Address2")))
			_leads.setAddress2(data.getString("Address2"));
		if (Validator.isNotNull(data.get("Province")))
			_leads.setProvince(data.getString("Province"));
		if (Validator.isNotNull(data.get("City")))
			_leads.setCity(data.getString("City"));
		if (Validator.isNotNull(data.get("Zip")))
			_leads.setZip(data.getString("Zip"));
		if (Validator.isNotNull(data.get("Active")))
			_leads.setActive(data.getInt("Active"));
		if (Validator.isNotNull(data.get("Token")))
			_leads.setToken(data.getString("Token"));
		if (Validator.isNotNull(data.get("TempCode")))
			_leads.setTempCode(data.getString("TempCode"));
		
//		if (Validator.isNotNull(data.get("ManagedBy")))
//			_leads.setMypageUserId(data.getLong("ManagedBy"));
		
		//set manage to manageBy
		if (Validator.isNotNull(data.get("ManagedBy")))
			_leads.setManagedBy(data.getString("ManagedBy"));
		
		if (Validator.isNotNull(data.get("LeadsParentId")))
			_leads.setLeadsParentId(data.getLong("LeadsParentId"));
		
		if (Validator.isNotNull(data.get("isPEP")))
			_leads.setIsPep(data.getInt("isPEP"));
		
		//additional sti
		if (Validator.isNotNull(data.get("CountryCode")))
			_leads.setCountryCode((data.getString("CountryCode")));
		if (Validator.isNotNull(data.get("Job")))
			_leads.setJob((data.getString("Job")));
		
		if (Validator.isNotNull(data.get("JobOther")))
			_leads.setJobOther((data.getString("JobOther")));
		
		if (Validator.isNotNull(data.get("Age")))
			_leads.setAge((data.getInt("Age")));
		if (Validator.isNotNull(data.get("MaritalStatus")))
			_leads.setMaritalStatus((data.getString("MaritalStatus")));
		if (Validator.isNotNull(data.get("Phone")))
			_leads.setPhone((data.getString("Phone")));
		
		if (Validator.isNotNull(data.get("IdPhotoFileEntry")))
			_leads.setIdPhotoFileEntryId((data.getLong("IdPhotoFileEntry")));
		if (Validator.isNotNull(data.get("PhotoFileUrl")))
			_leads.setPhotoFileUrl((data.getString("PhotoFileUrl")));
		
		// additional sa
		if (Validator.isNotNull(data.get("WorkLocation")))
			_leads.setWorkLocation((data.getString("WorkLocation")));
		if (Validator.isNotNull(data.get("WorkLocationOther")))
			_leads.setWorkLocationOther((data.getString("WorkLocationOther")));
		if (Validator.isNotNull(data.get("MonthlyIncome")))
			_leads.setMonthlyIncome((data.getString("MonthlyIncome")));
		if (Validator.isNotNull(data.get("PaymentSource")))
			_leads.setPaymentSource((data.getString("PaymentSource")));
		if (Validator.isNotNull(data.get("PaymentSourceOther")))
			_leads.setPaymentSourceOther((data.getString("PaymentSourceOther")));
		if (Validator.isNotNull(data.get("Beneficiary")))
			_leads.setBeneficiary((data.getString("Beneficiary")));
		if (Validator.isNotNull(data.get("BeneficiaryRelationship")))
			_leads.setBeneficiaryRelationship((data.getString("BeneficiaryRelationship")));
		
		_leads.setUserId(userId);
		_leads.setGroupId(groupId);
		_leads.setCompanyId(user.getCompanyId());
		_leads.setUserName(user.getFullName());
		_leads.setCreateDate(serviceContext.getCreateDate(now));
		_leads.setModifiedDate(serviceContext.getModifiedDate(now));
		_leads.setExpandoBridgeAttributes(serviceContext);

		leadsPersistence.update(_leads);

		// Register permission
		if (LeadsId == 0) {
			try {
				resourceLocalService.addResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
						serviceContext.getUserId(), Leads.class.getName(), "leadsId", false, true, true);
			} catch (PortalException e) {
				log.debug(e.getMessage());
				throw new Error("Error update resource.");
			}
		} else {
			try {
				resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
						Leads.class.getName(), "leadsId", serviceContext.getModelPermissions());
			} catch (PortalException e) {
				log.debug(e.getMessage());
				throw new Error("Error update resource.");
			}

		}

		return _leads;
	}
	
	public Leads updateLeadsData(long userId, long LeadsId, HashMap<String, Object> data, ServiceContext serviceContext) {
		Leads _leads = null;

		if (LeadsId == 0) {
			LeadsId = counterLocalService.increment();
			_leads = leadsPersistence.create(LeadsId);
			if (Validator.isNull(data.get("Token").toString())) {
				String test = StringUtil.randomString(5) + LeadsId + StringUtil.randomString(5);
				String token = Base64.encode(test.getBytes());
				data.put("Token", token);
			}
			// New leads or kyc default to active
			data.put("Active", 1);
		} else {
			try {
				_leads = leadsPersistence.findByPrimaryKey(LeadsId);	
			} catch (NoSuchLeadsException e) {
				log.debug(e.getMessage());
				throw new Error("Lead is not found");
			}
		}

		long groupId = serviceContext.getScopeGroupId();
		User user = null;
		try {
			user = userLocalService.getUserById(userId);
		} catch (PortalException e) {
			log.debug(e.getMessage());
			throw new Error("User is not found");
		}

		boolean isKyc = false;

		if (Validator.isNull(_leads.getLeadsType())) {
			if (Validator.isNotNull(data.get("LeadsType"))) {
				isKyc = data.get("LeadsType").toString().equalsIgnoreCase("kyc");
				_leads.setLeadsType(data.get("LeadsType").toString().toLowerCase());
			} else {
				// do not proceed if leadsType is unknown
				return null;
			}
		}
		
		Date now = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		if (Validator.isNotNull(data.get("Dob").toString())) {
			Date dob = null;
			try {
				//dob = dateFormatter.parse(data.getString("Dob")); //error kalau pakai ini 0032-05-06 00:00:00.000000
				dob = sdf.parse(data.get("Dob").toString());
			} catch (ParseException e) {
				log.debug(e.getMessage());
			}
			_leads.setDob(dob);
		}

		if (Validator.isNotNull(data.get("PolicyStartDate"))) {
			Date policyStartDate = null;
			try {
				policyStartDate = dateFormatter.parse(data.get("PolicyStartDate").toString());
			} catch (ParseException e) {
				log.debug(e.getMessage());
			}
			_leads.setPolicyStartDate(policyStartDate);
		}
		if (Validator.isNotNull(data.get("PolicyEndDate").toString())) {
			Date policyEndDate = null;
			try {
				policyEndDate = dateFormatter.parse(data.get("PolicyEndDate").toString());
			} catch (ParseException e) {
				log.debug(e.getMessage());
			}
			_leads.setPolicyEndDate(policyEndDate);
		}

		if (Validator.isNotNull(Integer.parseInt(data.get("CommercialOffers").toString())))
			_leads.setCommercialOffers(Integer.parseInt(data.get("CommercialOffers").toString()));
		if (Validator.isNotNull(data.get("PolicyNumber")))
			_leads.setPolicyNumber(data.get("PolicyNumber").toString());
		if (Validator.isNotNull(data.get("ReferenceNumber").toString()))
			_leads.setReferenceNumber(data.get("ReferenceNumber").toString());
		if (Validator.isNotNull(data.get("Currency").toString()))
			_leads.setCurrency(data.get("Currency").toString());
		if (Validator.isNotNull(Double.parseDouble(data.get("PolicyCost").toString())))
			_leads.setPolicyCost(Double.isNaN(Double.parseDouble(data.get("PolicyCost").toString())) ? 0 : Double.parseDouble(data.get("PolicyCost").toString()));
		if (Validator.isNotNull(data.get("StampDuty").toString()))
			_leads.setStampDuty(Double.isNaN(Double.parseDouble(data.get("StampDuty").toString())) ? 0 : Double.parseDouble(data.get("StampDuty").toString()));
		if (Validator.isNotNull(data.get("Premium").toString()))
			_leads.setPremium(Double.isNaN(Double.parseDouble(data.get("Premium").toString())) ? 0 : Double.parseDouble(data.get("Premium").toString()));
		if (Validator.isNotNull(data.get("NetPremium").toString()))
			_leads.setNetPremium(Double.isNaN(Double.parseDouble(data.get("NetPremium").toString())) ? 0 : Double.parseDouble(data.get("NetPremium").toString()));
		if (Validator.isNotNull(data.get("Discount").toString()))
			_leads.setDiscount(Double.isNaN(Double.parseDouble(data.get("Discount").toString())) ? 0 : Double.parseDouble(data.get("Discount").toString()));
		if (Validator.isNotNull(data.get("DiscountAmount").toString()))
			_leads.setDiscountAmount(
					Double.isNaN(Double.parseDouble(data.get("DiscountAmount").toString())) ? 0 : Double.parseDouble(data.get("DiscountAmount").toString()));
		if (Validator.isNotNull(data.get("Commission").toString()))
			_leads.setCommission(Double.isNaN(Double.parseDouble(data.get("Commission").toString())) ? 0 : Double.parseDouble(data.get("Commission").toString()));
		if (Validator.isNotNull(data.get("BussinesModel").toString()))
			_leads.setBussinesModel(data.get("BussinesModel").toString());
		if (Validator.isNotNull(data.get("Channel").toString()))
			_leads.setChannel(data.get("Channel").toString());
		
//		if (Validator.isNotNull(data.get("PromoCode"))) {
//			_leads.setPromoCode(data.getString("PromoCode"));
//		}
		
		if(data.containsKey("PromoCode")) {
			_leads.setPromoCode(data.get("PromoCode").toString());	
		}
		
		
		if (Validator.isNotNull(data.get("ProductCode").toString()))
			_leads.setProductCode(data.get("ProductCode").toString());
		if (Validator.isNotNull(data.get("UtmSource").toString()))
			_leads.setUtmSource(data.get("UtmSource").toString());
		if (Validator.isNotNull(data.get("UtmMedium").toString()))
			_leads.setUtmMedium(data.get("UtmMedium").toString());
		if (Validator.isNotNull(data.get("UtmCampaign").toString()))
			_leads.setUtmCampaign(data.get("UtmCampaign").toString());
		if (Validator.isNotNull(data.get("UtmTerm").toString()))
			_leads.setUtmTerm(data.get("UtmTerm").toString());
		if (Validator.isNotNull(data.get("UtmContent").toString()))
			_leads.setUtmContent(data.get("UtmContent").toString());
		if (Validator.isNotNull(data.get("ClickId").toString()))
			_leads.setClickId(data.get("ClickId").toString());
		if (Validator.isNotNull(data.get("Name").toString()))
			_leads.setName(data.get("Name").toString());
		if (Validator.isNotNull(data.get("BirthPlace").toString()))
			_leads.setBirthPlace(data.get("BirthPlace").toString());
		if (Validator.isNotNull(data.get("Email").toString()))
			_leads.setEmail(data.get("Email").toString());
		if (Validator.isNotNull(data.get("MobilePhone").toString()))
			_leads.setMobilePhone(data.get("MobilePhone").toString());
		if (Validator.isNotNull(data.get("Gender").toString()))
			_leads.setGender(data.get("Gender").toString());
		if (Validator.isNotNull(data.get("Nationality").toString()))
			_leads.setNationality(data.get("Nationality").toString());
		if (Validator.isNotNull(data.get("IdNumber").toString()))
			_leads.setIdNumber(data.get("IdNumber").toString());
		if (Validator.isNotNull(data.get("PassportNumber").toString()))
			_leads.setPassportNumber(data.get("PassportNumber").toString());
		if (Validator.isNotNull(data.get("KitasNumber").toString()))
			_leads.setKitasNumber(data.get("KitasNumber").toString());
		if (Validator.isNotNull(data.get("Address").toString()))
			_leads.setAddress(data.get("Address").toString());
		if (Validator.isNotNull(data.get("Address2").toString()))
			_leads.setAddress2(data.get("Address2").toString());
		if (Validator.isNotNull(data.get("Province").toString()))
			_leads.setProvince(data.get("Province").toString());
		if (Validator.isNotNull(data.get("City").toString()))
			_leads.setCity(data.get("City").toString());
		if (Validator.isNotNull(data.get("Zip").toString()))
			_leads.setZip(data.get("Zip").toString());
		if (Validator.isNotNull(Integer.parseInt(data.get("Active").toString())))
			_leads.setActive(Integer.parseInt(data.get("Active").toString()));
		if (Validator.isNotNull(data.get("Token").toString()))
			_leads.setToken(data.get("Token").toString());
		if (Validator.isNotNull(data.get("TempCode").toString()))
			_leads.setTempCode(data.get("TempCode").toString());
		
//		if (Validator.isNotNull(data.get("ManagedBy")))
//			_leads.setMypageUserId(data.getLong("ManagedBy"));
		
		//set manage to manageBy
		if (Validator.isNotNull(data.get("ManagedBy").toString()))
			_leads.setManagedBy(data.get("ManagedBy").toString());
		
		if (Validator.isNotNull(Long.parseLong(data.get("LeadsParentId").toString())))
			_leads.setLeadsParentId(Long.parseLong(data.get("LeadsParentId").toString()));
		
		if (Validator.isNotNull(Integer.parseInt(data.get("isPEP").toString())))
			_leads.setIsPep(Integer.parseInt(data.get("isPEP").toString()));
		
		//additional sti
		if (Validator.isNotNull(data.get("CountryCode").toString()))
			_leads.setCountryCode((data.get("CountryCode").toString()));
		if (Validator.isNotNull(data.get("Job").toString()))
			_leads.setJob((data.get("Job").toString()));
		
		if (Validator.isNotNull(data.get("JobOther").toString()))
			_leads.setJobOther((data.get("JobOther").toString()));
		
		if (Validator.isNotNull(Integer.parseInt(data.get("Age").toString())))
			_leads.setAge(Integer.parseInt(data.get("Age").toString()));
		if (Validator.isNotNull(data.get("MaritalStatus").toString()))
			_leads.setMaritalStatus((data.get("MaritalStatus").toString()));
		if (Validator.isNotNull(data.get("Phone").toString()))
			_leads.setPhone((data.get("Phone").toString()));
		
		if (Validator.isNotNull(Long.parseLong(data.get("IdPhotoFileEntry").toString())))
			_leads.setIdPhotoFileEntryId(Long.parseLong(data.get("IdPhotoFileEntry").toString()));
		if (Validator.isNotNull(data.get("PhotoFileUrl").toString()))
			_leads.setPhotoFileUrl((data.get("PhotoFileUrl").toString()));
		
		// additional sa
		if (Validator.isNotNull(data.get("WorkLocation").toString()))
			_leads.setWorkLocation((data.get("WorkLocation").toString()));
		if (Validator.isNotNull(data.get("WorkLocationOther").toString()))
			_leads.setWorkLocationOther((data.get("WorkLocationOther").toString()));
		if (Validator.isNotNull(data.get("MonthlyIncome").toString()))
			_leads.setMonthlyIncome((data.get("MonthlyIncome").toString()));
		if (Validator.isNotNull(data.get("PaymentSource").toString()))
			_leads.setPaymentSource((data.get("PaymentSource").toString()));
		if (Validator.isNotNull(data.get("PaymentSourceOther").toString()))
			_leads.setPaymentSourceOther((data.get("PaymentSourceOther").toString()));
		if (Validator.isNotNull(data.get("Beneficiary").toString()))
			_leads.setBeneficiary((data.get("Beneficiary").toString()));
		if (Validator.isNotNull(data.get("BeneficiaryRelationship").toString()))
			_leads.setBeneficiaryRelationship((data.get("BeneficiaryRelationship").toString()));
		
		_leads.setUserId(userId);
		_leads.setGroupId(groupId);
		_leads.setCompanyId(user.getCompanyId());
		_leads.setUserName(user.getFullName());
		_leads.setCreateDate(serviceContext.getCreateDate(now));
		_leads.setModifiedDate(serviceContext.getModifiedDate(now));
		_leads.setExpandoBridgeAttributes(serviceContext);

		leadsPersistence.update(_leads);

		// Register permission
		if (LeadsId == 0) {
			try {
				resourceLocalService.addResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
						serviceContext.getUserId(), Leads.class.getName(), "leadsId", false, true, true);
			} catch (PortalException e) {
				log.debug(e.getMessage());
				throw new Error("Error update resource.");
			}
		} else {
			try {
				resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
						Leads.class.getName(), "leadsId", serviceContext.getModelPermissions());
			} catch (PortalException e) {
				log.debug(e.getMessage());
				throw new Error("Error update resource.");
			}

		}

		return _leads;
	}

	public Leads setLeadsType(long LeadsId, String LeadsType) throws Exception {
		Leads leads = leadsPersistence.findByPrimaryKey(LeadsId);

		if (!LeadsType.equalsIgnoreCase("kyc") && !LeadsType.equalsIgnoreCase("leads") && !LeadsType.equalsIgnoreCase("quotation")) {
			throw new Exception("Leads Type is unknown");
		}

		leads.setLeadsType(LeadsType);
		leadsPersistence.update(leads);

		return leads;
	}
	
	public Leads setIdPhoto(long LeadsId, long idPhotoFileEntryId) throws Exception {
		Leads leads = leadsPersistence.findByPrimaryKey(LeadsId);

		leads.setIdPhotoFileEntryId(idPhotoFileEntryId);;
		leadsPersistence.update(leads);

		return leads;
	}
	
	public Leads setIdPhoto(long LeadsId, long idPhotoFileEntryId, String photoFileUrl) throws Exception {
		Leads leads = leadsPersistence.findByPrimaryKey(LeadsId);

		leads.setIdPhotoFileEntryId(idPhotoFileEntryId);;
		leads.setPhotoFileUrl(photoFileUrl);
		leadsPersistence.update(leads);

		return leads;
	}
	
	public Leads setStatus(long leadsId, String status) throws Exception {
		Leads leads = leadsPersistence.findByPrimaryKey(leadsId);
		
		leads.setStatus(status);
		leadsPersistence.update(leads);
		return leads;
	}

	public Leads setReferenceNumber(long LeadsId, String referenceNumber) throws NoSuchLeadsException {
		Leads leads = leadsPersistence.findByPrimaryKey(LeadsId);
		leads.setReferenceNumber(referenceNumber);
		leadsPersistence.update(leads);

		return leads;
	}

	public Leads findByToken(String Token) {
		try {
			return leadsPersistence.findByfindByToken(Token);
		} catch (NoSuchLeadsException e) {
            log.debug(e.getMessage());
		}
		return null;
	}

	public List<Leads> findAllByMypageUserId(long mypageUserId) throws NoSuchLeadsException {
		List<Leads> leads = null;

		leads = leadsPersistence.findByMyPageUserId(mypageUserId);

		if (Validator.isNull(leads)) {
			throw new NoSuchLeadsException("Leads are not found");
		}

		return leads;
	}

	public List<Leads> searchByToken(String Token) {
		return leadsPersistence.findBysearchByToken(Token);
	}

	public List<Leads> searchByPromoCode(String PromoCode) {
		return leadsPersistence.findBysearchByPromoCode(PromoCode);
	}

	public Leads searchByReferenceNumber(String ReferenceNumber) {
		return leadsPersistence.fetchByfindByReferenceNumber(ReferenceNumber);
	}
	
	public Leads searchByIdPhoto(long idPhoto) {
		return leadsPersistence.fetchByidPhotoFileEntryId(idPhoto);
	}
	
	public Leads findByLeadId(long leadId) throws NoSuchLeadsException {
		return leadsPersistence.findByPrimaryKey(leadId);
	}

    private static final Log log = LogFactoryUtil.getLog(LeadsLocalServiceImpl.class);
}