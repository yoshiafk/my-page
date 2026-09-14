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

package com.mypage.leads.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.leads.model.DetailDrive;
import com.mypage.leads.service.base.DetailDriveLocalServiceBaseImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus
 */
@Component(
	property = "model.class.name=com.mypage.leads.model.DetailDrive",
	service = AopService.class
)
public class DetailDriveLocalServiceImpl
	extends DetailDriveLocalServiceBaseImpl {
	
	public DetailDrive addDetailDrive(long userId, long detailId, JSONObject data, ServiceContext serviceContext)
			throws PortalException {

		DetailDrive _detail = null;

		try {
			if (detailId == 0) {
				detailId = counterLocalService.increment();
				_detail = detailDrivePersistence.create(detailId);
			} else {
				_detail = detailDrivePersistence.findByPrimaryKey(detailId);
			}

			long groupId = serviceContext.getScopeGroupId();
			User user = userLocalService.getUserById(userId);
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			if (Validator.isNotNull(data.get("LeadsId"))) {
				_detail.setLeadsId(data.getLong("LeadsId"));
			} else {
				// dont proceed if LeadsId is not provided
				return null;
			}

			_detail.setVehicleCode(data.getString("VehicleCode"));
			_detail.setVehicleManufacture(data.getString("VehicleManufacture"));
			_detail.setVehicleModel(data.getString("VehicleModel"));
			_detail.setVehicleSubModel(data.getString("VehicleSubModel"));
			_detail.setVehicleBody(data.getString("VehicleBody"));
			_detail.setManufactureYear(data.getInt("ManufactureYear"));
			_detail.setManufactureAge(data.getInt("ManufactureAge"));
			_detail.setCoverageType(data.getString("CoverageType"));
			_detail.setVehicleType(data.getString("VehicleType"));
			_detail.setTypeOfUse(data.getString("TypeOfUse"));
			_detail.setVehicleInsured(data.getDouble("VehicleInsured"));
			_detail.setAccessoriesInsured(data.getDouble("AccessoriesInsured"));
			_detail.setSumInsured(data.getDouble("SumInsured"));
			_detail.setRegionPlate(data.getString("RegionPlate"));
			_detail.setCc(data.getInt("Cc"));
			_detail.setMake(data.getString("Make"));
			_detail.setDpg(data.getString("Dpg"));
			_detail.setSeatCapacity(data.getInt("SeatCapacity"));

			if (Validator.isNotNull(data.get("PolicyStartDate"))) {
				Date policyStartDate = sdf.parse(data.getString("PolicyStartDate"));
				_detail.setStartDate(policyStartDate);
			}
			if (Validator.isNotNull(data.get("PolicyEndDate"))) {
				Date policyEndDate = sdf.parse(data.getString("PolicyEndDate"));
				_detail.setExpiredDate(policyEndDate);
			}

			_detail.setCommercialOffers(data.getInt("CommercialOffers"));

			// Personal information
			_detail.setName(data.getString("Name"));
			_detail.setBirthPlace(data.getString("BirthPlace"));

			if (Validator.isNotNull(data.getString("Dob"))) {
				Date dob = sdf.parse(data.getString("Dob"));
				_detail.setDob(dob);
			}

			_detail.setNationality(data.getString("Nationality"));
			_detail.setIdNumber(data.getString("IdNumber"));
			_detail.setPassportNumber(data.getString("PassportNumber"));
			_detail.setKitasNumber(data.getString("KitasNumber"));
			_detail.setMobilePhone(data.getString("MobilePhone"));
			_detail.setEmail(data.getString("Email").toLowerCase());
			_detail.setAddress(data.getString("Address").toUpperCase());
			_detail.setAddress2(data.getString("Address2"));
			_detail.setProvince(data.getString("Province"));
			_detail.setCity(data.getString("City"));

			// Vehicle information
			_detail.setPoliceNumber(data.getString("PoliceNumber"));
			_detail.setChassisNumber(data.getString("ChassisNumber"));
			_detail.setEngineNumber(data.getString("EngineNumber"));

			_detail.setPoliceNumber(data.getString("policyNumber"));
			_detail.setReferenceNumber(data.getString("ReferenceNumber"));
			_detail.setPolicyStatus(data.getString("PolicyStatus"));
			_detail.setCurrency(data.getString("Currency"));
			_detail.setPolicyCost(data.getDouble("PolicyCost"));
			_detail.setStampDuty(data.getDouble("StampDuty"));
			_detail.setPremium(data.getDouble("Premium"));
			_detail.setNetPremium(data.getDouble("NetPremium"));
			_detail.setDiscount(data.getInt("Discount"));
			_detail.setCommission(data.getString("Commission"));

			detailDrivePersistence.update(_detail);
			return _detail;

		} catch (Exception e) {
			log.debug(e.getMessage());
		}

		return _detail;
	}

	public List<DetailDrive> findByLeadsId(long LeadsId) {
		return detailDrivePersistence.findByLeadsId(LeadsId);
	}

    private static final Log log = LogFactoryUtil.getLog(DetailDriveLocalServiceImpl.class);
}