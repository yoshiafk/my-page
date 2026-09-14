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

import com.mypage.leads.model.DetailInternationalTravel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DetailInternationalTravel in entity cache.
 *
 * @author Gositus
 * @generated
 */
public class DetailInternationalTravelCacheModel
	implements CacheModel<DetailInternationalTravel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DetailInternationalTravelCacheModel)) {
			return false;
		}

		DetailInternationalTravelCacheModel
			detailInternationalTravelCacheModel =
				(DetailInternationalTravelCacheModel)object;

		if (DetailId == detailInternationalTravelCacheModel.DetailId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, DetailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{DetailId=");
		sb.append(DetailId);
		sb.append(", LeadsId=");
		sb.append(LeadsId);
		sb.append(", TravelType=");
		sb.append(TravelType);
		sb.append(", Destination=");
		sb.append(Destination);
		sb.append(", PackageType=");
		sb.append(PackageType);
		sb.append(", TravellerType=");
		sb.append(TravellerType);
		sb.append(", DepartureDate=");
		sb.append(DepartureDate);
		sb.append(", ArrivalDate=");
		sb.append(ArrivalDate);
		sb.append(", Adult=");
		sb.append(Adult);
		sb.append(", Child=");
		sb.append(Child);
		sb.append(", ListBenefitId=");
		sb.append(ListBenefitId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DetailInternationalTravel toEntityModel() {
		DetailInternationalTravelImpl detailInternationalTravelImpl =
			new DetailInternationalTravelImpl();

		detailInternationalTravelImpl.setDetailId(DetailId);
		detailInternationalTravelImpl.setLeadsId(LeadsId);

		if (TravelType == null) {
			detailInternationalTravelImpl.setTravelType("");
		}
		else {
			detailInternationalTravelImpl.setTravelType(TravelType);
		}

		if (Destination == null) {
			detailInternationalTravelImpl.setDestination("");
		}
		else {
			detailInternationalTravelImpl.setDestination(Destination);
		}

		if (PackageType == null) {
			detailInternationalTravelImpl.setPackageType("");
		}
		else {
			detailInternationalTravelImpl.setPackageType(PackageType);
		}

		if (TravellerType == null) {
			detailInternationalTravelImpl.setTravellerType("");
		}
		else {
			detailInternationalTravelImpl.setTravellerType(TravellerType);
		}

		if (DepartureDate == Long.MIN_VALUE) {
			detailInternationalTravelImpl.setDepartureDate(null);
		}
		else {
			detailInternationalTravelImpl.setDepartureDate(
				new Date(DepartureDate));
		}

		if (ArrivalDate == Long.MIN_VALUE) {
			detailInternationalTravelImpl.setArrivalDate(null);
		}
		else {
			detailInternationalTravelImpl.setArrivalDate(new Date(ArrivalDate));
		}

		detailInternationalTravelImpl.setAdult(Adult);
		detailInternationalTravelImpl.setChild(Child);

		if (ListBenefitId == null) {
			detailInternationalTravelImpl.setListBenefitId("");
		}
		else {
			detailInternationalTravelImpl.setListBenefitId(ListBenefitId);
		}

		detailInternationalTravelImpl.setGroupId(groupId);
		detailInternationalTravelImpl.setCompanyId(companyId);
		detailInternationalTravelImpl.setUserId(userId);

		if (userName == null) {
			detailInternationalTravelImpl.setUserName("");
		}
		else {
			detailInternationalTravelImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			detailInternationalTravelImpl.setCreateDate(null);
		}
		else {
			detailInternationalTravelImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			detailInternationalTravelImpl.setModifiedDate(null);
		}
		else {
			detailInternationalTravelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		detailInternationalTravelImpl.resetOriginalValues();

		return detailInternationalTravelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		DetailId = objectInput.readLong();

		LeadsId = objectInput.readLong();
		TravelType = objectInput.readUTF();
		Destination = objectInput.readUTF();
		PackageType = objectInput.readUTF();
		TravellerType = objectInput.readUTF();
		DepartureDate = objectInput.readLong();
		ArrivalDate = objectInput.readLong();

		Adult = objectInput.readInt();

		Child = objectInput.readInt();
		ListBenefitId = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(DetailId);

		objectOutput.writeLong(LeadsId);

		if (TravelType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TravelType);
		}

		if (Destination == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Destination);
		}

		if (PackageType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PackageType);
		}

		if (TravellerType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TravellerType);
		}

		objectOutput.writeLong(DepartureDate);
		objectOutput.writeLong(ArrivalDate);

		objectOutput.writeInt(Adult);

		objectOutput.writeInt(Child);

		if (ListBenefitId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ListBenefitId);
		}

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
	}

	public long DetailId;
	public long LeadsId;
	public String TravelType;
	public String Destination;
	public String PackageType;
	public String TravellerType;
	public long DepartureDate;
	public long ArrivalDate;
	public int Adult;
	public int Child;
	public String ListBenefitId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}