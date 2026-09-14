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
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.user.model.MypageUserRole;
import com.mypage.user.service.base.MypageUserRoleLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.mypage.user.model.MypageUserRole",
	service = AopService.class
)
public class MypageUserRoleLocalServiceImpl extends MypageUserRoleLocalServiceBaseImpl {
	
	public List<MypageUserRole> getActiveRole() {
		return (List<MypageUserRole>) mypageUserRolePersistence.findAll().stream().filter(v -> v.getActive() == 1).collect(Collectors.toList());
	}
	
	public MypageUserRole addUserRole(String name, int active) throws PortalException {
		long mypageUserRoleId = counterLocalService.increment();
		MypageUserRole mypageUserRole = mypageUserRolePersistence.create(mypageUserRoleId);
			
		mypageUserRole.setName(name);
		mypageUserRole.setActive(active);

		mypageUserRolePersistence.update(mypageUserRole);

		return mypageUserRole;
	}
	
	public MypageUserRole updateUserRole(long mypageUserRoleId, String name, int active) throws PortalException {
		MypageUserRole mypageUserRole = mypageUserRolePersistence.findByPrimaryKey(mypageUserRoleId);
		
		mypageUserRole.setName(name);
		mypageUserRole.setActive(active);

		mypageUserRolePersistence.update(mypageUserRole);

		return mypageUserRole;
	}

	public MypageUserRole setActive(long mypageUserRoleId, int active, ServiceContext serviceContext) throws PortalException {
		MypageUserRole mypageUserRole = null;

		try {
			mypageUserRole = mypageUserRolePersistence.findByPrimaryKey(mypageUserRoleId);
			Date now = new Date();
			mypageUserRole.setActive(active);
			mypageUserRole.setModifiedDate(serviceContext.getModifiedDate(now));

			mypageUserRolePersistence.update(mypageUserRole);
		} catch (Exception e) {
			System.out.println(e);
		}

		return mypageUserRole;
	}
	
	public MypageUserRole getByName(String name) {
		List<MypageUserRole> result = null;
		DynamicQuery dynamicQuery = mypageUserRoleLocalService.dynamicQuery();
		
		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		conjunction.add(RestrictionsFactoryUtil.eq("name", name));
		
		dynamicQuery.add(conjunction);
		
		result = mypageUserRoleLocalService.dynamicQuery(dynamicQuery);
		
		if(result.size() < 1) {
			return null;
		}
		
		return result.get(0);
	}
}