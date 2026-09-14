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
	</div>
	
	<div class="row">
		<div class="col-xs-12">
			<h1>SERTIFIKAT POLIS / POLICY SCHEDULE</h1>
		</div>

		<@com.title title="Rincian Polis / Policy Details" />
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
						<th class="bgray">
							<u>Periode Polis</u><br />
							<i>Period of Policy</i>
						</th>
						<td>From <strong>${(leads.policyStartDate?number_to_datetime)?string["dd MMMM yyyy"]}</strong> To <strong>${(leads.policyEndDate?number_to_datetime)?string["dd MMMM yyyy"]}</strong> (both date inclusive)</td>
					</tr>

					<tr>
						<th class="bgray">
							<u>Plan</u><br />
							<i>Type of Plan</i>
						</th>
						<td><strong>${plan.name}</strong></td>
					</tr>

					<tr>
						<th class="bgray">
							<u>Pemegang Polis</u><br />
							<i>Policy Holder</i>
						</th>
						<td><strong>${leads.name}</strong></td>
					</tr>
					
					<tr>
						<th class="bgray">
							<u>Tanggal Lahir</u><br />
							<i>Date of Birth</i>
						</th>
						<td><strong>${(leads.dob?number_to_datetime)?string["dd MMMM yyyy"]}</strong></td>
					</tr>
					
					<tr>
						<th class="bgray">
							<u>Kewarganegaraan</u><br />
							<i>Nationality</i>
						</th>
						<td><strong>${leads.nationality}</strong></td>
					</tr>
					
					<tr>
						<th class="bgray">
							<u>Alamat</u><br />
							<i>Address</i>
						</th>
						<td>
							<strong>${leads.address}</strong>
							<br />
							<strong>${leads.city} ${leads.province} ${leads.zip}</strong>
						</td>
					</tr>
					
					<tr>
						<th class="bgray">
							<u>Telepon</u><br />
							<i>Phone</i>
						</th>
						<td><strong>${leads.mobilePhone}</strong></td>
					</tr>
					
					<tr>
						<th class="bgray">
							<u>Surel</u><br />
							<i>Email</i>
						</th>
						<td><strong>${leads.email}</strong></td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<@com.title title="Rincian Tertanggung / Insured Details" />
		<div class="col-xs-12">
			<br />
			<table class="table1 border-black">
				<tbody>
					<tr>
						<th width="30" class="darkgray v-middle">No.</th>
						<th class="darkgray v-middle">
							<u>Nama Tertanggung</u><br />
							<i>Insured Name</i>
						</th>
						<th class="darkgray v-middle">
							<u>Keterangan Tertanggung</u><br />
							<i>Insured Description</i>
						</th>
						<th class="darkgray v-middle">
							<u>Jenis Kelamin</u><br />
							<i>Gender</i>
						</th>
						<th class="darkgray v-middle">
							<u>Tanggal Lahir</u><br />
							<i>Date of Birth</i>
						</th> 
					</tr>
					
					<#if customers?size gt 0 >
						<#assign num = 0 />
						<#list customers as customer>
							<#assign num = num + 1 />
							<tr>
								<td>${num}</td>
								<td>${customer.name}</td>
								<td>${customer.relationship}</td>
								<td>
									<#if customer.gender == 'M'>
									  Laki-laki
									<#else>
									  Perempuan
									</#if>
								</td>
								<td>${customer.dob?string["dd MMMM yyyy"]}</td>
							</tr>
						</#list>
					</#if>
				</tbody>
			</table>
		</div>
		
	</div>
</section>
<#-- ---------- End Page 1 ---------- -->

<#-- ---------- Start Page 2 ---------- -->
<section class="page">
	<div class="row">
		<@com.title title="Ringkasan Manfaat / Benefits Summary" subtitle="" type="no-slash" />
		<div class="col-xs-12">
			<br />
			<#include "/eh/benefit.ftl">
		</div>
	</div>
</section>
<#-- ---------- End Page 2 ---------- -->

<#-- ---------- Start Page 3 ---------- -->
<section class="page">
	<div class="row mb-20">
		<@com.title title="Ringkasan Premi / Premium Summary" subtitle="" type="no-slash" />
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
								<u>Materai</u><br />
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
		
		<@com.title title="Catatan Penting / Important Notice" />
		<div class="col-xs-12">
			<table class="table1 type2">
				<tbody>
						<tr>
							<td width="10">1.</td>
							<td>Limit manfaat serta syarat dan kondisi polis lainnya mengikuti standar polis SmartCare Executive dari PT Mandiri AXA General Insurance. <br /> <i>Limit benefit and other terms &amp; conditions of the policy are following the standard SmartCare Executive policy from PT Mandiri AXA General Insurance.</i></td>
						</tr>
						<tr>
							<td>2.</td>
							<td>Pelunasan Bea Materai terlampir menggunakan sistem komputerisasi dengan nomor persetujuan dari Dirjen Pajak No. SI-000002/SK/WPJ.04/KP.01/2019 tertanggal 06/02/2019 <br /> <i>Stamp duty has been settled with computerized as per approval of Dirjen Pajak system number No. SI-000002/SK/WPJ.04/KP.01/2019 dated 06/02/2019.</i></td>
						</tr>
				</tbody>
			</table>
		</div>	
	</div>
	
	<div id="signature">
		<div class="row">
			<div class="col-xs-12">
				<br /><br />
				<label>Jakarta, ${.now?string["dd MMMM yyyy"]}</label>
			</div>
			<div class="col-xs-12">
				<#include "/includes/signature_health.ftl">
			</div>
		</div>
	</div>
</section>
<#-- ---------- End Page 3 ---------- -->