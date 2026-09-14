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
 * This class is a wrapper for {@link DetailDomesticTravel}.
 * </p>
 *
 * @author Gositus
 * @see DetailDomesticTravel
 * @generated
 */
public class DetailDomesticTravelWrapper
	extends BaseModelWrapper<DetailDomesticTravel>
	implements DetailDomesticTravel, ModelWrapper<DetailDomesticTravel> {

	public DetailDomesticTravelWrapper(
		DetailDomesticTravel detailDomesticTravel) {

		super(detailDomesticTravel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("detailDomesticTravelId", getDetailDomesticTravelId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("LeadsId", getLeadsId());
		attributes.put("TravelType", getTravelType());
		attributes.put("TravelPlan", getTravelPlan());
		attributes.put("TravellerType", getTravellerType());
		attributes.put("Adult", getAdult());
		attributes.put("Child", getChild());
		attributes.put("DepartureDate", getDepartureDate());
		attributes.put("ArrivalDate", getArrivalDate());
		attributes.put("CommercialOffers", getCommercialOffers());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long detailDomesticTravelId = (Long)attributes.get(
			"detailDomesticTravelId");

		if (detailDomesticTravelId != null) {
			setDetailDomesticTravelId(detailDomesticTravelId);
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

		Long LeadsId = (Long)attributes.get("LeadsId");

		if (LeadsId != null) {
			setLeadsId(LeadsId);
		}

		String TravelType = (String)attributes.get("TravelType");

		if (TravelType != null) {
			setTravelType(TravelType);
		}

		String TravelPlan = (String)attributes.get("TravelPlan");

		if (TravelPlan != null) {
			setTravelPlan(TravelPlan);
		}

		String TravellerType = (String)attributes.get("TravellerType");

		if (TravellerType != null) {
			setTravellerType(TravellerType);
		}

		Integer Adult = (Integer)attributes.get("Adult");

		if (Adult != null) {
			setAdult(Adult);
		}

		Integer Child = (Integer)attributes.get("Child");

		if (Child != null) {
			setChild(Child);
		}

		Date DepartureDate = (Date)attributes.get("DepartureDate");

		if (DepartureDate != null) {
			setDepartureDate(DepartureDate);
		}

		Date ArrivalDate = (Date)attributes.get("ArrivalDate");

		if (ArrivalDate != null) {
			setArrivalDate(ArrivalDate);
		}

		Integer CommercialOffers = (Integer)attributes.get("CommercialOffers");

		if (CommercialOffers != null) {
			setCommercialOffers(CommercialOffers);
		}
	}

	/**
	 * Returns the adult of this detail domestic travel.
	 *
	 * @return the adult of this detail domestic travel
	 */
	@Override
	public Integer getAdult() {
		return model.getAdult();
	}

	/**
	 * Returns the arrival date of this detail domestic travel.
	 *
	 * @return the arrival date of this detail domestic travel
	 */
	@Override
	public Date getArrivalDate() {
		return model.getArrivalDate();
	}

	/**
	 * Returns the child of this detail domestic travel.
	 *
	 * @return the child of this detail domestic travel
	 */
	@Override
	public Integer getChild() {
		return model.getChild();
	}

	/**
	 * Returns the commercial offers of this detail domestic travel.
	 *
	 * @return the commercial offers of this detail domestic travel
	 */
	@Override
	public Integer getCommercialOffers() {
		return model.getCommercialOffers();
	}

	/**
	 * Returns the company ID of this detail domestic travel.
	 *
	 * @return the company ID of this detail domestic travel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this detail domestic travel.
	 *
	 * @return the create date of this detail domestic travel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the departure date of this detail domestic travel.
	 *
	 * @return the departure date of this detail domestic travel
	 */
	@Override
	public Date getDepartureDate() {
		return model.getDepartureDate();
	}

	/**
	 * Returns the detail domestic travel ID of this detail domestic travel.
	 *
	 * @return the detail domestic travel ID of this detail domestic travel
	 */
	@Override
	public long getDetailDomesticTravelId() {
		return model.getDetailDomesticTravelId();
	}

	/**
	 * Returns the group ID of this detail domestic travel.
	 *
	 * @return the group ID of this detail domestic travel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the leads ID of this detail domestic travel.
	 *
	 * @return the leads ID of this detail domestic travel
	 */
	@Override
	public long getLeadsId() {
		return model.getLeadsId();
	}

	/**
	 * Returns the modified date of this detail domestic travel.
	 *
	 * @return the modified date of this detail domestic travel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this detail domestic travel.
	 *
	 * @return the primary key of this detail domestic travel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the traveller type of this detail domestic travel.
	 *
	 * @return the traveller type of this detail domestic travel
	 */
	@Override
	public String getTravellerType() {
		return model.getTravellerType();
	}

	/**
	 * Returns the travel plan of this detail domestic travel.
	 *
	 * @return the travel plan of this detail domestic travel
	 */
	@Override
	public String getTravelPlan() {
		return model.getTravelPlan();
	}

	/**
	 * Returns the travel type of this detail domestic travel.
	 *
	 * @return the travel type of this detail domestic travel
	 */
	@Override
	public String getTravelType() {
		return model.getTravelType();
	}

	/**
	 * Returns the user ID of this detail domestic travel.
	 *
	 * @return the user ID of this detail domestic travel
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this detail domestic travel.
	 *
	 * @return the user name of this detail domestic travel
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this detail domestic travel.
	 *
	 * @return the user uuid of this detail domestic travel
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
	 * Sets the adult of this detail domestic travel.
	 *
	 * @param Adult the adult of this detail domestic travel
	 */
	@Override
	public void setAdult(Integer Adult) {
		model.setAdult(Adult);
	}

	/**
	 * Sets the arrival date of this detail domestic travel.
	 *
	 * @param ArrivalDate the arrival date of this detail domestic travel
	 */
	@Override
	public void setArrivalDate(Date ArrivalDate) {
		model.setArrivalDate(ArrivalDate);
	}

	/**
	 * Sets the child of this detail domestic travel.
	 *
	 * @param Child the child of this detail domestic travel
	 */
	@Override
	public void setChild(Integer Child) {
		model.setChild(Child);
	}

	/**
	 * Sets the commercial offers of this detail domestic travel.
	 *
	 * @param CommercialOffers the commercial offers of this detail domestic travel
	 */
	@Override
	public void setCommercialOffers(Integer CommercialOffers) {
		model.setCommercialOffers(CommercialOffers);
	}

	/**
	 * Sets the company ID of this detail domestic travel.
	 *
	 * @param companyId the company ID of this detail domestic travel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this detail domestic travel.
	 *
	 * @param createDate the create date of this detail domestic travel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the departure date of this detail domestic travel.
	 *
	 * @param DepartureDate the departure date of this detail domestic travel
	 */
	@Override
	public void setDepartureDate(Date DepartureDate) {
		model.setDepartureDate(DepartureDate);
	}

	/**
	 * Sets the detail domestic travel ID of this detail domestic travel.
	 *
	 * @param detailDomesticTravelId the detail domestic travel ID of this detail domestic travel
	 */
	@Override
	public void setDetailDomesticTravelId(long detailDomesticTravelId) {
		model.setDetailDomesticTravelId(detailDomesticTravelId);
	}

	/**
	 * Sets the group ID of this detail domestic travel.
	 *
	 * @param groupId the group ID of this detail domestic travel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the leads ID of this detail domestic travel.
	 *
	 * @param LeadsId the leads ID of this detail domestic travel
	 */
	@Override
	public void setLeadsId(long LeadsId) {
		model.setLeadsId(LeadsId);
	}

	/**
	 * Sets the modified date of this detail domestic travel.
	 *
	 * @param modifiedDate the modified date of this detail domestic travel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this detail domestic travel.
	 *
	 * @param primaryKey the primary key of this detail domestic travel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the traveller type of this detail domestic travel.
	 *
	 * @param TravellerType the traveller type of this detail domestic travel
	 */
	@Override
	public void setTravellerType(String TravellerType) {
		model.setTravellerType(TravellerType);
	}

	/**
	 * Sets the travel plan of this detail domestic travel.
	 *
	 * @param TravelPlan the travel plan of this detail domestic travel
	 */
	@Override
	public void setTravelPlan(String TravelPlan) {
		model.setTravelPlan(TravelPlan);
	}

	/**
	 * Sets the travel type of this detail domestic travel.
	 *
	 * @param TravelType the travel type of this detail domestic travel
	 */
	@Override
	public void setTravelType(String TravelType) {
		model.setTravelType(TravelType);
	}

	/**
	 * Sets the user ID of this detail domestic travel.
	 *
	 * @param userId the user ID of this detail domestic travel
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this detail domestic travel.
	 *
	 * @param userName the user name of this detail domestic travel
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this detail domestic travel.
	 *
	 * @param userUuid the user uuid of this detail domestic travel
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected DetailDomesticTravelWrapper wrap(
		DetailDomesticTravel detailDomesticTravel) {

		return new DetailDomesticTravelWrapper(detailDomesticTravel);
	}

}