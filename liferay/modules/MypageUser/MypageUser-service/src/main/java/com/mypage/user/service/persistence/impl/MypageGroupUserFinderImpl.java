package com.mypage.user.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.mypage.user.model.MypageGroupUser;
import com.mypage.user.model.MypageUser;
import com.mypage.user.model.MypageUserGroup;
import com.mypage.user.service.MypageUserGroupLocalServiceUtil;
import com.mypage.user.service.MypageUserLocalServiceUtil;
import com.mypage.user.service.persistence.MypageGroupUserFinder;

import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(service = MypageGroupUserFinder.class)
public class MypageGroupUserFinderImpl extends MypageGroupUserFinderBaseImpl implements MypageGroupUserFinder {
	public List<MypageUser> findBymypageGroupId(long mypageGroupId) {
		
	    Session session = null;
		List<MypageUser> users = Collections.emptyList();
		
	    try {
	        session = openSession();

	        ClassLoader classLoader = getClass().getClassLoader();

	        DynamicQuery mypageGroupUserQuery = DynamicQueryFactoryUtil.forClass(MypageGroupUser.class, classLoader)
	                .add(RestrictionsFactoryUtil.eq("mypageGroupId", mypageGroupId))
	                .setProjection(ProjectionFactoryUtil.property("mypageUserId"));

            Order order = OrderFactoryUtil.asc("userName");

            DynamicQuery mypageUserQuery = DynamicQueryFactoryUtil.forClass(MypageUser.class, classLoader)
                .add(PropertyFactoryUtil.forName("mypageUserId").in(mypageGroupUserQuery))
                .addOrder(order);
    		
    		users = MypageUserLocalServiceUtil.dynamicQuery(mypageUserQuery);
	    }
	    catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        }
	        catch (SystemException se) {
	            se.printStackTrace();
	        }
	    }
	    finally {
	        closeSession(session);
	    }

        return users;
	}
	
public List<MypageUserGroup> findBymypageUserId(long mypageUserId) {
		
	    Session session = null;
		List<MypageUserGroup> groups = Collections.emptyList();
		
	    try {
	        session = openSession();

	        ClassLoader classLoader = getClass().getClassLoader();

	        DynamicQuery mypageGroupUserQuery = DynamicQueryFactoryUtil.forClass(MypageGroupUser.class, classLoader)
	                .add(RestrictionsFactoryUtil.eq("mypageUserId", mypageUserId))
	                .setProjection(ProjectionFactoryUtil.property("mypageGroupId"));

            Order order = OrderFactoryUtil.asc("name");

            DynamicQuery mypageUserGroupQuery = DynamicQueryFactoryUtil.forClass(MypageUserGroup.class, classLoader)
                .add(PropertyFactoryUtil.forName("mypageUserGroupId").in(mypageGroupUserQuery))
                .addOrder(order);
    		
            groups = MypageUserGroupLocalServiceUtil.dynamicQuery(mypageUserGroupQuery);
	    }
	    catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        }
	        catch (SystemException se) {
	            se.printStackTrace();
	        }
	    }
	    finally {
	        closeSession(session);
	    }

        return groups;
	}
}
