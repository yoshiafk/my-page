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
 * This class is a wrapper for {@link MasterBank}.
 * </p>
 *
 * @author Gositus Team
 * @see MasterBank
 * @generated
 */
public class MasterBankWrapper
	extends BaseModelWrapper<MasterBank>
	implements MasterBank, ModelWrapper<MasterBank> {

	public MasterBankWrapper(MasterBank masterBank) {
		super(masterBank);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("masterBankId", getMasterBankId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("bankCode", getBankCode());
		attributes.put("bankDesc", getBankDesc());
		attributes.put("name", getName());
		attributes.put("detail", getDetail());
		attributes.put("imageURL", getImageURL());
		attributes.put("imageFileEntryId", getImageFileEntryId());
		attributes.put("order", getOrder());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long masterBankId = (Long)attributes.get("masterBankId");

		if (masterBankId != null) {
			setMasterBankId(masterBankId);
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

		String bankCode = (String)attributes.get("bankCode");

		if (bankCode != null) {
			setBankCode(bankCode);
		}

		String bankDesc = (String)attributes.get("bankDesc");

		if (bankDesc != null) {
			setBankDesc(bankDesc);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String detail = (String)attributes.get("detail");

		if (detail != null) {
			setDetail(detail);
		}

		String imageURL = (String)attributes.get("imageURL");

		if (imageURL != null) {
			setImageURL(imageURL);
		}

		Long imageFileEntryId = (Long)attributes.get("imageFileEntryId");

		if (imageFileEntryId != null) {
			setImageFileEntryId(imageFileEntryId);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this master bank.
	 *
	 * @return the active of this master bank
	 */
	@Override
	public Integer getActive() {
		return model.getActive();
	}

	/**
	 * Returns the bank code of this master bank.
	 *
	 * @return the bank code of this master bank
	 */
	@Override
	public String getBankCode() {
		return model.getBankCode();
	}

	/**
	 * Returns the bank desc of this master bank.
	 *
	 * @return the bank desc of this master bank
	 */
	@Override
	public String getBankDesc() {
		return model.getBankDesc();
	}

	/**
	 * Returns the company ID of this master bank.
	 *
	 * @return the company ID of this master bank
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this master bank.
	 *
	 * @return the create date of this master bank
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the detail of this master bank.
	 *
	 * @return the detail of this master bank
	 */
	@Override
	public String getDetail() {
		return model.getDetail();
	}

	/**
	 * Returns the group ID of this master bank.
	 *
	 * @return the group ID of this master bank
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image file entry ID of this master bank.
	 *
	 * @return the image file entry ID of this master bank
	 */
	@Override
	public Long getImageFileEntryId() {
		return model.getImageFileEntryId();
	}

	/**
	 * Returns the image url of this master bank.
	 *
	 * @return the image url of this master bank
	 */
	@Override
	public String getImageURL() {
		return model.getImageURL();
	}

	/**
	 * Returns the master bank ID of this master bank.
	 *
	 * @return the master bank ID of this master bank
	 */
	@Override
	public long getMasterBankId() {
		return model.getMasterBankId();
	}

	/**
	 * Returns the modified date of this master bank.
	 *
	 * @return the modified date of this master bank
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this master bank.
	 *
	 * @return the name of this master bank
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the order of this master bank.
	 *
	 * @return the order of this master bank
	 */
	@Override
	public Integer getOrder() {
		return model.getOrder();
	}

	/**
	 * Returns the primary key of this master bank.
	 *
	 * @return the primary key of this master bank
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this master bank.
	 *
	 * @return the user ID of this master bank
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this master bank.
	 *
	 * @return the user name of this master bank
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this master bank.
	 *
	 * @return the user uuid of this master bank
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
	 * Sets the active of this master bank.
	 *
	 * @param active the active of this master bank
	 */
	@Override
	public void setActive(Integer active) {
		model.setActive(active);
	}

	/**
	 * Sets the bank code of this master bank.
	 *
	 * @param bankCode the bank code of this master bank
	 */
	@Override
	public void setBankCode(String bankCode) {
		model.setBankCode(bankCode);
	}

	/**
	 * Sets the bank desc of this master bank.
	 *
	 * @param bankDesc the bank desc of this master bank
	 */
	@Override
	public void setBankDesc(String bankDesc) {
		model.setBankDesc(bankDesc);
	}

	/**
	 * Sets the company ID of this master bank.
	 *
	 * @param companyId the company ID of this master bank
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this master bank.
	 *
	 * @param createDate the create date of this master bank
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the detail of this master bank.
	 *
	 * @param detail the detail of this master bank
	 */
	@Override
	public void setDetail(String detail) {
		model.setDetail(detail);
	}

	/**
	 * Sets the group ID of this master bank.
	 *
	 * @param groupId the group ID of this master bank
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image file entry ID of this master bank.
	 *
	 * @param imageFileEntryId the image file entry ID of this master bank
	 */
	@Override
	public void setImageFileEntryId(Long imageFileEntryId) {
		model.setImageFileEntryId(imageFileEntryId);
	}

	/**
	 * Sets the image url of this master bank.
	 *
	 * @param imageURL the image url of this master bank
	 */
	@Override
	public void setImageURL(String imageURL) {
		model.setImageURL(imageURL);
	}

	/**
	 * Sets the master bank ID of this master bank.
	 *
	 * @param masterBankId the master bank ID of this master bank
	 */
	@Override
	public void setMasterBankId(long masterBankId) {
		model.setMasterBankId(masterBankId);
	}

	/**
	 * Sets the modified date of this master bank.
	 *
	 * @param modifiedDate the modified date of this master bank
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this master bank.
	 *
	 * @param name the name of this master bank
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the order of this master bank.
	 *
	 * @param order the order of this master bank
	 */
	@Override
	public void setOrder(Integer order) {
		model.setOrder(order);
	}

	/**
	 * Sets the primary key of this master bank.
	 *
	 * @param primaryKey the primary key of this master bank
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this master bank.
	 *
	 * @param userId the user ID of this master bank
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this master bank.
	 *
	 * @param userName the user name of this master bank
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this master bank.
	 *
	 * @param userUuid the user uuid of this master bank
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MasterBankWrapper wrap(MasterBank masterBank) {
		return new MasterBankWrapper(masterBank);
	}

}