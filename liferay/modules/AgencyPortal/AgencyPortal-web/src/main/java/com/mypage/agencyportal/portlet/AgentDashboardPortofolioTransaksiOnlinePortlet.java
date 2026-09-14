package com.mypage.agencyportal.portlet;

import com.google.gson.Gson;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.agencyportal.constants.AgentDashboardPortofolioTransaksiOnlinePortletKeys;
import com.mypage.agencyportal.dto.APIResponse;
import com.mypage.agencyportal.dto.DataItemProductDto;
import com.mypage.agencyportal.dto.DataLeadsStatusDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.helpers.LogHelper;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalService;
import com.mypage.user.service.MypageUserLocalService;

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

@Component(immediate = true, property = { 
		"com.liferay.portlet.display-category=myPage",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Agent Dashboard Portofolio Online",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/dashboard/portofolio/dashboard_portofolio_transaksi_online.jsp",
		"javax.portlet.name=" + AgentDashboardPortofolioTransaksiOnlinePortletKeys.AGENT_DASHBOARD_PORTOFOLIO_TRX_ONLINE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, 
service = Portlet.class)
public class AgentDashboardPortofolioTransaksiOnlinePortlet extends MVCPortlet {

	private static String PIMCORE_HOST;
	private static String dashboardApiAgencyProductsUrl;
	private static String dashboardApiAgencyLeadsStatus;	
	private static ActionHelpers helpers = new ActionHelpers();
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _log = LogFactoryUtil.getLog(AgentDashboardPortofolioTransaksiOnlinePortlet.class);
	private static String deptoreCode = StringPool.BLANK;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

		String token = StringPool.BLANK;
		String tokenMobile = StringPool.BLANK;
		
		try {
			token = EncryptionHelper.decrypt(ParamUtil.getString(httpRequest, "a"));
			tokenMobile = ParamUtil.getString(httpRequest, "m");
			
			String decodeTokenBrowser = ParamUtil.getString(httpRequest, "a");
			String encodeToken = URLEncoder.encode(decodeTokenBrowser, "UTF-8");
			
			if (Validator.isBlank(token) == true) {
				PortletRequestDispatcher dispatcher = getPortletContext()
						.getRequestDispatcher("/META-INF/resources/includes/404.jsp");
				dispatcher.include(renderRequest, renderResponse);
				return;
			}

			// VALIDASI TOKEN SEKALI PAKAI
			String tokenFromParam = token;
			
			boolean authStatus = false;

			AgentToken agentToken = _agentTokenLocalService.getAgentTokenByToken(tokenFromParam);

			if (!Validator.isNull(agentToken)) {
				if (agentToken.getToken().equals(tokenFromParam)) {
					if (agentToken.getIsValid() == 0) {
						if (helpers.isLog()) _log.info(
								"Token tidak valid: token dari param sama dengan token di DB tapi di DB statusnya tidak valid.");
					} else {
						if (helpers.isLog()) _log.info(
								"Token Valid: Token dari param sama dengan token yang ada di DB dan status token valid.");

						// Invalidate Render token and set to attribute
						_agentTokenLocalService.setAgentTokenToInvalid(agentToken.getAgentTokenId());
						renderRequest.setAttribute("renderToken", agentToken.getToken());

						// Renew api request token
						AgentToken agentTokenRenewApiToken = _agentTokenLocalService
								.renewAgentToken(agentToken.getAgentTokenId());
						if (Validator.isNull(agentTokenRenewApiToken)) {
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
				// berarti belum pernah hit o/performance-booking/show
				if (helpers.isLog()) _log.info("DeptCode tidak pernah terdaftar di DB.");
			}

			if (authStatus) {

				PIMCORE_HOST = helpers.getConfig("com.mypage.agent.config.pimcoreAddress");
				dashboardApiAgencyProductsUrl = helpers.getConfig("dashboard.api.agency.products");
				dashboardApiAgencyLeadsStatus = helpers.getConfig("dashboard.api.agency.leads.status");
				deptoreCode = agentToken.getDeptCode();

				Gson gson = new Gson();
				
				// get product
				URI uriProducts = new URI(PIMCORE_HOST + dashboardApiAgencyProductsUrl);
				String URLproducts = uriProducts.toString();
				String postDataProduct = "Code=" + deptoreCode;
				byte[] postDataBytesProduct = postDataProduct.getBytes(StandardCharsets.UTF_8);
				APIResponse<DataItemProductDto> listProducts = helpers.APIClients(URLproducts, postDataBytesProduct,
						DataItemProductDto.class, encodeToken);
				
				if (helpers.isLog()) _log.info(gson.toJson(listProducts.getData()));
				if(Integer.valueOf(listProducts.getStatus()) < 1) {
					if (helpers.isLog()) _log.info(listProducts.getMessage());
					PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/includes/404.jsp");
					dispatcher.include(renderRequest, renderResponse);
					return;
				}
				
				//get status
				URI uriStatus = new URI(PIMCORE_HOST + dashboardApiAgencyLeadsStatus);
				String URLstatus = uriStatus.toString();
				String postDataStatus = "Code=" + deptoreCode;
				byte[] postDataBytesStatus = postDataStatus.getBytes(StandardCharsets.UTF_8);
				APIResponse<DataLeadsStatusDto> listStatus = helpers.APIClients(URLstatus, postDataBytesStatus, DataLeadsStatusDto.class, encodeToken);
				
				if (helpers.isLog()) _log.info(gson.toJson(listStatus.getData()));
				if(Integer.valueOf(listStatus.getStatus()) < 1) {
					if (helpers.isLog()) _log.info(listStatus.getMessage());
					PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/includes/404.jsp");
					dispatcher.include(renderRequest, renderResponse);
					return;
				}
				
				renderRequest.setAttribute("products", listProducts);
				renderRequest.setAttribute("statusLeads", listStatus);
				renderRequest.setAttribute("tokenMobile", tokenMobile);

				PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(
						"/META-INF/resources/dashboard/portofolio/dashboard_portofolio_transaksi_online.jsp");
				dispatcher.include(renderRequest, renderResponse);


			} else {
				String url = PortalUtil.getCurrentURL(httpRequest);
				int lastIndex = url.lastIndexOf("/");
				String lastPart = url.substring(lastIndex + 1).split("\\?")[0];
				
				renderRequest.setAttribute("endpoint", lastPart);
				
				PortletRequestDispatcher dispatcher = getPortletContext()
						.getRequestDispatcher("/META-INF/resources/includes/404.jsp");
				dispatcher.include(renderRequest, renderResponse);
			}
		} catch (Exception e) {
			if (helpers.isLog()) _log.info(e.getMessage());
			
			String url = PortalUtil.getCurrentURL(httpRequest);
			int lastIndex = url.lastIndexOf("/");
			String lastPart = url.substring(lastIndex + 1).split("\\?")[0];
			
			renderRequest.setAttribute("endpoint", lastPart);
			
			PortletRequestDispatcher dispatcher = getPortletContext()
					.getRequestDispatcher("/META-INF/resources/includes/404.jsp");
			dispatcher.include(renderRequest, renderResponse);
			return;
		}

	}


	@Reference
	private MypageUserLocalService _mypageUserLocalService;

	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
}