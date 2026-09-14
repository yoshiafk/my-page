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
import com.mypage.admin.product.service.MasterPromoCodeLocalService;
import com.mypage.agencyportal.constants.AgentPromoCodePortletKeys;
import com.mypage.agencyportal.dto.APIResponse;
import com.mypage.agencyportal.dto.DataItemProductDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.helpers.LogHelper;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalService;
import com.mypage.user.service.MypageUserLocalService;
import com.mypage.user.service.MypageUserLocalServiceUtil;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Agent Promo Code",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/promocode/view.jsp",
		"javax.portlet.name=" + AgentPromoCodePortletKeys.AGENT_PROMO_CODE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AgentPromoCodePortlet extends MVCPortlet {
	private static String PIMCORE_HOST;
	private static String dashboardApiAgencyProductsUrl;
	private static String dashboardApiAgencyPromoCodeUrl;
	private static ActionHelpers helpers = new ActionHelpers();
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _log = LogFactoryUtil.getLog(AgentPromoCodePortlet.class);
	private static String deptoreCode = StringPool.BLANK;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		
		try {
			String token = StringPool.BLANK;
			
			try {
				token = EncryptionHelper.decrypt(ParamUtil.getString(httpRequest, "a"));

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
						if (helpers.isLog()) _log.info("Token Valid: Token dari param sama dengan token yang ada di DB dan status token valid.");
						
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
				// berarti belum pernah hit o/promo-code/show
				if (helpers.isLog()) _log.info("DeptCode tidak pernah terdaftar di DB.");
			}
			
			if (authStatus) {
				String decodeTokenBrowser = ParamUtil.getString(httpRequest, "a");
				String encodeToken = URLEncoder.encode(decodeTokenBrowser, "UTF-8");
				
				PIMCORE_HOST = helpers.getConfig("com.mypage.agent.config.pimcoreAddress");
				dashboardApiAgencyProductsUrl = helpers.getConfig("dashboard.api.agency.products");
				dashboardApiAgencyPromoCodeUrl = helpers.getConfig("dashboard.api.agency.promocode");
				deptoreCode = agentToken.getDeptCode();
				
				JSONObject promoCodePayload = JSONFactoryUtil.createJSONObject();
				promoCodePayload.put("Code", deptoreCode);
				
				JSONObject userDetailResponse = ActionHelpers.hitAPI(PIMCORE_HOST + dashboardApiAgencyPromoCodeUrl, promoCodePayload.toString(), encodeToken);
				
				JSONObject userDetailAPIResponseDto = JSONFactoryUtil.createJSONObject(userDetailResponse.get("response").toString());
				
				if (helpers.isLog()) _log.info(userDetailAPIResponseDto.getJSONArray("Data").toString());
				
				if (userDetailAPIResponseDto.getInt("Status") == 1) {
					for (int i = 0; i < userDetailAPIResponseDto.getInt("Count"); i++) {
						JSONObject data = JSONFactoryUtil.createJSONObject(userDetailAPIResponseDto.getJSONArray("Data").get(i).toString());
						
						int searchPromoCode = _masterPromoCodeLocalService.countByPromoCode(0, data.getString("PromoCode"));
						
						if (searchPromoCode > 0) continue;
						
						int active = data.getBoolean("Status") == true ? 1 : 0;
						long userId = _mypageUserLocalService.getByDeptoreCode(deptoreCode).getMypageUserId();
						String agentCode = _mypageUserLocalService.getByDeptoreCode(deptoreCode).getCode();
						String agentName = _mypageUserLocalService.getByDeptoreCode(deptoreCode).getUserName();
						
				        _masterPromoCodeLocalService.updatePromoCode(data.getLong("Id"), data.getString("ProductCode"), data.getString("Product"), data.getString("PromoCode"), data.getDouble("Discount", 0), data.getString("StartDate"), data.getString("EndDate"), data.getString("Limit"), data.getString("PromoCodeTerms"), data.getString("Remarks"), userId, agentCode, agentName, deptoreCode, data.getDouble("Commission", 0), active);
					}
				}
				
				URI uriProducts = new URI(PIMCORE_HOST + dashboardApiAgencyProductsUrl);
				String URLproducts = uriProducts.toString();
				String postDataProduct = "Code=" + deptoreCode;
				byte[] postDataBytesProduct = postDataProduct.getBytes(StandardCharsets.UTF_8);
				APIResponse<DataItemProductDto> listProducts = helpers.APIClients(URLproducts, postDataBytesProduct,
						DataItemProductDto.class, encodeToken);
				
				long userId = MypageUserLocalServiceUtil.getByDeptoreCode(deptoreCode).getMypageUserId();
				
				int size = 10;
				int totalItems = _masterPromoCodeLocalService.countByUserId(userId);
		        int totalPages = (int) Math.ceil((double) totalItems / size);
		        
				int page = Validator.isNull(httpRequest.getParameter("page")) == true ? 1 : Validator.isNumber(httpRequest.getParameter("page")) == true ? Integer.valueOf(httpRequest.getParameter("page")) : 0;
		        
		        if (page > totalPages) page = totalPages;
				
		        renderRequest.setAttribute("userId", userId);
				renderRequest.setAttribute("size", size);
				renderRequest.setAttribute("current_page", page);
				renderRequest.setAttribute("total_pages", totalPages);
				renderRequest.setAttribute("products", listProducts);
				renderRequest.setAttribute("encodeToken", encodeToken);
				
				PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/promocode/view.jsp");
				dispatcher.include(renderRequest, renderResponse);
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
	private MasterPromoCodeLocalService _masterPromoCodeLocalService;
	
	@Reference
	private MypageUserLocalService _mypageUserLocalService;
	
	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
}