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

package com.mypage.leads.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.mypage.leads.model.DetailDomesticTravel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DetailDomesticTravel in entity cache.
 *
 * @author Gositus
 * @generated
 */
public class DetailDomesticTravelCacheModel
	implements CacheModel<DetailDomesticTravel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DetailDomesticTravelCacheModel)) {
			return false;
		}

		DetailDomesticTravelCacheModel detailDomesticTravelCacheModel =
			(DetailDomesticTravelCacheModel)object;

		if (detailDomesticTravelId ==
				detailDomesticTravelCacheModel.detailDomesticTravelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, detailDomesticTravelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{detailDomesticTravelId=");
		sb.append(detailDomesticTravelId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", LeadsId=");
		sb.append(LeadsId);
		sb.append(", TravelType=");
		sb.append(TravelType);
		sb.append(", TravelPlan=");
		sb.append(TravelPlan);
		sb.append(", TravellerType=");
		sb.append(TravellerType);
		sb.append(", Adult=");
		sb.append(Adult);
		sb.append(", Child=");
		sb.append(Child);
		sb.append(", DepartureDate=");
		sb.append(DepartureDate);
		sb.append(", ArrivalDate=");
		sb.append(ArrivalDate);
		sb.append(", CommercialOffers=");
		sb.append(CommercialOffers);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DetailDomesticTravel toEntityModel() {
		DetailDomesticTravelImpl detailDomesticTravelImpl =
			new DetailDomesticTravelImpl();

		detailDomesticTravelImpl.setDetailDomesticTravelId(
			detailDomesticTravelId);
		detailDomesticTravelImpl.setGroupId(groupId);
		detailDomesticTravelImpl.setCompanyId(companyId);
		detailDomesticTravelImpl.setUserId(userId);

		if (userName == null) {
			detailDomesticTravelImpl.setUserName("");
		}
		else {
			detailDomesticTravelImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			detailDomesticTravelImpl.setCreateDate(null);
		}
		else {
			detailDomesticTravelImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			detailDomesticTravelImpl.setModifiedDate(null);
		}
		else {
			detailDomesticTravelImpl.setModifiedDate(new Date(modifiedDate));
		}

		detailDomesticTravelImpl.setLeadsId(LeadsId);

		if (TravelType == null) {
			detailDomesticTravelImpl.setTravelType("");
		}
		else {
			detailDomesticTravelImpl.setTravelType(TravelType);
		}

		if (TravelPlan == null) {
			detailDomesticTravelImpl.setTravelPlan("");
		}
		else {
			detailDomesticTravelImpl.setTravelPlan(TravelPlan);
		}

		if (TravellerType == null) {
			detailDomesticTravelImpl.setTravellerType("");
		}
		else {
			detailDomesticTravelImpl.setTravellerType(TravellerType);
		}

		detailDomesticTravelImpl.setAdult(Adult);
		detailDomesticTravelImpl.setChild(Child);

		if (DepartureDate == Long.MIN_VALUE) {
			detailDomesticTravelImpl.setDepartureDate(null);
		}
		else {
			detailDomesticTravelImpl.setDepartureDate(new Date(DepartureDate));
		}

		if (ArrivalDate == Long.MIN_VALUE) {
			detailDomesticTravelImpl.setArrivalDate(null);
		}
		else {
			detailDomesticTravelImpl.setArrivalDate(new Date(ArrivalDate));
		}

		detailDomesticTravelImpl.setCommercialOffers(CommercialOffers);

		detailDomesticTravelImpl.resetOriginalValues();

		return detailDomesticTravelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		detailDomesticTravelId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		LeadsId = objectInput.readLong();
		TravelType = objectInput.readUTF();
		TravelPlan = objectInput.readUTF();
		TravellerType = objectInput.readUTF();

		Adult = objectInput.readInt();

		Child = objectInput.readInt();
		DepartureDate = objectInput.readLong();
		ArrivalDate = objectInput.readLong();

		CommercialOffers = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(detailDomesticTravelId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(LeadsId);

		if (TravelType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TravelType);
		}

		if (TravelPlan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TravelPlan);
		}

		if (TravellerType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TravellerType);
		}

		objectOutput.writeInt(Adult);

		objectOutput.writeInt(Child);
		objectOutput.writeLong(DepartureDate);
		objectOutput.writeLong(ArrivalDate);

		objectOutput.writeInt(CommercialOffers);
	}

	public long detailDomesticTravelId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long LeadsId;
	public String TravelType;
	public String TravelPlan;
	public String TravellerType;
	public int Adult;
	public int Child;
	public long DepartureDate;
	public long ArrivalDate;
	public int CommercialOffers;

}