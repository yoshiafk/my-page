<%@page import="java.util.stream.Collectors"%>
<%@page import="java.time.Period"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mypage.leads.service.DetailInternationalTravelLocalServiceUtil"%>
<%@page import="com.mypage.leads.model.DetailInternationalTravel"%>
<%@page import="com.mypage.leads.service.CustomerLocalServiceUtil"%>
<%@page import="com.mypage.leads.model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.mypage.leads.service.LeadsLocalServiceUtil"%>
<%@page import="com.mypage.leads.model.Leads"%>
<%@ include file="init.jsp"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@page import="com.mypage.product.it2.helper.EncryptionHelper" %>
<%
LocalDateTime timestampForJSURI = LocalDateTime.now();
DateTimeFormatter formatterForJSURI = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
String numericTimestamptimestampForJSURI = timestampForJSURI.format(formatterForJSURI);
String aParam = (String) renderRequest.getAttribute("a");
String bParam = (String) renderRequest.getAttribute("b");
%>

<% ProductConfiguration _product = ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"); %>
<% String managedBy = (String)renderRequest.getAttribute("managedBy"); %>
<% String managedById = (String)renderRequest.getAttribute("managedById"); %>
<% String businessModel = (String)renderRequest.getAttribute("businessModel"); %>
<% boolean continueQuotation = (boolean)renderRequest.getAttribute("continueQuotation"); %>

<% long lId = Long.valueOf((long)renderRequest.getAttribute("lId")); %>

<% String quouteId = (String)renderRequest.getAttribute("quouteId"); %>
<% String promoCode = (String)renderRequest.getAttribute("pc"); %>
<% String tokenLimiter = (String)renderRequest.getAttribute("tokenLimiter"); %>

<% int repeatOrder = Integer.valueOf((int)renderRequest.getAttribute("repeatOrder")); %>
<% int modifyQuotation = Integer.valueOf((int)renderRequest.getAttribute("modifyQuotation")); %>

<% String _portalURL = themeDisplay.getPortalURL(); %>

<% String utmSource = (String) renderRequest.getAttribute("utm_source"); %>

<%
	Leads _leads = null;
	DetailInternationalTravel _detailInternationalTravel = null;
	
	JSONObject payloadData = null;
	String Token = null;
	
	boolean docPhotoComplete = true;
	List<Boolean> docPhotoEmptyStat = new ArrayList<>();
	
	List<Customer> customers = CustomerLocalServiceUtil.findByLeadsId(lId);
	List<Object> _additionalBenefit = new ArrayList<Object>();
%>
				
<%
	if(continueQuotation) {
		
		if(lId > 0) {
				
			_leads = LeadsLocalServiceUtil.getLeads(lId);
			
			if(_leads != null) {
				
				if(_leads.getIdPhotoFileEntryId() < 1 && _leads.getPhotoFileUrl().isEmpty()) {
					docPhotoEmptyStat.add(true);
				}
				
				Token = _leads.getToken();
				_detailInternationalTravel = DetailInternationalTravelLocalServiceUtil.findByLeadsId(lId);
			
			    JSONObject policyholder = JSONFactoryUtil.createJSONObject();
		        policyholder.put("_ispep", _leads.getIsPep());
		        policyholder.put("_name", _leads.getName());
		        policyholder.put("_ktppaspor", _leads.getPassportNumber());
		        policyholder.put("_dob", _leads.getDob());
		        policyholder.put("_pdob", _leads.getBirthPlace());
		        policyholder.put("_gender", _leads.getGender());
		        policyholder.put("_kodenegara", _leads.getCountryCode());
		        policyholder.put("_hp", _leads.getMobilePhone());
		        policyholder.put("_negara", _leads.getNationality());
		        policyholder.put("_job", _leads.getJob());
		        policyholder.put("_otherjob", _leads.getJobOther());
		        
		        String nationality = _leads.getNationality();
				if (nationality.equalsIgnoreCase("indonesia")) {
					policyholder.put("_ktpkitas", _leads.getIdNumber());
				} else {
					policyholder.put("_ktpkitas", _leads.getKitasNumber());
				}
		        
		        policyholder.put("_age", _leads.getAge());
		        policyholder.put("_statuskawin", _leads.getMaritalStatus());
		        policyholder.put("_telepon", _leads.getPhone());
		        policyholder.put("_email", _leads.getEmail());
		        policyholder.put("_kodepos", _leads.getZip());
		        policyholder.put("_alamat", _leads.getAddress());
		        
		        if (_leads.getIdPhotoFileEntryId() > 0) {
			        policyholder.put("_photoUrl", _portalURL + "/" + EncryptionHelper.encrypt(String.valueOf(_leads.getIdPhotoFileEntryId())));
			        policyholder.put("_photoFileEntryId",  _leads.getIdPhotoFileEntryId());
		        }
		        
			    JSONArray insuredList = JSONFactoryUtil.createJSONArray();
			    for (Customer customer : customers) {
			    	
					if(customer.getIdPhotoFileEntryId() < 1 && customer.getPhotoFileUrl().isEmpty()) {
						docPhotoEmptyStat.add(true);
					}
			    	
			        JSONObject insured = JSONFactoryUtil.createJSONObject();

			        insured.put("_ispep", customer.getIsPep());
			        insured.put("_name", customer.getName());
			        insured.put("_ktppaspor", customer.getPassportNumber());
			        insured.put("_dob", customer.getDob());
			        insured.put("_pdob", customer.getBirthPlace());
			        insured.put("_gender", customer.getGender());
			        insured.put("_kodenegara", customer.getCountryCode());
			        insured.put("_hp", customer.getMobilePhone());
			        insured.put("_negara", customer.getNationality());
			        insured.put("_job", customer.getJob());
			        insured.put("_otherjob", customer.getJobOther());
			        
			        String nationalityins = customer.getNationality();
					if (nationalityins.equalsIgnoreCase("indonesia")) {
						insured.put("_ktpkitas", customer.getIdNumber());
					} else {
						insured.put("_ktpkitas", customer.getKitasNumber());
					}
			        
			        
			        insured.put("_age", customer.getAge());
			        insured.put("_statuskawin", customer.getMaritalStatus());
			        insured.put("_telepon", customer.getPhone());
			        insured.put("_email", customer.getEmail());
			        insured.put("_kodepos", customer.getZip());
			        insured.put("_alamat", customer.getAddress());
			        
			        if (customer.getIdPhotoFileEntryId() > 0) {
				        insured.put("_photoUrl", _portalURL + "/" + EncryptionHelper.encrypt(String.valueOf(customer.getIdPhotoFileEntryId())));
				        insured.put("_photoFileEntryId",  customer.getIdPhotoFileEntryId());
			        }
			        
			        insured.put("_relationship", customer.getRelationship());
			        insuredList.put(insured);
			    }
			    
						
						// Separate the list into listChildren and listAdult using Java Streams
						List<Customer> listChildren = new ArrayList<>();
						List<Customer> listAdult = new ArrayList<>();

						int totalAdults = _detailInternationalTravel.getAdult();
						int totalChildren = _detailInternationalTravel.getChild();
						String travellerType = _detailInternationalTravel.getTravellerType();
						
						if ("Duo".equalsIgnoreCase(travellerType)) {
							Customer utama = customers.stream()
					                .filter(cus -> "Pasangan".equalsIgnoreCase(cus.getRelationship()) || "Tertanggung Utama".equalsIgnoreCase(cus.getRelationship()))
					                .collect(Collectors.toList()).get(0);
					    
							Customer kerabatTeman = customers.stream()
							        .filter(cus -> "Kerabat".equalsIgnoreCase(cus.getRelationship()) || "Teman".equalsIgnoreCase(cus.getRelationship()))
							        .collect(Collectors.toList()).get(0);

							
							if (totalAdults == 2) {
						        // Semua menjadi dewasa
						        
						    	listAdult.add(utama); 
						    	listAdult.add(kerabatTeman);
						        
						    } else if (totalChildren == 1 && totalAdults == 1) {
						    	
						        listAdult.add(utama);   // Data pertama menjadi dewasa
						        listChildren.add(kerabatTeman); // Data kedua menjadi anak
						    }
						} else {
						    listChildren = customers.stream()
						            .filter(cus -> "Anak".equalsIgnoreCase(cus.getRelationship()) || "Anak / Pelajar".equalsIgnoreCase(cus.getRelationship()))
						            .collect(Collectors.toList());

						    listAdult = customers.stream()
						            .filter(cus -> "Pasangan".equalsIgnoreCase(cus.getRelationship()) || "Tertanggung Utama".equalsIgnoreCase(cus.getRelationship()))
						            .collect(Collectors.toList());
						}      
		        
		
			    // Bangun JSONArray untuk insured
			    JSONArray adultList = JSONFactoryUtil.createJSONArray();
			    for (Customer customer : listAdult) {
			    	
			        JSONObject adult = JSONFactoryUtil.createJSONObject();
		
			        adult.put("_ispep", customer.getIsPep());
			        adult.put("_name", customer.getName());
			        adult.put("_ktppaspor", customer.getPassportNumber());
			        adult.put("_dob", customer.getDob());
			        adult.put("_pdob", customer.getBirthPlace());
			        adult.put("_gender", customer.getGender());
			        adult.put("_kodenegara", customer.getCountryCode());
			        adult.put("_hp", customer.getMobilePhone());
			        adult.put("_negara", customer.getNationality());
			        adult.put("_job", customer.getJob());
			        adult.put("_otherjob", customer.getJobOther());
			        
			        String nationalityins = customer.getNationality();
					if (nationalityins.equalsIgnoreCase("indonesia")) {
						adult.put("_ktpkitas", customer.getIdNumber());
					} else {
						adult.put("_ktpkitas", customer.getKitasNumber());
					}
			        
					adult.put("_age", customer.getAge());
					adult.put("_statuskawin", customer.getMaritalStatus());
					adult.put("_telepon", customer.getPhone());
					adult.put("_email", customer.getEmail());
					adult.put("_kodepos", customer.getZip());
					adult.put("_alamat", customer.getAddress());
					
					if (customer.getIdPhotoFileEntryId() > 0) {
						adult.put("_photoUrl", _portalURL + "/" + EncryptionHelper.encrypt(String.valueOf(customer.getIdPhotoFileEntryId())));
						adult.put("_photoFileEntryId",  customer.getIdPhotoFileEntryId());
					}
					
					adult.put("_relationship", customer.getRelationship());
		
					adultList.put(adult);
			        
			    }
			   
			    
			 // Bangun JSONArray untuk insured
			    JSONArray childList = JSONFactoryUtil.createJSONArray();
			    for (Customer customer : listChildren) {
			    	
			        JSONObject child = JSONFactoryUtil.createJSONObject();
		
			        child.put("_ispep", customer.getIsPep());
			        child.put("_name", customer.getName());
			        child.put("_ktppaspor", customer.getPassportNumber());
			        child.put("_dob", customer.getDob());
			        child.put("_pdob", customer.getBirthPlace());
			        child.put("_gender", customer.getGender());
			        child.put("_kodenegara", customer.getCountryCode());
			        child.put("_hp", customer.getMobilePhone());
			        child.put("_negara", customer.getNationality());
			        child.put("_job", customer.getJob());
			        child.put("_otherjob", customer.getJobOther());
			        
			        String nationalityins = customer.getNationality();
					if (nationalityins.equalsIgnoreCase("indonesia")) {
						child.put("_ktpkitas", customer.getIdNumber());
					} else {
						child.put("_ktpkitas", customer.getKitasNumber());
					}
			        
					child.put("_age", customer.getAge());
					child.put("_statuskawin", customer.getMaritalStatus());
					child.put("_telepon", customer.getPhone());
					child.put("_email", customer.getEmail());
					child.put("_kodepos", customer.getZip());
					child.put("_alamat", customer.getAddress());
					
					if (customer.getIdPhotoFileEntryId() > 0) {
						child.put("_photoUrl", _portalURL + "/" + EncryptionHelper.encrypt(String.valueOf(customer.getIdPhotoFileEntryId())));
						child.put("_photoFileEntryId",  customer.getIdPhotoFileEntryId());
					}
					
					child.put("_relationship", customer.getRelationship());
		
					childList.put(child);
			        
			    }
			    
			    payloadData = JSONFactoryUtil.createJSONObject();
			    payloadData.put("policyholder", policyholder);
			    payloadData.put("insured", insuredList);
			    
			    payloadData.put("adults", adultList);
			    payloadData.put("children", childList);
			    
			    payloadData.put("travellerType", _detailInternationalTravel.getTravellerType());
			    payloadData.put("AdultTotal", _detailInternationalTravel.getAdult());
			    payloadData.put("ChildTotal", _detailInternationalTravel.getChild());
			
			    // ADDITIONAL BENEFITS
			    String additionalBenefits = _detailInternationalTravel.getListBenefitId();    
			    
			    JSONArray additionalBenefitArray = JSONFactoryUtil.createJSONArray(additionalBenefits); 
			    
			    if (additionalBenefitArray.length() > 0) {
				      for (int i = 0; i < additionalBenefitArray.length(); i++) {
				            int benefitId = additionalBenefitArray.getInt(i);
				            Benefit benefit = BenefitLocalServiceUtil.fetchBenefit(benefitId);

				            if (benefit != null) {
				                _additionalBenefit.add(String.valueOf(benefit.getExternalCode()));
				            }
				        }
				  }
			}
		}
	}
%>

<%
	List<BenefitType> _allBenefitTypes = BenefitTypeLocalServiceUtil.getAllBenefitTypes();
%>

<%
	String _datainfo = (String) renderRequest.getAttribute("_data-info");
	String _dataItemUtama = (String) renderRequest.getAttribute("item-utama");
	String _dataFiturUtama = (String) renderRequest.getAttribute("fitur-utama");
	String _dataItemManfaat = (String) renderRequest.getAttribute("item-manfaat");
	String _dataItemResiko = (String) renderRequest.getAttribute("item-resiko");
	String _dataItemBiaya = (String) renderRequest.getAttribute("item-biaya");
	String _dataItemKecuali = (String) renderRequest.getAttribute("item-pengecualian");
	String _dataItemSyarat = (String) renderRequest.getAttribute("item-persyaratan");
	String _dataItemSimulasi = (String) renderRequest.getAttribute("item-simulasi");
	String _dataItemInfoTambahan = (String) renderRequest.getAttribute("item-info-tambahan");
	String _dataItemCatatanPenting = (String) renderRequest.getAttribute("item-catatan-penting");
	String _dataItemDisclaimer = (String) renderRequest.getAttribute("item-disclaimer");

	String _riplayVersi = (String) renderRequest.getAttribute("riplay-version");
	String capitalizedVersionRiplay = _riplayVersi.substring(0, 1).toUpperCase() + _riplayVersi.substring(1).toLowerCase();

	String portalURL = PortalUtil.getPortalURL(request);
	String restApiProcessUrl = portalURL + "/o/api/sti2/process";
%>

<% if(docPhotoEmptyStat.size() > 0) {%>
	<% docPhotoComplete = false; %>
<% } %>

<portlet:renderURL var="riplayURL">
	<portlet:param name="mvcPath" value="/step4.jsp" />
</portlet:renderURL>

<% 
    String riplayModifiedURL = riplayURL;
    if (Validator.isNotNull(aParam)) riplayModifiedURL = riplayModifiedURL + "&a=" + aParam;
    if (Validator.isNotNull(bParam)) riplayModifiedURL = riplayModifiedURL + "&b=" + bParam;
%>

<portlet:renderURL var="polisBaseURL">
	<portlet:param name="mvcPath" value="/step2.jsp" />
	<portlet:param name="fromContinue" value="1" />
</portlet:renderURL>

<% 
    String step2URL = polisBaseURL;
    if (Validator.isNotNull(aParam)) step2URL = step2URL + "&a=" + aParam;
    if (Validator.isNotNull(bParam)) step2URL = step2URL + "&b=" + bParam;
%>

<portlet:renderURL var="step3URL">
	<portlet:param name="mvcPath" value="/step3.jsp" />
</portlet:renderURL>

<% 
    String step3ModifiedURL = step3URL;
    if (Validator.isNotNull(aParam)) step3ModifiedURL = step3ModifiedURL + "&a=" + aParam;
    if (Validator.isNotNull(bParam)) step3ModifiedURL = step3ModifiedURL + "&b=" + bParam;
%>

<script>
	var restApiProcessUrl = "<%=restApiProcessUrl%>";
	var _apiURL = "<%=_portalURL %>";
	var linkRiplay = "<%=riplayModifiedURL%>";
	var linkStep2 = "<%=step2URL%>";
	var linkStep3 = "<%=step3ModifiedURL%>";
	var docPhotoComplete = "<%=docPhotoComplete%>";
	
	var _repeatOrder = "<%=repeatOrder%>";
	var repeatOrder = 0;
	if(!isNaN(parseInt(_repeatOrder))){
		repeatOrder = parseInt(_repeatOrder);
	}
		
	var _modifyQuotation = "<%=modifyQuotation%>";
	var modifyQuotation = 0;
	if(!isNaN(parseInt(_modifyQuotation))){
		modifyQuotation = parseInt(_modifyQuotation);
	}
</script>
<script src="<%=request.getContextPath()%>/js/main.js?v=<%=numericTimestamptimestampForJSURI%>" type="text/javascript"></script>

<% 
try {
	
	if(_leads != null && _detailInternationalTravel != null) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
		String _dDate = formatter.format(_detailInternationalTravel.getDepartureDate());
		String _aDate = formatter.format(_detailInternationalTravel.getArrivalDate());
		
		boolean modifyorrepeatorderstat = false;
		if(repeatOrder == 1 || modifyQuotation == 1) {
			promoCode = "";
			modifyorrepeatorderstat = true;
		} else {
			if(promoCode.isEmpty()) {
				promoCode = _leads.getPromoCode();
			}
		}
	%>
	<script type="text/javascript">
	
	var utm_source = '<%=utmSource%>';
	updateSess(_smartTravelInternationalFormDetailSess, "UtmSource", utm_source);
	
	updateSess(_smartTravelInternationalFormDetailSess, "lid", '<%=lId%>');
	
	updateSess(_smartTravelInternationalFormDetailSess, "ModifyOrRepeatOrderStat", '<%=modifyorrepeatorderstat%>');
	updateSess(_smartTravelInternationalFormDetailSess, "DocPhotoComplete", <%=docPhotoComplete%>);
	
	continueQuote = true;
	updateSess(_smartTravelInternationalFormDetailSess, "Name", '<%=_leads.getName()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "Email", '<%=_leads.getEmail()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "ManagedBy", '<%=_leads.getManagedBy()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "ManagedById", '<%=managedById%>');
	updateSess(_smartTravelInternationalFormDetailSess, "Role", '<%=_leads.getChannel()%>');
	
	updateSess(_smartTravelInternationalFormDetailSess, "Token", '<%=_leads.getToken()%>');
	
	updateSess(_smartTravelInternationalFormDetailSess, "QuoteId", '<%=quouteId%>');
	updateSess(_smartTravelInternationalFormDetailSess, "PromoCode", '<%=promoCode%>');
	updateSess(_smartTravelInternationalFormDetailSess, "Currency", '<%=_leads.getCurrency().toLowerCase()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "TravellerType", '<%=_detailInternationalTravel.getTravellerType()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "AdultTotal", '<%=_detailInternationalTravel.getAdult()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "ChildTotal", '<%=_detailInternationalTravel.getChild()%>');

	updateSess(_smartTravelInternationalFormDetailSess, "DepartureDate", '<%=_dDate%>');
	updateSess(_smartTravelInternationalFormDetailSess, "ArrivalDate", '<%=_aDate%>');
	
	updateSess(_smartTravelInternationalFormDetailSess, "TravelType", '<%=_detailInternationalTravel.getTravelType()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "ChoosenPlan", '<%=_detailInternationalTravel.getPackageType()%>');
	
	updateSess(_smartTravelInternationalFormDetailSess, "AdultTotalFromStep1", '<%=_detailInternationalTravel.getAdult()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "ChildTotalFromStep1", '<%=_detailInternationalTravel.getChild()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "FromStep1", true);
	
	let additionalBenefits = '<%=_detailInternationalTravel.getListBenefitId()%>';
	
	if(additionalBenefits === "[]" || additionalBenefits === "") {
		updateSess(_smartTravelInternationalFormDetailSess, "AdditionalBenefits", []);
	} else {
		updateSess(_smartTravelInternationalFormDetailSess, "AdditionalBenefits", JSON.parse(additionalBenefits));
	}
	
	if(repeatOrder == 1) {
		updateSess(_smartTravelInternationalFormDetailSess, "ro", true);
	} else {
		updateSess(_smartTravelInternationalFormDetailSess, "ro", false);
	}
	
	if(modifyQuotation == 1) {
		updateSess(_smartTravelInternationalFormDetailSess, "modify", true);
	}
	 
	// Key untuk SmartTravelInternationalDataPayload
	var _SmartTravelInternationalDataPayloadSess = "SmartTravelInternationalDataPayload";
	
	let dataPayloadSessData = sessionStorage.getItem(_SmartTravelInternationalDataPayloadSess);
	dataPayloadSessData = dataPayloadSessData ? JSON.parse(dataPayloadSessData) : {};
	
	dataPayloadSessData = JSON.parse('<%=payloadData%>');
	sessionStorage.setItem(_SmartTravelInternationalDataPayloadSess, JSON.stringify(dataPayloadSessData));
	
	// Key untuk AdditionalBenefit
	var _SmartTravelInternationalAdditionalBenefitSess = "AdditionalBenefit";

	let additionalBenefitSessData = '<%=_additionalBenefit%>';
	let additionalBenefitArray = additionalBenefitSessData
	    .replace(/[\[\]\s]/g, '')
	    .split(',');

	sessionStorage.setItem(
	    _SmartTravelInternationalAdditionalBenefitSess,
	    JSON.stringify(additionalBenefitArray)
	);
	
	</script>
	<%} %>
	
	<script type="text/javascript">
var businessModel = '<%=businessModel%>';
updateSess(_smartTravelInternationalFormDetailSess, "BusinessModel", businessModel);
</script>
	
	<%
} catch(Exception e) {
	out.println(e.getMessage());
}
%>


<script src="<%=request.getContextPath()%>/js/continue.js?v=<%=numericTimestamptimestampForJSURI%>" type="text/javascript"></script>

