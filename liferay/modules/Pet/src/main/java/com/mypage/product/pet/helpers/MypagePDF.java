package com.mypage.product.pet.helpers;

public class MypagePDF {
//	private ServiceContext _serviceContext;
//	private long _userId;
//	private long _groupId;
//	
//	private long _leadsId;
//	private Leads _leads;
//	
//	private String _productCode;
//	private String _type;
//	
//	private ProductConfiguration _productConfiguration;
//	
//	private static final Log _log = LogFactoryUtil.getLog(MypagePDF.class);
//	
//	public void setServiceContext(ServiceContext serviceContext) {
//		_serviceContext = serviceContext;
//		_userId = _serviceContext.getUserId();
//		_groupId = _serviceContext.getScopeGroupId();
//	}
//	
//	// SET LEADS
//	public void setLeads(long leadsId) {
//		_leadsId = leadsId;
//
//		try {
//			Leads leads = LeadsLocalServiceUtil.getLeads(leadsId);
//
//			if (!Validator.isNull(leads)) {
//				_leads = leads;
//				_productCode = leads.getProductCode().toLowerCase();
////				_payment = PaymentLocalServiceUtil.findByLeadsId(leadsId);
//				_productConfiguration = ProductConfigurationLocalServiceUtil.getConfigByCode(leads.getProductCode());
//			}
//		} catch (PortalException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	// SET TYPE
//	public void setType(String type) {
//		_type = type.toLowerCase();
//	}
//	
//	// CREATE UNIQUE NAME
//	private String createNameByDocumentType() {
//		String nameByDocumentType = "";
//		if (_type == null) {
//			nameByDocumentType = "";
//		} else {
//			switch (_type.toLowerCase()) {
//			case "policy_certificate":
//				nameByDocumentType = _leads.getReferenceNumber();
//				break;
//			case "quotation":
//				nameByDocumentType = _leads.getReferenceNumber();
//				break;
//			default:
//				nameByDocumentType = "";
//				break;
//			}
//		}
//
//		return nameByDocumentType;
//	}
//	
//	// TEMPLATE
//	public String getTemplate() throws IOException, TemplateException, JSONException {
//		String templateString = "";
//
//		// Set template directory and load template ftl file
//		Configuration cfg = new Configuration();
//		cfg.setClassForTemplateLoading(MypagePDF.class, "/META-INF/resources/pdf");
//		cfg.setDefaultEncoding("UTF-8");
//		Template template = cfg.getTemplate("/template/quotation_template.ftl");
//		
//		String jsonLeads = JSONFactoryUtil.looseSerialize(_leads);
//		JSONObject leads = JSONFactoryUtil.createJSONObject(jsonLeads);
//		
//		String jsonProduct = JSONFactoryUtil.looseSerialize(_productConfiguration);
//		JSONObject product = JSONFactoryUtil.createJSONObject(jsonProduct);
//		
//		Map templateData = new HashMap();
//		
//		templateData.put("leads", leads);
////		templateData.put("payment", _payment);
//		templateData.put("product", product);
//		
//		templateData.put("content", "/" + _productCode + "/" + _type + ".ftl");
//		templateData.put("baseUrl", getClass().getClassLoader().getResource("/META-INF/resources/pdf"));
//		
//		
//		// Pet Detail
////		if(_productCode.equals("pet")) {
//			DetailPet getDetail = null;
//			PetPlan plan = null;
//			
//			try {
//				getDetail = DetailPetLocalServiceUtil.searchByLeadsId(_leadsId);
//				plan = PetPlanLocalServiceUtil.getPetPlan(getDetail.getPlanId());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			// detail
//			templateData.put("detail", getDetail);
//			// plan
//			templateData.put("plan", plan);
////		}
//		
//		try (StringWriter out = new StringWriter()) {
//			template.process(templateData, out);
//			templateString = out.getBuffer().toString();
//			out.flush();
//		}
//		
//		return templateString;
//	}
//	
//	private boolean _exists(long folderId, String curFileName) {
//		try {
//			FileEntry tempFileEntry = DLAppLocalServiceUtil.getFileEntry(_groupId, folderId,
//					curFileName);
//			if (tempFileEntry != null) {
//				return true;
//			}
//
//			return false;
//		} catch (PortalException portalException) {
//			if (_log.isDebugEnabled()) {
//				_log.debug(portalException, portalException);
//			}
//
//			return false;
//		}
//	}
//	
//	private DLFolder getFolder() throws PortalException {
//		// Get pdf folder
//		DLFolder pdfFolder = DLFolderLocalServiceUtil.fetchFolder(_groupId, 0, "PDF");
//		if (pdfFolder == null) {
//			pdfFolder = DLFolderLocalServiceUtil.addFolder(_userId, _groupId,
//					_groupId, false, 0, "PDF", "", false, _serviceContext);
//		}
//		// Get policy / quotation folder
//		DLFolder typeFolder = DLFolderLocalServiceUtil.fetchFolder(_groupId,
//				pdfFolder.getFolderId(), _type.toUpperCase());
//		if (typeFolder == null) {
//			typeFolder = DLFolderLocalServiceUtil.addFolder(_userId, _groupId,
//					_groupId, false, pdfFolder.getFolderId(), _type.toUpperCase(), "", false,
//					_serviceContext);
//		}
//		// Get product folder
//		DLFolder productFolder = DLFolderLocalServiceUtil.fetchFolder(_groupId,
//				typeFolder.getFolderId(), _productCode.toUpperCase());
//		if (productFolder == null) {
//			productFolder = DLFolderLocalServiceUtil.addFolder(_userId,
//					_groupId, _groupId, false, typeFolder.getFolderId(),
//					_productCode.toUpperCase(), "", false, _serviceContext);
//		}
//
//		return productFolder;
//	}
//	
//	// GENERATE
//	public FileEntry generate() {
//		try {
//			String tomcatBase = System.getProperty("catalina.base");
//			long unixTime = System.currentTimeMillis() / 1000L;
//			String fileName = createNameByDocumentType();
//			
//			String ext = ".pdf";
//			String outputFile = tomcatBase + "\\temp\\temp-" + fileName + "-" + unixTime + ".tmp";
//			
//			OutputStream outputStream = new FileOutputStream(outputFile);
//			ITextRenderer renderer = new ITextRenderer();
//			SharedContext sharedContext = renderer.getSharedContext();
//			sharedContext.setPrint(true);
//			sharedContext.setInteractive(false);
//			renderer.setDocumentFromString(getTemplate());
//			renderer.layout();
//			renderer.createPDF(outputStream);
//			
//			File tempFile = new File(outputFile);
//			Path path = tempFile.toPath();
//			String mimeType = Files.probeContentType(path);
//			
//			DLFolder dlFolder = getFolder();
//			String uniqueFileName = fileName + ext;
//			int num = 1;
//			while (_exists(dlFolder.getFolderId(), uniqueFileName) == true) {
//				uniqueFileName = fileName + "_" + num + ext;
//				num++;
//			}
//			
//			FileEntry pdf = DLAppLocalServiceUtil.addFileEntry(_userId, _groupId, dlFolder.getFolderId(),
//					uniqueFileName, mimeType, uniqueFileName, "", "", tempFile, _serviceContext);
//			
//			tempFile.delete();
//	
//			return pdf;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
}
