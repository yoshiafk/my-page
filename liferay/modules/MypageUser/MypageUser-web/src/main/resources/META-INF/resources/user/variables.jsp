<%@ include file="../includes/init.jsp"%>
<%
	String pageKey = ParamUtil.getString(renderRequest, "pageKey", "account");
	boolean allowAdd = MypageUserPermission.contains(permissionChecker, scopeGroupId, "ADD_ENTRY");
	long mypageUserId = ParamUtil.getLong(renderRequest, "mypageUserId", 0);
	long liferayUserId = 0;
	String[] onlyAdmin = {"account", "agent", "license", "grace_period"};
	String[] pages = {"account", "agent", "basic_information", "password", "license", "grace_period", "about_me", "social_media", "image", "working_hour","timeline"};

	User liferayUser = null;
	MypageUser mypageUser = null;
	
	if(mypageUserId > 0) {
		// if update
		mypageUser = MypageUserLocalServiceUtil.getMypageUser(mypageUserId);
		liferayUser = UserLocalServiceUtil.getUser(mypageUser.getLiferayUserId());
		liferayUserId = mypageUser.getLiferayUserId();
		
		allowAdd = MypageUserPermission.contains(permissionChecker, scopeGroupId, "ADD_ENTRY");
		
		if(!allowAdd && Arrays.asList(onlyAdmin).contains(pageKey)) {
			pageKey = "basic_information";
		}
	} else {
		// if agent login
		if(!allowAdd) {
			// get current user
			User currentUser = themeDisplay.getUser();
			mypageUser = MypageUserLocalServiceUtil.getByLiferayUserId(currentUser.getUserId());
			liferayUser = UserLocalServiceUtil.getUser(mypageUser.getLiferayUserId());
			
			mypageUserId = mypageUser.getMypageUserId();
			liferayUserId = mypageUser.getLiferayUserId();
			pageKey = "basic_information";
		}
	}
%>
