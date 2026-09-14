package com.mypage.leads.routes;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.mypage.leads.constants.PaymentPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(
	     property = {
	         "com.liferay.portlet.friendly-url-routes=META-INF/routes/payment.xml",
	         "javax.portlet.name=" + PaymentPortletKeys.PAYMENT
	     },
	     service = FriendlyURLMapper.class
	 )
public class PaymentRoutesMapper extends DefaultFriendlyURLMapper {
	@Override
    public String getMapping() {
        return _MAPPING;
    }

    private static final String _MAPPING = "payment";
}
