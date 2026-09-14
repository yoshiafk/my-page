package com.mypage.leads.helper;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.template.TemplateException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.DocumentException;
import com.mypage.admin.product.model.HealthIndividuPlan;
import com.mypage.admin.product.model.PetPlan;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.model.TravelDomesticBenefit;
import com.mypage.admin.product.model.TravelDomesticBenefitGroup;
import com.mypage.admin.product.model.TravelDomesticPlan;
import com.mypage.admin.product.model.TravelIntBenefit;
import com.mypage.admin.product.model.TravelIntBenefitValue;
import com.mypage.admin.product.service.HealthIndividuPlanLocalServiceUtil;
import com.mypage.admin.product.service.PetPlanLocalServiceUtil;
import com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil;
import com.mypage.admin.product.service.TravelDomesticBenefitGroupLocalServiceUtil;
import com.mypage.admin.product.service.TravelDomesticBenefitLocalServiceUtil;
import com.mypage.admin.product.service.TravelDomesticPlanLocalServiceUtil;
import com.mypage.admin.product.service.TravelIntBenefitLocalServiceUtil;
import com.mypage.admin.product.service.TravelIntBenefitValueLocalServiceUtil;
import com.mypage.leads.model.Customer;
import com.mypage.leads.model.DetailDomesticTravel;
import com.mypage.leads.model.DetailDrive;
import com.mypage.leads.model.DetailHealthIndividu;
import com.mypage.leads.model.DetailInternationalTravel;
import com.mypage.leads.model.DetailPet;
import com.mypage.leads.model.Leads;
import com.mypage.leads.model.Payment;
import com.mypage.leads.service.CustomerLocalServiceUtil;
import com.mypage.leads.service.DetailDomesticTravelLocalServiceUtil;
import com.mypage.leads.service.DetailDriveLocalServiceUtil;
import com.mypage.leads.service.DetailHealthIndividuLocalServiceUtil;
import com.mypage.leads.service.DetailInternationalTravelLocalServiceUtil;
import com.mypage.leads.service.DetailPetLocalServiceUtil;
import com.mypage.leads.service.LeadsLocalServiceUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;

import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class MypagePDF {
	private long _leadsId;
	private Leads _leads;
	private Payment _payment;
	private ProductConfiguration _productConfiguration;
	private String _productCode;
	private String _type;
	private String _template;
	private String[] _pages;
	private RenderRequest _renderRequest;
	private ThemeDisplay _themeDisplay;
	private long _userId;
	private long _groupId;
	private ServiceContext _serviceContext;
	private static final Log log = LogFactoryUtil.getLog(pdf.class);

	/**
	 * Setter
	 */
	public void setLeads(long leadsId) {
		_leadsId = leadsId;

		try {
			Leads leads = LeadsLocalServiceUtil.getLeads(leadsId);

			if (leads != null) {
				_leads = leads;
				_productCode = leads.getProductCode().toLowerCase();
//				_payment = PaymentLocalServiceUtil.findByLeadsId(leadsId);

				ProductConfiguration _configList = ProductConfigurationLocalServiceUtil.getConfigByCode(leads.getProductCode());
				_productConfiguration = _configList;
			}
		} catch (PortalException e) {
			log.info(e);
		}
	}

	public void setProduct(String product) {
		_productCode = product.toLowerCase();
	}

	public void setType(String type) {
		_type = type.toLowerCase();
	}

	public void setTemplate(String template) {
		_template = template;
	}

	public void setPages(String[] pages) {
		_pages = pages;
	}

	public void setRenderRequest(RenderRequest renderRequest) {
		try {
			_renderRequest = renderRequest;
			_themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			_userId = _themeDisplay.getUserId();
			_groupId = _themeDisplay.getScopeGroupId();
			_serviceContext = ServiceContextFactory.getInstance(MypagePDF.class.getName(), renderRequest);
		} catch (PortalException e) {
			log.info(e);
		}
	}
	
	public void setServiceContext(ServiceContext serviceContext) {
		_serviceContext = serviceContext;
		_userId = _serviceContext.getUserId();
		_groupId = _serviceContext.getScopeGroupId();
	}
	
	public void setUserId(long userId) {
		_userId = userId;
	}
	
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	/**
	 * Get PDF Template
	 */
	public String getTemplate() throws IOException, TemplateException, JSONException {
		String templateString = "";

		// Set template directory and load template ftl file
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(MypagePDF.class, "/META-INF/resources/pdf");
		cfg.setDefaultEncoding("UTF-8");
		Template template = cfg.getTemplate("/template/policy_certificate_template.ftl");

		// Set data leads
		String jsonLeads = JSONFactoryUtil.looseSerialize(_leads);
		JSONObject leads = JSONFactoryUtil.createJSONObject(jsonLeads);

		// Set data product configuration
		String jsonProduct = JSONFactoryUtil.looseSerialize(_productConfiguration);
		JSONObject product = JSONFactoryUtil.createJSONObject(jsonProduct);

		Map templateData = new HashMap();
		templateData.put("content", "/" + _productCode + "/" + _type + ".ftl");
		templateData.put("baseUrl", getClass().getClassLoader().getResource("/META-INF/resources/pdf"));
		templateData.put("leads", leads);
		templateData.put("payment", _payment);
		templateData.put("product", product);
		templateData.put("pages", _pages);
		
//		log.info(templateData);
		
		// Customers
        List<Customer> customers = CustomerLocalServiceUtil.findByLeadsIdAndProductCode(_leads.getLeadsId(), _leads.getProductCode());
        templateData.put("customers", customers);

		/**
		 * Detail Information
		 */
        
		// Domestic Travel Detail
		if(_productCode.equals("dt")) {
        	// Detail
        	DetailDomesticTravel detail = DetailDomesticTravelLocalServiceUtil.searchByLeadsId(_leadsId);
            templateData.put("detail", detail);
            
            // Plan
            TravelDomesticPlan plan = TravelDomesticPlanLocalServiceUtil.searchByCode(detail.getTravelPlan()).get(0);
            templateData.put("plan", plan);
            
            // Benefit
            List<TravelDomesticBenefit> getBenefits = TravelDomesticBenefitLocalServiceUtil.searchByPlan(detail.getTravelPlan());
            List<TravelDomesticBenefitGroup> getGroups = TravelDomesticBenefitGroupLocalServiceUtil.getTravelDomesticBenefitGroups(0, TravelDomesticBenefitGroupLocalServiceUtil.getTravelDomesticBenefitGroupsCount());
            List<Object> benefits = new ArrayList<>();
            for(TravelDomesticBenefitGroup group : getGroups) {
            	JSONObject temp = JSONFactoryUtil.createJSONObject();
            	List<Object> list = new ArrayList<>();
            	
            	for(TravelDomesticBenefit benefit : getBenefits) {
            		if(benefit.getGroup().equals(group.getCode())) {
            			list.add(benefit);
            		}
            	}
            	
            	if(list.size() > 0) {            		
            		temp.put("title", group.getName());
            		temp.put("list", list);
            		benefits.add(temp);
            	}
            }
            templateData.put("benefits", benefits);
        }

		// International Travel Detail
		if (_productCode.equals("it")) {
			DetailInternationalTravel getDetail = DetailInternationalTravelLocalServiceUtil.findByLeadsId(_leadsId);
			String jsonDetail = JSONFactoryUtil.looseSerialize(getDetail);
			JSONObject detail = JSONFactoryUtil.createJSONObject(jsonDetail);
			templateData.put("detail", detail);

			// Customer data
//			List<Customer> getCustomers = CustomerLocalServiceUtil.findByLeadsIdAndProductCode(_leads.getLeadsId(),
//					_leads.getProductCode());
//			String jsonCustomers = JSONFactoryUtil.looseSerialize(getCustomers);
//			JSONArray customers = JSONFactoryUtil.createJSONArray(jsonCustomers);
//			List<Customer> customers = CustomerLocalServiceUtil.findByLeadsIdAndProductCode(_leads.getLeadsId(),
//					_leads.getProductCode());
//			templateData.put("customers", customers);

			// Benefit
			String packageType = "platinum";
			switch (getDetail.getPackageType()) {
			case "GLD":
				packageType = "gold";
				break;
			case "PLA":
				packageType = "platinum";
				break;
			case "SPA":
				packageType = "special_asia";
				break;
			}

			List<TravelIntBenefit> benefitNames = TravelIntBenefitLocalServiceUtil.getTravelIntBenefits();

//			HashMap<String, String> benefits = new HashMap<String, String>();
			List<Object> benefits = new ArrayList<>();

			for (TravelIntBenefit benefitName : benefitNames) {

				HashMap<String, String> temp = new HashMap<String, String>();

				// Get benefit value
				List<TravelIntBenefitValue> benefitValue = TravelIntBenefitValueLocalServiceUtil.findByPackageTypeAndCurrencyName(benefitName.getTravelIntBenefitId(), packageType, String.valueOf(_leads.getCurrency()));
				
				if(benefitValue.size() > 0) {
					temp.put(benefitName.getBenefitName(), _leads.getCurrency().toUpperCase() + " " + benefitValue.get(0).getBenefitValue());
					benefits.add(temp);
				}
			}

			templateData.put("benefits", benefits);

		}
		
		// Health Individu Detail
		if(_productCode.equals("eh")) {
			// detail
			DetailHealthIndividu detail = DetailHealthIndividuLocalServiceUtil.searchByLeadsId(_leadsId);
            templateData.put("detail", detail);
            
            // plan
            HealthIndividuPlan plan = null;
			try {
				plan = HealthIndividuPlanLocalServiceUtil.getHealthIndividuPlan(detail.getPlanId());
			} catch (Exception e) {
				log.info(e);
			}
			templateData.put("plan", plan);
		}
		
		// Drive MV Detail
		if (_productCode.equals("mv")) {
			List<DetailDrive> getDetail = DetailDriveLocalServiceUtil.findByLeadsId(_leadsId);
			templateData.put("detail", getDetail.get(0));
		}
		
		// Pet Detail
		if(_productCode.equals("pet")) {
			DetailPet getDetail = null;
			PetPlan plan = null;
			
			try {
				getDetail = DetailPetLocalServiceUtil.searchByLeadsId(_leadsId);
				plan = PetPlanLocalServiceUtil.getPetPlan(getDetail.getPlanId());
			} catch (Exception e) {
				log.info(e);
			}

			// detail
			templateData.put("detail", getDetail);
			// plan
			templateData.put("plan", plan);
		}

//		try (StringWriter out = new StringWriter()) {
//			template.process(templateData, out);
//			templateString = out.getBuffer().toString();
//			out.flush();
//		}
		try {
			StringWriter out = new StringWriter();
			template.process(templateData, out);
			templateString = out.getBuffer().toString();
			out.flush();	
		} catch (Exception e) {
			log.info(e);
		}		

		return templateString;
	}

	/**
	 * Check existing file
	 */
	private boolean _exists(long folderId, String curFileName) {
		try {
			FileEntry tempFileEntry = DLAppLocalServiceUtil.getFileEntry(_groupId, folderId,
					curFileName);
			if (tempFileEntry != null) {
				return true;
			}

			return false;
		} catch (PortalException portalException) {
			if (log.isDebugEnabled()) {
				log.debug(portalException, portalException);
			}

			return false;
		}
	}

	private DLFolder getFolder() throws PortalException {
		// Get pdf folder
		DLFolder pdfFolder = DLFolderLocalServiceUtil.fetchFolder(_groupId, 0, "PDF");
		if (pdfFolder == null) {
			pdfFolder = DLFolderLocalServiceUtil.addFolder(_userId, _groupId,
					_groupId, false, 0, "PDF", "", false, _serviceContext);
		}
		// Get policy / quotation folder
		DLFolder typeFolder = DLFolderLocalServiceUtil.fetchFolder(_groupId,
				pdfFolder.getFolderId(), _type.toUpperCase());
		if (typeFolder == null) {
			typeFolder = DLFolderLocalServiceUtil.addFolder(_userId, _groupId,
					_groupId, false, pdfFolder.getFolderId(), _type.toUpperCase(), "", false,
					_serviceContext);
		}
		// Get product folder
		DLFolder productFolder = DLFolderLocalServiceUtil.fetchFolder(_groupId,
				typeFolder.getFolderId(), _productCode.toUpperCase());
		if (productFolder == null) {
			productFolder = DLFolderLocalServiceUtil.addFolder(_userId,
					_groupId, _groupId, false, typeFolder.getFolderId(),
					_productCode.toUpperCase(), "", false, _serviceContext);
		}

		return productFolder;
	}

	/**
	 * Generate PDF
	 * @throws com.lowagie.text.DocumentException 
	 */
	public FileEntry generate() throws com.lowagie.text.DocumentException {
		try {

			String tomcatBase = System.getProperty("catalina.base");
			long unixTime = System.currentTimeMillis() / 1000L;

			// Use leads id to create unique name
			String fileName = createNameByDocumentType();

			String ext = ".pdf";
			String outputFile = tomcatBase + "\\temp\\temp-" + fileName + "-" + unixTime + ".tmp";

			OutputStream outputStream = new FileOutputStream(outputFile);

			ITextRenderer renderer = new ITextRenderer();
			SharedContext sharedContext = renderer.getSharedContext();
			sharedContext.setPrint(true);
			sharedContext.setInteractive(false);
			renderer.setDocumentFromString(getTemplate());
			renderer.layout();
			renderer.createPDF(outputStream);

			File tempFile = new File(outputFile);
			Path path = tempFile.toPath();
			String mimeType = Files.probeContentType(path);

			DLFolder dlFolder = getFolder();

			String uniqueFileName = fileName + ext;
			int num = 1;
			while (_exists(dlFolder.getFolderId(), uniqueFileName) == true) {
				uniqueFileName = fileName + "_" + num + ext;
				num++;
			}

			// Add generated PDF to portal repository
			FileEntry pdf = DLAppLocalServiceUtil.addFileEntry(_userId, _groupId, dlFolder.getFolderId(),
					uniqueFileName, mimeType, uniqueFileName, "", "", tempFile, _serviceContext);

			// Delete temp file
			boolean delete = tempFile.delete();
			
			if (!delete) {
				log.info("Failed to delete temp file");
			}

			return pdf;

		} catch (IOException | PortalException e) {
			log.info(e);
		}

		return null;
	}

	/**
	 * Create Name by Document Type, e:g Policy_Certificate this name is used as
	 * prefix for PDF filename
	 * 
	 * @return String Returns Name by Document Type
	 */
	private String createNameByDocumentType() {
		String nameByDocumentType = "";
		if (_type == null) {
			nameByDocumentType = "";
		} else {
			switch (_type.toLowerCase()) {
			case "policy_certificate":
				nameByDocumentType = _leads.getReferenceNumber();
				break;
			case "quotation_certificate":
				nameByDocumentType = _leads.getReferenceNumber();
				break;
			default:
				nameByDocumentType = "";
				break;
			}
		}

		return nameByDocumentType;
	}

}
