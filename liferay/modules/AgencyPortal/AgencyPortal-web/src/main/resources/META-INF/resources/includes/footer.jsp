<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="com.mypage.user.model.MypageUser"%>
<%@ include file="../init.jsp"%>

<%
	MypageUser myPageUser = (MypageUser) renderRequest.getAttribute("myPageUser");
%>

<footer>
		<div class="footer__inner">
			<div class="container-axa">
				<div class="footer-wrapper">
					<div class="footer-wrapper__grid">
						<div class="footer-wrapper__sitemap">
							<div class="footer-wrapper__sitemap--inner">
								<div class="col-sitemap">
									<h5>Solusi Kami</h5>
									<ul>
										<li class="mb-12px"><a href="https://mypage.axa.co.id/our-solution/asuransi-perjalanan" target="_blank">Asuransi Perjalanan</a></li>
										<li class="mb-12px"><a href="https://mypage.axa.co.id/our-solution/asuransi-kendaraan" target="_blank">Asuransi Kendaraan</a></li>
										<li class="mb-12px"><a href="https://mypage.axa.co.id/our-solution/asuransi-kesehatan-dan-jiwa" target="_blank">Asuransi Kesehatan</a></li>
										<li class="mb-0"><a href="https://mypage.axa.co.id/our-solution/more" target="_blank">Asuransi Lainnya</a></li>
									</ul>
								</div>
								<div class="col-sitemap">
									<h5>AXA Insurance</h5>
									<ul>
										<li class="mb-12px"><a href="https://mypage.axa.co.id/policy-check" target="_blank">Kirim Ulang Polis</a></li>
										<li class="mb-12px"><a href="https://mypage.axa.co.id/policy-endorsement/" target="_blank">Ganti Polis</a></li>
										<li class="mb-12px"><a href="https://axa.co.id/in/tentang-axainsurance?_gl=1*tq3f38*_ga*MTU1ODAxNjU2OS4xNzAxMjQ0MjIx*_ga_QXR0HLF191*MTcwMTI0NDIyMS4xLjEuMTcwMTI0NDY0My4wLjAuMA.." target="_blank">Tentang Asuransi AXA</a></li>
										<li class="mb-12px"><a href="https://axa.co.id/kebijakan-privasi/?_gl=1*1ndho2f*_ga*MTU1ODAxNjU2OS4xNzAxMjQ0MjIx*_ga_QXR0HLF191*MTcwMTI0NDIyMS4xLjEuMTcwMTI0NDY1NS4wLjAuMA.." target="_blank">Ketentuan Privasi</a></li>
										<li class="mb-12px"><a href="https://axa.co.id/kebijakan-cookie?_gl=1*1ndho2f*_ga*MTU1ODAxNjU2OS4xNzAxMjQ0MjIx*_ga_QXR0HLF191*MTcwMTI0NDIyMS4xLjEuMTcwMTI0NDY1NS4wLjAuMA.." target="_blank">Ketentuan Cookie</a></li>
										<li class="mb-12px"><a href="contact_us.html">Kontak Kami</a></li>
										<li><a href="https://mypage.axa.co.id/tata-cara-pengajuan-klaim" target="_blank">Informasi Klaim</a></li>
									</ul>
								</div>
								<div class="col-sitemap">
									<h5>Umum</h5>
									<ul>
										<li><a href="https://mypage.axa.co.id/news/" target="_blank">Berita / Promosi</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="footer-wrapper__contact">
							<address class="not-italic text-16px">
								<h5>Butuh bantuan?</h5>
								<div class="flex mb-12px phone-contact">
									<a class="text-white" href="#">
										<span class="flex">
											<span><i class="text-12px fas fa-phone-alt mr-8px"></i></span>
											<span> 1 500 733</span>
										</span>
									</a>
									<span class="text-white inline-block ml-8px">(Senin - Jumat, 08:00 - 17:00 WIB)</span>
								</div>
								<div class="flex phone-contact">
									<a class="text-white" href="#">
										<span class="flex">
											<span><i class="text-15px fab fa-whatsapp mr-8px"></i></span>
											<span>0811 1500 733</span>
										</span>
									</a>
									<span class="text-white inline-block ml-8px">Chatbot (24 jam)</span>
								</div>
							</address>
							<div class="social-media mt-8">
								<h5>Ikuti AXA</h5>
								<ul>
									<li><a href="https://www.facebook.com/axaindonesia" target="_blank"><i class="fab fa-facebook-f"></i></a></li>
									<li><a href="https://www.linkedin.com/company/axa-insurance-indonesia/" target="_blank"><i class="fab fa-linkedin-in"></i></a></li>
									<li><a href="https://www.youtube.com/user/axaindonesia" target="_blank"><i class="fab fa-youtube"></i></a></li>
									<li>
										<a class="group" href="https://www.instagram.com/axaindonesia" target="_blank">
											<svg class="w-19px-h-26px" xmlns="http://www.w3.org/2000/svg" version="1.2" viewBox="0 0 48 49"><path fill-rule="evenodd" class="a" d="m46.8 34.2c-0.1 3.7-1 6.9-3.6 9.6-2.7 2.7-5.9 3.5-9.6 3.7-3.1 0.2-6.3 0.1-9.4 0.1-3.2 0-6.3 0.1-9.4-0.1-3.7-0.2-6.9-1-9.6-3.7-2.7-2.7-3.5-5.9-3.7-9.6-0.2-3.1-0.1-6.2-0.1-9.4 0-3.1-0.1-6.3 0.1-9.4 0.2-3.7 1-6.9 3.7-9.6 2.7-2.6 5.9-3.5 9.6-3.6 3.1-0.2 6.2-0.2 9.4-0.2 3.1 0 6.3 0 9.4 0.2 3.7 0.1 6.9 1 9.6 3.6 2.6 2.7 3.5 5.9 3.6 9.6 0.2 3.1 0.2 6.3 0.2 9.4 0 3.2 0 6.3-0.2 9.4zm-10.9-9.4c0-6.5-5.2-11.7-11.7-11.7-6.5 0-11.7 5.2-11.7 11.7 0 6.5 5.2 11.7 11.7 11.7 6.5 0 11.7-5.2 11.7-11.7zm-11.7 7.6c-4.2 0-7.6-3.4-7.6-7.6 0-4.2 3.4-7.6 7.6-7.6 4.2 0 7.6 3.4 7.6 7.6 0 4.2-3.4 7.6-7.6 7.6zm13.2-17.2q0.5-0.3 0.9-0.6 0.4-0.4 0.6-0.9 0.2-0.5 0.2-1.1c0-1.5-1.2-2.7-2.7-2.7-1.5 0-2.8 1.2-2.8 2.7 0 1.5 1.3 2.8 2.8 2.8q0.5 0 1-0.2z"/></svg>
										</a>
									</li>
									<li><a href="https://twitter.com/AXAIndonesia" target="_blank"><i class="fab fa-twitter"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="copyright">
				<div class="copyright__wrapper">
					<p class="text-white text-13px text-center line-height-1-85"><a href="https://www.axa-mandiri.co.id/disclaimer-ownership" target="_blank">Disclaimer & Ownership</a>. Copyright 2018-2023 PT AXA Insurance Indonesia. PT AXA Insurance Indonesia merupakan perusahaan <br/>asuransi yang berizin dan diawasi oleh Otoritas Jasa Keuangan</p>
				</div>
			</div>
		</div>
	</footer>