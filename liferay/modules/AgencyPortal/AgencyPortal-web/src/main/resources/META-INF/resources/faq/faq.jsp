<%@page import="com.mypage.agencyportal.service.AgentFAQLocalServiceUtil"%>
<%@page import="com.mypage.agencyportal.model.AgentFAQ"%>
<%@page import="com.mypage.agencyportal.model.AgentFAQCategory"%>
<%@ include file="../init.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%
	List<AgentFAQCategory> categories= (List<AgentFAQCategory>)renderRequest.getAttribute("categories");
%>

<div class="breadcrumbs container-breadcrumbs-axa">
		<nav class="w-full">
			<ol class="list-reset display-inline-flex">
				<li class="text-13px agency-self-center">
					<a href="#">Beranda</a>
				</li>
				<li class="agency-self-center">
					<span class="text-13px">/</span>
				</li>
				<li class="text-13px agency-uppercase agency-self-center">Faq</li>
			</ol>
		</nav>
</div>

<div class="faq">
        <div class="container-axa">
            <div class="faq-grid">
                <div class="faq__left">
                    <h1>Kategori</h1>
                    <div class="top-2level" id="is-float">
                        <p class="mb-2level">Hal yang sering ditanyakan</p>
                        <div class="position-relative">
                            <select class="input-control filter-report" name="Faq-select" id="FaqSelect">
                                <option></option>
                                 <% for(int i = 0 ; i < categories.size(); i++ ) {  
                                	AgentFAQCategory category = categories.get(i);
                                	
                                	String labelCollapse = "collapse"+i+"ne";
                                	
                                %>
                                
                                <option value="#<%=labelCollapse %>"><%=category.getCategory() %></option>
                                
								<% } %>
								
                            </select>
                        </div>
                    </div>
                    <div id="sticky"></div>
                </div>
                <div class="faq__right mt-30px">
                    <div class="accordion-wrapper mt-8level lg:mt-20level lg:pl-10level">
                        <div class="accordion" id="accordionCategory">
                        	
                        	<% for(int i = 0 ; i < categories.size(); i++ ) {  
                                	AgentFAQCategory category = categories.get(i);
                                	
                                	String labelCollapse = "collapse"+i+"ne";
                                	
                                %>
                        	
                            <div class="accordion-item">
                                <div class="accordion-header">
                                    <%-- <button class="accordion-button text-24px agency-text-grey-800" data-bs-toggle="collapse" data-bs-target="#<%=labelCollapse %>" aria-expanded="false" aria-controls="<%=labelCollapse %>">
                                        <%=category.getCategory() %>
                                        <i class="fas fa-chevron-down position-absolute right-5level mt-1level text-14px"></i>
                                    </button> --%>
                                    
                                    <button 
									    class="accordion-button text-24px agency-text-grey-800" 
									    data-bs-toggle="collapse" 
									    data-bs-target="#<%=labelCollapse %>" 
									    aria-expanded="false" 
									    aria-controls="<%=labelCollapse %>" 
									    style="background-color: transparent; font-family: Publico;">
									    <%=category.getCategory() %>
									    <i class="fas fa-chevron-down position-absolute right-5level mt-1level text-14px"></i>
									</button>
                                </div>
                                <div id="<%=labelCollapse %>" class="accordion-collapse collapse" data-bs-parent="#accordionCategory">
                                	<div class="accordion" id="accordionFAQ">
                                		<% 
			                    		List<AgentFAQ> faqs = AgentFAQLocalServiceUtil.findByCategory(category.getCategory());
			                    		for(int j = 0; j < faqs.size(); j ++) { 
			                    			AgentFAQ faq = faqs.get(j);
			                    			String labelCollapseFAQ = "collapseFAQ"+j+"ne";
		                    			%>
	                                	<div class="accordion-item">
			                                <div class="accordion-header">
			                                    <button class="accordion-button agency-uppercase text-14px" data-bs-toggle="collapse" data-bs-target="#<%=labelCollapseFAQ %>" aria-expanded="false" aria-controls="<%=labelCollapseFAQ %>">
			                                        <%=faq.getTitle() %>
			                                        <i class="fas fa-chevron-down position-absolute right-5level mt-1level text-14px"></i>
			                                    </button>
			                                </div>
			                                <div id="<%=labelCollapseFAQ %>" class="accordion-collapse collapse" data-bs-parent="#accordionFAQ">
			                                    <div class="accordion-body">
						                            <p class="text-14px mb-4level">
						                            	<%=faq.getDescription() %>
						                            </p>
						                        </div> 
			                                </div>
			                            </div>
			                            <% } %>
                                	</div>
                                    
                                </div>
                            </div>
                            <% } %>
                        </div>

                    </div>
                </div>
            </div>
		</div>
    </div>

<script>
    var html = $("html");
    var body = $("body");

    html.addClass("html__agency");
    body.addClass("body__agency body-white");

    $(document).ready(function() {
        // Existing code for the parent accordion
        $('.accordion-button').on('click', function() {
            console.log($("#FaqSelect :selected").select2(this.data));
            sendHeightToParent();
        });

        function scrollToTarget(target) {
            setTimeout(function() {
                var element = document.querySelector(target);
                if (element) {
                    element.scrollIntoView({ behavior: 'smooth', block: 'start' });
                } else {
                    console.log('Target not found:', target);
                }
            }, 100);
        }

        $(function() {
            const myCollapsible = document.getElementById('accordionCategory');
            myCollapsible.addEventListener('shown.bs.collapse', event => {
                var target = '#' + event.target.id;
                console.log('Target shown:', target);
                $('#FaqSelect').val(target).change();
                scrollToTarget(target);
                sendHeightToParent(); // Call function when shown
            });

            myCollapsible.addEventListener('hidden.bs.collapse', event => {
                sendHeightToParent(); // Call function when hidden
            });
        });

        // Existing code for select2 initialization
        $('#FaqSelect').select2({
            width: '100%',
            dropdownParent: '.faq',
            placeholder: "Pilih Kategori",
            minimumResultsForSearch: -1,
        });

        $('#FaqSelect').on('change', function() {
            var target = $(this).val();
            console.log('Target selected:', target);
            $(target).collapse('show');
            scrollToTarget(target);
            sendHeightToParent();
        });

        // Adding event listeners to child accordions
        $('.accordion-collapse').on('shown.bs.collapse hidden.bs.collapse', function() {
            sendHeightToParent();
        });

        // Adding MutationObserver to monitor DOM changes
        const observer = new MutationObserver(function(mutations) {
            mutations.forEach(function(mutation) {
                if (mutation.type === 'childList') {
                    sendHeightToParent();
                }
            });
        });

        observer.observe(document.getElementById('accordionCategory'), {
            childList: true,
            subtree: true
        });
    });
    
    function sendHeightToParent() {
    	setTimeout(function() {
    		var contentElement = document.getElementById('content');
    		if (contentElement) {
    			var height = contentElement.scrollHeight;
    			//console.log('Sending height:', height);
    			window.parent.postMessage({ height: height }, '*');
    		} else {
    			console.error('Element with id "content" not found');
    		}
    	}, 100); // Delay 100ms
    }
    
 	// Call sendHeightToParent when the content of the iframe changes
    document.addEventListener('DOMContentLoaded', function() {
        sendHeightToParent();
    });

    window.addEventListener('resize', function() {
        sendHeightToParent();
    });
</script>
