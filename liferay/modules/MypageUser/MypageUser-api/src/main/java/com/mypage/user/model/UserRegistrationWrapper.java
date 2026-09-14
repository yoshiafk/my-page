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

package com.mypage.user.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistration
 * @generated
 */
public class UserRegistrationWrapper
	extends BaseModelWrapper<UserRegistration>
	implements ModelWrapper<UserRegistration>, UserRegistration {

	public UserRegistrationWrapper(UserRegistration userRegistration) {
		super(userRegistration);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userRegistrationId", getUserRegistrationId());
		attributes.put("name", getName());
		attributes.put("idNumber", getIdNumber());
		attributes.put("licenseNumber", getLicenseNumber());
		attributes.put("address", getAddress());
		attributes.put("postalAddress", getPostalAddress());
		attributes.put("province", getProvince());
		attributes.put("city", getCity());
		attributes.put("zip", getZip());
		attributes.put("phone", getPhone());
		attributes.put("mobilePhone", getMobilePhone());
		attributes.put("email", getEmail());
		attributes.put("birthPlace", getBirthPlace());
		attributes.put("dob", getDob());
		attributes.put("gender", getGender());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("residenceStatus", getResidenceStatus());
		attributes.put("stayPeriod", getStayPeriod());
		attributes.put("knowAXAFrom", getKnowAXAFrom());
		attributes.put("knowAXAFromOther", getKnowAXAFromOther());
		attributes.put("joinReason", getJoinReason());
		attributes.put("bankName", getBankName());
		attributes.put("bankAccountName", getBankAccountName());
		attributes.put("bankAccountNo", getBankAccountNo());
		attributes.put("npwp", getNpwp());
		attributes.put("npwpName", getNpwpName());
		attributes.put("portfolioFire", getPortfolioFire());
		attributes.put("portfolioMotor", getPortfolioMotor());
		attributes.put("portfolioMarine", getPortfolioMarine());
		attributes.put("portfolioHealth", getPortfolioHealth());
		attributes.put("portfolioOther", getPortfolioOther());
		attributes.put("targetFire", getTargetFire());
		attributes.put("targetMotor", getTargetMotor());
		attributes.put("targetMarine", getTargetMarine());
		attributes.put("targetHealth", getTargetHealth());
		attributes.put("targetOther", getTargetOther());
		attributes.put("annualPremiIncome", getAnnualPremiIncome());
		attributes.put("targetCase", getTargetCase());
		attributes.put("targetPremi", getTargetPremi());
		attributes.put("prospectSource", getProspectSource());
		attributes.put("otherInsuranceJob", getOtherInsuranceJob());
		attributes.put("tnc", getTnc());
		attributes.put("agentAFI", getAgentAFI());
		attributes.put("sentToMAS", getSentToMAS());
		attributes.put("approved", getApproved());
		attributes.put("active", getActive());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userRegistrationId = (Long)attributes.get("userRegistrationId");

		if (userRegistrationId != null) {
			setUserRegistrationId(userRegistrationId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String idNumber = (String)attributes.get("idNumber");

		if (idNumber != null) {
			setIdNumber(idNumber);
		}

		String licenseNumber = (String)attributes.get("licenseNumber");

		if (licenseNumber != null) {
			setLicenseNumber(licenseNumber);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String postalAddress = (String)attributes.get("postalAddress");

		if (postalAddress != null) {
			setPostalAddress(postalAddress);
		}

		String province = (String)attributes.get("province");

		if (province != null) {
			setProvince(province);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String zip = (String)attributes.get("zip");

		if (zip != null) {
			setZip(zip);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String mobilePhone = (String)attributes.get("mobilePhone");

		if (mobilePhone != null) {
			setMobilePhone(mobilePhone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String birthPlace = (String)attributes.get("birthPlace");

		if (birthPlace != null) {
			setBirthPlace(birthPlace);
		}

		Date dob = (Date)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String maritalStatus = (String)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		String residenceStatus = (String)attributes.get("residenceStatus");

		if (residenceStatus != null) {
			setResidenceStatus(residenceStatus);
		}

		Integer stayPeriod = (Integer)attributes.get("stayPeriod");

		if (stayPeriod != null) {
			setStayPeriod(stayPeriod);
		}

		Integer knowAXAFrom = (Integer)attributes.get("knowAXAFrom");

		if (knowAXAFrom != null) {
			setKnowAXAFrom(knowAXAFrom);
		}

		String knowAXAFromOther = (String)attributes.get("knowAXAFromOther");

		if (knowAXAFromOther != null) {
			setKnowAXAFromOther(knowAXAFromOther);
		}

		String joinReason = (String)attributes.get("joinReason");

		if (joinReason != null) {
			setJoinReason(joinReason);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
		}

		String bankAccountName = (String)attributes.get("bankAccountName");

		if (bankAccountName != null) {
			setBankAccountName(bankAccountName);
		}

		String bankAccountNo = (String)attributes.get("bankAccountNo");

		if (bankAccountNo != null) {
			setBankAccountNo(bankAccountNo);
		}

		String npwp = (String)attributes.get("npwp");

		if (npwp != null) {
			setNpwp(npwp);
		}

		String npwpName = (String)attributes.get("npwpName");

		if (npwpName != null) {
			setNpwpName(npwpName);
		}

		Integer portfolioFire = (Integer)attributes.get("portfolioFire");

		if (portfolioFire != null) {
			setPortfolioFire(portfolioFire);
		}

		Integer portfolioMotor = (Integer)attributes.get("portfolioMotor");

		if (portfolioMotor != null) {
			setPortfolioMotor(portfolioMotor);
		}

		Integer portfolioMarine = (Integer)attributes.get("portfolioMarine");

		if (portfolioMarine != null) {
			setPortfolioMarine(portfolioMarine);
		}

		Integer portfolioHealth = (Integer)attributes.get("portfolioHealth");

		if (portfolioHealth != null) {
			setPortfolioHealth(portfolioHealth);
		}

		Integer portfolioOther = (Integer)attributes.get("portfolioOther");

		if (portfolioOther != null) {
			setPortfolioOther(portfolioOther);
		}

		Integer targetFire = (Integer)attributes.get("targetFire");

		if (targetFire != null) {
			setTargetFire(targetFire);
		}

		Integer targetMotor = (Integer)attributes.get("targetMotor");

		if (targetMotor != null) {
			setTargetMotor(targetMotor);
		}

		Integer targetMarine = (Integer)attributes.get("targetMarine");

		if (targetMarine != null) {
			setTargetMarine(targetMarine);
		}

		Integer targetHealth = (Integer)attributes.get("targetHealth");

		if (targetHealth != null) {
			setTargetHealth(targetHealth);
		}

		Integer targetOther = (Integer)attributes.get("targetOther");

		if (targetOther != null) {
			setTargetOther(targetOther);
		}

		Long annualPremiIncome = (Long)attributes.get("annualPremiIncome");

		if (annualPremiIncome != null) {
			setAnnualPremiIncome(annualPremiIncome);
		}

		Integer targetCase = (Integer)attributes.get("targetCase");

		if (targetCase != null) {
			setTargetCase(targetCase);
		}

		Long targetPremi = (Long)attributes.get("targetPremi");

		if (targetPremi != null) {
			setTargetPremi(targetPremi);
		}

		String prospectSource = (String)attributes.get("prospectSource");

		if (prospectSource != null) {
			setProspectSource(prospectSource);
		}

		Integer otherInsuranceJob = (Integer)attributes.get(
			"otherInsuranceJob");

		if (otherInsuranceJob != null) {
			setOtherInsuranceJob(otherInsuranceJob);
		}

		Integer tnc = (Integer)attributes.get("tnc");

		if (tnc != null) {
			setTnc(tnc);
		}

		Integer agentAFI = (Integer)attributes.get("agentAFI");

		if (agentAFI != null) {
			setAgentAFI(agentAFI);
		}

		Integer sentToMAS = (Integer)attributes.get("sentToMAS");

		if (sentToMAS != null) {
			setSentToMAS(sentToMAS);
		}

		Integer approved = (Integer)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the active of this user registration.
	 *
	 * @return the active of this user registration
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the address of this user registration.
	 *
	 * @return the address of this user registration
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the agent afi of this user registration.
	 *
	 * @return the agent afi of this user registration
	 */
	@Override
	public int getAgentAFI() {
		return model.getAgentAFI();
	}

	/**
	 * Returns the annual premi income of this user registration.
	 *
	 * @return the annual premi income of this user registration
	 */
	@Override
	public long getAnnualPremiIncome() {
		return model.getAnnualPremiIncome();
	}

	/**
	 * Returns the approved of this user registration.
	 *
	 * @return the approved of this user registration
	 */
	@Override
	public int getApproved() {
		return model.getApproved();
	}

	/**
	 * Returns the bank account name of this user registration.
	 *
	 * @return the bank account name of this user registration
	 */
	@Override
	public String getBankAccountName() {
		return model.getBankAccountName();
	}

	/**
	 * Returns the bank account no of this user registration.
	 *
	 * @return the bank account no of this user registration
	 */
	@Override
	public String getBankAccountNo() {
		return model.getBankAccountNo();
	}

	/**
	 * Returns the bank name of this user registration.
	 *
	 * @return the bank name of this user registration
	 */
	@Override
	public String getBankName() {
		return model.getBankName();
	}

	/**
	 * Returns the birth place of this user registration.
	 *
	 * @return the birth place of this user registration
	 */
	@Override
	public String getBirthPlace() {
		return model.getBirthPlace();
	}

	/**
	 * Returns the city of this user registration.
	 *
	 * @return the city of this user registration
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the company ID of this user registration.
	 *
	 * @return the company ID of this user registration
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this user registration.
	 *
	 * @return the create date of this user registration
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the dob of this user registration.
	 *
	 * @return the dob of this user registration
	 */
	@Override
	public Date getDob() {
		return model.getDob();
	}

	/**
	 * Returns the email of this user registration.
	 *
	 * @return the email of this user registration
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the gender of this user registration.
	 *
	 * @return the gender of this user registration
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this user registration.
	 *
	 * @return the group ID of this user registration
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the id number of this user registration.
	 *
	 * @return the id number of this user registration
	 */
	@Override
	public String getIdNumber() {
		return model.getIdNumber();
	}

	/**
	 * Returns the join reason of this user registration.
	 *
	 * @return the join reason of this user registration
	 */
	@Override
	public String getJoinReason() {
		return model.getJoinReason();
	}

	/**
	 * Returns the know axa from of this user registration.
	 *
	 * @return the know axa from of this user registration
	 */
	@Override
	public int getKnowAXAFrom() {
		return model.getKnowAXAFrom();
	}

	/**
	 * Returns the know axa from other of this user registration.
	 *
	 * @return the know axa from other of this user registration
	 */
	@Override
	public String getKnowAXAFromOther() {
		return model.getKnowAXAFromOther();
	}

	/**
	 * Returns the license number of this user registration.
	 *
	 * @return the license number of this user registration
	 */
	@Override
	public String getLicenseNumber() {
		return model.getLicenseNumber();
	}

	/**
	 * Returns the marital status of this user registration.
	 *
	 * @return the marital status of this user registration
	 */
	@Override
	public String getMaritalStatus() {
		return model.getMaritalStatus();
	}

	/**
	 * Returns the mobile phone of this user registration.
	 *
	 * @return the mobile phone of this user registration
	 */
	@Override
	public String getMobilePhone() {
		return model.getMobilePhone();
	}

	/**
	 * Returns the modified date of this user registration.
	 *
	 * @return the modified date of this user registration
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this user registration.
	 *
	 * @return the name of this user registration
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the npwp of this user registration.
	 *
	 * @return the npwp of this user registration
	 */
	@Override
	public String getNpwp() {
		return model.getNpwp();
	}

	/**
	 * Returns the npwp name of this user registration.
	 *
	 * @return the npwp name of this user registration
	 */
	@Override
	public String getNpwpName() {
		return model.getNpwpName();
	}

	/**
	 * Returns the other insurance job of this user registration.
	 *
	 * @return the other insurance job of this user registration
	 */
	@Override
	public int getOtherInsuranceJob() {
		return model.getOtherInsuranceJob();
	}

	/**
	 * Returns the phone of this user registration.
	 *
	 * @return the phone of this user registration
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the portfolio fire of this user registration.
	 *
	 * @return the portfolio fire of this user registration
	 */
	@Override
	public int getPortfolioFire() {
		return model.getPortfolioFire();
	}

	/**
	 * Returns the portfolio health of this user registration.
	 *
	 * @return the portfolio health of this user registration
	 */
	@Override
	public int getPortfolioHealth() {
		return model.getPortfolioHealth();
	}

	/**
	 * Returns the portfolio marine of this user registration.
	 *
	 * @return the portfolio marine of this user registration
	 */
	@Override
	public int getPortfolioMarine() {
		return model.getPortfolioMarine();
	}

	/**
	 * Returns the portfolio motor of this user registration.
	 *
	 * @return the portfolio motor of this user registration
	 */
	@Override
	public int getPortfolioMotor() {
		return model.getPortfolioMotor();
	}

	/**
	 * Returns the portfolio other of this user registration.
	 *
	 * @return the portfolio other of this user registration
	 */
	@Override
	public int getPortfolioOther() {
		return model.getPortfolioOther();
	}

	/**
	 * Returns the postal address of this user registration.
	 *
	 * @return the postal address of this user registration
	 */
	@Override
	public String getPostalAddress() {
		return model.getPostalAddress();
	}

	/**
	 * Returns the primary key of this user registration.
	 *
	 * @return the primary key of this user registration
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the prospect source of this user registration.
	 *
	 * @return the prospect source of this user registration
	 */
	@Override
	public String getProspectSource() {
		return model.getProspectSource();
	}

	/**
	 * Returns the province of this user registration.
	 *
	 * @return the province of this user registration
	 */
	@Override
	public String getProvince() {
		return model.getProvince();
	}

	/**
	 * Returns the residence status of this user registration.
	 *
	 * @return the residence status of this user registration
	 */
	@Override
	public String getResidenceStatus() {
		return model.getResidenceStatus();
	}

	/**
	 * Returns the sent to mas of this user registration.
	 *
	 * @return the sent to mas of this user registration
	 */
	@Override
	public int getSentToMAS() {
		return model.getSentToMAS();
	}

	/**
	 * Returns the stay period of this user registration.
	 *
	 * @return the stay period of this user registration
	 */
	@Override
	public int getStayPeriod() {
		return model.getStayPeriod();
	}

	/**
	 * Returns the target case of this user registration.
	 *
	 * @return the target case of this user registration
	 */
	@Override
	public int getTargetCase() {
		return model.getTargetCase();
	}

	/**
	 * Returns the target fire of this user registration.
	 *
	 * @return the target fire of this user registration
	 */
	@Override
	public int getTargetFire() {
		return model.getTargetFire();
	}

	/**
	 * Returns the target health of this user registration.
	 *
	 * @return the target health of this user registration
	 */
	@Override
	public int getTargetHealth() {
		return model.getTargetHealth();
	}

	/**
	 * Returns the target marine of this user registration.
	 *
	 * @return the target marine of this user registration
	 */
	@Override
	public int getTargetMarine() {
		return model.getTargetMarine();
	}

	/**
	 * Returns the target motor of this user registration.
	 *
	 * @return the target motor of this user registration
	 */
	@Override
	public int getTargetMotor() {
		return model.getTargetMotor();
	}

	/**
	 * Returns the target other of this user registration.
	 *
	 * @return the target other of this user registration
	 */
	@Override
	public int getTargetOther() {
		return model.getTargetOther();
	}

	/**
	 * Returns the target premi of this user registration.
	 *
	 * @return the target premi of this user registration
	 */
	@Override
	public long getTargetPremi() {
		return model.getTargetPremi();
	}

	/**
	 * Returns the tnc of this user registration.
	 *
	 * @return the tnc of this user registration
	 */
	@Override
	public int getTnc() {
		return model.getTnc();
	}

	/**
	 * Returns the user ID of this user registration.
	 *
	 * @return the user ID of this user registration
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this user registration.
	 *
	 * @return the user name of this user registration
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user registration ID of this user registration.
	 *
	 * @return the user registration ID of this user registration
	 */
	@Override
	public long getUserRegistrationId() {
		return model.getUserRegistrationId();
	}

	/**
	 * Returns the user uuid of this user registration.
	 *
	 * @return the user uuid of this user registration
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the zip of this user registration.
	 *
	 * @return the zip of this user registration
	 */
	@Override
	public String getZip() {
		return model.getZip();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this user registration.
	 *
	 * @param active the active of this user registration
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the address of this user registration.
	 *
	 * @param address the address of this user registration
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the agent afi of this user registration.
	 *
	 * @param agentAFI the agent afi of this user registration
	 */
	@Override
	public void setAgentAFI(int agentAFI) {
		model.setAgentAFI(agentAFI);
	}

	/**
	 * Sets the annual premi income of this user registration.
	 *
	 * @param annualPremiIncome the annual premi income of this user registration
	 */
	@Override
	public void setAnnualPremiIncome(long annualPremiIncome) {
		model.setAnnualPremiIncome(annualPremiIncome);
	}

	/**
	 * Sets the approved of this user registration.
	 *
	 * @param approved the approved of this user registration
	 */
	@Override
	public void setApproved(int approved) {
		model.setApproved(approved);
	}

	/**
	 * Sets the bank account name of this user registration.
	 *
	 * @param bankAccountName the bank account name of this user registration
	 */
	@Override
	public void setBankAccountName(String bankAccountName) {
		model.setBankAccountName(bankAccountName);
	}

	/**
	 * Sets the bank account no of this user registration.
	 *
	 * @param bankAccountNo the bank account no of this user registration
	 */
	@Override
	public void setBankAccountNo(String bankAccountNo) {
		model.setBankAccountNo(bankAccountNo);
	}

	/**
	 * Sets the bank name of this user registration.
	 *
	 * @param bankName the bank name of this user registration
	 */
	@Override
	public void setBankName(String bankName) {
		model.setBankName(bankName);
	}

	/**
	 * Sets the birth place of this user registration.
	 *
	 * @param birthPlace the birth place of this user registration
	 */
	@Override
	public void setBirthPlace(String birthPlace) {
		model.setBirthPlace(birthPlace);
	}

	/**
	 * Sets the city of this user registration.
	 *
	 * @param city the city of this user registration
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the company ID of this user registration.
	 *
	 * @param companyId the company ID of this user registration
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this user registration.
	 *
	 * @param createDate the create date of this user registration
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the dob of this user registration.
	 *
	 * @param dob the dob of this user registration
	 */
	@Override
	public void setDob(Date dob) {
		model.setDob(dob);
	}

	/**
	 * Sets the email of this user registration.
	 *
	 * @param email the email of this user registration
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the gender of this user registration.
	 *
	 * @param gender the gender of this user registration
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this user registration.
	 *
	 * @param groupId the group ID of this user registration
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the id number of this user registration.
	 *
	 * @param idNumber the id number of this user registration
	 */
	@Override
	public void setIdNumber(String idNumber) {
		model.setIdNumber(idNumber);
	}

	/**
	 * Sets the join reason of this user registration.
	 *
	 * @param joinReason the join reason of this user registration
	 */
	@Override
	public void setJoinReason(String joinReason) {
		model.setJoinReason(joinReason);
	}

	/**
	 * Sets the know axa from of this user registration.
	 *
	 * @param knowAXAFrom the know axa from of this user registration
	 */
	@Override
	public void setKnowAXAFrom(int knowAXAFrom) {
		model.setKnowAXAFrom(knowAXAFrom);
	}

	/**
	 * Sets the know axa from other of this user registration.
	 *
	 * @param knowAXAFromOther the know axa from other of this user registration
	 */
	@Override
	public void setKnowAXAFromOther(String knowAXAFromOther) {
		model.setKnowAXAFromOther(knowAXAFromOther);
	}

	/**
	 * Sets the license number of this user registration.
	 *
	 * @param licenseNumber the license number of this user registration
	 */
	@Override
	public void setLicenseNumber(String licenseNumber) {
		model.setLicenseNumber(licenseNumber);
	}

	/**
	 * Sets the marital status of this user registration.
	 *
	 * @param maritalStatus the marital status of this user registration
	 */
	@Override
	public void setMaritalStatus(String maritalStatus) {
		model.setMaritalStatus(maritalStatus);
	}

	/**
	 * Sets the mobile phone of this user registration.
	 *
	 * @param mobilePhone the mobile phone of this user registration
	 */
	@Override
	public void setMobilePhone(String mobilePhone) {
		model.setMobilePhone(mobilePhone);
	}

	/**
	 * Sets the modified date of this user registration.
	 *
	 * @param modifiedDate the modified date of this user registration
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this user registration.
	 *
	 * @param name the name of this user registration
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the npwp of this user registration.
	 *
	 * @param npwp the npwp of this user registration
	 */
	@Override
	public void setNpwp(String npwp) {
		model.setNpwp(npwp);
	}

	/**
	 * Sets the npwp name of this user registration.
	 *
	 * @param npwpName the npwp name of this user registration
	 */
	@Override
	public void setNpwpName(String npwpName) {
		model.setNpwpName(npwpName);
	}

	/**
	 * Sets the other insurance job of this user registration.
	 *
	 * @param otherInsuranceJob the other insurance job of this user registration
	 */
	@Override
	public void setOtherInsuranceJob(int otherInsuranceJob) {
		model.setOtherInsuranceJob(otherInsuranceJob);
	}

	/**
	 * Sets the phone of this user registration.
	 *
	 * @param phone the phone of this user registration
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the portfolio fire of this user registration.
	 *
	 * @param portfolioFire the portfolio fire of this user registration
	 */
	@Override
	public void setPortfolioFire(int portfolioFire) {
		model.setPortfolioFire(portfolioFire);
	}

	/**
	 * Sets the portfolio health of this user registration.
	 *
	 * @param portfolioHealth the portfolio health of this user registration
	 */
	@Override
	public void setPortfolioHealth(int portfolioHealth) {
		model.setPortfolioHealth(portfolioHealth);
	}

	/**
	 * Sets the portfolio marine of this user registration.
	 *
	 * @param portfolioMarine the portfolio marine of this user registration
	 */
	@Override
	public void setPortfolioMarine(int portfolioMarine) {
		model.setPortfolioMarine(portfolioMarine);
	}

	/**
	 * Sets the portfolio motor of this user registration.
	 *
	 * @param portfolioMotor the portfolio motor of this user registration
	 */
	@Override
	public void setPortfolioMotor(int portfolioMotor) {
		model.setPortfolioMotor(portfolioMotor);
	}

	/**
	 * Sets the portfolio other of this user registration.
	 *
	 * @param portfolioOther the portfolio other of this user registration
	 */
	@Override
	public void setPortfolioOther(int portfolioOther) {
		model.setPortfolioOther(portfolioOther);
	}

	/**
	 * Sets the postal address of this user registration.
	 *
	 * @param postalAddress the postal address of this user registration
	 */
	@Override
	public void setPostalAddress(String postalAddress) {
		model.setPostalAddress(postalAddress);
	}

	/**
	 * Sets the primary key of this user registration.
	 *
	 * @param primaryKey the primary key of this user registration
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the prospect source of this user registration.
	 *
	 * @param prospectSource the prospect source of this user registration
	 */
	@Override
	public void setProspectSource(String prospectSource) {
		model.setProspectSource(prospectSource);
	}

	/**
	 * Sets the province of this user registration.
	 *
	 * @param province the province of this user registration
	 */
	@Override
	public void setProvince(String province) {
		model.setProvince(province);
	}

	/**
	 * Sets the residence status of this user registration.
	 *
	 * @param residenceStatus the residence status of this user registration
	 */
	@Override
	public void setResidenceStatus(String residenceStatus) {
		model.setResidenceStatus(residenceStatus);
	}

	/**
	 * Sets the sent to mas of this user registration.
	 *
	 * @param sentToMAS the sent to mas of this user registration
	 */
	@Override
	public void setSentToMAS(int sentToMAS) {
		model.setSentToMAS(sentToMAS);
	}

	/**
	 * Sets the stay period of this user registration.
	 *
	 * @param stayPeriod the stay period of this user registration
	 */
	@Override
	public void setStayPeriod(int stayPeriod) {
		model.setStayPeriod(stayPeriod);
	}

	/**
	 * Sets the target case of this user registration.
	 *
	 * @param targetCase the target case of this user registration
	 */
	@Override
	public void setTargetCase(int targetCase) {
		model.setTargetCase(targetCase);
	}

	/**
	 * Sets the target fire of this user registration.
	 *
	 * @param targetFire the target fire of this user registration
	 */
	@Override
	public void setTargetFire(int targetFire) {
		model.setTargetFire(targetFire);
	}

	/**
	 * Sets the target health of this user registration.
	 *
	 * @param targetHealth the target health of this user registration
	 */
	@Override
	public void setTargetHealth(int targetHealth) {
		model.setTargetHealth(targetHealth);
	}

	/**
	 * Sets the target marine of this user registration.
	 *
	 * @param targetMarine the target marine of this user registration
	 */
	@Override
	public void setTargetMarine(int targetMarine) {
		model.setTargetMarine(targetMarine);
	}

	/**
	 * Sets the target motor of this user registration.
	 *
	 * @param targetMotor the target motor of this user registration
	 */
	@Override
	public void setTargetMotor(int targetMotor) {
		model.setTargetMotor(targetMotor);
	}

	/**
	 * Sets the target other of this user registration.
	 *
	 * @param targetOther the target other of this user registration
	 */
	@Override
	public void setTargetOther(int targetOther) {
		model.setTargetOther(targetOther);
	}

	/**
	 * Sets the target premi of this user registration.
	 *
	 * @param targetPremi the target premi of this user registration
	 */
	@Override
	public void setTargetPremi(long targetPremi) {
		model.setTargetPremi(targetPremi);
	}

	/**
	 * Sets the tnc of this user registration.
	 *
	 * @param tnc the tnc of this user registration
	 */
	@Override
	public void setTnc(int tnc) {
		model.setTnc(tnc);
	}

	/**
	 * Sets the user ID of this user registration.
	 *
	 * @param userId the user ID of this user registration
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this user registration.
	 *
	 * @param userName the user name of this user registration
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user registration ID of this user registration.
	 *
	 * @param userRegistrationId the user registration ID of this user registration
	 */
	@Override
	public void setUserRegistrationId(long userRegistrationId) {
		model.setUserRegistrationId(userRegistrationId);
	}

	/**
	 * Sets the user uuid of this user registration.
	 *
	 * @param userUuid the user uuid of this user registration
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the zip of this user registration.
	 *
	 * @param zip the zip of this user registration
	 */
	@Override
	public void setZip(String zip) {
		model.setZip(zip);
	}

	@Override
	protected UserRegistrationWrapper wrap(UserRegistration userRegistration) {
		return new UserRegistrationWrapper(userRegistration);
	}

}