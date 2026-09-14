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

package com.mypage.leads.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DetailInternationalTravel}.
 * </p>
 *
 * @author Gositus
 * @see DetailInternationalTravel
 * @generated
 */
public class DetailInternationalTravelWrapper
	extends BaseModelWrapper<DetailInternationalTravel>
	implements DetailInternationalTravel,
			   ModelWrapper<DetailInternationalTravel> {

	public DetailInternationalTravelWrapper(
		DetailInternationalTravel detailInternationalTravel) {

		super(detailInternationalTravel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("DetailId", getDetailId());
		attributes.put("LeadsId", getLeadsId());
		attributes.put("TravelType", getTravelType());
		attributes.put("Destination", getDestination());
		attributes.put("PackageType", getPackageType());
		attributes.put("TravellerType", getTravellerType());
		attributes.put("DepartureDate", getDepartureDate());
		attributes.put("ArrivalDate", getArrivalDate());
		attributes.put("Adult", getAdult());
		attributes.put("Child", getChild());
		attributes.put("ListBenefitId", getListBenefitId());
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
		Long DetailId = (Long)attributes.get("DetailId");

		if (DetailId != null) {
			setDetailId(DetailId);
		}

		Long LeadsId = (Long)attributes.get("LeadsId");

		if (LeadsId != null) {
			setLeadsId(LeadsId);
		}

		String TravelType = (String)attributes.get("TravelType");

		if (TravelType != null) {
			setTravelType(TravelType);
		}

		String Destination = (String)attributes.get("Destination");

		if (Destination != null) {
			setDestination(Destination);
		}

		String PackageType = (String)attributes.get("PackageType");

		if (PackageType != null) {
			setPackageType(PackageType);
		}

		String TravellerType = (String)attributes.get("TravellerType");

		if (TravellerType != null) {
			setTravellerType(TravellerType);
		}

		Date DepartureDate = (Date)attributes.get("DepartureDate");

		if (DepartureDate != null) {
			setDepartureDate(DepartureDate);
		}

		Date ArrivalDate = (Date)attributes.get("ArrivalDate");

		if (ArrivalDate != null) {
			setArrivalDate(ArrivalDate);
		}

		Integer Adult = (Integer)attributes.get("Adult");

		if (Adult != null) {
			setAdult(Adult);
		}

		Integer Child = (Integer)attributes.get("Child");

		if (Child != null) {
			setChild(Child);
		}

		String ListBenefitId = (String)attributes.get("ListBenefitId");

		if (ListBenefitId != null) {
			setListBenefitId(ListBenefitId);
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
	 * Returns the adult of this detail international travel.
	 *
	 * @return the adult of this detail international travel
	 */
	@Override
	public Integer getAdult() {
		return model.getAdult();
	}

	/**
	 * Returns the arrival date of this detail international travel.
	 *
	 * @return the arrival date of this detail international travel
	 */
	@Override
	public Date getArrivalDate() {
		return model.getArrivalDate();
	}

	/**
	 * Returns the child of this detail international travel.
	 *
	 * @return the child of this detail international travel
	 */
	@Override
	public Integer getChild() {
		return model.getChild();
	}

	/**
	 * Returns the company ID of this detail international travel.
	 *
	 * @return the company ID of this detail international travel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this detail international travel.
	 *
	 * @return the create date of this detail international travel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the departure date of this detail international travel.
	 *
	 * @return the departure date of this detail international travel
	 */
	@Override
	public Date getDepartureDate() {
		return model.getDepartureDate();
	}

	/**
	 * Returns the destination of this detail international travel.
	 *
	 * @return the destination of this detail international travel
	 */
	@Override
	public String getDestination() {
		return model.getDestination();
	}

	/**
	 * Returns the detail ID of this detail international travel.
	 *
	 * @return the detail ID of this detail international travel
	 */
	@Override
	public long getDetailId() {
		return model.getDetailId();
	}

	/**
	 * Returns the group ID of this detail international travel.
	 *
	 * @return the group ID of this detail international travel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the leads ID of this detail international travel.
	 *
	 * @return the leads ID of this detail international travel
	 */
	@Override
	public long getLeadsId() {
		return model.getLeadsId();
	}

	/**
	 * Returns the list benefit ID of this detail international travel.
	 *
	 * @return the list benefit ID of this detail international travel
	 */
	@Override
	public String getListBenefitId() {
		return model.getListBenefitId();
	}

	/**
	 * Returns the modified date of this detail international travel.
	 *
	 * @return the modified date of this detail international travel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the package type of this detail international travel.
	 *
	 * @return the package type of this detail international travel
	 */
	@Override
	public String getPackageType() {
		return model.getPackageType();
	}

	/**
	 * Returns the primary key of this detail international travel.
	 *
	 * @return the primary key of this detail international travel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the traveller type of this detail international travel.
	 *
	 * @return the traveller type of this detail international travel
	 */
	@Override
	public String getTravellerType() {
		return model.getTravellerType();
	}

	/**
	 * Returns the travel type of this detail international travel.
	 *
	 * @return the travel type of this detail international travel
	 */
	@Override
	public String getTravelType() {
		return model.getTravelType();
	}

	/**
	 * Returns the user ID of this detail international travel.
	 *
	 * @return the user ID of this detail international travel
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this detail international travel.
	 *
	 * @return the user name of this detail international travel
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this detail international travel.
	 *
	 * @return the user uuid of this detail international travel
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
	 * Sets the adult of this detail international travel.
	 *
	 * @param Adult the adult of this detail international travel
	 */
	@Override
	public void setAdult(Integer Adult) {
		model.setAdult(Adult);
	}

	/**
	 * Sets the arrival date of this detail international travel.
	 *
	 * @param ArrivalDate the arrival date of this detail international travel
	 */
	@Override
	public void setArrivalDate(Date ArrivalDate) {
		model.setArrivalDate(ArrivalDate);
	}

	/**
	 * Sets the child of this detail international travel.
	 *
	 * @param Child the child of this detail international travel
	 */
	@Override
	public void setChild(Integer Child) {
		model.setChild(Child);
	}

	/**
	 * Sets the company ID of this detail international travel.
	 *
	 * @param companyId the company ID of this detail international travel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this detail international travel.
	 *
	 * @param createDate the create date of this detail international travel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the departure date of this detail international travel.
	 *
	 * @param DepartureDate the departure date of this detail international travel
	 */
	@Override
	public void setDepartureDate(Date DepartureDate) {
		model.setDepartureDate(DepartureDate);
	}

	/**
	 * Sets the destination of this detail international travel.
	 *
	 * @param Destination the destination of this detail international travel
	 */
	@Override
	public void setDestination(String Destination) {
		model.setDestination(Destination);
	}

	/**
	 * Sets the detail ID of this detail international travel.
	 *
	 * @param DetailId the detail ID of this detail international travel
	 */
	@Override
	public void setDetailId(long DetailId) {
		model.setDetailId(DetailId);
	}

	/**
	 * Sets the group ID of this detail international travel.
	 *
	 * @param groupId the group ID of this detail international travel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the leads ID of this detail international travel.
	 *
	 * @param LeadsId the leads ID of this detail international travel
	 */
	@Override
	public void setLeadsId(long LeadsId) {
		model.setLeadsId(LeadsId);
	}

	/**
	 * Sets the list benefit ID of this detail international travel.
	 *
	 * @param ListBenefitId the list benefit ID of this detail international travel
	 */
	@Override
	public void setListBenefitId(String ListBenefitId) {
		model.setListBenefitId(ListBenefitId);
	}

	/**
	 * Sets the modified date of this detail international travel.
	 *
	 * @param modifiedDate the modified date of this detail international travel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the package type of this detail international travel.
	 *
	 * @param PackageType the package type of this detail international travel
	 */
	@Override
	public void setPackageType(String PackageType) {
		model.setPackageType(PackageType);
	}

	/**
	 * Sets the primary key of this detail international travel.
	 *
	 * @param primaryKey the primary key of this detail international travel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the traveller type of this detail international travel.
	 *
	 * @param TravellerType the traveller type of this detail international travel
	 */
	@Override
	public void setTravellerType(String TravellerType) {
		model.setTravellerType(TravellerType);
	}

	/**
	 * Sets the travel type of this detail international travel.
	 *
	 * @param TravelType the travel type of this detail international travel
	 */
	@Override
	public void setTravelType(String TravelType) {
		model.setTravelType(TravelType);
	}

	/**
	 * Sets the user ID of this detail international travel.
	 *
	 * @param userId the user ID of this detail international travel
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this detail international travel.
	 *
	 * @param userName the user name of this detail international travel
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this detail international travel.
	 *
	 * @param userUuid the user uuid of this detail international travel
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected DetailInternationalTravelWrapper wrap(
		DetailInternationalTravel detailInternationalTravel) {

		return new DetailInternationalTravelWrapper(detailInternationalTravel);
	}

}