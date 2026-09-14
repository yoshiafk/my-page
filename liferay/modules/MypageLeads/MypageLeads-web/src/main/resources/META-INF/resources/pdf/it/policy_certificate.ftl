<#-- START PAGE 1 -->
	<section class="page">
	
		<div class="row mb-20">
		<div class="col-xs-6 alamat">
			${leads.name ? upper_case} <br/>
			${leads.address} <br/>
			<#if (leads.address2)?? >${leads.address2}</#if>
		</div>
		<div class="col-xs-5">
			<table class="table1">
				<tbody>
					<tr>
						<td>
							<strong>Tanggal</strong><br/>
						 	<i class="english">Date</i></td>
						<td><strong>${leads.createDate?number_to_date?string["dd MMMM yyyy"]}</strong></td>
					</tr>
					<tr>
						<td>
							<strong>Nomor Referensi</strong><br/>
						 	<i class="english">Reference Number</i></td>
						<td><strong>${leads.referenceNumber}</strong></td>
					</tr>
					<tr>
						<td colspan="2">
							<strong>${product.productName}</strong><br/>
							<i class="english">New Business</i>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	
	<div class="row">
	
		<div class="col-xs-12">
			<h1>IKHTISAR POLIS/<i>POLICY SCHEDULE</i></h1>
		</div>
		
		<#-- Rincian Polis -->
		<#-- ------------------------------------------------------------------ -->
		<@com.title title="Rincian Polis / <i>Policy Details</i>" />
		
		<div class="col-xs-12">
			<table class="table1">
				<tbody>
					<tr>
						<th class="w300 bgray">
							<u>Nomor Polis</u><br/>
						 	<i>Policy Number</i></th>
						<td><strong>${leads.referenceNumber}</strong></td>
					</tr>
					<tr>
						<th class="bgray">
							<u>Nama Pemegang Polis</u><br/>
							<i>Policyholder Name</i></th>
						<td><strong>${leads.name ? upper_case}</strong></td>
					</tr>
					<tr>
						<th class="bgray">
							<u>Alamat Pemegang Polis</u><br/>
							<i>Policyholder's Address</i>
						</th>
						<td><strong>${leads.address ? upper_case} <#if (leads.address2)?? > ${leads.address2 ? upper_case} </#if></strong></td>
					</tr>
					<tr>
						<th class="bgray">
							<u>Tujuan</u><br/>
							<i>Destination</i></th>
						<td><strong>${detail.destination}</strong></td>
					</tr>

					<tr>
						<th class="bgray">
							<u>Jenis Perjalanan</u><br/>
							<i>Trip Type</i></th>
						<td>
						<#if detail.travelType? lower_case == "single">
						<strong>Perjalanan Tunggal</strong>/<i>${detail.travelType} Trip</i>
						<#else>
						<strong>Perjalanan Tahunan</strong>/<i>${detail.travelType} Trip</i>
						</#if>
						</td>
					</tr>
					<tr>
						<th class="bgray">
							<u>Paket Manfaat</u><br/>
							<i>Benefit Package</i></th>
						<td>
						<strong>
						<#if detail.packageType?lower_case == "gld">
						Gold
						<#elseif detail.packageType?lower_case == "pla">
						Platinum
						<#elseif detail.packageType?lower_case == "spa">
						Special Asia
						<#else>
						-
						</#if>
						</strong>
						</td>
					</tr>
					<tr>
						<th class="bgray">
							<u>Periode Asuransi</u><br/>
							<i>Period of Insurance</i></th>
						<td><strong>${leads.policyStartDate?number_to_date?string["dd MMMM yyyy"]}</strong> to <strong>${leads.policyEndDate?number_to_date?string["dd MMMM yyyy"]}</strong> (both date inclusive)</td>
					</tr>
					
					<tr>
						<th class="bgray">
						<u>Jumlah Tertanggung Dewasa</u><br/>
						<i>Amount of Adult Insured</i>
						</th>
						<td><strong>${detail.adult} Orang</strong>/<i>Person</i></td>
					</tr>
					
					<tr>
						<th class="bgray">
						<u>Jumlah Tertanggung Anak</u><br/>
						<i>Amount of Child Insured</i>
						</th>
						<td><strong>${detail.child} Orang</strong>/<i>Person</i></td>
					</tr>
					
					
				</tbody>
			</table>
		</div>
		<#-- ------------------------------------------------------------------ -->
		<#-- End Rincian Polis -->
		
		<#-- Perhitungan Premi -->
		<#------------------------------------------------------------------------>
		<@com.title title="Perhitungan Premi / <i>Premium Calculation</i>" type="no-slash" />
		<div class="col-xs-12">
			<table class="table1 type2 text-right">
				<tbody class="border-notop border-color1">
					<tr>
						<td class="w300 bgray">
							<u>Premi Kotor</u><br/>
							<i>Gross Premium</i></td>
						<td>${leads.currency?upper_case} ${leads.premium}</td>
					</tr>
					
					<#if leads.policyCost gt 0>
					<tr>
						<td class="w300 bgray">
							<u>Biaya Admin</u><br/>
							<i>Admin Cost</i></td>
							<td>${leads.currency?upper_case} ${leads.policyCost}</td>
					</tr>
					</#if>
					
					<#if leads.stampDuty gt 0>
					<tr>
						<td class="w300 bgray">
							<u>Biaya Materai</u><br/>
							<i>Stampduty</i></td>
							<td>${leads.currency?upper_case} ${leads.stampDuty}</td>
					</tr>
					</#if>
					
					<#if leads.discount gt 0>
					<tr>
						<td class="w300 bgray">
							<u>Diskon ${leads.discount}%</u><br/>
							<i>Discount ${leads.discount}%</i></td>
							<td>${leads.currency?upper_case} ${leads.discountAmount}</td>
					</tr>					
					</#if>

					<tr>
						<th class="w300 bgray text-right">
							<u>Premi Akhir</u><br/>
							<i>Final Premium</i></th>
							<td>${leads.currency?upper_case} ${leads.netPremium}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<#------------------------------------------------------------------------>
		<#-- End Perhitungan Premi -->
		
	</div>
	</section>
<#-- END PAGE 1 -->

<#-- ------------- START PAGE 2 ------------- -->
<section class="page">
		<div class="row">
		
			<#if customers?size gt 0 >
			<#-- ------------- Data Pertanggungan ------------- -->
				<@com.title title="Data Pertanggungan / <i>Coverage Data</i>" type="no-slash" />
				<div class="col-xs-12">
    				<br/>
    				<table class="table1 border-black">
        				<tbody>
            				<tr>
                				<th width="7%" class="darkgray v-middle">No.</th>
                				<th class="darkgray v-middle">
                    			<u>Nama</u><br/>
                    			<i>Name</i>
                				</th>
                				<th class="darkgray v-middle">
                    				<u>Tanggal Lahir</u><br/>
                    				<i>Date of Birth</i>
                				</th>
                				<th class="darkgray v-middle">
                    				<u>Passport</u><br/>
                    				<i>Passport</i>
                				</th>
            				</tr>
            				
            				<#assign num = 0 />
            				<#list customers as customer>
            					<#assign num = num + 1 />
            					<tr>
            						<td width="60">${num}</td>
            						<td>${customer.name}</td>
            						<td>${customer.dob?string["dd MMMM yyyy"]}</td>
            						<td>${customer.passportNumber}</td>
            					</tr>
            				</#list>
    
        				</tbody>
    				</table>
				</div>
			<#-- ------------- End Data Pertanggungan ------------- -->
			</#if>
			
			<#-- ------------- Ringkasan Manfaat ------------- -->
				<@com.title title="Ringkasan Manfaat / <i>Benefits Summary</i>" />
				<div class="col-xs-12">
				<br/>
					<table class="table1 type2 border-black">
						<tbody>
							<tr>
								<th class="darkgray">Deskripsi Manfaat / <i>Description of Benefit</i></th>
								<th class="darkgray">Uang Pertanggungan /<br/><i>Sum Insured</i> (${leads.currency?upper_case})</th>
							</tr>
							
                			<#list benefits as benefit>
                				<tr>
                					<#list benefit as k, v>
                						<td>${k?html}</td>
                						<td>${v}</td>
                					</#list>
                				</tr>
                			</#list>
                			

                		</tbody>
					</table>
				</div>
			<#-- ------------- End Ringkasan Manfaat ------------- -->
			
		</div>
	</section>
<#-- END PAGE 2 -->

<#-- START PAGE 3 -->
	<section class="page">
		<div class="row">
			<@com.title title="Hal-Hal Yang Perlu Diperhatikan / <i>Thing That Need To Be Considered</i>" />
		</div>
		
		<#include "/it/things_that_need_to_be_considered.ftl">
	</section>
<#-- END PAGE 3 -->

<#-- START PAGE 4 -->
		<section class="page">
		<div class="row">
		
		<#-- Pengaduan dan Kontak -->
		<@com.title title="Pengaduan &amp; Kontak / <i>Complaints &amp; Contact</i>" />
		
			<div class="col-xs-12" style="padding:0 25px">
				<table class="table1">
					<tbody>
						<tr>
							<td>
							Tertanggung dapat mengajukan pengaduan langsung ke customer service walk in di kantor cabang terdekat, atau melalui telepon ke Customer Care Center MAGI di no telepon 1500 733 dan email ke customer.general@axa-mandiri.co.id.<br/>
							<i>The Insured can submit a complaint directly to the walk-in customer service at the nearest office, or by telephone to the MAGI Customer Care Center at 1500 733 and email to customer.general@axa-mandiri.co.id.</i>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		
		</div>
		<#-- End Pengaduan dan Kontak -->
		
		
		<div class="row">
			<#-- Catatan Penting -->
			<@com.title title="Catatan Penting / <i>Important Notice</i>" />
			
			<div class="col-xs-12" style="padding:0 25px">
    		<table class="table1">
        		<tbody>
            		<tr>
            			<td>
            				Jika terjadi keadaan darurat selama perjalanan, hubungi kami di AXA Travel Assistance 24 jam di nomor (+60) 376 283 985 atau Customer Care Center 1500 733 dan bisa dihubungi pada pukul 08:00 &#8211; 17:00 di hari Senin sampai Jumat.<br/>
            				<i>If an emergency occurs during the trip, please contact us at AXA Travel Assistance 24 hours at (+60) 376 283 985 or Customer Care at 1500733 and can be contacted at 08.00 &#8211; 17:00 Monday to Friday.</i>
							<br/><br/>
							Terima kasih atas kepercayaan Anda kepada AXA Mandiri dalam memilih perlindungan perjalanan Anda.
							<br/><i>Thank you for your trust in AXA Mandiri in choosing your travel protection.</i>
						</td>
            		</tr>
        		</tbody>
    		</table>
		</div>
		<#-- End Catatan Penting -->
		</div>
		
			<div id="signature">
		<div class="row">
			<div class="col-xs-12">
				<br /><br />
				<label>Jakarta, ${.now?string["dd MMMM yyyy"]}</label>
			</div>
			<div class="col-xs-12">
				<#include "/includes/signature.ftl">
			</div>
		</div>
	</div>
		</section>
<#-- END PAGE 4 -->