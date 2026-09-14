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
import com.mypage.leads.model.DetailHealthIndividu;
import com.mypage.leads.service.base.DetailHealthIndividuLocalServiceBaseImpl;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus
 */
@Component(
	property = "model.class.name=com.mypage.leads.model.DetailHealthIndividu",
	service = AopService.class
)
public class DetailHealthIndividuLocalServiceImpl
	extends DetailHealthIndividuLocalServiceBaseImpl {
	
	public DetailHealthIndividu addDetail(long userId, long detailId, JSONObject data,ServiceContext serviceContext) {
		DetailHealthIndividu _detail = null;
		
		try {
			if (detailId == 0) {
				detailId = counterLocalService.increment();
				_detail = detailHealthIndividuPersistence.create(detailId);
			} else {
				_detail = detailHealthIndividuPersistence.findByPrimaryKey(detailId);
			}
			
			long groupId = serviceContext.getScopeGroupId();
			User user = userLocalService.getUserById(userId);
			Date now = new Date();
			
			_detail.setLeadsId(data.getLong("LeadsId"));
			_detail.setPlanId(data.getLong("PlanId"));
			_detail.setPremiId(data.getLong("PremiId"));
			_detail.setSameAddress(data.getInt("SameAddress"));
			_detail.setCurrentAddress(data.getString("CurrentAddress"));
			_detail.setCurrentAddress2(data.getString("CurrentAddress2"));
			_detail.setCurrentZip(data.getString("CurrentZip"));
			_detail.setJobCat(data.getString("JobCat"));
			_detail.setJobType(data.getString("JobType"));
			_detail.setJob(data.getString("Job"));
			_detail.setJobPosition(data.getString("JobPosition"));
			_detail.setAccountBankNumber(data.getString("AccountBankNumber"));
			_detail.setAccountBankName(data.getString("AccountBankName"));
			_detail.setBankName(data.getString("BankName"));
			_detail.setHealthAgreement(data.getInt("HealthAgreement"));
			_detail.setChildAgreement(data.getInt("ChildAgreement"));
			
			_detail.setUserId(userId);
			_detail.setGroupId(groupId);
			_detail.setCompanyId(user.getCompanyId());
			_detail.setUserName(user.getFullName());
			_detail.setCreateDate(serviceContext.getCreateDate(now));
			_detail.setModifiedDate(serviceContext.getModifiedDate(now));
			_detail.setExpandoBridgeAttributes(serviceContext);
			
			detailHealthIndividuPersistence.update(_detail);
			
			return _detail;
		} catch (Exception e) {
			// TODO: handle exception
			log.debug(e.getMessage());
		}
		
		return _detail;
	}
	
	public DetailHealthIndividu searchByLeadsId(long LeadsId) {
		return detailHealthIndividuPersistence.fetchBysearchByLeadsId(LeadsId);
	}

    private static final Log log = LogFactoryUtil.getLog(DetailHealthIndividuLocalServiceImpl.class);
}