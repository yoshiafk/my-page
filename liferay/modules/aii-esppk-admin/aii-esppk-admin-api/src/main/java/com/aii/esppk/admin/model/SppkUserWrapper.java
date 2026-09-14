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

package com.aii.esppk.admin.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SppkUser}.
 * </p>
 *
 * @author Gositus
 * @see SppkUser
 * @generated
 */
public class SppkUserWrapper
	extends BaseModelWrapper<SppkUser>
	implements ModelWrapper<SppkUser>, SppkUser {

	public SppkUserWrapper(SppkUser sppkUser) {
		super(sppkUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sppkUserId", getSppkUserId());
		attributes.put("sppkLoginCode", getSppkLoginCode());
		attributes.put("password", getPassword());
		attributes.put("fullName", getFullName());
		attributes.put("roleCode", getRoleCode());
		attributes.put("email", getEmail());
		attributes.put("allAccess", getAllAccess());
		attributes.put("accessData", getAccessData());
		attributes.put("accessMonitoring", getAccessMonitoring());
		attributes.put("active", getActive());
		attributes.put("expireDate", getExpireDate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("otpCode", getOtpCode());
		attributes.put("otpExpired", getOtpExpired());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sppkUserId = (Long)attributes.get("sppkUserId");

		if (sppkUserId != null) {
			setSppkUserId(sppkUserId);
		}

		String sppkLoginCode = (String)attributes.get("sppkLoginCode");

		if (sppkLoginCode != null) {
			setSppkLoginCode(sppkLoginCode);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String roleCode = (String)attributes.get("roleCode");

		if (roleCode != null) {
			setRoleCode(roleCode);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Integer allAccess = (Integer)attributes.get("allAccess");

		if (allAccess != null) {
			setAllAccess(allAccess);
		}

		Integer accessData = (Integer)attributes.get("accessData");

		if (accessData != null) {
			setAccessData(accessData);
		}

		Integer accessMonitoring = (Integer)attributes.get("accessMonitoring");

		if (accessMonitoring != null) {
			setAccessMonitoring(accessMonitoring);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Date expireDate = (Date)attributes.get("expireDate");

		if (expireDate != null) {
			setExpireDate(expireDate);
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

		String otpCode = (String)attributes.get("otpCode");

		if (otpCode != null) {
			setOtpCode(otpCode);
		}

		Date otpExpired = (Date)attributes.get("otpExpired");

		if (otpExpired != null) {
			setOtpExpired(otpExpired);
		}
	}

	/**
	 * Returns the access data of this sppk user.
	 *
	 * @return the access data of this sppk user
	 */
	@Override
	public int getAccessData() {
		return model.getAccessData();
	}

	/**
	 * Returns the access monitoring of this sppk user.
	 *
	 * @return the access monitoring of this sppk user
	 */
	@Override
	public int getAccessMonitoring() {
		return model.getAccessMonitoring();
	}

	/**
	 * Returns the active of this sppk user.
	 *
	 * @return the active of this sppk user
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the all access of this sppk user.
	 *
	 * @return the all access of this sppk user
	 */
	@Override
	public int getAllAccess() {
		return model.getAllAccess();
	}

	/**
	 * Returns the company ID of this sppk user.
	 *
	 * @return the company ID of this sppk user
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this sppk user.
	 *
	 * @return the create date of this sppk user
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this sppk user.
	 *
	 * @return the email of this sppk user
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the expire date of this sppk user.
	 *
	 * @return the expire date of this sppk user
	 */
	@Override
	public Date getExpireDate() {
		return model.getExpireDate();
	}

	/**
	 * Returns the full name of this sppk user.
	 *
	 * @return the full name of this sppk user
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the group ID of this sppk user.
	 *
	 * @return the group ID of this sppk user
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this sppk user.
	 *
	 * @return the modified date of this sppk user
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the otp code of this sppk user.
	 *
	 * @return the otp code of this sppk user
	 */
	@Override
	public String getOtpCode() {
		return model.getOtpCode();
	}

	/**
	 * Returns the otp expired of this sppk user.
	 *
	 * @return the otp expired of this sppk user
	 */
	@Override
	public Date getOtpExpired() {
		return model.getOtpExpired();
	}

	/**
	 * Returns the password of this sppk user.
	 *
	 * @return the password of this sppk user
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the primary key of this sppk user.
	 *
	 * @return the primary key of this sppk user
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role code of this sppk user.
	 *
	 * @return the role code of this sppk user
	 */
	@Override
	public String getRoleCode() {
		return model.getRoleCode();
	}

	/**
	 * Returns the sppk login code of this sppk user.
	 *
	 * @return the sppk login code of this sppk user
	 */
	@Override
	public String getSppkLoginCode() {
		return model.getSppkLoginCode();
	}

	/**
	 * Returns the sppk user ID of this sppk user.
	 *
	 * @return the sppk user ID of this sppk user
	 */
	@Override
	public long getSppkUserId() {
		return model.getSppkUserId();
	}

	/**
	 * Returns the sppk user uuid of this sppk user.
	 *
	 * @return the sppk user uuid of this sppk user
	 */
	@Override
	public String getSppkUserUuid() {
		return model.getSppkUserUuid();
	}

	/**
	 * Returns the status of this sppk user.
	 *
	 * @return the status of this sppk user
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the trash entry created when this sppk user was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this sppk user.
	 *
	 * @return the trash entry created when this sppk user was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this sppk user.
	 *
	 * @return the class primary key of the trash entry for this sppk user
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this sppk user.
	 *
	 * @return the trash handler for this sppk user
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this sppk user.
	 *
	 * @return the user ID of this sppk user
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this sppk user.
	 *
	 * @return the user name of this sppk user
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this sppk user.
	 *
	 * @return the user uuid of this sppk user
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this sppk user is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this sppk user is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this sppk user is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this sppk user is in the Recycle Bin; <code>false</code> otherwise
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
	 * Sets the access data of this sppk user.
	 *
	 * @param accessData the access data of this sppk user
	 */
	@Override
	public void setAccessData(int accessData) {
		model.setAccessData(accessData);
	}

	/**
	 * Sets the access monitoring of this sppk user.
	 *
	 * @param accessMonitoring the access monitoring of this sppk user
	 */
	@Override
	public void setAccessMonitoring(int accessMonitoring) {
		model.setAccessMonitoring(accessMonitoring);
	}

	/**
	 * Sets the active of this sppk user.
	 *
	 * @param active the active of this sppk user
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the all access of this sppk user.
	 *
	 * @param allAccess the all access of this sppk user
	 */
	@Override
	public void setAllAccess(int allAccess) {
		model.setAllAccess(allAccess);
	}

	/**
	 * Sets the company ID of this sppk user.
	 *
	 * @param companyId the company ID of this sppk user
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this sppk user.
	 *
	 * @param createDate the create date of this sppk user
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this sppk user.
	 *
	 * @param email the email of this sppk user
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the expire date of this sppk user.
	 *
	 * @param expireDate the expire date of this sppk user
	 */
	@Override
	public void setExpireDate(Date expireDate) {
		model.setExpireDate(expireDate);
	}

	/**
	 * Sets the full name of this sppk user.
	 *
	 * @param fullName the full name of this sppk user
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the group ID of this sppk user.
	 *
	 * @param groupId the group ID of this sppk user
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this sppk user.
	 *
	 * @param modifiedDate the modified date of this sppk user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the otp code of this sppk user.
	 *
	 * @param otpCode the otp code of this sppk user
	 */
	@Override
	public void setOtpCode(String otpCode) {
		model.setOtpCode(otpCode);
	}

	/**
	 * Sets the otp expired of this sppk user.
	 *
	 * @param otpExpired the otp expired of this sppk user
	 */
	@Override
	public void setOtpExpired(Date otpExpired) {
		model.setOtpExpired(otpExpired);
	}

	/**
	 * Sets the password of this sppk user.
	 *
	 * @param password the password of this sppk user
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the primary key of this sppk user.
	 *
	 * @param primaryKey the primary key of this sppk user
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role code of this sppk user.
	 *
	 * @param roleCode the role code of this sppk user
	 */
	@Override
	public void setRoleCode(String roleCode) {
		model.setRoleCode(roleCode);
	}

	/**
	 * Sets the sppk login code of this sppk user.
	 *
	 * @param sppkLoginCode the sppk login code of this sppk user
	 */
	@Override
	public void setSppkLoginCode(String sppkLoginCode) {
		model.setSppkLoginCode(sppkLoginCode);
	}

	/**
	 * Sets the sppk user ID of this sppk user.
	 *
	 * @param sppkUserId the sppk user ID of this sppk user
	 */
	@Override
	public void setSppkUserId(long sppkUserId) {
		model.setSppkUserId(sppkUserId);
	}

	/**
	 * Sets the sppk user uuid of this sppk user.
	 *
	 * @param sppkUserUuid the sppk user uuid of this sppk user
	 */
	@Override
	public void setSppkUserUuid(String sppkUserUuid) {
		model.setSppkUserUuid(sppkUserUuid);
	}

	/**
	 * Sets the user ID of this sppk user.
	 *
	 * @param userId the user ID of this sppk user
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this sppk user.
	 *
	 * @param userName the user name of this sppk user
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this sppk user.
	 *
	 * @param userUuid the user uuid of this sppk user
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SppkUserWrapper wrap(SppkUser sppkUser) {
		return new SppkUserWrapper(sppkUser);
	}

}