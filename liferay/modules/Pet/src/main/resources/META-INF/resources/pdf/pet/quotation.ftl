<#-- ---------- Start Page 1 ---------- -->
<section class="page">
	<div class="row mb-20">
		<div class="col-xs-6 alamat">
			${leads.name ? upper_case}
			<br />
			${leads.address}
			<br />
			<#if leads.address2 != "">${leads.address2}</#if>
			<#if leads.province != "">${leads.province}, ${leads.city}<br /></#if>
			<#if leads.nationality != "">${leads.nationality?upper_case} ${leads.zip}<br /></#if>
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
							<strong>Nomor Penawaran</strong><br />
							<i class="english">Quotation Number</i>
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
			<h1>SURAT PENAWARAN / <i>QUOTATION LETTER</i></h1>
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
						<th class="bgray">
							<u>Periode Polis</u><br />
							<i>Period of Insurance</i>
						</th>
						<td>From <strong>${(leads.policyStartDate?number_to_datetime)?string["dd MMMM yyyy"]}</strong> To <strong>${(leads.policyEndDate?number_to_datetime)?string["dd MMMM yyyy"]}</strong> (both date inclusive)</td>
					</tr>

					<tr>
						<th class="bgray">
							<u>Jenis Paket</u><br />
							<i>Package Type</i>
						</th>
						<td><strong>${plan.getName()}</strong></td>
					</tr>
				</tbody>
			</table>
		</div> <#-- END ROW -->
		
		<@com.title title="Ringkasan Hewan Peliharaan / <i>Pet Details</i>" subtitle="" type="no-slash" />
		<div class="col-xs-12">
			<br />
			<table class="table1">
				<tbody>
					<tr>
						<th class="w300 bgray">
							<u>Nama Hewan</u><br />
							<i>Pet Name</i>
						</th>
						<td><strong>${detail.getPetName()}</strong></td>
					</tr>
					<tr>
						<th class="bgray">
							<u>Jenis Hewan Peliharaan</u><br />
							<i>Pet Type</i>
						</th>
						<td><strong>${detail.getPetType()}</strong></td>
					</tr>
					<tr>
						<th class="bgray">
							<u>Jenis Kelamin</u><br />
							<i>Gender</i>
						</th>
						<td>
							<strong>
								<#if detail.getPetName() == 'M'>
								  Jantan
								<#else>
								  Betina
								</#if>
							</strong>
						</td>
					</tr>
					<tr>
						<th class="bgray">
							<u>Tanggal Lahir</u><br />
							<i>Date of Birth</i>
						</th>
						<td><strong>${detail.getPetDob()?string["dd MMMM yyyy"]}</strong></td>
					</tr>
					<tr>
						<th class="bgray">
							<u>Nomor Sertifikat</u><br />
							<i>Certificate Number</i>
						</th>
						<td><strong>${detail.getPetIdNumber()}</strong></td>
					</tr>
					<tr>
						<th class="bgray">
							<u>Lembaga Penerbit Sertifikat </u><br />
							<i>Certificate Issuer</i>
						</th>
						<td><strong>${detail.getPetIdNumberIssuing()}</strong></td>
					</tr>
					<tr>
						<th class="bgray">
							<u>Lokasi Pemeliharaan </u><br />
							<i>Pet Rearing Location</i>
						</th>
						<td>
							<strong>
								${detail.getPetLocation()}
							</strong>
						</td>
					</tr>

					<tr>
						<th class="bgray">
							<u>Vaksinansi Rabies </u><br />
							<i>Rabies Vaccination</i>
						</th>
						<td>
							<strong>
								<#if detail.getPetVaccine() == 1>
								  Sudah
								<#else>
								  Belum
								</#if>
							</strong>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		
	</div> <#-- END ROW -->
</section>
<#-- ---------- End Page 1 ---------- -->

<#-- ---------- Start Page 2 ---------- -->
<section class="page">
	<div class="row mt-2">
		<@com.title title="Manfaat / <i>Benefit</i>" subtitle="" type="no-slash" />
		
		<div class="col-xs-12">
			<table class="table1 type2 text-right">
				<tbody class="border-notop border-color1 table-odd">
					<tr class="text-left">
						<td width="70%">
							<span>Kematian &amp; cacat tetap total akibat kecelakaan, termasuk keracunan, masuknya virus atau kuman penyakit ke dalam luka, komplikasi selama dalam perawatan atau pengobatan yang dilakukan oleh dokter hewan</span> 
						</td>
						<td>
							<span>${detail.getLimitDisability()}</span>
						</td>
					</tr>
					<tr class="text-left">
						<td width="70%">
							<span>Santunan biaya pengobatan dan perawatan akibat kecelakaan di klinik hewan atau rumah sakit hewan yang berlisensi</span> </td>
						<td>
							<span>${detail.getLimitMedical()}</span>
						</td>
					</tr>
					<tr class="text-left">
						<td width="70%">
							<span>Tanggung jawab hukum terhadap pihak ketiga (biaya pencegahan/pengobatan rabies terhadap pihak ketiga)</span> 
						</td>
						<td>
							<span>${detail.getLimitThirdParty()}</span>
						</td>
					</tr>
					<tr class="text-left">
						<td width="70%">
							<span>Biaya tambahan penitipan wewan akibat keterlambatan pesawat</span> </td>
						<td>
							<span>${detail.getLimitCustody()}</span>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div> <#-- END ROW -->
	
	<div class="row mt-2">
		<@com.title title="Risiko sendiri / <i>Deductibles</i>" />
		
		<div class="col-xs-12">
			<table class="table1 type2 text-right">
				<tbody class="border-notop border-color1 table-odd">
					<tr class="text-left">
						<td width="70%">
							<span>Kematian dan cacat tetap total akibat kecelakaan</span> 
						</td>
						<td>
							<span>NIHIL</span>
						</td>
					</tr>
					<tr class="text-left">
						<td width="70%">
							<span>Biaya pengobatan hewan peliharaan karena cidera akibat Kecelakaan</span> </td>
						<td>
							<span>IDR ${ 200000 }</span>
						</td>
					</tr>
					<tr class="text-left">
						<td width="70%">
							<span>Tanggung jawab hukum terhadap pihak ketiga (biaya pencegahan/pengobatan rabies terhadap pihak ketiga)</span> 
						</td>
						<td>
							<span>NIHIL</span>
						</td>
					</tr>
					<tr class="text-left">
						<td width="70%">
							<span>Biaya tambahan penitipan hewan akibat keterlambatan pesawat</span> </td>
						<td>
							<span>IDR ${ 100000 }</span>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div> <#-- END ROW -->
	
	<div class="row mt-2">
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
	
	<div class="row mt-2">
		<@com.title title="Klausula / <i>Clause</i>" subtitle="" type="no-slash" />
		
		<div class="col-xs-12">
			<table class="table1 type2 text-right">
				<tbody class="border-notop border-color1 table-odd">

					<tr class="text-left">
						<td width="20">1</td>
						<td>
							<span>KLAUSUL PEMBERITAHUAN KERUGIAN (14 HARI)</span><br />
							<span>
								Tanpa mengabaikan hal yang terkandung sebaliknya disepakati bahwa asuransi ini tidak akan berprasangka oleh keterlambatan disengaja, kesalahan atau kelalaian dalam memberitahukan Perusahaan dari keadaan atau peristiwa yang menimbulkan atau kemungkinan menimbulkan klaim berdasarkan Polis ini.
							</span>	
							<br />
							<i>LOSS NOTIFICATION CLAUSE (14 DAYS)</i><br />
							<i>
								Notwithstanding anything contained otherwise it is agreed that this insurance will not be prejudiced by intentional delays, errors or omissions in notifying the Company of circumstances or events that cause or are likely to give rise to claims under this Policy.
							</i>
						</td>
					</tr>


					<tr class="text-left">
						<td width="20">2</td>
						<td>
							<span>KLAUSUL PENGESAMPINGAN (AAUI) </span><br />
							<span>
								Dengan ini dinyatakan bahwa dalam hal Tertanggung atau Peru-sahaan Asuransi mengakhiri asuransi ini, maka kedua belah pihak sepakat untuk mengesampingkan pasal 1266 dan 1267 Kitab Undang-undang Hukum Perdata Indonesia dan pengakhiran tersebut harus dilakukan tanpa memerlukan persetujuan dari Pengadilan Negeri di dalam wilayah Republik Indonesia. 
							</span>	
							<br />
							<i>WAIVER CLAUSE (AAUI) </i><br />
							<i>
								 It is hereby declared that in the event of the Insured or the Insurer terminates this insurance, then both parties agree to waive articles 1266 and 1267 of the Indonesian Civil Code and Such termination shall be made without requiring any consent of the Court (Pengadilan Negeri) within the territory of the Republic of Indonesia. 
							</i>
						</td>
					</tr>

					<tr class="text-left">
						<td width="20">3</td>
						<td>
							<span>KLAUSUL PENYESUAIAN  (AAUI) </span><br />
							<span>
								Isi polis ini telah disesuaikan dengan peraturan perundang-undangan termasuk ketentuan Peraturan Otoritas Jasa Keuangan. 
							</span>	
							<br />
							<i>COMPLIANCE CLAUSE (AAUI) </i><br />
							<i>
								 This policy has complied with prevailing laws and regulations including regulations of Financial Service Authority.
							</i>
						</td>
					</tr>

				</tbody>
			</table>
		</div>
	</div> <#-- END ROW -->
</section>
<#-- ---------- End Page 2 ---------- -->

<#-- ---------- Srart Page 3 ---------- -->
<section class="page">
	<div class="row">
		<@com.title title="Risiko Yang Tidak Dijamin" />
		
		<div class="col-xs-12">
			<table class="table1 type2">
				<tbody>
					<tr>
						<td width="10">1.</td>
						<td>Euthanasia (wabah penyakit tertentu, masalah perilaku atau karena alasan finansial Tertanggung)</td> 
					</tr>
					<tr>
						<td width="10">2.</td>
						<td>Usia hewan peliharaan melebihi 10 tahun.</td> 
					</tr>
					<tr>
						<td width="10">3.</td>
						<td>Kematian selama atau setelah operasi bedah atau anastesi umum.</td> 
					</tr>
					<tr>
						<td width="10">4.</td>
						<td>Kematian akibat melahirkan.</td> 
					</tr>
					<tr>
						<td width="10">5.</td>
						<td>Kematian yang diakibatkan oleh perawatan atau pencegahan (seperti vaksinasi).</td> 
					</tr>
					<tr>
						<td width="10">6.</td>
						<td>Pencurian.</td> 
					</tr>
					<tr>
						<td width="10">7.</td>
						<td>Penggugat adalah orang yang tinggal bersama, anggota keluarga dekat atau yang dipekerjakan oleh tertanggung.</td>
					</tr>
					<tr>
						<td width="10">8.</td>
						<td>Jika Tertanggung tidak mengikuti saran yang diberikan oleh pemilik sebelumnya atau oleh lembaga penerbit sertifikasi.</td>
					</tr>
					<tr>
						<td width="10">9. </td>
						<td>
							Klaim yang timbul sebagai akibat dari: <br />
							<span>9.1 Tindakan yang disengaja oleh Tertanggung.</span><br />
							<span>9.2 Hasil dari interaksi hewan peliharaan Tertanggung dengan hewan lain atau hewan ternak.</span><br />
							<span>9.3 Orang yang menangani hewan peliharaan Tertanggung tanpa izin atau persetujuan Tertanggung.</span><br />
							<span>9.4 Denda, hukuman, atau pelanggaran pembatasan karantina atau peraturan ekspor dan impor</span>

						</td>
					</tr>
					<tr>
						<td width="10">10.</td>
						<td>Klaim terhadap tanggung jawab hukum yang dijamin oleh polis lain.</td>
					</tr>

					<tr>
						<td width="10">11.</td>
						<td>Biaya sebagai akibat dari perawatan di rumah sakit yang tidak atas saran dokter hewan.</td>
					</tr>
					<tr>
						<td width="10">12.</td>
						<td>Biaya sebagai akibat dari perawatan rumah atau perawatan pemulihan lainnya selain dilakukan di rumah sakit hewan atau klinik hewan yang berlisensi.</td>
					</tr>
					<tr>
						<td width="10">13.</td>
						<td>
							Kecelakaan yang disebabkan atau ditimbulkan oleh: <br />
							<span>13.1 Kerusuhan, Pemogokan, Penghalangan Bekerja, Perbuatan Jahat, Huru-hara, Pembangkitan Rakyat, Pengambil-alihan Kekuasaan, Revolusi, Pemberontakan, Kekuatan Militer, Invasi, Perang Saudara, Perang dan Permusuhan, Makar, Terorisme, atau Sabotase.</span><br />
							<span>13.2 Baik langsung maupun tidak langsung karena atau terjadi pada reaksi-reaksi inti atom dan atau nuklir.</span>
						</td>
					</tr>
					<tr>
						<td width="10">14. </td>
						<td>
							Dalam hal Tertanggung mengadakan perjalanan, polis ini tidak menjamin: <br />
							<span>14.1 Keterlambatan bersifat disengaja.</span><br />
							<span>14.2 Kematian, biaya pengobatan, biaya hukum yang terjadi di jasa penitipan hewan.</span>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</section>
<#-- ---------- End Page 3 ---------- -->

<#-- ---------- Srart Page 4 ---------- -->
<section class="page">
	<div class="row">
		<@com.title title="Catatan Penting / <i>Important Notice</i>" />
	
		<div class="col-xs-12">
			<table class="table1 type2">
				<tbody>
						<tr>
							<td width="10">1.</td>
							<td>Keep this Policy Schedule as a record of your Pet insurance. This Policy Schedule is an integral part of Mandiri Pet Insurance Policy.</td>
						</tr>
						<tr>
							<td>2.</td>
							<td>Summary of the above benefits are at maximum limit. Terms &amp; Conditions applicable can be found in Mandiri Pet Insurance Policy.</td>
						</tr>
						<tr>
							<td>3.</td>
							<td>The benefits listed in the table are of benefit during the policy period.</td>
						</tr>
						<tr>
							<td>4.</td>
							<td>Stamp duty has been settled with computerized as per approval of Dirjen Pajak system number No. SI-000002/SK/WPJ.04/KP.01/2019 dated 06/02/2019.</td>
						</tr>
				</tbody>
			</table>
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
<#-- ---------- End Page 4 ---------- -->
