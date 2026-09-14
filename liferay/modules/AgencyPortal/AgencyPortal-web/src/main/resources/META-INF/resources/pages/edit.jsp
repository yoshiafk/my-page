<%@ include file="../init.jsp" %>

<%
	MypageUser _user = (MypageUser) renderRequest.getAttribute("myPageUser");
	boolean isTaxation = (boolean) renderRequest.getAttribute("isTaxation");

	ActionHelpers helpers = new ActionHelpers();
	String host = helpers.getConfig("com.mypage.agent.config.pimcoreHost");
	
	String renderToken = !Validator.isNull((String) renderRequest.getAttribute("renderToken")) ? (String) renderRequest.getAttribute("renderToken") : "";
	String apiRequestToken = !Validator.isNull((String) renderRequest.getAttribute("apiRequestToken")) ? (String) renderRequest.getAttribute("apiRequestToken") : "";
	String encodeToken = !Validator.isNull((String) renderRequest.getAttribute("encodeToken")) ? (String) renderRequest.getAttribute("encodeToken") : "";
%>

<portlet:resourceURL id="/data/agentpage" var="loadAgentPageData" />

<div class="breadcrumbs container-breadcrumbs-axa">
	<nav class="width-full">
		<ol class="list-reset display-inline-flex">
			<li class="text-13px agency-self-center">
				<a href="<%= host %>/dashboard" class="link-dashboard">Beranda</a>
			</li>
			<li class="agency-self-center">
				<span class="text-13px">/</span>
			</li>
			<li class="text-13px agency-uppercase agency-self-center">Ubah Profil</li>
		</ol>
	</nav>
</div>

<div class="dashboard-profile">
	<div class="container-axa">
		<div class="dashboard-profile__biodata">
			<div class="dashboard-profile__biodata-inner">
				<div class="dashboard-profile__biodata--left">
					<div class="dashboard-profile__biodata--left-inner">
						<%
							Long imageEntryId = Validator.isNull(_user.getProfileImageFileEntryId()) ? 0 : _user.getProfileImageFileEntryId();
						%>
						<c:if test="<%= imageEntryId > 0  %>">
							<%
								FileEntry image = DLAppLocalServiceUtil.getFileEntry(imageEntryId);
								String imageUrl = "/documents/" + image.getGroupId() + "/" + image.getFolderId() + "/" + image.getFileName(); 
							%>
							<liferay-adaptive-media:img class="placeholder-img" fileVersion="<%= image.getFileVersion() %>" />
						</c:if>
						<c:if test="<%= imageEntryId == 0  %>">					    
							<img class="placeholder-img" src="/o/agency-theme/images/placeholder-profile.png" alt="" loading="lazy" />
						</c:if>
						<div class="dashboard-profile__biodata--detail">
							<p class="text-14px letter-spacing-1px">Biodata</p>
							<h1 class="text-24px mb-20px"><%= _user.getUserName() %></h1>
							<ul class="list-group-biodata">
								<fmt:formatDate value="<%= _user.getDob() == null ? null : _user.getDob() %>" pattern="dd-MMMM-yyyy" var="formattedStartDate" />
								<%
									String gender = _user.getGender().equalsIgnoreCase("F") == true ? "Perempuan" : _user.getGender().equalsIgnoreCase("L") == true ? "Laki-laki" : "";
									String address = _user.getAddress();
									String mobilePhone = _user.getMobilePhone();
									String email = _user.getEmail();
								%>
								<c:if test="<%= Validator.isNotNull(_user.getDob()) %>">
									<li class="display-grid">
										<span>Tanggal Lahir</span>
										<strong>${formattedStartDate}</strong>
									</li>
								</c:if>
								<c:if test="<%= Validator.isNotNull(gender) %>">
									<li class="display-grid">
										<span>Jenis Kelamin</span>
										<strong><%= gender %></strong>
									</li>
								</c:if>
								<c:if test="<%= Validator.isNotNull(address) %>">
									<li class="display-grid">
										<span>Alamat</span>
										<strong><%= address %></strong>
									</li>
								</c:if>
								<c:if test="<%= Validator.isNotNull(mobilePhone) %>">
									<li class="display-grid">
										<span>Telepon</span>
										<strong><%= mobilePhone %></strong>
									</li>
								</c:if>
								<c:if test="<%= Validator.isNotNull(email) %>">
									<li class="display-grid">
										<span>Email</span>
										<strong><%= email %></strong>
									</li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
				<div class="dashboard-profile__biodata--right">
					<div class="dashboard-profile__biodata--right-inner">
						<a href="<%= host %>/dashboard/profile" class="btn__agency btn--dark-blue link-profile">
							<span class="position-relative order-10 display-flex">
								<span class="mr-8px">Lihat Profil</span>
								<svg class="agency-self-baseline" xmlns="http://www.w3.org/2000/svg" width="17" height="16" viewBox="0 0 17 16" fill="none">
									<path d="M14.0997 14.3996L14.0999 11.9998C14.1 10.6743 13.0255 9.59961 11.6999 9.59961H5.30042C3.97504 9.59961 2.90057 10.674 2.90042 11.9993L2.90015 14.3996M10.9001 3.99961C10.9001 5.32509 9.82563 6.39961 8.50015 6.39961C7.17466 6.39961 6.10015 5.32509 6.10015 3.99961C6.10015 2.67413 7.17466 1.59961 8.50015 1.59961C9.82563 1.59961 10.9001 2.67413 10.9001 3.99961Z" stroke="white" stroke-width="1.25" stroke-linecap="round" stroke-linejoin="round"/>
								</svg>
							</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="dashboard-edit-profile">
	<div class="container-axa">
		<div class="display-grid grid-cols-repeat-12 gap-16px">
			<div class="dashboard-edit-profile__left">
				<div class="select-tab-wrapper">
					<select class="input-control" id="SelectTabs">
						<option value="0">Informasi Dasar</option>
						<option value="1">Lokasi</option>
						<option value="2">Jam Operasional</option>
						<option value="3">Sosial Media</option>
						<option value="4">Ubah kata sandi</option>
					</select>
				</div>
				<div class="nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
					<button class="nav-link display-block active" id="v-pills-InformasiDasar-tab" data-bs-toggle="pill" data-bs-target="#v-pills-InformasiDasar" type="button" role="tab" aria-controls="v-pills-InformasiDasar" aria-selected="true">
						<span class="display-flex">
							<span class="btn-box display-inline-block w-12px-h-20px"></span>
							<span>Informasi Dasar</span>
						</span>
					</button>
					<button class="nav-link display-block" id="v-pills-Lokasi-tab" data-bs-toggle="pill" data-bs-target="#v-pills-Lokasi" type="button" role="tab" aria-controls="v-pills-Lokasi" aria-selected="false">
						<span class="display-flex">
							<span class="btn-box display-inline-block w-12px-h-20px"></span>
							<span>Lokasi</span>
						</span>
					</button>
					<button class="nav-link display-block" id="v-pills-JamOperasional-tab" data-bs-toggle="pill" data-bs-target="#v-pills-JamOperasional" type="button" role="tab" aria-controls="v-pills-JamOperasional" aria-selected="false">
						<span class="display-flex">
							<span class="btn-box display-inline-block w-12px-h-20px"></span>
							<span>Jam Operasional</span>
						</span>
					</button>
					<button class="nav-link display-block" id="v-pills-SosialMedia-tab" data-bs-toggle="pill" data-bs-target="#v-pills-SosialMedia" type="button" role="tab" aria-controls="v-pills-SosialMedia" aria-selected="false">
						<span class="display-flex">
							<span class="btn-box display-inline-block w-12px-h-20px"></span>
							<span>Sosial Media</span>
						</span>
					</button>
					<button class="nav-link display-block" id="v-pills-UbahKataKunci-tab" data-bs-toggle="pill" data-bs-target="#v-pills-UbahKataKunci" type="button" role="tab" aria-controls="v-pills-UbahKataKunci" aria-selected="false">
						<span class="display-flex">
							<span class="btn-box display-inline-block w-12px-h-20px"></span>
							<span>Ubah kata sandi</span>
						</span>
					</button>
				</div>
			</div>
			<div class="dashboard-edit-profile__right">
				<div class="multi-step-form">
					<form class="profile-form" id="Myprofile" action="javascript:void()" autocomplete="off" novalidate="novalidate">
						<div class="tab-content" id="v-pills-tabContent">
							<div class="tab-pane fade show active" id="v-pills-InformasiDasar" role="tabpanel" aria-labelledby="v-pills-InformasiDasar-tab" tabindex="0">
								<div class="p-30px-30px-20px-30px">
									<div class="alert-agency display-none mb-20px">
										<span class="agency-font-semibold"></span>
									</div>
									<h3 class="text-32px">Halaman Saya</h3>
									<div class="change-profile-grid">
										<div class="change-profile">
											<div class="preview-zone preview-zone-profile display-none">
												<div class="box box-profile box-solid">
													<div class="box-body box-body-profile">
													</div>
													<div class="box-header">
														<div class="box-tools">
															<button type="button" class="btn__agency btn btn--dark-blue remove-preview remove-preview-profile">
																<span class="position-relative order-10 display-flex">Hapus</span>
															</button>
														</div>
													</div>
												</div>
											</div>
											<div class="dropzone-wrapper dropzone-profile-wrapper">
												<div class="dropzone-desc dropzone-profile-desc">
													<div class="dropzone-desc__left large-mr-24px">
														<div class="placeholder-upload"></div>
													</div>
													<div class="dropzone-desc__center agency-self-center">
														<div class="placeholder-caption">
															<p>Ganti Profil</p>
														</div>
														<span class="btn__agency btn--grey choose-file">
															<span class="position-relative">Pilih file</span>
														</span>
													</div>
													<div class="dropzone-desc__right agency-self-center">
														<p>Tidak ada</p>
													</div>
												</div>
												<input type="file" name="img-upload-profile" class="dropzone dropzone-profile" accept="image/gif, image/jpeg, image/png">
											</div>
										</div>
										<div class="change-banner">
											<div class="preview-zone preview-zone-banner display-none">
												<div class="box box-banner box-solid">
													<div class="box-body box-body-banner">
													</div>
													<div class="box-header">
														<div class="box-tools">
															<button type="button" class="btn__agency btn btn--dark-blue remove-preview remove-preview-banner">
																<span class="position-relative order-10 display-flex">Hapus</span>
															</button>
														</div>
													</div>
												</div>
											</div>
											<div class="dropzone-wrapper dropzone-banner-wrapper">
												<div class="dropzone-desc dropzone-banner-desc">
													<div class="dropzone-dropzone-desc__left">
														<div class="placeholder-upload"></div>
													</div>
													<div class="dropzone-desc__center agency-text-left agency-self-center">
														<div class="placeholder-caption">
															<p>Gambar Banner</p>
														</div>
														<span class="btn__agency btn--grey choose-file">
															<span class="position-relative">Pilih file</span>
														</span>
													</div>
													<div class="dropzone-desc__right agency-self-center">
														<p>Tidak ada</p>
													</div>
												</div>
												<input type="file" name="img-upload-banner" class="dropzone dropzone-banner" accept="image/gif, image/jpeg, image/png">
											</div>
										</div>
									</div>
									<div class="information-wrapper">
										<div class="col-url">
											<div class="mb-15px">
												<label class="label__agency" for="url">Tautan Link</label>
												<input class="input-control agency-normalcase input-control--outline agency-bg-transparent <%= _user.getPrettyUrlChange() == 2 ? "disabled" : "" %>" type="text" name="pretty-url" id="pretty-url" value="<%= _user.getPrettyUrl() %>" <% if (_user.getPrettyUrlChange() == 2) { %>disabled<% } %>>
												<span class="text-12px">URL : <a href="<%= host.concat("/").concat(_user.getPrettyUrl()) %>" class="link-pretty-url"><%= host.concat("/").concat(_user.getPrettyUrl()) %></a></span>
											</div>
										</div>
										<div class="col-number-hp">
											<div class="mb-15px">
												<label class="label__agency" for="number-hp">Nomor HP<sup>*</sup></label>
												<input class="input-control agency-normalcase input-control--outline agency-bg-transparent phone" name="number-hp" id="number-hp" type="text" placeholder="Masukkan nomor HP" value="<%= _user.getMobilePhone() %>" required>
												<span class="note-text">Wajib Diisi</span>
											</div>
										</div>
										<div class="col-number-tlp">
											<div class="mb-15px">
												<label class="label__agency" for="number-tlp">Nomor Telepon</label>
												<input class="input-control agency-normalcase input-control--outline agency-bg-transparent telephone" name="number-tlp" id="number-tlp" type="text" placeholder="Masukkan nomor Telepon" value="<%= _user.getPhone() %>">
											</div>
										</div>
										<div class="col-basic">
											<div class="mb-10px">
												<label class="label__agency" for="DasarPerhitungan">Basis Dasar Perhitungan</label>
												<select class="input-control filter-report" name="DasarPerhitungan" id="DasarPerhitungan" required>
													<option value="Gross" <%= _user.getPaymentMethod().equalsIgnoreCase("gross") == true ? "selected" : "" %>>Gross Premium</option>
													<% if (isTaxation == true) { %>
														<option value="Nett" <%= _user.getPaymentMethod().equalsIgnoreCase("nett") == true ? "selected" : "" %>>Nett Premium</option>
													<% } %>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="information-wrapper-bottom p-20px-30px">
									<button type="button" class="btn__agency btn--dark-blue p-12px-30px-10px-30px" onclick="saveBasicInfo()">
										<span class="position-relative order-10 display-flex">
											<span class="mr-8px">Simpan</span>
											<svg class="agency-self-baseline" xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 16 16" fill="none">
												<path d="M4.39998 13.5996V9.99961C4.39998 9.55778 4.75815 9.19961 5.19998 9.19961H10.8C11.2418 9.19961 11.6 9.55778 11.6 9.99961V13.9996M11.6 2.39961V3.99961C11.6 4.44144 11.2418 4.79961 10.8 4.79961L5.19998 4.79961C4.75815 4.79961 4.39998 4.44144 4.39998 3.99961L4.39998 1.59961M13.9983 4.39792L11.6017 2.0013C11.3445 1.7441 10.9956 1.59961 10.6319 1.59961H2.9714C2.21398 1.59961 1.59998 2.21361 1.59998 2.97104V13.0282C1.59998 13.7856 2.21398 14.3996 2.9714 14.3996H13.0285C13.786 14.3996 14.4 13.7856 14.4 13.0282V5.36767C14.4 5.00394 14.2555 4.65511 13.9983 4.39792Z" stroke="white" stroke-width="1.25" stroke-linecap="round"/>
											</svg>
										</span>
									</button>
								</div>
							</div>
							<div class="tab-pane fade" id="v-pills-Lokasi" role="tabpanel" aria-labelledby="v-pills-Lokasi-tab" tabindex="0">
								<div class="p-30px">
									<div class="alert-agency display-none mb-20px">
										<span class="agency-font-semibold"></span>
									</div>
									<h3 class="text-32px">Tentukan Lokasi</h3>
									<div class="col-address">
										<div class="mb-15px">
											<label class="label__agency" for="address">Alamat</label>
											<textarea class="input-control" id="address" rows="3" placeholder="Alamat anda"><%= _user.getAddress() %></textarea>
										</div>
									</div>
									<div class="location-wrapper">
										<div class="col-span-12-12">
											<label class="label__agency" for="searchTextField">Pencarian</label>
											<div class="input-group">
												<input class="input-control agency-normalcase input-control--outline agency-bg-transparent" name="searchTextField" id="searchTextField" type="text" placeholder="Cari Berdasarkan Lokasi">
												<span class="btn-group">
													<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
														<path d="M16.9268 17.0401L20.4 20.4001M19.28 11.4401C19.28 15.77 15.7699 19.2801 11.44 19.2801C7.11006 19.2801 3.59998 15.77 3.59998 11.4401C3.59998 7.11019 7.11006 3.6001 11.44 3.6001C15.7699 3.6001 19.28 7.11019 19.28 11.4401Z" stroke="#1F1F9C" stroke-width="2" stroke-linecap="round"></path>
													</svg>
												</span>
											</div>
										</div>
										<div class="col-span-12-12">
											<div id="map_canvas" class="w-full h-350px"></div>
										</div>
										<div class="col-latitude">
											<label class="label__agency" for="latitude">Lintang</label>
											<input class="input-control agency-normalcase input-control--outline agency-bg-transparent MapLat disabled" name="latitude" id="latitude" type="text" placeholder="Lintang" value="<%= _user.getLatitude() %>" disabled>
										</div>
										<div class="col-longitude">
											<label class="label__agency" for="longitude">Bujur</label>
											<input class="input-control agency-normalcase input-control--outline agency-bg-transparent MapLon disabled" name="longitude" id="longitude" type="text" placeholder="Bujur" value="<%= _user.getLongitude() %>" disabled>
										</div>
									</div>
								</div>
								<div class="location-wrapper-bottom p-20px-30px">
									<button type="button" class="btn__agency btn--dark-blue p-12px-30px-10px-30px" onclick="saveLocation()">
										<span class="position-relative order-10 display-flex">
											<span class="mr-8px">Simpan</span>
											<svg class="agency-self-baseline" xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 16 16" fill="none">
												<path d="M4.39998 13.5996V9.99961C4.39998 9.55778 4.75815 9.19961 5.19998 9.19961H10.8C11.2418 9.19961 11.6 9.55778 11.6 9.99961V13.9996M11.6 2.39961V3.99961C11.6 4.44144 11.2418 4.79961 10.8 4.79961L5.19998 4.79961C4.75815 4.79961 4.39998 4.44144 4.39998 3.99961L4.39998 1.59961M13.9983 4.39792L11.6017 2.0013C11.3445 1.7441 10.9956 1.59961 10.6319 1.59961H2.9714C2.21398 1.59961 1.59998 2.21361 1.59998 2.97104V13.0282C1.59998 13.7856 2.21398 14.3996 2.9714 14.3996H13.0285C13.786 14.3996 14.4 13.7856 14.4 13.0282V5.36767C14.4 5.00394 14.2555 4.65511 13.9983 4.39792Z" stroke="white" stroke-width="1.25" stroke-linecap="round"/>
											</svg>
										</span>
									</button>
								</div>
							</div>
							<div class="tab-pane fade" id="v-pills-JamOperasional" role="tabpanel" aria-labelledby="v-pills-JamOperasional-tab" tabindex="0">
								<div class="p-30px-30px-0px-30px">
									<div class="alert-agency display-none mb-20px">
										<span class="agency-font-semibold"></span>
									</div>
									<h3 class="text-32px">Jam Operasional</h3>
									<p>Pilih salah satu kondisi untuk jam operasional</p>
								</div>
								<div class="p-0px-30px-30px-30px">
									<div class="operational-hour-wrapper">
										<div class="btn-radio-left">
											<input class="display-none hour-optional" type="radio" name="operasional" id="24jam">
											<label class="label__agency display-table table__agency h-217px" for="24jam">
												<div class="agency-table-cell vertical-align-middle">
													<svg class="display-block m-x-auto" xmlns="http://www.w3.org/2000/svg" width="104" height="94" viewBox="0 0 104 94" fill="none">
														<path class="arrow" d="M101.5 87.5L93.5 88.5L95.5 80.5" stroke="#CCCCCC" stroke-width="1.5"/>
														<circle cx="80" cy="70" r="23" stroke="#CCCCCC" stroke-width="2"/>
														<path class="seven" d="M77.18 77C77.26 75.5867 77.4133 74.32 77.64 73.2C77.8667 72.08 78.2133 71.0067 78.68 69.98C79.1467 68.9533 79.78 67.8867 80.58 66.78H74.88V64.3H83.72V66.1C82.9867 66.9933 82.3933 67.8333 81.94 68.62C81.5 69.4067 81.1533 70.2133 80.9 71.04C80.66 71.8533 80.4867 72.74 80.38 73.7C80.2733 74.66 80.1933 75.76 80.14 77H77.18Z" fill="#999999"/>
														<circle cx="39" cy="39" r="38" fill="white" stroke="#CCCCCC" stroke-width="2"/>
														<path class="twenty-four" d="M21.448 49V46.408C24.328 44.104 26.28 42.28 28.168 40.136C30.344 37.704 31.496 35.72 31.496 32.2C31.496 28.776 30.312 27.688 28.584 27.688C27.24 27.688 26.92 28.104 26.856 29.256C26.76 31.816 25.896 32.552 24.072 32.552C22.6 32.552 21.8 31.752 21.8 30.408C21.8 28.328 24.264 26.44 29.096 26.44C33.864 26.44 37.256 28.552 37.256 32.872C37.256 37.416 31.784 41.192 25.352 44.712V44.904H33.416C35.016 44.904 35.24 44.616 36.232 42.376H37.16L36.68 49H21.448ZM45.0378 49V48.104L46.1898 47.88C47.2778 47.624 47.5338 47.496 47.5338 45.544V42.792H38.5098V41.064L49.5818 26.824H53.1338V40.488H56.3978L56.0778 42.792H53.1338V45.544C53.1338 47.496 53.3898 47.656 54.5098 47.88L55.7257 48.104V49H45.0378ZM40.8458 40.488H47.5338V31.912H47.4378L40.8458 40.392V40.488Z" fill="#999999"/>
													</svg>
													<span class="display-block mt-15px">Jam Operasional 24/7</span>
												</div>
											</label>
										</div>
										<div class="btn-radio-right">
											<input class="display-none hour-optional" type="radio" name="operasional" id="aturjam" checked>
											<label class="label__agency display-table table__agency h-217px" for="aturjam">
												<div class="agency-table-cell vertical-align-middle">
													<svg class="display-block m-x-auto" xmlns="http://www.w3.org/2000/svg" width="78" height="78" viewBox="0 0 78 78" fill="none">
														<path d="M35 37L28 32" stroke="#CCCCCC" stroke-width="2"/>
														<path d="M43 37L64.5 22" stroke="#CCCCCC" stroke-width="2"/>
														<circle cx="39" cy="39" r="38" stroke="#CCCCCC" stroke-width="2"/>
														<path d="M39 0.5V12.5" stroke="#CCCCCC" stroke-width="2"/>
														<path d="M77.25 38.75L65.25 38.75" stroke="#CCCCCC" stroke-width="2"/>
														<path d="M39 65V77" stroke="#CCCCCC" stroke-width="2"/>
														<path d="M12.75 38.75L0.75 38.75" stroke="#CCCCCC" stroke-width="2"/>
														<circle cx="39" cy="39" r="4" stroke="#CCCCCC" stroke-width="2"/>
													</svg>
													<span class="display-block mt-30px">Atur Jam Operasional</span>
												</div>
											</label>
										</div>
									</div>
								</div>
								<div class="hours-list p-0px-30px-20px-30px">
									<h4 class="text-20px">Jam Operasional</h4>
									<div
										class="hours-wrapper display-grid grid-cols-repeat-12">
										<div class="col-day">
											<div
												class="display-inline-flex align-items-center checkbox-custom-wrapper">
												<input id="senin" class="checkbox-custom hour" name="senin"
													type="checkbox" /> <label for="senin"
													class="label__agency checkbox-custom-label"> <span>Senin</span>
												</label>
											</div>
										</div>
										<div class="col-hour senin">
											<div class="display-grid grid-cols-repeat-12 gap-20px">
												<div class="col-span-6-6">
													<label class="label__agency" for="jam-buka">Jam
														Buka</label> <input
														class="input-control time agency-normalcase input-control--outline agency-bg-transparent"
														name="jam-buka" id="jam-buka-senin" type="text" />
												</div>
												<div class="col-span-6-6">
													<label class="label__agency" for="jam-tutup">Jam
														Tutup</label> <input
														class="input-control time agency-normalcase input-control--outline agency-bg-transparent"
														name="jam-tutup" id="jam-tutup-senin" type="text" />
												</div>
											</div>
										</div>
									</div>
									<div class="hours-wrapper display-grid grid-cols-repeat-12">
										<div class="col-day">
											<div
												class="display-inline-flex align-items-center checkbox-custom-wrapper">
												<input id="selasa" class="checkbox-custom hour"
													name="selasa" type="checkbox" /> <label for="selasa"
													class="label__agency checkbox-custom-label"> <span>Selasa</span>
												</label>
											</div>
										</div>
										<div class="col-hour selasa">
											<div class="display-grid grid-cols-repeat-12 gap-20px">
												<div class="col-span-6-6">
													<label class="label__agency" for="jam-buka">Jam
														Buka</label> <input
														class="input-control time agency-normalcase input-control--outline agency-bg-transparent"
														name="jam-buka" id="jam-buka-selasa" type="text" />
												</div>
												<div class="col-span-6-6">
													<label class="label__agency" for="jam-tutup">Jam
														Tutup</label> <input
														class="input-control time agency-normalcase input-control--outline agency-bg-transparent"
														name="jam-tutup" id="jam-tutup-selasa" type="text" />
												</div>
											</div>
										</div>
									</div>
									<div class="hours-wrapper display-grid grid-cols-repeat-12">
										<div class="col-day">
											<div
												class="display-inline-flex align-items-center checkbox-custom-wrapper">
												<input id="rabu" class="checkbox-custom hour" name="rabu"
													type="checkbox" /> <label for="rabu"
													class="label__agency checkbox-custom-label"> <span>Rabu</span>
												</label>
											</div>
										</div>
										<div class="col-hour rabu">
											<div class="display-grid grid-cols-repeat-12 gap-20px">
												<div class="col-span-6-6">
													<label class="label__agency" for="jam-buka">Jam
														Buka</label> <input
														class="input-control time agency-normalcase input-control--outline agency-bg-transparent"
														name="jam-buka" id="jam-buka-rabu" type="text" />
												</div>
												<div class="col-span-6-6">
													<label class="label__agency" for="jam-tutup">Jam
														Tutup</label> <input
														class="input-control time agency-normalcase input-control--outline agency-bg-transparent"
														name="jam-tutup" id="jam-tutup-rabu" type="text" />
												</div>
											</div>
										</div>
									</div>
									<div class="hours-wrapper display-grid grid-cols-repeat-12">
										<div class="col-day">
											<div
												class="display-inline-flex align-items-center checkbox-custom-wrapper">
												<input id="kamis" class="checkbox-custom hour" name="kamis"
													type="checkbox" /> <label for="kamis"
													class="label__agency checkbox-custom-label"> <span>Kamis</span>
												</label>
											</div>
										</div>
										<div class="col-hour kamis">
											<div class="display-grid grid-cols-repeat-12 gap-20px">
												<div class="col-span-6-6">
													<label class="label__agency" for="jam-buka">Jam
														Buka</label> <input
														class="input-control time agency-normalcase input-control--outline agency-bg-transparent"
														name="jam-buka" id="jam-buka-kamis" type="text" />
												</div>
												<div class="col-span-6-6">
													<label class="label__agency" for="jam-tutup">Jam
														Tutup</label> <input
														class="input-control time agency-normalcase input-control--outline agency-bg-transparent"
														name="jam-tutup" id="jam-tutup-kamis" type="text" />
												</div>
											</div>
										</div>
									</div>
									<div class="hours-wrapper display-grid grid-cols-repeat-12">
										<div class="col-day">
											<div
												class="display-inline-flex align-items-center checkbox-custom-wrapper">
												<input id="jumat" class="checkbox-custom hour" name="jumat"
													type="checkbox" /> <label for="jumat"
													class="label__agency checkbox-custom-label"> <span>Jumat</span>
												</label>
											</div>
										</div>
										<div class="col-hour jumat">
											<div class="display-grid grid-cols-repeat-12 gap-20px">
												<div class="col-span-6-6">
													<label class="label__agency" for="jam-buka">Jam
														Buka</label> <input
														class="input-control time agency-normalcase input-control--outline agency-bg-transparent"
														name="jam-buka" id="jam-buka-jumat" type="text" />
												</div>
												<div class="col-span-6-6">
													<label class="label__agency" for="jam-tutup">Jam
														Tutup</label> <input
														class="input-control time agency-normalcase input-control--outline agency-bg-transparent"
														name="jam-tutup" id="jam-tutup-jumat" type="text" />
												</div>
											</div>
										</div>
									</div>
									<div class="hours-wrapper display-grid grid-cols-repeat-12">
										<div class="col-day">
											<div
												class="display-inline-flex align-items-center checkbox-custom-wrapper">
												<input id="sabtu" class="checkbox-custom hour" name="sabtu"
													type="checkbox" /> <label for="sabtu"
													class="label__agency checkbox-custom-label"> <span>Sabtu</span>
												</label>
											</div>
										</div>
										<div class="col-hour sabtu">
											<div class="display-grid grid-cols-repeat-12 gap-20px">
												<div class="col-span-6-6">
													<label class="label__agency" for="jam-buka">Jam
														Buka</label> <input
														class="input-control time agency-normalcase input-control--outline agency-bg-transparent"
														name="jam-buka" id="jam-buka-sabtu" type="text" />
												</div>
												<div class="col-span-6-6">
													<label class="label__agency" for="jam-tutup">Jam
														Tutup</label> <input
														class="input-control time agency-normalcase input-control--outline agency-bg-transparent"
														name="jam-tutup" id="jam-tutup-sabtu" type="text" />
												</div>
											</div>
										</div>
									</div>
									<div class="hours-wrapper display-grid grid-cols-repeat-12">
										<div class="col-day">
											<div
												class="display-inline-flex align-items-center checkbox-custom-wrapper">
												<input id="minggu" class="checkbox-custom hour"
													name="minggu" type="checkbox" /> <label for="minggu"
													class="label__agency checkbox-custom-label"> <span>Minggu</span>
												</label>
											</div>
										</div>
										<div class="col-hour minggu">
											<div class="display-grid grid-cols-repeat-12 gap-20px">
												<div class="col-span-6-6">
													<label class="label__agency" for="jam-buka">Jam
														Buka</label> <input
														class="input-control time agency-normalcase input-control--outline agency-bg-transparent"
														name="jam-buka" id="jam-buka-minggu" type="text" />
												</div>
												<div class="col-span-6-6">
													<label class="label__agency" for="jam-tutup">Jam
														Tutup</label> <input
														class="input-control time agency-normalcase input-control--outline agency-bg-transparent"
														name="jam-tutup" id="jam-tutup-minggu" type="text" />
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="operational-hour-wrapper-bottom p-20px-30px">
									<button type="button" class="btn__agency btn--dark-blue p-12px-30px-10px-30px" onclick="saveWorkingHour()">
										<span class="position-relative order-10 display-flex">
											<span class="mr-8px">Simpan</span>
											<svg class="agency-self-baseline" xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 16 16" fill="none">
												<path d="M4.39998 13.5996V9.99961C4.39998 9.55778 4.75815 9.19961 5.19998 9.19961H10.8C11.2418 9.19961 11.6 9.55778 11.6 9.99961V13.9996M11.6 2.39961V3.99961C11.6 4.44144 11.2418 4.79961 10.8 4.79961L5.19998 4.79961C4.75815 4.79961 4.39998 4.44144 4.39998 3.99961L4.39998 1.59961M13.9983 4.39792L11.6017 2.0013C11.3445 1.7441 10.9956 1.59961 10.6319 1.59961H2.9714C2.21398 1.59961 1.59998 2.21361 1.59998 2.97104V13.0282C1.59998 13.7856 2.21398 14.3996 2.9714 14.3996H13.0285C13.786 14.3996 14.4 13.7856 14.4 13.0282V5.36767C14.4 5.00394 14.2555 4.65511 13.9983 4.39792Z" stroke="white" stroke-width="1.25" stroke-linecap="round"/>
											</svg>
										</span>
									</button>
								</div>
							</div>
							<div class="tab-pane fade" id="v-pills-SosialMedia" role="tabpanel" aria-labelledby="v-pills-SosialMedia-tab" tabindex="0">
								<div class="p-30px-30px-20px-30px">
									<div class="alert-agency display-none mb-20px">
										<span class="agency-font-semibold"></span>
									</div>
									<h3 class="text-32px">Sosial Media</h3>
									<p>Hubungkan sosial media Anda</p>
									<div class="social-media-wrapper">
										<div class="col-social-media">
											<div class="mb-15px">
												<label class="label__agency" for="fb-url">Facebook</label>
												<input class="input-control agency-normalcase input-control--outline agency-bg-transparent" type="text" id="fb-url" value="<%= _user.getFacebook() %>">
											</div>
										</div>
										<div class="col-social-media">
											<div class="mb-15px">
												<label class="label__agency" for="x-twitter-url">X.com (Twitter)</label>
												<input class="input-control agency-normalcase input-control--outline agency-bg-transparent" type="text" id="x-twitter-url" value="<%= _user.getTwitter() %>">
											</div>
										</div>
										<div class="col-social-media">
											<div class="mb-15px">
												<label class="label__agency" for="tiktok-url">Tiktok</label>
												<input class="input-control agency-normalcase input-control--outline agency-bg-transparent" type="text" id="tiktok-url" value="<%= _user.getTiktok() %>">
											</div>
										</div>
										<div class="col-social-media">
											<div class="mb-15px">
												<label class="label__agency" for="linkedin-url">Linkedin</label>
												<input class="input-control agency-normalcase input-control--outline agency-bg-transparent" type="text" id="linkedin-url" value="<%= _user.getLinkedIn() %>">
											</div>
										</div>
										<div class="col-social-media">
											<div class="mb-15px">
												<label class="label__agency" for="instagram-url">Instagram</label>
												<input class="input-control agency-normalcase input-control--outline agency-bg-transparent" type="text" id="instagram-url" value="<%= _user.getInstagram() %>">
											</div>
										</div>
										<div class="col-social-media">
											<div class="mb-15px">
												<label class="label__agency" for="blog-url">Blog</label>
												<input class="input-control agency-normalcase input-control--outline agency-bg-transparent" type="text" id="blog-url" value="<%= _user.getBlog() %>">
											</div>
										</div>
									</div>
								</div>
								<div class="social-media-wrapper-bottom p-20px-30px">
									<button type="button" class="btn__agency btn--dark-blue p-12px-30px-10px-30px" onclick="saveSocialMedia()">
										<span class="position-relative order-10 display-flex">
											<span class="mr-8px">Simpan</span>
											<svg class="agency-self-baseline" xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 16 16" fill="none">
												<path d="M4.39998 13.5996V9.99961C4.39998 9.55778 4.75815 9.19961 5.19998 9.19961H10.8C11.2418 9.19961 11.6 9.55778 11.6 9.99961V13.9996M11.6 2.39961V3.99961C11.6 4.44144 11.2418 4.79961 10.8 4.79961L5.19998 4.79961C4.75815 4.79961 4.39998 4.44144 4.39998 3.99961L4.39998 1.59961M13.9983 4.39792L11.6017 2.0013C11.3445 1.7441 10.9956 1.59961 10.6319 1.59961H2.9714C2.21398 1.59961 1.59998 2.21361 1.59998 2.97104V13.0282C1.59998 13.7856 2.21398 14.3996 2.9714 14.3996H13.0285C13.786 14.3996 14.4 13.7856 14.4 13.0282V5.36767C14.4 5.00394 14.2555 4.65511 13.9983 4.39792Z" stroke="white" stroke-width="1.25" stroke-linecap="round"/>
											</svg>
										</span>
									</button>
								</div>
							</div>
							<div class="tab-pane fade" id="v-pills-UbahKataKunci" role="tabpanel" aria-labelledby="v-pills-UbahKataKunci-tab" tabindex="0">
								<div class="p-30px-30px-20px-30px">
									<div id="confirmation-password-failed" class="error-text-wrapper text-center display-none"></div>
									<div class="alert-agency display-none">
										<span class="agency-font-semibold"></span>
									</div>
									<h3 class="text-32px mt-20px">Ubah Kata Sandi</h3>
									<div class="change-password-wrapper">
										<div class="col-password">
											<div class="position-relative mb-15px">
												<label class="label__agency display-flex gap-12px">
													<span>Kata Sandi Lama</span>
													<div class="agency-tooltip position-relative" id="tooltip-password">
														<span class="tooltip-click agency-pointer">
															<svg class="w-24px-h-24px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
																<path d="M11.9999 11.9999L11.9999 16.7999M11.9999 8.44209V8.3999M2.3999 11.9999C2.3999 6.69797 6.69797 2.3999 11.9999 2.3999C17.3018 2.3999 21.5999 6.69797 21.5999 11.9999C21.5999 17.3018 17.3018 21.5999 11.9999 21.5999C6.69797 21.5999 2.3999 17.3018 2.3999 11.9999Z" stroke="#00008F" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
															</svg>
														</span>
														<div class="tooltip__wrapper tooltip__wrapper--password">
															<div class="bubble">
																<p>Kata sandi terdiri dari 8 karakter, mengunakan huruf kapital, huruf kecil, angka dan simbol.</p>
																<div class="arrow-triangle-right"></div>
															</div>
														</div>
													</div>
												</label>
												<input class="input-control agency-normalcase input-control--outline agency-bg-transparent" type="password" name="profile_old_password" id="profile_old_password" placeholder="Masukkan kata sandi" autocomplete="new-password" required/>
												<span toggle="#profile_old_password" class="toggle-password position-absolute top-50px right-18px agency-pointer">
													<i class="eye-close eye-position">
														<svg class="w-24px-h-24px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
															<path d="M20.3999 19.5L5.3999 4.5M10.1999 10.4416C9.82648 10.8533 9.5999 11.394 9.5999 11.9863C9.5999 13.2761 10.6744 14.3217 11.9999 14.3217C12.611 14.3217 13.1688 14.0994 13.5926 13.7334M20.4387 14.3217C21.2649 13.0848 21.5999 12.0761 21.5999 12.0761C21.5999 12.0761 19.4153 5.1 11.9999 5.1C11.5836 5.1 11.1838 5.12199 10.7999 5.16349M17.3999 17.3494C16.0225 18.2281 14.2492 18.8495 11.9999 18.8127C4.67683 18.693 2.3999 12.0761 2.3999 12.0761C2.3999 12.0761 3.45776 8.69808 6.5999 6.64332" stroke-linecap="round"/>
														</svg>
													</i>
													<i class="eye-open eye-position">
														<svg class="w-24px-h-24px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
															<path fill-rule="evenodd" clip-rule="evenodd" d="M3.47139 12.103C3.53662 11.9408 3.63002 11.724 3.75499 11.4692C4.04899 10.8696 4.51161 10.0711 5.18309 9.27615C6.51416 7.70025 8.65372 6.14282 11.9999 6.14282C15.3461 6.14282 17.4856 7.70025 18.8167 9.27615C19.4882 10.0711 19.9508 10.8696 20.2448 11.4692C20.3715 11.7276 20.4657 11.9467 20.5311 12.1096C20.4639 12.2689 20.3678 12.4821 20.2394 12.7329C19.9391 13.32 19.469 14.1005 18.793 14.8742C17.453 16.4078 15.3163 17.9097 12.0163 17.8557C8.69468 17.8014 6.54376 16.2875 5.20096 14.7778C4.52406 14.0167 4.05425 13.2568 3.75477 12.6885C3.63137 12.4543 3.53783 12.2545 3.47139 12.103ZM21.5999 12.119C22.5542 11.8201 22.5541 11.8196 22.5539 11.8191L22.5535 11.818L22.5527 11.8152L22.5503 11.8077L22.543 11.7853C22.5369 11.7671 22.5286 11.7423 22.5178 11.7114C22.4963 11.6498 22.4651 11.5637 22.4235 11.4566C22.3403 11.2427 22.2148 10.944 22.0406 10.5887C21.6932 9.88026 21.1462 8.93467 20.3446 7.98562C18.7295 6.07346 16.0691 4.14282 11.9999 4.14282C7.9307 4.14282 5.27026 6.07346 3.65518 7.98562C2.85358 8.93467 2.30659 9.88026 1.95924 10.5887C1.78504 10.944 1.65955 11.2427 1.57631 11.4566C1.53466 11.5637 1.50347 11.6498 1.48197 11.7114C1.47122 11.7423 1.46288 11.7671 1.45685 11.7853L1.44953 11.8077L1.44715 11.8152L1.44627 11.818L1.44591 11.8191C1.44575 11.8196 1.4456 11.8201 2.3999 12.119L1.4456 11.8201L1.34741 12.1337L1.45432 12.4443L2.3999 12.119C1.45432 12.4443 1.45449 12.4448 1.45466 12.4453L1.45505 12.4465L1.45601 12.4492L1.45856 12.4565L1.46633 12.4782C1.47269 12.4958 1.48146 12.5196 1.49272 12.5491C1.51522 12.6082 1.54772 12.6905 1.59092 12.7928C1.67726 12.9971 1.8068 13.282 1.98542 13.6209C2.34171 14.297 2.89883 15.1988 3.70654 16.1069C5.33297 17.9356 7.98204 19.79 11.9836 19.8554C16.0066 19.9212 18.6699 18.0547 20.2991 16.1901C21.1077 15.2647 21.6645 14.3386 22.02 13.6438C22.1982 13.2954 22.3274 13.002 22.4134 12.7918C22.4564 12.6866 22.4887 12.6019 22.511 12.5412C22.5222 12.5108 22.5309 12.4865 22.5372 12.4685L22.5448 12.4463L22.5473 12.439L22.5482 12.4362L22.5486 12.4351C22.5488 12.4346 22.5489 12.4341 21.5999 12.119ZM21.5999 12.119L22.5489 12.4341L22.6506 12.128L22.5542 11.8201L21.5999 12.119ZM11.9999 10.6938C11.2008 10.6938 10.5999 11.3172 10.5999 12.0291C10.5999 12.7411 11.2008 13.3645 11.9999 13.3645C12.799 13.3645 13.3999 12.7411 13.3999 12.0291C13.3999 11.3172 12.799 10.6938 11.9999 10.6938ZM20.6463 12.42C20.6465 12.4205 20.6465 12.4205 20.6463 12.4202L20.6463 12.42ZM8.5999 12.0291C8.5999 10.1615 10.148 8.69377 11.9999 8.69377C13.8518 8.69377 15.3999 10.1615 15.3999 12.0291C15.3999 13.8968 13.8518 15.3645 11.9999 15.3645C10.148 15.3645 8.5999 13.8968 8.5999 12.0291Z" />
														</svg>
													</i>
												</span>
											</div>
										</div>
									</div>
									<div class="change-password-wrapper">
										<div class="col-password">
											<div class="position-relative mb-15px">
												<label class="label__agency display-flex gap-12px">
													<span>Kata Sandi Baru</span>
													<div class="agency-tooltip position-relative" id="tooltip-new-password">
														<span class="tooltip-click-new-password agency-pointer">
															<svg class="w-24px-h-24px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
																<path d="M11.9999 11.9999L11.9999 16.7999M11.9999 8.44209V8.3999M2.3999 11.9999C2.3999 6.69797 6.69797 2.3999 11.9999 2.3999C17.3018 2.3999 21.5999 6.69797 21.5999 11.9999C21.5999 17.3018 17.3018 21.5999 11.9999 21.5999C6.69797 21.5999 2.3999 17.3018 2.3999 11.9999Z" stroke="#00008F" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
															</svg>
														</span>
														<div class="tooltip__wrapper tooltip__wrapper--new-password">
															<div class="bubble">
																<p class="agency-font-normal agency-text-grey-500">Kata sandi terdiri dari 8 karakter, mengunakan huruf kapital, huruf kecil, angka dan simbol.</p>
																<div class="arrow-triangle-right"></div>
															</div>
														</div>
													</div>
												</label>
												<input class="input-control agency-normalcase input-control--outline agency-bg-transparent" type="password" name="change_profile_new_password" id="change_profile_new_password" placeholder="Masukkan kata sandi" autocomplete="new-password" required>
												<span toggle="#change_profile_new_password" class="toggle-password position-absolute top-50px right-18px agency-pointer">
													<i class="eye-close eye-position">
														<svg class="w-24px-h-24px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
															<path d="M20.3999 19.5L5.3999 4.5M10.1999 10.4416C9.82648 10.8533 9.5999 11.394 9.5999 11.9863C9.5999 13.2761 10.6744 14.3217 11.9999 14.3217C12.611 14.3217 13.1688 14.0994 13.5926 13.7334M20.4387 14.3217C21.2649 13.0848 21.5999 12.0761 21.5999 12.0761C21.5999 12.0761 19.4153 5.1 11.9999 5.1C11.5836 5.1 11.1838 5.12199 10.7999 5.16349M17.3999 17.3494C16.0225 18.2281 14.2492 18.8495 11.9999 18.8127C4.67683 18.693 2.3999 12.0761 2.3999 12.0761C2.3999 12.0761 3.45776 8.69808 6.5999 6.64332" stroke-linecap="round"/>
														</svg>
													</i>
													<i class="eye-open eye-position">
														<svg class="w-24px-h-24px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
															<path fill-rule="evenodd" clip-rule="evenodd" d="M3.47139 12.103C3.53662 11.9408 3.63002 11.724 3.75499 11.4692C4.04899 10.8696 4.51161 10.0711 5.18309 9.27615C6.51416 7.70025 8.65372 6.14282 11.9999 6.14282C15.3461 6.14282 17.4856 7.70025 18.8167 9.27615C19.4882 10.0711 19.9508 10.8696 20.2448 11.4692C20.3715 11.7276 20.4657 11.9467 20.5311 12.1096C20.4639 12.2689 20.3678 12.4821 20.2394 12.7329C19.9391 13.32 19.469 14.1005 18.793 14.8742C17.453 16.4078 15.3163 17.9097 12.0163 17.8557C8.69468 17.8014 6.54376 16.2875 5.20096 14.7778C4.52406 14.0167 4.05425 13.2568 3.75477 12.6885C3.63137 12.4543 3.53783 12.2545 3.47139 12.103ZM21.5999 12.119C22.5542 11.8201 22.5541 11.8196 22.5539 11.8191L22.5535 11.818L22.5527 11.8152L22.5503 11.8077L22.543 11.7853C22.5369 11.7671 22.5286 11.7423 22.5178 11.7114C22.4963 11.6498 22.4651 11.5637 22.4235 11.4566C22.3403 11.2427 22.2148 10.944 22.0406 10.5887C21.6932 9.88026 21.1462 8.93467 20.3446 7.98562C18.7295 6.07346 16.0691 4.14282 11.9999 4.14282C7.9307 4.14282 5.27026 6.07346 3.65518 7.98562C2.85358 8.93467 2.30659 9.88026 1.95924 10.5887C1.78504 10.944 1.65955 11.2427 1.57631 11.4566C1.53466 11.5637 1.50347 11.6498 1.48197 11.7114C1.47122 11.7423 1.46288 11.7671 1.45685 11.7853L1.44953 11.8077L1.44715 11.8152L1.44627 11.818L1.44591 11.8191C1.44575 11.8196 1.4456 11.8201 2.3999 12.119L1.4456 11.8201L1.34741 12.1337L1.45432 12.4443L2.3999 12.119C1.45432 12.4443 1.45449 12.4448 1.45466 12.4453L1.45505 12.4465L1.45601 12.4492L1.45856 12.4565L1.46633 12.4782C1.47269 12.4958 1.48146 12.5196 1.49272 12.5491C1.51522 12.6082 1.54772 12.6905 1.59092 12.7928C1.67726 12.9971 1.8068 13.282 1.98542 13.6209C2.34171 14.297 2.89883 15.1988 3.70654 16.1069C5.33297 17.9356 7.98204 19.79 11.9836 19.8554C16.0066 19.9212 18.6699 18.0547 20.2991 16.1901C21.1077 15.2647 21.6645 14.3386 22.02 13.6438C22.1982 13.2954 22.3274 13.002 22.4134 12.7918C22.4564 12.6866 22.4887 12.6019 22.511 12.5412C22.5222 12.5108 22.5309 12.4865 22.5372 12.4685L22.5448 12.4463L22.5473 12.439L22.5482 12.4362L22.5486 12.4351C22.5488 12.4346 22.5489 12.4341 21.5999 12.119ZM21.5999 12.119L22.5489 12.4341L22.6506 12.128L22.5542 11.8201L21.5999 12.119ZM11.9999 10.6938C11.2008 10.6938 10.5999 11.3172 10.5999 12.0291C10.5999 12.7411 11.2008 13.3645 11.9999 13.3645C12.799 13.3645 13.3999 12.7411 13.3999 12.0291C13.3999 11.3172 12.799 10.6938 11.9999 10.6938ZM20.6463 12.42C20.6465 12.4205 20.6465 12.4205 20.6463 12.4202L20.6463 12.42ZM8.5999 12.0291C8.5999 10.1615 10.148 8.69377 11.9999 8.69377C13.8518 8.69377 15.3999 10.1615 15.3999 12.0291C15.3999 13.8968 13.8518 15.3645 11.9999 15.3645C10.148 15.3645 8.5999 13.8968 8.5999 12.0291Z" />
														</svg>
													</i>
												</span>
											</div>
										</div>
										<div class="col-password">
											<div class="position-relative mb-15px">
												<label class="label__agency display-flex gap-12px">
													<span>Konfirmasi Kata Sandi Baru</span>
													<div class="agency-tooltip position-relative" id="tooltip-confirmation-new-password">
														<span class="tooltip-click-confirmation-new-password agency-pointer">
															<svg class="w-24px-h-24px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
																<path d="M11.9999 11.9999L11.9999 16.7999M11.9999 8.44209V8.3999M2.3999 11.9999C2.3999 6.69797 6.69797 2.3999 11.9999 2.3999C17.3018 2.3999 21.5999 6.69797 21.5999 11.9999C21.5999 17.3018 17.3018 21.5999 11.9999 21.5999C6.69797 21.5999 2.3999 17.3018 2.3999 11.9999Z" stroke="#00008F" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
															</svg>
														</span>
														<div class="tooltip__wrapper tooltip__wrapper--confirmation-new-password">
															<div class="bubble">
																<p>Kata sandi terdiri dari 8 karakter, mengunakan huruf kapital, huruf kecil, angka dan simbol.</p>
																<div class="arrow-triangle-right"></div>
															</div>
														</div>
													</div>
												</label>
												<input class="input-control agency-normalcase input-control--outline agency-bg-transparent" type="password" name="change_profile_password_confirmation" id="change_profile_password_confirmation" placeholder="Konfirmasi kata sandi baru" autocomplete="new-password" required>
												<span toggle="#change_profile_password_confirmation" class="toggle-password position-absolute top-50px right-18px agency-pointer">
													<i class="eye-close eye-position">
														<svg class="w-24px-h-24px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
															<path d="M20.3999 19.5L5.3999 4.5M10.1999 10.4416C9.82648 10.8533 9.5999 11.394 9.5999 11.9863C9.5999 13.2761 10.6744 14.3217 11.9999 14.3217C12.611 14.3217 13.1688 14.0994 13.5926 13.7334M20.4387 14.3217C21.2649 13.0848 21.5999 12.0761 21.5999 12.0761C21.5999 12.0761 19.4153 5.1 11.9999 5.1C11.5836 5.1 11.1838 5.12199 10.7999 5.16349M17.3999 17.3494C16.0225 18.2281 14.2492 18.8495 11.9999 18.8127C4.67683 18.693 2.3999 12.0761 2.3999 12.0761C2.3999 12.0761 3.45776 8.69808 6.5999 6.64332" stroke-linecap="round"/>
														</svg>
													</i>
													<i class="eye-open eye-position">
														<svg class="w-24px-h-24px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
															<path fill-rule="evenodd" clip-rule="evenodd" d="M3.47139 12.103C3.53662 11.9408 3.63002 11.724 3.75499 11.4692C4.04899 10.8696 4.51161 10.0711 5.18309 9.27615C6.51416 7.70025 8.65372 6.14282 11.9999 6.14282C15.3461 6.14282 17.4856 7.70025 18.8167 9.27615C19.4882 10.0711 19.9508 10.8696 20.2448 11.4692C20.3715 11.7276 20.4657 11.9467 20.5311 12.1096C20.4639 12.2689 20.3678 12.4821 20.2394 12.7329C19.9391 13.32 19.469 14.1005 18.793 14.8742C17.453 16.4078 15.3163 17.9097 12.0163 17.8557C8.69468 17.8014 6.54376 16.2875 5.20096 14.7778C4.52406 14.0167 4.05425 13.2568 3.75477 12.6885C3.63137 12.4543 3.53783 12.2545 3.47139 12.103ZM21.5999 12.119C22.5542 11.8201 22.5541 11.8196 22.5539 11.8191L22.5535 11.818L22.5527 11.8152L22.5503 11.8077L22.543 11.7853C22.5369 11.7671 22.5286 11.7423 22.5178 11.7114C22.4963 11.6498 22.4651 11.5637 22.4235 11.4566C22.3403 11.2427 22.2148 10.944 22.0406 10.5887C21.6932 9.88026 21.1462 8.93467 20.3446 7.98562C18.7295 6.07346 16.0691 4.14282 11.9999 4.14282C7.9307 4.14282 5.27026 6.07346 3.65518 7.98562C2.85358 8.93467 2.30659 9.88026 1.95924 10.5887C1.78504 10.944 1.65955 11.2427 1.57631 11.4566C1.53466 11.5637 1.50347 11.6498 1.48197 11.7114C1.47122 11.7423 1.46288 11.7671 1.45685 11.7853L1.44953 11.8077L1.44715 11.8152L1.44627 11.818L1.44591 11.8191C1.44575 11.8196 1.4456 11.8201 2.3999 12.119L1.4456 11.8201L1.34741 12.1337L1.45432 12.4443L2.3999 12.119C1.45432 12.4443 1.45449 12.4448 1.45466 12.4453L1.45505 12.4465L1.45601 12.4492L1.45856 12.4565L1.46633 12.4782C1.47269 12.4958 1.48146 12.5196 1.49272 12.5491C1.51522 12.6082 1.54772 12.6905 1.59092 12.7928C1.67726 12.9971 1.8068 13.282 1.98542 13.6209C2.34171 14.297 2.89883 15.1988 3.70654 16.1069C5.33297 17.9356 7.98204 19.79 11.9836 19.8554C16.0066 19.9212 18.6699 18.0547 20.2991 16.1901C21.1077 15.2647 21.6645 14.3386 22.02 13.6438C22.1982 13.2954 22.3274 13.002 22.4134 12.7918C22.4564 12.6866 22.4887 12.6019 22.511 12.5412C22.5222 12.5108 22.5309 12.4865 22.5372 12.4685L22.5448 12.4463L22.5473 12.439L22.5482 12.4362L22.5486 12.4351C22.5488 12.4346 22.5489 12.4341 21.5999 12.119ZM21.5999 12.119L22.5489 12.4341L22.6506 12.128L22.5542 11.8201L21.5999 12.119ZM11.9999 10.6938C11.2008 10.6938 10.5999 11.3172 10.5999 12.0291C10.5999 12.7411 11.2008 13.3645 11.9999 13.3645C12.799 13.3645 13.3999 12.7411 13.3999 12.0291C13.3999 11.3172 12.799 10.6938 11.9999 10.6938ZM20.6463 12.42C20.6465 12.4205 20.6465 12.4205 20.6463 12.4202L20.6463 12.42ZM8.5999 12.0291C8.5999 10.1615 10.148 8.69377 11.9999 8.69377C13.8518 8.69377 15.3999 10.1615 15.3999 12.0291C15.3999 13.8968 13.8518 15.3645 11.9999 15.3645C10.148 15.3645 8.5999 13.8968 8.5999 12.0291Z" />
														</svg>
													</i>
												</span>
											</div>
										</div>
									</div>
								</div>
								<div class="change-password-wrapper-bottom p-20px-30px">
									<button type="button" class="btn__agency btn-save-password btn--disabled p-12px-30px-10px-30px disabled" disabled onclick="saveChange()">
										<span class="position-relative order-10 display-flex">
											<span class="mr-8px">Simpan Kata Sandi</span>
											<svg class="agency-self-baseline" xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 16 16" fill="none">
												<path d="M4.39998 13.5996V9.99961C4.39998 9.55778 4.75815 9.19961 5.19998 9.19961H10.8C11.2418 9.19961 11.6 9.55778 11.6 9.99961V13.9996M11.6 2.39961V3.99961C11.6 4.44144 11.2418 4.79961 10.8 4.79961L5.19998 4.79961C4.75815 4.79961 4.39998 4.44144 4.39998 3.99961L4.39998 1.59961M13.9983 4.39792L11.6017 2.0013C11.3445 1.7441 10.9956 1.59961 10.6319 1.59961H2.9714C2.21398 1.59961 1.59998 2.21361 1.59998 2.97104V13.0282C1.59998 13.7856 2.21398 14.3996 2.9714 14.3996H13.0285C13.786 14.3996 14.4 13.7856 14.4 13.0282V5.36767C14.4 5.00394 14.2555 4.65511 13.9983 4.39792Z" stroke="white" stroke-width="1.25" stroke-linecap="round"/>
											</svg>
										</span>
									</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<liferay-util:html-bottom outputKey="htmlbottom">
	<script>
		window.host = "<%= host %>";
		window.loadAgentPageDataURL = "<%= loadAgentPageData %>";
		window.rToken = "<%= renderToken %>";
		window.apToken = "<%= apiRequestToken %>";
		window.eToken = "<%= encodeToken %>";
	</script>
	<script src="/o/agency-theme/js/multiform/multiform.js" type="text/javascript"></script>
	<script async src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCL7Yp7lsc-31-A9mpmvbI8sCDy2PF4y2k&libraries=places&sensor=true&callback=initMap"></script>
	<script src="<%= request.getContextPath() %>/pages/js/edit.js" type="text/javascript"></script>
</liferay-util:html-bottom>