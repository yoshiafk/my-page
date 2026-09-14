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
import com.mypage.user.model.MypageGroupUser;
import com.mypage.user.model.MypageUser;
import com.mypage.user.model.MypageUserGroup;
import com.mypage.user.service.base.MypageGroupUserLocalServiceBaseImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.mypage.user.model.MypageGroupUser",
	service = AopService.class
)
public class MypageGroupUserLocalServiceImpl extends MypageGroupUserLocalServiceBaseImpl {
	
	public List<MypageUserGroup> getActiveGroup() {
		return (List<MypageUserGroup>) mypageUserGroupPersistence.findAll().stream().filter(v -> v.getActive() == 1).collect(Collectors.toList());
	}
	
	public MypageGroupUser addGroupUser(long mypageGroupId, List<Long> mypageUserId) throws PortalException {
		MypageGroupUser mypageGroupUser = null;
		
		for (Long item : mypageUserId) {
			boolean isExist = mypageGroupUserPersistence.findAll().stream()
								.filter(v -> v.getMypageGroupId() == mypageGroupId && v.getMypageUserId() == item)
								.collect(Collectors.toList()).size() > 0 ? true : false;
								
			if (isExist == false) {
				long mypageGroupUserId = counterLocalService.increment();
				mypageGroupUser = mypageGroupUserPersistence.create(mypageGroupUserId);
	
				mypageGroupUser.setMypageGroupId(mypageGroupId);
				mypageGroupUser.setMypageUserId(item);
		
				mypageGroupUserPersistence.update(mypageGroupUser);
			}
        }

		return mypageGroupUser;
	}
	
	public MypageGroupUser removeGroupUser(long mypageGroupId, List<Long> mypageUserId) throws PortalException {
		MypageGroupUser mypageGroupUser = null;
		
		if (mypageUserId.size() > 0) {
			for (Long item : mypageUserId) {
				long mypageGroupUserId = mypageGroupUserPersistence.findAll().stream()
											.filter(v -> v.getMypageGroupId() == mypageGroupId && v.getMypageUserId() == item)
											.findFirst().get().getMypageGroupUserId();
									
				mypageGroupUserPersistence.remove(mypageGroupUserId);
	        }
		} else {
			mypageGroupUserPersistence.removeBymypageGroupId(mypageGroupId);
		}

		return mypageGroupUser;
	}
	
	public List<MypageUser> findBymypageGroupId(long mypageGroupId) {
		return mypageGroupUserFinder.findBymypageGroupId(mypageGroupId);
	}
}