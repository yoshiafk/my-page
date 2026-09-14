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
 * This class is a wrapper for {@link SmartTravelIntLink}.
 * </p>
 *
 * @author Gositus Team
 * @see SmartTravelIntLink
 * @generated
 */
public class SmartTravelIntLinkWrapper
	extends BaseModelWrapper<SmartTravelIntLink>
	implements ModelWrapper<SmartTravelIntLink>, SmartTravelIntLink {

	public SmartTravelIntLinkWrapper(SmartTravelIntLink smartTravelIntLink) {
		super(smartTravelIntLink);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("smartTravelIntLinkId", getSmartTravelIntLinkId());
		attributes.put("linkType", getLinkType());
		attributes.put("linkTitle", getLinkTitle());
		attributes.put("linkHref", getLinkHref());
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
		Long smartTravelIntLinkId = (Long)attributes.get(
			"smartTravelIntLinkId");

		if (smartTravelIntLinkId != null) {
			setSmartTravelIntLinkId(smartTravelIntLinkId);
		}

		String linkType = (String)attributes.get("linkType");

		if (linkType != null) {
			setLinkType(linkType);
		}

		String linkTitle = (String)attributes.get("linkTitle");

		if (linkTitle != null) {
			setLinkTitle(linkTitle);
		}

		String linkHref = (String)attributes.get("linkHref");

		if (linkHref != null) {
			setLinkHref(linkHref);
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
	 * Returns the company ID of this smart travel int link.
	 *
	 * @return the company ID of this smart travel int link
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this smart travel int link.
	 *
	 * @return the create date of this smart travel int link
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this smart travel int link.
	 *
	 * @return the group ID of this smart travel int link
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the link href of this smart travel int link.
	 *
	 * @return the link href of this smart travel int link
	 */
	@Override
	public String getLinkHref() {
		return model.getLinkHref();
	}

	/**
	 * Returns the link title of this smart travel int link.
	 *
	 * @return the link title of this smart travel int link
	 */
	@Override
	public String getLinkTitle() {
		return model.getLinkTitle();
	}

	/**
	 * Returns the link type of this smart travel int link.
	 *
	 * @return the link type of this smart travel int link
	 */
	@Override
	public String getLinkType() {
		return model.getLinkType();
	}

	/**
	 * Returns the modified date of this smart travel int link.
	 *
	 * @return the modified date of this smart travel int link
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this smart travel int link.
	 *
	 * @return the primary key of this smart travel int link
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the smart travel int link ID of this smart travel int link.
	 *
	 * @return the smart travel int link ID of this smart travel int link
	 */
	@Override
	public long getSmartTravelIntLinkId() {
		return model.getSmartTravelIntLinkId();
	}

	/**
	 * Returns the user ID of this smart travel int link.
	 *
	 * @return the user ID of this smart travel int link
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this smart travel int link.
	 *
	 * @return the user name of this smart travel int link
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this smart travel int link.
	 *
	 * @return the user uuid of this smart travel int link
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
	 * Sets the company ID of this smart travel int link.
	 *
	 * @param companyId the company ID of this smart travel int link
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this smart travel int link.
	 *
	 * @param createDate the create date of this smart travel int link
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this smart travel int link.
	 *
	 * @param groupId the group ID of this smart travel int link
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the link href of this smart travel int link.
	 *
	 * @param linkHref the link href of this smart travel int link
	 */
	@Override
	public void setLinkHref(String linkHref) {
		model.setLinkHref(linkHref);
	}

	/**
	 * Sets the link title of this smart travel int link.
	 *
	 * @param linkTitle the link title of this smart travel int link
	 */
	@Override
	public void setLinkTitle(String linkTitle) {
		model.setLinkTitle(linkTitle);
	}

	/**
	 * Sets the link type of this smart travel int link.
	 *
	 * @param linkType the link type of this smart travel int link
	 */
	@Override
	public void setLinkType(String linkType) {
		model.setLinkType(linkType);
	}

	/**
	 * Sets the modified date of this smart travel int link.
	 *
	 * @param modifiedDate the modified date of this smart travel int link
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this smart travel int link.
	 *
	 * @param primaryKey the primary key of this smart travel int link
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the smart travel int link ID of this smart travel int link.
	 *
	 * @param smartTravelIntLinkId the smart travel int link ID of this smart travel int link
	 */
	@Override
	public void setSmartTravelIntLinkId(long smartTravelIntLinkId) {
		model.setSmartTravelIntLinkId(smartTravelIntLinkId);
	}

	/**
	 * Sets the user ID of this smart travel int link.
	 *
	 * @param userId the user ID of this smart travel int link
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this smart travel int link.
	 *
	 * @param userName the user name of this smart travel int link
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this smart travel int link.
	 *
	 * @param userUuid the user uuid of this smart travel int link
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SmartTravelIntLinkWrapper wrap(
		SmartTravelIntLink smartTravelIntLink) {

		return new SmartTravelIntLinkWrapper(smartTravelIntLink);
	}

}