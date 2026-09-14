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
import com.mypage.leads.model.DetailPet;
import com.mypage.leads.service.base.DetailPetLocalServiceBaseImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus
 */
@Component(
	property = "model.class.name=com.mypage.leads.model.DetailPet",
	service = AopService.class
)
public class DetailPetLocalServiceImpl extends DetailPetLocalServiceBaseImpl {
	
	public DetailPet addDetail(long userId, long detailId, JSONObject data,ServiceContext serviceContext) {
		DetailPet _detail = null;
		
		try {
			if (detailId == 0) {
				detailId = counterLocalService.increment();
				_detail = detailPetPersistence.create(detailId);
			} else {
				_detail = detailPetPersistence.fetchByPrimaryKey(detailId);
			}
			
			long groupId = serviceContext.getScopeGroupId();
			User user = userLocalService.getUserById(userId);
			Date now = new Date();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			_detail.setLeadsId(data.getLong("LeadsId"));
			_detail.setPlanId(data.getLong("PlanId"));
			_detail.setLimitDisability(data.getDouble("LimitDisability"));
			_detail.setLimitMedical(data.getDouble("LimitMedical"));
			_detail.setLimitThirdParty(data.getDouble("LimitThirdParty"));
			_detail.setLimitCustody(data.getDouble("LimitCustody"));
			_detail.setPetName(data.getString("PetName"));
			_detail.setPetType(data.getString("PetType"));
			_detail.setPetGender(data.getString("PetGender"));
			if(Validator.isNotNull(data.get("PetDob"))) {
				Date petDob = sdf.parse(data.getString("PetDob"));
				_detail.setPetDob(petDob);
			}
			_detail.setPetIdNumber(data.getString("PetIdNumber"));
			_detail.setPetIdNumberIssuing(data.getString("PetIdNumberIssuing"));
//			_detail.setPetIdNumberFileEntryId(data.getLong("PetIdNumberFileEntryId"));
//			_detail.setPetIdNumberURL(data.getString("PetIdNumberURL"));
//			_detail.setPetPhotoFileEntryId(data.getLong("PetPhotoFileEntryId"));
//			_detail.setPetPhotoURL(data.getString("PetPhotoURL"));
			_detail.setPetLocation(data.getString("PetLocation"));
			_detail.setPetVaccine(data.getInt("PetVaccine"));
			_detail.setPetAuthorizedCertificate(data.getInt("PetAuthorizedCertificate"));
			
			_detail.setUserId(userId);
			_detail.setGroupId(groupId);
			_detail.setCompanyId(user.getCompanyId());
			_detail.setUserName(user.getFullName());
			_detail.setCreateDate(serviceContext.getCreateDate(now));
			_detail.setModifiedDate(serviceContext.getModifiedDate(now));
			_detail.setExpandoBridgeAttributes(serviceContext);
			
			detailPetPersistence.update(_detail);
			
			return _detail;
		} catch (Exception e) {
			// TODO: handle exception
			log.debug(e.getMessage());
		}
		
		return _detail;
	}
	
	public DetailPet searchByLeadsId(long LeadsId) {
		return detailPetPersistence.fetchBysearchByLeadsId(LeadsId);
	}
	
	public DetailPet setPetCertificatePhoto(long leadsId, long petCerfiticatePhotoFileEntryId) throws Exception {
		DetailPet _detailPet = detailPetPersistence.findBysearchByLeadsId(leadsId);
		
		_detailPet.setPetIdNumberFileEntryId(petCerfiticatePhotoFileEntryId);
		detailPetPersistence.update(_detailPet);
		
		return _detailPet;
	}
	
	public DetailPet setPetPhoto(long leadsId, long petPhotoFileEntryId) throws Exception {
		DetailPet _detailPet = detailPetPersistence.findBysearchByLeadsId(leadsId);
		
		_detailPet.setPetPhotoFileEntryId(petPhotoFileEntryId);
		detailPetPersistence.update(_detailPet);
		
		return _detailPet;
	}

    private static final Log log = LogFactoryUtil.getLog(DetailPetLocalServiceImpl.class);
}