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
 * This class is a wrapper for {@link MypageUserLicenses}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserLicenses
 * @generated
 */
public class MypageUserLicensesWrapper
	extends BaseModelWrapper<MypageUserLicenses>
	implements ModelWrapper<MypageUserLicenses>, MypageUserLicenses {

	public MypageUserLicensesWrapper(MypageUserLicenses mypageUserLicenses) {
		super(mypageUserLicenses);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mypageUserLicensesId", getMypageUserLicensesId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("mypageUserId", getMypageUserId());
		attributes.put("productId", getProductId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mypageUserLicensesId = (Long)attributes.get(
			"mypageUserLicensesId");

		if (mypageUserLicensesId != null) {
			setMypageUserLicensesId(mypageUserLicensesId);
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

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}
	}

	/**
	 * Returns the company ID of this mypage user licenses.
	 *
	 * @return the company ID of this mypage user licenses
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this mypage user licenses.
	 *
	 * @return the create date of this mypage user licenses
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this mypage user licenses.
	 *
	 * @return the group ID of this mypage user licenses
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this mypage user licenses.
	 *
	 * @return the modified date of this mypage user licenses
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mypage user ID of this mypage user licenses.
	 *
	 * @return the mypage user ID of this mypage user licenses
	 */
	@Override
	public long getMypageUserId() {
		return model.getMypageUserId();
	}

	/**
	 * Returns the mypage user licenses ID of this mypage user licenses.
	 *
	 * @return the mypage user licenses ID of this mypage user licenses
	 */
	@Override
	public long getMypageUserLicensesId() {
		return model.getMypageUserLicensesId();
	}

	/**
	 * Returns the mypage user uuid of this mypage user licenses.
	 *
	 * @return the mypage user uuid of this mypage user licenses
	 */
	@Override
	public String getMypageUserUuid() {
		return model.getMypageUserUuid();
	}

	/**
	 * Returns the primary key of this mypage user licenses.
	 *
	 * @return the primary key of this mypage user licenses
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product ID of this mypage user licenses.
	 *
	 * @return the product ID of this mypage user licenses
	 */
	@Override
	public long getProductId() {
		return model.getProductId();
	}

	/**
	 * Returns the user ID of this mypage user licenses.
	 *
	 * @return the user ID of this mypage user licenses
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this mypage user licenses.
	 *
	 * @return the user name of this mypage user licenses
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this mypage user licenses.
	 *
	 * @return the user uuid of this mypage user licenses
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
	 * Sets the company ID of this mypage user licenses.
	 *
	 * @param companyId the company ID of this mypage user licenses
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this mypage user licenses.
	 *
	 * @param createDate the create date of this mypage user licenses
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this mypage user licenses.
	 *
	 * @param groupId the group ID of this mypage user licenses
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this mypage user licenses.
	 *
	 * @param modifiedDate the modified date of this mypage user licenses
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mypage user ID of this mypage user licenses.
	 *
	 * @param mypageUserId the mypage user ID of this mypage user licenses
	 */
	@Override
	public void setMypageUserId(long mypageUserId) {
		model.setMypageUserId(mypageUserId);
	}

	/**
	 * Sets the mypage user licenses ID of this mypage user licenses.
	 *
	 * @param mypageUserLicensesId the mypage user licenses ID of this mypage user licenses
	 */
	@Override
	public void setMypageUserLicensesId(long mypageUserLicensesId) {
		model.setMypageUserLicensesId(mypageUserLicensesId);
	}

	/**
	 * Sets the mypage user uuid of this mypage user licenses.
	 *
	 * @param mypageUserUuid the mypage user uuid of this mypage user licenses
	 */
	@Override
	public void setMypageUserUuid(String mypageUserUuid) {
		model.setMypageUserUuid(mypageUserUuid);
	}

	/**
	 * Sets the primary key of this mypage user licenses.
	 *
	 * @param primaryKey the primary key of this mypage user licenses
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product ID of this mypage user licenses.
	 *
	 * @param productId the product ID of this mypage user licenses
	 */
	@Override
	public void setProductId(long productId) {
		model.setProductId(productId);
	}

	/**
	 * Sets the user ID of this mypage user licenses.
	 *
	 * @param userId the user ID of this mypage user licenses
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this mypage user licenses.
	 *
	 * @param userName the user name of this mypage user licenses
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this mypage user licenses.
	 *
	 * @param userUuid the user uuid of this mypage user licenses
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MypageUserLicensesWrapper wrap(
		MypageUserLicenses mypageUserLicenses) {

		return new MypageUserLicensesWrapper(mypageUserLicenses);
	}

}