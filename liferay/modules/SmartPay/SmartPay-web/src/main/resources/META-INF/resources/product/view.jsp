<%@ include file="../init.jsp" %>

<%@ include file="../includes/header.jsp" %>

<portlet:resourceURL id="getdataproductsummary" var="loadProductSummaryDataURL" />
<portlet:resourceURL id="setdatatransaction" var="createTrxDataURL" />
<portlet:resourceURL id="/auth/out" var="outURL" />

<div class="summary-pay">
    <div class="container-axa">
        <div class="summary-pay__grid">
            <div class="col-grid">
                <div class="bg-white-border p-20px-35px">
                    <div class="summary-pay__heading">
                        <div class="col-heading">
                            <h1 class="text-responsive-32px">Data Produk</h1>
                        </div>
                        <div class="col-heading">
                            <p class="align-text-right">Periode Polis</p>
                            <span class="align-text-right"><div class="skeleton skeleton-text-right"></div></span>
                        </div>
                    </div>

                    <div class="summary-pay__product-name">
                        <p>Nama Produk</p>
                        <span><div class="skeleton skeleton-text"></div></span>
                    </div>

                    <div class="summary-pay__product-desc">
                        <div class="col-product-desc">
                            <p>No Polis</p>
                            <span><div class="skeleton skeleton-text"></div></span>
                        </div>
                        <div class="col-product-desc align-text-right">
                            <p>Uang pertanggungan</p>
                            <span><div class="skeleton skeleton-text"></div></span>
                        </div>
                    </div>

                    <div class="summary-pay__table">
                        <div class="table-wrapper">
                            <table class="width-full">
                                <thead>
                                    <tr>
                                        <th>No</th>
                                        <th>tanggal jatuh tempo</th>
                                        <th>nominal</th>
                                        <th>status</th>
                                    </tr>
                                </thead>
                                <tbody></tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="bg-white-border p-20px-35px mt-24px">
                    <div class="summary-pay__policy">
                        <h1 class="text-responsive-32px">Pemegang Polis</h1>
                        <ul>
                            <li>
                                <p>Nama Pemegang Polis</p>
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
                </div>
                
            </div>
            <div class="col-grid">
                <div class="bg-white-border shadow-lg">
                    <div class="summary__payment">
                        <div class="summary_payment-heading border-bottom">
                            <h1 class="text-responsive-32px">Pembayaran</h1>
                            <i>* Total tagihan yang perlu dibayarkan</i>
                        </div>
                        <div class="summary_payment-body">
                            <ul class="payment-list">
                                <li>
                                    <span>Gross Premium</span>
                                    <span class="align-text-right"><div class="skeleton skeleton-text-right"></div></span>
                                </li>
                                <li>
                                    <span>Discount</span>
                                    <span class="align-text-right"><div class="skeleton skeleton-text-right"></div></span>
                                </li>
                                <li>
                                    <span>Premi Netto</span>
                                    <span class="align-text-right"><div class="skeleton skeleton-text-right"></div></span>
                                </li>
                                <li>
                                    <span>Policy Cost</span>
                                    <span class="align-text-right"><div class="skeleton skeleton-text-right"></div></span>
                                </li>
                                <li>
                                    <span>Stamp Duty</span>
                                    <span class="align-text-right"><div class="skeleton skeleton-text-right"></div></span>
                                </li>
                            </ul>
                        </div>

                        <div class="summary-footer__total">
                            <ul class="total">
                                <li>
                                    <span>Jumlah</span>
                                    <span class="align-text-right"><div class="skeleton skeleton-text-right"></div></span>
                                </li>
                            </ul>
                        </div>

                        <div class="summary-footer">
                            <ul class="installment-desc">
                                <li>
                                    <span>Tahap Cicilan</span>
                                    <span class="align-text-right"><div class="skeleton skeleton-text-right"></div></span>
                                </li>
                                <li>
                                    <span>Premi Belum Jatuh Tempo</span>
                                    <span class="align-text-right"><div class="skeleton skeleton-text-right"></div></span>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="summary-button mt-16px">
                    <a href="javascript:;" class="btn btn--dark-blue width-full display-block align-text-center p-15px-15px-15px-18px link-payment">
                        <span class="position-relative order-10">Lanjut ke pembayaran <i class="fas fa-arrow-right fa-fw ml-5px"></i></span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<liferay-util:html-bottom outputKey="htmlbottom">
	<script>
		window.loadProductSummaryDataURL = "<%= loadProductSummaryDataURL %>";
		window.loadTrxURL = "<%= createTrxDataURL %>";
		window.outURL = "<%= outURL %>";
	</script>
	<script src="<%= request.getContextPath() %>/product/js/main.js" type="text/javascript"></script>
	<script src="<%= request.getContextPath() %>/includes/js/main.js" type="text/javascript"></script>
</liferay-util:html-bottom>