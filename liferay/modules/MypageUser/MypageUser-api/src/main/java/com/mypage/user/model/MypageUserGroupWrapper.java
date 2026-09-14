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
 * This class is a wrapper for {@link MypageUserGroup}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserGroup
 * @generated
 */
public class MypageUserGroupWrapper
	extends BaseModelWrapper<MypageUserGroup>
	implements ModelWrapper<MypageUserGroup>, MypageUserGroup {

	public MypageUserGroupWrapper(MypageUserGroup mypageUserGroup) {
		super(mypageUserGroup);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mypageUserGroupId", getMypageUserGroupId());
		attributes.put("name", getName());
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
		Long mypageUserGroupId = (Long)attributes.get("mypageUserGroupId");

		if (mypageUserGroupId != null) {
			setMypageUserGroupId(mypageUserGroupId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
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
	 * Returns the active of this mypage user group.
	 *
	 * @return the active of this mypage user group
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this mypage user group.
	 *
	 * @return the company ID of this mypage user group
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this mypage user group.
	 *
	 * @return the create date of this mypage user group
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this mypage user group.
	 *
	 * @return the group ID of this mypage user group
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this mypage user group.
	 *
	 * @return the modified date of this mypage user group
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mypage user group ID of this mypage user group.
	 *
	 * @return the mypage user group ID of this mypage user group
	 */
	@Override
	public long getMypageUserGroupId() {
		return model.getMypageUserGroupId();
	}

	/**
	 * Returns the name of this mypage user group.
	 *
	 * @return the name of this mypage user group
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this mypage user group.
	 *
	 * @return the primary key of this mypage user group
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this mypage user group.
	 *
	 * @return the user ID of this mypage user group
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this mypage user group.
	 *
	 * @return the user name of this mypage user group
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this mypage user group.
	 *
	 * @return the user uuid of this mypage user group
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
	 * Sets the active of this mypage user group.
	 *
	 * @param active the active of this mypage user group
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this mypage user group.
	 *
	 * @param companyId the company ID of this mypage user group
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this mypage user group.
	 *
	 * @param createDate the create date of this mypage user group
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this mypage user group.
	 *
	 * @param groupId the group ID of this mypage user group
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this mypage user group.
	 *
	 * @param modifiedDate the modified date of this mypage user group
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mypage user group ID of this mypage user group.
	 *
	 * @param mypageUserGroupId the mypage user group ID of this mypage user group
	 */
	@Override
	public void setMypageUserGroupId(long mypageUserGroupId) {
		model.setMypageUserGroupId(mypageUserGroupId);
	}

	/**
	 * Sets the name of this mypage user group.
	 *
	 * @param name the name of this mypage user group
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this mypage user group.
	 *
	 * @param primaryKey the primary key of this mypage user group
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this mypage user group.
	 *
	 * @param userId the user ID of this mypage user group
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this mypage user group.
	 *
	 * @param userName the user name of this mypage user group
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this mypage user group.
	 *
	 * @param userUuid the user uuid of this mypage user group
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MypageUserGroupWrapper wrap(MypageUserGroup mypageUserGroup) {
		return new MypageUserGroupWrapper(mypageUserGroup);
	}

}