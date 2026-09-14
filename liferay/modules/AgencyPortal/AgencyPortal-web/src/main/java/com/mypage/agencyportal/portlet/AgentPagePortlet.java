package com.mypage.agencyportal.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
import com.mypage.agencyportal.constants.AgentPagePortletKeys;
import com.mypage.agencyportal.dto.APIResponse;
import com.mypage.agencyportal.dto.DataItemProductDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.helpers.LogHelper;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalService;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserLocalService;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=myPage",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Agent Page",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/pages/view.jsp",
		"javax.portlet.name=" + AgentPagePortletKeys.AGENT_PAGE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
service = Portlet.class)
public class AgentPagePortlet extends MVCPortlet {
	private static String PIMCORE_HOST;
	private static String dashboardApiAgencyProductsUrl;
	private static String dashboardApiAgencyUserUrl;
	private static ActionHelpers helpers = new ActionHelpers();
	private static String deptoreCode = StringPool.BLANK;
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _log = LogFactoryUtil.getLog(AgentPagePortlet.class);
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

		PIMCORE_HOST = helpers.getConfig("com.mypage.agent.config.pimcoreAddress");
		
		try {
			String token = StringPool.BLANK;
			String page = StringPool.BLANK;
			
			System.out.println("httpRequest, \"a\")" + ParamUtil.getString(httpRequest, "a"));
			
			try {
				token = EncryptionHelper.decrypt(ParamUtil.getString(httpRequest, "a"));
				page = ParamUtil.getString(httpRequest, "b");

				// Tampilkan halaman 404 jika parameter tidak lengkap
				if (Validator.isNull(token) == true) {
					PortletRequestDispatcher dispatcher = getPortletContext()
							.getRequestDispatcher("/META-INF/resources/includes/404.jsp");
					dispatcher.include(renderRequest, renderResponse);
					return;
				}
			} catch (Exception e) {
				// e.printStackTrace();
			}
			
			// VALIDASI TOKEN SEKALI PAKAI
			String tokenFromParam = token;
			boolean authStatus = false;
			AgentToken agentToken = _agentTokenLocalService.getAgentTokenByToken(tokenFromParam);

			if (!Validator.isNull(agentToken)) {
				if (agentToken.getToken().equals(tokenFromParam)) {
					if (agentToken.getIsValid() == 0) {
						if (helpers.isLog()) _log.info("Token tidak valid: token dari param sama dengan token di DB tapi di DB statusnya tidak valid.");
					} else {
						System.out.println("Token Valid: Token dari param sama dengan token yang ada di DB dan status token valid.");
						
						// Invalidate Render token and set to attribute
						_agentTokenLocalService.setAgentTokenToInvalid(agentToken.getAgentTokenId());
					    renderRequest.setAttribute("renderToken", agentToken.getToken());
						
						// Renew api request token
					    AgentToken agentTokenRenewApiToken = _agentTokenLocalService.renewAgentToken(agentToken.getAgentTokenId());
					    if(Validator.isNull(agentTokenRenewApiToken)) {
					    	if (helpers.isLog()) _log.info("Failed to renew agent token api request token");
					    	throw new Exception("Failed to renew agent token api request token");
					    }
					    renderRequest.setAttribute("apiRequestToken", agentTokenRenewApiToken.getApiRequestToken());
					    
					    // ini nanti dihapus kalau di resource command sudah selesai
						renderRequest.setAttribute("token", agentTokenRenewApiToken.getApiRequestToken());
						
					    // Set auth status to true
						authStatus = true;
					}
				} else {
					if (helpers.isLog()) _log.info("Token Tidak Valid: Token dari param tidak sama dengan token yang ada di DB.");
				}
			} else {
				// berarti belum pernah hit o/sales-tools/show
				if (helpers.isLog()) _log.info("DeptCode tidak pernah terdaftar di DB.");
			}
			
			if (authStatus) {
				deptoreCode = agentToken.getDeptCode();
				MypageUser user = _mypageUserLocalService.getByDeptoreCode(agentToken.getDeptCode());
				
				renderRequest.setAttribute("myPageUser", user);
				
				String decodeTokenBrowser = ParamUtil.getString(httpRequest, "a");
				String encodeToken = URLEncoder.encode(decodeTokenBrowser, "UTF-8");
				
				if (page.equalsIgnoreCase("ev")) {
					dashboardApiAgencyUserUrl = helpers.getConfig("dashboard.api.agency.user");
					
					JSONObject promoCodePayload = JSONFactoryUtil.createJSONObject();
					promoCodePayload.put("Code", deptoreCode);
					
					JSONObject userDetailResponse = ActionHelpers.hitAPI(PIMCORE_HOST + dashboardApiAgencyUserUrl, promoCodePayload.toString(), encodeToken);
					
					JSONObject userDetailAPIResponseDto = JSONFactoryUtil.createJSONObject(userDetailResponse.get("response").toString());
					
					if (helpers.isLog()) _log.info(userDetailAPIResponseDto.getJSONObject("Data").getJSONObject("Taxation").toString());
					
					renderRequest.setAttribute("encodeToken", encodeToken);
					renderRequest.setAttribute("isTaxation", userDetailAPIResponseDto.getJSONObject("Data").getJSONObject("Taxation").length() > 0 ? true : false );
					
					PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/pages/edit.jsp");
					dispatcher.include(renderRequest, renderResponse);
				} else {
					dashboardApiAgencyProductsUrl = helpers.getConfig("dashboard.api.agency.products");
					
					URI uriProducts = new URI(PIMCORE_HOST + dashboardApiAgencyProductsUrl);
					String URLproducts = uriProducts.toString();
					String postDataProduct = "Code=" + deptoreCode;
					byte[] postDataBytesProduct = postDataProduct.getBytes(StandardCharsets.UTF_8);
					APIResponse<DataItemProductDto> listProducts = helpers.APIClients(URLproducts, postDataBytesProduct,
							DataItemProductDto.class, encodeToken);
					
					if (helpers.isLog()) _log.info(listProducts.getStatus());
					
					List<MasterGlobalVariable> iconProducts = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Product");
					
					renderRequest.setAttribute("products", listProducts);
					renderRequest.setAttribute("iconProducts", iconProducts);
					renderRequest.setAttribute("pageType", page);
					
					PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/pages/view.jsp");
					dispatcher.include(renderRequest, renderResponse);
				}
			} else {
				String url = PortalUtil.getCurrentURL(httpRequest);
				int lastIndex = url.lastIndexOf("/");
				String lastPart = url.substring(lastIndex + 1).split("\\?")[0];
				
				renderRequest.setAttribute("endpoint", lastPart);
				
				if (helpers.isLog()) _log.info(authStatus);
				
				PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/includes/404.jsp");
				dispatcher.include(renderRequest, renderResponse);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (helpers.isLog()) _log.info(e.getMessage());
			
			String url = PortalUtil.getCurrentURL(httpRequest);
			int lastIndex = url.lastIndexOf("/");
			String lastPart = url.substring(lastIndex + 1).split("\\?")[0];
			
			renderRequest.setAttribute("endpoint", lastPart);
			
//			if (helpers.isLog()) _log.info(e.getStackTrace());
			
			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/includes/404.jsp");
			dispatcher.include(renderRequest, renderResponse);
		}
	}
	
	@Reference
	private MypageUserLocalService _mypageUserLocalService;
	
	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
}
