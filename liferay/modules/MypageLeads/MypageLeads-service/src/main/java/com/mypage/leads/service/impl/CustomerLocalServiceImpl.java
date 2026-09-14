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
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.leads.model.Customer;
import com.mypage.leads.service.base.CustomerLocalServiceBaseImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus
 */
@Component(
	property = "model.class.name=com.mypage.leads.model.Customer",
	service = AopService.class
)
public class CustomerLocalServiceImpl extends CustomerLocalServiceBaseImpl {
	
	public Customer addCustomer(long userId, long customerId, JSONObject data,ServiceContext serviceContext) {
		Customer customer = null;

		try {
			if (customerId == 0) {
				customerId = counterLocalService.increment();
				customer = customerPersistence.create(customerId);
			} else {
				customer = customerPersistence.findByPrimaryKey(customerId);
			}

			long groupId = serviceContext.getScopeGroupId();
			User user = userLocalService.getUserById(userId);
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			if(Validator.isNotNull(data.getLong("LeadsId"))) {
			    customer.setLeadsId(data.getLong("LeadsId"));
			}
			if(Validator.isNotNull(data.getString("Name"))) {
			    customer.setName(data.getString("Name"));
			}
			if(Validator.isNotNull(data.getString("Email"))) {
			    customer.setEmail(data.getString("Email"));
			}
			if(Validator.isNotNull(data.getString("MobilePhone"))) {
			    customer.setMobilePhone(data.getString("MobilePhone"));
			}
			if(Validator.isNotNull(data.getString("Gender"))) {
			    customer.setGender(data.getString("Gender"));
			}
			if(Validator.isNotNull(data.getString("Dob"))) {
				Date dob = sdf.parse(data.getString("Dob"));
			    customer.setDob(dob);
			}
			
			if(Validator.isNotNull(data.getString("BirthPlace"))) {
			    customer.setBirthPlace(data.getString("BirthPlace"));
			}
			
			if(Validator.isNotNull(data.getString("Nationality"))) {
			    customer.setNationality(data.getString("Nationality"));
			}
			if(Validator.isNotNull(data.getString("IdNumber"))) {
			    customer.setIdNumber(data.getString("IdNumber"));
			}
			if(Validator.isNotNull(data.getString("PassportNumber"))) {
			    customer.setPassportNumber(data.getString("PassportNumber"));
			}
			if(Validator.isNotNull(data.getString("KitasNumber"))) {
			    customer.setKitasNumber(data.getString("KitasNumber"));
			}
			if(Validator.isNotNull(data.getString("Address"))) {
			    customer.setAddress(data.getString("Address"));
			}
			if(Validator.isNotNull(data.getString("Address2"))) {
			    customer.setAddress2(data.getString("Address2"));
			}
			if(Validator.isNotNull(data.getString("Relationship"))) {
			    customer.setRelationship(data.getString("Relationship"));
			}
			if(Validator.isNotNull(data.getString("Province"))) {
			    customer.setProvince(data.getString("Province"));
			}
			if(Validator.isNotNull(data.getString("City"))) {
			    customer.setCity(data.getString("City"));
			}
			if(Validator.isNotNull(data.getString("Zip"))) {
			    customer.setZip(data.getString("Zip"));
			}
			if(Validator.isNotNull(data.getString("BeneficiaryRelationship"))) {
			    customer.setBeneficiaryRelationship(data.getString("BeneficiaryRelationship"));
			}
			if(Validator.isNotNull(data.getString("Beneficiary"))) {
			    customer.setBeneficiary(data.getString("Beneficiary"));
			}
			if(Validator.isNotNull(data.getString("Type"))) {
			    customer.setType(data.getString("Type"));
			}
			if(Validator.isNotNull(data.getString("ProductCode"))) {
			    customer.setProductCode(data.getString("ProductCode"));
			}
			
			//additional sti			
			if(Validator.isNotNull(data.getString("isPEP"))) {
				customer.setIsPep(data.getInt("isPEP"));
			}
			
			if(Validator.isNotNull(data.getString("CountryCode"))) {
			    customer.setCountryCode((data.getString("CountryCode")));
			}
			if(Validator.isNotNull(data.getString("Job"))) {
			    customer.setJob((data.getString("Job")));
			}
			
			if(Validator.isNotNull(data.getString("JobOther"))) {
			    customer.setJobOther((data.getString("JobOther")));
			}
			
			
			if(Validator.isNotNull(data.getString("Age"))) {
			    customer.setAge((data.getInt("Age")));
			}
			if(Validator.isNotNull(data.getString("MaritalStatus"))) {
			    customer.setMaritalStatus((data.getString("MaritalStatus")));
			}
			if(Validator.isNotNull(data.getString("Phone"))) {
			    customer.setPhone((data.getString("Phone")));
			}
						
			if(Validator.isNotNull(data.getString("IdPhotoFileEntry"))) {
			    customer.setIdPhotoFileEntryId((data.getLong("IdPhotoFileEntry")));
			}
			if(Validator.isNotNull(data.getString("PhotoFileUrl"))) {
			    customer.setPhotoFileUrl((data.getString("PhotoFileUrl")));
			}
			
			
			customer.setUserId(userId);
			customer.setGroupId(groupId);
			customer.setCompanyId(user.getCompanyId());
			customer.setUserName(user.getFullName());
			customer.setCreateDate(serviceContext.getCreateDate(now));
			customer.setModifiedDate(serviceContext.getModifiedDate(now));
			customer.setExpandoBridgeAttributes(serviceContext);

			customerPersistence.update(customer);
			
			return customer;
		} catch (Exception e) {
			// TODO: handle exception
			log.debug(e.getMessage());
		}
		
		return customer;	
	}
	
	public Customer addCustomerData(long userId, long customerId, HashMap<String, Object> data, ServiceContext serviceContext) {
		Customer customer = null;
		
		try {
			if (customerId == 0) {
				customerId = counterLocalService.increment();
				customer = customerPersistence.create(customerId);
			} else {
				customer = customerPersistence.findByPrimaryKey(customerId);
			}

			long groupId = serviceContext.getScopeGroupId();
			User user = userLocalService.getUserById(userId);
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			if(Validator.isNotNull(data.get("LeadsId").toString())) {
			    customer.setLeadsId(Long.parseLong(data.get("LeadsId").toString()));
			}
			if(Validator.isNotNull(data.get("Name").toString())) {
			    customer.setName(data.get("Name").toString());
			}
			if(Validator.isNotNull(data.get("Email").toString())) {
			    customer.setEmail(data.get("Email").toString());
			}
			if(Validator.isNotNull(data.get("MobilePhone").toString())) {
			    customer.setMobilePhone(data.get("MobilePhone").toString());
			}
			if(Validator.isNotNull(data.get("Gender").toString())) {
			    customer.setGender(data.get("Gender").toString());
			}
			if(Validator.isNotNull(data.get("Dob").toString())) {
				Date dob = sdf.parse(data.get("Dob").toString());
			    customer.setDob(dob);
			}
			
			if(Validator.isNotNull(data.get("BirthPlace").toString())) {
			    customer.setBirthPlace(data.get("BirthPlace").toString());
			}
			
			if(Validator.isNotNull(data.get("Nationality").toString())) {
			    customer.setNationality(data.get("Nationality").toString());
			}
			if(Validator.isNotNull(data.get("IdNumber").toString())) {
			    customer.setIdNumber(data.get("IdNumber").toString());
			}
			if(Validator.isNotNull(data.get("PassportNumber").toString())) {
			    customer.setPassportNumber(data.get("PassportNumber").toString());
			}
			if(Validator.isNotNull(data.get("KitasNumber").toString())) {
			    customer.setKitasNumber(data.get("KitasNumber").toString());
			}
			if(Validator.isNotNull(data.get("Address").toString())) {
			    customer.setAddress(data.get("Address").toString());
			}
			if(Validator.isNotNull(data.get("Address2").toString())) {
			    customer.setAddress2(data.get("Address2").toString());
			}
			if(Validator.isNotNull(data.get("Relationship").toString())) {
			    customer.setRelationship(data.get("Relationship").toString());
			}
			if(Validator.isNotNull(data.get("Province").toString())) {
			    customer.setProvince(data.get("Province").toString());
			}
			if(Validator.isNotNull(data.get("City").toString())) {
			    customer.setCity(data.get("City").toString());
			}
			if(Validator.isNotNull(data.get("Zip").toString())) {
			    customer.setZip(data.get("Zip").toString());
			}
			if(Validator.isNotNull(data.get("BeneficiaryRelationship").toString())) {
			    customer.setBeneficiaryRelationship(data.get("BeneficiaryRelationship").toString());
			}
			if(Validator.isNotNull(data.get("Beneficiary").toString())) {
			    customer.setBeneficiary(data.get("Beneficiary").toString());
			}
			if(Validator.isNotNull(data.get("Type").toString())) {
			    customer.setType(data.get("Type").toString());
			}
			if(Validator.isNotNull(data.get("ProductCode").toString())) {
			    customer.setProductCode(data.get("ProductCode").toString());
			}
			
			//additional sti			
			if(Validator.isNotNull(data.get("isPEP").toString())) {
				customer.setIsPep(Integer.parseInt(data.get("isPEP").toString()));
			}
			
			if(Validator.isNotNull(data.get("CountryCode").toString())) {
			    customer.setCountryCode((data.get("CountryCode").toString()));
			}
			if(Validator.isNotNull(data.get("Job").toString())) {
			    customer.setJob((data.get("Job").toString()));
			}
			
			if(Validator.isNotNull(data.get("JobOther").toString())) {
			    customer.setJobOther((data.get("JobOther").toString()));
			}
			
			
			if(Validator.isNotNull(data.get("Age").toString())) {
			    customer.setAge((Integer.parseInt(data.get("Age").toString())));
			}
			if(Validator.isNotNull(data.get("MaritalStatus").toString())) {
			    customer.setMaritalStatus((data.get("MaritalStatus").toString()));
			}
			if(Validator.isNotNull(data.get("Phone").toString())) {
			    customer.setPhone((data.get("Phone").toString()));
			}
						
			if(Validator.isNotNull(data.get("IdPhotoFileEntry").toString())) {
			    customer.setIdPhotoFileEntryId((Long.parseLong(data.get("IdPhotoFileEntry").toString())));
			}
			if(Validator.isNotNull(data.get("PhotoFileUrl").toString())) {
			    customer.setPhotoFileUrl((data.get("PhotoFileUrl").toString()));
			}
			
			
			customer.setUserId(userId);
			customer.setGroupId(groupId);
			customer.setCompanyId(user.getCompanyId());
			customer.setUserName(user.getFullName());
			customer.setCreateDate(serviceContext.getCreateDate(now));
			customer.setModifiedDate(serviceContext.getModifiedDate(now));
			customer.setExpandoBridgeAttributes(serviceContext);

			customerPersistence.update(customer);
			
			return customer;
		} catch (Exception e) {
			// TODO: handle exception
			log.debug(e.getMessage());
		}
		
		return customer;
	}
	
	public List<Customer> findByLeadsId(long LeadsId) {
		return customerPersistence.findBysearchByLeadsId(LeadsId);
	}
	
	public List<Customer> findByLeadsIdAndProductCode(long LeadsId, String ProductCode) {
		return customerPersistence.findBysearchByLeadsIdAndProductCode(LeadsId, ProductCode);
	}

	public void removeCustomerByLeadsId(long LeadsId) {
		customerPersistence.removeBysearchByLeadsId(LeadsId);
	}
	
	public void removeCustomerByLeadsIdAndProductCode(long LeadsId, String ProductCode) {
		customerPersistence.removeBysearchByLeadsIdAndProductCode(LeadsId, ProductCode);
	}

    private static final Log log = LogFactoryUtil.getLog(CustomerLocalServiceImpl.class);
}