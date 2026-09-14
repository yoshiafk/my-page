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
 * This class is a wrapper for {@link SmartActiveTopro}.
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveTopro
 * @generated
 */
public class SmartActiveToproWrapper
	extends BaseModelWrapper<SmartActiveTopro>
	implements ModelWrapper<SmartActiveTopro>, SmartActiveTopro {

	public SmartActiveToproWrapper(SmartActiveTopro smartActiveTopro) {
		super(smartActiveTopro);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("smartActiveToproId", getSmartActiveToproId());
		attributes.put("topro", getTopro());
		attributes.put("description", getDescription());
		attributes.put("annotations", getAnnotations());
		attributes.put(
			"smartActiveBenefitValueId", getSmartActiveBenefitValueId());
		attributes.put("toc", getToc());
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
		Long smartActiveToproId = (Long)attributes.get("smartActiveToproId");

		if (smartActiveToproId != null) {
			setSmartActiveToproId(smartActiveToproId);
		}

		String topro = (String)attributes.get("topro");

		if (topro != null) {
			setTopro(topro);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String annotations = (String)attributes.get("annotations");

		if (annotations != null) {
			setAnnotations(annotations);
		}

		Long smartActiveBenefitValueId = (Long)attributes.get(
			"smartActiveBenefitValueId");

		if (smartActiveBenefitValueId != null) {
			setSmartActiveBenefitValueId(smartActiveBenefitValueId);
		}

		String toc = (String)attributes.get("toc");

		if (toc != null) {
			setToc(toc);
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
	 * Returns the active of this smart active topro.
	 *
	 * @return the active of this smart active topro
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the annotations of this smart active topro.
	 *
	 * @return the annotations of this smart active topro
	 */
	@Override
	public String getAnnotations() {
		return model.getAnnotations();
	}

	/**
	 * Returns the company ID of this smart active topro.
	 *
	 * @return the company ID of this smart active topro
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this smart active topro.
	 *
	 * @return the create date of this smart active topro
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this smart active topro.
	 *
	 * @return the description of this smart active topro
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this smart active topro.
	 *
	 * @return the group ID of this smart active topro
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this smart active topro.
	 *
	 * @return the modified date of this smart active topro
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this smart active topro.
	 *
	 * @return the primary key of this smart active topro
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the smart active benefit value ID of this smart active topro.
	 *
	 * @return the smart active benefit value ID of this smart active topro
	 */
	@Override
	public long getSmartActiveBenefitValueId() {
		return model.getSmartActiveBenefitValueId();
	}

	/**
	 * Returns the smart active topro ID of this smart active topro.
	 *
	 * @return the smart active topro ID of this smart active topro
	 */
	@Override
	public long getSmartActiveToproId() {
		return model.getSmartActiveToproId();
	}

	/**
	 * Returns the toc of this smart active topro.
	 *
	 * @return the toc of this smart active topro
	 */
	@Override
	public String getToc() {
		return model.getToc();
	}

	/**
	 * Returns the topro of this smart active topro.
	 *
	 * @return the topro of this smart active topro
	 */
	@Override
	public String getTopro() {
		return model.getTopro();
	}

	/**
	 * Returns the user ID of this smart active topro.
	 *
	 * @return the user ID of this smart active topro
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this smart active topro.
	 *
	 * @return the user name of this smart active topro
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this smart active topro.
	 *
	 * @return the user uuid of this smart active topro
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
	 * Sets the active of this smart active topro.
	 *
	 * @param active the active of this smart active topro
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the annotations of this smart active topro.
	 *
	 * @param annotations the annotations of this smart active topro
	 */
	@Override
	public void setAnnotations(String annotations) {
		model.setAnnotations(annotations);
	}

	/**
	 * Sets the company ID of this smart active topro.
	 *
	 * @param companyId the company ID of this smart active topro
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this smart active topro.
	 *
	 * @param createDate the create date of this smart active topro
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this smart active topro.
	 *
	 * @param description the description of this smart active topro
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this smart active topro.
	 *
	 * @param groupId the group ID of this smart active topro
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this smart active topro.
	 *
	 * @param modifiedDate the modified date of this smart active topro
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this smart active topro.
	 *
	 * @param primaryKey the primary key of this smart active topro
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the smart active benefit value ID of this smart active topro.
	 *
	 * @param smartActiveBenefitValueId the smart active benefit value ID of this smart active topro
	 */
	@Override
	public void setSmartActiveBenefitValueId(long smartActiveBenefitValueId) {
		model.setSmartActiveBenefitValueId(smartActiveBenefitValueId);
	}

	/**
	 * Sets the smart active topro ID of this smart active topro.
	 *
	 * @param smartActiveToproId the smart active topro ID of this smart active topro
	 */
	@Override
	public void setSmartActiveToproId(long smartActiveToproId) {
		model.setSmartActiveToproId(smartActiveToproId);
	}

	/**
	 * Sets the toc of this smart active topro.
	 *
	 * @param toc the toc of this smart active topro
	 */
	@Override
	public void setToc(String toc) {
		model.setToc(toc);
	}

	/**
	 * Sets the topro of this smart active topro.
	 *
	 * @param topro the topro of this smart active topro
	 */
	@Override
	public void setTopro(String topro) {
		model.setTopro(topro);
	}

	/**
	 * Sets the user ID of this smart active topro.
	 *
	 * @param userId the user ID of this smart active topro
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this smart active topro.
	 *
	 * @param userName the user name of this smart active topro
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this smart active topro.
	 *
	 * @param userUuid the user uuid of this smart active topro
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SmartActiveToproWrapper wrap(SmartActiveTopro smartActiveTopro) {
		return new SmartActiveToproWrapper(smartActiveTopro);
	}

}