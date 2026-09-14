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

package com.mypage.user.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.user.model.UserRegistration;
import com.mypage.user.service.base.UserRegistrationLocalServiceBaseImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.mypage.user.model.UserRegistration",
	service = AopService.class
)
public class UserRegistrationLocalServiceImpl
	extends UserRegistrationLocalServiceBaseImpl {
	
	// Check existing user
	public List<UserRegistration> checkExistingUserRegistration(String fullName, String idNumber)
			throws PortalException {
		DynamicQuery _query = this.dynamicQuery();
		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (Validator.isNotNull(fullName) && !fullName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.eq("name", fullName));
		}

		if (Validator.isNotNull(idNumber) && !idNumber.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.eq("idNumber", idNumber));
		}

		_query.add(conjunction);

		List<UserRegistration> result = this.dynamicQuery(_query);
		return result;
	}

	// Add user registration
	public UserRegistration addUserRegistration(JSONObject params, ServiceContext serviceContext)
			throws PortalException {
		long userRegistrationId = counterLocalService.increment();
		UserRegistration userRegistration = userRegistrationPersistence.create(userRegistrationId);

		// Populate user registration data from params
		String name = params.getString("Name");
		userRegistration.setName(name);

		String idNumber = params.getString("IdNumber");
		userRegistration.setIdNumber(idNumber);

		String licenseNumber = params.getString("LicenseNumber");
		userRegistration.setLicenseNumber(licenseNumber);

		String address = params.getString("Address");
		userRegistration.setAddress(address);

		String postalAddress = params.getString("PostalAddress");
		userRegistration.setPostalAddress(postalAddress);

		String province = params.getString("Province");
		userRegistration.setProvince(province);

		String city = params.getString("City");
		userRegistration.setCity(city);

		String zip = params.getString("Zip");
		userRegistration.setZip(zip);

		String phone = params.getString("Phone");
		userRegistration.setPhone(phone);

		String mobilePhone = params.getString("MobilePhone");
		userRegistration.setMobilePhone(mobilePhone);

		String email = params.getString("Email");
		userRegistration.setEmail(email);

		String birthPlace = params.getString("BirthPlace");
		userRegistration.setBirthPlace(birthPlace);

		// Date of Birth
		String _dob = params.getString("Dob");
		Date dob = null;
		if (!_dob.isEmpty()) {
			SimpleDateFormat sdfDOB = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat _sdfDOB = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dateDOBMaster = sdfDOB.parse(_dob);
				String _dateDOB = _sdfDOB.format(dateDOBMaster);
				Date dateDOB = _sdfDOB.parse(_dateDOB);

				userRegistration.setDob(dateDOB);
			} catch (ParseException pe) {
				pe.printStackTrace();
			}
		}

		String gender = params.getString("Gender");
		userRegistration.setGender(gender);

		String maritalStatus = params.getString("MaritalStatus");
		userRegistration.setMaritalStatus(maritalStatus);

		String residenceStatus = params.getString("ResidenceStatus");
		userRegistration.setResidenceStatus(residenceStatus);

		int stayPeriod = params.getInt("StayPeriod");
		userRegistration.setStayPeriod(stayPeriod);

		int knowAXAFrom = params.getInt("KnowAXAFrom");
		userRegistration.setKnowAXAFrom(knowAXAFrom);
		String knowAXAFromOther = params.getString("KnowAXAFromOther");
		userRegistration.setKnowAXAFromOther(knowAXAFromOther);
		String joinReason = params.getString("JoinReason");
		userRegistration.setJoinReason(joinReason);

		// Bank, NPWP, Portfolio
		String bankName = params.getString("BankName");
		userRegistration.setBankName(bankName);
		String bankAccountName = params.getString("BankAccountName");
		userRegistration.setBankAccountName(bankAccountName);
		String bankAccountNo = params.getString("BankAccountNo");
		userRegistration.setBankAccountNo(bankAccountNo);

		String npwp = params.getString("NPWP");
		userRegistration.setNpwp(npwp);
		String npwpName = params.getString("NPWPName");
		userRegistration.setNpwpName(npwpName);

		int portfolioFire = params.getInt("Fire");
		userRegistration.setPortfolioFire(portfolioFire);
		int portfolioMotor = params.getInt("Motor");
		userRegistration.setPortfolioMotor(portfolioMotor);
		int portfolioMarine = params.getInt("Marine");
		userRegistration.setPortfolioMarine(portfolioMarine);
		int portfolioHealth = params.getInt("Health");
		userRegistration.setPortfolioHealth(portfolioHealth);
		int portfolioOther = params.getInt("Other");
		userRegistration.setPortfolioOther(portfolioOther);

		int targetFire = params.getInt("TargetFire");
		userRegistration.setTargetFire(targetFire);
		int targetMotor = params.getInt("TargetMotor");
		userRegistration.setTargetMotor(targetMotor);
		int targetMarine = params.getInt("TargetMarine");
		userRegistration.setTargetMarine(targetMarine);
		int targetHealth = params.getInt("TargetHealth");
		userRegistration.setTargetHealth(targetHealth);
		int targetOther = params.getInt("TargetOther");
		userRegistration.setTargetOther(targetOther);

		long annualPremiIncome = params.getLong("AnnualPremiIncome");
		userRegistration.setAnnualPremiIncome(annualPremiIncome);
		int targetCase = params.getInt("TargetCase");
		userRegistration.setTargetCase(targetCase);
		long targetPremi = params.getLong("TargetPremi");
		userRegistration.setTargetPremi(targetPremi);
		String prospectSource = params.getString("ProspectSource");
		userRegistration.setProspectSource(prospectSource);
		int agentAFI = params.getInt("AgentAFI");
		userRegistration.setAgentAFI(agentAFI);
		int tnc = params.getInt("TnC");
		userRegistration.setTnc(tnc);
		int otherInsuranceJob = params.getInt("OtherInsuranceJob");
		userRegistration.setOtherInsuranceJob(otherInsuranceJob);

		int activeStatus = Integer.valueOf("1");
		userRegistration.setActive(activeStatus);

		userRegistrationPersistence.update(userRegistration);

		return userRegistration;
	}

	public UserRegistration setActive(long userId, long userRegistrationId, int active, ServiceContext serviceContext)
			throws PortalException {
		UserRegistration userRegistration = null;

		try {
			userRegistration = userRegistrationPersistence.findByPrimaryKey(userRegistrationId);
			Date now = new Date();
			userRegistration.setUserRegistrationId(userRegistrationId);
			userRegistration.setActive(active);
			userRegistration.setModifiedDate(serviceContext.getModifiedDate(now));

			userRegistrationPersistence.update(userRegistration);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userRegistration;
	}	
}