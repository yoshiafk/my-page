<div class="panel-summary">
	<div class="panel-summary__body">
		<div class="panel-summary__body-inner">
			<span class="text-product">Produk</span>
			<h1>SmartActive</h1>
			<% if (businessModel.equalsIgnoreCase("b2b")) { %>
				<div class="agent">
					<span class="agent__name">Agent</span>
					<% if (Validator.isNull(agentCode) && Validator.isNull(agentName)) { %>
						<span class="agent__status"></span>
					<% } else { %>
						<span class="agent__status"><%= agentCode.concat(" - ").concat(agentName) %></span>
					<% } %>
				</div>
			<% } %>
			<span class="text-protection">Proteksi Anda</span>
			<ul>
				<li>
					<span>Jaminan</span>
					<span id="Summary-TotalBenefit"></span>
				</li>
				<li class="gohide">
					<span>Biaya Polis</span>
					<span id="Summary-PolicyCost"></span>
				</li>
				<li>
					<span>Materai</span>
					<span id="Summary-Stampduty"></span>
				</li>
			</ul>
		</div>
		<div class="panel-summary__promo">
			<label for="promo-code" class="sa-label <% if (_step.equalsIgnoreCase("continue") || _step.equalsIgnoreCase("three")) { %>gohide<% } %>">Kode Promo</label>
			<div class="sa-input-group-axa input-group-axa--border <% if (_step.equalsIgnoreCase("continue") || _step.equalsIgnoreCase("three")) { %>gohide<% } %>">
				<input class="input-control-axa input-control-axa--outline promo-code" id="promo-code" name="PromoCodeSidebar" type="text" value="<%= promoCode %>">
				<div class="align-self-center">
					<button type="button" id="clear-promo-code-btn-sidebar">
						<svg width="22" height="22" viewBox="0 0 22 22" fill="none" xmlns="http://www.w3.org/2000/svg">
							<path d="M2.17815 14C3.4379 17.8327 7.04583 20.6 11.3001 20.6C16.602 20.6 20.9001 16.302 20.9001 11C20.9001 5.69809 16.602 1.40002 11.3001 1.40002C7.74674 1.40002 4.64429 3.33058 2.98441 6.20002M5.9001 7.40002H1.1001V2.60002" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
						</svg>
					</button>
				</div>
			</div>

			<ul>
				<li>
					<span>Diskon</span>
					<span>Total Premi</span>
				</li>
				<li>
					<span id="Summary-Discount"></span>
<!-- 					<span class="discount"></span> -->
					<span class="total" id="Summary-NetPremium"></span>
				</li>
			</ul>
			<% if ((_step.equalsIgnoreCase("one") == true || _step.equalsIgnoreCase("two") == true) && businessModel.equalsIgnoreCase("b2b")) { %>
				<a id="submit-quotation-btn" class="mb-4level agency__pointer btn btn--dark-grey width-full">
					<span class="position-relative agency__uppercase">
						Kirim Penawaran <i class="fas fa-arrow-right"></i>
					</span>
				</a>
			<% } %>
			
			
			<% if (_step.equalsIgnoreCase("continue") == true && businessModel.equalsIgnoreCase("B2B") ) { %>
			<div style="margin-bottom: 20px;">
					<a class="agency__pointer btn__ubah_quote btn btn--dark-grey width-full">
						<span class="position-relative agency__uppercase">
							Ubah Penawaran <svg class="inline-block" xmlns="http://www.w3.org/2000/svg" width="17" height="16" viewBox="0 0 17 16" fill="none">
																<path d="M9.70001 13.0346H13.7M3.30005 13.0346L6.21071 12.4481C6.36522 12.417 6.5071 12.3409 6.61853 12.2294L13.1343 5.71007C13.4467 5.3975 13.4465 4.89084 13.1338 4.57853L11.7536 3.19981C11.441 2.88764 10.9346 2.88785 10.6224 3.20029L4.10589 9.72032C3.99468 9.83159 3.91875 9.97318 3.88758 10.1274L3.30005 13.0346Z" stroke="white" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
						</span>
					</a>
			</div>
			<% } %>
			
			
			
			
			<%
				String _wording = _step.equalsIgnoreCase("one") == true ? "Lanjut ke data Tertanggung" :
						   		  _step.equalsIgnoreCase("two") == true ? "Lanjut ke Persetujuan" :
						   		  _step.equalsIgnoreCase("three") == true ? "Lanjut ke Pembayaran" : 
						   		  _step.equalsIgnoreCase("continue") == true ? "Selanjutnya" : "Bayar";
			%>
			<a class="agency__pointer btn__next btn btn--dark-grey width-full">
				<span class="position-relative agency__uppercase">
					<%= _wording %> <i class="fas fa-arrow-right"></i>
				</span>
			</a>
			
			<% if (_step.equalsIgnoreCase("one") == true || _step.equalsIgnoreCase("two") == true) { %>
				<div id="label__mandatory__warning">
				    <span class="label_warning">
				        * Periksa kelengkapan data Anda
				    </span>
				    	<a class="agency__pointer check-link__mandatory">(Klik di sini)</a>
				</div>
			<% } %>
			
			
			
			
			
		</div>
	</div>
</div>