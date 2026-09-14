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
 * This class is a wrapper for {@link TravelDomesticRelationship}.
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticRelationship
 * @generated
 */
public class TravelDomesticRelationshipWrapper
	extends BaseModelWrapper<TravelDomesticRelationship>
	implements ModelWrapper<TravelDomesticRelationship>,
			   TravelDomesticRelationship {

	public TravelDomesticRelationshipWrapper(
		TravelDomesticRelationship travelDomesticRelationship) {

		super(travelDomesticRelationship);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"travelDomesticRelationshipId", getTravelDomesticRelationshipId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("sort", getSort());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long travelDomesticRelationshipId = (Long)attributes.get(
			"travelDomesticRelationshipId");

		if (travelDomesticRelationshipId != null) {
			setTravelDomesticRelationshipId(travelDomesticRelationshipId);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer sort = (Integer)attributes.get("sort");

		if (sort != null) {
			setSort(sort);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this travel domestic relationship.
	 *
	 * @return the active of this travel domestic relationship
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this travel domestic relationship.
	 *
	 * @return the company ID of this travel domestic relationship
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this travel domestic relationship.
	 *
	 * @return the create date of this travel domestic relationship
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this travel domestic relationship.
	 *
	 * @return the description of this travel domestic relationship
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this travel domestic relationship.
	 *
	 * @return the group ID of this travel domestic relationship
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this travel domestic relationship.
	 *
	 * @return the modified date of this travel domestic relationship
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this travel domestic relationship.
	 *
	 * @return the name of this travel domestic relationship
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this travel domestic relationship.
	 *
	 * @return the primary key of this travel domestic relationship
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sort of this travel domestic relationship.
	 *
	 * @return the sort of this travel domestic relationship
	 */
	@Override
	public int getSort() {
		return model.getSort();
	}

	/**
	 * Returns the status of this travel domestic relationship.
	 *
	 * @return the status of this travel domestic relationship
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the trash entry created when this travel domestic relationship was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this travel domestic relationship.
	 *
	 * @return the trash entry created when this travel domestic relationship was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this travel domestic relationship.
	 *
	 * @return the class primary key of the trash entry for this travel domestic relationship
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this travel domestic relationship.
	 *
	 * @return the trash handler for this travel domestic relationship
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the travel domestic relationship ID of this travel domestic relationship.
	 *
	 * @return the travel domestic relationship ID of this travel domestic relationship
	 */
	@Override
	public long getTravelDomesticRelationshipId() {
		return model.getTravelDomesticRelationshipId();
	}

	/**
	 * Returns the user ID of this travel domestic relationship.
	 *
	 * @return the user ID of this travel domestic relationship
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this travel domestic relationship.
	 *
	 * @return the user name of this travel domestic relationship
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this travel domestic relationship.
	 *
	 * @return the user uuid of this travel domestic relationship
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this travel domestic relationship is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this travel domestic relationship is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this travel domestic relationship is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this travel domestic relationship is in the Recycle Bin; <code>false</code> otherwise
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
	 * Sets the active of this travel domestic relationship.
	 *
	 * @param active the active of this travel domestic relationship
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this travel domestic relationship.
	 *
	 * @param companyId the company ID of this travel domestic relationship
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this travel domestic relationship.
	 *
	 * @param createDate the create date of this travel domestic relationship
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this travel domestic relationship.
	 *
	 * @param description the description of this travel domestic relationship
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this travel domestic relationship.
	 *
	 * @param groupId the group ID of this travel domestic relationship
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this travel domestic relationship.
	 *
	 * @param modifiedDate the modified date of this travel domestic relationship
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this travel domestic relationship.
	 *
	 * @param name the name of this travel domestic relationship
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this travel domestic relationship.
	 *
	 * @param primaryKey the primary key of this travel domestic relationship
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sort of this travel domestic relationship.
	 *
	 * @param sort the sort of this travel domestic relationship
	 */
	@Override
	public void setSort(int sort) {
		model.setSort(sort);
	}

	/**
	 * Sets the travel domestic relationship ID of this travel domestic relationship.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID of this travel domestic relationship
	 */
	@Override
	public void setTravelDomesticRelationshipId(
		long travelDomesticRelationshipId) {

		model.setTravelDomesticRelationshipId(travelDomesticRelationshipId);
	}

	/**
	 * Sets the user ID of this travel domestic relationship.
	 *
	 * @param userId the user ID of this travel domestic relationship
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this travel domestic relationship.
	 *
	 * @param userName the user name of this travel domestic relationship
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this travel domestic relationship.
	 *
	 * @param userUuid the user uuid of this travel domestic relationship
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TravelDomesticRelationshipWrapper wrap(
		TravelDomesticRelationship travelDomesticRelationship) {

		return new TravelDomesticRelationshipWrapper(
			travelDomesticRelationship);
	}

}