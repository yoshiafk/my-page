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
 * This class is a wrapper for {@link MypageUserGracePeriod}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserGracePeriod
 * @generated
 */
public class MypageUserGracePeriodWrapper
	extends BaseModelWrapper<MypageUserGracePeriod>
	implements ModelWrapper<MypageUserGracePeriod>, MypageUserGracePeriod {

	public MypageUserGracePeriodWrapper(
		MypageUserGracePeriod mypageUserGracePeriod) {

		super(mypageUserGracePeriod);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mypageUserGracePeriodId", getMypageUserGracePeriodId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("mypageUserId", getMypageUserId());
		attributes.put("code", getCode());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mypageUserGracePeriodId = (Long)attributes.get(
			"mypageUserGracePeriodId");

		if (mypageUserGracePeriodId != null) {
			setMypageUserGracePeriodId(mypageUserGracePeriodId);
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

		Long mypageUserId = (Long)attributes.get("mypageUserId");

		if (mypageUserId != null) {
			setMypageUserId(mypageUserId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Integer value = (Integer)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	 * Returns the code of this mypage user grace period.
	 *
	 * @return the code of this mypage user grace period
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this mypage user grace period.
	 *
	 * @return the company ID of this mypage user grace period
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this mypage user grace period.
	 *
	 * @return the create date of this mypage user grace period
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this mypage user grace period.
	 *
	 * @return the group ID of this mypage user grace period
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this mypage user grace period.
	 *
	 * @return the modified date of this mypage user grace period
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mypage user grace period ID of this mypage user grace period.
	 *
	 * @return the mypage user grace period ID of this mypage user grace period
	 */
	@Override
	public long getMypageUserGracePeriodId() {
		return model.getMypageUserGracePeriodId();
	}

	/**
	 * Returns the mypage user ID of this mypage user grace period.
	 *
	 * @return the mypage user ID of this mypage user grace period
	 */
	@Override
	public long getMypageUserId() {
		return model.getMypageUserId();
	}

	/**
	 * Returns the mypage user uuid of this mypage user grace period.
	 *
	 * @return the mypage user uuid of this mypage user grace period
	 */
	@Override
	public String getMypageUserUuid() {
		return model.getMypageUserUuid();
	}

	/**
	 * Returns the primary key of this mypage user grace period.
	 *
	 * @return the primary key of this mypage user grace period
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this mypage user grace period.
	 *
	 * @return the user ID of this mypage user grace period
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this mypage user grace period.
	 *
	 * @return the user name of this mypage user grace period
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this mypage user grace period.
	 *
	 * @return the user uuid of this mypage user grace period
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the value of this mypage user grace period.
	 *
	 * @return the value of this mypage user grace period
	 */
	@Override
	public int getValue() {
		return model.getValue();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the code of this mypage user grace period.
	 *
	 * @param code the code of this mypage user grace period
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this mypage user grace period.
	 *
	 * @param companyId the company ID of this mypage user grace period
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this mypage user grace period.
	 *
	 * @param createDate the create date of this mypage user grace period
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this mypage user grace period.
	 *
	 * @param groupId the group ID of this mypage user grace period
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this mypage user grace period.
	 *
	 * @param modifiedDate the modified date of this mypage user grace period
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mypage user grace period ID of this mypage user grace period.
	 *
	 * @param mypageUserGracePeriodId the mypage user grace period ID of this mypage user grace period
	 */
	@Override
	public void setMypageUserGracePeriodId(long mypageUserGracePeriodId) {
		model.setMypageUserGracePeriodId(mypageUserGracePeriodId);
	}

	/**
	 * Sets the mypage user ID of this mypage user grace period.
	 *
	 * @param mypageUserId the mypage user ID of this mypage user grace period
	 */
	@Override
	public void setMypageUserId(long mypageUserId) {
		model.setMypageUserId(mypageUserId);
	}

	/**
	 * Sets the mypage user uuid of this mypage user grace period.
	 *
	 * @param mypageUserUuid the mypage user uuid of this mypage user grace period
	 */
	@Override
	public void setMypageUserUuid(String mypageUserUuid) {
		model.setMypageUserUuid(mypageUserUuid);
	}

	/**
	 * Sets the primary key of this mypage user grace period.
	 *
	 * @param primaryKey the primary key of this mypage user grace period
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this mypage user grace period.
	 *
	 * @param userId the user ID of this mypage user grace period
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this mypage user grace period.
	 *
	 * @param userName the user name of this mypage user grace period
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this mypage user grace period.
	 *
	 * @param userUuid the user uuid of this mypage user grace period
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the value of this mypage user grace period.
	 *
	 * @param value the value of this mypage user grace period
	 */
	@Override
	public void setValue(int value) {
		model.setValue(value);
	}

	@Override
	protected MypageUserGracePeriodWrapper wrap(
		MypageUserGracePeriod mypageUserGracePeriod) {

		return new MypageUserGracePeriodWrapper(mypageUserGracePeriod);
	}

}