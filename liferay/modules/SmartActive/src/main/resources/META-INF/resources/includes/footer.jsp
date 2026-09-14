<%
	List<MasterGlobalVariable> medias = (List<MasterGlobalVariable>) renderRequest.getAttribute("medias");
%>

<div id="mypage-loading-spinner-backdrop" class="mypage-loading-spinner-backdrop gohide">
	<div class="lds-ripple"><div></div><div></div></div>
</div>

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
										<span><i class="text-sm fas fa-phone-alt mr-8px"></i></span>
										<span> 1 500 733</span>
									</span>
								</a>
								<span class="text-white inline-block ml-8px">(Senin - Jumat, 08:00 - 17:00 WIB)</span>
							</div>
							<div class="flex phone-contact">
								<a class="text-white" href="#">
									<span class="flex">
										<span><i class="text-sm fab fa-whatsapp mr-8px"></i></span>
										<span>0811 1500 733</span>
									</span>
								</a>
								<span class="text-white inline-block ml-8px">Chatbot (24 jam)</span>
							</div>
						</address>
						<% if (medias.size() > 0) { %>
							<div class="social-media mt-32px">
								<h5>Ikuti AXA</h5>
								<ul>
									<% for (MasterGlobalVariable media : medias) { %>
										<li>
											<a href="<%= media.getValue() %>" target="_blank">
												<%
													String icon = media.getName().equalsIgnoreCase("facebook") ? "fab fa-facebook-f" :
																  media.getName().equalsIgnoreCase("linkedin") ? "fab fa-linkedin-in" :
																  media.getName().equalsIgnoreCase("youtube") ? "fab fa-youtube" :
																  media.getName().equalsIgnoreCase("instagram") ? "fab fa-instagram" :
																  media.getName().equalsIgnoreCase("twitter") ? "fab fa-twitter" : "";
												%>
												<i class="<%= icon %>"></i>
											</a>
										</li>
									<% } %>
								</ul>
							</div>
						<% } %>
					</div>
				</div>
			</div>
		</div>
		<div class="copyright">
			<div class="copyright__wrapper">
				<p class="text-white text-center"><a href="https://www.axa-mandiri.co.id/disclaimer-ownership" target="_blank">Disclaimer & Ownership</a>. Copyright 2018-2024 PT AXA Insurance Indonesia. PT AXA Insurance Indonesia merupakan perusahaan <br/>asuransi yang berizin dan diawasi oleh Otoritas Jasa Keuangan</p>
			</div>
		</div>
	</div>
</footer>