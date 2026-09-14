package com.mypage.leads.misc;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.product.navigation.control.menu.BaseProductNavigationControlMenuEntry;
import com.liferay.product.navigation.control.menu.ProductNavigationControlMenuEntry;
import com.liferay.product.navigation.control.menu.constants.ProductNavigationControlMenuCategoryKeys;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"product.navigation.control.menu.category.key=" + ProductNavigationControlMenuCategoryKeys.USER,
			"product.navigation.control.menu.entry.order:Integer=1"
		},
		service = ProductNavigationControlMenuEntry.class
	)
public class MypageLeadsControlMenuEntry extends BaseProductNavigationControlMenuEntry
implements ProductNavigationControlMenuEntry {
	private String _label;
	private String _icon;
	private String _iconCss;

	@Override
	public String getLabel(Locale locale) {
		return _label;
	}
	
	public String getIconCssClass(Locale locale) {
		return _iconCss;
	}
 	

	@Override
	public String getURL(HttpServletRequest httpServletRequest) {
		return null;
	}

	@Override
	public String getIcon(HttpServletRequest httpServletRequest) {
		return _icon;
	}	
	
	@Override
	public boolean isShow(HttpServletRequest httpServletRequest)
		throws PortalException {
		if(httpServletRequest.getRequestURI().endsWith("leads/parents")) {
			_label = "Export All Data";
			_iconCss = "lexicon-icon";
			_icon = "download";
			return true;
		}
		return false;
	}	
}
