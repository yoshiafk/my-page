<%@ include file="../init.jsp" %>

<% 
    String startDate = (String) renderRequest.getAttribute("startDate");
    String dailyEndDate = (String) renderRequest.getAttribute("dailyEndDate");
    String monthlyEndDate = (String) renderRequest.getAttribute("monthlyEndDate");
    String token = (String) renderRequest.getAttribute("token");
    String tokenMobile = !Validator.isNull((String) renderRequest.getAttribute("tokenMobile")) ? (String) renderRequest.getAttribute("tokenMobile") : "";
    int currentYear = (int) renderRequest.getAttribute("currentYear");
    String renderToken = !Validator.isNull((String) renderRequest.getAttribute("renderToken")) ? (String) renderRequest.getAttribute("renderToken") : "";
    String apiRequestToken = !Validator.isNull((String) renderRequest.getAttribute("apiRequestToken")) ? (String) renderRequest.getAttribute("apiRequestToken") : "";
%>

<portlet:resourceURL id="/data/agentperformancebooking" var="loadAgentPerformanceBookingData" />

<div class="dashboard dashboard__agency dashboard__performance">
    <div class="container container__agency">
        <div class="wrapper__agency wrapper__performance">
            <h1 class="agency-heading text-responsive-20px">Laporan Pencapaian (Scorecard)</h1>
            <% if (Validator.isNull(tokenMobile) == true) { %>
	            <a href="javascript:void(0)" class="btn__agency btn--dark-blue btn-performance-wrapper">
	                <span class="position-relative order-10">Unduh PDF</span>
	                <svg class="position-relative order-10 icon-right" xmlns="http://www.w3.org/2000/svg" width="17" height="16"
	                    viewBox="0 0 17 16" fill="none">
	                    <path
	                        d="M3.31006 13.615C3.57261 13.8798 3.92871 14.0285 4.30001 14.0285H12.7C13.0713 14.0285 13.4274 13.8798 13.69 13.615M8.50079 1.9707V9.9707M8.50079 9.9707L11.7008 6.91394M8.50079 9.9707L5.30079 6.91394"
	                        stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
	                </svg>
	            </a>
			<% } %>
        </div>
        <div class="performance">
            <div class="performance__name">
                <span class="span-performance-name">Nama Agen</span>
                <h4 class="h4__agency">
                    <div class="skeleton skeleton-text-half"></div>
                </h4>
            </div>
            <div class="performance__select mb-2">
                <div class="grid-cols-1-performance">
                    <div class="filter-performance-wrapper">
                        <div class="grid-cols-2-performance">
                            <div class="col-form position-relative">
                                <label class="label__agency" for="RPTBulanan">Report Bulanan</label>
                                <select class="input-control select-cs filter-report" name="RPTBulanan"
                                    id="RPTBulanan" disabled>
                                    <option value="1" data-abbr="jan">January</option>
                                    <option value="2" data-abbr="feb">February</option>
                                    <option value="3" data-abbr="mar">March</option>
                                    <option value="4" data-abbr="apr">April</option>
                                    <option value="5" data-abbr="may">May</option>
                                    <option value="6" data-abbr="june">June</option>
                                    <option value="7" data-abbr="july">July</option>
                                    <option value="8" data-abbr="aug">August</option>
                                    <option value="9" data-abbr="sept">September</option>
                                    <option value="10" data-abbr="oct">October</option>
                                    <option value="11" data-abbr="nov">November</option>
                                    <option value="12" data-abbr="dec">December</option>
                                </select>
                            </div>
                            <div class="col-form position-relative" id="triwulan">
                                <label class="label__agency" for="Triwulan">Triwulan</label>
                                <select class="input-control select-cs filter-report" name="Triwulan"
                                    id="Triwulan" disabled>
                                    <option></option>
                                    <option value="1">Triwulan 1</option>
                                    <option value="2">Triwulan 2</option>
                                    <option value="3">Triwulan 3</option>
                                    <option value="4">Triwulan 4</option>
                                </select>
                            </div>
                        </div>
                        <% if (Validator.isNull(tokenMobile) == true) { %>
	                        <div class="wrapper-mobile__performance">
	                            <a href="javascript:void(0)"
	                                class="btn__agency btn--dark-blue btn-mobile-performance-wrapper">
	                                <span class="position-relative order-10">Unduh PDF</span>
	                                <svg class="position-relative order-10 icon-right" xmlns="http://www.w3.org/2000/svg" width="17"
	                                    height="16" viewBox="0 0 17 16" fill="none">
	                                    <path
	                                        d="M3.31006 13.615C3.57261 13.8798 3.92871 14.0285 4.30001 14.0285H12.7C13.0713 14.0285 13.4274 13.8798 13.69 13.615M8.50079 1.9707V9.9707M8.50079 9.9707L11.7008 6.91394M8.50079 9.9707L5.30079 6.91394"
	                                        stroke="white" stroke-width="2" stroke-linecap="round"
	                                        stroke-linejoin="round" />
	                                </svg>
	                            </a>
	                        </div>
						<% } %>
                    </div>
                </div>
            </div>
            <div class="performance__desc">
                <div class="grid-cols-1-performance">
                    <ul class="list-group-performance">
                        <li>
                            <span>Kode Agen</span>
                            <span><span class="mr-12px">:</span>
                                <div class="skeleton skeleton-text-half"></div>
                            </span>
                        </li>
                        <li>
                            <span>Tanggal Bergabung</span>
                            <span><span class="mr-12px">:</span>
                                <div class="skeleton skeleton-text-half"></div>
                            </span>
                        </li>
                        <li>
                            <span>Status Registrasi</span>
                            <span><span class="mr-12px">:</span>
                                <div class="skeleton skeleton-text-half"></div>
                            </span>
                        </li>
                    </ul>
                    <ul class="list-group-performance">
                        <li>
                            <span>Regional</span>
                            <span><span class="mr-12px">:</span>
                                <div class="skeleton skeleton-text-half"></div>
                            </span>
                        </li>
                        <li>
                            <span>Kepala Regional</span>
                            <span><span class="mr-12px">:</span>
                                <div class="skeleton skeleton-text-half"></div>
                            </span>
                        </li>
                        <li>
                            <span>BDE</span>
                            <span><span class="mr-12px">:</span>
                                <div class="skeleton skeleton-text-half"></div>
                            </span>
                        </li>
                        <li>
                            <span>Status Kartu AAUI</span>
                            <span><span class="mr-12px">:</span>
                                <div class="skeleton skeleton-text-half"></div>
                            </span>
                        </li>
                    </ul>
                    <ul class="list-group-performance">
                        <li>
                            <span id="ytd-last-year">YTD <%= currentYear - 1 %></span>
                            <div class="ytd-amount flex" id="ytd-last-amount">
                                <span class="mr-12px">:</span>

                                <div class="skeleton skeleton-text-half"></div>
                            </div>
                        </li>
                        <li>
                            <span id="ytd-current-year">YTD <%= currentYear %><sup>*</sup></span>
                            <div class="ytd-amount flex" id="ytd-current-amount">
                                <span class="mr-12px">:</span>

                                <div class="skeleton skeleton-text-half"></div>
                            </div>
                        </li>
                        <li class="data-grid-none">
                            <i class="data-per" id="ytd-last-update">
                                <span class="skeleton skeleton-text-half"></span>
                            </i>
                        </li>
                    </ul>
                    <ul class="list-group-performance">
                        <li>
                            <span>Klub Terakhir</span>
                            <span class="ytd-club" id="ytd-last-club"><span class="mr-12px">:</span>
                                <div class="skeleton skeleton-text-half"></div>
                            </span>
                        </li>
                        <li>
                            <span>Klub sekarang</span>
                            <span class="ytd-club" id="ytd-current-club"><span class="mr-12px">:</span>
                                <div class="skeleton skeleton-text-half"></div>
                            </span>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="performance__achievement">
                <div class="performance__achievement--table">
                    <h1 class="agency-heading text-responsive-20px">Pencapaian Mingguan</h1>
                    <div class="table-wrapper">
                        <table class="table__agency" id="weekly-achievement">
                            <thead>
                                <tr>
                                    <td>pencapaian</td>
                                    <td id="weekly-achievement-year__heading" class="agency-text-right"></td>
                                    <td class="agency-text-center">Produk</td>
                                    <td class="agency-text-right">Total</td>
                                </tr>
                            </thead>
                            <tbody class="filter-table-data">
                                <tr data-type="weekly">
                                    <td colspan="4">
                                        <div class="skeleton skeleton-text"></div>
                                    </td>
                                </tr>
                                <tr data-type="weekly">
                                    <td colspan="4">
                                        <div class="skeleton skeleton-text"></div>
                                    </td>
                                </tr>
                                <tr data-type="weekly">
                                    <td colspan="4">
                                        <div class="skeleton skeleton-text"></div>
                                    </td>
                                </tr>
                                <tr data-type="weekly">
                                    <td colspan="4">
                                        <div class="skeleton skeleton-text"></div>
                                    </td>
                                </tr>
                                <tr class="total">
                                    <td colspan="4">
                                        <div class="skeleton skeleton-text"></div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="performance__achievement--table">
                    <h1 class="agency-heading text-responsive-20px">Pencapaian Triwulan</h1>
                    <div class="table-wrapper">
                        <table class="table__agency" id="triwulan-achievement">
                            <thead>
                                <tr>
                                    <td>pencapaian</td>
                                    <td id="triwulan-achievement-year__heading" class="agency-text-right"></td>
                                    <td class="agency-text-center">Produk</td>
                                    <td class="agency-text-right">Total</td>
                                </tr>
                            </thead>
                            <tbody class="filter-table-data">
                                <tr data-type="Oktober">
                                    <td colspan="4">
                                        <div class="skeleton skeleton-text"></div>
                                    </td>
                                </tr>
                                <tr data-type="November">
                                    <td colspan="4">
                                        <div class="skeleton skeleton-text"></div>
                                    </td>
                                </tr>
                                <tr data-type="Desember">
                                    <td colspan="4">
                                        <div class="skeleton skeleton-text"></div>
                                    </td>
                                </tr>
                                <tr class="total">
                                    <td colspan="4">
                                        <div class="skeleton skeleton-text"></div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="performance__achievement--table">
                    <h1 class="agency-heading text-responsive-20px">Pencapaian Tahunan</h1>
                    <div class="table-wrapper">
                        <table class="table__agency" id="year-achievement">
                            <thead>
                                <tr>
                                    <td>pencapaian</td>
                                    <td id="year-achievement-year__heading" class="agency-text-right"></td>
                                    <td class="agency-text-center">Produk</td>
                                    <td class="agency-text-right">Total</td>
                                </tr>
                            </thead>
                            <tbody class="filter-table-data">
                                <tr data-type="September">
                                    <td colspan="4">
                                        <div class="skeleton skeleton-text"></div>
                                    </td>
                                </tr>
                                <tr data-type="Oktober">
                                    <td colspan="4">
                                        <div class="skeleton skeleton-text"></div>
                                    </td>
                                </tr>
                                <tr data-type="November">
                                    <td colspan="4">
                                        <div class="skeleton skeleton-text"></div>
                                    </td>
                                </tr>
                                <tr data-type="Desember">
                                    <td colspan="4">
                                        <div class="skeleton skeleton-text"></div>
                                    </td>
                                </tr>
                                <tr class="total">
                                    <td colspan="4">
                                        <div class="skeleton skeleton-text"></div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="performance__achievement--table">
					<h1 class="agency-heading text-responsive-20px">LOB</h1>
					<div class="table-wrapper">
						<table class="table__agency" id="cob-achievement">
							<thead>
								<tr>
									<td>pencapaian</td>
									<td class="agency-text-right">Triwulan 1</td>
									<td class="agency-text-right">Triwulan 2</td>
									<td class="agency-text-right">Triwulan 3</td>
									<td class="agency-text-right">Triwulan 4</td>
									<td class="agency-text-right">Total</td>
								</tr>
							</thead>
							<tbody class="filter-table-data">
								<tr>
									<td colspan="6">
                                        <div class="skeleton skeleton-text"></div>
                                    </td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="performance__achievement--table">
					<h1 class="agency-heading text-responsive-20px">Syarat & Ketentuan Perjalan Eksklusif</h1>
					<div class="table-wrapper">
						<table class="table__agency" id="miles-achievement">
							<thead>
								<tr>
									<td>Persyaratan Kontes</td>
									<td class="agency-text-right">Total GWP</td>
									<td class="agency-text-right">AXA Miles</td>
								</tr>
							</thead>
							<tbody class="filter-table-data">
								<tr data-type="GroupHealth">
									<td><div class="skeleton skeleton-text"></div></td>
									<td class="agency-text-right"><div class="skeleton skeleton-text"></div></td>
									<td class="agency-text-right" style="letter-spacing: 0.866px; text-transform: none; font-weight: 600"><div class="skeleton skeleton-text"></div></td>
								</tr>
								<tr data-type="NonGroupHealth">
									<td><div class="skeleton skeleton-text"></div></td>
									<td class="agency-text-right"><div class="skeleton skeleton-text"></div></td>
									<td class="agency-text-right" style="letter-spacing: 0.866px; text-transform: none; font-weight: 600"><div class="skeleton skeleton-text"></div></td>
								</tr>
								<tr data-type="Total">
									<td><div class="skeleton skeleton-text"></div></td>
									<td class="agency-text-right"><div class="skeleton skeleton-text"></div></td>
									<td class="agency-text-right" style="letter-spacing: 0.866px; text-transform: none; font-weight: 600"><div class="skeleton skeleton-text"></div></td>
								</tr>
								<tr data-type="Polis">
									<td><div class="skeleton skeleton-text"></div></td>
									<td class="agency-text-center" colspan="2"><div class="skeleton skeleton-text"></div></td>
								</tr>
								<tr data-type="Status">
									<td><div class="skeleton skeleton-text"></div></td>
									<td class="agency-text-center" colspan="2"><div class="skeleton skeleton-text"></div></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="performance__achievement--table">
				    <h1 class="agency-heading text-responsive-20px">Perjalanan Eksklusif</h1>
				    <div class="grid-cols-2-performance">
				        <div class="col-form position-relative">
				            <div class="table-wrapper">
				                <table class="table__agency" id="miles-tier-achievement">
				                    <thead>
				                        <tr>
				                            <td>
				                            	Reward Tier<br />
				                                &nbsp;
				                            </td>
				                            <td>#PAX</td>
				                        </tr>
				                    </thead>
				                    <tbody class="filter-table-data">
				                        <tr data-type="MilesTier">
				                            <td><div class="skeleton skeleton-text"></div></td>
				                            <td><div class="skeleton skeleton-text"></div></td>
				                        </tr>
				                    </tbody>
				                </table>
				            </div>
				        </div>
				        <div class="col-form position-relative">
				            <div class="table-wrapper">
				                <table class="table__agency" id="miles-allowance-achievement">
				                    <thead>
				                        <tr>
				                            <td>Peringkat di Club Saat Ini</td>
				                            <!-- <td class="agency-text-center">Office Allowance</td> -->
				                            <td class="agency-text-center">Trip Allowance (Min. 5% atas GWP Non Health)</td>
				                        </tr>
				                    </thead>
				                    <tbody class="filter-table-data">
										<tr data-type="MilesAllowance">
				                            <td class="agency-text-center"><div class="skeleton skeleton-text"></div></td>
				                            <!-- <td class="agency-text-right"><div class="skeleton skeleton-text"></div></td> -->
				                            <td class="agency-text-right" style="letter-spacing: 0.866px; text-transform: none; font-weight: 600"><div class="skeleton skeleton-text"></div></td>
				                        </tr>
				                    </tbody>
				                </table>
				            </div>
				        </div>
			    	</div>
				</div>
            </div>
            
            <!-- <div class="total-polis-per-years">
				<p>Total Polis Per Tahun : <span>0</span></p>
			</div> -->

            <div class="disclaimer">
                <h1>Pernyataan</h1>
                <div class="disclaimer-wrapper">
                    <%
						String disclaimerContent = (String) renderRequest.getAttribute("disclaimerContent");
                    
						if (disclaimerContent.length() > 0) {
					%>
					<%= disclaimerContent %>
					<%
						} else {
					%>
						<ol>
	                        <li>
	                            <span>1)</span>
	                            <span>Laporan ini dibuat untuk memberikan informasi terbaru mengenai produksi Agen,
	                                kontes dan penghargaan <%= currentYear %>.</span>
	                        </li>
	                        <li>
	                            <span>2)</span>
	                            <span>Laporan ini bukan merupakan hasil akhir dan belum memperhitungkan premi yang
	                                sudah dibayarkan serta GWP yang masih terhutang tahun <%= currentYear %>.</span>
	                        </li>
	                        <li>
	                            <span>3)</span>
	                            <span>PT. AXA Insurance Indonesia akan mengirimkan Surat Resmi Pemenang yang
	                                ditandatangani pejabat berwenang sebagai informasi hasil akhir.</span>
	                        </li>
	                        <li>
	                            <span>4)</span>
	                            <span>Kontes ini akan diperhitungkan jika Agen dapat mencapai club di tahun
	                                sebelumnya (khusus Agen lama), dan untuk Agen baru diharuskan masuk club untuk
	                                memenuhi persyaratan kontes ini.</span>
	                        </li>
	                        <li>
	                            <span>5)</span>
	                            <span>Perhitungan kontes ini akan dibayarkan sesuai dengan premi yang sudah
	                                dibayarkan sesuai dengan persyaratan kontes yang berlaku di tahun <%=
	                                    currentYear %>.</span>
	                        </li>
	                        <li>
	                            <span>6)</span>
	                            <span>Untuk penjelasan lebih lanjut, Bapak/Ibu dapat menghubungi BDE (Business Development Executive) dan
	                                Regional Head di kantor perwakilan wilayah masing-masing.</span>
	                        </li>
	                    </ol>
					<% } %>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Modal Lost Connection -->
<div class="modal modal-agency width-full fade" id="ModalLostConnection" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" style="display: none;" aria-labelledby="ModalLostConnectionLabel" aria-hidden="true">
	<div class="modal-dialog modal-agency-dialog modal-max-w-400px modal-agency-dialog-centered">
		<div class="modal-content modal-agency-content">
			<div class="modal-agency-body agency-text-center position-relative">
				<svg class="display-block m-0px-auto-20px-auto" xmlns="http://www.w3.org/2000/svg" width="140" height="140" viewBox="0 0 140 140" fill="none">
					<path d="M82.6219 82.5117L69.8425 95.2911C69.0601 96.0734 69.0616 97.3423 69.8457 98.1228L73.1719 101.434C74.025 102.287 74.025 103.665 73.1719 104.518L69.9781 107.712C69.125 108.565 67.7469 108.565 66.8719 107.712L32.2875 73.1273C31.4344 72.2523 31.4344 70.8742 32.2875 70.0211L35.4812 66.8273C36.3344 65.9742 37.7125 65.9742 38.5656 66.8273L41.8764 70.1535C42.6569 70.9376 43.9258 70.9391 44.7081 70.1567L57.4875 57.3773C59.1937 55.6711 61.9719 55.6711 63.6781 57.3773L63.7656 57.4867C65.4719 59.193 65.4719 61.9711 63.7656 63.6773L51.0048 76.4381C50.2238 77.2192 50.2238 78.4855 51.0048 79.2666L60.7326 88.9944C61.5137 89.7754 62.78 89.7754 63.5611 88.9944L76.3219 76.2336C78.0281 74.5273 80.8062 74.5273 82.5125 76.2336L82.6219 76.3211C84.3281 78.0273 84.3281 80.8055 82.6219 82.5117Z" stroke="#00008F" stroke-width="3"/>
					<path d="M70.0108 32.2831L66.8249 35.4691C65.9707 36.3232 65.9707 37.708 66.8249 38.5622L101.421 73.1588C102.276 74.0129 103.66 74.0129 104.515 73.1588L107.701 69.9729C108.555 69.1187 108.555 67.7339 107.701 66.8797L73.1039 32.2831C72.2498 31.429 70.8649 31.429 70.0108 32.2831Z" fill="#00008F"/>
					<path d="M103.709 89.6867C102.856 88.8336 101.478 88.8336 100.625 89.6867C99.7719 90.5398 99.7719 91.918 100.625 92.7711L106.903 99.0492C107.341 99.4867 107.887 99.6836 108.456 99.6836C109.025 99.6836 109.572 99.4648 110.009 99.0492C110.862 98.1961 110.862 96.818 110.009 95.9648L103.731 89.6867H103.709Z" fill="#00008F"/>
					<path d="M118.978 81.4867L110.863 77.8774C109.769 77.3961 108.478 77.8774 107.975 78.993C107.494 80.0867 107.975 81.3992 109.091 81.8805L117.206 85.4899C117.491 85.6211 117.797 85.6867 118.103 85.6867C118.934 85.6867 119.744 85.2055 120.116 84.3961C120.597 83.3024 120.116 81.9899 119 81.5086L118.978 81.4867Z" fill="#00008F"/>
					<path d="M92.7938 98.1557C92.3125 97.062 91 96.5589 89.9063 97.0401C88.8125 97.5214 88.3094 98.8338 88.7906 99.9276L92.4 108.043C92.7719 108.853 93.5594 109.334 94.4125 109.334C94.7188 109.334 95.0031 109.268 95.3094 109.137C96.4031 108.656 96.9063 107.343 96.425 106.249L92.8156 98.1339L92.7938 98.1557Z" fill="#00008F"/>
					<path d="M47.2281 39.3715C47.6656 39.809 48.2125 40.0059 48.7812 40.0059C49.35 40.0059 49.8969 39.7871 50.3344 39.3715C51.1875 38.5184 51.1875 37.1402 50.3344 36.2871L44.0562 30.009C43.2031 29.1559 41.825 29.1559 40.9719 30.009C40.1188 30.8621 40.1188 32.2402 40.9719 33.0934L47.25 39.3715H47.2281Z" fill="#00008F"/>
					<path d="M58.1438 30.9063C58.5156 31.7156 59.3031 32.1969 60.1344 32.1969C60.4406 32.1969 60.725 32.1313 61.0313 32C62.125 31.5188 62.6281 30.2063 62.1469 29.1125L58.5375 20.9969C58.0563 19.8813 56.7656 19.4 55.65 19.8813C54.5563 20.3625 54.0531 21.675 54.5344 22.7688L58.1438 30.8844V30.9063Z" fill="#00008F"/>
					<path d="M31.9594 47.5754L40.075 51.1848C40.3594 51.316 40.6656 51.3817 40.9719 51.3817C41.8031 51.3817 42.6125 50.9004 42.9625 50.091C43.4437 48.9973 42.9625 47.6848 41.8469 47.2035L33.7312 43.5942C32.6156 43.1129 31.3469 43.5942 30.8437 44.7098C30.3625 45.8035 30.8437 47.116 31.9594 47.5973V47.5754Z" fill="#00008F"/>
					<path d="M120.5 30.6783C120.341 29.7229 120.653 28.7494 121.338 28.0645L129.129 20.2741C130.3 19.1025 130.3 17.203 129.129 16.0314L123.943 10.8459C122.772 9.67436 120.872 9.67436 119.701 10.8459L111.91 18.6364C111.225 19.3213 110.252 19.6334 109.296 19.4744L96.4906 17.3434C93.6687 16.8621 90.7812 17.8027 88.7469 19.8152L79.9088 28.6533C78.7372 29.8249 78.7372 31.7244 79.9088 32.8959L107.079 60.0658C108.25 61.2374 110.15 61.2374 111.321 60.0658L120.159 51.2277C122.194 49.1934 123.112 46.3059 122.631 43.484L120.5 30.6783Z" stroke="#00008F" stroke-width="3"/>
					<path d="M19.8406 88.7445C17.8062 90.7789 16.8875 93.6664 17.3688 96.4883L19.7531 110.816L8.75 121.82L18.1781 131.248L29.1812 120.245L43.5094 122.629C46.3312 123.11 49.2188 122.17 51.2531 120.157L62.2125 109.198L30.8 77.7852L19.8406 88.7445Z" fill="#00008F"/>
				</svg>
				<h1 class="agency-heading text-25px mb-10px">Cek Koneksi Anda</h1>
				<p class="agency-text-grey-600 mb-20px">Silakan Coba Lagi</p>
				<a href="javascript:void(0)" class="btn__agency btn--dark-blue display-inline-block agency-text-center p-12px-25px-10px-25px" onclick="refreshPage()">
					<span class="position-relative order-10 flex-justify-center gap-8px">
						<span>Ok</span>
						<!-- <svg xmlns="http://www.w3.org/2000/svg" width="16" height="17" viewBox="0 0 16 17" fill="none">
							<path d="M2.11861 10.4996C2.95844 13.0548 5.36373 14.8996 8.1999 14.8996C11.7345 14.8996 14.5999 12.0342 14.5999 8.49961C14.5999 4.96499 11.7345 2.09961 8.1999 2.09961C5.831 2.09961 3.7627 3.38664 2.65611 5.29961M2.11861 4.67437L3.00016 5.49967M4.5999 6.09961H1.3999V2.89961L4.5999 6.09961Z" stroke="white" stroke-width="1.25" stroke-linecap="round" stroke-linejoin="round"></path>
						</svg> -->
					</span>
				</a>
			</div>
		</div>
	</div>
</div>
<!-- END Modal Lost Connection -->



<script type="text/javascript">
    var html = $("html");
    var body = $("body");
    var portletContent = $(".portlet-content");
    var button = $(".btn-performance-wrapper, .btn-mobile-performance-wrapper");

    html.addClass("html__agency");
    body.addClass("body__agency");
    body.css("overflow", "hidden");
    portletContent.addClass("portlet-content__agency");
    button.addClass("btn--disabled");
    button.css("pointer-events", "none");

    var loadAgentPerformanceBookingDataURL = "<%= loadAgentPerformanceBookingData %>";
    var rToken = "<%=renderToken%>", apToken = "<%=apiRequestToken%>";

    $(document).ready(function (jq) {

        var dailyTransaction,
        	cobTransaction,
        	milesTransaction,
            monthSelected,
            monthNumberSelected,
            triwulanSelected,
            lastUpdate,
            transactionPerWeek = {},
            transactionPerMonth = {},
            transactionPerTriwulan = {},
            totalPerTriwulan = { 1: 0, 2: 0, 3: 0, 4: 0 }

        let shortMonthToLongMonthName = {
            jan: "Januari",
            feb: "Februari",
            mar: "Maret",
            apr: "April",
            may: "Mei",
            june: "Juni",
            july: "Juli",
            aug: "Agustus",
            sept: "September",
            oct: "Oktober",
            nov: "November",
            dec: "Desember",
        };
        
        let cobMapping = {
            "01": "Property",
            "02": "Motor Vehicle",
            "03": "Marine Cargo",
            "04": "Marine Hull",
            "05": "Aviation Hull",
            "06": "Satellite",
            "07": "Energy",
            "08": "Engineering",
            "09": "Liability",
            "10": "General Accident",
            "11": "Credit Insurance & Bond",
            "12": "Miscellanous",
            "13": "Health Insurance",
            "TR": "Travel"
        };

        let monthNameArray = ["Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"];

        const currentYear = <%= currentYear %>;
        const minMilesYear = 2026;
        let currentMonth = new Date().getMonth() + 1;
        
        $("#year-achievement-year__heading").text(currentYear);

        function getTriwulan(monthAlias = null) {
            if (typeof monthAlias !== "string" || !monthAlias) return null;
            let monthToTriwulanGroup = [
                { triwulan: 1, months: ["jan", "feb", "mar"] },
                { triwulan: 2, months: ["apr", "may", "june"] },
                { triwulan: 3, months: ["july", "aug", "sept"] },
                { triwulan: 4, months: ["oct", "nov", "dec"] },
            ];

            let triwulan = monthToTriwulanGroup.filter((v, i, arr) => {
                return v.months.includes(monthAlias);
            });

            return triwulan;
        }

        // Format number to IDR
        function formatToIDR(amount) {
            const formattedCurrency = new Intl.NumberFormat("id-ID", {
                style: "currency",
                currency: "IDR",
            }).format(amount);
            return formattedCurrency;
        }
        
        function formatNumber(miles) {
            const formattedMiles = new Intl.NumberFormat("id-ID").format(miles);
            return formattedMiles;
        }

        // Init weekly
        function initWeeklyData() {
            transactionPerWeek = {}; // reset transaction per week

            let dataFilterForWeekly = dailyTransaction.filter((v) => v.month.toLowerCase() === monthSelected.toLowerCase());

            if (dataFilterForWeekly[0].transaction.length > 0) {
                const totalDayInCurrentMonth = new Date(currentYear, monthNumberSelected, 0).getDate();
                let numberOfWeek = 1,
                    transactions = dataFilterForWeekly[0].transaction;
                transactions.sort((a, b) => a.date - b.date);

                for (let i = 1; i <= totalDayInCurrentMonth; i++) {
                    let week = Math.ceil(parseInt(i) / 7);

                    transactions.forEach((v) => {
                        if (v.date === i) {
                            if (transactionPerWeek[week] === undefined) {
                                transactionPerWeek[week] = [{ amount: v.amount, productCode: v.productCode, transactionDate: v.date }];
                            } else {
                                transactionPerWeek[week].push({ amount: v.amount, productCode: v.productCode, transactionDate: v.date });
                            }
                        } else {
                            if (transactionPerWeek[week] === undefined) {
                                transactionPerWeek[week] = [];
                            }
                        }
                    });
                }

                // loop masing-masing minggu
                let arrProductCodeWeekFour = [];
                let arrProductCodeWeekFive = [];
                for (let key in transactionPerWeek) {
                    let sumAmount = 0;
                    let arrProductCode = [];

                    if (transactionPerWeek[key].length > 0) {
                        transactionPerWeek[key].map((v, i, a) => {
                            sumAmount = sumAmount + v.amount;
                            if (v.productCode && !arrProductCode.includes(v.productCode)) arrProductCode.push(v.productCode); // populate product code
                            if ("4" === key) {
                                if (v.productCode && !arrProductCodeWeekFour.includes(v.productCode)) arrProductCodeWeekFour.push(v.productCode); // populate kode produk minggu 4
                            }
                            if ("5" === key) {
                                if (v.productCode && !arrProductCodeWeekFive.includes(v.productCode)) arrProductCodeWeekFive.push(v.productCode); // populate kode produk minggu 4
                            }
                        });

                        transactionPerWeek[key] = { sumAmount: sumAmount, sumProduct: arrProductCode.length };

                        // merge amount minggu 5 ke minggu 4, lalu delete minggu 5
                        if ("5" === key) {
                            transactionPerWeek["4"].sumAmount += sumAmount;

                            // gabungkan product code di minggu 5 ke minggu 4, simpan di arrProductCodeWeekFour
                            for (let xm = 0; xm < arrProductCode.length; xm++) {
                                if (!arrProductCodeWeekFour.includes(arrProductCode[xm])) arrProductCodeWeekFour.push(arrProductCode[xm]);
                            }

                            transactionPerWeek["4"].sumProduct = arrProductCodeWeekFour.length;
                            delete transactionPerWeek["5"];
                        }
                    } else {
                        transactionPerWeek[key] = { sumAmount: 0, sumProduct: 0 };

                        if ("5" === key) {
                            delete transactionPerWeek["5"];
                        }
                    }
                }
                // END loop masing-masing minggu
            }
        }

        // Init triwulan
        function initTriwulan() {
            transactionPerMonth = {}; // reset
            let monthInCurrentTriwulan = getTriwulan(monthSelected),
                backDateTransaction = [];
            let dataFilterForTriwulan = dailyTransaction.filter((v) => monthInCurrentTriwulan[0].months.includes(v.month.toLowerCase()));

            for (let i = 0; i < dataFilterForTriwulan.length; i++) {
                let sumAmount = 0,
                    arrProductCode = [];
                if (dataFilterForTriwulan[i].transaction.length > 0) {
                    dataFilterForTriwulan[i].transaction.map((v, idx, arr) => {
                        sumAmount += v.amount;
                        if (v.productCode && !arrProductCode.includes(v.productCode)) arrProductCode.push(v.productCode);
                    });
                }
                (dataFilterForTriwulan[i]["sumAmount"] = sumAmount), (dataFilterForTriwulan[i]["sumProduct"] = arrProductCode.length);
                backDateTransaction.push(dataFilterForTriwulan[i]);
                if (dataFilterForTriwulan[i].month.toLowerCase() === monthSelected.toLowerCase()) {
                    break;
                }
            }
            transactionPerMonth = backDateTransaction;
        }

        // Init year
        function initYearData() {
            transactionPerTriwulan = {}; // reset
            let d = [],
                backDateTransactionTriwulan = [];

            // group month by triwulan
            dailyTransaction.map((value, index, arr) => {
                let x = Math.ceil((index + 1) / 3);
                d[x - 1] === undefined ? (d[x - 1] = [value]) : d[x - 1].push(value);
            });

            for (let i = 0; i < d.length; i++) {
                let l = d[i].length;
                let arrProductCodePerTriwulan = [];
                let activeMonthIndexInArray = 0;
                d[i].map((mictVal, mictIndex, mictArr) => {
                    if (mictVal.month === monthSelected) {
                        activeMonthIndexInArray = mictIndex;
                    }
                });

                // looping bulan dalam masing-masing triwulan
                for (let x = 0; x < l; x++) {
                    let sumAmount = 0,
                        arrProductCode = [];
                    if (d[i][x].transaction.length > 0) {
                        d[i][x].transaction.map((v, idx, arr) => {
                            sumAmount += v.amount;
                            if (v.productCode && !arrProductCode.includes(v.productCode)) arrProductCode.push(v.productCode);

                            // sum product per triwulan
                            // misal triwulan yang aktif sekarang adalah triwulan satu, dan bulan terpilih adalah januari.
                            // maka dalam triwulan tersebut cukup januari saja yang dihitung, feb sama maret tidak.
                            if (i + 1 === triwulanSelected[0].triwulan) {
                                if (x <= activeMonthIndexInArray) {
                                    if (v.productCode && !arrProductCodePerTriwulan.includes(v.productCode)) arrProductCodePerTriwulan.push(v.productCode);
                                }
                            } else {
                                if (v.productCode && !arrProductCodePerTriwulan.includes(v.productCode)) arrProductCodePerTriwulan.push(v.productCode);
                            }
                        });
                    }

                    // misal triwulan yang aktif sekarang adalah triwulan satu, dan bulan terpilih adalah januari.
                    // maka dalam triwulan tersebut cukup januari saja yang dihitung, feb sama maret tidak.
                    if (i + 1 === triwulanSelected[0].triwulan) {
                        if (x > activeMonthIndexInArray) {
                            (d[i][x]["sumAmountPerMonth"] = 0), (d[i][x]["sumProductPerMonth"] = 0);
                        } else {
                            (d[i][x]["sumAmountPerMonth"] = sumAmount), (d[i][x]["sumProductPerMonth"] = arrProductCode.length);
                        }
                    } else {
                        (d[i][x]["sumAmountPerMonth"] = sumAmount), (d[i][x]["sumProductPerMonth"] = arrProductCode.length);
                    }
                }

                backDateTransactionTriwulan.push({ triwulan: i + 1, data: d[i], sumProductPerTriwulan: arrProductCodePerTriwulan.length });
                if (i + 1 === triwulanSelected[0].triwulan) break;
            }

            backDateTransactionTriwulan.map((v, i, arr) => {
                let sumAmount = 0;
                v.data.map((x, y, z) => {
                    sumAmount += x.sumAmountPerMonth;
                });
                arr[i]["sumAmountPerTriwulan"] = sumAmount;
            });

            transactionPerTriwulan = backDateTransactionTriwulan;
        }
        
        // Init Cob
        function initCobData() {
        	transactionPerTriwulan = {}; // reset
        	totalPerTriwulan = { 1: 0, 2: 0, 3: 0, 4: 0 };

            cobTransaction.forEach(item => {
            	if (!transactionPerTriwulan[item.cob]) {
            		transactionPerTriwulan[item.cob] = {
                        quarter1: 0,
                        quarter2: 0,
                        quarter3: 0,
                        quarter4: 0
                    };
                }
            	
                let quarter1 = 0, quarter2 = 0, quarter3 = 0, quarter4 = 0;

                item.transaction.forEach(transaction => {
                    const q = transaction.quarter;
                    if (q === 1) {
                        quarter1 += transaction.amount;
                        totalPerTriwulan[1] += transaction.amount;
                    } else if (q === 2) {
                        quarter2 += transaction.amount;
                        totalPerTriwulan[2] += transaction.amount;
                    } else if (q === 3) {
                        quarter3 += transaction.amount;
                        totalPerTriwulan[3] += transaction.amount;
                    } else if (q === 4) {
                        quarter4 += transaction.amount;
                        totalPerTriwulan[4] += transaction.amount;
                    }
                });

                if (transactionPerTriwulan[item.cob]) {
                	transactionPerTriwulan[item.cob].quarter1 += quarter1;
                	transactionPerTriwulan[item.cob].quarter2 += quarter2;
                	transactionPerTriwulan[item.cob].quarter3 += quarter3;
                    transactionPerTriwulan[item.cob].quarter4 += quarter4;
                }
            });
        }

        /* DRAW TABLE */
        /*_________________________________________________*/

        // Draw weekly achievement
        function drawWeeklyAchievement() {
            // populate table
            let rowTable = $("#weekly-achievement").find("tbody").find("tr");
            rowTable.map(function (index, el) {
                if (index < 4) {
                    //let newAmount = transactionPerWeek[index + 1] !== undefined ? formatToIDR(transactionPerWeek[index + 1].sumAmount) : formatToIDR(0);
                    let newAmount = transactionPerWeek[index + 1] !== undefined ? /-/.test(transactionPerWeek[index + 1].sumAmount) ? "(" + formatToIDR(transactionPerWeek[index + 1].sumAmount).replace("-", "") + ")" : formatToIDR(transactionPerWeek[index + 1].sumAmount) : formatToIDR(0);
                    let totalProduct = transactionPerWeek[index + 1] !== undefined ? transactionPerWeek[index + 1].sumProduct : 0;
                    let newRow = "<td>Minggu " + (index + 1) + "</td><td class='agency-text-right'>" + newAmount + "</td><td class='agency-text-center'>" + totalProduct + "</td><td class='agency-text-right'>" + newAmount + "</td>";
                    $(el).empty().append(newRow);
                } else {
                    // grand total
                    let grandTotalAmount = 0;
                    for (let key in transactionPerWeek) {
                        grandTotalAmount += transactionPerWeek[key].sumAmount;
                    }
                    //let newRow = "<td>TOTAL</td><td>" + formatToIDR(grandTotalAmount) + "</td><td></td><td>" + formatToIDR(grandTotalAmount) + "</td>";
                    let grandTotalAmountFormatted = /-/.test(grandTotalAmount) ? "(" + formatToIDR(grandTotalAmount).replace("-", "") + ")" : formatToIDR(grandTotalAmount);
                    let newRow = "<td>TOTAL</td><td class='agency-text-right'>" + grandTotalAmountFormatted + "</td><td></td><td class='agency-text-right'>" + grandTotalAmountFormatted + "</td>";
                    $(el).empty().append(newRow);
                }
            });
        }

        // Draw year achievement
        function drawYearAchievement() {
            // populate table
            let rowTable = $("#year-achievement").find("tbody").find("tr");
            grandTotalAmount = 0;
            rowTable.map(function (index, el) {
                let newAmount, totalProduct, monthName;
                if (index < 4) {
                    if (transactionPerTriwulan[index] !== undefined) {
                        // newAmount = formatToIDR(transactionPerTriwulan[index].sumAmountPerTriwulan);
                        newAmount = /-/.test(transactionPerTriwulan[index].sumAmountPerTriwulan) ? "(" + formatToIDR(transactionPerTriwulan[index].sumAmountPerTriwulan).replace("-", "") + ")" : formatToIDR(transactionPerTriwulan[index].sumAmountPerTriwulan);
                        grandTotalAmount += transactionPerTriwulan[index].sumAmountPerTriwulan;
                        triwulanNumber = transactionPerTriwulan[index].triwulan;
                        totalProduct = transactionPerTriwulan[index].sumProductPerTriwulan;
                    } else {
                        (triwulanNumber = "-"), (totalProduct = "-"), (newAmount = "-");
                    }

                    let triwulanText = triwulanNumber !== "-" ? "Triwulan " + triwulanNumber : "-";
                    let newRow = "<td>" + triwulanText + "</td><td class='agency-text-right'>" + newAmount + "</td><td class='agency-text-center'>" + totalProduct + "</td><td class='agency-text-right'>" + newAmount + "</td>";
                    $(el).empty().append(newRow);
                } else {
                    // grand total
                    let grandTotalAmountFormatted = /-/.test(grandTotalAmount) ? "(" + formatToIDR(grandTotalAmount).replace("-", "") + ")" : formatToIDR(grandTotalAmount);
                    let newRow = "<td>TOTAL</td><td class='agency-text-right'>" + grandTotalAmountFormatted + "</td><td></td><td class='agency-text-right'>" + grandTotalAmountFormatted + "</td>";
                    // let newRow = "<td>TOTAL</td><td>" + formatToIDR(grandTotalAmount) + "</td><td></td><td>" + formatToIDR(grandTotalAmount) + "</td>";
                    $(el).empty().append(newRow);
                }
            });
        }

        // Draw triwulan
        function drawTriwulanAchievement() {
            // populate table
            let rowTable = $("#triwulan-achievement").find("tbody").find("tr");
            grandTotalAmount = 0;
            rowTable.map(function (index, el) {
                let newAmount, totalProduct, monthName;
                if (index < 3) {
                    if (transactionPerMonth[index] !== undefined) {
                        // newAmount = formatToIDR(transactionPerMonth[index].sumAmount);
                        newAmount = /-/.test(transactionPerMonth[index].sumAmount) ? "(" + formatToIDR(transactionPerMonth[index].sumAmount).replace("-", "") + ")" : formatToIDR(transactionPerMonth[index].sumAmount);
                        grandTotalAmount += transactionPerMonth[index].sumAmount;
                        monthName = transactionPerMonth[index].month;
                        totalProduct = transactionPerMonth[index].sumProduct;
                    } else {
                        (monthName = "-"), (totalProduct = "-"), (newAmount = "-");
                    }

                    let monthText = monthName !== "-" ? shortMonthToLongMonthName[monthName.toLowerCase()] : "-";
                    let newRow = "<td>" + monthText + "</td><td class='agency-text-right'>" + newAmount + "</td><td class='agency-text-center'>" + totalProduct + "</td><td class='agency-text-right'>" + newAmount + "</td>";
                    $(el).empty().append(newRow);
                } else {
                    // grand total
                    let grandTotalAmountFormatted = /-/.test(grandTotalAmount) ? "(" + formatToIDR(grandTotalAmount).replace("-", "") + ")" : formatToIDR(grandTotalAmount);
                    let newRow = "<td>TOTAL</td><td class='agency-text-right'>" + grandTotalAmountFormatted + "</td><td></td><td class='agency-text-right'>" + grandTotalAmountFormatted + "</td>";
                    // let newRow = "<td>TOTAL</td><td>" + formatToIDR(grandTotalAmount) + "</td><td></td><td>" + formatToIDR(grandTotalAmount) + "</td>";
                    $(el).empty().append(newRow);
                }
            });
        }
        
        // Draw Cob
        function drawCobAchievement() {
        	let rowTable = $("#cob-achievement").find("tbody").empty();
        	
        	Object.keys(transactionPerTriwulan).forEach(cob => {
                const achievementName = cobMapping[cob];
                let { quarter1, quarter2, quarter3, quarter4 } = transactionPerTriwulan[cob];
                let total = quarter1 + quarter2 + quarter3 + quarter4;
                let quarter1Formatted = quarter1 == 0 ? formatToIDR(0) : /-/.test(quarter1) ? "(" + formatToIDR(quarter1).replace("-", "") + ")" : formatToIDR(quarter1);
                let quarter2Formatted = quarter2 == 0 ? formatToIDR(0) : /-/.test(quarter2) ? "(" + formatToIDR(quarter2).replace("-", "") + ")" : formatToIDR(quarter2);
                let quarter3Formatted = quarter3 == 0 ? formatToIDR(0) : /-/.test(quarter3) ? "(" + formatToIDR(quarter3).replace("-", "") + ")" : formatToIDR(quarter3);
                let quarter4Formatted = quarter4 == 0 ? formatToIDR(0) : /-/.test(quarter4) ? "(" + formatToIDR(quarter4).replace("-", "") + ")" : formatToIDR(quarter4);
                let totalPerCobFormatted = total == 0 ? formatToIDR(0) : /-/.test(total) ? "(" + formatToIDR(total).replace("-", "") + ")" : formatToIDR(total);

                // Add row for each cob
                const rowHtml = "<tr>" +
		                        "<td>" + achievementName + "</td>" +
		                        "<td class='agency-text-right'>" + quarter1Formatted + "</td>" +
		                        "<td class='agency-text-right' style='letter-spacing: 0.866px; text-transform: none; font-weight: 600'>" + quarter2Formatted + "</td>" +
		                        "<td class='agency-text-right'>" + quarter3Formatted + "</td>" +
		                        "<td class='agency-text-right'>" + quarter4Formatted + "</td>" +
		                        "<td class='agency-text-right'>" + totalPerCobFormatted + "</td>" +
			                    "</tr>";
			                    
                $(rowTable).append(rowHtml);
            });
        	
        	let totalQuarter1Formatted = totalPerTriwulan[1] == 0 ? formatToIDR(0) : /-/.test(totalPerTriwulan[1]) ? "(" + formatToIDR(totalPerTriwulan[1]).replace("-", "") + ")" : formatToIDR(totalPerTriwulan[1]);
            let totalQuarter2Formatted = totalPerTriwulan[2] == 0 ? formatToIDR(0) : /-/.test(totalPerTriwulan[2]) ? "(" + formatToIDR(totalPerTriwulan[2]).replace("-", "") + ")" : formatToIDR(totalPerTriwulan[2]);
            let totalQuarter3Formatted = totalPerTriwulan[3] == 0 ? formatToIDR(0) : /-/.test(totalPerTriwulan[3]) ? "(" + formatToIDR(totalPerTriwulan[3]).replace("-", "") + ")" : formatToIDR(totalPerTriwulan[3]);
            let totalQuarter4Formatted = totalPerTriwulan[4] == 0 ? formatToIDR(0) : /-/.test(totalPerTriwulan[4]) ? "(" + formatToIDR(totalPerTriwulan[4]).replace("-", "") + ")" : formatToIDR(totalPerTriwulan[4]);
            let totalQuarter = totalPerTriwulan[1] + totalPerTriwulan[2] + totalPerTriwulan[3] + totalPerTriwulan[4];
            let totalPerQuarterFormatted = totalQuarter == 0 ? "-" : /-/.test(totalQuarter) ? "(" + formatToIDR(totalQuarter).replace("-", "") + ")" : formatToIDR(totalQuarter);

            // Add total row
            const totalRowHtml = "<tr class='total'>" +
			                     "<td>TOTAL</td>" +
			                     "<td class='agency-text-right'>" + totalQuarter1Formatted + "</td>" +
			                     "<td class='agency-text-right' style='letter-spacing: 0.866px; text-transform: none; font-weight: 600'>" + totalQuarter2Formatted + "</td>" +
			                     "<td class='agency-text-right'>" + totalQuarter3Formatted + "</td>" +
			                     "<td class='agency-text-right'>" + totalQuarter4Formatted + "</td>" +
			                     "<td class='agency-text-right'>" + totalPerQuarterFormatted + "</td>" +
				                 "</tr>";
            
            $(rowTable).append(totalRowHtml);
        }
        
     	// Draw Miles
        function drawMilesAchievement() {
        	let terms = milesTransaction.terms;

            // Convert terms array to key-value object
            let termMap = {};
            $.each(terms, function(i, term) {
				termMap[term.name] = term.amount;
            });

            // Update GroupHealth row
            let $groupRow = $('tr[data-type="GroupHealth"]');
            const amountGroupHealthGwp = termMap['GroupHealthGWP'] == 0 ? formatToIDR(0) : /-/.test(termMap['GroupHealthGWP']) ? "(" + formatToIDR(termMap['GroupHealthGWP']).replace("-", "") + ")" : formatToIDR(termMap['GroupHealthGWP']);
            $groupRow.find('.skeleton').remove();
            $groupRow.find('td').eq(0).text('Group Health');
            $groupRow.find('td').eq(1).text(amountGroupHealthGwp);
            $groupRow.find('td').eq(2).text(formatNumber(termMap['AXAMilesGroupHealth']) || '-');

            // Update NonGroupHealth row
            let $nonGroupRow = $('tr[data-type="NonGroupHealth"]');
            const amountNonGroupHealthGwp = termMap['NonGroupHealthGWP'] == 0 ? formatToIDR(0) : /-/.test(termMap['NonGroupHealthGWP']) ? "(" + formatToIDR(termMap['NonGroupHealthGWP']).replace("-", "") + ")" : formatToIDR(termMap['NonGroupHealthGWP']);
            $nonGroupRow.find('.skeleton').remove();
            $nonGroupRow.find('td').eq(0).text('Non Group Health');
            $nonGroupRow.find('td').eq(1).text(amountNonGroupHealthGwp);
            $nonGroupRow.find('td').eq(2).text(formatNumber(termMap['AXAMilesNonGroupHealth']) || '-');

            // Update Total row
            let $totalRow = $('tr[data-type="Total"]');
            const amountTotalGwp = termMap['TotalGWP'] == 0 ? formatToIDR(0) : /-/.test(termMap['TotalGWP']) ? "(" + formatToIDR(termMap['TotalGWP']).replace("-", "") + ")" : formatToIDR(termMap['TotalGWP']);
            $totalRow.find('.skeleton').remove();
            $totalRow.find('td').eq(0).text('Total');
            $totalRow.find('td').eq(1).text(amountTotalGwp);
            $totalRow.find('td').eq(2).text(formatNumber(termMap['TotalMiles']) || '-');

            // Update Polis row
            let $polisRow = $('tr[data-type="Polis"]');
            $polisRow.find('.skeleton').remove();
            $polisRow.find('td').eq(0).text('Polis');
            $polisRow.find('td').eq(1).text(termMap['TotalPolicy'] || '-');

            // Update Status row
            let $statusRow = $('tr[data-type="Status"]');
            $statusRow.find('.skeleton').remove();
            $statusRow.find('td').eq(0).text('Status Reward');
            $statusRow.find('td').eq(1).text(milesTransaction.status);
            
         	// Update Tier row
            let $tierRow = $('tr[data-type="MilesTier"]');
            $tierRow.find('.skeleton').remove();
            $tierRow.find('td').eq(0).text(milesTransaction.tier);
            const paxText = milesTransaction.paxBonus && milesTransaction.paxBonus != "-" ? milesTransaction.pax + " + " + milesTransaction.paxBonus : milesTransaction.pax;
            $tierRow.find('td').eq(1).text(paxText);

         	// Update Allowance row
            let $allowanceRow = $('tr[data-type="MilesAllowance"]');
            //const amountAllowance = milesTransaction.allowance == 0 ? '-' : /-/.test(milesTransaction.allowance) ? "(" + formatToIDR(milesTransaction.allowance).replace("-", "") + ")" : formatToIDR(milesTransaction.allowance);
            const amountTripAllowance = milesTransaction.tripAllowance == 0 ? '-' : /-/.test(milesTransaction.tripAllowance) ? "(" + formatToIDR(milesTransaction.tripAllowance).replace("-", "") + ")" : formatToIDR(milesTransaction.tripAllowance);
            const amountTripAllowanceText = milesTransaction.tripAllowancePlus == 0 ? amountTripAllowance : amountTripAllowance + " + " + formatToIDR(milesTransaction.tripAllowancePlus);

            $allowanceRow.find('.skeleton').remove();
            $allowanceRow.find('td').eq(0).text(milesTransaction.rank);
            $allowanceRow.find('td').eq(1).text(amountTripAllowanceText);
        }

        /*
        LOAD DAILY
        --------------------------------------------------------------------------------------------------------------
        */
        function loadDaily() {
            $.ajax({
                url: loadAgentPerformanceBookingDataURL,
                type: "POST",
                data: { dataCategory: "daily", rtoken: rToken, aptoken: apToken, startDate: "<%= startDate %>", endDate: "<%= dailyEndDate %>" },
                dataType: "json",
                success: function (response) {
                    if (response.status) {
                        apToken = response.token ? response.token : "";
                        
                        dailyTransaction = response.data; // set global var transaction

                        // activate and trigger change in select
                        $("#RPTBulanan").prop("disabled", false);
                        $("#RPTBulanan").val(lastUpdate).trigger("change");
                        
                        $("#RPTBulanan option[value]").each(function() {
							if ($(this).val() > currentMonth) {
                            	$(this).remove();
                          	}
                        });

                        button.removeClass("btn--disabled");
                        button.css("pointer-events", "auto");
                    } else {
                    	$("#ModalLostConnection").modal("show");
                    }
                },
                error: function (error) {
                    // $(".error-modal__wrapper").css("display", "block");
                	$("#ModalLostConnection").modal("show");
                },
            });
        }

        /*
        LOAD CLUB YEARS
        --------------------------------------------------------------------------------------------------------------
        */
        function loadClubYears() {
            $.ajax({
                url: loadAgentPerformanceBookingDataURL,
                type: "POST",
                data: { dataCategory: "club", rtoken: rToken, aptoken: apToken },
                dataType: "json",
                success: function (response) {
                    let listGroupPerformance = $(".performance__desc").find(".list-group-performance");
                    let listThree = $(listGroupPerformance[2]).find("li"); // ytd
                    let listFour = $(listGroupPerformance[3]).find("li"); // klub

                    if (response.status) {
                    	let last_data = response.data.filter(v => v.year == (currentYear - 1));
                    	if (last_data.length == 0) {
                    	    if ((currentYear - 1) < minMilesYear) {
                                $("#ytd-last-amount").append(
                                    '<div>' +
                                        '<div class="ytd-amount-rupiah">' + formatToIDR(0) + '</div>' +
                                    '</div>'
                                );
                            }
                            else
                            {
                                $("#ytd-last-amount").append(
                                    '<div>' +
                                        '<div class="ytd-amount-rupiah">' + formatToIDR(0) + '</div>' +
                                        '<div class="ytd-miles">' + formatNumber(0) + ' Miles</div>' +
                                    '</div>'
                                );
                            }

                            $("#ytd-last-club").append("No Club");	
                    	} else {
                            if ((currentYear - 1) < minMilesYear) {
                                $("#ytd-last-amount").append(
                                    '<div>' +
                                        '<div class="ytd-amount-rupiah">' + formatToIDR(last_data[0].amount) + '</div>' +
                                    '</div>'
                                );
                            }
                            else
                            {
                                $("#ytd-last-amount").append(
                                    '<div>' +
                                        '<div class="ytd-amount-rupiah">' + formatToIDR(last_data[0].amount) + '</div>' +
                                        '<div class="ytd-miles">' + formatNumber(last_data[0].miles) + ' Miles</div>' +
                                    '</div>'
                                );
                            }

                            $("#ytd-last-club").append(last_data[0].club);	
                    	}
                        
                        let current_data = response.data.filter(v => v.year == currentYear);
                        if (current_data.length == 0) {
                            lastUpdate = currentMonth;

                            $("#ytd-current-amount").append(
                                '<div>' +
                                    '<div class="ytd-amount-rupiah">' + formatToIDR(0) + '</div>' +
                                    '<div class="ytd-miles">' + formatNumber(0) + ' Miles</div>' +
                                '</div>'
                            );

                            $("#ytd-current-club").append("No Club");
                            $("#ytd-last-update").append("*) Total YTD per tanggal " + last_data[0].lastUpdate);                        	
                        } else {
                        	const _lastUpdate = new Date(current_data[0].lastUpdate);
                            lastUpdate = _lastUpdate.getMonth() + 1;
                            currentMonth = _lastUpdate.getMonth() + 1;

                            $("#ytd-current-amount").append(
                                '<div>' +
                                    '<div class="ytd-amount-rupiah">' + formatToIDR(current_data[0].amount) + '</div>' +
                                    '<div class="ytd-miles">' + formatNumber(current_data[0].miles) + ' Miles</div>' +
                                '</div>'
                            );

                            $("#ytd-current-club").append(current_data[0].club);
                            $("#ytd-last-update").append("*) Total YTD per tanggal " + current_data[0].lastUpdate);
                        }
                    }
                    
                    $(".ytd-amount").find(".skeleton").remove();
                    $(".ytd-club").find(".skeleton").remove();
                    $("#ytd-last-update").find(".skeleton").remove();

                    // call load daily
                    apToken = response.token ? response.token : "";
                    loadDaily();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    let listGroupPerformance = $(".performance__desc").find(".list-group-performance");
                    $(listGroupPerformance[2]).find("li").find(".skeleton").remove();
                    $(listGroupPerformance[3]).find("li").find(".skeleton").remove();

                    // call load daily
                    loadDaily();
                },
            });
        }

        /*
        LOAD PROFILE
        --------------------------------------------------------------------------------------------------------------
        */
        var listGroupPerformance = $(".performance__desc").find(".list-group-performance");
        $.ajax({
            url: loadAgentPerformanceBookingDataURL,
            type: "POST",
            data: { dataCategory: "profile", rtoken: rToken, aptoken: apToken },
            timeout: 20000,
            dataType: "json",
            success: function (response) {
                // LIST #1 kode agen, etc..
                let listOne = $(listGroupPerformance[0]).find("li");

                // LIST #2 regional, kepala regional etc..
                let listTwo = $(listGroupPerformance[1]).find("li");

                if (response.status) {
                    $(".performance__name").find(".h4__agency").text(response.data.agentName); // Agent Name
                    listOne.map(function (index, element) {
                        let spanValContainer = $(element).find("span")[1];

                        switch (index) {
                            case 0:
                                spanValContainer.append(response.data.agentCode);
                                break;
                            case 1:
                                spanValContainer.append(response.data.agentJoinDate);
                                break;
                            case 2:
                                spanValContainer.append(response.data.agentRegistStatus);
                                break;
                        }
                        // remove skeleton
                        $(spanValContainer).find(".skeleton").remove();
                    });

                    listTwo.map(function (index, element) {
                        let spanValContainer = $(element).find("span")[1];
                        switch (index) {
                            case 0:
                                spanValContainer.append(response.data.agentRegional);
                                break;
                            case 1:
                                spanValContainer.append(response.data.agentRegionalHead);
                                break;
                            case 2:
                                spanValContainer.append(response.data.agentManager);
                                break;
                            case 3:
                                spanValContainer.append(response.data.agentAauiStatus);
                                break;
                        }

                        // remove skeleton
                        $(spanValContainer).find(".skeleton").remove();
                    });
                } else {
                    $(".performance__name").find(".h4__agency").text("-");
                    listOne.map(function (index, element) {
                        let spanValContainer = $(element).find("span")[1];
                        $(spanValContainer).find(".skeleton").remove(); // remove skeleton
                    });

                    listTwo.map(function (index, element) {
                        let spanValContainer = $(element).find("span")[1];
                        $(spanValContainer).find(".skeleton").remove(); // remove skeleton
                    });
                }

                // call load club years
                apToken = response.token ? response.token : "";
                loadClubYears();

            },
            error: function (error) {
                let listOne = $(listGroupPerformance[0]).find("li");
                listOne.map(function (index, element) {
                    let spanValContainer = $(element).find("span")[1];
                    $(spanValContainer).find(".skeleton").remove(); // remove skeleton
                });

                let listTwo = $(listGroupPerformance[1]).find("li");
                listTwo.map(function (index, element) {
                    let spanValContainer = $(element).find("span")[1];
                    $(spanValContainer).find(".skeleton").remove(); // remove skeleton
                });

                loadClubYears(); // clubyears tetap dipanggil
            },
        });
        
        /*
        LOAD LOB
        --------------------------------------------------------------------------------------------------------------
        */
        function loadLob() {
            $.ajax({
                url: loadAgentPerformanceBookingDataURL,
                type: "POST",
                data: { dataCategory: "cob", dataMonth: monthNumberSelected, rtoken: rToken, aptoken: apToken },
                dataType: "json",
                success: function (response) {
                	if (response.status) {
                		cobTransaction = response.data; // set global var transaction
                		
                		initCobData();
        	            drawCobAchievement();
                        
                        $(".total-polis-per-years span").text(response.total);
                		
                		// $("#RPTBulanan").val(lastUpdate).trigger("change");

                        apToken = response.token ? response.token : "";
                        
                        loadTripReward();
                    } else {
                    	$("#ModalLostConnection").modal("show");
                    }
                },
                error: function (error) {
                    // $(".error-modal__wrapper").css("display", "block");
                	$("#ModalLostConnection").modal("show");
                },
            });
        }
        
        /*
        LOAD TRIP REWARD
        --------------------------------------------------------------------------------------------------------------
        */
        function loadTripReward() {
            $.ajax({
                url: loadAgentPerformanceBookingDataURL,
                type: "POST",
                data: { dataCategory: "miles", rtoken: rToken, aptoken: apToken },
                dataType: "json",
                success: function (response) {
                	if (response.status) {
                		milesTransaction = response.data;
                		
                		drawMilesAchievement();

                        apToken = response.token ? response.token : "";
                    } else {
                    	$("#ModalLostConnection").modal("show");
                    }
                },
                error: function (error) {
                	$("#ModalLostConnection").modal("show");
                },
            });
        }

        // INIT SELECT
        $("#RPTBulanan").select2({
            width: "resolve",
            placeholder: "Pilih RPT Bulanan",
            minimumResultsForSearch: -1,
        });

        $("#RPTBulanan").val(null).trigger("change");

        $("#RPTBulanan").on("change", function (e) {
            monthSelected = $("option:selected", this).data("abbr");
            monthNumberSelected = $("option:selected", this).val();

            triwulanSelected = getTriwulan(monthSelected).length > 0 ? getTriwulan(monthSelected) : null;
            $("#Triwulan").val(triwulanSelected[0].triwulan).trigger("change");

            $("#weekly-achievement-year__heading").text("GWP " + monthSelected.toUpperCase() + " " + currentYear);
            $("#triwulan-achievement-year__heading").text("GWP " + " " + currentYear);

            initWeeklyData();
            drawWeeklyAchievement();

            initTriwulan();
            drawTriwulanAchievement();

            initYearData();
            drawYearAchievement();
            
            loadLob();
        });

        $("#Triwulan").select2({
            width: "resolve",
            placeholder: "Pilih Triwulan",
            minimumResultsForSearch: -1,
        });

        $("#Triwulan").on("change", function (e) {
            // triwulanSelected = $("option:selected", this).val();
        });

        button.on("click", function () {
            const category = "generate";
            const url = loadAgentPerformanceBookingDataURL + "&dataCategory=" + category + "&dataMonth=" + monthNumberSelected + "&rtoken=" + rToken + "&aptoken=" + apToken;
            let date = new Date();
            const month = monthNumberSelected - 1;
            const year = date.getFullYear();

            $.ajax({
                url: url,
                method: 'GET',
                xhrFields: {
                    responseType: 'blob'
                },
                beforeSend: function () {
                    button.addClass("btn--disabled");
                    button.css("pointer-events", "none");
                },
                success: function (response, textStatus, xhrObj) {
                    if (response.status == false) {
                    	$("#ModalLostConnection").modal("show");
                    }

                    download(response, 'Scorecard-' + monthNameArray[month] + '-' + year + '.pdf');

                    apToken = xhrObj.getResponseHeader("Aptoken");
                },
                complete: function () {
                    button.removeClass("btn--disabled");
                    button.css("pointer-events", "auto");
                }
            });
        });
    });

    function download(object, name) {
        var a = document.createElement('a');
        var url = URL.createObjectURL(object);
        a.href = url;
        a.download = name;
        a.click();
    }
    
    function refreshPage() {
    	location.reload();
    }
</script>
