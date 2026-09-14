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

package com.mypage.admin.product.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.MasterPromoCode;
import com.mypage.admin.product.service.base.MasterPromoCodeLocalServiceBaseImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.MasterPromoCode",
	service = AopService.class
)
public class MasterPromoCodeLocalServiceImpl extends MasterPromoCodeLocalServiceBaseImpl {
	public MasterPromoCode addPromoCode(String productCode, String productName, String promoCode, double discount, String startDate, 
			String endDate, String limit, String promoCodeTerms, long mypageUserId, String agentCode, String agentName, String deptoreCode, 
			double commission, int active) throws PortalException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		long promoCodeId = counterLocalService.increment();
		MasterPromoCode agentPromoCode = masterPromoCodePersistence.create(promoCodeId);
		
		Date now = new Date();
		TimeZone timeZone = TimeZone.getTimeZone("GMT+7");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd MMMM yyyy, HH:mm:ss");
        dateTimeFormat.setTimeZone(timeZone);
        String formattedDateTime = dateTimeFormat.format(now);
        String remarks = "Add/Edit by " + agentName + "(" + agentCode + ") on " + formattedDateTime;
		
		agentPromoCode.setProductCode(productCode);
		agentPromoCode.setProductName(productName);
		agentPromoCode.setPromoCode(promoCode);
		agentPromoCode.setDiscount(discount);
		agentPromoCode.setStartDate(dateFormat.parse(startDate));
		agentPromoCode.setEndDate(dateFormat.parse(endDate));
		agentPromoCode.setLimit(limit);
		agentPromoCode.setPromoCodeTerms(promoCodeTerms);
		agentPromoCode.setMypageUserId(mypageUserId);
		agentPromoCode.setAgentName(agentName);
		agentPromoCode.setDeptoreCode(deptoreCode);
		agentPromoCode.setCommission(String.valueOf(commission));
		agentPromoCode.setActive(active);
		agentPromoCode.setRemarks(remarks);

		masterPromoCodePersistence.update(agentPromoCode);

		return agentPromoCode;
	}
	
	public MasterPromoCode updatePromoCode(long promoCodeId, String productCode, String productName, String promoCode, double discount, 
			String startDate, String endDate, String limit, String promoCodeTerms, String remarks, long mypageUserId, String agentCode, 
			String agentName, String deptoreCode, double commission, int active) throws PortalException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		MasterPromoCode agentPromoCode = null;
		
		try {
	        agentPromoCode = masterPromoCodePersistence.findByPrimaryKey(promoCodeId);
	    } catch (Exception e) {
	        agentPromoCode = masterPromoCodePersistence.create(promoCodeId);
	    }
		
		agentPromoCode.setPromoType("Normal");
		agentPromoCode.setProductCode(productCode);
		agentPromoCode.setProductName(productName);
		agentPromoCode.setPromoCode(promoCode);
		agentPromoCode.setDiscount(discount);
		if (Validator.isNotNull(startDate)) agentPromoCode.setStartDate(dateFormat.parse(startDate));
		if (Validator.isNotNull(endDate)) agentPromoCode.setEndDate(dateFormat.parse(endDate));
		agentPromoCode.setLimit(limit);
		agentPromoCode.setNetwork("Agent");
		agentPromoCode.setChannel("Agent");
		agentPromoCode.setIsB2B2C(1);
		agentPromoCode.setIsB2B(1);
		agentPromoCode.setPayment("AllDoku");
		agentPromoCode.setPromoCodeTerms(promoCodeTerms);
		agentPromoCode.setRemarks(remarks);
		agentPromoCode.setMypageUserId(mypageUserId);
		agentPromoCode.setAgentName(agentName);
		agentPromoCode.setDeptoreCode(deptoreCode);
		agentPromoCode.setCommission(String.valueOf(commission));
		agentPromoCode.setActive(active);
		agentPromoCode.setRemarks(remarks);

		masterPromoCodePersistence.update(agentPromoCode);

		return agentPromoCode;
	}
	
	public MasterPromoCode savePromoCode(int isDefault, long promoCodeId, String productCode, String productName, String promoType, 
			String promoCode, double discount, String startDate, String endDate, String activeDay, String limit, String network, 
			String channel, int isB2C, int isB2B2C, int isB2B, String payment, String birthdayMonth, String remarks, long mypageUserId, 
			String agentName, String deptoreCode, String commission, String plan, String promoCodeTerms, String travellerType, 
			int active) throws PortalException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		MasterPromoCode agentPromoCode = null;
		
		try {
	        agentPromoCode = masterPromoCodePersistence.findByPrimaryKey(promoCodeId);
	    } catch (Exception e) {
	        agentPromoCode = masterPromoCodePersistence.create(promoCodeId);
	    }
		
		agentPromoCode.setIsDefault(isDefault);
		agentPromoCode.setProductCode(productCode);
		agentPromoCode.setProductName(productName);
		agentPromoCode.setPromoType(promoType);
		agentPromoCode.setPromoCode(promoCode);
		agentPromoCode.setDiscount(discount);
		if (Validator.isNotNull(startDate)) agentPromoCode.setStartDate(dateFormat.parse(startDate));
		if (Validator.isNotNull(endDate)) agentPromoCode.setEndDate(dateFormat.parse(endDate));
		agentPromoCode.setActiveDay(activeDay);
		agentPromoCode.setLimit(limit);
		agentPromoCode.setNetwork(network);
		agentPromoCode.setChannel(channel);
		agentPromoCode.setIsB2C(isB2C);
		agentPromoCode.setIsB2B2C(isB2B2C);
		agentPromoCode.setIsB2B(isB2B);
		agentPromoCode.setPayment(payment);
		agentPromoCode.setBirthdayMonth(birthdayMonth);
		agentPromoCode.setRemarks(remarks);
		agentPromoCode.setMypageUserId(mypageUserId);
		agentPromoCode.setAgentName(agentName);
		agentPromoCode.setDeptoreCode(deptoreCode);
		agentPromoCode.setCommission(commission);
		agentPromoCode.setPlan_(plan);
		agentPromoCode.setPromoCodeTerms(promoCodeTerms);
		agentPromoCode.setTravellerType(travellerType);
		agentPromoCode.setActive(active);

		masterPromoCodePersistence.update(agentPromoCode);

		return agentPromoCode;
	}
	
	public List<MasterPromoCode> findByFilter(int start, int end, long userId) {
		DynamicQuery dynamicQuery = masterPromoCodeLocalService.dynamicQuery();
		
		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
		projectionList.add(ProjectionFactoryUtil.property("promoCodeId"));
	    projectionList.add(ProjectionFactoryUtil.property("promoCode"));
	    projectionList.add(ProjectionFactoryUtil.property("productCode"));
	    projectionList.add(ProjectionFactoryUtil.property("productName"));
	    projectionList.add(ProjectionFactoryUtil.property("discount"));
	    projectionList.add(ProjectionFactoryUtil.property("limit"));
	    projectionList.add(ProjectionFactoryUtil.property("startDate"));
	    projectionList.add(ProjectionFactoryUtil.property("endDate"));
	    projectionList.add(ProjectionFactoryUtil.property("active"));
	    dynamicQuery.setProjection(projectionList);
	    
	    projectionList = ProjectionFactoryUtil.projectionList();
	    projectionList.add(ProjectionFactoryUtil.groupProperty("promoCodeId"));
	    projectionList.add(ProjectionFactoryUtil.groupProperty("productCode"));
	    projectionList.add(ProjectionFactoryUtil.groupProperty("promoCode"));
	    projectionList.add(ProjectionFactoryUtil.groupProperty("productName"));
	    projectionList.add(ProjectionFactoryUtil.groupProperty("discount"));
	    projectionList.add(ProjectionFactoryUtil.groupProperty("limit"));
	    projectionList.add(ProjectionFactoryUtil.groupProperty("startDate"));
	    projectionList.add(ProjectionFactoryUtil.groupProperty("endDate"));
	    projectionList.add(ProjectionFactoryUtil.groupProperty("active"));
	    dynamicQuery.setProjection(projectionList);
	    
	    Order order = OrderFactoryUtil.desc("promoCodeId");
	    dynamicQuery.addOrder(order);
//	    order = OrderFactoryUtil.asc("promoCode");
//	    dynamicQuery.addOrder(order);
		
		dynamicQuery.add(RestrictionsFactoryUtil.eq("mypageUserId", userId));
		
		List<Object[]> results = masterPromoCodePersistence.findWithDynamicQuery(dynamicQuery, start, end);

	    List<MasterPromoCode> masterPromoCodes = new ArrayList<MasterPromoCode>();
	    
	    for (Object[] result : results) {
	        MasterPromoCode masterPromoCode = masterPromoCodeLocalService.createMasterPromoCode(0);
	        
	        masterPromoCode.setPromoCodeId((Long) result[0]);
	        masterPromoCode.setPromoCode((String) result[2]);
	        masterPromoCode.setProductCode((String) result[1]);
	        masterPromoCode.setProductName((String) result[3]);
	        masterPromoCode.setDiscount((Double) result[4]);
	        masterPromoCode.setLimit((String) result[5]);
	        masterPromoCode.setStartDate((Date) result[6]);
	        masterPromoCode.setEndDate((Date) result[7]);
	        masterPromoCode.setActive((Integer) result[8]);
	        
	        masterPromoCodes.add(masterPromoCode);
	    }
		
	    return masterPromoCodes;
	}
	
	public int countByPromoCode(long promoCodeId, String promoCode) {
		DynamicQuery dynamicQuery = masterPromoCodeLocalService.dynamicQuery();
		
		if (promoCodeId > 0) dynamicQuery.add(RestrictionsFactoryUtil.ne("promoCodeId", promoCodeId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("promoCode", promoCode));
		
	    return masterPromoCodePersistence.findWithDynamicQuery(dynamicQuery).size();
	}
	
	public int countByUserId(long userId) {
		DynamicQuery dynamicQuery = masterPromoCodeLocalService.dynamicQuery();
		
		dynamicQuery.add(RestrictionsFactoryUtil.eq("mypageUserId", userId));
		
	    return masterPromoCodePersistence.findWithDynamicQuery(dynamicQuery).size();
	}
	
	public MasterPromoCode setActive(long masterPromoCodeId, int active, ServiceContext serviceContext) throws PortalException {
		MasterPromoCode masterPromoCode = null;

		try {
			masterPromoCode = masterPromoCodePersistence.findByPrimaryKey(masterPromoCodeId);
			Date now = new Date();
			masterPromoCode.setActive(active);
			masterPromoCode.setModifiedDate(serviceContext.getModifiedDate(now));

			masterPromoCodePersistence.update(masterPromoCode);
		} catch (Exception e) {
			System.out.println(e);
		}

		return masterPromoCode;
	}
}