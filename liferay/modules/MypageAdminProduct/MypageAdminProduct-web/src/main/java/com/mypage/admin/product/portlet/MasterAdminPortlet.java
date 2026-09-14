package com.mypage.admin.product.portlet;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.liferay.blogs.exception.EntryImageNameException;
import com.liferay.blogs.exception.EntryImageSizeException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.criteria.FileEntryItemSelectorReturnType;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.upload.UniqueFileNameProvider;
import com.mypage.admin.product.constants.MasterAdminPortletKeys;
import com.mypage.admin.product.model.BlacklistCustomer;
import com.mypage.admin.product.model.CompanyType;
import com.mypage.admin.product.model.Industry;
import com.mypage.admin.product.model.IndustryCategory;
import com.mypage.admin.product.model.JobPosition;
import com.mypage.admin.product.model.MasterBank;
import com.mypage.admin.product.model.MasterBranch;
import com.mypage.admin.product.model.MasterCity;
import com.mypage.admin.product.model.MasterCountry;
import com.mypage.admin.product.model.MasterCurrency;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.model.MasterOccupation;
import com.mypage.admin.product.model.MasterOccupationCategory;
import com.mypage.admin.product.model.MasterPromoCode;
import com.mypage.admin.product.model.MasterProvince;
import com.mypage.admin.product.model.PaymentChannel;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.model.Promocodes;
import com.mypage.admin.product.model.ReferenceNumber;
import com.mypage.admin.product.service.BlacklistCustomerLocalService;
import com.mypage.admin.product.service.CompanyTypeLocalService;
import com.mypage.admin.product.service.IndustryCategoryLocalService;
import com.mypage.admin.product.service.IndustryLocalService;
import com.mypage.admin.product.service.JobPositionLocalService;
import com.mypage.admin.product.service.MasterBankLocalService;
import com.mypage.admin.product.service.MasterBranchLocalService;
import com.mypage.admin.product.service.MasterCityLocalService;
import com.mypage.admin.product.service.MasterCountryLocalService;
import com.mypage.admin.product.service.MasterCurrencyLocalService;
import com.mypage.admin.product.service.MasterGlobalVariableLocalService;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
import com.mypage.admin.product.service.MasterOccupationCategoryLocalService;
import com.mypage.admin.product.service.MasterOccupationLocalService;
import com.mypage.admin.product.service.MasterPromoCodeLocalService;
import com.mypage.admin.product.service.MasterPromoCodeLocalServiceUtil;
import com.mypage.admin.product.service.MasterProvinceLocalService;
import com.mypage.admin.product.service.PaymentChannelLocalService;
import com.mypage.admin.product.service.PaymentChannelTenorLocalService;
import com.mypage.admin.product.service.PaymentChannelTenorLocalServiceUtil;
import com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil;
import com.mypage.admin.product.service.PromocodesLocalService;
import com.mypage.admin.product.service.ReferenceNumberLocalService;
import com.mypage.user.service.MypageUserLocalServiceUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.jumpmind.symmetric.csv.CsvReader;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.hidden", 
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-css=/css/master_admin.css", 
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.private-request-attributes=false", 
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50", 
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=Master Data", 
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.template-path=/", 
		"javax.portlet.init-param.view-template=/master/country/list.jsp",
		"javax.portlet.name=" + MasterAdminPortletKeys.MASTER_DATA, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",

}, service = Portlet.class)
public class MasterAdminPortlet extends MVCPortlet {

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {

			// START image selector
			String imageSelectedItemEventName = renderResponse.getNamespace() + "imageSelectedItem";

			RequestBackedPortletURLFactory requestBackedPortletURLFactory = RequestBackedPortletURLFactoryUtil
					.create(renderRequest);

			ImageItemSelectorCriterion imageItemSelectorCriterion = new ImageItemSelectorCriterion();

			imageItemSelectorCriterion.setDesiredItemSelectorReturnTypes(new FileEntryItemSelectorReturnType());

			PortletURL itemSelectorURL = _itemSelector.getItemSelectorURL(requestBackedPortletURLFactory,
					imageSelectedItemEventName, imageItemSelectorCriterion);

			renderRequest.setAttribute("imageSelectedItemEventName", imageSelectedItemEventName);
			renderRequest.setAttribute("itemSelectorURL", itemSelectorURL.toString());
			// END image selector
		} catch (Exception e) {
			throw new PortletException(e);
		}

		super.render(renderRequest, renderResponse);
	}

	/**
	 * Add or Update Country
	 */
	public void addCountry(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		int countryId = ParamUtil.get(actionRequest, "countryId", 0);
		String countryName = ParamUtil.getString(actionRequest, "countryName", "").toUpperCase();
		int isPlatinum = ParamUtil.getBoolean(actionRequest, "isPlatinum", false) ? 1 : 0;
		int isGold = ParamUtil.getBoolean(actionRequest, "isGold", false) ? 1 : 0;
		int isSpecialAsia = ParamUtil.getBoolean(actionRequest, "isSpecialAsia", false) ? 1 : 0;
		int isSchengen = ParamUtil.getBoolean(actionRequest, "isSchengen", false) ? 1 : 0;
		int isSanctionCountry = ParamUtil.getBoolean(actionRequest, "isSanctionCountry", false) ? 1 : 0;
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (countryId > 0) {
			try {
				_masterCountryLocalService.updateMasterCountry(countryId, countryName, isPlatinum, isGold,
						isSpecialAsia, isSchengen, isSanctionCountry, active);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/country/list.jsp");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/country/edit.jsp");
			}
		} else {
			try {
				_masterCountryLocalService.addMasterCountry(countryName, isPlatinum, isGold, isSpecialAsia, isSchengen,
						isSanctionCountry, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/master/country/list.jsp");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/country/edit.jsp");
			}
		}
	}

	/**
	 * Add or Update Currency
	 */
	public void addCurrency(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		long currencyId = ParamUtil.getLong(actionRequest, "currencyId", 0);
		String currencyName = ParamUtil.getString(actionRequest, "currencyName", "");
		double amount = ParamUtil.getDouble(actionRequest, "amount", 0);
		int isDefault = ParamUtil.getBoolean(actionRequest, "isDefault", false) ? 1 : 0;
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (currencyId > 0) {
			try {

				_masterCurrencyLocalService.updateMasterCurrency(currencyId, currencyName, amount, isDefault, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/currency/list.jsp");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/currency/edit.jsp");
			}
		} else {
			try {

				_masterCurrencyLocalService.addMasterCurrency(currencyName, amount, isDefault, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/master/currency/list.jsp");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/currency/edit.jsp");
			}
		}
	}

	/**
	 * Add or Update Blacklist Customer
	 */
	public void addBlacklistCustomer(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException {

		long blacklistCustomerId = ParamUtil.getLong(actionRequest, "blacklistCustomerId", 0);
		String fullName = ParamUtil.getString(actionRequest, "fullName", "");
		fullName = !fullName.isEmpty() ? fullName.toUpperCase() : fullName;

		String firstName = ParamUtil.getString(actionRequest, "firstName", "");
		firstName = !firstName.isEmpty() ? firstName.toUpperCase() : firstName;

		String middleName = ParamUtil.getString(actionRequest, "middleName", "");
		middleName = !middleName.isEmpty() ? middleName.toUpperCase() : middleName;

		String lastName = ParamUtil.getString(actionRequest, "lastName", "");
		lastName = !lastName.isEmpty() ? lastName.toUpperCase() : lastName;

		String ktp = ParamUtil.getString(actionRequest, "ktp", "");
		String kitas = ParamUtil.getString(actionRequest, "kitas", "");

		String email = ParamUtil.getString(actionRequest, "email", "");
		email = !email.isEmpty() ? email.toLowerCase() : email;

		String _dateOfBirth = ParamUtil.getString(actionRequest, "dateOfBirth", "");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (blacklistCustomerId > 0) {
			try {

				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				Date dateOfBirth = sdf.parse(_dateOfBirth);

				_blacklistCustomerLocalService.updateBlacklistCustomer(blacklistCustomerId, fullName, firstName,
						middleName, lastName, ktp, kitas, email, dateOfBirth, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/blacklist_customer/list.jsp");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/blacklist_customer/edit.jsp");
			}
		} else {
			try {

				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				Date dateOfBirth = sdf.parse(_dateOfBirth);

				_blacklistCustomerLocalService.addBlacklistCustomer(fullName, firstName, middleName, lastName, ktp,
						kitas, email, dateOfBirth, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/master/blacklist_customer/list.jsp");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/blacklist_customer/edit.jsp");
			}
		}
	}

	/**
	 * Add or Update Promocode
	 * 
	 * @throws ParseException
	 */
	public void addPromocode(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException, ParseException {

		long promoCodeId = ParamUtil.getLong(actionRequest, "promocodeId", 0);
		int isDefault = ParamUtil.getInteger(actionRequest, "isDefault");
		String product = ParamUtil.getString(actionRequest, "product", "");
//		String productName = ProductConfigurationLocalServiceUtil.getConfigByCode(product).getProductName();
		String promoType = ParamUtil.getString(actionRequest, "promotype", "");
		String promoCode = ParamUtil.getString(actionRequest, "promocode", "");
		double discount = ParamUtil.getDouble(actionRequest, "discount", 0.0);
		String _startDate = ParamUtil.getString(actionRequest, "startdate", "");
		String _endDate = ParamUtil.getString(actionRequest, "enddate", "");
		String[] _activeDay = ParamUtil.getStringValues(actionRequest, "activeday");
		String activeDay = "";

		if (_activeDay.length > 0) {
			String jsonActiveDay = JSONFactoryUtil.createJSONArray(_activeDay).toJSONString();
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(jsonActiveDay);

			StringBuilder result = new StringBuilder();
			for (int i = 0; i < jsonArray.length(); i++) {
				result.append(jsonArray.getString(i));
				if (i < jsonArray.length() - 1) {
					result.append(",");
				}
			}

			activeDay = result.toString();
		}

		String limit = ParamUtil.getString(actionRequest, "limit", "");
		String network = ParamUtil.getString(actionRequest, "network", "");
		String channel = ParamUtil.getString(actionRequest, "channel", "");
		int isB2B = ParamUtil.getInteger(actionRequest, "isB2B");
		int isB2B2C = ParamUtil.getInteger(actionRequest, "isB2B2C");
		int isB2C = ParamUtil.getInteger(actionRequest, "isB2C");
		String payment = ParamUtil.getString(actionRequest, "payment", "");
		String birthdayMonth = ParamUtil.getString(actionRequest, "birthdaymonth");
		String remarks = ParamUtil.getString(actionRequest, "remarks", "");
		long mypageUserId = ParamUtil.getLong(actionRequest, "mypageUserId", 0);
		String agentName = mypageUserId > 0 ? MypageUserLocalServiceUtil.getMypageUser(mypageUserId).getUserName() : "";
		String deptoreCode = mypageUserId > 0 ? MypageUserLocalServiceUtil.getMypageUser(mypageUserId).getDeptoreCode()
				: "";
		String commission = ParamUtil.getString(actionRequest, "commission");
		String plan = ParamUtil.getString(actionRequest, "plan", "");
		String promoCodeTerms = ParamUtil.getString(actionRequest, "promocodeterms", "");
		String travellerType = ParamUtil.getString(actionRequest, "travellertype", "");
		int active = ParamUtil.getInteger(actionRequest, "active");

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate = dateFormat.parse(_startDate);
		Date endDate = dateFormat.parse(_endDate);

		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedStartDate = dateFormat.format(startDate);
		String formattedEndDate = dateFormat.format(endDate);

		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String payloadStartDate = dateFormat.format(startDate);
		String payloadEndDate = dateFormat.format(endDate);

//        int searchPromoCode = MasterPromoCodeLocalServiceUtil.countByPromoCode(promoCodeId, promoCode);
//		
//		if (searchPromoCode > 0) {
//			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
//
//			SessionErrors.add(actionRequest, "Failed");
//			actionResponse.setRenderParameter("mvcPath", "/master/promocode/list.jsp");
//			return;
//		}

		if ((product.contains("IT") || product.contains("DT")) && Validator.isNull(promoCodeTerms)) {
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);

			SessionErrors.add(actionRequest, "Failed");
			actionResponse.setRenderParameter("mvcPath", "/master/promocode/list.jsp");
			return;
		}

//		if (promoType.equalsIgnoreCase("birthday") && birthdayMonth == 0) {
//			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
//
//			SessionErrors.add(actionRequest, "Failed");
//			actionResponse.setRenderParameter("mvcPath", "/master/promocode/list.jsp");
//			return;
//		}

		String PIMCORE_HOST = getConfig("com.mypage.agent.config.pimcoreAddress");
		String dashboardApiUpdatePromoCodeUrl = getConfig("dashboard.api.agency.update.promocode");
		List<MasterGlobalVariable> _listToken = MasterGlobalVariableLocalServiceUtil
				.getActiveGlobalVariableByGroup("token");
		String _eToken = StringPool.BLANK;

		for (MasterGlobalVariable item : _listToken) {
			if (item.getName().equalsIgnoreCase("x_api_key"))
				_eToken = item.getValue();
		}

		try {
			JSONObject promoCodeResponse = JSONFactoryUtil.createJSONObject();
			JSONObject promoCodePayload = JSONFactoryUtil.createJSONObject();
			promoCodePayload.put("Code", deptoreCode);
			if (promoCodeId > 0)
				promoCodePayload.put("PromoCodeId", promoCodeId);
			promoCodePayload.put("ProductCode", product);
			promoCodePayload.put("PromoType", promoType);
			promoCodePayload.put("Promocode", promoCode);
			promoCodePayload.put("Discount", discount);
			promoCodePayload.put("StartDate", payloadStartDate);
			promoCodePayload.put("EndDate", payloadEndDate);
			promoCodePayload.put("ActiveDay", activeDay);
			promoCodePayload.put("Limit", limit);
			promoCodePayload.put("Network", network);
			promoCodePayload.put("Channel", channel);
			promoCodePayload.put("IsB2B", isB2B);
			promoCodePayload.put("IsB2B2C", isB2B2C);
			promoCodePayload.put("IsB2C", isB2C);
			promoCodePayload.put("Payment", payment);
//			promoCodePayload.put("BirhtdayMonth", birthdayMonth);
			if (promoCodeId > 0)
				promoCodePayload.put("Remarks", remarks);
			promoCodePayload.put("Commission", commission);
			promoCodePayload.put("Plan", plan);
			promoCodePayload.put("PromocodeTerms", promoCodeTerms);
			promoCodePayload.put("TravellerType", travellerType);
			promoCodePayload.put("Status", active);

			promoCodeResponse = hitAPI(PIMCORE_HOST + dashboardApiUpdatePromoCodeUrl, promoCodePayload.toString(),
					_eToken);

			JSONObject promoCodeResponseDto = JSONFactoryUtil
					.createJSONObject(promoCodeResponse.get("response").toString());

			if (promoCodeResponseDto.getInt("Status") == 0) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, "Failed");
				actionResponse.setRenderParameter("mvcPath", "/master/promocode/list.jsp");
				return;
			}

			JSONObject data = JSONFactoryUtil.createJSONObject(promoCodeResponseDto.getJSONObject("Data").toString());

			if (promoCodeId == 0)
				promoCodeId = data.getLong("PromoCodeId");

			_masterPromoCodeLocalService.savePromoCode(isDefault, promoCodeId, product, data.getString("ProductName"),
					promoType, promoCode, discount, formattedStartDate, formattedEndDate, activeDay, limit, network,
					channel, isB2C, isB2B2C, isB2B, payment, birthdayMonth, data.getString("Remarks"), mypageUserId,
					agentName, deptoreCode, commission, plan, promoCodeTerms, travellerType, active);

			SessionMessages.add(actionRequest, "dataAdded");
			actionResponse.setRenderParameter("mvcPath", "/master/promocode/list.jsp");
		} catch (Exception e) {
			log.info(e);
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);

			SessionErrors.add(actionRequest, e.getClass().getName());
			actionResponse.setRenderParameter("mvcPath", "/master/promocode/edit.jsp");
		}
	}

	/*
	 * Add or Update Province
	 */
	public void addProvince(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		int masterProvinceId = ParamUtil.get(actionRequest, "masterProvinceId", 0);
		String name = ParamUtil.getString(actionRequest, "name", "").toUpperCase();
		int countryId = ParamUtil.getInteger(actionRequest, "countryId");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (masterProvinceId > 0) {
			try {
				ParamUtil.print(actionRequest);
				_masterProvinceLocalService.updateMasterProvince(masterProvinceId, name, countryId, active);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/province/list.jsp");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/province/edit.jsp");
			}
		} else {
			try {
				_masterProvinceLocalService.addMasterProvince(name, countryId, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/master/province/list.jsp");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/province/edit.jsp");
			}
		}
	}

	/**
	 * Add or Update City
	 */
	public void addCity(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		int masterCityId = ParamUtil.get(actionRequest, "masterCityId", 0);
		String name = ParamUtil.getString(actionRequest, "name", "").toUpperCase();
		long provinceId = ParamUtil.getLong(actionRequest, "provinceId");
		String status = ParamUtil.getString(actionRequest, "status", "");
		int parEarthquakeZone = ParamUtil.getInteger(actionRequest, "parEarthquakeZone");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (masterCityId > 0) {
			try {
				ParamUtil.print(actionRequest);
				_masterCityLocalService.updateMasterCity(masterCityId, name, provinceId, status, parEarthquakeZone,
						active);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/city/list.jsp");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/city/edit.jsp");
			}
		} else {
			try {
				_masterCityLocalService.addMasterCity(name, provinceId, status, parEarthquakeZone, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/master/city/list.jsp");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/city/edit.jsp");
			}
		}
	}

	/**
	 * Add or update industry category
	 */
	public void addIndustryCategory(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		String _listViewPath = "/master/industry_category/list.jsp";
		String _editViewPath = "/master/industry_category/edit.jsp";

		// Process param
		int industryCategoryId = ParamUtil.get(actionRequest, "industryCategoryId", 0);
		String industryCategoryName = ParamUtil.getString(actionRequest, "industryCategoryName", "").toUpperCase();
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (industryCategoryId > 0) {
			try {
				_industryCategoryLocalService.updateIndustryCategory(industryCategoryId, industryCategoryName, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		} else {
			try {
				_industryCategoryLocalService.addIndustryCategory(industryCategoryName, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		}
	}

	/**
	 * Add or update industry
	 */
	public void addIndustry(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		String _listViewPath = "/master/industry/list.jsp";
		String _editViewPath = "/master/industry/edit.jsp";

		// Process param
		long industryId = ParamUtil.getLong(actionRequest, "industryId", 0);
		String name = ParamUtil.getString(actionRequest, "industryName", "").toUpperCase();
		long industryCategoryId = ParamUtil.getLong(actionRequest, "industryCategoryId", 0);
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (industryId > 0) {
			try {
				_industryLocalService.updateIndustry(industryId, industryCategoryId, name, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		} else {
			try {
				_industryLocalService.addIndustry(name, industryCategoryId, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		}
	}

	/**
	 * Add or update job position
	 */
	public void addJobPosition(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		String _listViewPath = "/master/job_position/list.jsp";
		String _editViewPath = "/master/job_position/edit.jsp";

		// Process param
		long jobPositionId = ParamUtil.getLong(actionRequest, "jobPositionId", 0);
		String name = ParamUtil.getString(actionRequest, "jobPositionName", "").toUpperCase();
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (jobPositionId > 0) {
			try {
				_jobPositionLocalService.updateJobPosition(jobPositionId, name, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		} else {
			try {
				_jobPositionLocalService.addJobPosition(name, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		}
	}

	/*
	 * Add or Update Bank
	 */
	public void addBank(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		int masterBankId = ParamUtil.get(actionRequest, "masterBankId", 0);
		String bankCode = ParamUtil.getString(actionRequest, "bankCode", "");
		String bankDesc = ParamUtil.getString(actionRequest, "bankDesc", "");
		String name = ParamUtil.getString(actionRequest, "name", "");
		String detail = ParamUtil.getString(actionRequest, "detail", "");
		int imageId = ParamUtil.getInteger(actionRequest, "imageId");
		int order = ParamUtil.getInteger(actionRequest, "order");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		String imageURL = "";
		int imageFileEntryId = 0;

		if (imageId != 0) {
			FileEntry entry = DLAppLocalServiceUtil.getFileEntry(imageId);
			if (entry != null) {
				imageFileEntryId = imageId;
				imageURL = "/documents/" + entry.getFileEntryId() + "/" + entry.getFolderId() + "/"
						+ entry.getFileName();
			}
		}

		if (masterBankId > 0) {
			try {
				ParamUtil.print(actionRequest);
				_masterBankLocalService.updateMasterBank(masterBankId, bankCode, bankDesc, name, detail, imageURL,
						imageFileEntryId, order, active, false);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/bank/list.jsp");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/bank/edit.jsp");
			}
		} else {
			try {
				_masterBankLocalService.addMasterBank(bankCode, bankDesc, name, detail, imageURL, imageFileEntryId,
						order, active);
				System.out.print("qwe");
				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/master/bank/list.jsp");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/bank/edit.jsp");
			}
		}
	}

	/**
	 * Add or Update Payment Channel
	 */
	public void addPaymentChannel(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		int paymentChannelId = ParamUtil.get(actionRequest, "paymentChannelId", 0);
		String code = ParamUtil.getString(actionRequest, "code", "");
		String name = ParamUtil.getString(actionRequest, "name", "");
		double minPayment = ParamUtil.getDouble(actionRequest, "minPayment", 0);
		double maxPayment = ParamUtil.getDouble(actionRequest, "maxPayment", 0);
		String description = ParamUtil.getString(actionRequest, "description", "");
		long masterBankId = ParamUtil.getLong(actionRequest, "masterBankId", 0);
		String mdrAxa = ParamUtil.getString(actionRequest, "mdrAxa", "");
		String mdrUser = ParamUtil.getString(actionRequest, "mdrUser", "");
		String pgFeePct = ParamUtil.getString(actionRequest, "pgFeePct", "");
		String pgFeeAmt = ParamUtil.getString(actionRequest, "pgFeeAmt", "");
		String imageURL = "";
		int imageFileEntryId = 0;
		int imageId = ParamUtil.getInteger(actionRequest, "imageId");
		int utmOnly = ParamUtil.get(actionRequest, "utmOnly", 0);
		String mallId = ParamUtil.getString(actionRequest, "mallId", "");
		String sharedKey = ParamUtil.getString(actionRequest, "sharedKey", "");
		int active = ParamUtil.get(actionRequest, "active", 0);
		String[] promoids = ParamUtil.getParameterValues(actionRequest, "promoid[]");
		String[] tenor = ParamUtil.getParameterValues(actionRequest, "tenor[]");
		String[] tenorid = ParamUtil.getParameterValues(actionRequest, "tenorid[]");
		String[] acquirer = ParamUtil.getParameterValues(actionRequest, "acquirer[]");

		if (imageId != 0) {
			FileEntry entry = DLAppLocalServiceUtil.getFileEntry(imageId);
			if (entry != null) {
				imageFileEntryId = imageId;
				imageURL = "/documents/" + entry.getFileEntryId() + "/" + entry.getFolderId() + "/"
						+ entry.getFileName();
			}
		}

		if (paymentChannelId > 0) {
			try {
				PaymentChannel paymentChannel = _paymentChannelLocalService.updatePaymentChannel(paymentChannelId, code,
						name, minPayment, maxPayment, description, masterBankId, mdrAxa, mdrUser, pgFeePct, pgFeeAmt,
						imageFileEntryId, imageURL, utmOnly, mallId, sharedKey, active, false);

				PaymentChannelTenorLocalServiceUtil.removeByPaymentChannelId(paymentChannel.getPaymentChannelId());
				if (promoids.length > 0) {
					for (int i = 0; i < promoids.length; i++) {
						if (promoids[i].isEmpty() && tenor[i].isEmpty() && tenorid[i].isEmpty()
								&& acquirer[i].isEmpty()) {
							continue;
						}
						System.out.print(tenor[i]);
						_paymentChannelTenorLocalService.addPaymentChannelTenor(paymentChannel.getPaymentChannelId(),
								promoids[i], tenor[i], tenorid[i], acquirer[i], 1);
					}
				}

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/paymentchannel/list.jsp");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/paymentchannel/edit.jsp");
			}
		} else {
			try {
				PaymentChannel paymentChannel = _paymentChannelLocalService.addPaymentChannel(code, name, minPayment,
						maxPayment, description, masterBankId, mdrAxa, mdrUser, pgFeePct, pgFeeAmt, imageFileEntryId,
						imageURL, utmOnly, mallId, sharedKey, active);

				PaymentChannelTenorLocalServiceUtil.removeByPaymentChannelId(paymentChannel.getPaymentChannelId());
				if (promoids.length > 0) {
					for (int i = 0; i < promoids.length; i++) {
						if (promoids[i].isEmpty() && tenor[i].isEmpty() && tenorid[i].isEmpty()
								&& acquirer[i].isEmpty()) {
							continue;
						}
						_paymentChannelTenorLocalService.addPaymentChannelTenor(paymentChannel.getPaymentChannelId(),
								promoids[i], tenor[i], tenorid[i], acquirer[i], 1);
					}
				}

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/master/paymentchannel/list.jsp");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/paymentchannel/edit.jsp");
			}
		}
	}

	/**
	 * Add or Update Payment Channel
	 */
	public void addReferenceNumber(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		long referenceNumberId = ParamUtil.get(actionRequest, "referenceNumberId", 0);
		String userRole = ParamUtil.getString(actionRequest, "userRole", "");
		String channel = ParamUtil.getString(actionRequest, "channel", "");
		String type = ParamUtil.getString(actionRequest, "type", "");
		String productCode = ParamUtil.getString(actionRequest, "productCode", "");
		String businessType = ParamUtil.getString(actionRequest, "businessType", "");
		String currency = ParamUtil.getString(actionRequest, "currency", "");
		String prefix = ParamUtil.getString(actionRequest, "prefix", "");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (referenceNumberId > 0) {
			try {
				ReferenceNumber referenceNumber = _referenceNumberLocalService.updateReferenceNumber(referenceNumberId,
						userRole, channel, type, productCode, businessType, currency, prefix, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/reference_number/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/reference_number/edit.jsp");
			}
		} else {
			try {
				ReferenceNumber referenceNumber = _referenceNumberLocalService.addReferenceNumber(userRole, channel,
						type, productCode, businessType, currency, prefix, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/master/reference_number/list.jsp");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/reference_number/edit.jsp");
			}
		}
	}

	/**
	 * Add or Update Occupation Category
	 */
	public void addOccupationCategory(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException {
		long masterOccupationCategoryId = ParamUtil.get(actionRequest, "masterOccupationCategoryId", 0);
		String name = ParamUtil.getString(actionRequest, "name", "");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (masterOccupationCategoryId > 0) {
			try {
				MasterOccupationCategory occupationCategory = _occupationcategoryLocalService
						.updateMasterOccupationCategory(masterOccupationCategoryId, name, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/occupation_category/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/occupation_category/edit.jsp");
			}
		} else {
			try {
				MasterOccupationCategory occupationCategory = _occupationcategoryLocalService
						.addMasterOccupationCategory(name, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/master/occupation_category/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/occupation_category/edit.jsp");
			}
		}
	}

	/**
	 * Add or Update Occupation Category
	 */
	public void addOccupation(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		long masterOccupationId = ParamUtil.get(actionRequest, "masterOccupationId", 0);
		long masterOccupationCategoryId = ParamUtil.get(actionRequest, "masterOccupationCategoryId", 0);
		String name = ParamUtil.getString(actionRequest, "name", "");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (masterOccupationId > 0) {
			try {
				MasterOccupation occupation = _occupationLocalService.updateMasterOccupation(masterOccupationId, name,
						masterOccupationCategoryId, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/occupation/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/occupation/edit.jsp");
			}
		} else {
			try {
				MasterOccupation occupation = _occupationLocalService.addMasterOccupation(name,
						masterOccupationCategoryId, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/master/occupation/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/occupation/edit.jsp");
			}
		}
	}

	/**
	 * Add or Update Company Type
	 */
	public void addCompanyType(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		long companyTypeId = ParamUtil.getLong(actionRequest, "companyTypeId", 0L);
		String name = ParamUtil.getString(actionRequest, "name", "");
		String label = ParamUtil.getString(actionRequest, "label", "");
		int sort = ParamUtil.getInteger(actionRequest, "sort", 0);
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (companyTypeId > 0) {

			try {
				_companyTypeLocalService.updateCompanyType(companyTypeId, name, label, sort, active);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/company_type/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/company_type/edit.jsp");
			}
		} else {
			try {
				_companyTypeLocalService.addCompanyType(name, label, sort, active);
				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/master/company_type/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/company_type/edit.jsp");
			}
		}
	}

	/**
	 * Add or Update Master Branch
	 */
	public void addBranch(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		long masterBranchId = ParamUtil.get(actionRequest, "masterBranchId", 0);
		String name = ParamUtil.getString(actionRequest, "name", "");
		String agiCode = ParamUtil.getString(actionRequest, "agiCode", "");
		String magiCode = ParamUtil.getString(actionRequest, "magiCode", "");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (masterBranchId > 0) {
			try {
				MasterBranch masterBranch = _masterBranchLocalService.updateMasterBranch(masterBranchId, name, agiCode,
						magiCode, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/branch/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/branch/edit.jsp");
			}
		} else {
			try {
				MasterBranch masterBranch = _masterBranchLocalService.addMasterBranch(name, agiCode, magiCode, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/master/branch/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/branch/edit.jsp");
			}
		}
	}

	/*
	 * Add or Update Global Variable
	 */
	public void addGlobalVariable(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterGlobalVariable.class.getName(),
				actionRequest);
		long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		int masterGlobalVariableId = ParamUtil.get(actionRequest, "masterGlobalVariableId", 0);
		String group = ParamUtil.getString(actionRequest, "group", "");
		String name = ParamUtil.getString(actionRequest, "name", "");
		String value = ParamUtil.getString(actionRequest, "value", "");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		// Product Icon Upload
		File imageFile = uploadRequest.getFile("imageFile");

		String imageURL = "";
		String fileName = "";
		long imageFileEntryId = 0;
		long groupId = 0;

		// upload images
		if (imageFile != null) {
			String imageFileName = uploadRequest.getFileName("imageFile");

			if (imageFileName != null && !imageFileName.equals("")) {
				String iconFileContentType = uploadRequest.getContentType("imageFile");
				// validate file
				_validateFile(imageFileName, iconFileContentType, uploadRequest.getSize("imageFile"));
				// get user folder
				DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0, group);
				if (userFolder == null) {
					userFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(),
							themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), false, 0, group, "", false,
							serviceContext);
				}

				_setGuestPermission(themeDisplay, DLFolder.class.getName(), userFolder.getPrimaryKey());

				long folderId = userFolder.getFolderId();

				// set filename
				String uniqueFileName = _uniqueFileNameProvider.provide(imageFileName,
						curFileName -> _exists(themeDisplay, folderId, curFileName));
				// add file
				FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), repositoryId,
						userFolder.getFolderId(), uniqueFileName, iconFileContentType, uniqueFileName, "", "",
						imageFile, serviceContext);

				_setGuestPermission(themeDisplay, DLFileEntry.class.getName(), fileEntry.getPrimaryKey());

				imageFileEntryId = fileEntry.getFileEntryId();
				fileEntry = DLAppLocalServiceUtil.getFileEntry(imageFileEntryId);
				groupId = fileEntry.getGroupId();
				fileName = fileEntry.getFileName();
				imageURL = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFolderId() + "/"
						+ fileEntry.getFileName();
			}
		}

		if (masterGlobalVariableId > 0) {
			try {
				ParamUtil.print(actionRequest);
				_masterGlobalVariableLocalService.updateMasterGlobalVariable(masterGlobalVariableId, group, name, value,
						imageURL, imageFileEntryId, active);

				List<DLFileEntry> fileEntries = DLFileEntryLocalServiceUtil.getFileEntries(groupId, 0);

				for (DLFileEntry fileEntry : fileEntries) {
					if (fileEntry.getFileName().equalsIgnoreCase(fileName))
						DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
				}

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/global_variable/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				List<DLFileEntry> fileEntries = DLFileEntryLocalServiceUtil.getFileEntries(groupId, 0);

				for (DLFileEntry fileEntry : fileEntries) {
					if (fileEntry.getFileName().equalsIgnoreCase(fileName))
						DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
				}

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/global_variable/edit.jsp");
			}
		} else {
			try {
				_masterGlobalVariableLocalService.addMasterGlobalVariable(group, name, value, imageURL,
						imageFileEntryId, active);

				List<DLFileEntry> fileEntries = DLFileEntryLocalServiceUtil.getFileEntries(groupId, 0);

				for (DLFileEntry fileEntry : fileEntries) {
					if (fileEntry.getFileName().equalsIgnoreCase(fileName))
						DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
				}

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/master/global_variable/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				List<DLFileEntry> fileEntries = DLFileEntryLocalServiceUtil.getFileEntries(groupId, 0);

				for (DLFileEntry fileEntry : fileEntries) {
					if (fileEntry.getFileName().equalsIgnoreCase(fileName))
						DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
				}

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/master/global_variable/edit.jsp");
			}
		}
	}

	

	/**
	 * EXPORT & IMPORT
	 */

	// Method for resource URL
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
		String type = ParamUtil.getString(resourceRequest, "type");

		if (cmd.equals(Constants.EXPORT) || cmd.equals("exportAll")) {
			if (type.equals("country")) {
				exportMasterCountry(resourceRequest, resourceResponse);
			}
			if (type.equals("currency")) {
				exportMasterCurrency(resourceRequest, resourceResponse);
			}
			if (type.equals("blacklist_customer")) {
				exportBlacklistCustomer(resourceRequest, resourceResponse);
			}
			if (type.equals("province")) {
				exportMasterProvince(resourceRequest, resourceResponse);
			}
			if (type.equals("city")) {
				exportMasterCity(resourceRequest, resourceResponse);
			}
			if (type.equals("promocode")) {
				exportPromocode(resourceRequest, resourceResponse);
			}
			if (type.equals("bank")) {
				exportMasterBank(resourceRequest, resourceResponse);
			}
			if (type.equals("industry_category")) {
				exportIndustryCategory(resourceRequest, resourceResponse);
			}
			if (type.equals("industry")) {
				exportIndustry(resourceRequest, resourceResponse);
			}
			if (type.equals("job_position")) {
				exportJobPosition(resourceRequest, resourceResponse);
			}
			if (type.equals("paymentchannel")) {
				exportPaymentChannel(resourceRequest, resourceResponse);
			}
			if (type.equals("referenceNumber")) {
				exportReferenceNumber(resourceRequest, resourceResponse);
			}
			if (type.equals("occupation")) {
				exportOccupation(resourceRequest, resourceResponse);
			}
			if (type.equals("occupationCategory")) {
				exportOccupationCategory(resourceRequest, resourceResponse);
			}

		}
		return;
	}

	private String getCSVFormattedValue(String value) {
		StringBundler sb = new StringBundler(3);
		sb.append(CharPool.QUOTE);
		sb.append(StringUtil.replace(value, CharPool.QUOTE, StringPool.DOUBLE_QUOTE));
		sb.append(CharPool.QUOTE);
		return sb.toString();
	}

	// Import Country
	public void importMasterCountry(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String filePath = "C:/liferayTmp/importMasterCountry.csv";
		List<String> csvHeadLines = Arrays.asList("Country ID", "Name", "Platinum", "Gold", "Special Asia", "Schengen",
				"Sanction Country", "Active");

		try (FileOutputStream fOut = new FileOutputStream(filePath);) {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			InputStream is = uploadRequest.getFileAsStream("importFile");
			int i;
			while ((i = is.read()) != -1) {
				fOut.write(i);
			}

			CsvReader csvReader = new CsvReader(new FileReader(filePath));
			csvReader.setDelimiter(';');

			csvReader.readHeaders();
			String[] headers = csvReader.getHeaders();
			if (!Arrays.asList(headers).containsAll(csvHeadLines)) {
				throw new RuntimeException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterCountry.class.getName(),
					actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			Long countryId = null;
			String name;
			int isPlatinum;
			int isGold;
			int isSpecialAsia;
			int isSchengen;
			int isSanctionCountry;
			int active;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				String countryIdCurrColVal = csvReader.get("Country ID");
				if (countryIdCurrColVal != null && !countryIdCurrColVal.equals(""))
					countryId = Long.parseLong(countryIdCurrColVal);

				String nameCurrColVal = csvReader.get("Name");
				if (nameCurrColVal == null || nameCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Name.");
					continue;
				} else {
					name = nameCurrColVal;
				}

				String isPlatinumCurrColVal = csvReader.get("Platinum");
				if (isPlatinumCurrColVal == null || Integer.parseInt(isPlatinumCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Platinum.");
					continue;
				} else {
					isPlatinum = Integer.parseInt(isPlatinumCurrColVal);
				}

				String isGoldCurrColVal = csvReader.get("Gold");
				if (isGoldCurrColVal == null || Integer.parseInt(isGoldCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Gold.");
					continue;
				} else {
					isGold = Integer.parseInt(isGoldCurrColVal);
				}

				String isSpecialAsiaCurrColVal = csvReader.get("Special Asia");
				if (isSpecialAsiaCurrColVal == null || Integer.parseInt(isSpecialAsiaCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Special Asia.");
					continue;
				} else {
					isSpecialAsia = Integer.parseInt(isSpecialAsiaCurrColVal);
				}

				String isSchengenCurrColVal = csvReader.get("Schengen");
				if (isSchengenCurrColVal == null || Integer.parseInt(isSchengenCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Schengen.");
					continue;
				} else {
					isSchengen = Integer.parseInt(isSchengenCurrColVal);
				}

				String isSanctionCountryCurrColVal = csvReader.get("Sanction Country");
				if (isSanctionCountryCurrColVal == null || Integer.parseInt(isSanctionCountryCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Sanction Country.");
					continue;
				} else {
					isSanctionCountry = Integer.parseInt(isSanctionCountryCurrColVal);
				}

				String activeCurrColVal = csvReader.get("Active");
				if (activeCurrColVal == null || Integer.parseInt(activeCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Active.");
					continue;
				} else {
					active = Integer.parseInt(activeCurrColVal);
				}

				// Insert all evaluated data to database
				if (countryIdCurrColVal != null) {
					try {
						_masterCountryLocalService.updateMasterCountry(countryId, name, isPlatinum, isGold,
								isSpecialAsia, isSchengen, isSanctionCountry, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-update-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/country/list.jsp");
					}
				} else {
					try {
						_masterCountryLocalService.addMasterCountry(name, isPlatinum, isGold, isSpecialAsia, isSchengen,
								isSanctionCountry, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/country/list.jsp");
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", "/master/country/list.jsp");

		} catch (Exception e) {
			log.info(e);
		}
	}

	// Export Country
	private void exportMasterCountry(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {
			long[] countries = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("Country ID", "Name", "Platinum", "Gold", "Special Asia",
					"Schengen", "Sanction Country", "Active");

			String COMMA = ";";
			StringBundler sb = new StringBundler();
			for (String columnName : csvHeadLines) {
				sb.append(getCSVFormattedValue(String.valueOf(columnName)));
				sb.append(COMMA);
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);

			// If ExportAll
			if (cmd.equals("exportAll")) {
				List<MasterCountry> _countries = _masterCountryLocalService.getMasterCountries();

				for (MasterCountry _country : _countries) {
					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_country.getCountryId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_country.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_country.getIsPlatinum())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_country.getIsGold())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_country.getIsSpecialAsia())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_country.getIsSchengen())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_country.getIsSanctionCountry())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_country.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (countries.length < 1)
					return;

				for (long countryId : countries) {

					MasterCountry _country = _masterCountryLocalService.getMasterCountry(countryId);

					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_country.getCountryId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_country.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_country.getIsPlatinum())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_country.getIsGold())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_country.getIsSpecialAsia())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_country.getIsSchengen())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_country.getIsSanctionCountry())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_country.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportsMasterCountry.csv", bytes,
					contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	// Import Currency
	public void importMasterCurrency(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String filePath = "C:/liferayTmp/importMasterCurrency.csv";
		List<String> csvHeadLines = Arrays.asList("Currency ID", "Name", "Amount", "Default Currency", "Active");

		try (FileOutputStream fOut = new FileOutputStream(filePath);) {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			InputStream is = uploadRequest.getFileAsStream("importFile");
			int i;
			while ((i = is.read()) != -1) {
				fOut.write(i);
			}

			CsvReader csvReader = new CsvReader(new FileReader(filePath));
			csvReader.setDelimiter(';');

			csvReader.readHeaders();
			String[] headers = csvReader.getHeaders();
			if (!Arrays.asList(headers).containsAll(csvHeadLines)) {
				throw new RuntimeException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterCurrency.class.getName(),
					actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			Long currencyId = null;
			String name;
			double amount;
			int isDefault;
			int active;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				String currencyIdCurrColVal = csvReader.get("Currency ID");
				if (currencyIdCurrColVal != null && !currencyIdCurrColVal.equals(""))
					currencyId = Long.parseLong(currencyIdCurrColVal);

				String nameCurrColVal = csvReader.get("Name");
				if (nameCurrColVal == null || nameCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Name.");
					continue;
				} else {
					name = nameCurrColVal;
				}

				String amountCurrColVal = csvReader.get("Amount");
				if (amountCurrColVal == null || amountCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Amount.");
					continue;
				} else {
					amount = Double.parseDouble(amountCurrColVal);
				}

				String isDefaultCurrColVal = csvReader.get("Default Currency");
				if (isDefaultCurrColVal == null || Integer.parseInt(isDefaultCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Default Currency.");
					continue;
				} else {
					isDefault = Integer.parseInt(isDefaultCurrColVal);
				}

				String activeCurrColVal = csvReader.get("Active");
				if (activeCurrColVal == null || Integer.parseInt(activeCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Active.");
					continue;
				} else {
					active = Integer.parseInt(activeCurrColVal);
				}

				// Insert all evaluated data to database
				if (currencyIdCurrColVal != null) {
					try {
						_masterCurrencyLocalService.updateMasterCurrency(currencyId, name, amount, isDefault, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-update-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/currency/list.jsp");
					}
				} else {
					try {
						_masterCurrencyLocalService.addMasterCurrency(name, amount, isDefault, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/currency/list.jsp");
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", "/master/currency/list.jsp");

		} catch (Exception e) {
			log.info(e);
		}
	}

	// Export Currency
	private void exportMasterCurrency(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {
			long[] currencies = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("Currency ID", "Name", "Amount", "Default Currency", "Active");

			String COMMA = ";";
			StringBundler sb = new StringBundler();
			for (String columnName : csvHeadLines) {
				sb.append(getCSVFormattedValue(String.valueOf(columnName)));
				sb.append(COMMA);
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);

			// If ExportAll
			if (cmd.equals("exportAll")) {
				List<MasterCurrency> _currencies = _masterCurrencyLocalService.getMasterCurrencies();

				for (MasterCurrency _currency : _currencies) {
					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_currency.getCurrencyId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_currency.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_currency.getAmount())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_currency.getIsDefault())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_currency.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (currencies.length < 1)
					return;

				for (long currencyId : currencies) {

					MasterCurrency _currency = _masterCurrencyLocalService.getMasterCurrency(currencyId);

					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_currency.getCurrencyId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_currency.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_currency.getAmount())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_currency.getIsDefault())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_currency.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportsMasterCurrency.csv", bytes,
					contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	// Import Country
	public void importBlacklistCustomer(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String filePath = "C:/liferayTmp/importBlacklistCustomer.csv";
		List<String> csvHeadLines = Arrays.asList("Blacklist Customer ID", "Full Name", "First Name", "Middle Name",
				"Last Name", "KTP Number", "KITAS", "Email", "Date of Birth", "Active");

		try (FileOutputStream fOut = new FileOutputStream(filePath);) {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			InputStream is = uploadRequest.getFileAsStream("importFile");
			int i;
			while ((i = is.read()) != -1) {
				fOut.write(i);
			}

			CsvReader csvReader = new CsvReader(new FileReader(filePath));
			csvReader.setDelimiter(';');

			csvReader.readHeaders();
			String[] headers = csvReader.getHeaders();
			if (!Arrays.asList(headers).containsAll(csvHeadLines)) {
				throw new RuntimeException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(BlacklistCustomer.class.getName(),
					actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			Long blacklistCustomerId = null;
			String fullName;
			String firstName;
			String middleName;
			String lastName;
			String ktp;
			String kitas;
			String email;
			Date dateOfBirth;
			int active;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				String blacklistCustomerIdCurrColVal = csvReader.get("Blacklist Customer ID");
				if (blacklistCustomerIdCurrColVal != null && !blacklistCustomerIdCurrColVal.equals(""))
					blacklistCustomerId = Long.parseLong(blacklistCustomerIdCurrColVal);

				String fullNameCurrColVal = csvReader.get("Full Name");
				if (fullNameCurrColVal == null || fullNameCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Full Name.");
					continue;
				} else {
					fullName = fullNameCurrColVal;
				}

				String firstNameCurrColVal = csvReader.get("First Name");
				if (firstNameCurrColVal == null || firstNameCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "First Name.");
					continue;
				} else {
					firstName = firstNameCurrColVal;
				}

				String middleNameCurrColVal = csvReader.get("Middle Name");
				if (middleNameCurrColVal == null || middleNameCurrColVal.equals("")) {
					middleName = null;
				} else {
					middleName = middleNameCurrColVal;
				}

				String lastNameCurrColVal = csvReader.get("Last Name");
				if (lastNameCurrColVal == null || lastNameCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Last Name.");
					continue;
				} else {
					lastName = lastNameCurrColVal;
				}

				String ktpNumberCurrColVal = csvReader.get("KTP Number");
				if (ktpNumberCurrColVal == null || ktpNumberCurrColVal.equals("")) {
					ktp = null;
				} else {
					ktp = ktpNumberCurrColVal;
				}

				String kitasCurrColVal = csvReader.get("KITAS");
				if (kitasCurrColVal == null || kitasCurrColVal.equals("")) {
					kitas = null;
				} else {
					kitas = kitasCurrColVal;
				}

				String emailCurrColVal = csvReader.get("Email");
				if (emailCurrColVal == null || emailCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Email.");
					continue;
				} else {
					email = emailCurrColVal;
				}

				String dateOfBirthCurrColVal = csvReader.get("Date of Birth");
				if (dateOfBirthCurrColVal == null || dateOfBirthCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Date of Birth.");
					continue;
				} else {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					dateOfBirth = sdf.parse(dateOfBirthCurrColVal);
				}

				String activeCurrColVal = csvReader.get("Active");
				if (activeCurrColVal == null || Integer.parseInt(activeCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Active.");
					continue;
				} else {
					active = Integer.parseInt(activeCurrColVal);
				}

				// Insert all evaluated data to database
				if (blacklistCustomerIdCurrColVal != null) {
					try {
						_blacklistCustomerLocalService.updateBlacklistCustomer(blacklistCustomerId, fullName, firstName,
								middleName, lastName, ktp, kitas, email, dateOfBirth, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-update-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/blacklist_customer/list.jsp");
					}
				} else {
					try {
						_blacklistCustomerLocalService.addBlacklistCustomer(fullName, firstName, middleName, lastName,
								ktp, kitas, email, dateOfBirth, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/blacklist_customer/list.jsp");
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", "/master/blacklist_customer/list.jsp");

		} catch (Exception e) {
			log.info(e);
		}
	}

	// Export Blacklist Customer
	private void exportBlacklistCustomer(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {
			long[] blacklistCustomers = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("Blacklist Customer ID", "Full Name", "First Name", "Middle Name",
					"Last Name", "KTP Number", "KITAS", "Email", "Date of Birth", "Active");

			String COMMA = ";";
			StringBundler sb = new StringBundler();
			for (String columnName : csvHeadLines) {
				sb.append(getCSVFormattedValue(String.valueOf(columnName)));
				sb.append(COMMA);
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);

			// If ExportAll
			if (cmd.equals("exportAll")) {
				List<BlacklistCustomer> _blacklistcustomers = _blacklistCustomerLocalService.getBlacklistCustomers();

				for (BlacklistCustomer _blacklistcustomer : _blacklistcustomers) {
					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getBlacklistCustomerId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getFullName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getFirstName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getMiddleName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getLastName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getKtp())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getKitas())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getEmail())));
						sb.append(COMMA);

						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						String _dob = sdf.format(_blacklistcustomer.getDateOfBirth());

						sb.append(getCSVFormattedValue(String.valueOf(_dob)));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (blacklistCustomers.length < 1)
					return;

				for (long blacklistCustomerId : blacklistCustomers) {

					BlacklistCustomer _blacklistcustomer = _blacklistCustomerLocalService
							.getBlacklistCustomer(blacklistCustomerId);

					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getBlacklistCustomerId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getFullName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getFirstName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getMiddleName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getLastName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getKtp())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getKitas())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getEmail())));
						sb.append(COMMA);

						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						String _dob = sdf.format(_blacklistcustomer.getDateOfBirth());

						sb.append(getCSVFormattedValue(String.valueOf(_dob)));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_blacklistcustomer.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportsMasterBlacklistCustomer.csv", bytes,
					contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	// Import Province
	public void importMasterProvince(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String filePath = "C:/liferayTmp/importMasterProvince.csv";
		List<String> csvHeadLines = Arrays.asList("Province ID", "Name", "Country", "Active");

		try (FileOutputStream fOut = new FileOutputStream(filePath);) {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			InputStream is = uploadRequest.getFileAsStream("importFile");
			int i;
			while ((i = is.read()) != -1) {
				fOut.write(i);
			}

			CsvReader csvReader = new CsvReader(new FileReader(filePath));
			csvReader.setDelimiter(';');

			csvReader.readHeaders();
			String[] headers = csvReader.getHeaders();
			if (!Arrays.asList(headers).containsAll(csvHeadLines)) {
				throw new RuntimeException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterCountry.class.getName(),
					actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			Long masterProvinceId = null;
			String name;
			int countryId;
			int active;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				String provinceIdCurrColVal = csvReader.get("Province ID");
				if (provinceIdCurrColVal != null && !provinceIdCurrColVal.equals(""))
					masterProvinceId = Long.parseLong(provinceIdCurrColVal);

				String nameCurrColVal = csvReader.get("Name");
				if (nameCurrColVal == null || nameCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Name.");
					continue;
				} else {
					name = nameCurrColVal.toUpperCase();
				}

				String countryCurrColVal = csvReader.get("Country");
				if (countryCurrColVal == null || countryCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Country.");
					continue;
				} else {
					// get country from name
					List<MasterCountry> country = _masterCountryLocalService.getMasterCountryByname(countryCurrColVal);
					System.out.print(country);

					if (country.size() < 1) {
						invalid.append("<br>Baris " + row + ", Kolom " + "Country.");
						continue;
					} else {
						countryId = (int) country.get(0).getCountryId();
					}
				}

				String activeCurrColVal = csvReader.get("Active");
				if (activeCurrColVal == null || Integer.parseInt(activeCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Active.");
					continue;
				} else {
					active = Integer.parseInt(activeCurrColVal);
				}

				// Insert all evaluated data to database
				if (provinceIdCurrColVal != null) {
					try {
						_masterProvinceLocalService.updateMasterProvince(masterProvinceId, name, countryId, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-update-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/province/list.jsp");
					}
				} else {
					try {
						_masterProvinceLocalService.addMasterProvince(name, countryId, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/province/list.jsp");
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", "/master/province/list.jsp");

		} catch (Exception e) {
			log.info(e);
		}
	}

	// Export Province
	private void exportMasterProvince(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {
			long[] provinces = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("Province ID", "Name", "Country", "Active");

			String COMMA = ";";
			StringBundler sb = new StringBundler();
			for (String columnName : csvHeadLines) {
				sb.append(getCSVFormattedValue(String.valueOf(columnName)));
				sb.append(COMMA);
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);

			// If ExportAll
			if (cmd.equals("exportAll")) {
				List<MasterProvince> _provinces = _masterProvinceLocalService.getMasterProvinces(0,
						_masterProvinceLocalService.getMasterProvincesCount());

				for (MasterProvince _province : _provinces) {
					try {
						MasterCountry country = _masterCountryLocalService.getMasterCountry(_province.getCountryId());

						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_province.getMasterProvinceId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_province.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(country.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_province.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (provinces.length < 1)
					return;

				for (long masterProvinceId : provinces) {

					MasterProvince _province = _masterProvinceLocalService.getMasterProvince(masterProvinceId);

					try {
						MasterCountry country = _masterCountryLocalService.getMasterCountry(_province.getCountryId());

						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_province.getMasterProvinceId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_province.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(country.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_province.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportsMasterProvince.csv", bytes,
					contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	// Import City
	public void importMasterCity(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String filePath = "C:/liferayTmp/importMasterCity.csv";
		List<String> csvHeadLines = Arrays.asList("City ID", "Name", "Province", "Status", "ParEarthquakeZone",
				"Active");

		try (FileOutputStream fOut = new FileOutputStream(filePath);) {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			InputStream is = uploadRequest.getFileAsStream("importFile");
			int i;
			while ((i = is.read()) != -1) {
				fOut.write(i);
			}

			CsvReader csvReader = new CsvReader(new FileReader(filePath));
			csvReader.setDelimiter(';');

			csvReader.readHeaders();
			String[] headers = csvReader.getHeaders();
			if (!Arrays.asList(headers).containsAll(csvHeadLines)) {
				throw new RuntimeException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterCountry.class.getName(),
					actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			Long masterCityId = null;
			String name;
			int provinceId;
			String status;
			int parEarthquakeZone;
			int active;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				String cityIdCurrColVal = csvReader.get("City ID");
				if (cityIdCurrColVal != null && !cityIdCurrColVal.equals(""))
					masterCityId = Long.parseLong(cityIdCurrColVal);

				String nameCurrColVal = csvReader.get("Name");
				if (nameCurrColVal == null || nameCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Name.");
					continue;
				} else {
					name = nameCurrColVal.toUpperCase();
				}

				String provinceCurrColVal = csvReader.get("Province");
				if (provinceCurrColVal == null || provinceCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Province.");
					continue;
				} else {
					// get country from name
					List<MasterProvince> province = _masterProvinceLocalService
							.getMasterProvinceByname(provinceCurrColVal);
					System.out.print(province);

					if (province.size() < 1) {
						invalid.append("<br>Baris " + row + ", Kolom " + "Province.");
						continue;
					} else {
						provinceId = (int) province.get(0).getMasterProvinceId();
					}
				}

				String statusCurrColVal = csvReader.get("Status");
				if (statusCurrColVal == null || statusCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Status.");
					continue;
				} else {
					status = statusCurrColVal;
				}

				int parEarthquakeZoneCurrColVal = Integer.parseInt(csvReader.get("ParEarthquakeZone"));
				if (csvReader.get("ParEarthquakeZone").equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "ParEarthquakeZone.");
					continue;
				} else {
					parEarthquakeZone = parEarthquakeZoneCurrColVal;
				}

				String activeCurrColVal = csvReader.get("Active");
				if (activeCurrColVal == null || Integer.parseInt(activeCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Active.");
					continue;
				} else {
					active = Integer.parseInt(activeCurrColVal);
				}

				// Insert all evaluated data to database
				if (cityIdCurrColVal != null) {
					try {
						_masterCityLocalService.updateMasterCity(masterCityId, nameCurrColVal, provinceId, status,
								parEarthquakeZone, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-update-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/city/list.jsp");
					}
				} else {
					try {
						_masterCityLocalService.addMasterCity(nameCurrColVal, provinceId, status, parEarthquakeZone,
								active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/city/list.jsp");
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", "/master/city/list.jsp");

		} catch (Exception e) {
			log.info(e);
		}
	}

	// Export City
	private void exportMasterCity(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			long[] cities = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("City ID", "Name", "Province", "Status", "ParEarthquakeZone",
					"Active");

			String COMMA = ";";
			StringBundler sb = new StringBundler();
			for (String columnName : csvHeadLines) {
				sb.append(getCSVFormattedValue(String.valueOf(columnName)));
				sb.append(COMMA);
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);

			// If ExportAll
			if (cmd.equals("exportAll")) {
				List<MasterCity> _cities = _masterCityLocalService.getMasterCities(0,
						_masterCityLocalService.getMasterCitiesCount());

				for (MasterCity _city : _cities) {
					try {
						MasterProvince province = _masterProvinceLocalService.getMasterProvince(_city.getProvinceId());

						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_city.getMasterCityId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_city.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(province.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_city.getStatus())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_city.getParEarthquakeZone())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_city.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (cities.length < 1)
					return;

				for (long masterCityId : cities) {

					MasterCity _city = _masterCityLocalService.getMasterCity(masterCityId);

					try {
						MasterProvince province = _masterProvinceLocalService.getMasterProvince(_city.getProvinceId());

						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_city.getMasterCityId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_city.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(province.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_city.getStatus())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_city.getParEarthquakeZone())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_city.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportsMasterCity.csv", bytes,
					contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	// Export Industry Category
	private void exportIndustryCategory(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {
			long[] industryCategories = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("Industry Category ID", "Name", "Active");

			String COMMA = ";";
			StringBundler sb = new StringBundler();
			for (String columnName : csvHeadLines) {
				sb.append(getCSVFormattedValue(String.valueOf(columnName)));
				sb.append(COMMA);
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);

			// If ExportAll
			if (cmd.equals("exportAll")) {
				List<IndustryCategory> _industryCategories = _industryCategoryLocalService.getIndustryCategories();

				for (IndustryCategory _industryCategory : _industryCategories) {
					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_industryCategory.getIndustryCategoryId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_industryCategory.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_industryCategory.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (industryCategories.length < 1)
					return;

				for (long industryCategoryId : industryCategories) {

					IndustryCategory _industryCategory = _industryCategoryLocalService
							.getIndustryCategory(industryCategoryId);

					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_industryCategory.getIndustryCategoryId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_industryCategory.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_industryCategory.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportsIndustryCategory.csv", bytes,
					contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	// Import Industry Category
	public void importIndustryCategory(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		String _currentListPath = "/master/industry_category/list.jsp";

		String filePath = "C:/liferayTmp/importIndustryCategory.csv";
		List<String> csvHeadLines = Arrays.asList("Industry Category ID", "Name", "Active");

		try (FileOutputStream fOut = new FileOutputStream(filePath);) {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			InputStream is = uploadRequest.getFileAsStream("importFile");
			int i;
			while ((i = is.read()) != -1) {
				fOut.write(i);
			}

			CsvReader csvReader = new CsvReader(new FileReader(filePath));
			csvReader.setDelimiter(';');

			csvReader.readHeaders();
			String[] headers = csvReader.getHeaders();
			if (!Arrays.asList(headers).containsAll(csvHeadLines)) {
				throw new RuntimeException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(IndustryCategory.class.getName(),
					actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			Long industryCategoryId = null;
			String name;
			int active;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				// Apabila kolom id null, proses CRUD tetap berlanjut
				// dengan kondisi apabila null maka method update yang berjalan
				// apabila sebaliknya, maka method add yang berjalan
				String industryCategoryIdCurrColVal = csvReader.get("Industry Category ID");
				if (industryCategoryIdCurrColVal != null && !industryCategoryIdCurrColVal.equals(""))
					industryCategoryId = Long.parseLong(industryCategoryIdCurrColVal);

				String nameCurrColVal = csvReader.get("Name");
				if (nameCurrColVal == null || nameCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Name.");
					continue;
				} else {
					name = nameCurrColVal;
				}

				String activeCurrColVal = csvReader.get("Active");
				if (activeCurrColVal == null || Integer.parseInt(activeCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Active.");
					continue;
				} else {
					active = Integer.parseInt(activeCurrColVal);
				}

				// Insert all evaluated data to database
				if (industryCategoryIdCurrColVal != null) {
					try {
						_industryCategoryLocalService.updateIndustryCategory(industryCategoryId, name, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-update-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", _currentListPath);
					}
				} else {
					try {
						_industryCategoryLocalService.addIndustryCategory(name, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", _currentListPath);
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", _currentListPath);

		} catch (Exception e) {
			log.info(e);
		}
	}

	// Export Industry
	private void exportIndustry(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {
			long[] industries = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("Industry ID", "Name", "Industry Category ID", "Active");

			String COMMA = ";";
			StringBundler sb = new StringBundler();
			for (String columnName : csvHeadLines) {
				sb.append(getCSVFormattedValue(String.valueOf(columnName)));
				sb.append(COMMA);
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);

			// If ExportAll
			if (cmd.equals("exportAll")) {
				List<Industry> _industries = _industryLocalService.getIndustries();

				for (Industry _industry : _industries) {
					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_industry.getIndustryId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_industry.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_industry.getIndustryCategoryId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_industry.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (industries.length < 1)
					return;

				for (long industryId : industries) {

					Industry _industry = _industryLocalService.getIndustry(industryId);

					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_industry.getIndustryId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_industry.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_industry.getIndustryCategoryId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_industry.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportsIndustry.csv", bytes, contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	// Import Industry
	public void importIndustry(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		String _currentListPath = "/master/industry/list.jsp";

		String filePath = "C:/liferayTmp/importIndustry.csv";
		List<String> csvHeadLines = Arrays.asList("Industry ID", "Name", "Industry Category ID", "Active");

		try (FileOutputStream fOut = new FileOutputStream(filePath);) {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			InputStream is = uploadRequest.getFileAsStream("importFile");
			int i;
			while ((i = is.read()) != -1) {
				fOut.write(i);
			}

			CsvReader csvReader = new CsvReader(new FileReader(filePath));
			csvReader.setDelimiter(';');

			csvReader.readHeaders();
			String[] headers = csvReader.getHeaders();
			if (!Arrays.asList(headers).containsAll(csvHeadLines)) {
				throw new RuntimeException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(Industry.class.getName(), actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			Long industryId = null;
			String name;
			Long industryCategoryId = null;
			int active;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				// Apabila kolom id null, proses CRUD tetap berlanjut
				// dengan kondisi apabila null maka method update yang berjalan
				// apabila sebaliknya, maka method add yang berjalan
				String industryIdCurrColVal = csvReader.get("Industry ID");
				if (industryIdCurrColVal != null && !industryIdCurrColVal.equals(""))
					industryId = Long.parseLong(industryIdCurrColVal);

				String nameCurrColVal = csvReader.get("Name");
				if (nameCurrColVal == null || nameCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Name.");
					continue;
				} else {
					name = nameCurrColVal;
				}

				String industryCategoryIdCurrColVal = csvReader.get("Industry Category ID");
				if (industryCategoryIdCurrColVal != null && !industryCategoryIdCurrColVal.equals("")) {
					IndustryCategory _industryCategory = _industryCategoryLocalService
							.fetchIndustryCategory(Long.parseLong(industryCategoryIdCurrColVal));
					if (_industryCategory != null) {
						industryCategoryId = Long.parseLong(industryCategoryIdCurrColVal);
					} else {
						invalid.append("<br>Baris " + row + ", Kolom "
								+ "Industry Category ID - Industry Category ID is not exist.");
						continue;
					}

				} else {
					invalid.append("<br>Baris " + row + ", Kolom " + "Industry Category ID.");
					continue;
				}

				String activeCurrColVal = csvReader.get("Active");
				if (activeCurrColVal == null || Integer.parseInt(activeCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Active.");
					continue;
				} else {
					active = Integer.parseInt(activeCurrColVal);
				}

				// Insert all evaluated data to database
				if (industryIdCurrColVal != null) {
					try {
						_industryLocalService.updateIndustry(industryId, industryCategoryId, name, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-update-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", _currentListPath);
					}
				} else {
					try {
						_industryLocalService.addIndustry(name, industryCategoryId, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", _currentListPath);
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", _currentListPath);

		} catch (Exception e) {
			log.info(e);
		}
	}

	

	// Export Job Position
	private void exportJobPosition(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {
			long[] jobPositions = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("Job Position ID", "Name", "Active");

			String COMMA = ";";
			StringBundler sb = new StringBundler();
			for (String columnName : csvHeadLines) {
				sb.append(getCSVFormattedValue(String.valueOf(columnName)));
				sb.append(COMMA);
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);

			// If ExportAll
			if (cmd.equals("exportAll")) {
				List<JobPosition> _jobPositions = _jobPositionLocalService.getJobPositions();

				for (JobPosition _jobPosition : _jobPositions) {
					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_jobPosition.getJobPositionId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_jobPosition.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_jobPosition.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (jobPositions.length < 1)
					return;

				for (long jobPositionId : jobPositions) {

					JobPosition _jobPosition = _jobPositionLocalService.getJobPosition(jobPositionId);

					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_jobPosition.getJobPositionId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_jobPosition.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_jobPosition.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportsJobPosition.csv", bytes,
					contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	// Import Job Position
	public void importJobPosition(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		String _currentListPath = "/master/job_position/list.jsp";

		String filePath = "C:/liferayTmp/importJobPosition.csv";
		List<String> csvHeadLines = Arrays.asList("Job Position ID", "Name", "Active");

		try (FileOutputStream fOut = new FileOutputStream(filePath);) {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			InputStream is = uploadRequest.getFileAsStream("importFile");
			int i;
			while ((i = is.read()) != -1) {
				fOut.write(i);
			}

			CsvReader csvReader = new CsvReader(new FileReader(filePath));
			csvReader.setDelimiter(';');

			csvReader.readHeaders();
			String[] headers = csvReader.getHeaders();
			if (!Arrays.asList(headers).containsAll(csvHeadLines)) {
				throw new RuntimeException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(JobPosition.class.getName(),
					actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			Long jobPositionId = null;
			String name;
			int active;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				// Apabila kolom id null, proses CRUD tetap berlanjut
				// dengan kondisi apabila null maka method update yang berjalan
				// apabila sebaliknya, maka method add yang berjalan
				String jobPositionIdCurrColVal = csvReader.get("Job Position ID");
				if (jobPositionIdCurrColVal != null && !jobPositionIdCurrColVal.equals(""))
					jobPositionId = Long.parseLong(jobPositionIdCurrColVal);

				String nameCurrColVal = csvReader.get("Name");
				if (nameCurrColVal == null || nameCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Name.");
					continue;
				} else {
					name = nameCurrColVal;
				}

				String activeCurrColVal = csvReader.get("Active");
				if (activeCurrColVal == null || Integer.parseInt(activeCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Active.");
					continue;
				} else {
					active = Integer.parseInt(activeCurrColVal);
				}

				// Insert all evaluated data to database
				if (jobPositionIdCurrColVal != null) {
					try {
						_jobPositionLocalService.updateJobPosition(jobPositionId, name, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-update-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", _currentListPath);
					}
				} else {
					try {
						_jobPositionLocalService.addJobPosition(name, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", _currentListPath);
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", _currentListPath);

		} catch (Exception e) {
			log.info(e);
		}
	}

	/**
	 * Set Status
	 */
	public void setStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		long countryId = ParamUtil.getLong(actionRequest, "countryId", 0);
		long currencyId = ParamUtil.getLong(actionRequest, "currencyId", 0);
		long blacklistCustomerId = ParamUtil.getLong(actionRequest, "blacklistCustomerId", 0);
		long masterProvinceId = ParamUtil.getLong(actionRequest, "masterProvinceId", 0);
		long masterCityId = ParamUtil.getLong(actionRequest, "masterCityId", 0);
		long promocodeId = ParamUtil.getLong(actionRequest, "promocodeId", 0);
		long industryCategoryId = ParamUtil.getLong(actionRequest, "industryCategoryId", 0);
		long industryId = ParamUtil.getLong(actionRequest, "industryId", 0);
		long jobPositionId = ParamUtil.getLong(actionRequest, "jobPositionId", 0);
		long masterBankId = ParamUtil.getLong(actionRequest, "masterBankId", 0);
		long paymentChannelId = ParamUtil.getLong(actionRequest, "paymentChannelId", 0);
		long masterOccupationCategoryId = ParamUtil.getLong(actionRequest, "masterOccupationCategoryId", 0);
		long masterOccupationId = ParamUtil.getLong(actionRequest, "masterOccupationId", 0);
		long companyTypeId = ParamUtil.getLong(actionRequest, "companyTypeId", 0);
		long masterBranchId = ParamUtil.getLong(actionRequest, "masterBranchId", 0);
		long masterGlobalVariableId = ParamUtil.getLong(actionRequest, "masterGlobalVariableId", 0);

		String _actionVal = ParamUtil.getString(actionRequest, "action", "");
		int active = 1;

		long[] entryIds = ParamUtil.getLongValues(actionRequest, "EntryIds");
		String cmd = ParamUtil.getString(actionRequest, "cmd", "");

		try {
			if (_actionVal.equals("unpublish")) {
				active = 0;
			}
		} catch (Exception e) {
			log.info(e);
		}

		try {
			if (countryId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterCountry.class.getName(),
						actionRequest);
				_masterCountryLocalService.setActive(countryId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/country/list.jsp");
			}

			if (currencyId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterCurrency.class.getName(),
						actionRequest);
				_masterCurrencyLocalService.setActive(currencyId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/currency/list.jsp");
			}

			if (blacklistCustomerId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterCurrency.class.getName(),
						actionRequest);
				_blacklistCustomerLocalService.setActive(blacklistCustomerId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/blacklist_customer/list.jsp");
			}

			if (masterProvinceId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterProvince.class.getName(),
						actionRequest);
				_masterProvinceLocalService.setActive(masterProvinceId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/province/list.jsp");
			}

			if (masterCityId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterCity.class.getName(),
						actionRequest);
				_masterCityLocalService.setActive(masterCityId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/city/list.jsp");
			}

			if (promocodeId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterPromoCode.class.getName(),
						actionRequest);
				_masterPromoCodeLocalService.setActive(promocodeId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/promocode/list.jsp");
			}

			if (industryCategoryId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(IndustryCategory.class.getName(),
						actionRequest);
				long userId = serviceContext.getUserId();
				_industryCategoryLocalService.setActive(industryCategoryId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/industry_category/list.jsp");
			}

			if (industryId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Industry.class.getName(),
						actionRequest);
				long userId = serviceContext.getUserId();
				_industryLocalService.setActive(industryId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/industry/list.jsp");
			}

			if (jobPositionId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(JobPosition.class.getName(),
						actionRequest);
				long userId = serviceContext.getUserId();
				_jobPositionLocalService.setActive(jobPositionId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/job_position/list.jsp");
			}

			if (masterBankId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterBank.class.getName(),
						actionRequest);
				_masterBankLocalService.setActive(masterBankId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/bank/list.jsp");
			}

			if (paymentChannelId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(PaymentChannel.class.getName(),
						actionRequest);
				_paymentChannelLocalService.setActive(paymentChannelId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/paymentchannel/list.jsp");
			}

			if (masterOccupationCategoryId != 0) {
				ServiceContext serviceContext = ServiceContextFactory
						.getInstance(MasterOccupationCategory.class.getName(), actionRequest);
				_occupationcategoryLocalService.setActive(masterOccupationCategoryId, active);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/occupation_category/list.jsp");
			}

			if (masterOccupationId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterOccupation.class.getName(),
						actionRequest);
				_occupationLocalService.setActive(masterOccupationId, active);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/occupation/list.jsp");
			}

			if (companyTypeId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(CompanyType.class.getName(),
						actionRequest);
				long userId = serviceContext.getUserId();
				_companyTypeLocalService.setActive(userId, companyTypeId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/company_type/list.jsp");
			}

			if (masterBranchId != 0) {
				_masterBranchLocalService.setActive(masterBranchId, active);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/branch/list.jsp");
			}

			if (masterGlobalVariableId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterGlobalVariable.class.getName(),
						actionRequest);
				_masterGlobalVariableLocalService.setActive(masterGlobalVariableId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/master/global_variable/list.jsp");
			}
			
		} catch (Exception e) {
			log.info(e);
		}
	}

	// Import Promocode
	public void importPromocode(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		String promoCode = ParamUtil.getString(actionRequest, "promocode", "");

		int searchPromoCode = MasterPromoCodeLocalServiceUtil.countByPromoCode(0, promoCode);

		if (searchPromoCode > 0) {
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);

			SessionErrors.add(actionRequest, "Failed");
			actionResponse.setRenderParameter("mvcPath", "/master/promocode/list.jsp");
			return;
		}

		String PIMCORE_HOST = getConfig("com.mypage.agent.config.pimcoreAddress");
		String dashboardApiAgencyPromoCodeUrl = getConfig("dashboard.api.agency.promocode");
		List<MasterGlobalVariable> _listToken = MasterGlobalVariableLocalServiceUtil
				.getActiveGlobalVariableByGroup("token");
		String _eToken = StringPool.BLANK;

		for (MasterGlobalVariable item : _listToken) {
			if (item.getName().equalsIgnoreCase("x_api_key"))
				_eToken = item.getValue();
		}

		try {
			JSONObject promoCodePayload = JSONFactoryUtil.createJSONObject();
			promoCodePayload.put("PromoCode", promoCode);

			JSONObject userDetailResponse = hitAPI(PIMCORE_HOST + dashboardApiAgencyPromoCodeUrl,
					promoCodePayload.toString(), _eToken);

			JSONObject userDetailAPIResponseDto = JSONFactoryUtil
					.createJSONObject(userDetailResponse.get("response").toString());

			if (userDetailAPIResponseDto.getInt("Status") == 0) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, "Failed");
				actionResponse.setRenderParameter("mvcPath", "/master/promocode/list.jsp");
				return;
			}

			for (int i = 0; i < userDetailAPIResponseDto.getInt("Count"); i++) {
				JSONObject data = JSONFactoryUtil
						.createJSONObject(userDetailAPIResponseDto.getJSONArray("Data").get(i).toString());

				MasterPromoCode dataPromoCode = _masterPromoCodeLocalService.fetchMasterPromoCode(data.getLong("Id"));

				if (Validator.isNotNull(dataPromoCode))
					continue;

				int isB2C = data.getBoolean("IsB2C") == true ? 1 : 0;
				int isB2B2C = data.getBoolean("IsB2B2C") == true ? 1 : 0;
				int isB2B = data.getBoolean("IsB2B") == true ? 1 : 0;
				int active = data.getBoolean("Status") == true ? 1 : 0;

				JSONArray activeDayArray = JSONFactoryUtil.createJSONArray(data.getString("ActiveDay"));

				StringBuilder result = new StringBuilder();
				for (int j = 0; j < activeDayArray.length(); j++) {
					result.append(activeDayArray.getString(j));
					if (j < activeDayArray.length() - 1) {
						result.append(",");
					}
				}

				String activeDay = result.toString();

				_masterPromoCodeLocalService.savePromoCode(0, data.getLong("Id"), data.getString("ProductCode"),
						data.getString("Product"), data.getString("PromoType"), data.getString("PromoCode"),
						data.getDouble("Discount", 0), data.getString("StartDate"), data.getString("EndDate"),
						activeDay, data.getString("Limit"), data.getString("Network"), data.getString("Channel"), isB2C,
						isB2B2C, isB2B, null, null, data.getString("Remarks"), 0, data.getString("AgentName"),
						data.getString("DeptoreCode"), data.getString("Commission"), data.getString("Plan"),
						data.getString("PromoCodeTerms"), data.getString("TravellerType"), active);
			}
		} catch (Exception e) {
			log.info(e);
		}
	}

	// Import CSV Promocode
	public void importCSVPromocode(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String filePath = "C:/liferayTmp/importPromocodes.csv";
		List<String> csvHeadLines = Arrays.asList("PromocodeId", "Promocode", "Limit", "Discount", "StartDate",
				"EndDate", "Terms", "Products", "isB2C", "isB2B", "isB2B2C", "Active");

		try (FileOutputStream fOut = new FileOutputStream(filePath);) {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			InputStream is = uploadRequest.getFileAsStream("importFile");
			int i;
			while ((i = is.read()) != -1) {
				fOut.write(i);
			}

			CsvReader csvReader = new CsvReader(new FileReader(filePath));
			csvReader.setDelimiter(';');

			csvReader.readHeaders();
			String[] headers = csvReader.getHeaders();
			if (!Arrays.asList(headers).containsAll(csvHeadLines)) {
				throw new RuntimeException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterCountry.class.getName(),
					actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			Long promocodeId = null;
			String promocode;
			int limit;
			double discount;
			Date startDate;
			Date endDate;
			String terms;
			String products;
			int isB2C;
			int isB2B;
			int isB2B2C;
			int active;

			String utmCampaignId = null;
			String paymentChannel = null;
			String plan = null;
			Date birthdayMonth = null;
			String promoType = null;
			double commission = 0.0;

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				String promocodeIdCurrColVal = csvReader.get("PromocodeId");
				if (promocodeIdCurrColVal != null && !promocodeIdCurrColVal.equals(""))
					promocodeId = Long.parseLong(promocodeIdCurrColVal);
				else
					promocodeId = (long) 0;

				String promocodeCurrColVal = csvReader.get("Promocode");
				if (promocodeCurrColVal == null || promocodeCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Promocode.");
					continue;
				} else {
					promocode = promocodeCurrColVal;
				}

				String limitCurrColVal = csvReader.get("Limit");
				if (limitCurrColVal == null || Integer.parseInt(limitCurrColVal) < 0) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Limit.");
					continue;
				} else {
					limit = Integer.parseInt(limitCurrColVal);
				}

				String discountCurrColVal = csvReader.get("Discount");
				if (discountCurrColVal == null || Double.parseDouble(discountCurrColVal) <= 0.0) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Discount.");
					continue;
				} else {
					discount = Double.parseDouble(discountCurrColVal);
				}

				String startDateCurrColVal = csvReader.get("StartDate");
				if (startDateCurrColVal == null || startDateCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "StartDate.");
					continue;
				} else {
					startDate = sdf.parse(startDateCurrColVal);
				}

				String endDateCurrColVal = csvReader.get("EndDate");
				if (endDateCurrColVal == null || endDateCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "EndDate.");
					continue;
				} else {
					endDate = sdf.parse(endDateCurrColVal);
				}

				String termsCurrColVal = csvReader.get("Terms");
				if (termsCurrColVal == null || termsCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Terms.");
					continue;
				} else {
					terms = termsCurrColVal;
				}

				String productsCurrColVal = csvReader.get("Products");
				if (productsCurrColVal == null || productsCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Products.");
					continue;
				} else {
					products = productsCurrColVal;
				}

				String isB2CCurrColVal = csvReader.get("isB2C");
				if (isB2CCurrColVal == null || Integer.parseInt(isB2CCurrColVal) < 0) {
					invalid.append("<br>Baris " + row + ", Kolom " + "isB2C.");
					continue;
				} else {
					isB2C = Integer.parseInt(isB2CCurrColVal);
				}

				String isB2BCurrColVal = csvReader.get("isB2B");
				if (isB2BCurrColVal == null || Integer.parseInt(isB2BCurrColVal) < 0) {
					invalid.append("<br>Baris " + row + ", Kolom " + "isB2B.");
					continue;
				} else {
					isB2B = Integer.parseInt(isB2BCurrColVal);
				}

				String isB2B2CCurrColVal = csvReader.get("isB2B2C");
				if (isB2B2CCurrColVal == null || Integer.parseInt(isB2B2CCurrColVal) < 0) {
					invalid.append("<br>Baris " + row + ", Kolom " + "isB2B2C.");
					continue;
				} else {
					isB2B2C = Integer.parseInt(isB2B2CCurrColVal);
				}

				String activeCurrColVal = csvReader.get("Active");
				if (activeCurrColVal == null || Integer.parseInt(activeCurrColVal) < 0) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Active.");
					continue;
				} else {
					active = Integer.parseInt(activeCurrColVal);
				}

				// Insert all evaluated data to database
				// try {
				// _promocodesLocalService.addPromocodes(userId, promocodeId, products,
				// promocode, commission,
				// discount, isB2C, isB2B, isB2B2C, startDate, endDate, promoType,
				// birthdayMonth, limit, terms,
				// plan, paymentChannel, utmCampaignId, active, serviceContext);
				// } catch (Exception e) {
				// SessionErrors.add(actionRequest, "data-update-failed");
				// log.info(e);
				// actionResponse.setRenderParameter("mvcPath", "/master/promocode/list.jsp");
				// }
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", "/master/promocode/list.jsp");

		} catch (Exception e) {
			log.info(e);
		}
	}

	// Export Promocode
	private void exportPromocode(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {
			long[] promocodeIds = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("PromocodeId", "Promocode", "Limit", "Discount", "StartDate",
					"EndDate", "Terms", "Products", "isB2C", "isB2B", "isB2B2C", "Active");

			String COMMA = ";";
			StringBundler sb = new StringBundler();
			for (String columnName : csvHeadLines) {
				sb.append(getCSVFormattedValue(String.valueOf(columnName)));
				sb.append(COMMA);
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date startDate;
			Date endDate;
			// If ExportAll
			if (cmd.equals("exportAll")) {
				List<Promocodes> _promocodes = _promocodesLocalService.getPromocodeses(0,
						_promocodesLocalService.getPromocodesesCount());

				for (Promocodes _promocode : _promocodes) {
					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getPromocodeId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getPromocode())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getLimit())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getDiscount())));
						sb.append(COMMA);

						startDate = _promocode.getStartDate();
						sb.append(getCSVFormattedValue(sdf.format(startDate).toString()));
						sb.append(COMMA);

						endDate = _promocode.getEndDate();
						sb.append(getCSVFormattedValue(sdf.format(endDate).toString()));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getTerms())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getProducts())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getIsB2C())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getIsB2B())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getIsB2B2C())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (promocodeIds.length < 1)
					return;

				for (long promocodeId : promocodeIds) {

					Promocodes _promocode = _promocodesLocalService.getPromocodes(promocodeId);

					try {
						// Populate each column in row to single csv row
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getPromocodeId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getPromocode())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getLimit())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getDiscount())));
						sb.append(COMMA);

						startDate = _promocode.getStartDate();
						sb.append(getCSVFormattedValue(sdf.format(startDate).toString()));
						sb.append(COMMA);

						endDate = _promocode.getEndDate();
						sb.append(getCSVFormattedValue(sdf.format(endDate).toString()));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getTerms())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getProducts())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getIsB2C())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getIsB2B())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getIsB2B2C())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_promocode.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportsPromocodes.csv", bytes,
					contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	// Import Bank
	public void importMasterBank(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String filePath = "C:/liferayTmp/importMasterBank.csv";
		List<String> csvHeadLines = Arrays.asList("Bank ID", "Code", "Name", "Description", "Detail", "Order",
				"Active");

		try (FileOutputStream fOut = new FileOutputStream(filePath);) {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			InputStream is = uploadRequest.getFileAsStream("importFile");
			int i;
			while ((i = is.read()) != -1) {
				fOut.write(i);
			}

			CsvReader csvReader = new CsvReader(new FileReader(filePath));
			csvReader.setDelimiter(';');

			csvReader.readHeaders();
			String[] headers = csvReader.getHeaders();
			if (!Arrays.asList(headers).containsAll(csvHeadLines)) {
				throw new RuntimeException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterCountry.class.getName(),
					actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			Long masterBankId = null;
			String bankCode;
			String bankDesc;
			String name;
			String detail = null;
			String imageURL = null;
			long imageFileEntryId = 0;
			int order = 0;
			int active;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				String bankIdCurrColVal = csvReader.get("Bank ID");
				if (bankIdCurrColVal != null && !bankIdCurrColVal.equals(""))
					masterBankId = Long.parseLong(bankIdCurrColVal);

				String codeCurrColVal = csvReader.get("Code");
				if (codeCurrColVal == null || codeCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Code.");
					continue;
				} else {
					bankCode = codeCurrColVal;
				}

				String nameCurrColVal = csvReader.get("Name");
				if (nameCurrColVal == null || nameCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Name.");
					continue;
				} else {
					name = nameCurrColVal;
				}

				String descriptionCurrColVal = csvReader.get("Description");
				bankDesc = descriptionCurrColVal;

				String detailCurrColVal = csvReader.get("Detail");
				detail = detailCurrColVal;

				String orderCurrColVal = csvReader.get("Order");
				if (orderCurrColVal != null) {
					order = Integer.parseInt(orderCurrColVal);
				} else {
					order = 0;
				}

				String activeCurrColVal = csvReader.get("Active");
				if (activeCurrColVal == null || Integer.parseInt(activeCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Active.");
					continue;
				} else {
					active = Integer.parseInt(activeCurrColVal);
				}

				// Insert all evaluated data to database
				if (bankIdCurrColVal != null) {
					try {
						_masterBankLocalService.updateMasterBank(masterBankId, bankCode, bankDesc, nameCurrColVal,
								detail, imageURL, imageFileEntryId, order, active, true);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-update-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/bank/list.jsp");
					}
				} else {
					try {
						_masterBankLocalService.addMasterBank(bankCode, bankDesc, nameCurrColVal, detail, imageURL,
								imageFileEntryId, order, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/bank/list.jsp");
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", "/master/bank/list.jsp");

		} catch (Exception e) {
			log.info(e);
		}
	}

	// Export Bank
	private void exportMasterBank(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			long[] banks = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("Bank ID", "Code", "Name", "Description", "Detail", "Order",
					"Active");

			String COMMA = ";";
			StringBundler sb = new StringBundler();
			for (String columnName : csvHeadLines) {
				sb.append(getCSVFormattedValue(String.valueOf(columnName)));
				sb.append(COMMA);
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);

			// If ExportAll
			if (cmd.equals("exportAll")) {
				List<MasterBank> _banks = _masterBankLocalService.getMasterBanks(0,
						_masterBankLocalService.getMasterBanksCount());

				for (MasterBank _bank : _banks) {
					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_bank.getMasterBankId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_bank.getBankCode())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_bank.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_bank.getBankDesc())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_bank.getDetail())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_bank.getOrder())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_bank.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (banks.length < 1)
					return;

				for (long masterBankId : banks) {

					MasterBank _bank = _masterBankLocalService.getMasterBank(masterBankId);

					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_bank.getMasterBankId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_bank.getBankCode())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_bank.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_bank.getBankDesc())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_bank.getDetail())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_bank.getOrder())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_bank.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportsMasterBank.csv", bytes,
					contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	// Import Payment Channel
	public void importPaymentChannel(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String filePath = "C:/liferayTmp/importPaymentChannel.csv";
		List<String> csvHeadLines = Arrays.asList("Payment Channel ID", "Code", "Name", "Minimum Payment",
				"Maximum Payment", "Description", "Bank", "Mdr Axa", "Mdr User", "Pg Fee Pct", "Pg Fee Amt", "Utm Only",
				"MallId", "SharedKey", "Active");

		try (FileOutputStream fOut = new FileOutputStream(filePath);) {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			InputStream is = uploadRequest.getFileAsStream("importFile");
			int i;
			while ((i = is.read()) != -1) {
				fOut.write(i);
			}

			CsvReader csvReader = new CsvReader(new FileReader(filePath));
			csvReader.setDelimiter(';');

			csvReader.readHeaders();
			String[] headers = csvReader.getHeaders();
			if (!Arrays.asList(headers).containsAll(csvHeadLines)) {
				throw new RuntimeException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterCountry.class.getName(),
					actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			Long paymentChannelId = null;
			String code;
			String name;
			Double minPayment = null;
			Double maxPayment = null;
			String description;
			long masterBankId;
			String mdrAxa;
			String mdrUser;
			String pgFeePct;
			String pgFeeAmt;
			long imageFileEntryId = 0;
			String imageURL = null;
			int utmOnly = 0;
			String mallId;
			String sharedKey;
			int active;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				String paymentChannelIdCurrColVal = csvReader.get("Payment Channel ID");
				if (paymentChannelIdCurrColVal != null && !paymentChannelIdCurrColVal.equals(""))
					paymentChannelId = Long.parseLong(paymentChannelIdCurrColVal);

				String codeCurrColVal = csvReader.get("Code");
				if (codeCurrColVal == null || codeCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Code.");
					continue;
				} else {
					code = codeCurrColVal;
				}

				String nameCurrColVal = csvReader.get("Name");
				if (nameCurrColVal == null || nameCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Name.");
					continue;
				} else {
					name = nameCurrColVal;
				}

				String minPaymentVal = csvReader.get("Minimum Payment");
				if (minPaymentVal != null) {
					minPayment = Double.parseDouble(minPaymentVal);
				}

				String maxPaymentVal = csvReader.get("Maximum Payment");
				if (maxPaymentVal != null) {
					maxPayment = Double.parseDouble(maxPaymentVal);
				}

				String descriptionVal = csvReader.get("Description");
				if (descriptionVal != null) {
					description = descriptionVal;
				}

				String bankVal = csvReader.get("Bank");
				if (bankVal == null || bankVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Bank " + "Detail.");
					continue;
				} else {
					List<MasterBank> bank = _masterBankLocalService.findByName(bankVal, 1);

					if (bank.isEmpty()) {
						invalid.append("<br>Baris " + row + ", Bank " + "Detail.");
						continue;
					}

					masterBankId = bank.get(0).getMasterBankId();
				}

				String mdrAxaVal = csvReader.get("Mdr Axa");
				if (mdrAxaVal != null) {
					mdrAxa = mdrAxaVal;
				}

				String mdrUserVal = csvReader.get("Mdr User");
				if (minPaymentVal != null) {
					mdrUser = mdrUserVal;
				}

				String pgFeePctVal = csvReader.get("Pg Fee Pct");
				if (pgFeePctVal != null) {
					pgFeePct = pgFeePctVal;
				}

				String pgFeeAmtVal = csvReader.get("Pg Fee Amt");
				if (pgFeeAmtVal != null) {
					pgFeeAmt = pgFeeAmtVal;
				}

				String utmOnlyVal = csvReader.get("Utm Only");
				if (utmOnlyVal != null) {
					utmOnly = Integer.parseInt(utmOnlyVal);
				}

				String mallIdVal = csvReader.get("MallId");
				if (mallIdVal != null) {
					mallId = mallIdVal;
				}

				String sharedKeyVal = csvReader.get("SharedKey");
				if (sharedKeyVal != null) {
					sharedKey = sharedKeyVal;
				}

				String activeCurrColVal = csvReader.get("Active");
				if (activeCurrColVal == null || Integer.parseInt(activeCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Active.");
					continue;
				} else {
					active = Integer.parseInt(activeCurrColVal);
				}

				// Insert all evaluated data to database
				if (paymentChannelId != null) {
					try {
						_paymentChannelLocalService.updatePaymentChannel(paymentChannelId, codeCurrColVal,
								nameCurrColVal, minPayment, maxPayment, descriptionVal, masterBankId, mdrAxaVal,
								mdrUserVal, pgFeePctVal, pgFeeAmtVal, imageFileEntryId, imageURL, utmOnly, mallIdVal,
								sharedKeyVal, active, true);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-update-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/paymentchannel/list.jsp");
					}
				} else {
					try {
						_paymentChannelLocalService.addPaymentChannel(codeCurrColVal, nameCurrColVal, minPayment,
								maxPayment, descriptionVal, masterBankId, mdrAxaVal, mdrUserVal, pgFeePctVal,
								pgFeeAmtVal, imageFileEntryId, imageURL, utmOnly, mallIdVal, sharedKeyVal, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/paymentchannel/list.jsp");
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", "/master/paymentchannel/list.jsp");

		} catch (Exception e) {
			log.info(e);
		}
	}

	// Export Payment Channel
	private void exportPaymentChannel(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			long[] paymentChannels = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("Payment Channel ID", "Code", "Name", "Minimum Payment",
					"Maximum Payment", "Description", "Bank", "Mdr Axa", "Mdr User", "Pg Fee Pct", "Pg Fee Amt",
					"Utm Only", "MallId", "SharedKey", "Active");

			String COMMA = ";";
			StringBundler sb = new StringBundler();
			for (String columnName : csvHeadLines) {
				sb.append(getCSVFormattedValue(String.valueOf(columnName)));
				sb.append(COMMA);
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);

			// If ExportAll
			if (cmd.equals("exportAll")) {
				List<PaymentChannel> _paymentChannels = _paymentChannelLocalService.getPaymentChannels(0,
						_paymentChannelLocalService.getPaymentChannelsCount());

				for (PaymentChannel _paymentChannel : _paymentChannels) {
					try {
						MasterBank _bank = _masterBankLocalService.getMasterBank(_paymentChannel.getMasterBankId());

						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getPaymentChannelId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getCode())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getMinPayment())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getMaxPayment())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getDescription())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_bank.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getMdrAxa())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getMdrUser())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getPgFeePct())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getPgFeeAmt())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getUtmOnly())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getMallId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getSharedKey())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (paymentChannels.length < 1)
					return;

				for (long paymentChannelId : paymentChannels) {

					PaymentChannel _paymentChannel = _paymentChannelLocalService.getPaymentChannel(paymentChannelId);

					try {
						MasterBank _bank = _masterBankLocalService.getMasterBank(_paymentChannel.getMasterBankId());

						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getPaymentChannelId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getCode())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getMinPayment())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getMaxPayment())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getDescription())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_bank.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getMdrAxa())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getMdrUser())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getPgFeePct())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getPgFeeAmt())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getUtmOnly())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getMallId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getSharedKey())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_paymentChannel.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportsPaymentChannel.csv", bytes,
					contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	// Import Payment Channel
	public void importReferenceNumber(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String filePath = "C:/liferayTmp/importReferenceNumber.csv";
		List<String> csvHeadLines = Arrays.asList("Reference Number ID", "User Role", "Channel", "Type", "Product Code",
				"Business Type", "Currency", "Prefix", "Active");

		try (FileOutputStream fOut = new FileOutputStream(filePath);) {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			InputStream is = uploadRequest.getFileAsStream("importFile");
			int i;
			while ((i = is.read()) != -1) {
				fOut.write(i);
			}

			CsvReader csvReader = new CsvReader(new FileReader(filePath));
			csvReader.setDelimiter(';');

			csvReader.readHeaders();
			String[] headers = csvReader.getHeaders();
			if (!Arrays.asList(headers).containsAll(csvHeadLines)) {
				throw new RuntimeException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterCountry.class.getName(),
					actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				Long referenceNumberId = null;
				String userRole;
				String channel;
				String type;
				String productCode;
				String businessType;
				String currency;
				String prefix;
				int active;

				String referenceNumberVal = csvReader.get("Reference Number ID");
				if (referenceNumberVal != null && !referenceNumberVal.equals(""))
					referenceNumberId = Long.parseLong(referenceNumberVal);

				String[] userRoleList = new String[] { "Direct", "Agent" };
				String userRoleVal = csvReader.get("User Role");
				if (userRoleVal == null || userRoleVal.equals("")
						|| !Arrays.stream(userRoleList).anyMatch(userRoleVal::equals)) {
					invalid.append("<br>Baris " + row + ", Kolom " + "User Role.");
					continue;
				} else {
					userRole = userRoleVal;
				}

				String[] channelList = new String[] { "Direct", "Agent" };
				String channelVal = csvReader.get("Channel");
				if (channelVal == null || channelVal.equals("")
						|| !Arrays.stream(channelList).anyMatch(channelVal::equals)) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Channel.");
					continue;
				} else {
					channel = channelVal;
				}

				String[] typeList = new String[] { "leads", "quotation", "kyc" };
				String typeVal = csvReader.get("Type");
				if (typeVal == null || typeVal.equals("") || !Arrays.stream(typeList).anyMatch(typeVal::equals)) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Type.");
					continue;
				} else {
					type = typeVal;
				}

				ProductConfiguration _configList = null;
				_configList = ProductConfigurationLocalServiceUtil.getConfigByCode(csvReader.get("Product Code"));
				String productCodeVal = csvReader.get("Product Code");
				if (productCodeVal == null || productCodeVal.equals("") || Validator.isNull(_configList)) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Product Code.");
					continue;
				} else {
					productCode = productCodeVal;
				}

				String[] businessList = new String[] { "B2C", "B2B", "B2B2C" };
				String businessTypeVal = csvReader.get("Business Type");
				if (businessTypeVal == null || businessTypeVal.equals("")
						|| !Arrays.stream(businessList).anyMatch(businessTypeVal::equals)) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Business Type.");
					continue;
				} else {
					businessType = businessTypeVal;
				}

				String[] currencyList = new String[] { "USD", "IDR" };
				String currencyVal = csvReader.get("Currency");
				if (currencyVal == null || currencyVal.equals("")
						|| !Arrays.stream(currencyList).anyMatch(currencyVal::equals)) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Currency.");
					continue;
				} else {
					currency = currencyVal;
				}

				String prefixVal = csvReader.get("Prefix");
				if (prefixVal == null || prefixVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Prefix.");
					continue;
				} else {
					prefix = prefixVal;
				}

				String activeCurrColVal = csvReader.get("Active");
				if (activeCurrColVal == null || Integer.parseInt(activeCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Active.");
					continue;
				} else {
					active = Integer.parseInt(activeCurrColVal);
				}

				// Insert all evaluated data to database
				if (referenceNumberId != null) {
					try {
						_referenceNumberLocalService.updateReferenceNumber(referenceNumberId, userRoleVal, channelVal,
								typeVal, productCodeVal, businessTypeVal, currencyVal, prefixVal, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-update-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/reference_number/list.jsp");
					}
				} else {
					try {
						_referenceNumberLocalService.addReferenceNumber(userRoleVal, channelVal, typeVal,
								productCodeVal, businessTypeVal, currencyVal, prefixVal, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/reference_number/list.jsp");
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", "/master/reference_number/list.jsp");

		} catch (Exception e) {
			log.info(e);
		}
	}

	// Export Reference Number
	private void exportReferenceNumber(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			long[] referenceNumbers = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("Reference Number ID", "User Role", "Channel", "Type",
					"Product Code", "Business Type", "Currency", "Prefix", "Active");

			String COMMA = ";";
			StringBundler sb = new StringBundler();
			for (String columnName : csvHeadLines) {
				sb.append(getCSVFormattedValue(String.valueOf(columnName)));
				sb.append(COMMA);
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);

			// If ExportAll
			if (cmd.equals("exportAll")) {
				List<ReferenceNumber> _reference_numbers = _referenceNumberLocalService.getReferenceNumbers(0,
						_referenceNumberLocalService.getReferenceNumbersCount());

				for (ReferenceNumber _referenceNumber : _reference_numbers) {
					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getReferenceNumberId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getUserRole())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getChannel())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getType())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getProductCode())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getBusinessType())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getCurrency())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getPrefix())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (referenceNumbers.length < 1)
					return;

				for (long referenceNumberId : referenceNumbers) {

					ReferenceNumber _referenceNumber = _referenceNumberLocalService
							.getReferenceNumber(referenceNumberId);

					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getReferenceNumberId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getUserRole())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getChannel())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getType())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getProductCode())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getBusinessType())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getCurrency())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getPrefix())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_referenceNumber.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportsReferenceNumber.csv", bytes,
					contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	// Import Occupation
	public void importMasterOccupation(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String filePath = "C:/liferayTmp/importOccupation.csv";
		List<String> csvHeadLines = Arrays.asList("Occupation ID", "Name", "Occupation Category", "Active");

		try (FileOutputStream fOut = new FileOutputStream(filePath);) {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			InputStream is = uploadRequest.getFileAsStream("importFile");
			int i;
			while ((i = is.read()) != -1) {
				fOut.write(i);
			}

			CsvReader csvReader = new CsvReader(new FileReader(filePath));
			csvReader.setDelimiter(';');

			csvReader.readHeaders();
			String[] headers = csvReader.getHeaders();
			if (!Arrays.asList(headers).containsAll(csvHeadLines)) {
				throw new RuntimeException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterCountry.class.getName(),
					actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				Long occupationId = null;
				String name;
				String occupationCategory;
				long occupationCategoryId = 0;
				int active;

				String occupationIdVal = csvReader.get("Occupation ID");
				if (occupationIdVal != null && !occupationIdVal.equals(""))
					occupationId = Long.parseLong(occupationIdVal);

				String nameVal = csvReader.get("Name");
				if (nameVal == null || nameVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Name.");
					continue;
				} else {
					name = nameVal;
				}

				String categoryVal = csvReader.get("Occupation Category");
				MasterOccupationCategory _occupationCategory = _occupationcategoryLocalService
						.searchByName(categoryVal);
				if (_occupationCategory == null || categoryVal == null || categoryVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Occupation Category.");
					continue;
				} else {
					occupationCategoryId = _occupationCategory.getMasterOccupationCategoryId();
				}

				String activeCurrColVal = csvReader.get("Active");
				if (activeCurrColVal == null || Integer.parseInt(activeCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Active.");
					continue;
				} else {
					active = Integer.parseInt(activeCurrColVal);
				}

				// Insert all evaluated data to database
				if (occupationId != null) {
					try {
						_occupationLocalService.updateMasterOccupation(occupationId, name, occupationCategoryId,
								active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-update-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/occupation/list.jsp");
					}
				} else {
					try {
						_occupationLocalService.addMasterOccupation(name, occupationCategoryId, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/occupation/list.jsp");
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", "/master/occupation/list.jsp");

		} catch (Exception e) {
			log.info(e);
		}
	}

	// Export Occupation
	private void exportOccupation(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			long[] occupations = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("Occupation ID", "Name", "Occupation Category", "Active");

			String COMMA = ";";
			StringBundler sb = new StringBundler();
			for (String columnName : csvHeadLines) {
				sb.append(getCSVFormattedValue(String.valueOf(columnName)));
				sb.append(COMMA);
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);

			// If ExportAll
			if (cmd.equals("exportAll")) {
				List<MasterOccupation> _occupations = _occupationLocalService.getMasterOccupations(0,
						_occupationLocalService.getMasterOccupationsCount());

				for (MasterOccupation _occupation : _occupations) {
					MasterOccupationCategory _occupationCategory = _occupationcategoryLocalService
							.getMasterOccupationCategory(_occupation.getMasterOccupationCategoryId());

					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_occupation.getMasterOccupationId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_occupation.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_occupationCategory.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_occupation.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (occupations.length < 1)
					return;

				for (long occupationId : occupations) {

					MasterOccupation _occupation = _occupationLocalService.getMasterOccupation(occupationId);
					MasterOccupationCategory _occupationCategory = _occupationcategoryLocalService
							.getMasterOccupationCategory(_occupation.getMasterOccupationCategoryId());

					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_occupation.getMasterOccupationId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_occupation.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_occupationCategory.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_occupation.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportOccupation.csv", bytes, contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	// Import Occupation
	public void importMasterOccupationCategory(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String filePath = "C:/liferayTmp/importOccupationCategory.csv";
		List<String> csvHeadLines = Arrays.asList("Occupation Category ID", "Name", "Active");

		try (FileOutputStream fOut = new FileOutputStream(filePath);) {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			InputStream is = uploadRequest.getFileAsStream("importFile");
			int i;
			while ((i = is.read()) != -1) {
				fOut.write(i);
			}

			CsvReader csvReader = new CsvReader(new FileReader(filePath));
			csvReader.setDelimiter(';');

			csvReader.readHeaders();
			String[] headers = csvReader.getHeaders();
			if (!Arrays.asList(headers).containsAll(csvHeadLines)) {
				throw new RuntimeException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterCountry.class.getName(),
					actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				Long occupationId = null;
				String name;
				int active;

				String occupationIdVal = csvReader.get("Occupation Category ID");
				if (occupationIdVal != null && !occupationIdVal.equals(""))
					occupationId = Long.parseLong(occupationIdVal);

				String nameVal = csvReader.get("Name");
				if (nameVal == null || nameVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Prefix.");
					continue;
				} else {
					name = nameVal;
				}

				String activeCurrColVal = csvReader.get("Active");
				if (activeCurrColVal == null || Integer.parseInt(activeCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Active.");
					continue;
				} else {
					active = Integer.parseInt(activeCurrColVal);
				}

				// Insert all evaluated data to database
				if (occupationId != null) {
					try {
						_occupationcategoryLocalService.updateMasterOccupationCategory(occupationId, name, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-update-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/occupation_category/list.jsp");
					}
				} else {
					try {
						_occupationcategoryLocalService.addMasterOccupationCategory(name, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/master/occupation_category/list.jsp");
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", "/master/occupation_category/list.jsp");

		} catch (Exception e) {
			log.info(e);
		}
	}

	// Export Occupation Category
	private void exportOccupationCategory(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			long[] occupations = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("Occupation Category ID", "Name", "Active");

			String COMMA = ";";
			StringBundler sb = new StringBundler();
			for (String columnName : csvHeadLines) {
				sb.append(getCSVFormattedValue(String.valueOf(columnName)));
				sb.append(COMMA);
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);

			// If ExportAll
			if (cmd.equals("exportAll")) {
				List<MasterOccupationCategory> _occupations = _occupationcategoryLocalService
						.getMasterOccupationCategories(0,
								_occupationcategoryLocalService.getMasterOccupationCategoriesCount());

				for (MasterOccupationCategory _occupation : _occupations) {
					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_occupation.getMasterOccupationCategoryId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_occupation.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_occupation.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (occupations.length < 1)
					return;

				for (long occupationId : occupations) {

					MasterOccupationCategory _occupation = _occupationcategoryLocalService
							.getMasterOccupationCategory(occupationId);

					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_occupation.getMasterOccupationCategoryId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_occupation.getName())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_occupation.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportOccupationCategory.csv", bytes,
					contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	private boolean _setGuestPermission(ThemeDisplay themeDisplay, String name, long primKey) {
		Map<Long, String[]> roleIdsToActionIds = new HashMap<>();
		roleIdsToActionIds.put(
				RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), RoleConstants.GUEST).getRoleId(),
				new String[] { ActionKeys.VIEW });

		try {
			ResourcePermissionLocalServiceUtil.setResourcePermissions(themeDisplay.getCompanyId(), name,
					ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(primKey), roleIdsToActionIds);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean _exists(ThemeDisplay themeDisplay, long folderId, String curFileName) {
		try {
			FileEntry tempFileEntry = DLAppLocalServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), folderId,
					curFileName);

			if (tempFileEntry != null) {
				return true;
			}

			return false;
		} catch (PortalException portalException) {
			return false;
		}
	}

	private void _validateFile(String fileName, String contentType, long size) throws PortalException {

		long blogsImageMaxSize = _IMAGE_MAX_SIZE;

		if ((blogsImageMaxSize > 0) && (size > blogsImageMaxSize)) {
			throw new EntryImageSizeException();
		}

		Set<String> extensions = MimeTypesUtil.getExtensions(contentType);

		boolean validContentType = Stream.of(_IMAGE_EXTENSIONS)
				.anyMatch(extension -> extension.equals(StringPool.STAR) || extensions.contains(extension));

		if (!validContentType) {
			throw new EntryImageNameException("Invalid image for file name " + fileName);
		}
	}

	public String getConfig(String key) {
		String result = StringPool.BLANK;

		try {
			String currentDir = System.getProperty("catalina.base");
			String filePath = currentDir + "/../agency-portal.json";

			JsonElement jsonElement = JsonParser.parseReader(new FileReader(filePath));
			JsonObject jsonObject = jsonElement.getAsJsonObject();

			if (Validator.isNotNull(jsonObject))
				result = jsonObject.get(key).toString().replace("\"", "");
		} catch (Exception e) {
			log.info(e);
		}

		return result;
	}

	/**
	 * Call API with body payload JSON
	 * 
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 */
	public JSONObject hitAPI(String url, String payload, String token) throws Exception {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		String line = StringPool.BLANK;
		StringBuilder responseBody = new StringBuilder();
		int responseCode = 0;

		try {
			URL requestUrl = new URL(url);
//			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
			HttpURLConnection connection = null;

			if (requestUrl.getProtocol().equalsIgnoreCase("https")) {
				HttpsURLConnection httpsConnection = (HttpsURLConnection) requestUrl.openConnection();

//				httpsConnection.setHostnameVerifier((hostname, session) -> true);
				httpsConnection.setHostnameVerifier(new HostnameVerifier() {
					@Override
					public boolean verify(String requestedHost, SSLSession remoteServerSession) {
						return requestedHost.equalsIgnoreCase(remoteServerSession.getPeerHost());
					}
				});

				SSLContext sslContext = SSLContext.getInstance("TLS");
				sslContext.init(null, new TrustManager[] { new X509TrustManager() {
					public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
					}

					public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
					}

					public X509Certificate[] getAcceptedIssuers() {
						return null; // new X509Certificate[0];
					}
				} }, new SecureRandom());
//				TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//                trustManagerFactory.init((KeyStore) null);
//                
//                SSLContext sslContext = SSLContext.getInstance("TLS");
//                sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());

				httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());

				connection = httpsConnection;
			} else {
				connection = (HttpURLConnection) requestUrl.openConnection();
			}

			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "application/json");

			connection.setRequestProperty("x-api-key", token); // Set Authorization header

			connection.setConnectTimeout(60000);
			connection.setReadTimeout(60000);
			connection.setDoOutput(true);

			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(payload.getBytes());
			outputStream.flush();
			outputStream.close();

			if (connection.getResponseCode() == 200) {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((line = bufferedReader.readLine()) != null) {
					responseBody.append(line);
				}
				bufferedReader.close();
			} else {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while ((line = bufferedReader.readLine()) != null) {
					responseBody.append(line);
				}
				bufferedReader.close();
			}

			responseCode = connection.getResponseCode();
		} catch (IOException e) {
			log.info(e);
		}

		_response.put("statusCode", responseCode);
		_response.put("response", responseBody.toString());

		return _response;
	}

	private static final Object[] _IMAGE_EXTENSIONS = { ".gif", ".jpeg", ".jpg", ".png", ".svg" };
	private static final long _IMAGE_MAX_SIZE = 5242880;
	private static final Log log = LogFactoryUtil.getLog(MasterAdminPortlet.class);

	@Reference
	private MasterCountryLocalService _masterCountryLocalService;

	@Reference
	private MasterCurrencyLocalService _masterCurrencyLocalService;

	@Reference
	private BlacklistCustomerLocalService _blacklistCustomerLocalService;

	@Reference
	private PromocodesLocalService _promocodesLocalService;

	@Reference
	private MasterProvinceLocalService _masterProvinceLocalService;

	@Reference
	private MasterCityLocalService _masterCityLocalService;

	@Reference
	private IndustryCategoryLocalService _industryCategoryLocalService;

	@Reference
	private IndustryLocalService _industryLocalService;


	@Reference
	private JobPositionLocalService _jobPositionLocalService;

	@Reference
	private MasterBankLocalService _masterBankLocalService;

	@Reference
	private PaymentChannelLocalService _paymentChannelLocalService;

	@Reference
	private PaymentChannelTenorLocalService _paymentChannelTenorLocalService;

	@Reference
	private ReferenceNumberLocalService _referenceNumberLocalService;

	@Reference
	private MasterOccupationCategoryLocalService _occupationcategoryLocalService;

	@Reference
	private MasterOccupationLocalService _occupationLocalService;

	@Reference
	private CompanyTypeLocalService _companyTypeLocalService;

	@Reference
	private MasterBranchLocalService _masterBranchLocalService;

	@Reference
	private MasterGlobalVariableLocalService _masterGlobalVariableLocalService;

	@Reference
	private MasterPromoCodeLocalService _masterPromoCodeLocalService;

	@Reference
	private ItemSelector _itemSelector;

	@Reference
	private UniqueFileNameProvider _uniqueFileNameProvider;
}
