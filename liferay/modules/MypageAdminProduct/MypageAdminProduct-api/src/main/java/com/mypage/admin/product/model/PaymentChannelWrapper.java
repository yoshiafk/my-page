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
 * This class is a wrapper for {@link PaymentChannel}.
 * </p>
 *
 * @author Gositus Team
 * @see PaymentChannel
 * @generated
 */
public class PaymentChannelWrapper
	extends BaseModelWrapper<PaymentChannel>
	implements ModelWrapper<PaymentChannel>, PaymentChannel {

	public PaymentChannelWrapper(PaymentChannel paymentChannel) {
		super(paymentChannel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("paymentChannelId", getPaymentChannelId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("name", getName());
		attributes.put("minPayment", getMinPayment());
		attributes.put("maxPayment", getMaxPayment());
		attributes.put("description", getDescription());
		attributes.put("masterBankId", getMasterBankId());
		attributes.put("mdrAxa", getMdrAxa());
		attributes.put("mdrUser", getMdrUser());
		attributes.put("pgFeePct", getPgFeePct());
		attributes.put("pgFeeAmt", getPgFeeAmt());
		attributes.put("imageFileEntryId", getImageFileEntryId());
		attributes.put("imageURL", getImageURL());
		attributes.put("utmOnly", getUtmOnly());
		attributes.put("mallId", getMallId());
		attributes.put("sharedKey", getSharedKey());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long paymentChannelId = (Long)attributes.get("paymentChannelId");

		if (paymentChannelId != null) {
			setPaymentChannelId(paymentChannelId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Double minPayment = (Double)attributes.get("minPayment");

		if (minPayment != null) {
			setMinPayment(minPayment);
		}

		Double maxPayment = (Double)attributes.get("maxPayment");

		if (maxPayment != null) {
			setMaxPayment(maxPayment);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long masterBankId = (Long)attributes.get("masterBankId");

		if (masterBankId != null) {
			setMasterBankId(masterBankId);
		}

		String mdrAxa = (String)attributes.get("mdrAxa");

		if (mdrAxa != null) {
			setMdrAxa(mdrAxa);
		}

		String mdrUser = (String)attributes.get("mdrUser");

		if (mdrUser != null) {
			setMdrUser(mdrUser);
		}

		String pgFeePct = (String)attributes.get("pgFeePct");

		if (pgFeePct != null) {
			setPgFeePct(pgFeePct);
		}

		String pgFeeAmt = (String)attributes.get("pgFeeAmt");

		if (pgFeeAmt != null) {
			setPgFeeAmt(pgFeeAmt);
		}

		Long imageFileEntryId = (Long)attributes.get("imageFileEntryId");

		if (imageFileEntryId != null) {
			setImageFileEntryId(imageFileEntryId);
		}

		String imageURL = (String)attributes.get("imageURL");

		if (imageURL != null) {
			setImageURL(imageURL);
		}

		Integer utmOnly = (Integer)attributes.get("utmOnly");

		if (utmOnly != null) {
			setUtmOnly(utmOnly);
		}

		String mallId = (String)attributes.get("mallId");

		if (mallId != null) {
			setMallId(mallId);
		}

		String sharedKey = (String)attributes.get("sharedKey");

		if (sharedKey != null) {
			setSharedKey(sharedKey);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this payment channel.
	 *
	 * @return the active of this payment channel
	 */
	@Override
	public Integer getActive() {
		return model.getActive();
	}

	/**
	 * Returns the code of this payment channel.
	 *
	 * @return the code of this payment channel
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this payment channel.
	 *
	 * @return the company ID of this payment channel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this payment channel.
	 *
	 * @return the create date of this payment channel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this payment channel.
	 *
	 * @return the description of this payment channel
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this payment channel.
	 *
	 * @return the group ID of this payment channel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image file entry ID of this payment channel.
	 *
	 * @return the image file entry ID of this payment channel
	 */
	@Override
	public long getImageFileEntryId() {
		return model.getImageFileEntryId();
	}

	/**
	 * Returns the image url of this payment channel.
	 *
	 * @return the image url of this payment channel
	 */
	@Override
	public String getImageURL() {
		return model.getImageURL();
	}

	/**
	 * Returns the mall ID of this payment channel.
	 *
	 * @return the mall ID of this payment channel
	 */
	@Override
	public String getMallId() {
		return model.getMallId();
	}

	/**
	 * Returns the master bank ID of this payment channel.
	 *
	 * @return the master bank ID of this payment channel
	 */
	@Override
	public long getMasterBankId() {
		return model.getMasterBankId();
	}

	/**
	 * Returns the max payment of this payment channel.
	 *
	 * @return the max payment of this payment channel
	 */
	@Override
	public Double getMaxPayment() {
		return model.getMaxPayment();
	}

	/**
	 * Returns the mdr axa of this payment channel.
	 *
	 * @return the mdr axa of this payment channel
	 */
	@Override
	public String getMdrAxa() {
		return model.getMdrAxa();
	}

	/**
	 * Returns the mdr user of this payment channel.
	 *
	 * @return the mdr user of this payment channel
	 */
	@Override
	public String getMdrUser() {
		return model.getMdrUser();
	}

	/**
	 * Returns the min payment of this payment channel.
	 *
	 * @return the min payment of this payment channel
	 */
	@Override
	public Double getMinPayment() {
		return model.getMinPayment();
	}

	/**
	 * Returns the modified date of this payment channel.
	 *
	 * @return the modified date of this payment channel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this payment channel.
	 *
	 * @return the name of this payment channel
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the payment channel ID of this payment channel.
	 *
	 * @return the payment channel ID of this payment channel
	 */
	@Override
	public long getPaymentChannelId() {
		return model.getPaymentChannelId();
	}

	/**
	 * Returns the pg fee amt of this payment channel.
	 *
	 * @return the pg fee amt of this payment channel
	 */
	@Override
	public String getPgFeeAmt() {
		return model.getPgFeeAmt();
	}

	/**
	 * Returns the pg fee pct of this payment channel.
	 *
	 * @return the pg fee pct of this payment channel
	 */
	@Override
	public String getPgFeePct() {
		return model.getPgFeePct();
	}

	/**
	 * Returns the primary key of this payment channel.
	 *
	 * @return the primary key of this payment channel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the shared key of this payment channel.
	 *
	 * @return the shared key of this payment channel
	 */
	@Override
	public String getSharedKey() {
		return model.getSharedKey();
	}

	/**
	 * Returns the user ID of this payment channel.
	 *
	 * @return the user ID of this payment channel
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this payment channel.
	 *
	 * @return the user name of this payment channel
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this payment channel.
	 *
	 * @return the user uuid of this payment channel
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the utm only of this payment channel.
	 *
	 * @return the utm only of this payment channel
	 */
	@Override
	public Integer getUtmOnly() {
		return model.getUtmOnly();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this payment channel.
	 *
	 * @param active the active of this payment channel
	 */
	@Override
	public void setActive(Integer active) {
		model.setActive(active);
	}

	/**
	 * Sets the code of this payment channel.
	 *
	 * @param code the code of this payment channel
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this payment channel.
	 *
	 * @param companyId the company ID of this payment channel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this payment channel.
	 *
	 * @param createDate the create date of this payment channel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this payment channel.
	 *
	 * @param description the description of this payment channel
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this payment channel.
	 *
	 * @param groupId the group ID of this payment channel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image file entry ID of this payment channel.
	 *
	 * @param imageFileEntryId the image file entry ID of this payment channel
	 */
	@Override
	public void setImageFileEntryId(long imageFileEntryId) {
		model.setImageFileEntryId(imageFileEntryId);
	}

	/**
	 * Sets the image url of this payment channel.
	 *
	 * @param imageURL the image url of this payment channel
	 */
	@Override
	public void setImageURL(String imageURL) {
		model.setImageURL(imageURL);
	}

	/**
	 * Sets the mall ID of this payment channel.
	 *
	 * @param mallId the mall ID of this payment channel
	 */
	@Override
	public void setMallId(String mallId) {
		model.setMallId(mallId);
	}

	/**
	 * Sets the master bank ID of this payment channel.
	 *
	 * @param masterBankId the master bank ID of this payment channel
	 */
	@Override
	public void setMasterBankId(long masterBankId) {
		model.setMasterBankId(masterBankId);
	}

	/**
	 * Sets the max payment of this payment channel.
	 *
	 * @param maxPayment the max payment of this payment channel
	 */
	@Override
	public void setMaxPayment(Double maxPayment) {
		model.setMaxPayment(maxPayment);
	}

	/**
	 * Sets the mdr axa of this payment channel.
	 *
	 * @param mdrAxa the mdr axa of this payment channel
	 */
	@Override
	public void setMdrAxa(String mdrAxa) {
		model.setMdrAxa(mdrAxa);
	}

	/**
	 * Sets the mdr user of this payment channel.
	 *
	 * @param mdrUser the mdr user of this payment channel
	 */
	@Override
	public void setMdrUser(String mdrUser) {
		model.setMdrUser(mdrUser);
	}

	/**
	 * Sets the min payment of this payment channel.
	 *
	 * @param minPayment the min payment of this payment channel
	 */
	@Override
	public void setMinPayment(Double minPayment) {
		model.setMinPayment(minPayment);
	}

	/**
	 * Sets the modified date of this payment channel.
	 *
	 * @param modifiedDate the modified date of this payment channel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this payment channel.
	 *
	 * @param name the name of this payment channel
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the payment channel ID of this payment channel.
	 *
	 * @param paymentChannelId the payment channel ID of this payment channel
	 */
	@Override
	public void setPaymentChannelId(long paymentChannelId) {
		model.setPaymentChannelId(paymentChannelId);
	}

	/**
	 * Sets the pg fee amt of this payment channel.
	 *
	 * @param pgFeeAmt the pg fee amt of this payment channel
	 */
	@Override
	public void setPgFeeAmt(String pgFeeAmt) {
		model.setPgFeeAmt(pgFeeAmt);
	}

	/**
	 * Sets the pg fee pct of this payment channel.
	 *
	 * @param pgFeePct the pg fee pct of this payment channel
	 */
	@Override
	public void setPgFeePct(String pgFeePct) {
		model.setPgFeePct(pgFeePct);
	}

	/**
	 * Sets the primary key of this payment channel.
	 *
	 * @param primaryKey the primary key of this payment channel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the shared key of this payment channel.
	 *
	 * @param sharedKey the shared key of this payment channel
	 */
	@Override
	public void setSharedKey(String sharedKey) {
		model.setSharedKey(sharedKey);
	}

	/**
	 * Sets the user ID of this payment channel.
	 *
	 * @param userId the user ID of this payment channel
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this payment channel.
	 *
	 * @param userName the user name of this payment channel
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this payment channel.
	 *
	 * @param userUuid the user uuid of this payment channel
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the utm only of this payment channel.
	 *
	 * @param utmOnly the utm only of this payment channel
	 */
	@Override
	public void setUtmOnly(Integer utmOnly) {
		model.setUtmOnly(utmOnly);
	}

	@Override
	protected PaymentChannelWrapper wrap(PaymentChannel paymentChannel) {
		return new PaymentChannelWrapper(paymentChannel);
	}

}