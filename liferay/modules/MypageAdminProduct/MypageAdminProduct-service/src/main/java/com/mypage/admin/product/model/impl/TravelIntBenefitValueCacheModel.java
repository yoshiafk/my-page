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

package com.mypage.admin.product.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.mypage.admin.product.model.TravelIntBenefitValue;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TravelIntBenefitValue in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class TravelIntBenefitValueCacheModel
	implements CacheModel<TravelIntBenefitValue>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TravelIntBenefitValueCacheModel)) {
			return false;
		}

		TravelIntBenefitValueCacheModel travelIntBenefitValueCacheModel =
			(TravelIntBenefitValueCacheModel)object;

		if (travelIntBenefitValueId ==
				travelIntBenefitValueCacheModel.travelIntBenefitValueId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, travelIntBenefitValueId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{travelIntBenefitValueId=");
		sb.append(travelIntBenefitValueId);
		sb.append(", travelIntBenefitId=");
		sb.append(travelIntBenefitId);
		sb.append(", currencyName=");
		sb.append(currencyName);
		sb.append(", packageType=");
		sb.append(packageType);
		sb.append(", benefitValue=");
		sb.append(benefitValue);
		sb.append(", active=");
		sb.append(active);
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
	public TravelIntBenefitValue toEntityModel() {
		TravelIntBenefitValueImpl travelIntBenefitValueImpl =
			new TravelIntBenefitValueImpl();

		travelIntBenefitValueImpl.setTravelIntBenefitValueId(
			travelIntBenefitValueId);
		travelIntBenefitValueImpl.setTravelIntBenefitId(travelIntBenefitId);

		if (currencyName == null) {
			travelIntBenefitValueImpl.setCurrencyName("");
		}
		else {
			travelIntBenefitValueImpl.setCurrencyName(currencyName);
		}

		if (packageType == null) {
			travelIntBenefitValueImpl.setPackageType("");
		}
		else {
			travelIntBenefitValueImpl.setPackageType(packageType);
		}

		if (benefitValue == null) {
			travelIntBenefitValueImpl.setBenefitValue("");
		}
		else {
			travelIntBenefitValueImpl.setBenefitValue(benefitValue);
		}

		travelIntBenefitValueImpl.setActive(active);
		travelIntBenefitValueImpl.setGroupId(groupId);
		travelIntBenefitValueImpl.setCompanyId(companyId);
		travelIntBenefitValueImpl.setUserId(userId);

		if (userName == null) {
			travelIntBenefitValueImpl.setUserName("");
		}
		else {
			travelIntBenefitValueImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			travelIntBenefitValueImpl.setCreateDate(null);
		}
		else {
			travelIntBenefitValueImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			travelIntBenefitValueImpl.setModifiedDate(null);
		}
		else {
			travelIntBenefitValueImpl.setModifiedDate(new Date(modifiedDate));
		}

		travelIntBenefitValueImpl.resetOriginalValues();

		return travelIntBenefitValueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		travelIntBenefitValueId = objectInput.readLong();

		travelIntBenefitId = objectInput.readLong();
		currencyName = objectInput.readUTF();
		packageType = objectInput.readUTF();
		benefitValue = objectInput.readUTF();

		active = objectInput.readInt();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(travelIntBenefitValueId);

		objectOutput.writeLong(travelIntBenefitId);

		if (currencyName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currencyName);
		}

		if (packageType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(packageType);
		}

		if (benefitValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benefitValue);
		}

		objectOutput.writeInt(active);

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

	public long travelIntBenefitValueId;
	public long travelIntBenefitId;
	public String currencyName;
	public String packageType;
	public String benefitValue;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}