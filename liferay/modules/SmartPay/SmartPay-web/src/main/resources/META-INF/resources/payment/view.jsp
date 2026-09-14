<%@ include file="../init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%
	String vaBca = (String) renderRequest.getAttribute("vaBca");
	String vaMandiri = (String) renderRequest.getAttribute("vaMandiri");
%>

<%@ include file="../includes/header.jsp" %>

<portlet:resourceURL id="getdatapayment" var="loadPaymentDataURL" />
<portlet:resourceURL id="setinternalpayment" var="loadPaymentInternalDataURL" />
<portlet:resourceURL id="setdokupayment" var="loadPaymentDokuDataURL" />
<portlet:resourceURL id="/auth/out" var="outURL" />

<div class="checkout-page">
    <div class="container-axa">
        <div class="checkout-page__grid">
            <div class="col-grid">
                <div class="bg-white-border p-20px-35px">
                    <h1 class="text-responsive-32px mb-8px">Halaman Pembayaran</h1>
                    <p>Pilih metode pembayaran yang ingin anda gunakan</p>

                    <div class="payment-method__list">
                    
                    	<% if (Validator.isNotNull(vaMandiri)) { %>
	                        <ul class="virtual-account-type">
	                            <li class="flex-justify-between">
	                                <div class="display-inline-flex position-relative align-items-center align-self-center radio-custom-wrapper">
	                                    <input id="va-mandiri" class="radio-custom" name="type" type="radio" data-target="VIRTUAL_ACCOUNT_BANK_MANDIRI">
	                                    <label for="va-mandiri" class="radio-custom-label mb-0px"><span class="c-pointer">Virtual Account Mandiri</span></label>
	                                 </div>
	                                 <div class="type-payment display-flex gap-8px">
	                                    <span class="mandiri-bank"></span>
	                                 </div>
	                            </li>
	                        </ul>
                        <% } %>
						
						<% if (Validator.isNotNull(vaBca)) { %>
	                        <ul class="virtual-account-type">
	                            <li class="flex-justify-between">
	                                <div class="display-inline-flex position-relative align-items-center align-self-center radio-custom-wrapper">
	                                    <input id="va-bca" class="radio-custom" name="type" type="radio" data-target="VIRTUAL_ACCOUNT_BCA">
	                                    <label for="va-bca" class="radio-custom-label mb-0px"><span class="c-pointer">Virtual Account BCA</span></label>
	                                </div>
	                                 <div class="type-payment display-flex gap-8px">
	                                    <span class="bca-bank"></span>
	                                 </div>
	                            </li>
	                        </ul>
	                    <% } %>
                        
                        <ul class="virtual-account-type">
                            <li class="flex-justify-between">
                                <div class="display-inline-flex position-relative align-items-center align-self-center radio-custom-wrapper">
                                    <input id="va-bsi" class="radio-custom" name="type" type="radio" data-target="VIRTUAL_ACCOUNT_BANK_SYARIAH_MANDIRI">
                                    <label for="va-bsi" class="radio-custom-label mb-0px"><span class="c-pointer">Virtual Account BSI</span></label>
                                </div>
                                 <div class="type-payment display-flex gap-8px">
                                    <span class="bsi-bank"></span>
                                 </div>
                            </li>
                        </ul>
                        
                        <ul class="virtual-account-type">
                            <li class="flex-justify-between">
                                <div class="display-inline-flex position-relative align-items-center align-self-center radio-custom-wrapper">
                                    <input id="va-bri" class="radio-custom" name="type" type="radio" data-target="VIRTUAL_ACCOUNT_BRI">
                                    <label for="va-bri" class="radio-custom-label mb-0px"><span class="c-pointer">Virtual Account BRI</span></label>
                                </div>
                                 <div class="type-payment display-flex gap-8px">
                                    <span class="bri-bank"></span>
                                 </div>
                            </li>
                        </ul>
                        
                        <ul class="virtual-account-type">
                            <li class="flex-justify-between">
                                <div class="display-inline-flex position-relative align-items-center align-self-center radio-custom-wrapper">
                                    <input id="va-bni" class="radio-custom" name="type" type="radio" data-target="VIRTUAL_ACCOUNT_BNI">
                                    <label for="va-bni" class="radio-custom-label mb-0px"><span class="c-pointer">Virtual Account BNI</span></label>
                                </div>
                                 <div class="type-payment display-flex gap-8px">
                                    <span class="bni-bank"></span>
                                 </div>
                            </li>
                        </ul>
                        
                        <ul class="virtual-account-type">
                            <li class="flex-justify-between">
                                <div class="display-inline-flex position-relative align-items-center align-self-center radio-custom-wrapper">
                                    <input id="va-doku" class="radio-custom" name="type" type="radio" data-target="VIRTUAL_ACCOUNT_DOKU">
                                    <label for="va-doku" class="radio-custom-label mb-0px"><span class="c-pointer">Virtual Account Doku</span></label>
                                </div>
                                 <div class="type-payment display-flex gap-8px">
                                    <span class="doku-bank"></span>
                                 </div>
                            </li>
                        </ul>
                        
                        <ul class="virtual-account-type">
                            <li class="flex-justify-between">
                                <div class="display-inline-flex position-relative align-items-center align-self-center radio-custom-wrapper">
                                    <input id="va-permata" class="radio-custom" name="type" type="radio" data-target="VIRTUAL_ACCOUNT_BANK_PERMATA">
                                    <label for="va-permata" class="radio-custom-label mb-0px"><span class="c-pointer">Virtual Account Permata</span></label>
                                </div>
                                 <div class="type-payment display-flex gap-8px">
                                    <span class="permata-bank"></span>
                                 </div>
                            </li>
                        </ul>
                        
                        <ul class="virtual-account-type">
                            <li class="flex-justify-between">
                                <div class="display-inline-flex position-relative align-items-center align-self-center radio-custom-wrapper">
                                    <input id="va-cimb" class="radio-custom" name="type" type="radio" data-target="VIRTUAL_ACCOUNT_BANK_CIMB">
                                    <label for="va-cimb" class="radio-custom-label mb-0px"><span class="c-pointer">Virtual Account CIMB</span></label>
                                </div>
                                 <div class="type-payment display-flex gap-8px">
                                    <span class="cimb-bank"></span>
                                 </div>
                            </li>
                        </ul>
                        
                        <ul class="virtual-account-type">
                            <li class="flex-justify-between">
                                <div class="display-inline-flex position-relative align-items-center align-self-center radio-custom-wrapper">
                                    <input id="va-danamon" class="radio-custom" name="type" type="radio" data-target="VIRTUAL_ACCOUNT_BANK_DANAMON">
                                    <label for="va-danamon" class="radio-custom-label mb-0px"><span class="c-pointer">Virtual Account Danamon</span></label>
                                </div>
                                 <div class="type-payment display-flex gap-8px">
                                    <span class="danamon-bank"></span>
                                 </div>
                            </li>
                        </ul>

                        <ul class="cc">
                            <li class="flex-justify-between">
                                <div class="display-inline-flex position-relative align-items-center align-self-center radio-custom-wrapper">
                                    <input id="credit-card" class="radio-custom" name="type" type="radio" data-target="CREDIT_CARD">
                                    <label for="credit-card" class="radio-custom-label mb-0px"><span class="c-pointer">Kartu Kredit</span></label>
                                </div>
                                 <div class="type-payment display-flex gap-8px">
                                    <span class="visa"></span>
                                    <span class="mastercard"></span>
                                 </div>
                            </li>
                        </ul>

                        <ul class="dana">
                            <li class="flex-justify-between">
                                <div class="display-inline-flex position-relative align-items-center align-self-center radio-custom-wrapper">
                                    <input id="dana" class="radio-custom" name="type" type="radio" data-target="EMONEY_DANA">
                                    <label for="dana" class="radio-custom-label mb-0px"><span class="c-pointer">DANA</span></label>
                                </div>
                                 <div class="type-payment display-flex gap-8px">
                                    <span class="dana"></span>
                                 </div>
                            </li>
                        </ul>

                        <ul class="qris">
                            <li class="flex-justify-between">
                                <div class="display-inline-flex position-relative align-items-center align-self-center radio-custom-wrapper">
                                    <input id="qris" class="radio-custom" name="type" type="radio" data-target="QRIS">
                                    <label for="qris" class="radio-custom-label mb-0px"><span class="c-pointer">QRIS</span></label>
                                </div>
                                 <div class="type-payment display-flex gap-8px">
                                    <span class="qris"></span>
                                 </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-grid">
                <div class="bg-white-border">
                    <div class="summary__payment">
                        <div class="summary_payment-heading border-bottom">
                            <h1 class="text-responsive-32px">Rincian</h1>
                            <span><div class="skeleton skeleton-text"></div></span>
                            <ul class="total-details">
                                <li>Total Pembayaran</li>
                                <li><div class="skeleton skeleton-text-right"></div></li>
                            </ul>
                        </div>

                        <div class="summary_payment-body border-bottom">
                            <ul class="summary-pay__policy">
                                <li>
                                    <p>Nama</p>
                                    <span><div class="skeleton skeleton-text"></div></span>
                                </li>
                                <li>
                                    <p>Email</p>
                                    <span><div class="skeleton skeleton-text"></div></span>
                                </li>
                                <li>
                                    <p>No Kontak</p>
                                    <span><div class="skeleton skeleton-text"></div></span>
                                </li>
                            </ul>
                        </div>

                        <div class="summary-button">
                            <a href="javascript:;" class="btn btn--dark-blue width-full display-block align-text-center p-15px-15px-15px-18px payment-internal">
                                <span class="position-relative order-10">Lanjut ke pembayaran <i class="fas fa-arrow-right fa-fw ml-5px"></i></span>
                            </a>
                            <a href="javascript:;" class="btn btn--dark-blue width-full display-block align-text-center p-15px-15px-15px-18px display-none payment-doku">
                                <span class="position-relative order-10">Lanjut ke pembayaran <i class="fas fa-arrow-right fa-fw ml-5px"></i></span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<liferay-util:html-bottom outputKey="htmlbottom">
	<script>
		window.loadPaymentDataURL = "<%= loadPaymentDataURL %>";
		window.loadPaymentInternalDataURL = "<%= loadPaymentInternalDataURL %>";
		window.loadPaymentDokuDataURL = "<%= loadPaymentDokuDataURL %>";
		window.outURL = "<%= outURL %>";
	</script>
	<script src="<%= request.getContextPath() %>/payment/js/main.js" type="text/javascript"></script>
	<script src="<%= request.getContextPath() %>/includes/js/main.js" type="text/javascript"></script>
</liferay-util:html-bottom>