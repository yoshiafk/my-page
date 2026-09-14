<%@page import="java.util.ArrayList"%>
<%@page
	import="com.mypage.user.service.MypageUserTimelineLocalServiceUtil"%>
<%@page import="com.mypage.user.model.MypageUserTimeline"%>
<%@page
	import="com.mypage.user.service.MypageUserWorkingHourLocalServiceUtil"%>
<%@page import="com.mypage.user.model.MypageUserWorkingHour"%>
<%@page import="java.util.List"%>
<%@page import="com.mypage.user.model.MypageUser"%>
<%@page import="com.mypage.admin.product.model.MasterGlobalVariable"%>
<%@page import="com.mypage.agencyportal.dto.APIResponse"%>
<%@page import="com.mypage.agencyportal.dto.DataItemProductDto"%>
<%@ include file="../init.jsp"%>

<%@ page language="java"%>

<%
	MypageUser myPageUser = (MypageUser) renderRequest.getAttribute("myPageUser");
	APIResponse<DataItemProductDto> _products = (APIResponse<DataItemProductDto>) renderRequest.getAttribute("products");
	List<MasterGlobalVariable> _iconProducts = (ArrayList<MasterGlobalVariable>) renderRequest.getAttribute("iconProducts");
	String pageType = (String) renderRequest.getAttribute("pageType");
	
	ActionHelpers helpers = new ActionHelpers();
	String host = helpers.getConfig("com.mypage.agent.config.pimcoreHost");

	String renderToken = !Validator.isNull((String) renderRequest.getAttribute("renderToken")) ? (String) renderRequest.getAttribute("renderToken") : "";
	String apiRequestToken = !Validator.isNull((String) renderRequest.getAttribute("apiRequestToken")) ? (String) renderRequest.getAttribute("apiRequestToken") : "";
%>

<portlet:resourceURL id="/data/agentprofile" var="loadAgentProfileData" />
<fmt:formatDate value="<%= myPageUser.getJoinDate() %>" pattern="d MMM yyyy" var="formattedDate" />

<div class="profile">
    <div class="profile__hero">
        <div class="profile__hero-banner">
            <% Long imageEntryId=Validator.isNull(myPageUser.getBannerImageFileEntryId()) ? 0 :
                myPageUser.getBannerImageFileEntryId(); FileEntry image=null; %>
                <c:if test="<%=imageEntryId > 0%>">
                    <% image=DLAppLocalServiceUtil.getFileEntry(imageEntryId); String imageUrl="/documents/" +
                        image.getGroupId() + "/" + image.getFolderId() + "/" + image.getFileName(); %>
                        <liferay-adaptive-media:img class="placeholder-img"
                            fileVersion="<%= image.getFileVersion() %>" />

                </c:if>
                <c:if test="<%=imageEntryId == 0%>">
                    <img src="/o/agency-theme/images/banner_profile_default.jpg" alt="Images">
                </c:if>
        </div>
        <div class="profile__hero-img">
            <div class="container-axa">
                <div class="profile__hero-img-inner">
                    <% imageEntryId=Validator.isNull(myPageUser.getProfileImageFileEntryId()) ? 0 :
                        myPageUser.getProfileImageFileEntryId(); %>
                        <c:if test="<%=imageEntryId > 0%>">
                            <% image=DLAppLocalServiceUtil.getFileEntry(imageEntryId); String imageUrl="/documents/" +
                                image.getGroupId() + "/" + image.getFolderId() + "/" + image.getFileName(); %>
                                <liferay-adaptive-media:img class="placeholder-img"
                                    fileVersion="<%=image.getFileVersion()%>"
                                    style="border-radius: 50%; width: 115px; height: 115px;" />
                        </c:if>
                        <c:if test="<%=imageEntryId == 0%>">
                            <img src="/o/agency-theme/images/placeholder-profile.png" alt="Images" loading="lazy" />
                        </c:if>
                        <span>
                            <%=myPageUser.getUserName()%>
                        </span>
                </div>
            </div>
        </div>
    </div>
    <div class="container-axa">
        <div class="profile-timeline-wrapper">
            <div class="profile__left">
                <div class="profile-biodata">
                    <h3 class="mb-16px">Biodata</h3>
                    <ul>
                    	<c:if test="<%= Validator.isNotNull(myPageUser.getJoinDate()) %>">
	                        <li class="display-grid"><span>Tanggal Bergabung</span>
	                            <strong>${formattedDate.toUpperCase()}</strong>
	                        </li>
	                    </c:if>
	                    <c:if test="<%= Validator.isNotNull(myPageUser.getGender()) %>">
	                        <li class="display-grid"><span>Jenis Kelamin</span> <strong>
	                                <%=myPageUser.getGender().equalsIgnoreCase("F") ? "Perempuan" : "Laki-laki" %>
	                            </strong>
	                        </li>
	                    </c:if>
	                    <c:if test="<%= Validator.isNotNull(myPageUser.getMobilePhone()) %>">
	                        <li class="display-grid"><span>Telepon</span> <strong><a
	                                    href="tel:<%=myPageUser.getMobilePhone()%>">
	                                    <%=myPageUser.getMobilePhone()%>
	                                </a></strong>
	                        </li>
	                    </c:if>
	                    <c:if test="<%= Validator.isNotNull(myPageUser.getEmail()) %>">
	                        <li class="display-grid"><span>Email</span> <strong><a href="mailto:<%=myPageUser.getEmail()%>">
	                                    <%=myPageUser.getEmail()%>
	                                </a></strong>
	                        </li>
	                    </c:if>
	                    <c:if test="<%= Validator.isNotNull(myPageUser.getAddress()) %>">
	                        <li class="display-grid"><span>Alamat</span> <strong>
	                                <%=myPageUser.getAddress()%>
	                            </strong>
	                        </li>
	                    </c:if>
                    </ul>
                </div>
                <div class="profile-operational-hour">
                    <h3 class="text-32px mb-16px">Jam Operasional</h3>

                    <ul>

                        <% List<MypageUserWorkingHour> agentWorkingHours = MypageUserWorkingHourLocalServiceUtil
                            .getByMypageUserId(myPageUser.getMypageUserId());

                            if (agentWorkingHours.size() == 0) {
                            %>

                            <li class="display-grid"><strong>24 Jam</strong></li>

                            <% } else { for (int i=0; i < agentWorkingHours.size(); i++) { MypageUserWorkingHour
                                workingHour=agentWorkingHours.get(i); %>

                                <li class="display-grid"><strong>
                                        <%=workingHour.getDay()%>
                                    </strong>
                                    <span>
                                        <%=workingHour.getStartTime()%> - <%=workingHour.getEndTime()%>
                                    </span>
                                </li>

                                <% } } %>

                    </ul>

                </div>
                <div class="profile-social-media">
                    <h3 class="text-32px mb-16px">Sosial Media</h3>
                    <ul>
                    	<c:if test="<%= Validator.isNotNull(myPageUser.getFacebook()) %>">
                        	<li><a href="<%=myPageUser.getFacebook()%>" class="link-socmed"><i class="fab fa-facebook-f"></i></a></li>
                        </c:if>
                        <c:if test="<%= Validator.isNotNull(myPageUser.getTwitter()) %>">
	                        <li><a href="<%=myPageUser.getTwitter()%>" class="link-socmed"> <svg class="twitter-x"
	                                    xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
	                                    width="19" height="18" viewBox="0 0 19 18" fill="none">
	                                    <mask id="mask0_1485_21700" style="mask-type:alpha" maskUnits="userSpaceOnUse" x="0"
	                                        y="0" width="19" height="18">
	                                        <rect x="0.458984" y="0.556641" width="18.5409" height="17.3667"
	                                            fill="url(#pattern0)" />
	                                    </mask>
	                                    <g mask="url(#mask0_1485_21700)">
	                                        <rect x="0.458984" y="0.556641" width="18.5409" height="17.3667" />
	                                    </g>
	                                    <defs>
	                                        <pattern id="pattern0" patternContentUnits="objectBoundingBox" width="1"
	                                            height="1">
	                                            <use xlink:href="#image0_1485_21700"
	                                                transform="scale(0.00333333 0.00355872)" />
	                                        </pattern>
	                                        <image id="image0_1485_21700" width="300" height="281"
	                                            xlink:href="data:image/png;base64,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" />
	                                    </defs>
	                                </svg>
	                            </a></li>
						</c:if>
						<c:if test="<%= Validator.isNotNull(myPageUser.getTiktok()) %>">
	                        <li><a href="<%=myPageUser.getTiktok()%>" class="link-socmed"> <svg class="tiktok"
	                                    xmlns="http://www.w3.org/2000/svg" width="20" height="23" viewBox="0 0 20 23"
	                                    fill="none">
	                                    <path
	                                        d="M19.5 8.70312C17.7422 8.74219 16.1016 8.19531 14.6953 7.17969V14.1719C14.6953 19.0547 9.38281 22.1016 5.16406 19.6797C0.945312 17.2188 0.945312 11.125 5.16406 8.66406C6.375 7.96094 7.82031 7.6875 9.22656 7.88281V11.3984C7.07812 10.6953 5.00781 12.6094 5.47656 14.7969C5.98438 16.9844 8.64062 17.8438 10.3203 16.3203C10.9062 15.7734 11.2578 14.9922 11.2578 14.1719V0.5H14.6953C14.6953 0.8125 14.6953 1.08594 14.7734 1.39844C15.0078 2.6875 15.75 3.82031 16.8828 4.52344C17.625 5.03125 18.5625 5.30469 19.5 5.30469V8.70312Z" />
	                                </svg>
	                            </a></li>
						</c:if>
						<c:if test="<%= Validator.isNotNull(myPageUser.getInstagram()) %>">
	                        <li><a href="<%=myPageUser.getInstagram()%>" class="link-socmed"> <svg class="w-19px-h-26px instagram"
	                                    xmlns="http://www.w3.org/2000/svg" version="1.2" viewBox="0 0 48 49">
	                                    <path fill-rule="evenodd" class="a"
	                                        d="m46.8 34.2c-0.1 3.7-1 6.9-3.6 9.6-2.7 2.7-5.9 3.5-9.6 3.7-3.1 0.2-6.3 0.1-9.4 0.1-3.2 0-6.3 0.1-9.4-0.1-3.7-0.2-6.9-1-9.6-3.7-2.7-2.7-3.5-5.9-3.7-9.6-0.2-3.1-0.1-6.2-0.1-9.4 0-3.1-0.1-6.3 0.1-9.4 0.2-3.7 1-6.9 3.7-9.6 2.7-2.6 5.9-3.5 9.6-3.6 3.1-0.2 6.2-0.2 9.4-0.2 3.1 0 6.3 0 9.4 0.2 3.7 0.1 6.9 1 9.6 3.6 2.6 2.7 3.5 5.9 3.6 9.6 0.2 3.1 0.2 6.3 0.2 9.4 0 3.2 0 6.3-0.2 9.4zm-10.9-9.4c0-6.5-5.2-11.7-11.7-11.7-6.5 0-11.7 5.2-11.7 11.7 0 6.5 5.2 11.7 11.7 11.7 6.5 0 11.7-5.2 11.7-11.7zm-11.7 7.6c-4.2 0-7.6-3.4-7.6-7.6 0-4.2 3.4-7.6 7.6-7.6 4.2 0 7.6 3.4 7.6 7.6 0 4.2-3.4 7.6-7.6 7.6zm13.2-17.2q0.5-0.3 0.9-0.6 0.4-0.4 0.6-0.9 0.2-0.5 0.2-1.1c0-1.5-1.2-2.7-2.7-2.7-1.5 0-2.8 1.2-2.8 2.7 0 1.5 1.3 2.8 2.8 2.8q0.5 0 1-0.2z">
	                                    </path>
	                                </svg>
	                            </a></li>
                        </c:if>
                        <c:if test="<%= Validator.isNotNull(myPageUser.getLinkedIn()) %>">
                        	<li><a href="<%=myPageUser.getLinkedIn()%>" class="link-socmed"><i class="fab fa-linkedin-in"></i></a></li>
                        </c:if>
                        <c:if test="<%= Validator.isNotNull(myPageUser.getPrettyUrl()) && pageType.equalsIgnoreCase("pv") %>">
	                        <li>
								<a href="javasccript:void(0)" data-bs-toggle="modal" data-bs-target="#ModalReferral">
									<svg class="link-referral" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
										<mask id="mask0_3330_20252" style="mask-type:alpha" maskUnits="userSpaceOnUse" x="0" y="0" width="24" height="24">
	                                    	<rect width="24" height="24" fill="#D9D9D9"/>
	                                    </mask>
	                                    <g mask="url(#mask0_3330_20252)">
		                                    <path d="M10 20.3564L2 6.5L22.4545 3.9282L10 20.3564ZM10.2321 16.7583L17.9945 6.5032L5.23205 8.09808L6.98205 11.1292L12.9282 9.4282L8.48205 13.7272L10.2321 16.7583Z" />
		                                    <path d="M6 17L5 11L13.5 9L6 17Z" />
	                                    </g>
	                                </svg>
	                            </a>
	                        </li>
						</c:if>
                    </ul>
                </div>
                <div class="products-offered">
                    <h3 class="text-32px mb-1">Produk Yang Ditawarkan</h3>
                    <p>Pilih asuransi kebutuhan anda</p>
                    
                    <% if (_products.getData().size() > 0) { %>
	                    <div class="product-offered-lists">
	                        <ul>
	                        	<% for(int i = 0 ; i <= Math.min(5, (_products.getData().size() - 1)); i++) {
	                        		imageEntryId = 0L;
	                        		
	                        		/* for (MasterGlobalVariable item : _iconProducts) {
	                        			if (_products.getData().get(i).getCode().equalsIgnoreCase(item.getName())) {
	                        				imageEntryId = item.getImageFileEntryId();
	                        				continue;
	                        			}
	                        		} */
	                        	%>
									<li>
										<a href="<%= _products.getData().get(i).getUrl() %>" class="link-product">
											<span class="insurance-img-wrapper">
												<c:choose>
												    <c:when test="<%= imageEntryId > 0  %>">
												        <%
							                        		image = DLAppLocalServiceUtil.getFileEntry(imageEntryId);
							                        		String imageUrl = "/documents/" + image.getGroupId() + "/" + image.getFolderId() + "/" + image.getFileName();
														%>
			                                        	<liferay-adaptive-media:img class="placeholder-img img-normal" fileVersion="<%= image.getFileVersion() %>" />
												    </c:when>    
												    <c:otherwise>
												        <img class="img-normal" src="<%= _products.getData().get(i).getIconImage() %>">
												    </c:otherwise>
												</c:choose>
		                                    </span>
		                                    <span class="text-product"><%= _products.getData().get(i).getName() %></span>
	                                    </a>
									</li>
								<%  } %>
	                        </ul>
	                        <% if (_products.getData().size() > 5) { %>
		                        <ul id="see-all" style="display: none;">
		                            <% for(int i = 6 ; i < _products.getData().size(); i++) {
		                            	imageEntryId = 0L;
		                        		
		                        		/* for (MasterGlobalVariable item : _iconProducts) {
		                        			if (_products.getData().get(i).getCode().equalsIgnoreCase(item.getName())) {
		                        				imageEntryId = item.getImageFileEntryId();
		                        				continue;
		                        			}
		                        		} */
		                            %>
										<li>
											<a href="<%= _products.getData().get(i).getUrl() %>" class="link-product">
												<span class="insurance-img-wrapper">
													<c:choose>
													    <c:when test="<%= imageEntryId > 0  %>">
													        <%
								                        		image = DLAppLocalServiceUtil.getFileEntry(imageEntryId);
								                        		String imageUrl = "/documents/" + image.getGroupId() + "/" + image.getFolderId() + "/" + image.getFileName();
															%>
				                                        	<liferay-adaptive-media:img class="placeholder-img img-normal" fileVersion="<%= image.getFileVersion() %>" />
													    </c:when>    
													    <c:otherwise>
													        <img class="img-normal" src="<%= _products.getData().get(i).getIconImage() %>">
													    </c:otherwise>
													</c:choose>
												</span>
												<span class="text-product"><%= _products.getData().get(i).getName() %></span>
											</a>
										</li>
									<% } %>
		                        </ul>
							<% } %>
	                    </div>
	
						<% if (_products.getData().size() > 5) { %>
		                    <button id="toggle-list-details" class="btn__agency btn--dark-blue width-full">
		                        <span class="position-relative order-10 text mr-8px"> Lihat
		                            Semua </span> <i class="position-relative order-10 fas fa-arrow-down"></i>
		                    </button>
						<% } %>
	            	<% } %>
                </div>
                <div class="profile-location">
                    <div class="profile-location-top">
                        <div class="profile-location__left">
                            <h3 class="text-32px mb-4px">Lokasi</h3>
                            <p>Anda dapat menemukan saya disini</p>
                        </div>
                        <div class="profile-location__right agency-self-center">
                            <a href="https://www.google.com/maps/?q=<%= myPageUser.getLatitude() %>,<%= myPageUser.getLongitude() %>" class="agency-uppercase link-location">Arahkan ke lokasi <i
                                    class="fas fa-arrow-right ml-8px"></i></a>
                        </div>
                    </div>
                    <div class="profile-map-location">
                        <div id="map_canvas" class="width-full h-350px"></div>
                    </div>
                </div>
            </div>
            <div class="profile__right">
                <h1 class="mb-16px"><% if (pageType.equalsIgnoreCase("pv")) { %>Lini Masa<% } else { %>Riwayat Lini Masa<% } %></h1>
                <div class="profile-timeline-history">
                	<c:if test="<%= pageType.equalsIgnoreCase("pv") %>">
	                    <div class="profile-status">
	                        <form action="" class="pt-25px" id="Mystatus">
	                            <div class="mb-15px p-0px-25px-0px-25px">
	                                <label class="label__agency" for="status">Status</label>
	                                <textarea class="input-control input-status" id="status" rows="3"
	                                    placeholder="Tulis status anda" name="status" required></textarea>
	                            </div>
	                            <div id="link_video-wrapper" class="mb-24px p-0px-25px-0px-25px" style="display: none;">
	                                <label class="label__agency" for="link_video">Tautan
	                                    Video</label> <input
	                                    class="input-control agency-normalcase input-control--outline bg-transparent input-link"
	                                    name="link_video" id="link_video" type="text" autocomplete="off"
	                                    placeholder="Tulisan tautan video">
	                            </div>
	                            <div class="change-upload-timeline">
	                                <div class="preview-zone preview-zone-upload-timeline display-none">
	                                    <div class="box box-upload-timeline box-solid">
	                                        <div class="box-body box-body-upload-timeline"></div>
	                                        <div class="box-header">
	                                            <div class="box-tools">
	                                                <button type="button" id="cancel-upload"
	                                                    class="btn__agency btn--dark-blue remove-preview remove-preview-upload-timeline display-block width-full agency-text-center">
	                                                    <span class="position-relative order-10 display-block">Hapus</span>
	                                                </button>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
	                                <div class="btn-status p-25px-25px-25px-25px">
	                                    <div class="col display-flex">
	                                        <div class="agency-self-center">
	                                            <div class="dropzone-wrapper dropzone-upload-timeline-wrapper mr-24px">
	                                                <div class="dropzone-desc dropzone-upload-timeline-desc">
	                                                    <span class="choose-file"> <svg class="svg-hover" width="27"
	                                                            height="21" viewBox="0 0 27 21" fill="none"
	                                                            xmlns="http://www.w3.org/2000/svg">
	                                                            <path
	                                                                d="M24.4687 21L2.53124 21C1.10742 21 -5.40143e-06 19.8926 -5.15248e-06 18.4688L-2.49701e-06 3.28125C-2.25728e-06 1.91016 1.10742 0.75 2.53125 0.75L24.4687 0.750004C25.8398 0.750005 27 1.91016 27 3.28125L27 18.4688C27 19.8926 25.8398 21 24.4687 21ZM5.90625 3.70313C4.27148 3.70313 2.95312 5.07422 2.95312 6.65625C2.95312 8.29102 4.27148 9.60938 5.90625 9.60938C7.48828 9.60938 8.85937 8.29102 8.85937 6.65625C8.85937 5.07422 7.48828 3.70313 5.90625 3.70313ZM3.37499 17.625L23.625 17.625L23.625 11.7188L18.9844 7.13086C18.7207 6.86719 18.3516 6.86719 18.0879 7.13086L10.9687 14.25L8.01562 11.3496C7.75195 11.0859 7.38281 11.0859 7.11914 11.3496L3.375 15.0938L3.37499 17.625Z" />
	                                                        </svg>
	                                                    </span>
	                                                </div>
	                                                <input type="file" id="input-file-upload" name="img-upload-timeline"
	                                                    class="dropzone dropzone-upload-timeline"
	                                                    accept="image/gif, image/jpeg, image/png">
	                                            </div>
	                                        </div>
	                                        <span class="agency-self-center"> <a id="toggle-video"
	                                                href="javascript:void(0)"> <svg width="37" height="37"
	                                                    viewBox="0 0 37 37" fill="none" xmlns="http://www.w3.org/2000/svg">
	                                                    <circle cx="18.5" cy="18.5" r="18.5" fill="#00008F" />
	                                                    <path
	                                                        d="M20.5 12C21.3125 12 22 12.6875 22 13.5L22 22.5313C22 23.3438 21.3125 24 20.5 24L11.4687 24C10.6562 24 10 23.3438 10 22.5312L10 13.5C10 12.6875 10.6562 12 11.4687 12L20.5 12ZM26.4062 13.1875C27.0625 12.75 28 13.2188 28 14L28 22.0313C28 22.8125 27.0625 23.2813 26.4062 22.8438L23 20.4688L23 15.5625L26.4062 13.1875Z"
	                                                        fill="white" />
	                                                </svg> <svg class="m-x-auto" xmlns="http://www.w3.org/2000/svg"
	                                                    width="23" height="15" viewBox="0 0 23 15" fill="none">
	                                                    <path
	                                                        d="M13.125 2.29485e-06C14.1406 2.47243e-06 15 0.859378 15 1.875L15 13.1641C15 14.1797 14.1406 15 13.125 15L1.83593 15C0.820308 15 -4.05287e-06 14.1797 -3.87529e-06 13.1641L-1.90145e-06 1.875C-1.72387e-06 0.859375 0.820311 1.43428e-07 1.83594 3.21006e-07L13.125 2.29485e-06ZM20.5078 1.48438C21.3281 0.937504 22.5 1.52344 22.5 2.5L22.5 12.5391C22.5 13.5156 21.3281 14.1016 20.5078 13.5547L16.25 10.5859L16.25 4.45313L20.5078 1.48438Z" />
	                                                </svg>
	                                            </a>
	                                        </span>
	                                    </div>
	                                    <div class="col">
	                                        <button id="btndis" class="btn__agency btn-create-status btn--disabled"
	                                            type="button" onclick="saveTimeline()" disabled>
	                                            <span class="position-relative order-10"> <span
	                                                    class="display-inline-block">Buat</span> <svg
	                                                    class="display-inline-block ml-4px"
	                                                    xmlns="http://www.w3.org/2000/svg" width="17" height="16"
	                                                    viewBox="0 0 17 16" fill="none">
	                                                    <path
	                                                        d="M9.70001 13.0346H13.7M3.30005 13.0346L6.21071 12.4481C6.36522 12.417 6.5071 12.3409 6.61853 12.2294L13.1343 5.71007C13.4467 5.3975 13.4465 4.89084 13.1338 4.57853L11.7536 3.19981C11.441 2.88764 10.9346 2.88785 10.6224 3.20029L4.10589 9.72032C3.99468 9.83159 3.91875 9.97318 3.88758 10.1274L3.30005 13.0346Z"
	                                                        stroke-width="1.5" stroke-linecap="round"
	                                                        stroke-linejoin="round"></path>
	                                                </svg>
	                                            </span>
	                                        </button>
	                                    </div>
	                                </div>
	                            </div>
	                        </form>
	                    </div>
	                </c:if>
					
					<div class="<% if (pageType.equalsIgnoreCase("pv")) { %>timeline<% } else { %>timeline-view<% } %>">
	                    <!-- GET BY loadProfile() render resource -->
	                    <div id="timelineContainer"></div>
	
	                    <div class="agency-text-center mt-32px">
	                        <a href="javascript:void(0)" class="btn__agency btn--dark-blue display-inline-block"
	                            id="loadMore"> <span class="position-relative order-10">Muat
	                                lainnya</span>
	                        </a>
	                    </div>
	                    
	                </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal Referral -->
<div class="modal modal-agency width-full fade" id="ModalReferral" tabindex="-1" style="display: none;" aria-labelledby="ModalReferralLabel" aria-hidden="true">
	<div class="modal-max-w-560px modal-agency-dialog modal-dialog modal-agency-dialog-centered">
		<div class="modal-agency-content">
			<div class="modal-agency-body agency-text-center p-80px-40px-0px-40px position-relative">
				<i class="agency-text-blue-400 text-70px fas fa-gift fa-fw mb-6px"></i>
				<h1 class="agency-heading text-32px mb-15px mt-8px">Bagikan link personal Anda.</h1>
                <div class="input-group">
                    <input class="input-control agency-normalcase input-control--outline agency-bg-transparent disabled" type="text" name="gift" id="gift" value="<%= host.concat("/").concat(myPageUser.getPrettyUrl()) %>" disabled>
                    <button onclick="copyText('gift')" class="btn-group agency-uppercase agency-font-bold agency-text-blue-400 copy-link">Salin tautan</button>
                </div>
               </div>
			<div class="modal-agency-footer display-flex mt-48px">
				<button type="button" class="btn__agency btn--dark-blue btn-close p-12px-25px-10px-25px" type="button" data-bs-dismiss="modal" aria-label="Close">
					<span class="position-relative order-50">
						Keluar
					</span>
				</button>
			</div>
		</div>
	</div>
</div>

<script src="/o/agency-theme/js/dragndrop/dragndrop.js" type="text/javascript"></script>
<script async src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCL7Yp7lsc-31-A9mpmvbI8sCDy2PF4y2k&libraries=places&sensor=true&callback=initMap"></script>
<script src="<%=request.getContextPath()%>/pages/js/view.js" type="text/javascript"></script>

<script>
var html = $("html");
var body = $("body");

html.addClass("html__agency");
body.addClass("body__agency body-white");

var loadAgentProfileDataURL = "<%=loadAgentProfileData%>";
var rToken = "<%= renderToken %>";
var apToken = "<%= apiRequestToken %>";

var responseData;
var batchSize = 5;
var displayedDataCount = 0;

var lat = null,
	lng = null,
	isNull = true;

function initMap() {
	var latlng = new google.maps.LatLng(lat, lng),
		image = '/o/agency-theme/images/pin-axa.png';

	var mapOptions = {
		center: new google.maps.LatLng(lat, lng),
		zoom: 12,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	};

	var map = new google.maps.Map(document.getElementById('map_canvas'),
		mapOptions);

	var marker = new google.maps.Marker({
		position: latlng,
		map: map,
		icon: image
	});
}

$(document).ready(function() {
	$("#loadMore").on("click", function() {
		renderNextBatch();
	});
	loadProfile();
	
	$('.link-location, .link-socmed').on('click', function(e) {
    	e.preventDefault();
        window.open(this.href, '_blank');
    });
});

function renderNextBatch() {	
    var batchLimit = displayedDataCount + batchSize;
    var dataToRender = responseData.slice(displayedDataCount, batchLimit);
    renderTimelineElements(dataToRender);
    displayedDataCount += dataToRender.length;
    
    var lastItem = $('.profile-timeline-history__lists--inner').last();
    if (displayedDataCount < responseData.length) {
        $("#loadMore").show();

        if(displayedDataCount > batchSize){ // > 5, expect first render not focus to loadMore
        	$('html, body').animate({
                scrollTop:  lastItem.offset().top
            }, 1500);
        }
        
    } else {
    	$("#loadMore").hide();
    	
    	if(displayedDataCount > batchSize){ // > 5, expect first render not focus to loadMore
         	$('html, body').animate({
                 scrollTop:  lastItem.offset().top
             }, 1500);
        }
    }
}

function loadProfile() {
	$.ajax({
		url: loadAgentProfileDataURL,
		type: "POST",
		data: {
			dataCategory: "profile",
			rtoken: rToken,
            aptoken: apToken
		},
		timeout: 20000,
		dataType: "json",
		success: function(response) {
			responseData = response.data.timelineUser;
			displayedDataCount = 0;

			if (response.status) {

				timelineContainer.innerHTML = '';
				renderNextBatch();

				// for map location
				if (response.data.agentLocation.latitude) {
					lat = response.data.agentLocation.latitude;
					isNull = false;
				}
				if (response.data.agentLocation.longitude)
					lng = response.data.agentLocation.longitude;

				initMap();
				
				apToken = response.token ? response.token : "";
			}
		}
	});
} 


function renderTimelineElements(data) {
	var timelineContainer = document.getElementById('timelineContainer');

	data
		.forEach(function(timelineEntry, index) {
			// Create main container for each timeline entry
			var timelineEntryContainer = document.createElement('div');
			timelineEntryContainer.className = 'profile-timeline-history__lists--inner';

			// Create and append avatar section
			var avatarSection = document.createElement('div');
			avatarSection.className = 'profile-timeline-history__ava';

			var avatarPhoto = document.createElement('div');
			avatarPhoto.className = 'ava-photo';
			if (!timelineEntry.imgUrlAvatar) {
				avatarPhoto.innerHTML = '<img src="/o/agency-theme/images/placeholder-profile.png" alt="Avatar">';
			} else {
			    avatarPhoto.innerHTML = '<img src="' + timelineEntry.imgUrlAvatar + '" alt="Avatar" style="border-radius: 50%; width: 55px; height: 55px;">';
			}

			var namePostDates = document.createElement('div');
			namePostDates.className = 'name-post-dates';
			var createDate = new Date(timelineEntry.createDate);
			var formattedDate = createDate.getDate() + ' ' +
			    getMonthName(createDate.getMonth()) + ' ' +
			    createDate.getFullYear() + '<i></i>' +
			    createDate.getHours() + ':' +
			    (createDate.getMinutes() < 10 ? '0' : '') + createDate.getMinutes();	

			namePostDates.innerHTML = '<span>' + formattedDate +
				'</span><h4>' + timelineEntry.userName + '</h4>';

			<% if (pageType.equalsIgnoreCase("pv")) { %>
			var timelineDelete = document.createElement('div');
			timelineDelete.className = 'timeline-delete';
			timelineDelete.innerHTML = '<a href="javascript:void(0)" class="display-flex gap-12px"><span class="agency-self-center display-none">Hapus</span><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"><path d="M2.3999 5.40078H21.5999M8.3999 1.80078H15.5999M16.1999 22.2008H7.7999C6.47442 22.2008 5.3999 21.1263 5.3999 19.8008L4.85198 6.65074C4.82358 5.96899 5.3686 5.40078 6.05094 5.40078H17.9489C18.6312 5.40078 19.1762 5.96899 19.1478 6.65074L18.5999 19.8008C18.5999 21.1263 17.5254 22.2008 16.1999 22.2008Z" stroke-width="2" stroke-linecap="round"></svg></a>';
			<% } %>

			avatarSection.appendChild(avatarPhoto);
			avatarSection.appendChild(namePostDates);
			<% if (pageType.equalsIgnoreCase("pv")) { %>
			avatarSection.appendChild(timelineDelete);
			<% } %>

			// Create and append image timeline section
			var timelinePhoto = document.createElement('div');
			if (timelineEntry.imgUrlTimeline) {
				timelinePhoto.innerHTML = '<img src="' + timelineEntry.imgUrlTimeline + '" alt="imge_timeline" style="padding-top: 18px;">';
			}
			
			// Create and append video timeline section	using Plyr				
			/* var timelineVideo = document.createElement('div');
			timelineVideo.className = 'profile-timeline-history__desc';
			if (timelineEntry.videoUrl) {
				console.log('video url exist!!');
				var videoId = getYouTubeVideoId(timelineEntry.videoUrl);
				console.log('video id >> ', videoId)
				
				var plyrVideoEmbed = document.createElement('div');
				plyrVideoEmbed.className = 'plyr__video-embed js-player';
				plyrVideoEmbed.id = 'timelineVideo'+videoId;

				var videoFrame = document.createElement('iframe');
				videoFrame.src = 'https://www.youtube.com/embed/' + videoId + '?origin=https://plyr.io&amp;iv_load_policy=3&amp;modestbranding=1&amp;playsinline=1&amp;showinfo=0&amp;rel=0&amp;enablejsapi=1';
				videoFrame.setAttribute('allowfullscreen', '');
				videoFrame.setAttribute('allowtransparency', '');

				plyrVideoEmbed.appendChild(videoFrame);
				
				timelineVideo.appendChild(plyrVideoEmbed);
				
			} */

			// section video basic
			var timelineVideo = document.createElement('div');
			if (timelineEntry.videoUrl) {
				var videoId = getYouTubeVideoId(timelineEntry.videoUrl);

				var embedUrl = "https://www.youtube.com/embed/" +videoId;
				var videoFrame = document.createElement('iframe');

				videoFrame.width = "100%";
				videoFrame.height = 315;
				videoFrame.src = embedUrl;
				videoFrame.frameBorder = 0;
				videoFrame.allowFullscreen = true;
				videoFrame.style.paddingTop = '20px';

				timelineVideo.appendChild(videoFrame);
			}

			// Create and append description section
			var descSection = document.createElement('div');
			descSection.className = 'profile-timeline-history__desc';
			descSection.innerHTML = '<p>' + timelineEntry.textStatus + '</p>';

			// Append avatar, image, videos and description sections to the main container
			timelineEntryContainer.appendChild(avatarSection);
			timelineEntryContainer.appendChild(timelinePhoto);
			timelineEntryContainer.appendChild(timelineVideo);
			timelineEntryContainer.appendChild(descSection);

			// Append the main container to the timeline container
			timelineContainer.appendChild(timelineEntryContainer);
			
			<% if (pageType.equalsIgnoreCase("pv")) { %>
			var deleteButton = timelineEntryContainer
				.querySelector('.timeline-delete');
			deleteButton.addEventListener('click', function() {
				event.preventDefault();
				deleteTimeline(timelineEntry.timelineId);
			});
			<% } %>
		});

	// Initialize Plyr for new videos , not yet apply
	// Array.from(document.querySelectorAll('.js-player')).map((p) => new Plyr(p));
}

<% if (pageType.equalsIgnoreCase("pv")) { %>
function deleteTimeline(timelineId) {
	
	var elementToDelete = event.target.closest('.profile-timeline-history__lists--inner');
	if (elementToDelete) {
		elementToDelete.remove();
		$.ajax({
			type: "POST",
			url: loadAgentProfileDataURL,
			data: {
				dataCategory: "deleteTimeline",
				timelineId: timelineId,
				rtoken: rToken,
	            aptoken: apToken
			},
			timeout: 20000,
			dataType: "json",
			success: function(response) {	
				apToken = response.token ? response.token : "";
			
				loadProfile();
			},
			error: function(error) {
				console.error("Error:", error);
			}
		});
	}
}
<% } %>

function getYouTubeVideoId(url) {
	var regex = /(?:https?:\/\/)?(?:www\.)?(?:youtube\.com\/(?:[^\/\n\s]+\/\S+\/|(?:v|e(?:mbed)?)\/|\S*?[?&]v=)|youtu\.be\/)([a-zA-Z0-9_-]{11})/;
	var match = url.match(regex);
	return match ? match[1] : null;
}

function getMonthName(monthIndex) {
	var monthNames = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul',
		'Aug', 'Sep', 'Oct', 'Nov', 'Dec'
	];
	return monthNames[monthIndex];
}

<% if (pageType.equalsIgnoreCase("pv")) { %>
function saveTimeline() {
	var fileInput = document.querySelector("#input-file-upload");
	var formData = new FormData();
	var maxFileSize = 5242880; // 5 MB

	if (fileInput.files && fileInput.files.length > 0) {
		if (fileInput.files[0].size > maxFileSize) {
			alert("File size exceeds the maximum limit of " + maxFileSize +
				" bytes.");
			return;
		}
		formData.append('file', fileInput.files[0]);
	}

	formData.append('dataCategory', "timeline");
	formData.append('rtoken', rToken);
	formData.append('aptoken', apToken);
	formData.append('status', $("#status").val());
	formData.append('linkVideo', $("#link_video").val());

	$.ajax({
		type: "POST",
		url: loadAgentProfileDataURL,
		data: formData,
		processData: false,
		contentType: false,
		beforeSend: function() {
			$('#btndis').addClass('btn--disabled').removeClass('btn--dark-blue').prop('disabled', true);
		},
		success: function(response) {
			response = JSON.parse(response);
			
			if (response.status) {
				// After submit set to null
				$("#status").val(null);
				$('#status').addClass('input-status');
	
				$('.preview-zone-upload-timeline').addClass(
					'display-none');
				$('.dropzone-upload-timeline-wrapper').removeClass(
					'display-none');
				$('.dropzone-upload-timeline-desc').removeClass(
					'display-none');
				$('#input-file-upload').val(null);
				$('#toggle-video').removeClass('display-none');
				$('#link_video-wrapper').css('display', 'none');
				$('#link_video').val(null);
				
				apToken = response.token ? response.token : "";
	
				loadProfile();
			}
		},
		error: function(error) {
			console.error("Error:", error);
		}
	});
}
<% } %>

function copyText(elem) {
	let element = document.getElementById(elem);
	let elementText = element.value || element.innerText || element.textContent;;
	let o = document.createElement("textarea");
	
	o.style.position = "fixed";
	o.style.left = "0";
	o.style.top = "0";
	o.style.opacity = "0";
	o.value = elementText;
	
	document.body.appendChild(o);
	o.focus();
	o.select();
	document.execCommand("copy");
	document.body.removeChild(o);
}
</script>
