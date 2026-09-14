//package com.mypage.agencyportal.portlet;
//
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//import com.liferay.portal.kernel.util.PortalUtil;
//import com.mypage.agencyportal.constants.AgentDashboardPortofolioTransaksiOnlinePortletKeys;
//import com.mypage.agencyportal.helpers.Utils;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URISyntaxException;
//import java.util.Map;
//
//import javax.portlet.PortletException;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//import javax.servlet.http.HttpServletRequest;
//
//import org.osgi.service.component.annotations.Component;
//
///**
// * 
// * @author Muhammad Baharuddin
// * portlet ini tidak dipakai, mungkin akan dihapus kemudian. saat ini menggunakan mvc portlet dan bukan render karena url path nya agar tidak generate
// */
//
//@Component(immediate = true, property = { 
//		"javax.portlet.name=" + AgentDashboardPortofolioTransaksiOnlinePortletKeys.AGENT_DASHBOARD_PORTOFOLIO_TRX_ONLINE,
//		"mvc.command.name=/portofolio/detail" })
//public class PortofolioDetailRenderMvcCommand implements MVCRenderCommand {
//	
//	private static Utils utils = new Utils();
//
//	@Override
//	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
//		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
//       
//        
//        try {
//        	
//        	StringBuffer requestURL = httpServletRequest.getRequestURL();
//            String queryString = httpServletRequest.getQueryString();
//            String fullURL = requestURL.toString();
//            if (queryString != null) {
//                fullURL += "?" + queryString;
//            }
//        	
//            Map<String, String> params = utils.getQueryParameters(fullURL);
////            renderRequest.setAttribute("params", params);
//            
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        	
//		return "/dashboard/portofolio/dashboard_portofolio_detail.jsp";
//	}
//	
//}
//
