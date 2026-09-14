<div class="nav-summary">
	<div class="container-axa">
		<div class="nav-summary__inner">
			<ul>
				<li>Ringkasan Produk</li>
			</ul>
			<% if (files.size() > 0) { %>
			<ul>
				<% for (SmartActiveLink itemFile : files) { %>
					<li>
						<a href="<%= itemFile.getFileUploadUrl() %>" target="_blank">
							<span class="position-relative"><%= itemFile.getTitle().replace("-", "").replace("FormulirKlaim", "Formulir Klaim").replace("AsuransiSmartActive", "") %></span>
						</a>
					</li>
				<% } %>
			</ul>
			<% } %>
		</div>
	</div>
</div>

<div class="container-axa">
	<div class="sa-stepper-wrapper">
		<div class="sa-stepper-item <%= _step == "one" ? "active" : "" %>">
			<div class="sa-step-name agency__uppercase">Pilih Polis</div>
			<div class="step-counter"></div>
		</div>
		<div class="sa-stepper-item <%= _step == "two" ? "active" : "" %>">
			<div class="sa-step-name agency__uppercase">Data Tertanggung</div>
			<div class="step-counter"></div>
		</div>
		<div class="sa-stepper-item <%= _step == "three" ? "active" : "" %>">
			<div class="sa-step-name agency__uppercase">Persetujuan</div>
			<div class="step-counter"></div>
		</div>
		<div class="sa-stepper-item <%= _step == "payment" ? "active" : "" %>">
			<div class="sa-step-name agency__uppercase">Pembayaran</div>
			<div class="step-counter"></div>
		</div>
	</div>
</div>