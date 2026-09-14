package com.mypage.leads.portlet;

import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.criteria.FileEntryItemSelectorReturnType;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.admin.product.model.PaymentChannel;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.service.PaymentChannelLocalServiceUtil;
import com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil;
import com.mypage.leads.constants.MypageLeadsPortletKeys;
import com.mypage.leads.helper.pdf;
import com.mypage.leads.model.Customer;
import com.mypage.leads.model.DetailDomesticTravel;
import com.mypage.leads.model.DetailInternationalTravel;
import com.mypage.leads.model.DetailPet;
import com.mypage.leads.model.Leads;
import com.mypage.leads.model.Payment;
import com.mypage.leads.service.CustomerLocalServiceUtil;
import com.mypage.leads.service.DetailDomesticTravelLocalServiceUtil;
import com.mypage.leads.service.DetailInternationalTravelLocalServiceUtil;
import com.mypage.leads.service.DetailPetLocalService;
import com.mypage.leads.service.LeadsLocalService;
import com.mypage.leads.service.LeadsLocalServiceUtil;
import com.mypage.leads.service.PaymentLocalServiceUtil;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gositus-IdeapadSlim5
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.add-default-resource=true",
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.private-session-attributes=false",
			"com.liferay.portlet.use-default-template=true",
			"javax.portlet.display-name=Leads Parent",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/parents/list.jsp",
			"javax.portlet.name=" + MypageLeadsPortletKeys.MYPAGELEADS,
			"javax.portlet.resource-bundle=content.Language", 
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.init-param.add-process-action-success-action=false"
		},
		service = Portlet.class
	)
public class MypageLeadsPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
				
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String asd = themeDisplay.getSiteGroupName();
//			System.out.println(asd);
		} catch(PortalException pe) {
			log.info(pe);
		}
		
//		pdf pdf = new pdf();
//		pdf.setLeads(130301);
//		pdf.setType("policy");
//		pdf.setPages(new String[]{"premiumNote", "covidInformation"});
//		pdf.setRenderRequest(renderRequest);
//		pdf.generate();
		
//		MypagePDF currentPDF = new MypagePDF();
//		currentPDF.setLeads(174779);
//		currentPDF.setType("quotation_certificate");
//		currentPDF.setPages(new String[]{"premiumNote"});
//		currentPDF.setRenderRequest(renderRequest);
//		currentPDF.generate();


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
//		System.out.print(itemSelectorURL.toString());
		super.render(renderRequest, renderResponse);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
		String type = ParamUtil.getString(resourceRequest, "type");

		if (cmd.equals(Constants.EXPORT) || cmd.equals("exportAll")) {			
			if (type.equals("leads")) {				
				exportLeads(resourceRequest, resourceResponse);
			}
		}
		
		return;
	}
	
	public void addLeads(ActionRequest actionRequest,
            ActionResponse actionResponse) throws IOException, PortletException, PortalException, ParseException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Leads.class.getName(),
				actionRequest);
		long userId = serviceContext.getUserId();
		long LeadsId = ParamUtil.getLong(actionRequest, "LeadsId");
		
		// data leads
		JSONObject data = JSONFactoryUtil.createJSONObject();
		data.put("ManagedBy", ParamUtil.getString(actionRequest, "ManagedBy"));
		data.put("LeadsType", ParamUtil.getString(actionRequest, "LeadsType"));
		data.put("CommercialOffers", ParamUtil.getInteger(actionRequest, "CommercialOffers"));
		data.put("PolicyNumber", ParamUtil.getString(actionRequest, "PolicyNumber"));
		data.put("ReferenceNumber", ParamUtil.getString(actionRequest, "ReferenceNumber"));
		data.put("Currency", ParamUtil.getString(actionRequest, "Currency"));
		data.put("PolicyCost", ParamUtil.getDouble(actionRequest, "PolicyCost"));
		data.put("StampDuty", ParamUtil.getDouble(actionRequest, "StampDuty"));
		data.put("Premium", ParamUtil.getDouble(actionRequest, "Premium"));
		data.put("NetPremium", ParamUtil.getDouble(actionRequest, "NetPremium"));
		data.put("Discount", ParamUtil.getDouble(actionRequest, "Discount"));
		data.put("Commission", ParamUtil.getDouble(actionRequest, "Commission"));
		data.put("BussinesModel", ParamUtil.getString(actionRequest, "BussinesModel"));
		data.put("Channel", ParamUtil.getString(actionRequest, "Channel"));
		data.put("PromoCode", ParamUtil.getString(actionRequest, "PromoCode"));
		data.put("ProductCode", ParamUtil.getString(actionRequest, "ProductCode"));
		data.put("UtmSource", ParamUtil.getString(actionRequest, "UtmSource"));
		data.put("UtmMedium", ParamUtil.getString(actionRequest, "UtmMedium"));
		data.put("UtmCampaign", ParamUtil.getString(actionRequest, "UtmCampaign"));
		data.put("UtmTerm", ParamUtil.getString(actionRequest, "UtmTerm"));
		data.put("UtmContent", ParamUtil.getString(actionRequest, "UtmContent"));
		data.put("ClickId", ParamUtil.getString(actionRequest, "ClickId"));
		data.put("Name", ParamUtil.getString(actionRequest, "Name"));
		data.put("Email", ParamUtil.getString(actionRequest, "Email"));
		data.put("MobilePhone", ParamUtil.getString(actionRequest, "MobilePhone"));
		data.put("Gender", ParamUtil.getString(actionRequest, "Gender"));
		data.put("Dob", !ParamUtil.getString(actionRequest, "Dob").equals("") ? ParamUtil.getString(actionRequest, "Dob").replace("/", "-") : "");
		data.put("Nationality", ParamUtil.getString(actionRequest, "Nationality"));
		data.put("IdNumber", ParamUtil.getString(actionRequest, "IdNumber"));
		data.put("PassportNumber", ParamUtil.getString(actionRequest, "PassportNumber"));
		data.put("KitasNumber", ParamUtil.getString(actionRequest, "KitasNumber"));
		data.put("Address", ParamUtil.getString(actionRequest, "Address"));
		data.put("Address2", ParamUtil.getString(actionRequest, "Address2"));
		data.put("Province", ParamUtil.getString(actionRequest, "Province"));
		data.put("City", ParamUtil.getString(actionRequest, "City"));
		data.put("Zip", ParamUtil.getString(actionRequest, "Zip"));
		data.put("Active", ParamUtil.getInteger(actionRequest, "active"));
		data.put("PolicyStartDate", ParamUtil.getString(actionRequest, "PolicyStartDate").replace("/", "-"));
		data.put("PolicyEndDate", ParamUtil.getString(actionRequest, "PolicyEndDate").replace("/", "-"));
		data.put("Token", ParamUtil.getString(actionRequest, "Token"));
		data.put("TempCode", ParamUtil.getString(actionRequest, "TempCode"));
		
		// check produuct code
		ProductConfiguration product = null;
		product = ProductConfigurationLocalServiceUtil.getConfigByCode(data.getString("ProductCode"));
		if(Validator.isNull(product)) {
			SessionErrors.add(actionRequest, "errorProductCode");
			actionResponse.setRenderParameter("LeadsId", String.valueOf(LeadsId));
			actionResponse.setRenderParameter("mvcPath", "/parents/edit.jsp");
			return;
		}
		
		
		// remove all child
		CustomerLocalServiceUtil.removeCustomerByLeadsIdAndProductCode(LeadsId, data.getString("ProductCode"));
		
		// customer input name
		String[] customerFields = {
			"Customer_Name[]", "Customer_Email[]", "Customer_MobilePhone[]", "Customer_Gender[]", "Customer_Dob[]", "Customer_Nationality[]", 
			"Customer_IdNumber[]", "Customer_PassportNumber[]", "Customer_KitasNumber[]", "Customer_Address[]", "Customer_Address2[]", 
			"Customer_Relationship[]", "Customer_Province[]", "Customer_City[]", "Customer_Beneficiary[]", "Customer_BeneficiaryRelationship[]", 
			"Customer_Type[]"
		};
		
		// for loop customer
		String[] customerName = ParamUtil.getParameterValues(actionRequest, "Customer_Name[]");
		
		// update customer
		if (customerName.length > 0) {
			for (int i = 0; i < customerName.length; i++) {
				// data customer
				JSONObject customerParams = JSONFactoryUtil.createJSONObject();
				customerParams.put("LeadsId", LeadsId);
				customerParams.put("ProductCode", data.getString("ProductCode"));
				for (int j = 0; j < customerFields.length; j++) {
					String[] input = ParamUtil.getParameterValues(actionRequest, customerFields[j]);
					String value = input.length > 0 ? input[i] : "";
					
					// dob format
					if(customerFields[j].equalsIgnoreCase("Customer_Dob[]")) {
						value = value.replace("/", "-");
					}
					customerParams.put(customerFields[j].replaceAll("(Customer_)|(\\[\\])", ""), value);
				}

				// add customer
				Customer customer = CustomerLocalServiceUtil.addCustomer(userId, 0, customerParams, serviceContext);
			}
		}
		
		// save detail product
		if(data.getString("ProductCode").equals("DT")) {
			saveDetailDT(actionRequest);
		} else if(data.getString("ProductCode").equals("IT")) {
			saveDetailIT(actionRequest);
		} else if(data.getString("ProductCode").equals("PET")) {
			saveDetailPET(actionRequest);
		}
		
		// save leads
		Leads _leads = LeadsLocalServiceUtil.addLeads(userId, LeadsId, data, serviceContext);
		
		SessionMessages.add(actionRequest, "dataUpdated");
		actionResponse.setRenderParameter("mvcPath", "/parents/list.jsp");
	}
	
	private void saveDetailDT(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Leads.class.getName(), actionRequest);
		long userId = serviceContext.getUserId();
		long LeadsId = ParamUtil.getLong(actionRequest, "LeadsId");
		
		JSONObject data = JSONFactoryUtil.createJSONObject();
		data.put("LeadsId", LeadsId);
		data.put("TravelType", ParamUtil.getString(actionRequest, "TravelType"));
		data.put("TravelPlan", ParamUtil.getString(actionRequest, "TravelPlan"));
		data.put("TravellerType", ParamUtil.getString(actionRequest, "TravellerType"));
		data.put("Adult", ParamUtil.getInteger(actionRequest, "Adult"));
		data.put("Child", ParamUtil.getInteger(actionRequest, "Child"));
		
//		List<DetailDomesticTravel> detail = DetailDomesticTravelLocalServiceUtil.searchByLeadsId(LeadsId);
		DetailDomesticTravel detail = DetailDomesticTravelLocalServiceUtil.searchByLeadsId(LeadsId);

		long detailId = 0;
		if(!Validator.isNull(detail)) {
//			detailId = detail.get(0).getDetailDomesticTravelId();
			detailId = detail.getDetailDomesticTravelId();
		}
		
		DetailDomesticTravel _detailLeads = DetailDomesticTravelLocalServiceUtil.addDetail(userId, detailId, data, serviceContext);
	}
	
	private void saveDetailIT(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Leads.class.getName(), actionRequest);
		long userId = serviceContext.getUserId();
		long LeadsId = ParamUtil.getLong(actionRequest, "LeadsId");
		
		JSONObject data = JSONFactoryUtil.createJSONObject();
		data.put("LeadsId", LeadsId);
		data.put("Destination", ParamUtil.getString(actionRequest, "Destination"));
		data.put("TravelType", ParamUtil.getString(actionRequest, "TravelType"));
		data.put("PackageType", ParamUtil.getString(actionRequest, "PackageType"));
		data.put("TravellerType", ParamUtil.getString(actionRequest, "TravellerType"));
		data.put("Adult", ParamUtil.getInteger(actionRequest, "Adult"));
		data.put("Child", ParamUtil.getInteger(actionRequest, "Child"));
		
		DetailInternationalTravel detail = DetailInternationalTravelLocalServiceUtil.findByLeadsId(LeadsId);
		
		long detailId = 0;
		if(detail != null) {
			detailId = detail.getDetailId();
		}

		DetailInternationalTravel _detail = DetailInternationalTravelLocalServiceUtil.addDetail(userId, detailId, data, serviceContext);
	}
	
	private void saveDetailPET(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Leads.class.getName(), actionRequest);
		long userId = serviceContext.getUserId();
		long LeadsId = ParamUtil.getLong(actionRequest, "LeadsId");
		
		JSONObject data = JSONFactoryUtil.createJSONObject();
		data.put("LeadsId", LeadsId);
		data.put("PlanId", ParamUtil.getString(actionRequest, "PlanId"));
		data.put("LimitDisability", ParamUtil.getDouble(actionRequest, "LimitDisability"));
		data.put("LimitMedical", ParamUtil.getDouble(actionRequest, "LimitMedical"));
		data.put("LimitThirdParty", ParamUtil.getDouble(actionRequest, "LimitThirdParty"));
		data.put("LimitCustody", ParamUtil.getDouble(actionRequest, "LimitCustody"));
		data.put("PetName", ParamUtil.getString(actionRequest, "PetName"));
		data.put("PetType", ParamUtil.getString(actionRequest, "PetType"));
		data.put("PetDob", ParamUtil.getString(actionRequest, "PetDob"));
		data.put("PetGender", ParamUtil.getString(actionRequest, "PetGender"));
		data.put("PetIdNumber", ParamUtil.getString(actionRequest, "PetIdNumber"));
		data.put("PetIdNumberIssuing", ParamUtil.getString(actionRequest, "PetIdNumberIssuing"));
		data.put("PetIdNumberFileEntryId", ParamUtil.getLong(actionRequest, "PetIdNumberFileEntryId"));
		data.put("PetIdNumberURL", "");
		data.put("PetPhotoFileEntryId", ParamUtil.getLong(actionRequest, "PetPhotoFileEntryId"));
		data.put("PetPhotoURL", "");
		data.put("PetLocation", ParamUtil.getString(actionRequest, "PetLocation"));
		data.put("PetVaccine", ParamUtil.getInteger(actionRequest, "PetVaccine"));
		data.put("PetAuthorizedCertificate", ParamUtil.getInteger(actionRequest, "PetAuthorizedCertificate"));
		
		DetailPet detail = _detailPetLocalService.searchByLeadsId(LeadsId);
		long detailId = 0;
		if(detail != null) {
			detailId = detail.getDetailPetId();
		}
		DetailPet _detailLeads = _detailPetLocalService.addDetail(userId, detailId, data, serviceContext);
	}
	
	private String getCSVFormattedValue(String value) {
		StringBundler sb = new StringBundler(3);
		sb.append(CharPool.QUOTE);
		sb.append(StringUtil.replace(value, CharPool.QUOTE,StringPool.DOUBLE_QUOTE));
		sb.append(CharPool.QUOTE);
		return sb.toString();
	}
	
	private void exportLeads(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			long[] leads = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList(
					"Leads Id", "Product", "Start Date", "End Date", "Leads Type", "Policy Number", "Reference Number", "Currency", 
					"Policy Cost", "Stamp Duty", "Premium", "Net Premium", "Discount", "Commission", "Channel", "Promo Code", 
					"Name", "Email", "Mobile Phone", "Gender", "Dob", "Nationality", "Id Number", "Passport Number", "Kitas Number", 
					"Address", "Address2", "Commercial Offers", "UtmSource", "UtmMedium", "UtmCampaign", "UtmTerm", "UtmContent",
					"Payment Code", "Payment Status", "Payment Channel", "Payment Message", "Credit Card Type", "Transaction Date Time", "Payment Date Time",
					"Bank", "ManagedBy", "Report Generated", "Daily Report Generated", "Weekly Report Generated", "Monthly Report Generated", 
					"Check Status Counter", "Credit Payment Status", "Credit Transaction Id", "Credit Payment Date", "Credit Bank", 
					"Credit Payment Code", "Credit Payment Message", "Report Settlement Generated", "UtmId", "Sojern", "InvolveAsia", "Ada");
			
			String COMMA = ";";
			StringBundler sb = new StringBundler();
			for (String columnName : csvHeadLines) {
				sb.append(getCSVFormattedValue(String.valueOf(columnName)));
				sb.append(COMMA);				
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);
			
//			String _tmp = "";
			if(cmd.equals("exportAll")) {
				int _count = _leadsLocalService.getLeadsesCount();
				List<Leads> _getLeads = _leadsLocalService.getLeadses(0, _count);
				
				for(Leads _leads : _getLeads) {
					
					try {
						// get payment
						Payment payment = PaymentLocalServiceUtil.findByLeadsId(_leads.getLeadsId());
						
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
						SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss"); 
						
						// Leads Id
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getLeadsId())));
						sb.append(COMMA);
						
						// Product
						String productName = "";
						if(!_leads.getProductCode().isEmpty()) {
							ProductConfiguration _config = null;
							_config = ProductConfigurationLocalServiceUtil.getConfigByCode(_leads.getProductCode());
							if(!Validator.isNull(_config)) {
								productName = _config.getProductName();
							}
						}
						sb.append(getCSVFormattedValue(productName));
						sb.append(COMMA);								

						// Start Date
						String startdate = "";
						if(_leads.getPolicyStartDate() != null) {
							startdate = dateFormat.format(_leads.getPolicyStartDate()); 
						}
						sb.append(getCSVFormattedValue(startdate));
						sb.append(COMMA);

						// End Date
						String enddate = "";
						if(_leads.getPolicyEndDate() != null) {
							enddate = dateFormat.format(_leads.getPolicyEndDate()); 
						}
						sb.append(getCSVFormattedValue(enddate));
						sb.append(COMMA);

						// Leads Type
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getLeadsType())));
						sb.append(COMMA);

						// Policy Number
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getPolicyNumber())));
						sb.append(COMMA);

						// Reference Number
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getReferenceNumber())));
						sb.append(COMMA);

						// Currency
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getCurrency())));
						sb.append(COMMA);

						// Policy Cost
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getPolicyCost())));
						sb.append(COMMA);

						// Stamp Duty
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getStampDuty())));
						sb.append(COMMA);

						// Premium
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getPremium())));
						sb.append(COMMA);

						// Net Premium
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getNetPremium())));
						sb.append(COMMA);

						// Discount
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getDiscount())));
						sb.append(COMMA);

						// Commission
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getCommission())));
						sb.append(COMMA);

						// Channel
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getChannel())));
						sb.append(COMMA);

						// Promo Code
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getPromoCode())));
						sb.append(COMMA);

						// Name
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getName())));
						sb.append(COMMA);

						// Email
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getEmail())));
						sb.append(COMMA);

						// Mobile Phone
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getMobilePhone())));
						sb.append(COMMA);

						// Gender
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getGender())));
						sb.append(COMMA);

						// Dob
						String dob = "";
						if(_leads.getDob() != null) {
							dob = dateFormat.format(_leads.getDob()); 
						}
						sb.append(getCSVFormattedValue(dob));
						sb.append(COMMA);

						// Nationality
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getNationality())));
						sb.append(COMMA);

						// Id Number
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getIdNumber())));
						sb.append(COMMA);

						// Passport Number
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getPassportNumber())));
						sb.append(COMMA);

						// Kitas Number
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getKitasNumber())));
						sb.append(COMMA);

						// Address
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getAddress())));
						sb.append(COMMA);

						// Address2
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getAddress2())));
						sb.append(COMMA);

						// Commercial Offers
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getCommercialOffers())));
						sb.append(COMMA);

						// UtmSource
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getUtmSource())));
						sb.append(COMMA);

						// UtmMedium
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getUtmMedium())));
						sb.append(COMMA);

						// UtmCampaign
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getUtmCampaign())));
						sb.append(COMMA);

						// UtmTerm
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getUtmTerm())));
						sb.append(COMMA);

						// UtmContent
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getUtmContent())));
						sb.append(COMMA);
						
						// Payment Code
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getPaymentCode()) : ""));
						sb.append(COMMA);

						// Payment Status
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getPaymentStatus()) : ""));
						sb.append(COMMA);

						// Payment Channel
						String paymentChannelName = "";
						if(payment != null && payment.getPaymentChannelId() > 0) {
							PaymentChannel paymentChannel = PaymentChannelLocalServiceUtil.getPaymentChannel(payment.getPaymentChannelId());
							if(paymentChannel != null) {
								paymentChannelName = paymentChannel.getName();
							}
						}
						sb.append(getCSVFormattedValue(paymentChannelName));
						sb.append(COMMA);

						// Payment Message
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getPaymentMessage()) : ""));
						sb.append(COMMA);

						// Credit Card Type
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getCreditCardType()) : ""));
						sb.append(COMMA);

						// Transaction Date Time
						String transactionTime = "";
						if(payment != null && payment.getTransactionDateTime() != null) {
							transactionTime = timeFormat.format(payment.getTransactionDateTime()); 
						}
						sb.append(getCSVFormattedValue(transactionTime));
						sb.append(COMMA);

						// Payment Date Time
						String paymentTime = "";
						if(payment != null && payment.getPaymentDateTime() != null) {
							paymentTime = timeFormat.format(payment.getPaymentDateTime()); 
						}
						sb.append(getCSVFormattedValue(paymentTime));
						sb.append(COMMA);

						// Bank
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getBank()) : ""));
						sb.append(COMMA);

						// ManagedBy
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getManagedBy()) : ""));
						sb.append(COMMA);

						// Report Generated
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getReportGenerated()) : ""));
						sb.append(COMMA);

						// Daily Report Generated
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getDailyReportGenerated()) : ""));
						sb.append(COMMA);

						// Weekly Report Generated
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getWeeklyReportGenerated()) : ""));
						sb.append(COMMA);

						// Monthly Report Generated
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getMonthlyReportGenerated()) : ""));
						sb.append(COMMA);

						// Check Status Counter
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getCheckStatusCounter()) : ""));
						sb.append(COMMA);

						// Credit Payment Status
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getCreditPaymentStatus()) : ""));
						sb.append(COMMA);

						// Credit Transaction Id
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getCreditTransactionId()) : ""));
						sb.append(COMMA);

						// Credit Payment Date
						String cPaymentTime = "";
						if(payment != null && payment.getCreditPaymentDate() != null) {
							cPaymentTime = timeFormat.format(payment.getCreditPaymentDate()); 
						}
						sb.append(getCSVFormattedValue(cPaymentTime));
						sb.append(COMMA);

						// Credit Bank
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getCreditBank()) : ""));
						sb.append(COMMA);

						// Credit Payment Code
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getCreditPaymentCode()) : ""));
						sb.append(COMMA);

						// Credit Payment Message
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getCreditPaymentMessage()) : ""));
						sb.append(COMMA);

						// Report Settlement Generated
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getReportSettlementGenerated()) : ""));
						sb.append(COMMA);

						// UtmId
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getUtmId()) : ""));
						sb.append(COMMA);

						// Sojern
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getSojern()) : ""));
						sb.append(COMMA);

						// InvolveAsia
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getInvolveAsia()) : ""));
						sb.append(COMMA);

						// Ada
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getAda()) : ""));
						sb.append(COMMA);
							
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);	
					} catch (Exception e) {
					}	
				}
			}else {
				// Export selected data
				if(leads.length<1) {
					return;
				}
				
				for (long LeadsId : leads) {
					Leads _leads = _leadsLocalService.getLeads(LeadsId);
					try {
						// get payment
						Payment payment = PaymentLocalServiceUtil.findByLeadsId(_leads.getLeadsId());
						
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
						SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
						
						// Leads Id
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getLeadsId())));
						sb.append(COMMA);
						
						// Product
						String productName = "";
						if(!_leads.getProductCode().isEmpty()) {
							ProductConfiguration _config = null;
							_config = ProductConfigurationLocalServiceUtil.getConfigByCode(_leads.getProductCode());
							if(!Validator.isNull(_config)) {
								productName = _config.getProductName();
							}
						}
						sb.append(getCSVFormattedValue(productName));
						sb.append(COMMA);								

						// Start Date
						String startdate = "";
						if(_leads.getPolicyStartDate() != null) {
							startdate = dateFormat.format(_leads.getPolicyStartDate()); 
						}
						sb.append(getCSVFormattedValue(startdate));
						sb.append(COMMA);

						// End Date
						String enddate = "";
						if(_leads.getPolicyEndDate() != null) {
							enddate = dateFormat.format(_leads.getPolicyEndDate()); 
						}
						sb.append(getCSVFormattedValue(enddate));
						sb.append(COMMA);

						// Leads Type
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getLeadsType())));
						sb.append(COMMA);

						// Policy Number
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getPolicyNumber())));
						sb.append(COMMA);

						// Reference Number
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getReferenceNumber())));
						sb.append(COMMA);

						// Currency
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getCurrency())));
						sb.append(COMMA);

						// Policy Cost
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getPolicyCost())));
						sb.append(COMMA);

						// Stamp Duty
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getStampDuty())));
						sb.append(COMMA);

						// Premium
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getPremium())));
						sb.append(COMMA);

						// Net Premium
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getNetPremium())));
						sb.append(COMMA);

						// Discount
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getDiscount())));
						sb.append(COMMA);

						// Commission
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getCommission())));
						sb.append(COMMA);

						// Channel
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getChannel())));
						sb.append(COMMA);

						// Promo Code
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getPromoCode())));
						sb.append(COMMA);

						// Name
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getName())));
						sb.append(COMMA);

						// Email
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getEmail())));
						sb.append(COMMA);

						// Mobile Phone
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getMobilePhone())));
						sb.append(COMMA);

						// Gender
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getGender())));
						sb.append(COMMA);

						// Dob
						String dob = "";
						if(_leads.getDob() != null) {
							dob = dateFormat.format(_leads.getDob()); 
						}
						sb.append(getCSVFormattedValue(dob));
						sb.append(COMMA);

						// Nationality
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getNationality())));
						sb.append(COMMA);

						// Id Number
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getIdNumber())));
						sb.append(COMMA);

						// Passport Number
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getPassportNumber())));
						sb.append(COMMA);

						// Kitas Number
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getKitasNumber())));
						sb.append(COMMA);

						// Address
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getAddress())));
						sb.append(COMMA);

						// Address2
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getAddress2())));
						sb.append(COMMA);

						// Commercial Offers
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getCommercialOffers())));
						sb.append(COMMA);

						// UtmSource
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getUtmSource())));
						sb.append(COMMA);

						// UtmMedium
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getUtmMedium())));
						sb.append(COMMA);

						// UtmCampaign
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getUtmCampaign())));
						sb.append(COMMA);

						// UtmTerm
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getUtmTerm())));
						sb.append(COMMA);

						// UtmContent
						sb.append(getCSVFormattedValue(String.valueOf(_leads.getUtmContent())));
						sb.append(COMMA);
						
						// Payment Code
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getPaymentCode()) : ""));
						sb.append(COMMA);

						// Payment Status
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getPaymentStatus()) : ""));
						sb.append(COMMA);

						// Payment Channel
						String paymentChannelName = "";
						if(payment != null && payment.getPaymentChannelId() > 0) {
							PaymentChannel paymentChannel = PaymentChannelLocalServiceUtil.getPaymentChannel(payment.getPaymentChannelId());
							if(paymentChannel != null) {
								paymentChannelName = paymentChannel.getName();
							}
						}
						sb.append(getCSVFormattedValue(paymentChannelName));
						sb.append(COMMA);

						// Payment Message
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getPaymentMessage()) : ""));
						sb.append(COMMA);

						// Credit Card Type
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getCreditCardType()) : ""));
						sb.append(COMMA);

						// Transaction Date Time
						String transactionTime = "";
						if(payment != null && payment.getTransactionDateTime() != null) {
							transactionTime = timeFormat.format(payment.getTransactionDateTime()); 
						}
						sb.append(getCSVFormattedValue(transactionTime));
						sb.append(COMMA);

						// Payment Date Time
						String paymentTime = "";
						if(payment != null && payment.getPaymentDateTime() != null) {
							paymentTime = timeFormat.format(payment.getPaymentDateTime()); 
						}
						sb.append(getCSVFormattedValue(paymentTime));
						sb.append(COMMA);

						// Bank
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getBank()) : ""));
						sb.append(COMMA);

						// ManagedBy
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getManagedBy()) : ""));
						sb.append(COMMA);

						// Report Generated
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getReportGenerated()) : ""));
						sb.append(COMMA);

						// Daily Report Generated
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getDailyReportGenerated()) : ""));
						sb.append(COMMA);

						// Weekly Report Generated
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getWeeklyReportGenerated()) : ""));
						sb.append(COMMA);

						// Monthly Report Generated
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getMonthlyReportGenerated()) : ""));
						sb.append(COMMA);

						// Check Status Counter
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getCheckStatusCounter()) : ""));
						sb.append(COMMA);

						// Credit Payment Status
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getCreditPaymentStatus()) : ""));
						sb.append(COMMA);

						// Credit Transaction Id
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getCreditTransactionId()) : ""));
						sb.append(COMMA);

						// Credit Payment Date
						String cPaymentTime = "";
						if(payment != null && payment.getCreditPaymentDate() != null) {
							cPaymentTime = timeFormat.format(payment.getCreditPaymentDate()); 
						}
						sb.append(getCSVFormattedValue(cPaymentTime));
						sb.append(COMMA);

						// Credit Bank
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getCreditBank()) : ""));
						sb.append(COMMA);

						// Credit Payment Code
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getCreditPaymentCode()) : ""));
						sb.append(COMMA);

						// Credit Payment Message
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getCreditPaymentMessage()) : ""));
						sb.append(COMMA);

						// Report Settlement Generated
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getReportSettlementGenerated()) : ""));
						sb.append(COMMA);

						// UtmId
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getUtmId()) : ""));
						sb.append(COMMA);

						// Sojern
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getSojern()) : ""));
						sb.append(COMMA);

						// InvolveAsia
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getInvolveAsia()) : ""));
						sb.append(COMMA);

						// Ada
						sb.append(getCSVFormattedValue(payment != null ? String.valueOf(payment.getAda()) : ""));
						sb.append(COMMA);
							
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);							
					} catch (Exception e) {
					}
					
				}					
			}
			
			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;
			
			PortletResponseUtil.sendFile(resourceRequest, resourceResponse,"ExportLeads.csv", bytes, contentType);
			
			return;
			
		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}
	
	private static final Log log = LogFactoryUtil.getLog(MypageLeadsPortlet.class);
	
	@Reference
	private LeadsLocalService _leadsLocalService;
	
	@Reference
	private ItemSelector _itemSelector;
	
	@Reference
	private DetailPetLocalService _detailPetLocalService;
}