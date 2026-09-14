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

import com.mypage.admin.product.model.TravelIntBenefit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TravelIntBenefit in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class TravelIntBenefitCacheModel
	implements CacheModel<TravelIntBenefit>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TravelIntBenefitCacheModel)) {
			return false;
		}

		TravelIntBenefitCacheModel travelIntBenefitCacheModel =
			(TravelIntBenefitCacheModel)object;

		if (travelIntBenefitId ==
				travelIntBenefitCacheModel.travelIntBenefitId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, travelIntBenefitId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{travelIntBenefitId=");
		sb.append(travelIntBenefitId);
		sb.append(", benefitName=");
		sb.append(benefitName);
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
	public TravelIntBenefit toEntityModel() {
		TravelIntBenefitImpl travelIntBenefitImpl = new TravelIntBenefitImpl();

		travelIntBenefitImpl.setTravelIntBenefitId(travelIntBenefitId);

		if (benefitName == null) {
			travelIntBenefitImpl.setBenefitName("");
		}
		else {
			travelIntBenefitImpl.setBenefitName(benefitName);
		}

		travelIntBenefitImpl.setActive(active);
		travelIntBenefitImpl.setGroupId(groupId);
		travelIntBenefitImpl.setCompanyId(companyId);
		travelIntBenefitImpl.setUserId(userId);

		if (userName == null) {
			travelIntBenefitImpl.setUserName("");
		}
		else {
			travelIntBenefitImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			travelIntBenefitImpl.setCreateDate(null);
		}
		else {
			travelIntBenefitImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			travelIntBenefitImpl.setModifiedDate(null);
		}
		else {
			travelIntBenefitImpl.setModifiedDate(new Date(modifiedDate));
		}

		travelIntBenefitImpl.resetOriginalValues();

		return travelIntBenefitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		travelIntBenefitId = objectInput.readLong();
		benefitName = objectInput.readUTF();

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
		objectOutput.writeLong(travelIntBenefitId);

		if (benefitName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benefitName);
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

	public long travelIntBenefitId;
	public String benefitName;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}