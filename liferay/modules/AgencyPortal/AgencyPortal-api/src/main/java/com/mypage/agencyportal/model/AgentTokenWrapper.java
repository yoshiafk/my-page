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

package com.mypage.agencyportal.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AgentToken}.
 * </p>
 *
 * @author Gositus Team
 * @see AgentToken
 * @generated
 */
public class AgentTokenWrapper
	extends BaseModelWrapper<AgentToken>
	implements AgentToken, ModelWrapper<AgentToken> {

	public AgentTokenWrapper(AgentToken agentToken) {
		super(agentToken);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("agentTokenId", getAgentTokenId());
		attributes.put("deptCode", getDeptCode());
		attributes.put("token", getToken());
		attributes.put("isValid", getIsValid());
		attributes.put("apiRequestToken", getApiRequestToken());
		attributes.put("apiRequestTokenExpired", getApiRequestTokenExpired());
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
		Long agentTokenId = (Long)attributes.get("agentTokenId");

		if (agentTokenId != null) {
			setAgentTokenId(agentTokenId);
		}

		String deptCode = (String)attributes.get("deptCode");

		if (deptCode != null) {
			setDeptCode(deptCode);
		}

		String token = (String)attributes.get("token");

		if (token != null) {
			setToken(token);
		}

		Integer isValid = (Integer)attributes.get("isValid");

		if (isValid != null) {
			setIsValid(isValid);
		}

		String apiRequestToken = (String)attributes.get("apiRequestToken");

		if (apiRequestToken != null) {
			setApiRequestToken(apiRequestToken);
		}

		Date apiRequestTokenExpired = (Date)attributes.get(
			"apiRequestTokenExpired");

		if (apiRequestTokenExpired != null) {
			setApiRequestTokenExpired(apiRequestTokenExpired);
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
	 * Returns the agent token ID of this agent token.
	 *
	 * @return the agent token ID of this agent token
	 */
	@Override
	public long getAgentTokenId() {
		return model.getAgentTokenId();
	}

	/**
	 * Returns the api request token of this agent token.
	 *
	 * @return the api request token of this agent token
	 */
	@Override
	public String getApiRequestToken() {
		return model.getApiRequestToken();
	}

	/**
	 * Returns the api request token expired of this agent token.
	 *
	 * @return the api request token expired of this agent token
	 */
	@Override
	public Date getApiRequestTokenExpired() {
		return model.getApiRequestTokenExpired();
	}

	/**
	 * Returns the company ID of this agent token.
	 *
	 * @return the company ID of this agent token
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this agent token.
	 *
	 * @return the create date of this agent token
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the dept code of this agent token.
	 *
	 * @return the dept code of this agent token
	 */
	@Override
	public String getDeptCode() {
		return model.getDeptCode();
	}

	/**
	 * Returns the group ID of this agent token.
	 *
	 * @return the group ID of this agent token
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is valid of this agent token.
	 *
	 * @return the is valid of this agent token
	 */
	@Override
	public int getIsValid() {
		return model.getIsValid();
	}

	/**
	 * Returns the modified date of this agent token.
	 *
	 * @return the modified date of this agent token
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this agent token.
	 *
	 * @return the primary key of this agent token
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this agent token.
	 *
	 * @return the status of this agent token
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the token of this agent token.
	 *
	 * @return the token of this agent token
	 */
	@Override
	public String getToken() {
		return model.getToken();
	}

	/**
	 * Returns the trash entry created when this agent token was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this agent token.
	 *
	 * @return the trash entry created when this agent token was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this agent token.
	 *
	 * @return the class primary key of the trash entry for this agent token
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this agent token.
	 *
	 * @return the trash handler for this agent token
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this agent token.
	 *
	 * @return the user ID of this agent token
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this agent token.
	 *
	 * @return the user name of this agent token
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this agent token.
	 *
	 * @return the user uuid of this agent token
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this agent token is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this agent token is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this agent token is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this agent token is in the Recycle Bin; <code>false</code> otherwise
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
	 * Sets the agent token ID of this agent token.
	 *
	 * @param agentTokenId the agent token ID of this agent token
	 */
	@Override
	public void setAgentTokenId(long agentTokenId) {
		model.setAgentTokenId(agentTokenId);
	}

	/**
	 * Sets the api request token of this agent token.
	 *
	 * @param apiRequestToken the api request token of this agent token
	 */
	@Override
	public void setApiRequestToken(String apiRequestToken) {
		model.setApiRequestToken(apiRequestToken);
	}

	/**
	 * Sets the api request token expired of this agent token.
	 *
	 * @param apiRequestTokenExpired the api request token expired of this agent token
	 */
	@Override
	public void setApiRequestTokenExpired(Date apiRequestTokenExpired) {
		model.setApiRequestTokenExpired(apiRequestTokenExpired);
	}

	/**
	 * Sets the company ID of this agent token.
	 *
	 * @param companyId the company ID of this agent token
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this agent token.
	 *
	 * @param createDate the create date of this agent token
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the dept code of this agent token.
	 *
	 * @param deptCode the dept code of this agent token
	 */
	@Override
	public void setDeptCode(String deptCode) {
		model.setDeptCode(deptCode);
	}

	/**
	 * Sets the group ID of this agent token.
	 *
	 * @param groupId the group ID of this agent token
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the is valid of this agent token.
	 *
	 * @param isValid the is valid of this agent token
	 */
	@Override
	public void setIsValid(int isValid) {
		model.setIsValid(isValid);
	}

	/**
	 * Sets the modified date of this agent token.
	 *
	 * @param modifiedDate the modified date of this agent token
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this agent token.
	 *
	 * @param primaryKey the primary key of this agent token
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the token of this agent token.
	 *
	 * @param token the token of this agent token
	 */
	@Override
	public void setToken(String token) {
		model.setToken(token);
	}

	/**
	 * Sets the user ID of this agent token.
	 *
	 * @param userId the user ID of this agent token
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this agent token.
	 *
	 * @param userName the user name of this agent token
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this agent token.
	 *
	 * @param userUuid the user uuid of this agent token
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected AgentTokenWrapper wrap(AgentToken agentToken) {
		return new AgentTokenWrapper(agentToken);
	}

}