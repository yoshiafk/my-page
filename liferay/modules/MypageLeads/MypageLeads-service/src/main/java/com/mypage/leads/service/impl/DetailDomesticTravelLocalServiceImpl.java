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
import com.mypage.leads.model.DetailDomesticTravel;
import com.mypage.leads.service.base.DetailDomesticTravelLocalServiceBaseImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus
 */
@Component(
	property = "model.class.name=com.mypage.leads.model.DetailDomesticTravel",
	service = AopService.class
)
public class DetailDomesticTravelLocalServiceImpl
	extends DetailDomesticTravelLocalServiceBaseImpl {
	
	public DetailDomesticTravel addDetail(long userId, long detailId, JSONObject data,ServiceContext serviceContext) {
		DetailDomesticTravel _detail = null;
		
		try {
			if (detailId == 0) {
				detailId = counterLocalService.increment();
				_detail = detailDomesticTravelPersistence.create(detailId);
			} else {
				_detail = detailDomesticTravelPersistence.findByPrimaryKey(detailId);
			}

			long groupId = serviceContext.getScopeGroupId();
			User user = userLocalService.getUserById(userId);
			Date now = new Date();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			if(Validator.isNotNull(data.get("LeadsId"))) {
			    _detail.setLeadsId(data.getLong("LeadsId"));
			}
			if(Validator.isNotNull(data.get("TravelType"))) {
			    _detail.setTravelType(data.getString("TravelType"));
			}
			if(Validator.isNotNull(data.get("TravelPlan"))) {
			    _detail.setTravelPlan(data.getString("TravelPlan"));
			}
			if(Validator.isNotNull(data.get("TravellerType"))) {
			    _detail.setTravellerType(data.getString("TravellerType"));
			}
			if(Validator.isNotNull(data.get("Adult"))) {
			    _detail.setAdult(data.getInt("Adult"));
			}
			if(Validator.isNotNull(data.get("Child"))) {
			    _detail.setChild(data.getInt("Child"));
			}
			if(Validator.isNotNull(data.get("DepartureDate"))) {
				Date DepartureDate = sdf.parse(data.getString("DepartureDate"));
			    _detail.setDepartureDate(DepartureDate);
			}	
			if(Validator.isNotNull(data.get("ArrivalDate"))) {
				Date ArrivalDate = sdf.parse(data.getString("ArrivalDate"));
			    _detail.setArrivalDate(ArrivalDate);
			}
			if(Validator.isNotNull(data.get("CommercialOffers"))) {
			    _detail.setCommercialOffers(data.getInt("CommercialOffers"));
			}
			
			_detail.setUserId(userId);
			_detail.setGroupId(groupId);
			_detail.setCompanyId(user.getCompanyId());
			_detail.setUserName(user.getFullName());
			_detail.setCreateDate(serviceContext.getCreateDate(now));
			_detail.setModifiedDate(serviceContext.getModifiedDate(now));
			_detail.setExpandoBridgeAttributes(serviceContext);

			detailDomesticTravelPersistence.update(_detail);
			
			return _detail;
		} catch (Exception e) {
			// TODO: handle exception
			log.debug(e.getMessage());
		}
		
		return _detail;
		
	}
	
	public DetailDomesticTravel searchByLeadsId(long LeadsId) {
		DetailDomesticTravel detailDomesticTravel = null;
		try {
			detailDomesticTravel = detailDomesticTravelPersistence.findBysearchByLeadsId(LeadsId);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return detailDomesticTravel;
	}

    private static final Log log = LogFactoryUtil.getLog(DetailDomesticTravelLocalServiceImpl.class);
}