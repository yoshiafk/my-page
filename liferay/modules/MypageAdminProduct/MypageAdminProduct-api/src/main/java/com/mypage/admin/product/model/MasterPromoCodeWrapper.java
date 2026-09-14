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

package com.mypage.admin.product.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MasterPromoCode}.
 * </p>
 *
 * @author Gositus Team
 * @see MasterPromoCode
 * @generated
 */
public class MasterPromoCodeWrapper
	extends BaseModelWrapper<MasterPromoCode>
	implements MasterPromoCode, ModelWrapper<MasterPromoCode> {

	public MasterPromoCodeWrapper(MasterPromoCode masterPromoCode) {
		super(masterPromoCode);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("promoCodeId", getPromoCodeId());
		attributes.put("isDefault", getIsDefault());
		attributes.put("productCode", getProductCode());
		attributes.put("productName", getProductName());
		attributes.put("promoType", getPromoType());
		attributes.put("promoCode", getPromoCode());
		attributes.put("discount", getDiscount());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("activeDay", getActiveDay());
		attributes.put("limit", getLimit());
		attributes.put("network", getNetwork());
		attributes.put("channel", getChannel());
		attributes.put("isB2C", getIsB2C());
		attributes.put("isB2B2C", getIsB2B2C());
		attributes.put("isB2B", getIsB2B());
		attributes.put("payment", getPayment());
		attributes.put("birthdayMonth", getBirthdayMonth());
		attributes.put("remarks", getRemarks());
		attributes.put("mypageUserId", getMypageUserId());
		attributes.put("agentName", getAgentName());
		attributes.put("deptoreCode", getDeptoreCode());
		attributes.put("commission", getCommission());
		attributes.put("plan_", getPlan_());
		attributes.put("promoCodeTerms", getPromoCodeTerms());
		attributes.put("travellerType", getTravellerType());
		attributes.put("utmId", getUtmId());
		attributes.put("paymentChannelId", getPaymentChannelId());
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
		Long promoCodeId = (Long)attributes.get("promoCodeId");

		if (promoCodeId != null) {
			setPromoCodeId(promoCodeId);
		}

		Integer isDefault = (Integer)attributes.get("isDefault");

		if (isDefault != null) {
			setIsDefault(isDefault);
		}

		String productCode = (String)attributes.get("productCode");

		if (productCode != null) {
			setProductCode(productCode);
		}

		String productName = (String)attributes.get("productName");

		if (productName != null) {
			setProductName(productName);
		}

		String promoType = (String)attributes.get("promoType");

		if (promoType != null) {
			setPromoType(promoType);
		}

		String promoCode = (String)attributes.get("promoCode");

		if (promoCode != null) {
			setPromoCode(promoCode);
		}

		Double discount = (Double)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String activeDay = (String)attributes.get("activeDay");

		if (activeDay != null) {
			setActiveDay(activeDay);
		}

		String limit = (String)attributes.get("limit");

		if (limit != null) {
			setLimit(limit);
		}

		String network = (String)attributes.get("network");

		if (network != null) {
			setNetwork(network);
		}

		String channel = (String)attributes.get("channel");

		if (channel != null) {
			setChannel(channel);
		}

		Integer isB2C = (Integer)attributes.get("isB2C");

		if (isB2C != null) {
			setIsB2C(isB2C);
		}

		Integer isB2B2C = (Integer)attributes.get("isB2B2C");

		if (isB2B2C != null) {
			setIsB2B2C(isB2B2C);
		}

		Integer isB2B = (Integer)attributes.get("isB2B");

		if (isB2B != null) {
			setIsB2B(isB2B);
		}

		String payment = (String)attributes.get("payment");

		if (payment != null) {
			setPayment(payment);
		}

		String birthdayMonth = (String)attributes.get("birthdayMonth");

		if (birthdayMonth != null) {
			setBirthdayMonth(birthdayMonth);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		Long mypageUserId = (Long)attributes.get("mypageUserId");

		if (mypageUserId != null) {
			setMypageUserId(mypageUserId);
		}

		String agentName = (String)attributes.get("agentName");

		if (agentName != null) {
			setAgentName(agentName);
		}

		String deptoreCode = (String)attributes.get("deptoreCode");

		if (deptoreCode != null) {
			setDeptoreCode(deptoreCode);
		}

		String commission = (String)attributes.get("commission");

		if (commission != null) {
			setCommission(commission);
		}

		String plan_ = (String)attributes.get("plan_");

		if (plan_ != null) {
			setPlan_(plan_);
		}

		String promoCodeTerms = (String)attributes.get("promoCodeTerms");

		if (promoCodeTerms != null) {
			setPromoCodeTerms(promoCodeTerms);
		}

		String travellerType = (String)attributes.get("travellerType");

		if (travellerType != null) {
			setTravellerType(travellerType);
		}

		String utmId = (String)attributes.get("utmId");

		if (utmId != null) {
			setUtmId(utmId);
		}

		String paymentChannelId = (String)attributes.get("paymentChannelId");

		if (paymentChannelId != null) {
			setPaymentChannelId(paymentChannelId);
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
	 * Returns the active of this master promo code.
	 *
	 * @return the active of this master promo code
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the active day of this master promo code.
	 *
	 * @return the active day of this master promo code
	 */
	@Override
	public String getActiveDay() {
		return model.getActiveDay();
	}

	/**
	 * Returns the agent name of this master promo code.
	 *
	 * @return the agent name of this master promo code
	 */
	@Override
	public String getAgentName() {
		return model.getAgentName();
	}

	/**
	 * Returns the birthday month of this master promo code.
	 *
	 * @return the birthday month of this master promo code
	 */
	@Override
	public String getBirthdayMonth() {
		return model.getBirthdayMonth();
	}

	/**
	 * Returns the channel of this master promo code.
	 *
	 * @return the channel of this master promo code
	 */
	@Override
	public String getChannel() {
		return model.getChannel();
	}

	/**
	 * Returns the commission of this master promo code.
	 *
	 * @return the commission of this master promo code
	 */
	@Override
	public String getCommission() {
		return model.getCommission();
	}

	/**
	 * Returns the company ID of this master promo code.
	 *
	 * @return the company ID of this master promo code
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this master promo code.
	 *
	 * @return the create date of this master promo code
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deptore code of this master promo code.
	 *
	 * @return the deptore code of this master promo code
	 */
	@Override
	public String getDeptoreCode() {
		return model.getDeptoreCode();
	}

	/**
	 * Returns the discount of this master promo code.
	 *
	 * @return the discount of this master promo code
	 */
	@Override
	public double getDiscount() {
		return model.getDiscount();
	}

	/**
	 * Returns the end date of this master promo code.
	 *
	 * @return the end date of this master promo code
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the group ID of this master promo code.
	 *
	 * @return the group ID of this master promo code
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is b2b of this master promo code.
	 *
	 * @return the is b2b of this master promo code
	 */
	@Override
	public int getIsB2B() {
		return model.getIsB2B();
	}

	/**
	 * Returns the is b2b2c of this master promo code.
	 *
	 * @return the is b2b2c of this master promo code
	 */
	@Override
	public int getIsB2B2C() {
		return model.getIsB2B2C();
	}

	/**
	 * Returns the is b2c of this master promo code.
	 *
	 * @return the is b2c of this master promo code
	 */
	@Override
	public int getIsB2C() {
		return model.getIsB2C();
	}

	/**
	 * Returns the is default of this master promo code.
	 *
	 * @return the is default of this master promo code
	 */
	@Override
	public int getIsDefault() {
		return model.getIsDefault();
	}

	/**
	 * Returns the limit of this master promo code.
	 *
	 * @return the limit of this master promo code
	 */
	@Override
	public String getLimit() {
		return model.getLimit();
	}

	/**
	 * Returns the modified date of this master promo code.
	 *
	 * @return the modified date of this master promo code
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mypage user ID of this master promo code.
	 *
	 * @return the mypage user ID of this master promo code
	 */
	@Override
	public long getMypageUserId() {
		return model.getMypageUserId();
	}

	/**
	 * Returns the mypage user uuid of this master promo code.
	 *
	 * @return the mypage user uuid of this master promo code
	 */
	@Override
	public String getMypageUserUuid() {
		return model.getMypageUserUuid();
	}

	/**
	 * Returns the network of this master promo code.
	 *
	 * @return the network of this master promo code
	 */
	@Override
	public String getNetwork() {
		return model.getNetwork();
	}

	/**
	 * Returns the payment of this master promo code.
	 *
	 * @return the payment of this master promo code
	 */
	@Override
	public String getPayment() {
		return model.getPayment();
	}

	/**
	 * Returns the payment channel ID of this master promo code.
	 *
	 * @return the payment channel ID of this master promo code
	 */
	@Override
	public String getPaymentChannelId() {
		return model.getPaymentChannelId();
	}

	/**
	 * Returns the plan_ of this master promo code.
	 *
	 * @return the plan_ of this master promo code
	 */
	@Override
	public String getPlan_() {
		return model.getPlan_();
	}

	/**
	 * Returns the primary key of this master promo code.
	 *
	 * @return the primary key of this master promo code
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product code of this master promo code.
	 *
	 * @return the product code of this master promo code
	 */
	@Override
	public String getProductCode() {
		return model.getProductCode();
	}

	/**
	 * Returns the product name of this master promo code.
	 *
	 * @return the product name of this master promo code
	 */
	@Override
	public String getProductName() {
		return model.getProductName();
	}

	/**
	 * Returns the promo code of this master promo code.
	 *
	 * @return the promo code of this master promo code
	 */
	@Override
	public String getPromoCode() {
		return model.getPromoCode();
	}

	/**
	 * Returns the promo code ID of this master promo code.
	 *
	 * @return the promo code ID of this master promo code
	 */
	@Override
	public long getPromoCodeId() {
		return model.getPromoCodeId();
	}

	/**
	 * Returns the promo code terms of this master promo code.
	 *
	 * @return the promo code terms of this master promo code
	 */
	@Override
	public String getPromoCodeTerms() {
		return model.getPromoCodeTerms();
	}

	/**
	 * Returns the promo type of this master promo code.
	 *
	 * @return the promo type of this master promo code
	 */
	@Override
	public String getPromoType() {
		return model.getPromoType();
	}

	/**
	 * Returns the remarks of this master promo code.
	 *
	 * @return the remarks of this master promo code
	 */
	@Override
	public String getRemarks() {
		return model.getRemarks();
	}

	/**
	 * Returns the start date of this master promo code.
	 *
	 * @return the start date of this master promo code
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the traveller type of this master promo code.
	 *
	 * @return the traveller type of this master promo code
	 */
	@Override
	public String getTravellerType() {
		return model.getTravellerType();
	}

	/**
	 * Returns the user ID of this master promo code.
	 *
	 * @return the user ID of this master promo code
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this master promo code.
	 *
	 * @return the user name of this master promo code
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this master promo code.
	 *
	 * @return the user uuid of this master promo code
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the utm ID of this master promo code.
	 *
	 * @return the utm ID of this master promo code
	 */
	@Override
	public String getUtmId() {
		return model.getUtmId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this master promo code.
	 *
	 * @param active the active of this master promo code
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the active day of this master promo code.
	 *
	 * @param activeDay the active day of this master promo code
	 */
	@Override
	public void setActiveDay(String activeDay) {
		model.setActiveDay(activeDay);
	}

	/**
	 * Sets the agent name of this master promo code.
	 *
	 * @param agentName the agent name of this master promo code
	 */
	@Override
	public void setAgentName(String agentName) {
		model.setAgentName(agentName);
	}

	/**
	 * Sets the birthday month of this master promo code.
	 *
	 * @param birthdayMonth the birthday month of this master promo code
	 */
	@Override
	public void setBirthdayMonth(String birthdayMonth) {
		model.setBirthdayMonth(birthdayMonth);
	}

	/**
	 * Sets the channel of this master promo code.
	 *
	 * @param channel the channel of this master promo code
	 */
	@Override
	public void setChannel(String channel) {
		model.setChannel(channel);
	}

	/**
	 * Sets the commission of this master promo code.
	 *
	 * @param commission the commission of this master promo code
	 */
	@Override
	public void setCommission(String commission) {
		model.setCommission(commission);
	}

	/**
	 * Sets the company ID of this master promo code.
	 *
	 * @param companyId the company ID of this master promo code
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this master promo code.
	 *
	 * @param createDate the create date of this master promo code
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the deptore code of this master promo code.
	 *
	 * @param deptoreCode the deptore code of this master promo code
	 */
	@Override
	public void setDeptoreCode(String deptoreCode) {
		model.setDeptoreCode(deptoreCode);
	}

	/**
	 * Sets the discount of this master promo code.
	 *
	 * @param discount the discount of this master promo code
	 */
	@Override
	public void setDiscount(double discount) {
		model.setDiscount(discount);
	}

	/**
	 * Sets the end date of this master promo code.
	 *
	 * @param endDate the end date of this master promo code
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the group ID of this master promo code.
	 *
	 * @param groupId the group ID of this master promo code
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the is b2b of this master promo code.
	 *
	 * @param isB2B the is b2b of this master promo code
	 */
	@Override
	public void setIsB2B(int isB2B) {
		model.setIsB2B(isB2B);
	}

	/**
	 * Sets the is b2b2c of this master promo code.
	 *
	 * @param isB2B2C the is b2b2c of this master promo code
	 */
	@Override
	public void setIsB2B2C(int isB2B2C) {
		model.setIsB2B2C(isB2B2C);
	}

	/**
	 * Sets the is b2c of this master promo code.
	 *
	 * @param isB2C the is b2c of this master promo code
	 */
	@Override
	public void setIsB2C(int isB2C) {
		model.setIsB2C(isB2C);
	}

	/**
	 * Sets the is default of this master promo code.
	 *
	 * @param isDefault the is default of this master promo code
	 */
	@Override
	public void setIsDefault(int isDefault) {
		model.setIsDefault(isDefault);
	}

	/**
	 * Sets the limit of this master promo code.
	 *
	 * @param limit the limit of this master promo code
	 */
	@Override
	public void setLimit(String limit) {
		model.setLimit(limit);
	}

	/**
	 * Sets the modified date of this master promo code.
	 *
	 * @param modifiedDate the modified date of this master promo code
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mypage user ID of this master promo code.
	 *
	 * @param mypageUserId the mypage user ID of this master promo code
	 */
	@Override
	public void setMypageUserId(long mypageUserId) {
		model.setMypageUserId(mypageUserId);
	}

	/**
	 * Sets the mypage user uuid of this master promo code.
	 *
	 * @param mypageUserUuid the mypage user uuid of this master promo code
	 */
	@Override
	public void setMypageUserUuid(String mypageUserUuid) {
		model.setMypageUserUuid(mypageUserUuid);
	}

	/**
	 * Sets the network of this master promo code.
	 *
	 * @param network the network of this master promo code
	 */
	@Override
	public void setNetwork(String network) {
		model.setNetwork(network);
	}

	/**
	 * Sets the payment of this master promo code.
	 *
	 * @param payment the payment of this master promo code
	 */
	@Override
	public void setPayment(String payment) {
		model.setPayment(payment);
	}

	/**
	 * Sets the payment channel ID of this master promo code.
	 *
	 * @param paymentChannelId the payment channel ID of this master promo code
	 */
	@Override
	public void setPaymentChannelId(String paymentChannelId) {
		model.setPaymentChannelId(paymentChannelId);
	}

	/**
	 * Sets the plan_ of this master promo code.
	 *
	 * @param plan_ the plan_ of this master promo code
	 */
	@Override
	public void setPlan_(String plan_) {
		model.setPlan_(plan_);
	}

	/**
	 * Sets the primary key of this master promo code.
	 *
	 * @param primaryKey the primary key of this master promo code
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product code of this master promo code.
	 *
	 * @param productCode the product code of this master promo code
	 */
	@Override
	public void setProductCode(String productCode) {
		model.setProductCode(productCode);
	}

	/**
	 * Sets the product name of this master promo code.
	 *
	 * @param productName the product name of this master promo code
	 */
	@Override
	public void setProductName(String productName) {
		model.setProductName(productName);
	}

	/**
	 * Sets the promo code of this master promo code.
	 *
	 * @param promoCode the promo code of this master promo code
	 */
	@Override
	public void setPromoCode(String promoCode) {
		model.setPromoCode(promoCode);
	}

	/**
	 * Sets the promo code ID of this master promo code.
	 *
	 * @param promoCodeId the promo code ID of this master promo code
	 */
	@Override
	public void setPromoCodeId(long promoCodeId) {
		model.setPromoCodeId(promoCodeId);
	}

	/**
	 * Sets the promo code terms of this master promo code.
	 *
	 * @param promoCodeTerms the promo code terms of this master promo code
	 */
	@Override
	public void setPromoCodeTerms(String promoCodeTerms) {
		model.setPromoCodeTerms(promoCodeTerms);
	}

	/**
	 * Sets the promo type of this master promo code.
	 *
	 * @param promoType the promo type of this master promo code
	 */
	@Override
	public void setPromoType(String promoType) {
		model.setPromoType(promoType);
	}

	/**
	 * Sets the remarks of this master promo code.
	 *
	 * @param remarks the remarks of this master promo code
	 */
	@Override
	public void setRemarks(String remarks) {
		model.setRemarks(remarks);
	}

	/**
	 * Sets the start date of this master promo code.
	 *
	 * @param startDate the start date of this master promo code
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the traveller type of this master promo code.
	 *
	 * @param travellerType the traveller type of this master promo code
	 */
	@Override
	public void setTravellerType(String travellerType) {
		model.setTravellerType(travellerType);
	}

	/**
	 * Sets the user ID of this master promo code.
	 *
	 * @param userId the user ID of this master promo code
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this master promo code.
	 *
	 * @param userName the user name of this master promo code
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this master promo code.
	 *
	 * @param userUuid the user uuid of this master promo code
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the utm ID of this master promo code.
	 *
	 * @param utmId the utm ID of this master promo code
	 */
	@Override
	public void setUtmId(String utmId) {
		model.setUtmId(utmId);
	}

	@Override
	protected MasterPromoCodeWrapper wrap(MasterPromoCode masterPromoCode) {
		return new MasterPromoCodeWrapper(masterPromoCode);
	}

}