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
 * This class is a wrapper for {@link MasterBranch}.
 * </p>
 *
 * @author Gositus Team
 * @see MasterBranch
 * @generated
 */
public class MasterBranchWrapper
	extends BaseModelWrapper<MasterBranch>
	implements MasterBranch, ModelWrapper<MasterBranch> {

	public MasterBranchWrapper(MasterBranch masterBranch) {
		super(masterBranch);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("masterBranchId", getMasterBranchId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("agiCode", getAgiCode());
		attributes.put("magiCode", getMagiCode());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long masterBranchId = (Long)attributes.get("masterBranchId");

		if (masterBranchId != null) {
			setMasterBranchId(masterBranchId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String agiCode = (String)attributes.get("agiCode");

		if (agiCode != null) {
			setAgiCode(agiCode);
		}

		String magiCode = (String)attributes.get("magiCode");

		if (magiCode != null) {
			setMagiCode(magiCode);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this master branch.
	 *
	 * @return the active of this master branch
	 */
	@Override
	public Integer getActive() {
		return model.getActive();
	}

	/**
	 * Returns the agi code of this master branch.
	 *
	 * @return the agi code of this master branch
	 */
	@Override
	public String getAgiCode() {
		return model.getAgiCode();
	}

	/**
	 * Returns the company ID of this master branch.
	 *
	 * @return the company ID of this master branch
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this master branch.
	 *
	 * @return the create date of this master branch
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this master branch.
	 *
	 * @return the group ID of this master branch
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the magi code of this master branch.
	 *
	 * @return the magi code of this master branch
	 */
	@Override
	public String getMagiCode() {
		return model.getMagiCode();
	}

	/**
	 * Returns the master branch ID of this master branch.
	 *
	 * @return the master branch ID of this master branch
	 */
	@Override
	public long getMasterBranchId() {
		return model.getMasterBranchId();
	}

	/**
	 * Returns the modified date of this master branch.
	 *
	 * @return the modified date of this master branch
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this master branch.
	 *
	 * @return the name of this master branch
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this master branch.
	 *
	 * @return the primary key of this master branch
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this master branch.
	 *
	 * @return the user ID of this master branch
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this master branch.
	 *
	 * @return the user name of this master branch
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this master branch.
	 *
	 * @return the user uuid of this master branch
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
	 * Sets the active of this master branch.
	 *
	 * @param active the active of this master branch
	 */
	@Override
	public void setActive(Integer active) {
		model.setActive(active);
	}

	/**
	 * Sets the agi code of this master branch.
	 *
	 * @param agiCode the agi code of this master branch
	 */
	@Override
	public void setAgiCode(String agiCode) {
		model.setAgiCode(agiCode);
	}

	/**
	 * Sets the company ID of this master branch.
	 *
	 * @param companyId the company ID of this master branch
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this master branch.
	 *
	 * @param createDate the create date of this master branch
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this master branch.
	 *
	 * @param groupId the group ID of this master branch
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the magi code of this master branch.
	 *
	 * @param magiCode the magi code of this master branch
	 */
	@Override
	public void setMagiCode(String magiCode) {
		model.setMagiCode(magiCode);
	}

	/**
	 * Sets the master branch ID of this master branch.
	 *
	 * @param masterBranchId the master branch ID of this master branch
	 */
	@Override
	public void setMasterBranchId(long masterBranchId) {
		model.setMasterBranchId(masterBranchId);
	}

	/**
	 * Sets the modified date of this master branch.
	 *
	 * @param modifiedDate the modified date of this master branch
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this master branch.
	 *
	 * @param name the name of this master branch
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this master branch.
	 *
	 * @param primaryKey the primary key of this master branch
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this master branch.
	 *
	 * @param userId the user ID of this master branch
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this master branch.
	 *
	 * @param userName the user name of this master branch
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this master branch.
	 *
	 * @param userUuid the user uuid of this master branch
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MasterBranchWrapper wrap(MasterBranch masterBranch) {
		return new MasterBranchWrapper(masterBranch);
	}

}