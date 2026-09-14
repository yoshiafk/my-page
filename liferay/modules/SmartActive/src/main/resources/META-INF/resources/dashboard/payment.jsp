<%@ include file="../init.jsp" %>

<%@ include file="../includes/navbar.jsp" %>

<%
	String _step = "payment";
%>

<header class="hero">
	<img src="/o/mypage-theme/images/banner_step_sa.jpg" alt="Axa SmartActive" class="width-full height-full">
</header>

<section class="step-four" id="Step-4">
	<%@ include file="../includes/stepbar.jsp" %>

	<div class="sa-payment">
		<div class="container-axa">
			<div class="payment-grid">
				<div class="sa-payment__left">
					<div class="panel">
                        <div class="panel__heading"><h1>Pembayaran</h1></div>
                        <div class="panel__body">
                            <p>Pilih metode pembayaran yang ingin anda gunakan</p>

                            <div class="radio-group">
                                <div class="radio-payment" data-radio="kartu_kredit">
                                    <div>
                                        <div class="display-inline-flex align-items-center align-self-center sa-radio-custom-wrapper">
                                            <input id="kartu_kredit" class="radio-custom" name="payment_method" type="radio">
                                            <label for="kartu_kredit" class="sa-label sa-radio-custom-label mb-0px">
                                                <span class="radio-cloak"></span>
                                                <span>Kartu Kredit</span>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="display-flex spacex-2">
                                        <img src="/o/mypage-theme/images/mastercard.png" alt="mastercard">
                                        <img src="/o/mypage-theme/images/visa.png" alt="visa">
                                    </div>
                                </div>

                                <div class="radio-payment" data-radio="virtual_account">
                                    <div>
                                        <div class="display-inline-flex align-items-center align-self-center sa-radio-custom-wrapper">
                                            <input id="virtual_account" class="radio-custom" name="payment_method" type="radio">
                                            <label for="virtual_account" class="sa-label sa-radio-custom-label mb-0px">
                                                <span class="radio-cloak"></span>
                                                <span>Virtual Account</span>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="display-flex spacex-2">
                                        <img src="/o/mypage-theme/images/BCA.png" alt="bca">
                                        <img src="/o/mypage-theme/images/Permata.png" alt="permata">
                                        <img src="/o/mypage-theme/images/Mandiri.png" alt="mandiri">
                                    </div>
                                </div>

                                <div class="radio-payment" data-radio="cicilan">
                                    <div class="display-inline-flex align-items-center align-self-center sa-radio-custom-wrapper">
                                        <input id="cicilan" class="radio-custom" name="payment_method" type="radio">
                                        <label for="cicilan" class="sa-label sa-radio-custom-label mb-0px">
                                            <span class="radio-cloak"></span>
                                            <span>Cicilan 0%</span>
                                        </label>
                                    </div>
                                    <div class="display-flex spacex-2">
                                        <img src="/o/mypage-theme/images/BNI.png" alt="bni">
                                        <img src="/o/mypage-theme/images/Mandiri.png" alt="mandiri">
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
				</div>

				<div class="sa-payment__right">
					<%@ include file="../includes/panel_summary.jsp" %>
				</div>
			</div>
		</div>
	</div>
</section>

<script src="<%= request.getContextPath() %>/dashboard/js/main.js" type="text/javascript"></script>

<%@ include file="../includes/footer.jsp" %>