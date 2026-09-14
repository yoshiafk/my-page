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

package com.mypage.user.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.user.exception.NoSuchMypageUserGroupException;
import com.mypage.user.model.MypageUserGroup;
import com.mypage.user.service.base.MypageUserGroupLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.mypage.user.model.MypageUserGroup",
	service = AopService.class
)
public class MypageUserGroupLocalServiceImpl extends MypageUserGroupLocalServiceBaseImpl {
	public List<MypageUserGroup> getActiveGroup() {
		return (List<MypageUserGroup>) mypageUserGroupPersistence.findAll().stream().filter(v -> v.getActive() == 1).collect(Collectors.toList());
	}
	
	public MypageUserGroup addUserGroup(String name, int active) throws PortalException {
		long mypageUserGroupId = counterLocalService.increment();
		MypageUserGroup mypageUserGroup = mypageUserGroupPersistence.create(mypageUserGroupId);
			
		mypageUserGroup.setName(name);
		mypageUserGroup.setActive(active);

		mypageUserGroupPersistence.update(mypageUserGroup);

		return mypageUserGroup;
	}
	
	public MypageUserGroup updateUserGroup(long mypageUserGroupId, String name, int active) throws PortalException {
		MypageUserGroup mypageUserGroup = mypageUserGroupPersistence.findByPrimaryKey(mypageUserGroupId);
		
		mypageUserGroup.setName(name);
		mypageUserGroup.setActive(active);

		mypageUserGroupPersistence.update(mypageUserGroup);

		return mypageUserGroup;
	}

	public MypageUserGroup setActive(long mypageUserGroupId, int active, ServiceContext serviceContext) throws PortalException {
		MypageUserGroup mypageUserGroup = null;

		try {
			mypageUserGroup = mypageUserGroupPersistence.findByPrimaryKey(mypageUserGroupId);
			Date now = new Date();
			mypageUserGroup.setActive(active);
			mypageUserGroup.setModifiedDate(serviceContext.getModifiedDate(now));

			mypageUserGroupPersistence.update(mypageUserGroup);
		} catch (Exception e) {
			System.out.println(e);
		}

		return mypageUserGroup;
	}
	
	public MypageUserGroup findBymypageUserGroupId(long mypageUserGroupId) throws NoSuchMypageUserGroupException {
	    return mypageUserGroupPersistence.findByPrimaryKey(mypageUserGroupId);
	}
	
	public List<Long> findBymypageUserId(long mypageUserId) {
		List<Long> ids = new ArrayList<>();
		
		List<MypageUserGroup> groups = mypageGroupUserFinder.findBymypageUserId(mypageUserId);
		        
        for (MypageUserGroup group : groups) {
        	ids.add(group.getMypageUserGroupId());
        }
		
		return ids;
	}
}