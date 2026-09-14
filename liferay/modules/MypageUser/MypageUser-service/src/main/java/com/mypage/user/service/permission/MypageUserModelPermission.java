package com.mypage.user.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {"model.class.name=com.mypage.user.model.MypageUser"}
	)
public class MypageUserModelPermission implements BaseModelPermissionChecker {
	public static void check(
        PermissionChecker permissionChecker, long mypageUserId, String actionId)
        throws PortalException, SystemException {

        if (!contains(permissionChecker, mypageUserId, actionId)) {
            throw new PrincipalException();
        }
    }

    public static void check(
        PermissionChecker permissionChecker, long groupId, long mypageUserId,
        String actionId)
        throws PortalException {

        if (!contains(permissionChecker, groupId, actionId)) {
            throw new PrincipalException.MustHavePermission(
                permissionChecker, MypageUser.class.getName(), mypageUserId,
                actionId);
        }
    }

    public static boolean contains(
        PermissionChecker permissionChecker, long groupId, long mypageUserId, String actionId) 
            throws PortalException {

        MypageUser mypageUser = _mypageUserLocalService.getMypageUser(mypageUserId);

        return MypageUserModelPermission.contains(permissionChecker, groupId, actionId);
    }

    public static boolean contains(
        PermissionChecker permissionChecker, long mypageUserId, String actionId)
        throws PortalException, SystemException {

        MypageUser mypageUser
            = _mypageUserLocalService.getMypageUser(mypageUserId);
        return contains(permissionChecker, mypageUser, actionId);
    }

    public static boolean contains(
        PermissionChecker permissionChecker, MypageUser mypageUser, String actionId) 
            throws PortalException, SystemException {

        return permissionChecker.hasPermission(
        mypageUser.getGroupId(), MypageUser.class.getName(), mypageUser.getMypageUserId(), actionId);

    }

    @Reference(unbind = "-")
    protected void setMypageUserLocalService(MypageUserLocalService mypageUserLocalService) {
        _mypageUserLocalService = mypageUserLocalService;
    }

    private static MypageUserLocalService _mypageUserLocalService;

    @Override
    public void checkBaseModel(
        PermissionChecker permissionChecker, long groupId, long mypageUserId, String actionId) throws PortalException {
            check(permissionChecker, mypageUserId, actionId);
    }
}
