<header class="new-header">
    <div class="top-menu d-none d-lg-block">
        <div class="container">
            <nav class="navbar-expand-lg">
                <div class="navbar-brand d-none">
                    <a href="http://onelink.to/6t5ynh" class="c-gray-100">DOWNLOAD MY AXA APP</a>
                </div>
                <div class="navbar-collapse">
                    <ul class="navbar-nav ml-auto">
                        <!-- <li><a href=""><i class="fas fa-calculator"></i> Kalkulator</a></li> -->
                        <!-- <li><a href=""><i class="fas fa-tachometer-alt"></i> Health Meter</a></li> -->
                        <li><a href="/hubungi-kami"><i class="fas fa-phone-alt"></i> Hubungi Kami</a></li>
                        <!-- <li><a href="" class="search"><i class="fas fa-search"></i> Cari</a></li> -->
                        <li>
                        	<#if !is_signed_in>
                            <a class="b-light-red" data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">Login Agen</a>
                            <#else>
                            <a class="b-light-red" href="/dashboard">Masuk Dashboard</a>
                            </#if>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
    <div class="bottom-menu">
        <div class="navbar">
            <div class="container">
                <nav class="navbar-expand-lg navbar-menu">
                    <div class="navbar-brand">
                        <a class="link-logo" href="${home_url}">
                        <img src="${images_folder}/main-logo.png" alt="AXA Mandiri myPage">
                        </a>
                    </div>
                    
					<div class="d-lg-none">
						<div class="d-flex align-items-center toggler-mobile">
							<#if !is_signed_in>
						    <a class="b-light-red mr-2" href="${is_login_redirect_required?string}">
						        <div class="d-flex align-items-center">
						            <span class="fz-12">Login Agen</span>
						        </div>
						    </a>
						    <#else>
						    <a class="b-light-red mr-2" href="/dashboard">
						        <div class="d-flex align-items-center">
						            <span class="fz-12">Masuk Dashboard</span>
						        </div>
						    </a>
						    </#if>
						    
						    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#new-header-mobile" aria-controls="new-header-mobile" aria-expanded="false" aria-label="Toggle navigation">
		                        <div class="burger-menu">
		                            <span></span>
		                            <span></span>
		                            <span></span>
		                        </div>
		                    </button>
						</div>
					</div>

                    <!-- Start Mobile -->
                    <div class="d-lg-none w-100">
                    	<div id="new-header-mobile" class="collapse navbar-collapse">
	                    	<ul id="menu" class="navbar-nav">
							    <li class="nav-item">
							        <div class="wrap-link">
							            <a class="nav-link" href="our-solution/asuransi-perjalanan">Asuransi Perjalanan</a>
							            <i class="fas fa-caret-down" data-toggle="collapse" data-target="#col-418774" aria-controls="col-418774" aria-expanded="true"></i>
							        </div>
							        <div class="navbar-collapse collapse-lv2 collapse" id="col-418774" data-parent="#menu">
							            <ul class="navbar-nav">
							                <li class="nav-item">
							                    <a class="nav-link" href="/travel/quote/step1">Asuransi Mandiri Travel Domestik</a>
							                </li>
							                <li class="nav-item">
							                    <a class="nav-link" href="/international-travel/quote/step1">Asuransi Mandiri Travel International</a>
							                </li>
							            </ul>
							        </div>
							    </li>
							    <li class="nav-item">
							        <div class="wrap-link">
							            <a class="nav-link" href="our-solution/asuransi-kendaraan">Asuransi Kendaraan</a>
							            <i class="fas fa-caret-down collapsed" data-toggle="collapse" data-target="#col-418775" aria-controls="col-418775" aria-expanded="true"></i>
							        </div>
							        <div class="collapse navbar-collapse collapse-lv2" id="col-418775" data-parent="#menu">
							            <ul class="navbar-nav">
							                <li class="nav-item">
							                    <a class="nav-link" href="/drive/quote/step1">Asuransi Mandiri Mobil</a>
							                </li>
							            </ul>
							        </div>
							    </li>
							    <li class="nav-item">
							        <div class="wrap-link">
							            <a class="nav-link" href="our-solution/asuransi-kesehatan-dan-jiwa">Asuransi Kesehatan</a>
							            <i class="fas fa-caret-down collapsed" data-toggle="collapse" data-target="#col-418773" aria-controls="col-418773" aria-expanded="true"></i>
							        </div>
							        <div class="collapse navbar-collapse collapse-lv2" id="col-418773" data-parent="#menu">
							            <ul class="navbar-nav">
							                <li class="nav-item">
							                    <a class="nav-link" href="/e-health/quote/step1">SmartCare Executive Individu</a>
							                </li>
							                <li class="nav-item">
							                    <a class="nav-link" href="/e-health/quote/sme/step1">SmartCare Executive SME</a>
							                </li>
							            </ul>
							        </div>
							    </li>
							    <li class="nav-item">
							        <div class="wrap-link">
							            <a class="nav-link" href="our-solution/more">Asuransi Lainnya</a>
							            <i class="fas fa-caret-down collapsed" data-toggle="collapse" data-target="#col-418776" aria-controls="col-418776" aria-expanded="true"></i>
							        </div>
							        <div class="collapse navbar-collapse collapse-lv2" id="col-418776" data-parent="#menu">
							            <ul class="navbar-nav">
							                <li class="nav-item">
							                    <a class="nav-link" href="/property/quote/step1">Asuransi Property</a>
							                </li>
							            </ul>
							        </div>
							    </li>
							</ul>
	                    </div>
                    </div>
                    <!-- End Mobile -->
                    
                    <!-- Start Desktop -->
                    <div class="navbar-collapse d-none d-lg-block" id="navbarNavDropdown">
                        <ul class="navbar-nav ml-auto">
                            <!-- <li><a href="" class="link-red">Beli Online</a></li>
                                <li><a href="">Produk Eksklusif</a></li> -->
                            <li>
                                <a href="javascript:;" class="drop-mega-menu">Asuransi Kami</a>
                                <div class="mega-menu our-insurance">
                                    <div class="container">
                                        <div class="side-left">
                                            <label class="w-100">Asuransi Kami</label>
                                            <p>Asuransi Perlindungan Kesehatan Menyeluruh Yang Memberikan Ketenangan Bagi Anda Dan Keluarga.</p>
                                        </div>
                                        <div class="side-right">
                                            <div class="row">
                                                <div class="col-md-3">
                                                    <label class="w-100">Solusi Kami</label>
                                                    <ul class="list-insurance nav">
                                                        <li><a data-toggle="tab" href="#menu1" class="active">Asuransi Perjalanan</a></li>
                                                        <li><a data-toggle="tab" href="#menu2">Asuransi Kendaraan</a></li>
                                                        <li><a data-toggle="tab" href="#menu3">Asuransi Kesehatan</a></li>
                                                        <li><a data-toggle="tab" href="#menu4">Asuransi Lainnya</a></li>
                                                    </ul>
                                                </div>
                                                <div class="col-md-9">
                                                    <div class="detail-insurance">
                                                        <div class="tab-content">
                                                            <div id="menu1" class="tab-pane fadein active show">
                                                                <div class="row">
                                                                    <div class="col-md-6">
                                                                        <div class="wrap-product">
                                                                            <a href="http://localhost/travel/quote/step1/@MzU2NDYFAA" product="DT">
                                                                            <img src="https://via.placeholder.com/300x200" class="img-product">
                                                                            <label class="caption">Asuransi Mandiri Travel Domestik</label></a>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-6">
                                                                        <div class="wrap-product">
                                                                            <a href="http://localhost/international-travel/quote/step1/@MzU2NDYFAA" product="IT">
                                                                            <img src="https://via.placeholder.com/300x200" class="img-product">
                                                                            <label class="caption">Asuransi Mandiri Travel International</label></a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div id="menu2" class="tab-pane fade">
                                                                <div class="row">
                                                                    <div class="col-md-6">
                                                                        <div class="wrap-product">
                                                                            <a href="http://localhost/drive/quote/step1/@MzU2NDYFAA" product="MV">
                                                                            <img src="https://via.placeholder.com/300x200" class="img-product">
                                                                            <label class="caption">Asuransi Mobil</label></a>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-6">
                                                                        <div class="wrap-product">
                                                                            <a href="http://localhost/tlp/quote/step1/@MzU2NDYFAA" product="MVTLP">
                                                                            <img src="https://via.placeholder.com/300x200" class="img-product">
                                                                            <label class="caption">Asuransi Santunan Kerugian Total Loss Kendaraan</label></a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div id="menu3" class="tab-pane fade">
                                                                <div class="row">
                                                                    <div class="col-md-6">
                                                                        <div class="wrap-product">
                                                                            <a href="http://localhost/e-health/quote/step1/@MzU2NDYFAA" product="EH">
                                                                            <img src="https://via.placeholder.com/300x200" class="img-product">
                                                                            <label class="caption">SmartCare Executive Individu</label></a>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-6">
                                                                        <div class="wrap-product">
                                                                            <a href="http://localhost/e-health/quote/sme/step1/@MzU2NDYFAA" product="SME">
                                                                            <img src="https://via.placeholder.com/300x200" class="img-product">
                                                                            <label class="caption">SmartCare Executive SME</label></a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div id="menu4" class="tab-pane fade">
                                                                <div class="row">
                                                                    <div class="col-md-6">
                                                                        <div class="wrap-product">
                                                                            <a href="http://localhost/pet/quote/step1/@MzU2NDYFAA" product="PI">
                                                                            <img src="https://via.placeholder.com/300x200" class="img-product">
                                                                            <label class="caption">Asuransi Hewan Peliharaan</label></a>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-6">
                                                                        <div class="wrap-product">
                                                                            <a href="http://localhost/personal-accident/quote/step1/@MzU2NDYFAA" product="PA">
                                                                            <img src="https://via.placeholder.com/300x200" class="img-product">
                                                                            <label class="caption">Asuransi Kecelakaan Diri</label></a>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-6">
                                                                        <div class="wrap-product">
                                                                            <a href="http://localhost/gadget-protection/quote/step1/@MzU2NDYFAA" product="GP">
                                                                            <img src="https://via.placeholder.com/300x200" class="img-product">
                                                                            <label class="caption">Asuransi Purchase Secure</label></a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li><a href="/news">Promo &amp; News</a></li>
                            <li><a href="http://localhost/policy-check">Kirim Ulang Polis</a></li>
                            <li><a href="https://axa-mandiri.co.id/tentang-axa-mandiri/">Tentang AXA</a></li>
                            <!-- <li><a href="">Layanan Nasabah</a></li> -->
                        </ul>
                    </div>
                    <!-- End Desktop -->
                    
                </nav>
            </div>
        </div>
    </div>
</header>