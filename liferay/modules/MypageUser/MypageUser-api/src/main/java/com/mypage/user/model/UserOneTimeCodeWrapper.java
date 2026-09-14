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
 * This class is a wrapper for {@link UserOneTimeCode}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserOneTimeCode
 * @generated
 */
public class UserOneTimeCodeWrapper
	extends BaseModelWrapper<UserOneTimeCode>
	implements ModelWrapper<UserOneTimeCode>, UserOneTimeCode {

	public UserOneTimeCodeWrapper(UserOneTimeCode userOneTimeCode) {
		super(userOneTimeCode);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userOneTimeCodeId", getUserOneTimeCodeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("sharedSecret", getSharedSecret());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("expiryDate", getExpiryDate());
		attributes.put("TimestampExpiryDate", getTimestampExpiryDate());
		attributes.put("isUsed", getIsUsed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userOneTimeCodeId = (Long)attributes.get("userOneTimeCodeId");

		if (userOneTimeCodeId != null) {
			setUserOneTimeCodeId(userOneTimeCodeId);
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

		String sharedSecret = (String)attributes.get("sharedSecret");

		if (sharedSecret != null) {
			setSharedSecret(sharedSecret);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date expiryDate = (Date)attributes.get("expiryDate");

		if (expiryDate != null) {
			setExpiryDate(expiryDate);
		}

		Long TimestampExpiryDate = (Long)attributes.get("TimestampExpiryDate");

		if (TimestampExpiryDate != null) {
			setTimestampExpiryDate(TimestampExpiryDate);
		}

		Integer isUsed = (Integer)attributes.get("isUsed");

		if (isUsed != null) {
			setIsUsed(isUsed);
		}
	}

	/**
	 * Returns the company ID of this user one time code.
	 *
	 * @return the company ID of this user one time code
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this user one time code.
	 *
	 * @return the create date of this user one time code
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the expiry date of this user one time code.
	 *
	 * @return the expiry date of this user one time code
	 */
	@Override
	public Date getExpiryDate() {
		return model.getExpiryDate();
	}

	/**
	 * Returns the group ID of this user one time code.
	 *
	 * @return the group ID of this user one time code
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is used of this user one time code.
	 *
	 * @return the is used of this user one time code
	 */
	@Override
	public int getIsUsed() {
		return model.getIsUsed();
	}

	/**
	 * Returns the modified date of this user one time code.
	 *
	 * @return the modified date of this user one time code
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this user one time code.
	 *
	 * @return the primary key of this user one time code
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the shared secret of this user one time code.
	 *
	 * @return the shared secret of this user one time code
	 */
	@Override
	public String getSharedSecret() {
		return model.getSharedSecret();
	}

	/**
	 * Returns the timestamp expiry date of this user one time code.
	 *
	 * @return the timestamp expiry date of this user one time code
	 */
	@Override
	public long getTimestampExpiryDate() {
		return model.getTimestampExpiryDate();
	}

	/**
	 * Returns the user ID of this user one time code.
	 *
	 * @return the user ID of this user one time code
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user one time code ID of this user one time code.
	 *
	 * @return the user one time code ID of this user one time code
	 */
	@Override
	public long getUserOneTimeCodeId() {
		return model.getUserOneTimeCodeId();
	}

	/**
	 * Returns the user uuid of this user one time code.
	 *
	 * @return the user uuid of this user one time code
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
	 * Sets the company ID of this user one time code.
	 *
	 * @param companyId the company ID of this user one time code
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this user one time code.
	 *
	 * @param createDate the create date of this user one time code
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the expiry date of this user one time code.
	 *
	 * @param expiryDate the expiry date of this user one time code
	 */
	@Override
	public void setExpiryDate(Date expiryDate) {
		model.setExpiryDate(expiryDate);
	}

	/**
	 * Sets the group ID of this user one time code.
	 *
	 * @param groupId the group ID of this user one time code
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the is used of this user one time code.
	 *
	 * @param isUsed the is used of this user one time code
	 */
	@Override
	public void setIsUsed(int isUsed) {
		model.setIsUsed(isUsed);
	}

	/**
	 * Sets the modified date of this user one time code.
	 *
	 * @param modifiedDate the modified date of this user one time code
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this user one time code.
	 *
	 * @param primaryKey the primary key of this user one time code
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the shared secret of this user one time code.
	 *
	 * @param sharedSecret the shared secret of this user one time code
	 */
	@Override
	public void setSharedSecret(String sharedSecret) {
		model.setSharedSecret(sharedSecret);
	}

	/**
	 * Sets the timestamp expiry date of this user one time code.
	 *
	 * @param TimestampExpiryDate the timestamp expiry date of this user one time code
	 */
	@Override
	public void setTimestampExpiryDate(long TimestampExpiryDate) {
		model.setTimestampExpiryDate(TimestampExpiryDate);
	}

	/**
	 * Sets the user ID of this user one time code.
	 *
	 * @param userId the user ID of this user one time code
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user one time code ID of this user one time code.
	 *
	 * @param userOneTimeCodeId the user one time code ID of this user one time code
	 */
	@Override
	public void setUserOneTimeCodeId(long userOneTimeCodeId) {
		model.setUserOneTimeCodeId(userOneTimeCodeId);
	}

	/**
	 * Sets the user uuid of this user one time code.
	 *
	 * @param userUuid the user uuid of this user one time code
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected UserOneTimeCodeWrapper wrap(UserOneTimeCode userOneTimeCode) {
		return new UserOneTimeCodeWrapper(userOneTimeCode);
	}

}