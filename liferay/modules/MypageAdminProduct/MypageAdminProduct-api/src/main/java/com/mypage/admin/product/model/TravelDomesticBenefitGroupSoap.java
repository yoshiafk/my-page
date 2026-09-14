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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.TravelDomesticBenefitGroupServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TravelDomesticBenefitGroupSoap implements Serializable {

	public static TravelDomesticBenefitGroupSoap toSoapModel(
		TravelDomesticBenefitGroup model) {

		TravelDomesticBenefitGroupSoap soapModel =
			new TravelDomesticBenefitGroupSoap();

		soapModel.setTravelDomesticBenefitGroupId(
			model.getTravelDomesticBenefitGroupId());
		soapModel.setCode(model.getCode());
		soapModel.setName(model.getName());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static TravelDomesticBenefitGroupSoap[] toSoapModels(
		TravelDomesticBenefitGroup[] models) {

		TravelDomesticBenefitGroupSoap[] soapModels =
			new TravelDomesticBenefitGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TravelDomesticBenefitGroupSoap[][] toSoapModels(
		TravelDomesticBenefitGroup[][] models) {

		TravelDomesticBenefitGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TravelDomesticBenefitGroupSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new TravelDomesticBenefitGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TravelDomesticBenefitGroupSoap[] toSoapModels(
		List<TravelDomesticBenefitGroup> models) {

		List<TravelDomesticBenefitGroupSoap> soapModels =
			new ArrayList<TravelDomesticBenefitGroupSoap>(models.size());

		for (TravelDomesticBenefitGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new TravelDomesticBenefitGroupSoap[soapModels.size()]);
	}

	public TravelDomesticBenefitGroupSoap() {
	}

	public long getPrimaryKey() {
		return _travelDomesticBenefitGroupId;
	}

	public void setPrimaryKey(long pk) {
		setTravelDomesticBenefitGroupId(pk);
	}

	public long getTravelDomesticBenefitGroupId() {
		return _travelDomesticBenefitGroupId;
	}

	public void setTravelDomesticBenefitGroupId(
		long travelDomesticBenefitGroupId) {

		_travelDomesticBenefitGroupId = travelDomesticBenefitGroupId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _travelDomesticBenefitGroupId;
	private String _code;
	private String _name;
	private int _active;

}