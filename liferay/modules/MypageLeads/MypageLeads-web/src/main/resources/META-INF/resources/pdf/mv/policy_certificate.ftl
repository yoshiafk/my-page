<#-- START PAGE 1 -->
<#if detail.nationality ? lower_case == "indonesia">
<#assign countryName = "INDONESIA">
<#else>
<#assign countryName = detail.nationality ? upper_case>
</#if>

<section class="page">
  <div class="row mb-20">
    <div class="col-xs-7 alamat">
      ${detail.name ? upper_case} <br />
      ${detail.address ? upper_case} <br />
      
      <#if detail.address2 ? has_content>
      ${address2 ? upper_case}
      </#if>
      
      ${detail.city ? upper_case}, ${detail.province ? upper_case}<br />
      ${countryName}, ${leads.zip}
    </div>
    <div class="col-xs-5">
      <p>
        <label class="text-bold">New business</label> <br />
        <label class="text-bold">Asli/Original</label> <br />
        <label class="text-bold">Nasabah/Client Copy</label>
      </p>

      <p>
        <label>Tanggal/Date</label> <br />
        <label class="text-bold">17 Maret 2022</label>
      </p>

      <p>
        <label>Nomor Referensi/Reference Number</label> <br />
        <label class="text-bold">AGNWMV1-666666</label>
      </p>

      <p>
        <label>Asuransi Mandiri Mobil</label> <br />
        <label class="text-bold">New Business</label>
      </p>
    </div>
  </div>
  
  	<div class="row">
		<div class="col-xs-12">
			<h1>IKHTISAR POLIS/POLICY SCHEDULE</h1>
		</div>
		
		<#-- Rincian Polis -->
		<#-- ------------------------------------------------------------------ -->
		<@com.title title="Rincian Polis / Policy Details" />
		
				<div class="col-xs-12">
			<table class="table1">
				<tbody>
					<tr>
						<th class="w300 bgray">
							<u>Nomor Sertifikat Polis</u><br />
						 	<i>Policy Certificate Number</i></th>
						<td><strong>${leads.referenceNumber}</strong></td>
					</tr>
					<tr>
						<th class="bgray">
							<u>Periode Pertanggungan</u><br />
							<i>Cover Period</i></th>
						<td><strong>${leads.policyStartDate?number_to_date?string["dd MMMM yyyy"]}</strong> to <strong>${leads.policyEndDate?number_to_date?string["dd MMMM yyyy"]}</strong> (dimulai dan berakhir pukul 12.00 siang waktu setempat dimana polis diterbitkan)</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	
		<#-- Detail Risiko -->
		<#-- ------------------------------------------------------------------ -->
		<@com.title title="Detail Risiko / Risk Detail" />
				<div class="col-xs-12">
			<table class="table1">
				<tbody>
					<tr>
						<th class="bgray">
							<u>Tipe Pertanggungan</u><br/>
							<i>Type of Cover</i>
						</th>
						<td>
							<strong><#if detail.coverageType == "CO">COMPREHENSIVE<#else>TOTAL LOSS ONLY</#if></strong>
						</td>
					</tr>
					<tr>
						<th class="bgray">
							<u>Model Kendaraan</u><br/>
							<i>Make &amp; Model of Vehicle</i>
						</th>
						<td>
							<strong>${detail.vehicleManufacture} ${detail.vehicleModel} ${detail.vehicleSubModel}</strong>
						</td>
					</tr>
					<tr>
						<th class="w300 bgray">
							<u>Tahun Pembuatan</u><br/>
						 	<i>Year of Manufacture</i>
						</th>
						<td>
							<strong>${detail.manufactureYear?string.computer}</strong>
						</td>
					</tr>
					<tr>
						<th class="w300 bgray">
							<u>Penggunaan Kendaraan</u><br/>
						 	<i>Type Of Use</i>
						</th>
						<td>
							<strong><#if detail.typeOfUse == "PO">PRIBADI/DINAS<#else>${detail.typeOfUse ? upper_case}</#if></strong>
						</td>
					</tr>
					<tr>
						<th class="w300 bgray">
							<u>Nomor Polisi</u><br/>
						 	<i>Registration Number</i>
						</th>
						<td>
							<strong>${detail.policyNumber}</strong>
						</td>
					</tr>
					<tr>
						<th class="w300 bgray">
							<u>Sum Insured</u><br/>
						 	<i>Sum Insured</i>
						</th>
						<td>
							<strong>IDR ${detail.sumInsured}</strong>
						</td>
					</tr>
					<tr>
						<th class="w300 bgray">
							<u>Aksesoris</u><br/>
						 	<i>Accessories</i>
						</th>
						<td>
							<strong>IDR ${detail.accessoriesInsured}</strong>
						</td>
					</tr>
					<tr>
						<th class="w300 bgray">
							<u>Nomor Rangka</u><br/>
						 	<i>Chasis Number</i>
						</th>
						<td>
							<strong>${detail.chassisNumber ? upper_case}</strong>
						</td>
					</tr>
					<tr>
						<th class="w300 bgray">
							<u>Nomor Mesin</u><br/>
						 	<i>Engine Number</i></th>
						<td>
							<strong>${detail.engineNumber ? upper_case}</strong>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	
	
</section>
<#-- END PAGE 1 -->
