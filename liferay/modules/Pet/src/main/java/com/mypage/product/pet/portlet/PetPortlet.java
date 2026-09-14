package com.mypage.product.pet.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.admin.product.model.PetPlan;
import com.mypage.admin.product.service.PetPlanLocalService;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalService;
import com.mypage.product.pet.constants.PetPortletKeys;
import com.mypage.product.pet.helpers.EncryptionHelper;
import com.mypage.product.pet.helpers.MypageHelpers;
import com.mypage.user.service.MypageUserLocalService;
import com.mypage.user.service.MypageUserRoleLocalService;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gositus
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=mypage",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Pet Insurance", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/step1.jsp", "javax.portlet.name=" + PetPortletKeys.PET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class PetPortlet extends MVCPortlet {

	private static MypageHelpers mypageHelpers = new MypageHelpers();

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

		ServiceContext serviceContext = null;
		try {
			serviceContext = ServiceContextFactory.getInstance(renderRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String token = StringPool.BLANK;

		// check token
		try {
			
			String mvcPath = ParamUtil.get(renderRequest, "mvcPath", "");
			
			String aParam = ParamUtil.getString(httpRequest, "a");
			token = EncryptionHelper.decryptOri(aParam);

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
//						logs.log("Token tidak valid: token dari param sama dengan token di DB tapi di DB statusnya tidak valid.");
						System.out.println(
								"Token tidak valid: token dari param sama dengan token di DB tapi di DB statusnya tidak valid.");
					} else {
//						logs.log("Token Valid: Token dari param sama dengan token yang ada di DB dan status token valid.");
						System.out.println(
								"Token Valid: Token dari param sama dengan token yang ada di DB dan status token valid.");

						// Invalidate Render token and set to attribute
//						_agentTokenLocalService.setAgentTokenToInvalid(agentToken.getAgentTokenId());
//						renderRequest.setAttribute("renderToken", agentToken.getToken());
						
						// bawa a param untuk halaman berikutnya
						renderRequest.setAttribute("aParam", aParam);

						// Renew api request token
//						AgentToken agentTokenRenewApiToken = _agentTokenLocalService
//								.renewAgentToken(agentToken.getAgentTokenId());
//						if (Validator.isNull(agentTokenRenewApiToken)) {
////					    	logs.log("Failed to renew agent token api request token");
//							System.out.println("Failed to renew agent token api request token");
//							throw new Exception("Failed to renew agent token api request token");
//						}
//						renderRequest.setAttribute("apiRequestToken", agentTokenRenewApiToken.getApiRequestToken());

						// ini nanti dihapus kalau di resource command sudah selesai
//						renderRequest.setAttribute("token", agentTokenRenewApiToken.getApiRequestToken());

						// Set auth status to true
						authStatus = true;
					}
				} else {
//					logs.log("Token Tidak Valid: Token dari param tidak sama dengan token yang ada di DB.");
					System.out.println("Token Tidak Valid: Token dari param tidak sama dengan token yang ada di DB.");
				}
			} else {
				// berarti belum pernah hit o/performance-booking/show
//				logs.log("DeptCode tidak pernah terdaftar di DB.");
				System.out.println("DeptCode tidak pernah terdaftar di DB.");
			}
			
			if(authStatus) {
				
				String lrToPimcKycMiddlewareUrl = mypageHelpers
						.getConfig("com.mypage.product.pet.config.lrToPimcKycMiddlewareUrl");
				String pmcrPaymentUrl = mypageHelpers.getConfig("com.mypage.product.pet.config.pmcrPaymentUrl");

				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

				// Web Content
				String _pep_wording_question_content = MypageHelpers.getWebContentByFriendlyUrl("pep-wording-question",
						themeDisplay);

				// Remove paragraph element
				if (!Validator.isBlank(_pep_wording_question_content)) {
					_pep_wording_question_content = _pep_wording_question_content.replace("<p>", "").replace("</p>", "");
				}

				// Send web content to JSP
				renderRequest.setAttribute("_pep_wording_question_content", _pep_wording_question_content);

				renderRequest.setAttribute("lrToPimcKycMiddlewareUrl", lrToPimcKycMiddlewareUrl);
				renderRequest.setAttribute("pmcrPaymentUrl", pmcrPaymentUrl);

				// custom plan
				List<PetPlan> plans = _petPlanLocalService.getPetPlans();
				String _mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
				if (_mvcPath == null || _mvcPath.isEmpty() || _mvcPath.equals("/step1_2.jsp")) {
					PetPlan customPlan = null;

					if (plans != null) {
						for (PetPlan plan : plans) {
							if (plan.getCustomPlan() == 1) {
								customPlan = plan;
							}
						}
					}

					renderRequest.setAttribute("CustomPlan", customPlan);
				}
				
				PortletRequestDispatcher dispatcher = null;
				if(mvcPath.equals("/step2.jsp")) {
					dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/step2.jsp");
				} else if(mvcPath.equals("/step3.jsp")) {
					dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/step3.jsp");
				} else if(mvcPath.equals("/step4.jsp")) {
					dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/step4.jsp");
				} else {
					dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/step1.jsp");
				}
				
				dispatcher.include(renderRequest, renderResponse);
			} else {
				PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/includes/404.jsp");
				dispatcher.include(renderRequest, renderResponse);
			}

		} catch (Exception e) {
			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/includes/404.jsp");
			dispatcher.include(renderRequest, renderResponse);
			return;
		}

//		super.render(renderRequest, renderResponse);
	}

	@Reference
	private PetPlanLocalService _petPlanLocalService;

	@Reference
	private MypageUserLocalService _mypageUserLocalService;

	@Reference
	private MypageUserRoleLocalService _mypageUserRoleLocalService;

	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
}