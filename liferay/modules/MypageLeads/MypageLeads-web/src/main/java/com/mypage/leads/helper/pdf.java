package com.mypage.leads.helper;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.lowagie.text.DocumentException;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.model.TravelDomesticBenefit;
import com.mypage.admin.product.model.TravelDomesticBenefitGroup;
import com.mypage.admin.product.model.TravelDomesticPlan;
import com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil;
import com.mypage.admin.product.service.TravelDomesticBenefitGroupLocalServiceUtil;
import com.mypage.admin.product.service.TravelDomesticBenefitLocalServiceUtil;
import com.mypage.admin.product.service.TravelDomesticPlanLocalServiceUtil;
import com.mypage.leads.model.Customer;
import com.mypage.leads.model.DetailDomesticTravel;
import com.mypage.leads.model.Leads;
import com.mypage.leads.model.Payment;
import com.mypage.leads.service.CustomerLocalServiceUtil;
import com.mypage.leads.service.DetailDomesticTravelLocalServiceUtil;
import com.mypage.leads.service.LeadsLocalServiceUtil;
import com.mypage.leads.service.PaymentLocalServiceUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class pdf {
	// global init
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
	private ServiceContext _serviceContext;
	private static final Log log = LogFactoryUtil.getLog(pdf.class);
	
	/********** Start Set Data **********/
	public void setLeads(long leadsId) { 
		_leadsId = leadsId; 
		
		try {
			Leads leads =  LeadsLocalServiceUtil.getLeads(leadsId);
			
			if(leads != null) {
				_leads = leads;
				_productCode = leads.getProductCode().toLowerCase();
				_payment = PaymentLocalServiceUtil.findByLeadsId(leadsId);
				
				// get product configuration
				ProductConfiguration _configList = ProductConfigurationLocalServiceUtil.getConfigByCode(leads.getProductCode());
				_productConfiguration = _configList;
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setProduct(String product) { _productCode = product.toLowerCase(); }
	public void setType(String type) { _type = type.toLowerCase(); }
	public void setTemplate(String template) { _template = template; }
	public void setPages(String[] pages) { _pages = pages; }
	public void setRenderRequest(RenderRequest renderRequest) { 
		try {
			_renderRequest = renderRequest; 
			_themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			_serviceContext = ServiceContextFactory.getInstance(pdf.class.getName(), renderRequest);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/********** End Set Data **********/
	
	// get pdf template
	public String getTemplate() throws IOException, TemplateException, JSONException {
		String templateString = "";
		
		// load template
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(pdf.class, "/META-INF/resources/pdf");
        cfg.setDefaultEncoding("UTF-8");
        Template template = cfg.getTemplate("/template/template.ftl");
        
        Map templateData = new HashMap();
        //// base settings
        templateData.put("content", "/" + _productCode + "/" + _type + ".ftl");
        templateData.put("baseUrl", getClass().getClassLoader().getResource("/META-INF/resources/pdf"));
        templateData.put("leads", _leads);
        templateData.put("payment", _payment);
        templateData.put("product", _productConfiguration);
        templateData.put("pages", _pages);
        
        //// additional settings
        // detail travel domestic
        if(_productCode.equals("dt")) {
        	// detail
        	DetailDomesticTravel detail = DetailDomesticTravelLocalServiceUtil.searchByLeadsId(_leadsId);
            templateData.put("detail", detail);
            
            // plan
            TravelDomesticPlan plan = TravelDomesticPlanLocalServiceUtil.searchByCode(detail.getTravelPlan()).get(0);
            templateData.put("plan", plan);
            
            // customers
            List<Customer> customers = CustomerLocalServiceUtil.findByLeadsIdAndProductCode(_leads.getLeadsId(), _leads.getProductCode());
            templateData.put("customers", customers);
            
            // benefit
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

        try (StringWriter out = new StringWriter()) {
            template.process(templateData, out);
            templateString = out.getBuffer().toString();
            out.flush();
        }
        
        return templateString;
	}
	
	// check file exist
	private boolean _exists(long folderId, String curFileName) {
		try {
			FileEntry tempFileEntry = DLAppLocalServiceUtil.getFileEntry(_themeDisplay.getScopeGroupId(), folderId, curFileName);
			if (tempFileEntry != null) {
				return true;
			}

			return false;
		}
		catch (PortalException portalException) {
			if (log.isDebugEnabled()) {
				log.debug(portalException, portalException);
			}

			return false;
		}
	}
	
	// get folder
	private DLFolder getFolder() throws PortalException {
		// get pdf folder 
		DLFolder pdfFolder = DLFolderLocalServiceUtil.fetchFolder(_themeDisplay.getScopeGroupId(), 0, "PDF");
		if(pdfFolder == null) {
			pdfFolder = DLFolderLocalServiceUtil.addFolder(_themeDisplay.getUserId(), _themeDisplay.getScopeGroupId(), _themeDisplay.getScopeGroupId(), false, 0, "PDF", "", false, _serviceContext);
		}
		// get policy / quotation folder
		DLFolder typeFolder = DLFolderLocalServiceUtil.fetchFolder(_themeDisplay.getScopeGroupId(), pdfFolder.getFolderId(), _type.toUpperCase());
		if(typeFolder == null) {
			typeFolder = DLFolderLocalServiceUtil.addFolder(_themeDisplay.getUserId(), _themeDisplay.getScopeGroupId(), _themeDisplay.getScopeGroupId(), false, pdfFolder.getFolderId(), _type.toUpperCase(), "", false, _serviceContext);
		}
		// get product folder
		DLFolder productFolder = DLFolderLocalServiceUtil.fetchFolder(_themeDisplay.getScopeGroupId(), typeFolder.getFolderId(), _productCode.toUpperCase());
		if(productFolder == null) {
			productFolder = DLFolderLocalServiceUtil.addFolder(_themeDisplay.getUserId(), _themeDisplay.getScopeGroupId(), _themeDisplay.getScopeGroupId(), false, typeFolder.getFolderId(), _productCode.toUpperCase(), "", false, _serviceContext);
		}
		
		return productFolder;
	}
	
	// generate pdf
	public FileEntry generate() {
		try {
			// init
			String tomcatBase = System.getProperty("catalina.base");
			long unixTime = System.currentTimeMillis() / 1000L;
			String fileName = "pdf-" + _type;
			// pdf name for policy
			if(_type.equals("policy")) {
				fileName = _leads.getReferenceNumber();
			}
			String ext = ".pdf";
			String outputFile = tomcatBase + "\\temp\\temp-" + fileName + "-" + unixTime + ".tmp";
			
			OutputStream outputStream = new FileOutputStream(outputFile);
			
			// render pdf
			///////////////////////////
		    ITextRenderer renderer = new ITextRenderer();
		    SharedContext sharedContext = renderer.getSharedContext();
		    sharedContext.setPrint(true);
		    sharedContext.setInteractive(false);
		    renderer.setDocumentFromString(getTemplate());
		    renderer.layout();
		    renderer.createPDF(outputStream);
		    
		    // save to document & media
		    ///////////////////////////
			File tempFile = new File(outputFile);
			Path path = tempFile.toPath();
			String mimeType = Files.probeContentType(path);
			
			long userId = _serviceContext.getUserId();
			long repositoryId = _themeDisplay.getScopeGroupId();
			DLFolder dlFolder = getFolder();
			
			// get unique filename
			String uniqueFileName = fileName + ext;
			int num = 1;
			while(_exists(dlFolder.getFolderId(), uniqueFileName) == true) {
				uniqueFileName = fileName + "_" + num + ext;
				num++;
			}
			
			// save to document & media
			FileEntry pdf = DLAppLocalServiceUtil.addFileEntry(userId, repositoryId, dlFolder.getFolderId(), uniqueFileName, mimeType, uniqueFileName, "", "", tempFile, _serviceContext);
			
			// delete temp file
			boolean delete = tempFile.delete();
			
			if (!delete) {
				log.info("Failed to delete temp file");
			}
			
			return pdf;
		} catch (DocumentException | IOException | PortalException | TemplateException e) {
			// TODO Auto-generated catch block
			log.info(e);
		}
		
		return null;
	}
}
