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
 * This class is a wrapper for {@link PaymentChannelTenor}.
 * </p>
 *
 * @author Gositus Team
 * @see PaymentChannelTenor
 * @generated
 */
public class PaymentChannelTenorWrapper
	extends BaseModelWrapper<PaymentChannelTenor>
	implements ModelWrapper<PaymentChannelTenor>, PaymentChannelTenor {

	public PaymentChannelTenorWrapper(PaymentChannelTenor paymentChannelTenor) {
		super(paymentChannelTenor);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("paymentChannelTenorId", getPaymentChannelTenorId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("paymentChannelId", getPaymentChannelId());
		attributes.put("promoid", getPromoid());
		attributes.put("tenor", getTenor());
		attributes.put("tenorid", getTenorid());
		attributes.put("acquirer", getAcquirer());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long paymentChannelTenorId = (Long)attributes.get(
			"paymentChannelTenorId");

		if (paymentChannelTenorId != null) {
			setPaymentChannelTenorId(paymentChannelTenorId);
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

		Long paymentChannelId = (Long)attributes.get("paymentChannelId");

		if (paymentChannelId != null) {
			setPaymentChannelId(paymentChannelId);
		}

		String promoid = (String)attributes.get("promoid");

		if (promoid != null) {
			setPromoid(promoid);
		}

		String tenor = (String)attributes.get("tenor");

		if (tenor != null) {
			setTenor(tenor);
		}

		String tenorid = (String)attributes.get("tenorid");

		if (tenorid != null) {
			setTenorid(tenorid);
		}

		String acquirer = (String)attributes.get("acquirer");

		if (acquirer != null) {
			setAcquirer(acquirer);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the acquirer of this payment channel tenor.
	 *
	 * @return the acquirer of this payment channel tenor
	 */
	@Override
	public String getAcquirer() {
		return model.getAcquirer();
	}

	/**
	 * Returns the active of this payment channel tenor.
	 *
	 * @return the active of this payment channel tenor
	 */
	@Override
	public Integer getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this payment channel tenor.
	 *
	 * @return the company ID of this payment channel tenor
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this payment channel tenor.
	 *
	 * @return the create date of this payment channel tenor
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this payment channel tenor.
	 *
	 * @return the group ID of this payment channel tenor
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this payment channel tenor.
	 *
	 * @return the modified date of this payment channel tenor
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the payment channel ID of this payment channel tenor.
	 *
	 * @return the payment channel ID of this payment channel tenor
	 */
	@Override
	public long getPaymentChannelId() {
		return model.getPaymentChannelId();
	}

	/**
	 * Returns the payment channel tenor ID of this payment channel tenor.
	 *
	 * @return the payment channel tenor ID of this payment channel tenor
	 */
	@Override
	public long getPaymentChannelTenorId() {
		return model.getPaymentChannelTenorId();
	}

	/**
	 * Returns the primary key of this payment channel tenor.
	 *
	 * @return the primary key of this payment channel tenor
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the promoid of this payment channel tenor.
	 *
	 * @return the promoid of this payment channel tenor
	 */
	@Override
	public String getPromoid() {
		return model.getPromoid();
	}

	/**
	 * Returns the tenor of this payment channel tenor.
	 *
	 * @return the tenor of this payment channel tenor
	 */
	@Override
	public String getTenor() {
		return model.getTenor();
	}

	/**
	 * Returns the tenorid of this payment channel tenor.
	 *
	 * @return the tenorid of this payment channel tenor
	 */
	@Override
	public String getTenorid() {
		return model.getTenorid();
	}

	/**
	 * Returns the user ID of this payment channel tenor.
	 *
	 * @return the user ID of this payment channel tenor
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this payment channel tenor.
	 *
	 * @return the user name of this payment channel tenor
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this payment channel tenor.
	 *
	 * @return the user uuid of this payment channel tenor
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the acquirer of this payment channel tenor.
	 *
	 * @param acquirer the acquirer of this payment channel tenor
	 */
	@Override
	public void setAcquirer(String acquirer) {
		model.setAcquirer(acquirer);
	}

	/**
	 * Sets the active of this payment channel tenor.
	 *
	 * @param active the active of this payment channel tenor
	 */
	@Override
	public void setActive(Integer active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this payment channel tenor.
	 *
	 * @param companyId the company ID of this payment channel tenor
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this payment channel tenor.
	 *
	 * @param createDate the create date of this payment channel tenor
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this payment channel tenor.
	 *
	 * @param groupId the group ID of this payment channel tenor
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this payment channel tenor.
	 *
	 * @param modifiedDate the modified date of this payment channel tenor
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the payment channel ID of this payment channel tenor.
	 *
	 * @param paymentChannelId the payment channel ID of this payment channel tenor
	 */
	@Override
	public void setPaymentChannelId(long paymentChannelId) {
		model.setPaymentChannelId(paymentChannelId);
	}

	/**
	 * Sets the payment channel tenor ID of this payment channel tenor.
	 *
	 * @param paymentChannelTenorId the payment channel tenor ID of this payment channel tenor
	 */
	@Override
	public void setPaymentChannelTenorId(long paymentChannelTenorId) {
		model.setPaymentChannelTenorId(paymentChannelTenorId);
	}

	/**
	 * Sets the primary key of this payment channel tenor.
	 *
	 * @param primaryKey the primary key of this payment channel tenor
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the promoid of this payment channel tenor.
	 *
	 * @param promoid the promoid of this payment channel tenor
	 */
	@Override
	public void setPromoid(String promoid) {
		model.setPromoid(promoid);
	}

	/**
	 * Sets the tenor of this payment channel tenor.
	 *
	 * @param tenor the tenor of this payment channel tenor
	 */
	@Override
	public void setTenor(String tenor) {
		model.setTenor(tenor);
	}

	/**
	 * Sets the tenorid of this payment channel tenor.
	 *
	 * @param tenorid the tenorid of this payment channel tenor
	 */
	@Override
	public void setTenorid(String tenorid) {
		model.setTenorid(tenorid);
	}

	/**
	 * Sets the user ID of this payment channel tenor.
	 *
	 * @param userId the user ID of this payment channel tenor
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this payment channel tenor.
	 *
	 * @param userName the user name of this payment channel tenor
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this payment channel tenor.
	 *
	 * @param userUuid the user uuid of this payment channel tenor
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PaymentChannelTenorWrapper wrap(
		PaymentChannelTenor paymentChannelTenor) {

		return new PaymentChannelTenorWrapper(paymentChannelTenor);
	}

}