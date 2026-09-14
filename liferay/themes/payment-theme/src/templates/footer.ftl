<footer>
    <div class="footer__inner">
        <div class="container-axa">
            <div class="footer-wrapper">
                <div class="footer-wrapper__sitemap--inner">
                    <div class="col-sitemap">
                        <h5>PT AXA Insurance Indonesia</h5>
                        <ul>
                            <li class="mb-12px">AXA Tower Ground Floor</li>
                            <li class="mb-12px">Jl. Prof Dr Satrio Kav. 18, Kuningan City</li>
                            <li class="mb-12px">Jakarta, 12490</li>
                        </ul>
                    </div>
                    
                    <div class="footer-wrapper__contact">
                        <address class="not-italic text-16px">
                            <h5>Butuh bantuan?</h5>
                            <div class="flex mb-12px phone-contact">
                                <a class="text-white" href="tel://1500733">
                                <span class="flex">
                                <span><i class="text-12px fas fa-phone-alt mr-8px"></i></span>
                                <span> 1 500 733</span>
                                </span>
                                </a>
                                <span class="text-white inline-block ml-8px">(Senin - Jumat, 08:00 - 17:00 WIB)</span>
                            </div>
                            <div class="flex phone-contact">
                                <a class="text-white" href="mailto:customer.general@axa.co.id">
                                <span class="flex">
                                <span><i class="text-15px fad fa-envelope mr-8px"></i></span>
                                <span>customer.general@axa.co.id</span>
                                </span>
                                </a>
                            </div>
                        </address>
                    </div>
                </div>
            </div>
        </div>
        <div class="copyright">
            <div class="copyright__wrapper">
                <#if (currentYear > startYear)>
                    <p class="text-white text-13px text-center line-height-1-85">Copyright ${startYear}-${currentYear} Hak Cipta Dilindungi.<br/>PT AXA Insurance Indonesia merupakan perusahaan asuransi yang berizin dan diawasi oleh Otoritas Jasa Keuangan</p>
                <#else>
                    <p class="text-white text-13px text-center line-height-1-85">Copyright ${startYear} Hak Cipta Dilindungi.<br/>PT AXA Insurance Indonesia merupakan perusahaan asuransi yang berizin dan diawasi oleh Otoritas Jasa Keuangan</p>
                </#if>
            </div>
        </div>
    </div>
</footer>