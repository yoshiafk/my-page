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
 * This class is a wrapper for {@link PetRemarks}.
 * </p>
 *
 * @author Gositus Team
 * @see PetRemarks
 * @generated
 */
public class PetRemarksWrapper
	extends BaseModelWrapper<PetRemarks>
	implements ModelWrapper<PetRemarks>, PetRemarks {

	public PetRemarksWrapper(PetRemarks petRemarks) {
		super(petRemarks);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("petRemarksId", getPetRemarksId());
		attributes.put("name", getName());
		attributes.put("code", getCode());
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
		Long petRemarksId = (Long)attributes.get("petRemarksId");

		if (petRemarksId != null) {
			setPetRemarksId(petRemarksId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
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
	 * Returns the active of this pet remarks.
	 *
	 * @return the active of this pet remarks
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the code of this pet remarks.
	 *
	 * @return the code of this pet remarks
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this pet remarks.
	 *
	 * @return the company ID of this pet remarks
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this pet remarks.
	 *
	 * @return the create date of this pet remarks
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this pet remarks.
	 *
	 * @return the group ID of this pet remarks
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this pet remarks.
	 *
	 * @return the modified date of this pet remarks
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this pet remarks.
	 *
	 * @return the name of this pet remarks
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the pet remarks ID of this pet remarks.
	 *
	 * @return the pet remarks ID of this pet remarks
	 */
	@Override
	public long getPetRemarksId() {
		return model.getPetRemarksId();
	}

	/**
	 * Returns the primary key of this pet remarks.
	 *
	 * @return the primary key of this pet remarks
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this pet remarks.
	 *
	 * @return the status of this pet remarks
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the trash entry created when this pet remarks was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this pet remarks.
	 *
	 * @return the trash entry created when this pet remarks was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this pet remarks.
	 *
	 * @return the class primary key of the trash entry for this pet remarks
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this pet remarks.
	 *
	 * @return the trash handler for this pet remarks
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this pet remarks.
	 *
	 * @return the user ID of this pet remarks
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this pet remarks.
	 *
	 * @return the user name of this pet remarks
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this pet remarks.
	 *
	 * @return the user uuid of this pet remarks
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this pet remarks is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this pet remarks is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this pet remarks is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this pet remarks is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer() {
		return model.isInTrashContainer();
	}

	@Override
	public boolean isInTrashExplicitly() {
		return model.isInTrashExplicitly();
	}

	@Override
	public boolean isInTrashImplicitly() {
		return model.isInTrashImplicitly();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this pet remarks.
	 *
	 * @param active the active of this pet remarks
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the code of this pet remarks.
	 *
	 * @param code the code of this pet remarks
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this pet remarks.
	 *
	 * @param companyId the company ID of this pet remarks
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this pet remarks.
	 *
	 * @param createDate the create date of this pet remarks
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this pet remarks.
	 *
	 * @param groupId the group ID of this pet remarks
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this pet remarks.
	 *
	 * @param modifiedDate the modified date of this pet remarks
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this pet remarks.
	 *
	 * @param name the name of this pet remarks
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the pet remarks ID of this pet remarks.
	 *
	 * @param petRemarksId the pet remarks ID of this pet remarks
	 */
	@Override
	public void setPetRemarksId(long petRemarksId) {
		model.setPetRemarksId(petRemarksId);
	}

	/**
	 * Sets the primary key of this pet remarks.
	 *
	 * @param primaryKey the primary key of this pet remarks
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this pet remarks.
	 *
	 * @param userId the user ID of this pet remarks
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this pet remarks.
	 *
	 * @param userName the user name of this pet remarks
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this pet remarks.
	 *
	 * @param userUuid the user uuid of this pet remarks
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PetRemarksWrapper wrap(PetRemarks petRemarks) {
		return new PetRemarksWrapper(petRemarks);
	}

}