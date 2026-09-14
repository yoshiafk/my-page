<div class="sticky-plan" id="scrollSticky">
    <div class="sticky-plan__inner position-relative">
        <div class="code-promo">
            <a class="trigger-collapse-promo" href="javascript:void(0)">
                <div class="container-axa">
                    <div class="code-promo__inner">
                        <span>gunakan kode promo</span>
                        <i class="fas fa-chevron-right fa-fw"></i>
                    </div>
                </div>
            </a>
        </div>
        <div class="detail-summary">
            <a class="trigger-collapse-summary-detail" href="javascript:void(0)">
                <div class="container-axa">
                    <div class="detail-summary__inner">
                        <span>Detail</span>
                        <i class="far fa-times fa-fw"></i>
                    </div>
                </div>
            </a>
        </div>

        <div class="sticky-collapse-promo" id="collapseCodepromo">
            <div class="container-axa">
                <form action="">
                    <div class="sticky-collapse-promo__grid">
                        <div class="col">
                            <label for="promo-code-sticky">Kode Promo</label>
                            <div class="input-group-axa input-group-axa--border">
                                <input class="input-control-axa promo-code" type="text" placeholder="Isi Kode Promo" id="promo-code-sticky" name="PromoCode" maxlength="50" value="<%= promoCode %>">
                                <button type="button" class="btnClear" id="clear-promo-code-btn">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none">
                                        <path d="M3.17766 14.9999C4.43741 18.8326 8.04535 21.5999 12.2996 21.5999C17.6015 21.5999 21.8996 17.3018 21.8996 11.9999C21.8996 6.69797 17.6015 2.3999 12.2996 2.3999C8.74625 2.3999 5.6438 4.33046 3.98392 7.1999M6.89961 8.3999H2.09961V3.5999" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                    </svg>
                                </button>
                            </div>
                        </div>
                        <div class="col">
                            <button class="btn btn--dark-blue" id="promo-code-btn" type="button"><span class="position-relative order-10">Pakai Kode Promo <i class="fas fa-arrow-right"></i></span></button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="sticky-plan__summary">
            <div class="container-axa">
                <div class="sticky-plan__summary-grid">
                    <div class="col">
                        <div class="price">
                            <div class="price-left">
                                <p>Harga</p>
                                	<strong id="sticky-price-wrapper-original" style="text-decoration-line: line-through;font-size: 16px;"></strong>
                                	<strong id="sticky-price-wrapper"><div class="skeleton skeleton-text"></div></strong>
                            </div>
                            <div class="price-right">
                                <a class="trigger-collapse-plan-detail" href="javascript:void(0)"><span>Lihat Detail <i class="far fa-search"></i></span></a>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <a class="btn btn--dark-blue btn__next" href="javascript:void(0)">
                            <span class="position-relative">Lanjutkan <i class="fas fa-arrow-right"></i></span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="sticky-plan-collapse-summary" id="collapsePlandetail">
            <div class="container-axa">
                <div class="sticky-plan-collapse-summary-sa__grid">
                    <div class="col">
                        <div class="col-grid">
                            <div class="col">
                                <p>Proteksi Anda</p>
								<div class="protection">
									<div class="col">
										<ul>
											<li>
												<span>Jaminan Utama</span>
												<span id="sticky-summary-total-main-benefit-premium"></span>
											</li>
										</ul>
										<ul>
											<li class="additional-benefit-premium gohide">
												<span>Jaminan Tambahan</span>
												<span id="sticky-summary-total-additional-benefit-premium"></span>
											</li>
										</ul>
									</div>
									<div class="col">
										<ul>
											<li class="gohide">
												<span>Biaya Polis</span>
												<span id="sticky-summary-policycost-wrapper"></span>
											</li>
										</ul>
										<ul>
											<li class="gohide">
												<span>Materai</span>
												<span id="sticky-summary-stamp-wrapper"></span>
											</li>
										</ul>
									</div>
								</div>
                            </div>
                            <div class="col">
                                <p>Total Premi</p>
                                <div class="total-premi" style="text-decoration-line: none;">
                                    <span class="discount gohide" id="sticky-summary-totalpremi-wrapper-withoutdiscount"></span>
									<span id="sticky-summary-totalpremi-wrapper"></span>
									<small class="sticky-summary-totalpremi-wrapper-idr gohide"></small>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-grid-responsive">
                            <p>Proteksi Anda</p>
                            <ul>
                                <li><span>Jaminan Utama</span><span></span><span id="sticky-summary-total-main-benefit-premium-mobile"></span></li>
                                <li class="additional-benefit-premium-mobile gohide"><span>Jaminan Tambahan</span><span></span><span id="sticky-summary-total-additional-benefit-premium-mobile"></span></li>
                                <li class="gohide"><span>Biaya Polis</span> <span></span><span id="sticky-summary-policycost-wrapper-mobile"></span></li>
                                <li class="gohide"><span>Materai</span> <span></span><span id="sticky-summary-stamp-wrapper-mobile"></span></li>
                                
<!--                                 <li> -->
<!--                                 <span>Biaya Polis</span> <span id="sticky-summary-policycost-wrapper-mobile"></span> -->
<!--                                 <span>Materai</span> <span id="sticky-summary-stamp-wrapper-mobile"></span> -->
<!--                                 </li> -->
                            </ul>
                            <div class="total-premi" style="text-decoration-line: none;">
                                <div class="col">
                                    <p>Total Premi</p>
                                </div>
                                <div class="col">
									<span class="discount gohide" id="sticky-summary-totalpremi-wrapper-withoutdiscount-mobile"></span>
									<span id="sticky-summary-totalpremi-wrapper-mobile"></span>
									<small class="sticky-summary-totalpremi-wrapper-idr-mobile gohide"></small>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    <div class="col">
                        <a class="btn btn--dark-blue btn__next" href="javascript:void(0)">
                            <span class="position-relative">Lanjutkan <i class="fas fa-arrow-right"></i></span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>