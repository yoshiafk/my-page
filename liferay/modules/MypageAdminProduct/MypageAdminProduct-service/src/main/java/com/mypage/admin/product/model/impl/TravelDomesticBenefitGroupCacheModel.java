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

import com.mypage.admin.product.model.TravelDomesticBenefitGroup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TravelDomesticBenefitGroup in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class TravelDomesticBenefitGroupCacheModel
	implements CacheModel<TravelDomesticBenefitGroup>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TravelDomesticBenefitGroupCacheModel)) {
			return false;
		}

		TravelDomesticBenefitGroupCacheModel
			travelDomesticBenefitGroupCacheModel =
				(TravelDomesticBenefitGroupCacheModel)object;

		if (travelDomesticBenefitGroupId ==
				travelDomesticBenefitGroupCacheModel.
					travelDomesticBenefitGroupId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, travelDomesticBenefitGroupId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{travelDomesticBenefitGroupId=");
		sb.append(travelDomesticBenefitGroupId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", name=");
		sb.append(name);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TravelDomesticBenefitGroup toEntityModel() {
		TravelDomesticBenefitGroupImpl travelDomesticBenefitGroupImpl =
			new TravelDomesticBenefitGroupImpl();

		travelDomesticBenefitGroupImpl.setTravelDomesticBenefitGroupId(
			travelDomesticBenefitGroupId);

		if (code == null) {
			travelDomesticBenefitGroupImpl.setCode("");
		}
		else {
			travelDomesticBenefitGroupImpl.setCode(code);
		}

		if (name == null) {
			travelDomesticBenefitGroupImpl.setName("");
		}
		else {
			travelDomesticBenefitGroupImpl.setName(name);
		}

		travelDomesticBenefitGroupImpl.setActive(active);

		travelDomesticBenefitGroupImpl.resetOriginalValues();

		return travelDomesticBenefitGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		travelDomesticBenefitGroupId = objectInput.readLong();
		code = objectInput.readUTF();
		name = objectInput.readUTF();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(travelDomesticBenefitGroupId);

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(active);
	}

	public long travelDomesticBenefitGroupId;
	public String code;
	public String name;
	public int active;

}