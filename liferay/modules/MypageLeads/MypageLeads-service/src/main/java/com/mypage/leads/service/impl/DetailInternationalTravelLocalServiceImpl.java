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
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.leads.exception.NoSuchDetailInternationalTravelException;
import com.mypage.leads.model.DetailInternationalTravel;
import com.mypage.leads.service.base.DetailInternationalTravelLocalServiceBaseImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus
 */
@Component(
	property = "model.class.name=com.mypage.leads.model.DetailInternationalTravel",
	service = AopService.class
)
public class DetailInternationalTravelLocalServiceImpl
	extends DetailInternationalTravelLocalServiceBaseImpl {
	
	public DetailInternationalTravel addDetail(long userId, long detailId, JSONObject data,ServiceContext serviceContext) {
		DetailInternationalTravel _detail = null;
		
		try {
			if (detailId == 0) {
				detailId = counterLocalService.increment();
				_detail = detailInternationalTravelPersistence.create(detailId);
			} else {
				_detail = detailInternationalTravelPersistence.findByPrimaryKey(detailId);
			}

			long groupId = serviceContext.getScopeGroupId();
			User user = userLocalService.getUserById(userId);
			Date now = new Date();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(Validator.isNotNull(data.get("LeadsId"))) {
			    _detail.setLeadsId(data.getLong("LeadsId"));
			}else {
				// dont proceed if LeadsId is not provided
				return null;
			}
			if(Validator.isNotNull(data.get("TravelType"))) {
			    _detail.setTravelType(data.getString("TravelType"));
			}
			if(Validator.isNotNull(data.get("Destination"))) {
			    _detail.setDestination(data.getString("Destination"));
			}
			if(Validator.isNotNull(data.get("PackageType"))) {
			    _detail.setPackageType(data.getString("PackageType"));
			}
			if(Validator.isNotNull(data.get("TravellerType"))) {
			    _detail.setTravellerType(data.getString("TravellerType"));
			}
			if(Validator.isNotNull(data.get("DepartureDate"))) {
				Date departureDate = sdf.parse(data.getString("DepartureDate"));
			    _detail.setDepartureDate(departureDate);
			}
			if(Validator.isNotNull(data.get("ArrivalDate"))) {
				Date arrivalDate = sdf.parse(data.getString("ArrivalDate"));
			    _detail.setArrivalDate(arrivalDate);
			}
			
			_detail.setAdult(data.getInt("Adult"));
			_detail.setChild(data.getInt("Child"));
			
			//additional
			_detail.setListBenefitId(data.getString("ListBenefitId"));
			
			
			_detail.setUserId(userId);
			_detail.setGroupId(groupId);
			_detail.setCompanyId(user.getCompanyId());
			_detail.setUserName(user.getFullName());
			_detail.setCreateDate(serviceContext.getCreateDate(now));
			_detail.setModifiedDate(serviceContext.getModifiedDate(now));
			_detail.setExpandoBridgeAttributes(serviceContext);

			detailInternationalTravelPersistence.update(_detail);
			
			return _detail;
		} catch (Exception e) {
			// TODO: handle exception
			log.debug(e.getMessage());
		}
		
		return _detail;	
	}
	
	public DetailInternationalTravel addDetailData(long userId, long detailId, HashMap<String, Object> data, ServiceContext serviceContext) {
		DetailInternationalTravel _detail = null;
		
		try {
			if (detailId == 0) {
				detailId = counterLocalService.increment();
				_detail = detailInternationalTravelPersistence.create(detailId);
			} else {
				_detail = detailInternationalTravelPersistence.findByPrimaryKey(detailId);
			}

			long groupId = serviceContext.getScopeGroupId();
			User user = userLocalService.getUserById(userId);
			Date now = new Date();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(Validator.isNotNull(Long.parseLong(data.get("LeadsId").toString()))) {
			    _detail.setLeadsId(Long.parseLong(data.get("LeadsId").toString()));
			}else {
				// dont proceed if LeadsId is not provided
				return null;
			}
			if(Validator.isNotNull(data.get("TravelType").toString())) {
			    _detail.setTravelType(data.get("TravelType").toString());
			}
			if(Validator.isNotNull(data.get("Destination").toString())) {
			    _detail.setDestination(data.get("Destination").toString());
			}
			if(Validator.isNotNull(data.get("PackageType").toString())) {
			    _detail.setPackageType(data.get("PackageType").toString());
			}
			if(Validator.isNotNull(data.get("TravellerType").toString())) {
			    _detail.setTravellerType(data.get("TravellerType").toString());
			}
			if(Validator.isNotNull(data.get("DepartureDate").toString())) {
				Date departureDate = sdf.parse(data.get("DepartureDate").toString());
			    _detail.setDepartureDate(departureDate);
			}
			if(Validator.isNotNull(data.get("ArrivalDate").toString())) {
				Date arrivalDate = sdf.parse(data.get("ArrivalDate").toString());
			    _detail.setArrivalDate(arrivalDate);
			}
			
			_detail.setAdult(Integer.parseInt(data.get("Adult").toString()));
			_detail.setChild(Integer.parseInt(data.get("Child").toString()));
			
			//additional
			_detail.setListBenefitId(data.get("ListBenefitId").toString());
			
			
			_detail.setUserId(userId);
			_detail.setGroupId(groupId);
			_detail.setCompanyId(user.getCompanyId());
			_detail.setUserName(user.getFullName());
			_detail.setCreateDate(serviceContext.getCreateDate(now));
			_detail.setModifiedDate(serviceContext.getModifiedDate(now));
			_detail.setExpandoBridgeAttributes(serviceContext);

			detailInternationalTravelPersistence.update(_detail);
			
			return _detail;
		} catch (Exception e) {
			// TODO: handle exception
			log.debug(e.getMessage());
		}
		
		return _detail;	
	}

	public DetailInternationalTravel findByLeadsId(long LeadsId) {
		try {
			return detailInternationalTravelPersistence.findBysearchByLeadsId(LeadsId);
		} catch (NoSuchDetailInternationalTravelException e) {
			// TODO Auto-generated catch block
			log.debug(e.getMessage());
		}
		return null;
	}

    private static final Log log = LogFactoryUtil.getLog(DetailInternationalTravelLocalServiceImpl.class);
}