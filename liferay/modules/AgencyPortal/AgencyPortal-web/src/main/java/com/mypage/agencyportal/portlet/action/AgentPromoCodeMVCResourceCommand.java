package com.mypage.agencyportal.portlet.action;

import com.google.gson.Gson;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.MasterPromoCode;
import com.mypage.admin.product.service.MasterPromoCodeLocalService;
import com.mypage.agencyportal.constants.AgentPromoCodePortletKeys;
import com.mypage.agencyportal.dto.CommissionDto;
import com.mypage.agencyportal.dto.PaginationDto;
import com.mypage.agencyportal.dto.PromoCodeDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.helpers.LogHelper;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalService;
import com.mypage.user.service.MypageUserLocalService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + AgentPromoCodePortletKeys.AGENT_PROMO_CODE,
			"mvc.command.name=/data/agentpromocode"
		},
		service = MVCResourceCommand.class
	)
public class AgentPromoCodeMVCResourceCommand extends BaseMVCResourceCommand {
	private static Gson gson = new Gson();
	private static int size = 10;
	private static String PIMCORE_HOST = StringPool.BLANK;
	private static String dashboardApiAgencyCommissionUrl = StringPool.BLANK;
	private static String dashboardApiUpdatePromoCodeUrl = StringPool.BLANK;
	private static String deptoreCode = StringPool.BLANK;
	private static String apiRequestTokenRenew = StringPool.BLANK;
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _log = LogFactoryUtil.getLog(AgentPromoCodeMVCResourceCommand.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		
		ActionHelpers helpers = new ActionHelpers();
		long promoCodeId = 0L;
		
		int page = ParamUtil.getInteger(httpRequest, "page");
		
		if (Validator.isNotNull(ParamUtil.getString(httpRequest, "target"))) {
			String param = EncryptionHelper.decrypt(ParamUtil.getString(httpRequest, "target"));
			String[] paramSplit = param.split("\\|");
			promoCodeId = Long.parseLong(paramSplit[1]);
		}
		
		String _eToken = ParamUtil.getString(httpRequest, "etoken");
		String category = ParamUtil.getString(httpRequest, "category");
		String jsonStringify = ParamUtil.getString(httpRequest, "data");
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonStringify);
		
		/* Validate API Request Token */
		boolean validateApiRequestToken = false;
		String renderToken = ParamUtil.getString(httpRequest, "rtoken");
		String _apiRequestToken = ParamUtil.getString(httpRequest, "aptoken");

		AgentToken verifyAgentToken = _agentTokenLocalService.verifyToken(renderToken, _apiRequestToken);

		if (!Validator.isNull(verifyAgentToken)) {

			AgentToken renewAgentApiRequestToken = _agentTokenLocalService.renewAgentToken(verifyAgentToken.getAgentTokenId());

			if (!Validator.isNull(renewAgentApiRequestToken)) {
				apiRequestTokenRenew = renewAgentApiRequestToken.getApiRequestToken();
			}

			validateApiRequestToken = true;
			deptoreCode = verifyAgentToken.getDeptCode();
		}

		if (!validateApiRequestToken) {
			_response.put("status", false);
			_response.put("message", "Access Forbidden");

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		/* END Validate API Request Token */
		
		if (category.equalsIgnoreCase("view")) {
        	MasterPromoCode item = _masterPromoCodeLocalService.fetchMasterPromoCode(promoCodeId);
        	SimpleDateFormat inputFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("id"));
        	
        	JSONObject data = JSONFactoryUtil.createJSONObject();
			data.put("promoCode", item.getPromoCode());
			data.put("limit", item.getLimit());
			data.put("product", item.getProductCode());
			data.put("promoCodeTerms", item.getPromoCodeTerms());
			data.put("startDate", Validator.isNotNull(item.getStartDate()) ? inputFormat.format(item.getStartDate()) : StringPool.BLANK);
			data.put("endDate", Validator.isNotNull(item.getEndDate()) ? inputFormat.format(item.getEndDate()) : StringPool.BLANK);
			data.put("discount", item.getDiscount());
			data.put("status", item.getActive() == 1 ? "AKTIF" : "NONAKTIF");
        	
        	_response.put("status", true);
			_response.put("message", "");
			_response.put("data", data);
			_response.put("token", apiRequestTokenRenew);
			
			resourceResponse.getWriter().write(_response.toString());
			return;
        }

		long userId = _mypageUserLocalService.getByDeptoreCode(deptoreCode).getMypageUserId();
		String agentCode = _mypageUserLocalService.getByDeptoreCode(deptoreCode).getCode();
		String agentName = _mypageUserLocalService.getByDeptoreCode(deptoreCode).getUserName();
		
		if (page > 0) {
			int totalItems = _masterPromoCodeLocalService.countByUserId(userId);
	        int totalPages = (int) Math.ceil((double) totalItems / size);
	        
	        if (page > totalPages) page = totalPages;
	        
	        int start = (page - 1) * size;
	        int end = page * size;
	        
	        List<MasterPromoCode> items = _masterPromoCodeLocalService.findByFilter(start, end, userId);
	        
	        List<PromoCodeDto> _items = new ArrayList<PromoCodeDto>();
	        
	        for (MasterPromoCode item : items) {
	        	PromoCodeDto _item = new PromoCodeDto();
	        	
	        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        	Date startDate = null, endDate = null;
	            if (Validator.isNotNull(item.getStartDate())) startDate = dateFormat.parse(item.getStartDate().toString());
	            if (Validator.isNotNull(item.getEndDate())) endDate = dateFormat.parse(item.getEndDate().toString());
	            
	            dateFormat = new SimpleDateFormat("d MMM yyyy");
	            String formattedStartDate = StringPool.BLANK, formattedEndDate = StringPool.BLANK;
	            if (Validator.isNotNull(startDate)) formattedStartDate = dateFormat.format(startDate);
	            if (Validator.isNotNull(endDate)) formattedEndDate = dateFormat.format(endDate);
	            
				_item.setTarget(EncryptionHelper.encryptRandom(String.valueOf(item.getPromoCodeId())));
				_item.setPromoCode(item.getPromoCode());
				_item.setProductName(item.getProductName());
				_item.setDiscount(item.getDiscount());
				_item.setLimit(item.getLimit());
				_item.setFormattedStartDate(formattedStartDate);
				_item.setFormattedEndDate(formattedEndDate);
				_item.setActive(item.getActive());
	            
	            _items.add(_item);
	        }
	        
	        PaginationDto pagination = new PaginationDto();
	        pagination.setItemPerPage(size);
	        pagination.setPage(page);
	        pagination.setTotalItem(totalItems);
	        pagination.setTotalPage(totalPages);
	        
	        _data.put("items", _items);
	        _data.put("paging", gson.fromJson(gson.toJson(pagination), Object.class));
	        _response.put("status", true);
	        _response.put("message", "");
	        _response.put("data", _data);
	        _response.put("token", apiRequestTokenRenew);
	        
	        resourceResponse.getWriter().write(_response.toString());
	        return;
		}

		String promoCode = helpers.sanitizeHtml(jsonObject.getString("promoCode"));
		
		boolean validatePromoCode = inputValidate(promoCode, "textnum");
		
		if (validatePromoCode == false) {
			if (helpers.isLog()) _log.info("Promocode contains invalid characters");
			_response.put("status", false);
			_response.put("message", "Simpan data gagal, pastikan data telah sesuai [PC01_01 Gagal Validasi Data Kode Promo]");
			_response.put("token", apiRequestTokenRenew);

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		int searchPromoCode = _masterPromoCodeLocalService.countByPromoCode(promoCodeId, promoCode);
		
		if (searchPromoCode > 0) {
			if (helpers.isLog()) _log.info("Promocode must be unique");
			_response.put("status", false);
			_response.put("message", "Simpan data gagal, pastikan data telah sesuai [PC02_01 Kode Promo Sudah Ada]");
			_response.put("token", apiRequestTokenRenew);

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		String maxCoupon = helpers.sanitizeHtml(jsonObject.getString("maxCoupon"));
		
		boolean validateMaxCoupon = inputValidate(maxCoupon, "num");
		
		if (validateMaxCoupon == false) {
			if (helpers.isLog()) _log.info("Coupon contains invalid characters");
			_response.put("status", false);
			_response.put("message", "Simpan data gagal, pastikan data telah sesuai [PC01_02 Gagal Validasi Data Kupon]");
			_response.put("token", apiRequestTokenRenew);

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		String product = jsonObject.getString("product");
//		String productName = jsonObject.getString("productName");
		String promoCodeTerm = jsonObject.getString("promoCodeTerm");
		String startPromo = jsonObject.getString("startPromo");
		String endPromo = jsonObject.getString("endPromo");
		String discount = jsonObject.getString("discount");
		int isActive = jsonObject.getBoolean("isActive") == true ? 1 : 0;
		
		if ((product.contains("IT") || product.contains("DT")) && Validator.isNull(promoCodeTerm)) {
			if (helpers.isLog()) _log.info("SmartTravel require PromocodeTerm");
			_response.put("status", false);
			_response.put("message", "Simpan data gagal, pastikan data telah sesuai [PC01_03 Gagal Validasi Data Terminologi Kode Promo]");
			_response.put("token", apiRequestTokenRenew);

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("id"));
		startPromo = helpers.ConvertDateFormat(inputFormat.parse(startPromo).toString(), "yyyy-MM-dd");
		endPromo = helpers.ConvertDateFormat(inputFormat.parse(endPromo).toString(), "yyyy-MM-dd");
		
		PIMCORE_HOST = helpers.getConfig("com.mypage.agent.config.pimcoreAddress");
		dashboardApiAgencyCommissionUrl = helpers.getConfig("dashboard.api.agency.commission");
		
		Gson gson = new Gson();
		String commissionPayload = StringPool.BLANK;
		JSONObject commissionResponse = JSONFactoryUtil.createJSONObject();
		
		HashMap<String, Object> _commissionPayload = new HashMap<String, Object>();
		_commissionPayload.put("Code", deptoreCode);
		_commissionPayload.put("ProductCode", product);
		commissionPayload = gson.toJson(_commissionPayload);
		
		commissionResponse = ActionHelpers.hitAPI(PIMCORE_HOST + dashboardApiAgencyCommissionUrl, commissionPayload, _eToken);
		
		CommissionDto commissionResponseDto = new Gson().fromJson(commissionResponse.get("response").toString(), CommissionDto.class);
		
		if (commissionResponseDto.getStatus() == 0) {
			if (helpers.isLog()) _log.info(commissionResponseDto.getMessage());
			_response.put("status", false);
			_response.put("message", "Simpan data gagal, pastikan data telah sesuai [PC03_01 " + commissionResponseDto.getMessage() + "]");
			_response.put("token", apiRequestTokenRenew);

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		double commission = 0L;
		
		if (commissionResponseDto.getStatus() == 1) {
			if (Double.parseDouble(discount) > commissionResponseDto.getData().getCommission()) {
				if (helpers.isLog()) _log.info("Discount must be lower than commission. Your commission is " + commissionResponseDto.getData().getCommission());
				_response.put("status", false);
				_response.put("message", "Simpan data gagal, pastikan data telah sesuai [PC01_04 Gagal Validasi Data Diskon]");
				_response.put("token", apiRequestTokenRenew);

				resourceResponse.getWriter().write(_response.toString());
				return;
			}
			
			commission = commissionResponseDto.getData().getCommission() - Double.parseDouble(discount);
		}
		
		if (promoCodeId > 0) {
			long mypageUserId = _masterPromoCodeLocalService.fetchMasterPromoCode(promoCodeId).getMypageUserId();
			
			if (userId != mypageUserId) {
				if (helpers.isLog()) _log.info("You're not authorized");
				_response.put("status", false);
				_response.put("message", "Simpan data gagal, Anda tidak memiliki izin untuk mengubah data");
				_response.put("token", apiRequestTokenRenew);
	
				resourceResponse.getWriter().write(_response.toString());
				return;
			}
		}

		dashboardApiUpdatePromoCodeUrl = helpers.getConfig("dashboard.api.agency.update.promocode");
		
		JSONObject promoCodeResponse = JSONFactoryUtil.createJSONObject();
		JSONObject promoCodePayload = JSONFactoryUtil.createJSONObject();
		promoCodePayload.put("Code", deptoreCode);
		if (promoCodeId > 0) promoCodePayload.put("PromoCodeId", promoCodeId);
		promoCodePayload.put("ProductCode", product);
		promoCodePayload.put("Promocode", promoCode);
		promoCodePayload.put("Discount", Double.parseDouble(discount));
		
		SimpleDateFormat payloadFormat = new SimpleDateFormat("yyyy-MM-dd");
		String startPromoPayload = helpers.ConvertDateFormat(payloadFormat.parse(startPromo).toString(), "dd/MM/yyyy");
		String endPromoPayload = helpers.ConvertDateFormat(payloadFormat.parse(endPromo).toString(), "dd/MM/yyyy");
		
		promoCodePayload.put("StartDate", startPromoPayload);
		promoCodePayload.put("EndDate", endPromoPayload);
		promoCodePayload.put("Limit", maxCoupon);
		promoCodePayload.put("PromocodeTerms", promoCodeTerm);
		promoCodePayload.put("Status", isActive);
		
		if (helpers.isLog()) _log.info(promoCodePayload.toString());
		
		promoCodeResponse = ActionHelpers.hitAPI(PIMCORE_HOST + dashboardApiUpdatePromoCodeUrl, promoCodePayload.toString(), _eToken);
		
		JSONObject promoCodeResponseDto = JSONFactoryUtil.createJSONObject(promoCodeResponse.get("response").toString());
		
		if (promoCodeResponseDto.getInt("Status") == 0) {
			if (helpers.isLog()) _log.info(promoCodeResponseDto.getString("Message"));
			_response.put("status", false);
			_response.put("message", "Simpan data gagal, pastikan data telah sesuai [PC03_02 " + promoCodeResponseDto.getString("Message") + "]");
			_response.put("token", apiRequestTokenRenew);
			
			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		JSONObject data = JSONFactoryUtil.createJSONObject(promoCodeResponseDto.getJSONObject("Data").toString());
		
		if (promoCodeId == 0) promoCodeId = data.getLong("PromoCodeId");
		
		_masterPromoCodeLocalService.updatePromoCode(promoCodeId, product, data.getString("ProductName"), promoCode, Double.parseDouble(discount), startPromo, endPromo, maxCoupon, promoCodeTerm, data.getString("Remarks"), userId, agentCode, agentName, deptoreCode, commission, isActive);
//		} else {
//			_masterPromoCodeLocalService.addPromoCode(product, productName, promoCode, Double.parseDouble(discount), startPromo, endPromo, maxCoupon, promoCodeTerm, userId, agentCode, agentName, deptoreCode, commission, isActive);
//		}
		
        _response.put("status", true);
        _response.put("message", AgentPromoCodePortletKeys.MSG_SUCCESS_CREATE_PROMOCODE);
        _response.put("token", apiRequestTokenRenew);
        
        resourceResponse.getWriter().write(_response.toString());
	}
	
	private boolean inputValidate(String value, String type) {
	    Pattern pattern;
        switch (type.toLowerCase()) {
            case "num":
                pattern = Pattern.compile("^[0-9]*$");
                return pattern.matcher(value).matches();
            case "textnum":
                pattern = Pattern.compile("^[A-Za-z0-9]+$");
                return pattern.matcher(value).matches();
            default:
                return false;
        }
	}
	
	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
	
	@Reference
	private MasterPromoCodeLocalService _masterPromoCodeLocalService;
	
	@Reference
	private MypageUserLocalService _mypageUserLocalService;
}
