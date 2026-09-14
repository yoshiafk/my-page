<%@ include file="/init.jsp" %>

<%
	LocalDateTime timestampForJSURI = LocalDateTime.now();
	DateTimeFormatter formatterForJSURI = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	String numericTimestamptimestampForJSURI = timestampForJSURI.format(formatterForJSURI);
%>

<%
	String _step = "landing";
	String productName = (String) renderRequest.getAttribute("productName");
	String price = (String) renderRequest.getAttribute("price");
	List<SmartActiveBenefit> mainCover = (List<SmartActiveBenefit>) renderRequest.getAttribute("mainCover");
	List<SmartActiveBenefit> allowances = (List<SmartActiveBenefit>) renderRequest.getAttribute("allowances");
	List<SmartActiveBenefit> otherCover = (List<SmartActiveBenefit>) renderRequest.getAttribute("otherCover");
	List<SmartActiveFeature> features = (List<SmartActiveFeature>) renderRequest.getAttribute("features");
	List<SmartActiveLink> files = (List<SmartActiveLink>) renderRequest.getAttribute("files");
	List<Map.Entry<Long, String>> faqContents = (List<Map.Entry<Long, String>>) renderRequest.getAttribute("faqContents");
	String descriptionContent = (String) renderRequest.getAttribute("descriptionContent");
	String productAdvantagesContent = (String) renderRequest.getAttribute("productAdvantagesContent");
	String occupationExceptionContent = (String) renderRequest.getAttribute("occupationExceptionContent");
	String promoCode = Validator.isNotNull((String) renderRequest.getAttribute("pc")) ? (String) renderRequest.getAttribute("pc") : "";
	String utm_source = Validator.isNotNull((String) renderRequest.getAttribute("utm_source")) ? (String) renderRequest.getAttribute("utm_source") : "";
	String utm_medium = Validator.isNotNull((String) renderRequest.getAttribute("utm_medium")) ? (String) renderRequest.getAttribute("utm_medium") : "";
	String utm_campaign = Validator.isNotNull((String) renderRequest.getAttribute("utm_campaign")) ? (String) renderRequest.getAttribute("utm_campaign") : "";
	String utm_term = Validator.isNotNull((String) renderRequest.getAttribute("utm_term")) ? (String) renderRequest.getAttribute("utm_term") : "";
	String utm_content = Validator.isNotNull((String) renderRequest.getAttribute("utm_content")) ? (String) renderRequest.getAttribute("utm_content") : "";
	String prettyUrl = Validator.isNotNull((String) renderRequest.getAttribute("pu")) ? (String) renderRequest.getAttribute("pu") : "";
	String mobile = Validator.isNotNull((String) renderRequest.getAttribute("mobile")) ? (String) renderRequest.getAttribute("mobile") : "";
	
	String portalURL = themeDisplay.getPortalURL();
%>

<portlet:renderURL var="step2BaseURL">
	<portlet:param name="mvcPath" value="/step2.jsp"></portlet:param>
</portlet:renderURL>

<% 
    String step2URL = step2BaseURL;
    if (Validator.isNotNull(promoCode)) step2URL = step2URL + "&pc=" + promoCode;
    if (Validator.isNotNull(utm_source)) step2URL = step2URL + "&utm_source=" + utm_source;
    if (Validator.isNotNull(utm_medium)) step2URL = step2URL + "&utm_medium=" + utm_medium;
    if (Validator.isNotNull(utm_campaign)) step2URL = step2URL + "&utm_campaign=" + utm_campaign;
    if (Validator.isNotNull(utm_term)) step2URL = step2URL + "&utm_term=" + utm_term;
    if (Validator.isNotNull(utm_content)) step2URL = step2URL + "&utm_content=" + utm_content;
    if (Validator.isNotNull(mobile)) step2URL = step2URL + "&mobile=" + mobile;
%>

<% if (Validator.isNull(mobile)) { %>
	<%@ include file="/includes/navbar.jsp" %>
<% } %>

<header class="hero<% if (Validator.isNotNull(mobile)) { %> hero-mobile<% } %>">
    <div class="hero__home<% if (Validator.isNotNull(mobile)) { %> hero-mobile__home<% } %>">
        <div class="hero__home--grid">
            <div class="col">
                <img src="/o/mypage-theme/images/banner_home_sa.jpg" alt="">
            </div>
            <div class="col">
                <h1><%= productName.isEmpty() == false ? productName.replace(" SmartActive", "<br>SmartActive") : "Asuransi Kecelakaan Diri<br>SmartActive" %></h1>
                <p>
                    Bebas beraktivitas apapun dengan SmartActive!
                </p>
                <div class="card-hero_sa">
                    <div class="card-header-hero">
                        <h3>SmartActive</h3>
                    </div>
                    <div class="card-body-hero">
                        <%= descriptionContent %>
                    </div>
                    <div class="card-footer-hero">
                        <p class="agency__text_axa_bluesky_900">Mulai Dari</p>
                        <div class="card-footer-hero__flex">
                            <div class="card-footer-hero__left">
                                <div class="price">
                                    <span class="display-block agency__text_axa_bluesky_900"><%= price %></span>
                                </div>
                                <small class="agency__text_axa_bluesky_900">*syarat & ketentuan berlaku</small>
                            </div>
                            <div class="card-footer-hero__right">
                                <a href="javascript:void(0)" class="btn btn--dark-blue-outline buy-btn">
                                    <span class="position-relative">Beli Polis <i class="fas fa-arrow-right"></i></span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<div class="main-smartactive">
    <div class="container-axa">
        <div class="main-smartactive-inner">
            <div class="main-smartactive-inner__left">
                <div class="sticky-aside">
                    <ul class="sticky-aside-nav">
                        <li class="aside-link-pane Sec-1 is-active">
                            <a href="#Sec-1">Keunggulan Produk</a>
                        </li>
                        <li class="aside-link-pane Sec-2">
                            <a href="#Sec-2">Manfaat</a>
                        </li>
                        <li class="aside-link-pane Sec-3">
                            <a href="#Sec-3">FAQ</a>
                        </li>
                    </ul>
                    <ul class="download-tab">
                    	<% if (files.size() > 0) { %>
	                    	<% for (SmartActiveLink itemFile : files) { %>
		                        <li>
		                            <a class="display-flex gap-4level" href="#Sec-4">
		                                <span><%= itemFile.getTitle().replace("-", "").replace("FormulirKlaim", "Formulir Klaim").replace("AsuransiSmartActive", "") %></span>
		                            </a>
		                        </li>
							<% } %>
						<% } %>
                    </ul>
                </div>
            </div>
            <div class="main-smartactive-inner__right">
            	<section class="sa-product-excellence">
                    <h1>Bebas Beraktivitas, Mengejar Impian dan Explore Pengalaman Hidup Tanpa Khawatir</h1>

					<div class="product">
					    <div class="display-flex-responsive gap-6level">
						    <% if (Validator.isNotNull(productAdvantagesContent)) { %>
				            	<%= productAdvantagesContent %>
				            <% } %>
					    </div>
					</div>
                </section>
                
                <section class="sa-product-excellence" id="Sec-1">
                    <h1>Keunggulan Produk</h1>

                    <div class="card-product-excellence-wrapper">
                    	<% if (features.size() > 0) { %>
                    		<% for (SmartActiveFeature itemFeature : features) { %>
                    			<div class="card-product-excellence">
									<%
										if (itemFeature.getFileUploadEntryId() > 0) {
											FileEntry image = DLAppLocalServiceUtil.getFileEntry(itemFeature.getFileUploadEntryId()); 
									%>
										<liferay-adaptive-media:img class="placeholder-img" fileVersion="<%= image.getFileVersion() %>" />
									<% } else { %>
		                            	<img src="/o/mypage-theme/images/icon_accident.svg">
		                            <% } %>
		                            <p><%= itemFeature.getTitle() %></p>
		                            <%= itemFeature.getDescription() %>
		                        </div>
                    		<% } %>
                    	<% } %>
                    </div>
                </section>

                <section class="sa-key-benefits" id="Sec-2">
                    <h1>Manfaat</h1>
                    <div class="panel-table">
                        <div class="panel-table-header">
                            <h3>Manfaat Utama</h3>
                        </div>
                        <div class="panel-table-body">
                            <div class="table-wrapper">
                                <table class="table-axa">
                                    <tbody>
                                    	<% if (mainCover.size() > 0) { %>
	                                    	<% for (SmartActiveBenefit itemMainCover : mainCover) { %>
		                                        <tr>
		                                            <td>
		                                                <span><%= itemMainCover.getNameId() %></span>
		                                                <a href="javascript:void(0)" class="info-link" data-target="<%= itemMainCover.getUserName() %>">?</a>
		                                            </td>
		                                            <% if (itemMainCover.getNameId().contains("Jaminan A")) { %>
			                                            <td rowspan="2">
			                                                <%= itemMainCover.getLimit_() %>
			                                            </td>
		                                            <% } %>
		                                        </tr>
											<% } %>
										<% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div class="panel-table">
                        <div class="panel-table-header">
                            <h3>Santunan (Tambahan)</h3>
                        </div>
                        <div class="panel-table-body">
                            <div class="table-wrapper">
                                <table class="table-axa">
                                    <tbody>
                                    	<% if (allowances.size() > 0) { %>
	                                    	<% for (SmartActiveBenefit itemAllowances : allowances) { %>
		                                        <tr>
		                                            <td>
		                                                <span><%= itemAllowances.getNameId() %></span>
		                                                <a href="javascript:void(0)" class="info-link" data-target="<%= itemAllowances.getUserName() %>">?</a>
		                                            </td>
		                                            <td>
		                                                <%= itemAllowances.getLimit_() %>
		                                            </td>
		                                        </tr>
		                                    <% } %>
										<% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div class="panel-table">
                        <div class="panel-table-header">
                            <h3>Manfaat Lainnya</h3>
                        </div>
                        <div class="panel-table-body">
                            <div class="table-wrapper">
                                <table class="table-axa">
                                    <tbody>
                                    	<% if (otherCover.size() > 0) { %>
	                                    	<% for (SmartActiveBenefit itemOtherCover : otherCover) { %>
		                                        <tr>
		                                            <td>
		                                                <span><%= itemOtherCover.getNameId() %></span>
		                                                <a href="javascript:void(0)" class="info-link" data-target="<%= itemOtherCover.getUserName() %>">?</a>
		                                            </td>
		                                            <td>
		                                                <%= itemOtherCover.getLimit_() %>
		                                            </td>
		                                        </tr>
		                                    <% } %>
										<% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div class="panel-bg-color">
                        <div class="panel-bg-header">
                            <h3>JENIS PEKERJAAN DAN AKTIVITAS TERTANGGUNG YANG DIKECUALIKAN</h3>
                        </div>
                        <div class="panel-bg-color-body">
                        	<% if (Validator.isNotNull(occupationExceptionContent)) { %>
				            	<%= occupationExceptionContent %>
				            <% } %>
                        </div>
                    </div>
                </section>
				
				<% if (faqContents.size() > 0) { %>
	                <section class="sa-faq" id="Sec-3">
	                    <h1>FAQ</h1>
	                    <div class="accordion" id="accordionFAQ">
	                		<% for (Map.Entry<Long, String> itemFaqContent : faqContents) { %>
	                			<%= itemFaqContent.getValue() %>
	                		<% } %>        
	                    </div>
	                </section>
	            <% } %>

				<% if (files.size() > 0) { %>
	                <section class="sa-download" id="Sec-4">
	                    <h1>Unduh</h1>
	
	                    <div class="table-wrapper">
	                        <table class="table-axa">
	                            <tbody>
	                            	<% for (SmartActiveLink itemFile : files) { %>
	                            		<fmt:formatDate value="<%= itemFile.getCreateDate() %>" pattern="d MMM yyyy" var="formattedDate" />
		                                <tr>
		                                    <td><i class="icon file-pdf"></i></td>
			                                <td>
			                                    <div class="td-inner">
			                                        <p class="agency__normalcase"><%= itemFile.getTitle() %></p>
			                                    </div>
			                                </td>
			                                <td><p class="date agency__uppercase">${ formattedDate }</p></td>
			                                <td>
			                                    <div class="agency__text-center">
			                                        <a href="<%= itemFile.getFileUploadUrl() %>" target="_blank" class="btn btn--dark-blue text-sm agency__text-center">
			                                            <span class="position-relative order-10">Download</span>
			                                            <svg class="position-relative order-10" xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 17 16" fill="none">
			                                                <path d="M3.31006 13.615C3.57261 13.8798 3.92871 14.0285 4.30001 14.0285H12.7C13.0713 14.0285 13.4274 13.8798 13.69 13.615M8.50079 1.9707V9.9707M8.50079 9.9707L11.7008 6.91394M8.50079 9.9707L5.30079 6.91394" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
			                                            </svg>
			                                        </a>
			                                    </div>
			                                </td>
			                            </tr>
			                        <% } %>
		                        </tbody>
	                        </table>
	                    </div>
	                </section>
				<% } %>
            </div>
        </div>
    </div>
</div>

<div class="banner-bottom">
    <div class="banner-bottom__inner">
        <div class="col align-self-center">
            <div class="col--inner">
                <h1>Klaim mudah <br />dengan AXA MyInsurance</h1>
                <a class="btn btn--white" href="javascript:void(0)">
                    <span class="position-relative order-10">lihat sekarang</span>
                </a>
            </div>
        </div>
        <div class="col">
            <img src="/o/mypage-theme/images/banner_teman_emma.jpg" alt="">
        </div>
    </div>
</div>

<%@ include file="/includes/modal.jsp" %>

<script type="text/javascript">
	var _nextStepURL = "<%= step2URL %>";
	var _apiURL = "<%= portalURL %>";
	var _step = "<%= _step %>";
</script>
<script src="<%= request.getContextPath() %>/js/main.js?v=<%= numericTimestamptimestampForJSURI %>" type="text/javascript"></script>
<script type="text/javascript">
	let sessionData = sessionStorage.getItem(_smartActiveFormDetailSess);
	if (sessionData) {
		sessionData = JSON.parse(sessionData);
		
		if (sessionData.ManagedBy) {
			sessionStorage.clear();
		}
	}
</script>
<script src="<%= request.getContextPath() %>/js/step1.js?v=<%= numericTimestamptimestampForJSURI %>" type="text/javascript"></script>

<% if (Validator.isNull(mobile)) { %>
	<%@ include file="/includes/footer.jsp" %>
<% }%>