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
import com.mypage.leads.model.DetailTlp;
import com.mypage.leads.service.base.DetailTlpLocalServiceBaseImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus
 */
@Component(
	property = "model.class.name=com.mypage.leads.model.DetailTlp",
	service = AopService.class
)
public class DetailTlpLocalServiceImpl extends DetailTlpLocalServiceBaseImpl {
	
	public DetailTlp addDetailTlp(long userId, long detailTlpId, JSONObject data, ServiceContext serviceContext)
			throws PortalException {
		DetailTlp detailTlp = null;
		Date startDate = null;
		Date expiredDate = null;

		try {
			if (detailTlpId == 0) {
				detailTlpId = counterLocalService.increment();
				detailTlp = detailTlpPersistence.create(detailTlpId);
			} else {
				detailTlp = detailTlpPersistence.fetchByPrimaryKey(detailTlpId);
			}

			long groupId = serviceContext.getScopeGroupId();
			User user = userLocalService.getUserById(userId);
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			// Sets leadsId
			if (Validator.isNotNull(data.get("LeadsId"))) {
				detailTlp.setLeadsId(data.getLong("LeadsId"));
			} else {
				// dont proceed if LeadsId is not provided
				return null;
			}

			if (Validator.isNotNull(data.get("StartDate"))) {
				startDate = sdf.parse(data.getString("StartDate").replace("/", "-"));
				detailTlp.setStartDate(startDate);
			}

			if (Validator.isNotNull(data.get("ExpiredDate"))) {
				expiredDate = sdf.parse(data.getString("ExpiredDate").replace("/", "-"));
				detailTlp.setExpiredDate(expiredDate);
			}

			if (Validator.isNotNull(data.get("PolicyStartDate"))) {
				Date mainPolicyStartDate = sdf.parse(data.getString("PolicyStartDate").replace("/", "-"));
				detailTlp.setMainPolicyStartDate(mainPolicyStartDate);
			}

			if (Validator.isNotNull(data.get("PolicyExpiredDate"))) {
				Date mainPolicyEndDate = sdf.parse(data.getString("PolicyExpiredDate").replace("/", "-"));
				detailTlp.setMainPolicyEndDate(mainPolicyEndDate);
			}

			if (Validator.isNotNull(startDate) && Validator.isNotNull(expiredDate)) {
				long diffInMillies = Math.abs(expiredDate.getTime() - startDate.getTime());
				long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
				int diffDays = (int) diff; 
				detailTlp.setNumberOfDays(diffDays);
			}

			detailTlp.setName(data.getString("Name").toUpperCase());
			detailTlp.setBirthPlace(data.getString("BirthPlace").toUpperCase());
			
			if(Validator.isNotNull(data.get("Dob"))) {
				Date _dob = sdf.parse(data.getString("Dob").replace("/", "-"));
				detailTlp.setDob(_dob);
			}

			detailTlp.setNationality(data.getString("Nationality"));
			detailTlp.setIdNumber(data.getString("IdNumber"));
			detailTlp.setPassportNumber(data.getString("PassportNumber"));
			detailTlp.setKitasNumber(data.getString("KitasNumber"));
			detailTlp.setMobilePhone(data.getString("MobilePhone"));
			detailTlp.setEmail(data.getString("Email").toUpperCase());
			detailTlp.setAddress(data.getString("Address").toUpperCase());
			detailTlp.setAddress2(data.getString("Address2").toUpperCase());
			detailTlp.setProvince(data.getString("Province"));
			detailTlp.setCity(data.getString("City"));
			detailTlp.setPostCode(data.getString("Zip"));

			detailTlpPersistence.update(detailTlp);
			return detailTlp;

		} catch (Exception e) {
			log.debug(e.getMessage());
		}

		return detailTlp;
	}

    private static final Log log = LogFactoryUtil.getLog(DetailTlpLocalServiceImpl.class);
}