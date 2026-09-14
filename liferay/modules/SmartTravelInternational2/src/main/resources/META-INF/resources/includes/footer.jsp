<%@ include file="../init.jsp"%>

<%
	List<MasterGlobalVariable> medias = (List<MasterGlobalVariable>) renderRequest.getAttribute("medias");
%>

    <div id="mypage-loading-spinner-backdrop" class="mypage-loading-spinner-backdrop gohide">
    <div class="lds-ripple"><div></div><div></div></div>
    </div>
    
        <!-- Modal Sanction Country -->
    <div class="modal modal-axa-smarttravel fade" id="sanctionCountryModal" tabindex="-1" aria-labelledby="sanctionCountryModalLabel" aria-hidden="true" style="display: none">
  <div class="modal-dialog modal-axa-smarttravel-dialog modal-lg">
    <div class="modal-content modal-axa-smarttravel-content">
      <div class="modal-header modal-axa-smarttravel-header">
        <h1 class="modal-title fs-5 agency__text-center" id="sanctionCountryModalLabel">Informasi</h1>
      </div>
      <div class="modal-body modal-axa-smarttravel-body modal-axa-smarttravel-body__sanction-country">
        <div>
          <%= sanctionCountry %>
        </div>
        <br />
        <br />
        <div>
          <button class="btn btn__agency btn--dark-blue width-full h-54px" data-bs-dismiss="modal" aria-label="Close">Mengerti</button>
        </div>
      </div>
    </div>
  </div>
</div>
    
    <!-- End Modal sanction Country -->

<!-- MODAL ALERT -->
<div class="modal modal-axa-smarttravel fade" id="modal-alert" tabindex="-1" aria-labelledby="" aria-hidden="true" style="display: none">
  <div class="modal-dialog modal-axa-smarttravel-dialog modal-lg">
    <div class="modal-content modal-axa-smarttravel-content">
      <div class="modal-body modal-axa-smarttravel-body">
        <h3></h3>
      </div>
    </div>
  </div>
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
                                    <li class="mb-12px"><a
                                            href="https://mypage.axa.co.id/our-solution/asuransi-perjalanan"
                                            target="_blank">Asuransi Perjalanan</a></li>
                                    <li class="mb-12px"><a
                                            href="https://mypage.axa.co.id/our-solution/asuransi-kendaraan"
                                            target="_blank">Asuransi Kendaraan</a></li>
                                    <li class="mb-12px"><a
                                            href="https://mypage.axa.co.id/our-solution/asuransi-kesehatan-dan-jiwa"
                                            target="_blank">Asuransi Kesehatan</a></li>
                                    <li class="mb-0"><a href="https://mypage.axa.co.id/our-solution/more"
                                            target="_blank">Asuransi Lainnya</a></li>
                                </ul>
                            </div>
                            <div class="col-sitemap">
                                <h5>AXA Insurance</h5>
                                <ul>
                                    <li class="mb-12px"><a href="https://mypage.axa.co.id/policy-check"
                                            target="_blank">Kirim Ulang Polis</a></li>
                                    <li class="mb-12px"><a href="https://mypage.axa.co.id/policy-endorsement"
                                            target="_blank">Perubahan Polis</a></li>
                                    <li class="mb-12px"><a
                                            href="https://axa.co.id/in/tentang-axainsurance?_gl=1*1eekb5z*_gcl_au*OTI0ODgzMzAxLjE3MzE0ODk2MzE.*_ga*NDM0ODEzODQwLjE3MzE0ODk2MzE.*_ga_QXR0HLF191*MTczMTQ4OTYzMS4xLjAuMTczMTQ4OTYzMi4wLjAuMA.."
                                            target="_blank">Tentang AXA Insurance</a></li>
                                    <li class="mb-12px"><a
                                            href="https://axa.co.id/kebijakan-privasi/?_gl=1*1ndho2f*_ga*MTU1ODAxNjU2OS4xNzAxMjQ0MjIx*_ga_QXR0HLF191*MTcwMTI0NDIyMS4xLjEuMTcwMTI0NDY1NS4wLjAuMA.."
                                            target="_blank">Kebijakan Privasi</a></li>
                                    <li class="mb-12px"><a
                                            href="https://axa.co.id/kebijakan-cookie?_gl=1*1ndho2f*_ga*MTU1ODAxNjU2OS4xNzAxMjQ0MjIx*_ga_QXR0HLF191*MTcwMTI0NDIyMS4xLjEuMTcwMTI0NDY1NS4wLjAuMA.."
                                            target="_blank">Kebijakan Cookie</a></li>
                                    <li class="mb-12px"><a href="contact_us.html">Hubungi Kami</a></li>
                                    <li><a href="https://mypage.axa.co.id/tata-cara-pengajuan-klaim"
                                            target="_blank">Informasi Klaim</a></li>
                                </ul>
                            </div>
                            <div class="col-sitemap">
                                <h5>Umum</h5>
                                <ul>
                                    <li><a href="https://mypage.axa.co.id/news/" target="_blank">Berita /
                                            Promosi</a></li>
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
                                <span class="text-white inline-block ml-8px">(Senin - Jumat, 08:00 - 17:00
                                    WIB)</span>
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
                        <% if (medias.size() > 0) { %>
                        <div class="social-media mt-8">
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
<!--                                 <li><a href="https://www.facebook.com/axaindonesia" target="_blank"><i -->
<!--                                             class="fab fa-facebook-f"></i></a></li> -->
<!--                                 <li><a href="https://www.linkedin.com/company/axa-insurance-indonesia/" -->
<!--                                         target="_blank"><i class="fab fa-linkedin-in"></i></a></li> -->
<!--                                 <li><a href="https://www.youtube.com/user/axaindonesia" target="_blank"><i -->
<!--                                             class="fab fa-youtube"></i></a></li> -->
<!--                                 <li> -->
<!--                                     <a class="group" href="https://www.instagram.com/axaindonesia" target="_blank"> -->
<!--                                         <svg class="w-19px-h-26px" xmlns="http://www.w3.org/2000/svg" version="1.2" -->
<!--                                             viewBox="0 0 48 49"> -->
<!--                                             <path fill-rule="evenodd" class="a" -->
<!--                                                 d="m46.8 34.2c-0.1 3.7-1 6.9-3.6 9.6-2.7 2.7-5.9 3.5-9.6 3.7-3.1 0.2-6.3 0.1-9.4 0.1-3.2 0-6.3 0.1-9.4-0.1-3.7-0.2-6.9-1-9.6-3.7-2.7-2.7-3.5-5.9-3.7-9.6-0.2-3.1-0.1-6.2-0.1-9.4 0-3.1-0.1-6.3 0.1-9.4 0.2-3.7 1-6.9 3.7-9.6 2.7-2.6 5.9-3.5 9.6-3.6 3.1-0.2 6.2-0.2 9.4-0.2 3.1 0 6.3 0 9.4 0.2 3.7 0.1 6.9 1 9.6 3.6 2.6 2.7 3.5 5.9 3.6 9.6 0.2 3.1 0.2 6.3 0.2 9.4 0 3.2 0 6.3-0.2 9.4zm-10.9-9.4c0-6.5-5.2-11.7-11.7-11.7-6.5 0-11.7 5.2-11.7 11.7 0 6.5 5.2 11.7 11.7 11.7 6.5 0 11.7-5.2 11.7-11.7zm-11.7 7.6c-4.2 0-7.6-3.4-7.6-7.6 0-4.2 3.4-7.6 7.6-7.6 4.2 0 7.6 3.4 7.6 7.6 0 4.2-3.4 7.6-7.6 7.6zm13.2-17.2q0.5-0.3 0.9-0.6 0.4-0.4 0.6-0.9 0.2-0.5 0.2-1.1c0-1.5-1.2-2.7-2.7-2.7-1.5 0-2.8 1.2-2.8 2.7 0 1.5 1.3 2.8 2.8 2.8q0.5 0 1-0.2z" /> -->
<!--                                         </svg> -->
<!--                                     </a> -->
<!--                                 </li> -->
                            </ul>
                        </div>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
        <div class="copyright">
            <div class="copyright__wrapper">
                <p class="text-white text-13px text-center line-height-1-85"><a
                        href="https://www.axa-mandiri.co.id/disclaimer-ownership" target="_blank">Disclaimer &
                        Ownership</a>. Copyright 2018-2024 PT AXA Insurance Indonesia. PT AXA Insurance Indonesia
                    merupakan perusahaan <br />asuransi yang berizin dan diawasi oleh Otoritas Jasa Keuangan</p>
            </div>
        </div>
    </div>
</footer>