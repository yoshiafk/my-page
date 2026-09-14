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
 * This class is a wrapper for {@link MypageGroupUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageGroupUser
 * @generated
 */
public class MypageGroupUserWrapper
	extends BaseModelWrapper<MypageGroupUser>
	implements ModelWrapper<MypageGroupUser>, MypageGroupUser {

	public MypageGroupUserWrapper(MypageGroupUser mypageGroupUser) {
		super(mypageGroupUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mypageGroupUserId", getMypageGroupUserId());
		attributes.put("mypageGroupId", getMypageGroupId());
		attributes.put("mypageUserId", getMypageUserId());
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
		Long mypageGroupUserId = (Long)attributes.get("mypageGroupUserId");

		if (mypageGroupUserId != null) {
			setMypageGroupUserId(mypageGroupUserId);
		}

		Long mypageGroupId = (Long)attributes.get("mypageGroupId");

		if (mypageGroupId != null) {
			setMypageGroupId(mypageGroupId);
		}

		Long mypageUserId = (Long)attributes.get("mypageUserId");

		if (mypageUserId != null) {
			setMypageUserId(mypageUserId);
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
	 * Returns the company ID of this mypage group user.
	 *
	 * @return the company ID of this mypage group user
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this mypage group user.
	 *
	 * @return the create date of this mypage group user
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this mypage group user.
	 *
	 * @return the group ID of this mypage group user
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this mypage group user.
	 *
	 * @return the modified date of this mypage group user
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mypage group ID of this mypage group user.
	 *
	 * @return the mypage group ID of this mypage group user
	 */
	@Override
	public long getMypageGroupId() {
		return model.getMypageGroupId();
	}

	/**
	 * Returns the mypage group user ID of this mypage group user.
	 *
	 * @return the mypage group user ID of this mypage group user
	 */
	@Override
	public long getMypageGroupUserId() {
		return model.getMypageGroupUserId();
	}

	/**
	 * Returns the mypage group user uuid of this mypage group user.
	 *
	 * @return the mypage group user uuid of this mypage group user
	 */
	@Override
	public String getMypageGroupUserUuid() {
		return model.getMypageGroupUserUuid();
	}

	/**
	 * Returns the mypage user ID of this mypage group user.
	 *
	 * @return the mypage user ID of this mypage group user
	 */
	@Override
	public long getMypageUserId() {
		return model.getMypageUserId();
	}

	/**
	 * Returns the mypage user uuid of this mypage group user.
	 *
	 * @return the mypage user uuid of this mypage group user
	 */
	@Override
	public String getMypageUserUuid() {
		return model.getMypageUserUuid();
	}

	/**
	 * Returns the primary key of this mypage group user.
	 *
	 * @return the primary key of this mypage group user
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this mypage group user.
	 *
	 * @return the user ID of this mypage group user
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this mypage group user.
	 *
	 * @return the user name of this mypage group user
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this mypage group user.
	 *
	 * @return the user uuid of this mypage group user
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
	 * Sets the company ID of this mypage group user.
	 *
	 * @param companyId the company ID of this mypage group user
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this mypage group user.
	 *
	 * @param createDate the create date of this mypage group user
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this mypage group user.
	 *
	 * @param groupId the group ID of this mypage group user
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this mypage group user.
	 *
	 * @param modifiedDate the modified date of this mypage group user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mypage group ID of this mypage group user.
	 *
	 * @param mypageGroupId the mypage group ID of this mypage group user
	 */
	@Override
	public void setMypageGroupId(long mypageGroupId) {
		model.setMypageGroupId(mypageGroupId);
	}

	/**
	 * Sets the mypage group user ID of this mypage group user.
	 *
	 * @param mypageGroupUserId the mypage group user ID of this mypage group user
	 */
	@Override
	public void setMypageGroupUserId(long mypageGroupUserId) {
		model.setMypageGroupUserId(mypageGroupUserId);
	}

	/**
	 * Sets the mypage group user uuid of this mypage group user.
	 *
	 * @param mypageGroupUserUuid the mypage group user uuid of this mypage group user
	 */
	@Override
	public void setMypageGroupUserUuid(String mypageGroupUserUuid) {
		model.setMypageGroupUserUuid(mypageGroupUserUuid);
	}

	/**
	 * Sets the mypage user ID of this mypage group user.
	 *
	 * @param mypageUserId the mypage user ID of this mypage group user
	 */
	@Override
	public void setMypageUserId(long mypageUserId) {
		model.setMypageUserId(mypageUserId);
	}

	/**
	 * Sets the mypage user uuid of this mypage group user.
	 *
	 * @param mypageUserUuid the mypage user uuid of this mypage group user
	 */
	@Override
	public void setMypageUserUuid(String mypageUserUuid) {
		model.setMypageUserUuid(mypageUserUuid);
	}

	/**
	 * Sets the primary key of this mypage group user.
	 *
	 * @param primaryKey the primary key of this mypage group user
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this mypage group user.
	 *
	 * @param userId the user ID of this mypage group user
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this mypage group user.
	 *
	 * @param userName the user name of this mypage group user
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this mypage group user.
	 *
	 * @param userUuid the user uuid of this mypage group user
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MypageGroupUserWrapper wrap(MypageGroupUser mypageGroupUser) {
		return new MypageGroupUserWrapper(mypageGroupUser);
	}

}