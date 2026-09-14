<section class="page">
	<div class="row">
		<div class="col-sm-12">
			<h1 class="text-center premium-note-title">PREMIUM NOTE</h1>
		</div>
		<div class="col-sm-12 text-right border-bottom">
			<p>Date: ${.now?string["dd MMMM yyyy"]}</p>
			<p>No.: <#if payment??> ${payment.transactionId} <#else> - </#if></p>
		</div>
		
		<div class="col-md-12">
			<br />
			<table class="table1">
				<tbody>
						<tr>
							<td width="150">
								<u>No. Referensi</u><br />
								<i>Reference No.</i>
							</td>
							<td width="10">:</td>
							<td>${leads.referenceNumber}</td>
						</tr>
						<tr>
							<td>
								<u>Nama &amp; Alamat Tertanggung</u><br />
								<i>Name &amp; Address of Insured</i>
							</td>
							<td>:</td>
							<td>
								${leads.name}<br />
								${leads.address}<br />
								<#if (leads.address2)?has_content>${leads.address2}<br /></#if>
								<#if (leads.province)??>${leads.province}, ${leads.city}<br /></#if>
								<#if (leads.nationality)??>${leads.nationality?upper_case} ${leads.zip}<br /></#if>
							</td>
						</tr>
						<tr>
							<td>
								<u>Jangka Waktu</u><br />
								<i>Period</i>
							</td>
							<td>:</td>
							<td>${(leads.policyStartDate?number_to_datetime)?string["dd MMMM yyyy"]} - ${(leads.policyEndDate?number_to_datetime)?string["dd MMMM yyyy"]}
							</td>
						</tr>
						<tr>
							<td>
								<u>Jenis Asuransi</u><br />
								<i>Type of Insurance</i>
							</td>
							<td>:</td>
							<td>${product.productName}</td>
						</tr>
				</tbody>
			</table>
			<br />
		</div>
		
		<div class="col-md-12">
			<table class="table1">
				<thead>
					<tr>
						<th class="bgray border pad-5 text-center">Catatan / <i>Notes</i></th>
						<th class="bgray border pad-5 text-center">Perincian / <i>Details</i></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td width="50%" class="border border-nobottom pad-5">
							<p>
								Pembayaran dilakukan melalui transaksi bank transfer ke Rekening No. a.n PT MANDIRI AXA GENERAL INSURANCE, dengan mencantumkan Nomor Referensi Polis yang dibayarkan dan Nama Tertanggung dengan format : No. Referensi Polis ${leads.referenceNumber} a.n ${leads.name}
							</p><br />
							<p>
								Payment should be done thru bank transfer to Account No. PT MANDIRI AXA GENERAL INSURANCE, with stating the Policy Reference Number and Insured Name with format : No. Referensi Polis ${leads.referenceNumber} a.n ${leads.name}
							</p>
						</td>
						<td class="border pad-5">
							<table class="no-border" width="100%">
								<tr>
									<td width="30%">
										<u>Premi</u><br />
										<i>Premium</i>
									</td>
									<td width="100">: ${leads.currency}</td>
									<td class="text-right">${leads.premium}</td>
								</tr>
								
								<#if leads.stampDuty gt 0>
									<tr>
										<td>
											<u>Biaya Materai</u><br />
											<i>Duty Cost</i>
										</td>
										<td width="100">: ${leads.currency}</td>
										<td class="text-right">${leads.stampDuty}</td>
									</tr>
								</#if>

								<#if leads.discount gt 0>
									<tr>
										<td>
											<u>Diskon</u><br />
											<i>Discount</i>
										</td>
										<td width="100">: ${leads.currency}</td>
										<td class="text-right">${leads.discountAmount}</td>
									</tr>
								</#if>

								<tr>
									<td><br /><strong>
										<u>Jumlah</u><br />
										<i>Total</i></strong>
									</td>
									<td width="100"><br /><strong>: ${leads.currency}</strong></td>
									<td class="text-right"><br /><strong>${leads.netPremium}</strong></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td class="border border-notop vbottom pad-5">
							<p>Tuliskan no. referensi polis atau no. nota dikolom pesan pada slip transfer.</p>
							<i>Please input the Policy Reference No or Note No in the message column on the transfer slip.</i>
						</td>
						<td class="border text-center pad-5">
							<#include "/includes/signature.ftl">
						</td>
					</tr>
				</tbody>
			</table>
			<p>
				Dokumen ini BUKAN BUKTI PEMBAYARAN<br />
				<i>This Document is not a proof of payment</i>
			</p>
		</div>
	</div>
</section>