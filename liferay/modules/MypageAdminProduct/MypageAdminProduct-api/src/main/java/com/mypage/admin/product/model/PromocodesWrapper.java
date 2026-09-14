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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Promocodes}.
 * </p>
 *
 * @author Gositus Team
 * @see Promocodes
 * @generated
 */
public class PromocodesWrapper
	extends BaseModelWrapper<Promocodes>
	implements ModelWrapper<Promocodes>, Promocodes {

	public PromocodesWrapper(Promocodes promocodes) {
		super(promocodes);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("promocodeId", getPromocodeId());
		attributes.put("products", getProducts());
		attributes.put("promocode", getPromocode());
		attributes.put("commission", getCommission());
		attributes.put("discount", getDiscount());
		attributes.put("isB2C", getIsB2C());
		attributes.put("isB2B2C", getIsB2B2C());
		attributes.put("isB2B", getIsB2B());
		attributes.put("user", getUser());
		attributes.put("mypageUserId", getMypageUserId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("promoType", getPromoType());
		attributes.put("birthdayMonth", getBirthdayMonth());
		attributes.put("limit", getLimit());
		attributes.put("terms", getTerms());
		attributes.put("plan", getPlan());
		attributes.put("paymentChannel", getPaymentChannel());
		attributes.put("utmCampaignId", getUtmCampaignId());
		attributes.put("active", getActive());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long promocodeId = (Long)attributes.get("promocodeId");

		if (promocodeId != null) {
			setPromocodeId(promocodeId);
		}

		String products = (String)attributes.get("products");

		if (products != null) {
			setProducts(products);
		}

		String promocode = (String)attributes.get("promocode");

		if (promocode != null) {
			setPromocode(promocode);
		}

		Double commission = (Double)attributes.get("commission");

		if (commission != null) {
			setCommission(commission);
		}

		Double discount = (Double)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
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

		String user = (String)attributes.get("user");

		if (user != null) {
			setUser(user);
		}

		Long mypageUserId = (Long)attributes.get("mypageUserId");

		if (mypageUserId != null) {
			setMypageUserId(mypageUserId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String promoType = (String)attributes.get("promoType");

		if (promoType != null) {
			setPromoType(promoType);
		}

		Date birthdayMonth = (Date)attributes.get("birthdayMonth");

		if (birthdayMonth != null) {
			setBirthdayMonth(birthdayMonth);
		}

		Integer limit = (Integer)attributes.get("limit");

		if (limit != null) {
			setLimit(limit);
		}

		String terms = (String)attributes.get("terms");

		if (terms != null) {
			setTerms(terms);
		}

		String plan = (String)attributes.get("plan");

		if (plan != null) {
			setPlan(plan);
		}

		String paymentChannel = (String)attributes.get("paymentChannel");

		if (paymentChannel != null) {
			setPaymentChannel(paymentChannel);
		}

		String utmCampaignId = (String)attributes.get("utmCampaignId");

		if (utmCampaignId != null) {
			setUtmCampaignId(utmCampaignId);
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

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	/**
	 * Returns the active of this promocodes.
	 *
	 * @return the active of this promocodes
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the birthday month of this promocodes.
	 *
	 * @return the birthday month of this promocodes
	 */
	@Override
	public Date getBirthdayMonth() {
		return model.getBirthdayMonth();
	}

	/**
	 * Returns the commission of this promocodes.
	 *
	 * @return the commission of this promocodes
	 */
	@Override
	public double getCommission() {
		return model.getCommission();
	}

	/**
	 * Returns the company ID of this promocodes.
	 *
	 * @return the company ID of this promocodes
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this promocodes.
	 *
	 * @return the create date of this promocodes
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the discount of this promocodes.
	 *
	 * @return the discount of this promocodes
	 */
	@Override
	public double getDiscount() {
		return model.getDiscount();
	}

	/**
	 * Returns the end date of this promocodes.
	 *
	 * @return the end date of this promocodes
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the group ID of this promocodes.
	 *
	 * @return the group ID of this promocodes
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is b2b of this promocodes.
	 *
	 * @return the is b2b of this promocodes
	 */
	@Override
	public int getIsB2B() {
		return model.getIsB2B();
	}

	/**
	 * Returns the is b2b2c of this promocodes.
	 *
	 * @return the is b2b2c of this promocodes
	 */
	@Override
	public int getIsB2B2C() {
		return model.getIsB2B2C();
	}

	/**
	 * Returns the is b2c of this promocodes.
	 *
	 * @return the is b2c of this promocodes
	 */
	@Override
	public int getIsB2C() {
		return model.getIsB2C();
	}

	/**
	 * Returns the limit of this promocodes.
	 *
	 * @return the limit of this promocodes
	 */
	@Override
	public int getLimit() {
		return model.getLimit();
	}

	/**
	 * Returns the modified date of this promocodes.
	 *
	 * @return the modified date of this promocodes
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mypage user ID of this promocodes.
	 *
	 * @return the mypage user ID of this promocodes
	 */
	@Override
	public long getMypageUserId() {
		return model.getMypageUserId();
	}

	/**
	 * Returns the mypage user uuid of this promocodes.
	 *
	 * @return the mypage user uuid of this promocodes
	 */
	@Override
	public String getMypageUserUuid() {
		return model.getMypageUserUuid();
	}

	/**
	 * Returns the payment channel of this promocodes.
	 *
	 * @return the payment channel of this promocodes
	 */
	@Override
	public String getPaymentChannel() {
		return model.getPaymentChannel();
	}

	/**
	 * Returns the plan of this promocodes.
	 *
	 * @return the plan of this promocodes
	 */
	@Override
	public String getPlan() {
		return model.getPlan();
	}

	/**
	 * Returns the primary key of this promocodes.
	 *
	 * @return the primary key of this promocodes
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the products of this promocodes.
	 *
	 * @return the products of this promocodes
	 */
	@Override
	public String getProducts() {
		return model.getProducts();
	}

	/**
	 * Returns the promocode of this promocodes.
	 *
	 * @return the promocode of this promocodes
	 */
	@Override
	public String getPromocode() {
		return model.getPromocode();
	}

	/**
	 * Returns the promocode ID of this promocodes.
	 *
	 * @return the promocode ID of this promocodes
	 */
	@Override
	public long getPromocodeId() {
		return model.getPromocodeId();
	}

	/**
	 * Returns the promo type of this promocodes.
	 *
	 * @return the promo type of this promocodes
	 */
	@Override
	public String getPromoType() {
		return model.getPromoType();
	}

	/**
	 * Returns the start date of this promocodes.
	 *
	 * @return the start date of this promocodes
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this promocodes.
	 *
	 * @return the status of this promocodes
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this promocodes.
	 *
	 * @return the status by user ID of this promocodes
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this promocodes.
	 *
	 * @return the status by user name of this promocodes
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this promocodes.
	 *
	 * @return the status by user uuid of this promocodes
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this promocodes.
	 *
	 * @return the status date of this promocodes
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the terms of this promocodes.
	 *
	 * @return the terms of this promocodes
	 */
	@Override
	public String getTerms() {
		return model.getTerms();
	}

	/**
	 * Returns the user of this promocodes.
	 *
	 * @return the user of this promocodes
	 */
	@Override
	public String getUser() {
		return model.getUser();
	}

	/**
	 * Returns the user ID of this promocodes.
	 *
	 * @return the user ID of this promocodes
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this promocodes.
	 *
	 * @return the user name of this promocodes
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this promocodes.
	 *
	 * @return the user uuid of this promocodes
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the utm campaign ID of this promocodes.
	 *
	 * @return the utm campaign ID of this promocodes
	 */
	@Override
	public String getUtmCampaignId() {
		return model.getUtmCampaignId();
	}

	/**
	 * Returns the uuid of this promocodes.
	 *
	 * @return the uuid of this promocodes
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this promocodes is approved.
	 *
	 * @return <code>true</code> if this promocodes is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this promocodes is denied.
	 *
	 * @return <code>true</code> if this promocodes is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this promocodes is a draft.
	 *
	 * @return <code>true</code> if this promocodes is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this promocodes is expired.
	 *
	 * @return <code>true</code> if this promocodes is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this promocodes is inactive.
	 *
	 * @return <code>true</code> if this promocodes is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this promocodes is incomplete.
	 *
	 * @return <code>true</code> if this promocodes is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this promocodes is pending.
	 *
	 * @return <code>true</code> if this promocodes is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this promocodes is scheduled.
	 *
	 * @return <code>true</code> if this promocodes is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this promocodes.
	 *
	 * @param active the active of this promocodes
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the birthday month of this promocodes.
	 *
	 * @param birthdayMonth the birthday month of this promocodes
	 */
	@Override
	public void setBirthdayMonth(Date birthdayMonth) {
		model.setBirthdayMonth(birthdayMonth);
	}

	/**
	 * Sets the commission of this promocodes.
	 *
	 * @param commission the commission of this promocodes
	 */
	@Override
	public void setCommission(double commission) {
		model.setCommission(commission);
	}

	/**
	 * Sets the company ID of this promocodes.
	 *
	 * @param companyId the company ID of this promocodes
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this promocodes.
	 *
	 * @param createDate the create date of this promocodes
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the discount of this promocodes.
	 *
	 * @param discount the discount of this promocodes
	 */
	@Override
	public void setDiscount(double discount) {
		model.setDiscount(discount);
	}

	/**
	 * Sets the end date of this promocodes.
	 *
	 * @param endDate the end date of this promocodes
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the group ID of this promocodes.
	 *
	 * @param groupId the group ID of this promocodes
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the is b2b of this promocodes.
	 *
	 * @param isB2B the is b2b of this promocodes
	 */
	@Override
	public void setIsB2B(int isB2B) {
		model.setIsB2B(isB2B);
	}

	/**
	 * Sets the is b2b2c of this promocodes.
	 *
	 * @param isB2B2C the is b2b2c of this promocodes
	 */
	@Override
	public void setIsB2B2C(int isB2B2C) {
		model.setIsB2B2C(isB2B2C);
	}

	/**
	 * Sets the is b2c of this promocodes.
	 *
	 * @param isB2C the is b2c of this promocodes
	 */
	@Override
	public void setIsB2C(int isB2C) {
		model.setIsB2C(isB2C);
	}

	/**
	 * Sets the limit of this promocodes.
	 *
	 * @param limit the limit of this promocodes
	 */
	@Override
	public void setLimit(int limit) {
		model.setLimit(limit);
	}

	/**
	 * Sets the modified date of this promocodes.
	 *
	 * @param modifiedDate the modified date of this promocodes
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mypage user ID of this promocodes.
	 *
	 * @param mypageUserId the mypage user ID of this promocodes
	 */
	@Override
	public void setMypageUserId(long mypageUserId) {
		model.setMypageUserId(mypageUserId);
	}

	/**
	 * Sets the mypage user uuid of this promocodes.
	 *
	 * @param mypageUserUuid the mypage user uuid of this promocodes
	 */
	@Override
	public void setMypageUserUuid(String mypageUserUuid) {
		model.setMypageUserUuid(mypageUserUuid);
	}

	/**
	 * Sets the payment channel of this promocodes.
	 *
	 * @param paymentChannel the payment channel of this promocodes
	 */
	@Override
	public void setPaymentChannel(String paymentChannel) {
		model.setPaymentChannel(paymentChannel);
	}

	/**
	 * Sets the plan of this promocodes.
	 *
	 * @param plan the plan of this promocodes
	 */
	@Override
	public void setPlan(String plan) {
		model.setPlan(plan);
	}

	/**
	 * Sets the primary key of this promocodes.
	 *
	 * @param primaryKey the primary key of this promocodes
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the products of this promocodes.
	 *
	 * @param products the products of this promocodes
	 */
	@Override
	public void setProducts(String products) {
		model.setProducts(products);
	}

	/**
	 * Sets the promocode of this promocodes.
	 *
	 * @param promocode the promocode of this promocodes
	 */
	@Override
	public void setPromocode(String promocode) {
		model.setPromocode(promocode);
	}

	/**
	 * Sets the promocode ID of this promocodes.
	 *
	 * @param promocodeId the promocode ID of this promocodes
	 */
	@Override
	public void setPromocodeId(long promocodeId) {
		model.setPromocodeId(promocodeId);
	}

	/**
	 * Sets the promo type of this promocodes.
	 *
	 * @param promoType the promo type of this promocodes
	 */
	@Override
	public void setPromoType(String promoType) {
		model.setPromoType(promoType);
	}

	/**
	 * Sets the start date of this promocodes.
	 *
	 * @param startDate the start date of this promocodes
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the status of this promocodes.
	 *
	 * @param status the status of this promocodes
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this promocodes.
	 *
	 * @param statusByUserId the status by user ID of this promocodes
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this promocodes.
	 *
	 * @param statusByUserName the status by user name of this promocodes
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this promocodes.
	 *
	 * @param statusByUserUuid the status by user uuid of this promocodes
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this promocodes.
	 *
	 * @param statusDate the status date of this promocodes
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the terms of this promocodes.
	 *
	 * @param terms the terms of this promocodes
	 */
	@Override
	public void setTerms(String terms) {
		model.setTerms(terms);
	}

	/**
	 * Sets the user of this promocodes.
	 *
	 * @param user the user of this promocodes
	 */
	@Override
	public void setUser(String user) {
		model.setUser(user);
	}

	/**
	 * Sets the user ID of this promocodes.
	 *
	 * @param userId the user ID of this promocodes
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this promocodes.
	 *
	 * @param userName the user name of this promocodes
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this promocodes.
	 *
	 * @param userUuid the user uuid of this promocodes
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the utm campaign ID of this promocodes.
	 *
	 * @param utmCampaignId the utm campaign ID of this promocodes
	 */
	@Override
	public void setUtmCampaignId(String utmCampaignId) {
		model.setUtmCampaignId(utmCampaignId);
	}

	/**
	 * Sets the uuid of this promocodes.
	 *
	 * @param uuid the uuid of this promocodes
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected PromocodesWrapper wrap(Promocodes promocodes) {
		return new PromocodesWrapper(promocodes);
	}

}