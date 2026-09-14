package com.mypage.agencyportal.application.list;

import com.liferay.application.list.BasePanelCategory;
import com.liferay.application.list.PanelCategory;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.agencyportal.constants.AgencyPortalPanelCategoryKeys;
import com.mypage.agencyportal.helpers.ActionHelpers;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

@Component(
immediate = true,
property = {
	"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION,
	"panel.category.order:Integer=50"
	},
	service = PanelCategory.class
)
public class AgencyPortalPanelCategory extends BasePanelCategory {
	@Override
	public String getKey() {
		return AgencyPortalPanelCategoryKeys.AGENCY_PORTAL_CATEGORY;
	}
	
	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle("content.Language", locale, getClass());
		return LanguageUtil.get(resourceBundle, "agency_portal_category");
	}
	
	@Override
	public boolean isShow(PermissionChecker permissionChecker, Group group) throws PortalException {
        ActionHelpers helpers = new ActionHelpers();
        long siteId = permissionChecker.getUser().getCompanyId();
        
        // JIKA GAGAL GET CONFIG, KEMUNGKINAN ADA TANDA BACA YANG KURANG PADA AGENCY JSON
    	long instance = Validator.isNull(helpers.getConfig("com.mypage.agent.config.instance")) ? 0 : Long.valueOf(helpers.getConfig("com.mypage.agent.config.instance"));
    	
		if (siteId == instance) return true;
		
		return false;
	}
}
