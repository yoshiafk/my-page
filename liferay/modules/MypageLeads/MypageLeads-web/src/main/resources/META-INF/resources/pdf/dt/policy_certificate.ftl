<#-- ---------- Start Page 1 ---------- -->
<section class="page">
	<div class="row mb-20">
		<div class="col-xs-6 alamat">
			${leads.name ? upper_case}
			<br />
			${leads.address}
			<br />
			<#if leads.address2 != "">${leads.address2}</#if>
		</div>
		
		<div class="col-xs-6">
			<table class="table1">
				<tbody>
					<tr>
						<td>
							<strong>Tanggal Terbit Polis</strong>
							<br />
							<i class="english">Date of Issue</i>
						</td>
						<td><strong>${(leads.createDate?number_to_datetime)?string["dd MMMM yyyy"]}</strong></td>
					</tr>
					<tr>
						<td>
							<strong>Nomor Polis</strong><br />
							<i class="english">Policy Number</i>
						</td>
						<td><strong>${leads.referenceNumber}</strong></td>
					</tr>
					<tr>
						<td colspan="2">
							<strong>${product.productName}</strong><br />
							<i class="english">New Business</i>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div> <#-- END ROW -->
	
	<div class="row">
		<div class="col-xs-12">
			<h1>IKHTISAR POLIS / <i>POLICY SCHEDULE</i></h1>
		</div>

		<@com.title title="Rincian Polis / <i>Policy Details</i>" />
		<div class="col-xs-12">
			<table class="table1">
				<tbody>
					<tr>
						<th class="w300 bgray">
							<u>Nomor Polis</u><br />
							<i>Policy Number</i>
						</th>
						<td><strong>${leads.referenceNumber}</strong></td>
					</tr>
					
					<tr>
						<th class="w300 bgray">
							<u>Nama Pemegang Polis</u><br />
							<i>Policyholder Namer</i>
						</th>
						<td><strong>${leads.name}</strong></td>
					</tr>
					
					<tr>
						<th class="w300 bgray">
							<u>Alamat Pemegang Polis</u><br />
							<i>Policyholder`s Address</i>
						</th>
						<td><strong>${leads.address} <#if leads.address2 != ""><br />${leads.address2}</#if></strong></td>
					</tr>
					
					<tr>
						<th class="bgray">
							<u>Jenis Perjalanan</u><br />
							<i>Trip Type</i>
						</th>
						<td><strong>Perjalanan Tunggal / <i>Single Trip</i></strong></td>
					</tr>
					
					<tr>
						<th class="bgray">
							<u>Paket Manfaat</u><br />
							<i>Benefit Package</i>
						</th>
						<td><strong>${plan.getName()}</strong></td>
					</tr>

					<tr>
						<th class="bgray">
							<u>Periode Asuransi</u><br />
							<i>Period of Insurance</i>
						</th>
						<td>From <strong>${(leads.policyStartDate?number_to_datetime)?string["dd MMMM yyyy"]}</strong> To <strong>${(leads.policyEndDate?number_to_datetime)?string["dd MMMM yyyy"]}</strong> (both date inclusive)</td>
					</tr>

					<tr>
						<th class="bgray">
							<u>Jumlah Tertanggung Dewasa</u><br />
							<i>Amount of Adult Insured</i>
						</th>
						<td><strong>${detail.adult} Orang/<i>Person</i></strong></td>
					</tr>
					
					<tr>
						<th class="bgray">
							<u>Jumlah Tertanggung Anak</u><br />
							<i>Amount of Child Insured</i>
						</th>
						<td><strong>${detail.child} Orang/<i>Person</i></strong></td>
					</tr>
				</tbody>
			</table>
		</div> <#-- END ROW -->
		
		<@com.title title="Perhitungan Premi / <i>Premium Calculation</i>" subtitle="" type="no-slash" />
		<div class="col-xs-12">
			<table class="table1 type2 text-right">
				<tbody class="border-notop border-color1">
					<tr>
						<td class="w300 bgray">
							<u>Premi Kotor</u><br />
							<i>Gross Premium</i>
						</td>
						<td class="text-left">IDR</td>
						<td>${leads.premium}</td>
					</tr>

					<#if leads.discount gt 0>
						<tr>
							<td class="w300 bgray">
								<u>Diskon</u><br />
								<i>Discount</i>
							</td>
							<td class="text-left">IDR</td>
							<td>${leads.premium * leads.discount / 100}</td>
						</tr>
					</#if>

					<#if leads.policyCost gt 0>
						<tr>
							<td class="w300 bgray">
								<u>Biaya Admin</u><br />
								<i>Admin Cost</i>
							</td>
							<td class="text-left">IDR</td>
							<td>${leads.policyCost}</td>
						</tr>
					</#if>

					<#if leads.stampDuty gt 0>
						<tr>
							<td class="w300 bgray">
								<u>Biaya Materai</u><br />
								<i>Stamp Duty</i>
							</td>
							<td class="text-left">IDR</td>
							<td>${leads.stampDuty}</td>
						</tr>
					</#if>
					
					<tr>
						<th class="w300 bgray text-right">
							<u>Premi Akhir</u><br />
							<i>Final Premium</i>
						</th>
						<td class="text-left"><strong>IDR</strong></td>
						<td><strong>${leads.netPremium}</strong></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div> <#-- END ROW -->
</section>
<#-- ---------- End Page 1 ---------- -->

<#-- ---------- Start Page 2 ---------- -->
<section class="page">
	<#if customers?size gt 0 >

		<div class="row mt-2">
			<@com.title title="Data Pertanggungan / <i>Coverage Data</i>" subtitle="" type="no-slash" />
			
			<div class="col-md-12">
				<br />
				<table class="table1 border-black">
					<tbody>
						<tr>
							<th width="30" class="darkgray v-middle">No.</th>
							<th class="darkgray v-middle">
								<u>Nama Wisatawan</u><br />
								<i>Traveller Name</i>
							</th>
							<th class="darkgray v-middle">
								<u>Tanggal Lahir</u><br />
								<i>Date of Birth</i>
							</th>
							<th class="darkgray v-middle">
								<u>KTP / KITAS</u><br />
								<i>Id Number / Kitas Number</i>
							</th>
						</tr>
						
						<#assign num = 0 />
						<#list customers as customer>
							<#assign num = num + 1 />
							<tr>
								<td>${num}</td>
								<td>${customer.name}</td>
								<td>${customer.dob?string["dd MMMM yyyy"]}</td>
								<#if customer.nationality?lower_case == "indonesia">
									<td>${customer.idNumber}</td>
								<#else>
									<td>${customer.passportNumber}</td>
								</#if>
							</tr>
						</#list>
					</tbody>
				</table>
			</div>
		</div> <#-- END ROW -->
	</#if>
	
	<div class="row mt-2">
		<@com.title title="Ringkasan Manfaat / <i>Benefits Summary</i>" />
		
		<div class="col-md-12">
			<br />
			<table class="table1 type2 border-black">
				<tbody>
					<tr>
						<th class="darkgray">Deskripsi Santunan / <i>Benefit Description</i></th>
						<th class="darkgray">Uang Pertanggungan / <i>Sum Insured</i> (IDR)</th>
					</tr>
					
					<#if benefits?size gt 0 >
						<#list benefits as benefit>
							<tr>
								<td colspan="2"><strong>${ benefit.title }</strong></td>
							</tr>
							
							<#if benefit.list?size gt 0 >
								<#list benefit.list as data>
									<tr>
										<td class="">${ data.benefit }</td>
										<td>${ data.amount }</td>
									</tr>
								</#list>
							</#if>
						</#list>
					</#if>
				</tbody>
			</table>
		</div>
	</div> <#-- END ROW -->
</section>
<#-- ---------- End Page 2 ---------- -->

<#-- ---------- Srart Page 3 ---------- -->
<section class="page">
	<div class="row">
		<@com.title title="Hal-Hal Yang Perlu Diperhatikan / <i>Thing That Need To Be Considered</i>" />
		
		<div class="col-xs-12">
			<table class="table1 type2">
				<tbody>
					<tr>
						<td width="10">1.</td>
						<td>Polis asuransi perjalanan ini mencakup manfaat Medis dan Repatriasi termasuk dalam hal terjadi klaim terkait infeksi pandemi (termasuk Covid-19), manfaat tersebut tercantum dalam polis.<br />
							<i>This travel insurance policy is covering Medical and Repatriation benefits including in the case of the occurrence of claims related to pandemic infection (including Covid-19), the benefits be stated in the policy.</i>
						</td>
					</tr>
					<tr>
						<td width="10">2.</td>
						<td>Harap diperhatikan bahwa sesuai dengan kebijakan peraturan pemerintah Indonesia, jika tertanggung bepergian ke daerah yang bertentangan dengan anjuran perjalanan pemerintah, manfaat tmedis dan repatriasi jika terjadi pandemi akan ditanggung tetapi terbatas sesuai dengan manfaat yang tercantum dalam ikhtisar/sertifikat polis.<br />
							<i>Please note that in accordance to the Indonesian government policy, if the insured is traveling in area against the government travel advice, the medical and repatriation benefits in case of pandemic will be covered but limited as per the benefits stated in the policy schedule.</i>
						</td>
					</tr>
					<tr>
						<td width="10">3.</td>
						<td>Simpanlah Ikhtisar Pertanggungan ini sebagai catatan perlindungan asuransi Mandiri Travel Domestik Anda. Ikhtisar Pertanggungan ini merupakan bagian yang tidak terpisahkan dari Polis Asuransi Mandiri Travel Domestik.<br />
							<i>Keep this Policy Schedule as a protection notes of your Mandiri Travel Domestic Insurance. This Policy Schedule is an integral part of the Mandiri Travel Domestic Insurance.</i>
						</td>
					</tr>
					<tr>
						<td width="10">4.</td>
						<td>Ringkasan Manfaat di atas merupakan limit maksimum. Syarat &amp; Ketentuan yang berlaku terdapat pada Polis Asuransi Mandiri Travel Domestik.<br />
							<i>Summary of Benefits above is the maximum limit. The terms &amp; conditions that apply are contained in the Mandiri Travel Domestic Insurance Policy.</i>
						</td>
					</tr>
					<tr>
						<td width="10">5.</td>
						<td>Jumlah manfaat yang tercantum pada tabel di atas merupakan tabel manfaat untuk Tertanggung Individu, manfaat per Keluarga adalah sebesar dua kali manfaat Tertanggung Individu.<br />
							<i>The amount of benefits listed in the table above is a table of benefits for the Individual Insured, the benefit per Family is twice the benefit of the Individual Insured.</i>
						</td>
					</tr>
					<tr>
						<td width="10">6.</td>
						<td>Seluruh manfaat di atas tetap berlaku apabila kerugian yang timbul disebabkan oleh tindakan terorisme.<br />
							<i>All of the above benefits will still be valid if the losses are caused by acts of terrorism.</i>
						</td>
					</tr>
					<tr>
						<td width="10">7.</td>
						<td>Manfaat yang tercantum dalam tabel merupakan manfaat selama periode polis.<br />
							<i>Benefits listed in the table represent benefits during the policy period.</i>
						</td>
					</tr>
					<tr>
						<td width="10">8.</td>
						<td>Bea meterai telah dibayarkan secara komputerisasi sesuai dengan persetujuan sistem Dirjen Pajak No. SI-000002/SK/WPJ.04 /KP.01/2019 tanggal 02/06/2019.<br />
							<i>Stamp duty has been settled with computerized as per approval of Dirjen Pajak system number No. SI- 000002/SK/WPJ.04 /KP.01/2019 dated 06/02/2019.</i>
						</td>
					</tr>
					<tr>
						<td width="10">9.</td>
						<td>Polis ini dibuat secara otomatis oleh sistem elektronik milik PT Mandiri AXA General Insurance, tanpa mencantumkan stempel dan tanda tangan basah tidak mengurangi keabsahan polis ini.<br />
							<i>This policy is automatic generated by an electronic system owned by PT Mandiri AXA General Insurance, without the inclusion of stamp and wet signature not diminish the validity of this policy.</i>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div> <#-- END ROW -->
</section>

<#-- ---------- Srart Page 4 ---------- -->
<section class="page">
	<div class="row">
		<@com.title title="Pengaduan &amp; Kontak / <i>Complaints &amp; Contact</i>" />
		
		<div class="col-xs-12">
			<div style="padding:0 10px;">
				<p>Tertanggung dapat mengajukan pengaduan langsung ke customer service walk in di kantor cabang terdekat, atau melalui telepon ke Customer Care Center MAGI di no telepon 1500 733 dan email ke customer.general@axa-mandiri.co.id.<br />
					<i class="english">The Insured can submit a complaint directly to the walk-in customer service at the nearest office, or by telephone to the MAGI Customer Care Center at 1500 733 and email to customer.general@axa-mandiri.co.id.</i>
				</p>
			</div>
		</div>
	</div> <#-- END ROW -->
	
	<div class="row">
		<@com.title title="Catatan Penting / <i>Important Notice</i>" />
	
		<div class="col-xs-12">
			<div style="padding:0 10px;">
				<p>Jika terjadi keadaan darurat selama perjalanan, hubungi kami di AXA Travel Assistance 24 jam di nomor 021-765 6728 atau Customer Care Center 1500 733 dan bisa dihubungi pada pukul 08:00 – 17:00 di hari Senin sampai Jumat.<br />
					<i class="english">If an emergency occurs during the trip, please contact us at AXA Travel Assistance 24 hours at 021-765 6728 or Customer Care at 1500733 and can be contacted at 08.00 – 17:00 Monday to Friday.</i>
				</p>
				<p>Terima kasih atas kepercayaan Anda kepada AXA Mandiri dalam memilih perlindungan perjalanan Anda.<br />
					<i class="english">Thank you for your trust in AXA Mandiri in choosing your travel protection.</i>
				</p>
			</div>
		</div>
	</div> <#-- END ROW -->
	
	<div id="signature">
		<div class="row">
			<div class="col-xs-12">
				<br /><br />
				<label>Jakarta, ${.now?string["dd MMMM yyyy"]}</label>
			</div>
			<div class="col-xs-12">
				<#include "/includes/signature.ftl">
			</div>
		</div> <#-- END ROW -->
	</div>
</section>
<#-- ---------- End Page 3 ---------- -->
