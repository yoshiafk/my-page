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

package com.mypage.agencyportal.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.agencyportal.model.AgentNotification;
import com.mypage.agencyportal.service.base.AgentNotificationLocalServiceBaseImpl;
import com.mypage.user.service.MypageUserGroupLocalService;
import com.mypage.user.service.MypageUserRoleLocalService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.agencyportal.model.AgentNotification",
	service = AopService.class
)
public class AgentNotificationLocalServiceImpl extends AgentNotificationLocalServiceBaseImpl {
	
	public List<AgentNotification> getActiveNotificationByRole(long userId, long roleId, List<Long> groupId, List<String> category) {
		List<AgentNotification> agentNotification = new ArrayList<AgentNotification>();
		
		Comparator<AgentNotification> comparator = Comparator.comparing(AgentNotification::getAgentNotificationId).reversed();
		
		agentNotification = (List<AgentNotification>) agentNotificationPersistence.findAll().stream()
						.filter(v -> v.getActive() == 1 && category.contains(v.getCategory()) &&
							   (v.getMypageUserId() == userId || v.getMypageUserRoleId() == roleId || groupId.contains(v.getMypageUserGroupId())
							   ))
						.sorted(comparator)
						.collect(Collectors.toList());
		
		return agentNotification;
	}
	
	public List<AgentNotification> getUnreadNotificationByRole(long userId, long roleId, List<Long> groupId) {
		List<AgentNotification> agentNotification = new ArrayList<AgentNotification>();
		
		Comparator<AgentNotification> comparator = Comparator.comparing(AgentNotification::getAgentNotificationId).reversed();
		
		agentNotification = (List<AgentNotification>) agentNotificationPersistence.findAll().stream()
						.filter(v -> v.getActive() == 1 && v.getIsRead() == 0 &&
							   (v.getMypageUserId() == userId || v.getMypageUserRoleId() == roleId || groupId.contains(v.getMypageUserGroupId())
							   ))
						.sorted(comparator)
						.collect(Collectors.toList());
		
		return agentNotification;
	}
	
	public AgentNotification addNotification(String title, String location, String address, String description, String link, String category, 
			long roleId, long groupId, long referenceId, String startDate, String startTime, String endDate, String endTime, String fileURL,
			long fileEntryId, int isAllDay, int active, long userId) throws PortalException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		long agentNotificationId = counterLocalService.increment();
		String role = roleId > 0 ? _mypageUserRoleLocalService.getMypageUserRole(roleId).getName() : "";
		String group = groupId > 0 ? _mypageUserGroupLocalService.getMypageUserGroup(groupId).getName() : "";
		
		AgentNotification agentNotification = agentNotificationPersistence.create(agentNotificationId);
		
		agentNotification.setTitle(title);
		agentNotification.setLocation(location);
		agentNotification.setAddress(address);
		agentNotification.setDescription(description);
		agentNotification.setLink(link);
		agentNotification.setCategory(category);
		agentNotification.setMypageUserRoleId(roleId);
		agentNotification.setRole(role);
		agentNotification.setMypageUserGroupId(groupId);
		agentNotification.setGroup(group);
		agentNotification.setReferenceId(referenceId);
		
		if (Validator.isNotNull(startDate)) {
			agentNotification.setStartDate(dateFormat.parse(startDate));
		}
		
		if (Validator.isNotNull(endDate)) {
			agentNotification.setEndDate(dateFormat.parse(endDate));
		}

		if (Validator.isNotNull(startTime)) {
			agentNotification.setStartTime(startTime);
		}
		
		if (Validator.isNotNull(endTime)) {
			agentNotification.setEndTime(endTime);
		}
		
		agentNotification.setFileUploadUrl(fileURL);
		agentNotification.setFileUploadEntryId(fileEntryId);
		agentNotification.setIsAllDay(isAllDay);
		agentNotification.setIsRead(0);
		agentNotification.setActive(active);
		agentNotification.setMypageUserId(userId);

		agentNotificationPersistence.update(agentNotification);

		return agentNotification;
	}
	
	public AgentNotification updateNotification(String title, String location, String address, String description, 
			String link, String category, long roleId, long groupId, long referenceId, String startDate, String startTime, String endDate, String endTime, 
			String fileURL, long fileEntryId, int isAllDay, int active) throws PortalException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String role = roleId > 0 ? _mypageUserRoleLocalService.getMypageUserRole(roleId).getName() : "";
		String group = groupId > 0 ? _mypageUserGroupLocalService.getMypageUserGroup(groupId).getName() : "";
		AgentNotification agentNotification = agentNotificationPersistence.findByreferenceId(referenceId).get(0);
		
		agentNotification.setTitle(title);
		agentNotification.setLocation(location);
		agentNotification.setAddress(address);
		agentNotification.setDescription(description);
		agentNotification.setLink(link);
		agentNotification.setCategory(category);
		agentNotification.setMypageUserRoleId(roleId);
		agentNotification.setRole(role);
		agentNotification.setMypageUserGroupId(groupId);
		agentNotification.setGroup(group);
		agentNotification.setStartDate(dateFormat.parse(startDate));
		agentNotification.setStartTime(startTime);
		agentNotification.setEndDate(dateFormat.parse(endDate));
		agentNotification.setEndTime(endTime);
		
		if (Validator.isNotNull(fileEntryId)) {
			agentNotification.setFileUploadUrl(fileURL);
			agentNotification.setFileUploadEntryId(fileEntryId);
		}
		
		agentNotification.setIsAllDay(isAllDay);
		agentNotification.setActive(active);

		agentNotificationPersistence.update(agentNotification);

		return agentNotification;
	}
	
	public AgentNotification updateNotificationAdmin(long agentNotificationId, String title, String location, String address, String description, 
			String link, String category, long roleId, long groupId, long referenceId, String startDate, String startTime, String endDate, String endTime, 
			int isAllDay, int active) throws PortalException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String role = roleId > 0 ? _mypageUserRoleLocalService.getMypageUserRole(roleId).getName() : "";
		String group = groupId > 0 ? _mypageUserGroupLocalService.getMypageUserGroup(groupId).getName() : "";
		AgentNotification agentNotification = agentNotificationPersistence.findByPrimaryKey(agentNotificationId);
		
		agentNotification.setTitle(title);
		agentNotification.setLocation(location);
		agentNotification.setAddress(address);
		agentNotification.setDescription(description);
		agentNotification.setLink(link);
		agentNotification.setCategory(category);
		agentNotification.setMypageUserRoleId(roleId);
		agentNotification.setRole(role);
		agentNotification.setMypageUserGroupId(groupId);
		agentNotification.setGroup(group);
		agentNotification.setStartDate(dateFormat.parse(startDate));
		agentNotification.setStartTime(startTime);
		agentNotification.setEndDate(dateFormat.parse(endDate));
		agentNotification.setEndTime(endTime);
		agentNotification.setIsAllDay(isAllDay);
		agentNotification.setActive(active);

		agentNotificationPersistence.update(agentNotification);

		return agentNotification;
	}
	
	public AgentNotification setActive(long agentNotificationId, long referenceId, int active, ServiceContext serviceContext) throws PortalException {
		AgentNotification agentNotification = null;

		try {
			agentNotification = agentNotificationId > 0 ? agentNotificationPersistence.findByPrimaryKey(agentNotificationId) : agentNotificationPersistence.findByreferenceId(referenceId).get(0);
			Date now = new Date();
			agentNotification.setActive(active);
			agentNotification.setModifiedDate(serviceContext.getModifiedDate(now));

			agentNotificationPersistence.update(agentNotification);
		} catch (Exception e) {
			System.out.println(e);
		}

		return agentNotification;
	}
	
	public AgentNotification setIsRead(long notificationId, int isRead, ServiceContext serviceContext) throws PortalException {
		AgentNotification agentNotification = null;

		try {
			agentNotification = agentNotificationPersistence.fetchByPrimaryKey(notificationId);
			Date now = new Date();
			agentNotification.setIsRead(isRead);
			agentNotification.setModifiedDate(serviceContext.getModifiedDate(now));

			agentNotificationPersistence.update(agentNotification);
		} catch (Exception e) {
			System.out.println(e);
		}

		return agentNotification;
	}
	
	public List<AgentNotification> findByFilter(int start, int end, long userId, long roleId, List<Long> groupId, List<String> category) {
		List<AgentNotification> agentNotification = new ArrayList<AgentNotification>();
		
		Comparator<AgentNotification> comparator = Comparator.comparing(AgentNotification::getAgentNotificationId).reversed();
		
		if (start >= 0) {
			agentNotification = (List<AgentNotification>) agentNotificationPersistence.findAll().stream()
								.filter(v -> v.getActive() == 1 && category.contains(v.getCategory()) &&
								   	   (v.getMypageUserId() == userId || v.getMypageUserRoleId() == roleId || groupId.contains(v.getMypageUserGroupId())
								   	   ))
								.sorted(comparator)
								.skip(start)
								.limit(end - start)
								.collect(Collectors.toList());
		}
		
		return agentNotification;
	}
	
	public long findEndLicenseByYear(long userId, String category, int year) {
		DynamicQuery dynamicQuery = agentNotificationLocalService.dynamicQuery();
		
		dynamicQuery.add(RestrictionsFactoryUtil.eq("category", category));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("mypageUserId", userId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("active", 1));
		
	    List<AgentNotification> notifications = agentNotificationPersistence.findWithDynamicQuery(dynamicQuery);
	    
	    long size = 0L;
	    
	    for (AgentNotification item : notifications) {
	    	int itemYear = item.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear();
	    	
	    	if (itemYear == year) size = 1;
	    }
	    
	    return size;
	}
	
	@Reference
	private MypageUserRoleLocalService _mypageUserRoleLocalService;
	
	@Reference
	private MypageUserGroupLocalService _mypageUserGroupLocalService;
}