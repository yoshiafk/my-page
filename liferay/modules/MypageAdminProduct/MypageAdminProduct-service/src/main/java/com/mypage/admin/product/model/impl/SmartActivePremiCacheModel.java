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

import com.mypage.admin.product.model.SmartActivePremi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SmartActivePremi in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class SmartActivePremiCacheModel
	implements CacheModel<SmartActivePremi>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SmartActivePremiCacheModel)) {
			return false;
		}

		SmartActivePremiCacheModel smartActivePremiCacheModel =
			(SmartActivePremiCacheModel)object;

		if (smartActivePremiId ==
				smartActivePremiCacheModel.smartActivePremiId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, smartActivePremiId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{smartActivePremiId=");
		sb.append(smartActivePremiId);
		sb.append(", rate=");
		sb.append(rate);
		sb.append(", active=");
		sb.append(active);
		sb.append(", smartActiveClassRateId=");
		sb.append(smartActiveClassRateId);
		sb.append(", smartActiveBenefitId=");
		sb.append(smartActiveBenefitId);
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
	public SmartActivePremi toEntityModel() {
		SmartActivePremiImpl smartActivePremiImpl = new SmartActivePremiImpl();

		smartActivePremiImpl.setSmartActivePremiId(smartActivePremiId);
		smartActivePremiImpl.setRate(rate);
		smartActivePremiImpl.setActive(active);
		smartActivePremiImpl.setSmartActiveClassRateId(smartActiveClassRateId);
		smartActivePremiImpl.setSmartActiveBenefitId(smartActiveBenefitId);
		smartActivePremiImpl.setGroupId(groupId);
		smartActivePremiImpl.setCompanyId(companyId);
		smartActivePremiImpl.setUserId(userId);

		if (userName == null) {
			smartActivePremiImpl.setUserName("");
		}
		else {
			smartActivePremiImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			smartActivePremiImpl.setCreateDate(null);
		}
		else {
			smartActivePremiImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			smartActivePremiImpl.setModifiedDate(null);
		}
		else {
			smartActivePremiImpl.setModifiedDate(new Date(modifiedDate));
		}

		smartActivePremiImpl.resetOriginalValues();

		return smartActivePremiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		smartActivePremiId = objectInput.readLong();

		rate = objectInput.readDouble();

		active = objectInput.readInt();

		smartActiveClassRateId = objectInput.readLong();

		smartActiveBenefitId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(smartActivePremiId);

		objectOutput.writeDouble(rate);

		objectOutput.writeInt(active);

		objectOutput.writeLong(smartActiveClassRateId);

		objectOutput.writeLong(smartActiveBenefitId);

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

	public long smartActivePremiId;
	public double rate;
	public int active;
	public long smartActiveClassRateId;
	public long smartActiveBenefitId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}