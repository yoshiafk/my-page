package com.mypage.product.pet.application;

import com.google.gson.Gson;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.MasterProvince;
import com.mypage.admin.product.model.PetPlan;
import com.mypage.admin.product.model.PetRate;
import com.mypage.admin.product.model.PetRemarks;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.service.MasterProvinceLocalServiceUtil;
import com.mypage.admin.product.service.PetPlanLocalService;
import com.mypage.admin.product.service.PetPlanLocalServiceUtil;
import com.mypage.admin.product.service.PetRateLocalService;
import com.mypage.admin.product.service.PetRemarksLocalService;
import com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalServiceUtil;
import com.mypage.leads.model.Customer;
import com.mypage.leads.model.DetailPet;
import com.mypage.leads.model.Leads;
import com.mypage.leads.service.CustomerLocalServiceUtil;
import com.mypage.leads.service.DetailPetLocalService;
import com.mypage.leads.service.DetailPetLocalServiceUtil;
import com.mypage.leads.service.LeadsLocalServiceUtil;
import com.mypage.leads.service.PaymentLocalServiceUtil;
import com.mypage.product.pet.helpers.EncryptionHelper;
import com.mypage.product.pet.helpers.MypageHelpers;
import com.mypage.product.pet.helpers.Uploader;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserLocalServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/api/pet",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=PetInsurance.Rest", "auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true" }, service = Application.class)
public class PetApplication extends Application {
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	// TOKEN UNTUK IFRAME
	@GET
	@Path("/show")
	@Produces("application/json")
	public String showAction(@QueryParam("a") String params) throws PortletException, IOException {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		try {
			EncryptionHelper encryptionHelper = new EncryptionHelper();

			String _secureToken = EncryptionHelper.generateSecureToken(32);

			@SuppressWarnings("static-access")
			String paramsDecoded = URLDecoder.decode(params, "UTF-8");
			String param = encryptionHelper.decrypt(paramsDecoded);

			String[] paramSplit = param.split("\\|");

			String deptCode = paramSplit[1];

			AgentToken _agentToken = AgentTokenLocalServiceUtil.getAgentTokenByDeptCode(deptCode);

			if (!Validator.isNull(_agentToken)) {
				long agentTokenId = _agentToken.getAgentTokenId();
				_agentToken = AgentTokenLocalServiceUtil.editAgentToken(agentTokenId, deptCode, _secureToken, 1);
			} else {
				_agentToken = AgentTokenLocalServiceUtil.addAgentToken(deptCode, _secureToken, 1);
			}

			@SuppressWarnings("static-access")
			String token = encryptionHelper.encrypt(_secureToken);

			_data.put("Token", token);

			_response.put("Status", 1);
			_response.put("Data", _data);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return _response.toString();
	}

	// CALCULATE
	@POST
	@Path("/calculate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public String calculate(String request) throws JSONException {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		JSONObject params;

		try {
			params = JSONFactoryUtil.createJSONObject(request);

			String promoCode = params.getString("PromoCode");
			long petPlanId = params.getLong("Plan");

			double totalPremi = 0;
			double basicPrice = 0;
			double price = 0;
			double adminPrice = 0;
			double commission = 0;
			double premiumSummary = 0;
			double discount = 0;
			double discountAmount = 0;
			String productCode = "PET";

			JSONObject limits = JSONFactoryUtil.createJSONObject();
			limits.put("LimitDisability", params.getDouble("LimitDisability", 0));
			limits.put("LimitMedical", params.getDouble("LimitMedical", 0));
			limits.put("LimitThirdParty", params.getDouble("LimitThirdParty", 0));
			limits.put("LimitCustody", params.getDouble("LimitCustody", 0));

			// get plan
			PetPlan plan = _petPlanLocalService.searchPetPlanId(petPlanId);
			if (Validator.isNull(plan)) {
//				throw new NoSuchPetPlanException("Plan not found");
				return errorMessage("Plan not found").toString();
			}

			// get remarks
			List<PetRemarks> remarks = _petRemarksLocalService.getPetRemarks();

			for (PetRemarks remark : remarks) {
				PetRate rate = _petRateLocalService.searchByPetPlanAndPetRemarks(plan.getPetPlanId(),
						remark.getPetRemarksId());
				long limit = 0;
				try {
					limit = (long) plan.getClass().getMethod("get" + remark.getCode()).invoke(plan);

					if (plan.getCustomPlan() == 1 && limits.getDouble(remark.getCode()) > 0) {
						limit = (long) limits.getDouble(remark.getCode());
					}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
					return errorMessage("Plan remarks tidak ditemukan").toString();
				}

				totalPremi += limit * Double.parseDouble(rate.getRate());
			}

			// Load product configuration
			ProductConfiguration _productConfig = ProductConfigurationLocalServiceUtil.getConfigByCode(productCode);
			if (Validator.isNull(_productConfig)) {
				return errorMessage("Data Configuration not found").toString();
			}

			// disini logic untuk promocode, dilewat dulu

			// commision
			commission = _productConfig.getCommission();

			// set admin price
			adminPrice = _productConfig.getPolicyCostIDR() + _productConfig.getStampdutyIDR();

			// set total
			basicPrice = totalPremi;
			price = Math.round(basicPrice - (basicPrice * discount / 100)) + adminPrice;

			premiumSummary = basicPrice + adminPrice;

			// detail for sidebar
			JSONObject detail = JSONFactoryUtil.createJSONObject();
			detail.put("Premi", basicPrice);

			// set return
			_data.put("Price", price);
			_data.put("StampDuty", _productConfig.getStampdutyIDR());
			_data.put("PolicyCost", _productConfig.getPolicyCostIDR());
			_data.put("Premium", basicPrice);
			_data.put("PremiumSummary", premiumSummary);
			_data.put("NetPremium", price);
			_data.put("netPremiNew", price);
			_data.put("Commission", commission);
			_data.put("CommissionValue", commission);
			_data.put("PromoCode", promoCode);
			_data.put("Discount", discount);
			_data.put("DiscountAmount", discountAmount);
			_data.put("Tax", 0);
			_data.put("TaxValue", 0);
			_data.put("Adult", 0);
			_data.put("Child", 0);
			_data.put("Detail", detail);

			// Detail Pet
			int petAge = 0;
			JSONObject petDetail = JSONFactoryUtil.createJSONObject();
			petDetail.put("Age", petAge);
			petDetail.put("Premi", _data.get("Premium"));
			_data.put("PetDetail", petDetail);

			_response.put("Data", _data);
			_response.put("Message", "");
			_response.put("Status", 1);

		} catch (Exception e) {
			e.printStackTrace();
			return errorMessage(e.getMessage()).toString();
		}

		// return if no error in catch
		return _response.toString();
	}

	// KYC
	@POST
	@Path("/kyc")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public String kyc(String request, @Context HttpServletRequest httpServletRequest) {
		JSONObject _response = JSONFactoryUtil.createJSONObject();

		try {
			JSONObject params = JSONFactoryUtil.createJSONObject(request);
			JSONObject _data = JSONFactoryUtil.createJSONObject(); // data container untuk disimpan di leads,
																	// detailtravel dan customer
			ServiceContext serviceContext = ServiceContextFactory.getInstance(PetApplication.class.getName(),
					httpServletRequest);

			if (params.getString("StartDate").isEmpty()) {
				return errorMessage("Policy peride not selected").toString();
			}

			long userId = serviceContext.getUserId();
			long petPlanId = params.getLong("Plan");
			long LeadsId = 0;
			String leadsType = "kyc";
			Leads _leads = null;
			MypageUser _mypageUser = null;

			// validate request
			String errorValidate = validate(request);
			if (!errorValidate.equals("")) {
				return errorMessage(errorValidate).toString();
			}

			// quotation
			boolean quotation = !params.getString("Quotation").isEmpty() && params.getString("Quotation").equals("1")
					? true
					: false;
			if (quotation)
				leadsType = "quotation";

			// get leads, jika ada param Token di request
			if (!params.getString("Token").isEmpty()) {
				_leads = LeadsLocalServiceUtil.findByToken(params.getString("Token"));

				if (_leads != null) {
					LeadsId = _leads.getLeadsId();
				}
			}

			// set leads parent for quotation
			if (!params.getString("ParentToken").isEmpty()) {
				Leads leadsParent = LeadsLocalServiceUtil.findByToken(params.getString("ParentToken"));
				_data.put("LeadsParentId", leadsParent.getLeadsId());
			}

			// get mypage user jika LeadsId bukan 0 (ada token yang dikirim di param
			// request)
			if (LeadsId > 0) {
				if (_leads.getMypageUserId() > 0) {
					_mypageUser = MypageUserLocalServiceUtil.getMypageUser(_leads.getMypageUserId());

				}
			}

			// get plan
			PetPlan plan = _petPlanLocalService.searchPetPlanId(petPlanId);
//			System.out.println(plan);
			if (plan == null) {
				return errorMessage("Plan not found").toString();
			}

			// UPDATE/CREATE LEADS DATA
			SimpleDateFormat dateInputFormatter = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat dateInputFormatter2 = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat dateOutputFormatter = new SimpleDateFormat("yyyy-MM-dd");

			String formattedExpiredDate = "";
			String formattedStartDate = "";

			String startDate = params.getString("StartDate", null);
			String expiredDate = params.getString("ExpiredDate", null);
			if (startDate != null) {
//				startDate = startDate.replace("/", "-");
				Date _startDate = dateInputFormatter.parse(startDate);
				formattedStartDate = dateOutputFormatter.format(_startDate);

			}
			if (expiredDate != null) {
//				expiredDate = expiredDate.replace("/", "-");
				Date _expiredDate = dateInputFormatter.parse(expiredDate);
				formattedExpiredDate = dateOutputFormatter.format(_expiredDate);
			}

			if (LeadsId > 0) {
				_data.put("Token", params.getString("Token"));
			}

			_data.put("BussinesModel", "B2B"); // set default ke B2B
			_data.put("Channel", "Agent"); // Default diset Agent karena ini untuk B2B
			_data.put("ManagedBy", ""); // myPageUserId
			_data.put("LeadsType", leadsType);
			_data.put("Currency", "IDR");
			_data.put("ProductCode", "PET");
			_data.put("Active", 1);

			_data.put("PolicyStartDate", formattedStartDate);
			_data.put("PolicyEndDate", formattedExpiredDate);

			// Insured
			
			_data.put("isPEP", params.get("IsPEP"));
			
			_data.put("Name", params.get("Name"));

			String _leadDobDate = params.getString("Dob");
			if (!_leadDobDate.isEmpty()) {
				Date leadDobDate = dateInputFormatter2.parse(_leadDobDate);
				String formattedLeadDobDate = dateOutputFormatter.format(leadDobDate);
				_data.put("Dob", formattedLeadDobDate);
			}

			_data.put("BirthPlace", params.get("BirthPlace"));
			_data.put("IdNumber", params.get("IdNumber"));
			_data.put("Nationality", "Indonesia");
			_data.put("Address", params.get("Address"));
			_data.put("Province", params.get("Province"));
			_data.put("City", params.get("City"));
			_data.put("Zip", params.get("Zip"));
			_data.put("MobilePhone", params.get("MobilePhone"));
			_data.put("Email", params.get("Email"));
			_data.put("CommercialOffers", params.getInt("CommercialOffers"));

			// Calculate Premi
			JSONObject calc = JSONFactoryUtil.createJSONObject(calculate(request));
			JSONObject _calcData = calc.getJSONObject("Data");

			if (calc.getInt("Status") == 0) {
				return errorMessage(calc.getString("Message")).toString();
			}

			if (_calcData != null) {
				_data.put("PolicyCost", _calcData.getDouble("PolicyCost"));
				_data.put("StampDuty", _calcData.getDouble("StampDuty"));
				_data.put("Premium", _calcData.getDouble("Premium"));
				_data.put("NetPremium", _calcData.getDouble("NetPremium"));
				_data.put("Discount", _calcData.getDouble("Discount"));
				_data.put("DiscountAmount", _calcData.getDouble("DiscountAmount"));
				_data.put("Commission", _calcData.getDouble("Commission"));
			}

			// Save Leads
			Leads saveLeads = LeadsLocalServiceUtil.updateLeads(userId, quotation ? (long) 0 : LeadsId, _data,
					serviceContext);

			if (saveLeads == null) {
				return errorMessage("Failed save leads").toString();
			}

			// SAVE DETAIL PET
			double limitDisability = plan.getLimitDisability();
			double limitMedical = plan.getLimitMedical();
			double limitThirdParty = plan.getLimitThirdParty();
			double limitCustody = plan.getLimitCustody();

			_data.put("LeadsId", saveLeads.getLeadsId());
			_data.put("PlanId", petPlanId);
			_data.put("LimitDisability", limitDisability);
			_data.put("LimitMedical", limitMedical);
			_data.put("LimitThirdParty", limitThirdParty);
			_data.put("LimitCustody", limitCustody);
			_data.put("PetName", params.getString("PetName"));
			_data.put("PetType", params.getString("PetType"));

			String _petDobDate = params.getString("PetDob");
			if (!_petDobDate.isEmpty()) {
				Date petDobDate = dateInputFormatter.parse(_petDobDate);
				String formattedPetDobDate = dateOutputFormatter.format(petDobDate);
				_data.put("PetDob", formattedPetDobDate);
			}

			_data.put("PetGender", params.getString("PetGender"));
			_data.put("PetIdNumber", params.getString("PetIdNumber"));
			_data.put("PetIdNumberIssuing", params.getString("PetIdNumberIssuing"));
			_data.put("PetLocation", params.getString("PetLocation"));
			_data.put("PetVaccine", params.getInt("PetVaccine"));
			_data.put("PetAuthorizedCertificate", params.getInt("PetAuthorizedCertificate"));

			// save detail leads
			DetailPet detail = _detailPetLocalService.searchByLeadsId(saveLeads.getLeadsId());
			long detailId = 0;
			if (detail != null) {
				detailId = detail.getDetailPetId();
			}
			DetailPet _detailLeads = _detailPetLocalService.addDetail(userId, detailId, _data, serviceContext);

			// CUSTOMER
			// remove all child
			CustomerLocalServiceUtil.removeCustomerByLeadsIdAndProductCode(saveLeads.getLeadsId(), "PET");

			// add main child
			JSONObject _mainCustomer = JSONFactoryUtil.createJSONObject();
			_mainCustomer.put("LeadsId", saveLeads.getLeadsId());
			_mainCustomer.put("ProductCode", "PET");
			_mainCustomer.put("Relationship", "Tertanggung");
			_mainCustomer.put("Name", params.getString("Name"));
			_mainCustomer.put("Email", params.getString("Email"));
			_mainCustomer.put("MobilePhone", params.getString("MobilePhone"));
			_mainCustomer.put("IdNumber", params.getString("IdNumber"));
			_mainCustomer.put("Nationality", "Indonesia");
			_mainCustomer.put("Province", params.getString("Province"));
			_mainCustomer.put("City", params.getString("City"));
			_mainCustomer.put("Zip", params.getString("Zip"));
			_mainCustomer.put("Address", params.getString("Address"));
			Customer mainCustomer = CustomerLocalServiceUtil.addCustomer(userId, 0, _mainCustomer, serviceContext);

			if (saveLeads.getLeadsId() > 0) {
				JSONObject responseData = JSONFactoryUtil.createJSONObject();
				responseData.put("Token", saveLeads.getToken());
				if (quotation) {
					responseData.put("LeadsId", saveLeads.getLeadsId());
				}

				// jika ada managedby, maka masukan ke response, nantinya untuk ditampilkan di
				// sidebar frontend
				// logicnya dibalik, lihat arg di if
				if (params.getString("ManagedBy").isEmpty()) {
					JSONObject managedByObject = JSONFactoryUtil.createJSONObject();
					managedByObject.put("Code", "RFK12345"); // sementara dihardcode, ini harusnya ambil dari data agen
																// yang sedang login sekarang
					managedByObject.put("Name", "RIFKI"); // sementara dihardcode, ini harusnya ambil dari data agen
															// yang sedang login sekarang
					responseData.put("ManagedBy", managedByObject);
				}

				_response.put("Status", 1);
				_response.put("Data", responseData);
			} else {
				return errorMessage("Failed KYC").toString();
			}

		} catch (Exception e) {
			e.printStackTrace();

			_response.put("Status", 0);
			_response.put("Message", e.getMessage());
			return _response.toString();
		}

		return _response.toString();
	}

	// QUOTATION
	@POST
	@Path("/quotation")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public String quotation(String request, @Context HttpServletRequest httpServletRequest) throws JSONException {
		JSONObject _response = JSONFactoryUtil.createJSONObject();

//		long leadsId = 0;
		long leadsId = Long.valueOf("42947");
		Leads _leads = null;

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(PetApplication.class.getName(), httpServletRequest);
			
//			JSONObject params;
//			params = JSONFactoryUtil.createJSONObject(request);
//
//			if (!params.getString("t").isEmpty()) {
//				String _token = params.getString("t");
//				_leads = LeadsLocalServiceUtil.findByToken(_token);
//				if (_leads != null) {
//					leadsId = _leads.getLeadsId();
//				}
//			}
//			
			Leads quotationLeads = null;
			
			if(!Validator.isNull(_leads)) {
				quotationLeads = LeadsLocalServiceUtil.setLeadsType(leadsId, "quotation"); // set lead type to quotation
			}
			
//			MypagePDF currentPDF = new MypagePDF();
//			currentPDF.setServiceContext(serviceContext);
//			currentPDF.setLeads(Long.valueOf("52106"));
//			currentPDF.setType("quotation");
//			FileEntry pdf = currentPDF.generate();
			
//			JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticleByUrlTitle(serviceContext.getScopeGroupId(), "pet-email-quotation");
//
//			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//			DocumentBuilder db = dbf.newDocumentBuilder();
//			InputSource is = new InputSource();
//			is.setCharacterStream(new StringReader(journalArticle.getContent()));
//			Document doc = db.parse(is);
//			NodeList dynamicContent = doc.getElementsByTagName("dynamic-element");
//			String subject = dynamicContent.item(0).getTextContent();
//			String from = dynamicContent.item(1).getTextContent();
//			String to = dynamicContent.item(2).getTextContent();
//			String cc = dynamicContent.item(3).getTextContent();
//			String bcc = dynamicContent.item(4).getTextContent();
//			String emailTemplate = dynamicContent.item(5).getTextContent();
			
//			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(pdf.getFileEntryId());
//			InputStream inputStream = fileEntry.getContentStream();
//			File file = FileUtil.createTempFile(inputStream);
			
//			Map<String, String> replacements = new HashMap<>();
//			replacements.put("ReferenceNumber", _leads.getReferenceNumber());
//			replacements.put("AgentCode", _mypageUser.getCode());
//			replacements.put("CustName", _leads.getName());
//			replacements.put("CustGender", _leads.getGender().equals("M") ? "Laki-Laki" : "Perempuan");
//			replacements.put("InitialPeriod", dateFormat.format(_leads.getPolicyStartDate()));
//			replacements.put("FinalPeriod", dateFormat.format(_leads.getPolicyEndDate()));
//			replacements.put("Plan", _petPlan.getName());
//			replacements.put("TempURL", PortalUtil.getPortalURL(httpServletRequest) + "/web/guest/pet/-/quote/pet/continue/" + _leads.getTempCode());
//			replacements.put("AgentEmail", _user.getEmailAddress());
//			replacements.put("AgentMobilePhone", _mypageUser.getMobilePhone());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return _response.toString();
	}

	// SEND TO AXA API
	@POST
	@Path("/uploader")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public String uploader(String request) throws JSONException {

		try {
			JSONObject params;
			params = JSONFactoryUtil.createJSONObject(request);
			String payload = Uploader.createPayload(Long.valueOf("42947"));
			System.out.println("==================PAYLOAD====================");
			System.out.println(payload);
			System.out.println("==================PAYLOAD====================");

			JSONObject responseapi = Uploader.callAPI(payload);
//			System.out.println(responseapi);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _payload = JSONFactoryUtil.createJSONObject();
		return _response.toString();
	}

	// Process data to Pimcore and redirect to Pimcore payment page if success
	@POST
	@Path("/process")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public String process(String request) throws JSONException {

		MypageHelpers mypageHelpers = new MypageHelpers();
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		String pimcorePetKycURL = mypageHelpers.getConfig("com.mypage.product.pet.config.lrToPimcKycUrl");
		JSONObject params = JSONFactoryUtil.createJSONObject(request);
		String currentToken = params.getString("currentToken");
		String _payload = "";
		
		// agent token
		String renderToken = params.getString("rToken");
		String renderTokenEncoded = "";
		String renderTokenDecrypted = "";
		
        try {
            // Encode render token
            renderTokenEncoded = URLEncoder.encode(renderToken, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
		
		try {
			renderTokenDecrypted = EncryptionHelper.decryptOri(renderToken);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		AgentToken _currentAgentToken = AgentTokenLocalServiceUtil.getAgentTokenByToken(renderTokenDecrypted);
		String _agentDeptCode = _currentAgentToken.getDeptCode();

		Leads leads = LeadsLocalServiceUtil.findByToken(currentToken);
		DetailPet detailPet = DetailPetLocalServiceUtil.searchByLeadsId(leads.getLeadsId());

		SimpleDateFormat _dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

		Gson gson = new Gson();
		String payload = "";
		HashMap<String, Object> mainBodyPayload = new HashMap<>();
		mainBodyPayload.put("LId", String.valueOf(leads.getLeadsId()));
		mainBodyPayload.put("PdCode", "PI");
		mainBodyPayload.put("Code", _agentDeptCode);
		mainBodyPayload.put("Step1", "1");
		mainBodyPayload.put("Step1_2", "0");
		mainBodyPayload.put("Step2", "1");
		mainBodyPayload.put("Step3", "1");
		mainBodyPayload.put("Step4", "1");
		mainBodyPayload.put("Channel", "Agent");
		mainBodyPayload.put("BussinesModel", "B2B");
		mainBodyPayload.put("ManagedBy", "53135"); // ini harus pakai metode spt agencyportal, get agent id dulu saat
													// akses iframe
		mainBodyPayload.put("CommercialOffers", "1");
		mainBodyPayload.put("isPep", "0");
		mainBodyPayload.put("Name", leads.getName());
		mainBodyPayload.put("BirthPlace", leads.getBirthPlace());

		String dobFormatted = _dateFormatter.format(leads.getDob());
		mainBodyPayload.put("Dob", dobFormatted);

		mainBodyPayload.put("Gender", "M"); // ini di set default ke M. karena di frontend tidak ada opsi pilih gender.
											// perlu cek lebih lanjut

		mainBodyPayload.put("Nationality", leads.getNationality().equals("Indonesia") ? "WNI" : "WNA");
		mainBodyPayload.put("NationalityCountry", leads.getNationality());
		mainBodyPayload.put("Address", leads.getAddress());

		// nama province bukan id province di liferay
		try {
			MasterProvince masterProv = MasterProvinceLocalServiceUtil
					.getMasterProvince(Long.valueOf(leads.getProvince()));
			mainBodyPayload.put("Province", masterProv.getName());
		} catch (Exception e) {
			mainBodyPayload.put("Province", "");
		}

		mainBodyPayload.put("City", leads.getCity());
		mainBodyPayload.put("Zip", leads.getZip());
		mainBodyPayload.put("IdNumber", leads.getIdNumber());
		mainBodyPayload.put("KitasNumber", leads.getKitasNumber());
		mainBodyPayload.put("MobilePhone", leads.getMobilePhone());
		mainBodyPayload.put("Email", leads.getEmail());
		mainBodyPayload.put("Job", "482196"); // ini belum ada di table leads
		mainBodyPayload.put("JobOther", ""); // ini juga belum ada di table leads

		mainBodyPayload.put("PetName", detailPet.getPetName());
		mainBodyPayload.put("PetType", detailPet.getPetType());
		mainBodyPayload.put("PetGender", detailPet.getPetGender());
		String petDobFormatted = _dateFormatter.format(detailPet.getPetDob());
		mainBodyPayload.put("PetDob", petDobFormatted);
		mainBodyPayload.put("PetIdNumber", detailPet.getPetIdNumber());
		mainBodyPayload.put("PetIdNumberIssuing", detailPet.getPetIdNumberIssuing());
		mainBodyPayload.put("PetLocation", detailPet.getPetLocation());
		mainBodyPayload.put("PetAuthorizedCertificate", String.valueOf(detailPet.getPetAuthorizedCertificate()));
		mainBodyPayload.put("PetVaccine", String.valueOf(detailPet.getPetVaccine()));

		String policyStartDateFormatted = _dateFormatter.format(leads.getPolicyStartDate());
		String policyEndDateFormatted = _dateFormatter.format(leads.getPolicyEndDate());
		mainBodyPayload.put("StartDate", policyStartDateFormatted);
		mainBodyPayload.put("ExpiredDate", policyEndDateFormatted);

		PetPlan _plan = PetPlanLocalServiceUtil.fetchPetPlan(detailPet.getPlanId());

		mainBodyPayload.put("Plan", _plan.getPimcorePlanId()); // plan pimcore id

		mainBodyPayload.put("UserCustom", "0"); // ini nanti harus dicek lebih lanjut

		mainBodyPayload.put("Remarks1", ""); // ini nanti harus dicek lebih lanjut
		mainBodyPayload.put("Remarks2", ""); // ini nanti harus dicek lebih lanjut
		mainBodyPayload.put("Remarks3", ""); // ini nanti harus dicek lebih lanjut
		mainBodyPayload.put("Remarks4", ""); // ini nanti harus dicek lebih lanjut

		mainBodyPayload.put("Currency", leads.getCurrency());
		mainBodyPayload.put("StampDuty", String.valueOf(leads.getStampDuty()));
		mainBodyPayload.put("Premium", String.valueOf(leads.getPremium()));
		mainBodyPayload.put("PolicyCost", String.valueOf(leads.getPolicyCost()));
		mainBodyPayload.put("NetPremium", String.valueOf(leads.getNetPremium()));
		mainBodyPayload.put("PromoCode", String.valueOf(leads.getPromoCode()));
		mainBodyPayload.put("Discount", String.valueOf(leads.getDiscount()));
		mainBodyPayload.put("Commission", String.valueOf(leads.getCommission()));

		mainBodyPayload.put("UtmCampaign", "");
		mainBodyPayload.put("UtmMedium", "");
		mainBodyPayload.put("UtmSource", "");
		mainBodyPayload.put("UtmTerm", "");
		mainBodyPayload.put("ClickId", "");

		// base64 id photo
		FileEntry idPhotoFileEntry = null;
		try {
			idPhotoFileEntry = DLAppLocalServiceUtil.getFileEntry(leads.getIdPhotoFileEntryId());
			String idPhotoMimeType = idPhotoFileEntry.getMimeType();
			InputStream idPhotoInputStream = idPhotoFileEntry.getContentStream();
			byte[] bytes = new byte[idPhotoInputStream.available()];
			idPhotoInputStream.read(bytes);
			idPhotoInputStream.close();
			String idPhotoBase64 = Base64.encode(bytes);
			String _idPhotoBase64 = "data:" + idPhotoMimeType + ";base64," + idPhotoBase64;
			mainBodyPayload.put("IdPhoto", _idPhotoBase64);
		} catch (Exception e) {
			mainBodyPayload.put("IdPhoto", "");
			System.out.println(e.getMessage());
		}

		// base64 pet certificate
		FileEntry petCertificateFileEntry = null;
		try {
			petCertificateFileEntry = DLAppLocalServiceUtil.getFileEntry(detailPet.getPetIdNumberFileEntryId());
			String petCertificateMimeType = petCertificateFileEntry.getMimeType();
			InputStream petCertificateInputStream = petCertificateFileEntry.getContentStream();
			byte[] bytes = new byte[petCertificateInputStream.available()];
			petCertificateInputStream.read(bytes);
			petCertificateInputStream.close();
			String petCertificateBase64 = Base64.encode(bytes);
			String _petCertificateBase64 = "data:" + petCertificateMimeType + ";base64," + petCertificateBase64;
			mainBodyPayload.put("PetIdNumberFile", _petCertificateBase64);
		} catch (Exception e) {
			mainBodyPayload.put("PetIdNumberFile", "");
			System.out.println(e.getMessage());
		}

		// base64 pet photo
		FileEntry petPhotoFileEntry = null;
		try {
			petPhotoFileEntry = DLAppLocalServiceUtil.getFileEntry(detailPet.getPetPhotoFileEntryId());
			String petPhotoMimeType = petPhotoFileEntry.getMimeType();
			InputStream petPhotoInputStream = petPhotoFileEntry.getContentStream();
			byte[] bytes = new byte[petPhotoInputStream.available()];
			petPhotoInputStream.read(bytes);
			petPhotoInputStream.close();
			String petPhotoBase64 = Base64.encode(bytes);
			String _petPhotoBase64 = "data:" + petPhotoMimeType + ";base64," + petPhotoBase64;
			mainBodyPayload.put("PetPhoto", _petPhotoBase64);
		} catch (Exception e) {
			mainBodyPayload.put("PetPhoto", "");
			System.out.println(e.getMessage());
		}

		_payload = gson.toJson(mainBodyPayload);

		System.out.println(_payload);

		// Call API PIMCORE
		String line = StringPool.BLANK;
		StringBuilder responseBody = new StringBuilder();
		try {
			URL requestUrl = new URL(pimcorePetKycURL);
			HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("authorization", renderTokenEncoded);
			connection.setDoOutput(true);

			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(_payload.getBytes());
			outputStream.flush();
			outputStream.close();

//            System.out.println(connection.getResponseCode());

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

//            System.out.println(responseBody);

			if (connection.getResponseCode() == 200) {
				_response.put("status", "1");
				_response.put("response", responseBody);
			} else {
				_response.put("status", "0");
				_response.put("response", responseBody);
			}

		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
			_response.put("status", "0");
			_response.put("response", responseBody);
		}
		
		// invalidate current agent token
		AgentTokenLocalServiceUtil.setAgentTokenToInvalid(_currentAgentToken.getAgentTokenId());

		return _response.toString();
	}

	// Notification - setelah pembayaran berhasil, maka pimcore akan hit kesini
	// untuk update payment status, reference number dll.
	@POST
	@Path("/notification")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public String notification(String request, @Context HttpServletRequest httpServletRequest) {
		JSONObject _response = JSONFactoryUtil.createJSONObject();

		try {
			JSONObject params = JSONFactoryUtil.createJSONObject(request);
			JSONObject paramsPayment = params.getJSONObject("Payment");
			JSONObject paramsLeads = params.getJSONObject("Leads");
//			System.out.println(params);

			JSONObject _data = JSONFactoryUtil.createJSONObject(); // data container untuk disimpan di leads

			JSONObject dataPayment = JSONFactoryUtil.createJSONObject();

			dataPayment.put("Amount", paramsPayment.get("Amount"));
			dataPayment.put("TransactionDateTime", paramsPayment.get("TransactionDateTime"));
			dataPayment.put("PaymentDateTime", paramsPayment.get("PaymentDateTime"));
			dataPayment.put("PaymentStatus", paramsPayment.get("PaymentStatus"));
			dataPayment.put("TransactionId", paramsPayment.getString("TransactionId"));

			PaymentLocalServiceUtil.addPayment(0, 0, dataPayment, null);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(PetApplication.class.getName(),
					httpServletRequest);
			JSONObject dataUpdateForLeads = JSONFactoryUtil.createJSONObject();
			dataUpdateForLeads.put("LeadsType", "leads");
			dataUpdateForLeads.put("ReferenceNumber", paramsLeads.get("ReferenceNumber"));

//			System.out.println(dataUpdateForLeads);

			String lidDecrypt = EncryptionHelper.decrypt(params.getString("LIdToken"));
			String[] lidDecryptSplit = lidDecrypt.split("\\|");
//			long leadsId = Long.valueOf(lidDecryptSplit[1]);
			long leadsId = Long.valueOf("53103");
			long userId = serviceContext.getUserId();

			Leads saveLeads = LeadsLocalServiceUtil.updateLeads(userId, leadsId, dataUpdateForLeads, serviceContext);
			System.out.println("==================UPDATE LEADS====================");
			System.out.println(saveLeads);
			System.out.println("==================UPDATE LEADS====================");

			// Hit to Care API
			String payload = Uploader.createPayload(saveLeads.getLeadsId());

			System.out.println("==================HIT TO API CARE PAYLOAD====================");
			System.out.println(payload);
			System.out.println("==================HIT TO API CARE PAYLOAD====================");

			JSONObject responseapi = Uploader.callAPI(payload);
			System.out.println(responseapi);

			// if failed, set flag in leads here....

		} catch (Exception e) {
			e.printStackTrace();

			_response.put("Status", 0);
			_response.put("Message", e.getMessage());
			return _response.toString();
		}
		return _response.toString();
	}

	private String validate(String request) {
		String error = "";
		JSONObject params;
		try {
			params = JSONFactoryUtil.createJSONObject(request);

			// check plan
			if (!checkInputString(params.getString("Plan"))) {
				// get plan
				PetPlan plan = _petPlanLocalService.searchPetPlanId(params.getLong("Plan"));

				if (plan == null) {
					throw new PortalException("Plan Not Valid");
				}
			}

			// check LimitMedical
			if (!checkInputString(params.getString("LimitMedical"))) {
				if (params.getLong("LimitMedical", 0) == 0 || params.getLong("LimitMedical", 0) < 500000) {
					throw new PortalException("Boleh nol, tapi jika diisi minimal 500rb");
				}
			}

			// check LimitCustody
			if (!checkInputString(params.getString("LimitCustody"))) {
				if (params.getLong("LimitCustody", 0) == 0 || params.getLong("LimitCustody", 0) < 250000) {
					throw new PortalException("Boleh nol, tapi jika diisi minimal 250rb");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

			error = e.getMessage();
			return error;
		}

		return error;
	}

	private static boolean checkInputString(String input) {
		return (input == null || input.trim().length() == 0);
	}

	private static JSONObject errorMessage(String message) {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		_response.put("Status", 0);
		_response.put("Message", message);

		return _response;
	}

	@Reference
	private PetPlanLocalService _petPlanLocalService;
	@Reference
	private PetRemarksLocalService _petRemarksLocalService;
	@Reference
	private PetRateLocalService _petRateLocalService;
	@Reference
	private DetailPetLocalService _detailPetLocalService;
	@Reference
	private JournalArticleLocalService _journalArticleLocalService;
//	@Reference
//	private AgentTokenLocalService _agentTokenLocalService;
}
