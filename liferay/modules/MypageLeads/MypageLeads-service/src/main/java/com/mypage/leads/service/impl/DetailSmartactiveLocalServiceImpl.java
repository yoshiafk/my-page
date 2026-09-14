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
import com.mypage.leads.exception.NoSuchDetailSmartactiveException;
import com.mypage.leads.model.DetailSmartactive;
import com.mypage.leads.service.base.DetailSmartactiveLocalServiceBaseImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus
 */
@Component(
	property = "model.class.name=com.mypage.leads.model.DetailSmartactive",
	service = AopService.class
)
public class DetailSmartactiveLocalServiceImpl
	extends DetailSmartactiveLocalServiceBaseImpl {
	
	
	public DetailSmartactive addDetail(long userId, long detailId, JSONObject data,ServiceContext serviceContext) {
		
		DetailSmartactive _detail = null;
		
		try {
			if (detailId == 0) {
				detailId = counterLocalService.increment();
				_detail = detailSmartactivePersistence.create(detailId);
			} else {
				_detail = detailSmartactivePersistence.findByPrimaryKey(detailId);
			}

			long groupId = serviceContext.getScopeGroupId();
			User user = userLocalService.getUserById(userId);
			Date now = new Date();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			if(Validator.isNotNull(data.get("LeadsId"))) {
			    _detail.setLeadsId(data.getLong("LeadsId"));
			}else {
				// dont proceed if LeadsId is not provided
				return null;
			}
			
			
			if(Validator.isNotNull(data.get("ExcludedActivityStatus"))) {
			    _detail.setExcludedActivityStatus(data.getInt("ExcludedActivityStatus"));
			}
			
			if(Validator.isNotNull(data.get("JobType"))) {
			    _detail.setJobType(Long.valueOf(data.getString("JobType")));
			}
			
			if(Validator.isNotNull(data.get("MainBenefitValue"))) {
			    _detail.setMainBenefitValue(data.getString("MainBenefitValue"));
			}
			
			if(Validator.isNotNull(data.get("StartPeriode"))) {
				Date startPeriode = sdf.parse(data.getString("StartPeriode"));
			    _detail.setStartPeriode(startPeriode);
			}
			
			if(Validator.isNotNull(data.get("EndPeriode"))) {
				Date endPeriode = sdf.parse(data.getString("EndPeriode"));
			    _detail.setEndPeriode(endPeriode);
			}
			
			
			//additional
			_detail.setListBenefitId(data.getString("ListBenefitId"));
			
			
			_detail.setUserId(userId);
			_detail.setGroupId(groupId);
			_detail.setCompanyId(user.getCompanyId());
			_detail.setUserName(user.getFullName());
			_detail.setCreateDate(serviceContext.getCreateDate(now));
			_detail.setModifiedDate(serviceContext.getModifiedDate(now));
			_detail.setExpandoBridgeAttributes(serviceContext);

			detailSmartactivePersistence.update(_detail);
			
			return _detail;
		} catch (Exception e) {
			// TODO: handle exception
			log.debug(e.getMessage());
		}
		
		return _detail;	
		
	}
	
	public DetailSmartactive findByLeadsId(long LeadsId) {
		try {
			return detailSmartactivePersistence.findBysearchByLeadsId(LeadsId);
		} catch (NoSuchDetailSmartactiveException e) {
			// TODO Auto-generated catch block
			log.debug(e.getMessage());
		}
		return null;
	}

    private static final Log log = LogFactoryUtil.getLog(DetailSmartactiveLocalServiceImpl.class);
}