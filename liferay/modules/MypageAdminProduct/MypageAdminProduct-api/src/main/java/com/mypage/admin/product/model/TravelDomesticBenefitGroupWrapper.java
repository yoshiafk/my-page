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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TravelDomesticBenefitGroup}.
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticBenefitGroup
 * @generated
 */
public class TravelDomesticBenefitGroupWrapper
	extends BaseModelWrapper<TravelDomesticBenefitGroup>
	implements ModelWrapper<TravelDomesticBenefitGroup>,
			   TravelDomesticBenefitGroup {

	public TravelDomesticBenefitGroupWrapper(
		TravelDomesticBenefitGroup travelDomesticBenefitGroup) {

		super(travelDomesticBenefitGroup);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"travelDomesticBenefitGroupId", getTravelDomesticBenefitGroupId());
		attributes.put("code", getCode());
		attributes.put("name", getName());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long travelDomesticBenefitGroupId = (Long)attributes.get(
			"travelDomesticBenefitGroupId");

		if (travelDomesticBenefitGroupId != null) {
			setTravelDomesticBenefitGroupId(travelDomesticBenefitGroupId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this travel domestic benefit group.
	 *
	 * @return the active of this travel domestic benefit group
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the code of this travel domestic benefit group.
	 *
	 * @return the code of this travel domestic benefit group
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the name of this travel domestic benefit group.
	 *
	 * @return the name of this travel domestic benefit group
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this travel domestic benefit group.
	 *
	 * @return the primary key of this travel domestic benefit group
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this travel domestic benefit group.
	 *
	 * @return the status of this travel domestic benefit group
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the trash entry created when this travel domestic benefit group was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this travel domestic benefit group.
	 *
	 * @return the trash entry created when this travel domestic benefit group was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this travel domestic benefit group.
	 *
	 * @return the class primary key of the trash entry for this travel domestic benefit group
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this travel domestic benefit group.
	 *
	 * @return the trash handler for this travel domestic benefit group
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the travel domestic benefit group ID of this travel domestic benefit group.
	 *
	 * @return the travel domestic benefit group ID of this travel domestic benefit group
	 */
	@Override
	public long getTravelDomesticBenefitGroupId() {
		return model.getTravelDomesticBenefitGroupId();
	}

	/**
	 * Returns <code>true</code> if this travel domestic benefit group is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this travel domestic benefit group is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this travel domestic benefit group is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this travel domestic benefit group is in the Recycle Bin; <code>false</code> otherwise
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
	 * Sets the active of this travel domestic benefit group.
	 *
	 * @param active the active of this travel domestic benefit group
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the code of this travel domestic benefit group.
	 *
	 * @param code the code of this travel domestic benefit group
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the name of this travel domestic benefit group.
	 *
	 * @param name the name of this travel domestic benefit group
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this travel domestic benefit group.
	 *
	 * @param primaryKey the primary key of this travel domestic benefit group
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the travel domestic benefit group ID of this travel domestic benefit group.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID of this travel domestic benefit group
	 */
	@Override
	public void setTravelDomesticBenefitGroupId(
		long travelDomesticBenefitGroupId) {

		model.setTravelDomesticBenefitGroupId(travelDomesticBenefitGroupId);
	}

	@Override
	protected TravelDomesticBenefitGroupWrapper wrap(
		TravelDomesticBenefitGroup travelDomesticBenefitGroup) {

		return new TravelDomesticBenefitGroupWrapper(
			travelDomesticBenefitGroup);
	}

}