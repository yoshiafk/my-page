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
 * This class is a wrapper for {@link MypageUserWorkingHour}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserWorkingHour
 * @generated
 */
public class MypageUserWorkingHourWrapper
	extends BaseModelWrapper<MypageUserWorkingHour>
	implements ModelWrapper<MypageUserWorkingHour>, MypageUserWorkingHour {

	public MypageUserWorkingHourWrapper(
		MypageUserWorkingHour mypageUserWorkingHour) {

		super(mypageUserWorkingHour);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mypageUserWorkingHourId", getMypageUserWorkingHourId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("mypageUserId", getMypageUserId());
		attributes.put("day", getDay());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mypageUserWorkingHourId = (Long)attributes.get(
			"mypageUserWorkingHourId");

		if (mypageUserWorkingHourId != null) {
			setMypageUserWorkingHourId(mypageUserWorkingHourId);
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

		String day = (String)attributes.get("day");

		if (day != null) {
			setDay(day);
		}

		String startTime = (String)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		String endTime = (String)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the company ID of this mypage user working hour.
	 *
	 * @return the company ID of this mypage user working hour
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this mypage user working hour.
	 *
	 * @return the create date of this mypage user working hour
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the day of this mypage user working hour.
	 *
	 * @return the day of this mypage user working hour
	 */
	@Override
	public String getDay() {
		return model.getDay();
	}

	/**
	 * Returns the end time of this mypage user working hour.
	 *
	 * @return the end time of this mypage user working hour
	 */
	@Override
	public String getEndTime() {
		return model.getEndTime();
	}

	/**
	 * Returns the group ID of this mypage user working hour.
	 *
	 * @return the group ID of this mypage user working hour
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this mypage user working hour.
	 *
	 * @return the modified date of this mypage user working hour
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mypage user ID of this mypage user working hour.
	 *
	 * @return the mypage user ID of this mypage user working hour
	 */
	@Override
	public long getMypageUserId() {
		return model.getMypageUserId();
	}

	/**
	 * Returns the mypage user uuid of this mypage user working hour.
	 *
	 * @return the mypage user uuid of this mypage user working hour
	 */
	@Override
	public String getMypageUserUuid() {
		return model.getMypageUserUuid();
	}

	/**
	 * Returns the mypage user working hour ID of this mypage user working hour.
	 *
	 * @return the mypage user working hour ID of this mypage user working hour
	 */
	@Override
	public long getMypageUserWorkingHourId() {
		return model.getMypageUserWorkingHourId();
	}

	/**
	 * Returns the primary key of this mypage user working hour.
	 *
	 * @return the primary key of this mypage user working hour
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start time of this mypage user working hour.
	 *
	 * @return the start time of this mypage user working hour
	 */
	@Override
	public String getStartTime() {
		return model.getStartTime();
	}

	/**
	 * Returns the status of this mypage user working hour.
	 *
	 * @return the status of this mypage user working hour
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this mypage user working hour.
	 *
	 * @return the user ID of this mypage user working hour
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this mypage user working hour.
	 *
	 * @return the user name of this mypage user working hour
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this mypage user working hour.
	 *
	 * @return the user uuid of this mypage user working hour
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
	 * Sets the company ID of this mypage user working hour.
	 *
	 * @param companyId the company ID of this mypage user working hour
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this mypage user working hour.
	 *
	 * @param createDate the create date of this mypage user working hour
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the day of this mypage user working hour.
	 *
	 * @param day the day of this mypage user working hour
	 */
	@Override
	public void setDay(String day) {
		model.setDay(day);
	}

	/**
	 * Sets the end time of this mypage user working hour.
	 *
	 * @param endTime the end time of this mypage user working hour
	 */
	@Override
	public void setEndTime(String endTime) {
		model.setEndTime(endTime);
	}

	/**
	 * Sets the group ID of this mypage user working hour.
	 *
	 * @param groupId the group ID of this mypage user working hour
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this mypage user working hour.
	 *
	 * @param modifiedDate the modified date of this mypage user working hour
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mypage user ID of this mypage user working hour.
	 *
	 * @param mypageUserId the mypage user ID of this mypage user working hour
	 */
	@Override
	public void setMypageUserId(long mypageUserId) {
		model.setMypageUserId(mypageUserId);
	}

	/**
	 * Sets the mypage user uuid of this mypage user working hour.
	 *
	 * @param mypageUserUuid the mypage user uuid of this mypage user working hour
	 */
	@Override
	public void setMypageUserUuid(String mypageUserUuid) {
		model.setMypageUserUuid(mypageUserUuid);
	}

	/**
	 * Sets the mypage user working hour ID of this mypage user working hour.
	 *
	 * @param mypageUserWorkingHourId the mypage user working hour ID of this mypage user working hour
	 */
	@Override
	public void setMypageUserWorkingHourId(long mypageUserWorkingHourId) {
		model.setMypageUserWorkingHourId(mypageUserWorkingHourId);
	}

	/**
	 * Sets the primary key of this mypage user working hour.
	 *
	 * @param primaryKey the primary key of this mypage user working hour
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start time of this mypage user working hour.
	 *
	 * @param startTime the start time of this mypage user working hour
	 */
	@Override
	public void setStartTime(String startTime) {
		model.setStartTime(startTime);
	}

	/**
	 * Sets the status of this mypage user working hour.
	 *
	 * @param status the status of this mypage user working hour
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this mypage user working hour.
	 *
	 * @param userId the user ID of this mypage user working hour
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this mypage user working hour.
	 *
	 * @param userName the user name of this mypage user working hour
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this mypage user working hour.
	 *
	 * @param userUuid the user uuid of this mypage user working hour
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MypageUserWorkingHourWrapper wrap(
		MypageUserWorkingHour mypageUserWorkingHour) {

		return new MypageUserWorkingHourWrapper(mypageUserWorkingHour);
	}

}